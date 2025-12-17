package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import java.io.File;

/* loaded from: classes.dex */
public class b implements k<BitmapDrawable> {

    private final e a;
    private final k<Bitmap> b;
    public b(e e, k<Bitmap> k2) {
        super();
        this.a = e;
        this.b = k2;
    }

    @Override // com.bumptech.glide.load.k
    public boolean a(Object object, File file2, h h3) {
        return c((u)object, file2, h3);
    }

    @Override // com.bumptech.glide.load.k
    public c b(h h) {
        return this.b.b(h);
    }

    public boolean c(u<BitmapDrawable> u, File file2, h h3) {
        e eVar = new e((BitmapDrawable)u.get().getBitmap(), this.a);
        return this.b.a(eVar, file2, h3);
    }
}
