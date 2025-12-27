package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;

/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class e implements u<Bitmap>, q {

    private final Bitmap a;
    private final e b;
    public e(Bitmap bitmap, e eVar) {
        super();
        k.e(bitmap, "Bitmap must not be null");
        this.a = bitmap;
        k.e(eVar, "BitmapPool must not be null");
        this.b = eVar;
    }

    public static e d(Bitmap bitmap, e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, eVar);
    }

    public void a() {
        this.b.c(this.a);
    }

    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    public Bitmap c() {
        return this.a;
    }

    public int getSize() {
        return l.g(this.a);
    }

    public void initialize() {
        this.a.prepareToDraw();
    }
}
