import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

interface ModalButtonsProps {
  id: string | undefined;
}

const ModalButtons: React.FC<ModalButtonsProps> = ({ id }) => {
  const navigate = useNavigate();
  return (
    <>
      {id ? (
        <>
          <Button>Add</Button>
          <Button
            onClick={() => navigate("/categories")}
            variant="outline-primary"
          >
            Back
          </Button>
        </>
      ) : (
        <>
          <Button>Add</Button>
          <Button onClick={() => navigate("/")} variant="outline-primary">
            Dismiss
          </Button>
        </>
      )}
    </>
  );
};

export default ModalButtons;
