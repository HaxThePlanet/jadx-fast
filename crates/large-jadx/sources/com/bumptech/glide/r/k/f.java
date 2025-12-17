package com.bumptech.glide.r.k;

import android.widget.ImageView;

/* loaded from: classes.dex */
public class f {
    public <Z> com.bumptech.glide.r.k.i<ImageView, Z> a(ImageView imageView, Class<Z> class2) {
        if (Bitmap.class.equals(class2)) {
            b obj4 = new b(imageView);
            return obj4;
        }
        if (!Drawable.class.isAssignableFrom(class2)) {
        } else {
            obj4 = new d(imageView);
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unhandled class: ");
        stringBuilder.append(class2);
        stringBuilder.append(", try .as*(Class).transcode(ResourceTranscoder)");
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }
}
