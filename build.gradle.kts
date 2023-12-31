plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.1.3").apply(false)
    id("com.android.library").version("8.1.3").apply(false)
    id("com.google.devtools.ksp").version("1.9.20-1.0.14").apply(false)

    kotlin("android").version("1.9.20").apply(false)
    kotlin("multiplatform").version("1.9.20").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
