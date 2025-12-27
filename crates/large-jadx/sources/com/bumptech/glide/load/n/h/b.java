package com.bumptech.glide.load.n.h;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.k;

/* compiled from: BitmapDrawableTranscoder.java */
/* loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    private final Resources a;
    public b(Resources resources) {
        super();
        k.d(resources);
        this.a = resources;
    }

    public com.bumptech.glide.load.engine.u<BitmapDrawable> a(com.bumptech.glide.load.engine.u<Bitmap> uVar, h hVar) {
        return u.d(this.a, uVar);
    }
}
