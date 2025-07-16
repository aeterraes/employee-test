# employee-test

## Пример консольного вывода

*Пример поиска сотрудника по ID*

Hibernate: SELECT * FROM employee WHERE id = ?

Найден: Иван Иванов

*Пример группировки по имени*

Hibernate: SELECT first_name, COUNT(*) FROM employee GROUP BY first_name

Имя: Елизавета, Количество: 1

Имя: Иван, Количество: 1

Имя: Роман, Количество: 1

*Пример поиска по диапазону дат рождения*

Hibernate: SELECT * FROM employee WHERE birth_date BETWEEN ? AND ?

Иван Иванов — 2001-01-01

Елизавета Васильева — 2002-02-02

Роман Петров — 2003-03-03
