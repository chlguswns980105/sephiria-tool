plugins {
    kotlin("jvm") version "1.9.23"
    id("org.jetbrains.compose") version "1.7.3"
}

group = "com.hyeonjunchoi.sephiria"
version = "1.0"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
}

kotlin {
    jvmToolchain(17)
}

compose.desktop {
    application {
        mainClass = "com.hyeonjunchoi.sephiria.MainKt"
    }
}
