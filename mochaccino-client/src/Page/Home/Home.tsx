import axios from "axios";
import { useState } from "react";
import Header from "../../Components/Header/Header";
import LoadingButton from "../../Components/LoadingButton/LoadingButton";
import SelectComponent from "../../Components/Select/SelectComponent";

import "bootstrap/dist/css/bootstrap.min.css";
import "./Home.css";
import { Outlet } from "react-router-dom";
import { useAppSelector, useGetOptions } from "../../Redux/Hooks/useRedux";
import OptionTable from "../../Components/List/OptionTable";

interface HomeProps {}

const Home: React.FC<HomeProps> = () => {
  const [isLoading, setIsLoading] = useState(false);
  const [format, setFormat] = useState("csv");
  const [limit, setLimit] = useState<number>(1000);

  const optionList = useAppSelector((state) => state.options.value);
  const optionProviders = useGetOptions();

  const handleDownload = () => {
    let body = {
      providers: optionProviders,
      limit: limit,
    };
    setIsLoading(true);
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

  return (
    <div className="home">
      <div className="home__content">
        <Header />
        <Outlet />
        <div className="home__sides-wrapper">
          <div className="home__left-wrapper">
            <section className="home__table-wrapper">
              <OptionTable optionList={optionList} />
            </section>
          </div>
          <div className="home__right-wrapper">
            <div className="home__select-wrapper">
              <SelectComponent value={format} setFormat={setFormat} />
            </div>
            <div className="home__button-wrapper">
              <LoadingButton
                function={handleDownload}
                isLoading={isLoading}
                name="Download data"
              />
              <LoadingButton
                function={() => console.log("hey")}
                outline={true}
                name="Preview data"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
