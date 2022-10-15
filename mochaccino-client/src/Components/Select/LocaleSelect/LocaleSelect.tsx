import { useAppDispatch, useAppSelector } from "../../../Hooks/useRedux";
import { Form } from "react-bootstrap";
import { setDefaultLocale } from "../../../Redux/Slices/OptionSlice";

interface LocaleSelectProps {}

const LocaleSelect: React.FC<LocaleSelectProps> = () => {
  const dispatch = useAppDispatch();
  const defaultLocale = useAppSelector((state) => state.options.defaultLocale);
  return (
    <>
      <Form.Label>
        {" "}
        <span style={{ opacity: ".6" }}>[in development]</span> Choose preferred
        locale:
      </Form.Label>
      <Form.Select
        value={defaultLocale}
        onChange={(event) => dispatch(setDefaultLocale(event.target.value))}
      >
        <option value="custom">custom</option>
        <option value="ua">ua</option>
        <option value="us">us</option>
        <option value="en">en</option>
      </Form.Select>
    </>
  );
};

export default LocaleSelect;
