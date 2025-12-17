package l;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.l;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes3.dex */
public class d extends l.e0 {

    public static final l.d.a Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0L;
    private static final long IDLE_TIMEOUT_NANOS = 0L;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static l.d head;
    private boolean inQueue;
    private l.d next;
    private long timeoutAt;

    public static final class a {
        public a(g g) {
            super();
        }

        public static final boolean a(l.d.a d$a, l.d d2) {
            return a.d(d2);
        }

        public static final void b(l.d.a d$a, l.d d2, long l3, boolean z4) {
            a.e(d2, l3, z4);
        }

        private final boolean d(l.d d) {
            l.d dVar;
            l.d dVar2;
            final Class<l.d> obj = d.class;
            final int i2 = 0;
            synchronized (obj) {
                return i2;
            }
        }

        private final void e(l.d d, long l2, boolean z3) {
            Object bVar;
            int cmp;
            int obj7;
            l.d obj9;
            final Class<l.d> obj = d.class;
            final int i2 = 1;
            synchronized (obj) {
                d.access$setInQueue$p(d, i2);
                if (d.access$getHead$cp() == null) {
                    d dVar = new d();
                    d.access$setHead$cp(dVar);
                    bVar = new d.b();
                    bVar.start();
                }
                try {
                    long nanoTime = System.nanoTime();
                    cmp = Long.compare(l2, i3);
                    if (cmp != 0 && obj9 != null) {
                    } else {
                    }
                    if (obj9 != null) {
                    } else {
                    }
                    d.access$setTimeoutAt$p(d, obj7 += nanoTime);
                    if (cmp != 0) {
                    } else {
                    }
                    d.access$setTimeoutAt$p(d, l2 += nanoTime);
                    if (obj9 == null) {
                    } else {
                    }
                    d.access$setTimeoutAt$p(d, d.deadlineNanoTime());
                    n.d(d.access$getHead$cp());
                    while (d.access$getNext$p(obj9) != null) {
                        l.d dVar2 = d.access$getNext$p(obj9);
                        n.d(dVar2);
                        if (Long.compare(obj7, l) < 0) {
                            break;
                        } else {
                        }
                        n.d(d.access$getNext$p(obj9));
                    }
                    dVar2 = d.access$getNext$p(obj9);
                    n.d(dVar2);
                    if (Long.compare(obj7, l) < 0) {
                    } else {
                    }
                    n.d(d.access$getNext$p(obj9));
                    d.access$setNext$p(d, d.access$getNext$p(obj9));
                    d.access$setNext$p(obj9, d);
                    if (obj9 == d.access$getHead$cp()) {
                    }
                    obj.notify();
                    w obj6 = w.a;
                    obj6 = new AssertionError();
                    throw obj6;
                    obj7 = new IllegalStateException("Unbalanced enter/exit".toString());
                    throw obj7;
                    throw d;
                }
            }
        }

        public final l.d c() {
            l.d cmp;
            int i;
            long nanoTime;
            Class<l.d> obj = d.class;
            l.d dVar3 = d.access$getHead$cp();
            n.d(dVar3);
            l.d dVar4 = d.access$getNext$p(dVar3);
            i = 0;
            obj.wait(d.access$getIDLE_TIMEOUT_MILLIS$cp());
            l.d dVar2 = d.access$getHead$cp();
            n.d(dVar2);
            if (dVar4 == null && d.access$getNext$p(dVar2) == null && Long.compare(i2, nanoTime) >= 0) {
                obj.wait(d.access$getIDLE_TIMEOUT_MILLIS$cp());
                dVar2 = d.access$getHead$cp();
                n.d(dVar2);
                if (d.access$getNext$p(dVar2) == null) {
                    if (Long.compare(i2, nanoTime) >= 0) {
                        i = d.access$getHead$cp();
                    }
                }
                return i;
            }
            long l = d.access$remainingNanos(dVar4, System.nanoTime());
            if (Long.compare(l, i5) > 0) {
                int i6 = 1000000;
                final int i8 = l / i6;
                obj.wait(i8, obj8);
                return i;
            }
            l.d dVar = d.access$getHead$cp();
            n.d(dVar);
            d.access$setNext$p(dVar, d.access$getNext$p(dVar4));
            d.access$setNext$p(dVar4, i);
            return dVar4;
        }
    }

    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread
        public void run() {
            w wVar;
            final Class<l.d> obj = d.class;
            l.d dVar = d.Companion.c();
            synchronized (obj) {
                d.access$setHead$cp(0);
            }
            try {
                dVar.timedOut();
                throw th;
            }
        }
    }

    public static final class c implements l.b0 {

        final l.d a;
        final l.b0 b;
        c(l.d d, l.b0 b02) {
            this.a = d;
            this.b = b02;
            super();
        }

        @Override // l.b0
        public l.d a() {
            return this.a;
        }

        @Override // l.b0
        public void close() {
            Throwable th;
            l.d dVar = this.a;
            dVar.enter();
            this.b.close();
            w wVar = w.a;
            if (dVar.exit()) {
            } else {
            }
            throw dVar.access$newTimeoutException(0);
        }

        @Override // l.b0
        public void flush() {
            Throwable th;
            l.d dVar = this.a;
            dVar.enter();
            this.b.flush();
            w wVar = w.a;
            if (dVar.exit()) {
            } else {
            }
            throw dVar.access$newTimeoutException(0);
        }

        @Override // l.b0
        public l.e0 timeout() {
            return a();
        }

        @Override // l.b0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AsyncTimeout.sink(");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // l.b0
        public void write(l.f f, long l2) {
            String str;
            long l;
            l.y yVar;
            int exit;
            long l3;
            int obj9;
            n.f(f, "source");
            final long size = f.size();
            c.b(size, obj2, 0);
            while (Long.compare(obj9, str) > 0) {
                n.d(f.a);
                while (Long.compare(str, l4) < 0) {
                    if (Long.compare(str, obj9) >= 0) {
                        break loop_3;
                    } else {
                    }
                    n.d(yVar.f);
                }
                l = this.a;
                l.enter();
                this.b.write(f, str);
                w wVar = w.a;
                obj9 -= str;
                if (Long.compare(str, obj9) >= 0) {
                } else {
                }
                n.d(yVar.f);
                str = obj9;
            }
        }
    }

    public static final class d implements l.d0 {

        final l.d a;
        final l.d0 b;
        d(l.d d, l.d0 d02) {
            this.a = d;
            this.b = d02;
            super();
        }

        @Override // l.d0
        public l.d a() {
            return this.a;
        }

        @Override // l.d0
        public void close() {
            Throwable th;
            l.d dVar = this.a;
            dVar.enter();
            this.b.close();
            w wVar = w.a;
            if (dVar.exit()) {
            } else {
            }
            throw dVar.access$newTimeoutException(0);
        }

        @Override // l.d0
        public long read(l.f f, long l2) {
            n.f(f, "sink");
            l.d dVar = this.a;
            dVar.enter();
            if (dVar.exit()) {
            } else {
                return this.b.read(f, l2);
            }
            throw dVar.access$newTimeoutException(0);
        }

        @Override // l.d0
        public l.e0 timeout() {
            return a();
        }

        @Override // l.d0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AsyncTimeout.source(");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    static {
        d.a aVar = new d.a(0);
        d.Companion = aVar;
        int i2 = 60;
        long millis = TimeUnit.SECONDS.toMillis(i2);
        d.IDLE_TIMEOUT_MILLIS = millis;
        d.IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final l.d access$getHead$cp() {
        return d.head;
    }

    public static final long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return d.IDLE_TIMEOUT_MILLIS;
    }

    public static final long access$getIDLE_TIMEOUT_NANOS$cp() {
        return d.IDLE_TIMEOUT_NANOS;
    }

    public static final boolean access$getInQueue$p(l.d d) {
        return d.inQueue;
    }

    public static final l.d access$getNext$p(l.d d) {
        return d.next;
    }

    public static final long access$getTimeoutAt$p(l.d d) {
        return d.timeoutAt;
    }

    public static final long access$remainingNanos(l.d d, long l2) {
        return d.remainingNanos(l2);
    }

    public static final void access$setHead$cp(l.d d) {
        d.head = d;
    }

    public static final void access$setInQueue$p(l.d d, boolean z2) {
        d.inQueue = z2;
    }

    public static final void access$setNext$p(l.d d, l.d d2) {
        d.next = d2;
    }

    public static final void access$setTimeoutAt$p(l.d d, long l2) {
        d.timeoutAt = l2;
    }

    private final long remainingNanos(long l) {
        return timeoutAt -= l;
    }

    @Override // l.e0
    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    @Override // l.e0
    public final void enter() {
        final long timeoutNanos = timeoutNanos();
        final boolean deadline = hasDeadline();
        if (Long.compare(timeoutNanos, i) == 0 && !deadline) {
            if (!deadline) {
            }
        }
        d.a.b(d.Companion, this, timeoutNanos, obj1);
    }

    @Override // l.e0
    public final boolean exit() {
        return d.a.a(d.Companion, this);
    }

    @Override // l.e0
    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @Override // l.e0
    public final l.b0 sink(l.b0 b0) {
        n.f(b0, "sink");
        d.c cVar = new d.c(this, b0);
        return cVar;
    }

    @Override // l.e0
    public final l.d0 source(l.d0 d0) {
        n.f(d0, "source");
        d.d dVar = new d.d(this, d0);
        return dVar;
    }

    @Override // l.e0
    protected void timedOut() {
    }

    public final <T> T withTimeout(a<? extends T> a) {
        n.f(a, "block");
        enter();
        int i = 1;
        l.b(i);
        if (exit()) {
        } else {
            l.a(i);
            return a.invoke();
        }
        throw access$newTimeoutException(0);
    }
}
