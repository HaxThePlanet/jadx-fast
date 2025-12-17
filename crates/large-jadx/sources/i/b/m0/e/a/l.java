package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.l0.o;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class l extends b {

    final f a;
    final o<? super Throwable> b;

    final class a implements d {

        private final d a;
        final i.b.m0.e.a.l b;
        a(i.b.m0.e.a.l l, d d2) {
            this.b = l;
            super();
            this.a = d2;
        }

        @Override // i.b.d
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // i.b.d
        public void onError(Throwable throwable) {
            boolean test;
            Object obj6;
            try {
                if (lVar.b.test(throwable)) {
                } else {
                }
                this.a.onComplete();
                this.a.onError(throwable);
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = throwable;
                throwable = 1;
                arr[throwable] = th;
                CompositeException compositeException = new CompositeException(arr);
                this.a.onError(compositeException);
            }
        }

        @Override // i.b.d
        public void onSubscribe(b b) {
            this.a.onSubscribe(b);
        }
    }
    public l(f f, o<? super Throwable> o2) {
        super();
        this.a = f;
        this.b = o2;
    }

    @Override // i.b.b
    protected void x(d d) {
        l.a aVar = new l.a(this, d);
        this.a.b(aVar);
    }
}
