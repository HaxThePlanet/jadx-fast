package com.bumptech.glide.load.n.g;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.n.a.a;

/* loaded from: classes.dex */
public final class b implements a.a {

    private final e a;
    private final b b;
    public b(e e, b b2) {
        super();
        this.a = e;
        this.b = b2;
    }

    @Override // com.bumptech.glide.n.a$a
    public Bitmap a(int i, int i2, Bitmap.Config bitmap$Config3) {
        return this.a.e(i, i2, config3);
    }

    @Override // com.bumptech.glide.n.a$a
    public int[] b(int i) {
        final b bVar = this.b;
        if (bVar == null) {
            return new int[i];
        }
        return (int[])bVar.e(i, int[].class);
    }

    @Override // com.bumptech.glide.n.a$a
    public void c(Bitmap bitmap) {
        this.a.c(bitmap);
    }

    @Override // com.bumptech.glide.n.a$a
    public void d(byte[] bArr) {
        final b bVar = this.b;
        if (bVar == null) {
        }
        bVar.d(bArr);
    }

    @Override // com.bumptech.glide.n.a$a
    public byte[] e(int i) {
        final b bVar = this.b;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[])bVar.e(i, byte[].class);
    }

    @Override // com.bumptech.glide.n.a$a
    public void f(int[] iArr) {
        final b bVar = this.b;
        if (bVar == null) {
        }
        bVar.d(iArr);
    }
}
