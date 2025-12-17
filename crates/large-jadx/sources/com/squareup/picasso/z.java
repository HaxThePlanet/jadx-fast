package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

/* loaded from: classes2.dex */
class z extends com.squareup.picasso.y {

    private final Context a;
    z(Context context) {
        super();
        this.a = context;
    }

    private static Bitmap j(Resources resources, int i2, com.squareup.picasso.w w3) {
        boolean z;
        int i;
        final android.graphics.BitmapFactory.Options factory = y.d(w3);
        if (y.g(factory)) {
            BitmapFactory.decodeResource(resources, i2, factory);
            y.b(w3.h, w3.i, factory, w3);
        }
        return BitmapFactory.decodeResource(resources, i2, factory);
    }

    @Override // com.squareup.picasso.y
    public boolean c(com.squareup.picasso.w w) {
        if (w.e != 0) {
            return 1;
        }
        return "android.resource".equals(w.d.getScheme());
    }

    @Override // com.squareup.picasso.y
    public com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2) {
        Resources obj4 = f0.m(this.a, w);
        y.a aVar = new y.a(z.j(obj4, f0.l(obj4, w), w), t.e.DISK);
        return aVar;
    }
}
