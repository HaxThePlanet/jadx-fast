# JADX-Fast: Ultra Performance Optimizations

This fork includes comprehensive performance optimizations that make JADX up to 2.2x faster for typical Android APKs by intelligently skipping framework and generated code.

## Performance Results

- **54% Time Reduction**: From 7.67s to 3.54s on a 100MB APK
- **Focus on YOUR Code**: Only decompiles app-specific code, not framework libraries
- **1,084 classes** decompiled instead of thousands of framework classes

## Framework Class Skipping (Primary Optimization)

The main optimization skips framework classes early in the loading phase before any expensive processing occurs:

### What's Skipped:

**Android & Support Libraries:**
- `android/*` - Core Android framework classes
- `androidx/*` - AndroidX support libraries
- `com/android/internal/*` - Internal Android APIs
- `com/android/support/*` - Legacy support libraries
- `com/google/android/*` - Google Play Services

**Language Runtimes:**
- `java/*`, `javax/*` - Java standard library
- `kotlin/*`, `kotlinx/*` - Kotlin runtime and coroutines
- `sun/*` - Sun/Oracle internal classes
- `dalvik/*` - Dalvik VM internals

**Common Libraries:**
- `org/apache/http/*` - Apache HTTP client
- `org/xmlpull/*`, `org/xml/sax/*`, `org/w3c/dom/*` - XML parsing
- `org/json/*` - JSON processing

## Enhanced Optimizations for Generated Code

The enhanced version also skips various types of generated code:

### Generated Resource Files:
- **R.java files** - Android resource references (`*/R`, `*/R$*`)
- **BuildConfig** - Build configuration constants
- **BR files** - Data binding resource files

### Dependency Injection Generated Code:
- **Dagger/Hilt**: `*_Factory`, `*_HiltModules`, `*_HiltComponents`, `Hilt_*`, `DaggerApplicationComponent`, `*_MembersInjector`
- **Butterknife**: `*_ViewBinding`, `*_ViewBinder`, `*$ViewBinder`

### Data Binding & View Binding:
- Classes in `*/databinding/*` packages
- `*DataBinderMapperImpl`, `*DataBindingMapperImpl`
- `*BindingAdapter` classes

### Cross-Platform Framework Code:
- **Flutter**: `io/flutter/*`, `GeneratedPluginRegistrant`
- **React Native**: `com/facebook/react/*`, `com/facebook/hermes/*`, `com/reactnativecommunity/*`
- **Unity**: `com/unity3d/*`, `com/unity/*`, `org/fmod/*`
- **Xamarin**: `mono/*`, `xamarin/*`, `android/runtime/*`
- **Cordova**: `org/apache/cordova/*`, `com/ionicframework/*`
- **Cocos2D**: `org/cocos2dx/*`

### Database/ORM Generated Code:
- **Room**: `*_Impl`, `*RoomDatabase_Impl`, `*Dao_Impl`
- **Realm**: `io/realm/*`, `*RealmProxy`, `*RealmModule`
- **GreenDAO**: `*DaoMaster`, `*DaoSession`

### Other Generated Code:
- **Protocol Buffers**: `*Proto`, `*ProtoOrBuilder`, `*OuterClass$`
- **Gson**: `*TypeAdapter$`, `*TypeAdapterFactory`
- **Moshi**: `*JsonAdapter`, `*MoshiJsonAdapter`

### Testing Frameworks:
- `org/junit/*`, `org/mockito/*`, `org/hamcrest/*`
- `androidx/test/*`, `android/support/test/*`
- `org/robolectric/*`

## Code Generation Optimizations

In addition to skipping framework classes, this fork includes two targeted code generation performance improvements:

### 1. StringBuilder Pre-sizing (5-10% improvement)

**How it works:**
- Pre-allocates StringBuilder capacity based on class complexity analysis
- Calculates estimated size using:
  - Base allocation: 500 characters for class declaration/imports
  - Methods: 500 characters per method
  - Fields: 100 characters per field
  - Inner classes: 1000 characters each
  - Adds 20% buffer to prevent resizing

**Benefits:**
- Reduces memory reallocations during string building
- Minimizes garbage collection pressure
- Most effective on large classes with many methods

**Implementation:**
- Added `PreSizedCodeWriter` class that extends `SimpleCodeWriter`
- Modified `ClassGen.makeClass()` to use pre-sized StringBuilder

### 2. Skip Empty Methods Early (10-15% improvement)

**How it works:**
- Detects methods with zero instructions early in processing
- Immediately skips methods that:
  - Have 0 instruction count
  - Are not constructors
  - Are not marked as "no code" (abstract/native)

**Benefits:**
- Avoids expensive decompilation passes on empty stub methods
- Particularly effective on obfuscated APKs where obfuscators often create many empty methods
- Reduces processing time for heavily obfuscated code

**Implementation:**
- Added early check in `ClassGen.skipMethod()` before any processing
- Checks `mth.getInsnsCount() == 0` to identify empty methods

## When These Optimizations Shine

- **Large Commercial Apps**: Framework skipping removes thousands of well-documented classes
- **Heavily Obfuscated APKs**: Empty method skipping avoids processing obfuscator-generated stubs
- **Complex Business Logic**: StringBuilder optimization speeds up large class generation
- **Security Analysis**: Focus on actual app code without framework noise

## Technical Implementation

All optimizations are implemented with minimal changes to core JADX:
1. **Framework skipping**: ~170 lines in `RootNode.loadClasses()`
2. **StringBuilder optimization**: New `PreSizedCodeWriter` class + minor `ClassGen` changes
3. **Empty method skipping**: ~7 lines in `ClassGen.skipMethod()`

Total changes: Less than 250 lines of code for 2.2x performance improvement!