package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import io.grpc.a;
import io.grpc.a.b;
import io.grpc.a0;
import io.grpc.b;
import io.grpc.d;
import io.grpc.d0;
import io.grpc.d1;
import io.grpc.e;
import io.grpc.e0.a;
import io.grpc.e0.b;
import io.grpc.f0;
import io.grpc.f0.b;
import io.grpc.f1;
import io.grpc.f1.c;
import io.grpc.g;
import io.grpc.g.a;
import io.grpc.h;
import io.grpc.h.a;
import io.grpc.h0;
import io.grpc.i;
import io.grpc.i0;
import io.grpc.k;
import io.grpc.o0.b;
import io.grpc.o0.b.a;
import io.grpc.o0.d;
import io.grpc.o0.e;
import io.grpc.o0.f;
import io.grpc.o0.h;
import io.grpc.o0.i;
import io.grpc.o0.j;
import io.grpc.p;
import io.grpc.r0;
import io.grpc.t0;
import io.grpc.u0;
import io.grpc.v0;
import io.grpc.v0.b;
import io.grpc.v0.b.a;
import io.grpc.v0.c;
import io.grpc.v0.d;
import io.grpc.v0.e;
import io.grpc.v0.g;
import io.grpc.w;
import io.grpc.y;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
final class g1 extends r0 implements h0<Object> {

    static final Logger l0;
    static final Pattern m0;
    static final d1 n0;
    static final d1 o0;
    static final d1 p0;
    private static final j1 q0;
    private static final f0 r0 = new g1$a();
    private static final h<Object, Object> s0 = new g1$m<>();
    private v0 A;
    private boolean B;
    private g1.u C;
    private volatile o0.i D;
    private boolean E;
    private final Set<y0> F;
    private Collection<g1.w.g<?, ?>> G;
    private final Object H;
    private final Set<q1> I;
    private final a0 J;
    private final g1.a0 K;
    private final AtomicBoolean L;
    private boolean M;
    private boolean N;
    private volatile boolean O;
    private final CountDownLatch P;
    private final m.a Q;
    private final m R;
    private final o S;
    private final g T;
    private final d0 U;
    private final g1.w V;
    private g1.x W;
    private j1 X;
    private final j1 Y;
    private boolean Z;
    private final i0 a;
    private final boolean a0;
    private final String b;
    private final z1.u b0;
    private final String c;
    private final long c0;
    private final v0.d d;
    private final long d0;
    private final v0.b e;
    private final boolean e0;
    private final j f;
    private final k1.a f0;
    private final t g;
    final w0<Object> g0;
    private final t h;
    private f1.c h0;
    private final g1.y i;
    private k i0;
    private final Executor j;
    private final p.e j0;
    private final p1<? extends Executor> k;
    private final y1 k0;
    private final p1<? extends Executor> l;
    private final g1.r m;
    private final g1.r n;
    private final l2 o;
    private final int p;
    final f1 q;
    private boolean r;
    private final w s;
    private final p t;
    private final com.google.common.base.s<com.google.common.base.q> u;
    private final long v;
    private final w w;
    private final k.a x;
    private final e y;
    private final String z;

    private final class a0 {

        final Object a;
        Collection<q> b;
        d1 c;
        final /* synthetic */ g1 d;
        private a0() {
            this.d = g1Var;
            super();
            this.a = new Object();
            this.b = new HashSet();
        }

        d1 a(z1<?> z1Var) {
            synchronized (obj2) {
                try {
                    if (this.c != null) {
                        return this.c;
                    }
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        void b(d1 d1Var) {
            synchronized (obj) {
                try {
                    if (this.c != null) {
                        return;
                    }
                    this.c = d1Var;
                } catch (Throwable th) {
                }
            }
            if (this.b.isEmpty()) {
                this.d.J.c(th);
            }
        }

        void c(d1 d1Var) {
            b(d1Var);
            synchronized (obj2) {
                try {
                } catch (Throwable th) {
                }
            }
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                (q)it.next().c(th);
            }
            this.d.J.d(th);
        }

        void d(z1<?> z1Var) {
            d1 d1Var = null;
            synchronized (obj) {
                try {
                    this.b.remove(z1Var);
                    if (this.b.isEmpty()) {
                        this.b = new HashSet();
                    } else {
                        int i = 0;
                    }
                } catch (Throwable th) {
                }
            }
            if (this.c != null) {
                this.d.J.c(d1Var);
            }
        }

        /* synthetic */ a0(g1.a aVar) {
            this(g1Var);
        }
    }

    final class b implements Runnable {

        final /* synthetic */ g1 a;
        b() {
            this.a = g1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.A0(1);
        }
    }

    final class d implements Runnable {

        final /* synthetic */ Runnable a;
        final /* synthetic */ io.grpc.q b;
        final /* synthetic */ g1 c;
        d(Runnable runnable, io.grpc.q qVar) {
            this.c = g1Var;
            this.a = runnable;
            this.b = qVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.w.c(this.a, this.c.j, this.b);
        }
    }

    final class f implements Runnable {

        final /* synthetic */ g1 a;
        f() {
            this.a = g1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.L.get()) {
                if (this.a.C != null) {
                    boolean z2 = false;
                    this.a.A0(z2);
                    this.a.C0();
                }
            }
        }
    }

    final class g implements Runnable {

        final /* synthetic */ g1 a;
        g() {
            this.a = g1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.D0();
            if (this.a.D != null) {
                this.a.D.b();
            }
            if (this.a.C != null) {
                this.a.C.a.c();
            }
        }
    }

    final class h implements Runnable {

        final /* synthetic */ g1 a;
        h() {
            this.a = g1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.T.a(g.a.INFO, "Entering SHUTDOWN state");
            this.a.w.b(q.SHUTDOWN);
        }
    }

    final class i implements Runnable {

        final /* synthetic */ g1 a;
        i() {
            this.a = g1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.M) {
                return;
            }
            this.a.M = 1;
            this.a.H0();
        }
    }

    class j implements java.lang.Thread.UncaughtExceptionHandler {

        final /* synthetic */ g1 a;
        j() {
            this.a = g1Var;
            super();
        }

        @Override // java.lang.Thread$UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "[";
            i0 i0Var = this.a.f();
            String str3 = "] Uncaught exception in the SynchronizationContext. Panic!";
            str = str2 + i0Var + str3;
            g1.l0.log(Level.SEVERE, str, th);
            this.a.J0(th);
        }
    }

    class k implements Executor {

        final /* synthetic */ g1 a;
        k() {
            this.a = g1Var;
            super();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.n.a().execute(runnable);
        }
    }

    class p implements Runnable {

        final /* synthetic */ g1 a;
        p() {
            this.a = g1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.h0 = 0;
            this.a.L0();
        }
    }

    private static final class r {

        private final p1<? extends Executor> a;
        private Executor b;
        r(p1<? extends Executor> p1Var) {
            super();
            n.p(p1Var, "executorPool");
            this.a = p1Var;
        }

        synchronized Executor a() {
            if (this.b == null) {
                Object obj = this.a.a();
                str = "%s.getObject()";
                n.q(obj, str, this.b);
                this.b = obj;
            }
            return this.b;
        }

        synchronized void b() {
            if (this.b != null) {
                this.b = (Executor)this.a.b(this.b);
            }
        }
    }

    private class t implements Runnable {

        final /* synthetic */ g1 a;
        private t() {
            this.a = g1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.C0();
        }

        /* synthetic */ t(g1.a aVar) {
            this(g1Var);
        }
    }

    enum x {

        ERROR,
        NO_RESOLUTION,
        SUCCESS;
    }

    private static final class y implements ScheduledExecutorService {

        final ScheduledExecutorService a;
        /* synthetic */ y(ScheduledExecutorService scheduledExecutorService, g1.a aVar) {
            this(scheduledExecutorService);
        }

        public boolean awaitTermination(long j, TimeUnit timeUnit) {
            return this.a.awaitTermination(j, timeUnit);
        }

        public void execute(Runnable runnable) {
            this.a.execute(runnable);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            return this.a.invokeAll(collection);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            return this.a.invokeAny(collection);
        }

        public boolean isShutdown() {
            return this.a.isShutdown();
        }

        public boolean isTerminated() {
            return this.a.isTerminated();
        }

        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            return this.a.schedule(callable, j, timeUnit);
        }

        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.a.scheduleAtFixedRate(runnable, j, j2, timeUnit);
        }

        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.a.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        }

        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        public <T> Future<T> submit(Callable<T> callable) {
            return this.a.submit(callable);
        }

        private y(ScheduledExecutorService scheduledExecutorService) {
            super();
            n.p(scheduledExecutorService, "delegate");
            this.a = scheduledExecutorService;
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
            return this.a.invokeAll(collection, j, timeUnit);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
            return this.a.invokeAny(collection, j, timeUnit);
        }

        public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.a.schedule(runnable, j, timeUnit);
        }

        public Future<?> submit(Runnable runnable) {
            return this.a.submit(runnable);
        }

        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.a.submit(runnable, t);
        }
    }

    class a extends f0 {
        a() {
            super();
        }

        @Override // io.grpc.f0
        public f0.b a(o0.f fVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    final class c implements m.a {

        final /* synthetic */ l2 a;
        c(l2 l2Var) {
            this.a = l2Var;
            super();
        }

        public m a() {
            return new m(this.a);
        }
    }

    final class e extends o0.i {

        private final o0.e a;
        final /* synthetic */ Throwable b;
        e(Throwable th) {
            this.b = th;
            super();
            this.a = o0.e.e(d1.m.r("Panic! This is a bug!").q(th));
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f fVar) {
            return this.a;
        }

        @Override // io.grpc.o0$i
        public String toString() {
            j.b bVar = j.b(g1.e.class);
            bVar.d("panicPickResult", this.a);
            return bVar.toString();
        }
    }

    class m extends h<Object, Object> {
        m() {
            super();
        }

        @Override // io.grpc.h
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.h
        public void halfClose() {
        }

        @Override // io.grpc.h
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.h
        public void request(int i) {
        }

        @Override // io.grpc.h
        public void sendMessage(Object object) {
        }

        @Override // io.grpc.h
        public void start(h.a<Object> aVar, t0 t0Var) {
        }
    }

    private final class n implements p.e {

        final /* synthetic */ g1 a;
        private n() {
            this.a = g1Var;
            super();
        }

        static /* synthetic */ s b(g1.n nVar, o0.f fVar) {
            return nVar.c(fVar);
        }

        private s c(o0.f fVar) {
            o0.i iVar = this.a.D;
            if (this.a.L.get()) {
                return this.a.J;
            }
            if (iVar == null) {
                this.a.q.execute(new g1.n.a(this));
                return this.a.J;
            }
            io.grpc.j1.s sVar = r0.j(iVar.a(fVar), fVar.a().j());
            if (sVar != null) {
                return sVar;
            }
            return this.a.J;
        }

        public q a(u0<?, ?> u0Var, d dVar, t0 t0Var, io.grpc.s sVar) {
            io.grpc.j1.a2 a2Var;
            io.grpc.j1.t0 t0Var2;
            if (!this.a.e0) {
                int i2 = 0;
                try {
                } finally {
                    sVar.j(sVar2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) u0Var;
                }
                sVar.j(sVar.c());
                return c(new t1(u0Var, t0Var, dVar)).b(u0Var, t0Var, dVar, r0.f(dVar, t0Var, i2, false));
            }
            Object obj = dVar.h(j1.b.g);
            int i = 0;
            i = obj == null ? i : a2Var;
            i = obj == null ? i : t0Var2;
            g1.n.b bVar = new g1.n.b(this, u0Var, t0Var, dVar, a2Var, t0Var2, this.a.X.g(), sVar);
            return bVar;
        }

        /* synthetic */ n(g1.a aVar) {
            this(g1Var);
        }
    }

    private final class q implements k1.a {

        final /* synthetic */ g1 a;
        private q() {
            this.a = g1Var;
            super();
        }

        public void a(d1 d1Var) {
            n.v(this.a.L.get(), "Channel must have been shut down");
        }

        public void c() {
            n.v(this.a.L.get(), "Channel must have been shut down");
            this.a.N = 1;
            this.a.O0(0);
            this.a.H0();
            this.a.I0();
        }

        public void d(boolean z) {
            g1Var.g0.e(this.a.J, z);
        }

        /* synthetic */ q(g1.a aVar) {
            this(g1Var);
        }

        public void b() {
        }
    }

    private final class s extends w0<Object> {

        final /* synthetic */ g1 b;
        private s() {
            this.b = g1Var;
            super();
        }

        @Override // io.grpc.j1.w0
        protected void b() {
            this.b.D0();
        }

        @Override // io.grpc.j1.w0
        protected void c() {
            if (this.b.L.get()) {
                return;
            }
            this.b.M0();
        }

        /* synthetic */ s(g1.a aVar) {
            this(g1Var);
        }
    }

    private final class u extends o0.d {

        j.b a;
        boolean b;
        boolean c;
        final /* synthetic */ g1 d;
        private u() {
            this.d = g1Var;
            super();
        }

        @Override // io.grpc.o0$d
        public g b() {
            return this.d.T;
        }

        @Override // io.grpc.o0$d
        public f1 c() {
            return this.d.q;
        }

        @Override // io.grpc.o0$d
        public void d() {
            this.d.q.d();
            this.b = true;
            this.d.q.execute(new g1.u.a(this));
        }

        @Override // io.grpc.o0$d
        public void e(io.grpc.q qVar, o0.i iVar) {
            this.d.q.d();
            n.p(qVar, "newState");
            n.p(iVar, "newPicker");
            this.d.q.execute(new g1.u.b(this, iVar, qVar));
        }

        @Override // io.grpc.o0$d
        public e f(o0.b bVar) {
            this.d.q.d();
            n.v(!this.d.N, "Channel is being terminated");
            return new g1.z(this.d, bVar, this);
        }

        /* synthetic */ u(g1.a aVar) {
            this(g1Var);
        }
    }

    private class w extends e {

        private final AtomicReference<f0> a;
        private final String b;
        private final e c;
        final /* synthetic */ g1 d;
        /* synthetic */ w(String str, g1.a aVar) {
            this(g1Var, str);
        }

        static /* synthetic */ AtomicReference i(g1.w wVar) {
            return wVar.a;
        }

        static /* synthetic */ String j(g1.w wVar) {
            return wVar.b;
        }

        static /* synthetic */ h k(g1.w wVar, u0 u0Var, d dVar) {
            return wVar.l(u0Var, dVar);
        }

        private <ReqT, RespT> h<ReqT, RespT> l(u0<ReqT, RespT> u0Var, d dVar) {
            final f0 f0Var = this.a.get();
            if (f0Var == null) {
                return this.c.h(u0Var, dVar);
            }
            if (f0Var instanceof j1.c) {
                io.grpc.j1.j1.b bVar = f0Var.b.f(u0Var);
                if (bVar != null) {
                    dVar = dVar.q(j1.b.g, bVar);
                }
                return this.c.h(u0Var, dVar);
            }
            g1.o oVar = new g1.o(f0Var, this.c, this.d.j, u0Var, dVar);
            return oVar;
        }

        @Override // io.grpc.e
        public String a() {
            return this.b;
        }

        @Override // io.grpc.e
        public <ReqT, RespT> h<ReqT, RespT> h(u0<ReqT, RespT> u0Var, d dVar) {
            if (this.a.get() != g1.r0) {
                return l(u0Var, dVar);
            }
            this.d.q.execute(new g1.w.d(this));
            if (this.a.get() != g1.r0) {
                return l(u0Var, dVar);
            }
            if (this.d.L.get()) {
                return new g1.w.e(this);
            }
            io.grpc.j1.g1.w.g gVar = new g1.w.g(this, s.i(), u0Var, dVar);
            this.d.q.execute(new g1.w.f(this, gVar));
            return gVar;
        }

        @Override // io.grpc.e
        void m() {
            if (this.a.get() == g1.r0) {
                p(null);
            }
        }

        @Override // io.grpc.e
        void n() {
            this.d.q.execute(new g1.w.b(this));
        }

        @Override // io.grpc.e
        void o() {
            this.d.q.execute(new g1.w.c(this));
        }

        @Override // io.grpc.e
        void p(f0 f0Var) {
            this.a.set(f0Var);
            if ((f0)this.a.get() == g1.r0) {
                if (this.d.G != null) {
                    Iterator it = this.d.G.iterator();
                    while (it.hasNext()) {
                        (g1.w.g)it.next().k();
                    }
                }
            }
        }

        private w(String str) {
            this.d = g1Var;
            super();
            this.a = new AtomicReference(g1.r0);
            this.c = new g1.w.a(this);
            n.p(str, "authority");
            this.b = str;
        }
    }

    class l extends n0 {

        final /* synthetic */ String b;
        l(v0 v0Var, String str) {
            this.b = str;
            super(v0Var);
        }

        @Override // io.grpc.j1.n0
        public String a() {
            return this.b;
        }
    }

    private final class v extends v0.e {

        final g1.u a;
        final v0 b;
        final /* synthetic */ g1 c;
        v(g1.u uVar, v0 v0Var) {
            this.c = g1Var;
            super();
            n.p(uVar, "helperImpl");
            this.a = uVar;
            n.p(v0Var, "resolver");
            this.b = v0Var;
        }

        static /* synthetic */ void d(g1.v vVar, d1 d1Var) {
            vVar.e(d1Var);
        }

        private void e(d1 d1Var) {
            Object[] arr = new Object[2];
            int i2 = 0;
            arr[i2] = this.c.f();
            int i = 1;
            arr[i] = d1Var;
            g1.l0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", arr);
            this.c.V.m();
            io.grpc.j1.g1.x eRROR2 = g1.x.ERROR;
            if (this.c.W != g1.x.ERROR) {
                Object[] arr2 = new Object[i];
                this.c.T.b(g.a.WARNING, "Failed to resolve name: {0}", new Object[] { d1Var });
                this.c.W = g1.x.ERROR;
            }
            if (this.a != this.c.C) {
                return;
            }
            this.a.a.b(d1Var);
            f();
        }

        private void f() {
            if (this.c.h0 != null && g1.o(this.c).b()) {
                return;
            }
            if (this.c.i0 == null) {
                this.c.i0 = this.c.x.get();
            }
            final long l = this.c.i0.a();
            Object[] arr = new Object[1];
            this.c.T.b(g.a.DEBUG, "Scheduling DNS resolution backoff for {0} ns", new Object[] { Long.valueOf(l) });
            this.c.h0 = g1Var5.q.c(new g1.p(g1Var5), l, TimeUnit.NANOSECONDS, this.c.h.K1());
        }

        @Override // io.grpc.v0$e
        public void a(d1 d1Var) {
            n.e(!d1Var.p(), "the error status must not be OK");
            this.c.q.execute(new g1.v.a(this, d1Var));
        }

        @Override // io.grpc.v0$e
        public void c(v0.g gVar) {
            this.c.q.execute(new g1.v.b(this, gVar));
        }
    }

    private final class z extends e {

        final o0.b a;
        final g1.u b;
        final i0 c;
        final n d = new n();
        final o e;
        List<y> f;
        y0 g;
        boolean h;
        boolean i;
        f1.c j;
        final /* synthetic */ g1 k;
        z(o0.b bVar, g1.u uVar) {
            o0.b bVar22;
            this.k = g1Var;
            super();
            this.f = bVar.a();
            if (g1Var.c != null) {
                o0.b.a aVar = bVar.d();
                aVar.e(i(bVar.a()));
                bVar22 = aVar.b();
            }
            n.p(bVar22, "args");
            this.a = (o0.b)bVar22;
            n.p(uVar, "helper");
            this.b = uVar;
            final i0 i0Var = i0.b("Subchannel", g1Var.a());
            this.c = i0Var;
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "Subchannel for ";
            List list4 = bVar22.a();
            str7 = str5 + list4;
            super(i0Var, g1Var.p, g1Var.o.a(), str6, str7);
            this.e = uVar32;
            io.grpc.j1.n nVar = new n(uVar32, g1Var.o);
        }

        private List<y> i(List<y> list) {
            final ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                a.b bVar = item.b().d();
                bVar.c(y.d);
                arrayList.add(new y(item.a(), bVar.a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        @Override // io.grpc.j1.e
        public List<y> b() {
            this.k.q.d();
            n.v(this.h, "not started");
            return this.f;
        }

        @Override // io.grpc.j1.e
        public a c() {
            return this.a.b();
        }

        @Override // io.grpc.j1.e
        public Object d() {
            n.v(this.h, "Subchannel is not started");
            return this.g;
        }

        @Override // io.grpc.j1.e
        public void e() {
            this.k.q.d();
            n.v(this.h, "not started");
            this.g.a();
        }

        @Override // io.grpc.j1.e
        public void f() {
            this.k.q.d();
            boolean z4 = true;
            if (this.g == null) {
                this.i = z4;
                return;
            }
            if (this.i) {
                if (this.k.N && this.j != null) {
                    this.j.a();
                    this.j = null;
                    if (!this.k.N) {
                        this.j = this.k.q.c(new d1(new g1.z.b(this)), 5L, TimeUnit.SECONDS, this.k.h.K1());
                        return;
                    }
                    this.g.c(g1.o0);
                    return;
                }
                return;
            }
            this.i = z4;
        }

        @Override // io.grpc.j1.e
        public void g(o0.j jVar) {
            final Object jVar3 = this;
            jVar3.k.q.d();
            boolean z4 = true;
            n.v(jVar3.h ^ z4, "already started");
            n.v(jVar3.i ^ z4, "already shutdown");
            n.v(jVar3.k.N ^ z4, "Channel is being terminated");
            jVar3.h = z4;
            final List list = jVar3.a.a();
            y0 y0Var = new y0(list, jVar3.k.a(), jVar3.k.z, jVar3.k.x, jVar3.k.h, jVar3.k.h.K1(), jVar3.k.u, g1Var9.q, new g1.z.a(jVar3, jVar), jVar3.k.U, jVar3.k.Q.a(), oVar, i0Var, nVar);
            e0.a aVar2 = new e0.a();
            aVar2.b("Child Subchannel started");
            aVar2.c(e0.b.CT_INFO);
            aVar2.e(jVar3.k.o.a());
            aVar2.d(y0Var);
            jVar3.k.S.e(aVar2.a());
            jVar3.g = y0Var;
            jVar3.k.U.e(y0Var);
            jVar3.k.F.add(y0Var);
        }

        @Override // io.grpc.j1.e
        public void h(List<y> list) {
            List list2;
            this.k.q.d();
            this.f = list;
            if (this.k.c != null) {
                list2 = i(list);
            }
            this.g.U(list2);
        }

        @Override // io.grpc.j1.e
        public String toString() {
            return this.c.toString();
        }
    }

    static final class o<ReqT, RespT> extends a0<ReqT, RespT> {

        private final f0 a;
        private final e b;
        private final Executor c;
        private final u0<ReqT, RespT> d;
        private final io.grpc.s e;
        private d f;
        private h<ReqT, RespT> g;
        o(f0 f0Var, e eVar, Executor executor, u0<ReqT, RespT> u0Var, d dVar) {
            super();
            this.a = f0Var;
            this.b = eVar;
            this.d = u0Var;
            if (dVar.e() != null) {
                executor = dVar.e();
            }
            this.c = executor;
            this.f = dVar.n(executor);
            this.e = s.i();
        }

        static /* synthetic */ io.grpc.s a(g1.o oVar) {
            return oVar.e;
        }

        private void b(h.a<RespT> aVar, d1 d1Var) {
            this.c.execute(new g1.o.a(this, aVar, d1Var));
        }

        @Override // io.grpc.a0
        public void cancel(String str, Throwable th) {
            if (this.g != null) {
                this.g.cancel(str, th);
            }
        }

        @Override // io.grpc.a0
        protected h<ReqT, RespT> delegate() {
            return this.g;
        }

        @Override // io.grpc.a0
        public void start(h.a<RespT> aVar, t0 t0Var) {
            io.grpc.d.a aVar2;
            f0.b bVar2 = this.a.a(new t1(this.d, t0Var, this.f));
            d1 d1Var = bVar2.c();
            if (!d1Var.p()) {
                b(aVar, d1Var);
                this.g = g1.s0;
                return;
            }
            i iVar = bVar2.b();
            io.grpc.j1.j1.b bVar = (j1)bVar2.a().f(this.d);
            if (bVar != null) {
                this.f = this.f.q(j1.b.g, bVar);
            }
            if (iVar != null) {
                this.g = iVar.a(this.d, this.f, this.b);
            } else {
                this.g = this.b.h(this.d, this.f);
            }
            this.g.start(aVar, t0Var);
        }
    }
    static {
        g1.l0 = Logger.getLogger(g1.class.getName());
        g1.m0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
        d1 d1Var = d1.n;
        g1.n0 = d1Var.r("Channel shutdownNow invoked");
        g1.o0 = d1Var.r("Channel shutdown invoked");
        g1.p0 = d1Var.r("Subchannel shutdown invoked");
        g1.q0 = j1.a();
    }

    g1(h1 h1Var, t tVar, k.a aVar, p1<? extends Executor> p1Var, com.google.common.base.s<com.google.common.base.q> sVar, List<i> list, l2 l2Var) {
        Object obj = null;
        io.grpc.j1.m mVar;
        int cmp = 1;
        boolean z = false;
        io.grpc.j1.g1.w wVar;
        io.grpc.a1 a1Var;
        final io.grpc.j1.g1 h1Var3 = this;
        Object h1Var2 = h1Var;
        io.grpc.j1.t tVar22 = tVar;
        Object p1Var42 = p1Var;
        Object sVar52 = sVar;
        Object l2Var72 = l2Var;
        super();
        final f1 f1Var = new f1(new g1.j(h1Var3));
        h1Var3.q = f1Var;
        h1Var3.w = new w();
        float f = 0.75f;
        h1Var3.F = new HashSet(16, f);
        h1Var3.H = new Object();
        int i7 = 1;
        h1Var3.I = new HashSet(i7, f);
        io.grpc.j1.g1.a aVar2 = null;
        h1Var3.K = new g1.a0(h1Var3, aVar2);
        boolean z5 = false;
        h1Var3.L = new AtomicBoolean(z5);
        h1Var3.P = new CountDownLatch(i7);
        h1Var3.W = g1.x.NO_RESOLUTION;
        h1Var3.X = g1.q0;
        h1Var3.Z = z5;
        h1Var3.b0 = new z1.u();
        io.grpc.j1.g1.q qVar = new g1.q(h1Var3, aVar2);
        h1Var3.f0 = qVar;
        h1Var3.g0 = new g1.s(h1Var3, aVar2);
        h1Var3.j0 = new g1.n(h1Var3, aVar2);
        n.p(h1Var2.f, "target");
        h1Var3.b = str14;
        i0 i0Var = i0.b("Channel", str14);
        h1Var3.a = i0Var;
        n.p(l2Var72, "timeProvider");
        h1Var3.o = (l2)l2Var72;
        n.p(h1Var2.a, "executorPool");
        h1Var3.k = p1Var2;
        Object obj4 = p1Var2.a();
        n.p(obj4, "executor");
        h1Var3.j = obj4;
        h1Var3.g = tVar22;
        io.grpc.j1.l lVar = new l(tVar22, h1Var2.h, obj4);
        h1Var3.h = lVar;
        io.grpc.j1.l lVar2 = new l(tVar22, aVar2, obj4);
        io.grpc.j1.g1.y yVar = new g1.y(lVar.K1(), aVar2);
        h1Var3.i = yVar;
        h1Var3.p = h1Var2.v;
        StringBuilder stringBuilder = new StringBuilder();
        String str11 = "Channel for '";
        String str12 = "'";
        r18 = str11 + str14 + str12;
        h1Var3.S = oVar;
        io.grpc.j1.n nVar = new n(oVar, l2Var72);
        h1Var3.T = nVar;
        if (h1Var2.z == null) {
            a1Var = r0.k;
        }
        h1Var3.e0 = h1Var2.t;
        io.grpc.j1.j jVar2 = new j(h1Var2.k);
        h1Var3.f = jVar2;
        n.p(h1Var2.b, "offloadExecutorPool");
        h1Var3.n = new g1.r(p1Var);
        io.grpc.j1.b2 b2Var = new b2(z6, h1Var2.p, h1Var2.q, jVar2);
        v0.b.a aVar22 = v0.b.f();
        aVar22.c(h1Var.e());
        aVar22.e(a1Var);
        aVar22.h(f1Var);
        aVar22.f(yVar);
        aVar22.g(b2Var);
        aVar22.b(nVar);
        aVar22.d(new g1.k(h1Var3));
        v0.b bVar = aVar22.a();
        h1Var3.e = bVar;
        h1Var3.c = h1Var2.j;
        h1Var3.d = h1Var2.e;
        h1Var3.A = g1.G0(str14, h1Var2.j, h1Var2.e, bVar);
        n.p(p1Var42, "balancerRpcExecutorPool");
        h1Var3.l = (p1)p1Var42;
        h1Var3.m = new g1.r(p1Var42);
        io.grpc.j1.a0 a0Var = new a0(obj4, f1Var);
        h1Var3.J = a0Var;
        a0Var.e(qVar);
        h1Var3.x = aVar;
        if (h1Var2.w != null) {
            v0.c cVar2 = b2Var.a(h1Var2.w);
            int r3 = cVar2.d() == null ? 1 : 0;
            str = "Default config is invalid: %s";
            n.x((cVar2.d() == null ? 1 : 0), "Default config is invalid: %s", cVar2.d());
            Object obj2 = cVar2.c();
            h1Var3.Y = obj2;
            h1Var3.X = obj2;
            int i2 = 0;
        } else {
            h1Var3.Y = null;
        }
        h1Var3.a0 = h1Var2.x;
        wVar = new g1.w(h1Var3, h1Var3.A.a(), obj);
        h1Var3.V = wVar;
        if (h1Var2.y != null) {
            e eVar2 = h1Var2.y.a(wVar);
        }
        h1Var3.y = k.a(wVar, list);
        n.p(sVar52, "stopwatchSupplier");
        h1Var3.u = (s)sVar52;
        long l2 = -1L;
        if (h1Var2.o == l2) {
            h1Var3.v = h1Var2.o;
        } else {
            l2 = h1.J;
            int r2 = h1Var2.o >= h1.J ? 1 : 0;
            n.j((h1Var2.o >= h1.J ? 1 : 0), "invalid idleTimeoutMillis %s", h1Var2.o);
            h1Var3.v = h1Var2.o;
        }
        h1Var3.k0 = new y1(new g1.t(h1Var3, null), f1Var, lVar.K1(), (q)sVar.get());
        h1Var3.r = h1Var2.l;
        n.p(h1Var2.m, "decompressorRegistry");
        h1Var3.s = wVar2;
        n.p(h1Var2.n, "compressorRegistry");
        h1Var3.t = pVar;
        h1Var3.z = h1Var2.i;
        h1Var3.d0 = h1Var2.r;
        h1Var3.c0 = h1Var2.s;
        io.grpc.j1.g1.c cVar = new g1.c(h1Var3, l2Var);
        h1Var3.Q = cVar;
        h1Var3.R = cVar.a();
        n.o(h1Var2.u);
        h1Var3.U = d0Var;
        d0Var.d(h1Var3);
        if (!h1Var2.x && h1Var3.Y != null) {
            nVar.a(g.a.INFO, "Service config look-up disabled, using default service config");
            h1Var3.Z = true;
        }
    }

    static /* synthetic */ Executor A(g1 g1Var, d dVar) {
        return g1Var.E0(dVar);
    }

    private void A0(boolean z) {
        this.k0.i(z);
    }

    static /* synthetic */ t B(g1 g1Var) {
        return g1Var.h;
    }

    private void B0() {
        this.q.d();
        if (this.h0 != null) {
            this.h0.a();
            f1.c cVar = null;
            this.h0 = cVar;
            this.i0 = cVar;
        }
    }

    static /* synthetic */ g1.a0 C(g1 g1Var) {
        return g1Var.K;
    }

    private void C0() {
        boolean z = true;
        O0(z);
        this.J.r(null);
        this.T.a(g.a.INFO, "Entering IDLE state");
        this.w.b(q.IDLE);
        Object[] arr = new Object[2];
        arr[z] = this.J;
        if (this.g0.a(arr)) {
            D0();
        }
    }

    static /* synthetic */ g1.r D(g1 g1Var) {
        return g1Var.n;
    }

    static /* synthetic */ m E(g1 g1Var) {
        return g1Var.R;
    }

    private Executor E0(d dVar) {
        Executor executor;
        if (dVar.e() == null) {
        }
        return executor;
    }

    static /* synthetic */ g F(g1 g1Var) {
        return g1Var.T;
    }

    private static v0 F0(String str, v0.d dVar, v0.b bVar) {
        URI uri;
        boolean found;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (java.net.URISyntaxException uRISyntax) {
            dVar = new IllegalArgumentException(uRISyntax);
            throw dVar;
        }
        if (uri != null && v0Var2 != null) {
            return v0Var2;
        }
        str2 = "";
        if (!g1.m0.matcher(uRISyntax).matches()) {
            try {
                StringBuilder stringBuilder3 = new StringBuilder();
                str5 = "/";
                str4 = str5 + uRISyntax;
            } catch (java.net.URISyntaxException uRISyntax) {
                dVar = new IllegalArgumentException(uRISyntax);
                throw dVar;
            }
            v0 v0Var = dVar.b(new URI(dVar.a(), "", str4, null), bVar);
            if (v0Var != null) {
                return v0Var;
            }
        }
        Object[] arr = new Object[2];
        if (stringBuilder.length() <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", new Object[] { uRISyntax, str2 }));
            throw illegalArgumentException;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str7 = " (";
            String str6 = ")";
            str2 = str7 + stringBuilder + str6;
        }
    }

    static /* synthetic */ void G(g1 g1Var, boolean z) {
        g1Var.A0(z);
    }

    static v0 G0(String str, String str2, v0.d dVar, v0.b bVar) {
        final v0 v0Var = g1.F0(str, dVar, bVar);
        if (str2 == null) {
            return v0Var;
        }
        return new g1.l(v0Var, str2);
    }

    static /* synthetic */ boolean H(g1 g1Var) {
        return g1Var.M;
    }

    private void H0() {
        d1 d1Var;
        if (this.M) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                (y0)it.next().d(g1.n0);
            }
            Iterator it2 = this.I.iterator();
            while (it2.hasNext()) {
                (q1)it2.next().o().d(g1.n0);
            }
        }
    }

    static /* synthetic */ boolean I(g1 g1Var, boolean z) {
        g1Var.M = z;
        return z;
    }

    private void I0() {
        if (this.O) {
            return;
        }
        if (this.L.get()) {
            if (this.F.isEmpty()) {
                if (this.I.isEmpty()) {
                    str = "Terminated";
                    this.T.a(g.a.INFO, str);
                    this.U.j(this);
                    this.k.b(this.j);
                    this.m.b();
                    this.n.b();
                    this.h.close();
                    this.O = true;
                    this.P.countDown();
                }
            }
        }
    }

    static /* synthetic */ void J(g1 g1Var) {
        g1Var.H0();
    }

    static /* synthetic */ f0 K() {
        return g1.r0;
    }

    private void K0() {
        this.q.d();
        B0();
        L0();
    }

    static /* synthetic */ p L(g1 g1Var) {
        return g1Var.t;
    }

    private void L0() {
        this.q.d();
        if (this.B) {
            this.A.b();
        }
    }

    static /* synthetic */ w M(g1 g1Var) {
        return g1Var.s;
    }

    private void M0() {
        if (this.v == -1) {
            return;
        }
        this.k0.k(this.v, TimeUnit.MILLISECONDS);
    }

    static /* synthetic */ boolean N(g1 g1Var) {
        return g1Var.r;
    }

    static /* synthetic */ p.e O(g1 g1Var) {
        return g1Var.j0;
    }

    private void O0(boolean z) {
        boolean z3 = true;
        this.q.d();
        boolean z2 = false;
        if (z) {
            n.v(this.B, "nameResolver is not started");
            int r1 = this.C != null ? 1 : z2;
            str = "lbHelper is null";
            n.v((this.C != null ? 1 : z2), "lbHelper is null");
        }
        v0 v0Var3 = null;
        if (this.A != null) {
            B0();
            this.A.c();
            this.B = z2;
            if (z) {
                this.A = g1.G0(this.b, this.c, this.d, this.e);
            } else {
                this.A = v0Var3;
            }
        }
        if (this.C != null) {
            uVar.a.d();
            this.C = v0Var3;
        }
        this.D = v0Var3;
    }

    static /* synthetic */ o P(g1 g1Var) {
        return g1Var.S;
    }

    static /* synthetic */ boolean Q(g1 g1Var) {
        return g1Var.O;
    }

    private void Q0(o0.i iVar) {
        this.D = iVar;
        this.J.r(iVar);
    }

    static /* synthetic */ Collection R(g1 g1Var) {
        return g1Var.G;
    }

    static /* synthetic */ Collection S(g1 g1Var, Collection list) {
        g1Var.G = list;
        return list;
    }

    static /* synthetic */ Object T(g1 g1Var) {
        return g1Var.H;
    }

    static /* synthetic */ g1.y U(g1 g1Var) {
        return g1Var.i;
    }

    static /* synthetic */ Executor V(g1 g1Var) {
        return g1Var.j;
    }

    static /* synthetic */ h W() {
        return g1.s0;
    }

    static /* synthetic */ g1.u X(g1 g1Var) {
        return g1Var.C;
    }

    static /* synthetic */ w Y(g1 g1Var) {
        return g1Var.w;
    }

    static /* synthetic */ void Z(g1 g1Var) {
        g1Var.K0();
    }

    static /* synthetic */ boolean a0(g1 g1Var) {
        return g1Var.N;
    }

    static /* synthetic */ boolean b0(g1 g1Var, boolean z) {
        g1Var.N = z;
        return z;
    }

    static /* synthetic */ void c0(g1 g1Var, o0.i iVar) {
        g1Var.Q0(iVar);
    }

    static /* synthetic */ l2 d0(g1 g1Var) {
        return g1Var.o;
    }

    static /* synthetic */ int e0(g1 g1Var) {
        return g1Var.p;
    }

    static /* synthetic */ m.a f0(g1 g1Var) {
        return g1Var.Q;
    }

    static /* synthetic */ d0 g0(g1 g1Var) {
        return g1Var.U;
    }

    static /* synthetic */ void h0(g1 g1Var) {
        g1Var.I0();
    }

    static /* synthetic */ String i0(g1 g1Var) {
        return g1Var.z;
    }

    static /* synthetic */ k.a j0(g1 g1Var) {
        return g1Var.x;
    }

    static /* synthetic */ com.google.common.base.s k0(g1 g1Var) {
        return g1Var.u;
    }

    static /* synthetic */ Set l0(g1 g1Var) {
        return g1Var.F;
    }

    static /* synthetic */ g1.x m0(g1 g1Var) {
        return g1Var.W;
    }

    static /* synthetic */ g1.x n0(g1 g1Var, g1.x xVar) {
        g1Var.W = xVar;
        return xVar;
    }

    static /* synthetic */ f1.c o(g1 g1Var) {
        return g1Var.h0;
    }

    static /* synthetic */ k o0(g1 g1Var) {
        return g1Var.i0;
    }

    static /* synthetic */ f1.c p(g1 g1Var, f1.c cVar) {
        g1Var.h0 = cVar;
        return cVar;
    }

    static /* synthetic */ k p0(g1 g1Var, k kVar) {
        g1Var.i0 = kVar;
        return kVar;
    }

    static /* synthetic */ void q(g1 g1Var) {
        g1Var.L0();
    }

    static /* synthetic */ boolean q0(g1 g1Var) {
        return g1Var.a0;
    }

    static /* synthetic */ o0.i r(g1 g1Var) {
        return g1Var.D;
    }

    static /* synthetic */ j1 r0(g1 g1Var) {
        return g1Var.Y;
    }

    static /* synthetic */ AtomicBoolean s(g1 g1Var) {
        return g1Var.L;
    }

    static /* synthetic */ j1 s0() {
        return g1.q0;
    }

    static /* synthetic */ a0 t(g1 g1Var) {
        return g1Var.J;
    }

    static /* synthetic */ g1.w t0(g1 g1Var) {
        return g1Var.V;
    }

    static /* synthetic */ boolean u(g1 g1Var) {
        return g1Var.e0;
    }

    static /* synthetic */ boolean u0(g1 g1Var) {
        return g1Var.Z;
    }

    static /* synthetic */ j1 v(g1 g1Var) {
        return g1Var.X;
    }

    static /* synthetic */ boolean v0(g1 g1Var, boolean z) {
        g1Var.Z = z;
        return z;
    }

    static /* synthetic */ j1 w(g1 g1Var, j1 j1Var) {
        g1Var.X = j1Var;
        return j1Var;
    }

    static /* synthetic */ String w0(g1 g1Var) {
        return g1Var.c;
    }

    static /* synthetic */ z1.u x(g1 g1Var) {
        return g1Var.b0;
    }

    static /* synthetic */ void x0(g1 g1Var, boolean z) {
        g1Var.O0(z);
    }

    static /* synthetic */ long y(g1 g1Var) {
        return g1Var.c0;
    }

    static /* synthetic */ void y0(g1 g1Var) {
        g1Var.M0();
    }

    static /* synthetic */ long z(g1 g1Var) {
        return g1Var.d0;
    }

    static /* synthetic */ void z0(g1 g1Var) {
        g1Var.C0();
    }

    @Override // io.grpc.r0
    void D0() {
        this.q.d();
    }

    @Override // io.grpc.r0
    void J0(Throwable th) {
        if (this.E) {
            return;
        }
        boolean z2 = true;
        this.E = z2;
        A0(z2);
        O0(false);
        Q0(new g1.e(this, th));
        this.T.a(g.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.w.b(q.TRANSIENT_FAILURE);
    }

    @Override // io.grpc.r0
    public g1 N0() {
        this.T.a(g.a.DEBUG, "shutdown() called");
        if (!this.L.compareAndSet(false, true)) {
            return this;
        }
        this.q.execute(new g1.h(this));
        this.V.n();
        this.q.execute(new g1.b(this));
        return this;
    }

    @Override // io.grpc.r0
    public g1 P0() {
        this.T.a(g.a.DEBUG, "shutdownNow() called");
        N0();
        this.V.o();
        this.q.execute(new g1.i(this));
        return this;
    }

    @Override // io.grpc.r0
    public String a() {
        return this.y.a();
    }

    @Override // io.grpc.r0
    public i0 f() {
        return this.a;
    }

    @Override // io.grpc.r0
    public <ReqT, RespT> h<ReqT, RespT> h(u0<ReqT, RespT> u0Var, d dVar) {
        return this.y.h(u0Var, dVar);
    }

    @Override // io.grpc.r0
    public boolean i(long j, TimeUnit timeUnit) throws java.lang.InterruptedException {
        return this.P.await(j, timeUnit);
    }

    @Override // io.grpc.r0
    public void j() {
        this.q.execute(new g1.f(this));
    }

    @Override // io.grpc.r0
    public io.grpc.q k(boolean z) {
        io.grpc.q qVar = this.w.a();
        if (q.IDLE && qVar == q.IDLE) {
            this.q.execute(new g1.g(this));
        }
        return qVar;
    }

    @Override // io.grpc.r0
    public void l(io.grpc.q qVar, Runnable runnable) {
        this.q.execute(new g1.d(this, runnable, qVar));
    }

    @Override // io.grpc.r0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.c("logId", this.a.d());
        bVar.d("target", this.b);
        return bVar.toString();
    }
}
