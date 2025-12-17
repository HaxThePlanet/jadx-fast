package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import com.bumptech.glide.t.g;
import com.bumptech.glide.t.l;
import com.bumptech.glide.t.m.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class c implements k<Bitmap> {

    public static final g<Integer> b;
    public static final g<Bitmap.CompressFormat> c;
    private final b a;
    static {
        c.b = g.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        c.c = g.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    public c(b b) {
        super();
        this.a = b;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, h h2) {
        final Object obj3 = h2.c(c.c);
        if ((Bitmap.CompressFormat)obj3 != null) {
            return (Bitmap.CompressFormat)obj3;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.k
    public boolean a(Object object, File file2, h h3) {
        return c((u)object, file2, h3);
    }

    @Override // com.bumptech.glide.load.k
    public c b(h h) {
        return c.TRANSFORMED;
    }

    public boolean c(u<Bitmap> u, File file2, h h3) {
        Object compressFormat;
        int str;
        int intValue;
        Object obj3;
        Object obj;
        Object obj9;
        Object obj10;
        Object obj11;
        final String str2 = "BitmapEncoder";
        obj9 = u.get();
        compressFormat = d((Bitmap)obj9, h3);
        Integer valueOf2 = Integer.valueOf(obj9.getHeight());
        b.d("encode: [%dx%d] %s", Integer.valueOf(obj9.getWidth()), valueOf2, compressFormat);
        long l = g.b();
        int i2 = 0;
        int i4 = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        if (this.a != null) {
            obj10 = new c(fileOutputStream, this.a);
            obj = obj10;
        } else {
            obj = fileOutputStream;
        }
        obj9.compress(compressFormat, (Integer)h3.c(c.b).intValue(), obj);
        obj.close();
        obj.close();
        if (Log.isLoggable(str2, 2)) {
            obj10 = new StringBuilder();
            obj10.append("Compressed with type: ");
            obj10.append(compressFormat);
            obj10.append(" of size ");
            obj10.append(l.g(obj9));
            obj10.append(" in ");
            obj10.append(g.a(l));
            obj10.append(", options format: ");
            obj10.append(h3.c(c.c));
            obj10.append(", hasAlpha: ");
            obj10.append(obj9.hasAlpha());
            Log.v(str2, obj10.toString());
        }
        b.e();
        return 1;
    }
}
