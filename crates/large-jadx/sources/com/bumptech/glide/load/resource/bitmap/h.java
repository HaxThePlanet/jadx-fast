package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public final class h implements j<ByteBuffer, Bitmap> {

    private final d a = new d();
    public h() {
        super();
        final com.bumptech.glide.load.resource.bitmap.d dVar = new d();
    }

    public u<Bitmap> c(ByteBuffer byteBuffer, int i, int i2, h hVar) {
        return this.a.c(ImageDecoder.createSource(byteBuffer), i, i2, hVar);
    }

    public boolean d(ByteBuffer byteBuffer, h hVar) {
        return true;
    }
}
