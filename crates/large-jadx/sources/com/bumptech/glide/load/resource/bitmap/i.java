package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: CenterCrop.java */
/* loaded from: classes.dex */
public class i extends f {

    private static final byte[] b;
    static {
        i.b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(f.a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(i.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(e eVar, Bitmap bitmap, int i, int i2) {
        return a0.b(eVar, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public boolean equals(Object object) {
        return object instanceof i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public int hashCode() {
        return -599754482;
    }
}
