package com.example.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * SQLite Database Helper for managing student records.
 * Implements native SQLiteOpenHelper for schema creation, upgrades, and CRUD operations.
 */
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

    /**
     * CREATE / INSERT Operation: Inserts a new student record.
     */
    public long insertStudent(String name, String email, String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_COURSE, course);

        return db.insert(TABLE_STUDENTS, null, values);
    }

    /**
     * READ Operation: Queries all stored student records ordered by ID descending.
     */
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

    /**
     * UPDATE Operation: Modifies an existing student record matching the given ID.
     */
    public int updateStudent(int id, String name, String email, String course) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_COURSE, course);

        return db.update(TABLE_STUDENTS, values, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }

    /**
     * DELETE Operation: Deletes the student record matching the given ID.
     */
    public int deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_STUDENTS, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }
}
