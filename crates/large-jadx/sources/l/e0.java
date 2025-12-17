package l;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.l;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes3.dex */
public class e0 {

    public static final l.e0.b Companion;
    public static final l.e0 NONE;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public static final class b {
        public b(g g) {
            super();
        }

        public final long a(long l, long l2) {
            int cmp;
            int obj4;
            cmp = 0;
            if (Long.compare(l, cmp) == 0) {
                obj4 = obj6;
            } else {
                if (Long.compare(obj6, cmp) == 0) {
                } else {
                    if (Long.compare(l, obj6) < 0) {
                    } else {
                    }
                }
            }
            return obj4;
        }
    }

    public static final class a extends l.e0 {
        @Override // l.e0
        public l.e0 deadlineNanoTime(long l) {
            return this;
        }

        @Override // l.e0
        public void throwIfReached() {
        }

        @Override // l.e0
        public l.e0 timeout(long l, TimeUnit timeUnit2) {
            n.f(obj3, "unit");
            return this;
        }
    }
    static {
        e0.b bVar = new e0.b(0);
        e0.Companion = bVar;
        e0.a aVar = new e0.a();
        e0.NONE = aVar;
    }

    public l.e0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public l.e0 clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final l.e0 deadline(long l, TimeUnit timeUnit2) {
        int i;
        n.f(obj5, "unit");
        i = Long.compare(l, i2) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return deadlineNanoTime(nanoTime += obj3);
        }
        StringBuilder obj5 = new StringBuilder();
        obj5.append("duration <= 0: ");
        obj5.append(l);
        IllegalArgumentException obj4 = new IllegalArgumentException(obj5.toString().toString());
        throw obj4;
    }

    public long deadlineNanoTime() {
        if (!this.hasDeadline) {
        } else {
            return this.deadlineNanoTime;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No deadline".toString());
        throw illegalStateException;
    }

    public l.e0 deadlineNanoTime(long l) {
        this.hasDeadline = true;
        this.deadlineNanoTime = l;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(l.e0 e0, a<w> a2) {
        TimeUnit nANOSECONDS;
        boolean deadline;
        long deadlineNanoTime2;
        long l;
        long deadlineNanoTime;
        boolean obj12;
        n.f(e0, "other");
        n.f(a2, "block");
        long timeoutNanos = timeoutNanos();
        long timeoutNanos2 = e0.timeoutNanos();
        final TimeUnit nANOSECONDS2 = TimeUnit.NANOSECONDS;
        timeout(e0.Companion.a(timeoutNanos2, obj4), timeoutNanos2);
        int i = 1;
        if (hasDeadline()) {
            if (e0.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), obj8));
            }
            a2.invoke();
            l.b(i);
            timeout(timeoutNanos, obj1);
            if (e0.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime());
            }
            l.a(i);
        } else {
            if (e0.hasDeadline()) {
                deadlineNanoTime(e0.deadlineNanoTime());
            }
            a2.invoke();
            l.b(i);
            timeout(timeoutNanos, obj1);
            if (e0.hasDeadline()) {
                clearDeadline();
            }
            l.a(i);
        }
    }

    public void throwIfReached() {
        boolean hasDeadline;
        int i;
        Thread currentThread = Thread.currentThread();
        n.e(currentThread, "Thread.currentThread()");
        if (currentThread.isInterrupted()) {
        } else {
            if (this.hasDeadline) {
                if (Long.compare(i2, i) <= 0) {
                } else {
                }
                InterruptedIOException interruptedIOException = new InterruptedIOException("deadline reached");
                throw interruptedIOException;
            }
        }
        InterruptedIOException interruptedIOException2 = new InterruptedIOException("interrupted");
        throw interruptedIOException2;
    }

    public l.e0 timeout(long l, TimeUnit timeUnit2) {
        int i;
        n.f(obj5, "unit");
        i = Long.compare(l, i2) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            this.timeoutNanos = obj5.toNanos(l);
            return this;
        }
        StringBuilder obj5 = new StringBuilder();
        obj5.append("timeout < 0: ");
        obj5.append(l);
        IllegalArgumentException obj4 = new IllegalArgumentException(obj5.toString().toString());
        throw obj4;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object object) {
        boolean deadlineNanoTime;
        int cmp;
        long timeoutNanos;
        int i;
        int cmp2;
        int cmp3;
        n.f(object, "monitor");
        deadlineNanoTime = hasDeadline();
        timeoutNanos = timeoutNanos();
        i = 0;
        if (!deadlineNanoTime && Long.compare(timeoutNanos, i) == 0) {
            if (Long.compare(timeoutNanos, i) == 0) {
                object.wait();
            }
        }
        long nanoTime2 = System.nanoTime();
        if (deadlineNanoTime && Long.compare(timeoutNanos, i) != 0) {
            if (Long.compare(timeoutNanos, i) != 0) {
                try {
                    timeoutNanos = Math.min(timeoutNanos, obj2);
                    if (deadlineNanoTime) {
                    }
                    timeoutNanos = deadlineNanoTime - nanoTime2;
                    if (Long.compare(timeoutNanos, i) > 0) {
                    }
                    int i2 = 1000000;
                    cmp3 = timeoutNanos / i2;
                    object.wait(cmp3, obj8);
                    nanoTime -= nanoTime2;
                    if (Long.compare(i, timeoutNanos) >= 0) {
                    } else {
                    }
                    InterruptedIOException obj10 = new InterruptedIOException("timeout");
                    throw obj10;
                    object = Thread.currentThread();
                    object.interrupt();
                    object = new InterruptedIOException("interrupted");
                    throw object;
                }
            } else {
            }
        } else {
        }
    }
}
