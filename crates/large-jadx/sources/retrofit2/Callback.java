package retrofit2;

/* loaded from: classes3.dex */
public interface Callback<T>  {
    public abstract void onFailure(retrofit2.Call<T> call, Throwable throwable2);

    public abstract void onResponse(retrofit2.Call<T> call, retrofit2.Response<T> response2);
}
