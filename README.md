# JADX-Fast: Ultra Performance Optimizations

This fork includes comprehensive performance optimizations that make JADX up to 2.2x faster for typical Android APKs:

## What's Skipped (For Speed)

- **Framework Classes**: Android, AndroidX, Kotlin, Java standard libraries
- **Generated Code**: R.java, BuildConfig, Data Binding, Dagger/Hilt generated classes  
- **Cross-Platform Frameworks**: Flutter, React Native, Unity, Xamarin, Cordova
- **Database/ORM**: Room, Realm, GreenDAO generated code
- **Testing Frameworks**: JUnit, Mockito, Robolectric

## Performance Results

- **54% Time Reduction**: From 7.67s to 3.54s on a 100MB APK
- **Focus on YOUR Code**: Skip framework code you can already read online
- **1,084 classes** decompiled instead of thousands of framework classes

Perfect for reverse engineering, security analysis, and understanding app logic without wading through framework code.