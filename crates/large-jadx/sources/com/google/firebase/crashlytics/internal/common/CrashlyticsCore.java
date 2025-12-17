package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class CrashlyticsCore {

    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_STACK_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
    static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private final AnalyticsEventLogger analyticsEventLogger;
    private final FirebaseApp app;
    private final com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker backgroundWorker;
    public final BreadcrumbSource breadcrumbSource;
    private final Context context;
    private com.google.firebase.crashlytics.internal.common.CrashlyticsController controller;
    private final ExecutorService crashHandlerExecutor;
    private com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker crashMarker;
    private final com.google.firebase.crashlytics.internal.common.DataCollectionArbiter dataCollectionArbiter;
    private boolean didCrashOnPreviousExecution;
    private final com.google.firebase.crashlytics.internal.common.IdManager idManager;
    private com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker initializationMarker;
    private final CrashlyticsNativeComponent nativeComponent;
    private final long startTime;

    private static final class LogFileDirectoryProvider implements LogFileManager.DirectoryProvider {

        private static final String LOG_FILES_DIR = "log-files";
        private final FileStore rootFileStore;
        public LogFileDirectoryProvider(FileStore fileStore) {
            super();
            this.rootFileStore = fileStore;
        }

        @Override // com.google.firebase.crashlytics.internal.log.LogFileManager$DirectoryProvider
        public File getLogFileDir() {
            File file = new File(this.rootFileStore.getFilesDir(), "log-files");
            if (file.exists() == null) {
                file.mkdirs();
            }
            return file;
        }
    }
    public CrashlyticsCore(FirebaseApp firebaseApp, com.google.firebase.crashlytics.internal.common.IdManager idManager2, CrashlyticsNativeComponent crashlyticsNativeComponent3, com.google.firebase.crashlytics.internal.common.DataCollectionArbiter dataCollectionArbiter4, BreadcrumbSource breadcrumbSource5, AnalyticsEventLogger analyticsEventLogger6, ExecutorService executorService7) {
        super();
        this.app = firebaseApp;
        this.dataCollectionArbiter = dataCollectionArbiter4;
        this.context = firebaseApp.getApplicationContext();
        this.idManager = idManager2;
        this.nativeComponent = crashlyticsNativeComponent3;
        this.breadcrumbSource = breadcrumbSource5;
        this.analyticsEventLogger = analyticsEventLogger6;
        this.crashHandlerExecutor = executorService7;
        CrashlyticsBackgroundWorker obj1 = new CrashlyticsBackgroundWorker(executorService7);
        this.backgroundWorker = obj1;
        this.startTime = System.currentTimeMillis();
    }

    static j access$000(com.google.firebase.crashlytics.internal.common.CrashlyticsCore crashlyticsCore, SettingsDataProvider settingsDataProvider2) {
        return crashlyticsCore.doBackgroundInitialization(settingsDataProvider2);
    }

    static com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker access$100(com.google.firebase.crashlytics.internal.common.CrashlyticsCore crashlyticsCore) {
        return crashlyticsCore.initializationMarker;
    }

    static com.google.firebase.crashlytics.internal.common.CrashlyticsController access$200(com.google.firebase.crashlytics.internal.common.CrashlyticsCore crashlyticsCore) {
        return crashlyticsCore.controller;
    }

    private void checkForPreviousCrash() {
        CrashlyticsCore.4 anon = new CrashlyticsCore.4(this);
        this.didCrashOnPreviousExecution = Boolean.TRUE.equals((Boolean)Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submit(anon)));
    }

    private j<Void> doBackgroundInitialization(SettingsDataProvider settingsDataProvider) {
        boolean finalizeSessions;
        boolean collectReports;
        String str = "Collection of crash reports disabled in Crashlytics settings.";
        markInitializationStarted();
        b bVar = new b(this);
        this.breadcrumbSource.registerBreadcrumbHandler(bVar);
        if (!featuresData.collectReports) {
            Logger.getLogger().d(str);
            RuntimeException obj4 = new RuntimeException(str);
            markInitializationComplete();
            return m.d(obj4);
        }
        if (!this.controller.finalizeSessions(settingsDataProvider)) {
            Logger.getLogger().w("Previous sessions could not be finalized.");
        }
        markInitializationComplete();
        return this.controller.submitAllReports(settingsDataProvider.getAppSettings());
    }

    private void finishInitSynchronously(SettingsDataProvider settingsDataProvider) {
        int i;
        String str;
        Future obj4;
        CrashlyticsCore.2 anon = new CrashlyticsCore.2(this, settingsDataProvider);
        str = "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.";
        Logger.getLogger().d(str);
        this.crashHandlerExecutor.submit(anon).get(4, str);
    }

    public static String getVersion() {
        return "18.2.4";
    }

    static boolean isBuildIdValid(String string, boolean z2) {
        int i = 1;
        if (!z2) {
            Logger.getLogger().v("Configured not to require a build ID.");
            return i;
        }
        if (!TextUtils.isEmpty(string)) {
            return i;
        }
        String obj2 = "FirebaseCrashlytics";
        String obj3 = ".";
        Log.e(obj2, obj3);
        Log.e(obj2, ".     |  | ");
        String str2 = ".     |  |";
        Log.e(obj2, str2);
        Log.e(obj2, str2);
        Log.e(obj2, ".   \\ |  | /");
        Log.e(obj2, ".    \\    /");
        Log.e(obj2, ".     \\  /");
        Log.e(obj2, ".      \\/");
        Log.e(obj2, obj3);
        Log.e(obj2, "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        Log.e(obj2, obj3);
        Log.e(obj2, ".      /\\");
        Log.e(obj2, ".     /  \\");
        Log.e(obj2, ".    /    \\");
        Log.e(obj2, ".   / |  | \\");
        Log.e(obj2, str2);
        Log.e(obj2, str2);
        Log.e(obj2, str2);
        Log.e(obj2, obj3);
        return 0;
    }

    public j<Boolean> checkForUnsentReports() {
        return this.controller.checkForUnsentReports();
    }

    public j<Void> deleteUnsentReports() {
        return this.controller.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.didCrashOnPreviousExecution;
    }

    boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    public j<Void> doBackgroundInitializationAsync(SettingsDataProvider settingsDataProvider) {
        CrashlyticsCore.1 anon = new CrashlyticsCore.1(this, settingsDataProvider);
        return Utils.callTask(this.crashHandlerExecutor, anon);
    }

    com.google.firebase.crashlytics.internal.common.CrashlyticsController getController() {
        return this.controller;
    }

    public void log(String string) {
        this.controller.writeToLog(currentTimeMillis -= startTime, obj1);
    }

    public void logException(Throwable throwable) {
        this.controller.writeNonFatalException(Thread.currentThread(), throwable);
    }

    void markInitializationComplete() {
        CrashlyticsCore.3 anon = new CrashlyticsCore.3(this);
        this.backgroundWorker.submit(anon);
    }

    void markInitializationStarted() {
        this.backgroundWorker.checkRunningOnThread();
        this.initializationMarker.create();
        Logger.getLogger().v("Initialization marker file was created.");
    }

    public boolean onPreExecute(com.google.firebase.crashlytics.internal.common.AppData appData, SettingsDataProvider settingsDataProvider2) {
        boolean didPreviousInitializationFail;
        final Object obj = this;
        SettingsDataProvider set = settingsDataProvider2;
        final int i3 = 1;
        if (!CrashlyticsCore.isBuildIdValid(obj2.buildId, CommonUtils.getBooleanResourceValue(obj.context, "com.crashlytics.RequireBuildId", i3))) {
        } else {
            final int i4 = 0;
            FileStoreImpl fileStoreImpl3 = new FileStoreImpl(obj.context);
            CrashlyticsFileMarker crashlyticsFileMarker = new CrashlyticsFileMarker("crash_marker", fileStoreImpl3);
            obj.crashMarker = crashlyticsFileMarker;
            CrashlyticsFileMarker crashlyticsFileMarker2 = new CrashlyticsFileMarker("initialization_marker", fileStoreImpl3);
            obj.initializationMarker = crashlyticsFileMarker2;
            UserMetadata userMetadata2 = new UserMetadata();
            CrashlyticsCore.LogFileDirectoryProvider logFileDirectoryProvider2 = new CrashlyticsCore.LogFileDirectoryProvider(fileStoreImpl3);
            LogFileManager logFileManager2 = new LogFileManager(obj.context, logFileDirectoryProvider2);
            com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy[] arr = new StackTraceTrimmingStrategy[i3];
            RemoveRepeatsStrategy removeRepeatsStrategy = new RemoveRepeatsStrategy(10);
            arr[i4] = removeRepeatsStrategy;
            MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, arr);
            super(obj.context, obj.backgroundWorker, obj.idManager, obj.dataCollectionArbiter, fileStoreImpl3, obj.crashMarker, appData, userMetadata2, logFileManager2, logFileDirectoryProvider2, SessionReportingCoordinator.create(obj.context, obj.idManager, fileStoreImpl3, appData, logFileManager2, userMetadata2, middleOutFallbackStrategy, settingsDataProvider2), obj.nativeComponent, obj.analyticsEventLogger);
            obj.controller = crashlyticsController;
            checkForPreviousCrash();
            obj.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler(), set);
            if (didPreviousInitializationFail() && CommonUtils.canTryConnection(obj.context)) {
                if (CommonUtils.canTryConnection(obj.context)) {
                    Logger.getLogger().d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    obj.finishInitSynchronously(set);
                    return i4;
                }
            }
            Logger.getLogger().d("Successfully configured exception handler.");
            return i3;
        }
        IllegalStateException illegalStateException = new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        throw illegalStateException;
    }

    public j<Void> sendUnsentReports() {
        return this.controller.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(Boolean boolean) {
        this.dataCollectionArbiter.setCrashlyticsDataCollectionEnabled(boolean);
    }

    public void setCustomKey(String string, String string2) {
        this.controller.setCustomKey(string, string2);
    }

    public void setCustomKeys(Map<String, String> map) {
        this.controller.setCustomKeys(map);
    }

    public void setInternalKey(String string, String string2) {
        this.controller.setInternalKey(string, string2);
    }

    public void setUserId(String string) {
        this.controller.setUserId(string);
    }
}
