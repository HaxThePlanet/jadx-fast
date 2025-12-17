package com.google.firebase.perf.session.gauges;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class GaugeMetadataManager {

    private static final AndroidLogger logger;
    private final ActivityManager activityManager;
    private final Context appContext;
    private final String currentProcessName;
    private final ActivityManager.MemoryInfo memoryInfo;
    private final java.lang.Runtime runtime;
    static {
        GaugeMetadataManager.logger = AndroidLogger.getInstance();
    }

    GaugeMetadataManager(Context context) {
        super(Runtime.getRuntime(), context);
    }

    GaugeMetadataManager(java.lang.Runtime runtime, Context context2) {
        super();
        this.runtime = runtime;
        this.appContext = context2;
        Object obj1 = context2.getSystemService("activity");
        this.activityManager = (ActivityManager)obj1;
        ActivityManager.MemoryInfo obj2 = new ActivityManager.MemoryInfo();
        this.memoryInfo = obj2;
        obj1.getMemoryInfo(obj2);
        this.currentProcessName = getCurrentProcessName();
    }

    private String getCurrentProcessName() {
        Object runningAppProcesses;
        boolean next;
        int pid;
        runningAppProcesses = this.activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            runningAppProcesses = runningAppProcesses.iterator();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            }
        }
        return this.appContext.getPackageName();
    }

    public int getDeviceRamSizeKb() {
        if (Build.VERSION.SDK_INT >= 16) {
            long totalMem = memoryInfo.totalMem;
            return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(totalMem));
        }
        return readTotalRAM("/proc/meminfo");
    }

    public int getMaxAppJavaHeapMemoryKb() {
        long maxMemory = this.runtime.maxMemory();
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(maxMemory));
    }

    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        long l = (long)memoryClass;
        return Utils.saturatedIntCast(StorageUnit.MEGABYTES.toKilobytes(l));
    }

    public String getProcessName() {
        return this.currentProcessName;
    }

    int readTotalRAM(String string) {
        Throwable th;
        BufferedReader bufferedReader;
        Throwable logger;
        FileReader fileReader;
        int int;
        StringBuilder stringBuilder;
        String str;
        String obj7;
        final String str2 = "' file: ";
        final int i = 0;
        fileReader = new FileReader(string);
        bufferedReader = new BufferedReader(fileReader);
        fileReader = bufferedReader.readLine();
        while (fileReader != null) {
            fileReader = bufferedReader.readLine();
        }
        bufferedReader.close();
        try {
            return i;
        }
    }
}
