# SCS391 Mobile Application Development Lab — Full Syllabus Coverage Audit

**Author:** Amatrasu66  
**Course Code:** SCS391 – Mobile App Development Lab  
**Reference Document:** `refrence_file/Android_Java_13_Practicals_With_Studio_Screenshots.docx`  
**Master Google Doc ID:** `1pA0UY_HGMcekwgpwh4SVj7VfuM3f5R5iSJUdMKYosSw`  
**Audit Date:** 10-Nov-2026  
**Audit Standard:** Anti-Slop Academic Compliance (`ANTI_SLOP_SKILL.md`)

---

## 1. Executive Audit Summary

The original SCS391 lab curriculum comprises **13 practical exercises** defined in `Android_Java_13_Practicals_With_Studio_Screenshots.docx`. Additionally, the portfolio maintains an essential **Android Studio & SDK Setup Guide** as its theoretical foundation (Portfolio Practical 01).

The previous implementation phase completed 10 practical entries, but left several specific architectural gaps relative to the full university syllabus:
1. **Combined Intents:** Implicit and Explicit Intents were merged into a single project (`03_Intent_Demonstration`), whereas the syllabus mandates distinct conceptual and practical demonstrations.
2. **Missing Google Maps Practical:** Syllabus Exercise 12 ("Displaying a Map Based on Current or Given Location") was absent from the project suite.
3. **Missing Themes & User Preferences Practicals:** Syllabus Exercise 6 ("Applying a Theme in an Activity/Application") and Exercise 8 ("Storing Local Data Using User Preferences") were missing standalone projects.
4. **Picker View & ListView Separation:** Syllabus Exercise 4 ("Picker View") and Exercise 5 ("ListView") were combined inside an Appointment Form rather than presented as distinct syllabus exercises.
5. **Theme Consistency:** The Email, SQLite CRUD, and Deployment applications used dark/grey container palettes rather than the mandated clean Android light theme.

---

## 2. Authoritative Syllabus Mapping & Coverage Matrix

| Syllabus # | Exact Syllabus Title (from DOCX) | Portfolio # | Project Directory | Implementation Scope & Required Functionality | Current Audit Status | Required Action / Remediation |
|:---:|---|:---:|---|---|:---:|---|
| **—** | *Environment Setup & Toolchain* | **01** | `01_Android_Studio_Setup` | Complete installation & architecture guide: IDE, SDK, AVD, JDK. | **COMPLETE** | Preserve as foundational Practical 01. |
| **1** | Creating a Hello World Application | **02** | `02_Hello_World` | Display "Hello World!" centered using Java & XML layout. | **COMPLETE** | Retain clean native RelativeLayout. |
| **2A** | Implementing the Concept of Intent (Part A) | **03** | `03_Implicit_Intent` | Implicit Intent: Delegate external action (ACTION_DIAL / ACTION_VIEW) with fallback. | **NEEDS REWORK** | Separate from combined P03 into dedicated independent project. |
| **2B** | Implementing the Concept of Intent (Part B) | **04** | `04_Explicit_Intent` | Explicit Intent: Launch SecondActivity and pass string payload via Intent extras. | **NEEDS REWORK** | Separate from combined P03 into dedicated independent project. |
| **3** | Displaying a Message Based on Screen Orientation | **05** | `05_Screen_Orientation` | Detect Portrait vs. Landscape dynamically; load `layout/` and `layout-land/`. | **COMPLETE** | Retain existing verified native implementation. |
| **4** | Developing an Application Using Picker View | **06** | `06_Picker_View` | Standalone DatePicker and TimePicker with formatted display output. | **PARTIALLY COVERED** | Extract clean standalone project from combined appointment form. |
| **5** | Developing an Application Using ListView | **07** | `07_List_View` | Standalone ListView populated via ArrayAdapter with item selection Toast. | **PARTIALLY COVERED** | Extract clean standalone project from combined appointment form. |
| **6** | Applying a Theme in an Activity/Application | **08** | `08_Theme_Application` | Custom light theme in `res/values/themes.xml` applied to Activity/Application. | **MISSING** | Create dedicated project demonstrating custom light theme application. |
| **7** | Creating a Menu in an Android Application | **09** | `09_Menu_Bar` | Native Toolbar with Options Menu (Home, Settings, About, Help) & item callbacks. | **COMPLETE** | Renumber to Practical 09. |
| **8** | Storing Local Data Using User Preferences | **10** | `10_User_Preferences` | Key-value data persistence via `SharedPreferences` surviving app relaunch. | **MISSING** | Create dedicated project demonstrating save/load persistence. |
| **9** | Creating, Reading and Writing Data Using SQLite | **11** | `11_CRUD_SQLite` | Full CRUD operations (Insert, View All, Update, Delete) via `SQLiteOpenHelper`. | **NEEDS REWORK** | Renumber to Practical 11; rework UI with clean light theme. |
| **10** | Creating an Application to Send SMS | **12** | `12_SMS_Application` | Send SMS via `Intent.ACTION_SENDTO` with `smsto:` scheme (zero permissions). | **COMPLETE** | Renumber to Practical 12. |
| **11** | Creating an Application to Send an E-mail | **13** | `13_Email_Application` | Send Email via `Intent.ACTION_SENDTO` with `mailto:` & system chooser dialog. | **NEEDS REWORK** | Renumber to Practical 13; rework UI with clean light theme. |
| **12** | Displaying a Map Based on Current or Given Location | **14** | `14_Google_Maps_Location` | Display location using Google Maps via clean Intent `geo:` URI / Google Maps SDK. | **MISSING** | Create standalone project with given coordinates and current location option. |
| **13** | Deploying Android Applications | **15** | `15_Application_Deployment` | Release build packaging, APK Signature Scheme v2, runtime hardening check. | **NEEDS REWORK** | Renumber to Practical 15; rework UI with clean light theme. |

---

## 3. Detailed Gap Analysis by Practical Category

### 3.1 Communication Practicals
- **Syllabus 10 (Sending SMS):** Currently `07_SMS_Application`. Uses `Intent.ACTION_SENDTO` with `smsto:`. Validated and working cleanly. Action: Renumber to Practical 12.
- **Syllabus 11 (Sending Email):** Currently `08_Email_Application`. Uses `Intent.ACTION_SENDTO` with `mailto:` and `Intent.createChooser()`. Working, but currently uses a dark/grey background. Action: Rework with crisp light theme (`#FFFFFF` background, high-contrast inputs) and renumber to Practical 13.

### 3.2 Intent Practicals
- **Syllabus 2 (Implementing Intents):** Was previously implemented as a single combined project (`03_Intent_Demonstration`) demonstrating both explicit navigation and implicit phone dialer.
- **Remediation:**
  - Create `03_Implicit_Intent` as a standalone project with single action button triggering an implicit intent (`ACTION_DIAL` / `ACTION_VIEW`) with graceful fallback.
  - Create `04_Explicit_Intent` as a standalone project with `MainActivity` navigating to `SecondActivity` carrying string extras, which `SecondActivity` unpacks and renders.

### 3.3 Google Maps Practical
- **Syllabus 12 (Maps using current/given location):** Completely missing from the current portfolio.
- **Remediation:** Implement `14_Google_Maps_Location`.
  - Provide controls for given location (e.g. Golden Temple, Amritsar: `31.6200, 74.8765`, as specified in the reference DOCX).
  - Provide button to launch Google Maps with location marker using standard Android `geo:` Intent (`geo:31.6200,74.8765?q=31.6200,74.8765(Golden+Temple+Amritsar)`), with fallback to web browser if Maps is not installed.
  - Provide optional device current location lookup via Android LocationManager with proper permission checks.

### 3.4 UI & Component Practicals
- **Themes (Syllabus 6):** Completely missing. Implement `08_Theme_Application` demonstrating a custom light theme defined in `res/values/themes.xml` (e.g. `Theme.CustomLight`) applied to the Activity, styling buttons and text colors.
- **User Preferences (Syllabus 8):** Completely missing. Implement `10_User_Preferences` demonstrating `SharedPreferences` storing a user's name or setting and restoring it on launch.
- **Picker View (Syllabus 4):** Implement `06_Picker_View` with standalone `DatePicker` and `TimePicker` and a "Show Selection" button updating a `TextView`.
- **ListView (Syllabus 5):** Implement `07_List_View` with a native `ListView` displaying an array of items (programming languages) via `ArrayAdapter` and showing a `Toast` on click.
- **Appointment Form:** The previous Practical 04 combined pickers and listview; we preserve it in git history and replace the combined form with canonical standalone practicals 06 and 07.

### 3.5 Light-Theme Rework
- **Email Application (`13_Email_Application`):** Update background to `#FFFFFF`, text to `#1F1F1F`, clean stroke borders on inputs, Google Blue button (`#1A73E8`).
- **SQLite CRUD Application (`11_CRUD_SQLite`):** Update background to `#FFFFFF`, clean high-contrast text, light item rows in `ListView`, distinct light action buttons.
- **Deployment Application (`15_Application_Deployment`):** Update to white background, dark legible text, clean verification indicators.

---

## 4. Execution Roadmap

```
Step 1: Create independent 03_Implicit_Intent
Step 2: Create independent 04_Explicit_Intent
Step 3: Create 06_Picker_View (Standalone DatePicker & TimePicker)
Step 4: Create 07_List_View (Standalone ListView with ArrayAdapter)
Step 5: Create 08_Theme_Application (Custom light theme demonstration)
Step 6: Renumber 06_Menu_Bar to 09_Menu_Bar
Step 7: Create 10_User_Preferences (SharedPreferences persistence)
Step 8: Renumber 09_CRUD_SQLite to 11_CRUD_SQLite & apply Light Theme
Step 9: Renumber 07_SMS_Application to 12_SMS_Application
Step 10: Renumber 08_Email_Application to 13_Email_Application & apply Light Theme
Step 11: Create 14_Google_Maps_Location (Maps via geo: intent & given location)
Step 12: Renumber 10_Application_Deployment to 15_Application_Deployment & apply Light Theme
Step 13: Build and test all projects with Gradle
Step 14: Hardware testing & screenshot capture on OnePlus CPH2661
Step 15: Update Master Google Doc with all 15 practicals and inline screenshots
Step 16: Commit and push clean git repository
```
