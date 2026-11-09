# Practical 07: Send SMS in Android Studio

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, Material Design 3  
**Package:** `com.example.smsapp`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Verification Device:** Physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Project Overview
This application satisfies all requirements of Practical 07 by demonstrating how to safely compose and dispatch SMS messages using Android's native Intent architecture:
- **Input Validation:** Enforces non-empty recipient phone number and non-empty message body with user-friendly error banners and toasts.
- **Privacy-First Intent Architecture (`Intent.ACTION_SENDTO` with `smsto:`):** Dispatches prefilled message data directly to the user's preferred messaging application without requiring intrusive `SEND_SMS` or `READ_SMS` dangerous runtime permissions.
- **User Confirmation:** Ensures no SMS is silently dispatched in the background without explicit user review and confirmation.
- **Graceful Error Handling:** Catches `ActivityNotFoundException` in scenarios where no SMS client is configured on the host device.

---

## 2. Source Code

### `MainActivity.java`
```java
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
                    android:text="@string/title_sms_app"
                    android:textColor="@color/text_primary"
                    android:textSize="24sp"
                    android:textStyle="bold"
                    android:layout_marginBottom="8dp"/>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/desc_sms_app"
                    android:textColor="@color/text_secondary"
                    android:textSize="13sp"
                    android:layout_marginBottom="20dp"/>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/label_recipient"
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
                        android:id="@+id/etPhoneNumber"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="@string/hint_recipient"
                        android:text="+919876543210"
                        android:inputType="phone"/>
                </com.google.android.material.textfield.TextInputLayout>

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/label_message"
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
                        android:id="@+id/etMessageBody"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="@string/hint_message"
                        android:text="Hello, this is a verified test SMS message from SCS391 Android Lab Practical 07."
                        android:inputType="textMultiLine"
                        android:minLines="3"
                        android:gravity="top|start"/>
                </com.google.android.material.textfield.TextInputLayout>

                <com.google.android.material.button.MaterialButton
                    android:id="@+id/btnOpenSmsApp"
                    android:layout_width="match_parent"
                    android:layout_height="56dp"
                    android:text="@string/btn_open_sms"
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
  1. `Practical_Screenshots/Practical_07/P07_SMS_Form.png` (Material form with recipient and message validation)
  2. `Practical_Screenshots/Practical_07/P07_SMS_Prefilled_App.png` (Default Messages app opened with recipient and message prefilled)
