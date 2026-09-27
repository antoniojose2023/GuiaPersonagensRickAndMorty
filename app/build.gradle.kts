plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
}

android {
    namespace = "br.com.devmobile.guiapersonagensrickandmorty"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "br.com.devmobile.guiapersonagensrickandmorty"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }


    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    implementation("com.airbnb.android:lottie:6.4.0")

    implementation("de.hdodenhof:circleimageview:2.0.0")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //swipe refesh
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0")

    //liveData
    implementation("androidx.activity:activity-ktx:1.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.11.0")

    //glide
    implementation("com.github.bumptech.glide:glide:5.0.9")
    annotationProcessor("com.github.bumptech.glide:compiler:5.0.9")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.11.0")


    val roomVersion = "2.6.1" // Use a versão estável mais recente do Room 2.x

    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion") // Suporte para Coroutines e Flow
    ksp("androidx.room:room-compiler:$roomVersion")

}