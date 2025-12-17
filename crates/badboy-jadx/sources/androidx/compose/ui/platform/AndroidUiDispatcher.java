package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.compose.runtime.MonotonicFrameClock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0008*\u0001\n\u0008\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\u0008\u0010%\u001a\u00020\u001dH\u0002J\u0015\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0008(J\u0015\u0010)\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0008*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Landroidx/compose/ui/platform/AndroidUiDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "choreographer", "Landroid/view/Choreographer;", "handler", "Landroid/os/Handler;", "(Landroid/view/Choreographer;Landroid/os/Handler;)V", "getChoreographer", "()Landroid/view/Choreographer;", "dispatchCallback", "androidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1", "Landroidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1;", "frameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "lock", "", "scheduledFrameDispatch", "", "scheduledTrampolineDispatch", "spareToRunOnFrame", "", "Landroid/view/Choreographer$FrameCallback;", "toRunOnFrame", "toRunTrampolined", "Lkotlin/collections/ArrayDeque;", "Ljava/lang/Runnable;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "nextTask", "performFrameDispatch", "frameTimeNanos", "", "performTrampolineDispatch", "postFrameCallback", "callback", "postFrameCallback$ui_release", "removeFrameCallback", "removeFrameCallback$ui_release", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidUiDispatcher extends CoroutineDispatcher {

    public static final int $stable = 8;
    public static final androidx.compose.ui.platform.AndroidUiDispatcher.Companion Companion;
    private static final Lazy<CoroutineContext> Main$delegate;
    private static final java.lang.ThreadLocal<CoroutineContext> currentThread;
    private final Choreographer choreographer;
    private final androidx.compose.ui.platform.AndroidUiDispatcher.dispatchCallback.1 dispatchCallback;
    private final MonotonicFrameClock frameClock;
    private final Handler handler;
    private final Object lock;
    private boolean scheduledFrameDispatch;
    private boolean scheduledTrampolineDispatch;
    private List<Choreographer.FrameCallback> spareToRunOnFrame;
    private List<Choreographer.FrameCallback> toRunOnFrame;
    private final ArrayDeque<Runnable> toRunTrampolined;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0008\u0010\u0006R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/ui/platform/AndroidUiDispatcher$Companion;", "", "()V", "CurrentThread", "Lkotlin/coroutines/CoroutineContext;", "getCurrentThread", "()Lkotlin/coroutines/CoroutineContext;", "Main", "getMain", "Main$delegate", "Lkotlin/Lazy;", "currentThread", "Ljava/lang/ThreadLocal;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final CoroutineContext getCurrentThread() {
            Object main;
            if (AndroidUiDispatcher_androidKt.access$isMainThread()) {
                main = getMain();
                return main;
            } else {
                if ((CoroutineContext)AndroidUiDispatcher.access$getCurrentThread$cp().get() == null) {
                } else {
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
            throw illegalStateException;
        }

        public final CoroutineContext getMain() {
            return (CoroutineContext)AndroidUiDispatcher.access$getMain$delegate$cp().getValue();
        }
    }
    static {
        AndroidUiDispatcher.Companion companion = new AndroidUiDispatcher.Companion(0);
        AndroidUiDispatcher.Companion = companion;
        int i = 8;
        AndroidUiDispatcher.Main$delegate = LazyKt.lazy((Function0)AndroidUiDispatcher.Companion.Main.2.INSTANCE);
        AndroidUiDispatcher.Companion.currentThread.1 anon = new AndroidUiDispatcher.Companion.currentThread.1();
        AndroidUiDispatcher.currentThread = (ThreadLocal)anon;
    }

    private AndroidUiDispatcher(Choreographer choreographer, Handler handler) {
        super();
        this.choreographer = choreographer;
        this.handler = handler;
        Object object = new Object();
        this.lock = object;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.toRunTrampolined = arrayDeque;
        ArrayList arrayList = new ArrayList();
        this.toRunOnFrame = (List)arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.spareToRunOnFrame = (List)arrayList2;
        AndroidUiDispatcher.dispatchCallback.1 anon = new AndroidUiDispatcher.dispatchCallback.1(this);
        this.dispatchCallback = anon;
        AndroidUiFrameClock androidUiFrameClock = new AndroidUiFrameClock(this.choreographer, this);
        this.frameClock = (MonotonicFrameClock)androidUiFrameClock;
    }

    public AndroidUiDispatcher(Choreographer choreographer, Handler handler2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(choreographer, handler2);
    }

    public static final java.lang.ThreadLocal access$getCurrentThread$cp() {
        return AndroidUiDispatcher.currentThread;
    }

    public static final Handler access$getHandler$p(androidx.compose.ui.platform.AndroidUiDispatcher $this) {
        return $this.handler;
    }

    public static final Object access$getLock$p(androidx.compose.ui.platform.AndroidUiDispatcher $this) {
        return $this.lock;
    }

    public static final Lazy access$getMain$delegate$cp() {
        return AndroidUiDispatcher.Main$delegate;
    }

    public static final List access$getToRunOnFrame$p(androidx.compose.ui.platform.AndroidUiDispatcher $this) {
        return $this.toRunOnFrame;
    }

    public static final void access$performFrameDispatch(androidx.compose.ui.platform.AndroidUiDispatcher $this, long frameTimeNanos) {
        $this.performFrameDispatch(frameTimeNanos);
    }

    public static final void access$performTrampolineDispatch(androidx.compose.ui.platform.AndroidUiDispatcher $this) {
        $this.performTrampolineDispatch();
    }

    public static final void access$setScheduledFrameDispatch$p(androidx.compose.ui.platform.AndroidUiDispatcher $this, boolean <set-?>) {
        $this.scheduledFrameDispatch = <set-?>;
    }

    private final Runnable nextTask() {
        final Object lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        return (Runnable)this.toRunTrampolined.removeFirstOrNull();
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            return (Runnable)this.toRunTrampolined.removeFirstOrNull();
        }
    }

    private final void performFrameDispatch(long frameTimeNanos) {
        int i2;
        int i;
        Object lock = this.lock;
        int i3 = 0;
        i = 0;
        synchronized (lock) {
        }
        while (i2 < size) {
            (Choreographer.FrameCallback)toRunOnFrame.get(i2).doFrame(frameTimeNanos);
            i2++;
        }
        try {
            toRunOnFrame.clear();
            throw th;
        }
    }

    private final void performTrampolineDispatch() {
        Object task;
        Runnable task2;
        int i2;
        Throwable th;
        int i;
        do {
            task2 = nextTask();
            while (task2 != null) {
                task2.run();
                task2 = nextTask();
            }
            task = this.lock;
            i2 = 0;
            th = 0;
            if (this.toRunTrampolined.isEmpty()) {
            } else {
            }
            i = 1;
            if (i != 0) {
            }
            this.scheduledTrampolineDispatch = false;
            task2.run();
            task2 = nextTask();
        } while (/* condition */);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        boolean scheduledTrampolineDispatch;
        boolean scheduledFrameDispatch;
        androidx.compose.ui.platform.AndroidUiDispatcher.dispatchCallback.1 dispatchCallback;
        final Object lock = this.lock;
        final int i = 0;
        int i2 = 0;
        this.toRunTrampolined.addLast(block);
        synchronized (lock) {
            scheduledTrampolineDispatch = 1;
            this.scheduledTrampolineDispatch = scheduledTrampolineDispatch;
            this.handler.post((Runnable)this.dispatchCallback);
            if (!this.scheduledFrameDispatch) {
                this.scheduledFrameDispatch = scheduledTrampolineDispatch;
                this.choreographer.postFrameCallback((Choreographer.FrameCallback)this.dispatchCallback);
            }
            Unit $i$a$SynchronizedAndroidUiDispatcher$dispatch$1 = Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final MonotonicFrameClock getFrameClock() {
        return this.frameClock;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void postFrameCallback$ui_release(Choreographer.FrameCallback callback) {
        boolean scheduledFrameDispatch;
        androidx.compose.ui.platform.AndroidUiDispatcher.dispatchCallback.1 dispatchCallback;
        final Object lock = this.lock;
        final int i = 0;
        int i2 = 0;
        this.toRunOnFrame.add(callback);
        synchronized (lock) {
            this.scheduledFrameDispatch = true;
            this.choreographer.postFrameCallback((Choreographer.FrameCallback)this.dispatchCallback);
            Unit $i$a$SynchronizedAndroidUiDispatcher$postFrameCallback$1 = Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void removeFrameCallback$ui_release(Choreographer.FrameCallback callback) {
        final Object lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        this.toRunOnFrame.remove(callback);
        return;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            this.toRunOnFrame.remove(callback);
        }
    }
}
