package com.bumptech.glide.load.n;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.t.k;

/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class b<T> implements u<T> {

    protected final T a;
    public b(T t) {
        super();
        k.d(t);
        this.a = t;
    }

    public Class<T> b() {
        return this.a.getClass();
    }

    public final T get() {
        return this.a;
    }

    public void a() {
    }

    public final int getSize() {
        return 1;
    }
}
