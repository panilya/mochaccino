import { Form, InputGroup } from "react-bootstrap";
import { useDownloadData } from "../Hooks/useDownloadData";

interface OptionsProps {}

const Options: React.FC<OptionsProps> = () => {
  const { header, separator, setSeparator, setHeader } = useDownloadData();
  const handleSeparator = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSeparator(event.target.value);
  };
  return (
    <div>
      <Form>
        <Form.Label style={{ opacity: ".7", marginTop: "1em" }}>
          Options:
        </Form.Label>
        <InputGroup className="mb-3">
          <InputGroup.Text>Separator?</InputGroup.Text>
          <Form.Control
            defaultValue={","}
            onChange={handleSeparator}
            value={separator}
            placeholder=""
            aria-label="Separator input"
          />
        </InputGroup>
        <Form.Check
          onChange={() => setHeader((prev) => !prev)}
          checked={header}
          type="checkbox"
          label="Include header"
        />
      </Form>
    </div>
  );
};

export default Options;
