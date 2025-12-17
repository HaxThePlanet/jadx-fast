package i.b.m0.d;

import i.b.d;
import i.b.j0.b;
import i.b.m0.a.c;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class z<T>  implements d, c {

    final b<? super T> a;
    b b;
    public z(b<? super T> b) {
        super();
        this.a = b;
    }

    @Override // i.b.d
    public void cancel() {
        this.b.dispose();
    }

    @Override // i.b.d
    public void onComplete() {
        this.a.onComplete();
    }

    @Override // i.b.d
    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    @Override // i.b.d
    public void onSubscribe(b b) {
        Object obj2;
        if (c.validate(this.b, b)) {
            this.b = b;
            this.a.onSubscribe(this);
        }
    }

    @Override // i.b.d
    public void request(long l) {
    }
}
