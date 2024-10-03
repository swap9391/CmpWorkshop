## Compose Multiplatform is a declarative framework for sharing UIs across multiple platforms with Kotlin. It is based on Jetpack Compose and developed by JetBrains and open-source contributors.

You can choose the platforms across which to share your UIs using Compose Multiplatform:

iOS (Beta)
Android
Desktop (Windows, MacOS, Linux)
Web (Alpha)

For example, you can share UIs between iOS and Android or Windows and MacOS.

<IMG  src="https://github.com/JetBrains/compose-multiplatform/raw/master/artwork/readme/apps.png"  alt="Shared UIs of the iOS, Android, desktop, and web apps"/>


## iOS

`iOS support is in Beta. It is feature complete, and migration issues should be minimal. You may still encounter bugs, performance and developer experience issues, but not as much as in the Alpha stage.`

Compose Multiplatform shares most of its API with Jetpack Compose, the Android UI framework developed by Google. You can use the same APIs to build user interfaces for both Android and iOS.

## Android

When Android is one of your targets, you can get the same experience for Android as if you were developing an Android app using Jetpack Compose.

## Desktop
Compose Multiplatform targets the JVM and supports high-performance hardware-accelerated UI rendering on all major desktop platforms – macOS, Windows, and Linux.

## Web
`Web support is in Alpha. It may change incompatibly and require manual migration in the future.`

You can experiment with sharing your mobile or desktop UIs with the web. Compose for Web is based on Kotlin, the newest target for Kotlin Multiplatform projects. It allows Kotlin developers to run their code in the browser with all the benefits that WebAssembly has to offer, such as good and predictable performance for your applications. 

## Libraries

**Compose HTML**

Compose HTML is a library targeting Kotlin/JS that provides Composable building blocks for creating web user interfaces with HTML and CSS.

### Environment Setup


While KMP and CMP were created and managed by JetBrains, Google announced at Google I/O 2024 that it will officially support the platform, ensuring the tools get first-class attention going forward.

Prerequisites:

1. Mac System
1. Latest JDK installed
1. Android Studio(Latest Version)
1. Xcode
1. Cocopods

To make sure you have all the prerequisite 

1. Open Terminal 
2. Execute Command - `kdoctor`

**Result**

![image.png](/.attachments/image-97b2817e-5376-4916-a078-2747decc3d56.png)

**Android Studio prerequisite:**  

1. Open Android Studio 
1. Install following plugins

![Screenshot 2024-10-02 at 12.33.53 PM.png](/.attachments/Screenshot%202024-10-02%20at%2012.33.53 PM-b6562534-522e-47fa-b4f1-92bb3dec882f.png)
![Screenshot 2024-10-02 at 12.32.15 PM.png](/.attachments/Screenshot%202024-10-02%20at%2012.32.15 PM-4b544b68-1f04-4d5f-9824-7c829e3865e5.png)

**iOS Simulator Setup in Android Studio**

Following is configuration to setup iOS device simulator setup 

![Screenshot 2024-10-02 at 12.39.06 PM.png](/.attachments/Screenshot%202024-10-02%20at%2012.39.06 PM-e3fece48-e7cc-4b8d-855c-98078d98a40c.png)


## Project Setup

While Android Studio has a new project wizard, it uses native UI code at the moment, not Compose for all. Instead, go to [https://kmp.jetbrains.com/](). The project in this post includes all the front-end options, but you’re welcome to select the options you would like for yours and continue following along.


![Screenshot 2024-10-02 at 12.45.50 PM.png](/.attachments/Screenshot%202024-10-02%20at%2012.45.50 PM-d8f40392-16a6-4718-ae67-15ba5f458c21.png)


Download the project and open it into Android Studio. 

Project Structure in Android Studio. 

![Screenshot 2024-10-02 at 12.50.49 PM.png](/.attachments/Screenshot%202024-10-02%20at%2012.50.49 PM-c8d45ec7-e089-4139-9be8-e203c5d8a3e2.png)

**Visual Guide of folder structure** 

<IMG  src="https://miro.medium.com/v2/resize:fit:15572/1*_RKGMEkunY6iGd-7Ni0fXg.png"/>



