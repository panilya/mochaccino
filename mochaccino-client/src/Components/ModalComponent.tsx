import React from "react";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";
import { dataTypes } from "../Service/DataTypes";

interface ModalComponentProps {
  show: boolean;
  onHide: () => void;
}

const ModalComponent: React.FC<ModalComponentProps> = (props) => {
  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter">
          Modal heading
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <h4>Centered Modal</h4>
        <ul>
          {dataTypes.person.value.map((el) => (
            <li>{el}</li>
          ))}
        </ul>
      </Modal.Body>
      <Modal.Footer>
        <Button onClick={props.onHide}>Add</Button>
        <Button variant="outline-primary" onClick={props.onHide}>
          Dismiss
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default ModalComponent;
