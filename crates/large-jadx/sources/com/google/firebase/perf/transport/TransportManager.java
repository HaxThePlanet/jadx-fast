package com.google.firebase.perf.transport;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateMonitor.AppStateCallback;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.logging.ConsoleUrlGenerator;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants.CounterNames;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.AndroidApplicationInfo.Builder;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo.Builder;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfMetric.Builder;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.protobuf.z.a;
import f.c.a.b.g;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class TransportManager implements AppStateMonitor.AppStateCallback {

    private static final int CORE_POOL_SIZE = 0;
    private static final String KEY_AVAILABLE_GAUGES_FOR_CACHING = "KEY_AVAILABLE_GAUGES_FOR_CACHING";
    private static final String KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING";
    private static final String KEY_AVAILABLE_TRACES_FOR_CACHING = "KEY_AVAILABLE_TRACES_FOR_CACHING";
    private static final int MAX_GAUGE_METRICS_CACHE_SIZE = 50;
    private static final int MAX_NETWORK_REQUEST_METRICS_CACHE_SIZE = 50;
    private static final int MAX_POOL_SIZE = 1;
    private static final int MAX_TRACE_METRICS_CACHE_SIZE = 50;
    private static final com.google.firebase.perf.transport.TransportManager instance;
    private static final AndroidLogger logger;
    private Context appContext;
    private AppStateMonitor appStateMonitor;
    private ApplicationInfo.Builder applicationInfoBuilder;
    private final Map<String, Integer> cacheMap;
    private ConfigResolver configResolver;
    private ExecutorService executorService;
    private FirebaseApp firebaseApp;
    private FirebaseInstallationsApi firebaseInstallationsApi;
    private FirebasePerformance firebasePerformance;
    private com.google.firebase.perf.transport.FlgTransport flgTransport;
    private Provider<g> flgTransportFactoryProvider;
    private boolean isForegroundState = false;
    private final AtomicBoolean isTransportInitialized;
    private String packageName;
    private final ConcurrentLinkedQueue<com.google.firebase.perf.transport.PendingPerfEvent> pendingEventsQueue;
    private String projectId;
    private com.google.firebase.perf.transport.RateLimiter rateLimiter;
    static {
        TransportManager.logger = AndroidLogger.getInstance();
        TransportManager transportManager = new TransportManager();
        TransportManager.instance = transportManager;
    }

    private TransportManager() {
        super();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.pendingEventsQueue = concurrentLinkedQueue;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.isTransportInitialized = atomicBoolean;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(0, 1, 10, obj6, TimeUnit.SECONDS, linkedBlockingQueue);
        this.executorService = threadPoolExecutor;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.cacheMap = concurrentHashMap;
        Integer valueOf = 50;
        concurrentHashMap.put("KEY_AVAILABLE_TRACES_FOR_CACHING", valueOf);
        concurrentHashMap.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", valueOf);
        concurrentHashMap.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", valueOf);
    }

    public static void a(com.google.firebase.perf.transport.TransportManager transportManager) {
        transportManager.syncInit();
    }

    private void b(com.google.firebase.perf.transport.PendingPerfEvent pendingPerfEvent) {
        syncLog(pendingPerfEvent.perfMetricBuilder, pendingPerfEvent.appState);
    }

    private void d(TraceMetric traceMetric, ApplicationProcessState applicationProcessState2) {
        syncLog(PerfMetric.newBuilder().setTraceMetric(traceMetric), applicationProcessState2);
    }

    private void dispatchLog(PerfMetric perfMetric) {
        AndroidLogger logger;
        String str;
        int arr;
        Object[] logcatMsg;
        String logcatMsg2;
        int i = 0;
        arr = 1;
        if (perfMetric.hasTraceMetric()) {
            logcatMsg = new Object[2];
            logcatMsg[i] = TransportManager.getLogcatMsg(perfMetric);
            logcatMsg[arr] = getConsoleUrl(perfMetric.getTraceMetric());
            TransportManager.logger.info("Logging %s. In a minute, visit the Firebase console to view your data: %s", logcatMsg);
        } else {
            arr = new Object[arr];
            arr[i] = TransportManager.getLogcatMsg(perfMetric);
            TransportManager.logger.info("Logging %s", arr);
        }
        this.flgTransport.log(perfMetric);
    }

    private void f(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState2) {
        syncLog(PerfMetric.newBuilder().setNetworkRequestMetric(networkRequestMetric), applicationProcessState2);
    }

    private void finishInitialization() {
        AtomicBoolean isTransportInitialized;
        int executorService;
        String versionName;
        WeakReference weakReference = new WeakReference(TransportManager.instance);
        this.appStateMonitor.registerForAppState(weakReference);
        ApplicationInfo.Builder builder = ApplicationInfo.newBuilder();
        this.applicationInfoBuilder = builder;
        builder.setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setAndroidAppInfo(AndroidApplicationInfo.newBuilder().setPackageName(this.packageName).setSdkVersion(BuildConfig.FIREPERF_VERSION_NAME).setVersionName(TransportManager.getVersionName(this.appContext)));
        this.isTransportInitialized.set(true);
        while (!this.pendingEventsQueue.isEmpty()) {
            isTransportInitialized = this.pendingEventsQueue.poll();
            if ((PendingPerfEvent)isTransportInitialized != null) {
            }
            versionName = new d(this, (PendingPerfEvent)isTransportInitialized);
            this.executorService.execute(versionName);
        }
    }

    private String getConsoleUrl(TraceMetric traceMetric) {
        String obj3 = traceMetric.getName();
        if (obj3.startsWith("_st_")) {
            return ConsoleUrlGenerator.generateScreenTraceUrl(this.projectId, this.packageName, obj3);
        }
        return ConsoleUrlGenerator.generateCustomTraceUrl(this.projectId, this.packageName, obj3);
    }

    private Map<String, String> getGlobalCustomAttributes() {
        Map emptyMap;
        updateFirebasePerformanceIfPossibleAndNeeded();
        FirebasePerformance firebasePerformance = this.firebasePerformance;
        if (firebasePerformance != null) {
            emptyMap = firebasePerformance.getAttributes();
        } else {
            emptyMap = Collections.emptyMap();
        }
        return emptyMap;
    }

    public static com.google.firebase.perf.transport.TransportManager getInstance() {
        return TransportManager.instance;
    }

    private static String getLogcatMsg(GaugeMetric gaugeMetric) {
        Object[] arr = new Object[3];
        return String.format(Locale.ENGLISH, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", Boolean.valueOf(gaugeMetric.hasGaugeMetadata()), Integer.valueOf(gaugeMetric.getCpuMetricReadingsCount()), Integer.valueOf(gaugeMetric.getAndroidMemoryReadingsCount()));
    }

    private static String getLogcatMsg(NetworkRequestMetric networkRequestMetric) {
        long timeToResponseCompletedUs;
        String valueOf;
        if (networkRequestMetric.hasTimeToResponseCompletedUs()) {
            timeToResponseCompletedUs = networkRequestMetric.getTimeToResponseCompletedUs();
        } else {
            timeToResponseCompletedUs = 0;
        }
        if (networkRequestMetric.hasHttpResponseCode()) {
            valueOf = String.valueOf(networkRequestMetric.getHttpResponseCode());
        } else {
            valueOf = "UNKNOWN";
        }
        Object[] arr = new Object[3];
        return String.format(Locale.ENGLISH, "network request trace: %s (responseCode: %s, responseTime: %.4fms)", networkRequestMetric.getUrl(), valueOf, Double.valueOf(d /= l));
    }

    private static String getLogcatMsg(PerfMetricOrBuilder perfMetricOrBuilder) {
        if (perfMetricOrBuilder.hasTraceMetric()) {
            return TransportManager.getLogcatMsg(perfMetricOrBuilder.getTraceMetric());
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric()) {
            return TransportManager.getLogcatMsg(perfMetricOrBuilder.getNetworkRequestMetric());
        }
        if (perfMetricOrBuilder.hasGaugeMetric()) {
            return TransportManager.getLogcatMsg(perfMetricOrBuilder.getGaugeMetric());
        }
        return "log";
    }

    private static String getLogcatMsg(TraceMetric traceMetric) {
        Object[] arr = new Object[2];
        return String.format(Locale.ENGLISH, "trace metric: %s (duration: %.4fms)", traceMetric.getName(), Double.valueOf(d /= l));
    }

    private static String getVersionName(Context context) {
        String str;
        str = "";
        String obj3 = obj3.versionName;
        if (obj3 == null) {
        } else {
            try {
                str = obj3;
                return str;
            }
        }
    }

    private void h(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState2) {
        syncLog(PerfMetric.newBuilder().setGaugeMetric(gaugeMetric), applicationProcessState2);
    }

    private void incrementDropCount(PerfMetric perfMetric) {
        String traceMetric;
        AppStateMonitor obj4;
        final int i = 1;
        if (perfMetric.hasTraceMetric()) {
            this.appStateMonitor.incrementCount(Constants.CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), i);
        } else {
            if (perfMetric.hasNetworkRequestMetric()) {
                this.appStateMonitor.incrementCount(Constants.CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), i);
            }
        }
    }

    private boolean isAllowedToCache(PerfMetricOrBuilder perfMetricOrBuilder) {
        String str = "KEY_AVAILABLE_TRACES_FOR_CACHING";
        int intValue = (Integer)this.cacheMap.get(str).intValue();
        String str2 = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING";
        int intValue2 = (Integer)this.cacheMap.get(str2).intValue();
        String str3 = "KEY_AVAILABLE_GAUGES_FOR_CACHING";
        int intValue3 = (Integer)this.cacheMap.get(str3).intValue();
        final int i6 = 1;
        if (perfMetricOrBuilder.hasTraceMetric() && intValue > 0) {
            if (intValue > 0) {
                this.cacheMap.put(str, Integer.valueOf(intValue -= i6));
                return i6;
            }
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric() && intValue2 > 0) {
            if (intValue2 > 0) {
                this.cacheMap.put(str2, Integer.valueOf(intValue2 -= i6));
                return i6;
            }
        }
        if (perfMetricOrBuilder.hasGaugeMetric() && intValue3 > 0) {
            if (intValue3 > 0) {
                this.cacheMap.put(str3, Integer.valueOf(intValue3 -= i6));
                return i6;
            }
        }
        Object[] arr = new Object[4];
        int i5 = 0;
        arr[i5] = TransportManager.getLogcatMsg(perfMetricOrBuilder);
        arr[i6] = Integer.valueOf(intValue);
        arr[2] = Integer.valueOf(intValue2);
        arr[3] = Integer.valueOf(intValue3);
        TransportManager.logger.debug("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", arr);
        return i5;
    }

    private boolean isAllowedToDispatch(PerfMetric perfMetric) {
        boolean networkRequestMetric;
        int arr;
        Object obj5;
        arr = 1;
        final int i = 0;
        if (!this.configResolver.isPerformanceMonitoringEnabled()) {
            Object[] arr4 = new Object[arr];
            arr4[i] = TransportManager.getLogcatMsg(perfMetric);
            TransportManager.logger.info("Performance collection is not enabled, dropping %s", arr4);
            return i;
        }
        if (!perfMetric.getApplicationInfo().hasAppInstanceId()) {
            Object[] arr2 = new Object[arr];
            arr2[i] = TransportManager.getLogcatMsg(perfMetric);
            TransportManager.logger.warn("App Instance ID is null or empty, dropping %s", arr2);
            return i;
        }
        if (!PerfMetricValidator.isValid(perfMetric, this.appContext)) {
            Object[] arr3 = new Object[arr];
            arr3[i] = TransportManager.getLogcatMsg(perfMetric);
            TransportManager.logger.warn("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", arr3);
            return i;
        }
        if (!this.rateLimiter.check(perfMetric)) {
            incrementDropCount(perfMetric);
            final String str = "Rate Limited - %s";
            if (perfMetric.hasTraceMetric()) {
                arr = new Object[arr];
                arr[i] = TransportManager.getLogcatMsg(perfMetric.getTraceMetric());
                TransportManager.logger.info(str, arr);
            } else {
                if (perfMetric.hasNetworkRequestMetric()) {
                    arr = new Object[arr];
                    arr[i] = TransportManager.getLogcatMsg(perfMetric.getNetworkRequestMetric());
                    TransportManager.logger.info(str, arr);
                }
            }
            return i;
        }
        return arr;
    }

    private void j() {
        this.rateLimiter.changeRate(this.isForegroundState);
    }

    private PerfMetric setApplicationInfoAndBuild(PerfMetric.Builder perfMetric$Builder, ApplicationProcessState applicationProcessState2) {
        boolean globalCustomAttributes;
        ApplicationInfo.Builder obj3;
        updateFirebaseInstallationIdIfPossibleAndNeeded();
        if (builder.hasTraceMetric()) {
            obj3 = (ApplicationInfo.Builder)this.applicationInfoBuilder.setApplicationProcessState(applicationProcessState2).clone().putAllCustomAttributes(getGlobalCustomAttributes());
        }
        return (PerfMetric)builder.setApplicationInfo(obj3).build();
    }

    private void syncInit() {
        Context applicationContext = this.firebaseApp.getApplicationContext();
        this.appContext = applicationContext;
        this.packageName = applicationContext.getPackageName();
        this.configResolver = ConfigResolver.getInstance();
        final int i2 = 100;
        super(i2, obj4, 1, obj6, TimeUnit.MINUTES);
        RateLimiter rateLimiter = new RateLimiter(this.appContext, rate2, 500, i2);
        this.rateLimiter = rateLimiter;
        this.appStateMonitor = AppStateMonitor.getInstance();
        FlgTransport flgTransport = new FlgTransport(this.flgTransportFactoryProvider, this.configResolver.getAndCacheLogSourceName());
        this.flgTransport = flgTransport;
        finishInitialization();
    }

    private void syncLog(PerfMetric.Builder perfMetric$Builder, ApplicationProcessState applicationProcessState2) {
        boolean pendingEventsQueue;
        com.google.firebase.perf.transport.PendingPerfEvent pendingPerfEvent;
        String str;
        String logcatMsg;
        Object obj5;
        if (!isInitialized() && isAllowedToCache(builder)) {
            if (isAllowedToCache(builder)) {
                Object[] arr = new Object[1];
                TransportManager.logger.debug("Transport is not initialized yet, %s will be queued for to be dispatched later", TransportManager.getLogcatMsg(builder));
                pendingPerfEvent = new PendingPerfEvent(builder, applicationProcessState2);
                this.pendingEventsQueue.add(pendingPerfEvent);
            }
        }
        obj5 = setApplicationInfoAndBuild(builder, applicationProcessState2);
        if (isAllowedToDispatch(obj5)) {
            dispatchLog(obj5);
            SessionManager.getInstance().updatePerfSessionIfExpired();
        }
    }

    private void updateFirebaseInstallationIdIfPossibleAndNeeded() {
        boolean performanceMonitoringEnabled;
        boolean isForegroundState;
        int applicationInfoBuilder;
        int i;
        int arr;
        Object message;
        AndroidLogger logger;
        TimeUnit mILLISECONDS;
        if (this.configResolver.isPerformanceMonitoringEnabled() && this.applicationInfoBuilder.hasAppInstanceId() && !this.isForegroundState) {
            if (this.applicationInfoBuilder.hasAppInstanceId()) {
                if (!this.isForegroundState) {
                }
            }
            int i2 = 0;
            i = 0;
            arr = 1;
            performanceMonitoringEnabled = message;
            if (!TextUtils.isEmpty(performanceMonitoringEnabled)) {
                this.applicationInfoBuilder.setAppInstanceId(performanceMonitoringEnabled);
            } else {
                TransportManager.logger.warn("Firebase Installation Id is empty, contact Firebase Support for debugging.");
            }
        }
    }

    private void updateFirebasePerformanceIfPossibleAndNeeded() {
        FirebasePerformance firebasePerformance;
        if (this.firebasePerformance == null && isInitialized()) {
            if (isInitialized()) {
                this.firebasePerformance = FirebasePerformance.getInstance();
            }
        }
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void c(com.google.firebase.perf.transport.PendingPerfEvent pendingPerfEvent) {
        b(pendingPerfEvent);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    protected void clearAppInstanceId() {
        this.applicationInfoBuilder.clearAppInstanceId();
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void e(TraceMetric traceMetric, ApplicationProcessState applicationProcessState2) {
        d(traceMetric, applicationProcessState2);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void g(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState2) {
        f(networkRequestMetric, applicationProcessState2);
    }

    protected ConcurrentLinkedQueue<com.google.firebase.perf.transport.PendingPerfEvent> getPendingEventsQueue() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(this.pendingEventsQueue);
        return concurrentLinkedQueue;
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void i(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState2) {
        h(gaugeMetric, applicationProcessState2);
    }

    public void initialize(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi2, Provider<g> provider3) {
        this.firebaseApp = firebaseApp;
        this.projectId = firebaseApp.getOptions().getProjectId();
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.flgTransportFactoryProvider = provider3;
        c obj2 = new c(this);
        this.executorService.execute(obj2);
    }

    void initializeForTest(FirebaseApp firebaseApp, FirebasePerformance firebasePerformance2, FirebaseInstallationsApi firebaseInstallationsApi3, Provider<g> provider4, ConfigResolver configResolver5, com.google.firebase.perf.transport.RateLimiter rateLimiter6, AppStateMonitor appStateMonitor7, com.google.firebase.perf.transport.FlgTransport flgTransport8, ExecutorService executorService9) {
        this.firebaseApp = firebaseApp;
        this.projectId = firebaseApp.getOptions().getProjectId();
        this.appContext = firebaseApp.getApplicationContext();
        this.firebasePerformance = firebasePerformance2;
        this.firebaseInstallationsApi = firebaseInstallationsApi3;
        this.flgTransportFactoryProvider = provider4;
        this.configResolver = configResolver5;
        this.rateLimiter = rateLimiter6;
        this.appStateMonitor = appStateMonitor7;
        this.flgTransport = flgTransport8;
        this.executorService = executorService9;
        Integer obj3 = 50;
        this.cacheMap.put("KEY_AVAILABLE_TRACES_FOR_CACHING", obj3);
        this.cacheMap.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", obj3);
        this.cacheMap.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", obj3);
        finishInitialization();
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public boolean isInitialized() {
        return this.isTransportInitialized.get();
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void k() {
        j();
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void log(GaugeMetric gaugeMetric) {
        log(gaugeMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void log(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState2) {
        b bVar = new b(this, gaugeMetric, applicationProcessState2);
        this.executorService.execute(bVar);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void log(NetworkRequestMetric networkRequestMetric) {
        log(networkRequestMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void log(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState2) {
        f fVar = new f(this, networkRequestMetric, applicationProcessState2);
        this.executorService.execute(fVar);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void log(TraceMetric traceMetric) {
        log(traceMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void log(TraceMetric traceMetric, ApplicationProcessState applicationProcessState2) {
        g gVar = new g(this, traceMetric, applicationProcessState2);
        this.executorService.execute(gVar);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        Object fOREGROUND;
        int obj2;
        obj2 = applicationProcessState == ApplicationProcessState.FOREGROUND ? 1 : 0;
        this.isForegroundState = obj2;
        if (isInitialized()) {
            fOREGROUND = new e(this);
            this.executorService.execute(fOREGROUND);
        }
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    protected void setInitialized(boolean z) {
        this.isTransportInitialized.set(z);
    }
}
