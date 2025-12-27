package l;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.d0.d.n;
import kotlin.k0.d;
import kotlin.y.i;
import l.g0.a;

/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class f implements h, g, java.lang.Cloneable, ByteChannel {

    public y a;
    private long b;

    public static final class a implements Closeable {

        public f a;
        public boolean b;
        private y c;
        public long v = -1;
        public byte[] w;
        public int x = -1;
        public int y = -1;
        public a() {
            super();
        }

        public final y a() {
            return this.c;
        }

        public final int c() {
            int i = 0;
            long l = 0;
            n.d(this.a);
            long size = this.a.size();
            int r0 = this.v != size ? 1 : 0;
            if (this.v == 0) {
                throw new IllegalStateException("no more bytes".toString());
            } else {
                if (this.v == -1) {
                    int i4 = 0;
                } else {
                    l2 = (long)(this.y - this.x);
                    l = l4 + l2;
                }
                return f(l);
            }
        }

        @Override // java.io.Closeable
        public void close() {
            int i = 1;
            int r0 = this.a != null ? 1 : 0;
            if (this.a == 0) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else {
                l.f fVar2 = null;
                this.a = fVar2;
                i(fVar2);
                this.v = -1L;
                this.w = fVar2;
                int i2 = -1;
                this.x = i2;
                this.y = i2;
                return;
            }
        }

        public final long e(long j) {
            long l;
            int cmp;
            long min;
            l.y yVar;
            long l2;
            long l3;
            int cmp3;
            int i;
            final Object j3 = this;
            long j2 = j;
            if (j3.a == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else {
                if (!j3.b) {
                    throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
                } else {
                    long size = j3.a.size();
                    cmp = 1;
                    final long l4 = 0L;
                    if (j2 <= size) {
                        int r7 = j2 >= l4 ? cmp : 0;
                        if (cmp == 0) {
                            StringBuilder stringBuilder = new StringBuilder();
                            String str4 = "newSize < 0: ";
                            str = str4 + j2;
                            throw new IllegalArgumentException(str.toString());
                        } else {
                            l = size - j2;
                            while (l > l4) {
                                n.d(fVar.a);
                                n.d(yVar4.g);
                                l3 = (long)(i5 - yVar5.b);
                                if (yVar5.b > l) {
                                    yVar5.c -= i2;
                                }
                            }
                            l.y yVar3 = null;
                            j3.i(yVar3);
                            j3.v = j2;
                            j3.w = yVar3;
                            cmp = -1;
                            j3.x = cmp;
                            j3.y = cmp;
                            j3.a.T(j2);
                            return size;
                        }
                    }
                    if (j2 > size) {
                        l2 = j2 - size;
                        while (yVar5.c > l4) {
                            l.y yVar2 = j3.a.Y(cmp);
                            min = Math.min(l2, (long)(yVar2.c - 8192));
                            cmp3 = (int)min;
                            yVar2.c += cmp3;
                            l2 = l2 - min;
                        }
                    }
                }
            }
        }

        public final int f(long j) {
            long size = 0;
            int i = -1;
            int cmp3;
            boolean z;
            int i2;
            l.y cmp;
            int cmp4;
            int cmp5;
            if (this.a == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else {
                i = -1;
                long l2 = (long)i;
                if (j < l2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "offset=";
                    String str2 = " > size=";
                    long size4 = this.a.size();
                    j = str + j + str2 + size4;
                    throw new ArrayIndexOutOfBoundsException(j);
                } else {
                    long size2 = this.a.size();
                    if (j <= size2) {
                        if (j != -1) {
                            long size3 = this.a.size();
                            if (j == size3) {
                                l.y yVar = null;
                                i(yVar);
                                this.v = j;
                                this.w = yVar;
                                this.x = i;
                                this.y = i;
                            } else {
                                int i7 = 0;
                                size = this.a.size();
                                if (a() == null) {
                                } else {
                                    l.y yVar5 = a();
                                    n.d(yVar5);
                                    size = this.v - (long)(this.x - yVar5.b);
                                    if (this.v > j) {
                                    } else {
                                    }
                                }
                                long l4 = size - j;
                                l = j - size;
                                if (l4 > yVar5.b) {
                                    n.d(cmp);
                                    cmp4 = (long)(i11 - i2) + size;
                                    while (j >= cmp4) {
                                        size = (long)(i11 - i2);
                                        size = size + size;
                                        n.d(cmp);
                                        cmp4 = (long)i11 - i2 + size;
                                    }
                                } else {
                                    while (cmp.c > j) {
                                        n.d(cmp);
                                        n.d(cmp.g);
                                        size = (long)(cmp.c - cmp.b);
                                        size = size - size;
                                    }
                                }
                                if (this.b && cmp.d) {
                                    cmp = cmp.f();
                                    if (fVar.a == this.v) {
                                        this.a.a = cmp;
                                    }
                                    cmp.c(cmp);
                                    n.d(cmp.g);
                                    cmp.g.b();
                                }
                                i(cmp);
                                this.v = j;
                                n.d(cmp);
                                this.w = cmp.a;
                                int i6 = cmp.b + (int)(j - size);
                                this.x = i6;
                                this.y = cmp.c;
                                i = i4 - i6;
                            }
                        }
                        return i;
                    }
                }
            }
        }

        public final void i(y yVar) {
            this.c = yVar;
        }
    }

    public static final class b extends InputStream {

        final /* synthetic */ f a;
        b() {
            this.a = fVar;
            super();
        }

        @Override // java.io.InputStream
        public int available() {
            return (int)(Math.min(this.a.size(), (long)(0x7fffffff /* Unknown resource */)));
        }

        @Override // java.io.InputStream
        public int read() {
            int i = -1;
            long size = this.a.size();
            if (size > 0) {
                i = this.a.readByte() & 255;
            } else {
                i = -1;
            }
            return i;
        }

        @Override // java.io.InputStream
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".inputStream()";
            str = this.a + str2;
            return str;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            n.f(bArr, "sink");
            return this.a.read(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public void close() {
        }
    }

    public static final class c extends OutputStream {

        final /* synthetic */ f a;
        c() {
            this.a = fVar;
            super();
        }

        @Override // java.io.OutputStream
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".outputStream()";
            str = this.a + str2;
            return str;
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.a.z0(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            n.f(bArr, "data");
            this.a.v0(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void close() {
        }

        @Override // java.io.OutputStream
        public void flush() {
        }
    }
    public f A0(long j) {
        int cmp2 = 15;
        long l2 = 100000000000000L;
        int i;
        byte b;
        byte[] bArr2;
        int i2;
        long l = 0L;
        if (j == l) {
            z0(48);
        } else {
            cmp2 = 0;
            cmp2 = 1;
            if (j < l) {
                i2 = -j;
                if (i2 < l) {
                    str = "-9223372036854775808";
                    b1(str);
                } else {
                    cmp2 = 10;
                    if (i2 < 100000000) {
                        if (i2 < 10000) {
                            if (i2 >= 100) {
                                l2 = 1000L;
                                int r2 = i2 < l2 ? 3 : 4;
                                cmp2 = (i2 < l2 ? 3 : 4);
                            } else {
                                l2 = 10L;
                                if (i2 >= l2) {
                                    cmp2 = 2;
                                }
                            }
                        }
                    }
                    if (cmp2 != 0) {
                        cmp2 = cmp2 + 1;
                    }
                    l.y yVar = Y(cmp2);
                    i = yVar.c + cmp2;
                    while (i2 != l) {
                        l3 = (long)cmp2;
                        i = i - 1;
                        yVar.a[i] = a.b()[(int)(i2 % l3)];
                        i2 = i2 / l3;
                    }
                    if (cmp2 != 0) {
                        i = i - 1;
                        yVar.a[i] = (byte)45;
                    }
                    yVar.c += cmp2;
                    l = (long)cmp2;
                    T(size() + l);
                }
            }
        }
        return this;
    }

    public i B(long j) throws EOFException {
        int i = 0;
        l.i iVar;
        if (j >= 0) {
            long l = (long)(0x7fffffff /* Unknown resource */);
            int r0 = j <= l ? 1 : 0;
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "byteCount: ";
            str2 = str + j;
            throw new IllegalArgumentException(str2.toString());
        } else {
            long size = size();
            if (size < j) {
                throw new EOFException();
            } else {
                long l2 = (long)4096;
                if (j >= l2) {
                    iVar = V((int)j);
                    skip(j);
                } else {
                    iVar = new i(p1(j));
                }
                return iVar;
            }
        }
    }

    public f C0(long j) {
        int i5;
        int i6 = 32;
        long l3;
        if (j == 0) {
            int i7 = 48;
            z0(i7);
        } else {
            int i = 1;
            long l5 = (j >>> i) | j;
            int i10 = 2;
            long l6 = l5 | (l5 >>> i10);
            int i3 = 4;
            long l7 = l6 | (l6 >>> i3);
            int i11 = 8;
            long l8 = l7 | (l7 >>> i11);
            int i12 = 16;
            long l9 = l8 | (l8 >>> i12);
            i6 = 32;
            long l10 = l9 | (l9 >>> i6);
            long l11 = l10 - (l10 >>> i) & 6148914691236517205L;
            long l2 = 3689348814741910323L;
            long l34 = (l11 >>> i10) & l2 + (l11 & l2);
            long l15 = (l34 >>> i3) + l34 & 1085102592571150095L;
            long l16 = l15 + (l15 >>> i11);
            long l17 = l16 + (l16 >>> i12);
            long l25 = 63L;
            l = (l17 & l25) + (l17 >>> i6) & l25 + (long)3 / (long)i3;
            i2 = (int)l;
            l.y yVar = Y(i2);
            i5 = (i4 + i2) - i;
            while (i5 >= yVar.c) {
                i6 = (int)(15L & l3);
                yVar.a[i5] = a.b()[i6];
                l3 = l3 >>> i3;
                i5 = i5 - 1;
            }
            yVar.c += i2;
            T(size() + l);
        }
        return this;
    }

    public final f.a E(f.a aVar) {
        n.f(aVar, "unsafeCursor");
        a.a(this, aVar);
        return aVar;
    }

    public f G0(int i) {
        l.y yVar = Y(4);
        int i7 = i3 + 1;
        yVar.a[yVar.c] = (byte)(i >>> 24) & 255;
        int i4 = i7 + 1;
        yVar.a[i7] = (byte)(i >>> 16) & 255;
        int i8 = i4 + 1;
        yVar.a[i4] = (byte)(i >>> 8) & 255;
        yVar.a[i8] = (byte)(i & 255);
        yVar.c = i8 + 1;
        T(size() + 4L);
        return this;
    }

    public int H() {
        return c.c(readInt());
    }

    public f I0(long j) {
        int i = 8;
        final l.y yVar = Y(i);
        int i9 = i5 + 1;
        final long l15 = 255L;
        yVar.a[yVar.c] = (byte)(int)(j >>> 56L) & l15;
        int i6 = i9 + 1;
        yVar.a[i9] = (byte)(int)(j >>> 48L) & l15;
        int i10 = i6 + 1;
        yVar.a[i6] = (byte)(int)(j >>> 40L) & l15;
        int i7 = i10 + 1;
        yVar.a[i10] = (byte)(int)(j >>> 32L) & l15;
        int i11 = i7 + 1;
        yVar.a[i7] = (byte)(int)(j >>> 24L) & l15;
        int i8 = i11 + 1;
        yVar.a[i11] = (byte)(int)(j >>> 16L) & l15;
        int i12 = i8 + 1;
        yVar.a[i8] = (byte)(int)(j >>> i) & l15;
        yVar.a[i12] = (byte)(int)(j & l15);
        yVar.c = i12 + 1;
        T(size() + 8L);
        return this;
    }

    public short J() {
        return c.d(readShort());
    }

    public long J1(b0 b0Var) {
        n.f(b0Var, "sink");
        long size = size();
        if (size > 0) {
            b0Var.write(this, size);
        }
        return size;
    }

    public String K(long j, Charset charset) throws EOFException, java.io.UnsupportedEncodingException {
        int i = 0;
        n.f(charset, "charset");
        if (j >= 0) {
            long l = (long)(0x7fffffff /* Unknown resource */);
            int r1 = j <= l ? 1 : 0;
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "byteCount: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            if (this.b < j) {
                throw new EOFException();
            } else {
                if (j == 0) {
                    return "";
                }
                n.d(this.a);
                long l6 = (long)i5 + j;
                long l7 = (long)yVar.c;
                if (l6 > yVar.c) {
                    return new String(p1(j), charset);
                }
                final int i6 = (int)j;
                yVar.b += i6;
                this.b -= j;
                if (yVar.b == yVar.c) {
                    this.a = this.a.b();
                    z.b(this.a);
                }
                return new String(yVar.a, i5, i6, charset);
            }
        }
    }

    public boolean K0(long j, i iVar) {
        n.f(iVar, "bytes");
        return this.x(j, iVar, 0, iVar.E());
    }

    public String L(long j) {
        return K(j, Charsets.a);
    }

    public f L0(int i) {
        l.y yVar = Y(2);
        final int i6 = i3 + 1;
        yVar.a[yVar.c] = (byte)(i >>> 8) & 255;
        yVar.a[i6] = (byte)(i & 255);
        yVar.c = i6 + 1;
        T(size() + 2L);
        return this;
    }

    public int M() throws EOFException {
        int i;
        int i2 = 1;
        int i3 = 2048;
        int cmp;
        int i4;
        long size = size();
        long l3 = 0L;
        if (size == l3) {
            throw new EOFException();
        } else {
            byte b = n(l3);
            i2 = 1;
            i3 = 128;
            i = 65533;
            if (b & 128 == 0) {
                i = b & 127;
                i3 = 0;
                long size3 = size();
                l2 = (long)i2;
                if (size3 < l2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "size < ";
                    String str3 = ": ";
                    long size2 = size();
                    String str4 = " (to read code point prefixed 0x";
                    String str = c.e(b);
                    r0 = str2 + i2 + str3 + size2 + str4 + str + 41;
                    throw new EOFException(r0);
                } else {
                    while (i2 < i2) {
                        cmp = (long)i2;
                        byte b2 = n(cmp);
                        i4 = b2 & 192;
                        if ((b2 & 192) != i3) {
                            skip(cmp);
                        }
                    }
                    skip(l2);
                    if (i <= 1114111) {
                        i2 = 55296;
                        if (55296 > i) {
                            if (i >= i3) {
                            }
                        }
                    }
                    return i;
                }
            } else {
                if ((b & 224) == 192) {
                    i = b & 31;
                    i2 = 2;
                } else {
                    if ((b & 240) == 224) {
                        i = b & 15;
                        i2 = 3;
                        i3 = 2048;
                    } else {
                        i = b & 248;
                        i2 = 240;
                        if (i == 240) {
                            i = b & 7;
                            i2 = 4;
                            i3 = 65536;
                        }
                    }
                }
            }
            long l = 1L;
            skip(l);
        }
    }

    public String M0(Charset charset) {
        n.f(charset, "charset");
        return K(this.b, charset);
    }

    public f Q0(String str, int i, int i2, Charset charset) throws java.io.UnsupportedEncodingException {
        n.f(str, "string");
        n.f(charset, "charset");
        i = 1;
        i = 0;
        int r2 = i;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str10 = "beginIndex < 0: ";
            str4 = str10 + i;
            throw new IllegalArgumentException(str4.toString());
        } else {
            r2 = i;
            if (i == 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str13 = "endIndex < beginIndex: ";
                String str11 = " < ";
                str5 = str13 + i2 + str11 + i;
                throw new IllegalArgumentException(str5.toString());
            } else {
                if (i2 > str.length()) {
                }
                if (i == 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str14 = "endIndex > string.length: ";
                    String str12 = " > ";
                    int length2 = str.length();
                    str6 = str14 + i2 + str12 + length2;
                    throw new IllegalArgumentException(str6.toString());
                } else {
                    if (n.b(charset, Charsets.a)) {
                        e1(str, i, i2);
                        return this;
                    }
                    String substring = str.substring(i, i2);
                    n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                    byte[] bytes = substring.getBytes(charset);
                    n.e(bytes, "(this as java.lang.String).getBytes(charset)");
                    v0(bytes, i, bytes.length);
                    return this;
                }
            }
        }
    }

    public final void T(long j) {
        this.b = j;
    }

    public final i U() {
        int i = 1;
        long size = size();
        long l = (long)(0x7fffffff /* Unknown resource */);
        int r0 = size <= l ? 1 : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "size > Int.MAX_VALUE: ";
            long size3 = size();
            str = str2 + size3;
            throw new IllegalStateException(str.toString());
        } else {
            return V((int)size());
        }
    }

    public final i V(int i) {
        l.y yVar;
        int i2 = 0;
        l.y yVar2;
        boolean z = true;
        int i4;
        l.a0 a0Var;
        if (i != 0) {
            l = (long)i;
            c.b(size(), 0L, l);
            i2 = 0;
            while (i2 < i) {
                n.d(yVar);
                if (yVar.c == yVar.b) {
                    throw new AssertionError("s.limit == s.pos");
                }
            }
            byte[][] bArr = new byte[i2];
            int[] iArr = new int[i2 * 2];
            while (i2 < i) {
                n.d(yVar2);
                bArr[i2] = yVar2.a;
                i2 = i2 + (yVar2.c - yVar2.b);
                iArr[i2] = Math.min(i2, i);
                iArr[i2 + i2] = yVar2.b;
                z = true;
                yVar2.d = z;
                i2 = i2 + z;
            }
            a0Var = new a0(bArr, iArr);
        } else {
            l.i iVar = i.c;
        }
        return a0Var;
    }

    public f V0(String str, Charset charset) {
        n.f(str, "string");
        n.f(charset, "charset");
        Q0(str, 0, str.length(), charset);
        return this;
    }

    public void V1(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public long W0(d0 d0Var) {
        int i = 0;
        n.f(d0Var, "source");
        i = 0;
        long read = d0Var.read(this, (long)8192);
        while (read == -1) {
            i = i + read;
            read = d0Var.read(this, (long)8192);
        }
        return i;
    }

    public byte[] X() {
        return p1(size());
    }

    public final y Y(int i) {
        int i2 = 0;
        l.y yVar;
        int i4 = 8192;
        i2 = 1;
        if (i < 1 || i > i4) {
            i2 = 0;
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        } else {
            if (this.a == null) {
                yVar = z.c();
                this.a = yVar;
                yVar.g = yVar;
                yVar.f = yVar;
            } else {
                n.d(this.a);
                n.d(yVar.g);
                i3 = yVar.c + i;
                if (yVar.c + i > i4 || !yVar.e) {
                    yVar.g.c(z.c());
                }
            }
            return yVar;
        }
    }

    public i Y0() {
        return B(size());
    }

    public final void a() {
        skip(size());
    }

    public long a0(i iVar) {
        n.f(iVar, "bytes");
        return r(iVar, 0L);
    }

    public final f a1(OutputStream outputStream, long j) throws java.io.IOException {
        l.y yVar;
        long l3;
        n.f(outputStream, "out");
        long l2 = 0L;
        c.b(this.b, l2, j);
        while (l3 > 0) {
            n.d(yVar);
            long j22 = Math.min(l3, (long)(yVar.c - i7));
            int i5 = (int)j22;
            outputStream.write(yVar.a, yVar.b, i5);
            yVar.b += i5;
            this.b -= j22;
            l3 = l3 - j22;
        }
        return this;
    }

    public boolean b0() {
        boolean z = true;
        int r0 = this.b == 0 ? 1 : 0;
        return (this.b == 0 ? 1 : 0);
    }

    public f b1(String str) {
        n.f(str, "string");
        e1(str, 0, str.length());
        return this;
    }

    public OutputStream b2() {
        return new f.c(this);
    }

    public f c() {
        return f();
    }

    public long d2() throws EOFException {
        int i = 0;
        long l;
        l.y yVar2;
        int i2;
        byte b;
        byte b2;
        int i4;
        byte b3;
        long size = size();
        l = 0L;
        if (size == l) {
            throw new EOFException();
        } else {
            i = 0;
            while (/* condition */) {
                while (i2 < i3) {
                    b = bArr[i2];
                    byte b4 = (byte)48;
                    b2 = (byte)97;
                    b2 = (byte)65;
                    b3 = (byte)70;
                    i4 = (b - b2) + 10;
                    long l7 = -1152921504606846976L & l;
                    if (l7 != l) {
                        l.f fVar = new f();
                        fVar.C0(l);
                        fVar.z0(b);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        final String str4 = "Number too large: ";
                        String str = fVar.r1();
                        r0 = str4 + str;
                        throw new NumberFormatException(r0);
                    }
                    b3 = (byte)102;
                    b3 = (byte)57;
                    i4 = b - b4;
                }
                b = bArr[i2];
                b4 = (byte)48;
                b2 = (byte)97;
                b2 = (byte)65;
                i = 1;
                b3 = (byte)70;
                i4 = (b - b2) + 10;
                l7 = -1152921504606846976L & l;
                if (l7 != l) {
                    fVar = new f();
                    fVar.C0(l);
                    fVar.z0(b);
                    stringBuilder2 = new StringBuilder();
                    str4 = "Number too large: ";
                    str = fVar.r1();
                    r0 = str4 + str;
                    throw new NumberFormatException(r0);
                }
                b3 = (byte)102;
                b3 = (byte)57;
                i4 = b - b4;
                if (i == 0 && this.a == null) {
                    T(size() - (long)i);
                    return l;
                }
            }
            fVar = new f();
            fVar.C0(l);
            fVar.z0(b);
            stringBuilder2 = new StringBuilder();
            str4 = "Number too large: ";
            str = fVar.r1();
            r0 = str4 + str;
            throw new NumberFormatException(r0);
        }
    }

    public final long e() {
        long size;
        int i;
        int cmp = 8192;
        size = size();
        size = 0L;
        if (size != size) {
            n.d(this.a);
            n.d(yVar2.g);
            cmp = 8192;
            if (yVar.c < 8192 && yVar.e) {
                i = i - yVar.b;
                size = size - (long)i;
            }
        }
        return size;
    }

    public f e0(i iVar) {
        n.f(iVar, "byteString");
        iVar.F(this, 0, iVar.E());
        return this;
    }

    public f e1(String str, int i, int i2) {
        int min;
        long l = 2;
        byte[] bArr;
        byte[] bArr2;
        int i4;
        byte b2;
        int i5;
        n.f(str, "string");
        min = 0;
        min = 1;
        int r2 = min;
        if (min == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str8 = "beginIndex < 0: ";
            str5 = str8 + i;
            throw new IllegalArgumentException(str5.toString());
        } else {
            r2 = min;
            if (min == 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str4 = "endIndex < beginIndex: ";
                String str10 = " < ";
                str7 = str4 + i2 + str10 + i;
                throw new IllegalArgumentException(str7.toString());
            } else {
                r2 = min;
                if (min == 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str3 = "endIndex > string.length: ";
                    String str9 = " > ";
                    int length2 = str.length();
                    str6 = str3 + i2 + str9 + length2;
                    throw new IllegalArgumentException(str6.toString());
                } else {
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        char c = '\u0080';
                    }
                    return this;
                }
            }
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        Object object2;
        l.y yVar;
        boolean z2 = false;
        int cmp;
        l.y yVar2;
        int i;
        long size = 0;
        int i2;
        int cmp2;
        int i3;
        int i4;
        byte[] bArr;
        int cmp3;
        long l2;
        final Object object3 = this;
        object2 = object;
        int i5 = 0;
        int r2 = 1;
        return true;
    }

    public final f f() {
        l.y yVar2;
        l.y yVar3;
        l.y yVar4;
        final l.f fVar = new f();
        long size = size();
        long l = 0L;
        if (size != l) {
            n.d(this.a);
            l.y yVar = this.a.d();
            fVar.a = yVar;
            yVar.g = yVar;
            yVar.f = yVar;
            while (yVar5.f != this.a) {
                n.d(yVar.g);
                n.d(yVar2);
                yVar.g.c(yVar2.d());
            }
            fVar.T(size());
        }
        return fVar;
    }

    public f g0(d0 d0Var, long j) throws EOFException {
        long l;
        str = "source";
        n.f(d0Var, str);
        while (l > 0) {
            long read = d0Var.read(this, l);
            if (read == -1) {
                throw new EOFException();
            }
        }
        return this;
    }

    public f g1(int i) {
        int i5 = 128;
        if (i < i5) {
            z0(i);
            return this;
        } else {
            int i9 = 63;
            if (i < 2048) {
                int i2 = 2;
                l.y yVar = Y(i2);
                yVar.a[yVar.c] = (byte)(i >> 6) | 192;
                i4 = i11 + 1;
                b2 = (byte)(i & i9) | i5;
                yVar.a[i4] = b2;
                yVar.c += i2;
                long l2 = 2L;
                l = size() + l2;
                T(l);
            } else {
                i2 = 57343;
                if (55296 > i) {
                    if (i < 65536) {
                        i2 = 3;
                        yVar = Y(i2);
                        yVar.a[yVar.c] = (byte)(i >> 12) | 224;
                        b = (byte)(i >> 6) & i9 | i5;
                        yVar.a[i13 + 1] = b;
                        i4 = i13 + 2;
                        b2 = (byte)(i & i9) | i5;
                        yVar.a[i4] = b2;
                        yVar.c += i2;
                        l2 = 3L;
                        l = size() + l2;
                        T(l);
                    } else {
                        if (i <= 1114111) {
                            i2 = 4;
                            yVar = Y(i2);
                            yVar.a[yVar.c] = (byte)(i >> 18) | 240;
                            yVar.a[i12 + 1] = (byte)(i >> 12) & i9 | i5;
                            b = (byte)(i >> 6) & i9 | i5;
                            yVar.a[i12 + 2] = b;
                            i4 = i12 + 3;
                            b2 = (byte)(i & i9) | i5;
                            yVar.a[i4] = b2;
                            yVar.c += i2;
                            l2 = 4L;
                            l = size() + l2;
                            T(l);
                        }
                    }
                } else {
                    if (57343 >= i) {
                        z0(i9);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Unexpected code point: 0x";
        String str2 = c.f(i);
        i = str + str2;
        throw new IllegalArgumentException(i);
    }

    public InputStream g2() {
        return new f.b(this);
    }

    @Override // java.lang.Object
    public int hashCode() {
        l.y yVar;
        int i = 1;
        int i2;
        byte b;
        int r1 = this.a != null ? 1 : 0;
        return i;
    }

    public int i2(t tVar) {
        int i;
        n.f(tVar, "options");
        final Object obj = null;
        i = a.f(this, tVar, false, 2, obj);
        i = -1;
        if (i == i) {
        } else {
            skip((long)tVar.i()[i].E());
        }
        return i;
    }

    public final f j(f fVar, long j, long j2) {
        l.y yVar;
        int i2;
        long l;
        int i3;
        long l2;
        n.f(fVar, "out");
        long j22 = j;
        c.b(size(), j22, j2);
        l = 0L;
        if (j2 != l) {
            fVar.T(fVar.size() + j2);
            n.d(yVar);
            long l6 = (long)(i - i2);
            while (l >= l6) {
                j22 = (long)(i - i2);
                l = l - j22;
                n.d(yVar);
                l6 = (long)(i - i2);
            }
            while (l2 > l) {
                n.d(yVar);
                l.y yVar3 = yVar.d();
                yVar3.b += i8;
                i2 = i6 + (int)l2;
                yVar3.c = Math.min(i2, yVar3.c);
                l2 = l2 - (long)(yVar3.c - yVar3.b);
            }
        }
        return this;
    }

    public void k0(f fVar, long j) throws EOFException {
        n.f(fVar, "sink");
        long size = size();
        if (size < j) {
            fVar.write(this, size());
            throw new EOFException();
        } else {
            fVar.write(this, j);
            return;
        }
    }

    public f m0(byte[] bArr) {
        n.f(bArr, "source");
        v0(bArr, 0, bArr.length);
        return this;
    }

    public String m1() {
        return r0(Long.MAX_VALUE);
    }

    public final byte n(long j) {
        l.y yVar;
        int i2 = 0;
        long size;
        byte b;
        int i3 = 1;
        c.b(size(), j, i3);
        if (this.a == null) {
            Object obj = null;
            size = -1L;
            n.d(obj);
            l3 = (long)obj.b + j - size;
            b = obj.a[(int)l3];
        } else {
            long l5 = size() - j;
            if (l5 < j) {
                size = size();
                while (size > j) {
                    n.d(yVar.g);
                    l2 = (long)(yVar.c - yVar.b);
                    size = size - l2;
                }
                n.d(yVar);
                l3 = (long)yVar.b + j - size;
                b = yVar.a[(int)l3];
            } else {
                i2 = 0;
                l = (long)(yVar.c - yVar.b) + i2;
                while (yVar.c - yVar.b > j) {
                    n.d(yVar.f);
                    i2 = l;
                    l = (long)yVar.c - yVar.b + i2;
                }
                n.d(yVar);
                l3 = (long)yVar.b + j - i2;
                b = yVar.a[(int)l3];
            }
        }
        return b;
    }

    public long n0(i iVar) {
        n.f(iVar, "targetBytes");
        return w(iVar, 0L);
    }

    public long o(byte b, long j, long j2) {
        long size;
        int i = 1;
        l.y yVar;
        int i2 = -1;
        byte[] bArr;
        int i3;
        long l;
        int cmp4;
        long l2;
        int i4;
        int i5;
        long size2;
        size = 0L;
        if (size > j) {
            i = 0;
        } else {
            int r2 = j2 >= j ? 1 : 0;
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "size=";
            long size3 = size();
            String str2 = " fromIndex=";
            String str4 = " toIndex=";
            str3 = str + size3 + str2 + j + str4 + j2;
            throw new IllegalArgumentException(str3.toString());
        } else {
            long size4 = size();
            if (j2 > size4) {
                size2 = size();
            }
            i2 = -1;
            if (j != size2) {
                if (this.a != null) {
                    long l5 = size() - j;
                    if (l5 < j) {
                        size = size();
                        while (size > j) {
                            n.d(yVar.g);
                            cmp3 = (long)(yVar.c - yVar.b);
                            size = size - cmp3;
                        }
                        if (yVar.g != null) {
                            while (size < size2) {
                                l2 = (long)yVar.b + size2 - size;
                                i3 = (int)(Math.min((long)yVar.c, l2));
                                l = (long)yVar.b + size - size;
                                i4 = (int)l;
                                while (i4 < i3) {
                                    if (yVar.a[i4] == b) {
                                        l3 = (long)(i4 - yVar.b);
                                        long l4 = l3 + size;
                                    }
                                }
                                size = size + (long)(yVar.c - yVar.b);
                                n.d(yVar.f);
                                if (yVar.a[i4] == b) {
                                    l3 = (long)(i4 - yVar.b);
                                    l4 = l3 + size;
                                }
                            }
                        }
                    } else {
                        l3 = (long)(i4 - yVar.b);
                        l4 = l3 + size;
                    }
                }
            }
            return i2;
        }
    }

    public long p0() throws EOFException {
        int i = -7;
        long l = 0;
        int cmp = 0;
        l.y yVar;
        int i2;
        int i4;
        byte b;
        int i5;
        final Object obj = this;
        long size = size();
        l = 0L;
        if (size == l) {
            throw new EOFException();
        } else {
            i = -7;
            cmp = 0;
            while (/* condition */) {
                cmp = 1;
                while (i2 < i3) {
                    byte b4 = bArr[i2];
                    b = (byte)48;
                    if (b4 == (byte)45 && cmp == 0) {
                    }
                    b2 = (byte)57;
                    i5 = b - b4;
                    long l3 = -922337203685477580L;
                    if (l == l3) {
                        long l8 = (long)i5;
                    }
                }
                b4 = bArr[i2];
                b = (byte)48;
                if (b4 == (byte)45 && cmp == 0) {
                }
                b2 = (byte)57;
                i5 = b - b4;
                l3 = -922337203685477580L;
                if (l == l3) {
                    l8 = (long)i5;
                }
            }
            l.f fVar = new f();
            fVar.A0(l);
            fVar.z0(b4);
            if (cmp != 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                final String str4 = "Number too large: ";
                String str = fVar.r1();
                r1 = str4 + str;
                throw new NumberFormatException(r1);
            } else {
                fVar.readByte();
            }
        }
    }

    public byte[] p1(long j) throws EOFException {
        int i = 0;
        if (j >= 0) {
            long l = (long)(0x7fffffff /* Unknown resource */);
            int r0 = j <= l ? 1 : 0;
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "byteCount: ";
            str2 = str + j;
            throw new IllegalArgumentException(str2.toString());
        } else {
            long size = size();
            if (size < j) {
                throw new EOFException();
            } else {
                byte[] bArr = new byte[(int)j];
                readFully(bArr);
                return bArr;
            }
        }
    }

    public h peek() {
        return q.d(new v(this));
    }

    public long r(i iVar, long j) {
        long j22;
        int i;
        int i2;
        int i3 = 1;
        Object iVar2;
        int cmp;
        int i5;
        boolean z;
        byte b2;
        l.y yVar;
        long l = -1;
        int i6;
        int cmp2;
        long l3 = 1;
        long l4;
        int i7 = 1;
        long l5 = 1;
        j22 = j;
        n.f(iVar, "bytes");
        i3 = 0;
        int r2 = iVar.E() > 0 ? 1 : i3;
        if (i3 == 0) {
            throw new IllegalArgumentException("bytes is empty".toString());
        } else {
            j22 = 0L;
            r2 = j22 >= j22 ? 1 : i3;
            if (i3 == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "fromIndex < 0: ";
                str = str4 + j22;
                throw new IllegalArgumentException(str.toString());
            } else {
                if (this.a != null) {
                    long l16 = size() - j22;
                    l3 = 1L;
                    if (l16 < j22) {
                        j22 = size();
                        while (j22 > j22) {
                            n.d(yVar.g);
                            cmp2 = yVar.c - yVar.b;
                            l5 = (long)cmp2;
                            j22 = j22 - l5;
                        }
                        if (yVar.g != null) {
                            byte[] bArr2 = iVar.q();
                            int i14 = iVar.E();
                            l2 = (long)i14;
                            l5 = (size() - l2) + 1L;
                            while (j22 < l5) {
                                l3 = (long)yVar.b + l5 - j22;
                                i5 = (int)(long)yVar.b + j22 - j22;
                                while (i5 < (int)(Math.min((long)yVar.c, l3))) {
                                    if (yVar.a[i5] == bArr2[i3]) {
                                        i6 = 1;
                                    }
                                }
                                j22 = j22 + (long)(yVar.c - yVar.b);
                                n.d(yVar.f);
                                if (yVar.a[i5] == bArr2[i3]) {
                                    i6 = 1;
                                }
                            }
                            int i27 = -1;
                        }
                    } else {
                        j22 = (long)(yVar.c - yVar.b) + j22;
                        while (yVar.b > j22) {
                            i7 = 1;
                            n.d(yVar.f);
                            j22 = (long)yVar.c - yVar.b + j22;
                        }
                        if (yVar.f != null) {
                            byte[] bArr = iVar.q();
                            int i4 = iVar.E();
                            l5 = (long)i4;
                            j22 = (size() - l5) + 1L;
                            while (j22 < j22) {
                                l4 = (long)yVar.b + j22 - j22;
                                l3 = (long)yVar.b + j22 - j22;
                                i = (int)l3;
                                while (i < (int)(Math.min((long)yVar.c, l4))) {
                                    if (yVar.a[i] == bArr[i3]) {
                                        int i8 = 1;
                                    }
                                }
                                l5 = 1L;
                                j22 = j22 + (long)(yVar.c - yVar.b);
                                n.d(yVar.f);
                                if (yVar.a[i] == bArr[i3]) {
                                    i8 = 1;
                                }
                            }
                        }
                    }
                }
                return l;
            }
        }
    }

    public String r0(long j) throws EOFException {
        int i = 1;
        long l = 9223372036854775807L;
        long l2 = 1;
        String str;
        int r0 = j >= 0 ? 1 : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "limit < 0: ";
            str6 = str2 + j;
            throw new IllegalArgumentException(str6.toString());
        } else {
            l = Long.MAX_VALUE;
            l2 = 1L;
            if (j != Long.MAX_VALUE) {
                l = j + 1L;
            }
            byte b = (byte)10;
            long l6 = this.o(b, 0L, l);
            if (l6 != -1) {
                str = a.d(this, l6);
                return str;
            } else {
                long size3 = size();
                cmp = (l > size3 ? 1 : (l == size3 ? 0 : -1));
                if (Long.MAX_VALUE < size3) {
                    b3 = (byte)13;
                    if (n(l - 1L) == (byte)13) {
                        if (n(l) == b) {
                            str = a.d(this, l);
                        }
                    }
                }
            }
            l.f fVar = new f();
            this.j(fVar, 0L, Math.min((long)32, size()));
            StringBuilder stringBuilder2 = new StringBuilder();
            String str3 = "\\n not found: limit=";
            long min2 = Math.min(size(), j);
            String str4 = " content=";
            String str5 = fVar.Y0().p();
            j = str3 + min2 + str4 + str5 + 8230;
            throw new EOFException(j);
        }
    }

    public String r1() {
        return K(this.b, Charsets.a);
    }

    public int read(ByteBuffer byteBuffer) {
        n.f(byteBuffer, "sink");
        if (this.a != null) {
            int min = Math.min(byteBuffer.remaining(), yVar.c - yVar.b);
            byteBuffer.put(yVar.a, yVar.b, min);
            yVar.b += min;
            this.b -= l3;
            if (yVar.b == yVar.c) {
                this.a = this.a.b();
                z.b(this.a);
            }
            return min;
        }
        return -1;
    }

    public byte readByte() throws EOFException {
        long size = size();
        if (size == 0) {
            throw new EOFException();
        } else {
            n.d(this.a);
            T(size() - 1L);
            if (i4 == yVar.c) {
                this.a = this.a.b();
                z.b(this.a);
            } else {
                yVar.b++;
            }
            return yVar.a[i2];
        }
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        n.f(bArr, "sink");
        i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            int i2 = -1;
            if (read == -1) {
                throw new EOFException();
            }
        }
    }

    public int readInt() throws EOFException {
        int i;
        long l = 4;
        long size = size();
        l = 4L;
        if (size < l) {
            throw new EOFException();
        } else {
            n.d(this.a);
            long l3 = (long)(i17 - i8);
            if (l3 < l) {
                i = readByte() & 255;
                i = (readByte() & 255) << 24 | (readByte() & 255) << 16 | (readByte() & 255) << 8 | i;
            } else {
                int i20 = i8 + 1;
                int i23 = i20 + 1;
                i2 = i23 + 1;
                i3 = i2 + 1;
                i = (bArr[i8] & 255) << 24 | (bArr[i20] & 255) << 16 | (bArr[i23] & 255) << 8 | (bArr[i2] & 255);
                l2 = size() - 4L;
                T(l2);
                if (i3 == yVar.c) {
                    this.a = this.a.b();
                    z.b(this.a);
                } else {
                    this.a.b = i3;
                }
            }
            return i;
        }
    }

    public long readLong() throws EOFException {
        long l;
        int i;
        long size = size();
        long l2 = 8L;
        if (size < l2) {
            throw new EOFException();
        } else {
            n.d(this.a);
            long l13 = (long)(i2 - i);
            int i11 = 32;
            if (l13 < l2) {
                long l11 = 4294967295L;
                l2 = l11 & (long)readInt();
                l = (long)readInt() & l11 << 32L | l2;
            } else {
                int i12 = i + 1;
                long l6 = 255L;
                int i4 = i12 + 1;
                int i16 = i4 + 1;
                int i6 = i16 + 1;
                int i14 = i6 + 1;
                int i8 = i14 + 1;
                int i15 = i8 + 1;
                l7 = (long)bArr[i8] & l6 << 8L;
                l3 = (long)bArr[i] & l6 << 56L | (long)bArr[i12] & l6 << 48L | (long)bArr[i4] & l6 << 40L | (long)bArr[i16] & l6 << 32L | (long)bArr[i6] & l6 << 24L | (long)bArr[i14] & l6 << 16L | l7;
                i = i15 + 1;
                l5 = (long)bArr[i15] & l6;
                l = l3 | l5;
                l4 = size() - 8L;
                T(l4);
                if (yVar.b == yVar.c) {
                    this.a = this.a.b();
                    z.b(this.a);
                } else {
                    this.a.b = i;
                }
            }
            return l;
        }
    }

    public short readShort() throws EOFException {
        short s;
        long l = 2;
        long size = size();
        l = 2L;
        if (size < l) {
            throw new EOFException();
        } else {
            n.d(this.a);
            int i2 = 2;
            if (i10 - i7 < 2) {
                i = readByte() & 255;
                s = (short)(readByte() & 255) << 8 | i;
            } else {
                i2 = i7 + 1;
                i3 = i2 + 1;
                i = (bArr[i7] & 255) << 8 | (bArr[i2] & 255);
                l2 = size() - 2L;
                T(l2);
                if (i3 == yVar.c) {
                    this.a = this.a.b();
                    z.b(this.a);
                } else {
                    this.a.b = i3;
                }
                s = (short)(bArr[i7] & 255 << 8 | bArr[i2] & 255);
            }
            return s;
        }
    }

    public boolean request(long j) {
        boolean z = true;
        j = this.b >= j ? 1 : 0;
        return (this.b >= j ? 1 : 0);
    }

    public final long size() {
        return this.b;
    }

    public void skip(long j) throws EOFException {
        long l;
        while (l > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
        }
    }

    public e0 timeout() {
        return e0.NONE;
    }

    @Override // java.lang.Object
    public String toString() {
        return U().toString();
    }

    public f v0(byte[] bArr, int i, int i2) {
        n.f(bArr, "source");
        length = bArr.length;
        l = (long)length;
        l2 = (long)i;
        final long l3 = (long)i2;
        c.b(l, l2, l3);
        i2 += i;
        while (i < i11) {
            l.y yVar = Y(1);
            int min = Math.min(i11 - i, yVar.c - 8192);
            i = i + min;
            l.e(bArr, yVar.a, yVar.c, i, i);
            yVar.c += min;
        }
        T(size() + l3);
        return this;
    }

    public long w(i iVar, long j) {
        long size;
        int cmp;
        l.y yVar;
        byte b;
        byte[] bArr;
        int i = -1;
        int cmp2;
        int length = 2;
        byte b2;
        int i2;
        int i3;
        int i4;
        n.f(iVar, "targetBytes");
        size = 0L;
        cmp = 0;
        cmp = 1;
        int r2 = cmp;
        if (cmp == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "fromIndex < 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            i = -1;
            if (this.a != null) {
                long l2 = size() - j;
                length = 2;
                if (l2 < j) {
                    size = size();
                    while (size > j) {
                        n.d(yVar.g);
                        cmp2 = yVar.c - yVar.b;
                        size = (long)cmp2;
                        size = size - size;
                    }
                    if (yVar.g != null && iVar.E() == length) {
                        long size3 = size();
                        while (size < size3) {
                            i3 = (int)(long)yVar.b + size - size;
                            while (i3 < yVar.c) {
                                cmp2 = yVar.a[i3];
                            }
                            size = size + (long)(yVar.c - yVar.b);
                            n.d(yVar.f);
                            size3 = size();
                            cmp2 = bArr[i3];
                        }
                    }
                } else {
                    long l = (long)(i3 - i2) + size;
                }
            }
            return i;
        }
    }

    public int write(ByteBuffer byteBuffer) {
        int remaining;
        n.f(byteBuffer, "source");
        remaining = byteBuffer.remaining();
        while (remaining > 0) {
            l.y yVar = Y(1);
            int min = Math.min(remaining, yVar.c - 8192);
            byteBuffer.get(yVar.a, yVar.c, min);
            remaining = remaining - min;
            yVar.c += min;
        }
        this.b += l3;
        return remaining;
    }

    public boolean x(long j, i iVar, int i, int i2) {
        int cmp;
        boolean z = false;
        long l;
        byte b;
        n.f(iVar, "bytes");
        if (j >= 0 && i >= 0 && i2 >= 0) {
            l = size() - j;
            l2 = (long)i2;
            if (l >= l2) {
                cmp = iVar.E() - i;
                if (iVar.E() - i >= i2) {
                    while (cmp < i2) {
                        if (n((long)cmp + j) != iVar.j(i + cmp)) {
                            break;
                        }
                    }
                    int i5 = 1;
                }
            }
        }
        return z;
    }

    public f z0(int i) {
        l.y yVar = Y(1);
        yVar.c++;
        yVar.a[yVar.c] = (byte)i;
        T(size() + 1L);
        return this;
    }

    public void write(f fVar, long j) {
        int i = 1;
        l.y yVar = null;
        long size;
        long l = 0;
        long l2;
        n.f(fVar, "source");
        i = 0;
        int r1 = fVar != this ? 1 : i;
        if (i == 0) {
            throw new IllegalArgumentException("source == this".toString());
        } else {
            l = 0L;
            c.b(fVar.size(), l, j);
            while (l2 > 0) {
                n.d(fVar.a);
                n.d(fVar.a);
                long l5 = (long)(yVar4.c - yVar9.b);
                if (l2 < yVar4.c) {
                }
            }
            return;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        int min = -1;
        n.f(bArr, "sink");
        l = (long)bArr.length;
        l2 = (long)i;
        c.b(l, l2, (long)i2);
        if (this.a == null) {
            min = -1;
        } else {
            min = Math.min(i2, yVar.c - yVar.b);
            l.e(yVar.a, bArr, i, yVar.b, i + min);
            yVar.b += min;
            l = (long)min;
            T(size() - l);
            if (yVar.b == yVar.c) {
                this.a = this.a.b();
                z.b(this.a);
            }
        }
        return min;
    }

    public long read(f fVar, long j) {
        int i = 0;
        long j22 = -1;
        n.f(fVar, "sink");
        long l = 0L;
        int r2 = j >= l ? 1 : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "byteCount < 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            long size2 = size();
            if (size2 == l) {
                int i2 = -1;
            } else {
                long size = size();
                if (j > size) {
                    j22 = size();
                }
                fVar.write(this, j22);
            }
            return j22;
        }
    }

    public static /* synthetic */ f.a F(f fVar, f.a aVar, int i, Object object) {
        if (i & 1 != 0) {
            aVar = new f.a();
        }
        fVar.E(aVar);
        return aVar;
    }

    public f A() {
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public f h() {
        return this;
    }

    public boolean isOpen() {
        return true;
    }

    public f k() {
        return this;
    }

    public f m() {
        return this;
    }
}
