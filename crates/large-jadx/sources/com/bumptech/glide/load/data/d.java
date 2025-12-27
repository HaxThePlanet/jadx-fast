package com.bumptech.glide.load.data;

import com.bumptech.glide.h;
import com.bumptech.glide.load.a;

/* compiled from: DataFetcher.java */
/* loaded from: classes.dex */
public interface d<T> {

    public interface a<T> {
        void c(Exception exc);

        void f(T t);
    }
    Class<T> a();

    void b();

    void cancel();

    a d();

    void e(h hVar, d.a<? super T> aVar);
}
