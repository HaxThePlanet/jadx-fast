package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;

/* loaded from: classes.dex */
public class e implements u<Bitmap>, q {

    private final Bitmap a;
    private final e b;
    public e(Bitmap bitmap, e e2) {
        super();
        k.e(bitmap, "Bitmap must not be null");
        this.a = (Bitmap)bitmap;
        k.e(e2, "BitmapPool must not be null");
        this.b = (e)e2;
    }

    public static com.bumptech.glide.load.resource.bitmap.e d(Bitmap bitmap, e e2) {
        if (bitmap == null) {
            return null;
        }
        e eVar = new e(bitmap, e2);
        return eVar;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void a() {
        this.b.c(this.a);
    }

    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public Bitmap c() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.u
    public Object get() {
        return c();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return l.g(this.a);
    }

    @Override // com.bumptech.glide.load.engine.u
    public void initialize() {
        this.a.prepareToDraw();
    }
}
