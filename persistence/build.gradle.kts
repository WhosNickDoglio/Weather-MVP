//apply(rootProject.file("base-android.gradle"))
plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}
android {
  compileSdkVersion(App.compilesdk)
  defaultConfig {
    minSdkVersion(App.minsdk)
    targetSdkVersion(App.targetsdk)
    versionCode = App.verisonCode
    versionName = App.versionName
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  buildTypes {
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
dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  implementation(Libs.kotlin_stdlib_jdk8)
  implementation(Libs.dagger)
  implementation(Libs.timber)
  kapt(Libs.dagger_compiler)

  implementation(Libs.room_runtime)
  implementation(Libs.room_rxjava2)
  kapt(Libs.room_compiler)

  testImplementation(Libs.room_testing)
  testImplementation(Libs.junit)
  testImplementation(Libs.mockk)
}
