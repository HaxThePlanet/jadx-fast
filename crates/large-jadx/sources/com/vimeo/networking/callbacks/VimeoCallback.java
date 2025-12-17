package com.vimeo.networking.callbacks;

import com.vimeo.networking.VimeoClient;
import com.vimeo.networking.model.error.VimeoError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public abstract class VimeoCallback<T>  implements Callback<T> {
    @Override // retrofit2.Callback
    public abstract void failure(VimeoError vimeoError);

    public void onFailure(Call<T> call, Throwable throwable2) {
        boolean obj3;
        throwable2.printStackTrace();
        VimeoError vimeoError = new VimeoError();
        vimeoError.setDeveloperMessage(throwable2.getMessage());
        vimeoError.setErrorMessage(throwable2.getMessage());
        if (call && call.isCanceled()) {
            obj3 = call.isCanceled() ? 1 : 0;
        } else {
        }
        vimeoError.setIsCanceledError(obj3);
        failure(vimeoError);
    }

    public void onResponse(Call<T> call, Response<T> response2) {
        Object errorBody2;
        okhttp3.ResponseBody errorBody;
        java.lang.annotation.Annotation[] arr;
        int obj4;
        if (response2.isSuccessful()) {
            success(response2.body());
        } else {
            obj4 = 0;
            if (response2.errorBody() != null) {
                obj4 = errorBody2;
            }
            if (obj4 == null) {
                obj4 = new VimeoError();
            }
            obj4.setResponse(response2);
            failure(obj4);
        }
    }

    public abstract void success(T t);
}
