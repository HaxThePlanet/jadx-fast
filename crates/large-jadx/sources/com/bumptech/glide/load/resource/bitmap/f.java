package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class f implements com.bumptech.glide.load.l<Bitmap> {
    public final u<Bitmap> b(Context context, u<Bitmap> uVar, int i, int i2) {
        com.bumptech.glide.load.resource.bitmap.e eVar;
        int width;
        int height;
        if (!l.t(i, i2)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Cannot apply transformation on width: ";
            String str2 = " or height: ";
            String str3 = " less than or equal to zero and not Target.SIZE_ORIGINAL";
            uVar = str + i + str2 + i2 + str3;
            throw new IllegalArgumentException(uVar);
        } else {
            e eVar2 = c.c(context).f();
            Object obj = uVar.get();
            i = Integer.MIN_VALUE;
            if (i == Integer.MIN_VALUE) {
                width = obj.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                height = obj.getHeight();
            }
            Bitmap bitmap = c(eVar2, obj, width, height);
            if (!(obj.equals(bitmap))) {
                eVar = e.d(bitmap, eVar2);
            }
            return eVar;
        }
    }

    protected abstract Bitmap c(e eVar, Bitmap bitmap, int i, int i2);
}
