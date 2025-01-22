# SimpleAuth App

## Описание
Простое приложение для демонстрации базовых возможностей Spring Security:
- Аутентификация с использованием in-memory данных.
- Защита страниц с авторизацией.
- Swagger для документирования API.

## Технологии
- Spring Boot
- Spring Security
- Thymeleaf
- Swagger

## Функционал
- Открытая страница (доступна всем).
- Закрытая страница (доступна только авторизованным пользователям).
- Кастомная страница логина.
- Swagger UI, доступный без авторизации.

## Запуск проекта
1. Склонируйте репозиторий.
2. Соберите проект с помощью Maven: mvn clean install
3. Запустите приложение: mvn spring-boot:run
4. Откройте браузер:
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Главная страница: [http://localhost:8080/](http://localhost:8080/)
- Закрытая страница: [http://localhost:8080/secure](http://localhost:8080/secure)

## Логины для входа
- **Admin**: admin/admin
- **User**: user/password
