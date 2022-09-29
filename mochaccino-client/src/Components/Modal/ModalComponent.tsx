import React from "react";
import Modal from "react-bootstrap/Modal";
import "./Modal.css";
import { useNavigate, useParams } from "react-router-dom";
import ModalButtons from "./ModalButtons";

interface ModalComponentProps {
  children: React.ReactNode;
}

const ModalComponent: React.FC<ModalComponentProps> = ({ children }) => {
  const { id } = useParams();
  const navigate = useNavigate();
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
            Choose the theme
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>{children}</Modal.Body>
        <Modal.Footer>
          <ModalButtons id={id} />
        </Modal.Footer>
      </Modal>
    </>
  );
};

export default ModalComponent;
