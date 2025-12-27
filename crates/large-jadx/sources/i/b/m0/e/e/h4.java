package i.b.m0.e.e;

import i.b.m0.c.j;
import i.b.m0.d.u;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundarySelector.java */
/* loaded from: classes3.dex */
public final class h4<T, B, V> extends a<T, r<T>> {

    final w<B> b;
    final i.b.l0.n<? super B, ? extends w<V>> c;
    final int v;

    static final class d<T, B> {

        final i.b.t0.e<T> a;
        final B b;
        d(i.b.t0.e<T> eVar, B b) {
            super();
            this.a = eVar;
            this.b = b;
        }
    }

    static final class a<T, V> extends i.b.o0.c<V> {

        final h4.c<T, ?, V> b;
        final i.b.t0.e<T> c;
        boolean v;
        a(h4.c<T, ?, V> cVar, i.b.t0.e<T> eVar) {
            super();
            this.b = cVar;
            this.c = eVar;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.b.h(this);
        }

        @Override // i.b.o0.c
        public void onError(Throwable th) {
            if (this.v) {
                a.t(th);
                return;
            }
            this.v = true;
            this.b.k(th);
        }

        @Override // i.b.o0.c
        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    static final class b<T, B> extends i.b.o0.c<B> {

        final h4.c<T, B, ?> b;
        b(h4.c<T, B, ?> cVar) {
            super();
            this.b = cVar;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // i.b.o0.c
        public void onError(Throwable th) {
            this.b.k(th);
        }

        @Override // i.b.o0.c
        public void onNext(B b) {
            this.b.m(b);
        }
    }

    static final class c<T, B, V> extends u<T, Object, r<T>> implements i.b.j0.b {

        final int A;
        final i.b.j0.a B = new a();
        i.b.j0.b C;
        final AtomicReference<i.b.j0.b> D = new AtomicReference<>();
        final List<i.b.t0.e<T>> E = new ArrayList<>();
        final AtomicLong F = new AtomicLong();
        final AtomicBoolean G = new AtomicBoolean();
        final w<B> y;
        final i.b.l0.n<? super B, ? extends w<V>> z;
        c(y<? super r<T>> yVar, w<B> wVar, i.b.l0.n<? super B, ? extends w<V>> nVar, int i) {
            super(yVar, new a());
            AtomicReference atomicReference = new AtomicReference();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.y = wVar;
            this.z = nVar;
            this.A = i;
            i.b.j0.a aVar2 = new a();
            ArrayList arrayList = new ArrayList();
            new AtomicLong().lazySet(1L);
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            boolean z = true;
            if (this.G.compareAndSet(false, z)) {
                c.dispose(this.D);
                long decrementAndGet = this.F.decrementAndGet();
                long l = 0L;
                if (decrementAndGet == l) {
                    this.C.dispose();
                }
            }
        }

        @Override // i.b.m0.d.u
        void h(h4.a<T, V> aVar) {
            this.B.c(aVar);
            this.c.offer(new h4.d(aVar.c, null));
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
            int i;
            i.b.m0.e.e.h4.a aVar = null;
            Object value;
            i = 1;
            Object apply = (a)this.c.poll();
            while (apply == null) {
                if (apply instanceof h4.d) {
                }
                if (c(-i) == 0) {
                    return;
                }
                apply = iVar.poll();
                int i4 = 0;
            }
            i();
            if (this.x != null) {
                Iterator it = this.E.iterator();
                while (it.hasNext()) {
                    (e)it.next().onError(this.x);
                }
            } else {
                Iterator it2 = this.E.iterator();
                while (it2.hasNext()) {
                    (e)it2.next().onComplete();
                }
            }
            this.E.clear();
        }

        @Override // i.b.m0.d.u
        void k(Throwable th) {
            this.C.dispose();
            this.B.dispose();
            onError(th);
        }

        @Override // i.b.m0.d.u
        void m(B b) {
            this.c.offer(new h4.d(null, b));
            if (d()) {
                j();
            }
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            if (d()) {
                j();
            }
            long decrementAndGet = this.F.decrementAndGet();
            if (decrementAndGet == 0) {
                this.B.dispose();
            }
            this.b.onComplete();
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable th) {
            if (this.w) {
                a.t(th);
                return;
            }
            this.x = th;
            this.w = true;
            if (d()) {
                j();
            }
            long decrementAndGet = this.F.decrementAndGet();
            if (decrementAndGet == 0) {
                this.B.dispose();
            }
            this.b.onError(th);
        }

        @Override // i.b.m0.d.u
        public void onNext(T t) {
            if (e()) {
                Iterator it = this.E.iterator();
                while (it.hasNext()) {
                    (e)it.next().onNext(t);
                }
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(n.next(t));
                if (!d()) {
                    return;
                }
            }
            j();
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.C, bVar)) {
                this.C = bVar;
                this.b.onSubscribe(this);
                if (this.G.get()) {
                    return;
                }
                i.b.m0.e.e.h4.b bVar2 = new h4.b(this);
                Object obj = null;
                if (this.D.compareAndSet(obj, bVar2)) {
                    this.y.subscribe(bVar2);
                }
            }
        }

        @Override // i.b.m0.d.u
        public void b(y<? super r<T>> yVar, Object object) {
        }
    }
    public h4(w<T> wVar, w<B> wVar2, i.b.l0.n<? super B, ? extends w<V>> nVar, int i) {
        super(wVar);
        this.b = wVar2;
        this.c = nVar;
        this.v = i;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super r<T>> yVar) {
        this.a.subscribe(new h4.c(new e(yVar), this.b, this.c, this.v));
    }
}
