sealed interface KmpModule : Module {
    enum class Base(override val path: String) : KmpModule {
        Application(":kmp:application"),
        Domain(":kmp:domain"),
        Data(":kmp:data"),
        Remote(":kmp:remote"),
        Local(":kmp:local"),
        Utils(":kmp:utils"),
    }

    enum class Feature(override val path: String) : KmpModule {
        Sample(":kmp:presentation:sample-shared"),
        Tutorial(":kmp:presentation:tutorial-shared"),
        Home(":kmp:presentation:home-shared"),
        Splash(":kmp:presentation:splash-shared"),
        WorkDetails(":kmp:presentation:work-details-shared")
    }
}
