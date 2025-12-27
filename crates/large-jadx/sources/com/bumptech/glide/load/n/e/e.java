package com.bumptech.glide.load.n.e;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.u;

/* compiled from: NonOwnedDrawableResource.java */
/* loaded from: classes.dex */
final class e extends c<Drawable> {
    private e(Drawable drawable) {
        super(drawable);
    }

    static u<Drawable> d(Drawable drawable) {
        com.bumptech.glide.load.n.e.e eVar = null;
        e r0 = drawable != null ? new e(drawable) : 0;
        return (drawable != null ? new e(drawable) : 0);
    }

    @Override // com.bumptech.glide.load.n.e.c
    public Class<Drawable> b() {
        return this.a.getClass();
    }

    @Override // com.bumptech.glide.load.n.e.c
    public int getSize() {
        return Math.max(1, (this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight()) * 4);
    }

    @Override // com.bumptech.glide.load.n.e.c
    public void a() {
    }
}
