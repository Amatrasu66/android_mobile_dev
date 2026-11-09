package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Target Activity for Explicit Intent Demonstration.
 * Unpacks passed extra data and presents it to the user.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvReceivedMessage = findViewById(R.id.tvReceivedMessage);
        TextView tvTimestamp = findViewById(R.id.tvTimestamp);

        // Retrieve passed extras from the invoking Intent
        Intent incomingIntent = getIntent();
        String message = incomingIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        long timestamp = incomingIntent.getLongExtra(MainActivity.EXTRA_TIMESTAMP, 0L);

        if (message != null) {
            tvReceivedMessage.setText(message);
        } else {
            tvReceivedMessage.setText("No message received");
        }

        if (timestamp > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            tvTimestamp.setText("Received at: " + sdf.format(new Date(timestamp)));
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}
