package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public interface c0 {
    public abstract void onBitmapFailed(Exception exception, Drawable drawable2);

    public abstract void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.t.e t$e2);

    public abstract void onPrepareLoad(Drawable drawable);
}
