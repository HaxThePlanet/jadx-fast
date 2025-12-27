package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.k;

/* compiled from: BitmapDrawableDecoder.java */
/* loaded from: classes.dex */
public class a<DataType> implements j<DataType, BitmapDrawable> {

    private final j<DataType, Bitmap> a;
    private final Resources b;
    public a(Resources resources, j<DataType, Bitmap> jVar) {
        super();
        k.d(resources);
        this.b = resources;
        k.d(jVar);
        this.a = jVar;
    }

    public boolean a(DataType datatype, h hVar) {
        return this.a.a(datatype, hVar);
    }

    public u<BitmapDrawable> b(DataType datatype, int i, int i2, h hVar) {
        return u.d(this.b, this.a.b(datatype, i, i2, hVar));
    }
}
