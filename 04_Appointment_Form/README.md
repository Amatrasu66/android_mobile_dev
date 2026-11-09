# Practical 04: Appointment Form Application

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, Material Design 3  
**Package:** `com.example.appointmentform`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Verification:** Installed & Verified on OnePlus CPH2661 (Android 16)

---

## 1. Project Overview
This application satisfies all Practical 04 requirements by demonstrating five core Android components within an Appointment Form workflow:
- **`ImageButton`:** Allows interactive toggling/selection of healthcare service types (General Consultation, Dental, Cardiology) with dynamic icon updates.
- **`Spinner`:** Dropdown selector for medical departments (General Medicine, Dental Surgery, Cardiovascular Care, Dermatology, Pediatrics).
- **`DatePicker`:** Interactive widget allowing selection of appointment year, month, and day.
- **`TimePicker`:** Interactive widget configured for hour and minute scheduling.
- **`ListView`:** Dynamic list displaying newly submitted appointments using a custom `AppointmentAdapter` and Material Cards.

---

## 2. Source Code

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
            tvSelectedService.setText(services[currentServiceIndex]);
            ibServiceIcon.setImageResource(serviceIcons[currentServiceIndex]);
            Toast.makeText(this, "Service: " + services[currentServiceIndex], Toast.LENGTH_SHORT).show();
        });

        String[] categories = {"General Medicine", "Dental Surgery", "Cardiovascular Care", "Dermatology Clinic", "Pediatric Health"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spnCategory.setAdapter(spinnerAdapter);

        appointmentAdapter = new AppointmentAdapter(this, appointmentList);
        lvAppointments.setAdapter(appointmentAdapter);

        findViewById(R.id.btnSubmitAppointment).setOnClickListener(v -> submitAppointment());
    }

    private void submitAppointment() {
        String patientName = etPatientName.getText().toString().trim();
        if (patientName.isEmpty()) {
            etPatientName.setError("Patient name is required");
            return;
        }

        String serviceType = services[currentServiceIndex];
        String category = spnCategory.getSelectedItem().toString();
        String formattedDate = String.format(Locale.getDefault(), "%04d-%02d-%02d",
                datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth());

        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        String amPm = (hour >= 12) ? "PM" : "AM";
        int displayHour = (hour % 12 == 0) ? 12 : (hour % 12);
        String formattedTime = String.format(Locale.getDefault(), "%02d:%02d %s", displayHour, minute, amPm);

        Appointment newAppointment = new Appointment(patientName, serviceType, category, formattedDate, formattedTime);
        appointmentList.add(0, newAppointment);
        appointmentAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Appointment Booked: " + patientName, Toast.LENGTH_SHORT).show();
        etPatientName.setText("");
    }
}
```

---

## 3. How to Build & Install

```bash
# Build APK
./gradlew assembleDebug

# Install via ADB to physical device
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Launch
adb shell am start -n com.example.appointmentform/.MainActivity
```

---

## 4. Hardware Verification
- **Test Target:** OnePlus CPH2661 (Android 16, API 36)
- **Screenshots:**
  - `Practical_Screenshots/Practical_04/P04_Appointment_Form.png`
  - `Practical_Screenshots/Practical_04/P04_DateTime_Selection.png`
  - `Practical_Screenshots/Practical_04/P04_Appointment_Submitted.png`
- **Result:** Successfully validated ImageButton, Spinner, DatePicker, TimePicker, and dynamic ListView on hardware.
