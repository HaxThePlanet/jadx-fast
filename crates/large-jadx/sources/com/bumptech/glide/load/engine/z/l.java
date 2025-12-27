package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: LruPoolStrategy.java */
/* loaded from: classes.dex */
interface l {
    String a(int i, int i2, Bitmap.Config config);

    int b(Bitmap bitmap);

    void c(Bitmap bitmap);

    Bitmap d(int i, int i2, Bitmap.Config config);

    String e(Bitmap bitmap);

    Bitmap removeLast();
}
