import logo from './logo.svg';
import './App.css';
import TopNavbar from './components/Navbar';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';

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
            <Route path="/register" element={<Registe
            r />} />
            <Route path="/profile" element={<Profile />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  </div>
  );
}

export default App;
