# Badboy Test APK - Source Reference

This document provides the **original source code** for the Badboy test APK, enabling comparison between decompiler output and ground truth.

## APK Files

| APK | Path | Size | Description |
|-----|------|------|-------------|
| badboy.apk | `apks/badboy.apk` | ~24MB | Multi-arch build (arm64-v8a, armeabi-v7a, x86, x86_64) |
| badboy-x86.apk | `apks/badboy-x86.apk` | ~24MB | x86-only build for emulator testing |

## Package Structure

```
com.prototype.badboy/
├── MainActivity.kt           # Main UI with malicious pattern demos
├── MaliciousPatterns.kt      # Execution, dropper, anti-debug patterns
├── NativePayload.kt          # JNI interface for native malware functions
├── BadAccessibilityService.kt # Keylogger/screen capture via accessibility
├── BadDeviceAdmin.kt         # Device admin receiver
├── BootReceiver.kt           # Boot persistence
├── SmsReceiver.kt            # SMS interception
├── ExportedComponents.kt     # Exported activities/services/receivers/providers
└── ui/theme/                 # Compose theme files
```

---

## Source Files

### MainActivity.kt

Main activity with UI demonstrating various malicious patterns.

```kotlin
package com.prototype.badboy

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.provider.Settings
import android.telephony.SmsManager
import android.widget.Toast
import dalvik.system.DexClassLoader
import java.io.File
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.provider.CallLog
import androidx.core.content.FileProvider
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.prototype.badboy.ui.theme.BadboyTheme

class MainActivity : ComponentActivity() {
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        // Handle permission results if needed
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BadboyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        requestPermissions = { perms ->
                            requestPermissionLauncher.launch(perms)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    requestPermissions: (Array<String>) -> Unit = {}
) {
    val context = LocalContext.current
    var androidId by remember { mutableStateOf("") }
    var displayText by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // App header with version
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(androidx.compose.ui.graphics.Color(0xFF1a1a1a))
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SAFE TEST APP",
                style = androidx.compose.ui.text.TextStyle(
                    color = androidx.compose.ui.graphics.Color.Green,
                    fontSize = androidx.compose.ui.unit.TextUnit(12f, androidx.compose.ui.unit.TextUnitType.Sp),
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                ),
                modifier = Modifier
                    .background(androidx.compose.ui.graphics.Color(0xFF004D00))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "BADBOY",
                style = androidx.compose.ui.text.TextStyle(
                    color = androidx.compose.ui.graphics.Color.Red,
                    fontSize = androidx.compose.ui.unit.TextUnit(32f, androidx.compose.ui.unit.TextUnitType.Sp),
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            )
            Text(
                text = "animalistic tendencies",
                style = androidx.compose.ui.text.TextStyle(
                    color = androidx.compose.ui.graphics.Color.Gray,
                    fontSize = androidx.compose.ui.unit.TextUnit(14f, androidx.compose.ui.unit.TextUnitType.Sp),
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                ),
                modifier = Modifier.padding(top = 2.dp)
            )
            Text(
                text = "v1.0.0",
                style = androidx.compose.ui.text.TextStyle(
                    color = androidx.compose.ui.graphics.Color.White,
                    fontSize = androidx.compose.ui.unit.TextUnit(18f, androidx.compose.ui.unit.TextUnitType.Sp),
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                ),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Button(
                onClick = {
                    androidId = Settings.Secure.getString(
                        context.contentResolver,
                        Settings.Secure.ANDROID_ID
                    )
                    displayText = "Android ID: $androidId"
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Android ID")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                        val cursor: Cursor? = context.contentResolver.query(
                            Uri.parse("content://sms/inbox"),
                            arrayOf("_id", "address", "body", "date"),
                            null,
                            null,
                            "date DESC"
                        )
                        val count = cursor?.count ?: 0
                        cursor?.close()
                        displayText = "SMS Count: $count"
                    } else {
                        requestPermissions(arrayOf(Manifest.permission.READ_SMS))
                        displayText = "Requesting SMS permission..."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Read SMS")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS)
                        == PackageManager.PERMISSION_GRANTED) {
                        val cursor: Cursor? = context.contentResolver.query(
                            ContactsContract.Contacts.CONTENT_URI,
                            null,
                            null,
                            null,
                            null
                        )
                        val count = cursor?.count ?: 0
                        cursor?.close()
                        displayText = "Contacts Count: $count"
                    } else {
                        requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS))
                        displayText = "Requesting Contacts permission..."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Get Contacts")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                        try {
                            val smsManager = SmsManager.getDefault()
                            displayText = "SMS API called (not actually sending)"
                        } catch (e: Exception) {
                            displayText = "SMS API error: ${e.message}"
                        }
                    } else {
                        requestPermissions(arrayOf(Manifest.permission.SEND_SMS))
                        displayText = "Requesting SMS permission..."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Send SMS")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALENDAR)
                        == PackageManager.PERMISSION_GRANTED) {
                        val cursor: Cursor? = context.contentResolver.query(
                            Uri.parse("content://com.android.calendar/events"),
                            arrayOf("_id", "title", "dtstart"),
                            null,
                            null,
                            null
                        )
                        val count = cursor?.count ?: 0
                        cursor?.close()
                        displayText = "Calendar Events Count: $count"
                    } else {
                        requestPermissions(arrayOf(Manifest.permission.READ_CALENDAR))
                        displayText = "Requesting Calendar permission..."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Read Calendar")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    try {
                        // Check if we can install unknown apps
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            if (!context.packageManager.canRequestPackageInstalls()) {
                                val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES)
                                    .setData(Uri.parse("package:${context.packageName}"))
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                context.startActivity(intent)
                                displayText = "Dropper: Enable unknown sources first"
                                return@Button
                            }
                        }

                        // Download F-Droid APK (open source app store)
                        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                        val apkUrl = "https://f-droid.org/F-Droid.apk"
                        val request = DownloadManager.Request(Uri.parse(apkUrl))
                            .setTitle("F-Droid")
                            .setDescription("Downloading APK...")
                            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "fdroid.apk")
                            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            .setAllowedOverMetered(true)
                            .setAllowedOverRoaming(true)
                        val downloadId = downloadManager.enqueue(request)
                        displayText = "Dropper: Downloading F-Droid (ID: $downloadId)"
                    } catch (e: Exception) {
                        displayText = "Dropper error: ${e.message}"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Dropper (Download)")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    try {
                        val apkFile = File(
                            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                            "fdroid.apk"
                        )
                        if (!apkFile.exists()) {
                            displayText = "Install: APK not found. Download first."
                            return@Button
                        }

                        val apkUri = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                            FileProvider.getUriForFile(
                                context,
                                "${context.packageName}.fileprovider",
                                apkFile
                            )
                        } else {
                            Uri.fromFile(apkFile)
                        }

                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            setDataAndType(apkUri, "application/vnd.android.package-archive")
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
                        }
                        context.startActivity(intent)
                        displayText = "Install: Launching installer..."
                    } catch (e: Exception) {
                        displayText = "Install error: ${e.message}"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Install APK")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    try {
                        val dexPath = File(context.filesDir, "classes.dex").absolutePath
                        val optimizedDir = context.getDir("dex", Context.MODE_PRIVATE).absolutePath
                        val classLoader = DexClassLoader(
                            dexPath,
                            optimizedDir,
                            null,
                            context.classLoader
                        )
                        displayText = "DexClassLoader: Initialized (path: $dexPath)"
                    } catch (e: Exception) {
                        displayText = "DexClassLoader error: ${e.message}"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("DexClassLoader")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // OVERLAY ABUSE - SYSTEM_ALERT_WINDOW
            Button(
                onClick = {
                    try {
                        val canDraw = Settings.canDrawOverlays(context)
                        if (!canDraw) {
                            val intent = Intent(
                                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:${context.packageName}")
                            )
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            context.startActivity(intent)
                            displayText = "Overlay: Grant permission first!"
                        } else {
                            // Show an overlay window
                            val wm = context.getSystemService(Context.WINDOW_SERVICE) as android.view.WindowManager
                            val params = android.view.WindowManager.LayoutParams(
                                android.view.WindowManager.LayoutParams.MATCH_PARENT,
                                200,
                                android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                                android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                                android.graphics.PixelFormat.TRANSLUCENT
                            )
                            params.gravity = android.view.Gravity.TOP
                            val overlay = android.widget.TextView(context).apply {
                                text = "OVERLAY ABUSE DEMO - Tap anywhere"
                                setBackgroundColor(android.graphics.Color.parseColor("#CC000000"))
                                setTextColor(android.graphics.Color.RED)
                                textSize = 18f
                                gravity = android.view.Gravity.CENTER
                                setPadding(20, 40, 20, 40)
                                setOnClickListener { wm.removeView(this) }
                            }
                            wm.addView(overlay, params)
                            displayText = "Overlay: Showing overlay! Tap it to dismiss."
                        }
                    } catch (e: Exception) {
                        displayText = "Overlay error: ${e.message}"
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.ui.graphics.Color(0xFFFF5722)
                )
            ) {
                Text("Overlay Abuse")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ACCESSIBILITY ABUSE - open settings + show what we can do
            Button(
                onClick = {
                    try {
                        // Check if our service is enabled
                        val enabledServices = Settings.Secure.getString(
                            context.contentResolver,
                            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
                        ) ?: ""
                        val isEnabled = enabledServices.contains(context.packageName)

                        if (!isEnabled) {
                            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            context.startActivity(intent)
                            displayText = "Accessibility: Enable BadAccessibilityService!\n" +
                                "Capabilities: Keylogging, UI automation, credential theft"
                        } else {
                            displayText = "Accessibility: ENABLED!\n" +
                                "Now capturing: keystrokes, screen content, gestures\n" +
                                "Can: click buttons, fill forms, bypass prompts"
                        }
                    } catch (e: Exception) {
                        displayText = "Accessibility error: ${e.message}"
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.ui.graphics.Color(0xFFE91E63)
                )
            ) {
                Text("Accessibility Abuse")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // EXECUTION - Runtime.exec
            Button(
                onClick = {
                    try {
                        val process = Runtime.getRuntime().exec("id")
                        val output = process.inputStream.bufferedReader().readText()
                        process.waitFor()
                        displayText = "Exec: $output"
                    } catch (e: Exception) {
                        displayText = "Exec error: ${e.message}"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Execution")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Read Call Log
            Button(
                onClick = {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALL_LOG)
                        == PackageManager.PERMISSION_GRANTED) {
                        val cursor: Cursor? = context.contentResolver.query(
                            CallLog.Calls.CONTENT_URI,
                            arrayOf(CallLog.Calls._ID, CallLog.Calls.NUMBER),
                            null,
                            null,
                            null
                        )
                        val count = cursor?.count ?: 0
                        cursor?.close()
                        displayText = "Call Log Count: $count"
                    } else {
                        requestPermissions(arrayOf(Manifest.permission.READ_CALL_LOG))
                        displayText = "Requesting Call Log permission..."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Read Call Log")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // BOOT - simulate checking boot receiver
            Button(
                onClick = {
                    displayText = "Boot: RECEIVE_BOOT_COMPLETED declared in manifest"
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Boot Receiver")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // DEVICEADMIN - open device admin settings
            Button(
                onClick = {
                    try {
                        val intent = Intent().apply {
                            setClassName(
                                "com.android.settings",
                                "com.android.settings.DeviceAdminSettings"
                            )
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        }
                        context.startActivity(intent)
                        displayText = "DeviceAdmin: Settings opened"
                    } catch (e: Exception) {
                        displayText = "DeviceAdmin error: ${e.message}"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Device Admin")
            }
        }

        if (displayText.isNotEmpty()) {
            Text(
                text = displayText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BadboyTheme {
        Greeting("Android")
    }
}
```

---

### MaliciousPatterns.kt

Contains execution, dropper, anti-debug, icon hiding, and other malicious patterns.

```kotlin
package com.prototype.badboy

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.os.Debug
import dalvik.system.DexClassLoader
import dalvik.system.PathClassLoader
import java.io.File
import java.lang.reflect.Method

/**
 * This class contains patterns that trigger various threat detection indicators.
 * FOR SECURITY RESEARCH AND TESTING PURPOSES ONLY.
 */
@Suppress("unused", "UNUSED_VARIABLE", "UNUSED_PARAMETER")
object MaliciousPatterns {

    // =====================================================
    // EXECUTION - Multiple Runtime.exec and ProcessBuilder
    // =====================================================

    fun execCommand1(cmd: String): String {
        val process = Runtime.getRuntime().exec(cmd)
        return process.inputStream.bufferedReader().readText()
    }

    fun execCommand2(cmd: String): String {
        val runtime = Runtime.getRuntime()
        val p = runtime.exec(arrayOf("sh", "-c", cmd))
        return p.inputStream.bufferedReader().readText()
    }

    fun execCommand3(cmd: String): String {
        return Runtime.getRuntime().exec(cmd).inputStream.bufferedReader().readText()
    }

    fun execWithProcessBuilder(cmd: String): String {
        val pb = ProcessBuilder(cmd.split(" "))
        val process = pb.start()
        return process.inputStream.bufferedReader().readText()
    }

    fun execSu(): java.lang.Process = Runtime.getRuntime().exec("su")
    fun execId(): java.lang.Process = Runtime.getRuntime().exec("id")
    fun execPs(): java.lang.Process = Runtime.getRuntime().exec("ps")
    fun execLs(): java.lang.Process = Runtime.getRuntime().exec("ls")
    fun execCat(): java.lang.Process = Runtime.getRuntime().exec("cat /etc/passwd")
    fun execMount(): java.lang.Process = Runtime.getRuntime().exec("mount")
    fun execGetprop(): java.lang.Process = Runtime.getRuntime().exec("getprop")
    fun execPm(): java.lang.Process = Runtime.getRuntime().exec("pm list packages")
    fun execDumpsys(): java.lang.Process = Runtime.getRuntime().exec("dumpsys")
    fun execLogcat(): java.lang.Process = Runtime.getRuntime().exec("logcat -d")

    // =====================================================
    // DROPPER - Multiple DexClassLoader instances
    // =====================================================

    fun loadDex1(ctx: Context, path: String): ClassLoader {
        return DexClassLoader(path, ctx.cacheDir.absolutePath, null, ctx.classLoader)
    }

    fun loadDex2(ctx: Context, path: String): ClassLoader {
        return DexClassLoader(path, ctx.codeCacheDir.absolutePath, null, ctx.classLoader)
    }

    fun loadDex3(ctx: Context, path: String): ClassLoader {
        val optimizedDir = ctx.getDir("outdex", Context.MODE_PRIVATE)
        return DexClassLoader(path, optimizedDir.absolutePath, null, ctx.classLoader)
    }

    fun loadDex4(ctx: Context, path: String): ClassLoader {
        return PathClassLoader(path, ctx.classLoader)
    }

    fun loadDexFromDownloads(ctx: Context): ClassLoader {
        val dexPath = "/sdcard/Download/payload.dex"
        return DexClassLoader(dexPath, ctx.cacheDir.absolutePath, null, ctx.classLoader)
    }

    fun loadDexFromData(ctx: Context): ClassLoader {
        val dexPath = ctx.filesDir.absolutePath + "/classes.dex"
        return DexClassLoader(dexPath, ctx.cacheDir.absolutePath, null, ctx.classLoader)
    }

    fun loadMultipleDex(ctx: Context, paths: List<String>): List<ClassLoader> {
        return paths.map { path ->
            DexClassLoader(path, ctx.cacheDir.absolutePath, null, ctx.classLoader)
        }
    }

    fun loadAndInvoke(ctx: Context, dexPath: String, className: String, methodName: String) {
        val classLoader = DexClassLoader(dexPath, ctx.cacheDir.absolutePath, null, ctx.classLoader)
        val clazz = classLoader.loadClass(className)
        val method = clazz.getDeclaredMethod(methodName)
        method.invoke(null)
    }

    // More DexClassLoader references to boost count
    private fun dexLoader10(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader11(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader12(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader13(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader14(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader15(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader16(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader17(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader18(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader19(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)
    private fun dexLoader20(ctx: Context) = DexClassLoader("", ctx.cacheDir.path, null, null)

    // =====================================================
    // ICON HIDE / ACTIVITY HIDE
    // =====================================================

    fun hideAppIcon(ctx: Context) {
        val pm = ctx.packageManager
        val componentName = ComponentName(ctx, MainActivity::class.java)
        pm.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    fun showAppIcon(ctx: Context) {
        val pm = ctx.packageManager
        val componentName = ComponentName(ctx, MainActivity::class.java)
        pm.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    fun disableComponent(ctx: Context, componentClass: Class<*>) {
        ctx.packageManager.setComponentEnabledSetting(
            ComponentName(ctx, componentClass),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    // excludeFromRecents pattern
    fun hideFromRecents(): Int {
        val flags = android.content.Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        return flags or android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
    }

    // =====================================================
    // ANTI-DEBUG / ANTI-VM PATTERNS
    // =====================================================

    fun isDebuggerConnected(): Boolean {
        return Debug.isDebuggerConnected()
    }

    fun isBeingDebugged(): Boolean {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger()
    }

    fun detectEmulator(): Boolean {
        val dominated by lazy {
            (android.os.Build.FINGERPRINT.startsWith("generic")
                || android.os.Build.FINGERPRINT.startsWith("unknown")
                || android.os.Build.MODEL.contains("google_sdk")
                || android.os.Build.MODEL.contains("Emulator")
                || android.os.Build.MODEL.contains("Android SDK built for x86")
                || android.os.Build.MANUFACTURER.contains("Genymotion")
                || android.os.Build.BRAND.startsWith("generic")
                || android.os.Build.DEVICE.startsWith("generic")
                || android.os.Build.PRODUCT == "sdk"
                || android.os.Build.PRODUCT == "sdk_google"
                || android.os.Build.PRODUCT == "sdk_x86"
                || android.os.Build.PRODUCT == "vbox86p"
                || android.os.Build.HARDWARE.contains("goldfish")
                || android.os.Build.HARDWARE.contains("ranchu"))
        }
        return dominated
    }

    fun checkTracerPid(): Boolean {
        val tracerPid = File("/proc/self/status").readLines()
            .find { it.startsWith("TracerPid:") }
            ?.split(":")?.get(1)?.trim()?.toIntOrNull() ?: 0
        return tracerPid != 0
    }

    // =====================================================
    // NATIVE / REFLECTION PATTERNS
    // =====================================================

    fun loadNativeLibrary(libName: String) {
        System.loadLibrary(libName)
    }

    fun loadNativeLibraryPath(path: String) {
        System.load(path)
    }

    fun reflectiveInvoke(className: String, methodName: String, vararg args: Any?) {
        val clazz = Class.forName(className)
        val method = clazz.getDeclaredMethod(methodName)
        method.isAccessible = true
        method.invoke(null, *args)
    }

    fun getHiddenApi(className: String, methodName: String): Method? {
        return try {
            val clazz = Class.forName(className)
            val method = clazz.getDeclaredMethod(methodName)
            method.isAccessible = true
            method
        } catch (e: Exception) {
            null
        }
    }

    // =====================================================
    // OBFUSCATION-LIKE PATTERNS
    // =====================================================

    // String obfuscation patterns
    private val a = "c".plus("m").plus("d")
    private val b = String(charArrayOf('s', 'h'))
    private val c = StringBuilder().append("e").append("x").append("e").append("c").toString()

    fun deobfuscate(encoded: String): String {
        return String(android.util.Base64.decode(encoded, android.util.Base64.DEFAULT))
    }

    // XOR decryption pattern
    fun xorDecrypt(data: ByteArray, key: ByteArray): ByteArray {
        return data.mapIndexed { i, b -> (b.toInt() xor key[i % key.size].toInt()).toByte() }.toByteArray()
    }

    // =====================================================
    // ADDITIONAL SUSPICIOUS PATTERNS
    // =====================================================

    // Crypto/keylogging patterns (just the API calls)
    fun getClipboardData(ctx: Context): String? {
        val clipboard = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        return clipboard.primaryClip?.getItemAt(0)?.text?.toString()
    }

    // Location tracking
    fun requestLocation(ctx: Context) {
        val lm = ctx.getSystemService(Context.LOCATION_SERVICE) as android.location.LocationManager
    }

    // Camera access pattern
    fun getCameraInfo(): Int {
        return android.hardware.Camera.getNumberOfCameras()
    }

    // Audio recording pattern
    fun createRecorder(): android.media.MediaRecorder {
        return android.media.MediaRecorder()
    }

    // Telephony patterns
    fun getTelephonyInfo(ctx: Context): String? {
        val tm = ctx.getSystemService(Context.TELEPHONY_SERVICE) as android.telephony.TelephonyManager
        return tm.networkOperatorName
    }

    // Kill other apps pattern
    fun killProcess(pid: Int) {
        android.os.Process.killProcess(pid)
    }

    // =====================================================
    // ANTI-ROOT DETECTION
    // =====================================================

    fun isRooted(): Boolean {
        val rootPaths = arrayOf(
            "/system/bin/su",
            "/system/xbin/su",
            "/sbin/su",
            "/system/su",
            "/system/bin/.ext/.su",
            "/system/usr/we-need-root/su-backup",
            "/system/xbin/mu",
            "/data/local/xbin/su",
            "/data/local/bin/su",
            "/data/local/su",
            "/system/app/Superuser.apk",
            "/system/app/SuperSU.apk",
            "/system/app/SuperSU/SuperSU.apk",
            "/system/app/Superuser/Superuser.apk"
        )
        return rootPaths.any { File(it).exists() }
    }

    fun checkSuBinary(): Boolean {
        return File("/system/bin/su").exists() || File("/system/xbin/su").exists()
    }

    fun checkMagisk(): Boolean {
        val magiskPaths = arrayOf(
            "/sbin/.magisk",
            "/data/adb/magisk",
            "/cache/.disable_magisk",
            "/dev/.magisk.unblock"
        )
        return magiskPaths.any { File(it).exists() }
    }

    fun checkRootManagementApps(ctx: Context): Boolean {
        val rootApps = arrayOf(
            "com.topjohnwu.magisk",
            "com.koushikdutta.superuser",
            "com.noshufou.android.su",
            "com.thirdparty.superuser",
            "eu.chainfire.supersu",
            "com.yellowes.su"
        )
        val pm = ctx.packageManager
        return rootApps.any { pkg ->
            try {
                pm.getPackageInfo(pkg, 0)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    fun checkBusybox(): Boolean {
        return File("/system/xbin/busybox").exists() || File("/system/bin/busybox").exists()
    }

    fun executeRootCheck(): Boolean {
        return try {
            val process = Runtime.getRuntime().exec(arrayOf("/system/xbin/which", "su"))
            process.inputStream.bufferedReader().readLine() != null
        } catch (e: Exception) {
            false
        }
    }
}
```

---

### NativePayload.kt

JNI interface for native malware functionality.

```kotlin
package com.prototype.badboy

/**
 * Native payload interface with suspicious JNI exports.
 * FOR SECURITY RESEARCH AND TESTING PURPOSES ONLY.
 */
@Suppress("unused")
object NativePayload {

    init {
        try {
            System.loadLibrary("badboy_native")
        } catch (e: UnsatisfiedLinkError) {
            // Library not available
        }
    }

    // Payload decryption
    external fun decryptPayload(encrypted: ByteArray): String

    // Shell command execution
    external fun executeShellCommand(cmd: String): Int

    // Process injection
    external fun injectProcess(pid: Int): Int

    // Process hiding
    external fun hideFromProcessList()

    // Credential theft
    external fun stealCredentials(): ByteArray?

    // Keylogger functions
    external fun keyloggerStart()
    external fun keyloggerGetBuffer(): String

    // Screen capture
    external fun screenCapture()

    // Root exploit
    external fun rootDevice(): Int

    // Anti-debug
    external fun antiDebug()

    // SSL pinning bypass
    external fun bypassSSLPinning()

    // C2 communication
    external fun connectC2Server(url: String): String

    // Data exfiltration
    external fun exfiltrateData(data: ByteArray)

    // In-memory DEX loading
    external fun loadDexFromMemory(dex: ByteArray): Int

    // Syscall hooking
    external fun hookSystemCall(syscall: String)

    // SELinux disable
    external fun disableSelinux()

    // Persistence
    external fun persistPayload()

    // Device fingerprinting
    external fun getDeviceFingerprint(): String

    // Ransomware
    external fun ransomwareEncrypt(path: String)

    // Banking overlay
    external fun bankingOverlayInject(): Int
}
```

---

### BadAccessibilityService.kt

Accessibility service for keylogging and screen capture.

```kotlin
package com.prototype.badboy

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent
import android.util.Log

class BadAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            Log.d("BadAccessibility", "Event: ${it.eventType} - ${it.packageName}")

            // Keylogger-like pattern
            if (it.eventType == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED) {
                val text = it.text.joinToString("")
                Log.d("BadAccessibility", "Text changed: $text")
            }

            // Screen content capture pattern
            val source = it.source
            source?.let { node ->
                val content = node.text?.toString() ?: ""
                node.recycle()
            }
        }
    }

    override fun onInterrupt() {
        Log.d("BadAccessibility", "Service interrupted")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        val info = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPES_ALL_MASK
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            flags = AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS or
                    AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS or
                    AccessibilityServiceInfo.FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY
            notificationTimeout = 100
        }
        serviceInfo = info
    }
}
```

---

### BadDeviceAdmin.kt

Device admin receiver for persistence.

```kotlin
package com.prototype.badboy

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BadDeviceAdmin : DeviceAdminReceiver() {

    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        Log.d("BadDeviceAdmin", "Device admin enabled")
    }

    override fun onDisabled(context: Context, intent: Intent) {
        super.onDisabled(context, intent)
        Log.d("BadDeviceAdmin", "Device admin disabled")
    }

    override fun onPasswordFailed(context: Context, intent: Intent) {
        super.onPasswordFailed(context, intent)
        Log.d("BadDeviceAdmin", "Password failed")
    }

    override fun onPasswordSucceeded(context: Context, intent: Intent) {
        super.onPasswordSucceeded(context, intent)
        Log.d("BadDeviceAdmin", "Password succeeded")
    }
}
```

---

### BootReceiver.kt

Boot persistence receiver.

```kotlin
package com.prototype.badboy

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d("BootReceiver", "Boot completed received")
        }
    }
}
```

---

### SmsReceiver.kt

SMS interception receiver.

```kotlin
package com.prototype.badboy

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            messages.forEach { sms ->
                Log.d("SmsReceiver", "From: ${sms.originatingAddress}, Body: ${sms.messageBody}")
            }
        }
    }
}
```

---

### ExportedComponents.kt

Exported activities, services, receivers, and content providers.

```kotlin
package com.prototype.badboy

import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.IBinder

// EXPORTED ACTIVITIES
class ExportedLoginActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }
class ExportedPaymentActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }
class ExportedSettingsActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }
class ExportedDebugActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }
class ExportedAdminActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }
class ExportedTransferActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }
class ExportedWebViewActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }
class ExportedDeepLinkActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }
class ExportedFileActivity : Activity() { override fun onCreate(s: Bundle?) { super.onCreate(s); finish() } }

// EXPORTED SERVICES
class ExportedDataService : Service() { override fun onBind(i: Intent?): IBinder? = null }
class ExportedSyncService : Service() { override fun onBind(i: Intent?): IBinder? = null }
class ExportedUploadService : Service() { override fun onBind(i: Intent?): IBinder? = null }
class ExportedDownloadService : Service() { override fun onBind(i: Intent?): IBinder? = null }
class ExportedCommandService : Service() { override fun onBind(i: Intent?): IBinder? = null }
class ExportedRemoteService : Service() { override fun onBind(i: Intent?): IBinder? = null }
class ExportedBackgroundService : Service() { override fun onBind(i: Intent?): IBinder? = null }
class ExportedMessagingService : Service() { override fun onBind(i: Intent?): IBinder? = null }

// EXPORTED RECEIVERS
class ExportedCommandReceiver : BroadcastReceiver() { override fun onReceive(c: Context?, i: Intent?) {} }
class ExportedUpdateReceiver : BroadcastReceiver() { override fun onReceive(c: Context?, i: Intent?) {} }
class ExportedTriggerReceiver : BroadcastReceiver() { override fun onReceive(c: Context?, i: Intent?) {} }
class ExportedPushReceiver : BroadcastReceiver() { override fun onReceive(c: Context?, i: Intent?) {} }
class ExportedWakeReceiver : BroadcastReceiver() { override fun onReceive(c: Context?, i: Intent?) {} }
class ExportedPackageReceiver : BroadcastReceiver() { override fun onReceive(c: Context?, i: Intent?) {} }
class ExportedNetworkReceiver : BroadcastReceiver() { override fun onReceive(c: Context?, i: Intent?) {} }
class ExportedBatteryReceiver : BroadcastReceiver() { override fun onReceive(c: Context?, i: Intent?) {} }

// EXPORTED CONTENT PROVIDERS
abstract class StubProvider : ContentProvider() {
    override fun onCreate() = true
    override fun query(u: Uri, p: Array<String>?, s: String?, a: Array<String>?, o: String?): Cursor? = null
    override fun getType(u: Uri): String? = null
    override fun insert(u: Uri, v: ContentValues?): Uri? = null
    override fun delete(u: Uri, s: String?, a: Array<String>?) = 0
    override fun update(u: Uri, v: ContentValues?, s: String?, a: Array<String>?) = 0
}

class ExportedUserProvider : StubProvider()
class ExportedCredentialsProvider : StubProvider()
class ExportedMessagesProvider : StubProvider()
class ExportedContactsProvider : StubProvider()
class ExportedFilesProvider : StubProvider()
class ExportedConfigProvider : StubProvider()
class ExportedTokenProvider : StubProvider()
class ExportedDatabaseProvider : StubProvider()
```

---

## Full Source Location

The complete Android Studio project is available at: `docs/badboy/`

```
docs/badboy/
├── app/
│   ├── src/main/
│   │   ├── java/com/prototype/badboy/   # All Kotlin source files
│   │   ├── cpp/                          # Native C code (badboy_native.c)
│   │   ├── res/                          # Android resources
│   │   └── AndroidManifest.xml           # Manifest with permissions
│   └── build.gradle.kts
├── build.gradle.kts
└── settings.gradle.kts
```

## Usage for Decompiler Validation

1. **Decompile APK**: `./target/release/dexterity apks/badboy-x86.apk -o output/dexterity/badboy-x86`
2. **Compare output** to source code in this document
3. **Check for**:
   - Correct class/method signatures
   - Accurate control flow reconstruction
   - Proper type inference
   - Lambda/callback handling (Compose)
   - Native method declarations
