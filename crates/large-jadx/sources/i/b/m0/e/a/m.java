package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.p0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class m extends b {

    final f a;
    final f<? super b> b;
    final f<? super Throwable> c;
    final a v;
    final a w;
    final a x;
    final a y;

    final class a implements d, b {

        final d a;
        b b;
        final i.b.m0.e.a.m c;
        a(i.b.m0.e.a.m m, d d2) {
            this.c = m;
            super();
            this.a = d2;
        }

        @Override // i.b.d
        void a() {
            a aVar;
            try {
                mVar.x.run();
                a.b(th);
                a.t(th);
            }
        }

        @Override // i.b.d
        public void dispose() {
            a aVar;
            try {
                mVar.y.run();
                a.b(th);
                a.t(th);
                this.b.dispose();
            }
        }

        @Override // i.b.d
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.d
        public void onComplete() {
            if (this.b == c.DISPOSED) {
            }
            mVar.v.run();
            mVar2.w.run();
            this.a.onComplete();
            a();
        }

        @Override // i.b.d
        public void onError(Throwable throwable) {
            a aVar;
            c dISPOSED;
            int arr;
            int i;
            Throwable obj5;
            if (this.b == c.DISPOSED) {
                a.t(throwable);
            }
            mVar.c.accept(throwable);
            mVar2.w.run();
            this.a.onError(obj5);
            a();
        }

        @Override // i.b.d
        public void onSubscribe(b b) {
            Object obj2;
            try {
                mVar.b.accept(b);
                if (c.validate(this.b, b)) {
                }
                this.b = b;
                this.a.onSubscribe(this);
                a.b(th);
                b.dispose();
                b = c.DISPOSED;
                this.b = b;
                b = this.a;
                d.error(th, b);
            }
        }
    }
    public m(f f, f<? super b> f2, f<? super Throwable> f3, a a4, a a5, a a6, a a7) {
        super();
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.v = a4;
        this.w = a5;
        this.x = a6;
        this.y = a7;
    }

    @Override // i.b.b
    protected void x(d d) {
        m.a aVar = new m.a(this, d);
        this.a.b(aVar);
    }
}
