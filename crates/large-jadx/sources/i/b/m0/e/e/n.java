package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.m0.c.j;
import i.b.m0.d.u;
import i.b.m0.j.r;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferBoundarySupplier.java */
/* loaded from: classes3.dex */
public final class n<T, U extends Collection<? super T>, B> extends a<T, U> {

    final Callable<? extends w<B>> b;
    final Callable<U> c;

    static final class a<T, U extends Collection<? super T>, B> extends i.b.o0.c<B> {

        final n.b<T, U, B> b;
        boolean c;
        a(n.b<T, U, B> bVar) {
            super();
            this.b = bVar;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.j();
        }

        @Override // i.b.o0.c
        public void onError(Throwable th) {
            if (this.c) {
                a.t(th);
                return;
            }
            this.c = true;
            this.b.onError(th);
        }

        @Override // i.b.o0.c
        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.c = true;
            dispose();
            this.b.j();
        }
    }

    static final class b<T, U extends Collection<? super T>, B> extends u<T, U, U> implements y<T>, i.b.j0.b {

        i.b.j0.b A;
        final AtomicReference<i.b.j0.b> B = new AtomicReference<>();
        U C;
        final Callable<U> y;
        final Callable<? extends w<B>> z;
        b(y<? super U> yVar, Callable<U> callable, Callable<? extends w<B>> callable2) {
            super(yVar, new a());
            final AtomicReference atomicReference = new AtomicReference();
            this.y = callable;
            this.z = callable2;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            if (!this.v) {
                this.v = true;
                this.A.dispose();
                i();
                if (d()) {
                    this.c.clear();
                }
            }
        }

        @Override // i.b.m0.d.u
        public void h(y<? super U> yVar, U u) {
            this.b.onNext(u);
        }

        @Override // i.b.m0.d.u
        void i() {
            c.dispose(this.B);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        void j() {
            try {
                Object call = this.y.call();
                b.e(call, "The buffer supplied is null");
            } catch (Throwable th) {
                a.b(th);
                boolean z2 = true;
                this.v = z2;
                this.A.dispose();
                this.A.onError(th);
                return;
            }
            try {
                Object call2 = this.z.call();
                b.e(call2, "The boundary ObservableSource supplied is null");
            } catch (Throwable th) {
                a.b(th);
                z2 = true;
                this.v = this.A;
                this.A.dispose();
                this.A.onError(th);
                return;
            }
            i.b.m0.e.e.n.a aVar = new n.a(this);
            if (c.replace(this.B, aVar)) {
                synchronized (this) {
                    try {
                        if (this.C == null) {
                            return;
                        }
                        this.C = call;
                    } catch (Throwable th) {
                    }
                }
                call2.subscribe(aVar);
                f(this.C, false, this);
            }
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            synchronized (this) {
                try {
                    if (this.C == null) {
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            this.c.offer(this.C);
            this.w = true;
            if (d()) {
                boolean z2 = false;
                r.c(this.c, this.b, z2, this, this);
            }
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable th) {
            dispose();
            this.b.onError(th);
        }

        @Override // i.b.m0.d.u
        public void onNext(T t) {
            synchronized (this) {
                try {
                    if (this.C == null) {
                        return;
                    }
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.A, bVar)) {
                this.A = bVar;
                try {
                    Object call2 = this.y.call();
                    b.e(call2, "The buffer supplied is null");
                } catch (Throwable th) {
                    a.b(th);
                    this.v = z;
                    bVar.dispose();
                    d.error(th, yVar);
                    return;
                }
                this.C = call2;
                try {
                    Object call = this.z.call();
                    str = "The boundary ObservableSource supplied is null";
                    b.e(call, str);
                } catch (Throwable th) {
                    a.b(th);
                    this.v = z;
                    bVar.dispose();
                    d.error(th, yVar);
                    return;
                }
                i.b.m0.e.e.n.a aVar = new n.a(this);
                this.B.set(aVar);
                this.b.onSubscribe(this);
                if (!this.v) {
                    call.subscribe(aVar);
                }
            }
        }
    }
    public n(w<T> wVar, Callable<? extends w<B>> callable, Callable<U> callable2) {
        super(wVar);
        this.b = callable;
        this.c = callable2;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super U> yVar) {
        this.a.subscribe(new n.b(new e(yVar), this.c, this.b));
    }
}
