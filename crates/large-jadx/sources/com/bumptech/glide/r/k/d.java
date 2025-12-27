package com.bumptech.glide.r.k;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: DrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class d extends e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.r.k.e
    protected void j(Drawable drawable) {
        (ImageView)this.a.setImageDrawable(drawable);
    }
}
