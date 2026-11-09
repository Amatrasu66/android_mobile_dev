# Practical 03: Intent Demonstration (Explicit & Implicit)

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Views Activity  
**Verification:** Verified on physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Description
Demonstrates the fundamental uses of Android Intents:
1. **Explicit Intent:** Navigating from `MainActivity` to `SecondActivity` and passing a string payload via `intent.putExtra()`.
2. **Implicit Intent:** Launching external Android system components (`ACTION_VIEW` for web browser, `ACTION_DIAL` for phone dialer).

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etMessage = findViewById(R.id.etMessage);

        findViewById(R.id.btnLaunchExplicit).setOnClickListener(v -> {
            String message = etMessage.getText().toString().trim();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        });

        findViewById(R.id.btnOpenWeb).setOnClickListener(v -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"));
            try {
                startActivity(webIntent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Browser unavailable", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnOpenDialer).setOnClickListener(v -> {
            Intent dialerIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"));
            try {
                startActivity(dialerIntent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Dialer unavailable", Toast.LENGTH_SHORT).show();
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

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvReceivedMessage = findViewById(R.id.tvReceivedMessage);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if (message != null && !message.isEmpty()) {
            tvReceivedMessage.setText(message);
        } else {
            tvReceivedMessage.setText("No message received");
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}
```

---

## 3. Output Screenshots
- Main Screen: `Practical_Screenshots/Practical_03/P03_Main_Screen.png`
- Explicit Intent Destination: `Practical_Screenshots/Practical_03/P03_Explicit_Intent.png`
- Implicit Intent Result: `Practical_Screenshots/Practical_03/P03_Implicit_Intent.png`
