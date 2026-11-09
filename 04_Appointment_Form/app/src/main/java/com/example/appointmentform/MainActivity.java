package com.example.appointmentform;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Practical 04: Appointment Form Application
 * Course: SCS391 Mobile Application Development Lab
 *
 * Demonstrates:
 * 1. ImageButton: Interactive service switcher
 * 2. Spinner: Dropdown department selection
 * 3. DatePicker: Date selection widget
 * 4. TimePicker: Time selection widget
 * 5. ListView: Dynamic list of submitted appointments
 */
public class MainActivity extends AppCompatActivity {

    private EditText etPatientName;
    private ImageButton ibServiceIcon;
    private TextView tvSelectedService;
    private Spinner spnCategory;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private ListView lvAppointments;

    private final String[] services = {
            "General Consultation",
            "Dental Checkup",
            "Cardiology Review"
    };
    private final int[] serviceIcons = {
            android.R.drawable.ic_menu_agenda,
            android.R.drawable.ic_menu_my_calendar,
            android.R.drawable.ic_menu_add
    };
    private int currentServiceIndex = 0;

    private final ArrayList<Appointment> appointmentList = new ArrayList<>();
    private AppointmentAdapter appointmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI Components
        etPatientName = findViewById(R.id.etPatientName);
        ibServiceIcon = findViewById(R.id.ibServiceIcon);
        tvSelectedService = findViewById(R.id.tvSelectedService);
        spnCategory = findViewById(R.id.spnCategory);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        lvAppointments = findViewById(R.id.lvAppointments);

        // 1. ImageButton Setup
        ibServiceIcon.setOnClickListener(v -> {
            currentServiceIndex = (currentServiceIndex + 1) % services.length;
            tvSelectedService.setText(services[currentServiceIndex]);
            ibServiceIcon.setImageResource(serviceIcons[currentServiceIndex]);
            Toast.makeText(this, "Service: " + services[currentServiceIndex], Toast.LENGTH_SHORT).show();
        });

        // 2. Spinner Setup
        String[] categories = {
                "General Medicine",
                "Dental Surgery",
                "Cardiovascular Care",
                "Dermatology Clinic",
                "Pediatric Health"
        };
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                categories
        );
        spnCategory.setAdapter(spinnerAdapter);

        // 3. TimePicker Initial Configuration
        timePicker.setIs24HourView(false);
        timePicker.setHour(10);
        timePicker.setMinute(30);

        // 4. ListView Setup
        appointmentAdapter = new AppointmentAdapter(this, appointmentList);
        lvAppointments.setAdapter(appointmentAdapter);

        lvAppointments.setOnItemClickListener((parent, view, position, id) -> {
            Appointment selected = appointmentList.get(position);
            Toast.makeText(this, "Selected: " + selected.toString(), Toast.LENGTH_LONG).show();
        });

        // Prepopulate with one verified sample submission to demonstrate initial list state
        appointmentList.add(new Appointment(
                "Jane Doe",
                "Dental Checkup",
                "Dental Surgery",
                "2026-11-12",
                "09:15 AM"
        ));
        appointmentAdapter.notifyDataSetChanged();

        // 5. Submit Button Listener
        findViewById(R.id.btnSubmitAppointment).setOnClickListener(v -> submitAppointment());
    }

    private void submitAppointment() {
        String patientName = etPatientName.getText().toString().trim();
        if (patientName.isEmpty()) {
            etPatientName.setError("Patient name is required");
            etPatientName.requestFocus();
            Toast.makeText(this, "Please enter patient name", Toast.LENGTH_SHORT).show();
            return;
        }

        String serviceType = services[currentServiceIndex];
        String category = spnCategory.getSelectedItem().toString();

        // Read DatePicker values
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; // 0-indexed
        int year = datePicker.getYear();
        String formattedDate = String.format(Locale.getDefault(), "%04d-%02d-%02d", year, month, day);

        // Read TimePicker values
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        String amPm = (hour >= 12) ? "PM" : "AM";
        int displayHour = (hour % 12 == 0) ? 12 : (hour % 12);
        String formattedTime = String.format(Locale.getDefault(), "%02d:%02d %s", displayHour, minute, amPm);

        // Create new Appointment entity and add to live ListView
        Appointment newAppointment = new Appointment(
                patientName,
                serviceType,
                category,
                formattedDate,
                formattedTime
        );

        appointmentList.add(0, newAppointment); // Add at top of list
        appointmentAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Appointment Booked: " + patientName, Toast.LENGTH_SHORT).show();

        // Reset name field
        etPatientName.setText("");
    }
}
