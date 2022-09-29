import { useRef } from "react";
import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { IOption } from "../../Service/Interfaces";
import CardOptionList from "../Card/CardOptionList";
import "./OptionTable.css";

interface OptionTableProps {
  optionList: IOption[];
}

const OptionTable: React.FC<OptionTableProps> = ({ optionList }) => {
  const navigate = useNavigate();
  const ref = useRef<HTMLDivElement>(null);
  ref.current?.scrollIntoView({ behavior: "smooth" });
  return (
    <section className="option-table">
      {optionList.length === 0 && <p>Add options below!</p>}
      {optionList.length > 0 &&
        optionList.map((el) => <CardOptionList data={el} />)}
      <Button onClick={() => navigate("categories")}>Add data</Button>
      <div ref={ref}></div>
    </section>
  );
};

export default OptionTable;
