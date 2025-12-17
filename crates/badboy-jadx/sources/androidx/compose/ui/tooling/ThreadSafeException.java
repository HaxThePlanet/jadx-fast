package androidx.compose.ui.tooling;

import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Landroidx/compose/ui/tooling/ThreadSafeException;", "", "()V", "exception", "", "lock", "set", "", "throwable", "throwIfPresent", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThreadSafeException {

    public static final int $stable = 8;
    private Throwable exception;
    private final Object lock;
    static {
        final int i = 8;
    }

    public ThreadSafeException() {
        super();
        Object object = new Object();
        this.lock = object;
    }

    public final void set(Throwable throwable) {
        final Object lock = this.lock;
        int i = 0;
        this.exception = throwable;
        Unit $i$a$SynchronizedThreadSafeException$set$1 = Unit.INSTANCE;
        return;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            this.exception = throwable;
            $i$a$SynchronizedThreadSafeException$set$1 = Unit.INSTANCE;
        }
    }

    public final void throwIfPresent() {
        final Object lock = this.lock;
        final int i = 0;
        final Throwable exception = this.exception;
        synchronized (lock) {
        }
    }
}
