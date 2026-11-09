# Practical 05: Portrait and Landscape Screen Orientation

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, Material Design 3  
**Package:** `com.example.screenorientation`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Verification:** Installed & Verified on OnePlus CPH2661 (Android 16)

---

## 1. Project Overview
This application demonstrates runtime detection and responsive layout handling for both **Portrait** and **Landscape** device orientations:
- **Orientation Detection:** Detects `Configuration.ORIENTATION_PORTRAIT` versus `Configuration.ORIENTATION_LANDSCAPE` using `getResources().getConfiguration().orientation`.
- **Adaptive Layout Resources:**
  - `res/layout/activity_main.xml`: Vertical card arrangement optimized for portrait viewports.
  - `res/layout-land/activity_main.xml`: Two-column horizontal card arrangement optimized for landscape viewports.
- **Hardware Verification:** Tested across both 1240x2772 (Portrait) and 2772x1240 (Landscape) on physical hardware.

---

## 2. Source Code

### `MainActivity.java`
```java
package com.example.screenorientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvOrientationMessage;
    private TextView tvDimensions;
    private TextView tvModeBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOrientationMessage = findViewById(R.id.tvOrientationMessage);
        tvDimensions = findViewById(R.id.tvDimensions);
        tvModeBadge = findViewById(R.id.tvModeBadge);

        updateOrientationDetails();
        findViewById(R.id.btnRefresh).setOnClickListener(v -> {
            updateOrientationDetails();
            Toast.makeText(this, "Orientation refreshed!", Toast.LENGTH_SHORT).show();
        });
    }

    private void updateOrientationDetails() {
        int orientation = getResources().getConfiguration().orientation;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        int density = metrics.densityDpi;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tvOrientationMessage.setText(R.string.msg_landscape);
            tvModeBadge.setText("LANDSCAPE MODE");
            tvDimensions.setText(String.format("Dimensions: %d x %d px | %d dpi (Wide)", width, height, density));
        } else {
            tvOrientationMessage.setText(R.string.msg_portrait);
            tvModeBadge.setText("PORTRAIT MODE");
            tvDimensions.setText(String.format("Dimensions: %d x %d px | %d dpi (Tall)", width, height, density));
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateOrientationDetails();
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
adb shell am start -n com.example.screenorientation/.MainActivity
```

---

## 4. Hardware Verification
- **Test Target:** OnePlus CPH2661 (Android 16, API 36)
- **Screenshots:**
  - `Practical_Screenshots/Practical_05/P05_Portrait_Mode.png` (1240 x 2772 px)
  - `Practical_Screenshots/Practical_05/P05_Landscape_Mode.png` (2772 x 1240 px)
- **Result:** Both orientations verified with adaptive layout resource loading.
