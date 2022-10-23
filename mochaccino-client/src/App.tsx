import { Routes, Route } from "react-router-dom";
import FakeDataList from "./Components/Modal/ModalComponents/FakeDataList";
import ModalComponent from "./Components/Modal/ModalComponent";
import Preview from "./Components/Modal/Preview";
import Home from "./Page/Home/Home";
import NotFound from "./Page/NotFound";
import CategoriesList from "./Components/Modal/ModalComponents/CategoriesList";
import "./Style/App.scss";
import Credits from "./Components/Modal/ModalComponents/Credits";

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />}>
          <Route
            path="categories"
            element={
              <ModalComponent>
                <CategoriesList />
              </ModalComponent>
            }
          ></Route>
          <Route
            path="credits"
            element={
              <ModalComponent>
                <Credits />
              </ModalComponent>
            }
          ></Route>
          <Route
            path="categories/:id"
            element={
              <ModalComponent>
                <FakeDataList />
              </ModalComponent>
            }
          ></Route>
          <Route
            path="preview"
            element={
              <ModalComponent>
                <Preview />
              </ModalComponent>
            }
          ></Route>
        </Route>
        <Route path="/*" element={<NotFound />} />
      </Routes>
    </>
  );
};

export default App;
