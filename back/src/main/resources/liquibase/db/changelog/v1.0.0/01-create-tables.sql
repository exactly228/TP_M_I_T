drop table if exists users, courses, lessons, tests cascade;

create table if not exists users
(
    id       bigint generated always as identity primary key,
    name     varchar(50) not null,
    email    varchar(50) not null,
    password varchar not null
);

create table if not exists courses
(
    id          bigint generated always as identity primary key,
    name        varchar(100) not null,
    description varchar,
    author      varchar(100),
    banner_url  varchar
);

create table if not exists lessons
(
    id        bigint generated always as identity primary key,
    name      varchar(100) not null,
    course_id bigint references courses (id) on delete cascade,
    text      varchar      not null
);

create table if not exists tests
(
    id             bigint generated always as identity primary key,
    lesson_id      bigint references lessons (id) on delete cascade,
    question_1     varchar,
    right_answer_1 varchar,
    question_2     varchar,
    right_answer_2 varchar,
    question_3     varchar,
    right_answer_3 varchar
);


insert into courses (name, description, author, banner_url)
values ('Английский для самых маленьких', 'Английский для самых маленьких.', 'Вадим Шнякин', 'https://avatars.mds.yandex.net/i?id=ad34f7da131c7257fbbcf19aa9bf7f71417f12ad-5859737-images-thumbs&n=13'),
       ('Английский для детей 5-7 лет', 'Курс английского для детей младшего возраста.', 'Вадим Шнякин', 'https://cdn.culture.ru/c/559886.jpg'),
       ('Английский для школьников', 'Курс английского для школьников.', 'Вадим Шнякин', 'https://avatars.mds.yandex.net/i?id=848f972d2783456dfc23f2eb9e1da26306529cc2-12884893-images-thumbs&n=13'),
       ('Английский для подростков', 'Курс английского языка для подростков.', 'Вадим Шнякин', 'https://unecon.ru/wp-content/uploads/2022/11/2113515504765283.jpg'),
       ('Английский для взрослых начинающих', 'Английский для взрослых с нуля.', 'Вадим Шнякин', 'https://avatars.mds.yandex.net/i?id=41a9620335cab2e4302affc7e1a2534f301c2ee5-7069403-images-thumbs&n=13');

insert into lessons (name, course_id, text)
values ('Английский для самых маленьких. Урок 1', 1,
        'В этом уроке мы познакомимся с основными английскими словами: "Hello" (Привет), "Goodbye" (До свидания), "Yes" (Да), "No" (Нет). Эти слова помогут начать общение. Попробуйте повторять их вместе с родителями или друзьями.'),
       ('Английский для самых маленьких. Урок 2', 1,
        'Сегодня мы будем учить числа от 1 до 10. Повторяйте за мной: One (один), Two (два), Three (три), Four (четыре), Five (пять), Six (шесть), Seven (семь), Eight (восемь), Nine (девять), Ten (десять). Давайте посчитаем игрушки вместе!'),
       ('Английский для самых маленьких. Урок 3', 1,
        'Этот урок посвящен цветам и формам. Красный (Red), Синий (Blue), Желтый (Yellow), Зеленый (Green). Круг (Circle), Квадрат (Square), Треугольник (Triangle). Посмотрите вокруг: какие предметы вас окружают? Какого они цвета и формы?'),
       ('Английский для самых маленьких. Урок 4', 1,
        'Сегодня мы узнаем, как называются животные на английском: Dog (собака), Cat (кошка), Cow (корова), Pig (свинья), Sheep (овца). Какие звуки они издают? Dog says "Woof", Cat says "Meow". Повторяйте вместе с нами!'),
       ('Английский для самых маленьких. Урок 5', 1,
        'В этом уроке мы изучим простые фразы для общения: "What is your name?" (Как тебя зовут?), "My name is..." (Меня зовут...), "How are you?" (Как дела?). Эти фразы помогут познакомиться с новыми друзьями.'),
       ('Английский для самых маленьких. Урок 6', 1,
        'Сегодня мы поговорим о игрушках и предметах дома: Toy (игрушка), Car (машина), Bed (кровать), Table (стол), Chair (стул). Как называется твоя любимая игрушка? Попробуй сказать это по-английски!'),
       ('Английский для самых маленьких. Урок 7', 1,
        'Мы изучим простые действия: Run (бежать), Jump (прыгать), Eat (есть), Sleep (спать). Эти глаголы можно использовать, чтобы рассказать о том, что ты делаешь каждый день.'),
       ('Английский для самых маленьких. Урок 8', 1,
        'Время суток и распорядок дня: Morning (утро), Afternoon (день), Evening (вечер), Night (ночь). "Good morning!" (Доброе утро!), "Good night!" (Спокойной ночи!). Какое сейчас время суток?'),
       ('Английский для самых маленьких. Урок 9', 1,
        'Сегодня мы изучим слова, связанные с семьей: Mother (мама), Father (папа), Brother (брат), Sister (сестра), Grandmother (бабушка), Grandfather (дедушка). Расскажи про свою семью на английском!'),
       ('Английский для самых маленьких. Урок 10', 1,
        'Повторим все, что мы выучили: приветствия, числа, цвета, формы, животных, фразы для общения, действия, время суток и семью. Попробуй рассказать небольшую историю, используя все эти слова!'),
       ('Английский для детей 5-7 лет. Урок 1', 2,
        'В этом уроке мы повторим основные приветствия: "Hello" (Привет), "Good morning" (Доброе утро), "Goodbye" (До свидания). Используйте эти фразы в реальных ситуациях.'),
       ('Английский для детей 5-7 лет. Урок 2', 2,
        'Сегодня мы изучим числа от 1 до 20. Повторяйте за мной: One, Two, Three... и так до Twenty. Сколько игрушек у тебя есть?'),
       ('Английский для детей 5-7 лет. Урок 3', 2,
        'Изучаем цвета и предметы: Red (красный), Blue (синий), Yellow (желтый), Green (зеленый). Какого цвета твоя футболка?'),
       ('Английский для детей 5-7 лет. Урок 4', 2,
        'Узнаем больше про домашних и диких животных: Dog, Cat, Elephant (слон), Lion (лев). Какое животное тебе нравится?'),
       ('Английский для детей 5-7 лет. Урок 5', 2,
        'Простые фразы для общения: "How old are you?" (Сколько тебе лет?), "I am five years old" (Мне пять лет). Ответь на этот вопрос.'),
       ('Английский для детей 5-7 лет. Урок 6', 2,
        'Изучаем названия игрушек и предметов: Ball (мяч), Doll (кукла), Car (машина). Какой у тебя любимый предмет?'),
       ('Английский для детей 5-7 лет. Урок 7', 2,
        'Сегодня будем учить глаголы действий: Walk (ходить), Run (бегать), Play (играть). Какие действия ты делаешь каждый день?'),
       ('Английский для детей 5-7 лет. Урок 8', 2,
        'Время суток и части дня: Morning, Afternoon, Evening. Что ты делаешь утром?'),
       ('Английский для детей 5-7 лет. Урок 9', 2,
        'Узнаем больше про семью: Mother, Father, Brother, Sister. Как зовут твою маму на английском?'),
       ('Английский для детей 5-7 лет. Урок 10', 2,
        'Повторение всех выученных слов: числа, цвета, предметы, животные, семья. Составь историю на английском!'),
       ('Английский для школьников. Урок 1', 3,
        'Сегодня мы узнаем больше о школьных принадлежностях: Pen (ручка), Pencil (карандаш), Book (книга), Desk (парта). Как называются предметы в твоем рюкзаке?'),
       ('Английский для школьников. Урок 2', 3,
        'Учим числа до 100: Ten (десять), Twenty (двадцать), Thirty (тридцать) и так далее. Можешь посчитать до 100?'),
       ('Английский для школьников. Урок 3', 3,
        'Изучаем дни недели и месяцы: Monday (понедельник), Tuesday (вторник)... и January (январь), February (февраль). Когда у тебя день рождения?'),
       ('Английский для школьников. Урок 4', 3,
        'Сегодня учим глаголы для школы: Study (учиться), Read (читать), Write (писать), Answer (отвечать). Что ты делаешь на уроках?'),
       ('Английский для школьников. Урок 5', 3,
        'Фразы для общения в школе: "Can I go to the toilet?" (Можно выйти в туалет?), "May I ask a question?" (Можно задать вопрос?). Попробуй использовать их в классе.'),
       ('Английский для школьников. Урок 6', 3,
        'Изучаем школьные предметы: English (английский), Math (математика), Science (наука). Какой твой любимый предмет?'),
       ('Английский для школьников. Урок 7', 3,
        'Учимся говорить о распорядке дня: "I wake up at 7 oclock" (Я просыпаюсь в 7 утра), "I go to bed at 9" (Я ложусь спать в 9). Каков твой распорядок?'),
       ('Английский для школьников. Урок 8', 3,
        'Изучаем местоимения: I (я), You (ты), He (он), She (она), We (мы). Как ты используешь их в предложениях?'),
       ('Английский для школьников. Урок 9', 3,
        'Сегодня поговорим о временах года и погоде: Spring (весна), Summer (лето), Rainy (дождливо), Sunny (солнечно). Какая погода сегодня?'),
       ('Английский для школьников. Урок 10', 3,
        'Повторение всего изученного: школьные принадлежности, дни недели, глаголы и местоимения. Попробуй рассказать о своем школьном дне на английском.'),
       ('Английский для подростков. Урок 1', 4,
        'Знакомимся с друзьями: "Whats up?" (Как дела?), "Where are you from?" (Откуда ты?). Используйте эти фразы для общения.'),
       ('Английский для подростков. Урок 2', 4,
        'Изучаем числа до 1000 и больше: "One hundred" (сто), "One thousand" (тысяча). Какое самое большое число ты можешь назвать?'),
       ('Английский для подростков. Урок 3', 4,
        'Изучаем больше прилагательных: Smart (умный), Funny (веселый), Brave (смелый), Shy (скромный). Как бы ты описал себя?'),
       ('Английский для подростков. Урок 4', 4,
        'Сегодня мы учим глаголы действий: Play (играть), Watch (смотреть), Listen (слушать), Speak (говорить). Какие действия ты любишь делать в свободное время?'),
       ('Английский для подростков. Урок 5', 4,
        'Учимся выражать мнения: "I think that..." (Я думаю, что...), "In my opinion..." (По моему мнению...). Какое твое мнение на этот счет?'),
       ('Английский для подростков. Урок 6', 4,
        'Фразы для общения в социальных сетях: "Send me a message" (Отправь мне сообщение), "Like this post" (Поставь лайк этому посту).'),
       ('Английский для подростков. Урок 7', 4,
        'Изучаем больше про хобби: Sports (спорт), Music (музыка), Art (искусство), Video games (видеоигры). Чем ты увлекаешься?'),
       ('Английский для подростков. Урок 8', 4,
        'Сегодня будем говорить о планах: "I am going to..." (Я собираюсь...), "Next year, I will..." (В следующем году я...). Каковы твои планы?'),
       ('Английский для подростков. Урок 9', 4,
        'Учимся говорить о чувствах: Happy (счастлив), Sad (грустный), Excited (взволнован), Bored (скучно). Как ты себя чувствуешь?'),
       ('Английский для подростков. Урок 10', 4,
        'Повторение всех тем: знакомства, мнения, глаголы и прилагательные. Составь диалог на английском с другом.'),
       ('Английский для взрослых начинающих. Урок 1', 5,
        'Сегодня мы начнем с простых фраз: "Hello, my name is..." (Привет, меня зовут...), "How are you?" (Как дела?). Как бы ты представился?'),
       ('Английский для взрослых начинающих. Урок 2', 5,
        'Изучаем числа для повседневной жизни: от 1 до 1000. "How much does it cost?" (Сколько это стоит?) — полезная фраза для покупок.'),
       ('Английский для взрослых начинающих. Урок 3', 5,
        'Сегодня говорим о профессиях: Doctor (врач), Teacher (учитель), Engineer (инженер), Artist (художник). Какова твоя профессия?'),
       ('Английский для взрослых начинающих. Урок 4', 5,
        'Учимся описывать внешность: Tall (высокий), Short (низкий), Beautiful (красивый). Как бы ты описал себя или другого человека?'),
       ('Английский для взрослых начинающих. Урок 5', 5,
        'Сегодня учим фразы для путешествий: "Where is the nearest hotel?" (Где ближайший отель?), "I would like to order..." (Я бы хотел заказать...).'),
       ('Английский для взрослых начинающих. Урок 6', 5,
        'Изучаем базовые глаголы: Eat (есть), Drink (пить), Sleep (спать), Work (работать). Используй их, чтобы рассказать о своем дне.'),
       ('Английский для взрослых начинающих. Урок 7', 5,
        'Говорим о семье: "Do you have children?" (У тебя есть дети?), "I have two children" (У меня двое детей).'),
       ('Английский для взрослых начинающих. Урок 8', 5,
        'Сегодня будем говорить о еде: "I like pasta" (Я люблю пасту), "Can I have the menu, please?" (Можно мне меню, пожалуйста?).'),
       ('Английский для взрослых начинающих. Урок 9', 5,
        'Учимся выражать предпочтения: "I prefer..." (Я предпочитаю...), "I don’t like..." (Мне не нравится...). Что ты предпочитаешь?'),
       ('Английский для взрослых начинающих. Урок 10', 5,
        'Повторение основных тем: профессии, семья, путешествия и предпочтения. Попробуй рассказать о себе на английском.');

insert
into tests (lesson_id, question_1, right_answer_1, question_2, right_answer_2, question_3, right_answer_3)
values (1, 'Hello, my name _...', 'is', 'Goodbye! _ you tomorrow!', 'See', '_ you later!', 'See'),
       (2, 'One, Two, _', 'Three', 'Five, Six, _', 'Seven', 'Nine, Ten, _', 'Eleven'),
       (3, 'Red, Blue, _', 'Green', 'The sky is _', 'blue', '_ is yellow', 'Banana'),
       (4, 'A dog says _', 'Woof', 'A cat says _', 'Meow', 'A cow says _', 'Moo'),
       (5, 'What _ your name?', 'is', 'How _ you?', 'are', '_ is my friend', 'He'),
       (6, '_ is my toy car', 'This', '_ is a doll', 'That', '_ you have a toy?', 'Do'),
       (7, 'I can _', 'run', 'She can _', 'jump', 'We can _', 'play'),
       (8, 'Good _', 'morning', '_ you sleepy?', 'Are', 'Its time to _', 'sleep'),
       (9, '_ is my mother', 'This', '_ is my father', 'That', '_ are my parents', 'They'),
       (10, 'Hello, how _ you?', 'are', 'What _ your name?', 'is', 'I _ five years old', 'am'),
       (11, 'Hello, how _ you?', 'are', 'What _ your name?', 'is', 'I _ fine, thank you', 'am'),
       (12, '_ is the number 1', 'One', '_ is the number 5', 'Five', '_ is the number 20', 'Twenty'),
       (13, 'The ball is _', 'red', 'The sky is _', 'blue', 'The sun is _', 'yellow'),
       (14, '_ is a dog', 'This', '_ is a cat', 'That', '_ are animals', 'They'),
       (15, 'How _ you?', 'are', 'I _ five years old', 'am', '_ is my friend', 'He'),
       (16, '_ is my ball', 'This', '_ is my toy car', 'That', 'Do you _ a doll?', 'have'),
       (17, 'I _ run', 'can', 'She _ jump', 'can', 'We _ play', 'can'),
       (18, 'Good _', 'morning', '_ are you?', 'How', 'Its time to _', 'sleep'),
       (19, '_ is my mother', 'This', '_ is my father', 'That', '_ are my parents', 'They'),
       (20, 'I _ five years old', 'am', 'What _ your name?', 'is', 'Hello, how _ you?', 'are'),
       (21, '_ is my pencil', 'This', '_ is my book', 'That', '_ are my school supplies', 'These'),
       (22, 'Ten, twenty, _', 'thirty', 'Forty, fifty, _', 'sixty', 'Seventy, eighty, _', 'ninety'),
       (23, 'Today is _', 'Monday', 'My birthday is in _', 'January', 'The weekend is _', 'Saturday'),
       (24, 'I can _', 'read', 'He can _', 'write', '_ can study', 'We'),
       (25, 'Can I _ to the toilet?', 'go', 'May I _ a question?', 'ask', '_ is my homework?', 'Where'),
       (26, 'My favorite subject is _', 'English', 'I like _', 'Math', '_ is fun', 'Science'),
       (27, 'I wake _ at 7 o’clock', 'up', 'I go _ bed at 9', 'to', '_ you go to school?', 'Do'),
       (28, '_ am going to school', 'I', '_ are my friends', 'They', 'He _ my brother', 'is'),
       (29, '_ is spring', 'It', 'The weather is _', 'sunny', '_ is raining', 'It'),
       (30, '_ are you?', 'How', 'I _ fine', 'am', 'He _ my friend', 'is'),
       (31, '_ are you from?', 'Where', 'What _ your name?', 'is', 'How _ you?', 'are'),
       (32, 'One hundred, two hundred, _', 'three hundred', 'Five hundred, six hundred, _', 'seven hundred',
        '_ thousand', 'One'),
       (33, 'He is very _', 'smart', 'She is very _', 'funny', 'I am very _', 'shy'),
       (34, 'I like to _ games', 'play', 'She likes to _ TV', 'watch', 'We like to _ music', 'listen'),
       (35, 'I think _ this book is great', 'that', '_ my opinion, it’s interesting', 'In', '_ is my favorite', 'This'),
       (36, 'Send me a _', 'message', '_ this post', 'Like', 'I will _ you later', 'see'),
       (37, '_ is my hobby', 'Music', 'I like _', 'sports', 'My favorite _ is painting', 'hobby'),
       (38, 'I am going _ the cinema', 'to', 'Next year I _ travel', 'will', '_ you go with me?', 'Will'),
       (39, 'I am _', 'happy', 'He is _', 'sad', 'She is _', 'excited'),
       (40, '_ are you?', 'How', 'I _ good', 'am', 'He _ my friend', 'is'),
       (41, 'Hello, my name _...', 'is', 'How _ you?', 'are', '_ you fine?', 'Are'),
       (42, '_ is the price?', 'What', '_ much does it cost?', 'How', '_ dollars?', 'Ten'),
       (43, 'I am a _', 'doctor', 'She is a _', 'teacher', 'He is an _', 'engineer'),
       (44, 'He is very _', 'tall', 'She is very _', 'beautiful', 'They are very _', 'smart'),
       (45, '_ is the nearest hotel?', 'Where', '_ I order this?', 'Can', '_ you help me?', 'Can'),
       (46, 'I like to _ food', 'eat', 'I like to _ water', 'drink', 'I want to _ now', 'sleep'),
       (47, '_ is my son', 'This', '_ is my daughter', 'That', '_ are my children', 'These'),
       (48, 'I like _', 'pasta', '_ is my favorite dish', 'Pizza', 'Can I have the _?', 'menu'),
       (49, 'I prefer _', 'tea', 'I don’t like _', 'coffee', '_ is my favorite', 'This'),
       (50, 'I _ a teacher', 'am', '_ you have children?', 'Do', 'She _ my sister', 'is');