package com.example.crudsqlite;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etStudentId;
    private EditText etStudentName;
    private EditText etStudentEmail;
    private TextView tvRecordsHeader;
    private ListView lvStudents;

    private DatabaseHelper dbHelper;
    private List<Student> studentList;
    private List<String> displayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        studentList = new ArrayList<>();
        displayList = new ArrayList<>();

        etStudentId = findViewById(R.id.etStudentId);
        etStudentName = findViewById(R.id.etStudentName);
        etStudentEmail = findViewById(R.id.etStudentEmail);
        tvRecordsHeader = findViewById(R.id.tvRecordsHeader);
        lvStudents = findViewById(R.id.lvStudents);

        adapter = new ArrayAdapter<>(this, R.layout.item_student, R.id.tvStudentRow, displayList);
        lvStudents.setAdapter(adapter);

        findViewById(R.id.btnInsert).setOnClickListener(v -> insertRecord());
        findViewById(R.id.btnViewAll).setOnClickListener(v -> loadRecords(true));
        findViewById(R.id.btnUpdate).setOnClickListener(v -> updateRecord());
        findViewById(R.id.btnDelete).setOnClickListener(v -> deleteRecord());

        lvStudents.setOnItemClickListener((parent, view, position, id) -> {
            Student s = studentList.get(position);
            etStudentId.setText(String.valueOf(s.getId()));
            etStudentName.setText(s.getName());
            etStudentEmail.setText(s.getEmail());
        });

        loadRecords(false);
    }

    private void insertRecord() {
        String name = etStudentName.getText().toString().trim();
        String email = etStudentEmail.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Enter name and email", Toast.LENGTH_SHORT).show();
            return;
        }

        long id = dbHelper.insertStudent(name, email);
        if (id != -1) {
            Toast.makeText(this, "Record Inserted (ID: " + id + ")", Toast.LENGTH_SHORT).show();
            clearInputs();
            loadRecords(false);
        } else {
            Toast.makeText(this, "Insert failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadRecords(boolean notify) {
        studentList.clear();
        displayList.clear();
        studentList.addAll(dbHelper.getAllStudents());
        for (Student s : studentList) {
            displayList.add("ID: " + s.getId() + " | " + s.getName() + " (" + s.getEmail() + ")");
        }
        adapter.notifyDataSetChanged();
        tvRecordsHeader.setText("Stored Records (" + studentList.size() + "):");
        if (notify) {
            Toast.makeText(this, studentList.size() + " records loaded", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateRecord() {
        String idStr = etStudentId.getText().toString().trim();
        String name = etStudentName.getText().toString().trim();
        String email = etStudentEmail.getText().toString().trim();

        if (idStr.isEmpty() || name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Enter ID, name, and email to update", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idStr);
        int rows = dbHelper.updateStudent(id, name, email);
        if (rows > 0) {
            Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
            loadRecords(false);
        } else {
            Toast.makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteRecord() {
        String idStr = etStudentId.getText().toString().trim();
        if (idStr.isEmpty()) {
            Toast.makeText(this, "Enter ID to delete", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idStr);
        int rows = dbHelper.deleteStudent(id);
        if (rows > 0) {
            Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
            clearInputs();
            loadRecords(false);
        } else {
            Toast.makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearInputs() {
        etStudentId.setText("");
        etStudentName.setText("");
        etStudentEmail.setText("");
    }
}
