import './App.css';
import TopNavbar from './components/Navbar';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';
import ShowBrands from './components/ShowBrands';
import AddBrand from './components/AddBrand';
import DeleteBrand from './components/DeleteBrand';
import ShowModels from './components/ShowModels';
import AddModel from './components/AddModel';
import DeleteModel from './components/DeleteModel';
import ShowEngines from './components/ShowEngines';
import AddEngine from './components/AddEngine';
import DeleteEngine from './components/DeleteEngine';
import Profile from './components/Profile';
import ShowCars from './components/ShowCars';
import AddCar from './components/AddCar';
import DeleteCar from './components/DeleteCar';
import ShowReservations from './components/ShowReservations';
import AddReservation from './components/AddReservation';
import DeleteReservation from './components/DeleteReservation';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import PriceCatalog from './components/PriceCatalog';





function App() {
  return (
    <div className="Page">
    <BrowserRouter className="App">
      <div className="NavBar">
        <TopNavbar />
      </div>
      <div className="Main">
        <div className="CenterComponent">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/prices" element={<PriceCatalog />} />

            <Route path="/brands" element={<ShowBrands />} />
              <Route path="/brands/add" element={<AddBrand />} />
              <Route path="/brands/delete" element={<DeleteBrand />} />

              <Route path="/models" element={<ShowModels />} />
              <Route path="/models/add" element={<AddModel />} />
              <Route path="/models/delete" element={<DeleteModel />} />

              <Route path="/engines" element={<ShowEngines />} />
              <Route path="/engines/add" element={<AddEngine />} />
              <Route path="/engines/delete" element={<DeleteEngine />} /> 

              <Route path="/cars" element={<ShowCars />} />
              <Route path="/cars/add" element={<AddCar />} />
              <Route path="/cars/delete" element={<DeleteCar />} />

              <Route path="/reservations" element={<ShowReservations />} />
              <Route path="/reservations/add" element={<AddReservation />} />
              <Route
                path="/reservations/delete"
                element={<DeleteReservation />}
              />

          </Routes>
        </div>
      </div>
    </BrowserRouter>
  </div>
  );
}

export default App;
