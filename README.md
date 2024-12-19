# Story Component Clone

A custom story component library for Android using Jetpack Compose.

## Installation

### Step 1: Add the JitPack repository

Add it in your root `settings.gradle` or `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```
Step 2: Add the dependency
Add this in your app's build.gradle or build.gradle.kts:

```kotlin
dependencies {
    implementation("com.github.alpermelkeli:StoryComponentClone:1.0.1")
}
```
Replace Tag with the latest version (e.g., 1.0.1)

Usage

Story Data Class
```kotlin
data class Story(
    val profilePhoto: String,    // URL of the user's profile photo
    val username: String,        // Username of the story owner
    val image: String           // URL of the story image
)
```
Stories Composable
```kotlin
Stories(
    onReturnBack = { 
        // Handle back navigation
    },
    stories = listOf(
        Pair(
            "User1",
            listOf(
                Story(
                    profilePhoto = "https://example.com/profile1.jpg",
                    username = "User1",
                    image = "https://example.com/story1.jpg"
                ),
                // More stories for User1...
            )
        ),
        // More users with their stories...
    )
)
```
Example Implementation
```kotlin
@Composable
fun StoryScreen() {
    val storiesList = listOf(
        Pair(
            "John Doe",
            listOf(
                Story(
                    profilePhoto = "https://example.com/john-profile.jpg",
                    username = "John Doe",
                    image = "https://example.com/john-story1.jpg"
                ),
                Story(
                    profilePhoto = "https://example.com/john-profile.jpg",
                    username = "John Doe",
                    image = "https://example.com/john-story2.jpg"
                )
            )
        ),
        // Add more users and their stories
    )

    Stories(
        onReturnBack = {
            // Navigate back
        },
        stories = storiesList
    )
}
```

Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

![test_video](https://github.com/user-attachments/assets/e6f5754c-810f-4489-8262-086b5e5376f8)
