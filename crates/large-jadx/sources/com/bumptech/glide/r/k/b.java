package com.bumptech.glide.r.k;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class b extends com.bumptech.glide.r.k.e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.r.k.e
    protected void h(Object object) {
        j((Bitmap)object);
    }

    @Override // com.bumptech.glide.r.k.e
    protected void j(Bitmap bitmap) {
        (ImageView)this.a.setImageBitmap(bitmap);
    }
}
