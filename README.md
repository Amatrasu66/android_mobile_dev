# SCS391 Mobile Application Development Lab — Master Portfolio

**Student / Contributor:** Amatrasu66  
**Student Email:** simransagoosagoo@gmail.com  
**Course Code:** SCS391 – Mobile App Development Lab  
**Academic Session:** 2026 – 2027  
**Platform:** Android Studio (Arch Linux x86_64)  
**Language:** Java (JDK 21 LTS / Android Studio JBR)  
**Target Architecture:** Android SDK 36 (VanillaIceCream) / Min SDK 24 (Nougat)  
**Primary Testing Device:** OnePlus CPH2661 (Android 16, API Level 36, Physical USB Debugging, Serial `2d242b39`)  
**GitHub Repository:** [https://github.com/Amatrasu66/android_mobile_dev.git](https://github.com/Amatrasu66/android_mobile_dev.git)  
**Master Google Document:** [SCS391 – Mobile App Development Practical File](https://docs.google.com/document/d/1pA0UY_HGMcekwgpwh4SVj7VfuM3f5R5iSJUdMKYosSw/edit)

---

## 1. Project Overview & Anti-Slop Architecture

This repository hosts the complete, verified, end-to-end deliverables for the **SCS391 Mobile App Development Lab** practical curriculum. It contains **15 independent Android Studio practical projects** developed strictly in **Java** and **XML layouts** covering 100% of the university syllabus exercises plus the foundational setup architecture.

### Anti-Slop Standards Enforced (`ANTI_SLOP_SKILL.md`)
Every application in this repository strictly adheres to minimalist academic practical standards:
- **Zero Decorative Slop:** No unnecessary cards, elevated shadows, faux badges, gradients, or marketing illustrations.
- **Pure Native Controls:** Interfaces utilize direct, purposeful Android widgets (`TextView`, `EditText`, `Button`, `Spinner`, `DatePicker`, `TimePicker`, `Toolbar`, `ListView`).
- **Consistent Light Themes:** Clean white backgrounds (`#FFFFFF`), dark high-contrast typography (`#1F1F1F`), and clean Google Blue (`#1A73E8`) accents.
- **Clean Code Hygiene:** Code focuses purely on syllabus requirements without noisy AI boilerplate comments.
- **Physical Hardware Verification:** 100% of testing performed on physical hardware (OnePlus CPH2661, Android 16). Zero emulator dependency.

---

## 2. Practical Directory & Completion Status (15 Practicals)

| # | Directory | Practical Name | Category | Status | Evidence Screenshots |
|---|---|---|---|---|---|
| **01** | `01_Android_Studio_Setup` | Android Studio, SDK, SDK Tools, AVD & JDK Setup | Theoretical / Architecture | **COMPLETE** | Architecture & Toolchain Specs |
| **02** | `02_Hello_World` | Hello World Java Application | Core Application | **COMPLETE** | 1 Screenshot (`P02_Hello_World.png`) |
| **03** | `03_Implicit_Intent` | Implicit Intent (Action Dial & Web View Delegation) | Core Application | **COMPLETE** | 2 Screenshots (`P03_Implicit_Main`, `P03_Implicit_Dialer`) |
| **04** | `04_Explicit_Intent` | Explicit Intent & Payload Passing (Activity Navigation) | Core Application | **COMPLETE** | 2 Screenshots (`P04_Explicit_Main`, `P04_Explicit_Second`) |
| **05** | `05_Screen_Orientation` | Portrait and Landscape Orientation Detection & Layouts | Configuration & Layouts | **COMPLETE** | 2 Screenshots (`P05_Portrait`, `Landscape`) |
| **06** | `06_Picker_View` | Developing an Application Using Picker View | UI Components & Pickers | **COMPLETE** | 1 Screenshot (`P06_Picker_View.png`) |
| **07** | `07_List_View` | Developing an Application Using ListView with Feedback | UI Components & Adapters | **COMPLETE** | 1 Screenshot (`P07_List_View.png`) |
| **08** | `08_Theme_Application` | Applying a Custom Light Theme in an Activity/Application | Styling & Themes | **COMPLETE** | 1 Screenshot (`P08_Theme_Application.png`) |
| **09** | `09_Menu_Bar` | Options Menu Bar (Home, Settings, About, Help) | Menus & Navigation | **COMPLETE** | 3 Screenshots (`P09_Closed`, `Open`, `Selected`) |
| **10** | `10_User_Preferences` | Local Data Storage Using SharedPreferences | Data Persistence | **COMPLETE** | 1 Screenshot (`P10_User_Preferences.png`) |
| **11** | `11_CRUD_SQLite` | Student Records Management using SQLite (Light Theme) | SQLite Database | **COMPLETE** | 4 Screenshots (`P11_Create`, `Read`, `Update`, `Delete`) |
| **12** | `12_SMS_Application` | SMS Intent Application via `ACTION_SENDTO` (Zero Permissions) | Intents & Communication | **COMPLETE** | 2 Screenshots (`P12_Form`, `Prefilled`) |
| **13** | `13_Email_Application` | Email Intent Application via Chooser (Light Theme) | Intents & Communication | **COMPLETE** | 2 Screenshots (`P13_Form`, `Prefilled`) |
| **14** | `14_Google_Maps_Location` | Displaying Maps via `geo:` Intent (Given & Current Location) | Location & Maps | **COMPLETE** | 3 Screenshots (`P14_Home`, `Permission`, `MapsView`) |
| **15** | `15_Application_Deployment` | Signed Release APK Build, Deployment & Signature Verification | Deployment & Signing | **COMPLETE** | Signed Release APK & 2 Screenshots |

**Total Verified Hardware Screenshots:** Exactly 27 genuine screenshots captured and synchronized to the Master Google Doc.

---

## 3. Physical Hardware Testing Environment

- **Device Model:** OnePlus CPH2661
- **Device Serial:** `2d242b39`
- **Android OS Version:** Android 16 (API Level 36)
- **Physical Resolution:** 1240 x 2772 pixels
- **Screen Density:** 560 dpi
- **Connection Mode:** USB Debugging via Android Debug Bridge (ADB)
- **Zero Emulator Policy:** All builds verified strictly on bare-metal hardware.

---

## 4. Release Deliverables

Pre-built signed release APK packages signed with APK Signature Scheme v2 (RSA 2048-bit, SHA-256 Digest) are preserved directly in the project repositories:
- `15_Application_Deployment/release/app-release.apk`
- `11_CRUD_SQLite/release/app-release.apk`
- `02_Hello_World/release/app-release.apk`

---

## 5. Repository Structure

```
Android Mobile Development/
├── 01_Android_Studio_Setup/
├── 02_Hello_World/
├── 03_Implicit_Intent/
├── 04_Explicit_Intent/
├── 05_Screen_Orientation/
├── 06_Picker_View/
├── 07_List_View/
├── 08_Theme_Application/
├── 09_Menu_Bar/
├── 10_User_Preferences/
├── 11_CRUD_SQLite/
├── 12_SMS_Application/
├── 13_Email_Application/
├── 14_Google_Maps_Location/
├── 15_Application_Deployment/
├── Documentation/
│   ├── MASTER_PRACTICAL_FILE.md
│   ├── PRACTICAL_PROGRESS.md
│   ├── SYLLABUS_COVERAGE_AUDIT.md
│   └── TESTING_REPORT.md
├── Practical_Screenshots/
├── ANTI_SLOP_SKILL.md
└── README.md
```
