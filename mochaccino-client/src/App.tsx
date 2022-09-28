import axios from "axios";
import { useState } from "react";
import Button from "react-bootstrap/Button";
import Spinner from "react-bootstrap/Spinner";
import Form from "react-bootstrap/Form";
import { dataTypes } from "./Service/DataTypes";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Style/App.css";
import ModalComponent from "./Components/ModalComponent";

function App() {
  const [isLoading, setIsLoading] = useState(false);
  const [format, setFormat] = useState("csv");
  const [limit, setLimit] = useState<number>(1000);
  const [modalShow, setModalShow] = useState(false);
  const [choosedData, setChoosedData] = useState([]);

  const handleFormatChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    console.log("changed");
    setFormat(event.target.value);
  };
  const handleDownload = () => {
    let body = {
      providers: ["firstName", "lastName", "zipCode"],
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
        console.log(response.headers);
        const contentDispositionHeader =
          response.headers["content-disposition"];
        const fileFormat = contentDispositionHeader.split(".")[1].slice(0, -1);
        console.log(fileFormat);
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
    <div className="app">
      <div className="app__content">
        <header className="app__header">
          <h1 className="app__header-title">Mochaccino</h1>
          <p className="app__header-subtitle">
            " Lorem ipsum dolor sit amet consectetur adipisicing elit officia. "
          </p>
        </header>

        <Form.Label htmlFor="inputPassword5">
          Choose the recieved file type:
        </Form.Label>
        <Form.Select
          value={format}
          onChange={handleFormatChange}
          aria-label="Default select example"
          className="app__select"
        >
          <option value="csv">CSV</option>
          <option value="json">JSON</option>
        </Form.Select>

        <section className="app__table-wrapper">
          <section className="app__table">
            {choosedData.map(el => <li>{el}</li>)}
            <Button onClick={() => setModalShow(true)}>Add data</Button>
          </section>
        </section>

        <ModalComponent show={modalShow} onHide={() => setModalShow(false)} />

        <div className="app__button-wrapper">
          <Button
            onClick={handleDownload}
            variant="primary"
            className="app__button"
          >
            {isLoading ? (
              <Spinner animation="border" role="status">
                <span className="visually-hidden">Loading...</span>
              </Spinner>
            ) : (
              "Download Data"
            )}
          </Button>
        </div>
      </div>
    </div>
  );
}

export default App;
