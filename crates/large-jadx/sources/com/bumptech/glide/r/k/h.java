package com.bumptech.glide.r.k;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.o.m;

/* compiled from: Target.java */
/* loaded from: classes.dex */
public interface h<R> extends m {
    com.bumptech.glide.r.d getRequest();

    void getSize(g gVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, com.bumptech.glide.r.l.d<? super R> dVar);

    void removeCallback(g gVar);

    void setRequest(com.bumptech.glide.r.d dVar);
}
