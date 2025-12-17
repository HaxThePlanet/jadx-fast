package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.k;

/* loaded from: classes.dex */
public class a<DataType>  implements j<DataType, BitmapDrawable> {

    private final j<DataType, Bitmap> a;
    private final Resources b;
    public a(Resources resources, j<DataType, Bitmap> j2) {
        super();
        k.d(resources);
        this.b = (Resources)resources;
        k.d(j2);
        this.a = (j)j2;
    }

    public boolean a(DataType datatype, h h2) {
        return this.a.a(datatype, h2);
    }

    public u<BitmapDrawable> b(DataType datatype, int i2, int i3, h h4) {
        return u.d(this.b, this.a.b(datatype, i2, i3, h4));
    }
}
