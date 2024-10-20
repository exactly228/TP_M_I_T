import React, { useEffect, useState } from 'react';
import api from '../../utils/Api.js';

function Lesson({ data }) {
  const [test, setTest] = useState([]);

  const [isFirstMatched, setIsFirstMatched] = useState(false);
  const [firstAnswer, setFirstAnswer] = useState('');

  const [isSecondMatched, setIsSecondMatched] = useState(false);
  const [secondAnswer, setSecondAnswer] = useState('');

  const [isThirdMatched, setIsThirdMatched] = useState(false);
  const [thirdAnswer, setThirdAnswer] = useState('');

  const [classname, setClassname] = useState('');

  function handleFirstAnswer(e) {
    setFirstAnswer(e.target.value);
    if (e.target.value === test.answer1) {
      setIsFirstMatched(true);
      setClassname('lesson__progressbar lesson__progressbar_first');
    } else {
      setIsFirstMatched(false);
    }
  }

  function handleSecondAnswer(e) {
    setSecondAnswer(e.target.value);
    if (e.target.value === test.answer2) {
      setIsSecondMatched(true);
      setClassname('lesson__progressbar lesson__progressbar_second');
    } else {
      setIsSecondMatched(false);
    }
  }

  function handleThirdAnswer(e) {
    setThirdAnswer(e.target.value);
    if (e.target.value === test.answer3) {
      setIsThirdMatched(true);
      setClassname('lesson__progressbar lesson__progressbar_third');
    } else {
      setIsThirdMatched(false);
    }
  }

  useEffect(() => {
    api.getTests(data.id).then((res) => setTest(res));
  }, [data.id]);

  return (
    <div className="lesson">
      <div className="lesson__container">
        <div className="lesson__column">
          <h2 className="lesson__heading">
            Урок
          </h2>
          {data.text}
        </div>
        <div className="lesson__column">
          <h2 className="lesson__heading">
            Тесты по уроку
          </h2>
          <p className="lesson__question">
            {test.question1}
          </p>
          <input
            type="text"
            className={isFirstMatched ? 'lesson__input lesson__input_active' : 'lesson__input'}
            value={firstAnswer}
            onChange={handleFirstAnswer}
          />
          <p className="lesson__question">
            {test.question2}
          </p>
          <input
            type="text"
            className={isSecondMatched ? 'lesson__input lesson__input_active' : 'lesson__input'}
            value={secondAnswer}
            onChange={handleSecondAnswer}
          />

          <p className="lesson__question">
            {test.question3}
          </p>
          <input
            type="text"
            className={isThirdMatched ? 'lesson__input lesson__input_active' : 'lesson__input'}
            value={thirdAnswer}
            onChange={handleThirdAnswer}
          />
        </div>
      </div>
      <div className="lesson__progress">
        <div className={classname} />
        <div className="lesson__progress-text">
          Прогресс по уроку
        </div>
      </div>
    </div>
  );
}

export default Lesson;
