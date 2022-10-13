import { Outlet, useNavigate } from "react-router-dom";
import Header from "../../Components/Header/Header";
import LoadingButton from "../../Components/LoadingButton/LoadingButton";
import SelectComponent from "../../Components/Select/SelectComponent";
import OptionTable from "../../Components/List/OptionTable";
import Options from "../../Components/Options";
import LocaleSelect from "../../Components/Select/LocaleSelect/LocaleSelect";
import { useDownloadData } from "../../Hooks/useDownloadData";
import { useAppDispatch, useAppSelector } from "../../Hooks/useRedux";
import Form from "react-bootstrap/Form";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Home.css";

interface HomeProps {}

const Home: React.FC<HomeProps> = () => {
  const optionList = useAppSelector((state) => state.options.value);
  const defaultLocale = useAppSelector((state) => state.options.defaultLocale);
  const dispatch = useAppDispatch();
  const navigate = useNavigate();
  const { limit, setLimit, format, setFormat, isLoading, handleDownloadData } =
    useDownloadData();

  const handleLimitChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.value.charAt(0) === "-") {
      return setLimit("1");
    }
    if (e.target.value.charAt(0) === "0") {
      return setLimit(e.target.value.substring(1));
    }
    if (Number(e.target.value) > 100000) {
      return setLimit("100000");
    }
    if (Number(e.target.value) < 0) {
      return setLimit("1");
    }
    setLimit(e.target.value);
  };

  return (
    <div className="home">
      <div className="home__content">
        <Header />
        <Outlet />
        <div className="home__sides-wrapper">
          <div className="home__left-wrapper">
            <section className="home__table-wrapper">
              <OptionTable
                optionList={optionList}
                defaultLocale={defaultLocale}
              />
            </section>
          </div>
          <div className="home__right-wrapper">
            <div className="home__select-wrapper">
              <Form.Label>Choose the limit</Form.Label>
              <Form.Control
                type="number"
                onChange={handleLimitChange}
                value={limit}
                style={{ width: "100%" }}
                min="1"
                pattern="^[+]?\d+([.]\d+)?$"
                placeholder="Amount goes here..."
              />
              <SelectComponent value={format} setFormat={setFormat} />
              <LocaleSelect />
              {format === "csv" && <Options />}
            </div>
            <div className="home__button-wrapper">
              <LoadingButton
                disabled={optionList.length === 0}
                function={handleDownloadData}
                isLoading={isLoading}
                name="Download data"
              />
              <LoadingButton
                function={() => {
                  navigate("preview", { state: { format, limit } });
                }}
                disabled={optionList.length === 0}
                outline={true}
                name="Preview data"
              />
            </div>
          </div>
        </div>
        <footer className="home__footer">
          <p className="home__credits">
            Powered by{" "}
            <a href="https://github.com/datafaker-net/datafaker">Datafaker</a>{" "}
          </p>
        </footer>
      </div>
    </div>
  );
};

export default Home;
