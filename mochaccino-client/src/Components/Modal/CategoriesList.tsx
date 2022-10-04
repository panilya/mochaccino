import { Spinner } from "react-bootstrap";
import { useGetGroupsQuery } from "../../Redux/Slices/GroupsQuery";
import CardCategory from "../Card/CardCategory";
import "./Modal.css";

interface CategoriesListProps {}

const CategoriesList: React.FC<CategoriesListProps> = () => {
  const { data, isLoading } = useGetGroupsQuery("");
  return (
    <div className="categories-list">
      {isLoading && <Spinner animation={"border"} />}
      {data && data.map((data, id) => <CardCategory key={id} data={data} />)}
    </div>
  );
};

export default CategoriesList;
