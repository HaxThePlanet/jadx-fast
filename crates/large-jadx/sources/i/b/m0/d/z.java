package i.b.m0.d;

import i.b.d;

/* compiled from: SubscriberCompletableObserver.java */
/* loaded from: classes3.dex */
public final class z<T> implements d, m.c.c {

    final m.c.b<? super T> a;
    i.b.j0.b b;
    public z(m.c.b<? super T> bVar) {
        super();
        this.a = bVar;
    }

    public void cancel() {
        this.b.dispose();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable th) {
        this.a.onError(th);
    }

    public void onSubscribe(i.b.j0.b bVar) {
        if (c.validate(this.b, bVar)) {
            this.b = bVar;
            this.a.onSubscribe(this);
        }
    }

    public void request(long j) {
    }
}
