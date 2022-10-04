import { useEffect } from "react";
import { Spinner } from "react-bootstrap";
import { useDownloadData } from "../../Hooks/useDownloadData";

interface PreviewProps {}

const Preview: React.FC<PreviewProps> = () => {
  //   const { previewData, isPreviewLoading } = useDownloadData();
  return (
    <section>
      <p>[in development]</p>
    </section>
  );
};

export default Preview;
