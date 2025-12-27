package io.grpc.j1;

import android.app.ActivityManager.MemoryInfo;
import com.google.common.base.n;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* compiled from: GzipInflatingBuffer.java */
/* loaded from: classes3.dex */
class s0 implements Closeable {

    private boolean A = false;
    private int B;
    private int C;
    private long D;
    private int E = 0;
    private int F = 0;
    private boolean G = true;
    private final u a = new u();
    private final CRC32 b = new CRC32();
    private final s0.b c = new s0$b();
    private final byte[] v;
    private int w;
    private int x;
    private Inflater y;
    private s0.c z;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[s0.c.values().length];
            s0.a.a = iArr;
            try {
                iArr[s0.c.HEADER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.HEADER_EXTRA.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.HEADER_NAME.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.HEADER_COMMENT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.HEADER_CRC.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.INFLATING.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s0.a.a[s0.c.TRAILER.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private class b {

        final /* synthetic */ s0 a;
        private b() {
            this.a = s0Var;
            super();
        }

        static /* synthetic */ void a(s0.b bVar, int i) {
            bVar.l(i);
        }

        static /* synthetic */ boolean b(s0.b bVar) {
            return bVar.g();
        }

        static /* synthetic */ long c(s0.b bVar) {
            return bVar.i();
        }

        static /* synthetic */ int d(s0.b bVar) {
            return bVar.k();
        }

        static /* synthetic */ int e(s0.b bVar) {
            return bVar.j();
        }

        static /* synthetic */ int f(s0.b bVar) {
            return bVar.h();
        }

        private boolean g() {
            while (k() > 0) {
                if (h() == 0) {
                    return true;
                }
            }
            return false;
        }

        private int h() {
            int unsignedByte;
            int i4 = 1;
            if (this.a.x - this.a.w > 0) {
                unsignedByte = this.a.v[this.a.w] & 255;
                s0.e(this.a, i4);
            } else {
                unsignedByte = this.a.a.readUnsignedByte();
            }
            this.a.b.update(unsignedByte);
            s0.k(this.a, i4);
            return unsignedByte;
        }

        private long i() {
            return (long)j() | (long)j() << 16L;
        }

        private int j() {
            return h() | (h() << 8);
        }

        private int k() {
            return (this.a.x - this.a.w) + this.a.a.g();
        }

        private void l(int i) {
            int i2;
            int i3;
            byte[] bArr;
            int i4;
            int min;
            CRC32 crc32;
            int i6 = this.a.x - this.a.w;
            if (this.a > 0) {
                int min2 = Math.min(i6, i);
                this.a.b.update(this.a.v, this.a.w, min2);
                s0.e(this.a, min2);
                i2 = i - min2;
            } else {
                i2 = i;
            }
            if (this.a > 0) {
                i3 = 512;
                bArr = new byte[i3];
                i4 = 0;
                while (i4 < this.a) {
                    min = Math.min(i2 - i4, i3);
                    this.a.a.O0(bArr, i4, min);
                    this.a.b.update(bArr, i4, min);
                    i4 = i4 + min;
                }
            }
            s0.k(this.a, i);
        }

        /* synthetic */ b(s0.a aVar) {
            this(s0Var);
        }
    }

    private enum c {

        HEADER,
        HEADER_COMMENT,
        HEADER_CRC,
        HEADER_EXTRA,
        HEADER_EXTRA_LEN,
        HEADER_NAME,
        INFLATER_NEEDS_INPUT,
        INFLATING,
        INITIALIZE_INFLATER,
        TRAILER;
    }
    s0() {
        super();
        io.grpc.j1.u uVar = new u();
        CRC32 crc32 = new CRC32();
        io.grpc.j1.s0.b bVar = new s0.b(this, null);
        this.v = new byte[512];
        this.z = s0.c.HEADER;
    }

    private boolean E() {
        final boolean z = true;
        if (this.y == null) {
            this.y = new Inflater(z);
        } else {
            this.y.reset();
        }
        this.b.reset();
        int i2 = this.x - i3;
        if (this.b > 0) {
            this.y.setInput(this.v, this.w, i2);
            this.z = s0.c.INFLATING;
        } else {
            this.z = s0.c.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    private boolean H() throws ZipException {
        if (this.c.k() < 10) {
            return false;
        }
        if (this.c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        } else {
            if (this.c.h() != 8) {
                throw new ZipException("Unsupported compression method");
            } else {
                this.B = this.c.h();
                this.c.l(6);
                this.z = s0.c.HEADER_EXTRA_LEN;
                return true;
            }
        }
    }

    private boolean J() {
        final int i4 = 16;
        final boolean z2 = true;
        if ((this.B & i4) != i4) {
            this.z = s0.c.HEADER_CRC;
            return true;
        }
        if (!this.c.g()) {
            return false;
        }
        this.z = s0.c.HEADER_CRC;
        return true;
    }

    private boolean K() throws ZipException {
        int i7 = 2;
        final boolean z = true;
        if ((this.B & i7) != i7) {
            this.z = s0.c.INITIALIZE_INFLATER;
            return true;
        }
        if (this.c.k() < i7) {
            return false;
        }
        if (((int)this.b.getValue() & 65535) != this.c.j()) {
            throw new ZipException("Corrupt GZIP header");
        } else {
            this.z = s0.c.INITIALIZE_INFLATER;
            return true;
        }
    }

    private boolean L() {
        if (this.c.k() < this.C) {
            return false;
        }
        this.c.l(this.C);
        this.z = s0.c.HEADER_NAME;
        return true;
    }

    private boolean M() {
        int i6 = 4;
        final boolean z = true;
        if ((this.B & i6) != i6) {
            this.z = s0.c.HEADER_NAME;
            return true;
        }
        if (this.c.k() < 2) {
            return false;
        }
        this.C = this.c.j();
        this.z = s0.c.HEADER_EXTRA;
        return true;
    }

    private boolean T() {
        final int i4 = 8;
        final boolean z2 = true;
        if ((this.B & i4) != i4) {
            this.z = s0.c.HEADER_COMMENT;
            return true;
        }
        if (!this.c.g()) {
            return false;
        }
        this.z = s0.c.HEADER_COMMENT;
        return true;
    }

    private boolean U() throws ZipException {
        if (this.y != null) {
            int i = 18;
            if (this.c.k() <= 18) {
                this.y.end();
                Inflater inflater = null;
                this.y = inflater;
            }
        }
        if (this.c.k() < 8) {
            return false;
        }
        long value = this.b.getValue();
        long l = this.c.i();
        if (value != l) {
            throw new ZipException("Corrupt GZIP trailer");
        } else {
            l = this.c.i();
            if (this.D == l) {
                this.b.reset();
                this.z = s0.c.HEADER;
                return true;
            }
        }
    }

    static /* synthetic */ int a(s0 s0Var) {
        return s0Var.x;
    }

    static /* synthetic */ int c(s0 s0Var) {
        return s0Var.w;
    }

    static /* synthetic */ int e(s0 s0Var, int i) {
        s0Var.w += i;
        return i3;
    }

    static /* synthetic */ byte[] f(s0 s0Var) {
        return s0Var.v;
    }

    static /* synthetic */ u i(s0 s0Var) {
        return s0Var.a;
    }

    static /* synthetic */ CRC32 j(s0 s0Var) {
        return s0Var.b;
    }

    static /* synthetic */ int k(s0 s0Var, int i) {
        s0Var.E += i;
        return i3;
    }

    private boolean n() {
        boolean z;
        boolean z2;
        final int i2 = 1;
        int i = 0;
        int r0 = this.y != null ? i2 : i;
        n.v((this.y != null ? i2 : i), "inflater is null");
        r0 = this.w == this.x ? i2 : i;
        n.v((this.w == this.x ? i2 : i), "inflaterInput has unconsumed bytes");
        int min = Math.min((this.w == this.x ? i2 : i), 512);
        if (min == 0) {
            return false;
        }
        this.w = i;
        this.x = min;
        this.a.O0(this.v, i, min);
        this.y.setInput(this.v, this.w, min);
        this.z = s0.c.INFLATING;
        return true;
    }

    private int w(byte[] bArr, int i, int i2) {
        boolean z = false;
        String str = this.y != null ? 1 : 0;
        n.v((this.y != null ? 1 : 0), "inflater is null");
        try {
            final int inflate = this.y.inflate(bArr, i, i2);
            int i11 = this.y.getTotalIn() - this.y.getTotalIn();
            this.E += i11;
            this.F += i11;
            this.w += i11;
            this.b.update(bArr, i, inflate);
            if (this.y.finished()) {
                this.D = this.y.getBytesWritten() & 4294967295L;
                this.z = s0.c.TRAILER;
            } else {
                if (this.y.needsInput()) {
                    this.z = s0.c.INFLATER_NEEDS_INPUT;
                }
            }
        } catch (java.util.zip.DataFormatException dataFormat) {
            i2 = new StringBuilder();
            i2.append((this.y != null ? 1 : 0));
            dataFormat = dataFormat.getMessage();
            i2.append(dataFormat);
            dataFormat = i2.toString();
            i = new DataFormatException(dataFormat);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
        return inflate;
    }

    boolean F() {
        n.v(!this.A, "GzipInflatingBuffer is closed");
        return this.G;
    }

    @Override // java.io.Closeable
    public void close() {
        if (!this.A) {
            this.A = true;
            this.a.close();
            if (this.y != null) {
                this.y.end();
                this.y = null;
            }
        }
    }

    void m(v1 v1Var) {
        n.v(!this.A, "GzipInflatingBuffer is closed");
        this.a.c(v1Var);
        this.G = false;
    }

    int o() {
        this.E = 0;
        return this.E;
    }

    int q() {
        this.F = 0;
        return this.F;
    }

    boolean r() {
        boolean z2 = true;
        str = "GzipInflatingBuffer is closed";
        n.v(this.A ^ 1, str);
        if (this.c.k() == 0) {
            if (this.z == s0.c.HEADER) {
                int i4 = 0;
            }
        }
        return z2;
    }

    int x(byte[] bArr, int i, int i2) {
        io.grpc.j1.s0.c tRAILER2;
        int ordinal;
        io.grpc.j1.s0.c cVar;
        io.grpc.j1.s0.c hEADER2;
        i = 1;
        str = "GzipInflatingBuffer is closed";
        n.v(this.A ^ i, str);
        i = 0;
        while (/* condition */) {
            while (i != 0) {
                int i8 = i2 - i;
                boolean z4 = U();
                boolean z7 = n();
                i = i + (w(bArr, i + i, i8));
                if (this.z != s0.c.TRAILER) {
                    break loop_2;
                }
                boolean z8 = E();
                boolean z2 = K();
                boolean z5 = J();
                boolean z9 = T();
                boolean z3 = L();
                boolean z6 = M();
                boolean z10 = H();
            }
            i8 = i2 - i;
            z4 = U();
            z7 = n();
            i = i + (this.w(bArr, i + i, s0.c.TRAILER));
            z8 = E();
            z2 = K();
            z5 = J();
            z9 = T();
            z3 = L();
            z6 = M();
            z10 = H();
        }
        if (this.z != 0) {
            if (this.z == s0.c.HEADER) {
                if (this.c.k() >= 10) {
                }
            }
        }
        this.G = i;
        return i;
    }
}
