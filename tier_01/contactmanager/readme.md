# Приложение для управления контактами

Это веб-приложение демонстрирует работу с Spring Boot, Spring Data JPA, Thymeleaf, Swagger, Liquibase, а также контейнеризацию с использованием Docker и docker-compose.

## Технологии

- **Spring Boot** – основа приложения
- **Spring Data JPA** – взаимодействие с базой данных
- **Thymeleaf** – серверный шаблонизатор для веб-интерфейса
- **Swagger (Springdoc OpenAPI)** – документация REST API
- **Liquibase** – управление миграциями БД
- **H2 Database** – для профиля dev (in-memory)
- **PostgreSQL** – для профиля prod
- **Docker, Docker Compose** – контейнеризация приложения
- **Java 17**

## Переменные окружения
В файле `.env` укажите:
- `PG_PORT` - порт (например 5432)
- `PG_DATABASE` - имя базы данных (например cmdb)
- `PG_URL` - URL базы (например postgres)
- `PG_USERNAME` - имя пользователя для подключения к PostgreSQL (например postgres)
- `PG_PASSWORD` - пароль для подключения к PostgreSQL (например postgres)
- `SPRING_PROFILES_ACTIVE` - профиль (например prod)

## Запуск
### Локально (dev-профиль)
Запустите приложение командой:
`mvn spring-boot:run -Dspring-boot.run.profiles=dev`
- h2-console доступна по адресу: `localhost:8080/h2-console`

### Через Docker Compose (prod-профиль)
Убедитесь, что файл `.env` заполнен, затем выполните:
- `mvn clean install` - для создания образа в Docker
- `docker-compose up` - для запуска контейнера

##Анализ и рекомендации

Я провёл поиск в сети по запросу «multi-stage docker build spring boot docker-compose best practices» и нашёл, что подход с использованием Maven-образа для сборки и минимального OpenJDK-образа для запуска является оптимальным и широко применяемым (см., например, рекомендации на официальном Docker блоге) . Этот подход позволяет снизить размер финального образа и повысить безопасность.

Также использование файла .env соответствует лучшим практикам по вынесению конфиденциальных данных и настройке окружения. Но в этом репозитории он включен для примера.