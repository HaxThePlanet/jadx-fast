package com.bumptech.glide.r.k;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.r.k.e
    protected void j(Bitmap bitmap) {
        (ImageView)this.a.setImageBitmap(bitmap);
    }
}
