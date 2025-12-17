package m.c;

/* loaded from: classes3.dex */
public interface b<T>  {
    public abstract void onComplete();

    public abstract void onError(Throwable throwable);

    public abstract void onNext(T t);

    public abstract void onSubscribe(m.c.c c);
}
