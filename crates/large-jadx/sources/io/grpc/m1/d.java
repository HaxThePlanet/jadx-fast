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

/* compiled from: ClientCalls.java */
/* loaded from: classes3.dex */
public final class d {

    private static final Logger a;
    static final d.a<d.d> b;

    static class a {
    }

    enum d {

        ASYNC,
        BLOCKING,
        FUTURE;
    }

    private static final class e extends ConcurrentLinkedQueue<Runnable> implements Executor {

        private static final Logger a;
        private volatile Thread waiter;
        static {
            d.e.a = Logger.getLogger(d.e.class.getName());
        }

        e() {
            super();
        }

        private static void b() throws java.lang.InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue
        public void d() {
            Object poll;
            Level obj;
            String obj3;
            d.e.b();
            if ((Runnable)poll() == null) {
                this.waiter = Thread.currentThread();
                while (/* condition */) {
                    try {
                        poll = poll();
                        LockSupport.park(this);
                        d.e.b();
                    } catch (Throwable th) {
                        th = d.e.a;
                        th.log(Level.WARNING, "Runnable threw exception", th);
                    }
                }
                this.waiter = currentThread;
            }
            do {
                try {
                    poll.run();
                } catch (Throwable th) {
                    th = d.e.a;
                    th.log(Level.WARNING, "Runnable threw exception", th);
                }
                if ((Runnable)poll() == null) {
                    return;
                }
            } while (/* condition */);
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue
        public void execute(Runnable runnable) {
            add(runnable);
            LockSupport.unpark(this.waiter);
        }
    }

    private static abstract class c<T> extends h.a<T> {
        private c() {
            super();
        }

        /* synthetic */ c(d.a aVar) {
            this();
        }

        @Override // io.grpc.h$a
        abstract void a();
    }

    private static final class b<RespT> extends a<RespT> {

        private final h<?, RespT> z;
        b(h<?, RespT> hVar) {
            super();
            this.z = hVar;
        }

        static /* synthetic */ h D(d.b bVar) {
            return bVar.z;
        }

        @Override // com.google.common.util.concurrent.a
        protected boolean B(RespT respt) {
            return super.B(respt);
        }

        @Override // com.google.common.util.concurrent.a
        protected boolean C(Throwable th) {
            return super.C(th);
        }

        @Override // com.google.common.util.concurrent.a
        protected void x() {
            this.z.cancel("GrpcFuture was cancelled", null);
        }

        @Override // com.google.common.util.concurrent.a
        protected String y() {
            j.b bVar = j.c(this);
            bVar.d("clientCall", this.z);
            return bVar.toString();
        }
    }

    private static final class f<RespT> extends d.c<RespT> {

        private final d.b<RespT> a;
        private RespT b;
        f(d.b<RespT> bVar) {
            super(null);
            this.a = bVar;
        }

        @Override // io.grpc.m1.d$c
        void a() {
            this.a.z.request(2);
        }

        @Override // io.grpc.m1.d$c
        public void onClose(d1 d1Var, t0 t0Var) {
            boolean z;
            String str;
            if (d1Var.p()) {
                if (this.b == null) {
                    str = "No value received for unary call";
                    this.a.C(d1.m.r(str).e(t0Var));
                }
                this.a.B(this.b);
            } else {
                this.a.C(d1Var.e(t0Var));
            }
        }

        @Override // io.grpc.m1.d$c
        public void onMessage(RespT respt) {
            if (this.b != null) {
                throw d1.m.r("More than one value received for unary call").d();
            } else {
                this.b = respt;
                return;
            }
        }

        @Override // io.grpc.m1.d$c
        public void onHeaders(t0 t0Var) {
        }
    }
    static {
        d.a = Logger.getLogger(d.class.getName());
        d.b = d.a.b("internal-stub-type");
    }

    private d() {
        super();
    }

    private static <ReqT, RespT> void a(h<ReqT, RespT> hVar, ReqT reqt, d.c<RespT> cVar) {
        d.f(hVar, cVar);
        try {
            hVar.sendMessage(reqt);
            hVar.halfClose();
        } catch (Error e) {
            d.c(hVar, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) cVar;
        } catch (RuntimeException e1) {
            d.c(hVar, e1);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) cVar;
        }
    }

    public static <ReqT, RespT> RespT b(e eVar, u0<ReqT, RespT> u0Var, d dVar, ReqT reqt) {
        int i2 = 0;
        final io.grpc.m1.d.e eVar2 = new d.e();
        int i = 0;
        i2 = 0;
        try {
            final c cVar = d.d(eVar.h(u0Var, dVar.q(d.b, d.d.BLOCKING).n(eVar2)), reqt);
        } catch (java.lang.InterruptedException interrupted) {
            int i3 = 1;
        } catch (Throwable th1) {
        } catch (Error e2) {
        } catch (RuntimeException e3) {
        }
        if (!cVar.isDone()) {
            try {
                eVar2.d();
            } catch (java.lang.InterruptedException interrupted) {
                i3 = 1;
            } catch (Throwable th1) {
            } catch (Error e2) {
            } catch (RuntimeException e3) {
            }
        }
        try {
        } catch (java.lang.InterruptedException interrupted) {
            i3 = 1;
        } catch (Throwable th1) {
        } catch (Error e2) {
        } catch (RuntimeException e3) {
        }
        try {
            th1.cancel("Thread interrupted", interrupted);
        } catch (Throwable th) {
            interrupted = i3;
        } catch (Error e1) {
            interrupted = i3;
        } catch (RuntimeException e2) {
            interrupted = i3;
        }
        interrupted = i3;
    }

    private static RuntimeException c(h<?, ?> hVar, Throwable th) {
        String str = null;
        try {
            hVar.cancel(str, th);
        } catch (Throwable th) {
            d.a.log(Level.SEVERE, "RuntimeException encountered while closing call", th);
        }
        if (th instanceof RuntimeException) {
            throw th;
        } else {
            if (th instanceof Error) {
                throw th;
            }
            throw new AssertionError(th);
        }
    }

    public static <ReqT, RespT> c<RespT> d(h<ReqT, RespT> hVar, ReqT reqt) {
        final io.grpc.m1.d.b bVar = new d.b(hVar);
        d.a(hVar, reqt, new d.f(bVar));
        return bVar;
    }

    private static <V> V e(Future<V> future) {
        try {
        } catch (java.util.concurrent.ExecutionException execution) {
            execution = execution.getCause();
            execution = d.g(execution);
            throw execution;
        } catch (java.lang.InterruptedException interrupted1) {
            Thread thread = Thread.currentThread();
            thread.interrupt();
            thread = d1.g;
            thread = thread.r("Thread interrupted");
            interrupted1 = thread.q(interrupted1);
            interrupted1 = interrupted1.d();
            throw interrupted1;
        }
        return future.get();
    }

    private static <ReqT, RespT> void f(h<ReqT, RespT> hVar, d.c<RespT> cVar) {
        hVar.start(cVar, new t0());
        cVar.a();
    }

    private static StatusRuntimeException g(Throwable th) {
        Object th2;
        n.p(th, "t");
        th2 = th;
        while (th2 != null) {
            z = th2 instanceof StatusRuntimeException;
            if (th2 instanceof StatusRuntimeException) {
                return new StatusRuntimeException(th2.a(), th2.b());
            }
        }
        return d1.h.r("unexpected exception").q(th).d();
    }
}
