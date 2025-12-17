package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.f;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.a.f;
import i.b.m0.b.b;
import i.b.m0.j.k;
import i.b.m0.j.n;
import i.b.n0.a;
import i.b.p0.a;
import i.b.r;
import i.b.s0.b;
import i.b.w;
import i.b.y;
import i.b.z;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class s2<T>  extends a<T> implements f {

    static final i.b.m0.e.e.s2.b w;
    final w<T> a;
    final AtomicReference<i.b.m0.e.e.s2.j<T>> b;
    final i.b.m0.e.e.s2.b<T> c;
    final w<T> v;

    interface b {
        public abstract i.b.m0.e.e.s2.h<T> call();
    }

    static final class f extends AtomicReference<i.b.m0.e.e.s2.f> {

        private static final long serialVersionUID = 245354315435971818L;
        final Object value;
        f(Object object) {
            super();
            this.value = object;
        }
    }

    interface h {
        public abstract void b(i.b.m0.e.e.s2.d<T> s2$d);

        public abstract void d();

        public abstract void g(T t);

        public abstract void h(Throwable throwable);
    }

    static abstract class a extends AtomicReference<i.b.m0.e.e.s2.f> implements i.b.m0.e.e.s2.h<T> {

        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        i.b.m0.e.e.s2.f tail;
        a() {
            super();
            s2.f fVar = new s2.f(0);
            this.tail = fVar;
            set(fVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        final void a(i.b.m0.e.e.s2.f s2$f) {
            this.tail.set(f);
            this.tail = f;
            this.size = obj2++;
        }

        public final void b(i.b.m0.e.e.s2.d<T> s2$d) {
            int andGet;
            Object obj2;
            Object obj;
            int i;
            y child;
            if (d.getAndIncrement() != 0) {
            }
            andGet = 1;
            while ((s2.f)d.a() == null) {
                d.index = e();
                i = 0;
                while (d.isDisposed()) {
                    obj = obj2.get();
                    obj2 = obj;
                    i = 0;
                }
                obj = obj2.get();
                d.index = obj2;
                obj2 = obj;
            }
            d.index = i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        Object c(Object object) {
            return object;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final void d() {
            s2.f fVar = new s2.f(c(n.complete()));
            a(fVar);
            m();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        i.b.m0.e.e.s2.f e() {
            return (s2.f)get();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        Object f(Object object) {
            return object;
        }

        public final void g(T t) {
            s2.f fVar = new s2.f(c(n.next(t)));
            a(fVar);
            l();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final void h(Throwable throwable) {
            s2.f fVar = new s2.f(c(n.error(throwable)));
            a(fVar);
            m();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        final void i() {
            this.size = size--;
            j((s2.f)(s2.f)get().get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        final void j(i.b.m0.e.e.s2.f s2$f) {
            set(f);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        final void k() {
            Object obj;
            Object fVar;
            int i;
            obj = get();
            if (obj.value != null) {
                fVar = new s2.f(0);
                fVar.lazySet((s2.f)obj.get());
                set(fVar);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        abstract void l();

        @Override // java.util.concurrent.atomic.AtomicReference
        void m() {
            k();
        }
    }

    static final class c implements f<b> {

        private final i.b.m0.e.e.o4<R> a;
        c(i.b.m0.e.e.o4<R> o4) {
            super();
            this.a = o4;
        }

        @Override // i.b.l0.f
        public void a(b b) {
            this.a.a(b);
        }

        @Override // i.b.l0.f
        public void accept(Object object) {
            a((b)object);
        }
    }

    static final class d extends AtomicInteger implements b {

        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final y<? super T> child;
        Object index;
        final i.b.m0.e.e.s2.j<T> parent;
        d(i.b.m0.e.e.s2.j<T> s2$j, y<? super T> y2) {
            super();
            this.parent = j;
            this.child = y2;
        }

        <U> U a() {
            return this.index;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean cancelled;
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.b(this);
                this.index = 0;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class i implements i.b.m0.e.e.s2.b<T> {

        private final int a;
        i(int i) {
            super();
            this.a = i;
        }

        public i.b.m0.e.e.s2.h<T> call() {
            s2.n nVar = new s2.n(this.a);
            return nVar;
        }
    }

    static final class j extends AtomicReference<b> implements y<T>, b {

        static final i.b.m0.e.e.s2.d[] a = null;
        static final i.b.m0.e.e.s2.d[] b = null;
        private static final long serialVersionUID = -533785617179540163L;
        final i.b.m0.e.e.s2.h<T> buffer;
        boolean done;
        final AtomicReference<i.b.m0.e.e.s2.d[]> observers;
        final AtomicBoolean shouldConnect;
        static {
            int i = 0;
            s2.j.a = new s2.d[i];
            s2.j.b = new s2.d[i];
        }

        j(i.b.m0.e.e.s2.h<T> s2$h) {
            super();
            this.buffer = h;
            AtomicReference obj2 = new AtomicReference(s2.j.a);
            this.observers = obj2;
            obj2 = new AtomicBoolean();
            this.shouldConnect = obj2;
        }

        boolean a(i.b.m0.e.e.s2.d<T> s2$d) {
            Object obj = this.observers.get();
            final int i = 0;
            while ((s2.d[])obj == s2.j.b) {
                int length = obj.length;
                i.b.m0.e.e.s2.d[] arr = new s2.d[length + 1];
                System.arraycopy((s2.d[])obj, i, arr, i, length);
                arr[length] = d;
                obj = this.observers.get();
                i = 0;
            }
            return i;
        }

        void b(i.b.m0.e.e.s2.d<T> s2$d) {
            i.b.m0.e.e.s2.d[] objArr;
            int i2;
            int i;
            int i3;
            boolean equals;
            Object obj = this.observers.get();
            int length = obj.length;
            while (length == 0) {
                i2 = -1;
                i = 0;
                i3 = i;
                while (i3 < length) {
                    if ((s2.d[])obj[i3].equals(d)) {
                        break loop_3;
                    } else {
                    }
                    i3++;
                }
                int i6 = 1;
                if (length == i6) {
                } else {
                }
                equals = new s2.d[length + -1];
                System.arraycopy(obj, i, equals, i, i2);
                System.arraycopy(obj, i2 + 1, equals, i2, i4 -= i6);
                objArr = equals;
                obj = this.observers.get();
                length = obj.length;
                objArr = s2.j.a;
                if ((s2.d[])obj[i3].equals(d)) {
                } else {
                }
                i3++;
                i2 = i3;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void c() {
            int i;
            Object obj;
            i.b.m0.e.e.s2.h buffer;
            Object obj2 = this.observers.get();
            i = 0;
            while (i < obj2.length) {
                this.buffer.b((s2.d[])obj2[i]);
                i++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void d() {
            int i;
            Object obj;
            i.b.m0.e.e.s2.h buffer;
            Object andSet = this.observers.getAndSet(s2.j.b);
            i = 0;
            while (i < andSet.length) {
                this.buffer.b((s2.d[])andSet[i]);
                i++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            this.observers.set(s2.j.b);
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            int i;
            i = this.observers.get() == s2.j.b ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            boolean buffer;
            if (!this.done) {
                this.done = true;
                this.buffer.d();
                d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            i.b.m0.e.e.s2.h buffer;
            if (!this.done) {
                this.done = true;
                this.buffer.h(throwable);
                d();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            boolean buffer;
            if (!this.done) {
                this.buffer.g(t);
                c();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            if (c.setOnce(this, b)) {
                c();
            }
        }
    }

    static final class k implements w<T> {

        private final AtomicReference<i.b.m0.e.e.s2.j<T>> a;
        private final i.b.m0.e.e.s2.b<T> b;
        k(AtomicReference<i.b.m0.e.e.s2.j<T>> atomicReference, i.b.m0.e.e.s2.b<T> s2$b2) {
            super();
            this.a = atomicReference;
            this.b = b2;
        }

        public void subscribe(y<? super T> y) {
            Object obj;
            i.b.m0.e.e.s2.j jVar;
            int i;
            while ((s2.j)this.a.get() == null) {
                jVar = new s2.j(this.b.call());
                if (this.a.compareAndSet(0, jVar)) {
                    break;
                } else {
                }
            }
            s2.d dVar = new s2.d(obj, y);
            y.onSubscribe(dVar);
            obj.a(dVar);
            if (dVar.isDisposed()) {
                obj.b(dVar);
            }
            obj.buffer.b(dVar);
        }
    }

    static final class l implements i.b.m0.e.e.s2.b<T> {

        private final int a;
        private final long b;
        private final TimeUnit c;
        private final z d;
        l(int i, long l2, TimeUnit timeUnit3, z z4) {
            super();
            this.a = i;
            this.b = l2;
            this.c = z4;
            this.d = obj5;
        }

        public i.b.m0.e.e.s2.h<T> call() {
            super(this.a, this.b, obj3, this.c, this.d);
            return mVar2;
        }
    }

    static final class o implements i.b.m0.e.e.s2.b<Object> {
        public i.b.m0.e.e.s2.h<Object> call() {
            s2.p pVar = new s2.p(16);
            return pVar;
        }
    }

    static final class p extends ArrayList<Object> implements i.b.m0.e.e.s2.h<T> {

        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;
        p(int i) {
            super(i);
        }

        public void b(i.b.m0.e.e.s2.d<T> s2$d) {
            int andGet;
            Integer valueOf;
            int intValue;
            boolean disposed;
            if (d.getAndIncrement() != 0) {
            }
            andGet = 1;
            while (d.isDisposed()) {
                Object obj = d.a();
                if ((Integer)obj != null) {
                } else {
                }
                intValue = 0;
                while (intValue < this.size) {
                    intValue++;
                }
                d.index = Integer.valueOf(intValue);
                intValue++;
                intValue = (Integer)obj.intValue();
            }
        }

        @Override // java.util.ArrayList
        public void d() {
            add(n.complete());
            this.size = size++;
        }

        public void g(T t) {
            add(n.next(t));
            this.size = obj1++;
        }

        @Override // java.util.ArrayList
        public void h(Throwable throwable) {
            add(n.error(throwable));
            this.size = obj1++;
        }
    }

    static final class e extends r<R> {

        private final Callable<? extends a<U>> a;
        private final n<? super r<U>, ? extends w<R>> b;
        e(Callable<? extends a<U>> callable, n<? super r<U>, ? extends w<R>> n2) {
            super();
            this.a = callable;
            this.b = n2;
        }

        protected void subscribeActual(y<? super R> y) {
            try {
                Object call = this.a.call();
                b.e(call, "The connectableFactory returned a null ConnectableObservable");
                Object apply = this.b.apply((a)call);
                b.e(apply, "The selector returned a null ObservableSource");
                o4 o4Var = new o4(y);
                (w)apply.subscribe(o4Var);
                s2.c obj4 = new s2.c(o4Var);
                call.c(obj4);
                a.b(th);
                d.error(th, y);
            }
        }
    }

    static final class m extends i.b.m0.e.e.s2.a<T> {

        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final z scheduler;
        final TimeUnit unit;
        m(int i, long l2, TimeUnit timeUnit3, z z4) {
            super();
            this.scheduler = obj5;
            this.limit = i;
            this.maxAge = l2;
            this.unit = z4;
        }

        @Override // i.b.m0.e.e.s2$a
        Object c(Object object) {
            final TimeUnit unit = this.unit;
            b bVar = new b(object, this.scheduler.b(unit), unit, this.unit);
            return bVar;
        }

        @Override // i.b.m0.e.e.s2$a
        i.b.m0.e.e.s2.f e() {
            Object obj2;
            Object obj3;
            Object value;
            boolean complete;
            Object obj;
            obj3 = (s2.f)get().get();
            obj2 = obj;
            while (obj2 == null) {
                value = obj2.value;
                if (!n.isComplete((b)value.b())) {
                    break;
                }
                if (Long.compare(l2, i) <= 0) {
                    break;
                }
                obj3 = obj2.get();
                obj2 = obj;
            }
            return obj2;
        }

        @Override // i.b.m0.e.e.s2$a
        Object f(Object object) {
            return (b)object.b();
        }

        @Override // i.b.m0.e.e.s2$a
        void l() {
            Object obj3;
            Object obj;
            int i;
            int cmp;
            int limit;
            int i2;
            Object obj2;
            obj = (s2.f)get().get();
            i = 0;
            obj3 = obj2;
            while (obj3 != null) {
                int size2 = this.size;
                i2 = 1;
                if (size2 > this.limit) {
                } else {
                }
                if (Long.compare(l2, i3) <= 0) {
                }
                i++;
                this.size = size -= i2;
                obj = obj3.get();
                obj3 = obj2;
                if (size2 > i2) {
                } else {
                }
                i++;
                this.size = size2--;
                obj = obj3.get();
            }
            if (i != 0) {
                j(obj3);
            }
        }

        @Override // i.b.m0.e.e.s2$a
        void m() {
            Object obj2;
            Object obj3;
            int i2;
            int size;
            int i;
            long l;
            Object obj;
            obj3 = (s2.f)get().get();
            i2 = 0;
            obj2 = obj;
            while (obj2 != null) {
                i = 1;
                if (this.size > i) {
                }
                if (Long.compare(l, i3) <= 0) {
                }
                i2++;
                this.size = size2 -= i;
                obj3 = obj2.get();
                obj2 = obj;
            }
            if (i2 != 0) {
                j(obj2);
            }
        }
    }

    static final class n extends i.b.m0.e.e.s2.a<T> {

        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;
        n(int i) {
            super();
            this.limit = i;
        }

        @Override // i.b.m0.e.e.s2$a
        void l() {
            if (this.size > this.limit) {
                i();
            }
        }
    }

    static final class g extends a<T> {

        private final a<T> a;
        private final r<T> b;
        g(a<T> a, r<T> r2) {
            super();
            this.a = a;
            this.b = r2;
        }

        public void c(f<? super b> f) {
            this.a.c(f);
        }

        protected void subscribeActual(y<? super T> y) {
            this.b.subscribe(y);
        }
    }
    static {
        s2.o oVar = new s2.o();
        s2.w = oVar;
    }

    private s2(w<T> w, w<T> w2, AtomicReference<i.b.m0.e.e.s2.j<T>> atomicReference3, i.b.m0.e.e.s2.b<T> s2$b4) {
        super();
        this.v = w;
        this.a = w2;
        this.b = atomicReference3;
        this.c = b4;
    }

    public static <T> a<T> f(w<T> w, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return s2.j(w);
        }
        s2.i iVar = new s2.i(i2);
        return s2.i(w, iVar);
    }

    public static <T> a<T> g(w<T> w, long l2, TimeUnit timeUnit3, z z4) {
        return s2.h(w, l2, obj2, z4, obj10);
    }

    public static <T> a<T> h(w<T> w, long l2, TimeUnit timeUnit3, z z4, int i5) {
        super(obj12, l2, obj3, z4, i5);
        return s2.i(w, lVar2);
    }

    static <T> a<T> i(w<T> w, i.b.m0.e.e.s2.b<T> s2$b2) {
        AtomicReference atomicReference = new AtomicReference();
        s2.k kVar = new s2.k(atomicReference, b2);
        s2 s2Var = new s2(kVar, w, atomicReference, b2);
        return a.q(s2Var);
    }

    public static <T> a<T> j(w<? extends T> w) {
        return s2.i(w, s2.w);
    }

    public static <U, R> r<R> k(Callable<? extends a<U>> callable, n<? super r<U>, ? extends w<R>> n2) {
        s2.e eVar = new s2.e(callable, n2);
        return a.n(eVar);
    }

    public static <T> a<T> l(a<T> a, z z2) {
        s2.g gVar = new s2.g(a, a.observeOn(z2));
        return a.q(gVar);
    }

    @Override // i.b.n0.a
    public void a(b b) {
        this.b.compareAndSet((s2.j)b, 0);
    }

    public void c(f<? super b> f) {
        Object obj;
        boolean disposed;
        int i;
        boolean compareAndSet;
        i.b.m0.e.e.s2.j jVar;
        Object obj5;
        obj = this.b.get();
        while ((s2.j)obj != null) {
            if ((s2.j)obj.isDisposed()) {
                break;
            }
            jVar = new s2.j(this.c.call());
            if (this.b.compareAndSet(obj, jVar)) {
                break;
            } else {
            }
            obj = this.b.get();
        }
        int i2 = 1;
        final int i3 = 0;
        if (!obj.shouldConnect.get() && obj.shouldConnect.compareAndSet(i3, i2)) {
            i = obj.shouldConnect.compareAndSet(i3, i2) ? i2 : i3;
        } else {
        }
        f.accept(obj);
        if (i != 0) {
            this.a.subscribe(obj);
        }
    }

    protected void subscribeActual(y<? super T> y) {
        this.v.subscribe(y);
    }
}
