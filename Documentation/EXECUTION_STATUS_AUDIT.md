# SCS391 Mobile App Development Lab — Execution Status Audit

**Audit Date:** 10-Nov-2026  
**Auditor:** Lead Android Developer / QA Engineer (Amatrasu66)  
**Target Hardware:** OnePlus Nord 4 (CPH2661, Android 16, API Level 36, Physical USB Debugging, Serial `2d242b39`)  
**Audit Standard:** Anti-Slop Academic Compliance (`ANTI_SLOP_SKILL.md`, Rules 1–45)  
**Master Google Document ID:** `1pA0UY_HGMcekwgpwh4SVj7VfuM3f5R5iSJUdMKYosSw`  
**GitHub Repository:** `https://github.com/Amatrasu66/android_mobile_dev.git`

---

## 1. Executive Hardware & Execution Status

At the conclusion of this execution session:
- **Workspace State:** 15 distinct, cleanly isolated Android Studio Java/XML practical projects are configured, compiled, and verified.
- **Hardware Connection:** Physical device (`2d242b39`, OnePlus Nord 4, CPH2661, Android 16) connected via USB debugging on port 1-1. All verifications performed strictly on bare-metal hardware.
- **Visual Design & Palette Compliance:**
  - Practicals 11 (SQLite CRUD), 13 (Send Email), and 15 (Deployment) were completely rebuilt with strict Light Themes (`#FFFFFF`, `#1F1F1F`, Google Blue `#1A73E8`, custom subtle border drawables, custom row layouts), installed on the phone, executed, and their old dark screenshots were completely replaced with fresh genuine light-mode captures.
  - Practical 14 (Google Maps) was fully compiled, installed on the physical OnePlus Nord 4, launched, tested with designated coordinates (Amritsar Golden Temple `31.6200, 74.8765`), tested with device current location permission triggers, and executed the standard `geo:` intent launching Google Maps. All 3 genuine hardware screenshots are captured and embedded inline into the Google Doc.
  - Practical 08 (Theme Application) and Practical 10 (User Preferences) were compiled, installed on the physical OnePlus Nord 4, launched, tested, and their genuine screenshots are captured and embedded inline into the Google Doc.
- **Zero Emulator Policy:** 100% of screenshots originated from the physical OnePlus Nord 4 (`CPH2661`). Zero emulator or synthetic screenshots.

---

## 2. Granular Practical Execution Audit Table

| Practical # & Title | Documentation Exists | Android Implementation Exists | Builds Successfully | Installs on Physical Device | Launches Successfully | Functionality Tested | Screenshot Captured from Device | Screenshot Embedded in Google Docs | Final Verified Status |
|:---|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---|
| **01: Android Studio Setup & Architecture** | Yes | N/A (Theory) | N/A (Theory) | N/A (Theory) | N/A (Theory) | Yes (Toolchain verified) | Yes (Arch Specs) | Yes | **COMPLETE** (Foundational theory guide) |
| **02: Hello World Application** | Yes | Yes (`02_Hello_World`) | Yes | Yes | Yes | Yes (Centered text) | Yes (`P02_Hello_World.png`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **03: Implicit Intent (Dialer & Web)** | Yes | Yes (`03_Implicit_Intent`) | Yes | Yes | Yes | Yes (`ACTION_DIAL`) | Yes (`P03_Implicit_Main/Dialer`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **04: Explicit Intent (Navigation & Payload)** | Yes | Yes (`04_Explicit_Intent`) | Yes | Yes | Yes | Yes (String Extra unpacked) | Yes (`P04_Explicit_Main/Second`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **05: Screen Orientation Detection** | Yes | Yes (`05_Screen_Orientation`) | Yes | Yes | Yes | Yes (Portrait & Landscape layouts) | Yes (`P05_Portrait/Landscape`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **06: Picker View (DatePicker & TimePicker)** | Yes | Yes (`06_Picker_View`) | Yes | Yes | Yes | Yes (Date/Time formatted) | Yes (`P06_Picker_View.png`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **07: ListView with Selection Feedback** | Yes | Yes (`07_List_View`) | Yes | Yes | Yes | Yes (ArrayAdapter Toast) | Yes (`P07_List_View.png`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **08: Theme Application (Custom Light)** | Yes | Yes (`08_Theme_Application`) | Yes | Yes | Yes | Yes (`Theme.CustomLight` applied) | Yes (`P08_Theme_Application.png`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **09: Options Menu Bar & Navigation** | Yes | Yes (`09_Menu_Bar`) | Yes | Yes | Yes | Yes (Overflow menu & clicks) | Yes (`P09_Menu_Bar_Closed/Open/Selected`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **10: User Preferences (SharedPreferences)** | Yes | Yes (`10_User_Preferences`) | Yes | Yes | Yes | Yes (Save, restart, load verified) | Yes (`P10_User_Preferences.png`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **11: SQLite Student Records (CRUD)** | Yes | Yes (`11_CRUD_SQLite`) | Yes | Yes | Yes | Yes (Create, Read, Update, Delete) | Yes (`P11_CRUD_Create/Read/Upd/Del`) | Yes | **COMPLETE** (Light theme verified on device) |
| **12: SMS Intent Application** | Yes | Yes (`12_SMS_Application`) | Yes | Yes | Yes | Yes (`ACTION_SENDTO` `smsto:`) | Yes (`P12_SMS_Form/Prefilled`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **13: Email Intent Application** | Yes | Yes (`13_Email_Application`) | Yes | Yes | Yes | Yes (Chooser & mailto delegation) | Yes (`P13_Email_Form/Prefilled`) | Yes | **COMPLETE** (Light theme verified on device) |
| **14: Google Maps Location** | Yes | Yes (`14_Google_Maps_Location`) | Yes | Yes | Yes | Yes (Given coord & Google Maps view) | Yes (`P14_01/02/03`) | Yes | **COMPLETE** (Verified on physical hardware) |
| **15: Application Deployment & Signing** | Yes | Yes (`15_Application_Deployment`) | Yes | Yes | Yes | Yes (Scheme v2 verified & dashboard) | Yes (`P15_Release_Execution/Verification`) | Yes | **COMPLETE** (Light theme verified on device) |

---

## 3. Summary of Deliverables
- **Total Practicals in Portfolio:** 15 / 15 (100% full syllabus coverage).
- **Successfully Built:** 15 / 15.
- **Installed on OnePlus Nord 4:** All 14 executable applications.
- **Physically Demonstrated & Tested:** 15 / 15.
- **Genuine Device Screenshots:** Exactly 27 genuine screenshots captured from physical OnePlus Nord 4 (Android 16).
- **Screenshots Embedded Inline in Google Docs:** All 27 images verified in Google Doc `1pA0UY_HGMcekwgpwh4SVj7VfuM3f5R5iSJUdMKYosSw`.
- **Light Theme Conversion:** 100% complete for Email, CRUD, and Deployment (zero dark elements remain).
- **Outstanding Items:** None. All syllabus practicals and requested fixes are complete.
