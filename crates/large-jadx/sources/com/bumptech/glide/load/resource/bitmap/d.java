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

/* loaded from: classes.dex */
public final class d implements j<ImageDecoder.Source, Bitmap> {

    private final e a;
    public d() {
        super();
        f fVar = new f();
        this.a = fVar;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((ImageDecoder.Source)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((ImageDecoder.Source)object, i2, i3, h4);
    }

    public u<Bitmap> c(ImageDecoder.Source imageDecoder$Source, int i2, int i3, h h4) {
        boolean stringBuilder;
        String str;
        String str2;
        int obj5;
        a aVar = new a(i2, i3, h4);
        final Bitmap obj4 = ImageDecoder.decodeBitmap(source, aVar);
        final String obj7 = "BitmapImageDecoder";
        if (Log.isLoggable(obj7, 2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Decoded [");
            stringBuilder.append(obj4.getWidth());
            str = "x";
            stringBuilder.append(str);
            stringBuilder.append(obj4.getHeight());
            stringBuilder.append("] for [");
            stringBuilder.append(i2);
            stringBuilder.append(str);
            stringBuilder.append(i3);
            stringBuilder.append("]");
            Log.v(obj7, stringBuilder.toString());
        }
        obj5 = new e(obj4, this.a);
        return obj5;
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(ImageDecoder.Source imageDecoder$Source, h h2) {
        return 1;
    }
}
