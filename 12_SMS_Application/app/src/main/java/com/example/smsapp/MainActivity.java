package com.example.smsapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 07: Send SMS in Android Studio
 * Course: SCS391 Mobile Application Development Lab
 *
 * Demonstrates:
 * 1. Validating recipient phone number and message payload.
 * 2. Invoking the default system messaging application via Intent.ACTION_SENDTO
 *    using the "smsto:" scheme.
 * 3. Prefilling the conversation thread without requesting invasive permissions
 *    or silently sending messages without user consent.
 */
public class MainActivity extends AppCompatActivity {

    private EditText etPhoneNumber;
    private EditText etMessageBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etMessageBody = findViewById(R.id.etMessageBody);

        findViewById(R.id.btnOpenSmsApp).setOnClickListener(v -> openSmsComposer());
    }

    private void openSmsComposer() {
        String phone = etPhoneNumber.getText().toString().trim();
        String message = etMessageBody.getText().toString().trim();

        // Validation
        if (phone.isEmpty()) {
            etPhoneNumber.setError("Phone number is required");
            etPhoneNumber.requestFocus();
            Toast.makeText(this, "Please enter recipient phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (message.isEmpty()) {
            etMessageBody.setError("Message body cannot be empty");
            etMessageBody.requestFocus();
            Toast.makeText(this, "Please enter message text", Toast.LENGTH_SHORT).show();
            return;
        }

        // Construct standard SMS Intent
        Uri smsUri = Uri.parse("smsto:" + Uri.encode(phone));
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, smsUri);
        smsIntent.putExtra("sms_body", message);

        try {
            startActivity(smsIntent);
            Toast.makeText(this, "Opening default SMS application...", Toast.LENGTH_SHORT).show();
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No compatible SMS messaging app found on device", Toast.LENGTH_LONG).show();
        }
    }
}
