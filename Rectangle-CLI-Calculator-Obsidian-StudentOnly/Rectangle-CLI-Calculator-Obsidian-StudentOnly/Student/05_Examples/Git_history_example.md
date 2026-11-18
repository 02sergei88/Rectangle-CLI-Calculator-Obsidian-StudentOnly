
## Пример истории коммитов (10–14 дней)

### День 1 — старт проекта

1. `chore: init project structure and README`
    
    - созданы папки, добавлен базовый `README.md`, `.gitignore`
        
2. `docs: add initial technical specification (iteration 1)`
    
    - добавлено ТЗ CLI + требования
        

### День 2 — модель и тестовые расчёты

3. `feat(model): add Rectangle with area/perimeter/diagonal`
    
    - `Rectangle` + методы
        
4. `test: add basic checks for Rectangle computations`
    
    - простые тесты (JUnit) или временный “ручной тест” в main (если без JUnit)
        

### День 3 — CLI: ввод и валидация

5. `feat(cli): add input validation utilities`
    
    - `InputUtils`, разбор double, ошибки
        
6. `feat(cli): implement CLI flow (enter params -> menu -> actions)`
    
    - основной цикл CLI
        

### День 4 — CLI: улучшение UX

7. `feat(cli): add formulas to output and pause after actions`
    
    - человекочитаемый вывод + Enter-пауза
        
8. `refactor(cli): split CLI into ConsoleUI and App entrypoint`
    
    - структурирование по классам/пакетам
        

### День 5 — документация и схемы

9. `docs(uml): add activity/sequence/class diagrams (PlantUML)`
    
    - схемы логики и классов
        
10. `docs: update README with CLI run instructions`
    

- как собрать/запустить
    

---

## Итерация 2 — GUI (JavaFX)

### День 6 — каркас GUI

11. `feat(gui): add JavaFX skeleton (App + empty view)`
    

- минимальный запуск окна
    

12. `feat(gui): add main.fxml layout and controller stub`
    

- разметка + пустые обработчики
    

### День 7 — GUI: ввод параметров и валидация

13. `feat(gui): implement apply/clear actions with validation`
    

- Apply/Clear, подсветка ошибок
    

14. `refactor: extract Validation utility for GUI`
    

- вынесение в util
    

### День 8 — GUI: расчёты

15. `feat(gui): add perimeter/area/diagonal actions`
    

- три кнопки вычислений
    

16. `feat(gui): add circumscribed circle length and inscribed radius`
    

- оставшиеся вычисления + проверка квадрата
    

### День 9 — ресурсы и polish

17. `feat(gui): add app icon and fix resource layout`
    

- favicon + `resources/` структура
    

18. `ui: improve layout spacing and result formatting`
    

- формат до 2 знаков, переносы, подсказки
    

---

## Упаковка и релиз

### День 10 — запуск и сборка

19. `build: add runnable jar export notes and run scripts`
    

- `run.cmd`, инструкции запуска
    

20. `docs: update README (GUI run, jar run, troubleshooting)`
    

- типовые ошибки, как запускать
    

### День 11 — jpackage / exe

21. `build: add jpackage scripts for Windows app-image`
    

- `package.cmd` или инструкции, иконка `.ico`
    

22. `docs: add release checklist and acceptance criteria`
    

- чек-лист: jar/ exe/ git
    

### День 12 — финальная стабилизация

23. `fix: handle missing resources gracefully (icon/fxml)`
    

- защита от null, понятные ошибки
    

24. `chore(release): tag v1.0.0 and prepare release artifacts`
    

- `v1.0.0`, итоговая версия
    

---

## Как студенту писать сообщения коммитов (шаблон)

Рекомендую стиль “conventional commits” (просто и строго):

- `feat: ...` — новая функциональность
    
- `fix: ...` — исправление
    
- `refactor: ...` — рефакторинг без изменения поведения
    
- `docs: ...` — документация/схемы
    
- `build: ...` — сборка, упаковка, скрипты
    
- `chore: ...` — сервисное (gitignore, форматирование и т.п.)
    
- `test: ...` — тесты
    

---

## Красные флажки (что выглядит “нечестно”)

- 1–3 коммита на весь проект
    
- все коммиты в один день/час
    
- сообщения вида `update`, `fix`, `final`, `123`
    
- один коммит на 50 файлов без логики (“залил всё”)
    

---

Если хочешь, я сделаю это **как готовый шаблон для студентов**:

1. таблица “День → цель → список коммитов”,
    
2. и отдельный “чек-лист перед пушем” (ветки, PR, теги релиза).

