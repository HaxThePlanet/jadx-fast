package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Landroidx/lifecycle/LifecycleDispatcher;", "", "<init>", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", "", "context", "Landroid/content/Context;", "DispatcherActivityCallback", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifecycleDispatcher {

    public static final androidx.lifecycle.LifecycleDispatcher INSTANCE;
    private static final AtomicBoolean initialized;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n", d2 = {"Landroidx/lifecycle/LifecycleDispatcher$DispatcherActivityCallback;", "Landroidx/lifecycle/EmptyActivityLifecycleCallbacks;", "<init>", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DispatcherActivityCallback extends androidx.lifecycle.EmptyActivityLifecycleCallbacks {
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ReportFragment.Companion.injectIfNeededIn(activity);
        }
    }
    static {
        LifecycleDispatcher lifecycleDispatcher = new LifecycleDispatcher();
        LifecycleDispatcher.INSTANCE = lifecycleDispatcher;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        LifecycleDispatcher.initialized = atomicBoolean;
    }

    @JvmStatic
    public static final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (LifecycleDispatcher.initialized.getAndSet(true)) {
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        LifecycleDispatcher.DispatcherActivityCallback dispatcherActivityCallback = new LifecycleDispatcher.DispatcherActivityCallback();
        (Application)applicationContext.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)dispatcherActivityCallback);
    }
}
