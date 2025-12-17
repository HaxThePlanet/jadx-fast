package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class k extends com.bumptech.glide.load.resource.bitmap.f {

    private static final byte[] b;
    static {
        k.b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(f.a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(k.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(e e, Bitmap bitmap2, int i3, int i4) {
        return a0.d(e, bitmap2, i3, i4);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public boolean equals(Object object) {
        return object instanceof k;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public int hashCode() {
        return 1101716364;
    }
}
