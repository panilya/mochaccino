import { Spinner } from "react-bootstrap";

import { useNavigate, useParams } from "react-router-dom";
import { useGetGroupsQuery } from "../../Redux/Slices/GroupsQuery";
import CardOption from "../Card/CardOption";

interface FakeDataListProps {}

const FakeDataList: React.FC<FakeDataListProps> = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { data, isLoading } = useGetGroupsQuery("");
  const list = data && data.find((el) => el.id === Number(id));

  return (
    <div className="fake-data-list">
      {isLoading && <Spinner animation={"border"} />}
      {list &&
        list.providers.map((el, id) => <CardOption key={id} data={el} />)}
    </div>
  );
};

export default FakeDataList;
