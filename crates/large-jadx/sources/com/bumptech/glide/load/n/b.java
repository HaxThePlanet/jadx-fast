package com.bumptech.glide.load.n;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.t.k;

/* loaded from: classes.dex */
public class b<T>  implements u<T> {

    protected final T a;
    public b(T t) {
        super();
        k.d(t);
        this.a = t;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void a() {
    }

    public Class<T> b() {
        return this.a.getClass();
    }

    public final T get() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.u
    public final int getSize() {
        return 1;
    }
}
