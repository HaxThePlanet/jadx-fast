package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class o implements com.google.android.exoplayer2.upstream.f {

    private final boolean a;
    private final int b;
    private final byte[] c;
    private final com.google.android.exoplayer2.upstream.e[] d;
    private int e;
    private int f;
    private int g;
    private com.google.android.exoplayer2.upstream.e[] h;
    public o(boolean z, int i2) {
        super(z, i2, 0);
    }

    public o(boolean z, int i2, int i3) {
        int i4;
        int i5;
        int i;
        com.google.android.exoplayer2.upstream.e eVar;
        byte[] bArr;
        byte[] obj6;
        super();
        i4 = 0;
        final int i6 = 1;
        i5 = i2 > 0 ? i6 : i4;
        g.a(i5);
        i = i3 >= 0 ? i6 : i4;
        g.a(i);
        this.a = z;
        this.b = i2;
        this.g = i3;
        this.h = new e[i3 + 100];
        if (i3 > 0) {
            this.c = new byte[i3 * i2];
            while (i4 < i3) {
                eVar = new e(this.c, i4 * i2);
                this.h[i4] = eVar;
                i4++;
            }
        } else {
            this.c = 0;
        }
        this.d = new e[i6];
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public void a(com.google.android.exoplayer2.upstream.e e) {
        final com.google.android.exoplayer2.upstream.e[] objArr = this.d;
        objArr[0] = e;
        d(objArr);
        return;
        synchronized (this) {
            objArr = this.d;
            objArr[0] = e;
            d(objArr);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public com.google.android.exoplayer2.upstream.e b() {
        com.google.android.exoplayer2.upstream.e eVar;
        com.google.android.exoplayer2.upstream.e[] bArr;
        int i;
        int i2;
        this.f = i3++;
        int i5 = this.g;
        synchronized (this) {
            try {
                i5--;
                this.g = i6;
                g.e(this.h[i6]);
                this.h[this.g] = 0;
                eVar = new e(new byte[this.b], 0);
                return eVar;
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public void c() {
        int i3;
        int i2;
        int i;
        byte[] bArr;
        com.google.android.exoplayer2.upstream.e eVar;
        com.google.android.exoplayer2.upstream.e[] objArr;
        int i4;
        i3 = Math.max(0, i6 -= i9);
        i = this.g;
        synchronized (this) {
            try {
                if (this.c != null) {
                }
                i--;
                while (i2 <= i) {
                    bArr = this.h[i2];
                    g.e(bArr);
                    if (bArr.a == this.c) {
                    } else {
                    }
                    eVar = this.h[i];
                    g.e(eVar);
                    if (eVar.a != this.c) {
                    } else {
                    }
                    objArr = this.h;
                    objArr[i2] = (e)eVar;
                    objArr[i] = (e)bArr;
                    i = i10;
                    i2 = i4;
                    i--;
                    i2++;
                }
                bArr = this.h[i2];
                g.e(bArr);
                if (bArr.a == this.c) {
                } else {
                }
                i2++;
                eVar = this.h[i];
                g.e(eVar);
                if (eVar.a != this.c) {
                } else {
                }
                i--;
                objArr = this.h;
                objArr[i2] = (e)eVar;
                objArr[i] = (e)bArr;
                i = i10;
                i2 = i4;
                if (Math.max(i3, i2) >= this.g) {
                }
                Arrays.fill(this.h, i3, this.g, 0);
                this.g = i3;
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public void d(com.google.android.exoplayer2.upstream.e[] eArr) {
        int copyOf;
        int i4;
        int i;
        com.google.android.exoplayer2.upstream.e[] objArr;
        int length;
        int i2;
        int i3;
        copyOf = this.g;
        objArr = this.h;
        synchronized (this) {
            try {
                this.h = (e[])Arrays.copyOf(objArr, Math.max(length4 *= 2, copyOf += length));
                i = 0;
                while (i < eArr.length) {
                    i2 = this.g;
                    this.g = i2 + 1;
                    this.h[i2] = eArr[i];
                    i++;
                }
                i2 = this.g;
                this.g = i2 + 1;
                this.h[i2] = eArr[i];
                i++;
                this.f = i7 -= obj7;
                notifyAll();
                throw eArr;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public int e() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public int f() {
        return i *= i3;
        synchronized (this) {
            return i *= i3;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public void g() {
        boolean z;
        synchronized (this) {
            try {
                h(0);
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public void h(int i) {
        int i2;
        synchronized (this) {
            try {
                i2 = 1;
                i2 = 0;
                this.e = i;
                if (i2 != 0) {
                }
                c();
                throw i;
            }
        }
    }
}
