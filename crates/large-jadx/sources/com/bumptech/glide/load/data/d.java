package com.bumptech.glide.load.data;

import com.bumptech.glide.h;
import com.bumptech.glide.load.a;

/* loaded from: classes.dex */
public interface d<T>  {

    public interface a {
        public abstract void c(Exception exception);

        public abstract void f(T t);
    }
    public abstract Class<T> a();

    public abstract void b();

    public abstract void cancel();

    public abstract a d();

    public abstract void e(h h, com.bumptech.glide.load.data.d.a<? super T> d$a2);
}
