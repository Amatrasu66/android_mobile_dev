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

### Practical 03: Intent Demonstration
- **Package Name:** `com.example.intentdemo`
- **Components:** `MainActivity`, `SecondActivity`
- **UI Architecture:** Minimalist `LinearLayout` with input field and action buttons
- **Build Status:** SUCCESS (`assembleDebug`)
- **Install Command:** `adb install -r 03_Intent_Demonstration/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Explicit Intent Test:** Tapped `btnLaunchExplicit` -> `SecondActivity` focused, unpacks payload message "Hello from Practical 03!".
- **Implicit Intent Test (Dialer):** Tapped `btnOpenDialer` -> System phone dialer focused with `tel:9876543210` prefilled.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_03/P03_Main_Screen.png`
  - `Practical_Screenshots/Practical_03/P03_Explicit_Intent.png`
  - `Practical_Screenshots/Practical_03/P03_Implicit_Intent.png`
- **Google Doc Embedded:** Yes (All 3 images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 04: Appointment Form Application
- **Package Name:** `com.example.appointmentform`
- **Component:** `MainActivity`
- **UI Architecture:** ScrollView containing `ImageButton`, `Spinner`, `DatePicker`, `TimePicker`, submit `Button`, and dynamic `ListView`
- **Build Status:** SUCCESS (`assembleDebug`)
- **Install Command:** `adb install -r 04_Appointment_Form/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **ImageButton Test:** Tapped `ibServiceIcon` -> Service cycled through General Consultation, Dental Checkup, Cardiology Review.
- **Spinner Test:** `spnCategory` bound to medical specialties via `ArrayAdapter`.
- **DatePicker & TimePicker Test:** Selected date and time on native pickers.
- **Submit & ListView Test:** Tapped `btnSubmitAppointment` -> Created new `Appointment` object for "Alex Johnson", inserted into `ListView`, dynamic row displayed with patient name, service, department, and formatted date/time.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_04/P04_Appointment_Form.png`
  - `Practical_Screenshots/Practical_04/P04_DateTime_Selection.png`
  - `Practical_Screenshots/Practical_04/P04_Appointment_Submitted.png`
- **Google Doc Embedded:** Yes (All 3 images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 05: Screen Orientation Detection & Layouts
- **Package Name:** `com.example.screenorientation`
- **Component:** `MainActivity`
- **UI Architecture:** Native layout qualifiers (`layout` and `layout-land`) with centered text
- **Build Status:** SUCCESS (`assembleDebug`)
- **Install Command:** `adb install -r 05_Screen_Orientation/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Portrait Verification:** In vertical orientation, rendered `res/layout/activity_main.xml` displaying "Portrait Mode".
- **Landscape Verification:** In horizontal orientation (`user_rotation 1`), system automatically recreated activity and inflated `res/layout-land/activity_main.xml` displaying "Landscape Mode".
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_05/P05_Portrait_Mode.png`
  - `Practical_Screenshots/Practical_05/P05_Landscape_Mode.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 06: Options Menu Bar
- **Package Name:** `com.example.menubar`
- **Component:** `MainActivity` with native `Toolbar`
- **UI Architecture:** Minimalist toolbar and centered feedback TextView
- **Build Status:** SUCCESS (`assembleDebug`)
- **Install Command:** `adb install -r 06_Menu_Bar/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Options Menu Test:** Tapped 3-dot overflow icon -> Menu popped open showing Home, Settings, About, and Help.
- **Item Selection Test:** Selected "Settings" -> Dynamic feedback updated to "Selected: Settings".
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_06/P06_Menu_Bar_Closed.png`
  - `Practical_Screenshots/Practical_06/P06_Menu_Bar_Open.png`
  - `Practical_Screenshots/Practical_06/P06_Menu_Item_Selected.png`
- **Google Doc Embedded:** Yes (All 3 images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 07: Send SMS Application
- **Package Name:** `com.example.smsapp`
- **Component:** `MainActivity`
- **UI Architecture:** Clean native form with phone `EditText`, message `EditText`, and send `Button`
- **Build Status:** SUCCESS (`assembleDebug`)
- **Install Command:** `adb install -r 07_SMS_Application/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Input Validation Test:** Validates phone number and message fields.
- **Intent Dispatch Test:** Tapped "Open SMS App" -> Triggered `Intent.ACTION_SENDTO` with `smsto:+919876543210` and `sms_body`. Successfully launched default messaging client with recipient and message prefilled.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_07/P07_SMS_Form.png`
  - `Practical_Screenshots/Practical_07/P07_SMS_Prefilled_App.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 08: Send Email Application
- **Package Name:** `com.example.emailapp`
- **Component:** `MainActivity`
- **UI Architecture:** Clean form with recipient, subject, body fields and action button
- **Build Status:** SUCCESS (`assembleDebug`)
- **Install Command:** `adb install -r 08_Email_Application/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Input Validation Test:** Validates recipient email syntax using `Patterns.EMAIL_ADDRESS`, subject, and message body.
- **Intent Chooser Test:** Tapped "Open Email Client" -> Dispatched `Intent.ACTION_SENDTO` with `mailto:` scheme wrapped in `Intent.createChooser()`. The system chooser dialog opened displaying email clients prefilled with recipient, subject, and body.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_08/P08_Email_Form.png`
  - `Practical_Screenshots/Practical_08/P08_Email_Prefilled_App.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 09: CRUD Operations using SQLite
- **Package Name:** `com.example.crudsqlite`
- **Database File:** `/data/data/com.example.crudsqlite/databases/StudentDB.db`
- **Component:** `MainActivity` with `DatabaseHelper` (SQLiteOpenHelper)
- **UI Architecture:** Native input fields (ID, Name, Email), 4 action buttons (Insert, View All, Update, Delete), and `ListView`
- **Build Status:** SUCCESS (`assembleDebug` & signed `assembleRelease`)
- **Install Command:** `adb install -r 09_CRUD_SQLite/app/build/outputs/apk/debug/app-debug.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **CREATE Test:** Inserted records for "Alice Smith" and "Bob Miller". Verified auto-increment IDs (#1, #2) and dynamic list view updates.
- **READ ALL Test:** Tapped "View All" -> Queried all rows via `Cursor` in `getAllStudents()`, displaying records in `ListView`.
- **UPDATE Test:** Tapped "Update" on ID #2 -> Changed name to "Robert Miller", email to `robert.miller@example.com`. Verified row update in SQLite and live list refresh.
- **DELETE Test:** Tapped "Delete" on ID #1 -> Record #1 deleted from SQLite table `students`. List dynamically refreshed showing 1 remaining record (Robert Miller).
- **Persistence Verification:** Application restarted; database state retained across lifecycles.
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_09/P09_CRUD_Create.png`
  - `Practical_Screenshots/Practical_09/P09_CRUD_Read.png`
  - `Practical_Screenshots/Practical_09/P09_CRUD_Update.png`
  - `Practical_Screenshots/Practical_09/P09_CRUD_Delete.png`
- **Google Doc Embedded:** Yes (All 4 images synchronized to Master Google Doc)
- **Verification Status:** PASS

---

### Practical 10: Android Application Deployment & Release Packaging
- **Package Name:** `com.example.deploymentapp`
- **Version:** Code: `100` | Name: `1.0.0-release`
- **Signing Keystore:** `~/.android/scs391_release.jks` (Key: `scs391Release`, RSA 2048-bit)
- **Release Deliverable:** `10_Application_Deployment/release/app-release.apk`
- **Build Status:** SUCCESS (`assembleRelease`)
- **Signature Verification:** Verified using `apksigner` -> Scheme v2 `true`, valid production certificate.
- **Hardware Install Command:** `adb install -r 10_Application_Deployment/release/app-release.apk`
- **Installation Output:** `Performing Streamed Install -> Success`
- **Runtime Hardening Verification:** `FLAG_DEBUGGABLE` reports `FALSE (Production Release)`.
- **Runtime Certificate Extraction:** Verified SHA-256 fingerprint matches `apksigner` digest.
- **Additional Release Deliverables Built & Signed:**
  - `02_Hello_World/release/app-release.apk` (Signed Release APK)
  - `09_CRUD_SQLite/release/app-release.apk` (Signed Release APK)
- **Hardware Screenshots:**
  - `Practical_Screenshots/Practical_10/P10_Release_Execution.png`
  - `Practical_Screenshots/Practical_10/P10_Release_Verification.png`
- **Google Doc Embedded:** Yes (Both images synchronized to Master Google Doc)
- **Verification Status:** PASS
