import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

interface NotFoundProps {}

const NotFound: React.FC<NotFoundProps> = () => {
  const navigate = useNavigate();
  return (
    <div
      style={{
        textAlign: "center",
        padding: "10em",
        width: "100%",
        height: "100vh",
        color: "#fff",
        background: "#303030",
      }}
      className="not-found"
    >
      <h1>Page not found.</h1>
      <Button style={{ margin: "2em" }} onClick={() => navigate("/")}>
        Go to main
      </Button>
    </div>
  );
};

export default NotFound;
