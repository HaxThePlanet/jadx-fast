package com.bumptech.glide.load.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.resource.bitmap.e;
import com.bumptech.glide.t.k;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class f implements l<c> {

    private final l<Bitmap> b;
    public f(l<Bitmap> lVar) {
        super();
        k.d(lVar);
        this.b = lVar;
    }

    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    public u<c> b(Context context, u<c> uVar, int i, int i2) {
        final Object obj = uVar.get();
        final e eVar2 = new e(obj.e(), c.c(context).f());
        uVar = this.b.b(context, eVar2, i, i2);
        if (!eVar2.equals(uVar)) {
            eVar2.a();
        }
        obj.m(this.b, (Bitmap)uVar.get());
        return uVar;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (object instanceof f) {
            return this.b.equals(object.b);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.b.hashCode();
    }
}
