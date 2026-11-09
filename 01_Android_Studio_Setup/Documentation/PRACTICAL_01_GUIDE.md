# Practical 01: Installation and Configuration of Android Studio, Android SDK, SDK Tools, AVD, and JDK

## Aim
To study, install, and configure the complete Android application development environment including Android Studio IDE, Android SDK, Android SDK Tools, Android Virtual Device (AVD), and Java Development Kit (JDK).

---

## Software and Hardware Requirements

| Parameter | Minimum Requirement | Verified Lab Environment |
|---|---|---|
| **Operating System** | 64-bit Linux, Windows 10/11, macOS | Arch Linux x86_64 (Kernel 7.2.14) |
| **IDE** | Android Studio Ladybug / Meerkat / Preview | Android Studio AI-262 (Installed at `/opt/android-studio`) |
| **JDK** | OpenJDK 17 LTS or 21 LTS | Eclipse Temurin OpenJDK 21.0.6+7 / JBR 25 |
| **Android SDK** | API Level 24+ | Android SDK Platforms 36 & 37, Build-Tools 36.0.0 |
| **Platform Tools** | ADB 1.0.41+ | ADB Version 1.0.41 (Platform-Tools 37.0.1) |
| **Testing Device** | AVD Emulator or Physical Phone | OnePlus CPH2661 (Android 16, API 36, USB Debugging) |
| **System RAM** | 8 GB RAM minimum | 8 GB System Memory |
| **Storage** | 16 GB SSD space | Fast NVMe / SSD Storage |

---

## Theoretical Overview

Developing Android applications requires a cohesive suite of developer tools that work in synergy:

```
+-------------------------------------------------------------------+
|                        Android Studio IDE                         |
|  - Code Editor (Java / XML)       - Android Project Structure     |
|  - Layout Visual Design Surface   - Gradle Build Integration      |
+---------------------------------+---------------------------------+
                                  |
            +---------------------+---------------------+
            |                                           |
            v                                           v
+-----------------------+                   +-----------------------+
|  JDK (Java Dev Kit)   |                   |      Android SDK      |
|  - javac Compiler     |                   |  - android.jar APIs   |
|  - Java Virtual Mach. |                   |  - System Images      |
|  - Keytool & Security |                   |  - Support Libraries  |
+-----------------------+                   +-----------+-----------+
            |                                           |
            +---------------------+---------------------+
                                  |
                                  v
+-------------------------------------------------------------------+
|                         Android SDK Tools                         |
|  - AAPT2: Asset Packaging & XML resource compilation              |
|  - D8 / R8: Java Bytecode -> Dalvik Executable (.dex) compiler    |
|  - Zipalign & Apksigner: APK packaging, alignment, cryptographic  |
+---------------------------------+---------------------------------+
                                  |
                                  v
+---------------------------------+---------------------------------+
|                       Target Runtime Engine                       |
|  Option A: Android Virtual Device   |  Option B: Physical Device  |
|  - QEMU Hardware Virtualization     |  - Direct Hardware Exec.    |
|  - KVM Acceleration (Linux)         |  - ADB via USB / Wi-Fi      |
+-------------------------------------------------------------------+
```

### 1. Android Studio IDE
Android Studio is the official Integrated Development Environment (IDE) for Google's Android operating system, built upon JetBrains' IntelliJ IDEA platform. It provides dedicated code analysis, Android-specific linting, visual layout editors with multi-preview support, integrated Gradle build automation, and performance profilers (CPU, memory, battery, and network).

### 2. Java Development Kit (JDK)
The JDK provides the core compiler (`javac`), runtime libraries, and development utilities required to build Java source code into Java bytecode (`.class` files). Modern Android Gradle Plugin releases mandate JDK 17 or JDK 21 LTS.

### 3. Android SDK (Software Development Kit)
The Android SDK consists of modular packages containing the Android APIs (`android.jar`), framework headers, and system documentation. Each Android API version (e.g., API 34 for Android 14, API 36 for Android 16) provides the specific platform APIs that applications call.

### 4. Android SDK Tools
The SDK Tools consist of three core tiers:
- **Build-Tools:** Low-level compilation tools including **AAPT2** (Android Asset Packaging Tool 2) for compiling resources into binary tables, **D8** for converting Java bytecode to `.dex` format, and **zipalign** for 4-byte memory boundary alignment.
- **Platform-Tools:** Utilities that interface directly with the device runtime, chief among them **ADB (Android Debug Bridge)** and `fastboot`.
- **Command-line Tools (`cmdline-tools`):** The `sdkmanager` and `avdmanager` binaries that allow automated SDK and virtual device orchestration without a graphical user interface.

### 5. Android Virtual Device (AVD)
An AVD is an emulator configuration that defines the hardware characteristics (screen size, memory, ABI architecture, cameras, sensors) and system image of an Android device. Under Linux, the emulator leverages **KVM (Kernel-based Virtual Machine)** to execute guest Android x86_64 system instructions natively on host CPU cores for near-native performance.

---

## Step-by-Step Installation and Configuration Procedure

### Step 1: JDK Installation & Environment Configuration
1. Install an LTS OpenJDK release (such as OpenJDK 21 or OpenJDK 17).
2. Configure the system environment variables in the user's profile (`~/.bashrc` or `/etc/environment`):
   ```bash
   export JAVA_HOME=/home/amatrasu/.jdks/jdk-21.0.6+7
   export PATH=$JAVA_HOME/bin:$PATH
   ```
3. Validate JDK installation:
   ```bash
   java -version
   javac -version
   ```

### Step 2: Android Studio Installation
1. Download the Android Studio distribution archive from the official developer portal (`developer.android.com/studio`).
2. Extract the archive into a dedicated directory (e.g., `/opt/android-studio/` or `~/android-studio/`).
3. Execute the launcher script:
   ```bash
   /opt/android-studio/bin/studio.sh
   ```
4. Follow the **Android Studio Setup Wizard**:
   - Choose **Standard** or **Custom** installation.
   - Select UI Theme (Darcula / Material Light).
   - Verify SDK component download paths.

### Step 3: Android SDK & SDK Tools Configuration
1. Open Android Studio and navigate to **Tools > SDK Manager** (or Settings > Languages & Frameworks > Android SDK).
2. Under the **SDK Platforms** tab, check the desired API levels:
   - `Android SDK Platform 36` (Android 16 / VanillaIceCream)
   - `Android SDK Platform 34` / `35`
3. Under the **SDK Tools** tab, verify and install:
   - `Android SDK Build-Tools` (e.g., 36.0.0)
   - `Android SDK Platform-Tools`
   - `Android SDK Command-line Tools (latest)`
   - `Android Emulator`
4. Set Android environment variables in `~/.bashrc`:
   ```bash
   export ANDROID_HOME=$HOME/Android/Sdk
   export PATH=$PATH:$ANDROID_HOME/platform-tools
   export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin
   export PATH=$PATH:$ANDROID_HOME/build-tools/36.0.0
   ```

### Step 4: Android Virtual Device (AVD) Creation & Configuration
1. In Android Studio, launch **Device Manager** from the toolbar or via **Tools > Device Manager**.
2. Click **Create Virtual Device**.
3. **Select Hardware:** Choose a target device profile (e.g., *Pixel 8* or *Medium Phone*) with appropriate screen resolution and DPI.
4. **Select System Image:**
   - Choose a release corresponding to the target SDK (e.g., *VanillaIceCream API Level 36* or *UpsideDownCake API Level 34*).
   - Select the `x86_64` ABI with Google APIs.
   - Click **Download** if the system image is not yet cached locally.
5. **Verify Configuration:**
   - Name the AVD (e.g., `Pixel_8_API_36`).
   - Set Startup Orientation to *Portrait*.
   - Under Advanced Settings, allocate appropriate RAM (2048 MB) and internal storage (4096 MB).
6. **Configure KVM Acceleration (Linux Hosts):**
   Ensure the current user belongs to the `kvm` user group to grant access to `/dev/kvm`:
   ```bash
   sudo usermod -aG kvm $USER
   ```
7. Click **Finish** to register the AVD.

### Step 5: Physical Device USB Debugging Configuration (Mandatory Lab Standard)
When testing on actual hardware:
1. Open the physical phone's **Settings > About Device > Version**.
2. Tap **Build Number** 7 consecutive times until the prompt confirms: *"You are now in Developer mode!"*.
3. Navigate to **Settings > Additional Settings > Developer Options**.
4. Enable **USB Debugging** (and **Install via USB** if required by the OEM).
5. Connect the phone to the host PC via a USB data cable.
6. When the host security dialog appears on the phone screen (*"Allow USB debugging from this computer?"*), check **Always allow from this computer** and tap **Allow**.
7. Confirm hardware recognition from the terminal:
   ```bash
   adb devices -l
   ```
   *Expected output:*
   ```
   List of devices attached
   2d242b39    device usb:1-2 product:CPH2661IN model:CPH2661 device:OP5E93L1
   ```

---

## Toolchain Verification & System Output

### Verification 1: Java Development Kit (JDK)
```bash
$ java -version
openjdk version "21.0.6" 2025-01-21 LTS
OpenJDK Runtime Environment Temurin-21.0.6+7 (build 21.0.6+7-LTS)
OpenJDK 64-Bit Server VM Temurin-21.0.6+7 (build 21.0.6+7-LTS, mixed mode, sharing)
```

### Verification 2: Android SDK & Build Tools Packages
```bash
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

### Verification 3: Android Debug Bridge (ADB) & Physical Device Authorization
```bash
$ adb devices -l
List of devices attached
2d242b39               device usb:1-2 product:CPH2661IN model:CPH2661 device:OP5E93L1 transport_id:1

$ adb shell getprop ro.build.version.release
16

$ adb shell getprop ro.build.version.sdk
36

$ adb shell wm size
Physical size: 1240x2772

$ adb shell wm density
Physical density: 560
```

---

## Conclusion & Learning Outcomes
The complete Android application development pipeline has been successfully explored, installed, and configured. The developer workspace is verified with a compliant JDK 21 LTS toolchain, Android SDK Platforms 36/37, Build-Tools 36.0.0, Platform-Tools with ADB, and an authorized physical OnePlus CPH2661 testing smartphone. The environment is fully operational to build, assemble, deploy, and debug native Java Android applications.
