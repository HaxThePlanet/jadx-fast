package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class y extends com.bumptech.glide.load.resource.bitmap.f {

    private static final byte[] c;
    private final int b;
    static {
        y.c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(f.a);
    }

    public y(int i) {
        int i2;
        super();
        i2 = i > 0 ? 1 : 0;
        k.a(i2, "roundingRadius must be greater than 0.");
        this.b = i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(y.c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(e e, Bitmap bitmap2, int i3, int i4) {
        return a0.o(e, bitmap2, this.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public boolean equals(Object object) {
        boolean z;
        int i;
        Object obj3;
        i = 0;
        if (object instanceof y && this.b == object.b) {
            if (this.b == object.b) {
                i = 1;
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public int hashCode() {
        return l.n(-569625254, l.m(this.b));
    }
}
