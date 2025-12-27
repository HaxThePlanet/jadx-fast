package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* compiled from: Target.java */
/* loaded from: classes2.dex */
public interface c0 {
    void onBitmapFailed(Exception exc, Drawable drawable);

    void onBitmapLoaded(Bitmap bitmap, t.e eVar);

    void onPrepareLoad(Drawable drawable);
}
