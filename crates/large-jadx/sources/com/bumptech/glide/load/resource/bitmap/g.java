package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class g implements j<ByteBuffer, Bitmap> {

    private final com.bumptech.glide.load.resource.bitmap.m a;
    public g(com.bumptech.glide.load.resource.bitmap.m m) {
        super();
        this.a = m;
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
        return this.a.g(byteBuffer, i2, i3, h4);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(ByteBuffer byteBuffer, h h2) {
        return this.a.q(byteBuffer);
    }
}
