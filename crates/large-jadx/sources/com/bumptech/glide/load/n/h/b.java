package com.bumptech.glide.load.n.h;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.t.k;

/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.n.h.e<Bitmap, BitmapDrawable> {

    private final Resources a;
    public b(Resources resources) {
        super();
        k.d(resources);
        this.a = (Resources)resources;
    }

    public u<BitmapDrawable> a(u<Bitmap> u, h h2) {
        return u.d(this.a, u);
    }
}
