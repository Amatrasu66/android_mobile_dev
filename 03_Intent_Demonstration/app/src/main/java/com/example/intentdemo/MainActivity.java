package com.example.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 03: Intent Demonstration
 * Course: SCS391 Mobile Application Development Lab
 *
 * Demonstrates:
 * 1. Explicit Intent: Navigating to SecondActivity and passing a data bundle.
 * 2. Implicit Intent: Requesting system handling to open a web URL and dialer.
 */
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.intentdemo.EXTRA_MESSAGE";
    public static final String EXTRA_TIMESTAMP = "com.example.intentdemo.EXTRA_TIMESTAMP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etMessage = findViewById(R.id.etMessage);

        // 3.1 Explicit Intent Demonstration
        findViewById(R.id.btnLaunchExplicit).setOnClickListener(v -> {
            String message = etMessage.getText().toString().trim();
            if (message.isEmpty()) {
                message = "Default SCS391 Practical Payload";
            }

            Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
            explicitIntent.putExtra(EXTRA_MESSAGE, message);
            explicitIntent.putExtra(EXTRA_TIMESTAMP, System.currentTimeMillis());
            startActivity(explicitIntent);
        });

        // 3.2 Implicit Intent (Action A: Open Website)
        findViewById(R.id.btnOpenWeb).setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://developer.android.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            try {
                startActivity(webIntent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "No web browser application found", Toast.LENGTH_SHORT).show();
            }
        });

        // 3.2 Implicit Intent (Action B: Open Phone Dialer)
        findViewById(R.id.btnOpenDialer).setOnClickListener(v -> {
            Uri phoneUri = Uri.parse("tel:9876543210");
            Intent dialerIntent = new Intent(Intent.ACTION_DIAL, phoneUri);
            try {
                startActivity(dialerIntent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "No phone dialer application found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
