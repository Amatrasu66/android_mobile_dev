# ANTI-SLOP IMPLEMENTATION RULEBOOK: SCS391 PRACTICAL PORTFOLIO

## Operating Mode
`antislop active: during (session override)`

## Core Directive
This is an academic practical portfolio for a university Mobile App Development Lab course (SCS391), **not** a commercial product, design showcase, startup landing page, portfolio website, or UI demonstration project. Every application must look like a clean, minimal, functional Android practical created by a university student.

---

## The 20 Persistent Implementation Principles

1. **Implement only what the syllabus requires:** Do not exceed the explicit practical requirements.
2. **Every visible element must serve a purpose:** Every control or text must directly serve a practical requirement or a necessary user interaction.
3. **Simplest possible implementation:** Prefer the most direct, minimal native Android implementation that demonstrates the required functionality.
4. **No decorative elements:** Zero purely decorative visuals without functional purpose.
5. **No fake branding:** No fake logos, badges, slogans, marketing headings, or invented product/lab identities.
6. **No unnecessary containers:** No unnecessary cards (`MaterialCardView`), nested panels, complex toolbars, navigation sections, status sections, or dashboard layouts.
7. **No fake metadata or metrics:** No fake statistics, progress indicators, usage info, or technical metadata.
8. **No excessive icons or emoji:** Use icons only when explicitly called for (e.g. `ImageButton` in P04). Zero decorative emoji.
9. **No unnecessary visual effects:** No unnecessary animations, gradients, glows, shadows, glassmorphism, or elaborate backgrounds. Plain, native backgrounds only.
10. **No oversized typography:** Standard, legible Android native typography. No arbitrary massive display headings.
11. **No repeated or redundant labels:** Eliminate redundant subtitles, captions, and explanatory paragraphs that add no value.
12. **Do not display implementation details to user:** The UI must not show internal implementation details or architecture notes.
13. **No runtime framework metadata:** Do not display Android API levels, target SDK numbers, framework names, source-language descriptions, or lab branding inside the application's UI unless the practical explicitly asks for them.
14. **Visually native and straightforward:** Use standard, default Android visual language (`TextView`, `Button`, `EditText`, `Spinner`, `ListView`).
15. **Clean mobile layout:** Keep layouts readable, uncrowded, and usable on the physical OnePlus phone without horizontal or vertical clipping.
16. **Only required widgets:** Use only the required widgets and controls for each practical.
17. **No extraneous features:** Do not add features outside the specific practical's objective.
18. **No unnecessary test/sample data:** Do not prefill artificial sample lists or decorative sample records unless needed for initial demonstration.
19. **Zero unnecessary permissions:** Never request permissions that are not strictly necessary.
20. **Preserve practical objective:** Do not distort or expand the practical's objective to justify extra features.

---

## Strict Approval Test

Before accepting or adding any UI element or code block, apply this test:

> **"Would this element be necessary for a student to demonstrate the exact practical requirement?"**

- **If YES:** Keep it minimal and functional.
- **If NO:** Do NOT add it. Strip it immediately.

---

## Practical-by-Practical Minimalist Baseline

- **Practical 02 (Hello World):** One Activity, one centered `TextView` displaying `Hello World!`. Plain background, zero cards, zero descriptions.
- **Practical 03 (Intents):** One button to trigger Explicit Intent (passes small text to `SecondActivity`, which displays the text), one or two buttons to trigger Implicit Intent (Web / Dialer). Clean, straightforward buttons.
- **Practical 04 (Appointment Form):** Single minimal form with `ImageButton`, `Spinner`, `DatePicker`, `TimePicker`, `Button` ("Book Appointment"), and a `ListView` displaying submitted appointments. Zero fake calendar cards or appointment stats.
- **Practical 05 (Screen Orientation):** Simple screen displaying current orientation ("Portrait Mode" or "Landscape Mode"). Usable in both orientations without locking.
- **Practical 06 (Menu Bar):** Standard native Android Options Menu with Home, Settings, About. Shows simple Toast or minimal text feedback on selection. Zero dashboard widgets.
- **Practical 07 (Send SMS):** Recipient `EditText`, Message `EditText`, and one Button to open the default SMS app prefilled via `Intent.ACTION_SENDTO` with `smsto:`.
- **Practical 08 (Send Email):** Recipient `EditText`, Subject `EditText`, Message `EditText`, and one Button to launch the email chooser via `Intent.ACTION_SENDTO` with `mailto:`.
- **Practical 09 (CRUD SQLite):** Inputs for ID, Name, Email. Four buttons: INSERT, READ ALL, UPDATE, DELETE. A simple `ListView` showing stored student records. Zero analytics charts or complex cards.
- **Practical 10 (Deployment):** Minimal release build verification screen showing the application ID, version, and confirmation of running as a signed release build.
