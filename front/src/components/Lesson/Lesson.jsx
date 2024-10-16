import React from 'react';

function Lesson({ data }) {
  return (
    <div className="lesson">
      {data.text}
    </div>
  );
}

export default Lesson;
