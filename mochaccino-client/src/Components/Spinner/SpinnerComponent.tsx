import { Spinner } from "react-bootstrap";
import "./SpinnerComponent.css";
interface SpinnerComponentProps {}

const SpinnerComponent: React.FC<SpinnerComponentProps> = () => {
  return (
    <div className="spinner-component-wrapper">
      <Spinner animation={"border"} />
    </div>
  );
};

export default SpinnerComponent;
