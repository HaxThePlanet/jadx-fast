package io.grpc.j1;

import io.grpc.r0;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: ManagedChannelOrphanWrapper.java */
/* loaded from: classes3.dex */
final class i1 extends m0 {

    private static final ReferenceQueue<i1> c = new ReferenceQueue<>();
    private static final ConcurrentMap<i1.a, i1.a> d = new ConcurrentHashMap<>();
    private static final Logger e;
    private final i1.a b;

    static final class a extends WeakReference<i1> {

        private static final boolean f = false;
        private static final RuntimeException g;
        private final ReferenceQueue<i1> a;
        private final ConcurrentMap<i1.a, i1.a> b;
        private final String c;
        private final Reference<RuntimeException> d = new SoftReference<>();
        private final AtomicBoolean e = new AtomicBoolean();
        static {
            i1.a.f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));
            i1.a.g = i1.a.e();
        }

        a(r0 r0Var, ReferenceQueue<i1> referenceQueue, ConcurrentMap<i1.a, i1.a> concurrentMap) {
            RuntimeException runtimeException;
            super(i1Var, referenceQueue);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            if (i1.a.f) {
                str = "ManagedChannel allocation site";
                runtimeException = new RuntimeException(str);
            } else {
                runtimeException = i1.a.g;
            }
            SoftReference softReference = new SoftReference(runtimeException);
            this.c = r0Var.toString();
            this.a = referenceQueue;
            this.b = concurrentMap;
            concurrentMap.put(this, this);
            i1.a.b(referenceQueue);
        }

        static /* synthetic */ void a(i1.a aVar) {
            aVar.d();
        }

        static int b(ReferenceQueue<i1> referenceQueue) {
            int i;
            boolean loggable;
            LogRecord logRecord;
            i = 0;
            Reference poll = referenceQueue.poll();
            while (poll != null) {
                poll.c();
                poll = referenceQueue.poll();
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
            final RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
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
        i1.e = Logger.getLogger(i1.class.getName());
    }

    i1(r0 r0Var) {
        this(r0Var, i1.c, i1.d);
    }

    static /* synthetic */ Logger o() {
        return i1.e;
    }

    @Override // io.grpc.j1.m0
    public r0 m() {
        this.b.d();
        return super.m();
    }

    @Override // io.grpc.j1.m0
    public r0 n() {
        this.b.d();
        return super.n();
    }

    i1(r0 r0Var, ReferenceQueue<i1> referenceQueue, ConcurrentMap<i1.a, i1.a> concurrentMap) {
        super(r0Var);
        this.b = new i1.a(this, r0Var, referenceQueue, concurrentMap);
    }
}
