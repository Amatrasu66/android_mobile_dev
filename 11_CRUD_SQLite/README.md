# Practical 11: SQLite Student Records Management (CRUD Operations)

## 1. Aim
To develop a native Android application utilizing SQLite database storage via `SQLiteOpenHelper` to perform full Create, Read, Update, and Delete (CRUD) operations on student records and display them dynamically in a `ListView`.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `SQLiteOpenHelper`, `SQLiteDatabase`, `EditText`, `Button`, `ListView`, `ArrayAdapter`

## 3. Implementation Details
- `DatabaseHelper.java`: Manages the SQLite database file (`StudentDB.db`) and table `students` (`id`, `name`, `email`). Implements parameterized SQL methods: `insertStudent()`, `getAllStudents()`, `updateStudent()`, `deleteStudent()`.
- `MainActivity.java`: Connects the 4 CRUD action buttons to `DatabaseHelper` and renders results in a high-contrast native `ListView`.
