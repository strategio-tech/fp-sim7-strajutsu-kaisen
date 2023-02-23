import "./App.css";
import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import LandingScreen from "./views/LandingScreen";
import LoginScreen from "./views/LoginScreen";

function App() {
    return (
        <Router>
            {/* <nav>
      <Link to="/">LandingScreen</Link>
      <Link to="/login">LoginScreen</Link>
      </nav> */}
            <Routes>
                <Route path="/" element={<LandingScreen />} />
                <Route path="/login" element={<LoginScreen />} />
            </Routes>
        </Router>
    );
}

export default App;
