package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: RoundedCorners.java */
/* loaded from: classes.dex */
public final class y extends f {

    private static final byte[] c;
    private final int b;
    static {
        y.c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(f.a);
    }

    public y(int i) {
        boolean z = true;
        super();
        int r0 = i > 0 ? 1 : 0;
        k.a((i > 0 ? 1 : 0), "roundingRadius must be greater than 0.");
        this.b = i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(y.c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(e eVar, Bitmap bitmap, int i, int i2) {
        return a0.o(eVar, bitmap, this.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public boolean equals(Object object) {
        boolean z2 = false;
        z = object instanceof y;
        int i3 = 0;
        if (object instanceof y) {
            if (this.b == object.b) {
                int i4 = 1;
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public int hashCode() {
        return l.n(-569625254, l.m(this.b));
    }
}
