import { Outlet, useNavigate } from "react-router-dom";
import Header from "../../Components/Header/Header";
import LoadingButton from "../../Components/LoadingButton/LoadingButton";
import SelectComponent from "../../Components/Select/SelectComponent";
import OptionTable from "../../Components/List/OptionTable";
import { useDownloadData } from "../../Hooks/useDownloadData";
import { useAppDispatch, useAppSelector } from "../../Hooks/useRedux";
import Form from "react-bootstrap/Form";
import { AiOutlineInfoCircle } from "react-icons/ai";
import { Button } from "react-bootstrap";
import OptionsCSV from "../../Components/OptionsCSV";
import OptionsSQL from "../../Components/OptionsSQL";
import { setLimit } from "../../Redux/Slices/OptionSlice";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Home.scss";

interface HomeProps {}

const Home: React.FC<HomeProps> = () => {
  const isButtonDisabled: number = useAppSelector(
    (state) => state.options.value.length
  );
  const dispatch = useAppDispatch();
  const { format, limit } = useAppSelector((state) => state.options.presets);
  const navigate = useNavigate();
  const { isLoading, handleDownloadData } = useDownloadData();
  const handleLimitChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setLimit(e.target.value));
  };

  return (
    <div className="home">
      <div className="home__content">
        <Header />
        <Outlet />
        <div className="home__sides-wrapper">
          <div className="home__left-wrapper">
            <section className="home__table-wrapper">
              <OptionTable />
              <Button
                id="option-table__add-button"
                onClick={() => {
                  navigate("categories");
                }}
              >
                Add data
              </Button>
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
              {Number(limit) >= 1000000 && (
                <span style={{ color: "red" }}>
                  Use preview on your own risk.
                  <br />
                </span>
              )}
              <SelectComponent />
              {/* <LocaleSelect /> */}
              {format === "csv" && <OptionsCSV />}
              {format === "sql" && <OptionsSQL />}
            </div>
            <div className="home__button-wrapper">
              <LoadingButton
                disabled={isButtonDisabled === 0}
                function={handleDownloadData}
                isLoading={isLoading}
                name="Download data"
              />
              <LoadingButton
                function={() => {
                  navigate("preview");
                }}
                disabled={isButtonDisabled === 0}
                outline={true}
                name="Preview data"
              />
            </div>
          </div>
        </div>
        <footer className="home__footer">
          <AiOutlineInfoCircle onClick={() => navigate(`credits`)} />
          <p className="home__credits">
            | Powered by{" "}
            <a href="https://github.com/datafaker-net/datafaker">Datafaker</a>{" "}
          </p>
        </footer>
      </div>
    </div>
  );
};

export default Home;
