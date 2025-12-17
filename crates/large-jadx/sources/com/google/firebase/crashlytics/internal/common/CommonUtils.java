package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class CommonUtils {

    static final int BYTES_IN_A_GIGABYTE = 1073741824;
    static final int BYTES_IN_A_KILOBYTE = 1024;
    static final int BYTES_IN_A_MEGABYTE = 1048576;
    public static final int DEVICE_STATE_BETAOS = 8;
    public static final int DEVICE_STATE_COMPROMISEDLIBRARIES = 32;
    public static final int DEVICE_STATE_DEBUGGERATTACHED = 4;
    public static final int DEVICE_STATE_ISSIMULATOR = 1;
    public static final int DEVICE_STATE_JAILBROKEN = 2;
    public static final int DEVICE_STATE_VENDORINTERNAL = 16;
    private static final String GOLDFISH = "goldfish";
    private static final char[] HEX_VALUES = null;
    static final String LEGACY_MAPPING_FILE_ID_RESOURCE_NAME = "com.crashlytics.android.build_id";
    public static final String LEGACY_SHARED_PREFS_NAME = "com.crashlytics.prefs";
    static final String MAPPING_FILE_ID_RESOURCE_NAME = "com.google.firebase.crashlytics.mapping_file_id";
    private static final String RANCHU = "ranchu";
    private static final String SDK = "sdk";
    private static final String SHA1_INSTANCE = "SHA-1";
    public static final String SHARED_PREFS_NAME = "com.google.firebase.crashlytics";
    private static final long UNCALCULATED_TOTAL_RAM = -1L;
    private static long totalRamInBytes;

    static enum Architecture {

        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        static com.google.firebase.crashlytics.internal.common.CommonUtils.Architecture getValue() {
            Object uNKNOWN;
            String cPU_ABI = Build.CPU_ABI;
            if (TextUtils.isEmpty(cPU_ABI)) {
                Logger.getLogger().v("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return CommonUtils.Architecture.UNKNOWN;
            }
            if ((CommonUtils.Architecture)CommonUtils.Architecture.matcher.get(cPU_ABI.toLowerCase(Locale.US)) == null) {
                uNKNOWN = CommonUtils.Architecture.UNKNOWN;
            }
            return uNKNOWN;
        }
    }
    static {
        char[] cArr = new char[16];
        cArr = new short[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        CommonUtils.HEX_VALUES = cArr;
        CommonUtils.totalRamInBytes = -1;
    }

    public static long calculateFreeRamInBytes(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        (ActivityManager)context.getSystemService("activity").getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long calculateUsedDiskSpaceInBytes(String string) {
        StatFs statFs = new StatFs(string);
        long l = (long)obj7;
        return i2 -= i;
    }

    public static boolean canTryConnection(Context context) {
        boolean checkPermission;
        int i;
        NetworkInfo obj2;
        i = 1;
        if (CommonUtils.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            obj2 = (ConnectivityManager)context.getSystemService("connectivity").getActiveNetworkInfo();
            if (obj2 != null && obj2.isConnectedOrConnecting()) {
                if (obj2.isConnectedOrConnecting()) {
                } else {
                    i = 0;
                }
            } else {
            }
        }
        return i;
    }

    public static boolean checkPermission(Context context, String string2) {
        int obj0;
        obj0 = context.checkCallingOrSelfPermission(string2) == 0 ? 1 : 0;
        return obj0;
    }

    public static void closeOrLog(Closeable closeable, String string2) {
        Logger logger;
        Throwable obj1;
        if (closeable != null) {
            closeable.close();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
    }

    static long convertMemInfoToBytes(String string, String string2, int i3) {
        return obj2 *= l;
    }

    public static String createInstanceIdFrom(String... stringArr) {
        int sha1;
        int length2;
        boolean next;
        int length;
        int i;
        Object lowerCase;
        Locale locale;
        String str;
        String obj7;
        sha1 = 0;
        if (stringArr != null) {
            if (stringArr.length == 0) {
            } else {
                ArrayList arrayList = new ArrayList();
                i = 0;
                while (i < stringArr.length) {
                    lowerCase = stringArr[i];
                    if (lowerCase != null) {
                    }
                    i++;
                    arrayList.add(lowerCase.replace("-", "").toLowerCase(Locale.US));
                }
                Collections.sort(arrayList);
                obj7 = new StringBuilder();
                Iterator iterator = arrayList.iterator();
                for (String length : iterator) {
                    obj7.append(length);
                }
                obj7 = obj7.toString();
                if (obj7.length() > 0) {
                    sha1 = CommonUtils.sha1(obj7);
                }
            }
        }
        return sha1;
    }

    public static String extractFieldFromSystemFile(File file, String string2) {
        Closeable closeable;
        boolean bufferedReader;
        Closeable closeable2;
        int i;
        Object fileReader;
        StringBuilder stringBuilder;
        String str;
        Object obj6;
        Object obj7;
        i = 0;
        if (file.exists() != null) {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader, 1024);
            fileReader = bufferedReader.readLine();
            while (fileReader != null) {
                fileReader = Pattern.compile("\\s*:\\s*").split(fileReader, 2);
                str = 1;
                if (fileReader.length > str) {
                    break;
                } else {
                }
                fileReader = bufferedReader.readLine();
                if (fileReader[0].equals(string2) != null) {
                    break;
                } else {
                }
            }
            CommonUtils.closeOrLog(bufferedReader, "Failed to close system file reader.");
        }
        return i;
    }

    public static ActivityManager.RunningAppProcessInfo getAppProcessInfo(String string, Context context2) {
        String next;
        boolean equals;
        Object obj3;
        obj3 = (ActivityManager)context2.getSystemService("activity").getRunningAppProcesses();
        if (obj3 != null) {
            obj3 = obj3.iterator();
            for (ActivityManager.RunningAppProcessInfo next : obj3) {
            }
            next = 0;
        } else {
        }
        return next;
    }

    public static boolean getBooleanResourceValue(Context context, String string2, boolean z3) {
        Object resources;
        int resourcesIdentifier;
        String obj3;
        resources = context.getResources();
        resourcesIdentifier = CommonUtils.getResourcesIdentifier(context, string2, "bool");
        if (context != null && resources != null && resourcesIdentifier > 0) {
            resources = context.getResources();
            if (resources != null) {
                resourcesIdentifier = CommonUtils.getResourcesIdentifier(context, string2, "bool");
                if (resourcesIdentifier > 0) {
                    return resources.getBoolean(resourcesIdentifier);
                }
                obj3 = CommonUtils.getResourcesIdentifier(context, string2, "string");
                if (obj3 > 0) {
                    return Boolean.parseBoolean(context.getString(obj3));
                }
            }
        }
        return z3;
    }

    public static int getCpuArchitectureInt() {
        return CommonUtils.Architecture.getValue().ordinal();
    }

    public static int getDeviceState(Context context) {
        int i;
        i = CommonUtils.isEmulator(context) ? 1 : 0;
        if (CommonUtils.isRooted(context)) {
            i |= 2;
        }
        if (CommonUtils.isDebuggerAttached()) {
            i |= 4;
        }
        return i;
    }

    public static SharedPreferences getLegacySharedPrefs(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String getMappingFileId(Context context) {
        int resourcesIdentifier;
        String obj2;
        final String str3 = "string";
        if (CommonUtils.getResourcesIdentifier(context, "com.google.firebase.crashlytics.mapping_file_id", str3) == null) {
            resourcesIdentifier = CommonUtils.getResourcesIdentifier(context, "com.crashlytics.android.build_id", str3);
        }
        if (resourcesIdentifier != 0) {
            obj2 = context.getResources().getString(resourcesIdentifier);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public static boolean getProximitySensorEnabled(Context context) {
        int i;
        if (CommonUtils.isEmulator(context)) {
            return 0;
        }
        if ((SensorManager)context.getSystemService("sensor").getDefaultSensor(8) != null) {
            i = 1;
        }
        return i;
    }

    public static String getResourcePackageName(Context context) {
        String resourcePackageName;
        boolean equals;
        int icon = applicationInfo.icon;
        if (icon > 0) {
            if ("android".equals(context.getResources().getResourcePackageName(icon))) {
                resourcePackageName = context.getPackageName();
            }
        } else {
            resourcePackageName = context.getPackageName();
        }
        return resourcePackageName;
    }

    public static int getResourcesIdentifier(Context context, String string2, String string3) {
        return context.getResources().getIdentifier(string2, string3, CommonUtils.getResourcePackageName(context));
    }

    public static SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    public static String getStringsFileValue(Context context, String string2) {
        final int obj2 = CommonUtils.getResourcesIdentifier(context, string2, "string");
        if (obj2 > 0) {
            return context.getString(obj2);
        }
        return "";
    }

    public static long getTotalRamInBytes() {
        int convertMemInfoToBytes;
        int fieldFromSystemFile;
        Throwable logger;
        Logger logger2;
        Object stringBuilder;
        String str;
        final Class<com.google.firebase.crashlytics.internal.common.CommonUtils> obj = CommonUtils.class;
        synchronized (obj) {
            convertMemInfoToBytes = 0;
            File file = new File("/proc/meminfo");
            fieldFromSystemFile = CommonUtils.extractFieldFromSystemFile(file, "MemTotal");
            if (TextUtils.isEmpty(fieldFromSystemFile) == null) {
                fieldFromSystemFile = fieldFromSystemFile.toUpperCase(Locale.US);
                if (fieldFromSystemFile.endsWith("KB") != null) {
                    try {
                        convertMemInfoToBytes = CommonUtils.convertMemInfoToBytes(fieldFromSystemFile, "KB", 1024);
                        if (fieldFromSystemFile.endsWith("MB") != null) {
                        } else {
                        }
                        convertMemInfoToBytes = CommonUtils.convertMemInfoToBytes(fieldFromSystemFile, "MB", 1048576);
                        if (fieldFromSystemFile.endsWith("GB") != null) {
                        } else {
                        }
                        convertMemInfoToBytes = CommonUtils.convertMemInfoToBytes(fieldFromSystemFile, "GB", 1073741824);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Unexpected meminfo format while computing RAM: ");
                        stringBuilder2.append(fieldFromSystemFile);
                        Logger.getLogger().w(stringBuilder2.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected meminfo format while computing RAM: ");
                        stringBuilder.append(string);
                        String string = stringBuilder.toString();
                        Logger.getLogger().e(string, logger);
                        CommonUtils.totalRamInBytes = convertMemInfoToBytes;
                        return CommonUtils.totalRamInBytes;
                        throw th;
                    } catch (java.lang.NumberFormatException numberFormat) {
                    } catch (Throwable th1) {
                    }
                } else {
                }
            }
        }
    }

    private static String hash(String string, String string2) {
        return CommonUtils.hash(string.getBytes(), string2);
    }

    private static String hash(byte[] bArr, String string2) {
        try {
            final MessageDigest obj4 = MessageDigest.getInstance(string2);
            obj4.update(bArr);
            return CommonUtils.hexify(obj4.digest());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create hashing algorithm: ");
            stringBuilder.append(string2);
            string2 = ", returning empty string.";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            Logger.getLogger().e(string2, bArr);
            bArr = "";
            return bArr;
        }
    }

    public static String hexify(byte[] bArr) {
        int i;
        char c2;
        int i2;
        char[] hEX_VALUES;
        char c;
        char[] cArr = new char[length *= 2];
        i = 0;
        for (byte b : bArr) {
            b &= 255;
            int i6 = i * 2;
            hEX_VALUES = CommonUtils.HEX_VALUES;
            cArr[i6] = hEX_VALUES[i4 >>> 4];
            cArr[i6++] = hEX_VALUES[i4 &= 15];
        }
        String obj6 = new String(cArr);
        return obj6;
    }

    public static boolean isAppDebuggable(Context context) {
        int obj0;
        obj0 = obj0 &= 2 != 0 ? 1 : 0;
        return obj0;
    }

    public static boolean isDebuggerAttached() {
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

    public static boolean isEmulator(Context context) {
        boolean hARDWARE;
        String contains;
        int obj2;
        hARDWARE = Build.HARDWARE;
        if (!Build.PRODUCT.contains("sdk") && !hARDWARE.contains("goldfish") && !hARDWARE.contains("ranchu")) {
            hARDWARE = Build.HARDWARE;
            if (!hARDWARE.contains("goldfish")) {
                if (!hARDWARE.contains("ranchu")) {
                    if (Settings.Secure.getString(context.getContentResolver(), "android_id") == null) {
                        obj2 = 1;
                    } else {
                        obj2 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Deprecated
    public static boolean isLoggingEnabled(Context context) {
        return 0;
    }

    public static boolean isRooted(Context context) {
        String tAGS;
        String str;
        boolean obj3;
        obj3 = CommonUtils.isEmulator(context);
        tAGS = Build.TAGS;
        final int i = 1;
        if (obj3 == null && tAGS != null && tAGS.contains("test-keys")) {
            if (tAGS != null) {
                if (tAGS.contains("test-keys")) {
                    return i;
                }
            }
        }
        File file = new File("/system/app/Superuser.apk");
        if (file.exists() != null) {
            return i;
        }
        File file2 = new File("/system/xbin/su");
        if (obj3 == null && file2.exists() != null) {
            if (file2.exists() != null) {
                return i;
            }
        }
        return 0;
    }

    public static String padWithZerosToMaxIntWidth(int i) {
        if (i < 0) {
        } else {
            Object[] arr = new Object[1];
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("value must be zero or greater");
        throw obj3;
    }

    public static String sha1(String string) {
        return CommonUtils.hash(string, "SHA-1");
    }

    public static String streamToString(InputStream inputStream) {
        String obj1;
        Scanner scanner = new Scanner(inputStream);
        obj1 = scanner.useDelimiter("\\A");
        if (obj1.hasNext()) {
            obj1 = obj1.next();
        } else {
            obj1 = "";
        }
        return obj1;
    }
}
