import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Auth from '../Auth/Auth.jsx';
import Header from '../Header/Header.jsx';
import Main from '../Main/Main.jsx';
import Lessons from '../Lessons/Lessons.jsx';
import Account from '../Account/Account.jsx';

function App() {
  return (
    <div className="app">
      <Routes>
        <Route path="/" element={<Auth />} />
        <Route
          path="/*"
          element={(
            <>
              <Header />
              <div className="app__container">
                <Routes>
                  <Route path="/main" element={<Main />} />
                  <Route path="/account" element={<Account />} />
                  <Route path="/course/:id" element={<Lessons />} />
                </Routes>
              </div>
            </>
          )}
        />
      </Routes>
    </div>
  );
}

export default App;
