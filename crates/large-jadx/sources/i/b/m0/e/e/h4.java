package i.b.m0.e.e;

import i.b.j0.a;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.m0.d.u;
import i.b.m0.f.a;
import i.b.m0.j.n;
import i.b.o0.c;
import i.b.o0.e;
import i.b.p0.a;
import i.b.r;
import i.b.t0.e;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class h4<T, B, V>  extends i.b.m0.e.e.a<T, r<T>> {

    final w<B> b;
    final n<? super B, ? extends w<V>> c;
    final int v;

    static final class d {

        final e<T> a;
        final B b;
        d(e<T> e, B b2) {
            super();
            this.a = e;
            this.b = b2;
        }
    }

    static final class a extends c<V> {

        final i.b.m0.e.e.h4.c<T, ?, V> b;
        final e<T> c;
        boolean v;
        a(i.b.m0.e.e.h4.c<T, ?, V> h4$c, e<T> e2) {
            super();
            this.b = c;
            this.c = e2;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            if (this.v) {
            }
            this.v = true;
            this.b.h(this);
        }

        @Override // i.b.o0.c
        public void onError(Throwable throwable) {
            if (this.v) {
                a.t(throwable);
            }
            this.v = true;
            this.b.k(throwable);
        }

        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    static final class b extends c<B> {

        final i.b.m0.e.e.h4.c<T, B, ?> b;
        b(i.b.m0.e.e.h4.c<T, B, ?> h4$c) {
            super();
            this.b = c;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // i.b.o0.c
        public void onError(Throwable throwable) {
            this.b.k(throwable);
        }

        public void onNext(B b) {
            this.b.m(b);
        }
    }

    static final class c extends u<T, Object, r<T>> implements b {

        final int A;
        final a B;
        b C;
        final AtomicReference<b> D;
        final List<e<T>> E;
        final AtomicLong F;
        final AtomicBoolean G;
        final w<B> y;
        final n<? super B, ? extends w<V>> z;
        c(y<? super r<T>> y, w<B> w2, n<? super B, ? extends w<V>> n3, int i4) {
            a aVar = new a();
            super(y, aVar);
            AtomicReference obj2 = new AtomicReference();
            this.D = obj2;
            obj2 = new AtomicLong();
            this.F = obj2;
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.G = atomicBoolean;
            this.y = w2;
            this.z = n3;
            this.A = i4;
            a obj3 = new a();
            this.B = obj3;
            obj3 = new ArrayList();
            this.E = obj3;
            obj2.lazySet(1);
        }

        public void b(y<? super r<T>> y, Object object2) {
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            boolean compareAndSet;
            int i;
            c.dispose(this.D);
            if (this.G.compareAndSet(false, true) && Long.compare(decrementAndGet, i) == 0) {
                c.dispose(this.D);
                if (Long.compare(decrementAndGet, i) == 0) {
                    this.C.dispose();
                }
            }
        }

        void h(i.b.m0.e.e.h4.a<T, V> h4$a) {
            this.B.c(a);
            h4.d dVar = new h4.d(a.c, 0);
            this.c.offer(dVar);
            if (d()) {
                j();
            }
        }

        @Override // i.b.m0.d.u
        void i() {
            this.B.dispose();
            c.dispose(this.D);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.G.get();
        }

        @Override // i.b.m0.d.u
        void j() {
            Object iterator;
            y next2;
            Iterator iterator3;
            int next;
            int i;
            Throwable iterator2;
            Object apply;
            int aVar;
            Object value;
            final List list = this.E;
            next = 1;
            i = next;
            apply = (a)this.c.poll();
            while (apply == null) {
                aVar = next;
                iterator2 = list.iterator();
                for (e aVar : iterator2) {
                    aVar.onNext(n.getValue(apply));
                }
                apply = iVar.poll();
                aVar = 0;
                (e)iterator2.next().onNext(n.getValue(apply));
                e eVar = apply.a;
                if (this.G.get()) {
                } else {
                }
                e eVar2 = e.e(this.A);
                list.add(eVar2);
                this.b.onNext(eVar2);
                apply = this.z.apply(apply.b);
                b.e(apply, "The ObservableSource supplied is null");
                aVar = new h4.a(this, eVar2);
                if (this.B.b(aVar)) {
                }
                this.F.getAndIncrement();
                (w)apply.subscribe(aVar);
                apply.a.onComplete();
            }
            i();
            iterator = this.x;
            if (iterator != null) {
                iterator3 = list.iterator();
                for (e next : iterator3) {
                    next.onError(iterator);
                }
            } else {
                iterator = list.iterator();
                for (e next2 : iterator) {
                    next2.onComplete();
                }
            }
            list.clear();
        }

        @Override // i.b.m0.d.u
        void k(Throwable throwable) {
            this.C.dispose();
            this.B.dispose();
            onError(throwable);
        }

        void m(B b) {
            h4.d dVar = new h4.d(0, b);
            this.c.offer(dVar);
            if (d()) {
                j();
            }
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            int cmp;
            if (this.w) {
            }
            this.w = true;
            if (d()) {
                j();
            }
            if (Long.compare(decrementAndGet, i2) == 0) {
                this.B.dispose();
            }
            this.b.onComplete();
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable throwable) {
            int cmp;
            if (this.w) {
                a.t(throwable);
            }
            this.x = throwable;
            this.w = true;
            if (d()) {
                j();
            }
            if (Long.compare(decrementAndGet, i2) == 0) {
                this.B.dispose();
            }
            this.b.onError(throwable);
        }

        public void onNext(T t) {
            Object iterator;
            Object next;
            boolean obj3;
            if (e()) {
                iterator = this.E.iterator();
                for (e next : iterator) {
                    next.onNext(t);
                }
                if (c(-1) == 0) {
                }
            } else {
                this.c.offer(n.next(t));
                if (!d()) {
                }
            }
            j();
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b b) {
            boolean compareAndSet;
            int i;
            b obj3;
            this.C = b;
            this.b.onSubscribe(this);
            if (c.validate(this.C, b) && this.G.get()) {
                this.C = b;
                this.b.onSubscribe(this);
                if (this.G.get()) {
                }
                obj3 = new h4.b(this);
                if (this.D.compareAndSet(0, obj3)) {
                    this.y.subscribe(obj3);
                }
            }
        }
    }
    public h4(w<T> w, w<B> w2, n<? super B, ? extends w<V>> n3, int i4) {
        super(w);
        this.b = w2;
        this.c = n3;
        this.v = i4;
    }

    public void subscribeActual(y<? super r<T>> y) {
        e eVar = new e(y);
        h4.c cVar = new h4.c(eVar, this.b, this.c, this.v);
        this.a.subscribe(cVar);
    }
}
