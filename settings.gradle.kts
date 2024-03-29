pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
        resolutionStrategy{
            eachPlugin{
                if( requested.id.id == "dagger.hilt.android.plugin") {
                    useModule("com.google.dagger:hilt-android-gradle-plugin:2.40")
                }
                if( requested.id.id == "com.google.gms.google-services") {
                    useModule("com.google.gms:google-services:4.3.8")
                }
            }
        }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AppMovile"
include(":app")
