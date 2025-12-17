package com.bumptech.glide.r;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.r.k.h;

/* loaded from: classes.dex */
public interface f<R>  {
    public abstract boolean onLoadFailed(GlideException glideException, Object object2, h<R> h3, boolean z4);

    public abstract boolean onResourceReady(R r, Object object2, h<R> h3, a a4, boolean z5);
}
