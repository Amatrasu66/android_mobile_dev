# Practical 09: Implementation of Options Menu Bar

## 1. Aim
To develop a native Android application demonstrating an Options Menu with items (Home, Settings, About, Help) inflated via XML and handled through menu callback methods.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `Toolbar`, `Menu`, `MenuItem`, `TextView`

## 3. Implementation Details
- `MainActivity.java`: Sets up native `Toolbar` as support action bar, inflates `res/menu/menu_main.xml` in `onCreateOptionsMenu()`, and handles item selection in `onOptionsItemSelected()`.
- `res/menu/menu_main.xml`: Defines menu options: Home, Settings, About, Help.
