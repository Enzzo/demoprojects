# HelloWorld App

## Описание
Это простое Spring Boot приложение, которое демонстрирует работу с:
- **REST API** через `@RestController`.
- **Thymeleaf** для отображения HTML-страниц.
- **Swagger UI** для автоматической документации и тестирования API.

### Основные функции:
- Веб-страница, отображающая приветственное сообщение через шаблон Thymeleaf.
- REST API с эндпоинтом `/api/hello`, возвращающим JSON с приветственным сообщением.
- Swagger UI, доступный по пути `/swagger-ui.html`, для просмотра и тестирования API.

## Технологии
- **Spring Boot**
- **Thymeleaf** — для отображения веб-страниц.
- **Swagger** (через `springdoc-openapi`) — для автоматической генерации документации API.
- **Spring Security** (будет добавлено позже).

## Инструкции по запуску

1. Клонируйте репозиторий:
   ```
   git clone <URL>
   cd <папка с проектом>
   
2. Соберите проект с помощью Maven:
	```
	mvn clean install

3. Запустите приложение:
	```
	java -jar target/springbootexample-0.0.1-SNAPSHOT.jar

4. Доступ:
- **HTML-страница:** http://localhost:8080/ — Приветственное сообщение через Thymeleaf.
- **REST API:** http://localhost:8080/api/hello — Возвращает JSON с приветственным сообщением.
- **Swagger UI:** http://localhost:8080/swagger-ui.html — Интерактивная документация для API.
