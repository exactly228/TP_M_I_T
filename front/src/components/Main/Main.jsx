import React, { useEffect, useState } from 'react';
import api from '../../utils/Api.js';
import Course from '../Course/Course.jsx';

function Main() {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    api.getCourses()
      .then((res) => setCourses(res));
  }, []);

  return (
    <div className="main">
      {
        courses.map((course) => (
          <Course key={course.id} data={course} />
        ))
       }
    </div>
  );
}

export default Main;
