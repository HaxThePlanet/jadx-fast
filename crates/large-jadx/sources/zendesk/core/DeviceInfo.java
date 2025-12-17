package zendesk.core;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import f.g.c.a;
import f.g.e.d;
import f.g.e.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
class DeviceInfo {

    private static final int BAD_VALUE = -1;
    private static final long BYTES_MULTIPLIER = 1024L;
    private static final int EXPECTED_TOKEN_COUNT = 3;
    private static final String LOG_TAG = "DeviceInfo";
    private static final String PLATFORM_ANDROID = "Android";
    private final ActivityManager activityManager;
    private final Context context;
    DeviceInfo(Context context) {
        super();
        this.context = context;
        this.activityManager = (ActivityManager)context.getSystemService("activity");
    }

    private long getAvailableInternalDiskMemory() {
        long availableBlocksLong;
        long blockSizeLong;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT < 18) {
            blockSizeLong = (long)blockSize;
            availableBlocksLong = (long)availableBlocks;
        } else {
            blockSizeLong = statFs.getBlockSizeLong();
            availableBlocksLong = statFs.getAvailableBlocksLong();
        }
        return availableBlocksLong *= blockSizeLong;
    }

    private int getBatteryLevel() {
        int intExtra;
        int str;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent registerReceiver = this.context.getApplicationContext().registerReceiver(0, intentFilter);
        if (registerReceiver != null) {
            intExtra = registerReceiver.getIntExtra("level", -1);
        }
        return intExtra;
    }

    private String getBytesInMb(long l) {
        return String.valueOf(l /= i);
    }

    public static Locale getCurrentLocale(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getResources().getConfiguration().getLocales().get(0);
        }
        return obj2.locale;
    }

    private long getDiskSize() {
        return getTotalInternalDiskSize();
    }

    private String getManufacturer() {
        String mANUFACTURER;
        int i;
        boolean equals;
        mANUFACTURER = Build.MANUFACTURER;
        if (!"unknown".equals(mANUFACTURER)) {
            if (g.e(mANUFACTURER)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        if (i != 0) {
            mANUFACTURER = "";
        }
        return mANUFACTURER;
    }

    private String getOS() {
        int i;
        boolean equals;
        int i2;
        String rELEASE = Build.VERSION.RELEASE;
        final int i3 = 0;
        final int i4 = 1;
        if (!"unknown".equals(rELEASE)) {
            if (g.e(rELEASE)) {
                i = i4;
            } else {
                i = i3;
            }
        } else {
        }
        final int sDK_INT = Build.VERSION.SDK_INT;
        i2 = sDK_INT == 0 ? i4 : i3;
        if (i != 0 && i2 != 0) {
            if (i2 != 0) {
                return "";
            }
        }
        Object[] arr = new Object[2];
        arr[i3] = rELEASE;
        arr[i4] = Integer.valueOf(sDK_INT);
        return String.format(Locale.US, "%s/%s", arr);
    }

    private long getTotalInternalDiskSize() {
        long blockCountLong;
        long blockSizeLong;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT < 18) {
            blockSizeLong = (long)blockSize;
            blockCountLong = (long)blockCount;
        } else {
            blockSizeLong = statFs.getBlockSizeLong();
            blockCountLong = statFs.getBlockCountLong();
        }
        return blockCountLong *= blockSizeLong;
    }

    private long getTotalMemory() {
        long totalMemoryCompat;
        String str;
        int i = 0;
        final String str2 = "DeviceInfo";
        if (Build.VERSION.SDK_INT >= 16) {
            a.b(str2, "Using getTotalMemoryApi() to determine memory", new Object[i]);
            totalMemoryCompat = getTotalMemoryApi();
        } else {
            a.b(str2, "Using getTotalMemoryCompat() to determine memory", new Object[i]);
            totalMemoryCompat = getTotalMemoryCompat();
        }
        return totalMemoryCompat;
    }

    private long getTotalMemoryApi() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private long getTotalMemoryCompat() {
        String str2;
        StringTokenizer stringTokenizer;
        int arr;
        int i2;
        Throwable th2;
        String line;
        int i;
        Throwable th;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder;
        FileReader fileReader;
        int countTokens;
        String arr2;
        String str;
        Throwable th3;
        str2 = "Failed to close /proc/meminfo file stream: ";
        final String str3 = "DeviceInfo";
        i2 = 0;
        int i3 = 0;
        fileReader = new FileReader("/proc/meminfo");
        bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();
        bufferedReader.close();
        stringTokenizer = new StringTokenizer(line);
        i = -1;
        if (stringTokenizer.countTokens() == 3) {
            stringTokenizer.nextToken();
            i = stringTokenizer;
        }
        return i;
    }

    private long getUsedDiskSpace() {
        return diskSize -= availableInternalDiskMemory;
    }

    private long getUsedMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return totalMemory -= availMem;
    }

    Map<String, String> getInfo() {
        boolean str;
        int bytesInMb2;
        int valueOf;
        boolean str2;
        boolean str5;
        String model;
        long usedMemory;
        int bytesInMb3;
        int bytesInMb;
        String str3;
        boolean str4;
        HashMap hashMap = new HashMap();
        String oS = getOS();
        model = getModel();
        usedMemory = getUsedMemory();
        final long totalMemory = getTotalMemory();
        final long diskSize = getDiskSize();
        final long usedDiskSpace = getUsedDiskSpace();
        final int batteryLevel = getBatteryLevel();
        final String locale = getLocale();
        final String manufacturer = getManufacturer();
        if (!g.e(oS)) {
            hashMap.put("os", oS);
        }
        if (!g.e(model)) {
            hashMap.put("model", model);
        }
        int i = -1;
        if (Long.compare(usedMemory, i) != 0) {
            hashMap.put("memory_used", getBytesInMb(usedMemory));
        }
        if (Long.compare(totalMemory, i) != 0) {
            hashMap.put("memory_total", getBytesInMb(totalMemory));
        }
        if (Long.compare(diskSize, i) != 0) {
            hashMap.put("disk_total", getBytesInMb(diskSize));
        }
        if (Long.compare(usedDiskSpace, i) != 0) {
            hashMap.put("disk_used", getBytesInMb(usedDiskSpace));
        }
        if (batteryLevel != -1) {
            hashMap.put("battery_level", String.valueOf(batteryLevel));
        }
        if (!g.e(locale)) {
            hashMap.put("sys_locale", locale);
        }
        if (!g.e(manufacturer)) {
            hashMap.put("manufacturer", manufacturer);
        }
        hashMap.put("platform", "Android");
        return hashMap;
    }

    String getLocale() {
        return d.d(Locale.getDefault());
    }

    String getModel() {
        boolean equals2;
        int i;
        boolean equals;
        int i2;
        String mODEL = Build.MODEL;
        String str3 = "unknown";
        final int i4 = 0;
        final int i5 = 1;
        if (!str3.equals(mODEL)) {
            if (g.e(mODEL)) {
                i2 = i5;
            } else {
                i2 = i4;
            }
        } else {
        }
        final String dEVICE = Build.DEVICE;
        if (!str3.equals(dEVICE)) {
            if (g.e(dEVICE)) {
                i = i5;
            } else {
                i = i4;
            }
        } else {
        }
        if (i2 != 0 && i != 0) {
            if (i != 0) {
                return "";
            }
        }
        if (mODEL.equals(dEVICE)) {
            return mODEL;
        }
        Object[] arr = new Object[2];
        arr[i4] = mODEL;
        arr[i5] = dEVICE;
        return String.format(Locale.US, "%s/%s", arr);
    }
}
