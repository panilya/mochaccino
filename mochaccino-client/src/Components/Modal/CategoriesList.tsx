import { dataTypes } from "../../Service/DataTypes";
import CardCategory from "../Card/CardCategory";
import "./Modal.css";

interface CategoriesListProps {}

const CategoriesList: React.FC<CategoriesListProps> = () => {
  return (
    <div className="categories-list">
      {dataTypes.fakeData.map((data) => (
        <CardCategory data={data} />
      ))}
    </div>
  );
};

export default CategoriesList;
