import React from 'react';
import { Link } from 'react-router-dom';

function Course({ data }) {
  return (
    <Link to={`/course/${data.id}`} className="course">
      <h1 className="course__name">
        {data.name}
      </h1>
      <h2 className="course__description">
        {data.description}
      </h2>
      <img className="course__image" src={data.bannerUrl} alt={data.name} />
      <p className="course__author">
        {data.author}
      </p>
    </Link>
  );
}

export default Course;
