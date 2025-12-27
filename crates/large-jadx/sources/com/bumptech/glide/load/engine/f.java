package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;

/* compiled from: DataFetcherGenerator.java */
/* loaded from: classes.dex */
interface f {

    public interface a {
        void a(f fVar, Exception exc, d<?> dVar, a aVar);

        void c();

        void e(f fVar, Object object, d<?> dVar, a aVar, f fVar2);
    }
    boolean b();

    void cancel();
}
