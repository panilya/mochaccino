import { useContext } from "react";
import { useGetGroupsQuery } from "../../../Redux/Slices/GroupsQuery";
import { SearchContext } from "../../../Service/Contexts/searchContext";
import CardCategory from "../../Card/CardCategory";
import SpinnerComponent from "../../Spinner/SpinnerComponent";
import "../Modal.css";

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
      {isLoading && <SpinnerComponent />}
      {categoryList && categoryList}
    </div>
  );
};

export default CategoriesList;
