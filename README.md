# Текстовый квест "Игра Престолов"

## Описание программы

Программа представляет собой текстовый квест в мире "Игры Престолов", реализованный как веб-приложение на Java с использованием:

- **Java Servlets** - для обработки HTTP-запросов
- **JSP (JavaServer Pages)** - для отображения пользовательского интерфейса
- **JSTL (JSP Standard Tag Library)** - для логики представления
- **Maven** - для управления зависимостями и сборки проекта
- **Tomcat 9** - как сервер приложений

## Функциональные возможности

1. **Сюжетная линия**:
    - Несколько сценариев развития событий
    - Различные концовки в зависимости от выбора игрока
    - Глубина сюжета до 3 выборов

2. **Управление игрой**:
    - Выбор из двух вариантов действий
    - Система переходов между сценами
    - Определение победы/поражения

3. **Пользовательские данные**:
    - Хранение имени игрока
    - Поддержка русского и английского имен
    - Счетчик сыгранных игр

4. **Дополнительные функции**:
    - Возможность завершить сессию
    - Система логирования действий
    - Адаптивный дизайн

## Техническая архитектура
game-of-thrones-quest/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── gotquest/
│ │ │ ├── servlets/ # Сервлеты обработки запросов
│ │ │ └── model/ # Модели данных
│ │ ├── webapp/
│ │ │ ├── WEB-INF/
│ │ │ │ ├── views/ # JSP страницы
│ │ │ │ └── web.xml # Конфигурация
│ │ │ ├── css/ # Стили
│ │ │ └── images/ # Фоновые изображения
│ │ └── resources/
│ └── test/ # Юнит-тесты
├── pom.xml # Конфигурация Maven
└── README.md


