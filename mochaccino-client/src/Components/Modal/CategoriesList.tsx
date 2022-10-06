import { useContext, useEffect } from "react";
import { Spinner } from "react-bootstrap";
import { useGetGroupsQuery } from "../../Redux/Slices/GroupsQuery";
import { SearchContext } from "../../Service/Contexts/searchContext";
import CardCategory from "../Card/CardCategory";
import "./Modal.css";


interface CategoriesListProps {}

const CategoriesList: React.FC<CategoriesListProps> = () => {
  const { data, isLoading } = useGetGroupsQuery("");
  const searchValue = useContext(SearchContext);

  const filteredList =
    data &&
    data.filter((el) =>
      searchValue === "" ? el : el.name.toLowerCase().includes(searchValue)
    );

  const categoryList =
    filteredList &&
    filteredList.map((data, id) => <CardCategory key={id} data={data} />);

  return (
    <div className="categories-list">
      {isLoading && <Spinner animation={"border"} />}
      {categoryList && categoryList}
    </div>
  );
};

export default CategoriesList;
