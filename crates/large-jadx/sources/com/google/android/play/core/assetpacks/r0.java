package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class r0 extends FilterInputStream {

    private final com.google.android.play.core.assetpacks.l2 a;
    private byte[] b;
    private long c;
    private boolean v = false;
    private boolean w = false;
    r0(InputStream inputStream) {
        super(inputStream);
        l2 obj1 = new l2();
        this.a = obj1;
        this.b = new byte[4096];
        obj1 = 0;
    }

    private final int i(byte[] bArr, int i2, int i3) {
        return Math.max(0, super.read(bArr, i2, i3));
    }

    private final boolean j(int i) {
        int i2;
        int i3;
        final int i5 = 0;
        int i4 = i(this.b, i5, i);
        i2 = i - i4;
        if (i4 != i && i(this.b, i4, i2) == i2) {
            i2 = i - i4;
            if (i(this.b, i4, i2) == i2) {
            }
            this.a.b(this.b, i5, i4);
            return i5;
        }
        this.a.b(this.b, i5, i);
        return 1;
    }

    @Override // java.io.FilterInputStream
    final long a() {
        return this.c;
    }

    @Override // java.io.FilterInputStream
    final com.google.android.play.core.assetpacks.m3 c() {
        int read;
        boolean z;
        int i;
        int length;
        long copyOf;
        int length2;
        int cmp;
        if (Long.compare(l, length) > 0) {
        }
        if (!this.v) {
            if (this.w) {
            } else {
                int i6 = 1;
                if (!j(30)) {
                    this.v = i6;
                    return this.a.c();
                }
                com.google.android.play.core.assetpacks.m3 m3Var2 = this.a.c();
                if (m3Var2.d()) {
                    this.w = i6;
                    return m3Var2;
                }
                if (Long.compare(l3, l4) == 0) {
                } else {
                    i3 += -30;
                    copyOf = (long)i4;
                    if (Long.compare(copyOf, l5) > 0) {
                    }
                    if (!j(i4)) {
                        this.v = i6;
                        return this.a.c();
                    }
                    com.google.android.play.core.assetpacks.m3 m3Var4 = this.a.c();
                    this.c = m3Var4.b();
                    return m3Var4;
                }
            }
            g1 g1Var = new g1("Files bigger than 4GiB are not supported.");
            throw g1Var;
        }
        super(0, -1, obj5, -1, 0, 0, 0);
        return n0Var;
    }

    @Override // java.io.FilterInputStream
    final boolean e() {
        return this.w;
    }

    @Override // java.io.FilterInputStream
    final boolean f() {
        return this.v;
    }

    @Override // java.io.FilterInputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int cmp;
        int obj5;
        long l = this.c;
        if (Long.compare(l, i) > 0) {
            if (this.v) {
            } else {
                obj5 = i(bArr, i2, (int)l2);
                this.c = obj6 -= l3;
                if (obj5 == null) {
                    this.v = true;
                    obj5 = 0;
                }
            }
            return obj5;
        }
        return -1;
    }
}
