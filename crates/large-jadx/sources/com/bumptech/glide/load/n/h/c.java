package com.bumptech.glide.load.n.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.g.c;

/* compiled from: DrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    private final com.bumptech.glide.load.engine.z.e a;
    private final e<Bitmap, byte[]> b;
    private final e<c, byte[]> c;
    public c(com.bumptech.glide.load.engine.z.e eVar, e<Bitmap, byte[]> eVar2, e<c, byte[]> eVar3) {
        super();
        this.a = eVar;
        this.b = eVar2;
        this.c = eVar3;
    }

    public u<byte[]> a(u<Drawable> uVar, h hVar) {
        Object obj = uVar.get();
        if (obj instanceof BitmapDrawable) {
            return this.b.a(e.d(obj.getBitmap(), this.a), hVar);
        }
        if (obj instanceof c) {
            c.b(uVar);
            return this.c.a(uVar, hVar);
        }
        return null;
    }

    private static u<c> b(u<Drawable> uVar) {
        return uVar;
    }
}
