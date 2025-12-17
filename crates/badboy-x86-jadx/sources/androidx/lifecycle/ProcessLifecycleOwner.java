package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 '2\u00020\u0001:\u0002'(B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0008\u0014J\r\u0010\u0015\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0008\u0016J\r\u0010\u0017\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0008\u0018J\r\u0010\u0019\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0008\u001aJ\r\u0010\u001b\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0008\u001cJ\r\u0010\u001d\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0008\u001eJ\u0015\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\u0008\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010&¨\u0006)", d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "startedCounter", "", "resumedCounter", "pauseSent", "", "stopSent", "handler", "Landroid/os/Handler;", "registry", "Landroidx/lifecycle/LifecycleRegistry;", "delayedPauseRunnable", "Ljava/lang/Runnable;", "initializationListener", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "activityStarted", "", "activityStarted$lifecycle_process_release", "activityResumed", "activityResumed$lifecycle_process_release", "activityPaused", "activityPaused$lifecycle_process_release", "activityStopped", "activityStopped$lifecycle_process_release", "dispatchPauseIfNeeded", "dispatchPauseIfNeeded$lifecycle_process_release", "dispatchStopIfNeeded", "dispatchStopIfNeeded$lifecycle_process_release", "attach", "context", "Landroid/content/Context;", "attach$lifecycle_process_release", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Companion", "Api29Impl", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProcessLifecycleOwner implements androidx.lifecycle.LifecycleOwner {

    public static final androidx.lifecycle.ProcessLifecycleOwner.Companion Companion = null;
    public static final long TIMEOUT_MS = 700L;
    private static final androidx.lifecycle.ProcessLifecycleOwner newInstance;
    private final Runnable delayedPauseRunnable;
    private Handler handler;
    private final androidx.lifecycle.ReportFragment.ActivityInitializationListener initializationListener;
    private boolean pauseSent = true;
    private final androidx.lifecycle.LifecycleRegistry registry;
    private int resumedCounter;
    private int startedCounter;
    private boolean stopSent = true;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Á\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0007¨\u0006\n", d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner$Api29Impl;", "", "<init>", "()V", "registerActivityLifecycleCallbacks", "", "activity", "Landroid/app/Activity;", "callback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Api29Impl {

        public static final androidx.lifecycle.ProcessLifecycleOwner.Api29Impl INSTANCE;
        static {
            ProcessLifecycleOwner.Api29Impl api29Impl = new ProcessLifecycleOwner.Api29Impl();
            ProcessLifecycleOwner.Api29Impl.INSTANCE = api29Impl;
        }

        @JvmStatic
        public static final void registerActivityLifecycleCallbacks(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0008\u0010\t\u001a\u00020\nH\u0007J\u0015\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0008\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0003R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner$Companion;", "", "<init>", "()V", "TIMEOUT_MS", "", "getTIMEOUT_MS$lifecycle_process_release$annotations", "newInstance", "Landroidx/lifecycle/ProcessLifecycleOwner;", "get", "Landroidx/lifecycle/LifecycleOwner;", "init", "", "context", "Landroid/content/Context;", "init$lifecycle_process_release", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getTIMEOUT_MS$lifecycle_process_release$annotations() {
        }

        @JvmStatic
        public final androidx.lifecycle.LifecycleOwner get() {
            return (LifecycleOwner)ProcessLifecycleOwner.access$getNewInstance$cp();
        }

        @JvmStatic
        public final void init$lifecycle_process_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ProcessLifecycleOwner.access$getNewInstance$cp().attach$lifecycle_process_release(context);
        }
    }
    public static void $r8$lambda$ArPpV1aF4irVI-oizc48o3VfLys(androidx.lifecycle.ProcessLifecycleOwner processLifecycleOwner) {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(processLifecycleOwner);
    }

    static {
        ProcessLifecycleOwner.Companion companion = new ProcessLifecycleOwner.Companion(0);
        ProcessLifecycleOwner.Companion = companion;
        ProcessLifecycleOwner processLifecycleOwner = new ProcessLifecycleOwner();
        ProcessLifecycleOwner.newInstance = processLifecycleOwner;
    }

    private ProcessLifecycleOwner() {
        super();
        int i = 1;
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
        this.registry = lifecycleRegistry;
        ProcessLifecycleOwner$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ProcessLifecycleOwner$$ExternalSyntheticLambda0(this);
        this.delayedPauseRunnable = externalSyntheticLambda0;
        ProcessLifecycleOwner.initializationListener.1 anon = new ProcessLifecycleOwner.initializationListener.1(this);
        this.initializationListener = (ReportFragment.ActivityInitializationListener)anon;
    }

    public static final androidx.lifecycle.ReportFragment.ActivityInitializationListener access$getInitializationListener$p(androidx.lifecycle.ProcessLifecycleOwner $this) {
        return $this.initializationListener;
    }

    public static final androidx.lifecycle.ProcessLifecycleOwner access$getNewInstance$cp() {
        return ProcessLifecycleOwner.newInstance;
    }

    private static final void delayedPauseRunnable$lambda$0(androidx.lifecycle.ProcessLifecycleOwner this$0) {
        this$0.dispatchPauseIfNeeded$lifecycle_process_release();
        this$0.dispatchStopIfNeeded$lifecycle_process_release();
    }

    @JvmStatic
    public static final androidx.lifecycle.LifecycleOwner get() {
        return ProcessLifecycleOwner.Companion.get();
    }

    @JvmStatic
    public static final void init$lifecycle_process_release(Context context) {
        ProcessLifecycleOwner.Companion.init$lifecycle_process_release(context);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final void activityPaused$lifecycle_process_release() {
        int resumedCounter;
        Runnable delayedPauseRunnable;
        int i;
        this.resumedCounter = resumedCounter2--;
        if (this.resumedCounter == 0) {
            resumedCounter = this.handler;
            Intrinsics.checkNotNull(resumedCounter);
            resumedCounter.postDelayed(this.delayedPauseRunnable, 700);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final void activityResumed$lifecycle_process_release() {
        int resumedCounter;
        int delayedPauseRunnable;
        delayedPauseRunnable = 1;
        this.resumedCounter = resumedCounter2 += delayedPauseRunnable;
        if (this.resumedCounter == delayedPauseRunnable) {
            if (this.pauseSent) {
                this.registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                this.pauseSent = false;
            } else {
                resumedCounter = this.handler;
                Intrinsics.checkNotNull(resumedCounter);
                resumedCounter.removeCallbacks(this.delayedPauseRunnable);
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final void activityStarted$lifecycle_process_release() {
        int startedCounter;
        int oN_START;
        oN_START = 1;
        this.startedCounter = startedCounter2 += oN_START;
        if (this.startedCounter == oN_START && this.stopSent) {
            if (this.stopSent) {
                this.registry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                this.stopSent = false;
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final void activityStopped$lifecycle_process_release() {
        this.startedCounter = startedCounter--;
        dispatchStopIfNeeded$lifecycle_process_release();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final void attach$lifecycle_process_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Handler handler = new Handler();
        this.handler = handler;
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ProcessLifecycleOwner.attach.1 anon = new ProcessLifecycleOwner.attach.1(this);
        (Application)applicationContext.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)anon);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final void dispatchPauseIfNeeded$lifecycle_process_release() {
        int resumedCounter;
        androidx.lifecycle.Lifecycle.Event oN_PAUSE;
        if (this.resumedCounter == 0) {
            this.pauseSent = true;
            this.registry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final void dispatchStopIfNeeded$lifecycle_process_release() {
        int startedCounter;
        androidx.lifecycle.Lifecycle.Event oN_STOP;
        if (this.startedCounter == 0 && this.pauseSent) {
            if (this.pauseSent) {
                this.registry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                this.stopSent = true;
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return (Lifecycle)this.registry;
    }
}
