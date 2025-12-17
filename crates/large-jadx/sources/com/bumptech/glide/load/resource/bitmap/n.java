package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.engine.z.f;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class n {

    private static final e a;

    class a extends f {
        @Override // com.bumptech.glide.load.engine.z.f
        public void c(Bitmap bitmap) {
        }
    }
    static {
        n.a aVar = new n.a();
        n.a = aVar;
    }

    static u<Bitmap> a(e e, Drawable drawable2, int i3, int i4) {
        boolean z;
        int i;
        e obj2;
        Bitmap obj3;
        obj3 = drawable2.getCurrent();
        i = 0;
        if (obj3 instanceof BitmapDrawable) {
            obj3 = (BitmapDrawable)obj3.getBitmap();
        } else {
            if (!obj3 instanceof Animatable) {
                obj3 = n.b(e, obj3, i3, i4);
                i = 1;
            } else {
                obj3 = 0;
            }
        }
        if (i != 0) {
        } else {
            obj2 = n.a;
        }
        return e.d(obj3, obj2);
    }

    private static Bitmap b(e e, Drawable drawable2, int i3, int i4) {
        int intrinsicHeight;
        int intrinsicWidth;
        boolean obj6;
        Object obj7;
        int obj8;
        int obj9;
        String str = "Unable to draw ";
        int i = 5;
        intrinsicHeight = Integer.MIN_VALUE;
        final int i5 = 0;
        final String str2 = "DrawableToBitmap";
        if (i3 == intrinsicHeight && drawable2.getIntrinsicWidth() <= 0 && Log.isLoggable(str2, i)) {
            if (drawable2.getIntrinsicWidth() <= 0) {
                if (Log.isLoggable(str2, i)) {
                    obj6 = new StringBuilder();
                    obj6.append(str);
                    obj6.append(drawable2);
                    obj6.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                    Log.w(str2, obj6.toString());
                }
                return i5;
            }
        }
        if (i4 == intrinsicHeight && drawable2.getIntrinsicHeight() <= 0 && Log.isLoggable(str2, i)) {
            if (drawable2.getIntrinsicHeight() <= 0) {
                if (Log.isLoggable(str2, i)) {
                    obj6 = new StringBuilder();
                    obj6.append(str);
                    obj6.append(drawable2);
                    obj6.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                    Log.w(str2, obj6.toString());
                }
                return i5;
            }
        }
        if (drawable2.getIntrinsicWidth() > 0) {
            obj8 = drawable2.getIntrinsicWidth();
        }
        if (drawable2.getIntrinsicHeight() > 0) {
            obj9 = drawable2.getIntrinsicHeight();
        }
        Lock lock = a0.i();
        lock.lock();
        obj6 = e.d(obj8, obj9, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(obj6);
        int i2 = 0;
        drawable2.setBounds(i2, i2, obj8, obj9);
        drawable2.draw(canvas);
        canvas.setBitmap(i5);
        lock.unlock();
        return obj6;
    }
}
