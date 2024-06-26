sealed interface AndroidModule : Module {

    enum class Base(override val path: String) : AndroidModule {
        App(":android:app"),
        Core(":android:core"),
        Navigation(":android:navigation"),
    }

    enum class Feature(override val path: String) : AndroidModule {
        Sample(":android:features:sample"),
        Tutorial(":android:features:tutorial"),
        Home(":android:features:home"),
        WorkDetails(":android:features:workDetails"),
        Splash(":android:features:splash"),
    }
}
