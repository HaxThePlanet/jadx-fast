package i.b.m0.e.e;

import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.j.k;
import i.b.r;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableReplay.java */
/* loaded from: classes3.dex */
public final class s2<T> extends i.b.n0.a<T> implements i.b.m0.a.f {

    static final s2.b w = new s2$o();
    final w<T> a;
    final AtomicReference<s2.j<T>> b;
    final s2.b<T> c;
    final w<T> v;

    interface b<T> {
        s2.h<T> call();
    }

    static final class f extends AtomicReference<s2.f> {

        private static final long serialVersionUID = 245354315435971818L;
        final Object value;
        f(Object object) {
            super();
            this.value = object;
        }
    }

    interface h<T> {
        void b(s2.d<T> dVar);

        void d();

        void g(T t);

        void h(Throwable th);
    }

    static abstract class a<T> extends AtomicReference<s2.f> implements s2.h<T> {

        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        s2.f tail = new s2$f(0);
        a() {
            super();
            set(new s2.f(null));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        final void a(s2.f fVar) {
            this.tail.set(fVar);
            this.tail = fVar;
            this.size++;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final void b(s2.d<T> dVar) {
            int andGet = 1;
            Object obj;
            Object obj2 = null;
            y child2;
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while ((s2.f)dVar.a() == null) {
                dVar.index = e();
                obj2 = null;
                while (dVar.isDisposed()) {
                    obj = obj.get();
                    if (n.accept(f(obj.value), dVar.child)) {
                        dVar.index = obj2;
                        return;
                    }
                }
                obj = obj.get();
                dVar.index = obj;
                if (dVar.addAndGet(-andGet) == 0) {
                    return;
                }
                if (n.accept(f(obj.value), dVar.child)) {
                    dVar.index = obj2;
                    return;
                }
            }
            dVar.index = obj2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final void d() {
            a(new s2.f(c(n.complete())));
            m();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        s2.f e() {
            return (s2.f)get();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final void g(T t) {
            a(new s2.f(c(n.next(t))));
            l();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final void h(Throwable th) {
            a(new s2.f(c(n.error(th))));
            m();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        final void i() {
            this.size--;
            j((s2.f)(s2.f)get().get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        final void j(s2.f fVar) {
            set(fVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        final void k() {
            Object obj = get();
            if (obj.value != null) {
                Object obj2 = null;
                i.b.m0.e.e.s2.f fVar = new s2.f(obj2);
                fVar.lazySet(obj.get());
                set(fVar);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void m() {
            k();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        Object c(Object object) {
            return object;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        Object f(Object object) {
            return object;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        abstract void l();
    }

    static final class c<R> implements i.b.l0.f<i.b.j0.b> {

        private final o4<R> a;
        c(o4<R> o4Var) {
            super();
            this.a = o4Var;
        }

        public void a(i.b.j0.b bVar) {
            this.a.a(bVar);
        }
    }

    static final class d<T> extends AtomicInteger implements i.b.j0.b {

        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final y<? super T> child;
        Object index;
        final s2.j<T> parent;
        d(s2.j<T> jVar, y<? super T> yVar) {
            super();
            this.parent = jVar;
            this.child = yVar;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        <U> U a() {
            return this.index;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.b(this);
                this.index = null;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class i<T> implements s2.b<T> {

        private final int a;
        i(int i) {
            super();
            this.a = i;
        }

        public s2.h<T> call() {
            return new s2.n(this.a);
        }
    }

    static final class j<T> extends AtomicReference<i.b.j0.b> implements y<T>, i.b.j0.b {

        static final s2.d[] a;
        static final s2.d[] b;
        private static final long serialVersionUID = -533785617179540163L;
        final s2.h<T> buffer;
        boolean done;
        final AtomicReference<s2.d[]> observers = new AtomicReference<>();
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        static {
            int i = 0;
            s2.j.a = new s2.d[i];
            s2.j.b = new s2.d[i];
        }

        j(s2.h<T> hVar) {
            super();
            this.buffer = hVar;
            AtomicReference atomicReference = new AtomicReference(s2.j.a);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        boolean a(s2.d<T> dVar) {
            Object obj = this.observers.get();
            final int i = 0;
            while (obj == s2.j.b) {
                int length = obj.length;
                i.b.m0.e.e.s2.d[] arr = new s2.d[length + 1];
                System.arraycopy(obj, i, arr, i, length);
                arr[length] = dVar;
                if (this.observers.compareAndSet(obj, arr)) {
                    return true;
                }
                obj = this.observers.get();
                i = 0;
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void b(s2.d<T> dVar) {
            i.b.m0.e.e.s2.d[] arr;
            int i = -1;
            boolean equals;
            Object obj = this.observers.get();
            int length = obj.length;
            while (length == 0) {
                i = -1;
                i = 0;
                for (Object obj2 : obj) {
                    if (obj2.equals(dVar)) {
                        break loop_3;
                    }
                }
                int i4 = 1;
                if (this.observers.compareAndSet(obj, arr)) {
                    return;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void c() {
            int i = 0;
            Object obj = this.observers.get();
            i = 0;
            for (Object obj2 : obj) {
                this.buffer.b(obj2);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void d() {
            int i = 0;
            Object andSet = this.observers.getAndSet(s2.j.b);
            i = 0;
            for (Object obj : andSet) {
                this.buffer.b(obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            this.observers.set(s2.j.b);
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.observers.get() == s2.j.b ? 1 : 0;
            return (this.observers.get() == s2.j.b ? 1 : 0);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.d();
                d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.h(th);
                d();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            if (!this.done) {
                this.buffer.g(t);
                c();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this, bVar)) {
                c();
            }
        }
    }

    static final class k<T> implements w<T> {

        private final AtomicReference<s2.j<T>> a;
        private final s2.b<T> b;
        k(AtomicReference<s2.j<T>> atomicReference, s2.b<T> bVar) {
            super();
            this.a = atomicReference;
            this.b = bVar;
        }

        public void subscribe(y<? super T> yVar) {
            i.b.m0.e.e.s2.j jVar;
            while ((s2.j)this.a.get() == null) {
                jVar = new s2.j(this.b.call());
                Object obj = null;
                if (this.a.compareAndSet(obj, jVar)) {
                    break;
                }
            }
            i.b.m0.e.e.s2.d dVar = new s2.d(jVar, yVar);
            yVar.onSubscribe(dVar);
            jVar.a(dVar);
            if (dVar.isDisposed()) {
                jVar.b(dVar);
                return;
            }
            jVar.buffer.b(dVar);
        }
    }

    static final class l<T> implements s2.b<T> {

        private final int a;
        private final long b;
        private final TimeUnit c;
        private final z d;
        l(int i, long j, TimeUnit timeUnit, z zVar) {
            super();
            this.a = i;
            this.b = j;
            this.c = timeUnit;
            this.d = zVar;
        }

        public s2.h<T> call() {
            s2.m mVar = new s2.m(this.a, this.b, timeUnit, this.c, this.d);
            return mVar;
        }
    }

    static final class o implements s2.b<Object> {
        o() {
            super();
        }

        public s2.h<Object> call() {
            return new s2.p(16);
        }
    }

    static final class p<T> extends ArrayList<Object> implements s2.h<T> {

        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;
        p(int i) {
            super(i);
        }

        @Override // java.util.ArrayList
        public void b(s2.d<T> dVar) {
            int andGet = 1;
            int value = 0;
            boolean disposed;
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (dVar.isDisposed()) {
                Object obj = dVar.a();
                while (value < this.size) {
                    if (dVar.isDisposed()) {
                        return;
                    }
                }
                if (dVar.isDisposed()) {
                    return;
                }
                dVar.index = Integer.valueOf(value);
                if (dVar.addAndGet(-andGet) == 0) {
                    return;
                }
            }
        }

        @Override // java.util.ArrayList
        public void d() {
            add(n.complete());
            this.size++;
        }

        @Override // java.util.ArrayList
        public void g(T t) {
            add(n.next(t));
            this.size++;
        }

        @Override // java.util.ArrayList
        public void h(Throwable th) {
            add(n.error(th));
            this.size++;
        }
    }

    static final class e<R, U> extends r<R> {

        private final Callable<? extends i.b.n0.a<U>> a;
        private final i.b.l0.n<? super r<U>, ? extends w<R>> b;
        e(Callable<? extends i.b.n0.a<U>> callable, i.b.l0.n<? super r<U>, ? extends w<R>> nVar) {
            super();
            this.a = callable;
            this.b = nVar;
        }

        @Override // i.b.r
        protected void subscribeActual(y<? super R> yVar) {
            try {
                Object call = this.a.call();
                b.e(call, "The connectableFactory returned a null ConnectableObservable");
                Object apply = this.b.apply(call);
                b.e(apply, "The selector returned a null ObservableSource");
            } catch (Throwable th) {
                a.b(th);
                d.error(th, yVar);
                return;
            }
            i.b.m0.e.e.o4 o4Var = new o4(yVar);
            apply.subscribe(o4Var);
            call.c(new s2.c(o4Var));
        }
    }

    static final class m<T> extends s2.a<T> {

        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final z scheduler;
        final TimeUnit unit;
        m(int i, long j, TimeUnit timeUnit, z zVar) {
            super();
            this.scheduler = zVar;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // i.b.m0.e.e.s2$a
        Object c(Object object) {
            return new b(object, this.scheduler.b(this.unit), unit2, this.unit);
        }

        @Override // i.b.m0.e.e.s2$a
        s2.f e() {
            Object obj;
            Object value2;
            boolean complete;
            long l2 = this.scheduler.b(this.unit) - this.maxAge;
            obj = (s2.f)get().get();
            while (obj == null) {
                if (n.isError(value2.b())) {
                    break;
                }
            }
            return obj;
        }

        @Override // i.b.m0.e.e.s2$a
        Object f(Object object) {
            return object.b();
        }

        @Override // i.b.m0.e.e.s2$a
        void l() {
            Object obj;
            int i = 0;
            int cmp;
            int limit2;
            int i2 = 1;
            long l2 = this.scheduler.b(this.unit) - this.maxAge;
            obj = (s2.f)get().get();
            i = 0;
            while (obj != null) {
                i2 = 1;
            }
            if (i != 0) {
                j(obj);
            }
        }

        @Override // i.b.m0.e.e.s2$a
        void m() {
            Object obj;
            int i = 0;
            int cmp;
            int i2 = 1;
            long l;
            long l3 = this.scheduler.b(this.unit) - this.maxAge;
            obj = (s2.f)get().get();
            i = 0;
            while (obj != null) {
                i2 = 1;
            }
            if (i != 0) {
                j(obj);
            }
        }
    }

    static final class n<T> extends s2.a<T> {

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

    static final class g<T> extends i.b.n0.a<T> {

        private final i.b.n0.a<T> a;
        private final r<T> b;
        g(i.b.n0.a<T> aVar, r<T> rVar) {
            super();
            this.a = aVar;
            this.b = rVar;
        }

        @Override // i.b.n0.a
        public void c(i.b.l0.f<? super i.b.j0.b> fVar) {
            this.a.c(fVar);
        }

        @Override // i.b.n0.a
        protected void subscribeActual(y<? super T> yVar) {
            this.b.subscribe(yVar);
        }
    }

    private s2(w<T> wVar, w<T> wVar2, AtomicReference<s2.j<T>> atomicReference, s2.b<T> bVar) {
        super();
        this.v = wVar;
        this.a = wVar2;
        this.b = atomicReference;
        this.c = bVar;
    }

    public static <T> i.b.n0.a<T> f(w<T> wVar, int i) {
        if (i == 0x7fffffff /* Unknown resource */) {
            return s2.j(wVar);
        }
        return s2.i(wVar, new s2.i(i));
    }

    public static <T> i.b.n0.a<T> g(w<T> wVar, long j, TimeUnit timeUnit, z zVar) {
        return s2.h(wVar, j, timeUnit, zVar, Integer.MAX_VALUE);
    }

    public static <T> i.b.n0.a<T> h(w<T> wVar, long j, TimeUnit timeUnit, z zVar, int i) {
        s2.l lVar = new s2.l(i, j, timeUnit, timeUnit, zVar);
        return s2.i(wVar, lVar);
    }

    static <T> i.b.n0.a<T> i(w<T> wVar, s2.b<T> bVar) {
        final AtomicReference atomicReference = new AtomicReference();
        return a.q(new s2(new s2.k(atomicReference, bVar), wVar, atomicReference, bVar));
    }

    public static <T> i.b.n0.a<T> j(w<? extends T> wVar) {
        return s2.i(wVar, s2.w);
    }

    public static <U, R> r<R> k(Callable<? extends i.b.n0.a<U>> callable, i.b.l0.n<? super r<U>, ? extends w<R>> nVar) {
        return a.n(new s2.e(callable, nVar));
    }

    public static <T> i.b.n0.a<T> l(i.b.n0.a<T> aVar, z zVar) {
        return a.q(new s2.g(aVar, aVar.observeOn(zVar)));
    }

    @Override // i.b.n0.a
    public void a(i.b.j0.b bVar) {
        this.b.compareAndSet(bVar, null);
    }

    @Override // i.b.n0.a
    public void c(i.b.l0.f<? super i.b.j0.b> fVar) {
        i.b.m0.e.e.s2.j jVar;
        boolean z;
        Object obj = this.b.get();
        while (obj != null) {
            jVar = new s2.j(this.c.call());
            if (this.b.compareAndSet(obj, jVar)) {
                break;
            }
        }
        z = true;
        z = false;
        if (!jVar.shouldConnect.get()) {
            boolean obj2 = z;
        }
        try {
            fVar.accept(jVar);
        } catch (Throwable th) {
        }
        if (this.b) {
            this.a.subscribe(jVar);
        }
    }

    @Override // i.b.n0.a
    protected void subscribeActual(y<? super T> yVar) {
        this.v.subscribe(yVar);
    }
}
