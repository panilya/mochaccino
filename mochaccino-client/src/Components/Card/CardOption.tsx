import { Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useAppDispatch } from "../../Redux/Hooks/useRedux";
import { addOption } from "../../Redux/Slices/OptionSlice";
import { IOption } from "../../Service/Interfaces";
import "./Card.css";
interface CardOptionProps {
  data: IOption;
}

const CardOption: React.FC<CardOptionProps> = ({ data }) => {
  const navigate = useNavigate();
  const dispatch = useAppDispatch();
  return (
    <Card
      onClick={() => dispatch(addOption(data))}
      style={{ width: "18rem", height: "150px" }}
      className="card"
    >
      <Card.Body>
        <Card.Title>{data.option}</Card.Title>
        <Card.Text style={{ opacity: "0.5" }}>
          Example: "{data.example}"
        </Card.Text>
      </Card.Body>
    </Card>
  );
};

export default CardOption;
