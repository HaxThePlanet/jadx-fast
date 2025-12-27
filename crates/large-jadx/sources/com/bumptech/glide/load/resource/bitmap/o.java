package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation.java */
/* loaded from: classes.dex */
public class o implements l<Drawable> {

    private final l<Bitmap> b;
    private final boolean c;
    public o(l<Bitmap> lVar, boolean z) {
        super();
        this.b = lVar;
        this.c = z;
    }

    private u<Drawable> d(Context context, u<Bitmap> uVar) {
        return u.d(context.getResources(), uVar);
    }

    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    public u<Drawable> b(Context context, u<Drawable> uVar, int i, int i2) {
        Object obj = uVar.get();
        uVar = n.a(c.c(context).f(), obj, i, i2);
        if (uVar == null) {
            if (this.c) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Unable to convert ";
                String str2 = " to a Bitmap";
                uVar = str + obj + str2;
                throw new IllegalArgumentException(uVar);
            } else {
                return uVar;
            }
        }
        u uVar4 = this.b.b(context, uVar, i, i2);
        if (uVar4.equals(uVar)) {
            uVar4.a();
            return uVar;
        }
        return d(context, uVar4);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (object instanceof o) {
            return this.b.equals(object.b);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.b.hashCode();
    }

    public l<BitmapDrawable> c() {
        return this;
    }
}
