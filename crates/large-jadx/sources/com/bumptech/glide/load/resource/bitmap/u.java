package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.t.k;

/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: classes.dex */
public final class u implements u<BitmapDrawable>, q {

    private final Resources a;
    private final u<Bitmap> b;
    private u(Resources resources, u<Bitmap> uVar) {
        super();
        k.d(resources);
        this.a = resources;
        k.d(uVar);
        this.b = uVar;
    }

    public static u<BitmapDrawable> d(Resources resources, u<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new u(resources, uVar);
    }

    public void a() {
        this.b.a();
    }

    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    public BitmapDrawable c() {
        return new BitmapDrawable(this.a, (Bitmap)this.b.get());
    }

    public int getSize() {
        return this.b.getSize();
    }

    public void initialize() {
        if (uVar instanceof q) {
            uVar.initialize();
        }
    }
}
