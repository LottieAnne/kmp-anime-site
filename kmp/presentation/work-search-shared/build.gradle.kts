plugins {
    kmpAndroid()
    kmpIos()
    id(libs.plugins.parcelize)
}

android {
    namespace = "kmp.workSearch"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                modules(
                    KmpModule.Base.Domain,
                    KmpModule.Base.Utils,
                )
                implementations(
                    libs.kotlinx.coroutinesCore,
                    libs.macaron.core,
                    libs.macaron.statemachine,
                    libs.macaron.logging,
                    libs.macaron.messaging,
                )
            }
        }
    }
}