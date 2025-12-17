package androidx.compose.foundation.lazy.layout;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.View;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0008\u0001\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000cH\u0016J\u0008\u0010\u0016\u001a\u00020\u0014H\u0016J\u0008\u0010\u0017\u001a\u00020\u0014H\u0016J\u0008\u0010\u0018\u001a\u00020\u0014H\u0016J\u0008\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0011H\u0016R\u0016\u0010\u0008\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler;", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "Landroidx/compose/runtime/RememberObserver;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "frameStartTimeNanos", "", "isActive", "", "prefetchRequests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "prefetchScheduled", "doFrame", "", "frameTimeNanos", "onAbandoned", "onForgotten", "onRemembered", "run", "schedulePrefetch", "prefetchRequest", "Companion", "PrefetchRequestScopeImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidPrefetchScheduler implements androidx.compose.foundation.lazy.layout.PrefetchScheduler, RememberObserver, Runnable, Choreographer.FrameCallback {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.lazy.layout.AndroidPrefetchScheduler.Companion Companion;
    private static long frameIntervalNs;
    private final Choreographer choreographer;
    private long frameStartTimeNanos;
    private boolean isActive;
    private final MutableVector<androidx.compose.foundation.lazy.layout.PrefetchRequest> prefetchRequests;
    private boolean prefetchScheduled;
    private final View view;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$Companion;", "", "()V", "frameIntervalNs", "", "calculateFrameIntervalIfNeeded", "", "view", "Landroid/view/View;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final void access$calculateFrameIntervalIfNeeded(androidx.compose.foundation.lazy.layout.AndroidPrefetchScheduler.Companion $this, View view) {
            $this.calculateFrameIntervalIfNeeded(view);
        }

        private final void calculateFrameIntervalIfNeeded(View view) {
            int display;
            int refreshRate2;
            boolean refreshRate;
            int i;
            int cmp;
            display = view.getDisplay();
            refreshRate2 = 1114636288;
            refreshRate = display.getRefreshRate();
            if (Long.compare(l, i) == 0 && !view.isInEditMode() && display != null && Float.compare(refreshRate, i3) >= 0) {
                display = view.getDisplay();
                refreshRate2 = 1114636288;
                if (!view.isInEditMode()) {
                    if (display != null) {
                        refreshRate = display.getRefreshRate();
                        if (Float.compare(refreshRate, i3) >= 0) {
                            refreshRate2 = refreshRate;
                        }
                    }
                }
                AndroidPrefetchScheduler.access$setFrameIntervalNs$cp((long)i2);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$PrefetchRequestScopeImpl;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "nextFrameTimeNs", "", "(J)V", "availableTimeNanos", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PrefetchRequestScopeImpl implements androidx.compose.foundation.lazy.layout.PrefetchRequestScope {

        public static final int $stable;
        private final long nextFrameTimeNs;
        static {
        }

        public PrefetchRequestScopeImpl(long nextFrameTimeNs) {
            super();
            this.nextFrameTimeNs = nextFrameTimeNs;
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequestScope
        public long availableTimeNanos() {
            return Math.max(0, obj3);
        }
    }
    static {
        AndroidPrefetchScheduler.Companion companion = new AndroidPrefetchScheduler.Companion(0);
        AndroidPrefetchScheduler.Companion = companion;
        int i = 8;
    }

    public AndroidPrefetchScheduler(View view) {
        super();
        this.view = view;
        int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new PrefetchRequest[16], 0);
        this.prefetchRequests = mutableVector;
        this.choreographer = Choreographer.getInstance();
        AndroidPrefetchScheduler.Companion.access$calculateFrameIntervalIfNeeded(AndroidPrefetchScheduler.Companion, this.view);
    }

    public static final long access$getFrameIntervalNs$cp() {
        return AndroidPrefetchScheduler.frameIntervalNs;
    }

    public static final void access$setFrameIntervalNs$cp(long <set-?>) {
        AndroidPrefetchScheduler.frameIntervalNs = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void doFrame(long frameTimeNanos) {
        boolean isActive;
        Object obj;
        if (this.isActive) {
            this.frameStartTimeNanos = frameTimeNanos;
            this.view.post((Runnable)this);
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void onAbandoned() {
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void onForgotten() {
        this.isActive = false;
        this.view.removeCallbacks((Runnable)this);
        this.choreographer.removeFrameCallback((Choreographer.FrameCallback)this);
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void onRemembered() {
        this.isActive = true;
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void run() {
        boolean prefetchScheduled;
        Choreographer choreographer;
        int scheduleForNextFrame;
        Object this_$iv;
        Object notEmpty;
        boolean $this$run_u24lambda_u240;
        MutableVector prefetchRequests;
        androidx.compose.foundation.lazy.layout.AndroidPrefetchScheduler.PrefetchRequestScopeImpl request;
        choreographer = 0;
        if (!this.prefetchRequests.isEmpty() && this.prefetchScheduled && this.isActive) {
            if (this.prefetchScheduled) {
                if (this.isActive) {
                    if (this.view.getWindowVisibility() != 0) {
                    } else {
                        AndroidPrefetchScheduler.PrefetchRequestScopeImpl prefetchRequestScopeImpl = new AndroidPrefetchScheduler.PrefetchRequestScopeImpl(frameStartTimeNanos += frameIntervalNs, obj3);
                        scheduleForNextFrame = 0;
                        while (this.prefetchRequests.isNotEmpty()) {
                            if (scheduleForNextFrame == 0) {
                            }
                            if (Long.compare(availableTimeNanos, prefetchRequests) > 0) {
                            } else {
                            }
                            scheduleForNextFrame = 1;
                            int i3 = 0;
                            prefetchRequests = 0;
                            if ((PrefetchRequest)this.prefetchRequests.getContent()[0].execute((PrefetchRequestScope)prefetchRequestScopeImpl)) {
                            } else {
                            }
                            this.prefetchRequests.removeAt(choreographer);
                            scheduleForNextFrame = 1;
                        }
                        if (scheduleForNextFrame != 0) {
                            this.choreographer.postFrameCallback((Choreographer.FrameCallback)this);
                        } else {
                            this.prefetchScheduled = choreographer;
                        }
                    }
                }
            }
        }
        this.prefetchScheduled = choreographer;
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void schedulePrefetch(androidx.compose.foundation.lazy.layout.PrefetchRequest prefetchRequest) {
        boolean prefetchScheduled;
        Object obj;
        this.prefetchRequests.add(prefetchRequest);
        if (!this.prefetchScheduled) {
            this.prefetchScheduled = true;
            this.view.post((Runnable)this);
        }
    }
}
