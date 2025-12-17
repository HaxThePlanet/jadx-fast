package io.grpc.m1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import com.google.common.util.concurrent.a;
import com.google.common.util.concurrent.c;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.d;
import io.grpc.d.a;
import io.grpc.d1;
import io.grpc.e;
import io.grpc.h;
import io.grpc.h.a;
import io.grpc.t0;
import io.grpc.u0;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class d {

    private static final Logger a;
    static final d.a<io.grpc.m1.d.d> b;

    static class a {
    }

    static enum d {

        BLOCKING,
        FUTURE,
        ASYNC;
    }

    private static final class e extends ConcurrentLinkedQueue<Runnable> implements Executor {

        private static final Logger a;
        private volatile Thread waiter;
        static {
            d.e.a = Logger.getLogger(d.e.class.getName());
        }

        private static void b() {
            if (Thread.interrupted()) {
            } else {
            }
            InterruptedException interruptedException = new InterruptedException();
            throw interruptedException;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue
        public void d() {
            Object poll;
            Thread currentThread;
            Object poll2;
            Level wARNING;
            String str;
            d.e.b();
            if ((Runnable)poll() == null) {
                this.waiter = Thread.currentThread();
                poll2 = poll();
                while ((Runnable)poll2 == null) {
                    LockSupport.park(this);
                    d.e.b();
                    poll2 = poll();
                }
                this.waiter = null;
                poll = poll2;
            }
            do {
                poll.run();
                if ((Runnable)poll() != null) {
                }
                poll2 = d.e.a;
                poll2.log(Level.WARNING, "Runnable threw exception", thread);
            } while (/* condition */);
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue
        public void execute(Runnable runnable) {
            add(runnable);
            LockSupport.unpark(this.waiter);
        }
    }

    private static abstract class c extends h.a<T> {
        c(io.grpc.m1.d.a d$a) {
            super();
        }

        @Override // io.grpc.h$a
        abstract void a();
    }

    private static final class b extends a<RespT> {

        private final h<?, RespT> z;
        b(h<?, RespT> h) {
            super();
            this.z = h;
        }

        static h D(io.grpc.m1.d.b d$b) {
            return b.z;
        }

        protected boolean B(RespT respt) {
            return super.B(respt);
        }

        @Override // com.google.common.util.concurrent.a
        protected boolean C(Throwable throwable) {
            return super.C(throwable);
        }

        @Override // com.google.common.util.concurrent.a
        protected void x() {
            this.z.cancel("GrpcFuture was cancelled", 0);
        }

        @Override // com.google.common.util.concurrent.a
        protected String y() {
            j.b bVar = j.c(this);
            bVar.d("clientCall", this.z);
            return bVar.toString();
        }
    }

    private static final class f extends io.grpc.m1.d.c<RespT> {

        private final io.grpc.m1.d.b<RespT> a;
        private RespT b;
        f(io.grpc.m1.d.b<RespT> d$b) {
            super(0);
            this.a = b;
        }

        @Override // io.grpc.m1.d$c
        void a() {
            d.b.D(this.a).request(2);
        }

        @Override // io.grpc.m1.d$c
        public void onClose(d1 d1, t0 t02) {
            boolean z;
            String str;
            Object obj3;
            Object obj4;
            if (d1.p()) {
                if (this.b == null) {
                    this.a.C(d1.m.r("No value received for unary call").e(t02));
                }
                this.a.B(this.b);
            } else {
                this.a.C(d1.e(t02));
            }
        }

        @Override // io.grpc.m1.d$c
        public void onHeaders(t0 t0) {
        }

        public void onMessage(RespT respt) {
            if (this.b != null) {
            } else {
                this.b = respt;
            }
            throw d1.m.r("More than one value received for unary call").d();
        }
    }
    static {
        d.a = Logger.getLogger(d.class.getName());
        d.b = d.a.b("internal-stub-type");
    }

    private static <ReqT, RespT> void a(h<ReqT, RespT> h, ReqT reqt2, io.grpc.m1.d.c<RespT> d$c3) {
        d.f(h, c3);
        final int obj2 = 0;
        h.sendMessage(reqt2);
        h.halfClose();
    }

    public static <ReqT, RespT> RespT b(e e, u0<ReqT, RespT> u02, d d3, ReqT reqt4) {
        d.a done;
        io.grpc.m1.d.d bLOCKING;
        int obj4;
        int obj5;
        d.e eVar = new d.e();
        obj4 = 0;
        obj5 = 0;
        final c obj6 = d.d(e.h(u02, d3.q(d.b, d.d.BLOCKING).n(eVar)), reqt4);
        while (obj6.isDone() == null) {
            eVar.d();
        }
        if (obj5 != null) {
            Thread.currentThread().interrupt();
        }
        return d.e(obj6);
    }

    private static RuntimeException c(h<?, ?> h, Throwable throwable2) {
        int i;
        Level sEVERE;
        String str;
        Throwable obj3;
        h.cancel(0, throwable2);
        if (throwable2 instanceof RuntimeException != null) {
        } else {
            if (throwable2 instanceof Error != null) {
                throw (Error)throwable2;
            }
            obj3 = new AssertionError(throwable2);
            throw obj3;
        }
        throw (RuntimeException)throwable2;
    }

    public static <ReqT, RespT> c<RespT> d(h<ReqT, RespT> h, ReqT reqt2) {
        d.b bVar = new d.b(h);
        d.f fVar = new d.f(bVar);
        d.a(h, reqt2, fVar);
        return bVar;
    }

    private static <V> V e(Future<V> future) {
        try {
            return future.get();
            future = future.getCause();
            future = d.g(future);
            throw future;
            Thread thread = Thread.currentThread();
            thread.interrupt();
            thread = d1.g;
            thread = thread.r("Thread interrupted");
            future = thread.q(future);
            future = future.d();
            throw future;
        }
    }

    private static <ReqT, RespT> void f(h<ReqT, RespT> h, io.grpc.m1.d.c<RespT> d$c2) {
        t0 t0Var = new t0();
        h.start(c2, t0Var);
        c2.a();
    }

    private static StatusRuntimeException g(Throwable throwable) {
        Object cause;
        boolean z;
        n.p(throwable, "t");
        cause = throwable;
        while (cause != null) {
            cause = cause.getCause();
        }
        return d1.h.r("unexpected exception").q(throwable).d();
    }
}
