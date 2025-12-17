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

/* loaded from: classes3.dex */
abstract class z1<ReqT>  implements io.grpc.j1.q {

    private static Random A;
    static final t0.f<String> x;
    static final t0.f<String> y;
    private static final d1 z;
    private final u0<ReqT, ?> a;
    private final Executor b;
    private final Executor c;
    private final ScheduledExecutorService d;
    private final t0 e;
    private final io.grpc.j1.a2 f;
    private final io.grpc.j1.t0 g;
    private final boolean h;
    private final Object i;
    private final io.grpc.j1.z1.u j;
    private final long k;
    private final long l;
    private final io.grpc.j1.z1.d0 m;
    private final io.grpc.j1.x0 n;
    private volatile io.grpc.j1.z1.a0 o;
    private final AtomicBoolean p;
    private long q;
    private io.grpc.j1.r r;
    private io.grpc.j1.z1.v s;
    private io.grpc.j1.z1.v t;
    private long u;
    private d1 v;
    private boolean w;

    private static final class a0 {

        final boolean a;
        final List<io.grpc.j1.z1.s> b;
        final Collection<io.grpc.j1.z1.c0> c;
        final Collection<io.grpc.j1.z1.c0> d;
        final int e;
        final io.grpc.j1.z1.c0 f;
        final boolean g;
        final boolean h;
        a0(List<io.grpc.j1.z1.s> list, Collection<io.grpc.j1.z1.c0> collection2, Collection<io.grpc.j1.z1.c0> collection3, io.grpc.j1.z1.c0 z1$c04, boolean z5, boolean z6, boolean z7, int i8) {
            int obj2;
            int obj4;
            super();
            this.b = list;
            n.p(collection2, "drainedSubstreams");
            this.c = (Collection)collection2;
            this.f = c04;
            this.d = collection3;
            this.g = z5;
            this.a = z6;
            this.h = z7;
            this.e = i8;
            obj4 = 0;
            final int obj8 = 1;
            if (z6) {
                if (list == null) {
                    obj2 = obj8;
                } else {
                    obj2 = obj4;
                }
            } else {
            }
            n.v(obj2, "passThrough should imply buffer is null");
            if (z6) {
                if (c04 != null) {
                    obj2 = obj8;
                } else {
                    obj2 = obj4;
                }
            } else {
            }
            n.v(obj2, "passThrough should imply winningSubstream != null");
            if (z6) {
                if (collection2.size() == obj8) {
                    if (!collection2.contains(c04)) {
                        if (collection2.size() == 0 && c04.b) {
                            if (c04.b) {
                                obj2 = obj8;
                            } else {
                                obj2 = obj4;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            n.v(obj2, "passThrough should imply winningSubstream is drained");
            if (z5) {
                obj4 = c04 != null ? obj8 : obj4;
            } else {
            }
            n.v(obj4, "cancelled should imply committed");
        }

        io.grpc.j1.z1.a0 a(io.grpc.j1.z1.c0 z1$c0) {
            int i;
            Object arrayList;
            Object str;
            Object obj12;
            final int i3 = 1;
            n.v(z ^= i3, "hedging frozen");
            i = this.f == null ? i3 : 0;
            n.v(i, "already committed");
            if (this.d == null) {
                obj12 = Collections.singleton(c0);
            } else {
                arrayList = new ArrayList(this.d);
                arrayList.add(c0);
                obj12 = Collections.unmodifiableCollection(arrayList);
            }
            super(this.b, this.c, obj12, this.f, this.g, this.a, this.h, obj12 + 1);
            return obj12;
        }

        io.grpc.j1.z1.a0 b() {
            super(this.b, this.c, this.d, this.f, 1, this.a, this.h, this.e);
            return a0Var2;
        }

        io.grpc.j1.z1.a0 c(io.grpc.j1.z1.c0 z1$c0) {
            int i;
            List list;
            List emptyList;
            int singleton;
            List list2;
            Object list3;
            int i2;
            emptyList = 1;
            singleton = 0;
            i = this.f == null ? emptyList : singleton;
            n.v(i, "Already committed");
            if (this.c.contains(c0)) {
                list2 = list;
                i2 = emptyList;
                list3 = singleton;
            } else {
                list2 = list;
                list3 = emptyList;
                i2 = singleton;
            }
            super(list2, list3, this.d, c0, this.g, i2, this.h, this.e);
            return a0Var;
        }

        io.grpc.j1.z1.a0 d() {
            if (this.h) {
                return this;
            }
            super(this.b, this.c, this.d, this.f, this.g, this.a, 1, this.e);
            return a0Var;
        }

        io.grpc.j1.z1.a0 e(io.grpc.j1.z1.c0 z1$c0) {
            ArrayList arrayList = new ArrayList(this.d);
            arrayList.remove(c0);
            super(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f, this.g, this.a, this.h, this.e);
            return obj12;
        }

        io.grpc.j1.z1.a0 f(io.grpc.j1.z1.c0 z1$c0, io.grpc.j1.z1.c0 z1$c02) {
            ArrayList arrayList = new ArrayList(this.d);
            arrayList.remove(c0);
            arrayList.add(c02);
            super(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f, this.g, this.a, this.h, this.e);
            return obj12;
        }

        io.grpc.j1.z1.a0 g(io.grpc.j1.z1.c0 z1$c0) {
            c0.b = true;
            if (this.c.contains(c0)) {
                ArrayList arrayList = new ArrayList(this.c);
                arrayList.remove(c0);
                super(this.b, Collections.unmodifiableCollection(arrayList), this.d, this.f, this.g, this.a, this.h, this.e);
                return obj12;
            }
            return this;
        }

        io.grpc.j1.z1.a0 h(io.grpc.j1.z1.c0 z1$c0) {
            Object unmodifiableCollection;
            int i;
            String str;
            List list;
            int i2;
            Object obj12;
            i = 1;
            n.v(z ^= i, "Already passThrough");
            if (c0.b) {
                unmodifiableCollection = this.c;
            } else {
                if (this.c.isEmpty()) {
                    unmodifiableCollection = Collections.singletonList(c0);
                } else {
                    ArrayList arrayList = new ArrayList(this.c);
                    arrayList.add(c0);
                    unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
                }
            }
            io.grpc.j1.z1.c0 c0Var = this.f;
            int i4 = 0;
            i2 = c0Var != null ? i : i4;
            list = this.b;
            if (i2 != 0) {
                if (c0Var == c0) {
                } else {
                    i = i4;
                }
                n.v(i, "Another RPC attempt has already committed");
                list = obj12;
            }
            super(list, unmodifiableCollection, this.d, this.f, this.g, i2, this.h, this.e);
            return obj12;
        }
    }

    class a implements java.lang.Thread.UncaughtExceptionHandler {
        a(io.grpc.j1.z1 z1) {
            super();
        }

        @Override // java.lang.Thread$UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable throwable2) {
            throw d1.l(throwable2).r("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    private static final class c0 {

        io.grpc.j1.q a;
        boolean b;
        boolean c;
        final int d;
        c0(int i) {
            super();
            this.d = i;
        }
    }

    class c implements Runnable {

        final Collection a;
        final io.grpc.j1.z1.c0 b;
        final Future c;
        final Future v;
        final io.grpc.j1.z1 w;
        c(io.grpc.j1.z1 z1, Collection collection2, io.grpc.j1.z1.c0 z1$c03, Future future4, Future future5) {
            this.w = z1;
            this.a = collection2;
            this.b = c03;
            this.c = future4;
            this.v = future5;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object next;
            Object obj;
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((z1.c0)next != this.b) {
                }
                next.a.c(z1.p());
            }
            Future future = this.c;
            int i = 0;
            if (future != null) {
                future.cancel(i);
            }
            Future future2 = this.v;
            if (future2 != null) {
                future2.cancel(i);
            }
            this.w.g0();
        }
    }

    static final class d0 {

        final int a;
        final int b;
        final int c;
        final AtomicInteger d;
        d0(float f, float f2) {
            super();
            AtomicInteger atomicInteger = new AtomicInteger();
            this.d = atomicInteger;
            final int i = 1148846080;
            this.c = (int)obj4;
            int obj3 = (int)obj3;
            this.a = obj3;
            this.b = obj3 / 2;
            atomicInteger.set(obj3);
        }

        boolean a() {
            int i;
            i = this.d.get() > this.b ? 1 : 0;
            return i;
        }

        boolean b() {
            int i;
            int i2 = this.d.get();
            i = 0;
            while (i2 == 0) {
                final int i4 = i2 + -1000;
                i2 = this.d.get();
                i = 0;
            }
            return i;
        }

        void c() {
            int compareAndSet;
            int i;
            int i2;
            AtomicInteger num;
            compareAndSet = this.d.get();
            i = this.a;
            while (compareAndSet == i) {
                if (!this.d.compareAndSet(compareAndSet, Math.min(i3 += compareAndSet, i))) {
                    break;
                }
                compareAndSet = this.d.get();
                i = this.a;
            }
        }

        public boolean equals(Object object) {
            int i;
            int i2;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i3 = 0;
            if (!object instanceof z1.d0) {
                return i3;
            }
            if (this.a == object.a && this.c == object.c) {
                if (this.c == object.c) {
                } else {
                    i = i3;
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            Object[] arr = new Object[2];
            return k.b(Integer.valueOf(this.a), Integer.valueOf(this.c));
        }
    }

    class q implements Runnable {

        final io.grpc.j1.z1 a;
        q(io.grpc.j1.z1 z1) {
            this.a = z1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (!z1.r(this.a)) {
                z1.D(this.a).c();
            }
        }
    }

    class r implements Runnable {

        final d1 a;
        final io.grpc.j1.z1 b;
        r(io.grpc.j1.z1 z1, d1 d12) {
            this.b = z1;
            this.a = d12;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            z1.t(this.b, true);
            t0 t0Var = new t0();
            z1.D(this.b).d(this.a, r.a.PROCESSED, t0Var);
        }
    }

    private interface s {
        public abstract void a(io.grpc.j1.z1.c0 z1$c0);
    }

    static final class u {

        private final AtomicLong a;
        u() {
            super();
            AtomicLong atomicLong = new AtomicLong();
            this.a = atomicLong;
        }

        long a(long l) {
            return this.a.addAndGet(l);
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
            final Object obj = this.a;
            synchronized (obj) {
                this.b = future;
            }
        }
    }

    private static final class w {

        final boolean a;
        final Integer b;
        public w(boolean z, Integer integer2) {
            super();
            this.a = z;
            this.b = integer2;
        }
    }

    private final class x implements Runnable {

        final io.grpc.j1.z1.v a;
        final io.grpc.j1.z1 b;
        x(io.grpc.j1.z1 z1, io.grpc.j1.z1.v z1$v2) {
            this.b = z1;
            super();
            this.a = v2;
        }

        @Override // java.lang.Runnable
        public void run() {
            z1.x.a aVar = new z1.x.a(this);
            z1.v(this.b).execute(aVar);
        }
    }

    private static final class y {

        final boolean a;
        final long b;
        y(boolean z, long l2) {
            super();
            this.a = z;
            this.b = l2;
        }
    }

    class b implements io.grpc.j1.z1.s {

        final String a;
        b(io.grpc.j1.z1 z1, String string2) {
            this.a = string2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.i(this.a);
        }
    }

    class d implements io.grpc.j1.z1.s {

        final o a;
        d(io.grpc.j1.z1 z1, o o2) {
            this.a = o2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.d(this.a);
        }
    }

    class e implements io.grpc.j1.z1.s {

        final u a;
        e(io.grpc.j1.z1 z1, u u2) {
            this.a = u2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.l(this.a);
        }
    }

    class f implements io.grpc.j1.z1.s {

        final w a;
        f(io.grpc.j1.z1 z1, w w2) {
            this.a = w2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.h(this.a);
        }
    }

    class g implements io.grpc.j1.z1.s {
        g(io.grpc.j1.z1 z1) {
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.flush();
        }
    }

    class h implements io.grpc.j1.z1.s {

        final boolean a;
        h(io.grpc.j1.z1 z1, boolean z2) {
            this.a = z2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.q(this.a);
        }
    }

    class i implements io.grpc.j1.z1.s {
        i(io.grpc.j1.z1 z1) {
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.k();
        }
    }

    class j implements io.grpc.j1.z1.s {

        final int a;
        j(io.grpc.j1.z1 z1, int i2) {
            this.a = i2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.f(this.a);
        }
    }

    class k implements io.grpc.j1.z1.s {

        final int a;
        k(io.grpc.j1.z1 z1, int i2) {
            this.a = i2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.g(this.a);
        }
    }

    class l implements io.grpc.j1.z1.s {

        final boolean a;
        l(io.grpc.j1.z1 z1, boolean z2) {
            this.a = z2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.b(this.a);
        }
    }

    class m implements io.grpc.j1.z1.s {
        m(io.grpc.j1.z1 z1) {
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.o();
        }
    }

    class n implements io.grpc.j1.z1.s {

        final int a;
        n(io.grpc.j1.z1 z1, int i2) {
            this.a = i2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.e(this.a);
        }
    }

    class o implements io.grpc.j1.z1.s {

        final Object a;
        final io.grpc.j1.z1 b;
        o(io.grpc.j1.z1 z1, Object object2) {
            this.b = z1;
            this.a = object2;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            c0.a.n(z1.w(this.b).j(this.a));
        }
    }

    class z implements io.grpc.j1.z1.s {

        final io.grpc.j1.z1 a;
        z(io.grpc.j1.z1 z1) {
            this.a = z1;
            super();
        }

        @Override // io.grpc.j1.z1$s
        public void a(io.grpc.j1.z1.c0 z1$c0) {
            z1.b0 b0Var = new z1.b0(this.a, c0);
            c0.a.m(b0Var);
        }
    }

    private final class b0 implements io.grpc.j1.r {

        final io.grpc.j1.z1.c0 a;
        final io.grpc.j1.z1 b;
        b0(io.grpc.j1.z1 z1, io.grpc.j1.z1.c0 z1$c02) {
            this.b = z1;
            super();
            this.a = c02;
        }

        private Integer e(t0 t0) {
            int obj2;
            obj2 = t0.f(z1.y);
            if ((String)obj2 != null) {
                obj2 = Integer.valueOf((String)obj2);
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        private io.grpc.j1.z1.w f(d1 d1, t0 t02) {
            int i;
            int i2;
            io.grpc.j1.z1.d0 intValue;
            final Integer obj6 = e(t02);
            i = 1;
            obj5 ^= i;
            final int i3 = 0;
            if (z1.V(this.b) != null) {
                if (obj5 != null) {
                    if (obj6 != null && obj6.intValue() < 0) {
                        if (obj6.intValue() < 0) {
                            z ^= i;
                        } else {
                            i2 = i3;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (obj5 == null && i2 == 0) {
                if (i2 == 0) {
                } else {
                    i = i3;
                }
            } else {
            }
            z1.w wVar = new z1.w(i, obj6);
            return wVar;
        }

        private io.grpc.j1.z1.y g(d1 d1, t0 t02) {
            io.grpc.j1.z1.d0 intValue;
            int nextDouble;
            long nanos;
            int i;
            long i2;
            long l;
            io.grpc.j1.z1 obj10;
            io.grpc.j1.a2 obj11;
            nanos = 0;
            i = 0;
            if (z1.C(this.b) == null) {
                obj10 = new z1.y(i, nanos, obj2);
                return obj10;
            }
            obj10 = a2Var2.f.contains(d1.n());
            obj11 = e(t02);
            final int i3 = 1;
            if (z1.V(this.b) != null) {
                if (obj10 == null) {
                    if (obj11 != null && obj11.intValue() < 0) {
                        if (obj11.intValue() < 0) {
                            z ^= i3;
                        } else {
                            nextDouble = i;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            i5 += i3;
            if (a2Var3.a > i6 && nextDouble == 0) {
                if (nextDouble == 0) {
                    if (obj11 == null) {
                        if (obj10 != null) {
                            nanos = (long)obj10;
                            obj10 = this.b;
                            z1.I(obj10, Math.min((long)i4, i6));
                            i = i3;
                        }
                    } else {
                        if (obj11.intValue() >= 0) {
                            nanos = TimeUnit.MILLISECONDS.toNanos((long)obj11);
                            obj10 = this.b;
                            z1.I(obj10, obj11.b);
                        }
                    }
                }
            }
            obj10 = new z1.y(i, nanos, obj2);
            return obj10;
        }

        @Override // io.grpc.j1.r
        public void a(io.grpc.j1.k2.a k2$a) {
            int i;
            io.grpc.j1.z1.a0 a0Var = z1.Q(this.b);
            i = a0Var.f != null ? 1 : 0;
            n.v(i, "Headers should be received prior to messages.");
            if (a0Var.f != this.a) {
            }
            z1.b0.f fVar = new z1.b0.f(this, a);
            z1.y(this.b).execute(fVar);
        }

        @Override // io.grpc.j1.r
        public void b(t0 t0) {
            io.grpc.j1.z1.d0 d0Var;
            Object c0Var;
            Object aVar;
            z1.x(this.b, this.a);
            if (a0Var.f == this.a && z1.V(this.b) != null) {
                if (z1.V(this.b) != null) {
                    z1.V(this.b).c();
                }
                aVar = new z1.b0.a(this, t0);
                z1.y(this.b).execute(aVar);
            }
        }

        @Override // io.grpc.j1.r
        public void c() {
            if (!this.b.a()) {
            }
            z1.b0.g gVar = new z1.b0.g(this);
            z1.y(this.b).execute(gVar);
        }

        @Override // io.grpc.j1.r
        public void d(d1 d1, io.grpc.j1.r.a r$a2, t0 t03) {
            Object c0Var2;
            io.grpc.j1.z1.c0 empty;
            Object c0Var;
            boolean compareAndSet;
            Object cVar;
            boolean z2;
            Object eVar;
            boolean z;
            Object bVar;
            Object c0Var3;
            io.grpc.j1.z1.c0 c0Var4;
            io.grpc.j1.a2 obj7;
            t0 obj8;
            Object obj = z1.T(this.b);
            io.grpc.j1.z1 z1Var14 = this.b;
            z1.R(z1Var14, z1.Q(z1Var14).g(this.a));
            z1.z(this.b).a(d1.n());
            io.grpc.j1.z1.c0 c0Var5 = this.a;
            synchronized (obj) {
                obj = z1.T(this.b);
                z1Var14 = this.b;
                z1.R(z1Var14, z1.Q(z1Var14).g(this.a));
                z1.z(this.b).a(d1.n());
                c0Var5 = this.a;
            }
            z1.x(this.b, c0Var5);
            if (a0Var.f == this.a) {
                cVar = new z1.b0.c(this, d1, a2, t03);
                z1.y(this.b).execute(cVar);
            }
        }
    }

    class p extends l.b {

        final l a;
        p(io.grpc.j1.z1 z1, l l2) {
            this.a = l2;
            super();
        }

        @Override // io.grpc.l$b
        public l a(l.c l$c, t0 t02) {
            return this.a;
        }
    }

    class t extends l {

        private final io.grpc.j1.z1.c0 a;
        long b;
        final io.grpc.j1.z1 c;
        t(io.grpc.j1.z1 z1, io.grpc.j1.z1.c0 z1$c02) {
            this.c = z1;
            super();
            this.a = c02;
        }

        @Override // io.grpc.l
        public void h(long l) {
            int i;
            long l2;
            io.grpc.j1.z1.c0 c0Var;
            long l3;
            int obj7;
            boolean obj8;
            if (a0Var.f != null) {
            }
            i = 0;
            Object obj = z1.T(this.c);
            synchronized (obj) {
                if (c0Var3.b) {
                } else {
                    l4 += l;
                    this.b = i2;
                    if (Long.compare(i2, obj7) <= 0) {
                    }
                    obj8 = 1;
                    if (Long.compare(obj7, l2) > 0) {
                        obj7.c = obj8;
                    } else {
                        z1.L(this.c, this.b);
                        if (Long.compare(l2, l3) > 0) {
                            obj7.c = obj8;
                        }
                    }
                    obj7 = this.a;
                    if (obj7.c) {
                        i = z1.P(this.c, obj7);
                    }
                    if (i != 0) {
                    }
                }
            }
            i.run();
        }
    }
    static {
        io.grpc.t0.d dVar = t0.c;
        z1.x = t0.f.e("grpc-previous-rpc-attempts", dVar);
        z1.y = t0.f.e("grpc-retry-pushback-ms", dVar);
        z1.z = d1.g.r("Stream thrown away because RetriableStream committed");
        Random random = new Random();
        z1.A = random;
    }

    z1(u0<ReqT, ?> u0, t0 t02, io.grpc.j1.z1.u z1$u3, long l4, long l5, Executor executor6, ScheduledExecutorService scheduledExecutorService7, io.grpc.j1.a2 a28, io.grpc.j1.t0 t09, io.grpc.j1.z1.d0 z1$d010) {
        int i2;
        t0 t0Var;
        int i;
        final Object obj = this;
        io.grpc.j1.a2 a2Var = d010;
        final io.grpc.j1.t0 t0Var2 = obj24;
        super();
        z1.a aVar = new z1.a(this);
        f1 f1Var = new f1(aVar);
        obj.c = f1Var;
        Object object = new Object();
        obj.i = object;
        x0 x0Var = new x0();
        obj.n = x0Var;
        ArrayList arrayList = new ArrayList(8);
        super(arrayList, Collections.emptyList(), 0, 0, 0, 0, 0, 0);
        obj.o = a0Var;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        obj.p = atomicBoolean;
        obj.a = u0;
        obj.j = u3;
        obj.k = l4;
        obj.l = executor6;
        obj.b = a28;
        obj.d = t09;
        obj.e = t02;
        obj.f = a2Var;
        if (a2Var != null) {
            obj.u = a2Var.b;
        }
        obj.g = t0Var2;
        int i4 = 1;
        if (a2Var != null) {
            if (t0Var2 == null) {
                i2 = i4;
            } else {
                i2 = i;
            }
        } else {
        }
        n.e(i2, "Should not provide both retryPolicy and hedgingPolicy");
        i = t0Var2 != null ? i4 : i;
        obj.h = i;
        obj.m = obj25;
    }

    static AtomicBoolean A(io.grpc.j1.z1 z1) {
        return z1.p;
    }

    static boolean B(io.grpc.j1.z1 z1) {
        return z1.h;
    }

    static io.grpc.j1.a2 C(io.grpc.j1.z1 z1) {
        return z1.f;
    }

    static io.grpc.j1.r D(io.grpc.j1.z1 z1) {
        return z1.r;
    }

    static void E(io.grpc.j1.z1 z1) {
        z1.d0();
    }

    static void F(io.grpc.j1.z1 z1, Integer integer2) {
        z1.i0(integer2);
    }

    static io.grpc.j1.z1.v G(io.grpc.j1.z1 z1, io.grpc.j1.z1.v z1$v2) {
        z1.s = v2;
        return v2;
    }

    static long H(io.grpc.j1.z1 z1) {
        return z1.u;
    }

    static long I(io.grpc.j1.z1 z1, long l2) {
        z1.u = l2;
        return l2;
    }

    static Random J() {
        return z1.A;
    }

    static long K(io.grpc.j1.z1 z1) {
        return z1.q;
    }

    static long L(io.grpc.j1.z1 z1, long l2) {
        z1.q = l2;
        return l2;
    }

    static long M(io.grpc.j1.z1 z1) {
        return z1.k;
    }

    static io.grpc.j1.z1.u N(io.grpc.j1.z1 z1) {
        return z1.j;
    }

    static long O(io.grpc.j1.z1 z1) {
        return z1.l;
    }

    static Runnable P(io.grpc.j1.z1 z1, io.grpc.j1.z1.c0 z1$c02) {
        return z1.Y(c02);
    }

    static io.grpc.j1.z1.a0 Q(io.grpc.j1.z1 z1) {
        return z1.o;
    }

    static io.grpc.j1.z1.a0 R(io.grpc.j1.z1 z1, io.grpc.j1.z1.a0 z1$a02) {
        z1.o = a02;
        return a02;
    }

    static io.grpc.j1.z1.c0 S(io.grpc.j1.z1 z1, int i2, boolean z3) {
        return z1.a0(i2, z3);
    }

    static Object T(io.grpc.j1.z1 z1) {
        return z1.i;
    }

    static boolean U(io.grpc.j1.z1 z1, io.grpc.j1.z1.a0 z1$a02) {
        return z1.e0(a02);
    }

    static io.grpc.j1.z1.d0 V(io.grpc.j1.z1 z1) {
        return z1.m;
    }

    static io.grpc.j1.z1.v W(io.grpc.j1.z1 z1, io.grpc.j1.z1.v z1$v2) {
        z1.t = v2;
        return v2;
    }

    static io.grpc.j1.t0 X(io.grpc.j1.z1 z1) {
        return z1.g;
    }

    private Runnable Y(io.grpc.j1.z1.c0 z1$c0) {
        Object vVar;
        Object vVar2;
        Future future;
        int i;
        final Object obj = this.i;
        final int i2 = 0;
        synchronized (obj) {
            return i2;
        }
    }

    private void Z(io.grpc.j1.z1.c0 z1$c0) {
        final Runnable obj1 = Y(c0);
        if (obj1 != null) {
            obj1.run();
        }
    }

    private io.grpc.j1.z1.c0 a0(int i, boolean z2) {
        z1.c0 c0Var = new z1.c0(i);
        z1.t tVar = new z1.t(this, c0Var);
        z1.p pVar = new z1.p(this, tVar);
        c0Var.a = f0(k0(this.e, i), pVar, i, z2);
        return c0Var;
    }

    private void b0(io.grpc.j1.z1.s z1$s) {
        boolean z;
        Collection next;
        Object obj = this.i;
        synchronized (obj) {
            a0Var2.b.add(s);
            Iterator iterator = a0Var3.c.iterator();
        }
        try {
            for (z1.c0 next : iterator) {
                s.a(next);
            }
            s.a((z1.c0)iterator.next());
            throw s;
        }
    }

    private void c0(io.grpc.j1.z1.c0 z1$c0) {
        int qVar;
        int i;
        int i2;
        List subList;
        int arrayList;
        boolean next;
        List list;
        int size;
        int size2;
        d1 obj9;
        arrayList = qVar;
        i2 = i;
        next = this.i;
        io.grpc.j1.z1.a0 a0Var3 = this.o;
        synchronized (next) {
            size = a0Var3.f;
            if (size != null && size != c0) {
                if (size != c0) {
                } else {
                    if (a0Var3.g) {
                    } else {
                        try {
                            if (i2 == a0Var3.b.size()) {
                            } else {
                            }
                            this.o = a0Var3.h(c0);
                            if (!a()) {
                            }
                            qVar = new z1.q(this);
                            if (qVar != 0) {
                            }
                            this.c.execute(qVar);
                            if (a0Var2.f == c0) {
                            } else {
                            }
                            obj9 = this.v;
                            obj9 = z1.z;
                            c0.a.c(obj9);
                            if (c0.b) {
                            } else {
                            }
                            size = Math.min(i2 + 128, a0Var3.b.size());
                            if (arrayList == null) {
                            } else {
                            }
                            arrayList = new ArrayList(a0Var3.b.subList(i2, size));
                            arrayList.clear();
                            arrayList.addAll(a0Var3.b.subList(i2, size));
                            Iterator iterator = arrayList.iterator();
                            while (iterator.hasNext()) {
                                Object next2 = iterator.next();
                                (z1.s)next2.a(c0);
                                if (next2 instanceof z1.z != null) {
                                }
                                if (i != 0) {
                                    break loop_23;
                                } else {
                                }
                                next = this.o;
                                list = next.f;
                                if (list != null) {
                                    break loop_23;
                                } else {
                                }
                                if (next.g == null) {
                                    break loop_23;
                                }
                                if (list != c0) {
                                    break loop_23;
                                } else {
                                }
                                i = 1;
                            }
                            next2 = iterator.next();
                            (z1.s)next2.a(c0);
                            if (next2 instanceof z1.z != null) {
                            }
                            i = 1;
                            if (i != 0) {
                            } else {
                            }
                            next = this.o;
                            list = next.f;
                            if (list != null) {
                            } else {
                            }
                            if (list != c0) {
                            } else {
                            }
                            if (next.g == null) {
                            }
                            i2 = size;
                            throw c0;
                        }
                    }
                }
            } else {
            }
        }
    }

    private void d0() {
        Object obj;
        Object vVar;
        int i;
        obj = this.i;
        vVar = this.t;
        synchronized (obj) {
            this.t = 0;
            i = vVar;
            this.o = this.o.d();
            if (i != 0) {
            }
        }
        try {
            i.cancel(false);
            throw th;
        }
    }

    private boolean e0(io.grpc.j1.z1.a0 z1$a0) {
        int c0Var;
        int i;
        int obj3;
        if (a0.f == null && a0.e < t0Var.a && !a0.h) {
            if (a0.e < t0Var.a) {
                obj3 = !a0.h ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    private void i0(Integer integer) {
        Object obj;
        if (integer == null) {
        }
        if (integer.intValue() < 0) {
            d0();
        }
        obj = this.i;
        io.grpc.j1.z1.v vVar = this.t;
        synchronized (obj) {
        }
        future.cancel(false);
        z1.x xVar = new z1.x(this, vVar2);
        vVar2.c(this.d.schedule(xVar, (long)obj6, obj4));
    }

    static d1 p() {
        return z1.z;
    }

    static boolean r(io.grpc.j1.z1 z1) {
        return z1.w;
    }

    static ScheduledExecutorService s(io.grpc.j1.z1 z1) {
        return z1.d;
    }

    static boolean t(io.grpc.j1.z1 z1, boolean z2) {
        z1.w = z2;
        return z2;
    }

    static void u(io.grpc.j1.z1 z1, io.grpc.j1.z1.c0 z1$c02) {
        z1.c0(c02);
    }

    static Executor v(io.grpc.j1.z1 z1) {
        return z1.b;
    }

    static u0 w(io.grpc.j1.z1 z1) {
        return z1.a;
    }

    static void x(io.grpc.j1.z1 z1, io.grpc.j1.z1.c0 z1$c02) {
        z1.Z(c02);
    }

    static Executor y(io.grpc.j1.z1 z1) {
        return z1.c;
    }

    static io.grpc.j1.x0 z(io.grpc.j1.z1 z1) {
        return z1.n;
    }

    @Override // io.grpc.j1.q
    public final boolean a() {
        boolean z;
        Iterator iterator = a0Var.c.iterator();
        for (z1.c0 next2 : iterator) {
        }
        return 0;
    }

    @Override // io.grpc.j1.q
    public final void b(boolean z) {
        z1.l lVar = new z1.l(this, z);
        b0(lVar);
    }

    @Override // io.grpc.j1.q
    public final void c(d1 d1) {
        io.grpc.j1.z1.c0 i;
        z1.c0 c0Var = new z1.c0(0);
        o1 o1Var = new o1();
        c0Var.a = o1Var;
        Runnable runnable = Y(c0Var);
        if (runnable != null) {
            runnable.run();
            z1.r rVar = new z1.r(this, d1);
            this.c.execute(rVar);
        }
        i = 0;
        Object obj = this.i;
        synchronized (obj) {
            i = a0Var.f;
            this.o = this.o.b();
            if (i != null) {
            }
        }
        i.a.c(d1);
    }

    @Override // io.grpc.j1.q
    public final void d(o o) {
        z1.d dVar = new z1.d(this, o);
        b0(dVar);
    }

    @Override // io.grpc.j1.q
    public final void e(int i) {
        io.grpc.j1.z1.a0 a0Var = this.o;
        if (a0Var.a) {
            c0Var.a.e(i);
        }
        z1.n nVar = new z1.n(this, i);
        b0(nVar);
    }

    @Override // io.grpc.j1.q
    public final void f(int i) {
        z1.j jVar = new z1.j(this, i);
        b0(jVar);
    }

    @Override // io.grpc.j1.q
    abstract io.grpc.j1.q f0(t0 t0, l.a l$a2, int i3, boolean z4);

    @Override // io.grpc.j1.q
    public final void flush() {
        io.grpc.j1.z1.a0 a0Var = this.o;
        if (a0Var.a) {
            c0Var.a.flush();
        }
        z1.g gVar = new z1.g(this);
        b0(gVar);
    }

    @Override // io.grpc.j1.q
    public final void g(int i) {
        z1.k kVar = new z1.k(this, i);
        b0(kVar);
    }

    @Override // io.grpc.j1.q
    abstract void g0();

    @Override // io.grpc.j1.q
    public final a getAttributes() {
        if (a0Var.f != null) {
            return c0Var2.a.getAttributes();
        }
        return a.b;
    }

    @Override // io.grpc.j1.q
    public final void h(w w) {
        z1.f fVar = new z1.f(this, w);
        b0(fVar);
    }

    @Override // io.grpc.j1.q
    abstract d1 h0();

    @Override // io.grpc.j1.q
    public final void i(String string) {
        z1.b bVar = new z1.b(this, string);
        b0(bVar);
    }

    @Override // io.grpc.j1.q
    public void j(io.grpc.j1.x0 x0) {
        io.grpc.j1.x0 x0Var;
        String str;
        io.grpc.j1.x0 next;
        io.grpc.j1.x0 x0Var2;
        Object obj = this.i;
        x0.b("closed", this.n);
        io.grpc.j1.z1.a0 a0Var = this.o;
        synchronized (obj) {
            obj = this.i;
            x0.b("closed", this.n);
            a0Var = this.o;
        }
        x0Var = new x0();
        c0Var2.a.j(x0Var);
        x0.b("committed", x0Var);
    }

    final void j0(ReqT reqt) {
        io.grpc.j1.z1.a0 a0Var = this.o;
        if (a0Var.a) {
            c0Var.a.n(this.a.j(reqt));
        }
        z1.o oVar = new z1.o(this, reqt);
        b0(oVar);
    }

    @Override // io.grpc.j1.q
    public final void k() {
        z1.i iVar = new z1.i(this);
        b0(iVar);
    }

    @Override // io.grpc.j1.q
    final t0 k0(t0 t0, int i2) {
        Object obj2;
        int obj3;
        t0 t0Var = new t0();
        t0Var.l(t0);
        if (i2 > 0) {
            t0Var.o(z1.x, String.valueOf(i2));
        }
        return t0Var;
    }

    @Override // io.grpc.j1.q
    public final void l(u u) {
        z1.e eVar = new z1.e(this, u);
        b0(eVar);
    }

    @Override // io.grpc.j1.q
    public final void m(io.grpc.j1.r r) {
        int vVar;
        Object zVar;
        boolean xVar;
        long l;
        TimeUnit nANOSECONDS;
        this.r = r;
        d1 obj7 = h0();
        if (obj7 != null) {
            c(obj7);
        }
        obj7 = this.i;
        zVar = new z1.z(this);
        a0Var.b.add(zVar);
        obj7 = 0;
        obj7 = a0(obj7, obj7);
        synchronized (obj7) {
            obj7 = this.i;
            zVar = new z1.z(this);
            a0Var.b.add(zVar);
            obj7 = 0;
            obj7 = a0(obj7, obj7);
        }
        vVar = 0;
        zVar = this.i;
        this.o = this.o.a(obj7);
        synchronized (zVar) {
            xVar = this.m;
            if (xVar != null) {
                if (xVar.a()) {
                    vVar = new z1.v(this.i);
                    this.t = vVar;
                }
            } else {
            }
            if (vVar != 0) {
            }
            c0(obj7);
        }
        xVar = new z1.x(this, vVar);
        vVar.c(this.d.schedule(xVar, t0Var.b, obj4));
    }

    @Override // io.grpc.j1.q
    public final void n(InputStream inputStream) {
        IllegalStateException obj2 = new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
        throw obj2;
    }

    @Override // io.grpc.j1.q
    public void o() {
        z1.m mVar = new z1.m(this);
        b0(mVar);
    }

    @Override // io.grpc.j1.q
    public final void q(boolean z) {
        z1.h hVar = new z1.h(this, z);
        b0(hVar);
    }
}
