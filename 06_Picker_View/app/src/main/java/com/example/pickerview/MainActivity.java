package com.example.pickerview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = findViewById(R.id.datePicker);
        TimePicker timePicker = findViewById(R.id.timePicker);
        TextView txtResult = findViewById(R.id.txtResult);
        Button btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(v -> {
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            String formattedResult = String.format(Locale.getDefault(),
                    "Selected Date: %02d/%02d/%04d\nSelected Time: %02d:%02d",
                    day, month, year, hour, minute);
            txtResult.setText(formattedResult);
        });
    }
}
