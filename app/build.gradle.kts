plugins {
    id ("com.android.application")
    kotlin("android") apply true
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id ("org.jlleitschuh.gradle.ktlint")
}

android {
    compileSdk = LibraryVersions.compileSdk
    defaultConfig {
        applicationId = "com.jingtian.study"
        minSdk = LibraryVersions.minSdk
        targetSdk = LibraryVersions.compileSdk
        versionCode = LibraryVersions.versionCode
        versionName = LibraryVersions.versionName
        testInstrumentationRunner = "com.skydoves.disneycompose.AppTestRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = LibraryVersions.composeVersion
    }

    kotlinOptions {
        jvmTarget = "11"
        useIR = true
    }

    buildFeatures {
        compose = true
    }

}

dependencies {
    // material
    implementation( "com.google.android.material:material:${LibraryVersions.materialVersion}")

    // compose
    implementation( "androidx.compose.ui:ui:${LibraryVersions.composeVersion}")
    implementation( "androidx.activity:activity-compose:${LibraryVersions.activityVersion}")
    implementation( "androidx.compose.material:material:${LibraryVersions.composeVersion}")
    implementation( "androidx.compose.material:material-icons-extended:${LibraryVersions.composeVersion}")
    implementation( "androidx.compose.foundation:foundation:${LibraryVersions.composeVersion}")
    implementation( "androidx.compose.foundation:foundation-layout:${LibraryVersions.composeVersion}")
    implementation( "androidx.compose.animation:animation:${LibraryVersions.composeVersion}")
    implementation( "androidx.compose.runtime:runtime:${LibraryVersions.composeVersion}")
    implementation( "androidx.compose.runtime:runtime-livedata:${LibraryVersions.composeVersion}")
    implementation( "androidx.navigation:navigation-compose:${LibraryVersions.composeNavVersion}")
    implementation( "androidx.compose.ui:ui-tooling:${LibraryVersions.composeVersion}")
    implementation( "androidx.constraintlayout:constraintlayout-compose:${LibraryVersions.constraintVersion}")

    // accompanist
    implementation( "com.google.accompanist:accompanist-insets:${LibraryVersions.accompanistVersion}")
    implementation( "com.google.accompanist:accompanist-swiperefresh:${LibraryVersions.accompanistVersion}")
    implementation( "com.google.accompanist:accompanist-pager:${LibraryVersions.accompanistVersion}")
    implementation( "com.google.accompanist:accompanist-pager-indicators:${LibraryVersions.accompanistVersion}")

    //coil
    implementation(LibraryVersions.coil)
    implementation( LibraryVersions.coilCompose)
    implementation( LibraryVersions.coilGif)

    // architecture components
    implementation( "androidx.fragment:fragment-ktx:${LibraryVersions.fragmentVersion}")
    implementation( "androidx.lifecycle:lifecycle-extensions:${LibraryVersions.lifecycleVersion}")
    implementation( "androidx.lifecycle:lifecycle-runtime-ktx:${LibraryVersions.lifecycleVersion}")
    implementation( "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersions.lifecycleVersion}")
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersions.lifecycleVersion}")
    implementation( "androidx.room:room-runtime:2.6.1")
    implementation( "androidx.room:room-ktx:2.3.0")
    kapt ("androidx.room:room-compiler:2.3.0")
    testImplementation( "androidx.arch.core:core-testing:${LibraryVersions.archCompomentVersion}")


    // hilt
    implementation( "com.google.dagger:hilt-android:${LibraryVersions.hiltCoreVersion}")
    implementation( "androidx.hilt:hilt-navigation-compose:${LibraryVersions.hiltComposeNavigation}")
    kapt ("com.google.dagger:hilt-compiler:${LibraryVersions.hiltCoreVersion}")
    kapt ("androidx.hilt:hilt-compiler:${LibraryVersions.hiltVersion}")
    androidTestImplementation( "com.google.dagger:hilt-android-testing:${LibraryVersions.hiltCoreVersion}")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:${LibraryVersions.hiltCoreVersion}")

    // network
    implementation( "com.squareup.okhttp3:logging-interceptor:${LibraryVersions.okhttpVersion}")
    implementation( "com.squareup.retrofit2:converter-gson:${LibraryVersions.retrofitVersion}")
    testImplementation( "com.squareup.okhttp3:mockwebserver:${LibraryVersions.okhttpVersion}")

    // coroutines
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersions.coroutinesVersion}")
    testImplementation( "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersions.coroutinesVersion}")
    testImplementation( "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibraryVersions.coroutinesVersion}")

    // unit test
    testImplementation( "junit:junit:${LibraryVersions.junitVersion}")
    testImplementation( "androidx.test:core:${LibraryVersions.androidxTest}")
    testImplementation( "io.mockk:mockk::${LibraryVersions.mockkVersion}")
    testImplementation( "app.cash.turbine:turbine:${LibraryVersions.turbineVersion}")
    testImplementation( "org.robolectric:robolectric:${LibraryVersions.robolectricVersion}")
    androidTestImplementation( "com.google.truth:truth:${LibraryVersions.truthVersion}")
    androidTestImplementation( "androidx.test.ext:junit:${LibraryVersions.androidxTestJunit}")
    androidTestImplementation( "com.android.support.test:runner:${LibraryVersions.androidTestRunner}")
    androidTestImplementation( "androidx.compose.ui:ui-test-junit4:${LibraryVersions.composeVersion}")
}

ktlint {
    android.set(true)
    outputColorName.set("RED")
}