package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\t\u0010\u0006\u001a\u00020\u0007H\u0081\u0008\u001a\t\u0010\u0008\u001a\u00020\u0007H\u0081\u0008\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0007H\u0081\u0008\u001a\t\u0010\u000e\u001a\u00020\nH\u0081\u0008\u001a\t\u0010\u000f\u001a\u00020\nH\u0081\u0008\u001a\t\u0010\u0010\u001a\u00020\nH\u0081\u0008\u001a\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0081\u0008\u001a\t\u0010\u0014\u001a\u00020\nH\u0081\u0008\u001a\u0019\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017H\u0081\u0008\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0004\u0008\u0004\u0010\u0005¨\u0006\u0019", d2 = {"timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "getTimeSource", "()Lkotlinx/coroutines/AbstractTimeSource;", "setTimeSource", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AbstractTimeSourceKt {

    private static kotlinx.coroutines.AbstractTimeSource timeSource;
    static {
    }

    private static final long currentTimeMillis() {
        long currentTimeMillis;
        kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            currentTimeMillis = timeSource.currentTimeMillis();
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        return currentTimeMillis;
    }

    public static final kotlinx.coroutines.AbstractTimeSource getTimeSource() {
        return AbstractTimeSourceKt.timeSource;
    }

    private static final long nanoTime() {
        long nanoTime;
        kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            nanoTime = timeSource.nanoTime();
        } else {
            nanoTime = System.nanoTime();
        }
        return nanoTime;
    }

    private static final void parkNanos(Object blocker, long nanos) {
        Unit iNSTANCE;
        kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        iNSTANCE = timeSource != null ? Unit.INSTANCE : 0;
        if (iNSTANCE == null) {
            LockSupport.parkNanos(blocker, nanos);
        }
    }

    private static final void registerTimeLoopThread() {
        final kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
    }

    public static final void setTimeSource(kotlinx.coroutines.AbstractTimeSource <set-?>) {
        AbstractTimeSourceKt.timeSource = <set-?>;
    }

    private static final void trackTask() {
        final kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
    }

    private static final void unTrackTask() {
        final kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.unTrackTask();
        }
    }

    private static final void unpark(Thread thread) {
        Unit iNSTANCE;
        kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        iNSTANCE = timeSource != null ? Unit.INSTANCE : 0;
        if (iNSTANCE == null) {
            LockSupport.unpark(thread);
        }
    }

    private static final void unregisterTimeLoopThread() {
        final kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.unregisterTimeLoopThread();
        }
    }

    private static final Runnable wrapTask(Runnable block) {
        Runnable timeSource;
        timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            if (timeSource.wrapTask(block) == null) {
                timeSource = block;
            }
        } else {
        }
        return timeSource;
    }
}
