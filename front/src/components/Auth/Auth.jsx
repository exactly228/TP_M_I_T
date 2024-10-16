import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function Auth() {
  const [isLogin, setIsLogin] = useState(true);

  function handleAuthToggle() {
    setIsLogin(!isLogin);
  }

  return (
    <div className="auth">
      <div className="auth__container">
        {
          isLogin ? (
            <form className="auth__form">
              <h2 className="auth__title">
                Авторизация
              </h2>
              <input className="auth__input" placeholder="Логин" id="login" type="text" />
              <input className="auth__input" placeholder="Пароль" id="pass" type="password" />
              <Link to="/main" className="auth__button">
                Войти
              </Link>
              <p className="auth__text">
                Не зарегистрированы?
                {' '}
                <button type="button" className="auth__link" onClick={handleAuthToggle}>
                  Зарегистрироваться
                </button>
              </p>
            </form>
          ) : (
            <form className="auth__form">
              <h2 className="auth__title">
                Регистрация
              </h2>
              <input className="auth__input" placeholder="ФИО" id="name" type="text" />
              <input className="auth__input" placeholder="Логин" id="login" type="text" />
              <input className="auth__input" placeholder="Пароль" id="pass" type="password" />
              <Link to="/main" className="auth__button">
                Зарегистрироваться
              </Link>
              <p className="auth__text">
                Уже зарегистрированы?
                {' '}
                <button type="button" className="auth__link" onClick={handleAuthToggle}>
                  Войти
                </button>
              </p>
            </form>
          )
        }
      </div>
    </div>
  );
}

export default Auth;
