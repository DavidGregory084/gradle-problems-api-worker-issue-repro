plugins { id("com.gradle.develocity") version ("3.18.2") }

rootProject.name = "gradle-problems-sample"

includeBuild("sample-ide")
includeBuild("sample-project")
includeBuild("reporters/standard-plugin")
includeBuild("reporters/script-plugin")
includeBuild("reporters/model-builder-plugin")
includeBuild("reporters/worker-api-plugin")

val isCI = !System.getenv("CI").isNullOrEmpty()

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/terms-of-service"
        termsOfUseAgree = "yes"
        uploadInBackground = !isCI
        publishing.onlyIf { isCI }
    }
}