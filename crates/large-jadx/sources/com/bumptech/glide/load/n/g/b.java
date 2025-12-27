package com.bumptech.glide.load.n.g;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.n.a.a;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class b implements a.a {

    private final e a;
    private final b b;
    public b(e eVar, b bVar) {
        super();
        this.a = eVar;
        this.b = bVar;
    }

    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.a.e(i, i2, config);
    }

    public int[] b(int i) {
        if (this.b == null) {
            return new int[i];
        }
        return (int[])this.b.e(i, int[].class);
    }

    public void c(Bitmap bitmap) {
        this.a.c(bitmap);
    }

    public void d(byte[] bArr) {
        if (this.b == null) {
            return;
        }
        this.b.d(bArr);
    }

    public byte[] e(int i) {
        if (this.b == null) {
            return new byte[i];
        }
        return (byte[])this.b.e(i, byte[].class);
    }

    public void f(int[] iArr) {
        if (this.b == null) {
            return;
        }
        this.b.d(iArr);
    }
}
