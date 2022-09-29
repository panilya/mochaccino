import { Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useAppDispatch } from "../../Redux/Hooks/useRedux";
import { deleteOption } from "../../Redux/Slices/OptionSlice";
import { IOption } from "../../Service/Interfaces";
import "./Card.css";
interface CardOptionListProps {
  data: IOption;
}

const CardOptionList: React.FC<CardOptionListProps> = ({ data }) => {
  const navigate = useNavigate();
  const dispatch = useAppDispatch();
  return (
    <Card
      className="card"
      onClick={() => dispatch(deleteOption(data.option))}
      style={{ width: "100%", margin: "1em 0" }}
    >
      <Card.Body className="card__body">
        <span>{data.option}</span>{" "}
        <span className="card__body-span">Example : "{data.example}"</span>
      </Card.Body>
    </Card>
  );
};

export default CardOptionList;
