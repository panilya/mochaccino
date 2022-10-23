import { Card } from "react-bootstrap";
import "../../../Page/Home/Home.scss";
interface CreditsProps {}

const Credits: React.FC<CreditsProps> = () => {
  return (
    <div>
      <Card.Text style={{ textAlign: "center", fontSize: "25px" }}>
        Backend by{" "}
        <a
          href="https://github.com/panilya"
          target="_blank"
          className="home__credits"
        >
          Illya Pantsir{" "}
        </a>
        <br />
        Frontend by{" "}
        <a
          href="https://github.com/SemX74"
          target="_blank"
          className="home__credits"
        >
          Mykola Semeniuk{" "}
        </a>
        <br />
      </Card.Text>
    </div>
  );
};

export default Credits;
