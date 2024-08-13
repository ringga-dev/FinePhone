plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)

    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ngga.ring.finephone"
    compileSdk = 34

    defaultConfig {
        applicationId = "ngga.ring.finephone"
        minSdk = 26
        targetSdk = 34
        versionCode = 3
        versionName = "0.1.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }

        flavorDimensions += "version"


        productFlavors {
            create("staging") {
                applicationIdSuffix = ".staging"
                versionNameSuffix = "-STAGING"
                resValue("string", "app_name", project.properties["nameStagingString"].toString())

                buildConfigField(
                    "String",
                    "SERVER_URL",
                    project.properties["stagingUrl"].toString()
                )
            }

            create("live") {
//                applicationIdSuffix = ".live"
//                versionNameSuffix = "-LIVE"
                resValue("string", "app_name", project.properties["nameReleaseString"].toString())

                buildConfigField(
                    "String",
                    "SERVER_URL",
                    project.properties["stagingUrl"].toString()
                )
            }
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    /**
     * import module
     */
    implementation(project(":core"))
    implementation(project(":remote"))

    /**
     * project library
     */
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    //ui library
    implementation(libs.material)
    implementation(libs.androidx.animation.core.android)
    implementation(libs.androidx.foundation.android)

    //ai library
    implementation(libs.generativeai)

    //navigasi
    implementation(libs.androidx.navigation.compose)

    // Paper
    implementation("io.github.pilgr:paperdb:2.7.2")

    //dagger-hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    //Log
    implementation(libs.timber)

    //coil
    implementation("io.coil-kt:coil-compose:2.6.0")
    /**
     * project library
     */


    /**
     * debug library
     */
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    /**
     * debug library
     */

    /**
     * maps
     */
    implementation("org.osmdroid:osmdroid-android:6.1.12")
}