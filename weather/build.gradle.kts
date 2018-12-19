import java.util.Properties
import java.io.FileInputStream

plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("android.extensions")
  kotlin("kapt")
}

android {
  compileSdkVersion(App.compilesdk)
  defaultConfig {
    applicationId = "com.nicholasdoglio.weather"
    minSdkVersion(App.minsdk)
    targetSdkVersion(App.targetsdk)
    versionCode = App.verisonCode
    versionName = App.versionName
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  buildTypes {
    val apiKeysFile = rootProject.file("api.properties")
    val apiKeys = Properties()
    if (apiKeysFile.exists()) apiKeys.load(FileInputStream(apiKeysFile))

    all {
      manifestPlaceholders["PLAY_KEY" to apiKeys.getProperty("places_key", "null")]
      buildConfigField("String", "WEATHER_API_KEY", apiKeys.getProperty("weather_key", "null"))
    }

    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}

androidExtensions {
  isExperimental = true
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  implementation(Libs.kotlin_stdlib_jdk8)

  //Android
  implementation(Libs.appcompat)
  implementation(Libs.constraintlayout)
  implementation(Libs.cardview)
  implementation(Libs.recyclerview)
  implementation(Libs.material)
  implementation(Libs.core_ktx)
  implementation(Libs.fragment_ktx)

  //Epoxy
  implementation(Libs.epoxy)
  kapt(Libs.epoxy_processor)

  implementation(Libs.threetenabp)

  implementation(Libs.play_services_places)

  //Rx
  implementation(Libs.rxjava)
  implementation(Libs.rxkotlin)
  implementation(Libs.rxandroid)

  //Dagger
  implementation(Libs.dagger)
  implementation(Libs.dagger_android)
  implementation(Libs.dagger_android_support)
  kapt(Libs.dagger_android_processor)
  kapt(Libs.dagger_compiler)

  //Debugging
  implementation(Libs.timber)
  releaseImplementation(Libs.leakcanary_android_no_op)
  debugImplementation(Libs.leakcanary_android)
  debugImplementation(Libs.leakcanary_support_fragment)

  //Testing
  testImplementation(Libs.junit)
  testImplementation(Libs.kotlin_test_junit)
  testImplementation(Libs.mockk)
  androidTestImplementation(Libs.androidx_test_rules)
  androidTestImplementation(Libs.androidx_test_runner)
  androidTestImplementation(Libs.espresso_core)
}

//// Ensure the no-op dependency is always used in JVM tests.
//configurations.all { config ->
//  if (config.name.contains("UnitTest")) {
//    config.resolutionStrategy.eachDependency { details ->
//      if (details.requested.group == "com.squareup.leakcanary" &&
//          details.requested.name ==
//          "leakcanary-android") {
//        details.useTarget(group: details.requested.group, name: "leakcanary-android-no-op",
//            version: details.requested.version)
//      }
//    }
//  }
//}
