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

/* compiled from: BitmapDrawableEncoder.java */
/* loaded from: classes.dex */
public class b implements k<BitmapDrawable> {

    private final e a;
    private final k<Bitmap> b;
    public b(e eVar, k<Bitmap> kVar) {
        super();
        this.a = eVar;
        this.b = kVar;
    }

    public c b(h hVar) {
        return this.b.b(hVar);
    }

    public boolean c(u<BitmapDrawable> uVar, File file, h hVar) {
        return this.b.a(new e((BitmapDrawable)uVar.get().getBitmap(), this.a), file, hVar);
    }
}
