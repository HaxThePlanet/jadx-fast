package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

/* compiled from: ResourceRequestHandler.java */
/* loaded from: classes2.dex */
class z extends y {

    private final Context a;
    z(Context context) {
        super();
        this.a = context;
    }

    private static Bitmap j(Resources resources, int i, w wVar) throws android.content.res.Resources.NotFoundException {
        final android.graphics.BitmapFactory.Options options = y.d(wVar);
        if (y.g(options)) {
            BitmapFactory.decodeResource(resources, i, options);
            y.b(wVar.h, wVar.i, options, wVar);
        }
        return BitmapFactory.decodeResource(resources, i, options);
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        if (wVar.e != 0) {
            return true;
        }
        return "android.resource".equals(wVar.d.getScheme());
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i) {
        Resources resources = f0.m(this.a, wVar);
        return new y.a(z.j(resources, f0.l(resources, wVar), wVar), t.e.DISK);
    }
}
