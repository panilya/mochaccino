import { Form } from "react-bootstrap";
import "./SelectComponent.css";
interface SelectComponentProps {
  value: string;
  setFormat: React.Dispatch<React.SetStateAction<string>>;
}

const SelectComponent: React.FC<SelectComponentProps> = (props) => {
  const handleFormatChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    props.setFormat(event.target.value);
  };
  return (
    <>
      <Form.Label htmlFor="inputPassword5">Choose file type:</Form.Label>
      <Form.Select
        className="select"
        value={props.value}
        onChange={handleFormatChange}
        aria-label="Default select example"
      >
        <option value="csv">CSV</option>
        <option value="json">JSON</option>
        <option value="json">SQL [in develop]</option>
      </Form.Select>
    </>
  );
};

export default SelectComponent;
