package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class q extends com.bumptech.glide.load.resource.bitmap.f {

    private static final byte[] b;
    static {
        q.b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(f.a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(q.b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(e e, Bitmap bitmap2, int i3, int i4) {
        return a0.f(e, bitmap2, i3, i4);
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
