# book-store-app

Задание 1:
Проверить основной функционал логина (возможность залогиниться) в веб прилолжение Book Store Application - https://demoqa.com/books.
Непосредственно пользователя возможно создать для теста с использованием существующего API приложения.

Задание 2:
Проверить что список книг на странице Book Store соответствует списку книг из API ответа. Для решения задачи использовать уже существующий список книг который представлен в приложении (https://demoqa.com/books). Сравнение книг выполнять по имени (Title).

-----------------------

Technologies - Java 15, Selenium Webdriver, TestNG, Maven, Lombok, Log4j
Run from console:
mvn -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml clean test
