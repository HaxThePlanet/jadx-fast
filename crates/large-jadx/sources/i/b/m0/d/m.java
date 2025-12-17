package i.b.m0.d;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class m<T>  implements y<T>, b {

    final y<? super T> a;
    final f<? super b> b;
    final a c;
    b v;
    public m(y<? super T> y, f<? super b> f2, a a3) {
        super();
        this.a = y;
        this.b = f2;
        this.c = a3;
    }

    @Override // i.b.y
    public void dispose() {
        a dISPOSED;
        final b bVar = this.v;
        dISPOSED = c.DISPOSED;
        if (bVar != dISPOSED) {
            this.v = dISPOSED;
            this.c.run();
            bVar.dispose();
        }
    }

    @Override // i.b.y
    public boolean isDisposed() {
        return this.v.isDisposed();
    }

    @Override // i.b.y
    public void onComplete() {
        Object bVar;
        final c dISPOSED = c.DISPOSED;
        if (this.v != dISPOSED) {
            this.v = dISPOSED;
            this.a.onComplete();
        }
    }

    @Override // i.b.y
    public void onError(Throwable throwable) {
        Object bVar;
        final c dISPOSED = c.DISPOSED;
        if (this.v != dISPOSED) {
            this.v = dISPOSED;
            this.a.onError(throwable);
        } else {
            a.t(throwable);
        }
    }

    public void onNext(T t) {
        this.a.onNext(t);
    }

    @Override // i.b.y
    public void onSubscribe(b b) {
        Object obj2;
        try {
            this.b.accept(b);
            if (c.validate(this.v, b)) {
            }
            this.v = b;
            this.a.onSubscribe(this);
            a.b(th);
            b.dispose();
            b = c.DISPOSED;
            this.v = b;
            b = this.a;
            d.error(th, b);
        }
    }
}
