package retrofit2;

import l.e0;
import okhttp3.Request;

/* loaded from: classes3.dex */
public interface Call<T>  extends java.lang.Cloneable {
    @Override // java.lang.Cloneable
    public abstract void cancel();

    public abstract retrofit2.Call<T> clone();

    public abstract void enqueue(retrofit2.Callback<T> callback);

    public abstract retrofit2.Response<T> execute();

    @Override // java.lang.Cloneable
    public abstract boolean isCanceled();

    @Override // java.lang.Cloneable
    public abstract boolean isExecuted();

    @Override // java.lang.Cloneable
    public abstract Request request();

    @Override // java.lang.Cloneable
    public abstract e0 timeout();
}
