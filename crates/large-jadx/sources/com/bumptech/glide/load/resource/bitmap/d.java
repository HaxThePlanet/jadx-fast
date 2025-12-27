package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.Source;
import android.util.Log;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.engine.z.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.n.a;

/* compiled from: BitmapImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public final class d implements j<ImageDecoder.Source, Bitmap> {

    private final e a = new f();
    public d() {
        super();
        final f fVar = new f();
    }

    public u<Bitmap> c(ImageDecoder.Source source, int i, int i2, h hVar) throws java.io.IOException {
        final Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new a(i, i2, hVar));
        final String str6 = "BitmapImageDecoder";
        if (Log.isLoggable(str6, 2)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "Decoded [";
            int width = decodeBitmap.getWidth();
            str = "x";
            int height = decodeBitmap.getHeight();
            str2 = "] for [";
            String str5 = "]";
            str3 = str4 + width + str + height + str2 + i + str + i2 + str5;
            Log.v(str6, str3);
        }
        return new e(decodeBitmap, this.a);
    }

    public boolean d(ImageDecoder.Source source, h hVar) {
        return true;
    }
}
