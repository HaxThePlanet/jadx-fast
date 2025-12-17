package com.google.android.gms.internal.firebase-auth-api;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class gr extends com.google.android.gms.internal.firebase-auth-api.pq {

    private static final Logger b;
    private static final boolean c;
    com.google.android.gms.internal.firebase-auth-api.hr a;
    static {
        gr.b = Logger.getLogger(gr.class.getName());
        gr.c = j1.C();
    }

    gr(com.google.android.gms.internal.firebase-auth-api.br br) {
        super();
    }

    public static int E(com.google.android.gms.internal.firebase-auth-api.wq wq) {
        final int obj1 = wq.g();
        return i += obj1;
    }

    @Deprecated
    static int F(int i, com.google.android.gms.internal.firebase-auth-api.y y2, com.google.android.gms.internal.firebase-auth-api.l0 l03) {
        int i2;
        int obj2 = gr.f(i <<= 3);
        if ((jq)y2.a() == -1) {
            y2.b(l03.d(y2));
        }
        return obj2 += i2;
    }

    public static int G(int i) {
        if (i >= 0) {
            return gr.f(i);
        }
        return 10;
    }

    public static int H(com.google.android.gms.internal.firebase-auth-api.g g) {
        final int obj1 = g.a();
        return i += obj1;
    }

    static int b(com.google.android.gms.internal.firebase-auth-api.y y, com.google.android.gms.internal.firebase-auth-api.l0 l02) {
        int i;
        if ((jq)y.a() == -1) {
            y.b(l02.d(y));
        }
        return obj2 += i;
    }

    static int c(int i) {
        final int i2 = 4096;
        if (i > i2) {
            return i2;
        }
        return i;
    }

    public static int d(String string) {
        java.nio.charset.Charset charset;
        int obj1;
        try {
            obj1 = o1.c(string);
            string = string.getBytes(e.a);
            string = string.length;
            return i += obj1;
        }
    }

    public static int e(int i) {
        return gr.f(i <<= 3);
    }

    public static int f(int i) {
        if (i & -128 == 0) {
            return 1;
        }
        if (i & -16384 == 0) {
            return 2;
        }
        if (i4 &= i == 0) {
            return 3;
        }
        if (i &= i6 == 0) {
            return 4;
        }
        return 5;
    }

    public static int g(long l) {
        int i;
        int cmp;
        int obj6;
        final int i6 = 0;
        final int i5 = 1;
        if (Long.compare(i3, i6) == 0) {
            return i5;
        }
        if (Long.compare(l, i6) < 0) {
            return 10;
        }
        if (Long.compare(i7, i6) != 0) {
            l >>>= i4;
            i = 6;
        } else {
            i = 2;
        }
        if (Long.compare(i9, i6) != 0) {
            i += 2;
            obj6 >>>= cmp;
        }
        if (Long.compare(obj6, i6) != 0) {
            i += i5;
        }
        return i;
    }

    public static com.google.android.gms.internal.firebase-auth-api.gr h(byte[] bArr) {
        er erVar = new er(bArr, 0, bArr.length);
        return erVar;
    }

    public static com.google.android.gms.internal.firebase-auth-api.gr i(OutputStream outputStream, int i2) {
        fr frVar = new fr(outputStream, i2);
        return frVar;
    }

    static boolean l() {
        return gr.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void A(int i, int i2);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void B(int i);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void C(int i, long l2);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void D(long l);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public final void j() {
        if (q() != 0) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Did not write as much data as expected.");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    final void k(String string, com.google.android.gms.internal.firebase-auth-api.n1 n12) {
        gr.b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", n12);
        final byte[] obj7 = string.getBytes(e.a);
        int obj8 = obj7.length;
        B(obj8);
        a(obj7, 0, obj8);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void m();

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void n(byte b);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void o(int i, boolean z2);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void p(int i, com.google.android.gms.internal.firebase-auth-api.wq wq2);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract int q();

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void r(int i, int i2);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void s(int i);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void t(int i, long l2);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void u(long l);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void v(int i, int i2);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void w(int i);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    abstract void x(int i, com.google.android.gms.internal.firebase-auth-api.y y2, com.google.android.gms.internal.firebase-auth-api.l0 l03);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void y(int i, String string2);

    @Override // com.google.android.gms.internal.firebase-auth-api.pq
    public abstract void z(int i, int i2);
}
