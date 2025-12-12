//! Gradle project export functionality
//!
//! Exports decompiled sources as a Gradle project that can be imported into
//! Android Studio or IntelliJ IDEA.
//!
//! Supports three project types:
//! - Android Application (from APK)
//! - Android Library (from AAR)
//! - Simple Java (fallback)

use std::fs;
use std::path::Path;

use anyhow::{Context, Result};

use crate::args::GradleType;

// ============================================================================
// Templates matching Java JADX output
// ============================================================================

/// Root build.gradle for Android projects
const ANDROID_ROOT_BUILD_GRADLE: &str = r#"buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:8.10.1'
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
"#;

/// settings.gradle for Android projects
const ANDROID_SETTINGS_GRADLE: &str = r#"rootProject.name = '{{projectName}}'

include '{{mainModuleName}}'
"#;

/// app/build.gradle for Android Application
const ANDROID_APP_BUILD_GRADLE: &str = r#"plugins {
    id 'com.android.application'
}

android {
    namespace '{{namespace}}'
    compileSdkVersion {{compileSdkVersion}}

    defaultConfig {
        applicationId '{{applicationId}}'
        minSdkVersion {{minSdkVersion}}
        targetSdkVersion {{targetSdkVersion}}
        versionCode {{versionCode}}
        versionName '{{versionName}}'

        testInstrumentationRunner 'androidx.test.runner.AndroidJUnitRunner'
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    lint {
        abortOnError false
    }

    buildFeatures {
        buildConfig false
    }
}

dependencies {
    // TODO: add dependencies
}
"#;

/// lib/build.gradle for Android Library
const ANDROID_LIB_BUILD_GRADLE: &str = r#"plugins {
    id 'com.android.library'
}

android {
    namespace '{{namespace}}'
    compileSdkVersion {{compileSdkVersion}}

    defaultConfig {
        minSdkVersion {{minSdkVersion}}
    }

    buildTypes {
        release {
            minifyEnabled false
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    lint {
        abortOnError false
    }

    buildFeatures {
        buildConfig false
    }
}

dependencies {
    // TODO: add dependencies
}
"#;

/// build.gradle.kts for Simple Java projects
const JAVA_BUILD_GRADLE_KTS: &str = r#"plugins {
    java
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // TODO: add dependencies
}
"#;

/// settings.gradle.kts for Simple Java projects
const JAVA_SETTINGS_GRADLE_KTS: &str = r#"rootProject.name = "{{projectName}}"

include("app")
"#;

// ============================================================================
// Metadata extracted from AndroidManifest.xml
// ============================================================================

/// Metadata extracted from AndroidManifest.xml for Gradle export
#[derive(Debug, Clone)]
pub struct AndroidManifestInfo {
    pub package: String,
    pub min_sdk: u32,
    pub target_sdk: u32,
    pub version_code: u32,
    pub version_name: String,
}

impl Default for AndroidManifestInfo {
    fn default() -> Self {
        Self {
            package: "com.example.app".to_string(),
            min_sdk: 21,
            target_sdk: 34,
            version_code: 1,
            version_name: "1.0".to_string(),
        }
    }
}

/// Parse AndroidManifest.xml to extract metadata
///
/// Looks for the manifest file in the resources directory and extracts
/// package name, SDK versions, and version info.
pub fn parse_android_manifest(res_dir: &Path) -> AndroidManifestInfo {
    let manifest_path = res_dir.join("AndroidManifest.xml");

    if !manifest_path.exists() {
        tracing::debug!("AndroidManifest.xml not found, using defaults");
        return AndroidManifestInfo::default();
    }

    let content = match fs::read_to_string(&manifest_path) {
        Ok(c) => c,
        Err(e) => {
            tracing::warn!("Failed to read AndroidManifest.xml: {}", e);
            return AndroidManifestInfo::default();
        }
    };

    let mut info = AndroidManifestInfo::default();

    // Extract package name: package="com.example.app"
    if let Some(pkg) = extract_xml_attr(&content, "package") {
        info.package = pkg;
    }

    // Extract android:versionCode
    if let Some(code) = extract_xml_attr(&content, "android:versionCode") {
        info.version_code = code.parse().unwrap_or(1);
    }

    // Extract android:versionName
    if let Some(name) = extract_xml_attr(&content, "android:versionName") {
        info.version_name = name;
    }

    // Extract minSdkVersion from <uses-sdk android:minSdkVersion="21"/>
    if let Some(min) = extract_xml_attr(&content, "android:minSdkVersion") {
        info.min_sdk = min.parse().unwrap_or(21);
    }

    // Extract targetSdkVersion
    if let Some(target) = extract_xml_attr(&content, "android:targetSdkVersion") {
        info.target_sdk = target.parse().unwrap_or(34);
    }

    tracing::info!(
        "Manifest: package={}, minSdk={}, targetSdk={}, versionCode={}, versionName={}",
        info.package,
        info.min_sdk,
        info.target_sdk,
        info.version_code,
        info.version_name
    );

    info
}

/// Extract an XML attribute value using simple string parsing
fn extract_xml_attr(content: &str, attr: &str) -> Option<String> {
    let pattern = format!("{}=\"", attr);
    let start = content.find(&pattern)? + pattern.len();
    let end = content[start..].find('"')? + start;
    Some(content[start..end].to_string())
}

// ============================================================================
// Gradle Export Implementation
// ============================================================================

/// Detected project type for Gradle export
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum DetectedGradleType {
    AndroidApp,
    AndroidLibrary,
    SimpleJava,
}

/// Detect the appropriate Gradle project type based on available files
pub fn detect_gradle_type(res_dir: &Path, has_arsc: bool, has_classes_jar: bool) -> DetectedGradleType {
    let has_manifest = res_dir.join("AndroidManifest.xml").exists();

    if has_manifest && has_arsc {
        DetectedGradleType::AndroidApp
    } else if has_manifest && has_classes_jar {
        DetectedGradleType::AndroidLibrary
    } else {
        DetectedGradleType::SimpleJava
    }
}

/// Export as a Gradle project
///
/// This restructures the output directory to match Android Studio's expected layout:
/// - `app/src/main/java/` for sources
/// - `app/src/main/res/` for resources
/// - Root build.gradle, settings.gradle
pub fn export_gradle_project(
    output_dir: &Path,
    src_dir: &Path,
    res_dir: &Path,
    gradle_type: Option<GradleType>,
    project_name: &str,
) -> Result<()> {
    tracing::info!("Exporting as Gradle project...");

    // Check what files we have to determine project type
    let has_arsc = res_dir.join("res").join("values").exists();
    let has_classes_jar = false; // AAR detection would set this

    // Determine export type
    let detected = detect_gradle_type(res_dir, has_arsc, has_classes_jar);
    let export_type = match gradle_type {
        Some(GradleType::Auto) | None => detected,
        Some(GradleType::AndroidApp) => DetectedGradleType::AndroidApp,
        Some(GradleType::AndroidLibrary) => DetectedGradleType::AndroidLibrary,
        Some(GradleType::SimpleJava) => DetectedGradleType::SimpleJava,
    };

    tracing::info!("Export type: {:?}", export_type);

    match export_type {
        DetectedGradleType::AndroidApp => {
            export_android_project(output_dir, src_dir, res_dir, project_name, false)?;
        }
        DetectedGradleType::AndroidLibrary => {
            export_android_project(output_dir, src_dir, res_dir, project_name, true)?;
        }
        DetectedGradleType::SimpleJava => {
            export_java_project(output_dir, src_dir, project_name)?;
        }
    }

    tracing::info!("Gradle project exported to: {}", output_dir.display());
    Ok(())
}

/// Export as Android Gradle project (app or library)
fn export_android_project(
    output_dir: &Path,
    src_dir: &Path,
    res_dir: &Path,
    project_name: &str,
    is_library: bool,
) -> Result<()> {
    let module_name = if is_library { "lib" } else { "app" };

    // Parse manifest for metadata
    let manifest_info = parse_android_manifest(res_dir);

    // Create Gradle project structure
    let module_dir = output_dir.join(module_name);
    let main_dir = module_dir.join("src").join("main");
    let java_dir = main_dir.join("java");
    let res_out_dir = main_dir.join("res");

    fs::create_dir_all(&java_dir)
        .with_context(|| format!("Failed to create {}", java_dir.display()))?;
    fs::create_dir_all(&res_out_dir)
        .with_context(|| format!("Failed to create {}", res_out_dir.display()))?;

    // Generate root build.gradle
    let root_build_gradle = output_dir.join("build.gradle");
    fs::write(&root_build_gradle, ANDROID_ROOT_BUILD_GRADLE)
        .with_context(|| "Failed to write root build.gradle")?;

    // Generate settings.gradle
    let settings_content = ANDROID_SETTINGS_GRADLE
        .replace("{{projectName}}", project_name)
        .replace("{{mainModuleName}}", module_name);
    let settings_gradle = output_dir.join("settings.gradle");
    fs::write(&settings_gradle, settings_content)
        .with_context(|| "Failed to write settings.gradle")?;

    // Generate module build.gradle
    let compile_sdk = std::cmp::max(manifest_info.target_sdk, 34);
    let module_build_content = if is_library {
        ANDROID_LIB_BUILD_GRADLE
            .replace("{{namespace}}", &manifest_info.package)
            .replace("{{compileSdkVersion}}", &compile_sdk.to_string())
            .replace("{{minSdkVersion}}", &manifest_info.min_sdk.to_string())
    } else {
        ANDROID_APP_BUILD_GRADLE
            .replace("{{namespace}}", &manifest_info.package)
            .replace("{{compileSdkVersion}}", &compile_sdk.to_string())
            .replace("{{applicationId}}", &manifest_info.package)
            .replace("{{minSdkVersion}}", &manifest_info.min_sdk.to_string())
            .replace("{{targetSdkVersion}}", &manifest_info.target_sdk.to_string())
            .replace("{{versionCode}}", &manifest_info.version_code.to_string())
            .replace("{{versionName}}", &manifest_info.version_name)
    };
    let module_build_gradle = module_dir.join("build.gradle");
    fs::write(&module_build_gradle, module_build_content)
        .with_context(|| "Failed to write module build.gradle")?;

    // Generate proguard-rules.pro (empty placeholder)
    let proguard_rules = module_dir.join("proguard-rules.pro");
    fs::write(&proguard_rules, "# Add project specific ProGuard rules here.\n")
        .with_context(|| "Failed to write proguard-rules.pro")?;

    // Move sources from src_dir to app/src/main/java/
    move_directory_contents(src_dir, &java_dir)
        .with_context(|| "Failed to move sources")?;

    // Move resources from res_dir to app/src/main/
    // AndroidManifest.xml goes directly in main/
    let manifest_src = res_dir.join("AndroidManifest.xml");
    if manifest_src.exists() {
        let manifest_dst = main_dir.join("AndroidManifest.xml");
        fs::copy(&manifest_src, &manifest_dst)
            .with_context(|| "Failed to copy AndroidManifest.xml")?;
    }

    // Move res/ subdirectory
    let res_src = res_dir.join("res");
    if res_src.exists() {
        move_directory_contents(&res_src, &res_out_dir)
            .with_context(|| "Failed to move resources")?;
    }

    // Copy other resource files (assets, etc.)
    let assets_src = res_dir.join("assets");
    if assets_src.exists() {
        let assets_dst = main_dir.join("assets");
        move_directory_contents(&assets_src, &assets_dst)
            .with_context(|| "Failed to move assets")?;
    }

    // Clean up old directories
    if src_dir.exists() && src_dir != java_dir.as_path() {
        let _ = fs::remove_dir_all(src_dir);
    }
    if res_dir.exists() && res_dir != res_out_dir.parent().unwrap_or(res_dir) {
        let _ = fs::remove_dir_all(res_dir);
    }

    tracing::info!(
        "Generated Android {} project: {}",
        if is_library { "library" } else { "app" },
        output_dir.display()
    );

    Ok(())
}

/// Export as Simple Java Gradle project
fn export_java_project(
    output_dir: &Path,
    src_dir: &Path,
    project_name: &str,
) -> Result<()> {
    // Create Gradle project structure
    let app_dir = output_dir.join("app");
    let java_dir = app_dir.join("src").join("main").join("java");

    fs::create_dir_all(&java_dir)
        .with_context(|| format!("Failed to create {}", java_dir.display()))?;

    // Generate build.gradle.kts
    let root_build_gradle = output_dir.join("build.gradle.kts");
    fs::write(&root_build_gradle, JAVA_BUILD_GRADLE_KTS)
        .with_context(|| "Failed to write build.gradle.kts")?;

    // Generate settings.gradle.kts
    let settings_content = JAVA_SETTINGS_GRADLE_KTS
        .replace("{{projectName}}", project_name);
    let settings_gradle = output_dir.join("settings.gradle.kts");
    fs::write(&settings_gradle, settings_content)
        .with_context(|| "Failed to write settings.gradle.kts")?;

    // Move sources
    move_directory_contents(src_dir, &java_dir)
        .with_context(|| "Failed to move sources")?;

    // Clean up old directory
    if src_dir.exists() && src_dir != java_dir.as_path() {
        let _ = fs::remove_dir_all(src_dir);
    }

    tracing::info!(
        "Generated Java project: {}",
        output_dir.display()
    );

    Ok(())
}

/// Move contents of one directory to another (preserving structure)
fn move_directory_contents(src: &Path, dst: &Path) -> Result<()> {
    if !src.exists() {
        return Ok(());
    }

    fs::create_dir_all(dst)?;

    for entry in fs::read_dir(src)? {
        let entry = entry?;
        let src_path = entry.path();
        let file_name = entry.file_name();
        let dst_path = dst.join(&file_name);

        if src_path.is_dir() {
            move_directory_contents(&src_path, &dst_path)?;
        } else {
            // Copy file (we copy instead of rename to handle cross-filesystem moves)
            fs::copy(&src_path, &dst_path)?;
        }
    }

    Ok(())
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_extract_xml_attr() {
        let xml = r#"<manifest package="com.example.app" android:versionCode="42">"#;

        assert_eq!(extract_xml_attr(xml, "package"), Some("com.example.app".to_string()));
        assert_eq!(extract_xml_attr(xml, "android:versionCode"), Some("42".to_string()));
        assert_eq!(extract_xml_attr(xml, "nonexistent"), None);
    }

    #[test]
    fn test_template_substitution() {
        let template = "name = '{{projectName}}'";
        let result = template.replace("{{projectName}}", "MyApp");
        assert_eq!(result, "name = 'MyApp'");
    }

    #[test]
    fn test_detect_gradle_type() {
        use std::fs;
        use tempfile::tempdir;

        let temp = tempdir().unwrap();
        let res_dir = temp.path();

        // No manifest = SimpleJava
        assert_eq!(
            detect_gradle_type(res_dir, false, false),
            DetectedGradleType::SimpleJava
        );

        // Create AndroidManifest.xml
        fs::write(res_dir.join("AndroidManifest.xml"), "<manifest/>").unwrap();

        // Manifest + ARSC = AndroidApp
        assert_eq!(
            detect_gradle_type(res_dir, true, false),
            DetectedGradleType::AndroidApp
        );

        // Manifest + classes.jar = AndroidLibrary
        assert_eq!(
            detect_gradle_type(res_dir, false, true),
            DetectedGradleType::AndroidLibrary
        );
    }
}
