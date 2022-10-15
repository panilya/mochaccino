import React, { useState } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import Modal from "react-bootstrap/Modal";
import { Form } from "react-bootstrap";
import ChoosedBadgeList from "../List/BadgeList/ChoosedBadgeList";
import { SearchContext } from "../../Service/Contexts/searchContext";
import "./Modal.scss";
import ModalButtons from "./ModalComponents/ModalButtons";

interface ModalComponentProps {
  children: React.ReactNode;
}

const ModalComponent: React.FC<ModalComponentProps> = ({ children }) => {
  const [searchValue, setSearchValue] = useState("");
  const { id } = useParams();
  const location = useLocation();
  const navigate = useNavigate();

  const handleSearch = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchValue(event.target.value);
  };

  return (
    <>
      <Modal
        show={true}
        onHide={() => navigate(`/`)}
        size="xl"
        className="modal"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title id="contained-modal-title-vcenter">
            <ChoosedBadgeList />
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {!location.pathname.includes("preview") && (
            <Form.Control
              placeholder="Search ..."
              type="search"
              value={searchValue}
              onChange={handleSearch}
            />
          )}

          <SearchContext.Provider value={searchValue}>
            {children}
          </SearchContext.Provider>
        </Modal.Body>
        <Modal.Footer>
          <ModalButtons id={id} />
        </Modal.Footer>
      </Modal>
    </>
  );
};

export default ModalComponent;
