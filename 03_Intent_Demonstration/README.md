# Practical 03: Intent Demonstration (Explicit & Implicit)

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, Material Design 3  
**Package:** `com.example.intentdemo`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Verification:** Installed & Verified on OnePlus CPH2661 (Android 16)

---

## 1. Project Overview
This project demonstrates both core types of Android Intents:
1. **Explicit Intent:** Direct navigation from `MainActivity` to `SecondActivity`, passing string and timestamp payload data via Intent extras (`putExtra`).
2. **Implicit Intent:** Delegating actions to external system apps:
   - Action A: View URL (`Intent.ACTION_VIEW` with `https://developer.android.com`) in the system browser.
   - Action B: Dial Number (`Intent.ACTION_DIAL` with `tel:9876543210`) in the native phone dialer.

---

## 2. Source Code

### `MainActivity.java`
```java
package com.example.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.intentdemo.EXTRA_MESSAGE";
    public static final String EXTRA_TIMESTAMP = "com.example.intentdemo.EXTRA_TIMESTAMP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etMessage = findViewById(R.id.etMessage);

        // 3.1 Explicit Intent
        findViewById(R.id.btnLaunchExplicit).setOnClickListener(v -> {
            String message = etMessage.getText().toString().trim();
            if (message.isEmpty()) message = "Default SCS391 Practical Payload";

            Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
            explicitIntent.putExtra(EXTRA_MESSAGE, message);
            explicitIntent.putExtra(EXTRA_TIMESTAMP, System.currentTimeMillis());
            startActivity(explicitIntent);
        });

        // 3.2 Implicit Intent - Web Browser
        findViewById(R.id.btnOpenWeb).setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://developer.android.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            try {
                startActivity(webIntent);
            } catch (Exception e) {
                Toast.makeText(this, "No browser found", Toast.LENGTH_SHORT).show();
            }
        });

        // 3.2 Implicit Intent - Phone Dialer
        findViewById(R.id.btnOpenDialer).setOnClickListener(v -> {
            Uri phoneUri = Uri.parse("tel:9876543210");
            Intent dialerIntent = new Intent(Intent.ACTION_DIAL, phoneUri);
            try {
                startActivity(dialerIntent);
            } catch (Exception e) {
                Toast.makeText(this, "No dialer found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

### `SecondActivity.java`
```java
package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvReceivedMessage = findViewById(R.id.tvReceivedMessage);
        TextView tvTimestamp = findViewById(R.id.tvTimestamp);

        Intent incomingIntent = getIntent();
        String message = incomingIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        long timestamp = incomingIntent.getLongExtra(MainActivity.EXTRA_TIMESTAMP, 0L);

        if (message != null) {
            tvReceivedMessage.setText(message);
        }
        if (timestamp > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            tvTimestamp.setText("Received at: " + sdf.format(new Date(timestamp)));
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
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
adb shell am start -n com.example.intentdemo/.MainActivity
```

---

## 4. Hardware Verification
- **Test Target:** OnePlus CPH2661 (Android 16, API 36)
- **Screenshots:**
  - `Practical_Screenshots/Practical_03/P03_Main_Screen.png`
  - `Practical_Screenshots/Practical_03/P03_Explicit_Intent_Result.png`
  - `Practical_Screenshots/Practical_03/P03_Implicit_Intent_Dialer.png`
  - `Practical_Screenshots/Practical_03/P03_Implicit_Intent_Web.png`
- **Result:** Both Explicit and Implicit Intents executed and verified on hardware.
