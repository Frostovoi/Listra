plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.compose.compiler)

}



android {
    namespace = "com.example.listra"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.listra"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":core:api"))
    implementation(project(":core:network"))
    implementation(project(":core:di"))

    implementation(project(":feature:ads:ads_repo"))
    implementation(project(":feature:search:search_repo"))

    implementation(project(":feature:ads:my_ads"))
    implementation(project(":feature:ads:post_ad"))
    implementation(project(":feature:ads:ad_details"))
    implementation(project(":feature:profile:profile"))
    implementation(project(":feature:search:search_screen"))
    implementation(project(":feature:authentication:login"))
    implementation(project(":feature:authentication:register"))
    implementation(project(":feature:authentication:reset"))


    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    // DataStore
    implementation(libs.androidx.datastore.preferences)


    //Compose
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)


}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
