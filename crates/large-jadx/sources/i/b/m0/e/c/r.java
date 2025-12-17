package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.n;
import i.b.p;
import i.b.p0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class r<T>  extends i.b.m0.e.c.a<T, T> {

    final f<? super b> b;
    final f<? super T> c;
    final f<? super Throwable> v;
    final a w;
    final a x;
    final a y;

    static final class a implements n<T>, b {

        final n<? super T> a;
        final i.b.m0.e.c.r<T> b;
        b c;
        a(n<? super T> n, i.b.m0.e.c.r<T> r2) {
            super();
            this.a = n;
            this.b = r2;
        }

        @Override // i.b.n
        void a() {
            a aVar;
            try {
                rVar.x.run();
                a.b(th);
                a.t(th);
            }
        }

        @Override // i.b.n
        void b(Throwable throwable) {
            f fVar;
            CompositeException compositeException;
            int arr;
            int i;
            Object obj5;
            try {
                rVar.v.accept(throwable);
                a.b(th);
                arr = 2;
                arr = new Throwable[arr];
                arr[0] = throwable;
                throwable = 1;
                arr[throwable] = th;
                compositeException = new CompositeException(arr);
                throwable = compositeException;
                this.c = c.DISPOSED;
                this.a.onError(obj5);
                a();
            }
        }

        @Override // i.b.n
        public void dispose() {
            a aVar;
            try {
                rVar.y.run();
                a.b(th);
                a.t(th);
                this.c.dispose();
                this.c = c.DISPOSED;
            }
        }

        @Override // i.b.n
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.n
        public void onComplete() {
            final c dISPOSED = c.DISPOSED;
            if (this.c == dISPOSED) {
            }
            rVar.w.run();
            this.c = dISPOSED;
            this.a.onComplete();
            a();
        }

        @Override // i.b.n
        public void onError(Throwable throwable) {
            if (this.c == c.DISPOSED) {
                a.t(throwable);
            }
            b(throwable);
        }

        @Override // i.b.n
        public void onSubscribe(b b) {
            boolean validate;
            Object obj2;
            if (c.validate(this.c, b)) {
                rVar.b.accept(b);
                this.c = b;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            final c dISPOSED = c.DISPOSED;
            if (this.c == dISPOSED) {
            }
            rVar.c.accept(t);
            this.c = dISPOSED;
            this.a.onSuccess(t);
            a();
        }
    }
    public r(p<T> p, f<? super b> f2, f<? super T> f3, f<? super Throwable> f4, a a5, a a6, a a7) {
        super(p);
        this.b = f2;
        this.c = f3;
        this.v = f4;
        this.w = a5;
        this.x = a6;
        this.y = a7;
    }

    protected void w(n<? super T> n) {
        r.a aVar = new r.a(n, this);
        this.a.b(aVar);
    }
}
