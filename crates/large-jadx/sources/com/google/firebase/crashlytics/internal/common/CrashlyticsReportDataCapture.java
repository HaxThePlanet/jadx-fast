package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class CrashlyticsReportDataCapture {

    private static final Map<String, Integer> ARCHITECTURES_BY_NAME = null;
    static final String GENERATOR = null;
    static final int GENERATOR_TYPE = 3;
    static final int REPORT_ANDROID_PLATFORM = 4;
    static final int SESSION_ANDROID_PLATFORM = 3;
    static final String SIGNAL_DEFAULT = "0";
    private final com.google.firebase.crashlytics.internal.common.AppData appData;
    private final Context context;
    private final com.google.firebase.crashlytics.internal.common.IdManager idManager;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    static {
        HashMap hashMap = new HashMap();
        CrashlyticsReportDataCapture.ARCHITECTURES_BY_NAME = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        int i4 = 0;
        hashMap.put("x86", Integer.valueOf(i4));
        int i5 = 1;
        hashMap.put("x86_64", Integer.valueOf(i5));
        Object[] arr = new Object[i5];
        arr[i4] = "18.2.4";
        CrashlyticsReportDataCapture.GENERATOR = String.format(Locale.US, "Crashlytics Android SDK/%s", arr);
    }

    public CrashlyticsReportDataCapture(Context context, com.google.firebase.crashlytics.internal.common.IdManager idManager2, com.google.firebase.crashlytics.internal.common.AppData appData3, StackTraceTrimmingStrategy stackTraceTrimmingStrategy4) {
        super();
        this.context = context;
        this.idManager = idManager2;
        this.appData = appData3;
        this.stackTraceTrimmingStrategy = stackTraceTrimmingStrategy4;
    }

    private CrashlyticsReport.Builder buildReportData() {
        return CrashlyticsReport.builder().setSdkVersion("18.2.4").setGmpAppId(appData.googleAppId).setInstallationUuid(this.idManager.getCrashlyticsInstallId()).setBuildVersion(appData2.versionCode).setDisplayVersion(appData3.versionName).setPlatform(4);
    }

    private static int getDeviceArchitecture() {
        String cPU_ABI = Build.CPU_ABI;
        final int i = 7;
        if (TextUtils.isEmpty(cPU_ABI)) {
            return i;
        }
        Object obj = CrashlyticsReportDataCapture.ARCHITECTURES_BY_NAME.get(cPU_ABI.toLowerCase(Locale.US));
        if ((Integer)obj == null) {
            return i;
        }
        return (Integer)obj.intValue();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage populateBinaryImageData() {
        int i = 0;
        return CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder().setBaseAddress(i).setSize(i).setName(appData.packageName).setUuid(appData2.buildId).build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> populateBinaryImagesList() {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage[] arr = new CrashlyticsReport.Session.Event.Application.Execution.BinaryImage[1];
        return ImmutableList.from(populateBinaryImageData());
    }

    private CrashlyticsReport.Session.Event.Application populateEventApplicationData(int i, CrashlyticsReport.ApplicationExitInfo crashlyticsReport$ApplicationExitInfo2) {
        int i2;
        i2 = applicationExitInfo2.getImportance() != 100 ? 1 : 0;
        return CrashlyticsReport.Session.Event.Application.builder().setBackground(Boolean.valueOf(i2)).setUiOrientation(i).setExecution(populateExecutionData(applicationExitInfo2)).build();
    }

    private CrashlyticsReport.Session.Event.Application populateEventApplicationData(int i, TrimmedThrowableData trimmedThrowableData2, Thread thread3, int i4, int i5, boolean z6) {
        int i2;
        int valueOf;
        Context context;
        android.app.ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(appData.packageName, this.context);
        if (appProcessInfo != null) {
            i2 = appProcessInfo.importance != 100 ? 1 : 0;
            valueOf = Boolean.valueOf(i2);
        } else {
            valueOf = 0;
        }
        return CrashlyticsReport.Session.Event.Application.builder().setBackground(valueOf).setUiOrientation(i).setExecution(this.populateExecutionData(trimmedThrowableData2, thread3, i4, i5, z6)).build();
    }

    private CrashlyticsReport.Session.Event.Device populateEventDeviceData(int i) {
        Double valueOf;
        com.google.firebase.crashlytics.internal.common.BatteryState batteryState = BatteryState.get(this.context);
        Float batteryLevel = batteryState.getBatteryLevel();
        if (batteryLevel != null) {
            valueOf = Double.valueOf(batteryLevel.doubleValue());
        } else {
            valueOf = 0;
        }
        return CrashlyticsReport.Session.Event.Device.builder().setBatteryLevel(valueOf).setBatteryVelocity(batteryState.getBatteryVelocity()).setProximityOn(CommonUtils.getProximitySensorEnabled(this.context)).setOrientation(i).setRamUsed(totalRamInBytes -= freeRamInBytes).setDiskUsed(CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath())).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception populateExceptionData(TrimmedThrowableData trimmedThrowableData, int i2, int i3) {
        return populateExceptionData(trimmedThrowableData, i2, i3, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception populateExceptionData(TrimmedThrowableData trimmedThrowableData, int i2, int i3, int i4) {
        java.lang.StackTraceElement[] stacktrace;
        int i;
        TrimmedThrowableData cause;
        Object obj6;
        int obj9;
        if (trimmedThrowableData.stacktrace != null) {
        } else {
            stacktrace = new StackTraceElement[0];
        }
        obj6 = trimmedThrowableData.cause;
        if (i4 >= i3) {
            cause = obj6;
            while (cause != null) {
                cause = cause.cause;
                i++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder overflowCount = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder().setType(trimmedThrowableData.className).setReason(trimmedThrowableData.localizedMessage).setFrames(ImmutableList.from(populateFramesList(stacktrace, i2))).setOverflowCount(i);
        if (obj6 != null && i == 0) {
            if (i == 0) {
                overflowCount.setCausedBy(populateExceptionData(obj6, i2, i3, i4++));
            }
        }
        return overflowCount.build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution populateExecutionData(CrashlyticsReport.ApplicationExitInfo crashlyticsReport$ApplicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.Execution.builder().setAppExitInfo(applicationExitInfo).setSignal(populateSignalData()).setBinaries(populateBinaryImagesList()).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution populateExecutionData(TrimmedThrowableData trimmedThrowableData, Thread thread2, int i3, int i4, boolean z5) {
        return CrashlyticsReport.Session.Event.Application.Execution.builder().setThreads(populateThreadsList(trimmedThrowableData, thread2, i3, z5)).setException(populateExceptionData(trimmedThrowableData, i3, i4)).setSignal(populateSignalData()).setBinaries(populateBinaryImagesList()).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame populateFrameData(java.lang.StackTraceElement stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder2) {
        int nativeMethod;
        int i;
        long l;
        boolean nativeMethod2;
        int obj8;
        i = 0;
        if (stackTraceElement.isNativeMethod()) {
            l = Math.max((long)nativeMethod, obj4);
        } else {
            l = i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getClassName());
        stringBuilder.append(".");
        stringBuilder.append(stackTraceElement.getMethodName());
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            if (stackTraceElement.getLineNumber() > 0) {
                i = (long)obj8;
            }
        }
        return builder2.setPc(l).setSymbol(stringBuilder.toString()).setFile(stackTraceElement.getFileName()).setOffset(i).build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> populateFramesList(java.lang.StackTraceElement[] stackTraceElementArr, int i2) {
        int i;
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame populateFrameData;
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder importance;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < stackTraceElementArr.length) {
            arrayList.add(populateFrameData(stackTraceElementArr[i], CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder().setImportance(i2)));
            i++;
        }
        return ImmutableList.from(arrayList);
    }

    private CrashlyticsReport.Session.Application populateSessionApplicationData() {
        CrashlyticsReport.Session.Application.Builder developmentPlatform;
        CrashlyticsReport.Session.Application.Builder installationUuid = CrashlyticsReport.Session.Application.builder().setIdentifier(this.idManager.getAppIdentifier()).setVersion(appData.versionCode).setDisplayVersion(appData2.versionName).setInstallationUuid(this.idManager.getCrashlyticsInstallId());
        String unityVersion = appData3.unityVersionProvider.getUnityVersion();
        if (unityVersion != null) {
            installationUuid.setDevelopmentPlatform("Unity").setDevelopmentPlatformVersion(unityVersion);
        }
        return installationUuid.build();
    }

    private CrashlyticsReport.Session populateSessionData(String string, long l2) {
        return CrashlyticsReport.Session.builder().setStartedAt(l2).setIdentifier(string).setGenerator(CrashlyticsReportDataCapture.GENERATOR).setApp(populateSessionApplicationData()).setOs(populateSessionOperatingSystemData()).setDevice(populateSessionDeviceData()).setGeneratorType(3).build();
    }

    private CrashlyticsReport.Session.Device populateSessionDeviceData() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return CrashlyticsReport.Session.Device.builder().setArch(CrashlyticsReportDataCapture.getDeviceArchitecture()).setModel(Build.MODEL).setCores(Runtime.getRuntime().availableProcessors()).setRam(CommonUtils.getTotalRamInBytes()).setDiskSpace(l *= l2).setSimulator(CommonUtils.isEmulator(this.context)).setState(CommonUtils.getDeviceState(this.context)).setManufacturer(Build.MANUFACTURER).setModelClass(Build.PRODUCT).build();
    }

    private CrashlyticsReport.Session.OperatingSystem populateSessionOperatingSystemData() {
        return CrashlyticsReport.Session.OperatingSystem.builder().setPlatform(3).setVersion(Build.VERSION.RELEASE).setBuildVersion(Build.VERSION.CODENAME).setJailbroken(CommonUtils.isRooted(this.context)).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Signal populateSignalData() {
        String str = "0";
        return CrashlyticsReport.Session.Event.Application.Execution.Signal.builder().setName(str).setCode(str).setAddress(0).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread populateThreadData(Thread thread, java.lang.StackTraceElement[] stackTraceElement2Arr2) {
        return populateThreadData(thread, stackTraceElement2Arr2, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread populateThreadData(Thread thread, java.lang.StackTraceElement[] stackTraceElement2Arr2, int i3) {
        return CrashlyticsReport.Session.Event.Application.Execution.Thread.builder().setName(thread.getName()).setImportance(i3).setFrames(ImmutableList.from(populateFramesList(stackTraceElement2Arr2, i3))).build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> populateThreadsList(TrimmedThrowableData trimmedThrowableData, Thread thread2, int i3, boolean z4) {
        boolean stackTraceTrimmingStrategy;
        Object obj3;
        int obj5;
        Object obj6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(populateThreadData(thread2, trimmedThrowableData.stacktrace, i3));
        if (z4 != null) {
            obj3 = Thread.getAllStackTraces().entrySet().iterator();
            while (obj3.hasNext()) {
                obj5 = obj3.next();
                obj6 = (Map.Entry)obj5.getKey();
                if (!(Thread)obj6.equals(thread2)) {
                }
                arrayList.add(populateThreadData(obj6, this.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[])obj5.getValue())));
            }
        }
        return ImmutableList.from(arrayList);
    }

    public CrashlyticsReport.Session.Event captureAnrEventData(CrashlyticsReport.ApplicationExitInfo crashlyticsReport$ApplicationExitInfo) {
        int orientation = configuration.orientation;
        return CrashlyticsReport.Session.Event.builder().setType("anr").setTimestamp(applicationExitInfo.getTimestamp()).setApp(populateEventApplicationData(orientation, applicationExitInfo)).setDevice(populateEventDeviceData(orientation)).build();
    }

    public CrashlyticsReport.Session.Event captureEventData(Throwable throwable, Thread thread2, String string3, long l4, int i5, int i6, boolean z7) {
        final Object obj2 = this;
        final int orientation = configuration.orientation;
        Throwable th = throwable;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(throwable, obj2.stackTraceTrimmingStrategy);
        String str = string3;
        long l = l4;
        return CrashlyticsReport.Session.Event.builder().setType(string3).setTimestamp(l4).setApp(this.populateEventApplicationData(orientation, trimmedThrowableData, thread2, i6, z7, obj18)).setDevice(populateEventDeviceData(orientation)).build();
    }

    public CrashlyticsReport captureReportData(String string, long l2) {
        return buildReportData().setSession(populateSessionData(string, l2)).build();
    }
}
