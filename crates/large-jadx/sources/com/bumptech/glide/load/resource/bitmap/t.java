package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.a;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class t implements j<InputStream, Bitmap> {

    private final com.bumptech.glide.load.resource.bitmap.d a;
    public t() {
        super();
        d dVar = new d();
        this.a = dVar;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((InputStream)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((InputStream)object, i2, i3, h4);
    }

    public u<Bitmap> c(InputStream inputStream, int i2, int i3, h h4) {
        return this.a.c(ImageDecoder.createSource(a.b(inputStream)), i2, i3, h4);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(InputStream inputStream, h h2) {
        return 1;
    }
}
