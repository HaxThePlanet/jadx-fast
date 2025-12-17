package com.bumptech.glide.r.k;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.o.m;
import com.bumptech.glide.r.d;
import com.bumptech.glide.r.l.d;

/* loaded from: classes.dex */
public interface h<R>  extends m {
    @Override // com.bumptech.glide.o.m
    public abstract d getRequest();

    @Override // com.bumptech.glide.o.m
    public abstract void getSize(com.bumptech.glide.r.k.g g);

    @Override // com.bumptech.glide.o.m
    public abstract void onLoadCleared(Drawable drawable);

    @Override // com.bumptech.glide.o.m
    public abstract void onLoadFailed(Drawable drawable);

    @Override // com.bumptech.glide.o.m
    public abstract void onLoadStarted(Drawable drawable);

    public abstract void onResourceReady(R r, d<? super R> d2);

    @Override // com.bumptech.glide.o.m
    public abstract void removeCallback(com.bumptech.glide.r.k.g g);

    @Override // com.bumptech.glide.o.m
    public abstract void setRequest(d d);
}
