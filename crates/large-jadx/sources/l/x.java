package l;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.d0.d.n;
import kotlin.k0.a;
import l.g0.a;

/* loaded from: classes3.dex */
public final class x implements l.h {

    public final l.f a;
    public boolean b;
    public final l.d0 c;

    public static final class a extends InputStream {

        final l.x a;
        a(l.x x) {
            this.a = x;
            super();
        }

        @Override // java.io.InputStream
        public int available() {
            l.x xVar = this.a;
            boolean z = xVar.b;
            if (z) {
            } else {
                return (int)l;
            }
            IOException iOException = new IOException("closed");
            throw iOException;
        }

        @Override // java.io.InputStream
        public void close() {
            this.a.close();
        }

        @Override // java.io.InputStream
        public int read() {
            int cmp;
            boolean z;
            int i;
            l.x xVar = this.a;
            if (xVar.b) {
            } else {
                l.x xVar3 = this.a;
                if (Long.compare(size, i) == 0 && Long.compare(read, i) == 0) {
                    xVar3 = this.a;
                    if (Long.compare(read, i) == 0) {
                        return -1;
                    }
                }
                return byte &= 255;
            }
            IOException iOException = new IOException("closed");
            throw iOException;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int cmp;
            long l;
            int i;
            n.f(bArr, "data");
            if (xVar.b) {
            } else {
                final long l3 = (long)i2;
                c.b((long)length, obj2, l3);
                l.x xVar4 = this.a;
                if (Long.compare(size, i) == 0 && Long.compare(read, i) == 0) {
                    xVar4 = this.a;
                    if (Long.compare(read, i) == 0) {
                        return -1;
                    }
                }
                return xVar3.a.read(bArr, i2, i3);
            }
            IOException obj8 = new IOException("closed");
            throw obj8;
        }

        @Override // java.io.InputStream
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }
    public x(l.d0 d0) {
        n.f(d0, "source");
        super();
        this.c = d0;
        f obj2 = new f();
        this.a = obj2;
    }

    @Override // l.h
    public l.f A() {
        return this.a;
    }

    @Override // l.h
    public l.i B(long l) {
        V1(l);
        return this.a.B(l);
    }

    @Override // l.h
    public long J1(l.b0 b0) {
        int cmp2;
        int i;
        long l;
        long size;
        l.f fVar;
        int cmp;
        n.f(b0, "sink");
        int i2 = 0;
        i = i2;
        fVar = this.a;
        while (Long.compare(read, i4) != 0) {
            l = this.a.e();
            if (Long.compare(l, i2) > 0) {
            }
            fVar = this.a;
            i += l;
            b0.write(this.a, l);
        }
        if (Long.compare(size, i2) > 0) {
            i += size2;
            cmp2 = this.a;
            b0.write(cmp2, cmp2.size());
        }
        return i;
    }

    @Override // l.h
    public boolean K0(long l, l.i i2) {
        n.f(obj10, "bytes");
        return this.i(l, obj3, obj10, 0);
    }

    @Override // l.h
    public String M0(Charset charset) {
        n.f(charset, "charset");
        this.a.W0(this.c);
        return this.a.M0(charset);
    }

    @Override // l.h
    public void V1(long l) {
        if (!request(l)) {
        } else {
        }
        EOFException obj1 = new EOFException();
        throw obj1;
    }

    @Override // l.h
    public byte[] X() {
        this.a.W0(this.c);
        return this.a.X();
    }

    @Override // l.h
    public l.i Y0() {
        this.a.W0(this.c);
        return this.a.Y0();
    }

    @Override // l.h
    public long a(byte b) {
        return this.c(b, 0, obj3);
    }

    @Override // l.h
    public long a0(l.i i) {
        n.f(i, "bytes");
        return e(i, 0);
    }

    @Override // l.h
    public boolean b0() {
        boolean cmp;
        int i;
        long read;
        long l;
        int i2;
        if (z ^= i == 0) {
        } else {
            if (this.a.b0() && Long.compare(read, i2) == 0) {
                if (Long.compare(read, i2) == 0) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }
        IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
        throw illegalStateException;
    }

    @Override // l.h
    public long c(byte b, long l2, long l3) {
        int size;
        int i;
        int cmp;
        l.f fVar;
        long l;
        int i2;
        int i3;
        int obj12;
        if (z ^= i == 0) {
        } else {
            if (Long.compare(cmp, l2) > 0) {
                i = 0;
            } else {
                if (Long.compare(obj14, l2) >= 0) {
                } else {
                }
            }
            if (i == 0) {
            }
            StringBuilder obj11 = new StringBuilder();
            obj11.append("fromIndex=");
            obj11.append(l2);
            obj11.append(" toIndex=");
            obj11.append(obj14);
            obj12 = new IllegalArgumentException(obj11.toString().toString());
            throw obj12;
        }
        obj11 = new IllegalStateException("closed".toString());
        throw obj11;
    }

    @Override // l.h
    public void close() {
        boolean z;
        if (this.b) {
        } else {
            this.b = true;
            this.c.close();
            this.a.a();
        }
    }

    @Override // l.h
    public long d2() {
        int i;
        int i2;
        byte request;
        byte b;
        V1(1);
        i = 0;
        i2 = i + 1;
        while (request((long)i2)) {
            request = this.a.n((long)i);
            i = i2;
            i2 = i + 1;
        }
        return this.a.d2();
    }

    @Override // l.h
    public long e(l.i i, long l2) {
        int i2;
        int l3;
        int i3;
        int cmp;
        l.f fVar;
        long l;
        long obj10;
        n.f(i, "bytes");
        if (z ^= 1 == 0) {
        }
        IllegalStateException obj9 = new IllegalStateException("closed".toString());
        throw obj9;
    }

    @Override // l.h
    public long f(l.i i, long l2) {
        int size;
        int l3;
        int i2;
        int cmp;
        l.f fVar;
        long l;
        long obj10;
        n.f(i, "targetBytes");
        if (z ^= 1 == 0) {
        }
        IllegalStateException obj9 = new IllegalStateException("closed".toString());
        throw obj9;
    }

    @Override // l.h
    public InputStream g2() {
        x.a aVar = new x.a(this);
        return aVar;
    }

    @Override // l.h
    public l.f h() {
        return this.a;
    }

    @Override // l.h
    public boolean i(long l, l.i i2, int i3, int i4) {
        int cmp;
        int i;
        int i5;
        byte b;
        boolean request;
        n.f(i3, "bytes");
        if (z ^= i == 0) {
        } else {
            int i9 = 0;
            if (Long.compare(l, i8) >= 0 && i4 >= 0 && obj12 >= 0) {
                if (i4 >= 0) {
                    if (obj12 >= 0) {
                        if (i7 -= i4 < obj12) {
                            i = i9;
                        } else {
                            cmp = i9;
                            while (cmp < obj12) {
                                l2 += l;
                                cmp++;
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        IllegalStateException obj8 = new IllegalStateException("closed".toString());
        throw obj8;
    }

    @Override // l.h
    public int i2(l.t t) {
        int cmp;
        l.f i4;
        int i;
        int i2;
        long read;
        int i3;
        int obj9;
        n.f(t, "options");
        i4 = 1;
        if (z ^= i4 == 0) {
        }
        obj9 = new IllegalStateException("closed".toString());
        throw obj9;
    }

    @Override // l.h
    public boolean isOpen() {
        return z ^= 1;
    }

    @Override // l.h
    public int j() {
        V1(4);
        return this.a.H();
    }

    @Override // l.h
    public short k() {
        V1(2);
        return this.a.J();
    }

    @Override // l.h
    public void k0(l.f f, long l2) {
        n.f(f, "sink");
        V1(l2);
        this.a.k0(f, l2);
    }

    @Override // l.h
    public String m1() {
        return r0(Long.MAX_VALUE);
    }

    @Override // l.h
    public long n0(l.i i) {
        n.f(i, "targetBytes");
        return f(i, 0);
    }

    @Override // l.h
    public long p0() {
        int cmp;
        byte b;
        int i;
        byte request;
        byte b2;
        int i2 = 1;
        V1(i2);
        int i3 = 0;
        cmp = i3;
        i = cmp + i2;
        while (request(i)) {
            request = this.a.n(cmp);
            cmp = Long.compare(cmp, i3);
            cmp = i;
            i = cmp + i2;
        }
        return this.a.p0();
    }

    @Override // l.h
    public byte[] p1(long l) {
        V1(l);
        return this.a.p1(l);
    }

    @Override // l.h
    public l.h peek() {
        v vVar = new v(this);
        return q.d(vVar);
    }

    @Override // l.h
    public String r0(long l) {
        int i;
        int request;
        byte b;
        int i2;
        int i3;
        long l2;
        String obj14;
        i = Long.compare(l, i4) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            request = Long.MAX_VALUE;
            i2 = 1;
            i3 = Long.compare(l, request) == 0 ? request : l + i2;
            byte b2 = (byte)i7;
            final byte b3 = b2;
            l2 = this.c(b3, 0, obj10);
            if (Long.compare(l2, i10) != 0) {
                obj14 = a.d(this.a, l2);
                return obj14;
            } else {
                if (Long.compare(i3, request) >= 0) {
                } else {
                    if (!request(i3)) {
                    } else {
                        if (this.a.n(i3 - i2) != (byte)i5) {
                        } else {
                            if (!request(i2 += i3)) {
                            } else {
                                if (this.a.n(i3) != b2) {
                                } else {
                                    obj14 = a.d(this.a, i3);
                                }
                            }
                        }
                    }
                }
            }
            f fVar6 = new f();
            l.f fVar3 = this.a;
            fVar3.j(fVar6, 0, i2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("\\n not found: limit=");
            stringBuilder2.append(Math.min(this.a.size(), i2));
            stringBuilder2.append(" content=");
            stringBuilder2.append(fVar6.Y0().p());
            stringBuilder2.append("…");
            EOFException eOFException = new EOFException(stringBuilder2.toString());
            throw eOFException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("limit < 0: ");
        stringBuilder.append(l);
        IllegalArgumentException obj15 = new IllegalArgumentException(stringBuilder.toString().toString());
        throw obj15;
    }

    @Override // l.h
    public String r1() {
        this.a.W0(this.c);
        return this.a.r1();
    }

    @Override // l.h
    public int read(ByteBuffer byteBuffer) {
        int cmp;
        l.f fVar;
        int i;
        n.f(byteBuffer, "sink");
        if (Long.compare(size, i) == 0 && Long.compare(read, i) == 0) {
            if (Long.compare(read, i) == 0) {
                return -1;
            }
        }
        return this.a.read(byteBuffer);
    }

    @Override // l.h
    public long read(l.f f, long l2) {
        int cmp;
        int read2;
        int i;
        long read;
        long l;
        int obj8;
        n.f(f, "sink");
        int i2 = 0;
        read = 1;
        i = Long.compare(l2, i2) >= 0 ? read : 0;
        if (i == 0) {
        } else {
            if (z ^= read == 0) {
            } else {
                read2 = -1;
                if (Long.compare(size2, i2) == 0 && Long.compare(read, read2) == 0) {
                    if (Long.compare(read, read2) == 0) {
                    } else {
                        read2 = this.a.read(f, Math.min(l2, obj9));
                    }
                } else {
                }
                return read2;
            }
            IllegalStateException obj7 = new IllegalStateException("closed".toString());
            throw obj7;
        }
        obj7 = new StringBuilder();
        obj7.append("byteCount < 0: ");
        obj7.append(l2);
        obj8 = new IllegalArgumentException(obj7.toString().toString());
        throw obj8;
    }

    @Override // l.h
    public byte readByte() {
        V1(1);
        return this.a.readByte();
    }

    @Override // l.h
    public void readFully(byte[] bArr) {
        int i;
        n.f(bArr, "sink");
        V1((long)length);
        this.a.readFully(bArr);
    }

    @Override // l.h
    public int readInt() {
        V1(4);
        return this.a.readInt();
    }

    @Override // l.h
    public long readLong() {
        V1(8);
        return this.a.readLong();
    }

    @Override // l.h
    public short readShort() {
        V1(2);
        return this.a.readShort();
    }

    @Override // l.h
    public boolean request(long l) {
        int i2;
        int cmp;
        int i;
        long size;
        long l2;
        int i3;
        final int i5 = 1;
        i2 = Long.compare(l, i4) >= 0 ? i5 : i;
        if (i2 == 0) {
        } else {
            if (z ^= i5 == 0) {
            }
            IllegalStateException obj8 = new IllegalStateException("closed".toString());
            throw obj8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount < 0: ");
        stringBuilder.append(l);
        IllegalArgumentException obj9 = new IllegalArgumentException(stringBuilder.toString().toString());
        throw obj9;
    }

    @Override // l.h
    public void skip(long l) {
        int i;
        int cmp;
        l.f fVar;
        l.f fVar2;
        long size;
        int obj5;
        if (z ^= 1 == 0) {
        }
        obj5 = new IllegalStateException("closed".toString());
        throw obj5;
    }

    @Override // l.h
    public l.e0 timeout() {
        return this.c.timeout();
    }

    @Override // l.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
