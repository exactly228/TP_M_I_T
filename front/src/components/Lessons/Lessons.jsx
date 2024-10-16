import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import api from '../../utils/Api.js';
import Lesson from '../Lesson/Lesson.jsx';

function Lessons() {
  const { id } = useParams();

  const [lessons, setLessons] = useState([]);

  useEffect(() => {
    api.getLessons(id)
      .then((res) => setLessons(res));
  }, [id]);

  return (
    <div className="lessons">
      {
        lessons.map((lesson) => (
          <Lesson data={lesson} key={lesson.id} />
        ))
      }
    </div>
  );
}

export default Lessons;
