package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.l;
import com.bumptech.glide.t.l;

/* loaded from: classes.dex */
public abstract class f implements l<Bitmap> {
    public final u<Bitmap> b(Context context, u<Bitmap> u2, int i3, int i4) {
        com.bumptech.glide.load.resource.bitmap.e obj4;
        int obj5;
        int obj6;
        if (!l.t(i3, i4)) {
        } else {
            e obj3 = c.c(context).f();
            Object obj = u2.get();
            final int i = Integer.MIN_VALUE;
            if (i3 == i) {
                obj5 = (Bitmap)obj.getWidth();
            }
            if (i4 == i) {
                obj6 = obj.getHeight();
            }
            obj5 = c(obj3, obj, obj5, obj6);
            if (obj.equals(obj5)) {
            } else {
                obj4 = e.d(obj5, obj3);
            }
            return obj4;
        }
        obj4 = new StringBuilder();
        obj4.append("Cannot apply transformation on width: ");
        obj4.append(i3);
        obj4.append(" or height: ");
        obj4.append(i4);
        obj4.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        obj3 = new IllegalArgumentException(obj4.toString());
        throw obj3;
    }

    @Override // com.bumptech.glide.load.l
    protected abstract Bitmap c(e e, Bitmap bitmap2, int i3, int i4);
}
