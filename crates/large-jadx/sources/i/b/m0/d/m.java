package i.b.m0.d;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.y;

/* compiled from: DisposableLambdaObserver.java */
/* loaded from: classes3.dex */
public final class m<T> implements y<T>, b {

    final y<? super T> a;
    final f<? super b> b;
    final i.b.l0.a c;
    b v;
    public m(y<? super T> yVar, f<? super b> fVar, i.b.l0.a aVar) {
        super();
        this.a = yVar;
        this.b = fVar;
        this.c = aVar;
    }

    public void dispose() {
        i.b.l0.a aVar;
        dISPOSED2 = c.DISPOSED;
        if (this.v != c.DISPOSED) {
            this.v = c.DISPOSED;
            try {
                this.c.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            this.v.dispose();
        }
    }

    public boolean isDisposed() {
        return this.v.isDisposed();
    }

    public void onComplete() {
        final c dISPOSED2 = c.DISPOSED;
        if (this.v != c.DISPOSED) {
            this.v = c.DISPOSED;
            this.a.onComplete();
        }
    }

    public void onError(Throwable th) {
        final c dISPOSED2 = c.DISPOSED;
        if (this.v != c.DISPOSED) {
            this.v = c.DISPOSED;
            this.a.onError(th);
        } else {
            a.t(th);
        }
    }

    public void onNext(T t) {
        this.a.onNext(t);
    }

    public void onSubscribe(b bVar) {
        try {
            this.b.accept(bVar);
        } catch (Throwable th) {
            a.b(th);
            bVar.dispose();
            bVar = c.DISPOSED;
            this.v = bVar;
            d.error(th, this.a);
            return;
        }
        if (c.validate(this.v, this.a)) {
            this.v = this.a;
            this.a.onSubscribe(this);
        }
    }
}
