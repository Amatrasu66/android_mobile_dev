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
- **Student Name:** [Student Name Placeholder]
- **Roll / Registration Number:** [Registration Number Placeholder]
- **Batch / Section:** [Batch / Section Placeholder]
- **Academic Session:** 2026 – 2027
- **Submitted To:** [Course Instructor Placeholder]
- **GitHub Repository:** [https://github.com/Amatrasu66/android_mobile_dev](https://github.com/Amatrasu66/android_mobile_dev)

---

## INDEX OF EXPERIMENTS

| S.No. | Practical Title | Category | Date of Completion | Verification Status | Signature |
|---|---|---|---|---|---|
| **01** | Installation & Configuration of Android Studio, SDK, SDK Tools, AVD & JDK | Theoretical / Environment | 09-Nov-2026 | Verified | |
| **02** | Display "Hello World" in Android Studio using Java & XML | Core Application | 09-Nov-2026 | Verified | |
| **03** | Demonstration of Explicit and Implicit Intents | Core Application | 09-Nov-2026 | Verified | |
| **04** | Appointment Form Application (ImageButton, Spinner, Pickers, ListView) | UI Components & Events | 09-Nov-2026 | Verified | |
| **05** | Portrait and Landscape Screen Orientation Detection & Layouts | Configuration & Layouts | 09-Nov-2026 | Verified | |
| **06** | Implementation of Options Menu Bar (Home, Settings, About) | Menus & Navigation | 09-Nov-2026 | Verified | |
| **07** | Send SMS Application using Prefilled Intent | Intents & Communication | 09-Nov-2026 | Verified | |
| **08** | Send Email Application using Prefilled Intent | Intents & Communication | 09-Nov-2026 | Verified | |
| **09** | SQLite Student Records Management (CRUD Operations) | Native Database Storage | 09-Nov-2026 | Verified | |
| **10** | Android Application Release Build, Signing & Deployment | Deployment & Packaging | 09-Nov-2026 | Verified | |

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
To develop, build, install, and execute a native Android application using the Java programming language and XML layouts to display the traditional "Hello World!" message within a modern Material Design user interface.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio (AI-262 / Ladybug / Meerkat)
- **Language:** Java (JDK 21 LTS)
- **Build System:** Gradle 9.1.0 with Android Gradle Plugin 9.0.1
- **Compile SDK:** API 36 (Android 16) | **Min SDK:** API 24 (Android 7.0)
- **UI Components:** `androidx.constraintlayout.widget.ConstraintLayout`, `com.google.android.material.card.MaterialCardView`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36, 1240x2772 px, 560 dpi)

## 4. Theoretical Background

### 4.1 Android Application Architecture
Every Android application consists of four fundamental building blocks:
1. **Activity:** Represents a single screen with a user interface. It acts as the visual container where users interact.
2. **Service:** A component running in the background to perform long-running operations.
3. **Broadcast Receiver:** Listens for system-wide or application-level broadcast announcements.
4. **Content Provider:** Manages a shared set of app data.

### 4.2 Activity Lifecycle & View Hierarchy
When an Activity starts, the Android OS invokes its lifecycle methods:
- `onCreate()`: Called when the activity is first created. This is where static setup occurs: creating views, binding data to lists, and calling `setContentView(int layoutResID)`.
- `setContentView()`: Inflates the specified XML layout resource file into active memory as a hierarchy of Java `View` and `ViewGroup` objects.

### 4.3 ConstraintLayout & Material Design 3
`ConstraintLayout` is a flexible layout manager that allows widgets to be positioned and sized relative to sibling views or parent boundaries, maintaining a flat view hierarchy for optimal rendering performance. Material Design cards (`MaterialCardView`) provide elevated surfaces with rounded corners and consistent elevation shadows.

---

## 5. Algorithm & Procedure

1. **Project Creation:** Create an Android project using the *Empty Views Activity* template with Java selected as the programming language.
2. **Layout Design (`activity_main.xml`):**
   - Root the layout in a `ConstraintLayout`.
   - Place a `MaterialCardView` anchored to parent top, bottom, start, and end.
   - Inside the card, arrange a vertical `LinearLayout` containing:
     - Header `TextView` ("SCS391 Mobile App Development Lab").
     - Primary `TextView` (`@+id/tvHelloWorld`) styled with 32sp bold typography.
     - Subtitle `TextView` detailing the implementation framework.
     - Hardware status pill `TextView` indicating target API level.
3. **Logic Implementation (`MainActivity.java`):**
   - Extend `AppCompatActivity`.
   - Override `onCreate(Bundle savedInstanceState)`.
   - Call `super.onCreate(savedInstanceState)`.
   - Call `setContentView(R.layout.activity_main)` to inflate the view hierarchy.
   - Reference `findViewById(R.id.tvHelloWorld)` and bind text.
4. **Manifest Declaration (`AndroidManifest.xml`):**
   - Declare the activity with `android:exported="true"`.
   - Add the `<intent-filter>` containing `ACTION_MAIN` and `CATEGORY_LAUNCHER`.
5. **Compilation & Installation:**
   - Compile the debug APK using `./gradlew assembleDebug`.
   - Stream the APK onto the connected OnePlus CPH2661 using `adb install -r <apk>`.
6. **Execution & Hardware Verification:**
   - Launch the application: `adb shell am start -n com.example.helloworld/.MainActivity`.
   - Verify UI rendering and capture hardware screenshot using ADB screencap.

---

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.helloworld;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 02: Hello World Application
 * Course: SCS391 Mobile Application Development Lab
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the XML layout into the active View hierarchy
        setContentView(R.layout.activity_main);

        // Bind TextView widget
        TextView tvHelloWorld = findViewById(R.id.tvHelloWorld);
        tvHelloWorld.setText(R.string.hello_world);
    }
}
```

### 6.2 `res/layout/activity_main.xml`
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
                android:letterSpacing="0.05"
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
    <string name="app_name">Practical 02 - Hello World</string>
    <string name="lab_header">SCS391 Mobile App Development Lab</string>
    <string name="hello_world">Hello World!</string>
    <string name="welcome_subtext">Native Java &amp; XML Implementation</string>
    <string name="device_info">Target: Android 16 (API 36)</string>
</resources>
```

### 6.5 `app/build.gradle.kts`
```kotlin
plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.helloworld"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.helloworld"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
}
```

---

## 7. Output & Hardware Execution Evidence

The application was built via Gradle, installed onto the authorized OnePlus CPH2661 smartphone running Android 16 via ADB, and executed.

- **Captured Screenshot Reference:** `Practical_Screenshots/Practical_02/P02_Hello_World.png`
- **Device Display Output:** The smartphone screen opens directly into the main activity displaying the Material Card with the header "SCS391 Mobile App Development Lab", bold primary text "Hello World!", subtext "Native Java & XML Implementation", and the hardware status badge "Target: Android 16 (API 36)".

## 8. Expected Output
The application successfully launches on the Android device and displays "Hello World!" in the center of the screen with proper typography and Material card styling.

## 9. Result & Conclusion
The "Hello World" native Android application was successfully developed in Java using Android Studio, compiled using Gradle, installed onto a physical OnePlus smartphone, and verified. The fundamental concepts of Activity lifecycle, layout inflation, widget referencing, and device deployment were demonstrated.


---

# PRACTICAL 03

## 1. Title
Development of an Android Application in Java to Demonstrate Intents (Explicit and Implicit).

## 2. Aim
To develop a native Android application demonstrating:
1. **Explicit Intent:** Navigating between activities within the application and passing payload data through Intent Extras.
2. **Implicit Intent:** Invoking external system-managed applications (Web Browser and Phone Dialer) using standard Android action filters and URIs.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio (AI-262 / Ladybug / Meerkat)
- **Language:** Java (JDK 21 LTS)
- **Build System:** Gradle 9.1.0 with Android Gradle Plugin 9.0.1
- **Compile SDK:** API 36 (Android 16) | **Min SDK:** API 24 (Android 7.0)
- **Key Classes:** `android.content.Intent`, `android.net.Uri`, `android.widget.EditText`, `com.google.android.material.button.MaterialButton`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36, USB Debugging)

## 4. Theoretical Background

### 4.1 Concept of Intent in Android
An `Intent` is an asynchronous messaging object used to request an action from another app component. Intents facilitate runtime binding between separate components (activities, services, broadcast receivers).

### 4.2 Explicit Intents
An Explicit Intent specifies the exact target component by providing the fully-qualified class name of the activity (`new Intent(Context packageContext, Class<?> cls)`). Explicit intents are typically used within an application because the developer controls internal package components. Data payloads are packaged as key-value pairs using `intent.putExtra(String name, value)` and unpacked using `getIntent().getStringExtra(name)`.

### 4.3 Implicit Intents
An Implicit Intent does not name a specific destination component. Instead, it declares a general action to perform (e.g., `Intent.ACTION_VIEW`, `Intent.ACTION_DIAL`), accompanied by data represented as a Uniform Resource Identifier (`Uri`). The Android system evaluates all installed applications' `<intent-filter>` declarations in their manifests to resolve an application capable of handling the action.

---

## 5. Algorithm & Procedure

### 5.1 Explicit Intent Workflow
1. In `MainActivity`, instantiate an `EditText` for user input and a button `btnLaunchExplicit`.
2. On click, create an explicit Intent targeting `SecondActivity.class`:
   ```java
   Intent intent = new Intent(MainActivity.this, SecondActivity.class);
   intent.putExtra(EXTRA_MESSAGE, message);
   intent.putExtra(EXTRA_TIMESTAMP, System.currentTimeMillis());
   startActivity(intent);
   ```
3. In `SecondActivity`, retrieve the extras in `onCreate()`:
   ```java
   String msg = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
   ```
4. Display the retrieved message and timestamp in designated `TextView` widgets.
5. Provide a finish button to pop `SecondActivity` off the back stack.

### 5.2 Implicit Intent Workflow
1. **Web Browser Action:**
   - Parse web URI: `Uri webpage = Uri.parse("https://developer.android.com");`.
   - Instantiate intent: `new Intent(Intent.ACTION_VIEW, webpage);`.
   - Wrap in `try-catch` and call `startActivity(webIntent);`.
2. **Phone Dialer Action:**
   - Parse telephone URI: `Uri phone = Uri.parse("tel:9876543210");`.
   - Instantiate intent: `new Intent(Intent.ACTION_DIAL, phone);`.
   - Call `startActivity(dialerIntent);`.

---

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 03: Intent Demonstration
 * Course: SCS391 Mobile Application Development Lab
 */
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.intentdemo.EXTRA_MESSAGE";
    public static final String EXTRA_TIMESTAMP = "com.example.intentdemo.EXTRA_TIMESTAMP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etMessage = findViewById(R.id.etMessage);

        // 3.1 Explicit Intent Demonstration
        findViewById(R.id.btnLaunchExplicit).setOnClickListener(v -> {
            String message = etMessage.getText().toString().trim();
            if (message.isEmpty()) {
                message = "Default SCS391 Practical Payload";
            }

            Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
            explicitIntent.putExtra(EXTRA_MESSAGE, message);
            explicitIntent.putExtra(EXTRA_TIMESTAMP, System.currentTimeMillis());
            startActivity(explicitIntent);
        });

        // 3.2 Implicit Intent (Action A: Open Website)
        findViewById(R.id.btnOpenWeb).setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://developer.android.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            try {
                startActivity(webIntent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "No web browser application found", Toast.LENGTH_SHORT).show();
            }
        });

        // 3.2 Implicit Intent (Action B: Open Phone Dialer)
        findViewById(R.id.btnOpenDialer).setOnClickListener(v -> {
            Uri phoneUri = Uri.parse("tel:9876543210");
            Intent dialerIntent = new Intent(Intent.ACTION_DIAL, phoneUri);
            try {
                startActivity(dialerIntent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "No phone dialer application found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

### 6.2 `SecondActivity.java`
```java
package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Target Activity for Explicit Intent Demonstration.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvReceivedMessage = findViewById(R.id.tvReceivedMessage);
        TextView tvTimestamp = findViewById(R.id.tvTimestamp);

        // Retrieve passed extras from the invoking Intent
        Intent incomingIntent = getIntent();
        String message = incomingIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        long timestamp = incomingIntent.getLongExtra(MainActivity.EXTRA_TIMESTAMP, 0L);

        if (message != null) {
            tvReceivedMessage.setText(message);
        } else {
            tvReceivedMessage.setText("No message received");
        }

        if (timestamp > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            tvTimestamp.setText("Received at: " + sdf.format(new Date(timestamp)));
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}
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
        android:theme="@style/Theme.IntentDemo">

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
            android:exported="false"
            android:label="@string/second_activity_title" />

    </application>

</manifest>
```

---

## 7. Output & Hardware Execution Evidence

The application was installed and verified on the OnePlus CPH2661 test smartphone via ADB.

- **Main Demonstration Screen:** `Practical_Screenshots/Practical_03/P03_Main_Screen.png`
- **Explicit Intent Execution:** `Practical_Screenshots/Practical_03/P03_Explicit_Intent_Result.png`
- **Implicit Intent (Phone Dialer):** `Practical_Screenshots/Practical_03/P03_Implicit_Intent_Dialer.png`
- **Implicit Intent (Web Browser):** `Practical_Screenshots/Practical_03/P03_Implicit_Intent_Web.png`

## 8. Expected Output
1. Pressing "Launch Second Activity" opens `SecondActivity` displaying the user-entered payload message and formatted timestamp.
2. Pressing "Open Phone Dialer" launches the native phone dialer with `9876543210` prefilled.
3. Pressing "Open Website" launches the system web browser pointing to `developer.android.com`.

## 9. Result & Conclusion
The Intent demonstration application was successfully developed, installed, and validated on physical Android hardware. The principles of explicit inter-activity navigation with data passing and implicit intent delegation to system applications were fully demonstrated.


---

# PRACTICAL 04

## 1. Title
Development of an Appointment Form Application Demonstrating ImageButton, Spinner, DatePicker, TimePicker, and ListView.

## 2. Aim
To develop a complete, validated Appointment Form Android application in Java demonstrating the integration and user interaction of five native Android components:
1. `ImageButton` for interactive service selection.
2. `Spinner` for category/department selection.
3. `DatePicker` for scheduling the appointment date.
4. `TimePicker` for selecting the appointment time.
5. `ListView` for dynamically rendering submitted appointment records.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio (AI-262 / Ladybug / Meerkat)
- **Language:** Java (JDK 21 LTS)
- **Build System:** Gradle 9.1.0 with Android Gradle Plugin 9.0.1
- **Compile SDK:** API 36 (Android 16) | **Min SDK:** API 24 (Android 7.0)
- **Required Android Widgets:**
  - `android.widget.ImageButton`
  - `android.widget.Spinner`
  - `android.widget.DatePicker`
  - `android.widget.TimePicker`
  - `android.widget.ListView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36, USB Debugging)

## 4. Theoretical Background

### 4.1 ImageButton Component
An `ImageButton` is a standard button widget displaying an arbitrary image drawable rather than text. It responds to standard click events (`View.OnClickListener`) and supports dynamic drawable mutation via `setImageResource(int resId)` to convey application state changes visually.

### 4.2 Spinner Component
A `Spinner` provides a drop-down menu that allows users to select one value from a predefined set of choices. In Java, an `ArrayAdapter` bridges between the backend array of string items and the visual dropdown list presentation.

### 4.3 DatePicker & TimePicker Components
`DatePicker` and `TimePicker` are native compound widgets for selecting calendar dates and wall-clock times:
- `DatePicker`: Provides getters `getYear()`, `getMonth()`, and `getDayOfMonth()`.
- `TimePicker`: Provides getters `getHour()` and `getMinute()` with 12-hour or 24-hour display configuration (`setIs24HourView`).

### 4.4 ListView & Custom Adapter
A `ListView` is a ViewGroup that displays a vertically scrollable collection of items. Rather than hardcoding static rows, an `ArrayAdapter<T>` or `BaseAdapter` dynamically inflates view items via `getView()`, recycling child views (`convertView`) for efficient memory usage.

---

## 5. Algorithm & Procedure

1. **Form Layout Construction (`activity_main.xml`):**
   - Place an `EditText` for the patient's full name.
   - Insert an `ImageButton` paired with a `TextView` to visually indicate and toggle between medical service types.
   - Embed a `Spinner` for department selection.
   - Embed native `DatePicker` and `TimePicker` widgets.
   - Include a primary submit `MaterialButton`.
   - Place a `ListView` (`@+id/lvAppointments`) below the form to display submitted appointments.
2. **Adapter & View Recycling (`item_appointment.xml` & `AppointmentAdapter.java`):**
   - Create a model class `Appointment` storing patient name, service type, department, date, and time.
   - Create a custom `ArrayAdapter<Appointment>` that binds `Appointment` properties to individual Material Cards inside the `ListView`.
3. **Event Listeners & State Logic (`MainActivity.java`):**
   - Attach an `OnClickListener` to `ImageButton` to cycle service type on each tap.
   - Populate `Spinner` with department categories using `ArrayAdapter<String>`.
   - Initialize `TimePicker` to 10:30 AM.
   - In `submitAppointment()`:
     - Validate that patient name is non-empty.
     - Extract values from `datePicker` (`getYear()`, `getMonth() + 1`, `getDayOfMonth()`).
     - Extract values from `timePicker` (`getHour()`, `getMinute()`).
     - Instantiate a new `Appointment` object and insert it into `appointmentList`.
     - Call `appointmentAdapter.notifyDataSetChanged()` to update the live `ListView`.
4. **Hardware Validation:**
   - Assemble debug APK: `./gradlew assembleDebug`.
   - Install onto OnePlus CPH2661 via `adb install -r <apk>`.
   - Exercise form inputs, interact with DatePicker and TimePicker, submit appointment, and capture genuine hardware screenshots.

---

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.appointmentform;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etPatientName;
    private ImageButton ibServiceIcon;
    private TextView tvSelectedService;
    private Spinner spnCategory;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private ListView lvAppointments;

    private final String[] services = {
            "General Consultation",
            "Dental Checkup",
            "Cardiology Review"
    };
    private final int[] serviceIcons = {
            android.R.drawable.ic_menu_agenda,
            android.R.drawable.ic_menu_my_calendar,
            android.R.drawable.ic_menu_add
    };
    private int currentServiceIndex = 0;

    private final ArrayList<Appointment> appointmentList = new ArrayList<>();
    private AppointmentAdapter appointmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPatientName = findViewById(R.id.etPatientName);
        ibServiceIcon = findViewById(R.id.ibServiceIcon);
        tvSelectedService = findViewById(R.id.tvSelectedService);
        spnCategory = findViewById(R.id.spnCategory);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        lvAppointments = findViewById(R.id.lvAppointments);

        // 1. ImageButton: Cycle service on tap
        ibServiceIcon.setOnClickListener(v -> {
            currentServiceIndex = (currentServiceIndex + 1) % services.length;
            tvSelectedService.setText(services[currentServiceIndex]);
            ibServiceIcon.setImageResource(serviceIcons[currentServiceIndex]);
            Toast.makeText(this, "Service: " + services[currentServiceIndex], Toast.LENGTH_SHORT).show();
        });

        // 2. Spinner: Department categories
        String[] categories = {
                "General Medicine",
                "Dental Surgery",
                "Cardiovascular Care",
                "Dermatology Clinic",
                "Pediatric Health"
        };
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                categories
        );
        spnCategory.setAdapter(spinnerAdapter);

        // 3. TimePicker: 12-hour format configuration
        timePicker.setIs24HourView(false);
        timePicker.setHour(10);
        timePicker.setMinute(30);

        // 4. ListView: Dynamic adapter binding
        appointmentAdapter = new AppointmentAdapter(this, appointmentList);
        lvAppointments.setAdapter(appointmentAdapter);

        // Submit Button
        findViewById(R.id.btnSubmitAppointment).setOnClickListener(v -> submitAppointment());
    }

    private void submitAppointment() {
        String patientName = etPatientName.getText().toString().trim();
        if (patientName.isEmpty()) {
            etPatientName.setError("Patient name is required");
            etPatientName.requestFocus();
            Toast.makeText(this, "Please enter patient name", Toast.LENGTH_SHORT).show();
            return;
        }

        String serviceType = services[currentServiceIndex];
        String category = spnCategory.getSelectedItem().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        String formattedDate = String.format(Locale.getDefault(), "%04d-%02d-%02d", year, month, day);

        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        String amPm = (hour >= 12) ? "PM" : "AM";
        int displayHour = (hour % 12 == 0) ? 12 : (hour % 12);
        String formattedTime = String.format(Locale.getDefault(), "%02d:%02d %s", displayHour, minute, amPm);

        Appointment newAppointment = new Appointment(
                patientName,
                serviceType,
                category,
                formattedDate,
                formattedTime
        );

        appointmentList.add(0, newAppointment);
        appointmentAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Appointment Booked: " + patientName, Toast.LENGTH_SHORT).show();
        etPatientName.setText("");
    }
}
```

### 6.2 `Appointment.java`
```java
package com.example.appointmentform;

public class Appointment {
    private final String patientName;
    private final String serviceType;
    private final String category;
    private final String date;
    private final String time;

    public Appointment(String patientName, String serviceType, String category, String date, String time) {
        this.patientName = patientName;
        this.serviceType = serviceType;
        this.category = category;
        this.date = date;
        this.time = time;
    }

    public String getPatientName() { return patientName; }
    public String getServiceType() { return serviceType; }
    public String getCategory() { return category; }
    public String getDate() { return date; }
    public String getTime() { return time; }
}
```

---

## 7. Output & Hardware Execution Evidence

The application was installed on the OnePlus CPH2661 test device and tested through its complete booking lifecycle.

- **Appointment Form Screen:** `Practical_Screenshots/Practical_04/P04_Appointment_Form.png`
- **DatePicker & TimePicker Interaction:** `Practical_Screenshots/Practical_04/P04_DateTime_Selection.png`
- **Submitted Appointment in Dynamic ListView:** `Practical_Screenshots/Practical_04/P04_Appointment_Submitted.png`

## 8. Expected Output
1. The user inputs patient details, selects service via `ImageButton`, chooses category from `Spinner`, and adjusts `DatePicker` and `TimePicker`.
2. Pressing "Confirm & Book Appointment" creates a new entry at the top of the `ListView` displaying the exact patient name, service, department, formatted date, and time.

## 9. Result & Conclusion
The Appointment Form application successfully incorporated `ImageButton`, `Spinner`, `DatePicker`, `TimePicker`, and a live dynamic `ListView`. All validation, scheduling, and dynamic list rendering operations were verified on physical Android hardware.


---

# PRACTICAL 05

## 1. Title
Demonstration of Portrait and Landscape Screen Orientation Detection and Adaptive Layouts.

## 2. Aim
To develop an Android application in Java that programmatically detects the device's current screen orientation (Portrait or Landscape), displays an appropriate message and screen metrics, and automatically utilizes resource qualifiers (`res/layout` vs `res/layout-land`) to adapt its layout to both orientations.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio (AI-262 / Ladybug / Meerkat)
- **Language:** Java (JDK 21 LTS)
- **Build System:** Gradle 9.1.0 with Android Gradle Plugin 9.0.1
- **Compile SDK:** API 36 (Android 16) | **Min SDK:** API 24 (Android 7.0)
- **Core APIs:** `android.content.res.Configuration`, `android.util.DisplayMetrics`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36, USB Debugging)

## 4. Theoretical Background

### 4.1 Runtime Configuration Changes
In Android, changes in device configuration—such as rotating from portrait to landscape—trigger a runtime event. By default, the Android system terminates the running activity (invoking `onPause()`, `onStop()`, and `onDestroy()`) and recreates it (`onCreate()`, `onStart()`, `onResume()`). This recreation mechanism ensures that the application automatically re-queries resources and selects layouts that best match the new configuration.

### 4.2 Resource Qualifiers (`layout` vs `layout-land`)
Android allows developers to provide alternative layout directories by appending qualifiers to resource folder names:
- `res/layout/`: Default layout directory, predominantly utilized for Portrait viewports.
- `res/layout-land/`: Qualified directory automatically selected by the Android resource manager whenever the device is in Landscape orientation (`Configuration.ORIENTATION_LANDSCAPE`).

### 4.3 Programmatic Orientation Detection
An Activity can inspect its current orientation at runtime using:
```java
int orientation = getResources().getConfiguration().orientation;
if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
    // Landscape Mode
} else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
    // Portrait Mode
}
```

---

## 5. Algorithm & Procedure

1. **Layout Design:**
   - Create `res/layout/activity_main.xml` containing a vertically stacked `MaterialCardView` with a teal accent theme indicating Portrait mode.
   - Create `res/layout-land/activity_main.xml` containing a two-column horizontal layout with an orange accent theme indicating Landscape mode.
2. **Activity Implementation (`MainActivity.java`):**
   - In `onCreate()`, call `setContentView(R.layout.activity_main)` to allow Android to load the orientation-appropriate layout.
   - Query `getResources().getConfiguration().orientation`.
   - Query `getResources().getDisplayMetrics()` to retrieve width, height, and pixel density.
   - Update `tvOrientationMessage`, `tvModeBadge`, and `tvDimensions` accordingly.
3. **Manifest Configuration:**
   - In `AndroidManifest.xml`, ensure no orientation locks (`android:screenOrientation`) are declared, allowing natural hardware rotation.
4. **Hardware Verification:**
   - Install APK on OnePlus CPH2661.
   - Test initial launch in Portrait mode (`user_rotation 0`) and capture screenshot.
   - Rotate device to Landscape mode (`user_rotation 1`), verify automatic recreation, and capture screenshot.
   - Restore device orientation.

---

## 6. Source Code

### 6.1 `MainActivity.java`
```java
package com.example.screenorientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 05: Portrait and Landscape Screen Orientation
 * Course: SCS391 Mobile Application Development Lab
 */
public class MainActivity extends AppCompatActivity {

    private TextView tvOrientationMessage;
    private TextView tvDimensions;
    private TextView tvModeBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Automatically selects res/layout/activity_main.xml or res/layout-land/activity_main.xml
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
            tvDimensions.setText(String.format("Dimensions: %d x %d px | %d dpi (Wide Aspect)", width, height, density));
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            tvOrientationMessage.setText(R.string.msg_portrait);
            tvModeBadge.setText("PORTRAIT MODE");
            tvDimensions.setText(String.format("Dimensions: %d x %d px | %d dpi (Tall Aspect)", width, height, density));
        } else {
            tvOrientationMessage.setText("ORIENTATION UNDEFINED");
            tvDimensions.setText(String.format("Dimensions: %d x %d px", width, height));
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateOrientationDetails();
    }
}
```

### 6.2 `res/layout/activity_main.xml` (Portrait)
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
        android:id="@+id/cardOrientation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardCornerRadius="16dp"
        app:cardElevation="6dp"
        app:cardBackgroundColor="@color/surface"
        app:strokeWidth="2dp"
        app:strokeColor="@color/portrait_accent"
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
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/lab_header"
                android:textColor="@color/primary"
                android:textSize="13sp"
                android:textStyle="bold"
                android:letterSpacing="0.05"
                android:layout_marginBottom="8dp"/>

            <TextView
                android:id="@+id/tvModeBadge"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="PORTRAIT ORIENTATION"
                android:textColor="@color/surface"
                android:background="@color/portrait_accent"
                android:paddingHorizontal="16dp"
                android:paddingVertical="6dp"
                android:textSize="12sp"
                android:textStyle="bold"
                android:layout_marginBottom="16dp"/>

            <TextView
                android:id="@+id/tvOrientationMessage"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/msg_portrait"
                android:textColor="@color/portrait_accent"
                android:textSize="22sp"
                android:textStyle="bold"
                android:gravity="center"
                android:layout_marginBottom="10dp"/>

            <TextView
                android:id="@+id/tvLayoutSource"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/sub_portrait"
                android:textColor="@color/text_secondary"
                android:textSize="13sp"
                android:gravity="center"
                android:layout_marginBottom="24dp"/>

            <TextView
                android:id="@+id/tvDimensions"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Resolution: Detecting..."
                android:textColor="@color/text_primary"
                android:textSize="13sp"
                android:background="#EDE7F6"
                android:padding="12dp"
                android:gravity="center"
                android:layout_marginBottom="16dp"/>

            <com.google.android.material.button.MaterialButton
                android:id="@+id/btnRefresh"
                android:layout_width="match_parent"
                android:layout_height="50dp"
                android:text="@string/btn_refresh_info"
                android:textSize="14sp"
                app:cornerRadius="10dp"/>

        </LinearLayout>
    </com.google.android.material.card.MaterialCardView>

</androidx.constraintlayout.widget.ConstraintLayout>
```

---

## 7. Output & Hardware Execution Evidence

The application was tested across both hardware orientations on the OnePlus CPH2661 device:

- **Portrait Screen Output:** `Practical_Screenshots/Practical_05/P05_Portrait_Mode.png` (Resolution: 1240 x 2772 px)
- **Landscape Screen Output:** `Practical_Screenshots/Practical_05/P05_Landscape_Mode.png` (Resolution: 2772 x 1240 px)

## 8. Expected Output
1. In portrait mode, the vertical layout renders with the message "PORTRAIT MODE DETECTED" and dimensions `1240 x 2772 px`.
2. When rotated to landscape, the two-column horizontal layout renders with the message "LANDSCAPE MODE DETECTED" and dimensions `2772 x 1240 px`.

## 9. Result & Conclusion
The Screen Orientation application successfully demonstrated dynamic runtime orientation detection and resource qualification (`layout` vs `layout-land`). Both portrait and landscape orientations were verified on physical Android hardware.
