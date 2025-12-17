package com.bumptech.glide.load.n.e;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.u;

/* loaded from: classes.dex */
final class e extends com.bumptech.glide.load.n.e.c<Drawable> {
    private e(Drawable drawable) {
        super(drawable);
    }

    static u<Drawable> d(Drawable drawable) {
        com.bumptech.glide.load.n.e.e eVar;
        if (drawable != null) {
            eVar = new e(drawable);
        } else {
            eVar = 0;
        }
        return eVar;
    }

    @Override // com.bumptech.glide.load.n.e.c
    public void a() {
    }

    public Class<Drawable> b() {
        return this.a.getClass();
    }

    @Override // com.bumptech.glide.load.n.e.c
    public int getSize() {
        return Math.max(1, i *= 4);
    }
}
