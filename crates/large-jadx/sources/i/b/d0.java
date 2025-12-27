package i.b;

import i.b.j0.b;

/* compiled from: SingleObserver.java */
/* loaded from: classes3.dex */
public interface d0<T> {
    void onError(Throwable th);

    void onSubscribe(b bVar);

    void onSuccess(T t);
}
