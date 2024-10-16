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
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getLessons(id) {
    return axios.get(`${this._baseUrl}/lessons/course/${id}`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }
}

const api = new Api({
  baseUrl: 'http://localhost:8080',
});

export default api;
