package com.bumptech.glide.n;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    private final byte[] a;
    private ByteBuffer b;
    private c c;
    private int d = 0;
    public d() {
        super();
        this.a = new byte[256];
    }

    private boolean b() {
        boolean z = true;
        int r0 = this.c.b != 0 ? 1 : 0;
        return (this.c.b != 0 ? 1 : 0);
    }

    private int d() {
        int i;
        try {
        } catch (Exception unused) {
            this.c.b = 1;
        }
        i = this.b.get() & 255;
        return i;
    }

    private void e() {
        int i;
        this.c.d.a = n();
        this.c.d.b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int i2 = d();
        i = 0;
        i = 1;
        int r1 = i2 & 128 != 0 ? i : 0;
        if (i2 & 64 != 0) {
        }
        this.c.d.e = i;
        if (i != 0) {
            this.c.d.k = g((int)Math.pow(4611686018427387904L, d, (double)i2 & 7 + i, obj));
        } else {
            int[] iArr = null;
            this.c.d.k = iArr;
        }
        this.c.d.j = this.b.position();
        r();
        if (b()) {
            return;
        }
        cVar6.c += i;
        cVar6.e.add(cVar6.d);
    }

    private void f() {
        int i = 0;
        Throwable th;
        ByteBuffer byteBuffer;
        int stringBuilder;
        byte[] bArr;
        String str;
        String str2;
        i = d();
        this.d = i;
        if (i > 0) {
            i = 0;
            while (i < this.d) {
                i = i2 - i;
                this.b.get(this.a, i, i);
                i = i + i;
                try {
                    i = i2 - i;
                    this.b.get(this.a, i, i);
                } catch (Exception e) {
                    stringBuilder = 3;
                    str = "GifHeaderParser";
                    stringBuilder = Log.isLoggable(str, stringBuilder);
                }
            }
        }
    }

    private int[] g(int i) {
        int str2;
        int i2 = 0;
        byte[] bArr = new byte[i * 3];
        try {
            this.b.get(bArr);
            int[] iArr = new int[256];
            i2 = 0;
            int i14 = i2 + 1;
            int i16 = i14 + 1;
            i2 = i16 + 1;
            i4 = bArr[i16] & 255;
            i2 = i2 + 1;
            int i5 = -16777216;
            i3 = (bArr[i14] & 255) << 8;
            iArr[i2] = (bArr[i2] & 255) << 16 | i5 | i3 | i4;
        } catch (java.nio.BufferUnderflowException bufferUnderflow) {
            String str = "GifHeaderParser";
            str2 = 3;
            str2 = Log.isLoggable(str, str2);
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i) {
        int i2;
        int i3;
        Object str;
        i2 = 0;
        while (i2 == 0) {
            if (b()) {
                return;
            }
        }
    }

    private void j() {
        int i;
        int i2 = 1;
        d();
        int i3 = d();
        final int i9 = 2;
        int i8 = (i3 & 28) >> i9;
        this.c.d.g = i8;
        i2 = 1;
        if (i8 == 0) {
            this.c.d.g = i2;
        }
        if (i3 & i2 == 0) {
            i2 = 0;
        }
        this.c.d.f = i2;
        i = 10;
        if (n() < i9) {
        }
        this.c.d.i = i * i;
        this.c.d.h = d();
        d();
    }

    private void k() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        int i2 = 6;
        while (i < 6) {
            c = (char)d();
            stringBuilder.append(c);
            i = i + 1;
            i2 = 6;
        }
        str = "GIF";
        if (!stringBuilder.toString().startsWith(str)) {
            this.c.b = 1;
            return;
        }
        l();
        if (this.c.h && !this.b()) {
            this.c.a = g(cVar2.i);
            this.c.l = cVar3.a[cVar3.j];
        }
    }

    private void l() {
        int i = 0;
        this.c.f = n();
        this.c.g = n();
        int i2 = d();
        i = 1;
        int r2 = i2 & 128 != 0 ? i : 0;
        this.c.h = (i2 & 128 != 0 ? i : 0);
        this.c.i = (int)(i2 & 128 != 0 ? i : 0);
        this.c.j = d();
        this.c.k = d();
    }

    private void m() {
        f();
        byte b2 = (byte) 1;
        while (bArr[0] == b2) {
            this.c.m = (bArr[2] & 255) << 8 | (bArr[b2] & 255);
            if (this.d > 0 && this.b()) {
                return;
            }
        }
    }

    private int n() {
        return this.b.getShort();
    }

    private void o() {
        this.b = null;
        final byte b = (byte) 0;
        Arrays.fill(this.a, b);
        this.c = new c();
        this.d = b;
    }

    private void q() {
        final int i = d();
        this.b.position(Math.min(this.b.position() + i, this.b.limit()));
        while (i <= 0) {
            i = d();
            this.b.position(Math.min(this.b.position() + i, this.b.limit()));
        }
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        final ByteBuffer byteBuffer = null;
        this.b = byteBuffer;
        this.c = byteBuffer;
    }

    public c c() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else {
            if (b()) {
                return this.c;
            }
            k();
            if (!b()) {
                h();
                if (cVar2.c < 0) {
                    int i = 1;
                    this.c.b = i;
                }
            }
            return this.c;
        }
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = readOnlyBuffer;
        readOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
