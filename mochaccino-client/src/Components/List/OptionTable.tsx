import { useRef } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useAppDispatch } from "../../Hooks/useRedux";
import { setLocale } from "../../Redux/Slices/OptionSlice";
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
  ref.current?.scrollIntoView({ behavior: "smooth" });

  return (
    <section className="option-table">
      {optionList.length === 0 && <p>Add options below!</p>}
      {optionList.length > 0 &&
        optionList.map((el, id) => {
          return (
            <div className="option-table__row">
              <CardOptionList key={id} data={el} />{" "}
              <Form.Label className="option-table-row__label">
                Locale:
              </Form.Label>
              <Form.Select
                id="option-table-row__select"
                style={{ height: "65%" }}
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
      <Button onClick={() => navigate("categories")}>Add data</Button>
      <div ref={ref}></div>
    </section>
  );
};

export default OptionTable;
