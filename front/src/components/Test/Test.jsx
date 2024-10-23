import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

function Test() {
  const navigate = useNavigate();

  const [question1, setQuestion1] = useState('');
  const [question2, setQuestion2] = useState('');
  const [question3, setQuestion3] = useState('');
  const [question4, setQuestion4] = useState('');
  const [question5, setQuestion5] = useState('');
  const [question6, setQuestion6] = useState('');
  const [question7, setQuestion7] = useState('');
  const [question8, setQuestion8] = useState('');
  const [question9, setQuestion9] = useState('');
  const [question10, setQuestion10] = useState('');
  const [question11, setQuestion11] = useState('');
  const [question12, setQuestion12] = useState('');
  const [question13, setQuestion13] = useState('');
  const [question14, setQuestion14] = useState('');
  const [question15, setQuestion15] = useState('');
  const [question16, setQuestion16] = useState('');
  const [question17, setQuestion17] = useState('');
  const [question18, setQuestion18] = useState('');
  const [question19, setQuestion19] = useState('');
  const [question20, setQuestion20] = useState('');

  const [isChecked, setIsChecked] = useState(false);
  const [id, setId] = useState(0);
  const [counter, setCounter] = useState(0);

  function handleResult() {
    navigate(`/course/${id}`);
  }

  function handleButtonClick() {
    if (question1 === 'finished') {
      setCounter((state) => state + 1);
    }
    if (question2 === 'have known') {
      setCounter((state) => state + 1);
    }
    if (question3 === 'house') {
      setCounter((state) => state + 1);
    }
    if (question4 === 'enjoys swimming') {
      setCounter((state) => state + 1);
    }
    if (question5 === 'be') {
      setCounter((state) => state + 1);
    }
    if (question6 === 'hasn’t written') {
      setCounter((state) => state + 1);
    }
    if (question7 === 'against') {
      setCounter((state) => state + 1);
    }
    if (question8 === 'will take') {
      setCounter((state) => state + 1);
    }
    if (question9 === 'were') {
      setCounter((state) => state + 1);
    }
    if (question10 === 'what') {
      setCounter((state) => state + 1);
    }
    if (question11 === 'has lived') {
      setCounter((state) => state + 1);
    }
    if (question12 === 'is') {
      setCounter((state) => state + 1);
    }
    if (question13 === 'кот') {
      setCounter((state) => state + 1);
    }
    if (question14 === 'green') {
      setCounter((state) => state + 1);
    }
    if (question15 === 'near') {
      setCounter((state) => state + 1);
    }
    if (question16 === 'armchair') {
      setCounter((state) => state + 1);
    }
    if (question17 === 'production') {
      setCounter((state) => state + 1);
    }
    if (question18 === 'plane') {
      setCounter((state) => state + 1);
    }
    if (question19 === 'corrupt') {
      setCounter((state) => state + 1);
    }
    if (question20 === 'government') {
      setCounter((state) => state + 1);
    }

    if (counter <= 4) {
      setId(1);
    } else if (counter <= 8) {
      setId(2);
    } else if (counter <= 12) {
      setId(3);
    } else if (counter <= 16) {
      setId(4);
    } else if (counter <= 20) {
      setId(5);
    }

    setIsChecked(true);
  }

  return (
    <div className="test">
      <h1 className="test__title">
        Тест на определение подходящего курса
      </h1>
      <div className="test__container">
        <p className="test__question">
          1. After Martin ___ reading, he put out the light and fell asleep.(finish)
        </p>
        <input className="test__input" type="text" value={question1} onChange={(e) => setQuestion1(e.target.value)} />

        <p className="test__question">
          2. He has always worn the same sweater since I ___ him.(know)
        </p>
        <input className="test__input" type="text" value={question2} onChange={(e) => setQuestion2(e.target.value)} />

        <p className="test__question">
          3. He shook hands and smiled at Lindsay’s parents ___.
        </p>
        <input className="test__input" type="text" value={question3} onChange={(e) => setQuestion3(e.target.value)} />

        <p className="test__question">
          4. Lucy ___. She goes to the swimming pool three times a day.(enjoy swim)
        </p>
        <input className="test__input" type="text" value={question4} onChange={(e) => setQuestion4(e.target.value)} />

        <p className="test__question">
          5. It’s essential that everybody ___ at the meeting on time. We are about to sign a very exclusive
          contract.(be)
        </p>
        <input className="test__input" type="text" value={question5} onChange={(e) => setQuestion5(e.target.value)} />

        <p className="test__question">
          6. She ___ for 5 weeks. I am getting really worried. Something must have happened. (have write)
        </p>
        <input className="test__input" type="text" value={question6} onChange={(e) => setQuestion6(e.target.value)} />

        <p className="test__question">
          7. The ladder is standing ___ the wall. (again)
        </p>
        <input className="test__input" type="text" value={question7} onChange={(e) => setQuestion7(e.target.value)} />

        <p className="test__question">
          8. I have been waiting for the bus for 30 minutes. I can’t wait any longer. I ____ an uber. (take)
        </p>
        <input className="test__input" type="text" value={question8} onChange={(e) => setQuestion8(e.target.value)} />

        <p className="test__question">
          9. If I ___ you, I would try to study harder.(are)
        </p>
        <input className="test__input" type="text" value={question9} onChange={(e) => setQuestion9(e.target.value)} />

        <p className="test__question">
          10. I’m a senior treasury manager in a multinational company. And ___ do you do?
        </p>
        <input className="test__input" type="text" value={question10} onChange={(e) => setQuestion10(e.target.value)} />

        <p className="test__question">
          11. She ___ in Toronto for 6 years.(is live)
        </p>
        <input className="test__input" type="text" value={question11} onChange={(e) => setQuestion11(e.target.value)} />

        <p className="test__question">
          12. She ___ an engineer. She has been working in the position for LTB for 11 years.(is)
        </p>
        <input className="test__input" type="text" value={question12} onChange={(e) => setQuestion12(e.target.value)} />

        <h2 className="test__title">
          Переведите слова
        </h2>

        <p className="test__question">
          13. cat
        </p>
        <input className="test__input" type="text" value={question13} onChange={(e) => setQuestion13(e.target.value)} />

        <p className="test__question">
          14. зеленый
        </p>
        <input className="test__input" type="text" value={question14} onChange={(e) => setQuestion14(e.target.value)} />

        <p className="test__question">
          15. рядом
        </p>
        <input className="test__input" type="text" value={question15} onChange={(e) => setQuestion15(e.target.value)} />

        <p className="test__question">
          16. кресло
        </p>
        <input className="test__input" type="text" value={question16} onChange={(e) => setQuestion16(e.target.value)} />

        <p className="test__question">
          17. производство
        </p>
        <input className="test__input" type="text" value={question17} onChange={(e) => setQuestion17(e.target.value)} />

        <p className="test__question">
          18. самолет
        </p>
        <input className="test__input" type="text" value={question18} onChange={(e) => setQuestion18(e.target.value)} />

        <p className="test__question">
          19. коррупция
        </p>
        <input className="test__input" type="text" value={question19} onChange={(e) => setQuestion19(e.target.value)} />

        <p className="test__question">
          20. правительство
        </p>
        <input className="test__input" type="text" value={question20} onChange={(e) => setQuestion20(e.target.value)} />

        <button className="test__button" type="button" onClick={handleButtonClick}>
          Проверить тест
        </button>

        {
          isChecked && (
            <>
              <p className="test__result">
                Мы проверили ваши знания, вот ссылка на рекомендуемый курс
              </p>
              <button type="button" onClick={handleResult} className="test__link">
                Ссылка на рекомендуемый курс
              </button>
            </>
          )
        }
      </div>
    </div>
  );
}

export default Test;
