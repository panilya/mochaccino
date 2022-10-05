import axios from "axios";
import JSONPretty from "react-json-pretty";
import { useEffect, useRef, useState } from "react";
import { Spinner } from "react-bootstrap";
import { useLocation } from "react-router-dom";
import { useGetOptions } from "../../Hooks/useRedux";
import CopyToClipboard from "react-copy-to-clipboard";
import LoadingButton from "../LoadingButton/LoadingButton";

interface PreviewProps {}

const Preview: React.FC<PreviewProps> = () => {
  const [isPreviewLoading, setIsPreviewLoading] = useState(false);
  const [previewData, setPreviewData] = useState();
  const [isCopied, setIsCopied] = useState(false);
  const optionProviders = useGetOptions();
  const ref = useRef<HTMLParagraphElement>(null);
  const { limit, format } = useLocation().state;

  useEffect(() => {
    setTimeout(() => {
      setIsCopied(false);
    }, 3000);
  }, [isCopied]);

  useEffect(() => {
    setIsPreviewLoading(true);
    let body = {
      providers: optionProviders,
      limit: Number(limit),
    };
    axios
      .post(
        `https://mochaccino-server.herokuapp.com/data?format=${format}`,
        body,
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((response) => {
        setPreviewData(response.data);
      })
      .finally(() => {
        setIsPreviewLoading(false);
      })
      .catch((err) => {
        console.log(err.status);
      });
  }, []);

  return (
    <section>
      {isPreviewLoading && <Spinner animation={"border"} />}
      {previewData && (
        <p ref={ref}>
          <JSONPretty data={previewData}></JSONPretty>
        </p>
      )}
      {!isPreviewLoading && (
        <LoadingButton
          style={{
            position: "sticky",
            width: "100%",
            margin: "1em 0",
            bottom: "20px",
          }}
          name={!isCopied ? "Copy to clipboard" : "Copied!"}
          function={() => {
            navigator.clipboard.writeText(ref.current?.textContent || "");
            setIsCopied(true);
          }}
        />
      )}
    </section>
  );
};

export default Preview;
