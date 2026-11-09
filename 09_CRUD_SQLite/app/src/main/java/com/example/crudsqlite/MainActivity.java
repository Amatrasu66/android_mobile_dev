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

/**
 * Practical 09: CRUD Operations using SQLite in Android Studio
 * Course: SCS391 Mobile Application Development Lab
 *
 * Implements:
 * 1. CREATE: Insert a new student record into SQLite database.
 * 2. READ: Query and display all stored records in an interactive ListView.
 * 3. UPDATE: Modify an existing student record by ID.
 * 4. DELETE: Remove a student record from the database by ID.
 * 5. Input validation, error handling for nonexistent IDs, and data persistence.
 */
public class MainActivity extends AppCompatActivity {

    private EditText etStudentId;
    private EditText etStudentName;
    private EditText etStudentEmail;
    private EditText etStudentCourse;
    private TextView tvStatus;
    private TextView tvListHeader;
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

        // Initialize UI components
        etStudentId = findViewById(R.id.etStudentId);
        etStudentName = findViewById(R.id.etStudentName);
        etStudentEmail = findViewById(R.id.etStudentEmail);
        etStudentCourse = findViewById(R.id.etStudentCourse);
        tvStatus = findViewById(R.id.tvStatus);
        tvListHeader = findViewById(R.id.tvListHeader);
        lvStudents = findViewById(R.id.lvStudents);

        adapter = new StudentAdapter(this, studentList);
        lvStudents.setAdapter(adapter);

        // Action button click handlers
        findViewById(R.id.btnInsert).setOnClickListener(v -> performCreate());
        findViewById(R.id.btnViewAll).setOnClickListener(v -> performRead(true));
        findViewById(R.id.btnUpdate).setOnClickListener(v -> performUpdate());
        findViewById(R.id.btnDelete).setOnClickListener(v -> performDelete());
        findViewById(R.id.btnClear).setOnClickListener(v -> clearFormFields());

        // Item selection handler: clicking a list item prefills form fields
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

        // Load existing records from persistent SQLite database on launch
        performRead(false);
    }

    /**
     * CREATE (INSERT) Operation
     */
    private void performCreate() {
        String name = etStudentName.getText().toString().trim();
        String email = etStudentEmail.getText().toString().trim();
        String course = etStudentCourse.getText().toString().trim();

        if (name.isEmpty()) {
            etStudentName.setError("Student name is required");
            etStudentName.requestFocus();
            return;
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etStudentEmail.setError("Valid email address is required");
            etStudentEmail.requestFocus();
            return;
        }

        if (course.isEmpty()) {
            etStudentCourse.setError("Department / Course is required");
            etStudentCourse.requestFocus();
            return;
        }

        long insertedId = dbHelper.insertStudent(name, email, course);
        if (insertedId != -1) {
            String msg = "SUCCESS: Created Student Record #" + insertedId;
            tvStatus.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            clearFormFields();
            performRead(false);
        } else {
            String errorMsg = "ERROR: Failed to insert student record into SQLite.";
            tvStatus.setText(errorMsg);
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * READ Operation: Queries all stored records from SQLite.
     */
    private void performRead(boolean showToast) {
        studentList.clear();
        List<Student> fetched = dbHelper.getAllStudents();
        studentList.addAll(fetched);
        adapter.notifyDataSetChanged();

        int count = studentList.size();
        tvListHeader.setText("Stored Student Records Database (" + count + " Total)");

        if (count == 0) {
            tvStatus.setText("Database is empty. Click 'INSERT RECORD' to add records.");
            if (showToast) {
                Toast.makeText(this, "No records found in database", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (showToast) {
                String msg = "READ ALL: " + count + " records loaded from SQLite.";
                tvStatus.setText(msg);
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * UPDATE Operation
     */
    private void performUpdate() {
        String idStr = etStudentId.getText().toString().trim();
        String name = etStudentName.getText().toString().trim();
        String email = etStudentEmail.getText().toString().trim();
        String course = etStudentCourse.getText().toString().trim();

        if (idStr.isEmpty()) {
            etStudentId.setError("Enter Record ID to update");
            etStudentId.requestFocus();
            Toast.makeText(this, "Specify ID to update", Toast.LENGTH_SHORT).show();
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            etStudentId.setError("Invalid numeric ID");
            return;
        }

        if (name.isEmpty()) {
            etStudentName.setError("Student name is required");
            etStudentName.requestFocus();
            return;
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etStudentEmail.setError("Valid email is required");
            etStudentEmail.requestFocus();
            return;
        }

        if (course.isEmpty()) {
            etStudentCourse.setError("Course is required");
            etStudentCourse.requestFocus();
            return;
        }

        int rows = dbHelper.updateStudent(id, name, email, course);
        if (rows > 0) {
            String msg = "SUCCESS: Updated Student Record #" + id;
            tvStatus.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            performRead(false);
        } else {
            String notFound = "ERROR: Record #" + id + " does not exist in database.";
            tvStatus.setText(notFound);
            Toast.makeText(this, notFound, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * DELETE Operation
     */
    private void performDelete() {
        String idStr = etStudentId.getText().toString().trim();
        if (idStr.isEmpty()) {
            etStudentId.setError("Enter Record ID to delete");
            etStudentId.requestFocus();
            Toast.makeText(this, "Specify ID to delete", Toast.LENGTH_SHORT).show();
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            etStudentId.setError("Invalid numeric ID");
            return;
        }

        int rows = dbHelper.deleteStudent(id);
        if (rows > 0) {
            String msg = "SUCCESS: Deleted Student Record #" + id;
            tvStatus.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            clearFormFields();
            performRead(false);
        } else {
            String notFound = "ERROR: Record #" + id + " does not exist in database.";
            tvStatus.setText(notFound);
            Toast.makeText(this, notFound, Toast.LENGTH_LONG).show();
        }
    }

    private void clearFormFields() {
        etStudentId.setText("");
        etStudentName.setText("");
        etStudentEmail.setText("");
        etStudentCourse.setText("");
        etStudentId.setError(null);
        etStudentName.setError(null);
        etStudentEmail.setError(null);
        etStudentCourse.setError(null);
    }
}
