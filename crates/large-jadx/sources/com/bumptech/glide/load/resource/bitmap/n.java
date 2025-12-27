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

/* compiled from: DrawableToBitmapConverter.java */
/* loaded from: classes.dex */
final class n {

    private static final e a = new n$a();

    class a extends f {
        a() {
            super();
        }

        @Override // com.bumptech.glide.load.engine.z.f
        public void c(Bitmap bitmap) {
        }
    }

    static u<Bitmap> a(e eVar, Drawable drawable, int i, int i2) {
        e eVar2;
        Bitmap bitmap = null;
        Drawable current = drawable.getCurrent();
        z = current instanceof BitmapDrawable;
        i = 0;
        if (current instanceof BitmapDrawable) {
            bitmap = current.getBitmap();
        } else {
            z = current instanceof Animatable;
            if (!(current instanceof Animatable)) {
                bitmap = n.b(eVar, current, i, i2);
                i = 1;
            } else {
                i2 = 0;
            }
        }
        if (i == 0) {
            eVar2 = n.a;
        }
        return e.d(bitmap, eVar2);
    }

    private static Bitmap b(e eVar, Drawable drawable, int i, int i2) {
        int intrinsicWidth2;
        int intrinsicHeight2;
        String str3 = "Unable to draw ";
        i = 5;
        int intrinsicHeight = Integer.MIN_VALUE;
        final Bitmap bitmap = null;
        final String str4 = "DrawableToBitmap";
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0 && Log.isLoggable(str4, i)) {
            StringBuilder stringBuilder = new StringBuilder();
            str = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
            str5 = str3 + drawable + str;
            Log.w(str4, str5);
            return bitmap;
        }
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0 && Log.isLoggable(str4, i)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            str2 = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
            str6 = str3 + drawable + str2;
            Log.w(str4, str6);
            return bitmap;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            intrinsicWidth2 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            intrinsicHeight2 = drawable.getIntrinsicHeight();
        }
        Lock lock = a0.i();
        lock.lock();
        Bitmap bitmap2 = eVar.d(intrinsicWidth2, intrinsicHeight2, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmap2);
            i2 = 0;
            drawable.setBounds(i2, i2, intrinsicWidth2, intrinsicHeight2);
            drawable.draw(canvas);
            canvas.setBitmap(bitmap);
        } finally {
            obj.unlock();
            throw eVar;
        }
        lock.unlock();
        return bitmap2;
    }
}
