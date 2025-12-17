package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants.TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric.Builder;
import com.google.protobuf.z.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks {

    private static final long MAX_LATENCY_BEFORE_UI_INIT;
    private static volatile com.google.firebase.perf.metrics.AppStartTrace instance;
    private Context appContext;
    private WeakReference<Activity> appStartActivity;
    private final Clock clock;
    private boolean isRegisteredForLifecycleCallbacks = false;
    private boolean isStartedFromBackground = false;
    private boolean isTooLateToInitUI = false;
    private WeakReference<Activity> launchActivity;
    private Timer onCreateTime = null;
    private Timer onResumeTime = null;
    private Timer onStartTime = null;
    private final TransportManager transportManager;

    public static class StartFromBackgroundRunnable implements Runnable {

        private final com.google.firebase.perf.metrics.AppStartTrace trace;
        public StartFromBackgroundRunnable(com.google.firebase.perf.metrics.AppStartTrace appStartTrace) {
            super();
            this.trace = appStartTrace;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object trace;
            int i;
            if (AppStartTrace.access$000(this.trace) == null) {
                AppStartTrace.access$102(this.trace, true);
            }
        }
    }
    static {
        AppStartTrace.MAX_LATENCY_BEFORE_UI_INIT = TimeUnit.MINUTES.toMicros(1);
    }

    AppStartTrace(TransportManager transportManager, Clock clock2) {
        super();
        final int i = 0;
        final int i2 = 0;
        this.transportManager = transportManager;
        this.clock = clock2;
    }

    static Timer access$000(com.google.firebase.perf.metrics.AppStartTrace appStartTrace) {
        return appStartTrace.onCreateTime;
    }

    static boolean access$102(com.google.firebase.perf.metrics.AppStartTrace appStartTrace, boolean z2) {
        appStartTrace.isStartedFromBackground = z2;
        return z2;
    }

    public static com.google.firebase.perf.metrics.AppStartTrace getInstance() {
        com.google.firebase.perf.metrics.AppStartTrace instance;
        Clock clock;
        if (AppStartTrace.instance != null) {
            instance = AppStartTrace.instance;
        } else {
            clock = new Clock();
            instance = AppStartTrace.getInstance(TransportManager.getInstance(), clock);
        }
        return instance;
    }

    static com.google.firebase.perf.metrics.AppStartTrace getInstance(TransportManager transportManager, Clock clock2) {
        com.google.firebase.perf.metrics.AppStartTrace instance;
        com.google.firebase.perf.metrics.AppStartTrace appStartTrace;
        instance = AppStartTrace.class;
        if (AppStartTrace.instance == null && AppStartTrace.instance == null) {
            instance = AppStartTrace.class;
            synchronized (instance) {
                appStartTrace = new AppStartTrace(transportManager, clock2);
                AppStartTrace.instance = appStartTrace;
            }
        }
        return AppStartTrace.instance;
    }

    public static void setLauncherActivityOnCreateTime(String string) {
    }

    public static void setLauncherActivityOnResumeTime(String string) {
    }

    public static void setLauncherActivityOnStartTime(String string) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    Activity getAppStartActivity() {
        return (Activity)this.appStartActivity.get();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    Activity getLaunchActivity() {
        return (Activity)this.launchActivity.get();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    Timer getOnCreateTime() {
        return this.onCreateTime;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    Timer getOnResumeTime() {
        return this.onResumeTime;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    Timer getOnStartTime() {
        return this.onStartTime;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle2) {
        int obj3;
        boolean obj4;
        synchronized (this) {
            try {
                if (this.onCreateTime != null) {
                } else {
                }
                obj4 = new WeakReference(activity);
                this.launchActivity = obj4;
                this.onCreateTime = this.clock.getTime();
                if (Long.compare(obj3, mAX_LATENCY_BEFORE_UI_INIT) > 0) {
                }
                this.isTooLateToInitUI = true;
                throw activity;
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        boolean isStartedFromBackground;
        synchronized (this) {
            try {
                if (this.onResumeTime == null) {
                }
                if (this.isTooLateToInitUI) {
                } else {
                }
                WeakReference weakReference = new WeakReference(activity);
                this.appStartActivity = weakReference;
                this.onResumeTime = this.clock.getTime();
                Timer appStartTime = FirebasePerfProvider.getAppStartTime();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onResume(): ");
                stringBuilder.append(activity.getClass().getName());
                stringBuilder.append(": ");
                stringBuilder.append(appStartTime.getDurationMicros(this.onResumeTime));
                stringBuilder.append(" microseconds");
                AndroidLogger.getInstance().debug(stringBuilder.toString());
                TraceMetric.Builder obj6 = TraceMetric.newBuilder().setName(Constants.TraceNames.APP_START_TRACE_NAME.toString()).setClientStartTimeUs(appStartTime.getMicros()).setDurationUs(appStartTime.getDurationMicros(this.onResumeTime));
                ArrayList arrayList = new ArrayList(3);
                arrayList.add((TraceMetric)TraceMetric.newBuilder().setName(Constants.TraceNames.ON_CREATE_TRACE_NAME.toString()).setClientStartTimeUs(appStartTime.getMicros()).setDurationUs(appStartTime.getDurationMicros(this.onCreateTime)).build());
                TraceMetric.Builder builder = TraceMetric.newBuilder();
                Timer onStartTime3 = this.onStartTime;
                builder.setName(Constants.TraceNames.ON_START_TRACE_NAME.toString()).setClientStartTimeUs(this.onCreateTime.getMicros()).setDurationUs(this.onCreateTime.getDurationMicros(onStartTime3));
                arrayList.add((TraceMetric)builder.build());
                TraceMetric.Builder builder2 = TraceMetric.newBuilder();
                Timer onResumeTime2 = this.onResumeTime;
                builder2.setName(Constants.TraceNames.ON_RESUME_TRACE_NAME.toString()).setClientStartTimeUs(this.onStartTime.getMicros()).setDurationUs(this.onStartTime.getDurationMicros(onResumeTime2));
                arrayList.add((TraceMetric)builder2.build());
                obj6.addAllSubtraces(arrayList).addPerfSessions(SessionManager.getInstance().perfSession().build());
                this.transportManager.log((TraceMetric)obj6.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
                if (this.isRegisteredForLifecycleCallbacks) {
                }
                unregisterActivityLifecycleCallbacks();
                throw activity;
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        boolean obj1;
        synchronized (this) {
            try {
                if (this.onStartTime == null) {
                }
                if (this.isTooLateToInitUI) {
                }
                this.onStartTime = this.clock.getTime();
                throw activity;
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        return;
        synchronized (this) {
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void registerActivityLifecycleCallbacks(Context context) {
        boolean i;
        synchronized (this) {
            try {
                final Context obj2 = context.getApplicationContext();
            }
            (Application)obj2.registerActivityLifecycleCallbacks(this);
            this.isRegisteredForLifecycleCallbacks = true;
            this.appContext = obj2;
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    void setIsStartFromBackground() {
        this.isStartedFromBackground = true;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void unregisterActivityLifecycleCallbacks() {
        synchronized (this) {
            try {
                (Application)this.appContext.unregisterActivityLifecycleCallbacks(this);
                this.isRegisteredForLifecycleCallbacks = false;
            }
        }
    }
}
