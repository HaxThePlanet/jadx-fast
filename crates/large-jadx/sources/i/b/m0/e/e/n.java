package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.m0.d.u;
import i.b.m0.f.a;
import i.b.m0.j.r;
import i.b.o0.c;
import i.b.o0.e;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class n<T, U extends Collection<? super T>, B>  extends i.b.m0.e.e.a<T, U> {

    final Callable<? extends w<B>> b;
    final Callable<U> c;

    static final class a extends c<B> {

        final i.b.m0.e.e.n.b<T, U, B> b;
        boolean c;
        a(i.b.m0.e.e.n.b<T, U, B> n$b) {
            super();
            this.b = b;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            if (this.c) {
            }
            this.c = true;
            this.b.j();
        }

        @Override // i.b.o0.c
        public void onError(Throwable throwable) {
            if (this.c) {
                a.t(throwable);
            }
            this.c = true;
            this.b.onError(throwable);
        }

        public void onNext(B b) {
            if (this.c) {
            }
            this.c = true;
            dispose();
            this.b.j();
        }
    }

    static final class b extends u<T, U, U> implements y<T>, b {

        b A;
        final AtomicReference<b> B;
        U C;
        final Callable<U> y;
        final Callable<? extends w<B>> z;
        b(y<? super U> y, Callable<U> callable2, Callable<? extends w<B>> callable3) {
            a aVar = new a();
            super(y, aVar);
            AtomicReference obj2 = new AtomicReference();
            this.B = obj2;
            this.y = callable2;
            this.z = callable3;
        }

        @Override // i.b.m0.d.u
        public void b(y y, Object object2) {
            h(y, (Collection)object2);
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            boolean z;
            this.v = true;
            this.A.dispose();
            i();
            if (!this.v && d()) {
                this.v = true;
                this.A.dispose();
                i();
                if (d()) {
                    this.c.clear();
                }
            }
        }

        public void h(y<? super U> y, U u2) {
            this.b.onNext(u2);
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
            Object call;
            boolean replace;
            try {
                call = this.y.call();
                b.e(call, "The buffer supplied is null");
                Object call2 = this.z.call();
                b.e(call2, "The boundary ObservableSource supplied is null");
                n.a aVar = new n.a(this);
                replace = this.C;
                if (c.replace(this.B, aVar) && replace == null) {
                }
                replace = this.C;
                if (replace == null) {
                }
                this.C = (Collection)call;
                (w)call2.subscribe(aVar);
                f(replace, false, this);
                throw th;
                a.b(th);
                int i = 1;
                this.v = i;
                i = this.A;
                i.dispose();
                i = this.b;
                i.onError(th);
                a.b(th);
                dispose();
                i = this.b;
                i.onError(th);
            } catch (Throwable th) {
            }
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            boolean z;
            Object iVar;
            int i;
            Collection collection = this.C;
            synchronized (this) {
                try {
                    this.C = 0;
                    this.c.offer(collection);
                    this.w = true;
                    if (d()) {
                    }
                    r.c(this.c, this.b, false, this, this);
                    throw th;
                }
            }
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable throwable) {
            dispose();
            this.b.onError(throwable);
        }

        public void onNext(T t) {
            final Collection collection = this.C;
            synchronized (this) {
                try {
                    collection.add(t);
                    throw t;
                }
            }
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b b) {
            boolean validate;
            boolean z;
            Object call;
            String str;
            b obj5;
            this.A = b;
            int i = 1;
            Object call2 = this.y.call();
            b.e(call2, "The buffer supplied is null");
            this.C = (Collection)call2;
            call = this.z.call();
            b.e(call, "The boundary ObservableSource supplied is null");
            obj5 = new n.a(this);
            this.B.set(obj5);
            this.b.onSubscribe(this);
            if (c.validate(this.A, b) && !this.v) {
                this.A = b;
                i = 1;
                call2 = this.y.call();
                b.e(call2, "The buffer supplied is null");
                this.C = (Collection)call2;
                call = this.z.call();
                b.e((w)call, "The boundary ObservableSource supplied is null");
                obj5 = new n.a(this);
                this.B.set(obj5);
                this.b.onSubscribe(this);
                if (!this.v) {
                    (w)call.subscribe(obj5);
                }
            }
        }
    }
    public n(w<T> w, Callable<? extends w<B>> callable2, Callable<U> callable3) {
        super(w);
        this.b = callable2;
        this.c = callable3;
    }

    protected void subscribeActual(y<? super U> y) {
        e eVar = new e(y);
        n.b bVar = new n.b(eVar, this.c, this.b);
        this.a.subscribe(bVar);
    }
}
