group = "com.example.libraries"
plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.services.toastcheck"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

// Define publishing outside the android block
publishing {
    publications {
        create<MavenPublication>("release") {
            from(components.findByName("release"))

            groupId = project.group.toString() // Replaced with dynamic reference
            artifactId = "ToastCheck"
            version = "1.0.0"
        }
    }
    repositories {
        mavenLocal()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}
