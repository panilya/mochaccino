import { Form } from "react-bootstrap";
import { useAppDispatch, useAppSelector } from "../../Hooks/useRedux";
import { setFormat } from "../../Redux/Slices/OptionSlice";
import "./SelectComponent.scss";
interface SelectComponentProps {}

const SelectComponent: React.FC<SelectComponentProps> = () => {
  const dispatch = useAppDispatch();
  const { format } = useAppSelector((state) => state.options.presets);
  const handleFormatChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    dispatch(setFormat(event.target.value));
  };
  return (
    <>
      <Form.Label htmlFor="inputPassword5">Choose file type:</Form.Label>
      <Form.Select
        className="select"
        value={format}
        onChange={handleFormatChange}
        aria-label="Default select example"
      >
        <option value="csv">CSV</option>
        <option value="json">JSON</option>
        <option value="sql">SQL</option>
      </Form.Select>
    </>
  );
};

export default SelectComponent;
