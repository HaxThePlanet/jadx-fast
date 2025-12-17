package i.b;

import i.b.j0.b;

/* loaded from: classes3.dex */
public interface y<T>  {
    public abstract void onComplete();

    public abstract void onError(Throwable throwable);

    public abstract void onNext(T t);

    public abstract void onSubscribe(b b);
}
