package com.bumptech.glide.n;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface a {

    public interface a {
        public abstract Bitmap a(int i, int i2, Bitmap.Config bitmap$Config3);

        public abstract int[] b(int i);

        public abstract void c(Bitmap bitmap);

        public abstract void d(byte[] bArr);

        public abstract byte[] e(int i);

        public abstract void f(int[] iArr);
    }
    public abstract Bitmap a();

    public abstract void b();

    public abstract int c();

    public abstract void clear();

    public abstract int d();

    public abstract void e(Bitmap.Config bitmap$Config);

    public abstract void f();

    public abstract int g();

    public abstract int getByteSize();

    public abstract ByteBuffer getData();
}
