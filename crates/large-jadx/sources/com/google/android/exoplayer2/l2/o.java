package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.k.h;
import com.google.android.exoplayer2.m2.k.h.a;
import com.google.android.exoplayer2.util.d0;

/* loaded from: classes2.dex */
public final class o {

    private final d0 a;
    public o() {
        super();
        d0 d0Var = new d0(10);
        this.a = d0Var;
    }

    public a a(com.google.android.exoplayer2.l2.j j, h.a h$a2) {
        int i3;
        int i;
        int hVar;
        int i4;
        int i2;
        byte[] bArr;
        final int i5 = 0;
        i3 = 0;
        i = i5;
        i4 = 10;
        j.m(this.a.d(), i5, i4);
        this.a.I(i5);
        while (this.a.A() != 4801587) {
            this.a.J(3);
            hVar = this.a.w();
            i2 = hVar + 10;
            if (i3 == 0) {
            } else {
            }
            j.g(hVar);
            i += i2;
            i4 = 10;
            j.m(this.a.d(), i5, i4);
            this.a.I(i5);
            byte[] bArr2 = new byte[i2];
            System.arraycopy(this.a.d(), i5, bArr2, i5, i4);
            j.m(bArr2, i4, hVar);
            hVar = new h(a2);
            i3 = hVar.d(bArr2, i2);
        }
        j.i();
        j.g(i);
        return i3;
    }
}
