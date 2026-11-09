# Practical 07: Send SMS in Android Studio

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Views Activity with Intent Delegation  
**Verification:** Verified on physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Description
Demonstrates validating recipient phone number and message inputs, constructing a prefilled SMS intent using `Intent.ACTION_SENDTO` with the `smsto:` scheme, and delegating message composition to the user's default messaging application without requiring invasive permissions.

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

        if (phone.isEmpty()) {
            etPhoneNumber.setError("Phone number required");
            return;
        }

        if (message.isEmpty()) {
            etMessageBody.setError("Message text required");
            return;
        }

        Uri smsUri = Uri.parse("smsto:" + Uri.encode(phone));
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, smsUri);
        smsIntent.putExtra("sms_body", message);

        try {
            startActivity(smsIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No SMS app found", Toast.LENGTH_SHORT).show();
        }
    }
}
```

---

## 3. Output Screenshots
- SMS Input Form: `Practical_Screenshots/Practical_07/P07_SMS_Form.png`
- Prefilled Messaging App: `Practical_Screenshots/Practical_07/P07_SMS_Prefilled_App.png`
