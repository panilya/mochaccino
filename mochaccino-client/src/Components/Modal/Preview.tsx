import axios from "axios";
import JSONPretty from "react-json-pretty";
import { useEffect, useRef, useState } from "react";
import { useAppSelector, useGetOptions } from "../../Hooks/useRedux";
import LoadingButton from "../LoadingButton/LoadingButton";
import SpinnerComponent from "../Spinner/SpinnerComponent";
import { useDownloadData } from "../../Hooks/useDownloadData";

interface PreviewProps {}

const Preview: React.FC<PreviewProps> = () => {
  const [isPreviewLoading, setIsPreviewLoading] = useState(false);
  const [previewData, setPreviewData] = useState();
  const [error, setError] = useState();
  const [isCopied, setIsCopied] = useState(false);
  const optionProviders = useGetOptions();
  const ref = useRef<HTMLParagraphElement>(null);
  const { limit, format, header, separator, dialect, tableName } =
    useAppSelector((state) => state.options.presets);
  const { columns } = useDownloadData();

  useEffect(() => {
    setTimeout(() => {
      setIsCopied(false);
    }, 3000);
  }, [isCopied]);

  useEffect(() => {
    console.log("start");

    setIsPreviewLoading(true);
    let body = {
      columns: columns,
      providers: optionProviders,
      limit: Number(limit),
    };
    axios
      .post(
        format === "csv"
          ? `https://mochaccino-server.herokuapp.com/data?format=${format}&header=${header}&separator=${separator}`
          : format === "sql"
          ? `https://mochaccino-server.herokuapp.com/data?format=${format}&tableName=${tableName}&dialect=${dialect}`
          : "https://mochaccino-server.herokuapp.com/data?format=json",
        body,
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((response) => {
        console.log("then ");
        setPreviewData(response.data);
      })
      .catch((err) => {
        setError(err);
      })
      .finally(() => {
        console.log("finnaly");
        setIsPreviewLoading(false);
      });
  }, []);

  return (
    <section>
      {isPreviewLoading && <SpinnerComponent />}
      {previewData && (
        <p ref={ref}>
          <JSONPretty data={previewData}></JSONPretty>
        </p>
      )}
      {error && <h1>Error : {error}</h1>}
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
