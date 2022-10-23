import axios from "axios";
import { useEffect, useState } from "react";
import { useAppSelector, useGetOptions } from "./useRedux";

export const useDownloadData = () => {
  const [isLoading, setIsLoading] = useState(false);
  const optionProviders = useGetOptions();

  const { separator, dialect, format, limit, header, tableName } =
    useAppSelector((state) => state.options.presets);

  const URL = () => {
    let URLbase = "https://mochaccino-server.herokuapp.com/data";
    let URLDownload = "/download";
    let URLcsv = `?format=${format}&header=${header}&separator=${separator}`;
    let URLsql = `?format=${format}&tableName=${tableName}&dialect=${dialect}`;
    if (format === "csv") {
      return URLbase + URLDownload + URLcsv;
    }
    if (format === "sql") {
      return URLbase + URLDownload + URLsql;
    } else {
      return URLbase + URLDownload;
    }
  };

  const handleDownloadData = () => {
    setIsLoading(true);
    let body = {
      providers: optionProviders,
      limit: Number(limit),
    };
    axios
      .post(URL(), body, {
        headers: {
          "Content-Type": "application/json",
        },
      })
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
    handleDownloadData,
    optionProviders,
  };

  return store;
};
