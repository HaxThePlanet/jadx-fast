package com.prototype.badboy;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Base64;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: MaliciousPatterns.kt */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0012\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0015\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0007bcdefghB\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u000c\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00160 2\u0006\u0010\u0017\u001a\u00020\u00182\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00050 J&\u0010\"\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010/\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00102\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u00103\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u00104\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u00105\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00182\n\u00106\u001a\u0006\u0012\u0002\u0008\u000307J\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u00020;J\u0006\u0010=\u001a\u00020;J\u0006\u0010>\u001a\u00020;J\u000e\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u0005J\u000e\u0010A\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u0005J3\u0010B\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0016\u0010C\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010D\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010EJ\u0018\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005J\u0016\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010R\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010S\u001a\u000209J\u0006\u0010T\u001a\u00020UJ\u0010\u0010V\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010W\u001a\u00020#2\u0006\u0010X\u001a\u000209J\u0006\u0010Y\u001a\u00020;J\u0006\u0010Z\u001a\u00020;J\u0006\u0010[\u001a\u00020;J\u000e\u0010\\\u001a\u00020;2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010]\u001a\u00020;J\u0006\u0010^\u001a\u00020;R\u000e\u0010H\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010_\u001a\u0008\u0012\u0004\u0012\u00020\u00050 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008`\u0010a¨\u0006i²\u0006\n\u0010j\u001a\u00020;X\u008a\u0084\u0002", d2 = {"Lcom/prototype/badboy/MaliciousPatterns;", "", "<init>", "()V", "execCommand1", "", "cmd", "execCommand2", "execCommand3", "execWithProcessBuilder", "execSu", "Ljava/lang/Process;", "execId", "execPs", "execLs", "execCat", "execMount", "execGetprop", "execPm", "execDumpsys", "execLogcat", "loadDex1", "Ljava/lang/ClassLoader;", "ctx", "Landroid/content/Context;", "path", "loadDex2", "loadDex3", "loadDex4", "loadDexFromDownloads", "loadDexFromData", "loadMultipleDex", "", "paths", "loadAndInvoke", "", "dexPath", "className", "methodName", "dexLoader10", "Ldalvik/system/DexClassLoader;", "dexLoader11", "dexLoader12", "dexLoader13", "dexLoader14", "dexLoader15", "dexLoader16", "dexLoader17", "dexLoader18", "dexLoader19", "dexLoader20", "hideAppIcon", "showAppIcon", "disableComponent", "componentClass", "Ljava/lang/Class;", "hideFromRecents", "", "isDebuggerConnected", "", "isBeingDebugged", "detectEmulator", "checkTracerPid", "loadNativeLibrary", "libName", "loadNativeLibraryPath", "reflectiveInvoke", "args", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "getHiddenApi", "Ljava/lang/reflect/Method;", "a", "b", "c", "deobfuscate", "encoded", "xorDecrypt", "", "data", "key", "getClipboardData", "requestLocation", "getCameraInfo", "createRecorder", "Landroid/media/MediaRecorder;", "getTelephonyInfo", "killProcess", "pid", "isRooted", "checkSuBinary", "checkMagisk", "checkRootManagementApps", "checkBusybox", "executeRootCheck", "adSdkStrings", "getAdSdkStrings", "()Ljava/util/List;", "FakeAdMob", "FakeFacebookAds", "FakeUnityAds", "FakeAppLovin", "FakeMintegral", "FakeStartApp", "FakeAirpush", "app_debug", "dominated"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MaliciousPatterns {

    public static final int $stable = 8;
    public static final MaliciousPatterns INSTANCE = new MaliciousPatterns();
    private static final String a = "cmd";
    private static final List<String> adSdkStrings;
    private static final String b = new String();
    private static final String c;
    private MaliciousPatterns() {
        super();
    }

    public final String execCommand1(String cmd) throws java.io.UnsupportedEncodingException, java.io.IOException {
        Object obj;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        java.io.InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        z = inputStreamReader instanceof BufferedReader;
        BufferedReader r3 = inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        return TextStreamsKt.readText((inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192)));
    }

    public final String execCommand2(String cmd) throws java.io.UnsupportedEncodingException, java.io.IOException {
        Object obj;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        String[] strArr = new String[3];
        java.io.InputStream inputStream = Runtime.getRuntime().exec(new String[] { "sh", "-c", cmd }).getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        z = inputStreamReader instanceof BufferedReader;
        BufferedReader r4 = inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        return TextStreamsKt.readText((inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192)));
    }

    public final String execCommand3(String cmd) throws java.io.UnsupportedEncodingException, java.io.IOException {
        Object obj;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        java.io.InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        z = inputStreamReader instanceof BufferedReader;
        BufferedReader r2 = inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        return TextStreamsKt.readText((inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192)));
    }

    public final String execWithProcessBuilder(String cmd) throws java.io.IOException, java.io.UnsupportedEncodingException {
        Object obj;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        String[] strArr = new String[1];
        int i2 = 0;
        strArr[i2] = " ";
        java.io.InputStream inputStream = new ProcessBuilder(StringsKt.split$default((CharSequence)cmd, strArr, false, 0, 6, null)).start().getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        z = inputStreamReader instanceof BufferedReader;
        BufferedReader r4 = inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        return TextStreamsKt.readText((inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192)));
    }

    public final java.lang.Process execSu() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("su");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execId() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("id");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execPs() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("ps");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execLs() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("ls");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execCat() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("cat /etc/passwd");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execMount() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("mount");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execGetprop() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("getprop");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execPm() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("pm list packages");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execDumpsys() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("dumpsys");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execLogcat() throws java.io.IOException {
        java.lang.Process exec = Runtime.getRuntime().exec("logcat -d");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.ClassLoader loadDex1(Context ctx, String path) throws java.io.IOException {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(path, "path");
        return (ClassLoader)new DexClassLoader(path, ctx.getCacheDir().getAbsolutePath(), null, ctx.getClassLoader());
    }

    public final java.lang.ClassLoader loadDex2(Context ctx, String path) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(path, "path");
        return (ClassLoader)new DexClassLoader(path, ctx.getCodeCacheDir().getAbsolutePath(), null, ctx.getClassLoader());
    }

    public final java.lang.ClassLoader loadDex3(Context ctx, String path) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(path, "path");
        return (ClassLoader)new DexClassLoader(path, ctx.getDir("outdex", 0).getAbsolutePath(), null, ctx.getClassLoader());
    }

    public final java.lang.ClassLoader loadDex4(Context ctx, String path) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(path, "path");
        return (ClassLoader)new PathClassLoader(path, ctx.getClassLoader());
    }

    public final java.lang.ClassLoader loadDexFromDownloads(Context ctx) throws java.io.IOException {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return (ClassLoader)new DexClassLoader("/sdcard/Download/payload.dex", ctx.getCacheDir().getAbsolutePath(), null, ctx.getClassLoader());
    }

    public final java.lang.ClassLoader loadDexFromData(Context ctx) throws java.io.IOException {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String str2 = "/classes.dex";
        r0 = str2;
        return (ClassLoader)new DexClassLoader(r0, ctx.getCacheDir().getAbsolutePath(), null, ctx.getClassLoader());
    }

    public final List<java.lang.ClassLoader> loadMultipleDex(Context ctx, List<String> paths) throws java.io.IOException {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Iterable paths2 = paths;
        final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(paths2, 10));
        final Iterator it = paths2.iterator();
        while (it.hasNext()) {
            i = 0;
            str2 = null;
            arrayList.add(new DexClassLoader((String)it.next(), ctx.getCacheDir().getAbsolutePath(), str2, ctx.getClassLoader()));
        }
        return arrayList;
    }

    public final void loadAndInvoke(Context ctx, String dexPath, String className, String methodName) throws java.io.IOException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(dexPath, "dexPath");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        final String str5 = null;
        int i = 0;
        new DexClassLoader(dexPath, ctx.getCacheDir().getAbsolutePath(), str5, ctx.getClassLoader()).loadClass(className).getDeclaredMethod(methodName, new Class[i]).invoke(str5, new Object[i]);
    }

    private final DexClassLoader dexLoader10(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader11(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader12(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader13(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader14(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader15(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader16(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader17(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader18(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader19(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    private final DexClassLoader dexLoader20(Context ctx) throws java.io.IOException {
        final String str = null;
        return new DexClassLoader("", ctx.getCacheDir().getPath(), str, str);
    }

    public final void hideAppIcon(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ctx.getPackageManager().setComponentEnabledSetting(new ComponentName(ctx, MainActivity.class), 2, 1);
    }

    public final void showAppIcon(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        int i = 1;
        ctx.getPackageManager().setComponentEnabledSetting(new ComponentName(ctx, MainActivity.class), i, i);
    }

    public final void disableComponent(Context ctx, Class<?> componentClass) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(componentClass, "componentClass");
        ctx.getPackageManager().setComponentEnabledSetting(new ComponentName(ctx, componentClass), 2, 1);
    }

    public final int hideFromRecents() {
        return 1073741824 | 8388608;
    }

    public final boolean isDebuggerConnected() {
        return Debug.isDebuggerConnected();
    }

    public final boolean isBeingDebugged() {
        boolean z = false;
        if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
            z = true;
        }
        return z;
    }

    private static final boolean detectEmulator$lambda$2(Lazy<Boolean> $dominated$delegate) {
        return (Boolean)$dominated$delegate.getValue().booleanValue();
    }

    public final boolean detectEmulator() {
        return MaliciousPatterns.detectEmulator$lambda$2(LazyKt.lazy(new MaliciousPatterns$$ExternalSyntheticLambda0()));
    }

    private static final boolean detectEmulator$lambda$1() {
        boolean startsWith$default;
        String str;
        String str2;
        boolean z = true;
        String str3;
        String fINGERPRINT2 = Build.FINGERPRINT;
        str = "FINGERPRINT";
        Intrinsics.checkNotNullExpressionValue(fINGERPRINT2, str);
        str2 = "generic";
        z = false;
        final int i2 = 2;
        final Object obj = null;
        if (!StringsKt.startsWith$default(fINGERPRINT2, str2, z, i2, obj)) {
            String fINGERPRINT22 = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(fINGERPRINT22, str);
            str = "unknown";
            if (!StringsKt.startsWith$default(fINGERPRINT22, str, z, i2, obj)) {
                String mODEL2 = Build.MODEL;
                str = "MODEL";
                Intrinsics.checkNotNullExpressionValue(mODEL2, str);
                str3 = "google_sdk";
                if (!StringsKt.contains$default(mODEL2, (CharSequence)str3, z, i2, obj)) {
                    String mODEL22 = Build.MODEL;
                    Intrinsics.checkNotNullExpressionValue(mODEL22, str);
                    str3 = "Emulator";
                    if (!StringsKt.contains$default(mODEL22, (CharSequence)str3, z, i2, obj)) {
                        String mODEL23 = Build.MODEL;
                        Intrinsics.checkNotNullExpressionValue(mODEL23, str);
                        str = "Android SDK built for x86";
                        if (!StringsKt.contains$default(mODEL23, (CharSequence)str, z, i2, obj)) {
                            String mANUFACTURER2 = Build.MANUFACTURER;
                            Intrinsics.checkNotNullExpressionValue(mANUFACTURER2, "MANUFACTURER");
                            str = "Genymotion";
                            if (!StringsKt.contains$default(mANUFACTURER2, (CharSequence)str, z, i2, obj)) {
                                String bRAND2 = Build.BRAND;
                                str = "BRAND";
                                Intrinsics.checkNotNullExpressionValue(bRAND2, str);
                                if (!StringsKt.startsWith$default(bRAND2, str2, z, i2, obj)) {
                                    String dEVICE2 = Build.DEVICE;
                                    str = "DEVICE";
                                    Intrinsics.checkNotNullExpressionValue(dEVICE2, str);
                                    if (!StringsKt.startsWith$default(dEVICE2, str2, z, i2, obj)) {
                                        str = "sdk";
                                        if (!Intrinsics.areEqual(Build.PRODUCT, str)) {
                                            str = "sdk_google";
                                            if (!Intrinsics.areEqual(Build.PRODUCT, str)) {
                                                str = "sdk_x86";
                                                if (!Intrinsics.areEqual(Build.PRODUCT, str)) {
                                                    str = "vbox86p";
                                                    if (!Intrinsics.areEqual(Build.PRODUCT, str)) {
                                                        String hARDWARE2 = Build.HARDWARE;
                                                        str = "HARDWARE";
                                                        Intrinsics.checkNotNullExpressionValue(hARDWARE2, str);
                                                        str2 = "goldfish";
                                                        if (!StringsKt.contains$default(hARDWARE2, (CharSequence)str2, z, i2, obj)) {
                                                            String hARDWARE22 = Build.HARDWARE;
                                                            Intrinsics.checkNotNullExpressionValue(hARDWARE22, str);
                                                            str = "ranchu";
                                                            if (StringsKt.contains$default(hARDWARE22, (CharSequence)str, z, i2, obj)) {
                                                                z = true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public final boolean checkTracerPid() {
        boolean z;
        java.nio.charset.Charset charset = null;
        boolean it2;
        int i = 0;
        String str;
        int i2 = 2;
        int i3 = 6;
        Object obj = null;
        charset = null;
        z = true;
        it = (Iterable)FilesKt.readLines$default(new File("/proc/self/status"), charset, i4, charset).iterator();
        z = false;
        while (it.hasNext()) {
            next2 = it.next();
            i = 0;
            str = "TracerPid:";
            i2 = 2;
            if (StringsKt.startsWith$default((String)next, str, z, i2, charset)) {
                break;
            }
            z = false;
        }
        if (charset != null) {
            String[] strArr = new String[i4];
            strArr[z] = ":";
            i3 = 6;
            obj = null;
            str = null;
            i2 = 0;
            it = StringsKt.split$default((CharSequence)charset, strArr, z2, i2, i3, obj);
            if (split$default != null) {
                it = split$default.get(i4);
                if (item != null) {
                    it = StringsKt.trim(item).toString();
                    if (object == null || intOrNull == null) {
                    } else {
                        z = intOrNull.intValue();
                    }
                }
            }
        }
        if (z) {
        } else {
        }
        return z;
    }

    public final void loadNativeLibrary(String libName) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        System.loadLibrary(libName);
    }

    public final void loadNativeLibraryPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        System.load(path);
    }

    public final void reflectiveInvoke(String className, String methodName, Object... args) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.NoSuchMethodException {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Method declaredMethod = Class.forName(className).getDeclaredMethod(methodName, new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, Arrays.copyOf(args, args.length));
    }

    public final Method getHiddenApi(String className, String methodName) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        Method declaredMethod;
        try {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            Class.forName(className).getDeclaredMethod(methodName, new Class[0]).setAccessible(true);
        } catch (Exception e) {
            return declaredMethod;
        }
    }

    static {
        char[] cArr = new char[] {115, 104};
        String str15 = "e";
        String str16 = "c";
        str14 = str16;
        Intrinsics.checkNotNullExpressionValue(str14, "toString(...)");
        MaliciousPatterns.c = str14;
        String[] strArr = new String[15];
        MaliciousPatterns.adSdkStrings = CollectionsKt.listOf(new String[] { "com.google.android.gms.ads", "com.facebook.ads", "com.unity3d.ads", "com.applovin", "com.mintegral", "com.startapp", "com.airpush.android", "com.leadbolt", "com.millennialmedia", "com.inmobi.ads", "com.chartboost.sdk", "com.vungle.publisher", "com.ironsource.mediationsdk", "com.adcolony.sdk", "com.tapjoy" });
    }

    public final String deobfuscate(String encoded) {
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        byte[] decode = Base64.decode(encoded, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
        return new String(decode, Charsets.UTF_8);
    }

    public final byte[] xorDecrypt(byte[] data, byte[] key) {
        int i = 0;
        int i2 = 0;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        Object data2 = data;
        final ArrayList arrayList = new ArrayList(data2.length);
        i = 0;
        i2 = 0;
        for (byte b : data2) {
            i = i + 1;
            i4 = (key[i % key.length]) ^ b;
            arrayList.add(Byte.valueOf((byte)i4));
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    public final String getClipboardData(Context ctx) {
        String object = null;
        int i = 0;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Object systemService = ctx.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        primaryClip = systemService.getPrimaryClip();
        if (primaryClip != null) {
            i = 0;
            primaryClip = primaryClip.getItemAt(i);
            if (itemAt == null || text == null) {
                object = null;
            } else {
                object = text.toString();
            }
        }
        return object;
    }

    public final void requestLocation(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNull(ctx.getSystemService("location"), "null cannot be cast to non-null type android.location.LocationManager");
    }

    public final int getCameraInfo() {
        return Camera.getNumberOfCameras();
    }

    public final MediaRecorder createRecorder() {
        return new MediaRecorder();
    }

    public final String getTelephonyInfo(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Object systemService = ctx.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return systemService.getNetworkOperatorName();
    }

    public final void killProcess(int pid) {
        Process.killProcess(pid);
    }

    public final boolean isRooted() {
        boolean z = false;
        int i;
        String str;
        boolean it2;
        int i3 = 0;
        File file;
        String[] strArr = new String[14];
        z = false;
        strArr[i] = "/system/bin/su";
        final int i2 = 1;
        strArr[i2] = "/system/xbin/su";
        strArr[2] = "/sbin/su";
        strArr[3] = "/system/su";
        strArr[4] = "/system/bin/.ext/.su";
        strArr[5] = "/system/usr/we-need-root/su-backup";
        strArr[6] = "/system/xbin/mu";
        strArr[7] = "/data/local/xbin/su";
        strArr[8] = "/data/local/bin/su";
        strArr[9] = "/data/local/su";
        strArr[10] = "/system/app/Superuser.apk";
        strArr[11] = "/system/app/SuperSU.apk";
        strArr[12] = "/system/app/SuperSU/SuperSU.apk";
        strArr[13] = "/system/app/Superuser/Superuser.apk";
        for (String str : strArr) {
            if (new File(str).exists()) {
            }
        }
        return z;
    }

    public final boolean checkSuBinary() {
        boolean z = false;
        String str;
        str = "/system/bin/su";
        if (!new File(str).exists()) {
            str = "/system/xbin/su";
            if (new File(str).exists()) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean checkMagisk() {
        boolean z = false;
        int i;
        String str;
        boolean it2;
        int i3 = 0;
        File file;
        String[] strArr = new String[4];
        z = false;
        strArr[i] = "/sbin/.magisk";
        final int i2 = 1;
        strArr[i2] = "/data/adb/magisk";
        strArr[2] = "/cache/.disable_magisk";
        strArr[3] = "/dev/.magisk.unblock";
        for (String str : strArr) {
            if (new File(str).exists()) {
            }
        }
        return z;
    }

    public final boolean checkRootManagementApps(Context ctx) throws android.content.pm.PackageManager.NameNotFoundException {
        boolean z = false;
        int i;
        String str;
        int i3 = 0;
        int i2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String[] strArr = new String[6];
        z = false;
        strArr[i] = "com.topjohnwu.magisk";
        i2 = 1;
        strArr[i2] = "com.koushikdutta.superuser";
        strArr[2] = "com.noshufou.android.su";
        strArr[3] = "com.thirdparty.superuser";
        strArr[4] = "eu.chainfire.supersu";
        strArr[5] = "com.yellowes.su";
        for (String str : strArr) {
            ctx.getPackageManager().getPackageInfo(str, i);
            if (i2 != 0) {
            }
        }
        return z;
    }

    public final boolean checkBusybox() {
        boolean z = false;
        String str;
        str = "/system/xbin/busybox";
        if (!new File(str).exists()) {
            str = "/system/bin/busybox";
            if (new File(str).exists()) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean executeRootCheck() throws java.io.IOException, java.io.UnsupportedEncodingException {
        boolean z2 = false;
        InputStreamReader inputStreamReader;
        try {
            z2 = false;
            String[] strArr = new String[2];
            strArr[i2] = "/system/xbin/which";
            final int i = 1;
            strArr[i] = "su";
            java.io.InputStream inputStream = Runtime.getRuntime().exec(strArr).getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            z = inputStreamReader instanceof BufferedReader;
            BufferedReader r5 = inputStreamReader instanceof BufferedReader ? (BufferedReader)inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        } catch (Exception e) {
            return z2;
        }
    }

    public final List<String> getAdSdkStrings() {
        return MaliciousPatterns.adSdkStrings;
    }

    public static /* synthetic */ boolean $r8$lambda$U07kKvfOZ4gFo5PzGvRAdvNkLTU() {
        return MaliciousPatterns.detectEmulator$lambda$1();
    }
}
