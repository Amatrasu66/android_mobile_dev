# Practical 02: Hello World Application in Java

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, Material Design 3  
**Package:** `com.example.helloworld`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Verification:** Installed & Verified on OnePlus CPH2661 (Android 16)

---

## 1. Project Overview
This project satisfies the Practical 02 requirements by implementing a native Android application in Java displaying **"Hello World!"** inside a centered Material Design Card with clear typography and academic headers.

---

## 2. Source Code

### `MainActivity.java`
```java
package com.example.helloworld;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHelloWorld = findViewById(R.id.tvHelloWorld);
        tvHelloWorld.setText(R.string.hello_world);
    }
}
```

### `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/background"
    android:padding="24dp">

    <com.google.android.material.card.MaterialCardView
        android:id="@+id/cardContainer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardCornerRadius="16dp"
        app:cardElevation="6dp"
        app:cardBackgroundColor="@color/surface"
        app:strokeWidth="1dp"
        app:strokeColor="#DADCE0"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:gravity="center"
            android:padding="32dp">

            <TextView
                android:id="@+id/tvLabHeader"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/lab_header"
                android:textColor="@color/primary"
                android:textSize="14sp"
                android:textStyle="bold"
                android:layout_marginBottom="8dp"/>

            <TextView
                android:id="@+id/tvHelloWorld"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/hello_world"
                android:textColor="@color/text_primary"
                android:textSize="32sp"
                android:textStyle="bold"
                android:layout_marginBottom="8dp"/>

            <TextView
                android:id="@+id/tvSubtext"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/welcome_subtext"
                android:textColor="@color/text_secondary"
                android:textSize="15sp"
                android:layout_marginBottom="20dp"/>

            <TextView
                android:id="@+id/tvDeviceInfo"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/device_info"
                android:textColor="@color/primary"
                android:background="@color/accent_chip"
                android:paddingHorizontal="14dp"
                android:paddingVertical="6dp"
                android:textSize="12sp"
                android:textStyle="bold"/>

        </LinearLayout>
    </com.google.android.material.card.MaterialCardView>
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

## 3. How to Build & Install

```bash
# Build APK
./gradlew assembleDebug

# Install via ADB to physical device
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Launch
adb shell am start -n com.example.helloworld/.MainActivity
```

---

## 4. Hardware Verification
- **Test Target:** OnePlus CPH2661 (Android 16, API 36)
- **Screenshot Evidence:** `Practical_Screenshots/Practical_02/P02_Hello_World.png`
- **Result:** Successfully rendered centered Material card displaying "Hello World!".
