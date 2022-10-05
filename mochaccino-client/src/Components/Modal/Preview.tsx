import axios from "axios";
import JSONPretty from "react-json-pretty";
import { useEffect, useState } from "react";
import { Spinner } from "react-bootstrap";
import { useLocation } from "react-router-dom";
import { useGetOptions } from "../../Hooks/useRedux";

interface PreviewProps {}

const Preview: React.FC<PreviewProps> = () => {
  const [isPreviewLoading, setIsPreviewLoading] = useState(false);
  const [previewData, setPreviewData] = useState();
  const optionProviders = useGetOptions();
  const { limit, format } = useLocation().state;

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
      {previewData && <JSONPretty data={previewData}></JSONPretty>}
    </section>
  );
};

export default Preview;
