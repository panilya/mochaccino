import axios from "axios";
import { useState } from "react";
import { useGetOptions } from "./useRedux";

export const useDownloadData = () => {
  const [limit, setLimit] = useState<string>("1000");
  const [isLoading, setIsLoading] = useState(false);
  const [format, setFormat] = useState("csv");
  const optionProviders = useGetOptions();

  const handleDownloadData = () => {
    setIsLoading(true);
    let body = {
      providers: optionProviders,
      limit: Number(limit),
    };
    axios
      .post(
        `https://mochaccino-server.herokuapp.com/data/download?format=${format}`,
        body,
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((response) => {
        const contentDispositionHeader =
          response.headers["content-disposition"];
        const fileFormat = contentDispositionHeader.split(".")[1].slice(0, -1);
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement("a");
        link.href = url;
        const desiredFileFormat = "data." + fileFormat;
        link.setAttribute("download", desiredFileFormat);
        document.body.appendChild(link);
        link.click();
      })
      .finally(() => setIsLoading(false))
      .catch((err) => {
        console.log(err.status);
      });
  };
  const store = {
    isLoading,
    limit,
    format,
    setFormat,
    handleDownloadData,
    setLimit,
    optionProviders,
  };
  
  return store;
};
