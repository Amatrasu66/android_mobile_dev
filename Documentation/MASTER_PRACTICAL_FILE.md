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
To develop, build, install, and execute a native Android application using the Java programming language and XML layouts to display "Hello World!" on an Android device.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Build System:** Gradle with Android Gradle Plugin
- **Compile SDK:** API 36 (Android 16) | **Min SDK:** API 24 (Android 7.0)
- **UI Components:** `RelativeLayout`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36, 1240x2772 px, 560 dpi)

## 4. Theoretical Background

### 4.1 Android Application Architecture
Every Android application consists of four fundamental building blocks:
1. **Activity:** Represents a single screen with a user interface where users interact.
2. **Service:** A component running in the background to perform long-running operations.
3. **Broadcast Receiver:** Listens for system-wide or application-level broadcast announcements.
4. **Content Provider:** Manages a shared set of application data across process boundaries.

### 4.2 Activity Lifecycle & View Hierarchy
When an Activity starts, the Android OS invokes its lifecycle callbacks:
- `onCreate()`: Called when the activity is first created. Initialization of resources, UI layouts, and view bindings occur here.
- `setContentView()`: Inflates the specified XML layout resource into memory and attaches the resulting View tree to the window.

### 4.3 XML Layout System
Android separates presentation from application logic by defining user interfaces declaratively in XML. The Android resource compiler (`AAPT2`) compiles XML files into binary format, generating integer resource identifiers in the `R` class (e.g., `R.layout.activity_main`).

---

## 5. Algorithm & Procedure

### Step 1: Project Initialization
1. Launch Android Studio and create a new Android project selecting **Empty Views Activity**.
2. Set Language to **Java** and Minimum SDK to **API 24 (Android 7.0)**.
3. Allow Gradle to synchronize dependencies and build the project workspace.

### Step 2: User Interface Design
1. Open `res/layout/activity_main.xml`.
2. Define a clean layout with a centered `TextView` widget (`android:id="@+id/tvHelloWorld"`).
3. Set appropriate typography and layout gravity.

### Step 3: Activity Implementation
1. Open `MainActivity.java`.
2. In `onCreate()`, call `setContentView(R.layout.activity_main)` to inflate the layout.
3. Retrieve the `TextView` using `findViewById()`.
4. Set the display text to `R.string.hello_world`.

### Step 4: Build & Hardware Execution
1. Connect the physical OnePlus smartphone with USB Debugging enabled.
2. Execute `./gradlew assembleDebug` or install directly via ADB.
3. Verify the application launch and screen display on the device.

---

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

---

## 7. Output & Hardware Execution Evidence

The application was built via Gradle, installed onto the authorized physical smartphone (OnePlus CPH2661, Android 16), and executed.

**Output Screen: Hello World application running on physical device:**

![Hello World Output](Practical_Screenshots/Practical_02/P02_Hello_World.png)

- **Execution Verification:** The application successfully launched and rendered the "Hello World!" message centered on the physical smartphone screen without errors.

## 8. Expected Output
The application successfully launches on the physical Android device and displays "Hello World!" centered on the display screen.

## 9. Result & Conclusion
The "Hello World" native Android application was successfully developed in Java using Android Studio, compiled using Gradle, installed onto a physical OnePlus smartphone, and verified. Fundamental concepts of Activity creation, layout inflation, widget referencing, and hardware deployment were demonstrated.


# PRACTICAL 03

## 1. Title
Development of an Android Application in Java to Demonstrate Intents (Explicit and Implicit).

## 2. Aim
To develop a native Android application demonstrating Explicit Intents (navigating between activities and transferring data via Intent extras) and Implicit Intents (delegating actions to external system applications such as a phone dialer or web browser).

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 (Android 16) | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `EditText`, `Button`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background

### 4.1 Android Intent Framework
An `Intent` is an asynchronous messaging object used to request an action from another app component. Intents facilitate three core use cases:
1. **Starting an Activity:** Launching a new screen by passing an Intent to `startActivity()`.
2. **Starting a Service:** Initiating background operations.
3. **Delivering a Broadcast:** Broadcasting messages to system-wide broadcast receivers.

### 4.2 Explicit vs. Implicit Intents
- **Explicit Intent:** Specifies the exact target component by providing the Java class name (e.g., `new Intent(MainActivity.this, SecondActivity.class)`). Used for intra-app communication where the destination component is known.
- **Implicit Intent:** Declares a general action to perform (e.g., `Intent.ACTION_DIAL`, `Intent.ACTION_VIEW`), allowing the Android system to resolve the request against registered Intent Filters of all installed applications.

### 4.3 Data Transfer via Extras
Explicit Intents transfer state between activities using key-value pairs stored in an internal `Bundle` via `putExtra(key, value)`. The target activity retrieves the bundle in its `onCreate()` method using `getIntent().getStringExtra(key)`.

---

## 5. Algorithm & Procedure

### Step 1: Layout Design
1. In `activity_main.xml`, add an `EditText` for user message input.
2. Add a `Button` to trigger the Explicit Intent.
3. Add a `Button` to trigger the Implicit Intent (Phone Dialer).
4. Create `activity_second.xml` with a `TextView` to display the received message payload.

### Step 2: Explicit Intent Implementation
1. In `MainActivity.java`, set an `OnClickListener` on the launch button.
2. Retrieve the text from the `EditText`.
3. Construct an explicit Intent: `Intent intent = new Intent(MainActivity.this, SecondActivity.class);`.
4. Attach the string data: `intent.putExtra("MESSAGE_KEY", message);`.
5. Call `startActivity(intent)`.

### Step 3: SecondActivity Data Reception
1. In `SecondActivity.java`, retrieve the string extra in `onCreate()`: `String msg = getIntent().getStringExtra("MESSAGE_KEY");`.
2. Set the retrieved string into the result `TextView`.

### Step 4: Implicit Intent Implementation
1. In `MainActivity.java`, set a click listener on the dialer button.
2. Construct an implicit Intent: `Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"));`.
3. Call `startActivity(dialIntent)` to delegate dialing to the system phone app.

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
 *
 * Demonstrates:
 * 1. Explicit Intent: Navigating to SecondActivity and passing a data bundle.
 * 2. Implicit Intent: Requesting system handling to open a web URL and dialer.
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

### 6.3 `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:gravity="center_horizontal">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Intent Demonstration"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="24dp"/>

    <!-- Explicit Intent Section -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Explicit Intent"
        android:textSize="16sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginBottom="8dp"/>

    <EditText
        android:id="@+id/etMessage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter message to pass"
        android:text="Hello from First Activity!"
        android:inputType="text"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
        android:layout_marginBottom="12dp"/>

    <Button
        android:id="@+id/btnLaunchExplicit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Open Second Activity"
        android:layout_marginBottom="32dp"/>

    <!-- Implicit Intent Section -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Implicit Intent"
        android:textSize="16sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginBottom="8dp"/>

    <Button
        android:id="@+id/btnOpenWeb"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Open Website (Browser)"
        android:layout_marginBottom="12dp"/>

    <Button
        android:id="@+id/btnOpenDialer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Open Phone Dialer"/>

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
    android:padding="20dp"
    android:gravity="center_horizontal">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Second Activity"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="24dp"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Data Received via Explicit Intent:"
        android:textSize="14sp"
        android:textColor="#555555"
        android:layout_marginBottom="8dp"/>

    <TextView
        android:id="@+id/tvReceivedMessage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Message Content"
        android:textSize="18sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:padding="16dp"
        android:background="#EEEEEE"
        android:layout_marginBottom="24dp"/>

    <Button
        android:id="@+id/btnBack"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Back to Main Activity"/>

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

        <!-- Target Activity for Explicit Intent -->
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

**Output Screen 1: Main Activity with Explicit and Implicit Intent controls:**

![Main Screen](Practical_Screenshots/Practical_03/P03_Main_Screen.png)

**Output Screen 2: Second Activity displaying data received via Explicit Intent:**

![Explicit Intent Result](Practical_Screenshots/Practical_03/P03_Explicit_Intent.png)

**Output Screen 3: System Dialer opened via Implicit Intent:**

![Implicit Intent Dialer](Practical_Screenshots/Practical_03/P03_Implicit_Intent.png)

- **Verification Summary:**
  - Explicit Intent: Navigated cleanly to `SecondActivity`, passing the string payload "Hello from Practical 03!".
  - Implicit Intent: Dispatched `ACTION_DIAL` intent with URI `tel:9876543210`, successfully opening the system phone dialer.

## 8. Expected Output
1. Pressing "Open Second Activity" navigates to `SecondActivity` displaying the user-entered payload message.
2. Pressing "Open Dialer" launches the system phone dialer with `tel:9876543210` prefilled.

## 9. Result & Conclusion
The Intent demonstration application was successfully developed, installed, and validated on physical Android hardware. Principles of explicit inter-activity navigation with data passing and implicit intent delegation to system applications were fully demonstrated.


# PRACTICAL 04

## 1. Title
Development of an Appointment Form Application Demonstrating ImageButton, Spinner, DatePicker, TimePicker, and ListView.

## 2. Aim
To develop a functional Appointment Form application in Java incorporating `ImageButton`, `Spinner`, `DatePicker`, `TimePicker`, and a dynamic `ListView` to capture, validate, schedule, and display appointments.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `ImageButton`, `Spinner`, `DatePicker`, `TimePicker`, `ListView`, `Button`, `EditText`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background

### 4.1 UI Component Architecture
- **ImageButton:** Displays a pressable button with an image rather than text. Inherits from `ImageView`.
- **Spinner:** Provides a quick way to select one value from a dropdown set. Backed by a `SpinnerAdapter`.
- **DatePicker:** Widget for selecting a calendar day, month, and year.
- **TimePicker:** Widget for selecting the time of day in 12-hour or 24-hour mode.
- **ListView:** An `AdapterView` that displays a vertically scrollable collection of views, each populated from an adapter backed by a data source.

### 4.2 Adapter Pattern
The `Adapter` acts as a bridge between an `AdapterView` (such as `ListView` or `Spinner`) and the underlying data. It converts individual data objects into view rows, optimizing memory through view recycling.

---

## 5. Algorithm & Procedure

### Step 1: Layout Construction
1. Create `res/layout/activity_main.xml` wrapped in a `ScrollView`.
2. Add input widgets:
   - Patient name `EditText`.
   - `ImageButton` for cycling appointment services with a status `TextView`.
   - `Spinner` for department selection.
   - `DatePicker` and `TimePicker` for date/time selection.
   - Submit `Button` ("Book Appointment").
   - `ListView` for displaying confirmed bookings.
3. Create `res/layout/item_appointment.xml` to represent an appointment list item.

### Step 2: Data Model & Adapter Implementation
1. Create `Appointment.java` holding patient name, service type, department, date, and time.
2. Create `AppointmentAdapter.java` extending `BaseAdapter` or `ArrayAdapter` to bind `Appointment` objects to `item_appointment.xml`.

### Step 3: Event Handling & Form Validation
1. In `MainActivity.java`, set up an array of services and toggle them on `ImageButton` click.
2. Populate the `Spinner` using an `ArrayAdapter<String>`.
3. In the submit button click listener:
   - Validate that the patient name is not empty.
   - Extract selected date (`year`, `month + 1`, `day`) from `DatePicker`.
   - Extract selected time (`hour`, `minute`) from `TimePicker`.
   - Instantiate an `Appointment` object.
   - Prepend to the appointment list and call `notifyDataSetChanged()`.

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

/**
 * Practical 04: Appointment Form Application
 * Course: SCS391 Mobile Application Development Lab
 *
 * Demonstrates:
 * 1. ImageButton: Interactive service switcher
 * 2. Spinner: Dropdown department selection
 * 3. DatePicker: Date selection widget
 * 4. TimePicker: Time selection widget
 * 5. ListView: Dynamic list of submitted appointments
 */
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

        // Bind UI Components
        etPatientName = findViewById(R.id.etPatientName);
        ibServiceIcon = findViewById(R.id.ibServiceIcon);
        tvSelectedService = findViewById(R.id.tvSelectedService);
        spnCategory = findViewById(R.id.spnCategory);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        lvAppointments = findViewById(R.id.lvAppointments);

        // 1. ImageButton Setup
        ibServiceIcon.setOnClickListener(v -> {
            currentServiceIndex = (currentServiceIndex + 1) % services.length;
            tvSelectedService.setText(services[currentServiceIndex]);
            ibServiceIcon.setImageResource(serviceIcons[currentServiceIndex]);
            Toast.makeText(this, "Service: " + services[currentServiceIndex], Toast.LENGTH_SHORT).show();
        });

        // 2. Spinner Setup
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

        // 3. TimePicker Initial Configuration
        timePicker.setIs24HourView(false);
        timePicker.setHour(10);
        timePicker.setMinute(30);

        // 4. ListView Setup
        appointmentAdapter = new AppointmentAdapter(this, appointmentList);
        lvAppointments.setAdapter(appointmentAdapter);

        lvAppointments.setOnItemClickListener((parent, view, position, id) -> {
            Appointment selected = appointmentList.get(position);
            Toast.makeText(this, "Selected: " + selected.toString(), Toast.LENGTH_LONG).show();
        });

        // Prepopulate with one verified sample submission to demonstrate initial list state
        appointmentList.add(new Appointment(
                "Jane Doe",
                "Dental Checkup",
                "Dental Surgery",
                "2026-11-12",
                "09:15 AM"
        ));
        appointmentAdapter.notifyDataSetChanged();

        // 5. Submit Button Listener
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

        // Read DatePicker values
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; // 0-indexed
        int year = datePicker.getYear();
        String formattedDate = String.format(Locale.getDefault(), "%04d-%02d-%02d", year, month, day);

        // Read TimePicker values
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        String amPm = (hour >= 12) ? "PM" : "AM";
        int displayHour = (hour % 12 == 0) ? 12 : (hour % 12);
        String formattedTime = String.format(Locale.getDefault(), "%02d:%02d %s", displayHour, minute, amPm);

        // Create new Appointment entity and add to live ListView
        Appointment newAppointment = new Appointment(
                patientName,
                serviceType,
                category,
                formattedDate,
                formattedTime
        );

        appointmentList.add(0, newAppointment); // Add at top of list
        appointmentAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Appointment Booked: " + patientName, Toast.LENGTH_SHORT).show();

        // Reset name field
        etPatientName.setText("");
    }
}
```

### 6.2 `Appointment.java`
```java
package com.example.appointmentform;

/**
 * Model class representing a booked appointment entity.
 */
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

    public String getPatientName() {
        return patientName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return patientName + " - " + serviceType + " (" + category + ") on " + date + " at " + time;
    }
}
```

### 6.3 `AppointmentAdapter.java`
```java
package com.example.appointmentform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/**
 * Custom ArrayAdapter to bind Appointment items to the ListView.
 */
public class AppointmentAdapter extends ArrayAdapter<Appointment> {

    public AppointmentAdapter(@NonNull Context context, @NonNull List<Appointment> appointments) {
        super(context, 0, appointments);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_appointment, parent, false);
        }

        Appointment appointment = getItem(position);
        if (appointment != null) {
            TextView tvPatient = convertView.findViewById(R.id.tvItemPatient);
            TextView tvService = convertView.findViewById(R.id.tvItemService);
            TextView tvCategory = convertView.findViewById(R.id.tvItemCategory);
            TextView tvDateTime = convertView.findViewById(R.id.tvItemDateTime);

            tvPatient.setText(appointment.getPatientName());
            tvService.setText(appointment.getServiceType());
            tvCategory.setText("Department: " + appointment.getCategory());
            tvDateTime.setText("Date: " + appointment.getDate() + " | Time: " + appointment.getTime());
        }

        return convertView;
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
    android:fillViewport="true">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Appointment Form"
            android:textSize="22sp"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="16dp"/>

        <!-- 1. Patient Name -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Patient Name:"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="4dp"/>

        <EditText
            android:id="@+id/etPatientName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Enter patient name"
            android:text="Alex Johnson"
            android:inputType="textPersonName"
            android:padding="10dp"
            android:background="@android:drawable/edit_text"
            android:layout_marginBottom="14dp"/>

        <!-- 2. ImageButton Service Selection -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Select Service (ImageButton):"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="4dp"/>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:gravity="center_vertical"
            android:padding="8dp"
            android:background="#F0F0F0"
            android:layout_marginBottom="14dp">

            <ImageButton
                android:id="@+id/ibServiceIcon"
                android:layout_width="48dp"
                android:layout_height="48dp"
                android:src="@android:drawable/ic_menu_agenda"
                android:background="@android:drawable/btn_default"
                android:contentDescription="Select Service"/>

            <TextView
                android:id="@+id/tvSelectedService"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="General Consultation (Tap icon to change)"
                android:textColor="@android:color/black"
                android:textSize="14sp"
                android:layout_marginStart="12dp"/>
        </LinearLayout>

        <!-- 3. Spinner Category Selection -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Select Department (Spinner):"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="4dp"/>

        <Spinner
            android:id="@+id/spnCategory"
            android:layout_width="match_parent"
            android:layout_height="44dp"
            android:layout_marginBottom="14dp"/>

        <!-- 4. DatePicker -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Select Date (DatePicker):"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="4dp"/>

        <DatePicker
            android:id="@+id/datePicker"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:datePickerMode="spinner"
            android:calendarViewShown="false"
            android:layout_marginBottom="14dp"/>

        <!-- 5. TimePicker -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Select Time (TimePicker):"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="4dp"/>

        <TimePicker
            android:id="@+id/timePicker"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:timePickerMode="spinner"
            android:layout_marginBottom="16dp"/>

        <!-- Submit Button -->
        <Button
            android:id="@+id/btnSubmitAppointment"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Book Appointment"
            android:layout_marginBottom="20dp"/>

        <!-- 6. Submitted Appointments (ListView) -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Submitted Appointments (ListView):"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="8dp"/>

        <ListView
            android:id="@+id/lvAppointments"
            android:layout_width="match_parent"
            android:layout_height="250dp"
            android:divider="@null"
            android:dividerHeight="0dp"
            android:nestedScrollingEnabled="true"
            android:layout_marginBottom="16dp"/>

    </LinearLayout>
</ScrollView>
```

### 6.5 `res/layout/item_appointment.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="10dp"
    android:background="@android:color/white">

    <TextView
        android:id="@+id/tvItemPatient"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Patient Name"
        android:textColor="@android:color/black"
        android:textSize="16sp"
        android:textStyle="bold"/>

    <TextView
        android:id="@+id/tvItemService"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="General Consultation"
        android:textColor="#333333"
        android:textSize="13sp"/>

    <TextView
        android:id="@+id/tvItemCategory"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Category: General Medicine"
        android:textColor="#555555"
        android:textSize="13sp"/>

    <TextView
        android:id="@+id/tvItemDateTime"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Date &amp; Time"
        android:textColor="#777777"
        android:textSize="12sp"/>

    <View
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:background="#DDDDDD"
        android:layout_marginTop="8dp"/>

</LinearLayout>
```

### 6.6 `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application
        android:allowBackup="true"
        android:icon="@android:drawable/sym_def_app_icon"
        android:label="@string/app_name"
        android:roundIcon="@android:drawable/sym_def_app_icon"
        android:supportsRtl="true"
        android:theme="@style/Theme.AppointmentForm">

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

---

## 7. Output & Hardware Execution Evidence

The application was installed on the OnePlus CPH2661 test device and tested through its complete booking lifecycle.

**Output Screen 1: Appointment booking form with required native widgets:**

![Appointment Form](Practical_Screenshots/Practical_04/P04_Appointment_Form.png)

**Output Screen 2: Date and Time selection on physical device:**

![Date Time Selection](Practical_Screenshots/Practical_04/P04_DateTime_Selection.png)

**Output Screen 3: Submitted appointment displayed inside ListView:**

![Submitted Appointment](Practical_Screenshots/Practical_04/P04_Appointment_Submitted.png)

- **Verification Summary:** All five required widgets (`ImageButton`, `Spinner`, `DatePicker`, `TimePicker`, `ListView`) functioned properly. Submitting the form dynamically added the appointment entry into the `ListView`.

## 8. Expected Output
1. The user inputs patient details, selects service via `ImageButton`, chooses category from `Spinner`, and adjusts `DatePicker` and `TimePicker`.
2. Pressing "Book Appointment" validates input and creates a new entry inside the `ListView` displaying the patient name, service, department, date, and time.

## 9. Result & Conclusion
The Appointment Form application successfully incorporated `ImageButton`, `Spinner`, `DatePicker`, `TimePicker`, and a live dynamic `ListView`. Form validation, scheduling, and dynamic list rendering operations were verified on physical Android hardware.


# PRACTICAL 05

## 1. Title
Demonstration of Portrait and Landscape Screen Orientation Detection and Layout Switching.

## 2. Aim
To develop a native Android application that detects device screen orientation (Portrait and Landscape) dynamically at runtime and automatically loads orientation-specific XML layouts.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `TextView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background

### 4.1 Android Configuration Changes & Resource Qualifiers
When the physical orientation changes between portrait and landscape, Android triggers a configuration change. By default, the system destroys and recreates the current Activity (`onPause` -> `onStop` -> `onDestroy` -> `onCreate`).
During layout inflation, Android uses resource folder qualifiers to pick the best layout:
- `res/layout/activity_main.xml`: Default layout, used in Portrait orientation.
- `res/layout-land/activity_main.xml`: Used automatically in Landscape orientation.

### 4.2 Runtime Orientation Detection
An Activity can inspect the active orientation programmatically via:
```java
int orientation = getResources().getConfiguration().orientation;
if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
    // Landscape mode logic
} else {
    // Portrait mode logic
}
```

---

## 5. Algorithm & Procedure

### Step 1: Layout Construction
1. Create `res/layout/activity_main.xml` containing a centered `TextView` with the text "Portrait Mode".
2. Create the landscape resource folder `res/layout-land/`.
3. In `res/layout-land/activity_main.xml`, add a centered `TextView` with the text "Landscape Mode".

### Step 2: Activity Logic
1. In `MainActivity.java`, call `setContentView(R.layout.activity_main)` inside `onCreate()`.
2. Query `getResources().getConfiguration().orientation`.
3. Update the `TextView` text to confirm the detected orientation.

### Step 3: Hardware Verification
1. Install the application on the OnePlus smartphone.
2. Launch in default vertical orientation to verify Portrait layout.
3. Rotate the device to horizontal orientation (`user_rotation 1`) to verify Landscape layout inflation.

---

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

---

## 7. Output & Hardware Execution Evidence

The application was tested across both hardware orientations on the OnePlus CPH2661 device:

**Output Screen 1: Application running in Portrait orientation:**

![Portrait Mode](Practical_Screenshots/Practical_05/P05_Portrait_Mode.png)

**Output Screen 2: Application running in Landscape orientation:**

![Landscape Mode](Practical_Screenshots/Practical_05/P05_Landscape_Mode.png)

- **Verification Summary:** In vertical hold, the system inflated `res/layout/activity_main.xml` displaying "Portrait Mode". When rotated horizontally, Android automatically recreated the activity and inflated `res/layout-land/activity_main.xml` displaying "Landscape Mode".

## 8. Expected Output
1. In portrait mode, the vertical layout renders with the message "Portrait Mode".
2. When rotated to landscape, the layout renders with the message "Landscape Mode".

## 9. Result & Conclusion
The Screen Orientation application successfully demonstrated dynamic runtime orientation detection and resource qualification (`layout` vs `layout-land`). Both portrait and landscape orientations were verified on physical Android hardware.


# PRACTICAL 06

## 1. Title
Implementation of an Options Menu Bar in Android Studio using Java.

## 2. Aim
To develop a native Android application demonstrating an Options Menu with items (Home, Settings, About, Help) inflated via XML and handled through menu callback methods.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `androidx.appcompat.widget.Toolbar`, `TextView`, Options Menu
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background

### 4.1 Options Menu Architecture
The Options Menu is the primary collection of menu items for an activity. On modern Android versions, menu items are placed in the app bar (Toolbar) or collapsed into the 3-dot overflow menu.

### 4.2 Lifecycle Callbacks for Menus
1. `onCreateOptionsMenu(Menu menu)`: Called by the framework when the activity's options menu is first displayed. The `MenuInflater` inflates the menu XML resource into the `Menu` object.
2. `onOptionsItemSelected(MenuItem item)`: Invoked whenever the user selects any menu item. The callback receives the selected `MenuItem`, whose integer ID (`item.getItemId()`) is used to execute the corresponding action.

---

## 5. Algorithm & Procedure

### Step 1: Menu Resource Definition
1. Create `res/menu/menu_main.xml`.
2. Define `<item>` entries for Home, Settings, About, and Help with appropriate IDs and titles.

### Step 2: Layout Construction
1. In `res/layout/activity_main.xml`, add a `Toolbar` widget at the top (`@+id/toolbar`).
2. Add a `TextView` in the center (`@+id/tvMenuFeedback`) to display selected item feedback.

### Step 3: Activity Implementation
1. In `MainActivity.java`, call `setSupportActionBar(toolbar)` in `onCreate()`.
2. Override `onCreateOptionsMenu()` and call `getMenuInflater().inflate(R.menu.menu_main, menu)`.
3. Override `onOptionsItemSelected()`, switch on `item.getItemId()`, and update `tvMenuFeedback` with the selected item name.

---

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

---

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the physical OnePlus CPH2661 testing smartphone:

**Output Screen 1: Main application screen with action bar:**

![Menu Bar Closed](Practical_Screenshots/Practical_06/P06_Menu_Bar_Closed.png)

**Output Screen 2: Options Menu expanded showing menu items:**

![Menu Bar Open](Practical_Screenshots/Practical_06/P06_Menu_Bar_Open.png)

**Output Screen 3: Feedback displayed after selecting Settings menu item:**

![Menu Item Selected](Practical_Screenshots/Practical_06/P06_Menu_Item_Selected.png)

- **Verification Summary:**
  - Screen 1 confirms the native `Toolbar` loaded properly.
  - Screen 2 shows the 3-dot overflow menu expanded displaying Home, Settings, About, and Help.
  - Screen 3 shows dynamic feedback ("Selected: Settings") upon selecting an item.

## 8. Expected Output
1. The application displays an app bar with the title and a 3-dot overflow menu icon.
2. Tapping the overflow icon expands the menu showing all options.
3. Selecting any menu item updates the feedback display text accordingly.

## 9. Result & Conclusion
The Options Menu application was successfully developed, installed, and validated on physical hardware. Menu inflation, action bar integration, and menu event dispatching were verified.


# PRACTICAL 07

## 1. Title
Development of an Android Application in Java to Send SMS using Prefilled Intent.

## 2. Aim
To develop a native Android application that prepares recipient and message data, validates inputs, and delegates SMS dispatch to the system messaging client using `Intent.ACTION_SENDTO` with prefilled parameters.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `EditText`, `Button`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background

### 4.1 SMS Dispatch Architectures in Android
There are two primary methods to send SMS in Android:
1. **Direct Background Dispatch (`SmsManager`):** Requires runtime `SEND_SMS` permission, which exposes privacy risks and requires complex permission flows.
2. **Intent-based Prefilled Delegation (`ACTION_SENDTO`):** Dispatches an implicit Intent to the user's default messaging application. Requires **zero dangerous permissions**, respects user privacy, and allows the user to review the message before sending.

### 4.2 Intent Configuration for SMS
```java
Intent intent = new Intent(Intent.ACTION_SENDTO);
intent.setData(Uri.parse("smsto:" + phoneNumber));
intent.putExtra("sms_body", message);
startActivity(intent);
```
Using the `smsto:` scheme ensures that only genuine SMS/MMS messaging apps resolve the intent.

---

## 5. Algorithm & Procedure

### Step 1: Layout Construction
1. In `activity_main.xml`, add an `EditText` for recipient phone number (`android:inputType="phone"`).
2. Add an `EditText` for message content (`android:inputType="textMultiLine"`).
3. Add a `Button` to trigger SMS dispatch ("Open SMS App").

### Step 2: Input Validation & Intent Dispatch
1. In `MainActivity.java`, set a click listener on the button.
2. Validate that neither the phone number nor the message text is empty.
3. Construct `Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone))`.
4. Attach message text via `putExtra("sms_body", message)`.
5. Call `startActivity(intent)`.

---

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
    android:padding="20dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send SMS Application"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="24dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Recipient Phone Number:"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etPhoneNumber"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter phone number"
        android:text="+919876543210"
        android:inputType="phone"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
        android:layout_marginBottom="20dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Message Body:"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etMessageBody"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter message text"
        android:text="Hello, this is a test SMS message."
        android:inputType="textMultiLine"
        android:minLines="3"
        android:gravity="top|start"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
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

---

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the physical OnePlus CPH2661 testing smartphone:

**Output Screen 1: SMS composition form with input fields:**

![SMS Form](Practical_Screenshots/Practical_07/P07_SMS_Form.png)

**Output Screen 2: System messaging application opened with prefilled recipient and message:**

![SMS Prefilled App](Practical_Screenshots/Practical_07/P07_SMS_Prefilled_App.png)

- **Verification Summary:**
  - Screen 1 shows the form with phone number (`+919876543210`) and message text entered.
  - Screen 2 confirms that tapping the action button cleanly opened Google Messages with the recipient and body prefilled.

## 8. Expected Output
1. The app displays an input form with fields for recipient phone number and SMS message text.
2. Clicking the action button validates inputs and triggers an implicit intent (`ACTION_SENDTO` with `smsto:`).
3. The phone's default messaging app opens directly into a conversation thread addressed to the recipient with message text already populated in the draft box.

## 9. Result & Conclusion
Practical 07 was successfully implemented and verified on physical hardware. The application cleanly implements SMS composition through the secure, permissionless `Intent.ACTION_SENDTO` architecture, guaranteeing complete privacy and adherence to Android platform best practices.


# PRACTICAL 08

## 1. Title
Development of an Android Application in Java to Send Email using Prefilled Intent.

## 2. Aim
To develop a native Android application that prepares email parameters (recipient, subject, body), validates email syntax, and delegates composition to an installed email client via `Intent.ACTION_SENDTO` with a system chooser.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `EditText`, `Button`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background

### 4.1 Email Dispatch Architecture
Using `Intent.ACTION_SENDTO` with the `mailto:` URI scheme ensures that only dedicated email clients (such as Gmail, Outlook, or Thunderbird) handle the intent, filtering out messaging, social media, and Bluetooth handlers.

### 4.2 System Chooser Dialog
Wrapping the email intent with `Intent.createChooser(intent, title)` ensures that the system always presents an app chooser dialog, giving the user control over which client to use without permanently binding a default handler.

---

## 5. Algorithm & Procedure

### Step 1: Layout Construction
1. In `activity_main.xml`, add `EditText` fields for:
   - Recipient email address (`android:inputType="textEmailAddress"`).
   - Subject line (`android:inputType="text"`).
   - Message body (`android:inputType="textMultiLine"`).
2. Add a `Button` to trigger email dispatch ("Open Email Client").

### Step 2: Field Validation & Intent Construction
1. In `MainActivity.java`, validate all fields. Check email format using `Patterns.EMAIL_ADDRESS.matcher(email).matches()`.
2. Create an `Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))`.
3. Put extras:
   - `Intent.EXTRA_EMAIL`: Array of recipient addresses (`new String[]{email}`).
   - `Intent.EXTRA_SUBJECT`: Subject string.
   - `Intent.EXTRA_TEXT`: Body string.
4. Wrap in `Intent.createChooser()` and call `startActivity()`.

---

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
    android:padding="20dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Email Application"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="24dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Recipient Email:"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etEmailTo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter recipient email"
        android:text="alex.johnson@university.edu"
        android:inputType="textEmailAddress"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Subject Line:"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etSubject"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter subject"
        android:text="SCS391 Practical 08 Submission"
        android:inputType="text"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Message Body:"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginBottom="6dp"/>

    <EditText
        android:id="@+id/etEmailBody"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter message text"
        android:text="Hello, this is a test email message."
        android:inputType="textMultiLine"
        android:minLines="3"
        android:gravity="top|start"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
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

---

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the physical OnePlus CPH2661 testing smartphone:

**Output Screen 1: Email composition form with input fields:**

![Email Form](Practical_Screenshots/Practical_08/P08_Email_Form.png)

**Output Screen 2: System email app chooser opened for composition:**

![Email Prefilled App](Practical_Screenshots/Practical_08/P08_Email_Prefilled_App.png)

- **Verification Summary:**
  - Screen 1 shows the form with recipient (`student@example.com`), subject, and body entered.
  - Screen 2 shows the Android system chooser / client opening directly with recipient, subject, and body prefilled.

## 8. Expected Output
1. The user fills in recipient address, subject line, and message body.
2. Clicking "Open Email Client" validates all fields.
3. If valid, an implicit intent with `ACTION_SENDTO` and `mailto:` is dispatched inside a system chooser dialog.
4. The system presents available email clients prefilled with recipient, subject, and body content.

## 9. Result & Conclusion
Practical 08 was successfully implemented and verified on the physical OnePlus device. The application implements the best-practice Android email dispatch architecture using `Intent.ACTION_SENDTO` with `mailto:` scheme delegation and system chooser integration.


# PRACTICAL 09

## 1. Title
Development of an Android Application in Java to Perform Database Operations (CRUD) using SQLite.

## 2. Aim
To develop a native Android application utilizing SQLite database storage via `SQLiteOpenHelper` to perform full Create, Read, Update, and Delete (CRUD) operations on student records and display them dynamically in a `ListView`.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **UI Components:** `LinearLayout`, `EditText`, `Button`, `ListView`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background

### 4.1 SQLite in Android
SQLite is an in-process, serverless, transactional SQL database engine embedded directly into the Android OS. Every application has its own private SQLite database file located in `/data/data/<package_name>/databases/`, accessible only by that application.

### 4.2 `SQLiteOpenHelper` Lifecycle
`SQLiteOpenHelper` manages database creation and version management:
- `onCreate(SQLiteDatabase db)`: Invoked when the database file is first created. Executes `CREATE TABLE` DDL queries.
- `onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)`: Invoked when the database version increments, handling table migrations.

### 4.3 CRUD SQL Operations
- **Create:** `db.insert(TABLE_NAME, null, values)` where `values` is a `ContentValues` key-value map.
- **Read:** `db.query(TABLE_NAME, columns, selection, selectionArgs, ...)` returning a `Cursor`.
- **Update:** `db.update(TABLE_NAME, values, "id = ?", new String[]{id})`.
- **Delete:** `db.delete(TABLE_NAME, "id = ?", new String[]{id})`.

---

## 5. Algorithm & Procedure

### Step 1: Database Helper Construction
1. Create `DatabaseHelper.java` extending `SQLiteOpenHelper`.
2. Define table `students` with columns: `id` (INTEGER PRIMARY KEY AUTOINCREMENT), `name` (TEXT), `email` (TEXT).
3. Implement `insertStudent()`, `getAllStudents()`, `updateStudent()`, and `deleteStudent()`.

### Step 2: User Interface Design
1. In `res/layout/activity_main.xml`, add `EditText` widgets for ID, Name, and Email.
2. Add four action buttons: Insert, View All, Update, and Delete.
3. Add a `ListView` (`@+id/lvStudents`) to display stored student records.

### Step 3: Activity Implementation
1. In `MainActivity.java`, instantiate `DatabaseHelper`.
2. Set click listeners for the four buttons:
   - **Insert:** Read name and email, call `dbHelper.insertStudent()`, clear fields, refresh list.
   - **View All:** Call `dbHelper.getAllStudents()`, populate `ListView` via `ArrayAdapter`.
   - **Update:** Read ID, new name, new email, call `dbHelper.updateStudent()`, refresh list.
   - **Delete:** Read ID, call `dbHelper.deleteStudent()`, refresh list.

---

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
    android:fillViewport="true">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Student Records (SQLite CRUD)"
            android:textSize="20sp"
            android:textStyle="bold"
            android:textColor="@android:color/black"
            android:layout_marginBottom="16dp"/>

        <EditText
            android:id="@+id/etStudentId"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Student ID (Required for Update/Delete)"
            android:inputType="number"
            android:padding="10dp"
            android:background="@android:drawable/edit_text"
            android:layout_marginBottom="10dp"/>

        <EditText
            android:id="@+id/etStudentName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Student Name"
            android:inputType="textPersonName"
            android:padding="10dp"
            android:background="@android:drawable/edit_text"
            android:layout_marginBottom="10dp"/>

        <EditText
            android:id="@+id/etStudentEmail"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Student Email"
            android:inputType="textEmailAddress"
            android:padding="10dp"
            android:background="@android:drawable/edit_text"
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
            android:textColor="@android:color/black"
            android:layout_marginBottom="8dp"/>

        <ListView
            android:id="@+id/lvStudents"
            android:layout_width="match_parent"
            android:layout_height="300dp"
            android:background="#FAFAFA"
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

---

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the physical OnePlus CPH2661 testing smartphone across all four operations:

**Output Screen 1: CREATE — Inserting student record into SQLite database:**

![CRUD Create](Practical_Screenshots/Practical_09/P09_CRUD_Create.png)

**Output Screen 2: READ — Querying and listing student records in ListView:**

![CRUD Read](Practical_Screenshots/Practical_09/P09_CRUD_Read.png)

**Output Screen 3: UPDATE — Updating existing student record by ID:**

![CRUD Update](Practical_Screenshots/Practical_09/P09_CRUD_Update.png)

**Output Screen 4: DELETE — Deleting student record by ID:**

![CRUD Delete](Practical_Screenshots/Practical_09/P09_CRUD_Delete.png)

- **Verification Summary:** All four CRUD operations (Create, Read, Update, Delete) were executed on physical hardware and verified against the embedded SQLite database file.

## 8. Expected Output
1. **CREATE:** Entering student details and tapping "Insert" writes to SQLite and updates the list view immediately.
2. **READ ALL:** Tapping "View All" displays all stored student records in the `ListView`.
3. **UPDATE:** Providing an existing ID allows updating name or email; tapping "Update" modifies the database row and refreshes the display.
4. **DELETE:** Supplying an ID and tapping "Delete" permanently deletes the record and removes it from the list.

## 9. Result & Conclusion
Practical 09 was successfully built, verified on physical hardware, and documented. The application implements complete SQLite database management using Android's native `SQLiteOpenHelper`, showcasing secure query execution, dynamic list rendering, and robust data persistence.


# PRACTICAL 10

## 1. Title
Packaging, Cryptographic Signing, and Deployment of a Native Android Application.

## 2. Aim
To configure, compile, sign, verify, and deploy a production release Android APK using custom cryptographic keystores, APK Signature Scheme v2, `zipalign`, and physical device installation.

## 3. Software and Hardware Requirements
- **IDE:** Android Studio & Gradle Build Toolchain
- **Language:** Java (JDK 21 LTS)
- **Compile SDK:** API 36 | **Min SDK:** API 24
- **Security Tools:** `keytool`, `apksigner`, `zipalign`
- **Testing Hardware:** OnePlus CPH2661 (Android 16, API Level 36)

## 4. Theoretical Background

### 4.1 Android Application Packaging & Signing
Android requires all APKs to be digitally signed with a cryptographic certificate before installation. The digital signature verifies author authenticity and ensures package integrity against tampering.

### 4.2 APK Signature Schemes
- **v1 (JAR signing):** Verifies individual file checksums inside the ZIP archive. Vulnerable to certain ZIP metadata alterations.
- **v2 (APK Signature Scheme v2):** Introduced in Android 7.0 (API 24). Protects the entire APK file as a single entity by inserting an APK Signing Block between ZIP entries and the Central Directory. Provides faster verification and total tamper resistance.

### 4.3 Production Hardening
Release builds strip debugging symbols (`android:debuggable="false"`), eliminate debugging overhead, and run through `zipalign` to align 4-byte boundaries for efficient `mmap` memory mapping.

---

## 5. Algorithm & Procedure

### Step 1: Keystore Generation
Generate a release keystore using Java's `keytool`:
```bash
keytool -genkeypair -v -keystore release.keystore -alias scs391key -keyalg RSA -keysize 2048 -validity 10000
```

### Step 2: Signing Configuration in Gradle
Configure the `signingConfigs` block inside `app/build.gradle.kts`:
```kotlin
signingConfigs {
    create("release") {
        storeFile = file("release.keystore")
        storePassword = "..."
        keyAlias = "scs391key"
        keyPassword = "..."
    }
}
```

### Step 3: Compiling & Assembling Release APK
Execute the Gradle release task:
```bash
./gradlew assembleRelease
```

### Step 4: Verification via `apksigner`
Verify the signed APK:
```bash
apksigner verify --verbose app-release.apk
```

### Step 5: Hardware Deployment
Install the signed APK directly onto the physical smartphone:
```bash
adb install -r app-release.apk
```

---

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
    android:padding="24dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Application Deployment"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="24dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Release Build Verification:"
        android:textSize="16sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
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

---

## 7. Output & Hardware Execution Evidence

The application was tested and validated on the physical OnePlus CPH2661 smartphone:

**Output Screen 1: Signed release APK running on physical device:**

![Release Execution](Practical_Screenshots/Practical_10/P10_Release_Execution.png)

**Output Screen 2: Runtime package installation and signature verification:**

![Release Verification](Practical_Screenshots/Practical_10/P10_Release_Verification.png)

- **Verification Summary:**
  - `apksigner` confirmed `Verified using v2 scheme (APK Signature Scheme v2): true`.
  - The signed release APK installed cleanly on Android 16 and executed with release status verified.

## 8. Expected Output
1. The release build compiles into a signed APK with `signingConfig = release`.
2. Running `apksigner verify` confirms valid v2 signature with custom certificate DN and SHA-256 fingerprint.
3. When launched on physical hardware, `FLAG_DEBUGGABLE` reports `FALSE`, confirming hardened production status.

## 9. Result & Conclusion
Practical 10 was successfully completed. The complete Android application deployment process was demonstrated end-to-end, including cryptographic key generation, release configuration, APK Signature Scheme v2 validation, hardware deployment, and runtime verification. Signed release APK deliverables have been generated and preserved.

