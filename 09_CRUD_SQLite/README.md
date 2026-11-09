# Practical 09: CRUD Operations using SQLite

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Views Activity with SQLiteOpenHelper  
**Verification:** Verified on physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Description
Demonstrates full native SQLite database operations on a Student record entity (`id`, `name`, `email`):
- **CREATE (Insert):** Adds a new student record to `StudentDB.db`.
- **READ (Select All):** Queries and displays stored records in a native `ListView`.
- **UPDATE:** Modifies an existing student record by ID.
- **DELETE:** Deletes a student record by ID.
- **Persistence:** Demonstrates persistence across app restarts.

---

## 2. Key Source Code

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
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_STUDENTS = "students";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_STUDENTS + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT NOT NULL, "
                + COL_EMAIL + " TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    public long insertStudent(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        return db.insert(TABLE_STUDENTS, null, values);
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_STUDENTS, new String[]{COL_ID, COL_NAME, COL_EMAIL},
                null, null, null, null, COL_ID + " ASC");

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(COL_EMAIL));
                list.add(new Student(id, name, email));
            }
            cursor.close();
        }
        return list;
    }

    public int updateStudent(int id, String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        return db.update(TABLE_STUDENTS, values, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public int deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_STUDENTS, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }
}
```

---

## 3. Output Screenshots
- CREATE (Insert Record): `Practical_Screenshots/Practical_09/P09_CRUD_Create.png`
- READ (View All Records): `Practical_Screenshots/Practical_09/P09_CRUD_Read.png`
- UPDATE (Modify by ID): `Practical_Screenshots/Practical_09/P09_CRUD_Update.png`
- DELETE (Delete by ID): `Practical_Screenshots/Practical_09/P09_CRUD_Delete.png`
