package io.grpc.j1;

import com.google.common.base.n;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* loaded from: classes3.dex */
class s0 implements Closeable {

    private boolean A = false;
    private int B;
    private int C;
    private long D;
    private int E = 0;
    private int F = 0;
    private boolean G = true;
    private final io.grpc.j1.u a;
    private final CRC32 b;
    private final io.grpc.j1.s0.b c;
    private final byte[] v;
    private int w;
    private int x;
    private Inflater y;
    private io.grpc.j1.s0.c z;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            s0.a.a = iArr;
            iArr[s0.c.HEADER.ordinal()] = 1;
            s0.a.a[s0.c.HEADER_EXTRA_LEN.ordinal()] = 2;
            s0.a.a[s0.c.HEADER_EXTRA.ordinal()] = 3;
            s0.a.a[s0.c.HEADER_NAME.ordinal()] = 4;
            s0.a.a[s0.c.HEADER_COMMENT.ordinal()] = 5;
            s0.a.a[s0.c.HEADER_CRC.ordinal()] = 6;
            s0.a.a[s0.c.INITIALIZE_INFLATER.ordinal()] = 7;
            s0.a.a[s0.c.INFLATING.ordinal()] = 8;
            s0.a.a[s0.c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            s0.a.a[s0.c.TRAILER.ordinal()] = 10;
        }
    }

    private class b {

        final io.grpc.j1.s0 a;
        private b(io.grpc.j1.s0 s0) {
            this.a = s0;
            super();
        }

        b(io.grpc.j1.s0 s0, io.grpc.j1.s0.a s0$a2) {
            super(s0);
        }

        static void a(io.grpc.j1.s0.b s0$b, int i2) {
            b.l(i2);
        }

        static boolean b(io.grpc.j1.s0.b s0$b) {
            return b.g();
        }

        static long c(io.grpc.j1.s0.b s0$b) {
            return b.i();
        }

        static int d(io.grpc.j1.s0.b s0$b) {
            return b.k();
        }

        static int e(io.grpc.j1.s0.b s0$b) {
            return b.j();
        }

        static int f(io.grpc.j1.s0.b s0$b) {
            return b.h();
        }

        private boolean g() {
            while (k() > 0) {
            }
            return 0;
        }

        private int h() {
            int unsignedByte;
            io.grpc.j1.s0 s0Var;
            int i4 = 1;
            if (i -= i3 > 0) {
                b &= 255;
                s0.e(this.a, i4);
            } else {
                unsignedByte = s0.i(this.a).readUnsignedByte();
            }
            s0.j(this.a).update(unsignedByte);
            s0.k(this.a, i4);
            return unsignedByte;
        }

        private long i() {
            return l |= i4;
        }

        private int j() {
            return i |= i4;
        }

        private int k() {
            return i2 += i5;
        }

        private void l(int i) {
            int i5;
            int i6;
            byte[] bArr;
            int i2;
            int i3;
            int i4;
            CRC32 crc32;
            i7 -= i6;
            if (i8 > 0) {
                int i9 = Math.min(i8, i);
                s0.j(this.a).update(s0.f(this.a), s0.c(this.a), i9);
                s0.e(this.a, i9);
                i5 = i - i9;
            } else {
                i5 = i;
            }
            if (i5 > 0) {
                i6 = 512;
                bArr = new byte[i6];
                i2 = 0;
                i3 = i2;
                while (i3 < i5) {
                    i4 = Math.min(i5 - i3, i6);
                    s0.i(this.a).O0(bArr, i2, i4);
                    s0.j(this.a).update(bArr, i2, i4);
                    i3 += i4;
                }
            }
            s0.k(this.a, i);
        }
    }

    private static enum c {

        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER;
    }
    s0() {
        super();
        u uVar = new u();
        this.a = uVar;
        CRC32 crc32 = new CRC32();
        this.b = crc32;
        s0.b bVar = new s0.b(this, 0);
        this.c = bVar;
        this.v = new byte[512];
        this.z = s0.c.HEADER;
        int i2 = 0;
        int i3 = 1;
    }

    private boolean E() {
        Inflater inflater2;
        io.grpc.j1.s0.c iNFLATER_NEEDS_INPUT;
        Inflater inflater;
        byte[] bArr;
        inflater2 = this.y;
        final int i3 = 1;
        if (inflater2 == null) {
            inflater2 = new Inflater(i3);
            this.y = inflater2;
        } else {
            inflater2.reset();
        }
        this.b.reset();
        final int i4 = this.w;
        i -= i4;
        if (i2 > 0) {
            this.y.setInput(this.v, i4, i2);
            this.z = s0.c.INFLATING;
        } else {
            this.z = s0.c.INFLATER_NEEDS_INPUT;
        }
        return i3;
    }

    private boolean H() {
        if (s0.b.d(this.c) < 10) {
            return 0;
        }
        if (s0.b.e(this.c) != 35615) {
        } else {
            if (s0.b.f(this.c) != 8) {
            } else {
                this.B = s0.b.f(this.c);
                s0.b.a(this.c, 6);
                this.z = s0.c.HEADER_EXTRA_LEN;
                return 1;
            }
            ZipException zipException = new ZipException("Unsupported compression method");
            throw zipException;
        }
        ZipException zipException2 = new ZipException("Not in GZIP format");
        throw zipException2;
    }

    private boolean J() {
        final int i4 = 16;
        final int i5 = 1;
        if (i &= i4 != i4) {
            this.z = s0.c.HEADER_CRC;
            return i5;
        }
        if (!s0.b.b(this.c)) {
            return 0;
        }
        this.z = s0.c.HEADER_CRC;
        return i5;
    }

    private boolean K() {
        int i7 = 2;
        final int i10 = 1;
        if (i &= i7 != i7) {
            this.z = s0.c.INITIALIZE_INFLATER;
            return i10;
        }
        if (s0.b.d(this.c) < i7) {
            return 0;
        }
        if (i5 &= i8 != s0.b.e(this.c)) {
        } else {
            this.z = s0.c.INITIALIZE_INFLATER;
            return i10;
        }
        ZipException zipException = new ZipException("Corrupt GZIP header");
        throw zipException;
    }

    private boolean L() {
        final int i4 = this.C;
        if (s0.b.d(this.c) < i4) {
            return 0;
        }
        s0.b.a(this.c, i4);
        this.z = s0.c.HEADER_NAME;
        return 1;
    }

    private boolean M() {
        int i6 = 4;
        final int i8 = 1;
        if (i &= i6 != i6) {
            this.z = s0.c.HEADER_NAME;
            return i8;
        }
        if (s0.b.d(this.c) < 2) {
            return 0;
        }
        this.C = s0.b.e(this.c);
        this.z = s0.c.HEADER_EXTRA;
        return i8;
    }

    private boolean T() {
        final int i4 = 8;
        final int i5 = 1;
        if (i &= i4 != i4) {
            this.z = s0.c.HEADER_COMMENT;
            return i5;
        }
        if (!s0.b.b(this.c)) {
            return 0;
        }
        this.z = s0.c.HEADER_COMMENT;
        return i5;
    }

    private boolean U() {
        Inflater inflater;
        int cmp;
        int i;
        long l;
        if (this.y != null && s0.b.d(this.c) <= 18) {
            if (s0.b.d(this.c) <= 18) {
                this.y.end();
                this.y = 0;
            }
        }
        if (s0.b.d(this.c) < 8) {
            return 0;
        }
        if (Long.compare(value, l) != 0) {
        } else {
            if (Long.compare(l2, l) != 0) {
            } else {
                this.b.reset();
                this.z = s0.c.HEADER;
                return 1;
            }
        }
        ZipException zipException = new ZipException("Corrupt GZIP trailer");
        throw zipException;
    }

    static int a(io.grpc.j1.s0 s0) {
        return s0.x;
    }

    static int c(io.grpc.j1.s0 s0) {
        return s0.w;
    }

    static int e(io.grpc.j1.s0 s0, int i2) {
        i += i2;
        s0.w = i3;
        return i3;
    }

    static byte[] f(io.grpc.j1.s0 s0) {
        return s0.v;
    }

    static io.grpc.j1.u i(io.grpc.j1.s0 s0) {
        return s0.a;
    }

    static CRC32 j(io.grpc.j1.s0 s0) {
        return s0.b;
    }

    static int k(io.grpc.j1.s0 s0, int i2) {
        i += i2;
        s0.E = i3;
        return i3;
    }

    private boolean n() {
        int i2;
        int i;
        final int i6 = 1;
        int i7 = 0;
        i2 = this.y != null ? i6 : i7;
        n.v(i2, "inflater is null");
        i = this.w == this.x ? i6 : i7;
        n.v(i, "inflaterInput has unconsumed bytes");
        int i5 = Math.min(this.a.g(), 512);
        if (i5 == 0) {
            return i7;
        }
        this.w = i7;
        this.x = i5;
        this.a.O0(this.v, i7, i5);
        this.y.setInput(this.v, this.w, i5);
        this.z = s0.c.INFLATING;
        return i6;
    }

    private int w(byte[] bArr, int i2, int i3) {
        int i;
        CRC32 crc32;
        boolean obj3;
        i = this.y != null ? 1 : 0;
        n.v(i, "inflater is null");
        final int obj5 = this.y.inflate(bArr, i2, i3);
        totalIn2 -= totalIn;
        this.E = i4 += i10;
        this.F = i6 += i10;
        this.w = i8 += i10;
        this.b.update(bArr, i2, obj5);
        if (this.y.finished()) {
            this.D = obj3 &= crc32;
            this.z = s0.c.TRAILER;
        } else {
            if (this.y.needsInput()) {
                this.z = s0.c.INFLATER_NEEDS_INPUT;
            }
        }
        return obj5;
    }

    @Override // java.io.Closeable
    boolean F() {
        n.v(z ^= 1, "GzipInflatingBuffer is closed");
        return this.G;
    }

    @Override // java.io.Closeable
    public void close() {
        boolean z;
        this.A = true;
        this.a.close();
        z = this.y;
        if (!this.A && z != null) {
            this.A = true;
            this.a.close();
            z = this.y;
            if (z != null) {
                z.end();
                this.y = 0;
            }
        }
    }

    @Override // java.io.Closeable
    void m(io.grpc.j1.v1 v1) {
        n.v(z ^= 1, "GzipInflatingBuffer is closed");
        this.a.c(v1);
        this.G = false;
    }

    @Override // java.io.Closeable
    int o() {
        this.E = 0;
        return this.E;
    }

    @Override // java.io.Closeable
    int q() {
        this.F = 0;
        return this.F;
    }

    @Override // java.io.Closeable
    boolean r() {
        int i2;
        int i;
        Object hEADER;
        n.v(z ^= i, "GzipInflatingBuffer is closed");
        if (s0.b.d(this.c) == 0) {
            if (this.z != s0.c.HEADER) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // java.io.Closeable
    int x(byte[] bArr, int i2, int i3) {
        int i;
        String str;
        int i5;
        int i4;
        io.grpc.j1.s0.c tRAILER;
        int ordinal;
        byte[] obj7;
        int obj8;
        i = 1;
        n.v(z ^= i, "GzipInflatingBuffer is closed");
        int i7 = 0;
        i4 = i7;
        while (/* condition */) {
            while (i5 != 0) {
                tRAILER = i3 - i4;
                i5 = U();
                i5 = n();
                i4 += i10;
                if (this.z != s0.c.TRAILER) {
                    break loop_2;
                } else {
                }
                i5 = U();
                i5 = E();
                i5 = K();
                i5 = J();
                i5 = T();
                i5 = L();
                i5 = M();
                i5 = H();
            }
            tRAILER = i3 - i4;
            i5 = U();
            i5 = n();
            i4 += i10;
            if (this.z == s0.c.TRAILER) {
            } else {
            }
            i5 = i;
            i5 = U();
            i5 = E();
            i5 = K();
            i5 = J();
            i5 = T();
            i5 = L();
            i5 = M();
            i5 = H();
        }
        if (i5 != 0) {
            if (this.z == s0.c.HEADER && s0.b.d(this.c) < 10) {
                if (s0.b.d(this.c) < 10) {
                } else {
                    i = i7;
                }
            } else {
            }
        }
        this.G = i;
        return i4;
    }
}
