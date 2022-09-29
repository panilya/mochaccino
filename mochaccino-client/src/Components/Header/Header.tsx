import "./Header.css";
import { BiCoffeeTogo } from "react-icons/bi";
import { useNavigate } from "react-router-dom";
interface HeaderProps {}

const Header: React.FC<HeaderProps> = () => {
  const navigate = useNavigate();
  return (
    <header className="header">
      <h1 onClick={() => navigate("/")} className="header-title">
        Mochaccino <BiCoffeeTogo />
      </h1>
      <p className="header-subtitle">
        "Good data gives you good insights. Great data makes all the decisions
        for you." <br /> - Martin "Rainman" Leghart Jr.
      </p>
    </header>
  );
};

export default Header;
