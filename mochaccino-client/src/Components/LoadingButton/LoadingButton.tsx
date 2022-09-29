import { Button, Spinner } from "react-bootstrap";
import "./LoadingButton.css";
interface LoadingButtonProps {
  name: string;
  outline?: boolean;
  function?: () => void;
  isLoading?: boolean;
}

const LoadingButton: React.FC<LoadingButtonProps> = (props) => {
  return (
    <Button
      onClick={props.function}
      variant={props.outline ? "outline-primary" : "primary"}
      className="loading-button"
    >
      {props.isLoading ? (
        <Spinner animation="border" role="status">
          <span className="visually-hidden">Loading...</span>
        </Spinner>
      ) : (
        props.name
      )}
    </Button>
  );
};

export default LoadingButton;
