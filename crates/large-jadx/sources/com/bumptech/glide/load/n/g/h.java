package com.bumptech.glide.load.n.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.bitmap.e;
import com.bumptech.glide.n.a;

/* loaded from: classes.dex */
public final class h implements j<a, Bitmap> {

    private final e a;
    public h(e e) {
        super();
        this.a = e;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((a)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((a)object, i2, i3, h4);
    }

    public u<Bitmap> c(a a, int i2, int i3, h h4) {
        return e.d(a.a(), this.a);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(a a, h h2) {
        return 1;
    }
}
