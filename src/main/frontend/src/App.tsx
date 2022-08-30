import React from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";

function App() {
  return (
    <Router>
    <main className="">
      <div>
        <Routes>
          <Route path="/" element={<Home />} />
        </Routes>
      </div>
      
    </main></Router>
  );
}

export default App;
