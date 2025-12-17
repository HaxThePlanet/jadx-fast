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

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0012\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0015\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0007bcdefghB\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u000c\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u0016\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00160 2\u0006\u0010\u0017\u001a\u00020\u00182\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00050 J&\u0010\"\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010/\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00102\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u00103\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u00104\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u00105\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00182\n\u00106\u001a\u0006\u0012\u0002\u0008\u000307J\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u00020;J\u0006\u0010=\u001a\u00020;J\u0006\u0010>\u001a\u00020;J\u000e\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u0005J\u000e\u0010A\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u0005J3\u0010B\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0016\u0010C\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010D\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010EJ\u0018\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005J\u0016\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010R\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010S\u001a\u000209J\u0006\u0010T\u001a\u00020UJ\u0010\u0010V\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010W\u001a\u00020#2\u0006\u0010X\u001a\u000209J\u0006\u0010Y\u001a\u00020;J\u0006\u0010Z\u001a\u00020;J\u0006\u0010[\u001a\u00020;J\u000e\u0010\\\u001a\u00020;2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010]\u001a\u00020;J\u0006\u0010^\u001a\u00020;R\u000e\u0010H\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010_\u001a\u0008\u0012\u0004\u0012\u00020\u00050 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008`\u0010a¨\u0006i²\u0006\n\u0010j\u001a\u00020;X\u008a\u0084\u0002", d2 = {"Lcom/prototype/badboy/MaliciousPatterns;", "", "<init>", "()V", "execCommand1", "", "cmd", "execCommand2", "execCommand3", "execWithProcessBuilder", "execSu", "Ljava/lang/Process;", "execId", "execPs", "execLs", "execCat", "execMount", "execGetprop", "execPm", "execDumpsys", "execLogcat", "loadDex1", "Ljava/lang/ClassLoader;", "ctx", "Landroid/content/Context;", "path", "loadDex2", "loadDex3", "loadDex4", "loadDexFromDownloads", "loadDexFromData", "loadMultipleDex", "", "paths", "loadAndInvoke", "", "dexPath", "className", "methodName", "dexLoader10", "Ldalvik/system/DexClassLoader;", "dexLoader11", "dexLoader12", "dexLoader13", "dexLoader14", "dexLoader15", "dexLoader16", "dexLoader17", "dexLoader18", "dexLoader19", "dexLoader20", "hideAppIcon", "showAppIcon", "disableComponent", "componentClass", "Ljava/lang/Class;", "hideFromRecents", "", "isDebuggerConnected", "", "isBeingDebugged", "detectEmulator", "checkTracerPid", "loadNativeLibrary", "libName", "loadNativeLibraryPath", "reflectiveInvoke", "args", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "getHiddenApi", "Ljava/lang/reflect/Method;", "a", "b", "c", "deobfuscate", "encoded", "xorDecrypt", "", "data", "key", "getClipboardData", "requestLocation", "getCameraInfo", "createRecorder", "Landroid/media/MediaRecorder;", "getTelephonyInfo", "killProcess", "pid", "isRooted", "checkSuBinary", "checkMagisk", "checkRootManagementApps", "checkBusybox", "executeRootCheck", "adSdkStrings", "getAdSdkStrings", "()Ljava/util/List;", "FakeAdMob", "FakeFacebookAds", "FakeUnityAds", "FakeAppLovin", "FakeMintegral", "FakeStartApp", "FakeAirpush", "app_debug", "dominated"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MaliciousPatterns {

    public static final int $stable = 8;
    public static final com.prototype.badboy.MaliciousPatterns INSTANCE;
    private static final String a;
    private static final List<String> adSdkStrings;
    private static final String b;
    private static final String c;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\u0008", d2 = {"Lcom/prototype/badboy/MaliciousPatterns$FakeAdMob;", "", "<init>", "()V", "loadAd", "", "showInterstitial", "showRewardedAd", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FakeAdMob {

        public static final int $stable;
        static {
        }

        public final void loadAd() {
        }

        public final void showInterstitial() {
        }

        public final void showRewardedAd() {
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007", d2 = {"Lcom/prototype/badboy/MaliciousPatterns$FakeAirpush;", "", "<init>", "()V", "startPush", "", "showDialog", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FakeAirpush {

        public static final int $stable;
        static {
        }

        public final void showDialog() {
        }

        public final void startPush() {
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007", d2 = {"Lcom/prototype/badboy/MaliciousPatterns$FakeAppLovin;", "", "<init>", "()V", "initializeSdk", "", "showInterstitial", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FakeAppLovin {

        public static final int $stable;
        static {
        }

        public final void initializeSdk() {
        }

        public final void showInterstitial() {
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\u0008", d2 = {"Lcom/prototype/badboy/MaliciousPatterns$FakeFacebookAds;", "", "<init>", "()V", "loadAd", "", "showInterstitial", "showNativeAd", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FakeFacebookAds {

        public static final int $stable;
        static {
        }

        public final void loadAd() {
        }

        public final void showInterstitial() {
        }

        public final void showNativeAd() {
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007", d2 = {"Lcom/prototype/badboy/MaliciousPatterns$FakeMintegral;", "", "<init>", "()V", "init", "", "loadAd", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FakeMintegral {

        public static final int $stable;
        static {
        }

        public final void init() {
        }

        public final void loadAd() {
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007", d2 = {"Lcom/prototype/badboy/MaliciousPatterns$FakeStartApp;", "", "<init>", "()V", "init", "", "showAd", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FakeStartApp {

        public static final int $stable;
        static {
        }

        public final void init() {
        }

        public final void showAd() {
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007", d2 = {"Lcom/prototype/badboy/MaliciousPatterns$FakeUnityAds;", "", "<init>", "()V", "initialize", "", "showAd", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FakeUnityAds {

        public static final int $stable;
        static {
        }

        public final void initialize() {
        }

        public final void showAd() {
        }
    }
    public static boolean $r8$lambda$U07kKvfOZ4gFo5PzGvRAdvNkLTU() {
        return MaliciousPatterns.detectEmulator$lambda$1();
    }

    static {
        MaliciousPatterns maliciousPatterns = new MaliciousPatterns();
        MaliciousPatterns.INSTANCE = maliciousPatterns;
        MaliciousPatterns.a = "cmd";
        int i = 2;
        char[] cArr = new char[i];
        cArr = new short[]{'s', 'h'};
        String string2 = new String(cArr);
        MaliciousPatterns.b = string2;
        StringBuilder stringBuilder = new StringBuilder();
        String str14 = "e";
        String string = stringBuilder.append(str14).append("x").append(str14).append("c").toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        MaliciousPatterns.c = string;
        String[] strArr = new String[15];
        strArr[i] = "com.unity3d.ads";
        strArr[3] = "com.applovin";
        strArr[4] = "com.mintegral";
        strArr[5] = "com.startapp";
        strArr[6] = "com.airpush.android";
        strArr[7] = "com.leadbolt";
        strArr[8] = "com.millennialmedia";
        strArr[9] = "com.inmobi.ads";
        strArr[10] = "com.chartboost.sdk";
        strArr[11] = "com.vungle.publisher";
        strArr[12] = "com.ironsource.mediationsdk";
        strArr[13] = "com.adcolony.sdk";
        strArr[14] = "com.tapjoy";
        MaliciousPatterns.adSdkStrings = CollectionsKt.listOf(strArr);
    }

    private static final boolean detectEmulator$lambda$1() {
        boolean startsWith$default;
        String str3;
        String str;
        int i;
        String str2;
        String fINGERPRINT = Build.FINGERPRINT;
        str3 = "FINGERPRINT";
        Intrinsics.checkNotNullExpressionValue(fINGERPRINT, str3);
        str = "generic";
        i = 0;
        final int i2 = 2;
        final int i3 = 0;
        String fINGERPRINT2 = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(fINGERPRINT2, str3);
        String mODEL = Build.MODEL;
        str3 = "MODEL";
        Intrinsics.checkNotNullExpressionValue(mODEL, str3);
        String mODEL2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(mODEL2, str3);
        String mODEL3 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(mODEL3, str3);
        String mANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(mANUFACTURER, "MANUFACTURER");
        String bRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(bRAND, "BRAND");
        String dEVICE = Build.DEVICE;
        Intrinsics.checkNotNullExpressionValue(dEVICE, "DEVICE");
        String hARDWARE = Build.HARDWARE;
        str3 = "HARDWARE";
        Intrinsics.checkNotNullExpressionValue(hARDWARE, str3);
        if (!StringsKt.startsWith$default(fINGERPRINT, str, i, i2, i3) && !StringsKt.startsWith$default(fINGERPRINT2, "unknown", i, i2, i3) && !StringsKt.contains$default((CharSequence)mODEL, (CharSequence)"google_sdk", i, i2, i3) && !StringsKt.contains$default((CharSequence)mODEL2, (CharSequence)"Emulator", i, i2, i3) && !StringsKt.contains$default((CharSequence)mODEL3, (CharSequence)"Android SDK built for x86", i, i2, i3) && !StringsKt.contains$default((CharSequence)mANUFACTURER, (CharSequence)"Genymotion", i, i2, i3) && !StringsKt.startsWith$default(bRAND, str, i, i2, i3) && !StringsKt.startsWith$default(dEVICE, str, i, i2, i3) && !Intrinsics.areEqual(Build.PRODUCT, "sdk") && !Intrinsics.areEqual(Build.PRODUCT, "sdk_google") && !Intrinsics.areEqual(Build.PRODUCT, "sdk_x86") && !Intrinsics.areEqual(Build.PRODUCT, "vbox86p") && !StringsKt.contains$default((CharSequence)hARDWARE, (CharSequence)"goldfish", i, i2, i3)) {
            fINGERPRINT2 = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(fINGERPRINT2, str3);
            if (!StringsKt.startsWith$default(fINGERPRINT2, "unknown", i, i2, i3)) {
                mODEL = Build.MODEL;
                str3 = "MODEL";
                Intrinsics.checkNotNullExpressionValue(mODEL, str3);
                if (!StringsKt.contains$default((CharSequence)mODEL, (CharSequence)"google_sdk", i, i2, i3)) {
                    mODEL2 = Build.MODEL;
                    Intrinsics.checkNotNullExpressionValue(mODEL2, str3);
                    if (!StringsKt.contains$default((CharSequence)mODEL2, (CharSequence)"Emulator", i, i2, i3)) {
                        mODEL3 = Build.MODEL;
                        Intrinsics.checkNotNullExpressionValue(mODEL3, str3);
                        if (!StringsKt.contains$default((CharSequence)mODEL3, (CharSequence)"Android SDK built for x86", i, i2, i3)) {
                            mANUFACTURER = Build.MANUFACTURER;
                            Intrinsics.checkNotNullExpressionValue(mANUFACTURER, "MANUFACTURER");
                            if (!StringsKt.contains$default((CharSequence)mANUFACTURER, (CharSequence)"Genymotion", i, i2, i3)) {
                                bRAND = Build.BRAND;
                                Intrinsics.checkNotNullExpressionValue(bRAND, "BRAND");
                                if (!StringsKt.startsWith$default(bRAND, str, i, i2, i3)) {
                                    dEVICE = Build.DEVICE;
                                    Intrinsics.checkNotNullExpressionValue(dEVICE, "DEVICE");
                                    if (!StringsKt.startsWith$default(dEVICE, str, i, i2, i3)) {
                                        if (!Intrinsics.areEqual(Build.PRODUCT, "sdk")) {
                                            if (!Intrinsics.areEqual(Build.PRODUCT, "sdk_google")) {
                                                if (!Intrinsics.areEqual(Build.PRODUCT, "sdk_x86")) {
                                                    if (!Intrinsics.areEqual(Build.PRODUCT, "vbox86p")) {
                                                        hARDWARE = Build.HARDWARE;
                                                        str3 = "HARDWARE";
                                                        Intrinsics.checkNotNullExpressionValue(hARDWARE, str3);
                                                        if (!StringsKt.contains$default((CharSequence)hARDWARE, (CharSequence)"goldfish", i, i2, i3)) {
                                                            String hARDWARE2 = Build.HARDWARE;
                                                            Intrinsics.checkNotNullExpressionValue(hARDWARE2, str3);
                                                            if (StringsKt.contains$default((CharSequence)hARDWARE2, (CharSequence)"ranchu", i, i2, i3)) {
                                                                i = 1;
                                                            }
                                                        } else {
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final boolean detectEmulator$lambda$2(Lazy<Boolean> $dominated$delegate) {
        return (Boolean)$dominated$delegate.getValue().booleanValue();
    }

    private final DexClassLoader dexLoader10(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader11(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader12(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader13(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader14(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader15(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader16(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader17(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader18(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader19(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    private final DexClassLoader dexLoader20(Context ctx) {
        final int i = 0;
        DexClassLoader dexClassLoader = new DexClassLoader("", ctx.getCacheDir().getPath(), i, i);
        return dexClassLoader;
    }

    public final boolean checkBusybox() {
        int i;
        boolean exists;
        String str;
        File file = new File("/system/xbin/busybox");
        if (file.exists() == null) {
            File file2 = new File("/system/bin/busybox");
            if (file2.exists() != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean checkMagisk() {
        int i;
        int i2;
        String str;
        boolean it2;
        int i3;
        File file;
        String[] strArr = new String[4];
        i = 0;
        strArr[i] = "/sbin/.magisk";
        final int i5 = 1;
        strArr[i5] = "/data/adb/magisk";
        strArr[2] = "/cache/.disable_magisk";
        strArr[3] = "/dev/.magisk.unblock";
        String[] strArr2 = strArr;
        int i8 = 0;
        i2 = i;
        while (i2 < strArr2.length) {
            i3 = 0;
            file = new File(strArr2[i2]);
            i2++;
        }
        return i;
    }

    public final boolean checkRootManagementApps(Context ctx) {
        int i3;
        int i;
        String str2;
        String str;
        int i2;
        Throwable e2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String[] strArr = new String[6];
        i3 = 0;
        strArr[i3] = "com.topjohnwu.magisk";
        final int i5 = 1;
        strArr[i5] = "com.koushikdutta.superuser";
        strArr[2] = "com.noshufou.android.su";
        strArr[3] = "com.thirdparty.superuser";
        strArr[4] = "eu.chainfire.supersu";
        strArr[5] = "com.yellowes.su";
        String[] strArr2 = strArr;
        final int i10 = 0;
        i = i3;
        while (i < strArr2.length) {
            i2 = 0;
            ctx.getPackageManager().getPackageInfo(strArr2[i], i3);
            e2 = i5;
            i++;
            e2 = obj2;
        }
        return i3;
    }

    public final boolean checkSuBinary() {
        int i;
        boolean exists;
        String str;
        File file = new File("/system/bin/su");
        if (file.exists() == null) {
            File file2 = new File("/system/xbin/su");
            if (file2.exists() != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean checkTracerPid() {
        int intValue;
        Object intOrNull;
        int i3;
        int i2;
        Object next;
        int i;
        boolean it2;
        int strArr;
        String str;
        int i4;
        int i5;
        int i6;
        File file = new File("/proc/self/status");
        i3 = 0;
        i2 = 1;
        intOrNull = (Iterable)FilesKt.readLines$default(file, i3, i2, i3).iterator();
        i = 0;
        while (intOrNull.hasNext()) {
            next = intOrNull.next();
            strArr = 0;
            if (StringsKt.startsWith$default((String)next, "TracerPid:", i, 2, i3)) {
                break;
            } else {
            }
            i = 0;
        }
        strArr = new String[i2];
        strArr[i] = ":";
        intOrNull = StringsKt.split$default((CharSequence)(String)i3, strArr, false, 0, 6, 0);
        intOrNull = intOrNull.get(i2);
        intOrNull = StringsKt.trim((CharSequence)(String)intOrNull).toString();
        intOrNull = StringsKt.toIntOrNull(intOrNull);
        if (i3 != 0 && intOrNull != null && intOrNull != null && intOrNull != null && intOrNull != null) {
            strArr = new String[i2];
            strArr[i] = ":";
            intOrNull = StringsKt.split$default((CharSequence)i3, strArr, false, 0, 6, 0);
            if (intOrNull != null) {
                intOrNull = intOrNull.get(i2);
                if ((String)intOrNull != null) {
                    intOrNull = StringsKt.trim((CharSequence)(String)intOrNull).toString();
                    if (intOrNull != null) {
                        intOrNull = StringsKt.toIntOrNull(intOrNull);
                        if (intOrNull != null) {
                            intValue = intOrNull.intValue();
                        } else {
                            intValue = i;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (intValue != 0) {
        } else {
            i2 = i;
        }
        return i2;
    }

    public final MediaRecorder createRecorder() {
        MediaRecorder mediaRecorder = new MediaRecorder();
        return mediaRecorder;
    }

    public final String deobfuscate(String encoded) {
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        byte[] decode = Base64.decode(encoded, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
        String string = new String(decode, Charsets.UTF_8);
        return string;
    }

    public final boolean detectEmulator() {
        MaliciousPatterns$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new MaliciousPatterns$$ExternalSyntheticLambda0();
        return MaliciousPatterns.detectEmulator$lambda$2(LazyKt.lazy(externalSyntheticLambda0));
    }

    public final void disableComponent(Context ctx, Class<?> componentClass) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(componentClass, "componentClass");
        ComponentName componentName = new ComponentName(ctx, componentClass);
        ctx.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
    }

    public final java.lang.Process execCat() {
        java.lang.Process exec = Runtime.getRuntime().exec("cat /etc/passwd");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final String execCommand1(String cmd) {
        boolean bufferedReader;
        java.nio.charset.Charset uTF_8;
        Object inputStreamReader;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        java.io.InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
            inputStreamReader = bufferedReader;
        }
        return TextStreamsKt.readText((Reader)inputStreamReader);
    }

    public final String execCommand2(String cmd) {
        boolean bufferedReader;
        java.nio.charset.Charset uTF_8;
        Object inputStreamReader;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        String[] strArr = new String[3];
        java.io.InputStream inputStream = Runtime.getRuntime().exec("sh", "-c", cmd).getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
            inputStreamReader = bufferedReader;
        }
        return TextStreamsKt.readText((Reader)inputStreamReader);
    }

    public final String execCommand3(String cmd) {
        boolean bufferedReader;
        java.nio.charset.Charset uTF_8;
        Object inputStreamReader;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        java.io.InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
            inputStreamReader = bufferedReader;
        }
        return TextStreamsKt.readText((Reader)inputStreamReader);
    }

    public final java.lang.Process execDumpsys() {
        java.lang.Process exec = Runtime.getRuntime().exec("dumpsys");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execGetprop() {
        java.lang.Process exec = Runtime.getRuntime().exec("getprop");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execId() {
        java.lang.Process exec = Runtime.getRuntime().exec("id");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execLogcat() {
        java.lang.Process exec = Runtime.getRuntime().exec("logcat -d");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execLs() {
        java.lang.Process exec = Runtime.getRuntime().exec("ls");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execMount() {
        java.lang.Process exec = Runtime.getRuntime().exec("mount");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execPm() {
        java.lang.Process exec = Runtime.getRuntime().exec("pm list packages");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execPs() {
        java.lang.Process exec = Runtime.getRuntime().exec("ps");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final java.lang.Process execSu() {
        java.lang.Process exec = Runtime.getRuntime().exec("su");
        Intrinsics.checkNotNullExpressionValue(exec, "exec(...)");
        return exec;
    }

    public final String execWithProcessBuilder(String cmd) {
        boolean bufferedReader;
        java.nio.charset.Charset uTF_8;
        Object inputStreamReader;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        String[] strArr = new String[1];
        int i2 = 0;
        strArr[i2] = " ";
        ProcessBuilder processBuilder = new ProcessBuilder(StringsKt.split$default((CharSequence)cmd, strArr, i2, 0, 6, 0));
        java.io.InputStream inputStream = processBuilder.start().getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
            inputStreamReader = bufferedReader;
        }
        return TextStreamsKt.readText((Reader)inputStreamReader);
    }

    public final boolean executeRootCheck() {
        int i;
        java.lang.Process exec;
        boolean bufferedReader;
        java.nio.charset.Charset uTF_8;
        Object inputStreamReader;
        String[] strArr = new String[2];
        final int i3 = 1;
        strArr[i3] = "su";
        java.io.InputStream inputStream = Runtime.getRuntime().exec(strArr).getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
        } else {
            try {
                bufferedReader = new BufferedReader((BufferedReader)(Reader)inputStreamReader, 8192);
                inputStreamReader = bufferedReader;
                if (inputStreamReader.readLine() != null) {
                }
                i = i3;
                return i;
            }
        }
    }

    public final List<String> getAdSdkStrings() {
        return MaliciousPatterns.adSdkStrings;
    }

    public final int getCameraInfo() {
        return Camera.getNumberOfCameras();
    }

    public final String getClipboardData(Context ctx) {
        String string;
        Object primaryClip;
        int i;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Object systemService = ctx.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        primaryClip = (ClipboardManager)systemService.getPrimaryClip();
        primaryClip = primaryClip.getItemAt(0);
        primaryClip = primaryClip.getText();
        if (primaryClip != null && primaryClip != null && primaryClip != null) {
            primaryClip = primaryClip.getItemAt(0);
            if (primaryClip != null) {
                primaryClip = primaryClip.getText();
                if (primaryClip != null) {
                    string = primaryClip.toString();
                } else {
                    string = 0;
                }
            } else {
            }
        } else {
        }
        return string;
    }

    public final Method getHiddenApi(String className, String methodName) {
        Class forName;
        Method declaredMethod;
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Class.forName(className).getDeclaredMethod(methodName, new Class[0]).setAccessible(true);
        return declaredMethod;
    }

    public final String getTelephonyInfo(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Object systemService = ctx.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return (TelephonyManager)systemService.getNetworkOperatorName();
    }

    public final void hideAppIcon(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ComponentName componentName = new ComponentName(ctx, MainActivity.class);
        ctx.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
    }

    public final int hideFromRecents() {
        return i2 |= i;
    }

    public final boolean isBeingDebugged() {
        int i;
        boolean waitingForDebugger;
        if (!Debug.isDebuggerConnected()) {
            if (Debug.waitingForDebugger()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean isDebuggerConnected() {
        return Debug.isDebuggerConnected();
    }

    public final boolean isRooted() {
        int i2;
        int i;
        String str;
        boolean it2;
        int i3;
        File file;
        String[] strArr = new String[14];
        i2 = 0;
        strArr[i2] = "/system/bin/su";
        final int i5 = 1;
        strArr[i5] = "/system/xbin/su";
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
        String[] strArr2 = strArr;
        int i18 = 0;
        i = i2;
        while (i < strArr2.length) {
            i3 = 0;
            file = new File(strArr2[i]);
            i++;
        }
        return i2;
    }

    public final void killProcess(int pid) {
        Process.killProcess(pid);
    }

    public final void loadAndInvoke(Context ctx, String dexPath, String className, String methodName) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(dexPath, "dexPath");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        final int i2 = 0;
        DexClassLoader dexClassLoader = new DexClassLoader(dexPath, ctx.getCacheDir().getAbsolutePath(), i2, ctx.getClassLoader());
        int i = 0;
        dexClassLoader.loadClass(className).getDeclaredMethod(methodName, new Class[i]).invoke(i2, new Object[i]);
    }

    public final java.lang.ClassLoader loadDex1(Context ctx, String path) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(path, "path");
        DexClassLoader dexClassLoader = new DexClassLoader(path, ctx.getCacheDir().getAbsolutePath(), 0, ctx.getClassLoader());
        return (ClassLoader)dexClassLoader;
    }

    public final java.lang.ClassLoader loadDex2(Context ctx, String path) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(path, "path");
        DexClassLoader dexClassLoader = new DexClassLoader(path, ctx.getCodeCacheDir().getAbsolutePath(), 0, ctx.getClassLoader());
        return (ClassLoader)dexClassLoader;
    }

    public final java.lang.ClassLoader loadDex3(Context ctx, String path) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(path, "path");
        DexClassLoader dexClassLoader = new DexClassLoader(path, ctx.getDir("outdex", 0).getAbsolutePath(), 0, ctx.getClassLoader());
        return (ClassLoader)dexClassLoader;
    }

    public final java.lang.ClassLoader loadDex4(Context ctx, String path) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(path, "path");
        PathClassLoader pathClassLoader = new PathClassLoader(path, ctx.getClassLoader());
        return (ClassLoader)pathClassLoader;
    }

    public final java.lang.ClassLoader loadDexFromData(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        StringBuilder stringBuilder = new StringBuilder();
        DexClassLoader dexClassLoader = new DexClassLoader(stringBuilder.append(ctx.getFilesDir().getAbsolutePath()).append("/classes.dex").toString(), ctx.getCacheDir().getAbsolutePath(), 0, ctx.getClassLoader());
        return (ClassLoader)dexClassLoader;
    }

    public final java.lang.ClassLoader loadDexFromDownloads(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        DexClassLoader dexClassLoader = new DexClassLoader("/sdcard/Download/payload.dex", ctx.getCacheDir().getAbsolutePath(), 0, ctx.getClassLoader());
        return (ClassLoader)dexClassLoader;
    }

    public final List<java.lang.ClassLoader> loadMultipleDex(Context ctx, List<String> paths) {
        Object next;
        Object obj;
        int i;
        DexClassLoader dexClassLoader;
        String absolutePath;
        int i2;
        java.lang.ClassLoader classLoader;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Object obj2 = paths;
        final int i3 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)obj2, 10));
        final int i5 = 0;
        final Iterator iterator = obj2.iterator();
        for (Object next : iterator) {
            i = 0;
            dexClassLoader = new DexClassLoader((String)next, ctx.getCacheDir().getAbsolutePath(), 0, ctx.getClassLoader());
            (Collection)arrayList.add(dexClassLoader);
        }
        return (List)arrayList;
    }

    public final void loadNativeLibrary(String libName) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        System.loadLibrary(libName);
    }

    public final void loadNativeLibraryPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        System.load(path);
    }

    public final void reflectiveInvoke(String className, String methodName, Object... args) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Method declaredMethod = Class.forName(className).getDeclaredMethod(methodName, new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(0, Arrays.copyOf(args, args.length));
    }

    public final void requestLocation(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNull(ctx.getSystemService("location"), "null cannot be cast to non-null type android.location.LocationManager");
    }

    public final void showAppIcon(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ComponentName componentName = new ComponentName(ctx, MainActivity.class);
        int i = 1;
        ctx.getPackageManager().setComponentEnabledSetting(componentName, i, i);
    }

    public final byte[] xorDecrypt(byte[] data, byte[] key) {
        int i;
        int i2;
        byte b;
        int i4;
        byte b2;
        int i3;
        int i5;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = data;
        final int i6 = 0;
        ArrayList arrayList = new ArrayList(obj.length);
        Object obj2 = obj;
        final int i7 = 0;
        i = 0;
        i2 = 0;
        while (i2 < obj2.length) {
            i3 = 0;
            (Collection)arrayList.add(Byte.valueOf((byte)i5));
            i2++;
            i = i4;
        }
        return CollectionsKt.toByteArray((Collection)(List)arrayList);
    }
}
