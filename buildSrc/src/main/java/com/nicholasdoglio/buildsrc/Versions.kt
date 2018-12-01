package com.nicholasdoglio.buildsrc

/**
 * Find which updates are available by running
 *     `$ ./gradlew syncLibs`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val android_arch_persistence_room: String = "1.1.1"

    const val com_airbnb_android: String = "2.19.0" //available: "3.0.0" 

    const val constraint_layout: String = "1.1.3"

    const val com_android_support_test_espresso: String = "3.0.2"

    const val com_android_support_test: String = "1.0.2"

    const val com_android_support_appcompat_v7: String = "28.0.0"

    const val cardview_v7: String = "28.0.0"

    const val design: String = "28.0.0"

    const val recyclerview_v7: String = "28.0.0"

    const val support_v4: String = "28.0.0"

    const val com_android_tools_build_gradle: String =
        "3.3.0-rc01" // exceed the version found: 3.2.1

    const val lint_gradle: String = "26.3.0-rc01" // exceed the version found: 26.2.1

    const val play_services_places: String = "15.0.1" //available: "16.0.0" 

    const val com_google_dagger: String = "2.19"

    const val threetenabp: String = "1.1.0" //available: "1.1.1" 

    const val timber: String = "4.7.1"

    const val com_squareup_leakcanary: String = "1.6.2"

    const val com_squareup_moshi: String = "1.8.0"

    const val com_squareup_okhttp3: String = "3.12.0"

    const val com_squareup_retrofit2: String = "2.5.0"

    const val mockk: String = "1.8.13.kotlin13" //available: "1.8.13" 

    const val rxandroid: String = "2.1.0"

    const val rxjava: String = "2.2.4"

    const val rxkotlin: String = "2.3.0"

    const val jmfayard_github_io_gradle_kotlin_dsl_libs_gradle_plugin: String = "0.2.6"

    const val junit: String = "4.12"

    const val org_gradle_kotlin_kotlin_dsl_gradle_plugin: String = "1.0.4"

    const val org_jetbrains_kotlin: String = "1.3.10"

    const val junit_jupiter_api: String = "5.1.0" //available: "5.3.2" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.0"

        const val currentVersion: String = "5.0"

        const val nightlyVersion: String = "5.1-20181201000046+0000"

        const val releaseCandidate: String = ""
    }
}
