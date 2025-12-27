package i.b;

/* compiled from: MaybeEmitter.java */
/* loaded from: classes3.dex */
public interface m<T> {
    void onComplete();

    void onError(Throwable th);

    void onSuccess(T t);
}
