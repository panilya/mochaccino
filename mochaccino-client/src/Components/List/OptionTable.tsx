import { useRef } from "react";
import { Button, Form } from "react-bootstrap";
import { BiTrash } from "react-icons/bi";
import { useNavigate } from "react-router-dom";
import { useAppDispatch } from "../../Hooks/useRedux";
import { deleteOption, setLocale } from "../../Redux/Slices/OptionSlice";
import { IProvider } from "../../Service/Interfaces";
import CardOptionList from "../Card/CardOptionList";
import "./OptionTable.css";

interface OptionTableProps {
  optionList: IProvider[];
  defaultLocale: string;
}

const OptionTable: React.FC<OptionTableProps> = ({
  optionList,
  defaultLocale,
}) => {
  const dispatch = useAppDispatch();
  const navigate = useNavigate();
  const ref = useRef<HTMLDivElement>(null);

  return (
    <section className="option-table">
      {optionList.length === 0 && <p className="option-table__hint">Add options below!</p>}
      {optionList.length > 0 &&
        optionList.map((el, id) => {
          return (
            <div className="option-table__row">
              <BiTrash
                onClick={() => dispatch(deleteOption(el.id))}
                className="option-table__delete"
              />
              <CardOptionList key={id} data={el} />{" "}
              <Form.Select
                id="option-table-row__select"
                style={{ height: "100%" }}
                value={el.locale}
                defaultValue={defaultLocale}
                onChange={(event) =>
                  dispatch(setLocale({ id: el.id, locale: event.target.value }))
                }
              >
                <option value="en">en</option>
                <option value="us">us</option>
                <option value="ua">ua</option>
              </Form.Select>
            </div>
          );
        })}
      <div ref={ref}></div>
      <Button
        id="option-table__add-button"
        onClick={() => {
          navigate("categories");
          ref.current?.scrollIntoView({ behavior: "smooth" });
        }}
      >
        Add data
      </Button>
    </section>
  );
};

export default OptionTable;
