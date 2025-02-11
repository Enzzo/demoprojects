# Project 1.1 - Minimal Monolithic Application

## Описание
Данное приложение демонстрирует базовый функционал Spring Boot с минимальным набором технологий:
- Spring Web (контроллеры, REST API)
- Spring Data JPA (работа с базой данных)
- Spring Security (базовая конфигурация)
- Thymeleaf (динамическое отображение данных)
- Swagger (документация API)
- Docker & Docker Compose (сборка и запуск в контейнере)

## Используемые технологии
- **Java 17**
- **Maven**
- **Spring Boot**
- **Spring Data JPA** (с PostgreSQL для prod и H2 для dev)
- **Spring Security**
- **Thymeleaf**
- **Swagger (springdoc-openapi)**
- **Docker и Docker Compose**
- **YAML-конфигурации**

## Конфигурация
- **Профили:**  
  - **dev:** база данных H2  
  - **prod:** база данных PostgreSQL  
- Чувствительные данные вынесены в переменные окружения (.env и docker-compose)

## Запуск
### Локально
mvn spring-boot:run
### Docker

docker-compose up --build

### Резюме
- Приложение доступно по адресу: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- H2-console (при dev-профиле): http://localhost:8080/h2-console