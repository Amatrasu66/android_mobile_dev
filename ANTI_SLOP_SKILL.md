# ANTI-SLOP IMPLEMENTATION RULEBOOK: SCS391 PRACTICAL PORTFOLIO

## Operating Mode
`antislop active: during (session override)`

## Core Directive
This is an academic practical portfolio for a university Mobile App Development Lab course (SCS391), **not** a commercial product, design showcase, startup landing page, portfolio website, or UI demonstration project. Every application must look like a clean, minimal, functional Android practical created by a university student.

---

## Persistent Implementation Principles

1. **Implement only what the syllabus requires:** Do not exceed the explicit practical requirements.
2. **Every visible element must serve a purpose:** Every control or text must directly serve a practical requirement or a necessary user interaction.
3. **Simplest possible implementation:** Prefer the most direct, minimal native Android implementation that demonstrates the required functionality.
4. **No decorative elements:** Zero purely decorative visuals without functional purpose.
5. **No fake branding:** No fake logos, badges, slogans, marketing headings, or invented product/lab identities.
6. **No unnecessary containers:** No unnecessary cards (`MaterialCardView`), nested panels, complex toolbars, navigation sections, status sections, or dashboard layouts.
7. **No fake metadata or metrics:** No fake statistics, progress indicators, usage info, or technical metadata.
8. **No excessive icons or emoji:** Use icons only when explicitly called for. Zero decorative emoji.
9. **No unnecessary visual effects:** No unnecessary animations, gradients, glows, shadows, glassmorphism, or elaborate backgrounds. Plain, native backgrounds only.
10. **No oversized typography:** Standard, legible Android native typography. No arbitrary massive display headings.
11. **No repeated or redundant labels:** Eliminate redundant subtitles, captions, and explanatory paragraphs that add no value.
12. **Do not display implementation details to user:** The UI must not show internal implementation details or architecture notes.
13. **No runtime framework metadata:** Do not display Android API levels, target SDK numbers, framework names, source-language descriptions, or lab branding inside the application's UI unless the practical explicitly asks for them.
14. **Visually native and straightforward:** Use standard, default Android visual language (`TextView`, `Button`, `EditText`, `Spinner`, `ListView`).
15. **Clean mobile layout:** Keep layouts readable, uncrowded, and usable on the physical phone without horizontal or vertical clipping.
16. **Only required widgets:** Use only the required widgets and controls for each practical.
17. **No extraneous features:** Do not add features outside the specific practical's objective.
18. **No unnecessary test/sample data:** Do not prefill artificial sample lists or decorative sample records unless needed for initial demonstration.
19. **Zero unnecessary permissions:** Never request permissions that are not strictly necessary.
20. **Preserve practical objective:** Do not distort or expand the practical's objective to justify extra features.

---

## Mandatory Phase 2 Architecture & Light-Theme Rules

21. **Light theme default:** Clean, readable light theme is the mandatory default for all new or reworked practical applications (`#FFFFFF` or light neutral background, dark text, standard Android blue primary actions).
22. **No dark palettes:** Dark palettes are strictly prohibited unless the syllabus explicitly mandates demonstrating a dark theme.
23. **High contrast & readability:** Use high-contrast dark text on light backgrounds for crisp, instantly legible screenshots.
24. **No dark screenshots:** Do not capture or submit dark-theme screenshots for practicals meant to demonstrate normal practical functionality.
25. **Specific syllabus objective:** Every practical must demonstrate its exact syllabus objective.
26. **No arbitrary combinations:** Do not combine separate syllabus practicals merely to reduce project count (e.g., Implicit Intent and Explicit Intent must be independent).
27. **Independent practical records:** Maintain independent practical records, source trees, and documentation for each distinct practical.
28. **No duplicates:** Do not create duplicate practical projects when an existing implementation cleanly satisfies the requirement.
29. **Location integrity:** Never claim that current device location was obtained unless location access actually succeeded.
30. **No simulated maps:** Never present a simulated map or static fake map mockup as a genuine Google Maps result.
31. **No invented requirements:** Do not invent features or requirements absent from the original syllabus.
32. **No decorative UI slop:** Eliminate all dashboards, chips, badges, and marketing headers.
33. **Purposeful iterations only:** Do not generate extra design iterations without a specific functional or readability defect.
34. **Genuine physical device captures:** All screenshots must be captured from the physical phone running bare-metal hardware.
35. **Direct document embedding:** All required screenshots must be embedded directly inside their respective sections in the Google Doc, not merely referenced as URLs or stored on Drive.

---

## Phase 3 Physical Execution & Hardware Verification Rules

36. **Physical execution mandatory:** A practical is not complete until its Android application has been physically executed on bare-metal hardware.
37. **Compilation is not verification:** Compilation success is not equivalent to functional verification; runtime states, lifecycle callbacks, and user interactions must be validated.
38. **Bare-metal captures only:** Screenshots must come from the connected physical Android device. Zero emulator or simulated captures.
39. **Demonstrate actual functionality:** Screenshots must demonstrate actual practical functionality (e.g. data entered, intent fired, records rendered, coordinates mapped), not just idle blank states.
40. **Direct document embedding:** Screenshots must be embedded directly in the correct Google Docs practical section immediately adjacent to the corresponding code and explanation.
41. **Mandatory screenshot replacement:** Old screenshots must be replaced when the underlying application code, theme, or visual design changes. Never retain obsolete dark-theme screenshots.
42. **Academic simplicity preserved:** Simple academic practical interfaces should remain simple, functional, and student-focused.
43. **Consistent light palette:** Light-themed practicals must use a consistent light palette throughout the application (white surfaces `#FFFFFF`, dark text `#1F1F1F`, subtle dividers, light status bars).
44. **Honest reporting:** Never report untested functionality as tested. Clearly delineate hardware-verified operations from pending or blocked operations.
45. **Zero fabrication:** Never fabricate screenshots, mockups, synthetic logs, or test results under any circumstances.

---

## Strict Approval Test

Before adding any UI element or code block, apply this test:

> **"Would this element be necessary for a student to demonstrate the exact practical requirement?"**

- **If YES:** Keep it minimal, functional, and light-themed.
- **If NO:** Do NOT add it. Strip it immediately.
