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

### Practical 04: Appointment Form Application
- **Package Name:** `com.example.appointmentform`
- **Component:** `MainActivity`
- **Build Status:** SUCCESS (`assembleDebug` in 10s)
- **Install Command:** `adb install -r 04_Appointment_Form/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **ImageButton Test:** Tapped `ibServiceIcon` -> Service cycled through General Consultation, Dental Checkup, Cardiology Review with live Toast and icon mutation.
- **Spinner Test:** `spnCategory` bound to 5 department categories via `ArrayAdapter`.
- **DatePicker & TimePicker Test:** Swiped to date and time picker widgets; selected date `2026-11-12` and time `09:15 AM`.
- **Submit & ListView Test:** Tapped `btnSubmitAppointment` at (620, 1160) -> Created new `Appointment` object for "Alex Johnson", inserted at top of `ListView`, dynamic list item displayed with patient name, service badge, department, and formatted date/time.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_04/P04_Appointment_Form.png`
  - `Practical_Screenshots/Practical_04/P04_DateTime_Selection.png`
  - `Practical_Screenshots/Practical_04/P04_Appointment_Submitted.png`
- **Google Doc Embedded:** Yes (All 3 images synchronized to Master Google Doc)
- **Verification Status:** PASS

### Practical 05: Screen Orientation Detection & Layouts
- **Package Name:** `com.example.screenorientation`
- **Component:** `MainActivity`
- **Build Status:** SUCCESS (`assembleDebug` in 9s)
- **Install Command:** `adb install -r 05_Screen_Orientation/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Portrait Verification:** In orientation 0, rendered `res/layout/activity_main.xml` with teal theme and "PORTRAIT MODE DETECTED", resolution `1240 x 2772 px`.
- **Landscape Verification:** In orientation 1 (`adb shell settings put system user_rotation 1`), system automatically recreated activity and inflated `res/layout-land/activity_main.xml` with orange theme and "LANDSCAPE MODE DETECTED", resolution `2772 x 1240 px`.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_05/P05_Portrait_Mode.png` (1240 x 2772 px)
  - `Practical_Screenshots/Practical_05/P05_Landscape_Mode.png` (2772 x 1240 px)
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

### Practical 06: Options Menu Bar
- **Package Name:** `com.example.menubar`
- **Component:** `MainActivity` with `MaterialToolbar`
- **Build Status:** SUCCESS (`assembleDebug` in 9s)
- **Install Command:** `adb install -r 06_Menu_Bar/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Options Menu Test:** Tapped 3-dot overflow icon at (1170, 112) -> Menu popped open showing Home, Settings, About Application, and Help & Support.
- **Item Selection Test:** Selected "Settings" -> Status card updated to `"Settings Selected: Opened System Configuration"` and toast displayed.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_06/P06_Menu_Bar_Closed.png`
  - `Practical_Screenshots/Practical_06/P06_Menu_Bar_Open.png`
  - `Practical_Screenshots/Practical_06/P06_Menu_Item_Selected.png`
- **Google Doc Embedded:** Yes (All 3 images synchronized to Master Google Doc)
- **Verification Status:** PASS


### Practical 07: Send SMS Application
- **Package Name:** `com.example.smsapp`
- **Component:** `MainActivity`
- **Build Status:** SUCCESS (`assembleDebug` in 8s)
- **Install Command:** `adb install -r 07_SMS_Application/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Input Validation Test:** Validated recipient phone number and SMS text fields; displays error hints if fields are cleared.
- **Intent Dispatch Test:** Tapped `btnOpenSmsApp` at (620, 2161) -> Triggered `Intent.ACTION_SENDTO` with `smsto:+919876543210` and `"sms_body"`. Successfully launched Google Messages (`com.google.android.apps.messaging`) with recipient and message prefilled.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_07/P07_SMS_Form.png` (Material form with recipient and message inputs)
  - `Practical_Screenshots/Practical_07/P07_SMS_Prefilled_App.png` (Default Messages app opened with recipient and message prefilled)
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS
