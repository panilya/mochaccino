import { Badge } from "react-bootstrap";
import { useLocation } from "react-router-dom";
import { useAppDispatch, useAppSelector } from "../../../Hooks/useRedux";
import { deleteOption } from "../../../Redux/Slices/OptionSlice";
import "./ChoosedBadgeList.scss";

interface ChoosedBadgeListProps {}

const ChoosedBadgeList: React.FC<ChoosedBadgeListProps> = () => {
  const optionsList = useAppSelector((state) => state.options.value);
  const location = useLocation();
  const dispatch = useAppDispatch();

  const handleDelete = (id: string) => dispatch(deleteOption(id));

  return (
    <span className="choosed-badge-list-wrapper">
      {!location.pathname.includes("credits") ? "Choosed:" : "Credits:"}
      {!location.pathname.includes("credits") && (
        <span>
          {optionsList.map((el) => (
            <Badge
              className="choosed-badge__badge"
              onClick={() => handleDelete(el.id)}
              key={el.id}
              bg="light"
              text="dark"
            >
              {el.providerName}
            </Badge>
          ))}
        </span>
      )}
    </span>
  );
};

export default ChoosedBadgeList;
