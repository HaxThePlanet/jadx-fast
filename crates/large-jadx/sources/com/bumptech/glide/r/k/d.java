package com.bumptech.glide.r.k;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class d extends com.bumptech.glide.r.k.e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.r.k.e
    protected void h(Object object) {
        j((Drawable)object);
    }

    @Override // com.bumptech.glide.r.k.e
    protected void j(Drawable drawable) {
        (ImageView)this.a.setImageDrawable(drawable);
    }
}
