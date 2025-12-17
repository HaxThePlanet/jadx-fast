package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class h implements j<ByteBuffer, Bitmap> {

    private final com.bumptech.glide.load.resource.bitmap.d a;
    public h() {
        super();
        d dVar = new d();
        this.a = dVar;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((ByteBuffer)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((ByteBuffer)object, i2, i3, h4);
    }

    public u<Bitmap> c(ByteBuffer byteBuffer, int i2, int i3, h h4) {
        return this.a.c(ImageDecoder.createSource(byteBuffer), i2, i3, h4);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(ByteBuffer byteBuffer, h h2) {
        return 1;
    }
}
