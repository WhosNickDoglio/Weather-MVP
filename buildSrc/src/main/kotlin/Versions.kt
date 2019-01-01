/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val appcompat: String = "1.0.2"

    const val cardview: String = "1.0.0"

    const val constraintlayout: String = "1.1.3"

    const val core_ktx: String = "1.0.1"

    const val fragment_ktx: String = "1.0.0"

    const val recyclerview: String = "1.0.0"

    const val espresso_core: String = "3.1.1"

    const val androidx_test: String = "1.1.1"

    const val com_airbnb_android: String = "3.1.0"

    const val com_android_tools_build_gradle: String = "3.4.0-alpha09"

    const val lint_gradle: String = "26.4.0-alpha09"

    const val play_services_places: String = "16.0.0"

    const val material: String = "1.0.0"

    const val com_google_dagger: String = "2.20"

    const val threetenabp: String = "1.1.1"

    const val timber: String = "4.7.1"

    const val com_squareup_leakcanary: String = "1.6.2"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2"

    const val mockk: String = "1.8.13.kotlin13" // available: "1.8.13"

    const val rxandroid: String = "2.1.0"

    const val rxjava: String = "2.2.5"

    const val rxkotlin: String = "2.3.0"

    const val junit: String = "4.12"

    const val org_gradle_kotlin_kotlin_dsl_gradle_plugin: String = "1.1.0"

    const val org_jetbrains_kotlin: String = "1.3.11"

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.1-rc-3"

        const val currentVersion: String = "5.0"

        const val nightlyVersion: String = "5.2-20190101000044+0000"

        const val releaseCandidate: String = "5.1-rc-3"
    }
}
