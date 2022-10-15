import { Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { convertCamel } from "../../Helpers/ConvertCamel";
import { useAppDispatch } from "../../Hooks/useRedux";
import { addOption } from "../../Redux/Slices/OptionSlice";
import { IProvider } from "../../Service/Interfaces";
import "./Card.scss";
interface CardOptionProps {
  data: IProvider;
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
        <Card.Title>{convertCamel(data.provider)}</Card.Title>
        <Card.Text style={{ opacity: "0.5" }}>
          Example: "{data.example}"
        </Card.Text>
      </Card.Body>
    </Card>
  );
};

export default CardOption;
