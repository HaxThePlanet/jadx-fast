package i.b.m0.j;

import i.b.d;
import i.b.d0;
import i.b.k;
import i.b.n;
import i.b.p0.a;
import i.b.y;
import m.c.c;

/* compiled from: EmptyComponent.java */
/* loaded from: classes3.dex */
public enum h implements k<Object>, y<Object>, n<Object>, d0<Object>, d, c, i.b.j0.b {

    INSTANCE;
    public static <T> y<T> asObserver() {
        return h.INSTANCE;
    }

    public static <T> m.c.b<T> asSubscriber() {
        return h.INSTANCE;
    }

    @Override // java.lang.Enum
    public void onError(Throwable th) {
        a.t(th);
    }

    @Override // java.lang.Enum
    public void onSubscribe(i.b.j0.b bVar) {
        bVar.dispose();
    }

    @Override // java.lang.Enum
    public void onSubscribe(c cVar) {
        cVar.cancel();
    }

    @Override // java.lang.Enum
    public void cancel() {
    }

    @Override // java.lang.Enum
    public void dispose() {
    }

    @Override // java.lang.Enum
    public boolean isDisposed() {
        return true;
    }

    @Override // java.lang.Enum
    public void onComplete() {
    }

    @Override // java.lang.Enum
    public void onNext(Object object) {
    }

    @Override // java.lang.Enum
    public void onSuccess(Object object) {
    }

    @Override // java.lang.Enum
    public void request(long j) {
    }
}
