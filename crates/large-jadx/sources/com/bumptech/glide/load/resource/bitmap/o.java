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

/* loaded from: classes.dex */
public class o implements l<Drawable> {

    private final l<Bitmap> b;
    private final boolean c;
    public o(l<Bitmap> l, boolean z2) {
        super();
        this.b = l;
        this.c = z2;
    }

    private u<Drawable> d(Context context, u<Bitmap> u2) {
        return u.d(context.getResources(), u2);
    }

    @Override // com.bumptech.glide.load.l
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    public u<Drawable> b(Context context, u<Drawable> u2, int i3, int i4) {
        Object obj = u2.get();
        u uVar = n.a(c.c(context).f(), (Drawable)obj, i3, i4);
        if (uVar == null) {
            if (this.c) {
            } else {
                return u2;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Unable to convert ");
            obj4.append(obj);
            obj4.append(" to a Bitmap");
            IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
            throw obj3;
        }
        u obj5 = this.b.b(context, uVar, i3, i4);
        if (obj5.equals(uVar)) {
            obj5.a();
            return u2;
        }
        return d(context, obj5);
    }

    public l<BitmapDrawable> c() {
        return this;
    }

    @Override // com.bumptech.glide.load.l
    public boolean equals(Object object) {
        if (object instanceof o) {
            return this.b.equals(object.b);
        }
        return 0;
    }

    @Override // com.bumptech.glide.load.l
    public int hashCode() {
        return this.b.hashCode();
    }
}
