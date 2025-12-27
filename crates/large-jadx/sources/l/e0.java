package l;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.l;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public class e0 {

    public static final e0.b Companion = new e0$b(0);
    public static final e0 NONE = new e0$a();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public static final class b {
        private b() {
            super();
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final long a(long j, long j2) {
            int cmp = 0;
            long l;
            long l2 = 0L;
            if (j == l2) {
                l = j2;
            }
            return l;
        }
    }

    public static final class a extends e0 {
        a() {
            super();
        }

        @Override // l.e0
        public e0 deadlineNanoTime(long j) {
            return this;
        }

        @Override // l.e0
        public void throwIfReached() {
        }

        @Override // l.e0
        public e0 timeout(long j, TimeUnit timeUnit) {
            n.f(timeUnit, "unit");
            return this;
        }
    }

    public e0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public e0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final e0 deadline(long j, TimeUnit timeUnit) {
        int i = 1;
        n.f(timeUnit, "unit");
        int r0 = j > 0 ? 1 : 0;
        if (i == 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            String str2 = "duration <= 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
        }
    }

    public long deadlineNanoTime() {
        if (!this.hasDeadline) {
            throw new IllegalStateException("No deadline".toString());
        } else {
            return this.deadlineNanoTime;
        }
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(e0 e0Var, a<w> aVar) {
        TimeUnit nANOSECONDS2;
        long deadlineNanoTime;
        long min;
        long deadlineNanoTime2;
        n.f(e0Var, "other");
        n.f(aVar, "block");
        long timeoutNanos = timeoutNanos();
        long timeoutNanos2 = e0Var.timeoutNanos();
        final TimeUnit nANOSECONDS22 = TimeUnit.NANOSECONDS;
        timeout(e0.Companion.a(timeoutNanos2, timeoutNanos()), nANOSECONDS22);
        int i2 = 1;
        if (hasDeadline()) {
            if (e0Var.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), e0Var.deadlineNanoTime()));
            }
            try {
                aVar.invoke();
            } catch (Throwable th) {
                l.b(i);
                nANOSECONDS2 = TimeUnit.NANOSECONDS;
                timeout(l, nANOSECONDS2);
                e0Var = e0Var.hasDeadline();
            }
            l.b(i2);
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (e0Var.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime());
            }
            l.a(i2);
        } else {
            if (e0Var.hasDeadline()) {
                deadlineNanoTime(e0Var.deadlineNanoTime());
            }
            try {
                th.invoke();
            } catch (Throwable th) {
                l.b(i);
                nANOSECONDS2 = TimeUnit.NANOSECONDS;
                timeout(l, nANOSECONDS2);
                e0Var = e0Var.hasDeadline();
            }
            l.b(i2);
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (e0Var.hasDeadline()) {
                clearDeadline();
            }
            l.a(i2);
        }
    }

    public void throwIfReached() throws InterruptedIOException {
        Thread currentThread = Thread.currentThread();
        n.e(currentThread, "Thread.currentThread()");
        if (currentThread.isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else {
            if (this.hasDeadline) {
                long l2 = this.deadlineNanoTime - System.nanoTime();
                long l = 0L;
                if (this.hasDeadline <= l) {
                    throw new InterruptedIOException("deadline reached");
                }
            }
            return;
        }
    }

    public e0 timeout(long j, TimeUnit timeUnit) {
        int i = 1;
        n.f(timeUnit, "unit");
        int r0 = j >= 0 ? 1 : 0;
        if (i == 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            String str2 = "timeout < 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object object) throws InterruptedIOException {
        long timeoutNanos;
        long l = 0;
        int cmp3;
        n.f(object, "monitor");
        try {
            boolean deadline = hasDeadline();
            timeoutNanos = timeoutNanos();
            l = 0L;
            if (!deadline && timeoutNanos == l) {
                object.wait();
                return;
            }
            long time2 = System.nanoTime();
            if (deadline) {
                if (timeoutNanos != l) {
                    timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - time2);
                } else {
                    if (deadline) {
                        timeoutNanos = deadlineNanoTime() - time2;
                    }
                }
            }
            if (timeoutNanos > l) {
                long l3 = 1000000L;
                long l6 = timeoutNanos / l3;
                cmp = (int)(timeoutNanos - (l3 * l6));
                object.wait(l6, cmp);
                l = System.nanoTime() - time2;
            }
            if (l >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (java.lang.InterruptedException unused) {
            object = Thread.currentThread();
            object.interrupt();
            object = new InterruptedIOException("interrupted");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) object;
        }
    }

    public e0 deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
