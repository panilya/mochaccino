import { useContext } from "react";
import { useParams } from "react-router-dom";
import { useGetGroupsQuery } from "../../../Redux/Slices/GroupsQuery";
import { SearchContext } from "../../../Service/Contexts/searchContext";
import CardOption from "../../Card/CardOption";
import SpinnerComponent from "../../Spinner/SpinnerComponent";

interface FakeDataListProps {}

const FakeDataList: React.FC<FakeDataListProps> = () => {
  const { id } = useParams();
  const searchValue = useContext(SearchContext);
  const { data, isLoading } = useGetGroupsQuery("");
  const list = data && data.find((el) => el.id === Number(id));

  const filteredProviders =
    list &&
    list.providers.filter((el) =>
      searchValue === "" ? el : el.provider.toLowerCase().includes(searchValue)
    );

  return (
    <div className="fake-data-list">
      {isLoading && <SpinnerComponent />}
      {filteredProviders &&
        filteredProviders.map((el, id) => <CardOption key={id} data={el} />)}
    </div>
  );
};

export default FakeDataList;
