import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <header className="header">
      <div className="header__container">
        <Link className="header__logo" to="/" />
        <div className="header__wrapper">
          <Link className="header__button header__button_test" to="/test">
            Тест
          </Link>
          <Link className="header__button" to="/account" />
        </div>
      </div>
    </header>
  );
}

export default Header;
