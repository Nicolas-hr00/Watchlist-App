// Defining Compose version
val composeVersion = "1.5.0" // Adjust the Compose version as necessary

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp") version "1.9.0-1.0.11"
    id("org.jetbrains.kotlin.kapt") // Add the KAPT plugin
    kotlin("jvm") version "1.9.10"  // Use the latest stable version

}

android {
    namespace = "com.example.watchlistaplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.watchlistaplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

dependencies {
    // AndroidX and Core libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Compose dependencies
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation(libs.androidx.benchmark.macro)
//    implementation("androidx.activity:activity-compose:1.3.1")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    // Core library desugaring
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    // OpenCSV
    implementation("com.opencsv:opencsv:5.5.2")

    // Additional Compose dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("com.google.accompanist:accompanist-flowlayout:0.17.0")
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.24.2-alpha")

    // Compose Nav Destinations
    implementation("io.github.raamcosta.compose-destinations:core:1.1.2-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.1.2-beta")

    // Coil for image loading
    implementation("io.coil-kt:coil-compose:1.4.0")

    // Dagger - Hilt for Dependency Injection

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

//    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android-compiler:2.40.5") // KAPT for Dagger-Hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0") // For Hilt Navigation with Compose


    // Retrofit for network requests
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

    // Room for database management
    implementation("androidx.room:room-runtime:2.4.2")
    kapt("androidx.room:room-compiler:2.4.2") // KAPT for Room
    implementation("androidx.room:room-ktx:2.4.2")
}
