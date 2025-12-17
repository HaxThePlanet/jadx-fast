package com.bumptech.glide.load.n.e;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;

/* loaded from: classes.dex */
public class g implements j<Drawable, Drawable> {
    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((Drawable)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((Drawable)object, i2, i3, h4);
    }

    public u<Drawable> c(Drawable drawable, int i2, int i3, h h4) {
        return e.d(drawable);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(Drawable drawable, h h2) {
        return 1;
    }
}
