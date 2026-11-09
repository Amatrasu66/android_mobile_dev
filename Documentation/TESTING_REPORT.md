# SCS391 Mobile App Development Lab — Hardware Testing & QA Report

## Hardware Testing Device Profile
- **Device Model:** OnePlus CPH2661
- **Android OS Version:** Android 16 (API 36)
- **Screen Resolution:** 1240 x 2772 px
- **Density:** 560 dpi
- **Transport:** ADB via USB (Serial: `2d242b39`)

---

## Practical Test Results

### Practical 01: Android Studio Setup & Architecture
- **Type:** Theoretical Setup Documentation
- **Execution:** Complete installation & architectural walkthrough covering Android Studio IDE, Android SDK, SDK Tools, AVD configuration, and JDK runtime.
- **Status:** PASS (Documentation verified)

---
*(Individual testing sections for Practicals 02 through 10 will be dynamically updated as each project is compiled, installed, and validated on the OnePlus device.)*

### Practical 02: Hello World Application
- **Package Name:** `com.example.helloworld`
- **Component:** `MainActivity` (Extending `AppCompatActivity`)
- **Build Status:** SUCCESS (`assembleDebug` in 1m 26s)
- **Install Command:** `adb install -r 02_Hello_World/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Execution Command:** `adb shell am start -n com.example.helloworld/.MainActivity`
- **Activity State:** `mResumed=true`, `mStopped=false`, `mFinished=false`
- **Hardware Screenshot:** `Practical_Screenshots/Practical_02/P02_Hello_World.png`
- **Google Doc Embedded:** Yes (Drive image synchronized to Master Google Doc)
- **Verification Status:** PASS

### Practical 03: Intent Demonstration
- **Package Name:** `com.example.intentdemo`
- **Components:** `MainActivity`, `SecondActivity`
- **Build Status:** SUCCESS (`assembleDebug` in 11s)
- **Install Command:** `adb install -r 03_Intent_Demonstration/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Explicit Intent Test:** Tapped `btnLaunchExplicit` at (620, 1038) -> `SecondActivity` focused (`mCurrentFocus=Window{... SecondActivity}`), unpacks payload message "Hello from SCS391 Lab!" and timestamp.
- **Implicit Intent Test A (Dialer):** Tapped `btnOpenDialer` at (620, 1932) -> Google Dialer focused (`mCurrentFocus=Window{... com.google.android.dialer...}`), prefilled with `tel:9876543210`.
- **Implicit Intent Test B (Browser):** Tapped `btnOpenWeb` at (620, 1708) -> System browser launched to `developer.android.com`.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_03/P03_Main_Screen.png`
  - `Practical_Screenshots/Practical_03/P03_Explicit_Intent_Result.png`
  - `Practical_Screenshots/Practical_03/P03_Implicit_Intent_Dialer.png`
  - `Practical_Screenshots/Practical_03/P03_Implicit_Intent_Web.png`
- **Google Doc Embedded:** Yes (All 4 images synchronized to Master Google Doc)
- **Verification Status:** PASS
