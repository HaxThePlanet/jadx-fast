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

/* loaded from: classes3.dex */
public final class f implements l.h, l.g, java.lang.Cloneable, ByteChannel {

    public l.y a;
    private long b;

    public static final class a implements Closeable {

        public l.f a;
        public boolean b;
        private l.y c;
        public long v = -1;
        public byte[] w;
        public int x = -1;
        public int y = -1;
        public a() {
            super();
            int i = -1;
            int i2 = -1;
        }

        @Override // java.io.Closeable
        public final l.y a() {
            return this.c;
        }

        @Override // java.io.Closeable
        public final int c() {
            int i;
            int i3;
            long cmp;
            int i2;
            l.f fVar = this.a;
            n.d(fVar);
            i = Long.compare(l, size) != 0 ? 1 : 0;
            if (i == 0) {
            } else {
                long l2 = this.v;
                if (Long.compare(l2, i5) == 0) {
                    i3 = 0;
                } else {
                    l2 += cmp;
                }
                return f(i3);
            }
            IllegalStateException illegalStateException = new IllegalStateException("no more bytes".toString());
            throw illegalStateException;
        }

        @Override // java.io.Closeable
        public void close() {
            int i;
            i = this.a != null ? 1 : 0;
            if (i == 0) {
            } else {
                int i2 = 0;
                this.a = i2;
                i(i2);
                this.v = -1;
                this.w = i2;
                int i3 = -1;
                this.x = i3;
                this.y = i3;
            }
            IllegalStateException illegalStateException = new IllegalStateException("not attached to a buffer".toString());
            throw illegalStateException;
        }

        @Override // java.io.Closeable
        public final long e(long l) {
            int i3;
            int cmp;
            int i4;
            int cmp4;
            int i;
            long l2;
            l.y cmp2;
            int cmp3;
            int i2;
            final Object obj = this;
            long l3 = l;
            l.f fVar = obj.a;
            if (fVar == null) {
            } else {
                if (!obj.b) {
                } else {
                    long size = fVar.size();
                    cmp = Long.compare(l3, size);
                    cmp4 = 1;
                    final int i7 = 0;
                    if (cmp <= 0) {
                        i4 = Long.compare(l3, i7) >= 0 ? cmp4 : 0;
                        if (i4 == 0) {
                        } else {
                            i3 = size - l3;
                            while (Long.compare(i3, i7) > 0) {
                                l.y yVar = fVar.a;
                                n.d(yVar);
                                cmp4 = yVar.g;
                                n.d(cmp4);
                                int i8 = cmp4.c;
                                l2 = (long)i10;
                                if (Long.compare(l2, i3) > 0) {
                                    break;
                                } else {
                                }
                                fVar.a = cmp4.b();
                                z.b(cmp4);
                                i3 -= l2;
                            }
                            int i5 = 0;
                            obj.i(i5);
                            obj.v = l3;
                            obj.w = i5;
                            cmp = -1;
                            obj.x = cmp;
                            obj.y = cmp;
                            fVar.T(l3);
                            return size;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("newSize < 0: ");
                        stringBuilder.append(l3);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
                        throw illegalArgumentException;
                    }
                    if (cmp > 0) {
                        i = l3 - size;
                        cmp = cmp4;
                        while (Long.compare(i, i7) > 0) {
                            cmp2 = fVar.Y(cmp4);
                            cmp3 = (int)l5;
                            cmp2.c = i13 += cmp3;
                            i -= i4;
                            if (cmp != 0) {
                            }
                            cmp4 = 1;
                            obj.i(cmp2);
                            obj.v = size;
                            obj.w = cmp2.a;
                            int i6 = cmp2.c;
                            obj.x = i6 - cmp3;
                            obj.y = i6;
                            cmp = 0;
                        }
                    }
                }
                IllegalStateException illegalStateException2 = new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
                throw illegalStateException2;
            }
            IllegalStateException illegalStateException = new IllegalStateException("not attached to a buffer".toString());
            throw illegalStateException;
        }

        @Override // java.io.Closeable
        public final int f(long l) {
            Object fVar;
            int i3;
            int i;
            int i6;
            int cmp3;
            int cmp;
            long size;
            boolean z;
            int i4;
            l.y cmp4;
            l.y yVar;
            int cmp5;
            int cmp2;
            int i2;
            int i5;
            long obj14;
            fVar = this.a;
            if (fVar == null) {
            } else {
                i6 = -1;
                if (Long.compare(l, l2) < 0) {
                } else {
                    if (Long.compare(l, size2) > 0) {
                    } else {
                        if (Long.compare(l, i10) != 0) {
                            if (Long.compare(l, size3) == 0) {
                                i3 = 0;
                                i(i3);
                                this.v = l;
                                this.w = i3;
                                this.x = i6;
                                this.y = i6;
                            } else {
                                i = 0;
                                size = fVar.size();
                                cmp4 = fVar.a;
                                if (a() != null) {
                                    l.y yVar5 = a();
                                    n.d(yVar5);
                                    l3 -= l5;
                                    if (Long.compare(i13, l) > 0) {
                                        cmp4 = yVar3;
                                        size = i13;
                                        yVar = i5;
                                    } else {
                                        yVar = yVar2;
                                        i = i5;
                                    }
                                } else {
                                    yVar = cmp4;
                                }
                                if (Long.compare(i14, i2) > 0) {
                                }
                                n.d(yVar);
                                z = yVar.f();
                                if (this.b && yVar.d && fVar.a == yVar) {
                                    n.d(yVar);
                                    if (yVar.d) {
                                        z = yVar.f();
                                        if (fVar.a == yVar) {
                                            fVar.a = z;
                                        }
                                        yVar.c(z);
                                        fVar = z.g;
                                        n.d(fVar);
                                        fVar.b();
                                        yVar = z;
                                    }
                                }
                                i(yVar);
                                this.v = l;
                                n.d(yVar);
                                this.w = yVar.a;
                                i7 += obj14;
                                this.x = i3;
                                obj14 = yVar.c;
                                this.y = obj14;
                                i6 = obj14 - i3;
                            }
                        } else {
                        }
                        return i6;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("offset=");
                stringBuilder.append(l);
                stringBuilder.append(" > size=");
                stringBuilder.append(fVar.size());
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(stringBuilder.toString());
                throw arrayIndexOutOfBoundsException;
            }
            obj14 = new IllegalStateException("not attached to a buffer".toString());
            throw obj14;
        }

        @Override // java.io.Closeable
        public final void i(l.y y) {
            this.c = y;
        }
    }

    public static final class b extends InputStream {

        final l.f a;
        b(l.f f) {
            this.a = f;
            super();
        }

        @Override // java.io.InputStream
        public int available() {
            return (int)l;
        }

        @Override // java.io.InputStream
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            int i;
            if (Long.compare(size, i2) > 0) {
                byte &= 255;
            } else {
                i = -1;
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            n.f(bArr, "sink");
            return this.a.read(bArr, i2, i3);
        }

        @Override // java.io.InputStream
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    public static final class c extends OutputStream {

        final l.f a;
        c(l.f f) {
            this.a = f;
            super();
        }

        @Override // java.io.OutputStream
        public void close() {
        }

        @Override // java.io.OutputStream
        public void flush() {
        }

        @Override // java.io.OutputStream
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".outputStream()");
            return stringBuilder.toString();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.a.z0(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            n.f(bArr, "data");
            this.a.v0(bArr, i2, i3);
        }
    }
    public static l.f.a F(l.f f, l.f.a f$a2, int i3, Object object4) {
        l.f.a obj1;
        if (i3 &= 1 != 0) {
            obj1 = new f.a();
        }
        f.E(obj1);
        return obj1;
    }

    @Override // l.h
    public l.f A() {
        return this;
    }

    @Override // l.h
    public l.f A0(long l) {
        int i3;
        int cmp2;
        int cmp;
        int i4;
        int i;
        int i2;
        int i5;
        byte[] bArr;
        int i6;
        int cmp3;
        byte b;
        byte[] bArr2;
        int obj13;
        i3 = 0;
        cmp2 = Long.compare(l, i3);
        if (cmp2 == 0) {
            z0(48);
        } else {
            i4 = 0;
            if (cmp2 < 0) {
                if (Long.compare(obj13, i3) < 0) {
                    b1("-9223372036854775808");
                } else {
                    i4 = i;
                    i2 = 10;
                    if (Long.compare(obj13, i7) < 0 && Long.compare(obj13, i8) < 0) {
                        if (Long.compare(obj13, i8) < 0) {
                            if (Long.compare(obj13, i9) < 0) {
                                if (Long.compare(obj13, i5) < 0) {
                                } else {
                                    i = 2;
                                }
                            } else {
                                cmp = Long.compare(obj13, i5) < 0 ? 3 : 4;
                                i = cmp;
                            }
                        } else {
                        }
                    } else {
                    }
                    if (i4 != 0) {
                        i++;
                    }
                    cmp2 = Y(i);
                    bArr = cmp2.a;
                    i11 += i;
                    while (Long.compare(obj13, i3) != 0) {
                        cmp3 = (long)i2;
                        bArr[i6--] = a.b()[(int)i12];
                        obj13 /= cmp3;
                    }
                    if (i4 != 0) {
                        bArr[i6--] = (byte)obj13;
                    }
                    cmp2.c = obj13 += i;
                    T(obj13 += i3);
                }
            } else {
            }
        }
        return this;
    }

    @Override // l.h
    public l.i B(long l) {
        int cmp;
        int i;
        l.i iVar;
        int obj3;
        if (Long.compare(l, i2) >= 0 && Long.compare(l, l2) <= 0) {
            i = Long.compare(l, l2) <= 0 ? 1 : 0;
        } else {
        }
        if (i == 0) {
        } else {
            if (Long.compare(size, l) < 0) {
            } else {
                if (Long.compare(l, l3) >= 0) {
                    iVar = V((int)l);
                    skip(l);
                } else {
                    iVar = new i(p1(l));
                }
                return iVar;
            }
            obj3 = new EOFException();
            throw obj3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount: ");
        stringBuilder.append(l);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString().toString());
        throw obj4;
    }

    @Override // l.h
    public l.f C0(long l) {
        int cmp;
        int i4;
        int i;
        l.y yVar;
        byte[] bArr;
        int i3;
        int i5;
        int i2;
        int i6;
        int i7;
        long l2;
        int obj13;
        if (Long.compare(l, i8) == 0) {
            z0(48);
        } else {
            i4 = 1;
            i9 |= l;
            int i26 = 2;
            i10 |= i27;
            i3 = 4;
            i11 |= i28;
            int i29 = 8;
            i12 |= i32;
            int i33 = 16;
            i13 |= i35;
            i6 = 32;
            i14 |= i38;
            i15 -= i40;
            l2 = 3689348814741910323L;
            i42 += i17;
            i19 &= l5;
            i20 += i44;
            i21 += i30;
            int i31 = 63;
            i = (int)i7;
            yVar = Y(i);
            i5 = yVar.c;
            i34 -= i4;
            while (i2 >= i5) {
                yVar.a[i2] = a.b()[(int)i37];
                obj13 >>>= i3;
                i2--;
            }
            yVar.c = obj13 += i;
            T(obj13 += cmp);
        }
        return this;
    }

    @Override // l.h
    public final l.f.a E(l.f.a f$a) {
        n.f(a, "unsafeCursor");
        a.a(this, a);
        return a;
    }

    @Override // l.h
    public l.g E0(String string) {
        b1(string);
        return this;
    }

    @Override // l.h
    public l.g G() {
        k();
        return this;
    }

    @Override // l.h
    public l.f G0(int i) {
        l.y yVar = Y(4);
        final byte[] bArr = yVar.a;
        int i4 = yVar.c;
        int i8 = i4 + 1;
        bArr[i4] = (byte)i11;
        int i5 = i8 + 1;
        bArr[i8] = (byte)i13;
        int i9 = i5 + 1;
        bArr[i5] = (byte)i15;
        bArr[i9] = (byte)obj6;
        yVar.c = i9 + 1;
        T(size += i7);
        return this;
    }

    @Override // l.h
    public int H() {
        return c.c(readInt());
    }

    @Override // l.h
    public l.g I(int i) {
        L0(i);
        return this;
    }

    @Override // l.h
    public l.f I0(long l) {
        int i = 8;
        final l.y yVar = Y(i);
        final byte[] bArr = yVar.a;
        int i5 = yVar.c;
        int i9 = i5 + 1;
        final int i39 = 255;
        bArr[i5] = (byte)i16;
        int i6 = i9 + 1;
        bArr[i9] = (byte)i20;
        int i10 = i6 + 1;
        bArr[i6] = (byte)i24;
        int i7 = i10 + 1;
        bArr[i10] = (byte)i28;
        int i11 = i7 + 1;
        bArr[i7] = (byte)i32;
        int i8 = i11 + 1;
        bArr[i11] = (byte)i36;
        int i12 = i8 + 1;
        bArr[i8] = (byte)i2;
        bArr[i12] = (byte)obj10;
        yVar.c = i12 + 1;
        T(obj10 += i4);
        return this;
    }

    @Override // l.h
    public short J() {
        return c.d(readShort());
    }

    @Override // l.h
    public long J1(l.b0 b0) {
        n.f(b0, "sink");
        long size = size();
        if (Long.compare(size, i) > 0) {
            b0.write(this, size);
        }
        return size;
    }

    @Override // l.h
    public String K(long l, Charset charset2) {
        int cmp;
        int i;
        int obj7;
        n.f(obj9, "charset");
        int cmp2 = Long.compare(l, i2);
        if (cmp2 >= 0 && Long.compare(l, l2) <= 0) {
            i = Long.compare(l, l2) <= 0 ? 1 : 0;
        } else {
        }
        if (i == 0) {
        } else {
            if (Long.compare(l3, l) < 0) {
            } else {
                if (cmp2 == 0) {
                    return "";
                }
                l.y yVar = this.a;
                n.d(yVar);
                int i4 = yVar.b;
                if (Long.compare(i6, l6) > 0) {
                    String obj8 = new String(p1(l), obj9);
                    return obj8;
                }
                final int i7 = (int)l;
                String string = new String(yVar.a, i4, i7, obj9);
                obj9 += i7;
                yVar.b = obj9;
                this.b = l4 -= l;
                if (obj9 == yVar.c) {
                    this.a = yVar.b();
                    z.b(yVar);
                }
                return string;
            }
            obj7 = new EOFException();
            throw obj7;
        }
        StringBuilder obj9 = new StringBuilder();
        obj9.append("byteCount: ");
        obj9.append(l);
        obj8 = new IllegalArgumentException(obj9.toString().toString());
        throw obj8;
    }

    @Override // l.h
    public boolean K0(long l, l.i i2) {
        n.f(obj10, "bytes");
        return this.x(l, obj3, obj10, 0);
    }

    @Override // l.h
    public String L(long l) {
        return K(l, obj3);
    }

    @Override // l.h
    public l.f L0(int i) {
        l.y yVar = Y(2);
        final byte[] bArr = yVar.a;
        int i4 = yVar.c;
        final int i7 = i4 + 1;
        bArr[i4] = (byte)i9;
        bArr[i7] = (byte)obj6;
        yVar.c = i7 + 1;
        T(size += i6);
        return this;
    }

    @Override // l.h
    public int M() {
        int i3;
        byte b;
        int i5;
        int i4;
        int i6;
        int i7;
        int i;
        int cmp;
        long l;
        int i2;
        int i13 = 0;
        if (Long.compare(size, i13) == 0) {
        } else {
            b = n(i13);
            int i14 = 128;
            if (b & 128 == 0) {
                i5 = b & 127;
                i = i17;
                i7 = i4;
                l = (long)i7;
                if (Long.compare(size3, l) < 0) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("size < ");
                stringBuilder.append(i7);
                stringBuilder.append(": ");
                stringBuilder.append(size());
                stringBuilder.append(" (to read code point prefixed 0x");
                stringBuilder.append(c.e(b));
                stringBuilder.append(')');
                EOFException eOFException2 = new EOFException(stringBuilder.toString());
                throw eOFException2;
            } else {
                if (b & 224 == 192) {
                    i5 = b & 31;
                    i7 = 2;
                    i = i14;
                } else {
                    if (b & 240 == 224) {
                        i5 = b & 15;
                        i7 = 3;
                        i = 2048;
                    } else {
                        i5 = b & 248;
                        if (i5 == 240) {
                            i5 = b & 7;
                            i7 = 4;
                            i = 65536;
                        }
                    }
                }
            }
            skip(1);
            return i6;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    @Override // l.h
    public String M0(Charset charset) {
        n.f(charset, "charset");
        return K(this.b, obj1);
    }

    @Override // l.h
    public l.g P(int i) {
        G0(i);
        return this;
    }

    @Override // l.h
    public l.f Q0(String string, int i2, int i3, Charset charset4) {
        int i;
        int i4;
        int i5;
        n.f(string, "string");
        n.f(charset4, "charset");
        i = 1;
        final int i6 = 0;
        i4 = i2 >= 0 ? i : i6;
        if (i4 == 0) {
        } else {
            i5 = i3 >= i2 ? i : i6;
            if (i5 == 0) {
            } else {
                if (i3 <= string.length()) {
                } else {
                    i = i6;
                }
                if (i == 0) {
                } else {
                    if (n.b(charset4, d.a)) {
                        e1(string, i2, i3);
                        return this;
                    }
                    String obj4 = string.substring(i2, i3);
                    n.e(obj4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Objects.requireNonNull(obj4, "null cannot be cast to non-null type java.lang.String");
                    obj4 = obj4.getBytes(charset4);
                    n.e(obj4, "(this as java.lang.String).getBytes(charset)");
                    v0(obj4, i6, obj4.length);
                    return this;
                }
                StringBuilder obj5 = new StringBuilder();
                obj5.append("endIndex > string.length: ");
                obj5.append(i3);
                obj5.append(" > ");
                obj5.append(string.length());
                obj5 = new IllegalArgumentException(obj5.toString().toString());
                throw obj5;
            }
            obj4 = new StringBuilder();
            obj4.append("endIndex < beginIndex: ");
            obj4.append(i3);
            obj4.append(" < ");
            obj4.append(i2);
            obj5 = new IllegalArgumentException(obj4.toString().toString());
            throw obj5;
        }
        obj4 = new StringBuilder();
        obj4.append("beginIndex < 0: ");
        obj4.append(i2);
        obj5 = new IllegalArgumentException(obj4.toString().toString());
        throw obj5;
    }

    @Override // l.h
    public final void T(long l) {
        this.b = l;
    }

    @Override // l.h
    public final l.i U() {
        int i;
        long l = (long)i3;
        i = Long.compare(size, l) <= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return V((int)size2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size > Int.MAX_VALUE: ");
        stringBuilder.append(size());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException;
    }

    @Override // l.h
    public l.g U0(String string, int i2, int i3) {
        e1(string, i2, i3);
        return this;
    }

    @Override // l.h
    public final l.i V(int i) {
        byte[][] bArr;
        l.y yVar;
        int i5;
        int[] iArr;
        int i2;
        int i6;
        int i4;
        long l;
        l.y yVar2;
        int i7;
        int i3;
        l.i obj9;
        if (i == 0) {
            obj9 = i.c;
        } else {
            c.b(size(), obj1, 0);
            yVar = this.a;
            i5 = 0;
            i6 = i2;
            while (i2 < i) {
                n.d(yVar);
                int i10 = yVar.c;
                yVar2 = yVar.b;
                i2 += l;
                i6++;
                yVar = yVar.f;
            }
            bArr = new byte[i6];
            iArr = new int[i6 * 2];
            yVar2 = yVar3;
            i4 = i5;
            while (i5 < i) {
                n.d(yVar2);
                bArr[i4] = yVar2.a;
                iArr[i4] = Math.min(i5 += i12, i);
                iArr[i4 + i6] = yVar2.b;
                i7 = 1;
                yVar2.d = i7;
                i4 += i7;
                yVar2 = yVar2.f;
            }
            obj9 = new a0(bArr, iArr);
        }
        return obj9;
    }

    @Override // l.h
    public l.f V0(String string, Charset charset2) {
        n.f(string, "string");
        n.f(charset2, "charset");
        Q0(string, 0, string.length(), charset2);
        return this;
    }

    @Override // l.h
    public void V1(long l) {
        if (Long.compare(l2, l) < 0) {
        } else {
        }
        EOFException obj3 = new EOFException();
        throw obj3;
    }

    @Override // l.h
    public long W0(l.d0 d0) {
        int i;
        long read;
        int cmp;
        n.f(d0, "source");
        i = 0;
        read = d0.read(this, (long)i2);
        while (Long.compare(read, i3) == 0) {
            i += read;
            read = d0.read(this, (long)i2);
        }
        return i;
    }

    @Override // l.h
    public byte[] X() {
        return p1(size());
    }

    @Override // l.h
    public l.g X0(long l) {
        C0(l);
        return this;
    }

    @Override // l.h
    public final l.y Y(int i) {
        int i3;
        l.y yVar;
        int i2;
        int obj4;
        int i4 = 8192;
        if (i >= 1 && i <= i4) {
            if (i <= i4) {
            } else {
                i3 = 0;
            }
        } else {
        }
        if (i3 == 0) {
        } else {
            yVar = this.a;
            if (yVar == null) {
                obj4 = z.c();
                this.a = obj4;
                obj4.g = obj4;
                obj4.f = obj4;
            } else {
                n.d(yVar);
                yVar = yVar.g;
                n.d(yVar);
                if (i5 += i <= i4) {
                    if (!yVar.e) {
                        yVar.c(z.c());
                    } else {
                        obj4 = yVar;
                    }
                } else {
                }
            }
            return obj4;
        }
        obj4 = new IllegalArgumentException("unexpected capacity".toString());
        throw obj4;
    }

    @Override // l.h
    public l.i Y0() {
        return B(size());
    }

    @Override // l.h
    public l.g Y1(long l) {
        A0(l);
        return this;
    }

    @Override // l.h
    public final void a() {
        skip(size());
    }

    @Override // l.h
    public long a0(l.i i) {
        n.f(i, "bytes");
        return r(i, 0);
    }

    @Override // l.h
    public final l.f a1(OutputStream outputStream, long l2) {
        l.y yVar;
        long l3;
        long l;
        int i;
        long i2;
        int obj9;
        n.f(outputStream, "out");
        c.b(this.b, obj2, 0);
        yVar = this.a;
        while (Long.compare(obj9, i3) > 0) {
            n.d(yVar);
            int i7 = yVar.b;
            int i6 = (int)l5;
            outputStream.write(yVar.a, yVar.b, i6);
            i8 += i6;
            yVar.b = l;
            i2 = (long)i6;
            this.b = l6 -= i2;
            obj9 -= i2;
            if (l == yVar.c) {
            }
            l3 = yVar.b();
            this.a = l3;
            z.b(yVar);
            yVar = l3;
        }
        return this;
    }

    @Override // l.h
    public l.g b(byte[] bArr, int i2, int i3) {
        v0(bArr, i2, i3);
        return this;
    }

    @Override // l.h
    public boolean b0() {
        int i;
        i = Long.compare(l, i2) == 0 ? 1 : 0;
        return i;
    }

    @Override // l.h
    public l.f b1(String string) {
        n.f(string, "string");
        e1(string, 0, string.length());
        return this;
    }

    @Override // l.h
    public OutputStream b2() {
        f.c cVar = new f.c(this);
        return cVar;
    }

    @Override // l.h
    public l.f c() {
        return f();
    }

    @Override // l.h
    public l.g c0(int i) {
        z0(i);
        return this;
    }

    @Override // l.h
    public Object clone() {
        return c();
    }

    @Override // l.h
    public void close() {
    }

    @Override // l.h
    public long d2() {
        int i4;
        int i3;
        int i;
        l.y yVar2;
        l.y yVar;
        int i2;
        int i5;
        byte b;
        byte b2;
        byte cmp;
        int i7 = 0;
        if (Long.compare(size, i7) == 0) {
        } else {
            i3 = i4;
            i = i7;
            while (/* condition */) {
                while (i2 < i5) {
                    b = yVar[i2];
                    byte b3 = (byte)i10;
                    i12 += 10;
                    i8 |= b;
                    i2++;
                    i4++;
                    b2 = b - b3;
                }
                if (i2 == i5) {
                } else {
                }
                yVar2.b = i2;
                if (i3 == 0) {
                }
                if (this.a != null) {
                }
                yVar2 = this.a;
                n.d(yVar2);
                i2 = yVar2.b;
                i5 = yVar2.c;
                this.a = yVar2.b();
                z.b(yVar2);
                b = yVar2.a[i2];
                b3 = (byte)i10;
                i3 = 1;
                i12 += 10;
                i8 |= b;
                i2++;
                i4++;
                b2 = b - b3;
            }
            f fVar = new f();
            fVar.C0(i);
            fVar.z0(b);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Number too large: ");
            stringBuilder2.append(fVar.r1());
            NumberFormatException numberFormatException2 = new NumberFormatException(stringBuilder2.toString());
            throw numberFormatException2;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    @Override // l.h
    public final long e() {
        long size;
        int i2;
        l.y yVar;
        int i;
        int cmp;
        size = size();
        if (Long.compare(size, i2) == 0) {
        } else {
            l.y yVar2 = this.a;
            n.d(yVar2);
            yVar = yVar2.g;
            n.d(yVar);
            i = yVar.c;
            if (i < 8192 && yVar.e) {
                if (yVar.e) {
                    size -= yVar;
                }
            }
            i2 = size;
        }
        return i2;
    }

    @Override // l.h
    public l.f e0(l.i i) {
        n.f(i, "byteString");
        i.F(this, 0, i.A());
        return this;
    }

    @Override // l.h
    public l.f e1(String string, int i2, int i3) {
        int i6;
        int i7;
        int charAt;
        byte b2;
        int i5;
        long l;
        byte[] bArr;
        int i8;
        int charAt2;
        int i;
        int i4;
        byte b;
        int obj13;
        n.f(string, "string");
        int i9 = 0;
        final int i10 = 1;
        i6 = i2 >= 0 ? i10 : i9;
        if (i6 == 0) {
        } else {
            i7 = i3 >= i2 ? i10 : i9;
            if (i7 == 0) {
            } else {
                charAt = i3 <= string.length() ? i10 : i9;
                if (charAt == 0) {
                }
                obj13 = new StringBuilder();
                obj13.append("endIndex > string.length: ");
                obj13.append(i3);
                obj13.append(" > ");
                obj13.append(string.length());
                obj13 = new IllegalArgumentException(obj13.toString().toString());
                throw obj13;
            }
            StringBuilder obj12 = new StringBuilder();
            obj12.append("endIndex < beginIndex: ");
            obj12.append(i3);
            obj12.append(" < ");
            obj12.append(i2);
            obj13 = new IllegalArgumentException(obj12.toString().toString());
            throw obj13;
        }
        obj12 = new StringBuilder();
        obj12.append("beginIndex < 0: ");
        obj12.append(i2);
        obj13 = new IllegalArgumentException(obj12.toString().toString());
        throw obj13;
    }

    @Override // l.h
    public boolean equals(Object object) {
        Object obj;
        int i;
        boolean cmp3;
        byte b;
        int size;
        byte b2;
        int i7;
        long cmp2;
        int i2;
        int i3;
        byte[] cmp;
        int i4;
        int i6;
        int i5;
        final Object obj2 = this;
        obj = object;
        i = 0;
        if (obj2 == obj) {
            i = i8;
        } else {
        }
        return i;
    }

    @Override // l.h
    public final l.f f() {
        int size;
        l.y yVar2;
        int i;
        l.y yVar3;
        l.y yVar;
        f fVar = new f();
        if (Long.compare(size2, i) == 0) {
        } else {
            l.y yVar4 = this.a;
            n.d(yVar4);
            yVar2 = yVar4.d();
            fVar.a = yVar2;
            yVar2.g = yVar2;
            yVar2.f = yVar2;
            i = yVar4.f;
            while (i != yVar4) {
                yVar3 = yVar2.g;
                n.d(yVar3);
                n.d(i);
                yVar3.c(i.d());
                i = i.f;
            }
            fVar.T(size());
        }
        return fVar;
    }

    @Override // l.h
    public void flush() {
    }

    @Override // l.h
    public l.f g0(l.d0 d0, long l2) {
        String read;
        int cmp;
        int obj6;
        n.f(d0, "source");
        while (Long.compare(obj6, i) > 0) {
            read = d0.read(this, obj6);
            obj6 -= read;
        }
        return this;
    }

    @Override // l.h
    public l.f g1(int i) {
        int i6;
        int i3;
        int i4;
        l.y yVar;
        byte[] bArr;
        int i5;
        int i2;
        byte b;
        byte obj9;
        i6 = 128;
        if (i < i6) {
            z0(i);
            return this;
        } else {
            i4 = 63;
            if (i < 2048) {
                i3 = 2;
                yVar = Y(i3);
                bArr = yVar.a;
                int i10 = yVar.c;
                bArr[i10] = (byte)i14;
                bArr[i10 + 1] = (byte)obj9;
                yVar.c = i10 += i3;
                T(size += i4);
            } else {
                if (55296 > i) {
                    if (i < 65536) {
                        i3 = 3;
                        yVar = Y(i3);
                        bArr = yVar.a;
                        int i12 = yVar.c;
                        bArr[i12] = (byte)i20;
                        bArr[i12 + 1] = (byte)i30;
                        bArr[i12 + 2] = (byte)obj9;
                        yVar.c = i12 += i3;
                        T(size3 += i4);
                    } else {
                        if (i > 1114111) {
                        } else {
                            i3 = 4;
                            yVar = Y(i3);
                            bArr = yVar.a;
                            int i11 = yVar.c;
                            bArr[i11] = (byte)i16;
                            bArr[i11 + 1] = (byte)i24;
                            bArr[i11 + 2] = (byte)i27;
                            bArr[i11 + 3] = (byte)obj9;
                            yVar.c = i11 += i3;
                            T(size2 += i4);
                        }
                    }
                } else {
                    if (57343 >= i) {
                        z0(i4);
                    } else {
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected code point: 0x");
        stringBuilder.append(c.f(i));
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // l.h
    public InputStream g2() {
        f.b bVar = new f.b(this);
        return bVar;
    }

    @Override // l.h
    public l.f h() {
        return this;
    }

    @Override // l.h
    public int hashCode() {
        l.y yVar2;
        int i3;
        l.y yVar;
        int i;
        int i2;
        byte b;
        if (this.a != null) {
            i3 = 1;
            do {
                i = yVar2.b;
                while (i < yVar2.c) {
                    i4 += b;
                    i++;
                }
                yVar2 = yVar2.f;
                n.d(yVar2);
                if (yVar2 != this.a) {
                }
                i4 += b;
                i++;
            } while (/* condition */);
        } else {
            i3 = 0;
        }
        return i3;
    }

    @Override // l.h
    public int i2(l.t t) {
        int i2;
        int i;
        Object obj4;
        n.f(t, "options");
        final int i5 = 0;
        i2 = a.f(this, t, false, 2, i5);
        i = -1;
        if (i2 == i) {
            i2 = i;
        } else {
            skip((long)obj4);
        }
        return i2;
    }

    @Override // l.h
    public boolean isOpen() {
        return 1;
    }

    @Override // l.h
    public final l.f j(l.f f, long l2, long l3) {
        l.y cmp2;
        int cmp3;
        int i;
        long l;
        int cmp;
        long obj9;
        int obj10;
        int obj11;
        n.f(f, "out");
        cmp3 = l2;
        c.b(size(), obj2, cmp3);
        int i2 = 0;
        if (Long.compare(obj11, i2) == 0) {
        } else {
            f.T(size2 += obj11);
            cmp2 = this.a;
            n.d(cmp2);
            i = cmp2.c;
            l = cmp2.b;
            while (Long.compare(obj9, l4) >= 0) {
                obj9 -= cmp3;
                cmp2 = cmp2.f;
                n.d(cmp2);
                i = cmp2.c;
                l = cmp2.b;
            }
            while (Long.compare(obj11, i2) > 0) {
                n.d(cmp2);
                i = cmp2.d();
                i5 += obj9;
                i.b = i6;
                i.c = Math.min(i6 += obj9, i.c);
                obj9 = f.a;
                if (obj9 == null) {
                } else {
                }
                n.d(obj9);
                obj9 = obj9.g;
                n.d(obj9);
                obj9.c(i);
                obj11 -= obj9;
                cmp2 = cmp2.f;
                obj9 = i2;
                i.g = i;
                i.f = i;
                f.a = i;
            }
        }
        return this;
    }

    @Override // l.h
    public l.f k() {
        return this;
    }

    @Override // l.h
    public void k0(l.f f, long l2) {
        n.f(f, "sink");
        if (Long.compare(size, l2) < 0) {
        } else {
            f.write(this, l2);
        }
        f.write(this, size());
        EOFException obj3 = new EOFException();
        throw obj3;
    }

    @Override // l.h
    public l.f m() {
        return this;
    }

    @Override // l.h
    public l.f m0(byte[] bArr) {
        n.f(bArr, "source");
        v0(bArr, 0, bArr.length);
        return this;
    }

    @Override // l.h
    public String m1() {
        return r0(Long.MAX_VALUE);
    }

    @Override // l.h
    public final byte n(long l) {
        int i3;
        l.y yVar;
        int size;
        byte[] bArr;
        long l2;
        int i2;
        int i;
        int cmp;
        byte obj7;
        c.b(size(), obj1, l);
        if (this.a != null) {
            if (Long.compare(i5, l) < 0) {
                size = size();
                while (Long.compare(size, l) > 0) {
                    yVar = yVar.g;
                    n.d(yVar);
                    size -= l2;
                }
                n.d(yVar);
                obj7 = yVar.a[(int)i2];
            } else {
                size = 0;
                l4 += size;
                while (Long.compare(l2, l) > 0) {
                    n.d(yVar.f);
                    size = l2;
                    l4 += size;
                }
                n.d(yVar);
                obj7 = yVar.a[(int)i2];
            }
        } else {
            int i4 = 0;
            n.d(i4);
            obj7 = i4.a[(int)i2];
        }
        return obj7;
    }

    @Override // l.h
    public long n0(l.i i) {
        n.f(i, "targetBytes");
        return w(i, 0);
    }

    @Override // l.h
    public long o(byte b, long l2, long l3) {
        int size;
        int i3;
        int cmp;
        int cmp4;
        int i4;
        int cmp3;
        int i2;
        long cmp2;
        int i;
        byte obj11;
        int obj12;
        byte obj13;
        int obj14;
        if (Long.compare(size, l2) > 0) {
            i3 = 0;
        } else {
            if (Long.compare(obj14, l2) >= 0) {
                i3 = 1;
            } else {
            }
        }
        if (i3 == 0) {
        } else {
            if (Long.compare(obj14, size3) > 0) {
                obj14 = size();
            }
            i4 = -1;
            if (Long.compare(l2, obj14) == 0) {
            } else {
                if (this.a != null && Long.compare(i5, l2) < 0) {
                    if (Long.compare(i5, l2) < 0) {
                        size = size();
                        while (Long.compare(size, l2) > 0) {
                            cmp = cmp.g;
                            n.d(cmp);
                            size -= cmp3;
                        }
                        if (cmp != null) {
                        }
                    }
                }
            }
            return i4;
        }
        obj11 = new StringBuilder();
        obj11.append("size=");
        obj11.append(size());
        obj11.append(" fromIndex=");
        obj11.append(l2);
        obj11.append(" toIndex=");
        obj11.append(obj14);
        obj12 = new IllegalArgumentException(obj11.toString().toString());
        throw obj12;
    }

    @Override // l.h
    public l.g o0() {
        m();
        return this;
    }

    @Override // l.h
    public long p0() {
        int i3;
        int i2;
        int i5;
        int i4;
        int cmp;
        long l;
        l.y yVar3;
        l.y yVar2;
        byte[] bArr;
        int i;
        int i6;
        int cmp2;
        byte b2;
        byte b;
        int i7;
        l.y yVar;
        final Object obj = this;
        if (Long.compare(size, i2) == 0) {
        } else {
            i3 = -7;
            cmp = i4;
            while (/* condition */) {
                cmp2 = 1;
                while (i < i6) {
                    b2 = bArr[i];
                    b = (byte)i13;
                    i7 = cmp;
                    yVar = yVar2;
                    i3 -= i10;
                    i4 = cmp2;
                    i++;
                    i5++;
                    cmp = i7;
                    yVar2 = yVar;
                    cmp2 = 1;
                    b -= b2;
                    cmp2 = Long.compare(i2, i7);
                    i7 = cmp;
                    yVar = yVar2;
                    i9 += l;
                }
                i7 = cmp;
                yVar = yVar2;
                if (i == i6) {
                } else {
                }
                yVar3.b = i;
                if (cmp == 0) {
                }
                if (obj.a != null) {
                }
                yVar2 = obj.a;
                n.d(yVar2);
                i = yVar2.b;
                i6 = yVar2.c;
                obj.a = yVar.b();
                z.b(yVar);
                b2 = yVar2.a[i];
                b = (byte)i13;
                i7 = cmp;
                yVar = yVar2;
                cmp = cmp2;
                i3 -= i10;
                i4 = cmp2;
                i++;
                i5++;
                cmp = i7;
                yVar2 = yVar;
                b -= b2;
                cmp2 = Long.compare(i2, i7);
                i7 = cmp;
                yVar = yVar2;
                i9 += l;
            }
            f fVar = new f();
            fVar.A0(i2);
            fVar.z0(b2);
            if (i4 != 0) {
            } else {
                fVar.readByte();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Number too large: ");
            stringBuilder2.append(fVar.r1());
            NumberFormatException numberFormatException2 = new NumberFormatException(stringBuilder2.toString());
            throw numberFormatException2;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    @Override // l.h
    public byte[] p1(long l) {
        int cmp;
        int i;
        if (Long.compare(l, i2) >= 0 && Long.compare(l, l2) <= 0) {
            i = Long.compare(l, l2) <= 0 ? 1 : 0;
        } else {
        }
        if (i == 0) {
        } else {
            if (Long.compare(size, l) < 0) {
            } else {
                byte[] obj3 = new byte[(int)l];
                readFully(obj3);
                return obj3;
            }
            obj3 = new EOFException();
            throw obj3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount: ");
        stringBuilder.append(l);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString().toString());
        throw obj4;
    }

    @Override // l.h
    public l.h peek() {
        v vVar = new v(this);
        return q.d(vVar);
    }

    @Override // l.h
    public long r(l.i i, long l2) {
        int i3;
        int i2;
        int i11;
        int i10;
        int i8;
        int obj;
        byte i9;
        int cmp3;
        int size;
        int i6;
        boolean z;
        l.y yVar;
        int cmp;
        long l;
        int i4;
        long l4;
        int cmp2;
        int i7;
        int i5;
        long l3;
        int i12;
        Object obj19;
        i3 = l2;
        n.f(i, "bytes");
        i9 = 0;
        i10 = i.A() > 0 ? 1 : i9;
        if (i10 == 0) {
        } else {
            i8 = Long.compare(i3, size) >= 0 ? 1 : i9;
            if (i8 == 0) {
            } else {
                if (obj3.a != null) {
                    i7 = 1;
                    if (Long.compare(i31, i3) < 0) {
                        size = size();
                        while (Long.compare(size, i3) > 0) {
                            yVar = yVar.g;
                            n.d(yVar);
                            size -= l3;
                        }
                        if (yVar != null) {
                            cmp2 = i.q();
                            obj = i.A();
                            i40 += i7;
                            while (Long.compare(size, l3) < 0) {
                                i3 = obj19;
                                i6 = (int)i25;
                                while (i6 < (int)l7) {
                                    i6++;
                                }
                                n.d(yVar.f);
                                i3 = size;
                                i6++;
                            }
                            i4 = -1;
                        } else {
                        }
                    }
                } else {
                }
                return i4;
            }
            Object obj4 = this;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fromIndex < 0: ");
            stringBuilder.append(i3);
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException2;
        }
        Object obj2 = this;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bytes is empty".toString());
        throw illegalArgumentException;
    }

    @Override // l.h
    public String r0(long l) {
        int i;
        int l2;
        int i2;
        byte b;
        int cmp;
        String obj12;
        i = Long.compare(l, i3) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            i2 = 1;
            if (Long.compare(l, l2) == 0) {
            } else {
                l2 = l + i2;
            }
            byte b2 = (byte)i5;
            byte b3 = b2;
            cmp = this.o(b3, 0, obj8);
            if (Long.compare(cmp, i10) != 0) {
                obj12 = a.d(this, cmp);
                return obj12;
            } else {
                cmp = Long.compare(l2, size3);
                if (cmp >= 0) {
                } else {
                    if (n(l2 - i2) != (byte)i8) {
                    } else {
                        if (n(l2) != b2) {
                        } else {
                            obj12 = a.d(this, l2);
                        }
                    }
                }
            }
            f fVar2 = new f();
            this.j(fVar2, 0, i2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("\\n not found: limit=");
            stringBuilder2.append(Math.min(size(), i2));
            stringBuilder2.append(" content=");
            stringBuilder2.append(fVar2.Y0().p());
            stringBuilder2.append('\u2026');
            EOFException eOFException = new EOFException(stringBuilder2.toString());
            throw eOFException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("limit < 0: ");
        stringBuilder.append(l);
        IllegalArgumentException obj13 = new IllegalArgumentException(stringBuilder.toString().toString());
        throw obj13;
    }

    @Override // l.h
    public String r1() {
        return K(this.b, obj1);
    }

    @Override // l.h
    public int read(ByteBuffer byteBuffer) {
        int obj7;
        n.f(byteBuffer, "sink");
        l.y yVar = this.a;
        int i = Math.min(byteBuffer.remaining(), i2 -= i6);
        byteBuffer.put(yVar.a, yVar.b, i);
        obj7 += i;
        yVar.b = obj7;
        this.b = l -= l2;
        if (yVar != null && obj7 == yVar.c) {
            i = Math.min(byteBuffer.remaining(), i2 -= i6);
            byteBuffer.put(yVar.a, yVar.b, i);
            obj7 += i;
            yVar.b = obj7;
            this.b = l -= l2;
            if (obj7 == yVar.c) {
                this.a = yVar.b();
                z.b(yVar);
            }
            return i;
        }
        return -1;
    }

    @Override // l.h
    public int read(byte[] bArr, int i2, int i3) {
        long l;
        long i;
        long i4;
        Object obj8;
        int obj9;
        int obj10;
        n.f(bArr, "sink");
        c.b((long)length, obj2, (long)i2);
        l.y yVar = this.a;
        if (yVar != null) {
            obj10 = Math.min(i3, i5 -= i7);
            i = yVar.b;
            i.e(yVar.a, bArr, i2, i, i + obj10);
            yVar.b = obj8 += obj10;
            T(obj8 -= l);
            if (yVar.b == yVar.c) {
                this.a = yVar.b();
                z.b(yVar);
            }
        } else {
            obj10 = -1;
        }
        return obj10;
    }

    @Override // l.h
    public long read(l.f f, long l2) {
        int cmp;
        int i;
        int obj5;
        int obj6;
        n.f(f, "sink");
        int i2 = 0;
        i = Long.compare(l2, i2) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            if (Long.compare(size2, i2) == 0) {
                obj5 = -1;
            } else {
                if (Long.compare(l2, size) > 0) {
                    obj6 = size();
                }
                f.write(this, obj6);
                obj5 = obj6;
            }
            return obj5;
        }
        obj5 = new StringBuilder();
        obj5.append("byteCount < 0: ");
        obj5.append(l2);
        obj6 = new IllegalArgumentException(obj5.toString().toString());
        throw obj6;
    }

    @Override // l.h
    public byte readByte() {
        int i;
        if (Long.compare(size, i3) == 0) {
        } else {
            l.y yVar = this.a;
            n.d(yVar);
            int i2 = yVar.b;
            final int i4 = i2 + 1;
            T(size2 -= i6);
            if (i4 == yVar.c) {
                this.a = yVar.b();
                z.b(yVar);
            } else {
                yVar.b = i4;
            }
            return yVar.a[i2];
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    @Override // l.h
    public void readFully(byte[] bArr) {
        int i;
        int read;
        int i2;
        n.f(bArr, "sink");
        i = 0;
        while (i < bArr.length) {
            read = read(bArr, i, length2 -= i);
            i += read;
        }
    }

    @Override // l.h
    public int readInt() {
        int i;
        int i4;
        int i3;
        int cmp;
        int i2;
        int i5;
        i3 = 4;
        if (Long.compare(size, i3) < 0) {
        } else {
            l.y yVar = this.a;
            n.d(yVar);
            int i10 = yVar.b;
            final int i19 = yVar.c;
            if (Long.compare(l, i3) < 0) {
                i9 |= i4;
            } else {
                byte[] bArr = yVar.a;
                int i22 = i10 + 1;
                int i25 = i22 + 1;
                i2 = i25 + 1;
                i5 = i2 + 1;
                T(size2 -= i3);
                if (i5 == i19) {
                    this.a = yVar.b();
                    z.b(yVar);
                } else {
                    yVar.b = i5;
                }
                i = i4;
            }
            return i;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    @Override // l.h
    public long readLong() {
        int i8;
        int i9;
        int i6;
        int i4;
        int cmp;
        int i;
        int i7;
        int i2;
        byte b;
        int i5;
        int i3;
        i6 = 8;
        if (Long.compare(size, i6) < 0) {
        } else {
            l.y yVar = this.a;
            n.d(yVar);
            i9 = yVar.b;
            i4 = yVar.c;
            i = 32;
            if (Long.compare(l3, i6) < 0) {
                long l2 = 4294967295L;
                i11 |= i6;
            } else {
                byte[] bArr = yVar.a;
                int i23 = i9 + 1;
                i5 = 255;
                int i13 = i23 + 1;
                int i33 = i13 + 1;
                int i15 = i33 + 1;
                int i29 = i15 + 1;
                int i17 = i29 + 1;
                int i32 = i17 + 1;
                i9 = i32 + 1;
                l6 &= i5;
                T(size2 -= i6);
                if (i9 == i4) {
                    this.a = yVar.b();
                    z.b(yVar);
                } else {
                    yVar.b = i9;
                }
                i8 = cmp;
            }
            return i8;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    @Override // l.h
    public short readShort() {
        short s;
        int i4;
        int i5;
        int i;
        int i3;
        int i2;
        i5 = 2;
        if (Long.compare(size, i5) < 0) {
        } else {
            l.y yVar = this.a;
            n.d(yVar);
            int i9 = yVar.b;
            final int i12 = yVar.c;
            if (i12 - i9 < 2) {
                s = (short)i8;
            } else {
                byte[] bArr = yVar.a;
                i3 = i9 + 1;
                i2 = i3 + 1;
                T(size2 -= i5);
                if (i2 == i12) {
                    this.a = yVar.b();
                    z.b(yVar);
                } else {
                    yVar.b = i2;
                }
                s = (short)i4;
            }
            return s;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    @Override // l.h
    public boolean request(long l) {
        int obj3;
        obj3 = Long.compare(l2, l) >= 0 ? 1 : 0;
        return obj3;
    }

    @Override // l.h
    public final long size() {
        return this.b;
    }

    @Override // l.h
    public void skip(long l) {
        l.y yVar;
        int i;
        int i2;
        long l2;
        int obj7;
        while (Long.compare(obj7, i3) > 0) {
            yVar = this.a;
            int i7 = yVar.b;
            int i6 = (int)l4;
            l2 = (long)i6;
            T(size -= l2);
            obj7 -= l2;
            i9 += i6;
            yVar.b = i2;
            if (i2 == yVar.c) {
            }
            this.a = yVar.b();
            z.b(yVar);
        }
    }

    @Override // l.h
    public l.e0 timeout() {
        return e0.NONE;
    }

    @Override // l.h
    public String toString() {
        return U().toString();
    }

    @Override // l.h
    public l.f v0(byte[] bArr, int i2, int i3) {
        int length;
        long l3;
        long l;
        long l2;
        long l4;
        int obj11;
        n.f(bArr, "source");
        final long l6 = (long)i3;
        c.b((long)length, obj2, (long)i2);
        i3 += i2;
        while (obj11 < obj12) {
            length = Y(1);
            l3 = Math.min(obj12 - obj11, i5 - 8192);
            l4 = obj11 + l3;
            i.e(bArr, length.a, length.c, obj11, l4);
            length.c = obj11 += l3;
            obj11 = l4;
        }
        T(obj10 += l6);
        return this;
    }

    @Override // l.h
    public long w(l.i i, long l2) {
        long size;
        int i4;
        l.y yVar;
        int i2;
        int cmp;
        int i3;
        int size2;
        int length;
        long l;
        byte b;
        byte[] obj12;
        int obj13;
        int obj14;
        n.f(i, "targetBytes");
        i2 = 0;
        cmp = 1;
        i4 = Long.compare(l2, size) >= 0 ? cmp : i2;
        if (i4 == 0) {
        } else {
            i3 = -1;
            length = 2;
            if (this.a != null && Long.compare(i5, l2) < 0) {
                length = 2;
                if (Long.compare(i5, l2) < 0) {
                    size = size();
                    while (Long.compare(size, l2) > 0) {
                        yVar = yVar.g;
                        n.d(yVar);
                        size -= l;
                    }
                    if (yVar != null) {
                        if (i.A() == length) {
                            while (Long.compare(size, size2) < 0) {
                                obj13 = (int)size2;
                                while (obj13 < yVar.c) {
                                    size2 = yVar.a[obj13];
                                    obj13++;
                                }
                                n.d(yVar.f);
                                obj13 = size;
                                size2 = cmp[obj13];
                                obj13++;
                            }
                        } else {
                            obj12 = i.q();
                            while (Long.compare(size, size2) < 0) {
                                obj13 = (int)size2;
                                while (obj13 < yVar.c) {
                                    l = i2;
                                    while (l < obj12.length) {
                                        l++;
                                    }
                                    obj13++;
                                    l++;
                                }
                                n.d(yVar.f);
                                obj13 = size;
                                l = i2;
                                while (l < obj12.length) {
                                    l++;
                                }
                                obj13++;
                                if (cmp[obj13] == obj12[l]) {
                                    break;
                                } else {
                                }
                                l++;
                            }
                        }
                    }
                }
            }
            return i3;
        }
        obj12 = new StringBuilder();
        obj12.append("fromIndex < 0: ");
        obj12.append(l2);
        obj13 = new IllegalArgumentException(obj12.toString().toString());
        throw obj13;
    }

    @Override // l.h
    public l.g w1(byte[] bArr) {
        m0(bArr);
        return this;
    }

    @Override // l.h
    public int write(ByteBuffer byteBuffer) {
        int i3;
        l.y yVar;
        int i4;
        int i2;
        int i;
        n.f(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        i3 = remaining;
        while (i3 > 0) {
            yVar = Y(1);
            i4 = Math.min(i3, i7 - 8192);
            byteBuffer.get(yVar.a, yVar.c, i4);
            i3 -= i4;
            yVar.c = i9 += i4;
        }
        this.b = l += l2;
        return remaining;
    }

    @Override // l.h
    public void write(l.f f, long l2) {
        int i2;
        int i;
        int cmp;
        int cmp2;
        long size;
        int cmp3;
        long l;
        int i4;
        int i3;
        l.y yVar;
        int obj10;
        n.f(f, "source");
        i2 = 0;
        i = f != this ? 1 : i2;
        if (i == 0) {
        } else {
            c.b(f.size(), obj3, 0);
            while (Long.compare(obj10, i6) > 0) {
                l.y yVar3 = f.a;
                n.d(yVar3);
                l.y yVar6 = f.a;
                n.d(yVar6);
                if (Long.compare(obj10, l3) < 0) {
                    break;
                } else {
                }
                i = f.a;
                n.d(i);
                size = (long)i13;
                f.a = i.b();
                yVar = this.a;
                if (yVar == null) {
                } else {
                }
                n.d(yVar);
                yVar = yVar.g;
                n.d(yVar);
                yVar.c(i);
                i.a();
                f.T(size4 -= size);
                T(size5 += size);
                obj10 -= size;
                this.a = i;
                i.g = i;
                i.f = i;
                l.y yVar4 = this.a;
                if (yVar4 != null) {
                } else {
                }
                cmp = 0;
                if (cmp != 0) {
                    break;
                } else {
                }
                l.y yVar5 = f.a;
                n.d(yVar5);
                f.a = yVar5.e((int)obj10);
                if (cmp.e) {
                    break;
                } else {
                }
                if (cmp.d) {
                } else {
                }
                i3 = cmp.b;
                if (Long.compare(i11, i4) <= 0) {
                    break;
                } else {
                }
                i3 = i2;
                n.d(yVar4);
                cmp = yVar4.g;
            }
        }
        IllegalArgumentException obj9 = new IllegalArgumentException("source == this".toString());
        throw obj9;
    }

    @Override // l.h
    public boolean x(long l, l.i i2, int i3, int i4) {
        int cmp;
        int i;
        int i5;
        byte b;
        long l2;
        n.f(i3, "bytes");
        if (Long.compare(l, i6) >= 0 && i4 >= 0 && obj11 >= 0 && Long.compare(i5, l2) >= 0) {
            if (i4 >= 0) {
                if (obj11 >= 0) {
                    if (Long.compare(i5, l2) >= 0) {
                        if (i7 -= i4 < obj11) {
                        } else {
                            cmp = i;
                            while (cmp < obj11) {
                                cmp++;
                            }
                            i = 1;
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // l.h
    public l.g y1(l.i i) {
        e0(i);
        return this;
    }

    @Override // l.h
    public l.f z0(int i) {
        l.y yVar = Y(1);
        final byte[] bArr = yVar.a;
        int i4 = yVar.c;
        yVar.c = i4 + 1;
        bArr[i4] = (byte)i;
        T(size += i5);
        return this;
    }
}
