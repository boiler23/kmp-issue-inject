plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":feature-api"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.google.dagger.runtime)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.google.dagger.runtime)
            }
        }
    }
}

android {
    namespace = "com.iliabogdanovich.kmpissue"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}

dependencies {
    add("kspJvm", libs.google.dagger.compiler)
    add("kspAndroid", libs.google.dagger.compiler)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}