package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.n.e.f;

/* compiled from: ResourceBitmapDecoder.java */
/* loaded from: classes.dex */
public class x implements j<Uri, Bitmap> {

    private final f a;
    private final e b;
    public x(f fVar, e eVar) {
        super();
        this.a = fVar;
        this.b = eVar;
    }

    public u<Bitmap> c(Uri uri, int i, int i2, h hVar) {
        u uVar = this.a.c(uri, i, i2, hVar);
        if (uVar == null) {
            return null;
        }
        return n.a(this.b, (Drawable)uVar.get(), i, i2);
    }

    public boolean d(Uri uri, h hVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
