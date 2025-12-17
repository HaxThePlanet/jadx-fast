package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import com.google.common.base.q;
import com.google.common.base.s;
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
import io.grpc.q;
import io.grpc.r0;
import io.grpc.s;
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

/* loaded from: classes3.dex */
final class g1 extends r0 implements h0<Object> {

    static final Logger l0;
    static final Pattern m0;
    static final d1 n0;
    static final d1 o0;
    static final d1 p0;
    private static final io.grpc.j1.j1 q0;
    private static final f0 r0;
    private static final h<Object, Object> s0;
    private v0 A;
    private boolean B;
    private io.grpc.j1.g1.u C;
    private volatile o0.i D;
    private boolean E;
    private final Set<io.grpc.j1.y0> F;
    private Collection<io.grpc.j1.g1.w.g<?, ?>> G;
    private final Object H;
    private final Set<io.grpc.j1.q1> I;
    private final io.grpc.j1.a0 J;
    private final io.grpc.j1.g1.a0 K;
    private final AtomicBoolean L;
    private boolean M;
    private boolean N;
    private volatile boolean O;
    private final CountDownLatch P;
    private final io.grpc.j1.m.a Q;
    private final io.grpc.j1.m R;
    private final io.grpc.j1.o S;
    private final g T;
    private final d0 U;
    private final io.grpc.j1.g1.w V;
    private io.grpc.j1.g1.x W;
    private io.grpc.j1.j1 X;
    private final io.grpc.j1.j1 Y;
    private boolean Z;
    private final i0 a;
    private final boolean a0;
    private final String b;
    private final io.grpc.j1.z1.u b0;
    private final String c;
    private final long c0;
    private final v0.d d;
    private final long d0;
    private final v0.b e;
    private final boolean e0;
    private final io.grpc.j1.j f;
    private final io.grpc.j1.k1.a f0;
    private final io.grpc.j1.t g;
    final io.grpc.j1.w0<Object> g0;
    private final io.grpc.j1.t h;
    private f1.c h0;
    private final io.grpc.j1.g1.y i;
    private io.grpc.j1.k i0;
    private final Executor j;
    private final io.grpc.j1.p.e j0;
    private final io.grpc.j1.p1<? extends Executor> k;
    private final io.grpc.j1.y1 k0;
    private final io.grpc.j1.p1<? extends Executor> l;
    private final io.grpc.j1.g1.r m;
    private final io.grpc.j1.g1.r n;
    private final io.grpc.j1.l2 o;
    private final int p;
    final f1 q;
    private boolean r;
    private final w s;
    private final p t;
    private final s<q> u;
    private final long v;
    private final io.grpc.j1.w w;
    private final io.grpc.j1.k.a x;
    private final e y;
    private final String z;

    private final class a0 {

        final Object a;
        Collection<io.grpc.j1.q> b;
        d1 c;
        final io.grpc.j1.g1 d;
        private a0(io.grpc.j1.g1 g1) {
            this.d = g1;
            super();
            Object obj1 = new Object();
            this.a = obj1;
            obj1 = new HashSet();
            this.b = obj1;
        }

        a0(io.grpc.j1.g1 g1, io.grpc.j1.g1.a g1$a2) {
            super(g1);
        }

        d1 a(io.grpc.j1.z1<?> z1) {
            final Object obj = this.a;
            d1 d1Var = this.c;
            synchronized (obj) {
                return d1Var;
            }
        }

        void b(d1 d1) {
            Object obj;
            obj = this.a;
            synchronized (obj) {
            }
            try {
                g1.t(this.d).c(d1);
                throw d1;
            }
        }

        void c(d1 d1) {
            ArrayList arrayList;
            b(d1);
            Object obj = this.a;
            arrayList = new ArrayList(this.b);
            Iterator iterator = arrayList.iterator();
            synchronized (obj) {
                b(d1);
                obj = this.a;
                arrayList = new ArrayList(this.b);
                iterator = arrayList.iterator();
            }
            for (q arrayList : iterator) {
                arrayList.c(d1);
            }
            g1.t(this.d).d(d1);
        }

        void d(io.grpc.j1.z1<?> z1) {
            Object obj;
            Object hashSet;
            d1 obj3;
            obj = this.a;
            this.b.remove(z1);
            synchronized (obj) {
                obj3 = this.c;
                hashSet = new HashSet();
                this.b = hashSet;
                try {
                    if (obj3 != null) {
                    }
                    g1.t(this.d).c(obj3);
                    throw z1;
                }
            }
        }
    }

    final class b implements Runnable {

        final io.grpc.j1.g1 a;
        b(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.G(this.a, true);
        }
    }

    final class d implements Runnable {

        final Runnable a;
        final q b;
        final io.grpc.j1.g1 c;
        d(io.grpc.j1.g1 g1, Runnable runnable2, q q3) {
            this.c = g1;
            this.a = runnable2;
            this.b = q3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.Y(this.c).c(this.a, g1.V(this.c), this.b);
        }
    }

    final class f implements Runnable {

        final io.grpc.j1.g1 a;
        f(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            int i;
            if (!g1.s(this.a).get()) {
                if (g1.X(this.a) == null) {
                } else {
                    g1.G(this.a, false);
                    g1.z0(this.a);
                }
            }
        }
    }

    final class g implements Runnable {

        final io.grpc.j1.g1 a;
        g(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.i iVar;
            Object uVar;
            this.a.D0();
            if (g1.r(this.a) != null) {
                g1.r(this.a).b();
            }
            if (g1.X(this.a) != null) {
                uVar2.a.c();
            }
        }
    }

    final class h implements Runnable {

        final io.grpc.j1.g1 a;
        h(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.F(this.a).a(g.a.INFO, "Entering SHUTDOWN state");
            g1.Y(this.a).b(q.SHUTDOWN);
        }
    }

    final class i implements Runnable {

        final io.grpc.j1.g1 a;
        i(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g1.H(this.a)) {
            }
            g1.I(this.a, true);
            g1.J(this.a);
        }
    }

    class j implements java.lang.Thread.UncaughtExceptionHandler {

        final io.grpc.j1.g1 a;
        j(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // java.lang.Thread$UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable throwable2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(this.a.f());
            stringBuilder.append("] Uncaught exception in the SynchronizationContext. Panic!");
            g1.l0.log(Level.SEVERE, stringBuilder.toString(), throwable2);
            this.a.J0(throwable2);
        }
    }

    class k implements Executor {

        final io.grpc.j1.g1 a;
        k(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            g1.D(this.a).a().execute(runnable);
        }
    }

    class p implements Runnable {

        final io.grpc.j1.g1 a;
        p(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.p(this.a, 0);
            g1.q(this.a);
        }
    }

    private static final class r {

        private final io.grpc.j1.p1<? extends Executor> a;
        private Executor b;
        r(io.grpc.j1.p1<? extends Executor> p1) {
            super();
            n.p(p1, "executorPool");
            this.a = (p1)p1;
        }

        Executor a() {
            Object executor;
            String str;
            Executor executor2;
            synchronized (this) {
                try {
                    executor = this.a.a();
                    n.q(executor, "%s.getObject()", this.b);
                    this.b = (Executor)executor;
                    return this.b;
                    throw th;
                }
            }
        }

        void b() {
            Object executor;
            io.grpc.j1.p1 p1Var;
            executor = this.b;
            synchronized (this) {
                try {
                    this.b = (Executor)this.a.b(executor);
                    throw th;
                }
            }
        }
    }

    private class t implements Runnable {

        final io.grpc.j1.g1 a;
        private t(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        t(io.grpc.j1.g1 g1, io.grpc.j1.g1.a g1$a2) {
            super(g1);
        }

        @Override // java.lang.Runnable
        public void run() {
            g1.z0(this.a);
        }
    }

    static enum x {

        NO_RESOLUTION,
        SUCCESS,
        ERROR;
    }

    private static final class y implements ScheduledExecutorService {

        final ScheduledExecutorService a;
        private y(ScheduledExecutorService scheduledExecutorService) {
            super();
            n.p(scheduledExecutorService, "delegate");
            this.a = (ScheduledExecutorService)scheduledExecutorService;
        }

        y(ScheduledExecutorService scheduledExecutorService, io.grpc.j1.g1.a g1$a2) {
            super(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public boolean awaitTermination(long l, TimeUnit timeUnit2) {
            return this.a.awaitTermination(l, timeUnit2);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public void execute(Runnable runnable) {
            this.a.execute(runnable);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            return this.a.invokeAll(collection);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long l2, TimeUnit timeUnit3) {
            return this.a.invokeAll(collection, l2, timeUnit3);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            return this.a.invokeAny(collection);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long l2, TimeUnit timeUnit3) {
            return this.a.invokeAny(collection, l2, timeUnit3);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public boolean isShutdown() {
            return this.a.isShutdown();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public boolean isTerminated() {
            return this.a.isTerminated();
        }

        public ScheduledFuture<?> schedule(Runnable runnable, long l2, TimeUnit timeUnit3) {
            return this.a.schedule(runnable, l2, timeUnit3);
        }

        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long l2, TimeUnit timeUnit3) {
            return this.a.schedule(callable, l2, timeUnit3);
        }

        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long l2, long l3, TimeUnit timeUnit4) {
            return this.a.scheduleAtFixedRate(runnable, l2, obj3, timeUnit4);
        }

        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long l2, long l3, TimeUnit timeUnit4) {
            return this.a.scheduleWithFixedDelay(runnable, l2, obj3, timeUnit4);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public void shutdown() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Restricted: shutdown() is not allowed");
            throw unsupportedOperationException;
        }

        public List<Runnable> shutdownNow() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
            throw unsupportedOperationException;
        }

        public Future<?> submit(Runnable runnable) {
            return this.a.submit(runnable);
        }

        public <T> Future<T> submit(Runnable runnable, T t2) {
            return this.a.submit(runnable, t2);
        }

        public <T> Future<T> submit(Callable<T> callable) {
            return this.a.submit(callable);
        }
    }

    class a extends f0 {
        @Override // io.grpc.f0
        public f0.b a(o0.f o0$f) {
            IllegalStateException obj2 = new IllegalStateException("Resolution is pending");
            throw obj2;
        }
    }

    final class c implements io.grpc.j1.m.a {

        final io.grpc.j1.l2 a;
        c(io.grpc.j1.g1 g1, io.grpc.j1.l2 l22) {
            this.a = l22;
            super();
        }

        @Override // io.grpc.j1.m$a
        public io.grpc.j1.m a() {
            m mVar = new m(this.a);
            return mVar;
        }
    }

    final class e extends o0.i {

        private final o0.e a;
        final Throwable b;
        e(io.grpc.j1.g1 g1, Throwable throwable2) {
            this.b = throwable2;
            super();
            this.a = o0.e.e(d1.m.r("Panic! This is a bug!").q(throwable2));
        }

        @Override // io.grpc.o0$i
        public o0.e a(o0.f o0$f) {
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
        @Override // io.grpc.h
        public void cancel(String string, Throwable throwable2) {
        }

        @Override // io.grpc.h
        public void halfClose() {
        }

        @Override // io.grpc.h
        public boolean isReady() {
            return 0;
        }

        @Override // io.grpc.h
        public void request(int i) {
        }

        @Override // io.grpc.h
        public void sendMessage(Object object) {
        }

        public void start(h.a<Object> h$a, t0 t02) {
        }
    }

    private final class n implements io.grpc.j1.p.e {

        final io.grpc.j1.g1 a;
        private n(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        n(io.grpc.j1.g1 g1, io.grpc.j1.g1.a g1$a2) {
            super(g1);
        }

        static io.grpc.j1.s b(io.grpc.j1.g1.n g1$n, o0.f o0$f2) {
            return n.c(f2);
        }

        private io.grpc.j1.s c(o0.f o0$f) {
            o0.i iVar = g1.r(this.a);
            if (g1.s(this.a).get()) {
                return g1.t(this.a);
            }
            if (iVar == null) {
                g1.n.a aVar = new g1.n.a(this);
                obj3.q.execute(aVar);
                return g1.t(this.a);
            }
            io.grpc.j1.s obj3 = r0.j(iVar.a(f), f.a().j());
            if (obj3 != null) {
                return obj3;
            }
            return g1.t(this.a);
        }

        public io.grpc.j1.q a(u0<?, ?> u0, d d2, t0 t03, s s4) {
            Object obj;
            io.grpc.j1.a2 a2Var;
            io.grpc.j1.a2 a2Var2;
            int i;
            if (!g1.u(this.a)) {
                t1 t1Var = new t1(u0, t03, d2);
                int i3 = 0;
                s4.j(s4.c());
                return c(t1Var).b(u0, t03, d2, r0.f(d2, t03, i3, i3));
            }
            obj = d2.h(j1.b.g);
            int i2 = 0;
            a2Var2 = (j1.b)obj == null ? i2 : a2Var;
            i = (j1.b)obj == null ? i2 : obj;
            super(this, u0, t03, d2, a2Var2, i, g1.v(this.a).g(), s4);
            return bVar;
        }
    }

    private final class q implements io.grpc.j1.k1.a {

        final io.grpc.j1.g1 a;
        private q(io.grpc.j1.g1 g1) {
            this.a = g1;
            super();
        }

        q(io.grpc.j1.g1 g1, io.grpc.j1.g1.a g1$a2) {
            super(g1);
        }

        @Override // io.grpc.j1.k1$a
        public void a(d1 d1) {
            n.v(g1.s(this.a).get(), "Channel must have been shut down");
        }

        @Override // io.grpc.j1.k1$a
        public void b() {
        }

        @Override // io.grpc.j1.k1$a
        public void c() {
            n.v(g1.s(this.a).get(), "Channel must have been shut down");
            g1.b0(this.a, true);
            g1.x0(this.a, false);
            g1.J(this.a);
            g1.h0(this.a);
        }

        @Override // io.grpc.j1.k1$a
        public void d(boolean z) {
            io.grpc.j1.g1 g1Var = this.a;
            g1Var.g0.e(g1.t(g1Var), z);
        }
    }

    private final class s extends io.grpc.j1.w0<Object> {

        final io.grpc.j1.g1 b;
        private s(io.grpc.j1.g1 g1) {
            this.b = g1;
            super();
        }

        s(io.grpc.j1.g1 g1, io.grpc.j1.g1.a g1$a2) {
            super(g1);
        }

        @Override // io.grpc.j1.w0
        protected void b() {
            this.b.D0();
        }

        @Override // io.grpc.j1.w0
        protected void c() {
            if (g1.s(this.b).get()) {
            }
            g1.y0(this.b);
        }
    }

    private final class u extends o0.d {

        io.grpc.j1.j.b a;
        boolean b;
        boolean c;
        final io.grpc.j1.g1 d;
        private u(io.grpc.j1.g1 g1) {
            this.d = g1;
            super();
        }

        u(io.grpc.j1.g1 g1, io.grpc.j1.g1.a g1$a2) {
            super(g1);
        }

        @Override // io.grpc.o0$d
        public o0.h a(o0.b o0$b) {
            return f(b);
        }

        @Override // io.grpc.o0$d
        public g b() {
            return g1.F(this.d);
        }

        @Override // io.grpc.o0$d
        public f1 c() {
            return g1Var.q;
        }

        @Override // io.grpc.o0$d
        public void d() {
            g1Var.q.d();
            this.b = true;
            g1.u.a aVar = new g1.u.a(this);
            g1Var2.q.execute(aVar);
        }

        @Override // io.grpc.o0$d
        public void e(q q, o0.i o0$i2) {
            g1Var.q.d();
            n.p(q, "newState");
            n.p(i2, "newPicker");
            g1.u.b bVar = new g1.u.b(this, i2, q);
            g1Var2.q.execute(bVar);
        }

        @Override // io.grpc.o0$d
        public io.grpc.j1.e f(o0.b o0$b) {
            g1Var.q.d();
            n.v(z ^= 1, "Channel is being terminated");
            g1.z zVar = new g1.z(this.d, b, this);
            return zVar;
        }
    }

    private class w extends e {

        private final AtomicReference<f0> a;
        private final String b;
        private final e c;
        final io.grpc.j1.g1 d;
        private w(io.grpc.j1.g1 g1, String string2) {
            this.d = g1;
            super();
            AtomicReference obj2 = new AtomicReference(g1.K());
            this.a = obj2;
            obj2 = new g1.w.a(this);
            this.c = obj2;
            n.p(string2, "authority");
            this.b = (String)string2;
        }

        w(io.grpc.j1.g1 g1, String string2, io.grpc.j1.g1.a g1$a3) {
            super(g1, string2);
        }

        static AtomicReference i(io.grpc.j1.g1.w g1$w) {
            return w.a;
        }

        static String j(io.grpc.j1.g1.w g1$w) {
            return w.b;
        }

        static h k(io.grpc.j1.g1.w g1$w, u0 u02, d d3) {
            return w.l(u02, d3);
        }

        private <ReqT, RespT> h<ReqT, RespT> l(u0<ReqT, RespT> u0, d d2) {
            io.grpc.d.a aVar;
            d obj9;
            final Object obj2 = obj;
            if ((f0)obj2 == null) {
                return this.c.h(u0, d2);
            }
            io.grpc.j1.j1.b bVar = obj2.b.f(u0);
            if (obj2 instanceof j1.c && bVar != null) {
                bVar = obj2.b.f(u0);
                if (bVar != null) {
                    obj9 = d2.q(j1.b.g, bVar);
                }
                return this.c.h(u0, obj9);
            }
            super((j1.c)(j1.c)(f0)obj2, this.c, g1.V(this.d), u0, d2);
            return oVar;
        }

        @Override // io.grpc.e
        public String a() {
            return this.b;
        }

        public <ReqT, RespT> h<ReqT, RespT> h(u0<ReqT, RespT> u0, d d2) {
            if (this.a.get() != g1.K()) {
                return l(u0, d2);
            }
            g1.w.d dVar = new g1.w.d(this);
            g1Var.q.execute(dVar);
            if (this.a.get() != g1.K()) {
                return l(u0, d2);
            }
            if (g1.s(this.d).get()) {
                g1.w.e obj3 = new g1.w.e(this);
                return obj3;
            }
            g1.w.g gVar = new g1.w.g(this, s.i(), u0, d2);
            g1.w.f obj4 = new g1.w.f(this, gVar);
            obj3.q.execute(obj4);
            return gVar;
        }

        @Override // io.grpc.e
        void m() {
            Object obj;
            if (this.a.get() == g1.K()) {
                p(0);
            }
        }

        @Override // io.grpc.e
        void n() {
            g1.w.b bVar = new g1.w.b(this);
            g1Var.q.execute(bVar);
        }

        @Override // io.grpc.e
        void o() {
            g1.w.c cVar = new g1.w.c(this);
            g1Var.q.execute(cVar);
        }

        @Override // io.grpc.e
        void p(f0 f0) {
            Object next;
            Object obj3;
            this.a.set(f0);
            if ((f0)this.a.get() == g1.K() && g1.R(this.d) != null) {
                if (g1.R(this.d) != null) {
                    obj3 = g1.R(this.d).iterator();
                    for (g1.w.g next : obj3) {
                        next.k();
                    }
                }
            }
        }
    }

    class l extends io.grpc.j1.n0 {

        final String b;
        l(v0 v0, String string2) {
            this.b = string2;
            super(v0);
        }

        @Override // io.grpc.j1.n0
        public String a() {
            return this.b;
        }
    }

    private final class v extends v0.e {

        final io.grpc.j1.g1.u a;
        final v0 b;
        final io.grpc.j1.g1 c;
        v(io.grpc.j1.g1 g1, io.grpc.j1.g1.u g1$u2, v0 v03) {
            this.c = g1;
            super();
            n.p(u2, "helperImpl");
            this.a = (g1.u)u2;
            n.p(v03, "resolver");
            this.b = (v0)v03;
        }

        static void d(io.grpc.j1.g1.v g1$v, d1 d12) {
            v.e(d12);
        }

        private void e(d1 d1) {
            Object xVar;
            Object[] wARNING;
            int arr;
            int str;
            wARNING = new Object[2];
            str = 0;
            wARNING[str] = this.c.f();
            arr = 1;
            wARNING[arr] = d1;
            g1.l0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", wARNING);
            g1.t0(this.c).m();
            io.grpc.j1.g1.x eRROR = g1.x.ERROR;
            if (g1.m0(this.c) != eRROR) {
                arr = new Object[arr];
                arr[str] = d1;
                g1.F(this.c).b(g.a.WARNING, "Failed to resolve name: {0}", arr);
                g1.n0(this.c, eRROR);
            }
            if (this.a != g1.X(this.c)) {
            }
            uVar2.a.b(d1);
            f();
        }

        private void f() {
            f1.c cVar;
            Object kVar2;
            io.grpc.j1.k kVar;
            if (g1.o(this.c) != null && g1.o(this.c).b()) {
                if (g1.o(this.c).b()) {
                }
            }
            if (g1.o0(this.c) == null) {
                kVar2 = this.c;
                g1.p0(kVar2, g1.j0(kVar2).get());
            }
            final long l = g1.o0(this.c).a();
            Object[] arr = new Object[1];
            g1.F(this.c).b(g.a.DEBUG, "Scheduling DNS resolution backoff for {0} ns", Long.valueOf(l));
            io.grpc.j1.g1 g1Var5 = this.c;
            g1.p pVar = new g1.p(g1Var5);
            g1.p(g1Var5, g1Var5.q.c(pVar, l, obj4, TimeUnit.NANOSECONDS));
        }

        @Override // io.grpc.v0$e
        public void a(d1 d1) {
            n.e(z ^= 1, "the error status must not be OK");
            g1.v.a aVar = new g1.v.a(this, d1);
            g1Var.q.execute(aVar);
        }

        @Override // io.grpc.v0$e
        public void c(v0.g v0$g) {
            g1.v.b bVar = new g1.v.b(this, g);
            g1Var.q.execute(bVar);
        }
    }

    private final class z extends io.grpc.j1.e {

        final o0.b a;
        final io.grpc.j1.g1.u b;
        final i0 c;
        final io.grpc.j1.n d;
        final io.grpc.j1.o e;
        List<y> f;
        io.grpc.j1.y0 g;
        boolean h;
        boolean i;
        f1.c j;
        final io.grpc.j1.g1 k;
        z(io.grpc.j1.g1 g1, o0.b o0$b2, io.grpc.j1.g1.u g1$u3) {
            Object str;
            o0.b obj9;
            this.k = g1;
            super();
            this.f = b2.a();
            if (g1.w0(g1) != null) {
                obj9 = b2.d();
                obj9.e(i(b2.a()));
                obj9 = obj9.b();
            }
            n.p(obj9, "args");
            this.a = (o0.b)obj9;
            n.p(u3, "helper");
            this.b = (g1.u)u3;
            final i0 i0Var = i0.b("Subchannel", g1.a());
            this.c = i0Var;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Subchannel for ");
            stringBuilder.append(obj9.a());
            super(i0Var, g1.e0(g1), g1.d0(g1).a(), obj5, stringBuilder.toString());
            this.e = obj10;
            obj9 = new n(obj10, g1.d0(g1));
            this.d = obj9;
        }

        private List<y> i(List<y> list) {
            a aVar;
            y yVar;
            List list2;
            io.grpc.a.c cVar;
            ArrayList arrayList = new ArrayList();
            Iterator obj6 = list.iterator();
            for (y next2 : obj6) {
                a.b bVar = next2.b().d();
                bVar.c(y.d);
                yVar = new y(next2.a(), bVar.a());
                arrayList.add(yVar);
            }
            return Collections.unmodifiableList(arrayList);
        }

        public List<y> b() {
            g1Var.q.d();
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
            g1Var.q.d();
            n.v(this.h, "not started");
            this.g.a();
        }

        @Override // io.grpc.j1.e
        public void f() {
            boolean z2;
            boolean z;
            g1Var.q.d();
            int i = 1;
            if (this.g == null) {
                this.i = i;
            }
            z2 = this.j;
            if (this.i && g1.a0(this.k) && z2 != null) {
                if (g1.a0(this.k)) {
                    z2 = this.j;
                    if (z2 != null) {
                        z2.a();
                        this.j = 0;
                        if (!g1.a0(this.k)) {
                            g1.z.b bVar = new g1.z.b(this);
                            d1 d1Var2 = new d1(bVar);
                            this.j = g1Var4.q.c(d1Var2, 5, obj4, TimeUnit.SECONDS);
                        }
                        this.g.c(g1.o0);
                    }
                }
            }
            this.i = i;
        }

        @Override // io.grpc.j1.e
        public void g(o0.j o0$j) {
            final Object obj = this;
            g1Var.q.d();
            int i4 = 1;
            n.v(z ^= i4, "already started");
            n.v(z2 ^= i4, "already shutdown");
            n.v(z3 ^= i4, "Channel is being terminated");
            obj.h = i4;
            final List list = obj.a.a();
            io.grpc.j1.g1 g1Var9 = obj.k;
            g1.z.a aVar4 = new g1.z.a(obj, j);
            super(list, obj.k.a(), g1.i0(obj.k), g1.j0(obj.k), g1.B(obj.k), g1.B(obj.k).K1(), g1.k0(obj.k), g1Var9.q, aVar4, g1.g0(g1Var9), g1.f0(obj.k).a(), obj.e, obj.c, obj.d);
            e0.a aVar2 = new e0.a();
            aVar2.b("Child Subchannel started");
            aVar2.c(e0.b.CT_INFO);
            aVar2.e(g1.d0(obj.k).a());
            aVar2.d(y0Var);
            g1.P(obj.k).e(aVar2.a());
            obj.g = y0Var;
            g1.g0(obj.k).e(y0Var);
            g1.l0(obj.k).add(y0Var);
        }

        public void h(List<y> list) {
            List obj2;
            g1Var.q.d();
            this.f = list;
            if (g1.w0(this.k) != null) {
                obj2 = i(list);
            }
            this.g.U(obj2);
        }

        @Override // io.grpc.j1.e
        public String toString() {
            return this.c.toString();
        }
    }

    static final class o extends a0<ReqT, RespT> {

        private final f0 a;
        private final e b;
        private final Executor c;
        private final u0<ReqT, RespT> d;
        private final s e;
        private d f;
        private h<ReqT, RespT> g;
        o(f0 f0, e e2, Executor executor3, u0<ReqT, RespT> u04, d d5) {
            Executor obj3;
            super();
            this.a = f0;
            this.b = e2;
            this.d = u04;
            if (d5.e() == null) {
            } else {
                obj3 = d5.e();
            }
            this.c = obj3;
            this.f = d5.n(obj3);
            this.e = s.i();
        }

        static s a(io.grpc.j1.g1.o g1$o) {
            return o.e;
        }

        private void b(h.a<RespT> h$a, d1 d12) {
            g1.o.a aVar = new g1.o.a(this, a, d12);
            this.c.execute(aVar);
        }

        @Override // io.grpc.a0
        public void cancel(String string, Throwable throwable2) {
            final h hVar = this.g;
            if (hVar != null) {
                hVar.cancel(string, throwable2);
            }
        }

        protected h<ReqT, RespT> delegate() {
            return this.g;
        }

        public void start(h.a<RespT> h$a, t0 t02) {
            Object bVar;
            h hVar;
            Object iVar;
            Object u0Var;
            d dVar;
            io.grpc.d.a aVar;
            t1 t1Var = new t1(this.d, t02, this.f);
            f0.b bVar2 = this.a.a(t1Var);
            d1 d1Var = bVar2.c();
            if (!d1Var.p()) {
                b(a, d1Var);
                this.g = g1.W();
            }
            iVar = bVar2.b();
            bVar = (j1)bVar2.a().f(this.d);
            if (bVar != null) {
                this.f = this.f.q(j1.b.g, bVar);
            }
            if (iVar != null) {
                this.g = iVar.a(this.d, this.f, this.b);
            } else {
                this.g = this.b.h(this.d, this.f);
            }
            this.g.start(a, t02);
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
        g1.a aVar = new g1.a();
        g1.r0 = aVar;
        g1.m mVar = new g1.m();
        g1.s0 = mVar;
    }

    g1(io.grpc.j1.h1 h1, io.grpc.j1.t t2, io.grpc.j1.k.a k$a3, io.grpc.j1.p1<? extends Executor> p14, s<q> s5, List<i> list6, io.grpc.j1.l2 l27) {
        Object iNFO;
        d0 d0Var;
        int i;
        int cmp;
        Object str;
        int obj;
        Object b2Var;
        e wVar;
        Object qVar;
        long l;
        io.grpc.a1 a1Var;
        int i2;
        final io.grpc.j1.g1 g1Var = this;
        Object obj2 = h1;
        io.grpc.j1.t tVar = t2;
        obj = p14;
        Object obj6 = s5;
        Object obj8 = l27;
        super();
        g1.j jVar = new g1.j(g1Var);
        f1 f1Var = new f1(jVar);
        g1Var.q = f1Var;
        w wVar3 = new w();
        g1Var.w = wVar3;
        int i6 = 1061158912;
        HashSet hashSet = new HashSet(16, i6);
        g1Var.F = hashSet;
        Object object = new Object();
        g1Var.H = object;
        int i5 = 1;
        HashSet hashSet2 = new HashSet(i5, i6);
        g1Var.I = hashSet2;
        int i7 = 0;
        g1.a0 a0Var2 = new g1.a0(g1Var, i7);
        g1Var.K = a0Var2;
        int i9 = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i9);
        g1Var.L = atomicBoolean;
        CountDownLatch countDownLatch = new CountDownLatch(i5);
        g1Var.P = countDownLatch;
        g1Var.W = g1.x.NO_RESOLUTION;
        g1Var.X = g1.q0;
        g1Var.Z = i9;
        z1.u uVar = new z1.u();
        g1Var.b0 = uVar;
        qVar = new g1.q(g1Var, i7);
        g1Var.f0 = qVar;
        g1.s sVar = new g1.s(g1Var, i7);
        g1Var.g0 = sVar;
        g1.n nVar2 = new g1.n(g1Var, i7);
        g1Var.j0 = nVar2;
        String str12 = obj2.f;
        n.p(str12, "target");
        g1Var.b = (String)str12;
        i0 i0Var = i0.b("Channel", str12);
        g1Var.a = i0Var;
        n.p(obj8, "timeProvider");
        g1Var.o = (l2)obj8;
        io.grpc.j1.p1 p1Var2 = obj2.a;
        n.p(p1Var2, "executorPool");
        g1Var.k = (p1)p1Var2;
        Object obj10 = p1Var2.a();
        n.p(obj10, "executor");
        g1Var.j = (Executor)obj10;
        io.grpc.f fVar = obj2.g;
        g1Var.g = tVar;
        l lVar3 = new l(tVar, obj2.h, obj10);
        g1Var.h = lVar3;
        l lVar2 = new l(tVar, i7, obj10);
        g1.y yVar = new g1.y(lVar3.K1(), i7);
        g1Var.i = yVar;
        g1Var.p = obj2.v;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Channel for '");
        stringBuilder.append(str12);
        stringBuilder.append("'");
        io.grpc.j1.o oVar = oVar2;
        o oVar2 = new o(i0Var, obj2.v, l27.a(), obj17, stringBuilder.toString());
        g1Var.S = oVar;
        n nVar = new n(oVar, obj8);
        g1Var.T = nVar;
        if (obj2.z != null) {
        } else {
            a1Var = r0.k;
        }
        boolean z3 = obj2.t;
        g1Var.e0 = z3;
        j jVar2 = new j(obj2.k);
        g1Var.f = jVar2;
        io.grpc.j1.p1 p1Var = obj2.b;
        n.p(p1Var, "offloadExecutorPool");
        g1.r rVar2 = new g1.r((p1)p1Var);
        g1Var.n = rVar2;
        io.grpc.x0 x0Var = obj2.d;
        b2Var = new b2(z3, obj2.p, obj2.q, jVar2);
        v0.b.a aVar2 = v0.b.f();
        aVar2.c(h1.e());
        aVar2.e(a1Var);
        aVar2.h(f1Var);
        aVar2.f(yVar);
        aVar2.g(b2Var);
        aVar2.b(nVar);
        g1.k kVar = new g1.k(g1Var);
        aVar2.d(kVar);
        v0.b bVar = aVar2.a();
        g1Var.e = bVar;
        String str8 = obj2.j;
        g1Var.c = str8;
        v0.d dVar = obj2.e;
        g1Var.d = dVar;
        g1Var.A = g1.G0(str12, str8, dVar, bVar);
        n.p(obj, "balancerRpcExecutorPool");
        g1Var.l = (p1)obj;
        g1.r rVar = new g1.r(obj);
        g1Var.m = rVar;
        a0 a0Var = new a0(obj10, f1Var);
        g1Var.J = a0Var;
        a0Var.e(qVar);
        g1Var.x = a3;
        java.util.Map map = obj2.w;
        if (map != null) {
            v0.c cVar2 = b2Var.a(map);
            obj = cVar2.d() == null ? 1 : 0;
            n.x(obj, "Default config is invalid: %s", cVar2.d());
            Object obj5 = cVar2.c();
            g1Var.Y = (j1)obj5;
            g1Var.X = obj5;
            i = 0;
        } else {
            g1Var.Y = 0;
        }
        boolean z2 = obj2.x;
        g1Var.a0 = z2;
        wVar = new g1.w(g1Var, g1Var.A.a(), i);
        g1Var.V = wVar;
        b bVar2 = obj2.y;
        if (bVar2 != null) {
            wVar = bVar2.a(wVar);
        }
        g1Var.y = k.a(wVar, list6);
        n.p(obj6, "stopwatchSupplier");
        g1Var.u = (s)obj6;
        l = obj2.o;
        if (Long.compare(l, i2) == 0) {
            g1Var.v = l;
        } else {
            cmp = Long.compare(l, i2) >= 0 ? 1 : 0;
            n.j(cmp, "invalid idleTimeoutMillis %s", l);
            g1Var.v = obj2.o;
        }
        g1.t tVar2 = new g1.t(g1Var, 0);
        y1 y1Var = new y1(tVar2, f1Var, lVar3.K1(), (q)s5.get());
        g1Var.k0 = y1Var;
        g1Var.r = obj2.l;
        w wVar2 = obj2.m;
        n.p(wVar2, "decompressorRegistry");
        g1Var.s = (w)wVar2;
        p pVar = obj2.n;
        n.p(pVar, "compressorRegistry");
        g1Var.t = (p)pVar;
        g1Var.z = obj2.i;
        g1Var.d0 = obj2.r;
        g1Var.c0 = obj2.s;
        g1.c cVar = new g1.c(g1Var, l27);
        g1Var.Q = cVar;
        g1Var.R = cVar.a();
        d0Var = obj2.u;
        n.o(d0Var);
        g1Var.U = (d0)d0Var;
        d0Var.d(g1Var);
        if (!z2 && g1Var.Y != null) {
            if (g1Var.Y != null) {
                nVar.a(g.a.INFO, "Service config look-up disabled, using default service config");
            }
            g1Var.Z = true;
        }
    }

    static Executor A(io.grpc.j1.g1 g1, d d2) {
        return g1.E0(d2);
    }

    private void A0(boolean z) {
        this.k0.i(z);
    }

    static io.grpc.j1.t B(io.grpc.j1.g1 g1) {
        return g1.h;
    }

    private void B0() {
        f1.c cVar;
        this.q.d();
        cVar = this.h0;
        if (cVar != null) {
            cVar.a();
            cVar = 0;
            this.h0 = cVar;
            this.i0 = cVar;
        }
    }

    static io.grpc.j1.g1.a0 C(io.grpc.j1.g1 g1) {
        return g1.K;
    }

    private void C0() {
        int i = 1;
        O0(i);
        this.J.r(0);
        this.T.a(g.a.INFO, "Entering IDLE state");
        this.w.b(q.IDLE);
        Object[] arr = new Object[2];
        arr[i] = this.J;
        if (this.g0.a(arr)) {
            D0();
        }
    }

    static io.grpc.j1.g1.r D(io.grpc.j1.g1 g1) {
        return g1.n;
    }

    static io.grpc.j1.m E(io.grpc.j1.g1 g1) {
        return g1.R;
    }

    private Executor E0(d d) {
        Executor obj1;
        if (d.e() == null) {
            obj1 = this.j;
        }
        return obj1;
    }

    static g F(io.grpc.j1.g1 g1) {
        return g1.T;
    }

    private static v0 F0(String string, v0.d v0$d2, v0.b v0$b3) {
        Object stringBuilder;
        int stringBuilder2;
        URI uri;
        boolean matches;
        String string2;
        String str2;
        String string3;
        String str;
        Object obj8;
        stringBuilder = new StringBuilder();
        uri = new URI(string);
        uri = d2.b(uri, b3);
        if (uri != null && uri != null) {
            uri = d2.b(uri, b3);
            if (uri != null) {
                return uri;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("/");
        stringBuilder3.append(string);
        matches = new URI(d2.a(), "", stringBuilder3.toString(), 0);
        obj8 = d2.b(matches, b3);
        if (!g1.m0.matcher(string).matches() && obj8 != null) {
            try {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("/");
                stringBuilder3.append(string);
                matches = new URI(d2.a(), string2, stringBuilder3.toString(), i);
                obj8 = d2.b(matches, b3);
                if (obj8 != null) {
                }
                return obj8;
                d2 = new IllegalArgumentException(string);
                throw d2;
                Object[] obj9 = new Object[2];
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(" (");
                stringBuilder2.append(stringBuilder);
                stringBuilder2.append(")");
                string2 = stringBuilder2.toString();
            } catch (java.net.URISyntaxException uRISyntax) {
            }
            obj8 = new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", string, string2));
            throw obj8;
        }
    }

    static void G(io.grpc.j1.g1 g1, boolean z2) {
        g1.A0(z2);
    }

    static v0 G0(String string, String string2, v0.d v0$d3, v0.b v0$b4) {
        final v0 obj0 = g1.F0(string, d3, b4);
        if (string2 == null) {
            return obj0;
        }
        g1.l obj2 = new g1.l(obj0, string2);
        return obj2;
    }

    static boolean H(io.grpc.j1.g1 g1) {
        return g1.M;
    }

    private void H0() {
        boolean iterator;
        boolean next2;
        boolean next;
        d1 d1Var;
        if (this.M) {
            Iterator iterator2 = this.F.iterator();
            for (y0 next2 : iterator2) {
                next2.d(g1.n0);
            }
            iterator = this.I.iterator();
            for (q1 next3 : iterator) {
                next3.o().d(g1.n0);
            }
        }
    }

    static boolean I(io.grpc.j1.g1 g1, boolean z2) {
        g1.M = z2;
        return z2;
    }

    private void I0() {
        boolean empty;
        Executor executor;
        String str;
        if (this.O) {
        }
        if (this.L.get() && this.F.isEmpty() && this.I.isEmpty()) {
            if (this.F.isEmpty()) {
                if (this.I.isEmpty()) {
                    this.T.a(g.a.INFO, "Terminated");
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

    static void J(io.grpc.j1.g1 g1) {
        g1.H0();
    }

    static f0 K() {
        return g1.r0;
    }

    private void K0() {
        this.q.d();
        B0();
        L0();
    }

    static p L(io.grpc.j1.g1 g1) {
        return g1.t;
    }

    private void L0() {
        boolean z;
        this.q.d();
        if (this.B) {
            this.A.b();
        }
    }

    static w M(io.grpc.j1.g1 g1) {
        return g1.s;
    }

    private void M0() {
        final long l = this.v;
        if (Long.compare(l, i) == 0) {
        }
        this.k0.k(l, obj1);
    }

    static boolean N(io.grpc.j1.g1 g1) {
        return g1.r;
    }

    static io.grpc.j1.p.e O(io.grpc.j1.g1 g1) {
        return g1.j0;
    }

    private void O0(boolean z) {
        int i;
        int i2;
        Object v0Var;
        String str;
        v0.b bVar;
        v0 obj5;
        this.q.d();
        i = 0;
        if (z != null) {
            n.v(this.B, "nameResolver is not started");
            i2 = this.C != null ? 1 : i;
            n.v(i2, "lbHelper is null");
        }
        int i3 = 0;
        if (this.A != null) {
            B0();
            this.A.c();
            this.B = i;
            if (z != null) {
                this.A = g1.G0(this.b, this.c, this.d, this.e);
            } else {
                this.A = i3;
            }
        }
        obj5 = this.C;
        if (obj5 != null) {
            obj5.a.d();
            this.C = i3;
        }
        this.D = i3;
    }

    static io.grpc.j1.o P(io.grpc.j1.g1 g1) {
        return g1.S;
    }

    static boolean Q(io.grpc.j1.g1 g1) {
        return g1.O;
    }

    private void Q0(o0.i o0$i) {
        this.D = i;
        this.J.r(i);
    }

    static Collection R(io.grpc.j1.g1 g1) {
        return g1.G;
    }

    static Collection S(io.grpc.j1.g1 g1, Collection collection2) {
        g1.G = collection2;
        return collection2;
    }

    static Object T(io.grpc.j1.g1 g1) {
        return g1.H;
    }

    static io.grpc.j1.g1.y U(io.grpc.j1.g1 g1) {
        return g1.i;
    }

    static Executor V(io.grpc.j1.g1 g1) {
        return g1.j;
    }

    static h W() {
        return g1.s0;
    }

    static io.grpc.j1.g1.u X(io.grpc.j1.g1 g1) {
        return g1.C;
    }

    static io.grpc.j1.w Y(io.grpc.j1.g1 g1) {
        return g1.w;
    }

    static void Z(io.grpc.j1.g1 g1) {
        g1.K0();
    }

    static boolean a0(io.grpc.j1.g1 g1) {
        return g1.N;
    }

    static boolean b0(io.grpc.j1.g1 g1, boolean z2) {
        g1.N = z2;
        return z2;
    }

    static void c0(io.grpc.j1.g1 g1, o0.i o0$i2) {
        g1.Q0(i2);
    }

    static io.grpc.j1.l2 d0(io.grpc.j1.g1 g1) {
        return g1.o;
    }

    static int e0(io.grpc.j1.g1 g1) {
        return g1.p;
    }

    static io.grpc.j1.m.a f0(io.grpc.j1.g1 g1) {
        return g1.Q;
    }

    static d0 g0(io.grpc.j1.g1 g1) {
        return g1.U;
    }

    static void h0(io.grpc.j1.g1 g1) {
        g1.I0();
    }

    static String i0(io.grpc.j1.g1 g1) {
        return g1.z;
    }

    static io.grpc.j1.k.a j0(io.grpc.j1.g1 g1) {
        return g1.x;
    }

    static s k0(io.grpc.j1.g1 g1) {
        return g1.u;
    }

    static Set l0(io.grpc.j1.g1 g1) {
        return g1.F;
    }

    static io.grpc.j1.g1.x m0(io.grpc.j1.g1 g1) {
        return g1.W;
    }

    static io.grpc.j1.g1.x n0(io.grpc.j1.g1 g1, io.grpc.j1.g1.x g1$x2) {
        g1.W = x2;
        return x2;
    }

    static f1.c o(io.grpc.j1.g1 g1) {
        return g1.h0;
    }

    static io.grpc.j1.k o0(io.grpc.j1.g1 g1) {
        return g1.i0;
    }

    static f1.c p(io.grpc.j1.g1 g1, f1.c f1$c2) {
        g1.h0 = c2;
        return c2;
    }

    static io.grpc.j1.k p0(io.grpc.j1.g1 g1, io.grpc.j1.k k2) {
        g1.i0 = k2;
        return k2;
    }

    static void q(io.grpc.j1.g1 g1) {
        g1.L0();
    }

    static boolean q0(io.grpc.j1.g1 g1) {
        return g1.a0;
    }

    static o0.i r(io.grpc.j1.g1 g1) {
        return g1.D;
    }

    static io.grpc.j1.j1 r0(io.grpc.j1.g1 g1) {
        return g1.Y;
    }

    static AtomicBoolean s(io.grpc.j1.g1 g1) {
        return g1.L;
    }

    static io.grpc.j1.j1 s0() {
        return g1.q0;
    }

    static io.grpc.j1.a0 t(io.grpc.j1.g1 g1) {
        return g1.J;
    }

    static io.grpc.j1.g1.w t0(io.grpc.j1.g1 g1) {
        return g1.V;
    }

    static boolean u(io.grpc.j1.g1 g1) {
        return g1.e0;
    }

    static boolean u0(io.grpc.j1.g1 g1) {
        return g1.Z;
    }

    static io.grpc.j1.j1 v(io.grpc.j1.g1 g1) {
        return g1.X;
    }

    static boolean v0(io.grpc.j1.g1 g1, boolean z2) {
        g1.Z = z2;
        return z2;
    }

    static io.grpc.j1.j1 w(io.grpc.j1.g1 g1, io.grpc.j1.j1 j12) {
        g1.X = j12;
        return j12;
    }

    static String w0(io.grpc.j1.g1 g1) {
        return g1.c;
    }

    static io.grpc.j1.z1.u x(io.grpc.j1.g1 g1) {
        return g1.b0;
    }

    static void x0(io.grpc.j1.g1 g1, boolean z2) {
        g1.O0(z2);
    }

    static long y(io.grpc.j1.g1 g1) {
        return g1.c0;
    }

    static void y0(io.grpc.j1.g1 g1) {
        g1.M0();
    }

    static long z(io.grpc.j1.g1 g1) {
        return g1.d0;
    }

    static void z0(io.grpc.j1.g1 g1) {
        g1.C0();
    }

    @Override // io.grpc.r0
    void D0() {
        boolean z;
        boolean z2;
        io.grpc.j1.g1.v vVar;
        v0 v0Var;
        this.q.d();
        if (!this.L.get()) {
            if (this.E) {
            } else {
                if (this.g0.d()) {
                    A0(false);
                } else {
                    M0();
                }
                if (this.C != null) {
                }
                this.T.a(g.a.INFO, "Exiting idle mode");
                g1.u uVar2 = new g1.u(this, 0);
                uVar2.a = this.f.e(uVar2);
                this.C = uVar2;
                vVar = new g1.v(this, uVar2, this.A);
                this.A.d(vVar);
                this.B = true;
            }
        }
    }

    @Override // io.grpc.r0
    void J0(Throwable throwable) {
        if (this.E) {
        }
        int i = 1;
        this.E = i;
        A0(i);
        O0(false);
        g1.e eVar = new g1.e(this, throwable);
        Q0(eVar);
        this.T.a(g.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.w.b(q.TRANSIENT_FAILURE);
    }

    @Override // io.grpc.r0
    public io.grpc.j1.g1 N0() {
        this.T.a(g.a.DEBUG, "shutdown() called");
        if (!this.L.compareAndSet(false, true)) {
            return this;
        }
        g1.h hVar = new g1.h(this);
        this.q.execute(hVar);
        this.V.n();
        g1.b bVar = new g1.b(this);
        this.q.execute(bVar);
        return this;
    }

    @Override // io.grpc.r0
    public io.grpc.j1.g1 P0() {
        this.T.a(g.a.DEBUG, "shutdownNow() called");
        N0();
        this.V.o();
        g1.i iVar = new g1.i(this);
        this.q.execute(iVar);
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

    public <ReqT, RespT> h<ReqT, RespT> h(u0<ReqT, RespT> u0, d d2) {
        return this.y.h(u0, d2);
    }

    @Override // io.grpc.r0
    public boolean i(long l, TimeUnit timeUnit2) {
        return this.P.await(l, timeUnit2);
    }

    @Override // io.grpc.r0
    public void j() {
        g1.f fVar = new g1.f(this);
        this.q.execute(fVar);
    }

    @Override // io.grpc.r0
    public q k(boolean z) {
        io.grpc.j1.g1.g gVar;
        Object obj3;
        q qVar = this.w.a();
        if (z != null && qVar == q.IDLE) {
            if (qVar == q.IDLE) {
                gVar = new g1.g(this);
                this.q.execute(gVar);
            }
        }
        return qVar;
    }

    @Override // io.grpc.r0
    public void l(q q, Runnable runnable2) {
        g1.d dVar = new g1.d(this, runnable2, q);
        this.q.execute(dVar);
    }

    @Override // io.grpc.r0
    public r0 m() {
        N0();
        return this;
    }

    @Override // io.grpc.r0
    public r0 n() {
        P0();
        return this;
    }

    @Override // io.grpc.r0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.c("logId", this.a.d());
        bVar.d("target", this.b);
        return bVar.toString();
    }
}
