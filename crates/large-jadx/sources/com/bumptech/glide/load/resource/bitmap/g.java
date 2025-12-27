package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder.java */
/* loaded from: classes.dex */
public class g implements j<ByteBuffer, Bitmap> {

    private final m a;
    public g(m mVar) {
        super();
        this.a = mVar;
    }

    public u<Bitmap> c(ByteBuffer byteBuffer, int i, int i2, h hVar) {
        return this.a.g(byteBuffer, i, i2, hVar);
    }

    public boolean d(ByteBuffer byteBuffer, h hVar) {
        return this.a.q(byteBuffer);
    }
}
