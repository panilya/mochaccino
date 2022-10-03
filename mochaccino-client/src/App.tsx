import { Routes, Route } from "react-router-dom";
import CategoriesList from "./Components/Modal/CategoriesList";
import FakeDataList from "./Components/Modal/FakeDataList";
import ModalComponent from "./Components/Modal/ModalComponent";
import Preview from "./Components/Modal/Preview";
import Home from "./Page/Home/Home";
import NotFound from "./Page/NotFound";
import "./Style/App.css";

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
