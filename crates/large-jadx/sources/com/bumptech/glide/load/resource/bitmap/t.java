package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.a;
import java.io.InputStream;

/* compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public final class t implements j<InputStream, Bitmap> {

    private final d a = new d();
    public t() {
        super();
        final com.bumptech.glide.load.resource.bitmap.d dVar = new d();
    }

    public u<Bitmap> c(InputStream inputStream, int i, int i2, h hVar) {
        return this.a.c(ImageDecoder.createSource(a.b(inputStream)), i, i2, hVar);
    }

    public boolean d(InputStream inputStream, h hVar) {
        return true;
    }
}
