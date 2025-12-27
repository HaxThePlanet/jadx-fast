package com.vimeo.networking.callbacks;

import com.vimeo.networking.VimeoClient;
import com.vimeo.networking.model.error.VimeoError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* compiled from: VimeoCallback.java */
/* loaded from: classes2.dex */
public abstract class VimeoCallback<T> implements Callback<T> {
    public void onFailure(Call<T> call, Throwable th) {
        boolean z = false;
        th.printStackTrace();
        final VimeoError vimeoError = new VimeoError();
        vimeoError.setDeveloperMessage(th.getMessage());
        vimeoError.setErrorMessage(th.getMessage());
        call = call != null && call.isCanceled() ? 1 : 0;
        vimeoError.setIsCanceledError((call != null && call.isCanceled() ? 1 : 0));
        failure(vimeoError);
    }

    public void onResponse(Call<T> call, Response<T> response) {
        okhttp3.ResponseBody errorBody;
        okhttp3.ResponseBody errorBody2;
        java.lang.annotation.Annotation[] arr;
        int i = 0;
        VimeoError vimeoError;
        if (response.isSuccessful()) {
            success(response.body());
        } else {
            i = 0;
            if (response.errorBody() != null) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i == 0) {
                vimeoError = new VimeoError();
            }
            vimeoError.setResponse(response);
            failure(vimeoError);
        }
    }

    public abstract void failure(VimeoError th);

    public abstract void success(T t);
}
