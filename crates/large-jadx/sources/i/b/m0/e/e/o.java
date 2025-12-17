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
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class o<T, U extends Collection<? super T>, B>  extends i.b.m0.e.e.a<T, U> {

    final w<B> b;
    final Callable<U> c;

    static final class a extends c<B> {

        final i.b.m0.e.e.o.b<T, U, B> b;
        a(i.b.m0.e.e.o.b<T, U, B> o$b) {
            super();
            this.b = b;
        }

        @Override // i.b.o0.c
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // i.b.o0.c
        public void onError(Throwable throwable) {
            this.b.onError(throwable);
        }

        public void onNext(B b) {
            this.b.i();
        }
    }

    static final class b extends u<T, U, U> implements y<T>, b {

        b A;
        b B;
        U C;
        final Callable<U> y;
        final w<B> z;
        b(y<? super U> y, Callable<U> callable2, w<B> w3) {
            a aVar = new a();
            super(y, aVar);
            this.y = callable2;
            this.z = w3;
        }

        @Override // i.b.m0.d.u
        public void b(y y, Object object2) {
            h(y, (Collection)object2);
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            boolean z;
            this.v = true;
            this.B.dispose();
            this.A.dispose();
            if (!this.v && d()) {
                this.v = true;
                this.B.dispose();
                this.A.dispose();
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
            Object call = this.y.call();
            b.e(call, "The buffer supplied is null");
            Collection collection = this.C;
            synchronized (this) {
            }
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
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
            int str;
            b obj3;
            this.A = b;
            Object call = this.y.call();
            b.e(call, "The buffer supplied is null");
            this.C = (Collection)call;
            obj3 = new o.a(this);
            this.B = obj3;
            this.b.onSubscribe(this);
            if (c.validate(this.A, b) && !this.v) {
                this.A = b;
                call = this.y.call();
                b.e(call, "The buffer supplied is null");
                this.C = (Collection)call;
                obj3 = new o.a(this);
                this.B = obj3;
                this.b.onSubscribe(this);
                if (!this.v) {
                    this.z.subscribe(obj3);
                }
            }
        }
    }
    public o(w<T> w, w<B> w2, Callable<U> callable3) {
        super(w);
        this.b = w2;
        this.c = callable3;
    }

    protected void subscribeActual(y<? super U> y) {
        e eVar = new e(y);
        o.b bVar = new o.b(eVar, this.c, this.b);
        this.a.subscribe(bVar);
    }
}
