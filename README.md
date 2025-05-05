<!-- GETTING STARTED -->

🔧 Firebase Setup (Required in App Module)
To enable Firebase features (Analytics, Remote Config, Crashlytics...) used by this library, please follow the steps below in your app project.

1️⃣ Add Firebase 
 plugins {
        id("com.google.gms.google-services") version "4.4.2" apply false
        alias(libs.plugins.google.firebase.crashlytics) apply false
    }
2️⃣ In app/build.gradle.kts

plugins {
    id("com.android.application")
    id("com.google.gms.google-services")                     // 🔧 Google Services (required)
    alias(libs.plugins.google.firebase.crashlytics)          // Optional: for Crashlytics
}


  
