package com.bumptech.glide.load.n.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.g.c;
import com.bumptech.glide.load.resource.bitmap.e;

/* loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.n.h.e<Drawable, byte[]> {

    private final e a;
    private final com.bumptech.glide.load.n.h.e<Bitmap, byte[]> b;
    private final com.bumptech.glide.load.n.h.e<c, byte[]> c;
    public c(e e, com.bumptech.glide.load.n.h.e<Bitmap, byte[]> e2, com.bumptech.glide.load.n.h.e<c, byte[]> e3) {
        super();
        this.a = e;
        this.b = e2;
        this.c = e3;
    }

    private static u<c> b(u<Drawable> u) {
        return u;
    }

    public u<byte[]> a(u<Drawable> u, h h2) {
        Object obj = u.get();
        if (obj instanceof BitmapDrawable) {
            return this.b.a(e.d((BitmapDrawable)(Drawable)obj.getBitmap(), this.a), h2);
        }
        if (obj instanceof c) {
            c.b(u);
            return this.c.a(u, h2);
        }
        return 0;
    }
}
