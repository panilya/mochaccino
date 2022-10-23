import { Form, InputGroup } from "react-bootstrap";
import { useAppDispatch, useAppSelector } from "../Hooks/useRedux";
import { setSeparator, setHeaders } from "../Redux/Slices/OptionSlice";

interface OptionsCSVProps {}

const OptionsCSV: React.FC<OptionsCSVProps> = () => {
  const { separator, header } = useAppSelector(
    (state) => state.options.presets
  );
  const dispatch = useAppDispatch();
  const handleSeparator = (event: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setSeparator(event.target.value));
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
          onChange={() => dispatch(setHeaders(!header))}
          checked={header}
          type="checkbox"
          label="Include header"
        />
      </Form>
    </div>
  );
};

export default OptionsCSV;
