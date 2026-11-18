
## 1) Общая логика приложения (Activity Diagram)

Показывает основной цикл: ввод параметров → меню → действие → снова меню / новые параметры / выход.

```plantuml
@startuml
title Rectangle CLI - общий алгоритм (Activity)

start
:Показать заголовок;

repeat
  :Запросить a (длина);
  while (a некорректно?) is (да)
    :Показать ошибку ввода;
    :Повторить ввод a;
  endwhile (нет)

  :Запросить b (ширина);
  while (b некорректно?) is (да)
    :Показать ошибку ввода;
    :Повторить ввод b;
  endwhile (нет)

  :Создать Rectangle(a, b);

  repeat
    :Показать меню;
    :Считать choice;

    if (choice == 0?) then (да)
      :Показать "Выход";
      stop
    elseif (choice == 6?) then (да)
      break
    elseif (choice в {1..5}?) then (да)
      :Вычислить выбранную характеристику;
      :Показать результат;
      :Пауза (Enter);
    else (нет)
      :Показать ошибку пункта меню;
      :Пауза (Enter);
    endif

  repeat while (true)

repeat while (true)

@enduml
```

---

## 2) Ветвление меню (внутренняя логика выбора)

Можно как отдельную activity-схему, чтобы студентам было проще “сверять switch-case”.

```plantuml
@startuml
title Rectangle CLI - логика меню (Activity)

start
:printMenu(rect);
:choice = readInt();

if (choice == 0) then (выход)
  stop
endif

if (choice == 1) then (периметр)
  :p = rect.perimeter();
  :show(p);
elseif (choice == 2) then (площадь)
  :s = rect.area();
  :show(s);
elseif (choice == 3) then (диагональ)
  :d = rect.diagonal();
  :show(d);
elseif (choice == 4) then (опис. окружность)
  :d = rect.diagonal();
  :c = PI * d;
  :show(c);
elseif (choice == 5) then (впис. окружность)
  if (a ~= b) then (не квадрат)
    :show("только для квадрата");
  else (квадрат)
    :r = a/2;
    :show(r);
  endif
elseif (choice == 6) then (новые параметры)
  :перейти к вводу a, b;
else (ошибка)
  :show("неизвестный пункт");
endif

stop
@enduml
```

---

## 3) Sequence Diagram (пользователь ↔ UI ↔ утилиты ↔ модель)

Показывает, кто кого вызывает: `ConsoleUI` управляет процессом, `InputUtils` читает/валидирует, `Rectangle` считает формулы.

```plantuml
@startuml
title Rectangle CLI - взаимодействие объектов (Sequence)

actor User
participant "ConsoleUI" as UI
participant "InputUtils" as IN
participant "Rectangle" as R

User -> UI: run()

UI -> UI: printHeader()

== Ввод параметров ==
UI -> IN: readPositiveDouble("Введите a")
IN -> User: prompt
User --> IN: ввод
IN --> UI: a

UI -> IN: readPositiveDouble("Введите b")
IN -> User: prompt
User --> IN: ввод
IN --> UI: b

UI -> R: new Rectangle(a, b)

== Цикл меню ==
loop пока не выход
  UI -> UI: printMenu(rect)
  UI -> IN: readInt("Ваш выбор")
  IN -> User: prompt
  User --> IN: choice
  IN --> UI: choice

  alt choice == 1
    UI -> R: perimeter()
    R --> UI: p
    UI -> User: вывести p
  else choice == 2
    UI -> R: area()
    R --> UI: s
    UI -> User: вывести s
  else choice == 3
    UI -> R: diagonal()
    R --> UI: d
    UI -> User: вывести d
  else choice == 4
    UI -> R: diagonal()
    R --> UI: d
    UI -> UI: c = PI*d
    UI -> User: вывести c
  else choice == 5
    UI -> UI: проверить квадрат
    alt квадрат
      UI -> R: inscribedCircleRadius()
      R --> UI: r
      UI -> User: вывести r
    else не квадрат
      UI -> User: вывести сообщение
    end
  else choice == 6
    UI -> UI: перейти к вводу новых параметров
  else choice == 0
    UI -> User: "Выход"
    break
  else
    UI -> User: "Ошибка пункта меню"
  end
end

@enduml
```

---

## 4) Диаграмма классов (Class Diagram)

Фиксируем ответственность и связи.

```plantuml
@startuml
title Rectangle CLI - диаграмма классов

package "ru.oivt.rectanglecli" {
  class App {
    +main(args: String[]): void
  }
}

package "ru.oivt.rectanglecli.ui" {
  class ConsoleUI {
    -EPS: double
    +run(): void
    -readRectangle(sc: Scanner): Rectangle
    -printMenu(rect: Rectangle): void
    -showPerimeter(sc: Scanner, rect: Rectangle): void
    -showArea(sc: Scanner, rect: Rectangle): void
    -showDiagonal(sc: Scanner, rect: Rectangle): void
    -showCircumscribedCircle(sc: Scanner, rect: Rectangle): void
    -showInscribedCircleRadius(sc: Scanner, rect: Rectangle): void
    -isSquare(rect: Rectangle): boolean
  }
}

package "ru.oivt.rectanglecli.model" {
  class Rectangle {
    -a: double
    -b: double
    +Rectangle(a: double, b: double)
    +getA(): double
    +getB(): double
    +perimeter(): double
    +area(): double
    +diagonal(): double
    +inscribedCircleRadius(): double
  }
}

package "ru.oivt.rectanglecli.util" {
  class InputUtils {
    {static} +readPositiveDouble(sc: Scanner, prompt: String): double
    {static} +readInt(sc: Scanner, prompt: String): int
    {static} +pause(sc: Scanner): void
  }
}

App ..> ConsoleUI : creates
ConsoleUI ..> Rectangle : uses
ConsoleUI ..> InputUtils : uses

@enduml
```

---

## 5) Диаграмма пакетов (Package Diagram)


```plantuml
@startuml
title Rectangle CLI - пакеты

package "ru.oivt.rectanglecli" as root
package "ru.oivt.rectanglecli.ui" as ui
package "ru.oivt.rectanglecli.model" as model
package "ru.oivt.rectanglecli.util" as util

root ..> ui
ui ..> model
ui ..> util

note right of ui
UI: ввод/вывод, меню,
управляющий цикл
end note

note right of model
Model: формулы и данные
end note

note right of util
Util: чтение/валидация ввода
end note

@enduml
```

---

## Методические указания 

### Логика работы:

1. сначала отрендерить схемы,
    
2. потом писать код «по схемам».
    

### Организация «проектной папки»

```
uml/docs/
  01-activity-main.puml
  02-activity-menu.puml
  03-sequence.puml
  04-class.puml
  05-packages.puml
```



