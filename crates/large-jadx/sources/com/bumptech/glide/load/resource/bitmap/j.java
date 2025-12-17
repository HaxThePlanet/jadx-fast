package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class j extends com.bumptech.glide.load.resource.bitmap.f {

    private static final byte[] b;
    static {
        j.b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(f.a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(j.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(e e, Bitmap bitmap2, int i3, int i4) {
        return a0.c(e, bitmap2, i3, i4);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public boolean equals(Object object) {
        return object instanceof j;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public int hashCode() {
        return -670243078;
    }
}
