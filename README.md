# Felony Reporter

![Android](https://img.shields.io/badge/Android-API%2021%2B-3DDC84?logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Language-Java-007396?logo=openjdk&logoColor=white)
![Version](https://img.shields.io/badge/Version-1.0-blue)
![Gradle](https://img.shields.io/badge/Gradle-7.2-02303A?logo=gradle&logoColor=white)

**Felony Reporter** is an Android application prototype for submitting and viewing crime and missing-person reports. It uses Firebase Authentication for email/password accounts and Firebase Realtime Database to store submitted reports.

The project demonstrates a simple mobile reporting workflow; it is **not an official police reporting service or an emergency-response system**.

## Features

- **Account access:** sign up and sign in with email and password; sign out from the navigation drawer.
- **Crime reporting:** submit a name, location (city, state, and PIN code), and description.
- **Missing-person reporting:** submit a name, location, description, and image URL.
- **Report listings:** browse crime reports and missing-person records retrieved from Firebase Realtime Database.
- **Image display:** load images linked in missing-person reports using Picasso.
- **Navigation drawer:** access the home screen, report listings, and sign-out action.

> **Current limitations:** The screens labeled “Crime Search” and “Missing Persons” display lists; they do not implement keyword or location filtering. The drawer's “Report” item has no action. Report status tracking, police verification, and report moderation are not implemented.

## Tech stack

| Component | Technology |
| --- | --- |
| Platform | Android (minimum SDK 21, compile/target SDK 31) |
| Language | Java 8 source compatibility |
| UI | AndroidX, Material Components, ConstraintLayout, RecyclerView |
| Authentication | Firebase Authentication (email/password) |
| Data storage | Firebase Realtime Database |
| Image loading | Picasso 2.71828 |
| Build | Gradle Wrapper 7.2, Android Gradle Plugin 7.1.0 |

The Gradle configuration also declares Firebase Analytics and Cloud Firestore dependencies; the reporting flows currently use **Realtime Database**, not Firestore.

## Getting started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) with the Android SDK Platform **31** installed
- **JDK 11**, compatible with the project's Android Gradle Plugin
- An Android emulator or device running **Android 5.0 (API 21)** or later
- A [Firebase project](https://console.firebase.google.com/) for development/testing

### 1. Clone the repository

```bash
git clone https://github.com/Chinmaya1910/Felony-Reporter.git
cd Felony-Reporter
```

### 2. Configure Firebase

1. Create or select a Firebase project and register an Android app with package name `com.example.felonyreporter`.
2. Download that app's `google-services.json` and place it at `app/google-services.json`, replacing the repository's existing configuration with **your own test-project configuration**.
3. In Firebase Authentication, enable the **Email/Password** sign-in provider.
4. Create a **Firebase Realtime Database** and configure security rules that allow the intended signed-in test users to read and write the report paths. Do **not** make a database containing real personal information publicly readable or writable.
5. Ensure the Android app is connected to the Firebase project and database you configured.

The application reads and writes these Realtime Database paths:

- `crimes` — crime reports
- `missing persons` — missing-person reports

For Firebase configuration details, see [Add Firebase to your Android project](https://firebase.google.com/docs/android/setup) and [Realtime Database security rules](https://firebase.google.com/docs/database/security).

### 3. Build and run

Open the cloned directory in Android Studio, select **JDK 11** for Gradle if necessary, allow Gradle to sync, then run the `app` configuration on an emulator or connected device.

Alternatively, build a debug APK from the repository root:

**macOS / Linux**

```bash
bash ./gradlew assembleDebug
```

**Windows**

```powershell
.\gradlew.bat assembleDebug
```

The debug APK is produced at `app/build/outputs/apk/debug/app-debug.apk` when the build succeeds.

## Using the app

1. Launch the app and select **Signup** to register an account, or **Login** with an existing email/password account.
2. From the home screen, select **Report Crime** or **Report Missing Person**.
3. Fill in the required fields and submit. Missing-person entries require a publicly reachable **image URL**, not an image upload.
4. Open the navigation drawer and choose **Crime Search** or **Missing Persons** to view records stored in Realtime Database.
5. Use **Logout** in the navigation drawer to sign out.

### Data behavior to know

- Records are saved under the supplied **name** as the database key, so submitting another record with the same name can overwrite the previous record.
- The crime-category spinner is displayed, but the current implementation reads its transition name rather than the selected item, so category values may not be stored as expected.
- Report submission does not await a confirmed database write before showing a success message.
- Use **fictional test data only** until access controls, validation, and privacy safeguards have been reviewed.

## Project structure

```text
Felony-Reporter/
├── app/
│   ├── build.gradle                  # Android app config and dependencies
│   ├── google-services.json         # Firebase configuration (replace for your project)
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/com/example/felonyreporter/
│       │   │   ├── MainActivity.java  # Login
│       │   │   ├── signup.java        # Registration
│       │   │   ├── home.java          # Home and navigation
│       │   │   ├── addcrime.java      # Create crime report
│       │   │   ├── addmissingperson.java
│       │   │   ├── users.java         # Crime report list
│       │   │   ├── Missing_search.java # Missing-person list
│       │   │   └── *RV*.java          # RecyclerView adapters and models
│       │   └── res/                  # Layouts, menus, and images
│       ├── test/                     # Local unit test example
│       └── androidTest/              # Instrumentation test example
├── gradle/wrapper/
├── build.gradle                      # Root build configuration
├── settings.gradle
├── gradlew
└── gradlew.bat
```

See the [application source](app/src/main/java/com/example/felonyreporter/), [layouts](app/src/main/res/layout/), and [app dependencies](app/build.gradle) for implementation details.

## Testing

Run the existing local unit tests:

```bash
bash ./gradlew testDebugUnitTest
```

With an emulator or device connected, run instrumentation tests:

```bash
bash ./gradlew connectedAndroidTest
```

The repository currently contains basic example tests, **not comprehensive feature or security coverage**. Build and test commands are provided from the project configuration; they have not been independently verified here.

## Contributing

Contributions that improve correctness, accessibility, database security, tests, and the user experience are welcome for review.

1. [Open an issue](https://github.com/Chinmaya1910/Felony-Reporter/issues) to describe a bug or proposed enhancement.
2. Fork the repository and create a focused feature branch.
3. Make your changes and run the relevant tests.
4. [Open a pull request](https://github.com/Chinmaya1910/Felony-Reporter/pulls) with a summary and testing notes.

## Help and support

For project-specific problems or feature requests, use [GitHub Issues](https://github.com/Chinmaya1910/Felony-Reporter/issues).

For platform setup, refer to the [Android Developers documentation](https://developer.android.com/docs) and [Firebase documentation](https://firebase.google.com/docs).

## Maintainer

Maintained by [@Chinmaya1910](https://github.com/Chinmaya1910).

