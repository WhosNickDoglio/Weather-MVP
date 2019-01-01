import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java-library")
  kotlin("jvm")
  kotlin("kapt")
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  implementation(Libs.kotlin_stdlib_jdk8)
  implementation(Libs.rxjava)
  implementation(Libs.rxkotlin)
  implementation(Libs.moshi)
  implementation(Libs.moshi_kotlin) //Look into reflect for debug and codegen for prod
  implementation(Libs.okhttp)
  implementation(Libs.logging_interceptor)
  implementation(Libs.retrofit)
  implementation(Libs.converter_moshi)
  implementation(Libs.adapter_rxjava2)
  implementation(Libs.retrofit_mock)
  implementation(Libs.dagger)
  implementation(Libs.timber)
  kapt(Libs.dagger_compiler)
  kapt(Libs.moshi_kotlin_codegen)

  testImplementation(Libs.junit)
  testImplementation(Libs.mockk)
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
}