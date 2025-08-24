pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Listra"
include(":app")
include(":feature:ads:my_ads")
include(":core:navigation")
include(":feature:ads:post_ad")
include(":feature:ads:ad_details")
include(":feature:authentication:auth")
include(":feature:profile:profile")
include(":feature:authentication:auth_repo")
include(":feature:ads:ads_repo")
include(":feature:profile:profile_repo")
