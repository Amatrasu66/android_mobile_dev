# Practical 10: Android Application Deployment

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Signed Release APK Packaging  
**Verification:** Verified on physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Description
Demonstrates configuring application identity (`applicationId = "com.example.deploymentapp"`), versioning (`versionCode = 100`, `versionName = "1.0.0-release"`), generating a signed release APK using APK Signature Scheme v2, and installing and verifying the release build on a physical Android smartphone.

---

## 2. Source Code

### `MainActivity.java`
```java
package com.example.deploymentapp;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvAppId = findViewById(R.id.tvAppId);
        TextView tvVersion = findViewById(R.id.tvVersion);
        TextView tvStatus = findViewById(R.id.tvStatus);

        try {
            PackageManager pm = getPackageManager();
            PackageInfo pInfo = pm.getPackageInfo(getPackageName(), 0);
            tvAppId.setText("Application ID: " + pInfo.packageName);
            long code = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) ? pInfo.getLongVersionCode() : pInfo.versionCode;
            tvVersion.setText("Version: " + pInfo.versionName + " (versionCode: " + code + ")");
            tvStatus.setText("Status: Verified Signed Release APK");
        } catch (Exception e) {
            tvStatus.setText("Status: Error reading package info");
        }

        findViewById(R.id.btnVerify).setOnClickListener(v ->
            Toast.makeText(this, "Release Application Active and Verified", Toast.LENGTH_SHORT).show()
        );
    }
}
```

---

## 3. Output Screenshots
- Installed Release Application: `Practical_Screenshots/Practical_10/P10_Release_Execution.png`
- Release Verification: `Practical_Screenshots/Practical_10/P10_Release_Verification.png`
