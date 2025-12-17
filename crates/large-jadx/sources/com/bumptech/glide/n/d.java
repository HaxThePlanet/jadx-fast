package com.bumptech.glide.n;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    private final byte[] a;
    private ByteBuffer b;
    private com.bumptech.glide.n.c c;
    private int d = 0;
    public d() {
        super();
        this.a = new byte[256];
        int i2 = 0;
    }

    private boolean b() {
        int i;
        i = cVar.b != 0 ? 1 : 0;
        return i;
    }

    private int d() {
        int i;
        int i2;
        try {
            b &= 255;
            cVar.b = 1;
            return i;
        }
    }

    private void e() {
        int i2;
        int i;
        int i3;
        bVar.a = n();
        bVar2.b = n();
        bVar3.c = n();
        bVar4.d = n();
        int i4 = d();
        final int i13 = 1;
        i = i4 & 128 != 0 ? i13 : i3;
        com.bumptech.glide.n.b bVar7 = cVar7.d;
        if (i4 &= 64 != 0) {
            i3 = i13;
        }
        bVar7.e = i3;
        if (i != 0) {
            bVar7.k = g((int)d);
        } else {
            bVar7.k = 0;
        }
        bVar5.j = this.b.position();
        r();
        if (b()) {
        }
        com.bumptech.glide.n.c cVar6 = this.c;
        cVar6.c = i11 += i13;
        cVar6.e.add(cVar6.d);
    }

    private void f() {
        int i4;
        int i2;
        int i;
        Throwable th;
        int stringBuilder;
        String str;
        String str2;
        i4 = d();
        this.d = i4;
        if (i4 > 0) {
            i = i4;
            i2 = this.d;
            while (i4 < i2) {
                i2 -= i4;
                this.b.get(this.a, i4, i);
                i4 += i;
                i2 = this.d;
            }
        }
    }

    private int[] g(int i) {
        byte[] bArr;
        int str;
        int i4;
        int i2;
        int i5;
        int i6;
        int i7;
        int i3;
        int i8;
        int obj10;
        bArr = new byte[i * 3];
        int i10 = 0;
        this.b.get(bArr);
        int[] iArr = new int[256];
        i2 = i4;
        while (i4 < i) {
            int i17 = i2 + 1;
            int i19 = i17 + 1;
            iArr[i4] = i15 |= i6;
            i2 = i7;
            i4 = i3;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i) {
        int i4;
        int equals;
        int bVar;
        int i3;
        int i2;
        final int i5 = 0;
        i4 = i5;
        while (i4 == 0) {
            if (!b()) {
            }
            if (cVar.c <= i) {
            }
            equals = d();
            i2 = 1;
            if (equals != 33) {
            } else {
            }
            equals = d();
            if (equals != i2) {
            } else {
            }
            q();
            if (equals != 249) {
            } else {
            }
            bVar = new b();
            equals.d = bVar;
            j();
            if (equals != 254) {
            } else {
            }
            q();
            if (equals != 255) {
            } else {
            }
            f();
            StringBuilder stringBuilder = new StringBuilder();
            i3 = i5;
            while (i3 < 11) {
                stringBuilder.append((char)b);
                i3++;
            }
            if (stringBuilder.toString().equals("NETSCAPE2.0")) {
            } else {
            }
            q();
            m();
            stringBuilder.append((char)b);
            i3++;
            q();
            if (equals != 44) {
            } else {
            }
            equals = this.c;
            if (equals.d == null) {
            }
            e();
            bVar = new b();
            equals.d = bVar;
            if (equals != 59) {
            } else {
            }
            i4 = i2;
            equals.b = i2;
        }
    }

    private void j() {
        int i;
        int i2;
        d();
        int i3 = d();
        com.bumptech.glide.n.b bVar = cVar.d;
        final int i10 = 2;
        i8 >>= i10;
        bVar.g = i9;
        i2 = 1;
        if (i9 == 0) {
            bVar.g = i2;
        }
        if (i3 &= i2 != 0) {
        } else {
            i2 = 0;
        }
        bVar.f = i2;
        int i7 = 10;
        if (n() < i10) {
            i = i7;
        }
        com.bumptech.glide.n.b bVar2 = cVar2.d;
        bVar2.i = i *= i7;
        bVar2.h = d();
        d();
    }

    private void k() {
        boolean z;
        int i;
        String str;
        char c;
        int i2;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < 6) {
            stringBuilder.append((char)i5);
            i++;
        }
        if (!stringBuilder.toString().startsWith("GIF")) {
            cVar3.b = 1;
        }
        l();
        if (cVar.h && !b()) {
            if (!b()) {
                com.bumptech.glide.n.c cVar2 = this.c;
                cVar2.a = g(cVar2.i);
                z = this.c;
                z.l = z.a[z.j];
            }
        }
    }

    private void l() {
        int i;
        cVar.f = n();
        cVar2.g = n();
        int i2 = d();
        com.bumptech.glide.n.c cVar5 = this.c;
        final int i11 = 1;
        i = i2 & 128 != 0 ? i11 : 0;
        cVar5.h = i;
        cVar5.i = (int)d2;
        cVar3.j = d();
        cVar4.k = d();
    }

    private void m() {
        byte[] bArr;
        int i2;
        byte b;
        int i;
        f();
        bArr = this.a;
        i = 1;
        while (bArr[0] == i) {
            i.m = i4 |= b;
            if (this.d > 0) {
            }
            if (!b()) {
            }
            f();
            bArr = this.a;
            i = 1;
        }
    }

    private int n() {
        return this.b.getShort();
    }

    private void o() {
        this.b = 0;
        final int i2 = 0;
        Arrays.fill(this.a, i2);
        c cVar = new c();
        this.c = cVar;
        this.d = i2;
    }

    private void q() {
        final int i = d();
        this.b.position(Math.min(position += i, this.b.limit()));
        while (i <= 0) {
            i = d();
            this.b.position(Math.min(position += i, this.b.limit()));
        }
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        final int i = 0;
        this.b = i;
        this.c = i;
    }

    public com.bumptech.glide.n.c c() {
        boolean z;
        int i;
        if (this.b == null) {
        } else {
            if (b()) {
                return this.c;
            }
            k();
            h();
            z = this.c;
            if (!b() && z.c < 0) {
                h();
                z = this.c;
                if (z.c < 0) {
                    z.b = 1;
                }
            }
            return this.c;
        }
        IllegalStateException illegalStateException = new IllegalStateException("You must call setData() before parseHeader()");
        throw illegalStateException;
    }

    public com.bumptech.glide.n.d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer obj2 = byteBuffer.asReadOnlyBuffer();
        this.b = obj2;
        obj2.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
