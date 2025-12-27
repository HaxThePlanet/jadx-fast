package com.bumptech.glide.r.k;

import android.widget.ImageView;

/* compiled from: ImageViewTargetFactory.java */
/* loaded from: classes.dex */
public class f {
    public <Z> i<ImageView, Z> a(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new b(imageView);
        }
        if (!Drawable.class.isAssignableFrom(cls)) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Unhandled class: ";
            String str2 = ", try .as*(Class).transcode(ResourceTranscoder)";
            cls = str + cls + str2;
            throw new IllegalArgumentException(cls);
        } else {
            return new d(imageView);
        }
    }
}
