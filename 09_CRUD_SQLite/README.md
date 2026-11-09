# Practical 09: CRUD Operations using SQLite

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, Material Design 3, SQLiteOpenHelper  
**Package:** `com.example.crudsqlite`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Verification Device:** Physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Project Overview
This application satisfies all requirements of Practical 09 by implementing a full native SQLite Student Record Management application:
- **CREATE (Insert):** Inserts student records (`name`, `email`, `course`) into SQLite database `StudentDB.db` via parameterized `ContentValues`, auto-generating primary keys.
- **READ (Select):** Queries all stored student records using `db.query()` and renders them dynamically in a custom `ListView` using `StudentAdapter`.
- **UPDATE:** Modifies existing student details matching a user-specified record ID with input validation and feedback on rows affected.
- **DELETE:** Removes a student record by ID, ensuring proper validation and database state reconciliation.
- **Persistence:** Demonstrates permanent storage inside the app's internal SQLite database sandbox (`/data/data/com.example.crudsqlite/databases/StudentDB.db`), persisting data across app recreation and process death.

---

## 2. Database Schema
- **Database:** `StudentDB.db` (Version 1)
- **Table:** `students`
- **Columns:**
  - `id` INTEGER PRIMARY KEY AUTOINCREMENT
  - `name` TEXT NOT NULL
  - `email` TEXT NOT NULL
  - `course` TEXT NOT NULL

---

## 3. Source Code

### `DatabaseHelper.java`
```java
package com.example.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_STUDENTS = "students";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";
    public static final String COL_COURSE = "course";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_STUDENTS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, "
            + COL_EMAIL + " TEXT NOT NULL, "
            + COL_COURSE + " TEXT NOT NULL"
            + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    public long insertStudent(String name, String email, String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_COURSE, course);

        return db.insert(TABLE_STUDENTS, null, values);
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(TABLE_STUDENTS,
                    new String[]{COL_ID, COL_NAME, COL_EMAIL, COL_COURSE},
                    null, null, null, null,
                    COL_ID + " ASC");

            if (cursor != null && cursor.moveToFirst()) {
                int idIdx = cursor.getColumnIndexOrThrow(COL_ID);
                int nameIdx = cursor.getColumnIndexOrThrow(COL_NAME);
                int emailIdx = cursor.getColumnIndexOrThrow(COL_EMAIL);
                int courseIdx = cursor.getColumnIndexOrThrow(COL_COURSE);

                do {
                    int id = cursor.getInt(idIdx);
                    String name = cursor.getString(nameIdx);
                    String email = cursor.getString(emailIdx);
                    String course = cursor.getString(courseIdx);
                    studentList.add(new Student(id, name, email, course));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return studentList;
    }

    public int updateStudent(int id, String name, String email, String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_COURSE, course);

        return db.update(TABLE_STUDENTS, values, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public int deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_STUDENTS, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }
}
```

### `MainActivity.java`
```java
package com.example.crudsqlite;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etStudentId, etStudentName, etStudentEmail, etStudentCourse;
    private TextView tvStatus, tvListHeader;
    private ListView lvStudents;

    private DatabaseHelper dbHelper;
    private StudentAdapter adapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        studentList = new ArrayList<>();

        etStudentId = findViewById(R.id.etStudentId);
        etStudentName = findViewById(R.id.etStudentName);
        etStudentEmail = findViewById(R.id.etStudentEmail);
        etStudentCourse = findViewById(R.id.etStudentCourse);
        tvStatus = findViewById(R.id.tvStatus);
        tvListHeader = findViewById(R.id.tvListHeader);
        lvStudents = findViewById(R.id.lvStudents);

        adapter = new StudentAdapter(this, studentList);
        lvStudents.setAdapter(adapter);

        findViewById(R.id.btnInsert).setOnClickListener(v -> performCreate());
        findViewById(R.id.btnViewAll).setOnClickListener(v -> performRead(true));
        findViewById(R.id.btnUpdate).setOnClickListener(v -> performUpdate());
        findViewById(R.id.btnDelete).setOnClickListener(v -> performDelete());
        findViewById(R.id.btnClear).setOnClickListener(v -> clearFormFields());

        lvStudents.setOnItemClickListener((parent, view, position, id) -> {
            Student selected = studentList.get(position);
            etStudentId.setText(String.valueOf(selected.getId()));
            etStudentName.setText(selected.getName());
            etStudentEmail.setText(selected.getEmail());
            etStudentCourse.setText(selected.getCourse());

            String msg = "Loaded Record #" + selected.getId() + " into editor.";
            tvStatus.setText(msg);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        performRead(false);
    }

    private void performCreate() {
        String name = etStudentName.getText().toString().trim();
        String email = etStudentEmail.getText().toString().trim();
        String course = etStudentCourse.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || course.isEmpty()) {
            Toast.makeText(this, "Please fill in Name, Email, and Course", Toast.LENGTH_SHORT).show();
            return;
        }

        long insertedId = dbHelper.insertStudent(name, email, course);
        if (insertedId != -1) {
            tvStatus.setText("SUCCESS: Created Student Record #" + insertedId);
            clearFormFields();
            performRead(false);
        }
    }

    private void performRead(boolean showToast) {
        studentList.clear();
        studentList.addAll(dbHelper.getAllStudents());
        adapter.notifyDataSetChanged();
        tvListHeader.setText("Stored Student Records Database (" + studentList.size() + " Total)");
    }

    private void performUpdate() {
        String idStr = etStudentId.getText().toString().trim();
        if (idStr.isEmpty()) return;
        int id = Integer.parseInt(idStr);

        int rows = dbHelper.updateStudent(id,
                etStudentName.getText().toString().trim(),
                etStudentEmail.getText().toString().trim(),
                etStudentCourse.getText().toString().trim());
        if (rows > 0) {
            tvStatus.setText("SUCCESS: Updated Student Record #" + id);
            performRead(false);
        }
    }

    private void performDelete() {
        String idStr = etStudentId.getText().toString().trim();
        if (idStr.isEmpty()) return;
        int id = Integer.parseInt(idStr);

        int rows = dbHelper.deleteStudent(id);
        if (rows > 0) {
            tvStatus.setText("SUCCESS: Deleted Student Record #" + id);
            clearFormFields();
            performRead(false);
        }
    }

    private void clearFormFields() {
        etStudentId.setText("");
        etStudentName.setText("");
        etStudentEmail.setText("");
        etStudentCourse.setText("");
    }
}
```

---

## 4. Verification & Screenshots
- **Verification Hardware:** Physical OnePlus CPH2661 (Android 16, API 36, Serial `2d242b39`)
- **Execution Evidence:**
  1. `Practical_Screenshots/Practical_09/P09_CRUD_Create.png` (Record inserted and database status updated)
  2. `Practical_Screenshots/Practical_09/P09_CRUD_Read.png` (All student records listed in custom ListView cards)
  3. `Practical_Screenshots/Practical_09/P09_CRUD_Update.png` (Record #2 updated to Robert Miller with instant reflection)
  4. `Practical_Screenshots/Practical_09/P09_CRUD_Delete.png` (Record #1 deleted from SQLite database)
