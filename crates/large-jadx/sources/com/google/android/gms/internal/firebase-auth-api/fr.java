package com.google.android.gms.internal.firebase-auth-api;

import java.io.OutputStream;

/* loaded from: classes2.dex */
final class fr extends com.google.android.gms.internal.firebase-auth-api.dr {

    private final OutputStream h;
    fr(OutputStream outputStream, int i2) {
        super(i2);
        this.h = outputStream;
    }

    private final void N() {
        final int i2 = 0;
        this.h.write(this.d, i2, this.f);
        this.f = i2;
    }

    private final void O(int i) {
        if (i2 -= i4 < i) {
            N();
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void A(int i, int i2) {
        O(20);
        L(i <<= 3);
        L(i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void B(int i) {
        O(5);
        L(i);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void C(int i, long l2) {
        O(20);
        L(i <<= 3);
        M(l2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void D(long l) {
        O(10);
        M(l);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void P(byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        int i = this.f;
        obj5 -= i;
        final int i8 = 0;
        if (obj5 >= i3) {
            System.arraycopy(bArr, i8, this.d, i, i3);
            this.f = obj4 += i3;
            this.g = obj4 += i3;
        }
        System.arraycopy(bArr, i8, this.d, i, obj5);
        i3 -= obj5;
        this.f = this.e;
        this.g = i5 += obj5;
        N();
        if (obj6 <= this.e) {
            System.arraycopy(bArr, obj5, this.d, i8, obj6);
            this.f = obj6;
        } else {
            this.h.write(bArr, obj5, obj6);
        }
        this.g = obj4 += obj6;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void Q(String string) {
        int i2;
        int i;
        int i3;
        int i4;
        try {
            length *= 3;
            int i10 = gr.f(i5);
            int i12 = i10 + i5;
            int i16 = this.e;
            if (i12 > i16) {
            }
            byte[] bArr2 = new byte[i5];
            int i14 = 0;
            int i9 = o1.b(string, bArr2, i14, i5);
            B(i9);
            P(bArr2, i14, i9);
            if (i12 > i16 -= i6) {
            }
            N();
            i2 = gr.f(string.length());
            int i13 = this.f;
            if (i2 == i10) {
            } else {
            }
            int i11 = i13 + i2;
            this.f = i11;
            i = o1.b(string, this.d, i11, i19 -= i11);
            this.f = i13;
            L(i18 -= i2);
            this.f = i;
            i3 = o1.c(string);
            L(i3);
            this.f = o1.b(string, this.d, this.f, i3);
            this.g = i7 += i3;
            zzzc zzzc = new zzzc(th);
            throw zzzc;
            zzzc = this.g;
            int i15 = this.f;
            i15 -= obj2;
            zzzc -= i15;
            this.g = zzzc;
            this.f = obj2;
            throw th;
            k(string, th);
        } catch (com.google.android.gms.internal.firebase-auth-api.n1 e) {
        } catch (java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBounds1) {
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void a(byte[] bArr, int i2, int i3) {
        P(bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void m() {
        if (this.f > 0) {
            N();
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void n(byte b) {
        if (this.f == this.e) {
            N();
        }
        I(b);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void o(int i, boolean z2) {
        O(11);
        L(i <<= 3);
        I(z2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void p(int i, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        B(obj1 |= 2);
        B(wq2.g());
        wq2.q(this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void r(int i, int i2) {
        O(14);
        L(obj2 |= 5);
        J(i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void s(int i) {
        O(4);
        J(i);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void t(int i, long l2) {
        O(18);
        L(obj2 |= 1);
        K(l2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void u(long l) {
        O(8);
        K(l);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void v(int i, int i2) {
        O(20);
        L(i <<= 3);
        if (i2 >= 0) {
            L(i2);
        }
        M((long)i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void w(int i) {
        if (i >= 0) {
            B(i);
        }
        D((long)i);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    final void x(int i, com.google.android.gms.internal.firebase-auth-api.y y2, com.google.android.gms.internal.firebase-auth-api.l0 l03) {
        int i2;
        B(obj3 |= 2);
        Object obj3 = y2;
        if ((jq)obj3.a() == -1) {
            obj3.b(l03.d(obj3));
        }
        B(i2);
        l03.f(y2, this.a);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void y(int i, String string2) {
        B(obj1 |= 2);
        Q(string2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.dr
    public final void z(int i, int i2) {
        B(obj1 |= i2);
    }
}
