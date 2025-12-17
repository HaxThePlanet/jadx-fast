package com.google.firebase.perf.application;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.core.app.g;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants.CounterNames;
import com.google.firebase.perf.util.Constants.TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric.Builder;
import com.google.protobuf.z.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class AppStateMonitor implements Application.ActivityLifecycleCallbacks {

    private static final String FRAME_METRICS_AGGREGATOR_CLASSNAME = "androidx.core.app.FrameMetricsAggregator";
    private static volatile com.google.firebase.perf.application.AppStateMonitor instance;
    private static final AndroidLogger logger;
    private final WeakHashMap<Activity, Boolean> activityToResumedMap;
    private final WeakHashMap<Activity, Trace> activityToScreenTraceMap;
    private Set<com.google.firebase.perf.application.AppStateMonitor.AppColdStartCallback> appColdStartSubscribers;
    private final Set<WeakReference<com.google.firebase.perf.application.AppStateMonitor.AppStateCallback>> appStateSubscribers;
    private final Clock clock;
    private final ConfigResolver configResolver;
    private ApplicationProcessState currentAppState;
    private g frameMetricsAggregator;
    private boolean hasFrameMetricsAggregator = false;
    private boolean isColdStart = true;
    private boolean isRegisteredForLifecycleCallbacks = false;
    private final Map<String, Long> metricToCountMap;
    private Timer resumeTime;
    private Timer stopTime;
    private final TransportManager transportManager;
    private final AtomicInteger tsnsCount;

    public interface AppColdStartCallback {
        public abstract void onAppColdStart();
    }

    public interface AppStateCallback {
        public abstract void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }
    static {
        AppStateMonitor.logger = AndroidLogger.getInstance();
    }

    AppStateMonitor(TransportManager transportManager, Clock clock2) {
        boolean obj3;
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.activityToResumedMap = weakHashMap;
        WeakHashMap weakHashMap2 = new WeakHashMap();
        this.activityToScreenTraceMap = weakHashMap2;
        HashMap hashMap = new HashMap();
        this.metricToCountMap = hashMap;
        HashSet hashSet = new HashSet();
        this.appStateSubscribers = hashSet;
        HashSet hashSet2 = new HashSet();
        this.appColdStartSubscribers = hashSet2;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.tsnsCount = atomicInteger;
        this.currentAppState = ApplicationProcessState.BACKGROUND;
        int i = 1;
        this.transportManager = transportManager;
        this.clock = clock2;
        this.configResolver = ConfigResolver.getInstance();
        obj3 = hasFrameMetricsAggregatorClass();
        this.hasFrameMetricsAggregator = obj3;
        if (obj3 != null) {
            obj3 = new g();
            this.frameMetricsAggregator = obj3;
        }
    }

    public static com.google.firebase.perf.application.AppStateMonitor getInstance() {
        com.google.firebase.perf.application.AppStateMonitor instance;
        com.google.firebase.perf.application.AppStateMonitor appStateMonitor;
        TransportManager instance2;
        Clock clock;
        instance = AppStateMonitor.class;
        if (AppStateMonitor.instance == null && AppStateMonitor.instance == null) {
            instance = AppStateMonitor.class;
            synchronized (instance) {
                clock = new Clock();
                appStateMonitor = new AppStateMonitor(TransportManager.getInstance(), clock);
                AppStateMonitor.instance = appStateMonitor;
            }
        }
        return AppStateMonitor.instance;
    }

    public static String getScreenTraceName(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_st_");
        stringBuilder.append(activity.getClass().getSimpleName());
        return stringBuilder.toString();
    }

    private boolean hasFrameMetricsAggregatorClass() {
        try {
            Class.forName("androidx.core.app.g");
            return 1;
            return 0;
        }
    }

    private boolean isScreenTraceSupported(Activity activity) {
        return this.hasFrameMetricsAggregator;
    }

    private void sendAppColdStartUpdate() {
        Object next;
        final Set appStateSubscribers = this.appStateSubscribers;
        Iterator iterator = this.appColdStartSubscribers.iterator();
        synchronized (appStateSubscribers) {
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((AppStateMonitor.AppColdStartCallback)next != null) {
                }
                (AppStateMonitor.AppColdStartCallback)next.onAppColdStart();
            }
        }
    }

    private void sendScreenTrace(Activity activity) {
        SparseIntArray[] string;
        boolean debugLoggingEnabled;
        int i2;
        int stringBuilder;
        int i4;
        int i;
        int keyAt;
        int valueAt;
        int i3;
        Object obj10;
        if (!this.activityToScreenTraceMap.containsKey(activity)) {
        }
        Object obj = this.activityToScreenTraceMap.get(activity);
        if ((Trace)obj == null) {
        }
        this.activityToScreenTraceMap.remove(activity);
        string = this.frameMetricsAggregator.b();
        i2 = 0;
        string = string[i2];
        if (string != null && string != null) {
            string = string[i2];
            if (string != null) {
                i = i4;
                while (i2 < string.size()) {
                    keyAt = string.keyAt(i2);
                    valueAt = string.valueAt(i2);
                    stringBuilder += valueAt;
                    if (keyAt > 700) {
                    }
                    if (keyAt > 16) {
                    }
                    i2++;
                    i4 += valueAt;
                    i += valueAt;
                }
                i2 = stringBuilder;
            } else {
                i = i4;
            }
        } else {
        }
        if (i2 > 0) {
            (Trace)obj.putMetric(Constants.CounterNames.FRAMES_TOTAL.toString(), (long)i2);
        }
        if (i4 > 0) {
            obj.putMetric(Constants.CounterNames.FRAMES_SLOW.toString(), (long)i4);
        }
        if (i > 0) {
            obj.putMetric(Constants.CounterNames.FRAMES_FROZEN.toString(), (long)i);
        }
        if (Utils.isDebugLoggingEnabled(activity.getApplicationContext())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("sendScreenTrace name:");
            stringBuilder.append(AppStateMonitor.getScreenTraceName(activity));
            stringBuilder.append(" _fr_tot:");
            stringBuilder.append(i2);
            stringBuilder.append(" _fr_slo:");
            stringBuilder.append(i4);
            stringBuilder.append(" _fr_fzn:");
            stringBuilder.append(i);
            AppStateMonitor.logger.debug(stringBuilder.toString());
        }
        obj.stop();
    }

    private void sendSessionLog(String string, Timer timer2, Timer timer3) {
        Object metricToCountMap;
        long l;
        if (!this.configResolver.isPerformanceMonitoringEnabled()) {
        }
        TraceMetric.Builder obj4 = TraceMetric.newBuilder().setName(string).setClientStartTimeUs(timer2.getMicros()).setDurationUs(timer2.getDurationMicros(timer3)).addPerfSessions(SessionManager.getInstance().perfSession().build());
        int obj5 = this.tsnsCount.getAndSet(0);
        Map obj6 = this.metricToCountMap;
        obj4.putAllCounters(this.metricToCountMap);
        synchronized (obj6) {
            obj4.putCounters(Constants.CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), (long)obj5);
            this.metricToCountMap.clear();
            this.transportManager.log((TraceMetric)obj4.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
        }
    }

    private void updateAppState(ApplicationProcessState applicationProcessState) {
        Object obj;
        ApplicationProcessState currentAppState;
        this.currentAppState = applicationProcessState;
        final Set obj4 = this.appStateSubscribers;
        Iterator iterator = this.appStateSubscribers.iterator();
        synchronized (obj4) {
            while (iterator.hasNext()) {
                obj = (WeakReference)iterator.next().get();
                if ((AppStateMonitor.AppStateCallback)obj != null) {
                } else {
                }
                iterator.remove();
                (AppStateMonitor.AppStateCallback)obj.onUpdateAppState(this.currentAppState);
            }
            try {
                throw th;
            }
        }
    }

    WeakHashMap<Activity, Trace> getActivity2ScreenTrace() {
        return this.activityToScreenTraceMap;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public ApplicationProcessState getAppState() {
        return this.currentAppState;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    Timer getPauseTime() {
        return this.stopTime;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    Timer getResumeTime() {
        return this.resumeTime;
    }

    WeakHashMap<Activity, Boolean> getResumed() {
        return this.activityToResumedMap;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void incrementCount(String string, long l2) {
        Object metricToCountMap;
        Map metricToCountMap2;
        int i;
        Long obj7;
        final Map metricToCountMap3 = this.metricToCountMap;
        metricToCountMap = this.metricToCountMap.get(string);
        synchronized (metricToCountMap3) {
            this.metricToCountMap.put(string, Long.valueOf(l2));
            try {
                throw string;
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void incrementTsnsCount(int i) {
        this.tsnsCount.addAndGet(i);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public boolean isColdStart() {
        return this.isColdStart;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public boolean isForeground() {
        int i;
        i = this.currentAppState == ApplicationProcessState.FOREGROUND ? 1 : 0;
        return i;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle2) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Object activityToResumedMap;
        Object resumeTime;
        String obj3;
        synchronized (this) {
            try {
                this.resumeTime = this.clock.getTime();
                this.activityToResumedMap.put(activity, Boolean.TRUE);
                updateAppState(ApplicationProcessState.FOREGROUND);
                if (this.isColdStart) {
                } else {
                }
                sendAppColdStartUpdate();
                this.isColdStart = false;
                sendSessionLog(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString(), this.stopTime, this.resumeTime);
                this.activityToResumedMap.put(activity, Boolean.TRUE);
                throw activity;
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        boolean screenTraceSupported;
        WeakHashMap activityToScreenTraceMap;
        TransportManager transportManager;
        Clock clock;
        synchronized (this) {
            try {
                if (this.configResolver.isPerformanceMonitoringEnabled()) {
                }
                this.frameMetricsAggregator.a(activity);
                screenTraceSupported = new Trace(AppStateMonitor.getScreenTraceName(activity), this.transportManager, this.clock, this);
                screenTraceSupported.start();
                this.activityToScreenTraceMap.put(activity, screenTraceSupported);
                throw activity;
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        boolean activityToResumedMap;
        Timer stopTime;
        Activity obj3;
        synchronized (this) {
            try {
                sendScreenTrace(activity);
                this.activityToResumedMap.remove(activity);
                if (this.activityToResumedMap.containsKey(activity) && this.activityToResumedMap.isEmpty()) {
                }
                this.activityToResumedMap.remove(activity);
                if (this.activityToResumedMap.isEmpty()) {
                }
                this.stopTime = this.clock.getTime();
                updateAppState(ApplicationProcessState.BACKGROUND);
                sendSessionLog(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString(), this.resumeTime, this.stopTime);
                throw activity;
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void registerActivityLifecycleCallbacks(Context context) {
        Context obj2;
        synchronized (this) {
            try {
                obj2 = context.getApplicationContext();
            }
            (Application)obj2.registerActivityLifecycleCallbacks(this);
            this.isRegisteredForLifecycleCallbacks = true;
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void registerForAppColdStart(com.google.firebase.perf.application.AppStateMonitor.AppColdStartCallback appStateMonitor$AppColdStartCallback) {
        final Set appStateSubscribers = this.appStateSubscribers;
        this.appColdStartSubscribers.add(appColdStartCallback);
        return;
        synchronized (appStateSubscribers) {
            appStateSubscribers = this.appStateSubscribers;
            this.appColdStartSubscribers.add(appColdStartCallback);
        }
    }

    public void registerForAppState(WeakReference<com.google.firebase.perf.application.AppStateMonitor.AppStateCallback> weakReference) {
        final Set appStateSubscribers = this.appStateSubscribers;
        this.appStateSubscribers.add(weakReference);
        return;
        synchronized (appStateSubscribers) {
            appStateSubscribers = this.appStateSubscribers;
            this.appStateSubscribers.add(weakReference);
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void setIsColdStart(boolean z) {
        this.isColdStart = z;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void unregisterActivityLifecycleCallbacks(Context context) {
        Context obj2;
        synchronized (this) {
            try {
                obj2 = context.getApplicationContext();
            }
            (Application)obj2.unregisterActivityLifecycleCallbacks(this);
            this.isRegisteredForLifecycleCallbacks = false;
        }
    }

    public void unregisterForAppState(WeakReference<com.google.firebase.perf.application.AppStateMonitor.AppStateCallback> weakReference) {
        final Set appStateSubscribers = this.appStateSubscribers;
        this.appStateSubscribers.remove(weakReference);
        return;
        synchronized (appStateSubscribers) {
            appStateSubscribers = this.appStateSubscribers;
            this.appStateSubscribers.remove(weakReference);
        }
    }
}
