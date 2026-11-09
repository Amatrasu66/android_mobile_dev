package com.example.emailapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 08: Send Email in Android Studio
 * Course: SCS391 Mobile Application Development Lab
 *
 * Demonstrates:
 * 1. Validation of recipient email format, subject line, and message body.
 * 2. Privacy-first implicit Intent delegation using Intent.ACTION_SENDTO with "mailto:".
 * 3. Delegating prefilled parameters to external email clients (e.g., Gmail) via Intent.createChooser.
 * 4. Graceful handling of ActivityNotFoundException when no email app is available.
 */
public class MainActivity extends AppCompatActivity {

    private EditText etEmailTo;
    private EditText etSubject;
    private EditText etEmailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmailTo = findViewById(R.id.etEmailTo);
        etSubject = findViewById(R.id.etSubject);
        etEmailBody = findViewById(R.id.etEmailBody);

        findViewById(R.id.btnSendEmail).setOnClickListener(v -> handleSendEmail());
    }

    private void handleSendEmail() {
        String to = etEmailTo.getText().toString().trim();
        String subject = etSubject.getText().toString().trim();
        String body = etEmailBody.getText().toString().trim();

        // 1. Recipient Validation
        if (to.isEmpty()) {
            etEmailTo.setError("Recipient email cannot be empty");
            etEmailTo.requestFocus();
            Toast.makeText(this, "Please enter recipient email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(to).matches()) {
            etEmailTo.setError("Please enter a valid email address");
            etEmailTo.requestFocus();
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show();
            return;
        }

        // 2. Subject Validation
        if (subject.isEmpty()) {
            etSubject.setError("Subject line cannot be empty");
            etSubject.requestFocus();
            Toast.makeText(this, "Please enter email subject", Toast.LENGTH_SHORT).show();
            return;
        }

        // 3. Body Validation
        if (body.isEmpty()) {
            etEmailBody.setError("Email body cannot be empty");
            etEmailBody.requestFocus();
            Toast.makeText(this, "Please enter message body", Toast.LENGTH_SHORT).show();
            return;
        }

        // 4. Construct Email Intent
        // ACTION_SENDTO with mailto: ensures ONLY dedicated email clients match
        Uri mailtoUri = Uri.parse("mailto:" + Uri.encode(to));
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, mailtoUri);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        // 5. Wrap in Chooser to provide seamless user choice
        Intent chooserIntent = Intent.createChooser(emailIntent, "Send Email via:");

        try {
            startActivity(chooserIntent);
            Toast.makeText(this, "Opening email client...", Toast.LENGTH_SHORT).show();
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No compatible email client found on device", Toast.LENGTH_LONG).show();
        }
    }
}
