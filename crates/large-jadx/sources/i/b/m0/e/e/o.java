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

/* compiled from: ObservableBufferExactBoundary.java */
/* loaded from: classes3.dex */
public final class o<T, U extends Collection<? super T>, B> extends a<T, U> {

    final w<B> b;
    final Callable<U> c;

    static final class a<T, U extends Collection<? super T>, B> extends i.b.o0.c<B> {

        final o.b<T, U, B> b;
        a(o.b<T, U, B> bVar) {
            super();
            this.b = bVar;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // i.b.o0.c
        public void onError(Throwable th) {
            this.b.onError(th);
        }

        @Override // i.b.o0.c
        public void onNext(B b) {
            this.b.i();
        }
    }

    static final class b<T, U extends Collection<? super T>, B> extends u<T, U, U> implements y<T>, i.b.j0.b {

        i.b.j0.b A;
        i.b.j0.b B;
        U C;
        final Callable<U> y;
        final w<B> z;
        b(y<? super U> yVar, Callable<U> callable, w<B> wVar) {
            super(yVar, new a());
            this.y = callable;
            this.z = wVar;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            if (!this.v) {
                this.v = true;
                this.B.dispose();
                this.A.dispose();
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
            try {
                Object call = this.y.call();
                b.e(call, "The buffer supplied is null");
            } catch (Throwable th) {
            }
            synchronized (this) {
                try {
                    if (this.C == null) {
                        return;
                    }
                    this.C = call;
                } catch (Throwable th) {
                }
            }
            f(this.C, false, this);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
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
                    Object call = this.y.call();
                    str = "The buffer supplied is null";
                    b.e(call, str);
                } catch (Throwable th) {
                    a.b(th);
                    this.v = true;
                    bVar.dispose();
                    d.error(th, this.b);
                }
                this.C = call;
                i.b.m0.e.e.o.a aVar = new o.a(this);
                this.B = aVar;
                this.b.onSubscribe(this);
                if (!this.v) {
                    this.z.subscribe(aVar);
                }
            }
        }
    }
    public o(w<T> wVar, w<B> wVar2, Callable<U> callable) {
        super(wVar);
        this.b = wVar2;
        this.c = callable;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super U> yVar) {
        this.a.subscribe(new o.b(new e(yVar), this.c, this.b));
    }
}
