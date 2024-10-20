import axios from 'axios';

class Api {
  constructor({ baseUrl }) {
    this._baseUrl = baseUrl;
  }

  _checkResponse(res) {
    if (res.status === 200 || res.status === 201) {
      return res.data;
    }

    return Promise.reject(`Ошибка: ${res.status}`);
  }

  getCourses() {
    return axios.get(`${this._baseUrl}/courses`, {
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Basic ${btoa(`${localStorage.getItem('userEmail')}:${localStorage.getItem('userPassword')}`)}`,
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getLessons(id) {
    return axios.get(`${this._baseUrl}/lessons/course/${id}`, {
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Basic ${btoa(`${localStorage.getItem('userEmail')}:${localStorage.getItem('userPassword')}`)}`,
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getTests(id) {
    return axios.get(`${this._baseUrl}/tests/${id}`, {
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Basic ${btoa(`${localStorage.getItem('userEmail')}:${localStorage.getItem('userPassword')}`)}`,
      },
    })
      .then((res) => this._checkResponse(res));
  }

  register(userData) {
    return axios.post(`${this._baseUrl}/api/auth/register`, userData, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res))
      .catch((res) => Promise.reject(res.response.data));
  }

  login(userData) {
    return axios.post(`${this._baseUrl}/api/auth/login`, userData, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res))
      .catch((res) => Promise.reject(res.response.data));
  }
}

const api = new Api({
  baseUrl: 'http://89.169.164.236:8080',
});

export default api;
