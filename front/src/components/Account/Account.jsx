import React from 'react';
import { useNavigate } from 'react-router-dom';

function Account({ setIsLoggedIn }) {
  const navigate = useNavigate();

  function handleLogout() {
    setIsLoggedIn(false);
    localStorage.removeItem('userEmail');
    localStorage.removeItem('userPassword');
    localStorage.removeItem('isLoggedIn');
    navigate('/');
  }
  return (
    <div className="account">
      <div className="account__container">
        <p className="account__text">
          Email:
          {' '}
          {localStorage.getItem('userEmail')}
        </p>
        <button className="account__button" type="button" onClick={handleLogout}>
          Выйти из аккаунта
        </button>
      </div>
    </div>
  );
}

export default Account;
