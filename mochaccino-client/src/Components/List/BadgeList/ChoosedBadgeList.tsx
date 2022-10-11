import { Badge } from "react-bootstrap";
import { useAppDispatch, useGetOptions } from "../../../Hooks/useRedux";
import { deleteOption } from "../../../Redux/Slices/OptionSlice";
import "./ChoosedBadgeList.css";

interface ChoosedBadgeListProps {}

const ChoosedBadgeList: React.FC<ChoosedBadgeListProps> = () => {
  const choosedOptionList = useGetOptions();
  const dispatch = useAppDispatch();

  const handleDelete = (name: string) => dispatch(deleteOption(name));

  return (
    <span className="choosed-badge-list-wrapper">
      Choosed:
      <span>
        {choosedOptionList.map((el, id) => (
          <Badge
            className="choosed-badge__badge"
            onClick={() => handleDelete(el)}
            key={id}
            bg="light"
            text="dark"
          >
            {el}
          </Badge>
        ))}
      </span>
    </span>
  );
};

export default ChoosedBadgeList;
