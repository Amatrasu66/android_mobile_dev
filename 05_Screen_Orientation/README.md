# Practical 05: Portrait and Landscape Screen Orientation

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Views Activity with adaptive resource qualifiers  
**Verification:** Verified on physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Description
Demonstrates dynamic orientation detection and adaptive layouts in Android:
- `res/layout/activity_main.xml` inflates automatically when in Portrait mode.
- `res/layout-land/activity_main.xml` inflates automatically when in Landscape mode.
- Runtime verification via `Configuration.orientation`.

---

## 2. Source Code

### `MainActivity.java`
```java
package com.example.screenorientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvOrientationMessage = findViewById(R.id.tvOrientationMessage);
        TextView tvModeInfo = findViewById(R.id.tvModeInfo);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tvOrientationMessage.setText("Landscape Mode");
            tvModeInfo.setText("Current Screen Orientation: LANDSCAPE");
        } else {
            tvOrientationMessage.setText("Portrait Mode");
            tvModeInfo.setText("Current Screen Orientation: PORTRAIT");
        }
    }
}
```

---

## 3. Output Screenshots
- Portrait Mode: `Practical_Screenshots/Practical_05/P05_Portrait_Mode.png`
- Landscape Mode: `Practical_Screenshots/Practical_05/P05_Landscape_Mode.png`
