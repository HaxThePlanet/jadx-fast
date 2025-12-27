package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: CircleCrop.java */
/* loaded from: classes.dex */
public class k extends f {

    private static final byte[] b;
    static {
        k.b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(f.a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(k.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(e eVar, Bitmap bitmap, int i, int i2) {
        return a0.d(eVar, bitmap, i, i2);
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
