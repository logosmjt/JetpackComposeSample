buildscript {
    repositories {
        google()
        mavenCentral()
        maven ( url = "https://oss.sonatype.org/content/repositories/snapshots" )
        maven ( url = "https://plugins.gradle.org/m2/" )
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:${LibraryVersions.gradleBuildTool}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${LibraryVersions.kotlin}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${LibraryVersions.hiltCoreVersion}")
        classpath ("com.diffplug.spotless:spotless-plugin-gradle:${LibraryVersions.spotlessGradle}")
        classpath ("org.jlleitschuh.gradle:ktlint-gradle:${LibraryVersions.ktlintVersion}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven ( url = "https://oss.sonatype.org/content/repositories/snapshots" )
    }
}
tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}