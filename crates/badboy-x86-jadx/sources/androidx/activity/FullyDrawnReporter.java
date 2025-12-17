package androidx.activity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0014\u001a\u00020\u00062\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u0016\u001a\u00020\u0006J\u0008\u0010\u0017\u001a\u00020\u0006H\u0007J\u0008\u0010\u0018\u001a\u00020\u0006H\u0002J\u0014\u0010\u0019\u001a\u00020\u00062\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Landroidx/activity/FullyDrawnReporter;", "", "executor", "Ljava/util/concurrent/Executor;", "reportFullyDrawn", "Lkotlin/Function0;", "", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;)V", "isFullyDrawnReported", "", "()Z", "lock", "onReportCallbacks", "", "reportPosted", "reportRunnable", "Ljava/lang/Runnable;", "reportedFullyDrawn", "reporterCount", "", "addOnReportDrawnListener", "callback", "addReporter", "fullyDrawnReported", "postWhenReportersAreDone", "removeOnReportDrawnListener", "removeReporter", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FullyDrawnReporter {

    private final Executor executor;
    private final Object lock;
    private final List<Function0<Unit>> onReportCallbacks;
    private final Function0<Unit> reportFullyDrawn;
    private boolean reportPosted;
    private final Runnable reportRunnable;
    private boolean reportedFullyDrawn;
    private int reporterCount;
    public static void $r8$lambda$A0RwxxT-QIMFOsDA3Nv48auR1K4(androidx.activity.FullyDrawnReporter fullyDrawnReporter) {
        FullyDrawnReporter.reportRunnable$lambda$2(fullyDrawnReporter);
    }

    public FullyDrawnReporter(Executor executor, Function0<Unit> reportFullyDrawn) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(reportFullyDrawn, "reportFullyDrawn");
        super();
        this.executor = executor;
        this.reportFullyDrawn = reportFullyDrawn;
        Object object = new Object();
        this.lock = object;
        ArrayList arrayList = new ArrayList();
        this.onReportCallbacks = (List)arrayList;
        FullyDrawnReporter$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new FullyDrawnReporter$$ExternalSyntheticLambda0(this);
        this.reportRunnable = externalSyntheticLambda0;
    }

    private final void postWhenReportersAreDone() {
        boolean reporterCount;
        Runnable reportRunnable;
        if (!this.reportPosted && this.reporterCount == 0) {
            if (this.reporterCount == 0) {
                this.reportPosted = true;
                this.executor.execute(this.reportRunnable);
            }
        }
    }

    private static final void reportRunnable$lambda$2(androidx.activity.FullyDrawnReporter this$0) {
        int reportedFullyDrawn;
        final Object lock = this$0.lock;
        int i = 0;
        this$0.reportPosted = false;
        synchronized (lock) {
            if (!this$0.reportedFullyDrawn) {
                this$0.reportFullyDrawn.invoke();
                this$0.fullyDrawnReported();
            }
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }

    public final void addOnReportDrawnListener(Function0<Unit> callback) {
        int i;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object lock = this.lock;
        final int i2 = 0;
        synchronized (lock) {
            i = 1;
            if (i != 0) {
            }
        }
        callback.invoke();
    }

    public final void addReporter() {
        boolean reportedFullyDrawn;
        final Object lock = this.lock;
        int i = 0;
        synchronized (lock) {
            this.reporterCount = reporterCount++;
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }

    public final void fullyDrawnReported() {
        Object next;
        Object obj;
        int i;
        final Object lock = this.lock;
        int i2 = 0;
        this.reportedFullyDrawn = true;
        final int i4 = 0;
        final Iterator iterator = (Iterable)this.onReportCallbacks.iterator();
        synchronized (lock) {
            for (Object next : iterator) {
                i = 0;
                (Function0)next.invoke();
            }
            this.onReportCallbacks.clear();
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }

    public final boolean isFullyDrawnReported() {
        final Object lock = this.lock;
        final int i = 0;
        return this.reportedFullyDrawn;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            return this.reportedFullyDrawn;
        }
    }

    public final void removeOnReportDrawnListener(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object lock = this.lock;
        int i = 0;
        (Collection)this.onReportCallbacks.remove(callback);
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            lock = this.lock;
            i = 0;
            (Collection)this.onReportCallbacks.remove(callback);
            iNSTANCE = Unit.INSTANCE;
        }
    }

    public final void removeReporter() {
        boolean reportedFullyDrawn;
        final Object lock = this.lock;
        int i = 0;
        synchronized (lock) {
            if (this.reporterCount > 0) {
                this.reporterCount = reporterCount--;
                postWhenReportersAreDone();
            }
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }
}
