import { Badge } from "react-bootstrap";
import { useAppDispatch, useAppSelector } from "../../../Hooks/useRedux";
import { deleteOption } from "../../../Redux/Slices/OptionSlice";
import "./ChoosedBadgeList.scss";

interface ChoosedBadgeListProps {}

const ChoosedBadgeList: React.FC<ChoosedBadgeListProps> = () => {
  const optionsList = useAppSelector((state) => state.options.value);

  const dispatch = useAppDispatch();

  const handleDelete = (id: string) => dispatch(deleteOption(id));

  return (
    <span className="choosed-badge-list-wrapper">
      Choosed:
      <span>
        {optionsList.map((el) => (
          <Badge
            className="choosed-badge__badge"
            onClick={() => handleDelete(el.id)}
            key={el.id}
            bg="light"
            text="dark"
          >
            {el.provider}
          </Badge>
        ))}
      </span>
    </span>
  );
};

export default ChoosedBadgeList;
