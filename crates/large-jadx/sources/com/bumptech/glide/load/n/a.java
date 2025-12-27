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

/* compiled from: DefaultOnHeaderDecodedListener.java */
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
        a() {
            super();
        }

        public boolean onPartialImage(ImageDecoder.DecodeException exc) {
            return false;
        }
    }
    public a(int i, int i2, h hVar) {
        super();
        this.a = r.b();
        this.b = i;
        this.c = i2;
        this.d = (b)hVar.c(m.f);
        this.e = (l)hVar.c(l.f);
        gVar = m.i;
        if (hVar.c(gVar) != null) {
            i = (Boolean)hVar.c(m.i).booleanValue() ? 1 : 0;
        }
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        int width;
        boolean z = false;
        int height;
        ColorSpace.Named sRGB2;
        i iVar;
        z = false;
        int i = 1;
        if (this.a.e(this.b, this.c, this.f, z)) {
            int i3 = 3;
            imageDecoder.setAllocator(i3);
        } else {
            imageDecoder.setAllocator(i);
        }
        if (this.d == b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(z);
        }
        imageDecoder.setOnPartialImageListener(new a.a(this));
        Size size = imageInfo.getSize();
        int i6 = Integer.MIN_VALUE;
        if (this.b == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        if (this.c == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float f = this.e.b(size.getWidth(), size.getHeight(), width, height);
        int rounded = Math.round((float)size.getWidth() * f);
        int rounded2 = Math.round((float)size.getHeight() * f);
        String str2 = "ImageDecoder";
        if (Log.isLoggable(str2, 2)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Resizing from [";
            int width4 = size.getWidth();
            str = "x";
            int height4 = size.getHeight();
            String str4 = "] to [";
            String str5 = "] scaleFactor: ";
            str6 = str3 + width4 + str + height4 + str4 + rounded + str + rounded2 + str5 + f;
            Log.v(str2, str6);
        }
        imageDecoder.setTargetSize(rounded, rounded2);
        if (this.g != null) {
            int sDK_INT2 = Build.VERSION.SDK_INT;
            rounded = 28;
            if (Build.VERSION.SDK_INT >= 28) {
                if (this.g == i.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                }
                imageInfo = z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB;
                imageDecoder.setTargetColorSpace((z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else {
                int i2 = 26;
                if (Build.VERSION.SDK_INT >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            }
        }
    }
}
