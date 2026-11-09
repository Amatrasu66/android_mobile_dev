# Practical 08: Send Email in Android Studio

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, Material Design 3  
**Package:** `com.example.emailapp`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Verification Device:** Physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Project Overview
This application satisfies all requirements of Practical 08 by demonstrating how to compose and dispatch email messages using Android's native Intent architecture:
- **Input Validation:** Enforces strict validation for recipient email syntax (using `android.util.Patterns.EMAIL_ADDRESS`), subject line, and message body.
- **Specific Email Delegation (`Intent.ACTION_SENDTO` with `mailto:`):** Configures an explicit email URI scheme so that only compliant email clients (such as Gmail or Outlook) are invoked, preventing inappropriate sharing targets (Bluetooth, messaging apps, etc.) from intercepting the request.
- **System Chooser (`Intent.createChooser`):** Wraps the intent inside a system chooser dialog, giving the user total autonomy over which email client to launch.
- **Defensive Exception Handling:** Catches `ActivityNotFoundException` to cleanly alert the user if no email client is configured on the device.
- **Zero Privacy Violation:** Does not send background emails or request sensitive email account credentials.

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

/**
 * Practical 08: Send Email in Android Studio
 * Course: SCS391 Mobile Application Development Lab
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
        Uri mailtoUri = Uri.parse("mailto:" + Uri.encode(to));
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, mailtoUri);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        // 5. Wrap in Chooser
        Intent chooserIntent = Intent.createChooser(emailIntent, "Send Email via:");

        try {
            startActivity(chooserIntent);
            Toast.makeText(this, "Opening email client...", Toast.LENGTH_SHORT).show();
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No compatible email client found on device", Toast.LENGTH_LONG).show();
        }
    }
}
```

### `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/background"
    android:fillViewport="true">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="20dp"
        android:gravity="center">

        <com.google.android.material.card.MaterialCardView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:cardCornerRadius="16dp"
            app:cardElevation="4dp"
            app:cardBackgroundColor="@color/surface"
            app:strokeWidth="1dp"
            app:strokeColor="@color/stroke_color">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="24dp">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/lab_header"
                    android:textColor="@color/primary"
                    android:textSize="13sp"
                    android:textStyle="bold"
                    android:letterSpacing="0.05"
                    android:layout_marginBottom="4dp"/>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/title_email_app"
                    android:textColor="@color/text_primary"
                    android:textSize="24sp"
                    android:textStyle="bold"
                    android:layout_marginBottom="8dp"/>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/desc_email_app"
                    android:textColor="@color/text_secondary"
                    android:textSize="13sp"
                    android:layout_marginBottom="20dp"/>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/label_recipient_email"
                    android:textColor="@color/text_primary"
                    android:textSize="14sp"
                    android:textStyle="bold"
                    android:layout_marginBottom="6dp"/>

                <com.google.android.material.textfield.TextInputLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="16dp"
                    style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

                    <com.google.android.material.textfield.TextInputEditText
                        android:id="@+id/etEmailTo"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="@string/hint_recipient_email"
                        android:text="alex.johnson@university.edu"
                        android:inputType="textEmailAddress"/>
                </com.google.android.material.textfield.TextInputLayout>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/label_subject"
                    android:textColor="@color/text_primary"
                    android:textSize="14sp"
                    android:textStyle="bold"
                    android:layout_marginBottom="6dp"/>

                <com.google.android.material.textfield.TextInputLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="16dp"
                    style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

                    <com.google.android.material.textfield.TextInputEditText
                        android:id="@+id/etSubject"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="@string/hint_subject"
                        android:text="SCS391 Practical 08 Email Submission"
                        android:inputType="text"/>
                </com.google.android.material.textfield.TextInputLayout>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/label_message_body"
                    android:textColor="@color/text_primary"
                    android:textSize="14sp"
                    android:textStyle="bold"
                    android:layout_marginBottom="6dp"/>

                <com.google.android.material.textfield.TextInputLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="24dp"
                    style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

                    <com.google.android.material.textfield.TextInputEditText
                        android:id="@+id/etEmailBody"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="@string/hint_message_body"
                        android:text="Dear Instructor,\n\nPlease find the attached execution details for SCS391 Mobile Application Development Lab Practical 08 demonstrating Email Intent dispatch.\n\nRespectfully,\nAlex Johnson"
                        android:inputType="textMultiLine"
                        android:minLines="4"
                        android:gravity="top|start"/>
                </com.google.android.material.textfield.TextInputLayout>

                <com.google.android.material.button.MaterialButton
                    android:id="@+id/btnSendEmail"
                    android:layout_width="match_parent"
                    android:layout_height="56dp"
                    android:text="@string/btn_send_email"
                    android:textSize="16sp"
                    android:textStyle="bold"
                    app:cornerRadius="12dp"
                    app:icon="@android:drawable/ic_dialog_email"
                    app:iconGravity="textStart"/>

            </LinearLayout>
        </com.google.android.material.card.MaterialCardView>
    </LinearLayout>
</ScrollView>
```

---

## 3. Verification & Screenshots
- **Verification Hardware:** Physical OnePlus CPH2661 (Android 16, API 36, Serial `2d242b39`)
- **Execution Evidence:**
  1. `Practical_Screenshots/Practical_08/P08_Email_Form.png` (Material form with recipient email, subject, and body validation)
  2. `Practical_Screenshots/Practical_08/P08_Email_Prefilled_App.png` (System intent chooser opened displaying email application targets)
