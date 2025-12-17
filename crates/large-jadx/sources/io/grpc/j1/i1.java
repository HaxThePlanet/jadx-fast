package io.grpc.j1;

import io.grpc.r0;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
final class i1 extends io.grpc.j1.m0 {

    private static final ReferenceQueue<io.grpc.j1.i1> c;
    private static final ConcurrentMap<io.grpc.j1.i1.a, io.grpc.j1.i1.a> d;
    private static final Logger e;
    private final io.grpc.j1.i1.a b;

    static final class a extends WeakReference<io.grpc.j1.i1> {

        private static final boolean f;
        private static final RuntimeException g;
        private final ReferenceQueue<io.grpc.j1.i1> a;
        private final ConcurrentMap<io.grpc.j1.i1.a, io.grpc.j1.i1.a> b;
        private final String c;
        private final Reference<RuntimeException> d;
        private final AtomicBoolean e;
        static {
            i1.a.f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));
            i1.a.g = i1.a.e();
        }

        a(io.grpc.j1.i1 i1, r0 r02, ReferenceQueue<io.grpc.j1.i1> referenceQueue3, ConcurrentMap<io.grpc.j1.i1.a, io.grpc.j1.i1.a> concurrentMap4) {
            RuntimeException runtimeException;
            String str;
            super(i1, referenceQueue3);
            AtomicBoolean obj3 = new AtomicBoolean();
            this.e = obj3;
            if (i1.a.f) {
                runtimeException = new RuntimeException("ManagedChannel allocation site");
            } else {
                runtimeException = i1.a.g;
            }
            obj3 = new SoftReference(runtimeException);
            this.d = obj3;
            this.c = r02.toString();
            this.a = referenceQueue3;
            this.b = concurrentMap4;
            concurrentMap4.put(this, this);
            i1.a.b(referenceQueue3);
        }

        static void a(io.grpc.j1.i1.a i1$a) {
            a.d();
        }

        static int b(ReferenceQueue<io.grpc.j1.i1> referenceQueue) {
            int i;
            Object poll;
            Object obj;
            boolean sEVERE;
            boolean loggable;
            LogRecord logRecord;
            final int i2 = 0;
            i = i2;
            poll = referenceQueue.poll();
            while ((i1.a)poll != null) {
                (i1.a)poll.c();
                i++;
                sEVERE = Level.SEVERE;
                if (!poll.e.get() && i1.o().isLoggable(sEVERE)) {
                }
                poll = referenceQueue.poll();
                i++;
                sEVERE = Level.SEVERE;
                if (i1.o().isLoggable(sEVERE)) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("*~*~*~ Channel {0} was not shutdown properly!!! ~*~*~*");
                stringBuilder.append(System.getProperty("line.separator"));
                stringBuilder.append("    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                logRecord = new LogRecord(sEVERE, stringBuilder.toString());
                logRecord.setLoggerName(i1.o().getName());
                sEVERE = new Object[1];
                sEVERE[i2] = poll.c;
                logRecord.setParameters(sEVERE);
                logRecord.setThrown((RuntimeException)poll.d.get());
                i1.o().log(logRecord);
            }
            return i;
        }

        private void c() {
            super.clear();
            this.b.remove(this);
            this.d.clear();
        }

        private void d() {
            if (!this.e.getAndSet(true)) {
                clear();
            }
        }

        private static RuntimeException e() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        @Override // java.lang.ref.WeakReference
        public void clear() {
            c();
            i1.a.b(this.a);
        }
    }
    static {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        i1.c = referenceQueue;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        i1.d = concurrentHashMap;
        i1.e = Logger.getLogger(i1.class.getName());
    }

    i1(r0 r0) {
        super(r0, i1.c, i1.d);
    }

    i1(r0 r0, ReferenceQueue<io.grpc.j1.i1> referenceQueue2, ConcurrentMap<io.grpc.j1.i1.a, io.grpc.j1.i1.a> concurrentMap3) {
        super(r0);
        i1.a aVar = new i1.a(this, r0, referenceQueue2, concurrentMap3);
        this.b = aVar;
    }

    static Logger o() {
        return i1.e;
    }

    @Override // io.grpc.j1.m0
    public r0 m() {
        i1.a.a(this.b);
        return super.m();
    }

    @Override // io.grpc.j1.m0
    public r0 n() {
        i1.a.a(this.b);
        return super.n();
    }
}
