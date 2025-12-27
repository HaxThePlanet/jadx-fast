package com.zendesk.service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: RetrofitZendeskCallbackAdapter.java */
/* loaded from: classes2.dex */
public class d<E, F> implements Callback<E> {

    protected static final d.b c = new d$a();
    private final f<F> a;
    private final d.b<E, F> b;

    public interface b<E, F> {
        F extract(E e);
    }

    static final class a<E> implements d.b<E, E> {
        a() {
            super();
        }

        public E extract(E e) {
            return e;
        }
    }

    public d(f<F> fVar, d.b<E, F> bVar) {
        super();
        this.a = fVar;
        this.b = bVar;
    }

    public void onFailure(Call<E> call, Throwable th) {
        if (this.a != null) {
            this.a.onError(c.g(th));
        }
    }

    public void onResponse(Call<E> call, Response<E> response) {
        if (this.a != null && response.isSuccessful()) {
            this.a.onSuccess(this.b.extract(response.body()));
        }
    }

    public d(f<F> fVar) {
        this(fVar, d.c);
    }
}
