<!-- GETTING STARTED -->

🔧 Firebase Setup (Required in App Module)
To enable Firebase features (Analytics, Remote Config, Crashlytics...) used by this library, please follow the steps below in your app project.

1️⃣ Add Firebase 

```kotlin
pluginManagement {
    plugins {
        id("com.google.gms.google-services") version "latest.release" apply false
        alias(libs.plugins.google.firebase.crashlytics) apply false
    }
}

subprojects {
    configurations.all {
        // No cache for dynamic versions
        resolutionStrategy.cacheDynamicVersionsFor(0, "seconds")
        resolutionStrategy.cacheChangingModulesFor(0, "seconds")
    }
}

// ✅ Warning logger, safe & less spam
gradle.projectsEvaluated {
    subprojects {
        configurations
            .filter { it.isCanBeResolved }
            .forEach { config ->
                config.resolutionStrategy.eachDependency {
                    val v = requested.version ?: return@eachDependency
                    if (v == "+" || v.contains("latest.release", ignoreCase = true)) {
                        println("⚠️  Dynamic version detected → ${requested.group}:${requested.name}:$v in module ${project.name}")
                    }
                }
            }
    }
}

tasks.register("printResolvedDeps") {
    doLast {
        subprojects {
            println("📦 Module: $name")
            configurations
                .filter { it.isCanBeResolved }
                .forEach { cfg ->
                    cfg.resolvedConfiguration
                        .firstLevelModuleDependencies
                        .forEach {
                            println("   → ${it.moduleGroup}:${it.moduleName}:${it.moduleVersion}")
                        }
                }
        }
    }
}
```

2️⃣ In app/build.gradle.kts
```
plugins {
    id("com.android.application")
    id("com.google.gms.google-services")                     // 🔧 Google Services (required)
    alias(libs.plugins.google.firebase.crashlytics)          // Optional: for Crashlytics
}

dependencies {
    .....
    implementation("com.google.android.gms:play-services-ads:latest.release")
    implementation("com.google.ads.mediation:vungle:latest.release")
    implementation("com.google.ads.mediation:pangle:latest.release")
    implementation("com.google.ads.mediation:applovin:latest.release")
    implementation("com.google.ads.mediation:facebook:latest.release")
    implementation("com.unity3d.ads:unity-ads:latest.release")
    implementation("com.google.ads.mediation:unity:latest.release")
    implementation("com.google.ads.mediation:ironsource:latest.release")
    implementation("com.google.ads.mediation:mintegral:latest.release")
}
```

Call in app:
```
 FireBaseConfig.initRemoteConfig(R.xml.remote_config_defaults,object : FireBaseConfig.CompleteListener{
            override fun onComplete() {
                FireBaseConfig.getValue("test")
                
            }
        })


  
