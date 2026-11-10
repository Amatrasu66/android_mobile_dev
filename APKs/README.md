# SCS391 Mobile App Development Lab — Compiled APK Directory

This directory contains pre-compiled, verifiable, and installable Android package (`.apk`) files for all 14 practical applications of the SCS391 syllabus.

Every APK has been compiled against **Android SDK 36 (VanillaIceCream)** and physically tested on a bare-metal smartphone (**OnePlus Nord 4 / CPH2661, Android 16**).

---

## Catalog of Application Packages

| Practical | File Name | Package Identifier | Architecture / Highlights | Physical Test Status |
|---|---|---|---|---|
| **P02** | `P02_Hello_World.apk` | `com.example.helloworld` | Minimalist native Hello World layout | **PASS** |
| **P03** | `P03_Implicit_Intent.apk` | `com.example.implicitintent` | `ACTION_DIAL` intent delegation | **PASS** |
| **P04** | `P04_Explicit_Intent.apk` | `com.example.explicitintent` | Explicit intent with payload passing | **PASS** |
| **P05** | `P05_Screen_Orientation.apk` | `com.example.screenorientation` | Dynamic portrait & landscape layouts | **PASS** |
| **P06** | `P06_Picker_View.apk` | `com.example.pickerview` | Native DatePicker and TimePicker controls | **PASS** |
| **P07** | `P07_List_View.apk` | `com.example.listviewapp` | ListView bound with ArrayAdapter and click listener | **PASS** |
| **P08** | `P08_Theme_Application.apk` | `com.example.themeapp` | Custom application-wide Light Theme styling | **PASS** |
| **P09** | `P09_Menu_Bar.apk` | `com.example.menubar` | Native Toolbar options menu with feedback | **PASS** |
| **P10** | `P10_User_Preferences.apk` | `com.example.userpreferences` | SharedPreferences persistent storage across lifecycle | **PASS** |
| **P11** | `P11_CRUD_SQLite.apk` | `com.example.crudsqlite` | SQLiteOpenHelper database management (CRUD) | **PASS** |
| **P12** | `P12_SMS_Application.apk` | `com.example.smsapplication` | SMS delegation via `ACTION_SENDTO` (Zero dangerous permissions) | **PASS** |
| **P13** | `P13_Email_Application.apk` | `com.example.emailapp` | Email composition with system chooser (`mailto:`) | **PASS** |
| **P14** | `P14_Google_Maps_Location.apk` | `com.example.googlemapslocation` | Map launching via `geo:` URI (Current & Given coordinates) | **PASS** |
| **P15** | `P15_Application_Deployment.apk` | `com.example.deploymentapp` | Cryptographically signed release build (Scheme v2) | **PASS** |

---

## Installation Instructions

### Method 1: Direct Command Line via ADB (Recommended)
Connect an Android phone via USB with USB Debugging enabled, then run:

```bash
# Install a single practical application
adb install -r APKs/P02_Hello_World.apk

# Install all practical applications at once
for apk in APKs/*.apk; do adb install -r "$apk"; done
```

### Method 2: Direct Download on Android Device
1. Open GitHub on the phone's browser and navigate to the `APKs/` directory.
2. Select the desired `.apk` file and tap **Download Raw File**.
3. In Android settings, enable **Install unknown apps** for the browser/file manager.
4. Tap the downloaded `.apk` to install and launch.
