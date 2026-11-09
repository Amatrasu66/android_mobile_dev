# Practical 08: Send Email in Android Studio

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Views Activity with Intent Chooser  
**Verification:** Verified on physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Description
Demonstrates composing an email message with recipient address, subject, and message body inputs, and delegating composition to an external email client using `Intent.ACTION_SENDTO` with the `mailto:` scheme and `Intent.createChooser()`.

---

## 2. Source Code

### `MainActivity.java`
```java
package com.example.emailapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

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

        if (to.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(to).matches()) {
            etEmailTo.setError("Valid email required");
            return;
        }

        if (subject.isEmpty()) {
            etSubject.setError("Subject required");
            return;
        }

        if (body.isEmpty()) {
            etEmailBody.setError("Message body required");
            return;
        }

        Uri mailtoUri = Uri.parse("mailto:" + Uri.encode(to));
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, mailtoUri);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        Intent chooser = Intent.createChooser(emailIntent, "Send Email via:");
        try {
            startActivity(chooser);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No email client found", Toast.LENGTH_SHORT).show();
        }
    }
}
```

---

## 3. Output Screenshots
- Email Input Form: `Practical_Screenshots/Practical_08/P08_Email_Form.png`
- Prefilled Email Client Chooser: `Practical_Screenshots/Practical_08/P08_Email_Prefilled_App.png`
