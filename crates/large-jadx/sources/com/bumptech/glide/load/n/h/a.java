package com.bumptech.glide.load.n.h;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.n.d.b;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder.java */
/* loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    private final Bitmap.CompressFormat a;
    private final int b;
    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public u<byte[]> a(u<Bitmap> uVar, h hVar) throws java.io.IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        (Bitmap)uVar.get().compress(this.a, this.b, byteArrayOutputStream);
        uVar.a();
        return new b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i) {
        super();
        this.a = compressFormat;
        this.b = i;
    }
}
