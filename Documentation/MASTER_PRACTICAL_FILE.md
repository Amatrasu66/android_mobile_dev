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
