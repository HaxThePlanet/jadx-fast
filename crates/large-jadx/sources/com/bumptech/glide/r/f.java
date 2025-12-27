package com.bumptech.glide.r;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.r.k.h;

/* compiled from: RequestListener.java */
/* loaded from: classes.dex */
public interface f<R> {
    boolean onLoadFailed(GlideException exc, Object object, h<R> hVar, boolean z);

    boolean onResourceReady(R r, Object object, h<R> hVar, a aVar, boolean z);
}
