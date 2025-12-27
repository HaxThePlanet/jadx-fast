package i.b;

import i.b.j0.b;

/* compiled from: MaybeObserver.java */
/* loaded from: classes3.dex */
public interface n<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(b bVar);

    void onSuccess(T t);
}
