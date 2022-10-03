import React from "react";
import Modal from "react-bootstrap/Modal";
import "./Modal.css";
import { useNavigate, useParams } from "react-router-dom";
import ModalButtons from "./ModalButtons";
import {
  useAppDispatch,
  useAppSelector,
  useGetOptions,
} from "../../Hooks/useRedux";
import { Badge } from "react-bootstrap";
import { deleteOption } from "../../Redux/Slices/OptionSlice";

interface ModalComponentProps {
  children: React.ReactNode;
}

const ModalComponent: React.FC<ModalComponentProps> = ({ children }) => {
  const { id } = useParams();
  const navigate = useNavigate();
  const dispatch = useAppDispatch();
  const choosedOptionList = useGetOptions();
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
            <span className="modal__title-choosed-wrapper">
              Choosed :
              <span>
                {choosedOptionList.map((el, id) => (
                  <Badge
                    onClick={() => dispatch(deleteOption(el))}
                    key={id}
                    style={{ margin: "0 .5em", cursor: "pointer" }}
                    bg="light"
                    text="dark"
                  >
                    {el}
                  </Badge>
                ))}
              </span>
            </span>
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
