package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: BitmapPoolAdapter.java */
/* loaded from: classes.dex */
public class f implements e {
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public Bitmap e(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }

    public void a(int i) {
    }

    public void b() {
    }
}
