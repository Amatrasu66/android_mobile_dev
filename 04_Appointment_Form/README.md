# Practical 04: Appointment Form Application

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Views Activity  
**Verification:** Verified on physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Description
Demonstrates essential interactive Android UI widgets:
- **ImageButton:** Cycles medical service types and updates visual icon.
- **Spinner:** Dropdown selection for hospital departments.
- **DatePicker:** Date selection widget.
- **TimePicker:** Time selection widget.
- **ListView:** Dynamic list displaying submitted patient appointments.

---

## 2. Key Code Implementation

### `MainActivity.java`
```java
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

public class MainActivity extends AppCompatActivity {

    private EditText etPatientName;
    private ImageButton ibServiceIcon;
    private TextView tvSelectedService;
    private Spinner spnCategory;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private ListView lvAppointments;

    private final String[] services = {"General Consultation", "Dental Checkup", "Cardiology Review"};
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

        etPatientName = findViewById(R.id.etPatientName);
        ibServiceIcon = findViewById(R.id.ibServiceIcon);
        tvSelectedService = findViewById(R.id.tvSelectedService);
        spnCategory = findViewById(R.id.spnCategory);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        lvAppointments = findViewById(R.id.lvAppointments);

        ibServiceIcon.setOnClickListener(v -> {
            currentServiceIndex = (currentServiceIndex + 1) % services.length;
            tvSelectedService.setText(services[currentServiceIndex] + " (Tap icon to change)");
            ibServiceIcon.setImageResource(serviceIcons[currentServiceIndex]);
        });

        String[] categories = {"General Medicine", "Dental Surgery", "Cardiovascular Care", "Pediatrics"};
        spnCategory.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories));

        appointmentAdapter = new AppointmentAdapter(this, appointmentList);
        lvAppointments.setAdapter(appointmentAdapter);

        findViewById(R.id.btnSubmitAppointment).setOnClickListener(v -> {
            String name = etPatientName.getText().toString().trim();
            if (name.isEmpty()) {
                etPatientName.setError("Name required");
                return;
            }

            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            String dateStr = String.format(Locale.getDefault(), "%04d-%02d-%02d", year, month, day);
            String timeStr = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);

            Appointment appt = new Appointment(name, services[currentServiceIndex],
                    spnCategory.getSelectedItem().toString(), dateStr + " at " + timeStr);
            appointmentList.add(0, appt);
            appointmentAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Appointment Booked!", Toast.LENGTH_SHORT).show();
        });
    }
}
```

---

## 3. Output Screenshots
- Form Screen: `Practical_Screenshots/Practical_04/P04_Appointment_Form.png`
- Service & DateTime Selection: `Practical_Screenshots/Practical_04/P04_DateTime_Selection.png`
- Submitted Appointment in ListView: `Practical_Screenshots/Practical_04/P04_Appointment_Submitted.png`
