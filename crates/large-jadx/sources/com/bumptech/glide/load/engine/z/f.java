package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.engine.z.e {
    @Override // com.bumptech.glide.load.engine.z.e
    public void a(int i) {
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap d(int i, int i2, Bitmap.Config bitmap$Config3) {
        return Bitmap.createBitmap(i, i2, config3);
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap e(int i, int i2, Bitmap.Config bitmap$Config3) {
        return d(i, i2, config3);
    }
}
