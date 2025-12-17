package com.bumptech.glide.load.n;

import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.DecodeException;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.OnPartialImageListener;
import android.graphics.ImageDecoder.Source;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.r;

/* loaded from: classes.dex */
public final class a implements ImageDecoder.OnHeaderDecodedListener {

    private final r a;
    private final int b;
    private final int c;
    private final b d;
    private final l e;
    private final boolean f = false;
    private final i g;

    class a implements ImageDecoder.OnPartialImageListener {
        a(com.bumptech.glide.load.n.a a) {
            super();
        }

        @Override // android.graphics.ImageDecoder$OnPartialImageListener
        public boolean onPartialImage(ImageDecoder.DecodeException imageDecoder$DecodeException) {
            return 0;
        }
    }
    public a(int i, int i2, h h3) {
        com.bumptech.glide.load.g obj2;
        super();
        this.a = r.b();
        this.b = i;
        this.c = i2;
        this.d = (b)h3.c(m.f);
        this.e = (l)h3.c(l.f);
        obj2 = m.i;
        if (h3.c(obj2) != null && (Boolean)h3.c(obj2).booleanValue()) {
            obj2 = (Boolean)h3.c(obj2).booleanValue() ? 1 : obj2;
        }
        obj2 = 0;
        this.g = (i)h3.c(m.g);
    }

    @Override // android.graphics.ImageDecoder$OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageDecoder$ImageInfo2, ImageDecoder.Source imageDecoder$Source3) {
        int width;
        float sDK_INT;
        int round;
        int i;
        int height;
        boolean stringBuilder;
        String str;
        boolean obj10;
        int obj11;
        i = 0;
        int i3 = 1;
        if (this.a.e(this.b, this.c, this.f, i)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(i3);
        }
        if (this.d == b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(i);
        }
        obj11 = new a.a(this);
        imageDecoder.setOnPartialImageListener(obj11);
        obj11 = imageInfo2.getSize();
        int i5 = Integer.MIN_VALUE;
        if (this.b == i5) {
            width = obj11.getWidth();
        }
        if (this.c == i5) {
            height = obj11.getHeight();
        }
        sDK_INT = this.e.b(obj11.getWidth(), obj11.getHeight(), width, height);
        round = Math.round(f *= sDK_INT);
        int round2 = Math.round(f2 *= sDK_INT);
        String str2 = "ImageDecoder";
        if (Log.isLoggable(str2, 2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Resizing from [");
            stringBuilder.append(obj11.getWidth());
            str = "x";
            stringBuilder.append(str);
            stringBuilder.append(obj11.getHeight());
            stringBuilder.append("] to [");
            stringBuilder.append(round);
            stringBuilder.append(str);
            stringBuilder.append(round2);
            stringBuilder.append("] scaleFactor: ");
            stringBuilder.append(sDK_INT);
            Log.v(str2, stringBuilder.toString());
        }
        imageDecoder.setTargetSize(round, round2);
        obj11 = this.g;
        if (obj11 != null) {
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 28) {
                if (obj11 == i.DISPLAY_P3 && imageInfo2.getColorSpace() != null && imageInfo2.getColorSpace().isWideGamut()) {
                    if (imageInfo2.getColorSpace() != null) {
                        if (imageInfo2.getColorSpace().isWideGamut()) {
                            i = i3;
                        }
                    }
                }
                obj10 = i != 0 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB;
                imageDecoder.setTargetColorSpace(ColorSpace.get(obj10));
            } else {
                if (sDK_INT >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            }
        }
    }
}
