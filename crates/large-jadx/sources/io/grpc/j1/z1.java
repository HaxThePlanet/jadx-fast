package io.grpc.j1;

import com.google.common.base.k;
import com.google.common.base.n;
import io.grpc.a;
import io.grpc.d1;
import io.grpc.f1;
import io.grpc.l;
import io.grpc.l.a;
import io.grpc.l.b;
import io.grpc.l.c;
import io.grpc.o;
import io.grpc.t0;
import io.grpc.t0.f;
import io.grpc.u;
import io.grpc.u0;
import io.grpc.w;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RetriableStream.java */
/* loaded from: classes3.dex */
abstract class z1<ReqT> implements q {

    private static Random A;
    static final t0.f<String> x;
    static final t0.f<String> y;
    private static final d1 z;
    private final u0<ReqT, ?> a;
    private final Executor b;
    private final Executor c;
    private final ScheduledExecutorService d;
    private final t0 e;
    private final a2 f;
    private final t0 g;
    private final boolean h;
    private final Object i;
    private final z1.u j;
    private final long k;
    private final long l;
    private final z1.d0 m;
    private final x0 n;
    private volatile z1.a0 o;
    private final AtomicBoolean p;
    private long q;
    private r r;
    private z1.v s;
    private z1.v t;
    private long u;
    private d1 v;
    private boolean w;

    private static final class a0 {

        final boolean a;
        final List<z1.s> b;
        final Collection<z1.c0> c;
        final Collection<z1.c0> d;
        final int e;
        final z1.c0 f;
        final boolean g;
        final boolean h;
        a0(List<z1.s> list, Collection<z1.c0> collection, Collection<z1.c0> collection2, z1.c0 c0Var, boolean z, boolean z2, boolean z3, int i) {
            boolean contains;
            super();
            this.b = list;
            n.p(collection, "drainedSubstreams");
            this.c = (Collection)collection;
            this.f = c0Var;
            this.d = collection2;
            this.g = z;
            this.a = z2;
            this.h = z3;
            this.e = i;
            int collection32 = 0;
            final int z72 = 1;
            if (!z2 || list == null) {
            }
            n.v(z, "passThrough should imply buffer is null");
            if (!z2 || c0Var != null) {
            }
            n.v(contains, "passThrough should imply winningSubstream != null");
            if (!z2 || collection.size() == z72) {
            } else {
                if (!(collection.contains(c0Var) || collection.size() == 0)) {
                    if (!(c0Var.b)) {
                    }
                }
            }
            n.v(z2, "passThrough should imply winningSubstream is drained");
            collection2 = z72;
            n.v(z72, "cancelled should imply committed");
        }

        z1.a0 a(z1.c0 c0Var) {
            boolean z2 = false;
            Collection c0Var3;
            final int i = 1;
            n.v(this.h ^ i, "hedging frozen");
            int r0 = this.f == null ? i : 0;
            n.v((this.f == null ? i : 0), "already committed");
            if (this.d == null) {
                Set singleton = Collections.singleton(c0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.d);
                arrayList.add(c0Var);
                c0Var3 = Collections.unmodifiableCollection(arrayList);
            }
            z1.a0 c0Var2 = new z1.a0(this.b, this.c, c0Var3, this.f, this.g, this.a, this.h, this.e + 1);
            return c0Var2;
        }

        z1.a0 b() {
            z1.a0 a0Var = new z1.a0(this.b, this.c, this.d, this.f, true, this.a, this.h, this.e);
            return a0Var;
        }

        z1.a0 c(z1.c0 c0Var) {
            boolean z;
            List list;
            List emptyList;
            boolean z3;
            int i2 = 1;
            int i3 = 0;
            int r0 = this.f == null ? i2 : i3;
            n.v((this.f == null ? i2 : i3), "Already committed");
            if (this.c.contains(c0Var)) {
            } else {
            }
            z1.a0 a0Var = new z1.a0(list, emptyList, this.d, c0Var, this.g, z3, this.h, this.e);
            return a0Var;
        }

        z1.a0 d() {
            if (this.h) {
                return this;
            }
            z1.a0 a0Var = new z1.a0(this.b, this.c, this.d, this.f, this.g, this.a, true, this.e);
            return a0Var;
        }

        z1.a0 e(z1.c0 c0Var) {
            final ArrayList arrayList = new ArrayList(this.d);
            arrayList.remove(c0Var);
            z1.a0 c0Var2 = new z1.a0(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f, this.g, this.a, this.h, this.e);
            return c0Var2;
        }

        z1.a0 f(z1.c0 c0Var, z1.c0 c0Var2) {
            final ArrayList arrayList = new ArrayList(this.d);
            arrayList.remove(c0Var);
            arrayList.add(c0Var2);
            z1.a0 c0Var3 = new z1.a0(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f, this.g, this.a, this.h, this.e);
            return c0Var3;
        }

        z1.a0 g(z1.c0 c0Var) {
            c0Var.b = true;
            if (this.c.contains(c0Var)) {
                ArrayList arrayList = new ArrayList(this.c);
                arrayList.remove(c0Var);
                z1.a0 c0Var2 = new z1.a0(this.b, Collections.unmodifiableCollection(arrayList), this.d, this.f, this.g, this.a, this.h, this.e);
                return c0Var2;
            }
            return this;
        }

        z1.a0 h(z1.c0 c0Var) {
            List unmodifiableCollection;
            boolean z3 = true;
            List list;
            boolean z5;
            int i = 1;
            str = "Already passThrough";
            n.v(this.a ^ i, str);
            if (c0Var.b) {
            } else {
                if (this.c.isEmpty()) {
                    unmodifiableCollection = Collections.singletonList(c0Var);
                } else {
                    ArrayList arrayList = new ArrayList(this.c);
                    arrayList.add(c0Var);
                    unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
                }
            }
            int i2 = 0;
            int r8 = this.f != null ? i : i2;
            if (z5 && this.f == c0Var) {
                n.v(z3, "Another RPC attempt has already committed");
                int c0Var3 = 0;
            }
            z1.a0 c0Var2 = new z1.a0(list, unmodifiableCollection, this.d, this.f, this.g, z5, this.h, this.e);
            return c0Var2;
        }
    }

    class a implements java.lang.Thread.UncaughtExceptionHandler {
        a() {
            super();
        }

        @Override // java.lang.Thread$UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw d1.l(th).r("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    private static final class c0 {

        q a;
        boolean b;
        boolean c;
        final int d;
        c0(int i) {
            super();
            this.d = i;
        }
    }

    class c implements Runnable {

        final /* synthetic */ Collection a;
        final /* synthetic */ z1.c0 b;
        final /* synthetic */ Future c;
        final /* synthetic */ Future v;
        final /* synthetic */ z1 w;
        c(Collection list, z1.c0 c0Var, Future future, Future future2) {
            this.w = z1Var;
            this.a = list;
            this.b = c0Var;
            this.c = future;
            this.v = future2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            boolean z = false;
            if (this.c != null) {
                this.c.cancel(z);
            }
            if (this.v != null) {
                this.v.cancel(z);
            }
            this.w.g0();
        }
    }

    static final class d0 {

        final int a;
        final int b;
        final int c;
        final AtomicInteger d = new AtomicInteger();
        d0(float f, float f2) {
            super();
            final float f3 = 1000f;
            this.c = (int)(f2 * f3);
            int i = (int)(f * f3);
            this.a = i;
            this.b = i / 2;
            new AtomicInteger().set(i);
        }

        boolean a() {
            boolean z = true;
            int r0 = this.d.get() > this.b ? 1 : 0;
            return (this.d.get() > this.b ? 1 : 0);
        }

        boolean b() {
            boolean z = false;
            int i = this.d.get();
            int i3 = 0;
            while (i == 0) {
                final int i5 = i - 1000;
                if (this.d.compareAndSet(i, Math.max(i5, i3)) && i5 > this.b) {
                }
                i = this.d.get();
                i3 = 0;
            }
            return false;
        }

        void c() {
            int i = this.d.get();
            while (i == this.a) {
                i2 = this.c + i;
                if (this.d.compareAndSet(i, Math.min(i2, this.a))) {
                    return;
                }
                i = this.d.get();
            }
        }

        public boolean equals(Object object) {
            boolean z = true;
            int i2;
            int i3;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (!(object instanceof z1.d0)) {
                return false;
            }
            if (this.a == object.a) {
                if (this.c != object.c) {
                }
            }
            return z;
        }

        public int hashCode() {
            Object[] arr = new Object[2];
            return k.b(new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.c) });
        }
    }

    class q implements Runnable {

        final /* synthetic */ z1 a;
        q() {
            this.a = z1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.w) {
                this.a.r.c();
            }
        }
    }

    class r implements Runnable {

        final /* synthetic */ d1 a;
        final /* synthetic */ z1 b;
        r(d1 d1Var) {
            this.b = z1Var;
            this.a = d1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.w = 1;
            this.b.r.d(this.a, r.a.PROCESSED, new t0());
        }
    }

    private interface s {
        void a(z1.c0 c0Var);
    }

    static final class u {

        private final AtomicLong a = new AtomicLong();
        u() {
            super();
            final AtomicLong atomicLong = new AtomicLong();
        }

        long a(long j) {
            return this.a.addAndGet(j);
        }
    }

    private static final class v {

        final Object a;
        Future<?> b;
        boolean c;
        v(Object object) {
            super();
            this.a = object;
        }

        boolean a() {
            return this.c;
        }

        Future<?> b() {
            this.c = true;
            return this.b;
        }

        void c(Future<?> future) {
            synchronized (obj2) {
                try {
                    if (!this.c) {
                        this.b = future;
                    }
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }
    }

    private static final class w {

        final boolean a;
        final Integer b;
        public w(boolean z, Integer integer) {
            super();
            this.a = z;
            this.b = integer;
        }
    }

    private final class x implements Runnable {

        final z1.v a;
        final /* synthetic */ z1 b;
        x(z1.v vVar) {
            this.b = z1Var;
            super();
            this.a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b.execute(new z1.x.a(this));
        }
    }

    private static final class y {

        final boolean a;
        final long b;
        y(boolean z, long j) {
            super();
            this.a = z;
            this.b = j;
        }
    }

    class b implements z1.s {

        final /* synthetic */ String a;
        b(String str) {
            this.a = str;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.i(this.a);
        }
    }

    class d implements z1.s {

        final /* synthetic */ o a;
        d(o oVar) {
            this.a = oVar;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.d(this.a);
        }
    }

    class e implements z1.s {

        final /* synthetic */ u a;
        e(u uVar) {
            this.a = uVar;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.l(this.a);
        }
    }

    class f implements z1.s {

        final /* synthetic */ w a;
        f(w wVar) {
            this.a = wVar;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.h(this.a);
        }
    }

    class g implements z1.s {
        g() {
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.flush();
        }
    }

    class h implements z1.s {

        final /* synthetic */ boolean a;
        h(boolean z) {
            this.a = z;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.q(this.a);
        }
    }

    class i implements z1.s {
        i() {
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.k();
        }
    }

    class j implements z1.s {

        final /* synthetic */ int a;
        j(int i) {
            this.a = i;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.f(this.a);
        }
    }

    class k implements z1.s {

        final /* synthetic */ int a;
        k(int i) {
            this.a = i;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.g(this.a);
        }
    }

    class l implements z1.s {

        final /* synthetic */ boolean a;
        l(boolean z) {
            this.a = z;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.b(this.a);
        }
    }

    class m implements z1.s {
        m() {
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.o();
        }
    }

    class n implements z1.s {

        final /* synthetic */ int a;
        n(int i) {
            this.a = i;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.e(this.a);
        }
    }

    class o implements z1.s {

        final /* synthetic */ Object a;
        final /* synthetic */ z1 b;
        o(Object object) {
            this.b = z1Var;
            this.a = object;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.n(this.b.a.j(this.a));
        }
    }

    class z implements z1.s {

        final /* synthetic */ z1 a;
        z() {
            this.a = z1Var;
            super();
        }

        public void a(z1.c0 c0Var) {
            c0Var.a.m(new z1.b0(this.a, c0Var));
        }
    }

    private final class b0 implements r {

        final z1.c0 a;
        final /* synthetic */ z1 b;
        b0(z1.c0 c0Var) {
            this.b = z1Var;
            super();
            this.a = c0Var;
        }

        private Integer e(t0 t0Var) {
            Integer num = null;
            Object obj = t0Var.f(z1.y);
            if (obj != null) {
                try {
                    num = Integer.valueOf(obj);
                } catch (java.lang.NumberFormatException unused) {
                    t0Var = -1;
                    t0Var = Integer.valueOf(t0Var);
                }
            } else {
                int i = 0;
            }
            return num;
        }

        private z1.w f(d1 d1Var, t0 t0Var) {
            boolean z = true;
            int i;
            final Integer num = e(t0Var);
            int i2 = 1;
            int i3 = this.b.g.c.contains(d1Var.n()) ^ i2;
            i = 0;
            if (this.b.m == null || i3 != 0) {
            } else {
                if (num != null && num.intValue() < 0) {
                    i = this.b.m.b() ^ i2;
                }
            }
            if (i3 != 0 || this.b != 0) {
            }
            z1.w wVar = new z1.w(z, num);
            return wVar;
        }

        private z1.y g(d1 d1Var, t0 t0Var) {
            int i;
            double nextDouble;
            long nanos;
            boolean z = false;
            long min;
            long l;
            io.grpc.j1.z1 z1Var;
            io.grpc.j1.a2 a2Var;
            nanos = 0L;
            z = false;
            if (this.b.f == null) {
                return new z1.y(z, 0L, r2);
            }
            boolean contains = this.b.f.f.contains(d1Var.n());
            Integer num = e(t0Var);
            final int i2 = 1;
            if (this.b.m == null || !contains) {
            } else {
                if (num != null && num.intValue() < 0) {
                    i = this.b.m.b() ^ i2;
                }
            }
            int i5 = this.a.d + i2;
            if (this.b.f.a > this.a && this.b == 0 && num == null && contains) {
                nanos = (long)(double)this.b.u * z1.A.nextDouble();
                this.b.u = Math.min((long)(double)this.b.u * this.b.f.d, this.b.f.c);
            }
            return new z1.y(z, nanos, r2);
        }

        public void a(k2.a aVar) {
            boolean z = true;
            io.grpc.j1.z1.a0 a0Var = this.b.o;
            int r1 = a0Var.f != null ? 1 : 0;
            n.v((a0Var.f != null ? 1 : 0), "Headers should be received prior to messages.");
            if (a0Var.f != this.a) {
                return;
            }
            this.b.c.execute(new z1.b0.f(this, aVar));
        }

        public void b(t0 t0Var) {
            this.b.Z(this.a);
            if (this.b.o.f == this.a) {
                if (this.b.m != null) {
                    this.b.m.c();
                }
                this.b.c.execute(new z1.b0.a(this, t0Var));
            }
        }

        public void c() {
            if (!this.b.a()) {
                return;
            }
            this.b.c.execute(new z1.b0.g(this));
        }

        public void d(d1 d1Var, r.a aVar, t0 t0Var) {
            boolean empty;
            boolean z = true;
            io.grpc.d1.b bVar = null;
            io.grpc.j1.z1 z1Var;
            int size;
            boolean z3;
            Object obj2 = this.b.i;
            synchronized (obj2) {
                try {
                    this.b.o = this.b.o.g(this.a);
                    this.b.n.a(d1Var.n());
                } catch (Throwable th) {
                }
            }
            if (c0Var8.c) {
                this.b.Z(this.a);
                if (this.b.o.f == this.a) {
                    this.b.c.execute(new z1.b0.c(this, th, aVar, t0Var));
                }
                return;
            }
            if (this.b.o.f == null) {
                z = true;
                if (aVar == r.a.REFUSED && z1.A(this.b).compareAndSet(z, z)) {
                    io.grpc.j1.z1.c0 c0Var10 = this.b.a0(this.a.d, z);
                    if (this.b.h) {
                        Object obj6 = this.b.i;
                        synchronized (obj6) {
                            try {
                                this.b.o = this.b.o.f(this.a, c0Var10);
                                if (!this.b.e0(this.b.o)) {
                                    if (this.b.o.d.size() != z) {
                                    }
                                }
                            } catch (Throwable th) {
                            }
                        }
                        if (this.b) {
                            this.b.Z(c0Var10);
                        }
                    } else {
                        if (this.b.f != null) {
                            if (this.b.f.a == z) {
                                this.b.Z(c0Var10);
                            }
                        }
                    }
                    this.b.b.execute(new z1.b0.d(this, c0Var10));
                    return;
                }
                if (this.a != r.a.DROPPED) {
                    this.b.p.set(z);
                    if (!this.b.h) {
                        io.grpc.j1.z1.y yVar = g(th, t0Var);
                        if (yVar.a) {
                            Object obj4 = this.b.i;
                            synchronized (obj4) {
                                try {
                                    io.grpc.j1.z1.v vVar = new z1.v(this.b.i);
                                    this.b.s = vVar;
                                } catch (Throwable th) {
                                }
                            }
                            vVar.c(this.b.d.schedule(new z1.b0.b(this), yVar.b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    } else {
                        io.grpc.j1.z1.w wVar = f(th, t0Var);
                        if (wVar.a) {
                            this.b.i0(wVar.b);
                        }
                        Object obj5 = this.b.i;
                        synchronized (obj5) {
                            try {
                                this.b.o = this.b.o.e(this.a);
                                if (wVar.a) {
                                    return;
                                }
                            } catch (Throwable th) {
                            }
                        }
                    }
                } else {
                    if (this.b.h) {
                        this.b.d0();
                    }
                }
            }
            this.b.Z(this.a);
            if (this.b.o.f == this.a) {
                this.b.c.execute(new z1.b0.e(this, th, aVar, t0Var));
            }
        }
    }

    class p extends l.b {

        final /* synthetic */ l a;
        p(l lVar) {
            this.a = lVar;
            super();
        }

        @Override // io.grpc.l$b
        public l a(l.c cVar, t0 t0Var) {
            return this.a;
        }
    }

    class t extends l {

        private final z1.c0 a;
        long b;
        final /* synthetic */ z1 c;
        t(z1.c0 c0Var) {
            this.c = z1Var;
            super();
            this.a = c0Var;
        }

        @Override // io.grpc.l
        public void h(long j) {
            int i = 0;
            if (this.c.o.f != null) {
                return;
            }
            i = 0;
            Object obj2 = this.c.i;
            synchronized (obj2) {
                try {
                    this.b += j;
                    long l10 = this.c.q;
                    if (this.a.b <= l10) {
                        return;
                    }
                    this.a.c = z3;
                    long l = this.c.j.a(this.b - this.c.q);
                    this.c.q = this.b;
                    long l2 = this.c.l;
                    if (l > l2) {
                        this.a.c = z3;
                    }
                    if (c0Var5.c) {
                        Runnable runnable = this.c.Y(this.a);
                    }
                } catch (Throwable unused) {
                }
                try {
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
            if (this.c != 0) {
                i.run();
            }
        }
    }
    static {
        io.grpc.t0.d dVar = t0.c;
        z1.x = t0.f.e("grpc-previous-rpc-attempts", dVar);
        z1.y = t0.f.e("grpc-retry-pushback-ms", dVar);
        z1.z = d1.g.r("Stream thrown away because RetriableStream committed");
        z1.A = new Random();
    }

    z1(u0<ReqT, ?> u0Var, t0 t0Var, z1.u uVar, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, a2 a2Var, t0 t0Var2, z1.d0 d0Var) {
        boolean z;
        int i = 0;
        final io.grpc.j1.z1 u0Var3 = this;
        io.grpc.j1.a2 d0Var102 = a2Var;
        final io.grpc.j1.t0 t0Var3 = t0Var2;
        super();
        u0Var3.c = new f1(new z1.a(this));
        u0Var3.i = new Object();
        u0Var3.n = new x0();
        super(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
        u0Var3.o = a0Var;
        u0Var3.p = new AtomicBoolean();
        u0Var3.a = u0Var;
        u0Var3.j = uVar;
        u0Var3.k = j;
        u0Var3.l = j2;
        u0Var3.b = executor;
        u0Var3.d = scheduledExecutorService;
        u0Var3.e = t0Var;
        u0Var3.f = d0Var102;
        if (d0Var102 != null) {
            u0Var3.u = d0Var102.b;
        }
        u0Var3.g = t0Var3;
        i = 0;
        i = 1;
        if (d0Var102 == null || t0Var3 == null) {
        }
        n.e(z, "Should not provide both retryPolicy and hedgingPolicy");
        i = t0Var3 != null ? i : i;
        u0Var3.h = i;
        u0Var3.m = d0Var;
    }

    static /* synthetic */ AtomicBoolean A(z1 z1Var) {
        return z1Var.p;
    }

    static /* synthetic */ boolean B(z1 z1Var) {
        return z1Var.h;
    }

    static /* synthetic */ a2 C(z1 z1Var) {
        return z1Var.f;
    }

    static /* synthetic */ r D(z1 z1Var) {
        return z1Var.r;
    }

    static /* synthetic */ void E(z1 z1Var) {
        z1Var.d0();
    }

    static /* synthetic */ void F(z1 z1Var, Integer integer) {
        z1Var.i0(integer);
    }

    static /* synthetic */ z1.v G(z1 z1Var, z1.v vVar) {
        z1Var.s = vVar;
        return vVar;
    }

    static /* synthetic */ long H(z1 z1Var) {
        return z1Var.u;
    }

    static /* synthetic */ long I(z1 z1Var, long j) {
        z1Var.u = j;
        return j;
    }

    static /* synthetic */ Random J() {
        return z1.A;
    }

    static /* synthetic */ long K(z1 z1Var) {
        return z1Var.q;
    }

    static /* synthetic */ long L(z1 z1Var, long j) {
        z1Var.q = j;
        return j;
    }

    static /* synthetic */ long M(z1 z1Var) {
        return z1Var.k;
    }

    static /* synthetic */ z1.u N(z1 z1Var) {
        return z1Var.j;
    }

    static /* synthetic */ long O(z1 z1Var) {
        return z1Var.l;
    }

    static /* synthetic */ Runnable P(z1 z1Var, z1.c0 c0Var) {
        return z1Var.Y(c0Var);
    }

    static /* synthetic */ z1.a0 Q(z1 z1Var) {
        return z1Var.o;
    }

    static /* synthetic */ z1.a0 R(z1 z1Var, z1.a0 a0Var) {
        z1Var.o = a0Var;
        return a0Var;
    }

    static /* synthetic */ z1.c0 S(z1 z1Var, int i, boolean z) {
        return z1Var.a0(i, z);
    }

    static /* synthetic */ Object T(z1 z1Var) {
        return z1Var.i;
    }

    static /* synthetic */ boolean U(z1 z1Var, z1.a0 a0Var) {
        return z1Var.e0(a0Var);
    }

    static /* synthetic */ z1.d0 V(z1 z1Var) {
        return z1Var.m;
    }

    static /* synthetic */ z1.v W(z1 z1Var, z1.v vVar) {
        z1Var.t = vVar;
        return vVar;
    }

    static /* synthetic */ t0 X(z1 z1Var) {
        return z1Var.g;
    }

    private Runnable Y(z1.c0 c0Var) {
        Object obj4;
        Future future;
        synchronized (obj2) {
            try {
                final io.grpc.j1.z1.v vVar2 = null;
                if (this.o.f != null) {
                    return vVar2;
                }
                this.o = this.o.c(c0Var);
                this.j.a(-this.q);
                if (this.s != null) {
                    this.s = vVar2;
                } else {
                }
                if (this.t != null) {
                    this.t = vVar2;
                } else {
                }
                z1.c cVar = new z1.c(this, this.o.c, c0Var, obj4, future);
                return cVar;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    private void Z(z1.c0 c0Var) {
        final Runnable runnable = Y(c0Var);
        if (runnable != null) {
            runnable.run();
        }
    }

    private z1.c0 a0(int i, boolean z) {
        final io.grpc.j1.z1.c0 c0Var = new z1.c0(i);
        c0Var.a = f0(k0(this.e, i), new z1.p(this, new z1.t(this, c0Var)), i, z);
        return c0Var;
    }

    private void b0(z1.s sVar) {
        synchronized (obj2) {
            try {
                if (!this.o.a) {
                    this.o.b.add(sVar);
                }
            } catch (Throwable th) {
            }
        }
        Iterator it = this.o.c.iterator();
        while (it.hasNext()) {
            th.a((z1.c0)it.next());
        }
    }

    private void c0(z1.c0 c0Var) {
        io.grpc.j1.z1.q qVar = null;
        int min = 0;
        int i;
        boolean hasNext;
        List list;
        d1 d1Var;
        min = 0;
        synchronized (obj) {
            try {
                this.o = this.o.h(c0Var);
                if (!a()) {
                    return;
                }
                qVar = new z1.q(this);
            } catch (Throwable th) {
            }
        }
        if (qVar != null) {
            this.c.execute(qVar);
            return;
        }
        th = this.o.f == this.c ? this.v : z1.z;
        th.a.c((this.o.f == this.c ? this.v : z1.z));
    }

    private void d0() {
        io.grpc.j1.z1.v vVar2 = null;
        synchronized (obj) {
            try {
                vVar2 = null;
                if (this.t != null) {
                    this.t = null;
                }
                this.o = this.o.d();
            } catch (Throwable th) {
            }
        }
        if (vVar2 != null) {
            vVar2.cancel(false);
        }
    }

    private boolean e0(z1.a0 a0Var) {
        io.grpc.j1.z1.c0 c0Var;
        int i2;
        boolean z2 = true;
        if (a0Var.f == null) {
            a0Var = a0Var.e < this.g.a && !a0Var.h ? 1 : 0;
        }
        return (a0Var.e < this.g.a && !a0Var.h ? 1 : 0);
    }

    private void i0(Integer integer) {
        if (integer == null) {
            return;
        }
        if (integer.intValue() < 0) {
            d0();
            return;
        }
        synchronized (obj) {
            try {
                if (this.t == null) {
                    return;
                }
                Future future = this.t.b();
                final io.grpc.j1.z1.v vVar2 = new z1.v(this.i);
                this.t = vVar2;
            } catch (Throwable th) {
            }
        }
        if (this.t != null) {
            future.cancel(false);
        }
        vVar2.c(this.d.schedule(new z1.x(this, vVar2), (long)th.intValue(), TimeUnit.MILLISECONDS));
    }

    static /* synthetic */ d1 p() {
        return z1.z;
    }

    static /* synthetic */ boolean r(z1 z1Var) {
        return z1Var.w;
    }

    static /* synthetic */ ScheduledExecutorService s(z1 z1Var) {
        return z1Var.d;
    }

    static /* synthetic */ boolean t(z1 z1Var, boolean z) {
        z1Var.w = z;
        return z;
    }

    static /* synthetic */ void u(z1 z1Var, z1.c0 c0Var) {
        z1Var.c0(c0Var);
    }

    static /* synthetic */ Executor v(z1 z1Var) {
        return z1Var.b;
    }

    static /* synthetic */ u0 w(z1 z1Var) {
        return z1Var.a;
    }

    static /* synthetic */ void x(z1 z1Var, z1.c0 c0Var) {
        z1Var.Z(c0Var);
    }

    static /* synthetic */ Executor y(z1 z1Var) {
        return z1Var.c;
    }

    static /* synthetic */ x0 z(z1 z1Var) {
        return z1Var.n;
    }

    public final boolean a() {
        Iterator it = this.o.c.iterator();
        while (it.hasNext()) {
            if ((z1.c0)it.next().a.a()) {
                return true;
            }
        }
        return false;
    }

    public final void b(boolean z) {
        b0(new z1.l(this, z));
    }

    public final void c(d1 d1Var) {
        int i = 0;
        io.grpc.j1.z1.c0 c0Var = new z1.c0(0);
        c0Var.a = new o1();
        Runnable runnable = Y(c0Var);
        if (runnable != null) {
            runnable.run();
            this.c.execute(new z1.r(this, d1Var));
            return;
        }
        i = 0;
        synchronized (obj2) {
            try {
                if (this.o.c.contains(this.o.f)) {
                } else {
                    this.v = d1Var;
                }
                this.o = this.o.b();
            } catch (Throwable th) {
            }
        }
        if (this.o.f != 0) {
            i.a.c(th);
        }
    }

    public final void d(o oVar) {
        b0(new z1.d(this, oVar));
    }

    public final void e(int i) {
        if (a0Var.a) {
            a0Var.f.a.e(i);
            return;
        }
        b0(new z1.n(this, i));
    }

    public final void f(int i) {
        b0(new z1.j(this, i));
    }

    public final void flush() {
        if (a0Var.a) {
            a0Var.f.a.flush();
            return;
        }
        b0(new z1.g(this));
    }

    public final void g(int i) {
        b0(new z1.k(this, i));
    }

    public final a getAttributes() {
        if (this.o.f != null) {
            return this.o.f.a.getAttributes();
        }
        return a.b;
    }

    public final void h(w wVar) {
        b0(new z1.f(this, wVar));
    }

    public final void i(String str) {
        b0(new z1.b(this, str));
    }

    public void j(x0 x0Var) {
        io.grpc.j1.x0 x0Var4;
        synchronized (obj2) {
            try {
                x0Var.b("closed", this.n);
            } catch (Throwable th) {
            }
        }
        if (a0Var.f != null) {
            io.grpc.j1.x0 x0Var2 = new x0();
            a0Var.f.a.j(x0Var2);
            str = "committed";
            th.b(str, x0Var2);
        } else {
            x0Var2 = new x0();
            Iterator it = a0Var.c.iterator();
            while (it.hasNext()) {
                x0Var4 = new x0();
                (z1.c0)it.next().a.j(x0Var4);
                x0Var2.a(x0Var4);
            }
            str = "open";
            th.b(str, x0Var2);
        }
    }

    final void j0(ReqT reqt) {
        if (a0Var.a) {
            a0Var.f.a.n(this.a.j(reqt));
            return;
        }
        b0(new z1.o(this, reqt));
    }

    public final void k() {
        b0(new z1.i(this));
    }

    final t0 k0(t0 t0Var, int i) {
        final t0 t0Var2 = new t0();
        t0Var2.l(t0Var);
        if (i > 0) {
            t0Var2.o(z1.x, String.valueOf(i));
        }
        return t0Var2;
    }

    public final void l(u uVar) {
        b0(new z1.e(this, uVar));
    }

    public final void m(r rVar) {
        io.grpc.j1.z1.v vVar = null;
        boolean z2;
        this.r = rVar;
        d1 d1Var = h0();
        if (d1Var != null) {
            c(d1Var);
            return;
        }
        synchronized (obj4) {
            try {
                this.o.b.add(new z1.z(this));
            } catch (Throwable th) {
            }
        }
        int i2 = 0;
        io.grpc.j1.z1.c0 c0Var = a0(i2, false);
        if (this.h) {
            int i = 0;
            synchronized (obj2) {
                try {
                    this.o = this.o.a(c0Var);
                    if (e0(this.o)) {
                        if (this.m == null || this.m.a()) {
                            this.t = new z1.v(this.i);
                        }
                    }
                } catch (Throwable th) {
                }
            }
            if (this.h != null) {
                vVar.c(this.d.schedule(new z1.x(this, vVar), this.g.b, TimeUnit.NANOSECONDS));
            }
        }
        c0(c0Var);
    }

    public final void n(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public void o() {
        b0(new z1.m(this));
    }

    public final void q(boolean z) {
        b0(new z1.h(this, z));
    }

    abstract q f0(t0 t0Var, l.a aVar, int i, boolean z);

    abstract void g0();

    abstract d1 h0();
}
