import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <header className="header">
      <div className="header__container">
        <Link className="header__logo" to="/" />
        <Link className="header__button" to="/account" />
      </div>
    </header>
  );
}

export default Header;
