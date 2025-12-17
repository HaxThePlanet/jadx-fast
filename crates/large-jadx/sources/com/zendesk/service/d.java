package com.zendesk.service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes2.dex */
public class d<E, F>  implements Callback<E> {

    protected static final com.zendesk.service.d.b c;
    private final com.zendesk.service.f<F> a;
    private final com.zendesk.service.d.b<E, F> b;

    public interface b {
        public abstract F extract(E e);
    }

    static final class a implements com.zendesk.service.d.b<E, E> {
        public E extract(E e) {
            return e;
        }
    }
    static {
        d.a aVar = new d.a();
        d.c = aVar;
    }

    public d(com.zendesk.service.f<F> f) {
        super(f, d.c);
    }

    public d(com.zendesk.service.f<F> f, com.zendesk.service.d.b<E, F> d$b2) {
        super();
        this.a = f;
        this.b = b2;
    }

    public void onFailure(Call<E> call, Throwable throwable2) {
        Object obj2;
        final com.zendesk.service.f obj1 = this.a;
        if (obj1 != null) {
            obj1.onError(c.g(throwable2));
        }
    }

    public void onResponse(Call<E> call, Response<E> response2) {
        com.zendesk.service.d.b bVar;
        com.zendesk.service.f obj2;
        Object obj3;
        if (this.a != null) {
            if (response2.isSuccessful()) {
                this.a.onSuccess(this.b.extract(response2.body()));
            } else {
                this.a.onError(c.f(response2));
            }
        }
    }
}
