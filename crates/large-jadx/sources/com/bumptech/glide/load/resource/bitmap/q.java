package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: FitCenter.java */
/* loaded from: classes.dex */
public class q extends f {

    private static final byte[] b;
    static {
        q.b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(f.a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(q.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(e eVar, Bitmap bitmap, int i, int i2) {
        return a0.f(eVar, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public boolean equals(Object object) {
        return object instanceof q;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public int hashCode() {
        return 1572326941;
    }
}
