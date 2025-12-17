package com.bumptech.glide.load.n.h;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.d.b;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class a implements com.bumptech.glide.load.n.h.e<Bitmap, byte[]> {

    private final Bitmap.CompressFormat a;
    private final int b;
    public a() {
        super(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(Bitmap.CompressFormat bitmap$CompressFormat, int i2) {
        super();
        this.a = compressFormat;
        this.b = i2;
    }

    public u<byte[]> a(u<Bitmap> u, h h2) {
        ByteArrayOutputStream obj5 = new ByteArrayOutputStream();
        (Bitmap)u.get().compress(this.a, this.b, obj5);
        u.a();
        b obj4 = new b(obj5.toByteArray());
        return obj4;
    }
}
