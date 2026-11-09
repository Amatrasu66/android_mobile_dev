# Practical 06: Android Options Menu Bar

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Views Activity with Options Menu  
**Verification:** Verified on physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Description
Demonstrates implementing an Android Options Menu using a native Toolbar, inflating menu items from XML (`res/menu/menu_main.xml`), and responding to item selection events with real-time feedback.

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
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView tvMenuFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMenuFeedback = findViewById(R.id.tvMenuFeedback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String message;

        if (id == R.id.menu_home) {
            message = "Selected: Home";
        } else if (id == R.id.menu_settings) {
            message = "Selected: Settings";
        } else if (id == R.id.menu_about) {
            message = "Selected: About";
        } else if (id == R.id.menu_help) {
            message = "Selected: Help";
        } else {
            return super.onOptionsItemSelected(item);
        }

        tvMenuFeedback.setText(message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        return true;
    }
}
```

---

## 3. Output Screenshots
- Main Screen (Menu Closed): `Practical_Screenshots/Practical_06/P06_Menu_Bar_Closed.png`
- Options Menu Open: `Practical_Screenshots/Practical_06/P06_Menu_Bar_Open.png`
- Option Selected (Feedback): `Practical_Screenshots/Practical_06/P06_Menu_Item_Selected.png`
