package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.t.k;

/* loaded from: classes.dex */
public final class u implements u<BitmapDrawable>, q {

    private final Resources a;
    private final u<Bitmap> b;
    private u(Resources resources, u<Bitmap> u2) {
        super();
        k.d(resources);
        this.a = (Resources)resources;
        k.d(u2);
        this.b = (u)u2;
    }

    public static u<BitmapDrawable> d(Resources resources, u<Bitmap> u2) {
        if (u2 == null) {
            return 0;
        }
        u uVar = new u(resources, u2);
        return uVar;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void a() {
        this.b.a();
    }

    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public BitmapDrawable c() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a, (Bitmap)this.b.get());
        return bitmapDrawable;
    }

    @Override // com.bumptech.glide.load.engine.u
    public Object get() {
        return c();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void initialize() {
        final u uVar = this.b;
        if (uVar instanceof q) {
            (q)uVar.initialize();
        }
    }
}
