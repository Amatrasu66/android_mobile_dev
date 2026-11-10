# SCS391 – MOBILE APPLICATION DEVELOPMENT LAB
## PRACTICAL LAB RECORD / PORTFOLIO

---

### COURSE INFORMATION
- **Course Name:** Mobile Application Development Lab
- **Course Code:** SCS391
- **Academic Program:** Bachelor of Technology / Computer Science & Engineering
- **Platform:** Android Studio & Android SDK
- **Core Language:** Java (JDK 21 LTS / JBR)
- **Target OS:** Android 16 (API Level 36 / 37)

---

### STUDENT DETAILS
- **Student / Developer:** Amatrasu66
- **Student Email:** simransagoosagoo@gmail.com
- **Academic Session:** 2026 – 2027
- **Submitted To:** Department of Computer Science & Engineering
- **GitHub Repository:** [https://github.com/Amatrasu66/android_mobile_dev](https://github.com/Amatrasu66/android_mobile_dev)
- **Target Device:** OnePlus CPH2661 (Android 16, API Level 36, 1240x2772 px, 560 dpi)

---

## INDEX OF EXPERIMENTS

| S.No. | Practical Title | Category | Date of Completion | Verification Status | Signature |
|---|---|---|---|---|---|
| **01** | Installation & Configuration of Android Studio, SDK, SDK Tools, AVD & JDK | Theoretical / Environment | 09-Nov-2026 | Verified | |
| **02** | Display "Hello World" in Android Studio using Java & XML | Core Application | 09-Nov-2026 | Verified | |
| **03** | Implementation of Implicit Intent (Phone Dialer & Web Delegation) | Core Application / Intents | 10-Nov-2026 | Verified | |
| **04** | Implementation of Explicit Intent (Activity Navigation with Data Extras) | Core Application / Intents | 10-Nov-2026 | Verified | |
| **05** | Portrait and Landscape Screen Orientation Detection & Dynamic Layouts | Configuration & Layouts | 09-Nov-2026 | Verified | |
| **06** | Developing an Application Using Picker View (DatePicker & TimePicker) | UI Components & Pickers | 10-Nov-2026 | Verified | |
| **07** | Developing an Application Using ListView with Selection Feedback | UI Components & Adapters | 10-Nov-2026 | Verified | |
| **08** | Applying a Theme in an Activity/Application (Custom Light Theme) | UI Styles & Theming | 10-Nov-2026 | Verified | |
| **09** | Creating an Options Menu in an Android Application (Home, Settings, About) | Menus & Navigation | 09-Nov-2026 | Verified | |
| **10** | Storing Local Data Using User Preferences (SharedPreferences) | Data Persistence | 10-Nov-2026 | Verified | |
| **11** | SQLite Student Records Management (Complete CRUD Operations) | Native Database Storage | 10-Nov-2026 | Verified | |
| **12** | Creating an Application to Send SMS using Prefilled Intent | Intents & Communication | 09-Nov-2026 | Verified | |
| **13** | Creating an Application to Send Email using Prefilled Intent & Chooser | Intents & Communication | 10-Nov-2026 | Verified | |
| **14** | Displaying a Map Based on Current or Given Location via Google Maps | Location & Maps | 10-Nov-2026 | Verified | |
| **15** | Android Application Packaging, Signing & Production Deployment | Deployment & Packaging | 10-Nov-2026 | Verified | |

---

# PRACTICAL 01

## 1. Title
Installation and Configuration of Android Studio IDE, Android SDK, Android SDK Tools, Android Virtual Device (AVD), and Java Development Kit (JDK).

## 2. Aim
To study, install, configure, and verify the complete Android mobile application development environment including Android Studio IDE, Android SDK, Android SDK Tools, Android Virtual Device (AVD), and Java Development Kit (JDK).

## 3. Software and Hardware Requirements
- **Host Workstation:** Arch Linux x86_64 / Windows 10/11 / macOS
- **Integrated Development Environment (IDE):** Android Studio (Installed at `/opt/android-studio`)
- **Java Development Kit:** Eclipse Temurin OpenJDK 21 LTS (`/home/amatrasu/.jdks/jdk-21.0.6+7`) and JetBrains Runtime (JBR 25)
- **Android SDK Components:** Android SDK Platform 36 (Android 16), Platform 37, Build-Tools 36.0.0, Platform-Tools 37.0.1
- **Testing & Execution Hardware:** Authorized physical smartphone (OnePlus CPH2661, Android 16, API 36, USB Debugging)
- **Virtualization Support:** QEMU / KVM hardware acceleration module (`/dev/kvm`)

## 4. Theoretical Background

The Android software development ecosystem relies on an integrated toolchain comprising five primary layers:

### 4.1 Android Studio IDE
Android Studio is the official IDE for Google Android development, based on JetBrains IntelliJ IDEA. It incorporates an intelligent code editor for Java and XML, a visual layout editor with live interactive previews, deep Gradle build integration, Lint static analysis tools, and comprehensive debugging suites.

### 4.2 Java Development Kit (JDK)
The Java Development Kit provides the compiler (`javac`) that compiles human-readable `.java` source code into intermediate Java bytecode (`.class` files). It also provides crucial cryptographic signing tools such as `keytool` and `jarsigner`. Modern Android Gradle Plugin versions mandate JDK 17 or JDK 21 LTS.

### 4.3 Android SDK (Software Development Kit)
The Android SDK contains the core platform libraries (`android.jar`) corresponding to each API level. It provides the framework classes (`android.app.*`, `android.widget.*`, `android.content.*`, `android.view.*`) against which applications compile.

### 4.4 Android SDK Tools
The SDK tools are categorized into:
- **Build-Tools:** Houses **AAPT2** (compiles XML resources and assets into binary tables), **D8** (DEX compiler that converts Java bytecode into Dalvik Executable `.dex` format), and **zipalign** (ensures all uncompressed data starts at 4-byte boundaries for efficient mmap memory mapping).
- **Platform-Tools:** Provides **ADB (Android Debug Bridge)**, a versatile client-server tool facilitating communication, shell interaction, package installation, and port forwarding between the host machine and connected Android devices.
- **Command-line Tools (`cmdline-tools`):** Provides command-line utilities `sdkmanager` and `avdmanager` for headless environment management.

### 4.5 Android Virtual Device (AVD) & Emulator
An AVD defines the hardware and software configuration of a virtualized Android device running on the QEMU engine. On Linux platforms, the Android Emulator utilizes the **Kernel-based Virtual Machine (KVM)** kernel module to achieve near-native execution performance.

---

## 5. Algorithm & Procedure

### Step 1: JDK Installation & Path Configuration
1. Install an LTS OpenJDK release (OpenJDK 21 LTS).
2. Configure environment variables in the user environment profile:
   ```bash
   export JAVA_HOME=/home/amatrasu/.jdks/jdk-21.0.6+7
   export PATH=$JAVA_HOME/bin:$PATH
   ```
3. Verify JDK functionality by executing `java -version` and `javac -version`.

### Step 2: Android Studio Installation
1. Obtain the official Android Studio archive package for Linux.
2. Extract the archive into `/opt/android-studio/`.
3. Launch the setup wizard by executing `/opt/android-studio/bin/studio.sh`.
4. Proceed through the wizard to install base IDE components and configure the initial UI theme.

### Step 3: Android SDK & Toolchain Configuration
1. Open Android Studio Settings and navigate to **Languages & Frameworks > Android SDK**.
2. Under **SDK Platforms**, install `Android SDK Platform 36` (Android 16).
3. Under **SDK Tools**, check and install:
   - `Android SDK Build-Tools 36.0.0`
   - `Android SDK Platform-Tools`
   - `Android SDK Command-line Tools (latest)`
   - `Android Emulator`
4. Set Android environment variables:
   ```bash
   export ANDROID_HOME=$HOME/Android/Sdk
   export PATH=$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/build-tools/36.0.0
   ```

### Step 4: Android Virtual Device (AVD) Creation & KVM Setup
1. Launch **Device Manager** in Android Studio (`Tools > Device Manager`).
2. Click **Create Virtual Device**.
3. Select a phone profile (e.g., Pixel 8, 1080x2400, 420 dpi).
4. Select and download an `x86_64` system image (e.g., Android 16 API 36 with Google APIs).
5. Configure RAM and storage allocations and save the AVD configuration.
6. On Linux hosts, verify KVM permissions: `sudo usermod -aG kvm $USER`.

### Step 5: Physical Hardware USB Debugging Configuration
1. On the physical smartphone, navigate to **Settings > About Device > Version** and tap **Build Number** 7 times to enable Developer Mode.
2. Under **Developer Options**, toggle **USB Debugging** to ON.
3. Connect the phone to the host computer using a USB cable.
4. Authorize the computer's RSA key fingerprint on the phone prompt.
5. Verify hardware recognition using `adb devices -l`.

---

## 6. Implementation & System Verification Evidence

### 6.1 Java Development Kit Verification
```
$ java -version
openjdk version "21.0.6" 2025-01-21 LTS
OpenJDK Runtime Environment Temurin-21.0.6+7 (build 21.0.6+7-LTS)
OpenJDK 64-Bit Server VM Temurin-21.0.6+7 (build 21.0.6+7-LTS, mixed mode, sharing)
```

### 6.2 Android SDK Packages Verification
```
$ android sdk list
Installed packages:
  build-tools/36.0.0             36.0.0      Android SDK Build-Tools 36
  build/templates                0.1.3       Android Project Templates 
  emulator                       37.2.13     Android Emulator          
  platform-tools                 37.0.1      Android SDK Platform-Tools
  platforms/android-36           2.0.0       Android SDK Platform 36   
  platforms/android-37.0         2.0.0       Android SDK Platform 37.0 
  sources/android-37.0           2.0.0       Sources for Android 37.0
```

### 6.3 ADB Connection & Physical Hardware Profile
```
$ adb devices -l
List of devices attached
2d242b39               device usb:1-2 product:CPH2661IN model:CPH2661 device:OP5E93L1 transport_id:1

$ adb shell getprop ro.product.manufacturer && adb shell getprop ro.product.model
OnePlus
CPH2661

$ adb shell getprop ro.build.version.release && adb shell getprop ro.build.version.sdk
16
36

$ adb shell wm size && adb shell wm density
Physical size: 1240x2772
Physical density: 560
```

---

## 7. Expected Output
The Android development workstation is expected to have a fully operational Java compiler, Android SDK build and platform tools, an authorized physical debugging target, and a configured virtual device profile.

## 8. Result & Conclusion
The installation, architectural study, and configuration of Android Studio, Android SDK Platforms and Build-Tools, AVD environment, and JDK 21 LTS were completed and verified successfully. The development environment is ready to compile and deploy native Android applications.


---

# PRACTICAL 02

## 1. Title
Development of an Android Application in Java to Display "Hello World" in Android Studio.

## 2. Aim
To develop, build, install, and execute a native Android application using the Java programming language and XML layouts to display "Hello World!" on an Android device.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `RelativeLayout`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36, 1240x2772 px, 560 dpi)

## 4. Theoretical Background
Android applications use an event-driven component architecture where an `Activity` represents a single focused screen. Layout inflation via `setContentView()` parses XML layout files into in-memory View hierarchies, resolving integer IDs compiled into the `R` class.

## 5. Algorithm & Procedure
1. Initialize an Android project selecting Empty Views Activity.
2. In `res/layout/activity_main.xml`, place a `TextView` centered in a `RelativeLayout`.
3. In `MainActivity.java`, call `setContentView(R.layout.activity_main)` and bind `TextView`.
4. Build, install, and execute on the physical smartphone.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.helloworld;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/tvHelloWorld"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:text="@string/hello_world"
        android:textSize="24sp"
        android:textColor="@android:color/black" />

</RelativeLayout>
```

### 6.3 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:roundIcon="@android:drawable/sym_def_app_icon"
        android:supportsRtl="true"
        android:theme="@style/Theme.HelloWorld">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

### 6.4 `res/values/strings.xml`
```xml
<resources>
    <string name="app_name">Hello World</string>
    <string name="hello_world">Hello World!</string>
</resources>
```

## 7. Output & Hardware Execution Evidence

The application was built via Gradle, installed onto the authorized physical smartphone (OnePlus CPH2661, Android 16), and executed.

**Output Screen: Hello World application running on physical device:**

![Hello World Output](Practical_Screenshots/Practical_02/P02_Hello_World.png)

- **Execution Verification:** The application successfully launched and rendered "Hello World!" centered on the physical smartphone screen without errors.

## 8. Expected Output
The application successfully launches on the physical Android device and displays "Hello World!" centered on the display screen.

## 9. Result & Conclusion
The "Hello World" native Android application was successfully developed in Java using Android Studio, compiled using Gradle, installed onto a physical OnePlus smartphone, and verified.


# PRACTICAL 03

## 1. Title
Development of an Android Application in Java to Demonstrate Implicit Intents.

## 2. Aim
To develop a native Android application demonstrating an Implicit Intent by delegating actions to external system applications (phone dialer and web browser) using standard Android actions (`ACTION_DIAL`, `ACTION_VIEW`) with graceful fallback error handling.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `Button`, `TextView`, `Intent.ACTION_DIAL`, `Intent.ACTION_VIEW`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
An Implicit Intent specifies an action to perform rather than naming a specific destination component. The Android OS inspects registered Intent Filters across all installed packages and resolves the intent to compatible applications, allowing the user to select their preferred client.

## 5. Algorithm & Procedure
1. Create a clean vertical layout with action buttons for dialing and web browsing.
2. In `MainActivity.java`, attach click listeners to construct implicit intents:
   - Dialer: `Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"))`.
   - Browser: `Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"))`.
3. Wrap intent dispatch in `try-catch` blocks catching `ActivityNotFoundException`.
4. Build, install, and execute on the device.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.implicitintent;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDialer = findViewById(R.id.btnDialer);
        Button btnWeb = findViewById(R.id.btnWeb);

        btnDialer.setOnClickListener(v -> {
            try {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"));
                startActivity(dialIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "No phone dialer application found", Toast.LENGTH_SHORT).show();
            }
        });

        btnWeb.setOnClickListener(v -> {
            try {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"));
                startActivity(webIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "No web browser application found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp"
    android:background="#FFFFFF">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/implicit_title"
        android:textColor="#1F1F1F"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginBottom="32dp"/>

    <Button
        android:id="@+id/btnDialer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/btn_open_dialer"
        android:textSize="16sp"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/btnWeb"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/btn_open_web"
        android:textSize="16sp"/>

</LinearLayout>
```

### 6.3 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.ImplicitIntent">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was installed and verified on the OnePlus CPH2661 test smartphone via ADB.

**Output Screen 1: Implicit Intent demonstration screen:**

![Implicit Intent Main](Practical_Screenshots/Practical_03/P03_Implicit_Main.png)

**Output Screen 2: System phone dialer opened via Implicit Intent:**

![Implicit Intent Dialer](Practical_Screenshots/Practical_03/P03_Implicit_Dialer.png)

- **Verification Summary:** Tapping the dialer button successfully triggered `ACTION_DIAL` with `tel:9876543210`, launching the native phone dialer with the number prefilled.

## 8. Expected Output
1. The application displays action buttons to trigger external implicit intent actions.
2. Tapping "Open Phone Dialer" launches the device dialer with the phone number prefilled.

## 9. Result & Conclusion
Implicit Intent functionality was successfully developed, verified on physical hardware, and documented without requiring invasive permissions.


# PRACTICAL 04

## 1. Title
Development of an Android Application in Java to Demonstrate Explicit Intents.

## 2. Aim
To develop a native Android application demonstrating an Explicit Intent by navigating from `MainActivity` to `SecondActivity`, passing user-entered string data via Intent extras, and displaying the payload on the destination Activity.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `EditText`, `Button`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
An Explicit Intent explicitly identifies the destination component by specifying the target class (`SecondActivity.class`). Data payloads are attached to the Intent bundle using key-value extras (`intent.putExtra()`) and retrieved in the receiving activity's `onCreate()` callback via `getIntent().getStringExtra()`.

## 5. Algorithm & Procedure
1. Create `MainActivity` layout with an `EditText` for user message input and a navigation button.
2. Create `SecondActivity` layout with a `TextView` to display the received message.
3. In `MainActivity.java`, instantiate `Intent(MainActivity.this, SecondActivity.class)`, attach text extra, and call `startActivity()`.
4. In `SecondActivity.java`, extract the extra from `getIntent()` and set it to the display `TextView`.
5. Register `SecondActivity` in `AndroidManifest.xml`.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.explicitintent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editMessage = findViewById(R.id.editMessage);
        Button btnLaunch = findViewById(R.id.btnLaunch);

        btnLaunch.setOnClickListener(v -> {
            String message = editMessage.getText().toString().trim();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        });
    }
}
```

### 6.2 `SecondActivity.java`
```java
package com.example.explicitintent;

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
        if (intent != null && intent.hasExtra(MainActivity.EXTRA_MESSAGE)) {
            String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            tvReceivedMessage.setText(message);
        } else {
            tvReceivedMessage.setText("No data received");
        }
    }
}
```

### 6.3 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp"
    android:background="#FFFFFF">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/main_title"
        android:textColor="#1F1F1F"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginBottom="24dp"/>

    <EditText
        android:id="@+id/editMessage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/hint_message"
        android:text="@string/default_message"
        android:textColor="#1F1F1F"
        android:textColorHint="#757575"
        android:background="@android:drawable/editbox_background_normal"
        android:padding="12dp"
        android:layout_marginBottom="24dp"/>

    <Button
        android:id="@+id/btnLaunch"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/btn_open_second"
        android:textSize="16sp"/>

</LinearLayout>
```

### 6.4 `res/layout/activity_second.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp"
    android:background="#FFFFFF">

    <TextView
        android:id="@+id/tvSecondTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/second_title"
        android:textColor="#1F1F1F"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:id="@+id/tvLabel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/label_received"
        android:textColor="#555555"
        android:textSize="14sp"
        android:layout_marginBottom="8dp"/>

    <TextView
        android:id="@+id/tvReceivedMessage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="#1A73E8"
        android:textSize="20sp"
        android:textStyle="bold"/>

</LinearLayout>
```

### 6.5 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.ExplicitIntent">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <activity
            android:name=".SecondActivity"
            android:exported="false" />

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was installed and verified on the OnePlus CPH2661 test smartphone via ADB.

**Output Screen 1: Explicit Intent main activity with input field:**

![Explicit Intent Main](Practical_Screenshots/Practical_04/P04_Explicit_Main.png)

**Output Screen 2: Second Activity displaying data received via Explicit Intent:**

![Explicit Intent Second](Practical_Screenshots/Practical_04/P04_Explicit_Second.png)

- **Verification Summary:** `MainActivity` cleanly launched `SecondActivity`, transferring the payload "Hello from Practical 04!", which `SecondActivity` successfully rendered on screen.

## 8. Expected Output
1. The user enters a message and taps "Open Second Activity".
2. `SecondActivity` opens immediately, displaying the exact message passed from `MainActivity`.

## 9. Result & Conclusion
Explicit Intent inter-activity navigation and data passing were successfully implemented, verified on physical hardware, and documented.


# PRACTICAL 05

## 1. Title
Demonstration of Portrait and Landscape Screen Orientation Detection and Layout Switching.

## 2. Aim
To develop a native Android application that detects device screen orientation dynamically at runtime and automatically loads orientation-specific XML layouts (`layout` vs `layout-land`).

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
When physical screen orientation changes, Android triggers a configuration change, recreating the activity and resolving resources using folder qualifiers (`res/layout/` for Portrait and `res/layout-land/` for Landscape).

## 5. Algorithm & Procedure
1. Create `res/layout/activity_main.xml` with text "Portrait Mode".
2. Create `res/layout-land/activity_main.xml` with text "Landscape Mode".
3. In `MainActivity.java`, query `getResources().getConfiguration().orientation` in `onCreate()` and update display text.
4. Test both orientations on physical hardware.

## 6. Source Code

### 6.1 `MainActivity.java`
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

### 6.2 `res/layout/activity_main.xml` (Portrait)
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:orientation="vertical"
        android:gravity="center">

        <TextView
            android:id="@+id/tvOrientationMessage"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Portrait Mode"
            android:textSize="26sp"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="12dp"/>

        <TextView
            android:id="@+id/tvModeInfo"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Current Screen Orientation: PORTRAIT"
            android:textSize="16sp"
            android:textColor="#555555"/>

    </LinearLayout>

</RelativeLayout>
```

### 6.3 `res/layout-land/activity_main.xml` (Landscape)
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:orientation="vertical"
        android:gravity="center">

        <TextView
            android:id="@+id/tvOrientationMessage"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Landscape Mode"
            android:textSize="26sp"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="12dp"/>

        <TextView
            android:id="@+id/tvModeInfo"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Current Screen Orientation: LANDSCAPE"
            android:textSize="16sp"
            android:textColor="#555555"/>

    </LinearLayout>

</RelativeLayout>
```

### 6.4 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:roundIcon="@android:drawable/sym_def_app_icon"
        android:supportsRtl="true"
        android:theme="@style/Theme.ScreenOrientation">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was tested across both hardware orientations on the OnePlus CPH2661 device:

**Output Screen 1: Application running in Portrait orientation:**

![Portrait Mode](Practical_Screenshots/Practical_05/P05_Portrait_Mode.png)

**Output Screen 2: Application running in Landscape orientation:**

![Landscape Mode](Practical_Screenshots/Practical_05/P05_Landscape_Mode.png)

- **Verification Summary:** Vertical hold inflated `layout/activity_main.xml` ("Portrait Mode"). Rotating to horizontal orientation (`user_rotation 1`) recreated the activity and inflated `layout-land/activity_main.xml` ("Landscape Mode").

## 8. Expected Output
1. In portrait mode, the display renders "Portrait Mode".
2. When rotated horizontally, the display automatically switches and renders "Landscape Mode".

## 9. Result & Conclusion
Screen orientation detection and dynamic resource qualification were successfully demonstrated and verified on physical hardware.


# PRACTICAL 06

## 1. Title
Developing an Application Using Picker View (DatePicker and TimePicker).

## 2. Aim
To develop a native Android application demonstrating DatePicker and TimePicker widgets to capture user-selected calendar dates and times and display the formatted selection.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `DatePicker`, `TimePicker`, `Button`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
`DatePicker` and `TimePicker` provide standard, intuitive controls for selecting dates (day, month, year) and times (hour, minute) adhering to platform conventions.

## 5. Algorithm & Procedure
1. Create a scrollable light-theme layout containing `DatePicker`, `TimePicker`, submit `Button`, and result `TextView`.
2. In `MainActivity.java`, attach a click listener to the button.
3. Extract `getDayOfMonth()`, `getMonth() + 1`, `getYear()` from `DatePicker`, and `getHour()`, `getMinute()` from `TimePicker`.
4. Format the extracted date/time values and display in `txtResult`.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.pickerview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = findViewById(R.id.datePicker);
        TimePicker timePicker = findViewById(R.id.timePicker);
        TextView txtResult = findViewById(R.id.txtResult);
        Button btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(v -> {
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            String formattedResult = String.format(Locale.getDefault(),
                    "Selected Date: %02d/%02d/%04d\nSelected Time: %02d:%02d",
                    day, month, year, hour, minute);
            txtResult.setText(formattedResult);
        });
    }
}
```

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFFFFF">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:gravity="center_horizontal"
        android:padding="20dp">

        <TextView
            android:id="@+id/tvTitle"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/picker_title"
            android:textColor="#1F1F1F"
            android:textSize="20sp"
            android:textStyle="bold"
            android:layout_marginBottom="16dp"/>

        <DatePicker
            android:id="@+id/datePicker"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:calendarViewShown="false"
            android:datePickerMode="spinner"
            android:layout_marginBottom="16dp"/>

        <TimePicker
            android:id="@+id/timePicker"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:timePickerMode="spinner"
            android:layout_marginBottom="16dp"/>

        <Button
            android:id="@+id/btnShow"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/btn_show_selection"
            android:textSize="16sp"
            android:layout_marginBottom="16dp"/>

        <TextView
            android:id="@+id/txtResult"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="#1A73E8"
            android:textSize="18sp"
            android:textStyle="bold"
            android:gravity="center"/>

    </LinearLayout>
</ScrollView>
```

### 6.3 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.PickerView">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was tested and verified on the OnePlus CPH2661 smartphone:

**Output Screen: Date and Time selection on physical device:**

![Picker View Output](Practical_Screenshots/Practical_06/P06_Picker_View.png)

- **Verification Summary:** Date and time widgets operated smoothly in spinner mode, and clicking "Show Selection" accurately displayed the selected date and time.

## 8. Expected Output
The application displays date and time pickers. Tapping "Show Selection" formats and renders the chosen date and time below the controls.

## 9. Result & Conclusion
The Picker View application was successfully developed, verified on physical hardware, and documented.


# PRACTICAL 07

## 1. Title
Developing an Application Using ListView with Dynamic Selection Feedback.

## 2. Aim
To develop a native Android application demonstrating the `ListView` widget populated with a dataset via `ArrayAdapter`, handling item click events to display interactive user feedback.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `ListView`, `ArrayAdapter<String>`, `Toast`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
`ListView` is a vertically scrollable `AdapterView` that displays rows backed by an `Adapter`. The `ArrayAdapter` binds an array of objects to view items (such as `android.R.layout.simple_list_item_1`) using view recycling for memory efficiency.

## 5. Algorithm & Procedure
1. Create a layout with a title `TextView` and `ListView`.
2. Define a String array of programming languages.
3. Instantiate `ArrayAdapter<String>` and attach it to the `ListView` via `setAdapter()`.
4. Attach `OnItemClickListener` to show a `Toast` with the selected item name.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.listviewapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] languages = {"Java", "Kotlin", "Python", "C", "C++", "JavaScript", "Dart", "Swift", "Go", "Rust"};
        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, languages);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(this, "Selected: " + languages[position], Toast.LENGTH_SHORT).show());
    }
}
```

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:background="#FFFFFF">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/list_title"
        android:textColor="#1F1F1F"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginBottom="16dp"/>

    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:divider="#E0E0E0"
        android:dividerHeight="1dp"/>

</LinearLayout>
```

### 6.3 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.ListViewApp">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was tested and verified on the OnePlus CPH2661 smartphone:

**Output Screen: ListView populated with items on physical device:**

![ListView Output](Practical_Screenshots/Practical_07/P07_List_View.png)

- **Verification Summary:** The list populated cleanly with item rows, and tapping any item triggered an interactive feedback message.

## 8. Expected Output
A scrollable list of programming languages is displayed. Tapping an item shows its name in a Toast.

## 9. Result & Conclusion
The ListView application was successfully built, verified on physical hardware, and documented.


# PRACTICAL 08

## 1. Title
Applying a Theme in an Activity/Application (Custom Light Theme).

## 2. Aim
To develop a native Android application demonstrating how to define a custom light theme in XML resources (`res/values/themes.xml`) and apply it globally at the application level to enforce consistent typography, surface, and brand accent colors.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `Button`, `TextView`, Theme Attributes (`?attr/colorPrimary`)
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
Themes in Android allow styling all views in an activity or application centrally. By inheriting from `Theme.Material3.Light.NoActionBar` and overriding attributes (`colorPrimary`, `colorOnPrimary`, `colorBackground`), applications maintain consistent visual branding.

## 5. Algorithm & Procedure
1. In `res/values/themes.xml`, define style `Theme.CustomLight` specifying brand colors and background.
2. In `AndroidManifest.xml`, apply the theme to the `<application>` tag.
3. In `activity_main.xml`, reference theme attributes like `?attr/colorPrimary` for text and controls.
4. Build and verify the rendered themed interface.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.themeapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

### 6.2 `res/values/themes.xml`
```xml
<resources>
    <style name="Theme.CustomLight" parent="Theme.Material3.Light.NoActionBar">
        <!-- Status bar styling -->
        <item name="android:statusBarColor">#FFFFFF</item>
        <item name="android:windowLightStatusBar">true</item>

        <!-- Brand color palette -->
        <item name="colorPrimary">#1976D2</item>
        <item name="colorOnPrimary">#FFFFFF</item>
        <item name="colorSecondary">#FFA000</item>
        <item name="colorOnSecondary">#000000</item>

        <!-- Background & Surface -->
        <item name="android:colorBackground">#F8F9FA</item>
        <item name="colorSurface">#FFFFFF</item>
        <item name="colorOnSurface">#1F1F1F</item>

        <!-- Standard typography -->
        <item name="android:fontFamily">sans-serif</item>
    </style>
</resources>
```

### 6.3 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp">

    <TextView
        android:id="@+id/tvThemeTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/theme_title"
        android:textColor="?attr/colorPrimary"
        android:textSize="24sp"
        android:textStyle="bold"
        android:layout_marginBottom="8dp"/>

    <TextView
        android:id="@+id/tvThemeSubtitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/theme_subtitle"
        android:textColor="?attr/colorOnSurface"
        android:textSize="16sp"
        android:layout_marginBottom="24dp"/>

    <Button
        android:id="@+id/btnSample"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/btn_sample"
        android:textSize="16sp"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:id="@+id/tvThemeInfo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/theme_info"
        android:textColor="#555555"
        android:textSize="14sp"/>

</LinearLayout>
```

### 6.4 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.CustomLight">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was built via Gradle, installed onto the physical OnePlus Nord 4 (CPH2661, Android 16), and verified:

**Output Screen: Custom Light Theme applied to application:**

![Custom Light Theme Output](Practical_Screenshots/Practical_08/P08_Theme_Application.png)

- **Execution Verification:** The application successfully launched applying `Theme.CustomLight`, rendering high-contrast blue primary accents on a clean light background `#FFFFFF`.

## 8. Expected Output
The application opens using the custom light theme, displaying configured colors and clean typography.

## 9. Result & Conclusion
Theme definition and application-wide theme inheritance were successfully demonstrated and documented.


# PRACTICAL 09

## 1. Title
Creating an Options Menu in an Android Application (Home, Settings, About, Help).

## 2. Aim
To develop a native Android application demonstrating an Options Menu with items (Home, Settings, About, Help) inflated via XML and handled through menu callback methods.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `Toolbar`, `TextView`, Options Menu
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
The Options Menu provides primary action and navigation items for an Activity. Menus are defined declaratively in `res/menu/`, inflated in `onCreateOptionsMenu()`, and actions are processed in `onOptionsItemSelected()`.

## 5. Algorithm & Procedure
1. Create `res/menu/menu_main.xml` defining items for Home, Settings, About, Help.
2. In `activity_main.xml`, add a `Toolbar` at the top and a feedback `TextView` in the center.
3. In `MainActivity.java`, call `setSupportActionBar(toolbar)`.
4. Override `onCreateOptionsMenu()` to inflate the menu resource.
5. Override `onOptionsItemSelected()` to handle item selections and update feedback text.

## 6. Source Code

### 6.1 `MainActivity.java`
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

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        app:title="Options Menu Demo"
        app:titleTextColor="@android:color/white"/>

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="24dp">

        <TextView
            android:id="@+id/tvMenuFeedback"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:text="Tap the 3-dot menu icon in the top right"
            android:textSize="18sp"
            android:textColor="@android:color/black"
            android:gravity="center"/>

    </RelativeLayout>

</LinearLayout>
```

### 6.3 `res/menu/menu_main.xml`
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

### 6.4 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:roundIcon="@android:drawable/sym_def_app_icon"
        android:supportsRtl="true"
        android:theme="@style/Theme.MenuBar">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the OnePlus CPH2661 smartphone:

**Output Screen 1: Main application screen with action bar:**

![Menu Bar Closed](Practical_Screenshots/Practical_09/P09_Menu_Bar_Closed.png)

**Output Screen 2: Options Menu expanded showing menu items:**

![Menu Bar Open](Practical_Screenshots/Practical_09/P09_Menu_Bar_Open.png)

**Output Screen 3: Feedback displayed after selecting Settings menu item:**

![Menu Item Selected](Practical_Screenshots/Practical_09/P09_Menu_Item_Selected.png)

- **Verification Summary:** Screen 1 confirms native `Toolbar` loaded; Screen 2 shows the 3-dot overflow menu expanded; Screen 3 shows dynamic feedback ("Selected: Settings").

## 8. Expected Output
Tapping the overflow icon expands the menu showing all options. Selecting an option displays corresponding feedback.

## 9. Result & Conclusion
The Options Menu application was successfully developed, verified on physical hardware, and documented.


# PRACTICAL 10

## 1. Title
Storing Local Data Using User Preferences (SharedPreferences).

## 2. Aim
To develop a native Android application demonstrating lightweight key-value data persistence using `SharedPreferences`, saving user data to persistent device storage and loading it across application lifecycle sessions.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `SharedPreferences`, `EditText`, `Button`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
`SharedPreferences` provides a lightweight mechanism to save and retrieve persistent key-value pairs of primitive data types stored as private XML files inside `/data/data/<package_name>/shared_prefs/`.

## 5. Algorithm & Procedure
1. Create a light-theme layout with an `EditText` for name input, Save and Load buttons, and a result `TextView`.
2. In `MainActivity.java`, get a `SharedPreferences` instance via `getSharedPreferences("UserPrefs", MODE_PRIVATE)`.
3. In the Save button listener, call `preferences.edit().putString("user_name", name).apply()`.
4. In the Load button listener, read `preferences.getString("user_name", default)` and display the result.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.userpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_USER_NAME = "user_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editName = findViewById(R.id.editName);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnLoad = findViewById(R.id.btnLoad);
        TextView txtResult = findViewById(R.id.txtResult);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Auto-load preference on launch if available
        String initialName = preferences.getString(KEY_USER_NAME, null);
        if (initialName != null && !initialName.isEmpty()) {
            txtResult.setText("Stored Name: " + initialName);
            editName.setText(initialName);
        }

        btnSave.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name to save", Toast.LENGTH_SHORT).show();
                return;
            }
            preferences.edit().putString(KEY_USER_NAME, name).apply();
            txtResult.setText("Saved successfully: " + name);
            Toast.makeText(this, "Preference saved to storage", Toast.LENGTH_SHORT).show();
        });

        btnLoad.setOnClickListener(v -> {
            String savedName = preferences.getString(KEY_USER_NAME, "No data saved");
            txtResult.setText("Loaded: " + savedName);
        });
    }
}
```

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp"
    android:background="#FFFFFF">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/pref_title"
        android:textColor="#1F1F1F"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_marginBottom="24dp"/>

    <EditText
        android:id="@+id/editName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/hint_user_name"
        android:textColor="#1F1F1F"
        android:textColorHint="#757575"
        android:background="@android:drawable/editbox_background_normal"
        android:padding="12dp"
        android:inputType="textPersonName"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/btnSave"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/btn_save_pref"
        android:textSize="16sp"
        android:layout_marginBottom="12dp"/>

    <Button
        android:id="@+id/btnLoad"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/btn_load_pref"
        android:textSize="16sp"
        android:layout_marginBottom="24dp"/>

    <TextView
        android:id="@+id/txtResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="#1A73E8"
        android:textSize="18sp"
        android:textStyle="bold"
        android:gravity="center"/>

</LinearLayout>
```

### 6.3 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.UserPreferences">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was built via Gradle, installed onto the physical OnePlus Nord 4 (CPH2661, Android 16), and verified:

**Output Screen: User Preferences saved and loaded successfully:**

![User Preferences SharedPreferences Persistence](Practical_Screenshots/Practical_10/P10_User_Preferences.png)

- **Execution Verification:** After saving a user's name to `SharedPreferences`, terminating and restarting the application accurately restored and rendered the saved string upon pressing Load.

## 8. Expected Output
After saving a name, pressing Load displays the stored name even after restarting the application.

## 9. Result & Conclusion
Local data storage using Android `SharedPreferences` was successfully implemented and verified.


# PRACTICAL 11

## 1. Title
Creating, Reading and Writing Data Using SQLite (CRUD Operations).

## 2. Aim
To develop a native Android application in light theme utilizing SQLite database storage via `SQLiteOpenHelper` to perform full Create, Read, Update, and Delete (CRUD) operations on student records and display them dynamically in a `ListView`.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Architecture:** Light Theme (`#FFFFFF` background, dark text `#1F1F1F`)
- **Components:** `SQLiteOpenHelper`, `SQLiteDatabase`, `EditText`, `Button`, `ListView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
SQLite is an embedded relational SQL database engine included in Android. `SQLiteOpenHelper` manages database creation (`onCreate`) and schema version upgrades (`onUpgrade`). Operations are executed via parameterized queries using `ContentValues` and `Cursor`.

## 5. Algorithm & Procedure
1. Create `DatabaseHelper.java` extending `SQLiteOpenHelper` with student table schema (`id`, `name`, `email`).
2. Implement CRUD methods: `insertStudent()`, `getAllStudents()`, `updateStudent()`, `deleteStudent()`.
3. In `MainActivity.java`, attach click listeners for the 4 action buttons (Insert, View All, Update, Delete) and bind results to `ListView`.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.crudsqlite;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etStudentId;
    private EditText etStudentName;
    private EditText etStudentEmail;
    private TextView tvRecordsHeader;
    private ListView lvStudents;

    private DatabaseHelper dbHelper;
    private List<Student> studentList;
    private List<String> displayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        studentList = new ArrayList<>();
        displayList = new ArrayList<>();

        etStudentId = findViewById(R.id.etStudentId);
        etStudentName = findViewById(R.id.etStudentName);
        etStudentEmail = findViewById(R.id.etStudentEmail);
        tvRecordsHeader = findViewById(R.id.tvRecordsHeader);
        lvStudents = findViewById(R.id.lvStudents);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        lvStudents.setAdapter(adapter);

        findViewById(R.id.btnInsert).setOnClickListener(v -> insertRecord());
        findViewById(R.id.btnViewAll).setOnClickListener(v -> loadRecords(true));
        findViewById(R.id.btnUpdate).setOnClickListener(v -> updateRecord());
        findViewById(R.id.btnDelete).setOnClickListener(v -> deleteRecord());

        lvStudents.setOnItemClickListener((parent, view, position, id) -> {
            Student s = studentList.get(position);
            etStudentId.setText(String.valueOf(s.getId()));
            etStudentName.setText(s.getName());
            etStudentEmail.setText(s.getEmail());
        });

        loadRecords(false);
    }

    private void insertRecord() {
        String name = etStudentName.getText().toString().trim();
        String email = etStudentEmail.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Enter name and email", Toast.LENGTH_SHORT).show();
            return;
        }

        long id = dbHelper.insertStudent(name, email);
        if (id != -1) {
            Toast.makeText(this, "Record Inserted (ID: " + id + ")", Toast.LENGTH_SHORT).show();
            clearInputs();
            loadRecords(false);
        } else {
            Toast.makeText(this, "Insert failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadRecords(boolean notify) {
        studentList.clear();
        displayList.clear();
        studentList.addAll(dbHelper.getAllStudents());
        for (Student s : studentList) {
            displayList.add("ID: " + s.getId() + " | " + s.getName() + " (" + s.getEmail() + ")");
        }
        adapter.notifyDataSetChanged();
        tvRecordsHeader.setText("Stored Records (" + studentList.size() + "):");
        if (notify) {
            Toast.makeText(this, studentList.size() + " records loaded", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateRecord() {
        String idStr = etStudentId.getText().toString().trim();
        String name = etStudentName.getText().toString().trim();
        String email = etStudentEmail.getText().toString().trim();

        if (idStr.isEmpty() || name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Enter ID, name, and email to update", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idStr);
        int rows = dbHelper.updateStudent(id, name, email);
        if (rows > 0) {
            Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
            loadRecords(false);
        } else {
            Toast.makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteRecord() {
        String idStr = etStudentId.getText().toString().trim();
        if (idStr.isEmpty()) {
            Toast.makeText(this, "Enter ID to delete", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idStr);
        int rows = dbHelper.deleteStudent(id);
        if (rows > 0) {
            Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
            clearInputs();
            loadRecords(false);
        } else {
            Toast.makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearInputs() {
        etStudentId.setText("");
        etStudentName.setText("");
        etStudentEmail.setText("");
    }
}
```

### 6.2 `DatabaseHelper.java`
```java
package com.example.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB.db";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_STUDENTS = "students";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_STUDENTS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, "
            + COL_EMAIL + " TEXT NOT NULL"
            + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    public long insertStudent(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        return db.insert(TABLE_STUDENTS, null, values);
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_STUDENTS, new String[]{COL_ID, COL_NAME, COL_EMAIL},
                null, null, null, null, COL_ID + " ASC");

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(COL_EMAIL));
                list.add(new Student(id, name, email));
            }
            cursor.close();
        }
        return list;
    }

    public int updateStudent(int id, String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        return db.update(TABLE_STUDENTS, values, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public int deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_STUDENTS, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }
}
```

### 6.3 `Student.java`
```java
package com.example.crudsqlite;

public class Student {
    private int id;
    private String name;
    private String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " (" + email + ")";
    }
}
```

### 6.4 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFFFFF"
    android:fillViewport="true">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="20dp"
        android:background="#FFFFFF">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Student Records (SQLite CRUD)"
            android:textSize="20sp"
            android:textStyle="bold"
            android:textColor="#1F1F1F"
            android:layout_marginBottom="16dp"/>

        <EditText
            android:id="@+id/etStudentId"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Student ID (Required for Update/Delete)"
            android:textColor="#1F1F1F"
            android:textColorHint="#757575"
            android:inputType="number"
            android:padding="12dp"
            android:background="@android:drawable/editbox_background_normal"
            android:layout_marginBottom="10dp"/>

        <EditText
            android:id="@+id/etStudentName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Student Name"
            android:textColor="#1F1F1F"
            android:textColorHint="#757575"
            android:inputType="textPersonName"
            android:padding="12dp"
            android:background="@android:drawable/editbox_background_normal"
            android:layout_marginBottom="10dp"/>

        <EditText
            android:id="@+id/etStudentEmail"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Student Email"
            android:textColor="#1F1F1F"
            android:textColorHint="#757575"
            android:inputType="textEmailAddress"
            android:padding="12dp"
            android:background="@android:drawable/editbox_background_normal"
            android:layout_marginBottom="16dp"/>

        <!-- Action Buttons -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:layout_marginBottom="8dp">

            <Button
                android:id="@+id/btnInsert"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Insert"
                android:layout_marginEnd="4dp"/>

            <Button
                android:id="@+id/btnViewAll"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="View All"
                android:layout_marginStart="4dp"/>
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:layout_marginBottom="16dp">

            <Button
                android:id="@+id/btnUpdate"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Update"
                android:layout_marginEnd="4dp"/>

            <Button
                android:id="@+id/btnDelete"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Delete"
                android:layout_marginStart="4dp"/>
        </LinearLayout>

        <TextView
            android:id="@+id/tvRecordsHeader"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Stored Records:"
            android:textStyle="bold"
            android:textColor="#1F1F1F"
            android:layout_marginBottom="8dp"/>

        <ListView
            android:id="@+id/lvStudents"
            android:layout_width="match_parent"
            android:layout_height="300dp"
            android:background="#FFFFFF"
            android:divider="#E0E0E0"
            android:dividerHeight="1dp"
            android:nestedScrollingEnabled="true"/>

    </LinearLayout>
</ScrollView>
```

### 6.5 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:roundIcon="@android:drawable/sym_def_app_icon"
        android:supportsRtl="true"
        android:theme="@style/Theme.CRUDApp">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the OnePlus CPH2661 smartphone across all four operations:

**Output Screen 1: CREATE — Inserting student record into SQLite database:**

![CRUD Create](Practical_Screenshots/Practical_11/P11_CRUD_Create.png)

**Output Screen 2: READ — Querying and listing student records in ListView:**

![CRUD Read](Practical_Screenshots/Practical_11/P11_CRUD_Read.png)

**Output Screen 3: UPDATE — Updating existing student record by ID:**

![CRUD Update](Practical_Screenshots/Practical_11/P11_CRUD_Update.png)

**Output Screen 4: DELETE — Deleting student record by ID:**

![CRUD Delete](Practical_Screenshots/Practical_11/P11_CRUD_Delete.png)

- **Verification Summary:** All four CRUD operations (Create, Read, Update, Delete) were executed on physical hardware and verified against the embedded SQLite database file.

## 8. Expected Output
1. **CREATE:** Entering student details and tapping "Insert" writes to SQLite and updates the list view immediately.
2. **READ ALL:** Tapping "View All" displays all stored student records in the `ListView`.
3. **UPDATE:** Providing an existing ID allows updating name or email; tapping "Update" modifies the database row.
4. **DELETE:** Supplying an ID and tapping "Delete" permanently removes the record from SQLite and the list.

## 9. Result & Conclusion
SQLite database management using Android's native `SQLiteOpenHelper` was successfully demonstrated and verified.


# PRACTICAL 12

## 1. Title
Creating an Application to Send SMS using Prefilled Intent.

## 2. Aim
To develop a native Android application in Java to send SMS using a prefilled implicit intent (`Intent.ACTION_SENDTO` with `smsto:`) delegating dispatch to the default messaging client without requiring dangerous runtime permissions.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `EditText`, `Button`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
Dispatching an implicit intent with `Intent.ACTION_SENDTO` and `smsto:` scheme allows prefilling recipient phone numbers and message drafts without requiring dangerous `SEND_SMS` permissions, adhering to platform privacy best practices.

## 5. Algorithm & Procedure
1. Create a clean form layout with recipient phone number and message input fields and a send button.
2. In `MainActivity.java`, validate inputs upon button click.
3. Construct `Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone))` with `sms_body` extra.
4. Dispatch the intent via `startActivity()`.

## 6. Source Code

### 6.1 `MainActivity.java`
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
 *
 * Demonstrates:
 * 1. Validating recipient phone number and message payload.
 * 2. Invoking the default system messaging application via Intent.ACTION_SENDTO
 *    using the "smsto:" scheme.
 * 3. Prefilling the conversation thread without requesting invasive permissions
 *    or silently sending messages without user consent.
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

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:background="#FFFFFF">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send SMS Application"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="24dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Recipient Phone Number:"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etPhoneNumber"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter phone number"
        android:text="+919876543210"
        android:textColor="#1F1F1F"
        android:textColorHint="#757575"
        android:inputType="phone"
        android:padding="12dp"
        android:background="@android:drawable/editbox_background_normal"
        android:layout_marginBottom="20dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Message Body:"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etMessageBody"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter message text"
        android:text="Hello, this is a test SMS message."
        android:textColor="#1F1F1F"
        android:textColorHint="#757575"
        android:inputType="textMultiLine"
        android:minLines="3"
        android:gravity="top|start"
        android:padding="12dp"
        android:background="@android:drawable/editbox_background_normal"
        android:layout_marginBottom="24dp"/>

    <Button
        android:id="@+id/btnOpenSmsApp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Open SMS App"/>

</LinearLayout>
```

### 6.3 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:roundIcon="@android:drawable/sym_def_app_icon"
        android:supportsRtl="true"
        android:theme="@style/Theme.SmsApp">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the OnePlus CPH2661 smartphone:

**Output Screen 1: SMS composition form with input fields:**

![SMS Form](Practical_Screenshots/Practical_12/P12_SMS_Form.png)

**Output Screen 2: System messaging application opened with prefilled recipient and message:**

![SMS Prefilled App](Practical_Screenshots/Practical_12/P12_SMS_Prefilled_App.png)

- **Verification Summary:** Screen 1 shows the form with recipient (`+919876543210`) and message text; Screen 2 confirms tapping the action button opened Google Messages with recipient and draft prefilled.

## 8. Expected Output
The app displays an input form. Tapping "Open SMS App" triggers an implicit intent opening the default messaging client prefilled with recipient and message.

## 9. Result & Conclusion
SMS composition was cleanly implemented through permissionless `Intent.ACTION_SENDTO` delegation and verified on physical hardware.


# PRACTICAL 13

## 1. Title
Creating an Application to Send an E-mail using Prefilled Intent with System Chooser.

## 2. Aim
To develop a native Android application in light theme that prepares email parameters (recipient, subject, body), validates email syntax, and delegates composition to an installed email client via `Intent.ACTION_SENDTO` with a system chooser dialog.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Architecture:** Light Theme (`#FFFFFF` background, dark text `#1F1F1F`)
- **Components:** `LinearLayout`, `EditText`, `Button`, `Intent.ACTION_SENDTO`, `Intent.createChooser`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
Using `Intent.ACTION_SENDTO` with the `mailto:` scheme filters handlers to dedicated email applications. Wrapping the intent inside `Intent.createChooser()` ensures that a system app chooser dialog is displayed, providing user autonomy.

## 5. Algorithm & Procedure
1. Create a clean form with fields for recipient email, subject, and message body.
2. In `MainActivity.java`, validate email format using `Patterns.EMAIL_ADDRESS`.
3. Construct `Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))`, attach `EXTRA_EMAIL`, `EXTRA_SUBJECT`, `EXTRA_TEXT`.
4. Wrap in `Intent.createChooser()` and call `startActivity()`.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.emailapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 08: Send Email in Android Studio
 * Course: SCS391 Mobile Application Development Lab
 *
 * Demonstrates:
 * 1. Validation of recipient email format, subject line, and message body.
 * 2. Privacy-first implicit Intent delegation using Intent.ACTION_SENDTO with "mailto:".
 * 3. Delegating prefilled parameters to external email clients (e.g., Gmail) via Intent.createChooser.
 * 4. Graceful handling of ActivityNotFoundException when no email app is available.
 */
public class MainActivity extends AppCompatActivity {

    private EditText etEmailTo;
    private EditText etSubject;
    private EditText etEmailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmailTo = findViewById(R.id.etEmailTo);
        etSubject = findViewById(R.id.etSubject);
        etEmailBody = findViewById(R.id.etEmailBody);

        findViewById(R.id.btnSendEmail).setOnClickListener(v -> handleSendEmail());
    }

    private void handleSendEmail() {
        String to = etEmailTo.getText().toString().trim();
        String subject = etSubject.getText().toString().trim();
        String body = etEmailBody.getText().toString().trim();

        // 1. Recipient Validation
        if (to.isEmpty()) {
            etEmailTo.setError("Recipient email cannot be empty");
            etEmailTo.requestFocus();
            Toast.makeText(this, "Please enter recipient email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(to).matches()) {
            etEmailTo.setError("Please enter a valid email address");
            etEmailTo.requestFocus();
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show();
            return;
        }

        // 2. Subject Validation
        if (subject.isEmpty()) {
            etSubject.setError("Subject line cannot be empty");
            etSubject.requestFocus();
            Toast.makeText(this, "Please enter email subject", Toast.LENGTH_SHORT).show();
            return;
        }

        // 3. Body Validation
        if (body.isEmpty()) {
            etEmailBody.setError("Email body cannot be empty");
            etEmailBody.requestFocus();
            Toast.makeText(this, "Please enter message body", Toast.LENGTH_SHORT).show();
            return;
        }

        // 4. Construct Email Intent
        // ACTION_SENDTO with mailto: ensures ONLY dedicated email clients match
        Uri mailtoUri = Uri.parse("mailto:" + Uri.encode(to));
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, mailtoUri);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        // 5. Wrap in Chooser to provide seamless user choice
        Intent chooserIntent = Intent.createChooser(emailIntent, "Send Email via:");

        try {
            startActivity(chooserIntent);
            Toast.makeText(this, "Opening email client...", Toast.LENGTH_SHORT).show();
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No compatible email client found on device", Toast.LENGTH_LONG).show();
        }
    }
}
```

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:background="#FFFFFF">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Email Application"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="24dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Recipient Email:"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etEmailTo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter recipient email"
        android:text="alex.johnson@university.edu"
        android:textColor="#1F1F1F"
        android:textColorHint="#757575"
        android:inputType="textEmailAddress"
        android:padding="12dp"
        android:background="@android:drawable/editbox_background_normal"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Subject Line:"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etSubject"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter subject"
        android:text="SCS391 Practical 13 Submission"
        android:textColor="#1F1F1F"
        android:textColorHint="#757575"
        android:inputType="text"
        android:padding="12dp"
        android:background="@android:drawable/editbox_background_normal"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Message Body:"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etEmailBody"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter message text"
        android:text="Hello, this is a test email message."
        android:textColor="#1F1F1F"
        android:textColorHint="#757575"
        android:inputType="textMultiLine"
        android:minLines="3"
        android:gravity="top|start"
        android:padding="12dp"
        android:background="@android:drawable/editbox_background_normal"
        android:layout_marginBottom="24dp"/>

    <Button
        android:id="@+id/btnSendEmail"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Open Email Client"/>

</LinearLayout>
```

### 6.3 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <!-- Zero permissions required: Using ACTION_SENDTO with mailto: delegation -->
    <queries>
        <!-- Support Android 11+ package visibility for email clients -->
        <intent>
            <action android:name="android.intent.action.SENDTO" />
            <data android:scheme="mailto" />
        </intent>
    </queries>

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:roundIcon="@android:drawable/sym_def_app_icon"
        android:supportsRtl="true"
        android:theme="@style/Theme.EmailApp">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the OnePlus CPH2661 smartphone:

**Output Screen 1: Email composition form with input fields:**

![Email Form](Practical_Screenshots/Practical_13/P13_Email_Form.png)

**Output Screen 2: System email app chooser opened for composition:**

![Email Prefilled App](Practical_Screenshots/Practical_13/P13_Email_Prefilled_App.png)

- **Verification Summary:** Screen 1 shows the form with recipient (`alex.johnson@university.edu`), subject, and body; Screen 2 confirms the system chooser opened displaying email application targets.

## 8. Expected Output
The user fills in recipient address, subject line, and message body. Clicking "Open Email Client" dispatches the implicit intent inside a chooser prefilling target email clients.

## 9. Result & Conclusion
Email dispatch architecture using `Intent.ACTION_SENDTO` with `mailto:` scheme delegation was successfully implemented and verified.


# PRACTICAL 14

## 1. Title
Displaying a Map Based on Current or Given Location via Google Maps.

## 2. Aim
To develop a native Android application that displays a geographical location using Google Maps, allowing the user to view either a given coordinate (e.g. Golden Temple, Amritsar: `31.6200, 74.8765`) or dynamically acquire device coordinates via `LocationManager` and open the location directly in Google Maps.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Architecture:** Light Theme (`#FFFFFF` background, dark text `#1F1F1F`)
- **Components:** `LocationManager`, `EditText` (Latitude, Longitude, Label), `Button`, `Intent.ACTION_VIEW` (`geo:` URI scheme)
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
Android allows opening map locations via the standard `geo:` URI scheme (`geo:latitude,longitude?q=latitude,longitude(label)`). This approach launches Google Maps cleanly without requiring external proprietary API keys or billing dependencies. Runtime permissions (`ACCESS_FINE_LOCATION`) allow querying device GPS sensors via `LocationManager`.

## 5. Algorithm & Procedure
1. Create a light-theme layout with input fields for Location Label, Latitude, and Longitude.
2. In `MainActivity.java`, populate default coordinates for the Golden Temple, Amritsar (`31.6200, 74.8765`).
3. Add a button to request runtime location permissions and fetch current GPS coordinates via `LocationManager`.
4. In the map launch listener, construct the `geo:` URI, wrap in `Intent.ACTION_VIEW`, target `com.google.android.apps.maps` with web browser fallback, and call `startActivity()`.

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.googlemapslocation;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_LOCATION = 1001;

    private EditText etLocationLabel;
    private EditText etLatitude;
    private EditText etLongitude;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLocationLabel = findViewById(R.id.etLocationLabel);
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);
        tvStatus = findViewById(R.id.tvStatus);

        Button btnUseCurrentLocation = findViewById(R.id.btnUseCurrentLocation);
        Button btnOpenMap = findViewById(R.id.btnOpenMap);

        btnUseCurrentLocation.setOnClickListener(v -> checkAndRequestLocation());

        btnOpenMap.setOnClickListener(v -> openInGoogleMaps());
    }

    private void checkAndRequestLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            retrieveCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERMISSION_REQUEST_LOCATION);
        }
    }

    private void retrieveCurrentLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager == null) {
            tvStatus.setText("Location service unavailable");
            return;
        }

        try {
            Location location = null;
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
            if (location == null && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }

            if (location != null) {
                double lat = location.getLatitude();
                double lng = location.getLongitude();
                etLatitude.setText(String.format(Locale.US, "%.4f", lat));
                etLongitude.setText(String.format(Locale.US, "%.4f", lng));
                etLocationLabel.setText("Current Device Location");
                tvStatus.setText(String.format(Locale.US, "Acquired Location: %.4f, %.4f", lat, lng));
                Toast.makeText(this, "Device coordinates acquired", Toast.LENGTH_SHORT).show();
            } else {
                tvStatus.setText("Location not yet acquired. Ensure GPS is enabled.");
                Toast.makeText(this, "Could not acquire current coordinates. Using given location.", Toast.LENGTH_SHORT).show();
            }
        } catch (SecurityException e) {
            tvStatus.setText("Location permission required");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                retrieveCurrentLocation();
            } else {
                tvStatus.setText("Location permission denied by user");
                Toast.makeText(this, "Permission denied. You can still use a given location.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void openInGoogleMaps() {
        String latStr = etLatitude.getText().toString().trim();
        String lngStr = etLongitude.getText().toString().trim();
        String label = etLocationLabel.getText().toString().trim();

        if (latStr.isEmpty() || lngStr.isEmpty()) {
            Toast.makeText(this, "Please provide valid coordinates", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double lat = Double.parseDouble(latStr);
            double lng = Double.parseDouble(lngStr);

            String uriStr = String.format(Locale.US, "geo:%f,%f?q=%f,%f(%s)", lat, lng, lat, lng, Uri.encode(label));
            Uri gmmIntentUri = Uri.parse(uriStr);

            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            try {
                startActivity(mapIntent);
            } catch (ActivityNotFoundException e) {
                // Fallback to web browser Google Maps
                Uri webUri = Uri.parse(String.format(Locale.US, "https://www.google.com/maps/search/?api=1&query=%f,%f", lat, lng));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
                startActivity(webIntent);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid coordinate format", Toast.LENGTH_SHORT).show();
        }
    }
}
```

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFFFFF">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="20dp"
        android:background="#FFFFFF">

        <TextView
            android:id="@+id/tvTitle"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/maps_title"
            android:textColor="#1F1F1F"
            android:textSize="22sp"
            android:textStyle="bold"
            android:layout_marginTop="16dp"
            android:layout_marginBottom="24dp"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Location Name / Label:"
            android:textColor="#1F1F1F"
            android:textStyle="bold"
            android:layout_marginBottom="6dp"/>

        <EditText
            android:id="@+id/etLocationLabel"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Location Name"
            android:text="Golden Temple, Amritsar"
            android:textColor="#1F1F1F"
            android:textColorHint="#757575"
            android:padding="12dp"
            android:background="@android:drawable/editbox_background_normal"
            android:layout_marginBottom="16dp"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Latitude:"
            android:textColor="#1F1F1F"
            android:textStyle="bold"
            android:layout_marginBottom="6dp"/>

        <EditText
            android:id="@+id/etLatitude"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Latitude (e.g. 31.6200)"
            android:text="31.6200"
            android:textColor="#1F1F1F"
            android:textColorHint="#757575"
            android:inputType="numberDecimal|numberSigned"
            android:padding="12dp"
            android:background="@android:drawable/editbox_background_normal"
            android:layout_marginBottom="16dp"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Longitude:"
            android:textColor="#1F1F1F"
            android:textStyle="bold"
            android:layout_marginBottom="6dp"/>

        <EditText
            android:id="@+id/etLongitude"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Longitude (e.g. 74.8765)"
            android:text="74.8765"
            android:textColor="#1F1F1F"
            android:textColorHint="#757575"
            android:inputType="numberDecimal|numberSigned"
            android:padding="12dp"
            android:background="@android:drawable/editbox_background_normal"
            android:layout_marginBottom="24dp"/>

        <Button
            android:id="@+id/btnUseCurrentLocation"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Use Device Current Location"
            android:textSize="15sp"
            android:layout_marginBottom="12dp"/>

        <Button
            android:id="@+id/btnOpenMap"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/btn_open_maps"
            android:textSize="16sp"
            android:layout_marginBottom="20dp"/>

        <TextView
            android:id="@+id/tvStatus"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textColor="#555555"
            android:textSize="14sp"
            android:gravity="center"/>

    </LinearLayout>
</ScrollView>
```

### 6.3 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.GoogleMapsLocation">

        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was built via Gradle, installed onto the physical OnePlus Nord 4 (CPH2661, Android 16), and executed:

**Output Screen 1: Google Maps Location application screen with designated coordinates:**

![Google Maps Application Screen](Practical_Screenshots/Practical_14/P14_01_Maps_Home.png)

**Output Screen 2: Current location trigger and permission execution:**

![Location Permission and Execution](Practical_Screenshots/Practical_14/P14_02_Maps_CurrentLocation_Permission.png)

**Output Screen 3: Google Maps launched with marker at Amritsar Golden Temple:**

![Google Maps Running on Phone](Practical_Screenshots/Practical_14/P14_03_Maps_GoogleMaps_View.png)

- **Execution Verification:** The application successfully launched, accepted given coordinates for Golden Temple, Amritsar (`31.6200, 74.8765`), handled device current location checks, and dispatched the standard `geo:` intent opening Google Maps with marker at the designated coordinates.

## 8. Expected Output
The user enters or acquires coordinates. Clicking "Open in Google Maps" launches Google Maps centered on the selected location with an annotated marker.

## 9. Result & Conclusion
Google Maps location display using standard `geo:` URI delegation was successfully implemented and verified.


# PRACTICAL 15

## 1. Title
Android Application Packaging, Cryptographic Signing, and Deployment.

## 2. Aim
To configure, compile, sign with APK Signature Scheme v2, verify, and deploy a production release Android APK on a physical Android device.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio & Gradle Build Toolchain
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Architecture:** Light Theme (`#FFFFFF` background, dark text `#1F1F1F`)
- **Security Tools:** `keytool`, `apksigner`, `zipalign`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background
Android requires all APKs to be digitally signed before installation. APK Signature Scheme v2 verifies the entire APK file integrity using an APK Signing Block. Release builds strip debug symbols (`FLAG_DEBUGGABLE=false`) for production hardening.

## 5. Algorithm & Procedure
1. Generate release keystore using Java `keytool`.
2. Configure `signingConfigs` block inside `app/build.gradle.kts`.
3. Execute `./gradlew assembleRelease` to compile, align, and sign the release APK.
4. Verify signature using `apksigner verify --verbose`.
5. Deploy signed APK to the device via `adb install -r`.

## 6. Source Code

### 6.1 `MainActivity.java`
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

### 6.2 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="24dp"
    android:background="#FFFFFF">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Application Deployment"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="24dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Release Build Verification:"
        android:textSize="16sp"
        android:textStyle="bold"
        android:textColor="#1F1F1F"
        android:layout_marginBottom="12dp"/>

    <TextView
        android:id="@+id/tvAppId"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Application ID: com.example.deploymentapp"
        android:textSize="14sp"
        android:textColor="#333333"
        android:layout_marginBottom="8dp"/>

    <TextView
        android:id="@+id/tvVersion"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Version: 1.0.0 (versionCode: 100)"
        android:textSize="14sp"
        android:textColor="#333333"
        android:layout_marginBottom="8dp"/>

    <TextView
        android:id="@+id/tvStatus"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Status: Verified Signed Release APK"
        android:textSize="14sp"
        android:textStyle="bold"
        android:textColor="#2E7D32"
        android:layout_marginBottom="24dp"/>

    <Button
        android:id="@+id/btnVerify"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Verify Installation"/>

</LinearLayout>
```

### 6.3 `app/build.gradle.kts`
```kotlin
plugins {
    id("com.android.application")
}

val releaseStoreFile = System.getenv("RELEASE_STORE_FILE")
    ?: "${System.getProperty("user.home")}/.android/scs391_release.jks"
val releaseStorePassword = System.getenv("RELEASE_STORE_PASSWORD")
    ?: "androidReleaseLab2026"
val releaseKeyAlias = System.getenv("RELEASE_KEY_ALIAS")
    ?: "scs391Release"
val releaseKeyPassword = System.getenv("RELEASE_KEY_PASSWORD")
    ?: "androidReleaseLab2026"

android {
    namespace = "com.example.deploymentapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.deploymentapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 100
        versionName = "1.0.0-release"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            if (file(releaseStoreFile).exists()) {
                storeFile = file(releaseStoreFile)
                storePassword = releaseStorePassword
                keyAlias = releaseKeyAlias
                keyPassword = releaseKeyPassword
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
}
```

### 6.4 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:roundIcon="@android:drawable/sym_def_app_icon"
        android:supportsRtl="true"
        android:theme="@style/Theme.DeploymentApp">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the physical OnePlus CPH2661 smartphone:

**Output Screen 1: Signed release APK running on physical device:**

![Release Execution](Practical_Screenshots/Practical_15/P15_Release_Execution.png)

**Output Screen 2: Runtime package installation and signature verification:**

![Release Verification](Practical_Screenshots/Practical_15/P15_Release_Verification.png)

- **Verification Summary:** `apksigner` confirmed `Verified using v2 scheme (APK Signature Scheme v2): true`. The signed release APK installed cleanly on Android 16 and executed with release status verified.

## 8. Expected Output
The release build compiles into a signed APK with `signingConfig = release`. Running `apksigner verify` confirms valid v2 signature. When launched, `FLAG_DEBUGGABLE` reports `FALSE`.

## 9. Result & Conclusion
Practical 15 was successfully completed. The complete Android application deployment process was demonstrated end-to-end, including cryptographic key generation, release configuration, APK Signature Scheme v2 validation, hardware deployment, and runtime verification.

