# Practical 06: Android Options Menu Bar

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, MaterialToolbar, Material Design 3  
**Package:** `com.example.menubar`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Verification:** Installed & Verified on OnePlus CPH2661 (Android 16)

---

## 1. Project Overview
This application satisfies the Practical 06 requirements by demonstrating the complete lifecycle and interaction of an Android Options Menu:
- **XML Menu Resource (`res/menu/menu_main.xml`):** Declares items for *Home*, *Settings*, *About Application*, and *Help & Support*.
- **Menu Inflation (`onCreateOptionsMenu`):** Inflates menu resources into the action bar / overflow menu.
- **Selection Handling (`onOptionsItemSelected`):** Responds to item clicks by displaying informative Toast messages and updating a dedicated status card.

---

## 2. Source Code

### `MainActivity.java`
```java
package com.example.menubar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    private TextView tvMenuFeedback;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvMenuFeedback = findViewById(R.id.tvMenuFeedback);

        findViewById(R.id.btnOpenMenuProgrammatic).setOnClickListener(v -> {
            if (toolbar != null) toolbar.showOverflowMenu();
            else openOptionsMenu();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_home) {
            String msg = "Home Selected: Navigated to Home Dashboard";
            tvMenuFeedback.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_settings) {
            String msg = "Settings Selected: Opened System Configuration";
            tvMenuFeedback.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_about) {
            String msg = "About Selected: SCS391 Mobile App Dev Lab v1.0";
            tvMenuFeedback.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_help) {
            String msg = "Help & Support Selected: Documentation Active";
            tvMenuFeedback.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
```

### `res/menu/menu_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/menu_home"
        android:title="@string/menu_home"
        android:icon="@android:drawable/ic_menu_today"
        app:showAsAction="never"/>

    <item
        android:id="@+id/menu_settings"
        android:title="@string/menu_settings"
        android:icon="@android:drawable/ic_menu_preferences"
        app:showAsAction="never"/>

    <item
        android:id="@+id/menu_about"
        android:title="@string/menu_about"
        android:icon="@android:drawable/ic_menu_info_details"
        app:showAsAction="never"/>

    <item
        android:id="@+id/menu_help"
        android:title="@string/menu_help"
        android:icon="@android:drawable/ic_menu_help"
        app:showAsAction="never"/>

</menu>
```

---

## 3. How to Build & Install

```bash
# Build APK
./gradlew assembleDebug

# Install via ADB to physical device
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Launch
adb shell am start -n com.example.menubar/.MainActivity
```

---

## 4. Hardware Verification
- **Test Target:** OnePlus CPH2661 (Android 16, API 36)
- **Screenshots:**
  - `Practical_Screenshots/Practical_06/P06_Menu_Bar_Closed.png`
  - `Practical_Screenshots/Practical_06/P06_Menu_Bar_Open.png`
  - `Practical_Screenshots/Practical_06/P06_Menu_Item_Selected.png`
- **Result:** Successfully verified overflow menu inflation and item handling on hardware.
