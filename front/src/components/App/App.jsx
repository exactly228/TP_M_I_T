import React, { useEffect, useState } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import Auth from '../Auth/Auth.jsx';
import Header from '../Header/Header.jsx';
import Main from '../Main/Main.jsx';
import Lessons from '../Lessons/Lessons.jsx';
import Account from '../Account/Account.jsx';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    setIsLoggedIn(Boolean(localStorage.getItem('isLoggedIn')));
  }, []);
  return (
    <div className="app">
      {
        isLoggedIn ? (
          <>
            <Header />
            <div className="app__container">
              <Routes>
                <Route path="/" element={<Main />} />
                <Route path="/account" element={<Account setIsLoggedIn={setIsLoggedIn} />} />
                <Route path="/course/:id" element={<Lessons />} />
                <Route
                  path="*"
                  element={<Navigate to="/" replace />}
                />
              </Routes>
            </div>
          </>
        ) : (
          <Routes>
            <Route path="/auth" element={<Auth setIsLoggedIn={setIsLoggedIn} />} />
            <Route
              path="*"
              element={<Navigate to="/auth" replace />}
            />
          </Routes>
        )
      }
    </div>
  );
}

export default App;
