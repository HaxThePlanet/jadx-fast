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

/* loaded from: classes.dex */
public class f implements l<com.bumptech.glide.load.n.g.c> {

    private final l<Bitmap> b;
    public f(l<Bitmap> l) {
        super();
        k.d(l);
        this.b = (l)l;
    }

    @Override // com.bumptech.glide.load.l
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    public u<com.bumptech.glide.load.n.g.c> b(Context context, u<com.bumptech.glide.load.n.g.c> u2, int i3, int i4) {
        final Object obj = u2.get();
        e eVar2 = new e((c)obj.e(), c.c(context).f());
        u obj5 = this.b.b(context, eVar2, i3, i4);
        if (!eVar2.equals(obj5)) {
            eVar2.a();
        }
        obj.m(this.b, (Bitmap)obj5.get());
        return u2;
    }

    @Override // com.bumptech.glide.load.l
    public boolean equals(Object object) {
        if (object instanceof f) {
            return this.b.equals(object.b);
        }
        return 0;
    }

    @Override // com.bumptech.glide.load.l
    public int hashCode() {
        return this.b.hashCode();
    }
}
