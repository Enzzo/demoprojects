# Система управления задачами

## Описание
Приложение демонстрирует базовую работу с:
- Spring Boot (последняя версия)
- Spring Data JPA
- Thymeleaf для серверной отрисовки шаблонов
- Swagger для документирования API
- Профили dev и prod:
  - **dev:** Используется H2 база данных (in-memory)
  - **prod:** Используется PostgreSQL, параметры подключения считываются из переменных окружения (.env)
- Docker, Docker Compose с многослойной сборкой образа

## Переменные окружения
В файле `.env` укажите:
- `PG_DATABASE` - имя базы данных
- `PG_USERNAME` - имя пользователя для подключения к PostgreSQL
- `PG_PASSWORD` - пароль для подключения к PostgreSQL

## Запуск
### Локально (dev-профиль)
Запустите приложение командой:
`mvn spring-boot:run -Dspring-boot.run.profiles=dev`
- h2-console доступна по адресу: `localhost:8080/h2-console`

### Через Docker Compose (prod-профиль)
Убедитесь, что файл `.env` заполнен, затем выполните:
- `mvn clean install` - для создания образа в Docker
- `docker-compose up` - для запуска контейнера
