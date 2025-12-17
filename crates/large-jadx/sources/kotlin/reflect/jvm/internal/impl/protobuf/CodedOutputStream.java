package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class CodedOutputStream {

    private final byte[] a;
    private final int b;
    private int c = 0;
    private int d = 0;
    private final OutputStream e;

    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }
    private CodedOutputStream(OutputStream outputStream, byte[] b2Arr2) {
        super();
        final int i = 0;
        this.e = outputStream;
        this.a = b2Arr2;
        this.b = b2Arr2.length;
    }

    public static int A(int i, long l2) {
        return obj0 += obj1;
    }

    public static int B(long l) {
        return CodedOutputStream.w(CodedOutputStream.H(l));
    }

    public static int C(String string) {
        try {
            byte[] obj2 = string.getBytes("UTF-8");
            return i += obj2;
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported.", string);
            throw runtimeException;
        }
    }

    public static int D(int i) {
        return CodedOutputStream.v(w.c(i, 0));
    }

    public static int E(int i) {
        return CodedOutputStream.v(i);
    }

    public static int F(long l) {
        return CodedOutputStream.w(l);
    }

    public static int G(int i) {
        return obj1 ^= i2;
    }

    public static long H(long l) {
        return obj3 ^= i2;
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream J(OutputStream outputStream, int i2) {
        CodedOutputStream codedOutputStream = new CodedOutputStream(outputStream, new byte[i2]);
        return codedOutputStream;
    }

    private void K() {
        OutputStream outputStream = this.e;
        if (outputStream == null) {
        } else {
            final int i2 = 0;
            outputStream.write(this.a, i2, this.c);
            this.c = i2;
        }
        CodedOutputStream.OutOfSpaceException outOfSpaceException = new CodedOutputStream.OutOfSpaceException();
        throw outOfSpaceException;
    }

    public static int a(int i, boolean z2) {
        return obj0 += obj1;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int c(byte[] bArr) {
        return i += obj1;
    }

    public static int d(int i, kotlin.reflect.jvm.internal.impl.protobuf.d d2) {
        return obj0 += obj1;
    }

    public static int e(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
        return i += obj1;
    }

    public static int f(int i, double d2) {
        return obj0 += obj1;
    }

    public static int g(double d) {
        return 8;
    }

    public static int h(int i, int i2) {
        return obj0 += obj1;
    }

    public static int i(int i) {
        return CodedOutputStream.p(i);
    }

    public static int j(int i) {
        return 4;
    }

    public static int k(long l) {
        return 8;
    }

    public static int l(int i, float f2) {
        return obj0 += obj1;
    }

    public static int m(float f) {
        return 4;
    }

    public static int n(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        return o.getSerializedSize();
    }

    public static int o(int i, int i2) {
        return obj0 += obj1;
    }

    public static int p(int i) {
        if (i >= 0) {
            return CodedOutputStream.v(i);
        }
        return 10;
    }

    public static int q(long l) {
        return CodedOutputStream.w(l);
    }

    public static int r(kotlin.reflect.jvm.internal.impl.protobuf.k k) {
        final int obj1 = k.b();
        return i += obj1;
    }

    public static int s(int i, kotlin.reflect.jvm.internal.impl.protobuf.o o2) {
        return obj0 += obj1;
    }

    public static int t(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        final int obj1 = o.getSerializedSize();
        return i += obj1;
    }

    static int u(int i) {
        final int i2 = 4096;
        if (i > i2) {
            return i2;
        }
        return i;
    }

    public static int v(int i) {
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

    public static int w(long l) {
        final int i13 = 0;
        if (Long.compare(i2, i13) == 0) {
            return 1;
        }
        if (Long.compare(i4, i13) == 0) {
            return 2;
        }
        if (Long.compare(i6, i13) == 0) {
            return 3;
        }
        if (Long.compare(i8, i13) == 0) {
            return 4;
        }
        if (Long.compare(i9, i13) == 0) {
            return 5;
        }
        if (Long.compare(i10, i13) == 0) {
            return 6;
        }
        if (Long.compare(i11, i13) == 0) {
            return 7;
        }
        if (Long.compare(i12, i13) == 0) {
            return 8;
        }
        if (Long.compare(obj4, i13) == 0) {
            return 9;
        }
        return 10;
    }

    public static int x(int i) {
        return 4;
    }

    public static int y(long l) {
        return 8;
    }

    public static int z(int i) {
        return CodedOutputStream.v(CodedOutputStream.G(i));
    }

    public void I() {
        if (this.e != null) {
            K();
        }
    }

    public void L(int i, boolean z2) {
        w0(i, 0);
        M(z2);
    }

    public void M(boolean z) {
        h0(z);
    }

    public void N(byte[] bArr) {
        o0(bArr.length);
        k0(bArr);
    }

    public void O(int i, kotlin.reflect.jvm.internal.impl.protobuf.d d2) {
        w0(i, 2);
        P(d2);
    }

    public void P(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
        o0(d.size());
        i0(d);
    }

    public void Q(int i, double d2) {
        w0(i, 1);
        R(d2);
    }

    public void R(double d) {
        n0(Double.doubleToRawLongBits(d));
    }

    public void S(int i, int i2) {
        w0(i, 0);
        T(i2);
    }

    public void T(int i) {
        b0(i);
    }

    public void U(int i) {
        m0(i);
    }

    public void V(long l) {
        n0(l);
    }

    public void W(int i, float f2) {
        w0(i, 5);
        X(f2);
    }

    public void X(float f) {
        m0(Float.floatToRawIntBits(f));
    }

    public void Y(int i, kotlin.reflect.jvm.internal.impl.protobuf.o o2) {
        w0(i, 3);
        Z(o2);
        w0(i, 4);
    }

    public void Z(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        o.a(this);
    }

    public void a0(int i, int i2) {
        w0(i, 0);
        b0(i2);
    }

    public void b0(int i) {
        long l;
        if (i >= 0) {
            o0(i);
        } else {
            p0((long)i);
        }
    }

    public void c0(long l) {
        p0(l);
    }

    public void d0(int i, kotlin.reflect.jvm.internal.impl.protobuf.o o2) {
        w0(i, 2);
        e0(o2);
    }

    public void e0(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        o0(o.getSerializedSize());
        o.a(this);
    }

    public void f0(int i, kotlin.reflect.jvm.internal.impl.protobuf.o o2) {
        final int i2 = 1;
        final int i3 = 3;
        w0(i2, i3);
        x0(2, i);
        d0(i3, o2);
        w0(i2, 4);
    }

    public void g0(byte b) {
        if (this.c == this.b) {
            K();
        }
        int i3 = this.c;
        this.c = i3 + 1;
        this.a[i3] = b;
        this.d = obj4++;
    }

    public void h0(int i) {
        g0((byte)i);
    }

    public void i0(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
        j0(d, 0, d.size());
    }

    public void j0(kotlin.reflect.jvm.internal.impl.protobuf.d d, int i2, int i3) {
        byte[] bArr;
        int i;
        int i4;
        int obj4;
        int obj5;
        int obj6;
        int i5 = this.b;
        i = this.c;
        if (i5 - i >= i3) {
            d.m(this.a, i2, i, i3);
            this.c = obj4 += i3;
            this.d = obj4 += i3;
        } else {
            i5 -= i;
            d.m(this.a, i2, i, i6);
            i2 += i6;
            i3 -= i6;
            this.c = this.b;
            this.d = i9 += i6;
            K();
            if (obj6 <= this.b) {
                d.m(this.a, obj5, 0, obj6);
                this.c = obj6;
            } else {
                d.E(this.e, obj5, obj6);
            }
            this.d = obj4 += obj6;
        }
    }

    public void k0(byte[] bArr) {
        l0(bArr, 0, bArr.length);
    }

    public void l0(byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        int i4;
        int i;
        int obj4;
        int obj5;
        int obj6;
        int i5 = this.b;
        i4 = this.c;
        if (i5 - i4 >= i3) {
            System.arraycopy(bArr, i2, this.a, i4, i3);
            this.c = obj4 += i3;
            this.d = obj4 += i3;
        } else {
            i5 -= i4;
            System.arraycopy(bArr, i2, this.a, i4, i6);
            i2 += i6;
            i3 -= i6;
            this.c = this.b;
            this.d = i9 += i6;
            K();
            if (obj6 <= this.b) {
                System.arraycopy(bArr, obj5, this.a, 0, obj6);
                this.c = obj6;
            } else {
                this.e.write(bArr, obj5, obj6);
            }
            this.d = obj4 += obj6;
        }
    }

    public void m0(int i) {
        h0(i & 255);
        h0(i3 &= 255);
        h0(i5 &= 255);
        h0(obj2 &= 255);
    }

    public void n0(long l) {
        h0(i &= 255);
        h0(i5 &= 255);
        h0(i9 &= 255);
        h0(i13 &= 255);
        h0(i17 &= 255);
        h0(i21 &= 255);
        h0(i25 &= 255);
        h0(obj3 &= 255);
    }

    public void o0(int i) {
        while (i & -128 == 0) {
            h0(i3 |= 128);
            i >>>= 7;
        }
        h0(i);
    }

    public void p0(long l) {
        while (Long.compare(i2, i7) == 0) {
            h0(i4 |= 128);
            l >>>= i6;
        }
        h0((int)l);
    }

    public void q0(int i) {
        m0(i);
    }

    public void r0(long l) {
        n0(l);
    }

    public void s0(int i) {
        o0(CodedOutputStream.G(i));
    }

    public void t0(int i, long l2) {
        w0(i, 0);
        u0(l2);
    }

    public void u0(long l) {
        p0(CodedOutputStream.H(l));
    }

    public void v0(String string) {
        final byte[] obj2 = string.getBytes("UTF-8");
        o0(obj2.length);
        k0(obj2);
    }

    public void w0(int i, int i2) {
        o0(w.c(i, i2));
    }

    public void x0(int i, int i2) {
        w0(i, 0);
        y0(i2);
    }

    public void y0(int i) {
        o0(i);
    }

    public void z0(long l) {
        p0(l);
    }
}
