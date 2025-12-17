package i.b;

import i.b.j0.b;

/* loaded from: classes3.dex */
public interface n<T>  {
    public abstract void onComplete();

    public abstract void onError(Throwable throwable);

    public abstract void onSubscribe(b b);

    public abstract void onSuccess(T t);
}
