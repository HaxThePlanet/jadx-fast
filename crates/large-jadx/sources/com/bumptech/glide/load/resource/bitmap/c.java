package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import com.bumptech.glide.t.l;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class c implements k<Bitmap> {

    public static final com.bumptech.glide.load.g<Integer> b;
    public static final com.bumptech.glide.load.g<Bitmap.CompressFormat> c;
    private final com.bumptech.glide.load.engine.z.b a;
    static {
        c.b = g.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        c.c = g.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    public c(com.bumptech.glide.load.engine.z.b bVar) {
        super();
        this.a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, h hVar) {
        final Object obj = hVar.c(c.c);
        if (obj != null) {
            return obj;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public com.bumptech.glide.load.c b(h hVar) {
        return c.TRANSFORMED;
    }

    public boolean c(u<Bitmap> uVar, File file, h hVar) {
        int str7;
        Object obj3;
        Object obj4;
        final String str3 = "BitmapEncoder";
        Object obj = uVar.get();
        Bitmap.CompressFormat compressFormat = d(obj, hVar);
        Integer num2 = Integer.valueOf(obj.getHeight());
        b.d("encode: [%dx%d] %s", Integer.valueOf(obj.getWidth()), num2, compressFormat);
        try {
            long l = g.b();
        } catch (Throwable th) {
        } catch (java.io.IOException ioException1) {
        }
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(ioException1);
        } catch (Throwable th) {
        }
        try {
        } catch (Throwable th) {
            obj3 = obj5;
        } catch (java.io.IOException ioException1) {
            obj3 = obj5;
        }
        try {
            obj.compress(compressFormat, (Integer)hVar.c(c.b).intValue(), obj4);
            obj4.close();
        } catch (Throwable th) {
        }
        try {
            obj4.close();
        } catch (java.io.IOException unused) {
            b.e();
            return true;
        } finally {
            b.e();
            throw th;
        }
    }
}
