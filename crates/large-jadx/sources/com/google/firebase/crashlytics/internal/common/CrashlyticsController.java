package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
class CrashlyticsController {

    static final FilenameFilter APP_EXCEPTION_MARKER_FILTER = null;
    static final String APP_EXCEPTION_MARKER_PREFIX = ".ae";
    static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
    static final String FIREBASE_CRASH_TYPE = "fatal";
    static final int FIREBASE_CRASH_TYPE_FATAL = 1;
    static final String FIREBASE_TIMESTAMP = "timestamp";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    static final String NATIVE_SESSION_DIR = "native-sessions";
    private final AnalyticsEventLogger analyticsEventLogger;
    private final com.google.firebase.crashlytics.internal.common.AppData appData;
    private final com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker backgroundWorker;
    final AtomicBoolean checkForUnsentReportsCalled;
    private final Context context;
    private com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler crashHandler;
    private final com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker crashMarker;
    private final com.google.firebase.crashlytics.internal.common.DataCollectionArbiter dataCollectionArbiter;
    private final FileStore fileStore;
    private final com.google.firebase.crashlytics.internal.common.IdManager idManager;
    private final LogFileManager.DirectoryProvider logFileDirectoryProvider;
    private final LogFileManager logFileManager;
    private final CrashlyticsNativeComponent nativeComponent;
    final k<Boolean> reportActionProvided;
    private final com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator reportingCoordinator;
    private final String unityVersion;
    final k<Boolean> unsentReportsAvailable;
    final k<Void> unsentReportsHandled;
    private final com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata;
    static {
        CrashlyticsController.APP_EXCEPTION_MARKER_FILTER = a.a;
    }

    CrashlyticsController(Context context, com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker crashlyticsBackgroundWorker2, com.google.firebase.crashlytics.internal.common.IdManager idManager3, com.google.firebase.crashlytics.internal.common.DataCollectionArbiter dataCollectionArbiter4, FileStore fileStore5, com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker crashlyticsFileMarker6, com.google.firebase.crashlytics.internal.common.AppData appData7, com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata8, LogFileManager logFileManager9, LogFileManager.DirectoryProvider logFileManager$DirectoryProvider10, com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator sessionReportingCoordinator11, CrashlyticsNativeComponent crashlyticsNativeComponent12, AnalyticsEventLogger analyticsEventLogger13) {
        super();
        k kVar = new k();
        this.unsentReportsAvailable = kVar;
        k kVar2 = new k();
        this.reportActionProvided = kVar2;
        k kVar3 = new k();
        this.unsentReportsHandled = kVar3;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.checkForUnsentReportsCalled = atomicBoolean;
        this.context = context;
        this.backgroundWorker = crashlyticsBackgroundWorker2;
        this.idManager = idManager3;
        this.dataCollectionArbiter = dataCollectionArbiter4;
        this.fileStore = fileStore5;
        this.crashMarker = crashlyticsFileMarker6;
        this.appData = appData7;
        this.userMetadata = userMetadata8;
        this.logFileManager = logFileManager9;
        this.logFileDirectoryProvider = directoryProvider10;
        this.nativeComponent = crashlyticsNativeComponent12;
        this.unityVersion = appData7.unityVersionProvider.getUnityVersion();
        this.analyticsEventLogger = analyticsEventLogger13;
        this.reportingCoordinator = sessionReportingCoordinator11;
    }

    static boolean a(File file, String string2) {
        return string2.startsWith(".ae");
    }

    static long access$000(long l) {
        return CrashlyticsController.getTimestampSeconds(l);
    }

    static String access$100(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        return crashlyticsController.getCurrentSessionId();
    }

    static LogFileManager access$1000(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        return crashlyticsController.logFileManager;
    }

    static AnalyticsEventLogger access$1100(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        return crashlyticsController.analyticsEventLogger;
    }

    static com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker access$200(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        return crashlyticsController.crashMarker;
    }

    static com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator access$300(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        return crashlyticsController.reportingCoordinator;
    }

    static void access$400(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController, long l2) {
        crashlyticsController.doWriteAppExceptionMarker(l2);
    }

    static void access$500(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        crashlyticsController.doOpenSession();
    }

    static com.google.firebase.crashlytics.internal.common.DataCollectionArbiter access$600(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        return crashlyticsController.dataCollectionArbiter;
    }

    static com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker access$700(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        return crashlyticsController.backgroundWorker;
    }

    static j access$800(com.google.firebase.crashlytics.internal.common.CrashlyticsController crashlyticsController) {
        return crashlyticsController.logAnalyticsAppExceptionEvents();
    }

    static void access$900(File[] fileArr) {
        CrashlyticsController.deleteFiles(fileArr);
    }

    private void cacheKeyData(Map<String, String> map, boolean z2) {
        CrashlyticsController.8 anon = new CrashlyticsController.8(this, map, z2);
        this.backgroundWorker.submit(anon);
    }

    private void cacheUserData(com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata) {
        CrashlyticsController.7 anon = new CrashlyticsController.7(this, userMetadata);
        this.backgroundWorker.submit(anon);
    }

    private static StaticSessionData.AppData createAppData(com.google.firebase.crashlytics.internal.common.IdManager idManager, com.google.firebase.crashlytics.internal.common.AppData appData2, String string3) {
        return StaticSessionData.AppData.create(idManager.getAppIdentifier(), appData2.versionCode, appData2.versionName, idManager.getCrashlyticsInstallId(), DeliveryMechanism.determineFrom(appData2.installerPackageName).getId(), string3);
    }

    private static StaticSessionData.DeviceData createDeviceData(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return StaticSessionData.DeviceData.create(CommonUtils.getCpuArchitectureInt(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.getTotalRamInBytes(), obj9, l * l2, obj11, CommonUtils.isEmulator(context), CommonUtils.getDeviceState(context));
    }

    private static StaticSessionData.OsData createOsData(Context context) {
        return StaticSessionData.OsData.create(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.isRooted(context));
    }

    private static void deleteFiles(File[] fileArr) {
        int i;
        Object obj;
        if (fileArr == null) {
        }
        i = 0;
        while (i < fileArr.length) {
            fileArr[i].delete();
            i++;
        }
    }

    private void doCloseSessions(boolean z, SettingsDataProvider settingsDataProvider2) {
        String str;
        int obj4;
        boolean obj5;
        List listSortedOpenSessionIds = this.reportingCoordinator.listSortedOpenSessionIds();
        if (listSortedOpenSessionIds.size() <= z) {
            Logger.getLogger().v("No open sessions to be closed.");
        }
        Object obj = listSortedOpenSessionIds.get(z);
        if (obj5.collectAnrs) {
            writeApplicationExitInfoEventIfRelevant((String)obj);
        } else {
            Logger.getLogger().v("ANR feature disabled.");
        }
        if (this.nativeComponent.hasCrashDataForSession(obj)) {
            finalizePreviousNativeSession(obj);
            this.nativeComponent.finalizeSession(obj);
        }
        obj5 = 0;
        if (z != 0) {
            obj5 = obj4;
        }
        this.reportingCoordinator.finalizeSessions(CrashlyticsController.getCurrentTimestampSeconds(), obj);
    }

    private void doOpenSession() {
        final long currentTimestampSeconds = CrashlyticsController.getCurrentTimestampSeconds();
        CLSUUID clsuuid = new CLSUUID(this.idManager);
        final String string2 = clsuuid.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Opening a new session with ID ");
        stringBuilder.append(string2);
        Logger.getLogger().d(stringBuilder.toString());
        Object[] arr = new Object[1];
        final CrashlyticsNativeComponent nativeComponent = this.nativeComponent;
        nativeComponent.prepareNativeSession(string2, String.format(Locale.US, "Crashlytics Android SDK/%s", CrashlyticsCore.getVersion()), currentTimestampSeconds, nativeComponent);
        this.logFileManager.setCurrentSession(string2);
        this.reportingCoordinator.onBeginSession(string2, currentTimestampSeconds);
    }

    private void doWriteAppExceptionMarker(long l) {
        File file;
        String obj5;
        Logger obj6;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".ae");
            stringBuilder.append(l);
            file = new File(getFilesDir(), stringBuilder.toString());
            file.createNewFile();
            obj6 = Logger.getLogger();
            obj6.w("Could not create app exception marker file.", l);
        }
    }

    private static File[] ensureFileArrayNotNull(File[] fileArr) {
        File[] obj0;
        if (fileArr == null) {
            obj0 = new File[0];
        }
        return obj0;
    }

    private void finalizePreviousNativeSession(String string) {
        String exists;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Finalizing native report for session ");
        stringBuilder.append(string);
        Logger.getLogger().v(stringBuilder.toString());
        NativeSessionFileProvider sessionFileProvider = this.nativeComponent.getSessionFileProvider(string);
        File minidumpFile = sessionFileProvider.getMinidumpFile();
        if (minidumpFile != null) {
            exists = minidumpFile.exists();
            if (!exists) {
            } else {
                LogFileManager logFileManager = new LogFileManager(this.context, this.logFileDirectoryProvider, string);
                File file = new File(getNativeSessionFilesDir(), string);
                if (file.mkdirs() == null) {
                    Logger.getLogger().w("Couldn't create directory to store native session files, aborting.");
                }
            }
            doWriteAppExceptionMarker(minidumpFile.lastModified());
            List nativeSessionFiles = CrashlyticsController.getNativeSessionFiles(sessionFileProvider, string, getFilesDir(), logFileManager.getBytesForLog());
            NativeSessionFileGzipper.processNativeSessions(file, nativeSessionFiles);
            this.reportingCoordinator.finalizeSessionWithNativeEvent(string, nativeSessionFiles);
            logFileManager.clearLog();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("No minidump data found for session ");
        stringBuilder2.append(string);
        Logger.getLogger().w(stringBuilder2.toString());
    }

    private static boolean firebaseCrashExists() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return 1;
            return 0;
        }
    }

    private Context getContext() {
        return this.context;
    }

    private String getCurrentSessionId() {
        Object obj;
        int empty;
        List listSortedOpenSessionIds = this.reportingCoordinator.listSortedOpenSessionIds();
        if (!listSortedOpenSessionIds.isEmpty()) {
            obj = listSortedOpenSessionIds.get(0);
        } else {
            obj = 0;
        }
        return obj;
    }

    private static long getCurrentTimestampSeconds() {
        return CrashlyticsController.getTimestampSeconds(System.currentTimeMillis());
    }

    static List<com.google.firebase.crashlytics.internal.common.NativeSessionFile> getNativeSessionFiles(NativeSessionFileProvider nativeSessionFileProvider, String string2, File file3, byte[] b4Arr4) {
        MetaDataStore metaDataStore = new MetaDataStore(file3);
        ArrayList arrayList = new ArrayList();
        BytesBackedNativeSessionFile bytesBackedNativeSessionFile = new BytesBackedNativeSessionFile("logs_file", "logs", b4Arr4);
        arrayList.add(bytesBackedNativeSessionFile);
        FileBackedNativeSessionFile obj7 = new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.getMetadataFile());
        arrayList.add(obj7);
        obj7 = new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.getSessionFile());
        arrayList.add(obj7);
        obj7 = new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.getAppFile());
        arrayList.add(obj7);
        obj7 = new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProvider.getDeviceFile());
        arrayList.add(obj7);
        obj7 = new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProvider.getOsFile());
        arrayList.add(obj7);
        obj7 = new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProvider.getMinidumpFile());
        arrayList.add(obj7);
        FileBackedNativeSessionFile obj4 = new FileBackedNativeSessionFile("user_meta_file", "user", metaDataStore.getUserDataFileForSession(string2));
        arrayList.add(obj4);
        obj4 = new FileBackedNativeSessionFile("keys_file", "keys", metaDataStore.getKeysFileForSession(string2));
        arrayList.add(obj4);
        return arrayList;
    }

    private static long getTimestampSeconds(long l) {
        return l /= i;
    }

    private static File[] listFilesMatching(File file, FilenameFilter filenameFilter2) {
        return CrashlyticsController.ensureFileArrayNotNull(file.listFiles(filenameFilter2));
    }

    private File[] listFilesMatching(FilenameFilter filenameFilter) {
        return CrashlyticsController.listFilesMatching(getFilesDir(), filenameFilter);
    }

    private j<Void> logAnalyticsAppExceptionEvent(long l) {
        if (CrashlyticsController.firebaseCrashExists()) {
            Logger.getLogger().w("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return m.e(0);
        }
        Logger.getLogger().d("Logging app exception event to Firebase Analytics");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        CrashlyticsController.10 anon = new CrashlyticsController.10(this, l, obj4);
        return m.c(scheduledThreadPoolExecutor, anon);
    }

    private j<Void> logAnalyticsAppExceptionEvents() {
        int i;
        File file;
        Object logAnalyticsAppExceptionEvent;
        StringBuilder string;
        String name;
        ArrayList arrayList = new ArrayList();
        final File[] listAppExceptionMarkerFiles = listAppExceptionMarkerFiles();
        i = 0;
        while (i < listAppExceptionMarkerFiles.length) {
            file = listAppExceptionMarkerFiles[i];
            string = 3;
            arrayList.add(logAnalyticsAppExceptionEvent(Long.parseLong(file.getName().substring(string))));
            file.delete();
            i++;
            string = new StringBuilder();
            name = "Could not parse app exception timestamp from file ";
            string.append(name);
            name = obj4.getName();
            string.append(name);
            string = string.toString();
            Logger.getLogger().w(string);
        }
        return m.f(arrayList);
    }

    private j<Boolean> waitForReportAction() {
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            this.unsentReportsAvailable.e(Boolean.FALSE);
            return m.e(Boolean.TRUE);
        }
        Logger.getLogger().d("Automatic data collection is disabled.");
        Logger.getLogger().v("Notifying that unsent reports are available.");
        this.unsentReportsAvailable.e(Boolean.TRUE);
        CrashlyticsController.3 anon = new CrashlyticsController.3(this);
        Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
        return Utils.race(this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled().onSuccessTask(anon), this.reportActionProvided.a());
    }

    private void writeApplicationExitInfoEventIfRelevant(String string) {
        Object historicalProcessExitReasons;
        Object logFileManager;
        Object userMetadata;
        com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator reportingCoordinator;
        File filesDir;
        Object obj6;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 30) {
            int i3 = 0;
            historicalProcessExitReasons = (ActivityManager)this.context.getSystemService("activity").getHistoricalProcessExitReasons(0, i3, i3);
            if (historicalProcessExitReasons.size() != 0) {
                logFileManager = new LogFileManager(this.context, this.logFileDirectoryProvider, string);
                userMetadata = new UserMetadata();
                MetaDataStore metaDataStore = new MetaDataStore(getFilesDir());
                userMetadata.setCustomKeys(metaDataStore.readKeyData(string));
                this.reportingCoordinator.persistRelevantAppExitInfoEvent(string, historicalProcessExitReasons, logFileManager, userMetadata);
            } else {
                logFileManager = new StringBuilder();
                logFileManager.append("No ApplicationExitInfo available. Session: ");
                logFileManager.append(string);
                Logger.getLogger().v(logFileManager.toString());
            }
        } else {
            logFileManager = new StringBuilder();
            logFileManager.append("ANR feature enabled, but device is API ");
            logFileManager.append(sDK_INT);
            Logger.getLogger().v(logFileManager.toString());
        }
    }

    j<Boolean> checkForUnsentReports() {
        if (!this.checkForUnsentReportsCalled.compareAndSet(false, true)) {
            Logger.getLogger().w("checkForUnsentReports should only be called once per execution.");
            return m.e(Boolean.FALSE);
        }
        return this.unsentReportsAvailable.a();
    }

    j<Void> deleteUnsentReports() {
        this.reportActionProvided.e(Boolean.FALSE);
        return this.unsentReportsHandled.a();
    }

    boolean didCrashOnPreviousExecution() {
        String crashDataForSession;
        int i;
        CrashlyticsNativeComponent nativeComponent;
        if (!this.crashMarker.isPresent()) {
            crashDataForSession = getCurrentSessionId();
            if (crashDataForSession != null && this.nativeComponent.hasCrashDataForSession(crashDataForSession)) {
                if (this.nativeComponent.hasCrashDataForSession(crashDataForSession)) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }
        Logger.getLogger().v("Found previous crash marker.");
        this.crashMarker.remove();
        return 1;
    }

    void doCloseSessions(SettingsDataProvider settingsDataProvider) {
        doCloseSessions(false, settingsDataProvider);
    }

    void enableExceptionHandling(java.lang.Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler, SettingsDataProvider settingsDataProvider2) {
        openSession();
        CrashlyticsController.1 anon = new CrashlyticsController.1(this);
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(anon, settingsDataProvider2, uncaughtExceptionHandler, this.nativeComponent);
        this.crashHandler = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    boolean finalizeSessions(SettingsDataProvider settingsDataProvider) {
        this.backgroundWorker.checkRunningOnThread();
        if (isHandlingException()) {
            Logger.getLogger().w("Skipping session finalization because a crash has already occurred.");
            return 0;
        }
        Logger.getLogger().v("Finalizing previously open sessions.");
        int i = 1;
        doCloseSessions(i, settingsDataProvider);
        Logger.getLogger().v("Closed all previously open sessions.");
        return i;
    }

    File getFilesDir() {
        return this.fileStore.getFilesDir();
    }

    File getNativeSessionFilesDir() {
        File file = new File(getFilesDir(), "native-sessions");
        return file;
    }

    com.google.firebase.crashlytics.internal.common.UserMetadata getUserMetadata() {
        return this.userMetadata;
    }

    void handleUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread2, Throwable throwable3) {
        j obj10;
        Logger obj11;
        Object obj12;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Handling uncaught exception \"");
        stringBuilder.append(throwable3);
        stringBuilder.append("\" from thread ");
        stringBuilder.append(thread2.getName());
        Logger.getLogger().d(stringBuilder.toString());
        super(this, System.currentTimeMillis(), obj5, throwable3, thread2, settingsDataProvider);
        Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submitTask(anon));
        synchronized (this) {
        }
    }

    boolean isHandlingException() {
        com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler handlingException;
        int i;
        handlingException = this.crashHandler;
        if (handlingException != null && handlingException.isHandlingException()) {
            i = handlingException.isHandlingException() ? 1 : 0;
        } else {
        }
        return i;
    }

    File[] listAppExceptionMarkerFiles() {
        return listFilesMatching(CrashlyticsController.APP_EXCEPTION_MARKER_FILTER);
    }

    File[] listNativeSessionFileDirectories() {
        return CrashlyticsController.ensureFileArrayNotNull(getNativeSessionFilesDir().listFiles());
    }

    void openSession() {
        CrashlyticsController.9 anon = new CrashlyticsController.9(this);
        this.backgroundWorker.submit(anon);
    }

    j<Void> sendUnsentReports() {
        this.reportActionProvided.e(Boolean.TRUE);
        return this.unsentReportsHandled.a();
    }

    void setCustomKey(String string, String string2) {
        try {
            this.userMetadata.setCustomKey(string, string2);
            cacheKeyData(this.userMetadata.getCustomKeys(), false);
            string2 = this.context;
            if (string2 != null) {
            }
            string2 = CommonUtils.isAppDebuggable(string2);
            throw string;
        }
        string = Logger.getLogger();
        string2 = "Attempting to set custom attribute with null key, ignoring.";
        string.e(string2);
    }

    void setCustomKeys(Map<String, String> map) {
        this.userMetadata.setCustomKeys(map);
        cacheKeyData(this.userMetadata.getCustomKeys(), false);
    }

    void setInternalKey(String string, String string2) {
        try {
            this.userMetadata.setInternalKey(string, string2);
            cacheKeyData(this.userMetadata.getInternalKeys(), true);
            string2 = this.context;
            if (string2 != null) {
            }
            string2 = CommonUtils.isAppDebuggable(string2);
            throw string;
        }
        string = Logger.getLogger();
        string2 = "Attempting to set custom attribute with null key, ignoring.";
        string.e(string2);
    }

    void setUserId(String string) {
        this.userMetadata.setUserId(string);
        cacheUserData(this.userMetadata);
    }

    j<Void> submitAllReports(j<AppSettingsData> j) {
        if (!this.reportingCoordinator.hasReportsToSend()) {
            Logger.getLogger().v("No crash reports are available to be sent.");
            this.unsentReportsAvailable.e(Boolean.FALSE);
            return m.e(0);
        }
        Logger.getLogger().v("Crash reports are available to be sent.");
        CrashlyticsController.4 anon = new CrashlyticsController.4(this, j);
        return waitForReportAction().onSuccessTask(anon);
    }

    void writeNonFatalException(Thread thread, Throwable throwable2) {
        super(this, System.currentTimeMillis(), obj3, throwable2, thread);
        this.backgroundWorker.submit(anon2);
    }

    void writeToLog(long l, String string2) {
        CrashlyticsController.5 anon = new CrashlyticsController.5(this, l, string2, obj5);
        this.backgroundWorker.submit(anon);
    }
}
