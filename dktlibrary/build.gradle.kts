plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.admob.max.dktlibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-process:2.5.1")

    // UI
    implementation("androidx.appcompat:appcompat:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("com.pnikosis:materialish-progress:1.7")
    implementation("com.facebook.shimmer:shimmer:0.5.0@aar")

    // Ads
    implementation("com.applovin:applovin-sdk:13.2.0")
    implementation("com.google.android.gms:play-services-ads:24.2.0")
    implementation("com.android.installreferrer:installreferrer:2.2")
    implementation("com.intuit.sdp:sdp-android:1.1.1")

    // Other
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.airbnb.android:lottie:6.6.0")
    implementation("com.google.android.ump:user-messaging-platform:3.2.0")

    implementation(platform("com.google.firebase:firebase-bom:34.0.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics-ndk")
    implementation("com.google.firebase:firebase-config")

    implementation ("com.reyun.solar.engine.oversea:solar-engine-core:1.3.0.5"){
        exclude(group = "com.huawei.hms", module = "ads-identifier")
        exclude(group = "com.hihonor.mcs", module = "ads-identifier")
    }
}