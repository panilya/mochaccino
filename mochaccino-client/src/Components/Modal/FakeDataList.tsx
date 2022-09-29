import { useNavigate, useParams } from "react-router-dom";
import { dataTypes } from "../../Service/DataTypes";
import CardOption from "../Card/CardOption";

interface FakeDataListProps {}

const FakeDataList: React.FC<FakeDataListProps> = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const list = dataTypes.fakeData.find((el) => el.id === Number(id));
  return (
    <div className="fake-data-list">
      {list && list.value.map((el) => <CardOption data={el} />)}
    </div>
  );
};

export default FakeDataList;
