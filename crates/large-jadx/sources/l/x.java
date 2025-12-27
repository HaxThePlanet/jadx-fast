package l;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.d0.d.n;

/* compiled from: RealBufferedSource.kt */
/* loaded from: classes3.dex */
public final class x implements h {

    public final f a = new f();
    public boolean b;
    public final d0 c;

    public static final class a extends InputStream {

        final /* synthetic */ x a;
        a() {
            this.a = xVar;
            super();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (xVar.b) {
                throw new IOException("closed");
            } else {
                return (int)(Math.min(xVar.a.size(), (long)(0x7fffffff /* Unknown resource */)));
            }
        }

        @Override // java.io.InputStream
        public void close() {
            this.a.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (xVar.b) {
                throw new IOException("closed");
            } else {
                long size = xVar.a.size();
                long l = 0L;
                if (size == l) {
                    long read = xVar3.c.read(xVar3.a, (long)8192);
                    l = -1L;
                    if (read == l) {
                        return -1;
                    }
                }
                return this.a.a.readByte() & 255;
            }
        }

        @Override // java.io.InputStream
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".inputStream()";
            str = this.a + str2;
            return str;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            n.f(bArr, "data");
            if (this.a.b) {
                throw new IOException("closed");
            } else {
                l = (long)bArr.length;
                final long l5 = (long)i;
                c.b(l, l5, (long)i2);
                long size = this.a.a.size();
                long l2 = 0L;
                if (size == l2) {
                    long read = xVar4.c.read(xVar4.a, (long)8192);
                    l2 = -1L;
                    if (read == l2) {
                        return -1;
                    }
                }
                return this.a.a.read(bArr, i, i2);
            }
        }
    }
    public x(d0 d0Var) {
        n.f(d0Var, "source");
        super();
        this.c = d0Var;
        final l.f fVar = new f();
    }

    public f A() {
        return this.a;
    }

    public i B(long j) {
        V1(j);
        return this.a.B(j);
    }

    public long J1(b0 b0Var) {
        int i;
        n.f(b0Var, "sink");
        long l2 = 0L;
        i = l2;
        long read = this.c.read(this.a, (long)8192);
        while (read != -1) {
            long l = this.a.e();
        }
        long size = this.a.size();
        if (size > l2) {
            i += size2;
            b0Var.write(this.a, this.a.size());
        }
        return i;
    }

    public boolean K0(long j, i iVar) {
        n.f(iVar, "bytes");
        return this.i(j, iVar, 0, iVar.A());
    }

    public String M0(Charset charset) {
        n.f(charset, "charset");
        this.a.W0(this.c);
        return this.a.M0(charset);
    }

    public void V1(long j) throws EOFException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    public byte[] X() {
        this.a.W0(this.c);
        return this.a.X();
    }

    public i Y0() {
        this.a.W0(this.c);
        return this.a.Y0();
    }

    public long a(byte b) {
        return this.c(b, 0L, Long.MAX_VALUE);
    }

    public long a0(i iVar) {
        n.f(iVar, "bytes");
        return e(iVar, 0L);
    }

    public boolean b0() {
        boolean z;
        boolean z3 = false;
        long read;
        long l;
        long l2 = -1;
        if (this.b ^ 1 == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            if (this.a.b0()) {
                l = (long)8192;
                read = this.c.read(this.a, l);
                l2 = -1L;
                if (read != l2) {
                    int i3 = 0;
                }
            }
            return z3;
        }
    }

    public long c(byte b, long j, long j2) {
        int size;
        int i = 1;
        long cmp = 0;
        l.f fVar;
        long j22;
        long l2;
        long l = -1;
        i = 1;
        if (this.b ^ i == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            cmp = 0L;
            if (cmp > j) {
                i = 0;
            }
            if (i == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "fromIndex=";
                String str3 = " toIndex=";
                str2 = str + j + str3 + j2;
                throw new IllegalArgumentException(str2.toString());
            } else {
                l = -1L;
                while (j22 < j2) {
                    l = this.a.o(b, j22, j2);
                    size = this.a.size();
                    j22 = (long)8192;
                    long read = this.c.read(this.a, j22);
                    if (read == l) {
                        break;
                    }
                }
                return l;
            }
        }
    }

    public void close() {
        if (!(this.b)) {
            this.b = true;
            this.c.close();
            this.a.a();
        }
    }

    public long d2() {
        int i = 0;
        byte b2;
        V1(1L);
        i = 0;
        i = i + 1;
        while (request((long)i)) {
            byte b = this.a.n((long)i);
            b2 = (byte)48;
            if (b < (byte)48) {
                b2 = (byte)97;
            }
        }
        return this.a.d2();
    }

    public long e(i iVar, long j) {
        long l;
        l.f fVar;
        long l3;
        long max;
        n.f(iVar, "bytes");
        i = !this.b;
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            l = this.a.r(iVar, max);
            l = -1L;
            while (l != l) {
                l3 = (long)8192;
                long read = this.c.read(this.a, l3);
                if (read == l) {
                }
            }
            return l;
        }
    }

    public long f(i iVar, long j) {
        long l;
        l.f fVar;
        long l2;
        long max;
        n.f(iVar, "targetBytes");
        size = !this.b;
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            l = this.a.w(iVar, max);
            l = -1L;
            while (l != l) {
                l2 = (long)8192;
                long read = this.c.read(this.a, l2);
                if (read == l) {
                }
            }
            return l;
        }
    }

    public InputStream g2() {
        return new x.a(this);
    }

    public f h() {
        return this.a;
    }

    public boolean i(long j, i iVar, int i, int i2) {
        int cmp;
        boolean z2 = true;
        byte b;
        long l;
        byte b2;
        l.f fVar;
        boolean request;
        n.f(iVar, "bytes");
        if (this.b ^ 1 == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            cmp = 0;
            if (j >= 0 && i >= 0 && i2 >= 0) {
                cmp = iVar.E() - i;
                if (iVar.E() - i < i2) {
                } else {
                    while ((this.b ^ 1) < i2) {
                        l = (long)cmp + j;
                    }
                }
            }
            return z2;
        }
    }

    public int i2(t tVar) {
        int cmp;
        int i = -2;
        long read;
        long l2 = -1;
        n.f(tVar, "options");
        boolean z2 = true;
        cmp = this.b ^ z2;
        if (this.b ^ z2 == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            cmp = a.e(this.a, tVar, z2);
            i = -2;
            cmp = -1;
            while (cmp != -2) {
                read = this.c.read(this.a, (long)8192);
                l2 = -1L;
                cmp = a.e(this.a, tVar, z2);
                i = -2;
                cmp = -1;
            }
            if (cmp != cmp) {
                l = (long)tVar.i()[cmp].E();
                this.a.skip(l);
            } else {
            }
            return cmp;
        }
    }

    public boolean isOpen() {
        return !this.b;
    }

    public int j() {
        V1(4L);
        return this.a.H();
    }

    public short k() {
        V1(2L);
        return this.a.J();
    }

    public void k0(f fVar, long j) {
        n.f(fVar, "sink");
        try {
            V1(j);
        } catch (java.io.EOFException e) {
            fVar.W0(this.a);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) e;
        }
        this.a.k0(fVar, e);
    }

    public String m1() {
        return r0(Long.MAX_VALUE);
    }

    public long n0(i iVar) {
        n.f(iVar, "targetBytes");
        return f(iVar, 0L);
    }

    public long p0() {
        int cmp;
        byte b;
        byte b3;
        long l2 = 1L;
        V1(l2);
        long l4 = 0L;
        cmp = l4;
        l = cmp + l2;
        while (request(l)) {
            byte b2 = this.a.n(cmp);
            b3 = (byte)48;
            if (b2 < (byte)48) {
            }
        }
        return this.a.p0();
    }

    public byte[] p1(long j) {
        V1(j);
        return this.a.p1(j);
    }

    public h peek() {
        return q.d(new v(this));
    }

    public String r0(long j) throws EOFException {
        int i = 1;
        long l2 = 1;
        long l;
        String str;
        int r0 = j >= 0 ? 1 : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "limit < 0: ";
            str4 = str2 + j;
            throw new IllegalArgumentException(str4.toString());
        } else {
            l = Long.MAX_VALUE;
            l2 = 1L;
            long r5 = j == Long.MAX_VALUE ? l : j + l2;
            byte b3 = (byte)10;
            long l3 = this.c(b3, 0L, (j == Long.MAX_VALUE ? l : j + l2));
            if (l3 != -1) {
                str = a.d(this.a, l3);
                return str;
            } else {
                if (r5 < Long.MAX_VALUE) {
                    if (request(r5)) {
                        l3 = r5 - 1L;
                        b2 = (byte)13;
                        if (this.a.n(l3) == (byte)13) {
                            l2 = 1L + r5;
                            if (request(l2)) {
                                if (this.a.n(r5) == b3) {
                                    str = a.d(this.a, r5);
                                }
                            }
                        }
                    }
                }
            }
            final l.f fVar = new f();
            this.a.j(fVar, 0L, Math.min((long)32, this.a.size()));
            StringBuilder stringBuilder2 = new StringBuilder();
            String str3 = "\\n not found: limit=";
            long min2 = Math.min(this.a.size(), j);
            String str5 = " content=";
            String str6 = fVar.Y0().p();
            String str7 = "…";
            j = str3 + min2 + str5 + str6 + str7;
            throw new EOFException(j);
        }
    }

    public String r1() {
        this.a.W0(this.c);
        return this.a.r1();
    }

    public long read(f fVar, long j) {
        long read = -1;
        int i = 0;
        long l;
        n.f(fVar, "sink");
        long l2 = 0L;
        i = 1;
        int r2 = j >= l2 ? i : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "byteCount < 0: ";
            str3 = str2 + j;
            throw new IllegalArgumentException(str3.toString());
        } else {
            if (this.b ^ i == 0) {
                throw new IllegalStateException("closed".toString());
            } else {
                long size2 = this.a.size();
                read = -1L;
                if (size2 == l2) {
                    l = (long)8192;
                    long read2 = this.c.read(this.a, l);
                    if (read2 != read) {
                        read = this.a.read(fVar, Math.min(j, this.a.size()));
                    }
                }
                return read;
            }
        }
    }

    public byte readByte() {
        V1(1L);
        return this.a.readByte();
    }

    public void readFully(byte[] bArr) {
        int i;
        n.f(bArr, "sink");
        try {
            V1((long)bArr.length);
        } catch (java.io.EOFException e) {
            i = 0;
        }
        this.a.readFully(bArr);
    }

    public int readInt() {
        V1(4L);
        return this.a.readInt();
    }

    public long readLong() {
        V1(8L);
        return this.a.readLong();
    }

    public short readShort() {
        V1(2L);
        return this.a.readShort();
    }

    public boolean request(long j) {
        int i;
        boolean z2 = false;
        long l;
        long l2 = -1;
        i = 1;
        int r0 = j >= 0 ? i : 0;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "byteCount < 0: ";
            str2 = str + j;
            throw new IllegalArgumentException(str2.toString());
        } else {
            cmp = this.b ^ i;
            if (this.b ^ i == 0) {
                throw new IllegalStateException("closed".toString());
            } else {
                long size = this.a.size();
                while (size < j) {
                    l = (long)8192;
                    size = this.c.read(this.a, l);
                    l2 = -1L;
                    if (size == l2) {
                        break;
                    }
                    size = this.a.size();
                }
                return z2;
            }
        }
    }

    public void skip(long j) throws EOFException {
        l.f fVar;
        long l;
        min = !this.b;
        if (!this.b == 0) {
            throw new IllegalStateException("closed".toString());
        } else {
            long l2 = 0L;
            while (l > l2) {
                long size = this.a.size();
                if (size == l2) {
                    long read = this.c.read(this.a, (long)8192);
                    size = -1L;
                }
            }
            return;
        }
    }

    public e0 timeout() {
        return this.c.timeout();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "buffer(";
        str = str2 + this.c + 41;
        return str;
    }

    public int read(ByteBuffer byteBuffer) {
        n.f(byteBuffer, "sink");
        long size = this.a.size();
        long l = 0L;
        if (size == l) {
            long read = this.c.read(this.a, (long)8192);
            l = -1L;
            if (read == l) {
                return -1;
            }
        }
        return this.a.read(byteBuffer);
    }
}
