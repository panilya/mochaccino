import { Form } from "react-bootstrap";
import { BiTrash } from "react-icons/bi";
import { useAppDispatch, useAppSelector } from "../../Hooks/useRedux";
import {
  changeOption,
  deleteOption,
  // setLocale,
} from "../../Redux/Slices/OptionSlice";
import CardOptionList from "../Card/CardOptionList";
import "./OptionTable.scss";

interface OptionTableProps {}

const OptionTable: React.FC<OptionTableProps> = () => {
  const dispatch = useAppDispatch();
  // const defaultLocale = useAppSelector((state) => state.options.defaultLocale);
  const optionList = useAppSelector((state) => state.options.value);

  return (
    <section className="option-table">
      {optionList.length === 0 && (
        <p className="option-table__hint">Add options below!</p>
      )}
      {optionList.length > 0 &&
        optionList.map((el, id) => {
          return (
            <div key={id} className="option-table__row">
              <BiTrash
                onClick={() => dispatch(deleteOption(el.id))}
                className="option-table__delete"
              />
              <CardOptionList key={id} data={el} />
              <Form.Control
                placeholder={el.providerName}
                value={el.provider}
                onChange={(event) =>
                  dispatch(
                    changeOption({ id: el.id, provider: event.target.value })
                  )
                }
                style={{ height: "100%", width: "50%" }}
                defaultValue={el.providerName}
              />

              {/*
               Locales
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
              </Form.Select> */}
            </div>
          );
        })}
    </section>
  );
};

export default OptionTable;
