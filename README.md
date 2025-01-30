### Kitaphana (Библиотека)

#### ✔ Проект: Обзор
Kitaphana — это приложение для управления библиотекой, разработанное на Java. Оно позволяет пользователям регистрироваться, входить в систему, просматривать доступные книги, брать книги на прокат и управлять своим профилем. Приложение взаимодействует с базой данных PostgreSQL для хранения и извлечения информации о пользователях и книгах.

---

#### ✘ Основные функции

##### 1. Управление пользователями
- Регистрация пользователей с указанием имени, фамилии, email, пароля и номера телефона.
- Безопасная аутентификация при входе в систему.
- Возможность смены пароля.
- Обновление профиля (имя, фамилия, номер телефона).
- Удаление пользователя.

##### 2. Управление книгами
- Просмотр всех книг и доступных книг в библиотеке.
- Возможность взять книгу на прокат.
- Автоматическое обновление статуса книги после взятия на прокат.

##### 3. Безопасность
- Хеширование паролей для обеспечения безопасности.
- Проверка уникальности email для предотвращения дублирования регистраций.
- Валидация номеров телефонов.

---

#### ✘ Структура проекта

kitaphana/
├── src/
│   ├── Main.java
│   ├── models/
│   │   ├── User.java
│   │   ├── Book.java
│   ├── Interfaces/
│   │   ├── IUserService.java
│   ├── Implementation/
│   │   ├── UserService.java
│   ├── Repository/
│   │   ├── UserRepository.java
│   │   ├── BookRepository.java
│   ├── Controller/
│   │   ├── UserController.java
├── README.md
---

#### ✘ Используемые технологии
- Java (основная логика и ООП).
- JDBC (Java Database Connectivity) для взаимодействия с базой данных.
- PostgreSQL в качестве реляционной базы данных.

---

#### ✘ Как запустить проект
1. Убедитесь, что у вас установлены Java и PostgreSQL.
2. Создайте базу данных и настройте подключение в файле конфигурации.
3. Скомпилируйте и запустите проект с помощью команды:
  
   javac src/Main.java
   java src/Main    
