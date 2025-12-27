package l;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.l;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: AsyncTimeout.kt */
/* loaded from: classes3.dex */
public class d extends e0 {

    public static final d.a Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0L;
    private static final long IDLE_TIMEOUT_NANOS = 0L;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static d head;
    private boolean inQueue;
    private d next;
    private long timeoutAt;

    public static final class a {
        private a() {
            super();
        }

        public static final /* synthetic */ boolean a(d.a aVar, d dVar) {
            return aVar.d(dVar);
        }

        public static final /* synthetic */ void b(d.a aVar, d dVar, long j, boolean z) {
            aVar.e(dVar, j, z);
        }

        private final boolean d(d dVar) {
            l.d dVar2;
            final Class<l.d> obj2 = d.class;
            synchronized (obj2) {
                final boolean z2 = false;
                if (!dVar.inQueue) {
                    return false;
                }
                dVar.inQueue = z2;
                dVar2 = d.head;
                dVar2.next = dVar.next;
                dVar.next = 0;
                return true;
            }
        }

        private final void e(d dVar, long j, boolean z) {
            int cmp;
            l.d dVar4;
            final Class<l.d> obj2 = d.class;
            synchronized (obj2) {
                final boolean z2 = true;
                dVar.inQueue = z2;
                if (d.head == null) {
                    d.head = new d();
                    new d.b().start();
                }
                deadlineNanoTime = (Math.min(j, dVar.deadlineNanoTime() - time)) + time;
                dVar.timeoutAt = deadlineNanoTime;
                deadlineNanoTime = j + time;
                dVar.timeoutAt = deadlineNanoTime;
                dVar.timeoutAt = dVar.deadlineNanoTime();
                long l3 = dVar.remainingNanos(time, z2);
                n.d(d.head);
                while (dVar4.next != null) {
                    l.d dVar6 = dVar4.next;
                    n.d(dVar6);
                    long l = dVar6.remainingNanos(time, z2);
                    if (l3 < l) {
                        break;
                    } else {
                        n.d(dVar4.next);
                        while (dVar4.next != null) {
                            dVar6 = dVar4.next;
                            n.d(dVar6);
                            l = dVar6.remainingNanos(time, z2);
                            if (l3 < l) {
                                break;
                            }
                        }
                        dVar.next = dVar4.next;
                        dVar4.next = dVar;
                        if (dVar4.next == d.head) {
                            obj2.notify();
                        }
                        return;
                    }
                }
                dVar.next = dVar4.next;
                dVar4.next = dVar;
                throw new IllegalStateException("Unbalanced enter/exit".toString());
            }
        }

        public final d c() throws java.lang.InterruptedException {
            int i = 0;
            Class<l.d> obj = d.class;
            l.d dVar4 = d.head;
            n.d(dVar4);
            l.d dVar5 = dVar4.next;
            i = 0;
            if (dVar5 == null) {
                obj.wait(d.IDLE_TIMEOUT_MILLIS);
                l.d dVar3 = d.head;
                n.d(dVar3);
                if (dVar3.next == null) {
                    long l = System.nanoTime() - System.nanoTime();
                    long time = d.IDLE_TIMEOUT_NANOS;
                    if (dVar3.next >= time) {
                        l.d dVar6 = d.head;
                    }
                }
                return i;
            }
            long l2 = dVar5.remainingNanos(System.nanoTime(), l4);
            if (l2 > 0) {
                long l5 = 1000000L;
                final long l8 = l2 / l5;
                obj.wait(l8, (int)(l2 - (l5 * l8)));
                return null;
            }
            l.d dVar2 = d.head;
            n.d(dVar2);
            dVar2.next = dVar5.next;
            dVar5.next = i;
            return dVar5;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread
        public void run() {
            final Class<l.d> obj2 = d.class;
            synchronized (obj2) {
                try {
                    l.d dVar = d.Companion.c();
                    d.head = 0;
                } catch (Throwable unused) {
                }
                try {
                    wVar = w.a;
                } catch (Throwable unused) {
                }
                if (d.Companion != null) {
                    dVar.timedOut();
                }
            }
        }
    }

    public static final class c implements b0 {

        final /* synthetic */ d a;
        final /* synthetic */ b0 b;
        c(b0 b0Var) {
            this.a = dVar;
            this.b = b0Var;
            super();
        }

        public d a() {
            return this.a;
        }

        public void close() {
            Throwable th;
            this.a.enter();
            try {
                this.b.close();
            } catch (Throwable th) {
            }
            if (this.a.exit()) {
                throw this.a.access$newTimeoutException(null);
            }
        }

        public void flush() {
            Throwable th;
            this.a.enter();
            try {
                this.b.flush();
            } catch (Throwable th) {
            }
            if (this.a.exit()) {
                throw this.a.access$newTimeoutException(null);
            }
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "AsyncTimeout.sink(";
            str = str2 + this.b + 41;
            return str;
        }

        public void write(f fVar, long j) {
            long j22 = 0;
            l.y yVar;
            long cmp = 0;
            int i;
            str = "source";
            n.f(fVar, str);
            final long size = fVar.size();
            cmp = 0L;
            c.b(size, cmp, j);
            j22 = 0L;
            while (j22 > j22) {
                n.d(fVar.a);
                long l2 = (long)65536;
                while (j22 < l2) {
                    j22 = j22 + (long)(yVar.c - yVar.b);
                    if (j22 >= j22) {
                        break loop_3;
                    }
                }
                this.a.enter();
                try {
                    this.b.write(fVar, j22);
                } catch (Throwable th) {
                }
                if (this.a.exit()) {
                    throw this.a.access$newTimeoutException(null);
                }
                j22 = j22 + (long)yVar.c - yVar.b;
            }
        }
    }

    public static final class d implements d0 {

        final /* synthetic */ d a;
        final /* synthetic */ d0 b;
        d(d0 d0Var) {
            this.a = dVar;
            this.b = d0Var;
            super();
        }

        public d a() {
            return this.a;
        }

        public void close() {
            Throwable th;
            this.a.enter();
            try {
                this.b.close();
            } catch (Throwable th) {
            }
            if (this.a.exit()) {
                throw this.a.access$newTimeoutException(null);
            }
        }

        public long read(f fVar, long j) {
            n.f(fVar, "sink");
            this.a.enter();
            try {
            } catch (Throwable th) {
            }
            if (this.a.exit()) {
                throw this.a.access$newTimeoutException(null);
            } else {
                return this.b.read(fVar, j);
            }
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "AsyncTimeout.source(";
            str = str2 + this.b + 41;
            return str;
        }
    }
    static {
        d.Companion = new d.a(null);
        long l = 60L;
        long millis = TimeUnit.SECONDS.toMillis(l);
        d.IDLE_TIMEOUT_MILLIS = millis;
        d.IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final /* synthetic */ d access$getHead$cp() {
        return d.head;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return d.IDLE_TIMEOUT_MILLIS;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_NANOS$cp() {
        return d.IDLE_TIMEOUT_NANOS;
    }

    public static final /* synthetic */ boolean access$getInQueue$p(d dVar) {
        return dVar.inQueue;
    }

    public static final /* synthetic */ d access$getNext$p(d dVar) {
        return dVar.next;
    }

    public static final /* synthetic */ long access$getTimeoutAt$p(d dVar) {
        return dVar.timeoutAt;
    }

    public static final /* synthetic */ long access$remainingNanos(d dVar, long j) {
        return dVar.remainingNanos(j);
    }

    public static final /* synthetic */ void access$setHead$cp(d dVar) {
        d.head = dVar;
    }

    public static final /* synthetic */ void access$setInQueue$p(d dVar, boolean z) {
        dVar.inQueue = z;
    }

    public static final /* synthetic */ void access$setNext$p(d dVar, d dVar2) {
        dVar.next = dVar2;
    }

    public static final /* synthetic */ void access$setTimeoutAt$p(d dVar, long j) {
        dVar.timeoutAt = j;
    }

    private final long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    @Override // l.e0
    public final IOException access$newTimeoutException(IOException exc) {
        return newTimeoutException(exc);
    }

    @Override // l.e0
    public final void enter() {
        final long timeoutNanos = timeoutNanos();
        final boolean deadline = hasDeadline();
        if (timeoutNanos == 0 && !deadline) {
            return;
        }
        d.Companion.e(this, timeoutNanos, l, deadline);
    }

    @Override // l.e0
    public final boolean exit() {
        return d.Companion.d(this);
    }

    @Override // l.e0
    protected IOException newTimeoutException(IOException exc) {
        final InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (exc != null) {
            interruptedIOException.initCause(exc);
        }
        return interruptedIOException;
    }

    @Override // l.e0
    public final b0 sink(b0 b0Var) {
        n.f(b0Var, "sink");
        return new d.c(this, b0Var);
    }

    @Override // l.e0
    public final d0 source(d0 d0Var) {
        n.f(d0Var, "source");
        return new d.d(this, d0Var);
    }

    @Override // l.e0
    public final <T> T withTimeout(a<? extends T> aVar) {
        n.f(aVar, "block");
        enter();
        int i2 = 1;
        try {
        } catch (Throwable th) {
        }
        l.b(i2);
        if (exit()) {
            throw access$newTimeoutException(null);
        } else {
            l.a(i2);
            return aVar.invoke();
        }
    }

    @Override // l.e0
    protected void timedOut() {
    }
}
