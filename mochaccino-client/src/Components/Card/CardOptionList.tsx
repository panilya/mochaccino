import { Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { convertCamel } from "../../Helpers/ConvertCamel";
import { useAppDispatch } from "../../Hooks/useRedux";
import { deleteOption } from "../../Redux/Slices/OptionSlice";
import { IProvider } from "../../Service/Interfaces";
import "./Card.css";
interface CardOptionListProps {
  data: IProvider;
}

const CardOptionList: React.FC<CardOptionListProps> = ({ data }) => {
  const dispatch = useAppDispatch();
  return (
    <Card
      className="card"
      onClick={() => dispatch(deleteOption(data.id))}
      style={{
        width: "100%",
        margin: "1em 0",
      }}
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
