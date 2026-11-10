# Practical 08: Applying a Theme in an Activity/Application

## 1. Aim
To develop a native Android application demonstrating how to define a custom light theme in XML resources (`res/values/themes.xml`) and apply it globally at the application level to enforce consistent typography, background, surface, and brand accent colors.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, custom light theme (`Theme.CustomLight` extending `Theme.Material3.Light.NoActionBar`)
- Brand Palette: Primary Blue (`#1976D2`), Background (`#F8F9FA`), Surface Text (`#1F1F1F`)

## 3. Implementation Details
- `res/values/themes.xml`: Defines `Theme.CustomLight` with custom status bar color, brand primary color, and surface palettes.
- `activity_main.xml`: Utilizes `?attr/colorPrimary` and `?attr/colorOnSurface` theme references to style UI controls dynamically according to the active theme.
- `AndroidManifest.xml`: Applies the custom theme via `android:theme="@style/Theme.CustomLight"`.
