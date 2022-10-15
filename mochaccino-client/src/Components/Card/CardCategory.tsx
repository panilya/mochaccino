import { Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { IFakeData } from "../../Service/Interfaces";
import "./Card.scss";
interface CardCategoryProps {
  data: IFakeData;
}

const CardCategory: React.FC<CardCategoryProps> = ({ data }) => {
  const navigate = useNavigate();
  return (
    <Card
      onClick={() => navigate(`${data.id}`)}
      style={{ width: "18rem" }}
      className="card"
    >
      <Card.Body>
        <Card.Title>{data.name}</Card.Title>
        <Card.Text>{data.description}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default CardCategory;
