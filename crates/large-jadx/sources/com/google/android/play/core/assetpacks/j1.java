package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
final class j1 extends OutputStream {

    private final com.google.android.play.core.assetpacks.l2 a;
    private final File b;
    private final com.google.android.play.core.assetpacks.g3 c;
    private long v;
    private long w;
    private FileOutputStream x;
    private com.google.android.play.core.assetpacks.m3 y;
    j1(File file, com.google.android.play.core.assetpacks.g3 g32) {
        super();
        l2 l2Var = new l2();
        this.a = l2Var;
        this.b = file;
        this.c = g32;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        final int i2 = 1;
        final byte[] bArr = new byte[i2];
        final int i3 = 0;
        bArr[i3] = (byte)i;
        write(bArr, i3, i2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        int i;
        int file;
        boolean z;
        int fileOutputStream;
        long l;
        long l2;
        com.google.android.play.core.assetpacks.g3 g3Var;
        int length;
        byte[] bArr3;
        byte[] bArr2;
        int i4;
        int i5;
        int obj12;
        int obj13;
        while (obj13 > 0) {
            l = 0;
            if (this.y.g()) {
            } else {
            }
            if (this.y.d()) {
            } else {
            }
            if (this.y.h()) {
            } else {
            }
            i = (int)l8;
            bArr3 = this.c;
            bArr3.e(i10 - l14, bArr3, bArr, obj12);
            this.v = l10 -= l2;
            obj12 += i;
            obj13 -= i;
            i = (int)l6;
            this.x.write(bArr, obj12, i);
            l13 -= bArr3;
            this.v = g3Var;
            if (Long.compare(g3Var, l) == 0) {
            }
            this.x.close();
            this.c.e(this.w, bArr3, bArr, obj12);
            this.w = l4 += l;
            i = obj13;
            int i7 = this.a.b(bArr, obj12, obj13);
            obj12 += i7;
            obj13 -= i7;
            com.google.android.play.core.assetpacks.m3 m3Var4 = this.a.c();
            this.y = m3Var4;
            fileOutputStream = 0;
            if (m3Var4.d()) {
            } else {
            }
            if (this.y.h()) {
            } else {
            }
            byte[] bArr5 = this.y.f();
            this.c.l(bArr5, fileOutputStream, bArr5.length);
            this.v = this.y.b();
            if (this.y.g()) {
            } else {
            }
            this.c.j(this.y.f());
            file = new File(this.b, this.y.c());
            file.getParentFile().mkdirs();
            this.v = this.y.b();
            fileOutputStream = new FileOutputStream(file);
            this.x = fileOutputStream;
            this.v = l;
            this.c.l(this.y.f(), fileOutputStream, bArr8.length);
            this.w = (long)length2;
        }
    }
}
