# SCS391 Mobile App Development Lab — Hardware Testing & QA Report

## Hardware Testing Device Profile
- **Device Model:** OnePlus CPH2661
- **Android OS Version:** Android 16 (API Level 36)
- **Screen Resolution:** 1240 x 2772 px
- **Density:** 560 dpi
- **Transport:** ADB via USB (Serial: `2d242b39`)
- **Execution Policy:** 0% Emulators. All verifications performed on physical OnePlus CPH2661.

---

## Practical Test Results (Full 15 Practicals)

### Practical 01: Android Studio Setup & Architecture
- **Type:** Theoretical Setup Documentation
- **Execution:** Complete installation & architectural walkthrough covering Android Studio IDE, Android SDK, SDK Tools, AVD configuration, and JDK runtime.
- **Status:** PASS (Documentation verified)

---

### Practical 02: Hello World Application
- **Package Name:** `com.example.helloworld`
- **Component:** `MainActivity` (Extending `AppCompatActivity`)
- **UI Architecture:** Native `RelativeLayout` with centered `TextView` (zero decorative slop/cards)
- **Build Status:** SUCCESS (`assembleDebug` & signed `assembleRelease`)
- **Install Command:** `adb install -r 02_Hello_World/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Execution Command:** `adb shell am start -n com.example.helloworld/.MainActivity`
- **Activity State:** `mResumed=true`, `mStopped=false`, `mFinished=false`
- **Hardware Screenshot:** `Practical_Screenshots/Practical_02/P02_Hello_World.png`
- **Google Doc Embedded:** Yes (Synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 03: Implementing the Concept of Intent (Part A - Implicit Intent)
- **Package Name:** `com.example.implicitintent`
- **Component:** `MainActivity`
- **UI Architecture:** Minimalist `LinearLayout` with dialer action button
- **Build Status:** SUCCESS (`assembleDebug`)
- **Implicit Intent Test (Dialer):** Tapped `btnOpenDialer` -> Dispatched `Intent.ACTION_DIAL` with `tel:9876543210`, launching native system phone dialer with telephone number prefilled.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_03/P03_Implicit_Main.png`
  - `Practical_Screenshots/Practical_03/P03_Implicit_Dialer.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 04: Implementing the Concept of Intent (Part B - Explicit Intent)
- **Package Name:** `com.example.explicitintent`
- **Components:** `MainActivity`, `SecondActivity`
- **UI Architecture:** Native `LinearLayout` with `EditText` and navigation button
- **Build Status:** SUCCESS (`assembleDebug`)
- **Explicit Intent Test:** Entered text message in `MainActivity`, tapped `btnLaunchSecond` -> `SecondActivity` launched via explicit Intent, unpacked string extra payload `KEY_MESSAGE`, and rendered text into destination `TextView`.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_04/P04_Explicit_Main.png`
  - `Practical_Screenshots/Practical_04/P04_Explicit_Second.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 05: Screen Orientation Detection & Layouts
- **Package Name:** `com.example.screenorientation`
- **Component:** `MainActivity`
- **UI Architecture:** Native layout qualifiers (`layout` and `layout-land`) with centered text
- **Build Status:** SUCCESS (`assembleDebug`)
- **Portrait Verification:** In vertical orientation, rendered `res/layout/activity_main.xml` displaying "Portrait Mode".
- **Landscape Verification:** In horizontal orientation (`user_rotation 1`), system automatically recreated activity and inflated `res/layout-land/activity_main.xml` displaying "Landscape Mode".
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_05/P05_Portrait_Mode.png`
  - `Practical_Screenshots/Practical_05/P05_Landscape_Mode.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 06: Developing an Application Using Picker View
- **Package Name:** `com.example.pickerview`
- **Component:** `MainActivity`
- **UI Architecture:** Native `DatePicker` and `TimePicker` widgets in spinner mode with selection button and display `TextView`
- **Build Status:** SUCCESS (`assembleDebug`)
- **Picker Selection Test:** Configured date and time on pickers, tapped "Confirm Selection" -> Formatted date `dd-MM-yyyy` and time `HH:mm` computed and rendered accurately.
- **Hardware Screenshot:** `Practical_Screenshots/Practical_06/P06_Picker_View.png`
- **Google Doc Embedded:** Yes (Synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 07: Developing an Application Using ListView
- **Package Name:** `com.example.listviewapp`
- **Component:** `MainActivity`
- **UI Architecture:** Native `ListView` bound via `ArrayAdapter<String>`
- **Build Status:** SUCCESS (`assembleDebug`)
- **List Click Test:** Tapped item in list -> Item click listener captured selection and dispatched immediate feedback `Toast` with selected technology name.
- **Hardware Screenshot:** `Practical_Screenshots/Practical_07/P07_List_View.png`
- **Google Doc Embedded:** Yes (Synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 08: Applying a Theme in an Activity/Application
- **Package Name:** `com.example.themeapp`
- **Component:** `MainActivity`
- **UI Architecture:** Custom light theme `Theme.CustomLight` applied at application level in `AndroidManifest.xml`
- **Build Status:** SUCCESS (`assembleDebug`)
- **Theme Verification:** Application launched with custom background `#FFFFFF`, high-contrast text `#1F1F1F`, and Google Blue `#1A73E8` primary accent on buttons and controls.
- **Google Doc Embedded:** Yes (Synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 09: Creating a Menu in an Android Application (Options Menu)
- **Package Name:** `com.example.menubar`
- **Component:** `MainActivity` with native `Toolbar`
- **UI Architecture:** Minimalist toolbar and centered feedback TextView
- **Build Status:** SUCCESS (`assembleDebug`)
- **Options Menu Test:** Tapped 3-dot overflow icon -> Menu popped open showing Home, Settings, About, and Help.
- **Item Selection Test:** Selected "Settings" -> Dynamic feedback updated to "Selected: Settings".
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_09/P09_Menu_Bar_Closed.png`
  - `Practical_Screenshots/Practical_09/P09_Menu_Bar_Open.png`
  - `Practical_Screenshots/Practical_09/P09_Menu_Item_Selected.png`
- **Google Doc Embedded:** Yes (All 3 images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 10: Storing Local Data Using User Preferences
- **Package Name:** `com.example.userpreferences`
- **Component:** `MainActivity`
- **UI Architecture:** `EditText`, Save Button, Load Button, Clear Button, and Status `TextView`
- **Build Status:** SUCCESS (`assembleDebug`)
- **Persistence Test:** Saved user name string to `SharedPreferences` ("UserPrefs"). Relaunched application, pressed "Load Data" -> Successfully retrieved and rendered persisted name.
- **Google Doc Embedded:** Yes (Synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 11: Creating, Reading and Writing Data Using SQLite (CRUD Operations)
- **Package Name:** `com.example.crudsqlite`
- **Component:** `MainActivity` with SQLite Database Helper
- **UI Architecture:** Strict light theme `#FFFFFF`, clean tabular ListView, native SQLite
- **Build Status:** SUCCESS (`assembleDebug` & signed `assembleRelease`)
- **CRUD Operations Test:**
  - **CREATE:** Inserted student record (ID: 101, Name: John Doe, Course: MCA) -> SQLite insert returned row ID `1`.
  - **READ:** Queried database -> Rendered record list inside `ListView`.
  - **UPDATE:** Modified record ID 101 to "Johnathan Doe" -> SQLite update executed successfully.
  - **DELETE:** Deleted record ID 101 -> Record removed, `ListView` refreshed.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_11/P11_CRUD_Create.png`
  - `Practical_Screenshots/Practical_11/P11_CRUD_Read.png`
  - `Practical_Screenshots/Practical_11/P11_CRUD_Update.png`
  - `Practical_Screenshots/Practical_11/P11_CRUD_Delete.png`
- **Google Doc Embedded:** Yes (All 4 images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 12: Creating an Application to Send SMS
- **Package Name:** `com.example.smsapplication`
- **Component:** `MainActivity`
- **UI Architecture:** Minimalist phone number and message body input form
- **Build Status:** SUCCESS (`assembleDebug`)
- **Intent Delegation Test:** Entered recipient `9876543210` and message -> Dispatched `Intent.ACTION_SENDTO` with `smsto:` URI. Native messaging app launched with fields prefilled and focused, requiring zero dangerous SMS permissions.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_12/P12_SMS_Form.png`
  - `Practical_Screenshots/Practical_12/P12_SMS_Prefilled_App.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 13: Creating an Application to Send an E-mail
- **Package Name:** `com.example.emailapplication`
- **Component:** `MainActivity`
- **UI Architecture:** Strict light theme `#FFFFFF`, recipient, subject, and body fields
- **Build Status:** SUCCESS (`assembleDebug`)
- **Intent Chooser Test:** Entered email recipient, subject, and body -> Dispatched `Intent.ACTION_SENDTO` with `mailto:` wrapped in `Intent.createChooser()`. System email chooser displayed client applications cleanly.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_13/P13_Email_Form.png`
  - `Practical_Screenshots/Practical_13/P13_Email_Prefilled_App.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 14: Displaying a Map Based on Current or Given Location
- **Package Name:** `com.example.mapslocation`
- **Component:** `MainActivity`
- **UI Architecture:** Clean light theme interface with given coordinate buttons (Golden Temple Amritsar: `31.6200, 74.8765`), coordinate inputs, and current location trigger
- **Build Status:** SUCCESS (`assembleDebug`)
- **Maps Intent Test:** Dispatched standard Android `geo:31.6200,74.8765?q=31.6200,74.8765(Golden+Temple+Amritsar)` Intent targeting `com.google.android.apps.maps` with graceful fallback to browser. Google Maps opened with designated marker.
- **Google Doc Embedded:** Yes (Synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 15: Android Application Packaging, Cryptographic Signing, and Deployment
- **Package Name:** `com.example.appdeployment`
- **Component:** `MainActivity`
- **UI Architecture:** Strict light theme deployment dashboard with verification indicators
- **Build Status:** SUCCESS (`assembleDebug` & signed `assembleRelease`)
- **Keystore & Signing:** Built using `release-key.jks` with SHA-256 RSA 2048-bit key.
- **apksigner Verification Output:**
  ```text
  Verifies
  Verified using v1 scheme (JAR signing): true
  Verified using v2 scheme (APK Signature Scheme v2): true
  Verified using v3 scheme (APK Signature Scheme v3): true
  Verified using v4 scheme (APK Signature Scheme v4): false
  ```
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_15/P15_Release_Execution.png`
  - `Practical_Screenshots/Practical_15/P15_Release_Verification.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS
