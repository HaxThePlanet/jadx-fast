package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class e {

    private final byte[] a;
    private final boolean b;
    private int c;
    private int d;
    private int e;
    private final InputStream f;
    private int g;
    private boolean h = false;
    private int i;
    private int j = Integer.MAX_VALUE;
    private int k;
    private int l = 64;
    private int m = 67108864;
    private kotlin.reflect.jvm.internal.impl.protobuf.e.a n = null;

    private interface a {
        public abstract void a();
    }
    private e(InputStream inputStream) {
        super();
        final int i = 0;
        int i2 = Integer.MAX_VALUE;
        int i3 = 64;
        int i4 = 67108864;
        int i5 = 0;
        this.a = new byte[4096];
        this.c = i;
        this.e = i;
        this.i = i;
        this.f = inputStream;
        this.b = i;
    }

    private e(kotlin.reflect.jvm.internal.impl.protobuf.n n) {
        super();
        int i = 0;
        int i2 = Integer.MAX_VALUE;
        int i3 = 64;
        int i4 = 67108864;
        this.a = n.b;
        int i6 = n.L();
        this.e = i6;
        this.c = i6 += obj3;
        this.i = -obj3;
        this.f = 0;
        this.b = true;
    }

    public static int B(int i, InputStream inputStream2) {
        int i3;
        int i2;
        int i5;
        int i4;
        int obj3;
        if (i & 128 == 0) {
            return i;
        }
        i &= 127;
        i3 = 7;
        int i8 = -1;
        while (i3 < 32) {
            int read2 = inputStream2.read();
            i3 += 7;
            i8 = -1;
        }
        while (i3 < 64) {
            int read = inputStream2.read();
            i3 += 7;
        }
        throw InvalidProtocolBufferException.f();
    }

    private void N() {
        int i;
        int i2;
        i3 += i5;
        this.c = i4;
        i6 += i4;
        final int i7 = this.j;
        if (i2 > i7) {
            i2 -= i7;
            this.d = i2;
            this.c = i4 -= i2;
        } else {
            this.d = 0;
        }
    }

    private void O(int i) {
        if (!T(i)) {
        } else {
        }
        throw InvalidProtocolBufferException.k();
    }

    private void S(int i) {
        int i3;
        int i2;
        int i4;
        if (i < 0) {
        } else {
            int i5 = this.i;
            int i8 = this.e;
            i4 = this.j;
            if (i9 += i > i4) {
            } else {
                int i6 = this.c;
                i3 = i6 - i8;
                this.e = i6;
                int i7 = 1;
                O(i7);
                i2 = i - i3;
                i4 = this.c;
                while (i2 > i4) {
                    i3 += i4;
                    this.e = i4;
                    O(i7);
                    i2 = i - i3;
                    i4 = this.c;
                }
                this.e = i2;
            }
            R(i10 -= i8);
            throw InvalidProtocolBufferException.k();
        }
        throw InvalidProtocolBufferException.g();
    }

    private boolean T(int i) {
        InputStream read;
        int i2;
        int length;
        byte[] bArr;
        int i3;
        boolean obj6;
        int i4 = this.e;
        if (i4 + i <= this.c) {
        } else {
            int i22 = 0;
            if (i13 += i > this.j) {
                return i22;
            }
            kotlin.reflect.jvm.internal.impl.protobuf.e.a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            int i6 = this.e;
            i2 = this.c;
            if (this.f != null && i6 > 0 && i2 > i6) {
                i6 = this.e;
                if (i6 > 0) {
                    i2 = this.c;
                    if (i2 > i6) {
                        bArr = this.a;
                        System.arraycopy(bArr, i6, bArr, i22, i2 -= i6);
                    }
                    this.i = i14 += i6;
                    this.c = i16 -= i6;
                    this.e = i22;
                }
                length = this.a;
                bArr = this.c;
                read = this.f.read(length, bArr, length2 -= bArr);
                if (read == 0) {
                } else {
                    if (read < -1) {
                    } else {
                        if (read > bArr2.length) {
                        } else {
                            if (read > 0) {
                                this.c = i17 += read;
                                if (i8 -= i19 > 0) {
                                } else {
                                    N();
                                    if (this.c >= i) {
                                        obj6 = 1;
                                    } else {
                                        obj6 = T(i);
                                    }
                                    return obj6;
                                }
                                throw InvalidProtocolBufferException.j();
                            }
                        }
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder(102);
                stringBuilder2.append("InputStream#read(byte[]) returned invalid result: ");
                stringBuilder2.append(read);
                stringBuilder2.append("\nThe InputStream implementation is buggy.");
                obj6 = new IllegalStateException(stringBuilder2.toString());
                throw obj6;
            }
            return i22;
        }
        StringBuilder stringBuilder = new StringBuilder(77);
        stringBuilder.append("refillBuffer() called when ");
        stringBuilder.append(i);
        stringBuilder.append(" bytes were already available in buffer");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public static int b(int i) {
        return obj1 ^= i2;
    }

    public static long c(long l) {
        return obj4 ^= i2;
    }

    private void d(int i) {
        if (i2 -= i4 < i) {
            O(i);
        }
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.e g(InputStream inputStream) {
        e eVar = new e(inputStream);
        return eVar;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.e h(kotlin.reflect.jvm.internal.impl.protobuf.n n) {
        e eVar = new e(n);
        eVar.j(n.size());
        return eVar;
    }

    private byte[] x(int i) {
        int i2;
        int length2;
        int length;
        int i6;
        int i5;
        byte[] bArr;
        int i3;
        int read;
        int i7;
        int i4;
        if (i <= 0) {
            if (i != 0) {
            } else {
                return i.a;
            }
            throw InvalidProtocolBufferException.g();
        }
        int i8 = this.i;
        length2 = this.e;
        int i15 = this.j;
        if (i11 += i > i15) {
        } else {
            length = 4096;
            int i18 = 0;
            if (i < length) {
                byte[] bArr2 = new byte[i];
                i13 -= length2;
                System.arraycopy(this.a, length2, bArr2, i18, i14);
                this.e = this.c;
                i -= i14;
                d(obj13);
                System.arraycopy(this.a, i18, bArr2, i14, obj13);
                this.e = obj13;
                return bArr2;
            }
            int i19 = this.c;
            this.i = i8 += i19;
            this.e = i18;
            this.c = i18;
            i19 -= length2;
            i2 = i - i6;
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                i5 = Math.min(i2, length);
                bArr = new byte[i5];
                i3 = i18;
                while (i3 < i5) {
                    InputStream inputStream = this.f;
                    int i20 = -1;
                    if (inputStream == null) {
                    } else {
                    }
                    read = inputStream.read(bArr, i3, i5 - i3);
                    this.i = i21 += read;
                    i3 += read;
                    read = i20;
                }
                i2 -= i5;
                arrayList.add(bArr);
                inputStream = this.f;
                i20 = -1;
                if (inputStream == null) {
                } else {
                }
                read = inputStream.read(bArr, i3, i5 - i3);
                this.i = i21 += read;
                i3 += read;
                read = i20;
            }
            byte[] obj13 = new byte[i];
            System.arraycopy(this.a, length2, obj13, i18, i6);
            Iterator iterator = arrayList.iterator();
            for (byte[] next2 : iterator) {
                System.arraycopy(next2, i18, obj13, i6, next2.length);
                i6 += length2;
            }
            return obj13;
        }
        R(i16 -= length2);
        throw InvalidProtocolBufferException.k();
    }

    public int A() {
        int i5;
        int i2;
        int i3;
        int cmp2;
        byte b;
        int i;
        int i4;
        int cmp;
        int i6;
        long cmp3;
        i5 = this.e;
        i3 = this.c;
        if (i3 == i5) {
            return (int)l;
        } else {
            b = this.a;
            i = i5 + 1;
            i5 = b[i5];
            if (i5 >= 0) {
                this.e = i;
                return i5;
            }
            if (i3 -= i < 9) {
            } else {
                i3 = i + 1;
                i5 ^= i13;
                cmp = 0;
                if (Long.compare(i, cmp) < 0) {
                    cmp = -128;
                    i5 = (int)b;
                } else {
                }
            }
        }
        this.e = i3;
        return i5;
    }

    public long C() {
        int cmp;
        int i4;
        int i5;
        int i;
        byte[] bArr;
        int i6;
        int i2;
        int i3;
        long l;
        cmp = this.e;
        i5 = this.c;
        if (i5 == cmp) {
            return D();
        } else {
            bArr = this.a;
            i6 = cmp + 1;
            cmp = bArr[cmp];
            if (cmp >= 0) {
                this.e = i6;
                return (long)cmp;
            }
            if (i5 -= i6 < 9) {
            } else {
                i5 = i6 + 1;
                i6 = (long)i7;
                i3 = 0;
                if (Long.compare(i6, i3) < 0) {
                    i3 = -128;
                    i = i6 ^ i3;
                } else {
                }
            }
        }
        this.e = i5;
        return i;
    }

    long D() {
        int i4;
        int i3;
        int i2;
        int i;
        i4 = 0;
        i3 = 0;
        while (i3 < 64) {
            byte b = w();
            i3 += 7;
        }
        throw InvalidProtocolBufferException.f();
    }

    public int E() {
        return y();
    }

    public long F() {
        return z();
    }

    public int G() {
        return e.b(A());
    }

    public long H() {
        return e.c(C());
    }

    public String I() {
        int i = A();
        String str2 = "UTF-8";
        if (i <= i2 -= i4 && i > 0) {
            if (i > 0) {
                String string2 = new String(this.a, this.e, i, str2);
                this.e = i5 += i;
                return string2;
            }
        }
        if (i == 0) {
            return "";
        }
        String string = new String(x(i), str2);
        return string;
    }

    public String J() {
        int i;
        byte[] bArr;
        int i2;
        int i3 = A();
        i = this.e;
        if (i3 <= i4 -= i && i3 > 0) {
            if (i3 > 0) {
                bArr = this.a;
                this.e = i + i3;
            } else {
                if (i3 == 0) {
                    return "";
                }
                bArr = x(i3);
                i = 0;
            }
        } else {
        }
        if (!v.f(bArr, i, i + i3)) {
        } else {
            String string = new String(bArr, i, i3, "UTF-8");
            return string;
        }
        throw InvalidProtocolBufferException.d();
    }

    public int K() {
        if (f()) {
            int i = 0;
            this.g = i;
            return i;
        }
        int i2 = A();
        this.g = i2;
        if (w.a(i2) == 0) {
        } else {
            return this.g;
        }
        throw InvalidProtocolBufferException.c();
    }

    public int L() {
        return A();
    }

    public long M() {
        return C();
    }

    public boolean P(int i, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream2) {
        int i2 = w.b(i);
        final int i4 = 1;
        final int i8 = 4;
        if (i2 != 0 && i2 != i4 && i2 != 2 && i2 != 3 && i2 != i8) {
            if (i2 != i4) {
                if (i2 != 2) {
                    i8 = 4;
                    if (i2 != 3) {
                        if (i2 != i8) {
                            if (i2 != 5) {
                            } else {
                                codedOutputStream2.o0(i);
                                codedOutputStream2.U(y());
                                return i4;
                            }
                            throw InvalidProtocolBufferException.e();
                        }
                        return 0;
                    }
                    codedOutputStream2.o0(i);
                    Q(codedOutputStream2);
                    int obj5 = w.c(w.a(i), i8);
                    a(obj5);
                    codedOutputStream2.o0(obj5);
                    return i4;
                }
                codedOutputStream2.o0(i);
                codedOutputStream2.P(l());
                return i4;
            }
            codedOutputStream2.o0(i);
            codedOutputStream2.V(z());
            return i4;
        }
        codedOutputStream2.o0(i);
        codedOutputStream2.z0(t());
        return i4;
    }

    public void Q(kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream) {
        int i;
        i = K();
        while (i != 0) {
            if (P(i, codedOutputStream)) {
            }
            i = K();
        }
    }

    public void R(int i) {
        int i2;
        i2 = this.e;
        if (i <= i3 -= i2 && i >= 0) {
            if (i >= 0) {
                this.e = i2 += i;
            } else {
                S(i);
            }
        } else {
        }
    }

    public void a(int i) {
        if (this.g != i) {
        } else {
        }
        throw InvalidProtocolBufferException.b();
    }

    public int e() {
        int i = this.j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i -= i6;
    }

    public boolean f() {
        int i2;
        int i;
        if (this.e == this.c && !T(1)) {
            if (!T(i)) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public void i(int i) {
        this.j = i;
        N();
    }

    public int j(int i) {
        if (i < 0) {
        } else {
            i += i3;
            int i4 = this.j;
            if (obj3 > i4) {
            } else {
                this.j = obj3;
                N();
                return i4;
            }
            throw InvalidProtocolBufferException.k();
        }
        throw InvalidProtocolBufferException.g();
    }

    public boolean k() {
        int i;
        i = Long.compare(l, i2) != 0 ? 1 : 0;
        return i;
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.d l() {
        kotlin.reflect.jvm.internal.impl.protobuf.d cVar;
        boolean z;
        byte[] i;
        int i2;
        int i3 = A();
        i = this.e;
        if (i3 <= i4 -= i && i3 > 0) {
            if (i3 > 0) {
                if (this.b && this.h) {
                    if (this.h) {
                        cVar = new c(this.a, this.e, i3);
                    } else {
                        cVar = d.i(this.a, i, i3);
                    }
                } else {
                }
                this.e = i6 += i3;
                return cVar;
            }
        }
        if (i3 == 0) {
            return d.a;
        }
        n nVar = new n(x(i3));
        return nVar;
    }

    public double m() {
        return Double.longBitsToDouble(z());
    }

    public int n() {
        return A();
    }

    public int o() {
        return y();
    }

    public long p() {
        return z();
    }

    public float q() {
        return Float.intBitsToFloat(y());
    }

    public void r(int i, kotlin.reflect.jvm.internal.impl.protobuf.o.a o$a2, kotlin.reflect.jvm.internal.impl.protobuf.f f3) {
        int i2 = this.k;
        if (i2 >= this.l) {
        } else {
            this.k = i2++;
            a2.j0(this, f3);
            a(w.c(i, 4));
            this.k = obj3--;
        }
        throw InvalidProtocolBufferException.h();
    }

    public int s() {
        return A();
    }

    public long t() {
        return C();
    }

    public <T extends kotlin.reflect.jvm.internal.impl.protobuf.o> T u(kotlin.reflect.jvm.internal.impl.protobuf.q<T> q, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        if (this.k >= this.l) {
        } else {
            this.k = i4++;
            a(0);
            this.k = obj5--;
            i(j(A()));
            return (o)q.b(this, f2);
        }
        throw InvalidProtocolBufferException.h();
    }

    public void v(kotlin.reflect.jvm.internal.impl.protobuf.o.a o$a, kotlin.reflect.jvm.internal.impl.protobuf.f f2) {
        if (this.k >= this.l) {
        } else {
            this.k = i4++;
            a.j0(this, f2);
            a(0);
            this.k = obj4--;
            i(j(A()));
        }
        throw InvalidProtocolBufferException.h();
    }

    public byte w() {
        int i;
        if (this.e == this.c) {
            O(1);
        }
        int i3 = this.e;
        this.e = i3 + 1;
        return this.a[i3];
    }

    public int y() {
        int i;
        int i8 = 4;
        if (i6 -= i < i8) {
            O(i8);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 4;
        return i4 |= i12;
    }

    public long z() {
        int i;
        int i8 = 8;
        if (i6 -= i < i8) {
            O(i8);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 8;
        final int i28 = 255;
        return i4 |= i14;
    }
}
