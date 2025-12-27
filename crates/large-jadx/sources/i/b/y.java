package i.b;

import i.b.j0.b;

/* compiled from: Observer.java */
/* loaded from: classes3.dex */
public interface y<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(b bVar);
}
