package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class e8 extends com.google.android.gms.internal.measurement.q7 {

    private static final Logger b;
    private static final boolean c;
    com.google.android.gms.internal.measurement.f8 a;
    static {
        e8.b = Logger.getLogger(e8.class.getName());
        e8.c = hb.C();
    }

    e8(com.google.android.gms.internal.measurement.c8 c8) {
        super();
    }

    public static int A(com.google.android.gms.internal.measurement.f9 f9) {
        final int obj1 = f9.a();
        return i += obj1;
    }

    static int B(com.google.android.gms.internal.measurement.y9 y9, com.google.android.gms.internal.measurement.ja ja2) {
        int i;
        if ((k7)y9.g() == -1) {
            y9.i(ja2.d(y9));
        }
        return obj2 += i;
    }

    public static int C(String string) {
        java.nio.charset.Charset charset;
        int obj1;
        try {
            obj1 = mb.c(string);
            string = string.getBytes(d9.a);
            string = string.length;
            return i += obj1;
        }
    }

    public static int D(int i) {
        return e8.a(i <<= 3);
    }

    public static int a(int i) {
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

    public static int b(long l) {
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

    public static com.google.android.gms.internal.measurement.e8 c(byte[] bArr) {
        d8 d8Var = new d8(bArr, 0, bArr.length);
        return d8Var;
    }

    static boolean f() {
        return e8.c;
    }

    public static int x(com.google.android.gms.internal.measurement.x7 x7) {
        final int obj1 = x7.g();
        return i += obj1;
    }

    @Deprecated
    static int y(int i, com.google.android.gms.internal.measurement.y9 y92, com.google.android.gms.internal.measurement.ja ja3) {
        int i2;
        int obj2 = e8.a(i <<= 3);
        if ((k7)y92.g() == -1) {
            y92.i(ja3.d(y92));
        }
        return obj2 += i2;
    }

    public static int z(int i) {
        if (i >= 0) {
            return e8.a(i);
        }
        return 10;
    }

    @Override // com.google.android.gms.internal.measurement.q7
    public final void d() {
        if (g() != 0) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Did not write as much data as expected.");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.internal.measurement.q7
    final void e(String string, com.google.android.gms.internal.measurement.lb lb2) {
        e8.b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", lb2);
        final byte[] obj7 = string.getBytes(d9.a);
        int obj8 = obj7.length;
        u(obj8);
        q(obj7, 0, obj8);
    }

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract int g();

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void h(byte b);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void i(int i, boolean z2);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void j(int i, com.google.android.gms.internal.measurement.x7 x72);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void k(int i, int i2);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void l(int i);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void m(int i, long l2);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void n(long l);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void o(int i, int i2);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void p(int i);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void q(byte[] bArr, int i2, int i3);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void r(int i, String string2);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void s(int i, int i2);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void t(int i, int i2);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void u(int i);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void v(int i, long l2);

    @Override // com.google.android.gms.internal.measurement.q7
    public abstract void w(long l);
}
