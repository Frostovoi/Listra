plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.identity_google"
    compileSdk = 36

    buildFeatures { buildConfig = true }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField(
            "String",
            "SERVER_CLIENT_ID",
            "\"${project.findProperty("SERVER_CLIENT_ID") ?: "DEV_ID.apps.googleusercontent.com"}\""
        )
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.googleid)
    implementation(libs.play.services.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Credentials
    implementation(libs.androidx.credentials.play)
    implementation(libs.androidx.credentials)

    implementation(project(":core:identity-api"))
    implementation(project(":core:api"))

    // Coroutines
    implementation(libs.bundles.coroutines)

    // Dagger 2
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)


}