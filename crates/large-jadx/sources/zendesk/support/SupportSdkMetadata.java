package zendesk.support;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import f.g.c.a;
import f.g.e.d;
import f.g.e.g;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
class SupportSdkMetadata {

    private static final int BAD_VALUE = -1;
    private static final long BYTES_MULTIPLIER = 1024L;
    private static final String DEVICE_INFO_API_VERSION = "device_api";
    private static final String DEVICE_INFO_BATTERY = "device_battery";
    private static final String DEVICE_INFO_DEVICE_NAME = "device_name";
    private static final String DEVICE_INFO_LOW_MEMORY = "device_low_memory";
    private static final String DEVICE_INFO_MANUFACTURER = "device_manufacturer";
    private static final String DEVICE_INFO_MODEL_TYPE = "device_model";
    private static final String DEVICE_INFO_OS_VERSION = "device_os";
    private static final String DEVICE_INFO_TOTAL_MEMORY = "device_total_memory";
    private static final String DEVICE_INFO_USED_MEMORY = "device_used_memory";
    private static final int EXPECTED_TOKEN_COUNT = 3;
    private static final String LOG_TAG = "SupportSdkMetadata";
    private final ActivityManager activityManager;
    private final Context context;
    SupportSdkMetadata(Context context) {
        super();
        this.context = context;
        this.activityManager = (ActivityManager)context.getSystemService("activity");
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

    private String getModel() {
        boolean equals;
        int i;
        boolean equals2;
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

    private String getModelDeviceName() {
        return Build.DEVICE;
    }

    private long getTotalMemory() {
        long totalMemoryCompat;
        String str;
        int i = 0;
        final String str2 = "SupportSdkMetadata";
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
        if (Build.VERSION.SDK_INT < 16) {
            a.k("SupportSdkMetadata", "Sorry, this call is not available on your API level, please use getTotalMemory() instead", new Object[0]);
            return -1;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private long getTotalMemoryCompat() {
        String str;
        StringTokenizer stringTokenizer;
        int arr2;
        int i;
        Throwable th3;
        String line;
        int i2;
        Throwable th;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder;
        FileReader fileReader;
        int countTokens;
        String arr;
        String str2;
        Throwable th2;
        str = "Failed to close /proc/meminfo file stream: ";
        final String str3 = "SupportSdkMetadata";
        i = 0;
        int i3 = 0;
        fileReader = new FileReader("/proc/meminfo");
        bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();
        bufferedReader.close();
        stringTokenizer = new StringTokenizer(line);
        i2 = -1;
        if (stringTokenizer.countTokens() == 3) {
            stringTokenizer.nextToken();
            i2 = stringTokenizer;
        }
        return i2;
    }

    private long getUsedMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return totalMemory -= availMem;
    }

    private int getVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    private String getVersionName() {
        return Build.VERSION.RELEASE;
    }

    private boolean isLowMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    Map<String, String> getDeviceInfoAsMapForMetaData() {
        HashMap hashMap = new HashMap();
        hashMap.put("device_os", getVersionName());
        hashMap.put("device_api", String.valueOf(getVersionCode()));
        hashMap.put("device_model", getModel());
        hashMap.put("device_name", getModelDeviceName());
        String str5 = "device_manufacturer";
        hashMap.put(str5, getManufacturer());
        String str6 = "device_total_memory";
        hashMap.put(str6, getBytesInMb(getTotalMemory()));
        hashMap.put("device_used_memory", getBytesInMb(getUsedMemory()));
        hashMap.put("device_low_memory", String.valueOf(isLowMemory()));
        hashMap.put("device_battery", String.valueOf(getBatteryLevel()));
        return hashMap;
    }

    String getLocale() {
        return d.d(Locale.getDefault());
    }
}
