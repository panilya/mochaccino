import { Card } from "react-bootstrap";
import { convertCamel } from "../../Helpers/ConvertCamel";
import { IProvider } from "../../Service/Interfaces";
import "./Card.css";
interface CardOptionListProps {
  data: IProvider;
}

const CardOptionList: React.FC<CardOptionListProps> = ({ data }) => {
  return (
    <Card
      className="card"
      id="card"
    >
      <Card.Body className="card__body">
        <span className="card__body-title">{convertCamel(data.provider)}</span>{" "}
        <div className="card__body-div">
          <span className="card__body-span-example">"{data.example}"</span>
        </div>
      </Card.Body>
    </Card>
  );
};

export default CardOptionList;
