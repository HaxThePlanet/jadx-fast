package com.google.protobuf;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class k {

    int a;
    int b;
    int c;
    com.google.protobuf.l d;

    static class a {
    }

    private static final class b extends com.google.protobuf.k {

        private final byte[] e;
        private final boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private boolean l;
        private int m;
        private b(byte[] bArr, int i2, int i3, boolean z4) {
            super(0);
            this.m = Integer.MAX_VALUE;
            this.e = bArr;
            this.g = i3 += i2;
            this.i = i2;
            this.j = i2;
            this.f = z4;
        }

        b(byte[] bArr, int i2, int i3, boolean z4, com.google.protobuf.k.a k$a5) {
            super(bArr, i2, i3, z4);
        }

        private void R() {
            int i;
            int i2;
            i3 += i5;
            this.g = i4;
            i2 = i4 - i6;
            final int i7 = this.m;
            if (i2 > i7) {
                i2 -= i7;
                this.h = i2;
                this.g = i4 -= i2;
            } else {
                this.h = 0;
            }
        }

        private void U() {
            if (i -= i3 >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() {
            int i;
            byte b;
            int i2;
            int i3;
            i = 0;
            while (i < 10) {
                i2 = this.i;
                this.i = i2 + 1;
                i++;
            }
            throw InvalidProtocolBufferException.f();
        }

        private void W() {
            int i;
            byte b;
            i = 0;
            while (i < 10) {
                i++;
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.k
        public long A() {
            return N();
        }

        @Override // com.google.protobuf.k
        public int B() {
            return k.b(O());
        }

        @Override // com.google.protobuf.k
        public long C() {
            return k.c(P());
        }

        @Override // com.google.protobuf.k
        public String D() {
            int i;
            int i2;
            int i3 = O();
            if (i3 > 0 && i3 <= i4 -= i2) {
                if (i3 <= i4 -= i2) {
                    String string = new String(this.e, this.i, i3, c0.a);
                    this.i = i5 += i3;
                    return string;
                }
            }
            if (i3 == 0) {
                return "";
            }
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public String E() {
            int i2;
            int i;
            int i3 = O();
            i = this.i;
            if (i3 > 0 && i3 <= i4 -= i) {
                i = this.i;
                if (i3 <= i4 -= i) {
                    this.i = i5 += i3;
                    return x1.h(this.e, i, i3);
                }
            }
            if (i3 == 0) {
                return "";
            }
            if (i3 <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public int F() {
            if (e()) {
                int i = 0;
                this.k = i;
                return i;
            }
            int i2 = O();
            this.k = i2;
            if (y1.a(i2) == 0) {
            } else {
                return this.k;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.k
        public int G() {
            return O();
        }

        @Override // com.google.protobuf.k
        public long H() {
            return P();
        }

        @Override // com.google.protobuf.k
        public boolean J(int i) {
            final int i2 = y1.b(i);
            final int i3 = 1;
            final int i6 = 4;
            if (i2 != 0 && i2 != i3 && i2 != 2 && i2 != 3 && i2 != i6) {
                if (i2 != i3) {
                    if (i2 != 2) {
                        i6 = 4;
                        if (i2 != 3) {
                            if (i2 != i6) {
                                if (i2 != 5) {
                                } else {
                                    T(i6);
                                    return i3;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            return 0;
                        }
                        S();
                        a(y1.c(y1.a(i), i6));
                        return i3;
                    }
                    T(O());
                    return i3;
                }
                T(8);
                return i3;
            }
            U();
            return i3;
        }

        @Override // com.google.protobuf.k
        public byte K() {
            int i = this.i;
            if (i == this.g) {
            } else {
                this.i = i + 1;
                return this.e[i];
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public byte[] L(int i) {
            int i3;
            int i2;
            i2 = this.i;
            if (i > 0 && i <= i4 -= i2) {
                i2 = this.i;
                if (i <= i4 -= i2) {
                    i += i2;
                    this.i = obj3;
                    return Arrays.copyOfRange(this.e, i2, obj3);
                }
            }
            if (i > 0) {
            } else {
                if (i != 0) {
                } else {
                    return c0.b;
                }
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public int M() {
            int i = this.i;
            if (i6 -= i < 4) {
            } else {
                byte[] bArr = this.e;
                this.i = i + 4;
                return i4 |= i12;
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public long N() {
            int i = this.i;
            int i8 = 8;
            if (i6 -= i < i8) {
            } else {
                byte[] bArr = this.e;
                this.i = i + 8;
                final int i28 = 255;
                return i4 |= i14;
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public int O() {
            int i3;
            int i2;
            int i;
            byte[] bArr;
            int i5;
            int i4;
            i3 = this.i;
            i2 = this.g;
            if (i2 == i3) {
                return (int)l;
            } else {
                bArr = this.e;
                i5 = i3 + 1;
                i3 = bArr[i3];
                if (i3 >= 0) {
                    this.i = i5;
                    return i3;
                }
                if (i2 -= i5 < 9) {
                } else {
                    i2 = i5 + 1;
                    i3 ^= i5;
                    if (i6 < 0) {
                        i6 ^= -128;
                    } else {
                        i5 = i2 + 1;
                        i6 ^= i;
                        if (i7 >= 0) {
                            i7 ^= 16256;
                            i2 = i5;
                        } else {
                        }
                    }
                }
            }
            this.i = i2;
            return i3;
        }

        @Override // com.google.protobuf.k
        public long P() {
            int cmp;
            int i6;
            int i4;
            byte[] bArr;
            int i2;
            int i3;
            int i;
            int i5;
            long l;
            long l2;
            cmp = this.i;
            i6 = this.g;
            if (i6 == cmp) {
                return Q();
            } else {
                bArr = this.e;
                i3 = cmp + 1;
                cmp = bArr[cmp];
                if (cmp >= 0) {
                    this.i = i3;
                    return (long)cmp;
                }
                if (i6 -= i3 < 9) {
                } else {
                    i6 = i3 + 1;
                    cmp ^= i3;
                    if (i7 < 0) {
                        i7 ^= -128;
                        i2 = (long)cmp;
                    } else {
                    }
                }
            }
            this.i = i6;
            return i2;
        }

        @Override // com.google.protobuf.k
        long Q() {
            int i2;
            int i4;
            int i3;
            int i;
            i2 = 0;
            i4 = 0;
            while (i4 < 64) {
                byte b = K();
                i4 += 7;
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.k
        public void S() {
            int i;
            i = F();
            while (i != 0) {
                if (J(i)) {
                }
                i = F();
            }
        }

        @Override // com.google.protobuf.k
        public void T(int i) {
            int i3;
            int i2;
            i2 = this.i;
            if (i >= 0 && i <= i4 -= i2) {
                i2 = this.i;
                if (i <= i4 -= i2) {
                    this.i = i2 += i;
                }
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public void a(int i) {
            if (this.k != i) {
            } else {
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.k
        public int d() {
            return i -= i3;
        }

        @Override // com.google.protobuf.k
        public boolean e() {
            int i;
            i = this.i == this.g ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.k
        public void n(int i) {
            this.m = i;
            R();
        }

        @Override // com.google.protobuf.k
        public int o(int i) {
            if (i < 0) {
            } else {
                i += i2;
                if (obj2 < 0) {
                } else {
                    int i3 = this.m;
                    if (obj2 > i3) {
                    } else {
                        this.m = obj2;
                        R();
                        return i3;
                    }
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.k
        public boolean p() {
            int i;
            i = Long.compare(l, i2) != 0 ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.k
        public com.google.protobuf.j q() {
            int i;
            com.google.protobuf.j jVar;
            boolean z;
            int i2;
            int i3 = O();
            i2 = this.i;
            if (i3 > 0 && i3 <= i4 -= i2) {
                i2 = this.i;
                if (i3 <= i4 -= i2) {
                    if (this.f && this.l) {
                        if (this.l) {
                            jVar = j.X(this.e, i2, i3);
                        } else {
                            jVar = j.t(this.e, i2, i3);
                        }
                    } else {
                    }
                    this.i = i5 += i3;
                    return jVar;
                }
            }
            if (i3 == 0) {
                return j.a;
            }
            return j.W(L(i3));
        }

        @Override // com.google.protobuf.k
        public double r() {
            return Double.longBitsToDouble(N());
        }

        @Override // com.google.protobuf.k
        public int s() {
            return O();
        }

        @Override // com.google.protobuf.k
        public int t() {
            return M();
        }

        @Override // com.google.protobuf.k
        public long u() {
            return N();
        }

        @Override // com.google.protobuf.k
        public float v() {
            return Float.intBitsToFloat(M());
        }

        @Override // com.google.protobuf.k
        public int w() {
            return O();
        }

        @Override // com.google.protobuf.k
        public long x() {
            return P();
        }

        @Override // com.google.protobuf.k
        public int z() {
            return M();
        }
    }

    private static final class c extends com.google.protobuf.k {

        private Iterable<ByteBuffer> e;
        private Iterator<ByteBuffer> f;
        private ByteBuffer g;
        private boolean h;
        private boolean i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private long p;
        private long q;
        private long r;
        private long s;
        private c(Iterable<ByteBuffer> iterable, int i2, boolean z3) {
            int obj2;
            super(0);
            this.l = Integer.MAX_VALUE;
            this.j = i2;
            this.e = iterable;
            this.f = iterable.iterator();
            this.h = z3;
            obj2 = 0;
            this.n = obj2;
            this.o = obj2;
            if (i2 == 0) {
                this.g = c0.c;
                obj2 = 0;
                this.p = obj2;
                this.q = obj2;
                this.s = obj2;
                this.r = obj2;
            } else {
                Z();
            }
        }

        c(Iterable iterable, int i2, boolean z3, com.google.protobuf.k.a k$a4) {
            super(iterable, i2, z3);
        }

        private long K() {
            return l -= l2;
        }

        private void L() {
            if (!this.f.hasNext()) {
            } else {
                Z();
            }
            throw InvalidProtocolBufferException.m();
        }

        private void N(byte[] bArr, int i2, int i3) {
            int i5;
            int i;
            int i6;
            long l3;
            int i4;
            byte[] bArr2;
            long l2;
            long l4;
            long l;
            if (i3 >= 0 && i3 <= U()) {
                if (i3 <= U()) {
                    i5 = i3;
                    while (i5 > 0) {
                        i4 = 0;
                        if (Long.compare(l5, i4) == 0) {
                        }
                        int i8 = Math.min(i5, (int)l6);
                        l = (long)i8;
                        w1.p(this.p, i4, bArr, (long)i10);
                        i5 -= i8;
                        this.p = l7 += l;
                        L();
                    }
                }
            }
            if (i3 > 0) {
            } else {
                if (i3 != 0) {
                } else {
                }
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        private void T() {
            int i2;
            int i;
            i3 += i5;
            this.j = i4;
            i = i4 - i6;
            final int i7 = this.l;
            if (i > i7) {
                i -= i7;
                this.k = i;
                this.j = i4 -= i;
            } else {
                this.k = 0;
            }
        }

        private int U() {
            return (int)i4;
        }

        private void X() {
            int i;
            byte b;
            i = 0;
            while (i < 10) {
                i++;
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer Y(int i, int i2) {
            this.g.position(i);
            this.g.limit(i2);
            this.g.position(this.g.position());
            this.g.limit(this.g.limit());
            return this.g.slice();
        }

        private void Z() {
            Object next = this.f.next();
            this.g = (ByteBuffer)next;
            this.n = i += i4;
            long l = (long)position;
            this.p = l;
            this.q = l;
            this.s = (long)limit;
            long l3 = w1.k(this.g);
            this.r = l3;
            this.p = l5 += l3;
            this.q = l6 += l3;
            this.s = l7 += l3;
        }

        @Override // com.google.protobuf.k
        public long A() {
            return P();
        }

        @Override // com.google.protobuf.k
        public int B() {
            return k.b(Q());
        }

        @Override // com.google.protobuf.k
        public long C() {
            return k.c(R());
        }

        @Override // com.google.protobuf.k
        public String D() {
            int cmp;
            long l;
            long l2;
            int i = Q();
            l2 = (long)i;
            l = this.p;
            if (i > 0 && Long.compare(l2, i2) <= 0) {
                l2 = (long)i;
                l = this.p;
                if (Long.compare(l2, i2) <= 0) {
                    byte[] bArr = new byte[i];
                    final int i6 = 0;
                    w1.p(l, obj2, bArr, i6);
                    String string2 = new String(bArr, c0.a);
                    this.p = l5 += l2;
                    return string2;
                }
            }
            if (i > 0 && i <= U()) {
                if (i <= U()) {
                    byte[] bArr2 = new byte[i];
                    N(bArr2, 0, i);
                    String string = new String(bArr2, c0.a);
                    return string;
                }
            }
            if (i == 0) {
                return "";
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public String E() {
            long l2;
            int cmp;
            long l;
            int i = Q();
            l2 = (long)i;
            l = this.p;
            if (i > 0 && Long.compare(l2, i3) <= 0) {
                l2 = (long)i;
                l = this.p;
                if (Long.compare(l2, i3) <= 0) {
                    this.p = l5 += l2;
                    return x1.g(this.g, (int)i6, i);
                }
            }
            if (i >= 0 && i <= U()) {
                if (i <= U()) {
                    byte[] bArr = new byte[i];
                    final int i2 = 0;
                    N(bArr, i2, i);
                    return x1.h(bArr, i2, i);
                }
            }
            if (i == 0) {
                return "";
            }
            if (i <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public int F() {
            if (e()) {
                int i = 0;
                this.m = i;
                return i;
            }
            int i2 = Q();
            this.m = i2;
            if (y1.a(i2) == 0) {
            } else {
                return this.m;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.k
        public int G() {
            return Q();
        }

        @Override // com.google.protobuf.k
        public long H() {
            return R();
        }

        @Override // com.google.protobuf.k
        public boolean J(int i) {
            final int i2 = y1.b(i);
            final int i3 = 1;
            final int i6 = 4;
            if (i2 != 0 && i2 != i3 && i2 != 2 && i2 != 3 && i2 != i6) {
                if (i2 != i3) {
                    if (i2 != 2) {
                        i6 = 4;
                        if (i2 != 3) {
                            if (i2 != i6) {
                                if (i2 != 5) {
                                } else {
                                    W(i6);
                                    return i3;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            return 0;
                        }
                        V();
                        a(y1.c(y1.a(i), i6));
                        return i3;
                    }
                    W(Q());
                    return i3;
                }
                W(8);
                return i3;
            }
            X();
            return i3;
        }

        @Override // com.google.protobuf.k
        public byte M() {
            if (Long.compare(l, i) == 0) {
                L();
            }
            long l2 = this.p;
            this.p = i2 += l2;
            return w1.w(l2);
        }

        @Override // com.google.protobuf.k
        public int O() {
            int i15 = 4;
            if (Long.compare(l, i15) >= 0) {
                long l2 = this.p;
                this.p = i15 += l2;
                return i3 |= i19;
            }
            return i7 |= i14;
        }

        @Override // com.google.protobuf.k
        public long P() {
            byte b;
            int i4;
            int i2;
            int i;
            int i3;
            final Object obj = this;
            int i12 = 8;
            final int i60 = 32;
            final int i61 = 24;
            final int i62 = 16;
            final int i63 = 8;
            final int i64 = 255;
            if (Long.compare(l, i12) >= 0) {
                long l17 = obj.p;
                obj.p = i12 += l17;
                i25 |= i58;
                b = w1.w(l17 += i2);
            } else {
                i18 |= i2;
                b = M();
            }
            return i9 |= i4;
        }

        @Override // com.google.protobuf.k
        public int Q() {
            int l;
            int cmp;
            int cmp2;
            int i;
            int i2;
            int i3;
            l = this.p;
            if (Long.compare(l3, l) == 0) {
                return (int)l2;
            } else {
                cmp2 = 1;
                i = l + cmp2;
                l = w1.w(l);
                if (l >= 0) {
                    this.p = l4 += cmp2;
                    return l;
                }
                if (Long.compare(i2, i3) < 0) {
                } else {
                    i2 = i + cmp2;
                    l ^= cmp;
                    if (i4 < 0) {
                        i4 ^= -128;
                    } else {
                        i = i2 + cmp2;
                        i4 ^= cmp;
                        if (i5 >= 0) {
                            i5 ^= 16256;
                            i2 = i;
                        } else {
                        }
                    }
                }
            }
            this.p = i2;
            return l;
        }

        @Override // com.google.protobuf.k
        public long R() {
            int l;
            int i3;
            int i;
            int i5;
            int cmp3;
            int cmp4;
            int cmp;
            int i4;
            int cmp2;
            int i2;
            l = this.p;
            if (Long.compare(l5, l) == 0) {
                return S();
            } else {
                cmp4 = 1;
                cmp = l + cmp4;
                l = w1.w(l);
                if (l >= 0) {
                    this.p = l6 += cmp4;
                    return (long)l;
                }
                if (Long.compare(i4, cmp2) < 0) {
                } else {
                    i4 = cmp + cmp4;
                    l ^= cmp3;
                    if (i6 < 0) {
                        i6 ^= -128;
                        l = (long)i5;
                    } else {
                    }
                }
            }
            this.p = i4;
            return l;
        }

        @Override // com.google.protobuf.k
        long S() {
            int i4;
            int i;
            int i3;
            int i2;
            i4 = 0;
            i = 0;
            while (i < 64) {
                byte b = M();
                i += 7;
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.k
        public void V() {
            int i;
            i = F();
            while (i != 0) {
                if (J(i)) {
                }
                i = F();
            }
        }

        @Override // com.google.protobuf.k
        public void W(int i) {
            int cmp;
            int i2;
            int i3;
            int i4;
            long l;
            int obj7;
            if (i >= 0 && Long.compare(l2, i3) <= 0) {
                if (Long.compare(l2, i3) <= 0) {
                }
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public void a(int i) {
            if (this.m != i) {
            } else {
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.k
        public int d() {
            return (int)i4;
        }

        @Override // com.google.protobuf.k
        public boolean e() {
            int i;
            i = Long.compare(i4, l4) == 0 ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.k
        public void n(int i) {
            this.l = i;
            T();
        }

        @Override // com.google.protobuf.k
        public int o(int i) {
            if (i < 0) {
            } else {
                i += i2;
                int i3 = this.l;
                if (obj2 > i3) {
                } else {
                    this.l = obj2;
                    T();
                    return i3;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.k
        public boolean p() {
            int i;
            i = Long.compare(l, i2) != 0 ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.k
        public com.google.protobuf.j q() {
            int i;
            int cmp;
            boolean z;
            boolean z2;
            long l2;
            long l3;
            int i2;
            long l;
            long l4;
            i = Q();
            l4 = (long)i;
            l3 = this.p;
            if (i > 0 && Long.compare(l4, i4) <= 0 && this.h && this.i) {
                l4 = (long)i;
                l3 = this.p;
                if (Long.compare(l4, i4) <= 0) {
                    if (this.h) {
                        if (this.i) {
                            int i5 = (int)i12;
                            this.p = l7 += l4;
                            return j.U(Y(i5, i += i5));
                        }
                    }
                    byte[] bArr = new byte[i];
                    int i15 = 0;
                    w1.p(l3, obj2, bArr, i15);
                    this.p = l9 += l4;
                    return j.W(bArr);
                }
            }
            if (i > 0 && i <= U() && this.h && this.i) {
                if (i <= U()) {
                    if (this.h) {
                        if (this.i) {
                            ArrayList arrayList = new ArrayList();
                            while (i > 0) {
                                if (Long.compare(l10, i13) == 0) {
                                }
                                l2 = Math.min(i, (int)l11);
                                int i11 = (int)i10;
                                arrayList.add(j.U(Y(i11, i11 + l2)));
                                i -= l2;
                                this.p = l13 += l;
                                L();
                            }
                            return j.m(arrayList);
                        }
                    }
                    byte[] bArr2 = new byte[i];
                    N(bArr2, 0, i);
                    return j.W(bArr2);
                }
            }
            if (i == 0) {
                return j.a;
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public double r() {
            return Double.longBitsToDouble(P());
        }

        @Override // com.google.protobuf.k
        public int s() {
            return Q();
        }

        @Override // com.google.protobuf.k
        public int t() {
            return O();
        }

        @Override // com.google.protobuf.k
        public long u() {
            return P();
        }

        @Override // com.google.protobuf.k
        public float v() {
            return Float.intBitsToFloat(O());
        }

        @Override // com.google.protobuf.k
        public int w() {
            return Q();
        }

        @Override // com.google.protobuf.k
        public long x() {
            return R();
        }

        @Override // com.google.protobuf.k
        public int z() {
            return O();
        }
    }

    private static final class d extends com.google.protobuf.k {

        private final InputStream e;
        private final byte[] f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private com.google.protobuf.k.d.a m;
        private d(InputStream inputStream, int i2) {
            int i = 0;
            super(i);
            this.l = Integer.MAX_VALUE;
            this.m = i;
            c0.b(inputStream, "input");
            this.e = inputStream;
            this.f = new byte[i2];
            int obj3 = 0;
            this.g = obj3;
            this.i = obj3;
            this.k = obj3;
        }

        d(InputStream inputStream, int i2, com.google.protobuf.k.a k$a3) {
            super(inputStream, i2);
        }

        private static int K(InputStream inputStream) {
            try {
                return inputStream.available();
                inputStream.j();
                throw inputStream;
            }
        }

        private static int L(InputStream inputStream, byte[] b2Arr2, int i3, int i4) {
            try {
                return inputStream.read(b2Arr2, i3, i4);
                inputStream.j();
                throw inputStream;
            }
        }

        private com.google.protobuf.j M(int i) {
            int i2;
            List length2;
            byte[] length;
            byte[] bArr = P(i);
            if (bArr != null) {
                return j.s(bArr);
            }
            int i3 = this.i;
            int i4 = this.g;
            i2 = i4 - i3;
            this.k = i6 += i4;
            int i5 = 0;
            this.i = i5;
            this.g = i5;
            byte[] obj6 = new byte[i];
            System.arraycopy(this.f, i3, obj6, i5, i2);
            Iterator iterator = Q(i - i2).iterator();
            for (byte[] next2 : iterator) {
                System.arraycopy(next2, i5, obj6, i2, next2.length);
                i2 += length2;
            }
            return j.W(obj6);
        }

        private byte[] O(int i, boolean z2) {
            byte[] bArr;
            int i2;
            List length2;
            byte[] length;
            int obj5;
            bArr = P(i);
            if (bArr != null && z2) {
                if (z2) {
                    bArr = obj5;
                }
                return bArr;
            }
            int obj6 = this.i;
            int i3 = this.g;
            i2 = i3 - obj6;
            this.k = i5 += i3;
            int i4 = 0;
            this.i = i4;
            this.g = i4;
            obj5 = new byte[i];
            System.arraycopy(this.f, obj6, obj5, i4, i2);
            obj6 = Q(i - i2).iterator();
            for (byte[] next2 : obj6) {
                System.arraycopy(next2, i4, obj5, i2, next2.length);
                i2 += length2;
            }
            return obj5;
        }

        private byte[] P(int i) {
            int i4;
            int i2;
            int i5;
            int i3;
            if (i == 0) {
                return c0.b;
            }
            if (i < 0) {
            } else {
                int i6 = this.k;
                int i8 = this.i;
                i10 += i;
                if (i11 - i13 > 0) {
                } else {
                    int i15 = this.l;
                    if (i11 > i15) {
                    } else {
                        i7 -= i8;
                        int i9 = i - i4;
                        if (i9 >= 4096 && i9 <= k.d.K(this.e)) {
                            if (i9 <= k.d.K(this.e)) {
                            }
                            return null;
                        }
                        byte[] bArr = new byte[i];
                        final int i22 = 0;
                        System.arraycopy(this.f, this.i, bArr, i22, i4);
                        this.k = i12 += i3;
                        this.i = i22;
                        this.g = i22;
                        while (i4 < i) {
                            i5 = k.d.L(this.e, bArr, i4, i - i4);
                            this.k = i21 += i5;
                            i4 += i5;
                        }
                        return bArr;
                    }
                    a0(i16 -= i8);
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.l();
            }
            throw InvalidProtocolBufferException.g();
        }

        private List<byte[]> Q(int i) {
            int i4;
            byte[] bArr;
            int i3;
            int read;
            int i2;
            int obj7;
            ArrayList arrayList = new ArrayList();
            while (obj7 > 0) {
                i4 = Math.min(obj7, 4096);
                bArr = new byte[i4];
                i3 = 0;
                while (i3 < i4) {
                    read = this.e.read(bArr, i3, i4 - i3);
                    this.k = i8 += read;
                    i3 += read;
                }
                obj7 -= i4;
                arrayList.add(bArr);
                read = this.e.read(bArr, i3, i4 - i3);
                this.k = i8 += read;
                i3 += read;
            }
            return arrayList;
        }

        private void W() {
            int i;
            int i2;
            i3 += i5;
            this.g = i4;
            i6 += i4;
            final int i7 = this.l;
            if (i2 > i7) {
                i2 -= i7;
                this.h = i2;
                this.g = i4 -= i2;
            } else {
                this.h = 0;
            }
        }

        private void X(int i) {
            if (!f0(i) && i > i3 -= i6) {
                if (i > i3 -= i6) {
                    throw InvalidProtocolBufferException.l();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        private static long Y(InputStream inputStream, long l2) {
            try {
                return inputStream.skip(l2);
                inputStream.j();
                throw inputStream;
            }
        }

        private void b0(int i) {
            int i5;
            int i6;
            int i2;
            com.google.protobuf.k.d.a cmp;
            int i3;
            int cmp2;
            int i4;
            if (i < 0) {
            } else {
                i6 = this.k;
                i2 = this.i;
                int i16 = this.l;
                if (i14 += i > i16) {
                } else {
                    i3 = 0;
                    if (this.m == null) {
                        this.k = i6 += i2;
                        this.g = i3;
                        this.i = i3;
                        i3 = i5;
                        while (i3 < i) {
                            i2 = this.e;
                            cmp2 = (long)i11;
                            i5 = k.d.Y(i2, cmp2);
                            cmp = Long.compare(i5, i4);
                            i3 += i5;
                        }
                        this.k = i10 += i3;
                        W();
                    }
                    if (i3 < i) {
                        int i12 = this.g;
                        i2 = i12 - i13;
                        this.i = i12;
                        i6 = 1;
                        X(i6);
                        cmp = i - i2;
                        i3 = this.g;
                        while (cmp > i3) {
                            i2 += i3;
                            this.i = i3;
                            X(i6);
                            cmp = i - i2;
                            i3 = this.g;
                        }
                        this.i = cmp;
                    }
                }
                a0(i17 -= i2);
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        private void c0() {
            if (i -= i3 >= 10) {
                d0();
            } else {
                e0();
            }
        }

        private void d0() {
            int i2;
            byte b;
            int i3;
            int i;
            i2 = 0;
            while (i2 < 10) {
                i3 = this.i;
                this.i = i3 + 1;
                i2++;
            }
            throw InvalidProtocolBufferException.f();
        }

        private void e0() {
            int i;
            byte b;
            i = 0;
            while (i < 10) {
                i++;
            }
            throw InvalidProtocolBufferException.f();
        }

        private boolean f0(int i) {
            int i3;
            byte[] length;
            int i2;
            int i4;
            boolean obj8;
            int i5 = this.i;
            if (i5 + i <= this.g) {
            } else {
                int i19 = this.k;
                final int i22 = 0;
                if (i > i12 -= i5) {
                    return i22;
                }
                if (i20 += i > this.l) {
                    return i22;
                }
                com.google.protobuf.k.d.a aVar = this.m;
                if (aVar != null) {
                    aVar.a();
                }
                int i7 = this.i;
                i2 = this.g;
                if (i7 > 0 && i2 > i7) {
                    i2 = this.g;
                    if (i2 > i7) {
                        i4 = this.f;
                        System.arraycopy(i4, i7, i4, i22, i2 -= i7);
                    }
                    this.k = i15 += i7;
                    this.g = i17 -= i7;
                    this.i = i22;
                }
                length = this.f;
                int i21 = this.g;
                int i8 = k.d.L(this.e, length, i21, Math.min(length2 -= i21, i26 -= i21));
                if (i8 == 0) {
                } else {
                    if (i8 < -1) {
                    } else {
                        if (i8 > bArr.length) {
                        } else {
                            if (i8 > 0) {
                                this.g = i13 += i8;
                                W();
                                if (this.g >= i) {
                                    obj8 = 1;
                                } else {
                                    obj8 = f0(i);
                                }
                                return obj8;
                            }
                            return i22;
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.e.getClass());
                stringBuilder.append("#read(byte[]) returned invalid result: ");
                stringBuilder.append(i8);
                stringBuilder.append("\nThe InputStream implementation is buggy.");
                obj8 = new IllegalStateException(stringBuilder.toString());
                throw obj8;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("refillBuffer() called when ");
            stringBuilder2.append(i);
            stringBuilder2.append(" bytes were already available in buffer");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        @Override // com.google.protobuf.k
        public long A() {
            return S();
        }

        @Override // com.google.protobuf.k
        public int B() {
            return k.b(T());
        }

        @Override // com.google.protobuf.k
        public long C() {
            return k.c(U());
        }

        @Override // com.google.protobuf.k
        public String D() {
            int i;
            int i2;
            int i3 = T();
            if (i3 > 0 && i3 <= i5 -= i2) {
                if (i3 <= i5 -= i2) {
                    String string3 = new String(this.f, this.i, i3, c0.a);
                    this.i = i9 += i3;
                    return string3;
                }
            }
            if (i3 == 0) {
                return "";
            }
            if (i3 <= this.g) {
                X(i3);
                String string2 = new String(this.f, this.i, i3, c0.a);
                this.i = i7 += i3;
                return string2;
            }
            String string = new String(O(i3, false), c0.a);
            return string;
        }

        @Override // com.google.protobuf.k
        public String E() {
            int i2;
            byte[] bArr;
            int i;
            int i3 = T();
            i2 = this.i;
            int i4 = this.g;
            final int i5 = 0;
            if (i3 <= i4 - i2 && i3 > 0) {
                if (i3 > 0) {
                    bArr = this.f;
                    this.i = i2 + i3;
                } else {
                    if (i3 == 0) {
                        return "";
                    }
                    if (i3 <= i4) {
                        X(i3);
                        bArr = this.f;
                        this.i = i3 + 0;
                    } else {
                        bArr = O(i3, i5);
                    }
                    i2 = i5;
                }
            } else {
            }
            return x1.h(bArr, i2, i3);
        }

        @Override // com.google.protobuf.k
        public int F() {
            if (e()) {
                int i = 0;
                this.j = i;
                return i;
            }
            int i2 = T();
            this.j = i2;
            if (y1.a(i2) == 0) {
            } else {
                return this.j;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.k
        public int G() {
            return T();
        }

        @Override // com.google.protobuf.k
        public long H() {
            return U();
        }

        @Override // com.google.protobuf.k
        public boolean J(int i) {
            final int i2 = y1.b(i);
            final int i3 = 1;
            final int i6 = 4;
            if (i2 != 0 && i2 != i3 && i2 != 2 && i2 != 3 && i2 != i6) {
                if (i2 != i3) {
                    if (i2 != 2) {
                        i6 = 4;
                        if (i2 != 3) {
                            if (i2 != i6) {
                                if (i2 != 5) {
                                } else {
                                    a0(i6);
                                    return i3;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            return 0;
                        }
                        Z();
                        a(y1.c(y1.a(i), i6));
                        return i3;
                    }
                    a0(T());
                    return i3;
                }
                a0(8);
                return i3;
            }
            c0();
            return i3;
        }

        @Override // com.google.protobuf.k
        public byte N() {
            int i;
            if (this.i == this.g) {
                X(1);
            }
            int i3 = this.i;
            this.i = i3 + 1;
            return this.f[i3];
        }

        @Override // com.google.protobuf.k
        public int R() {
            int i;
            int i8 = 4;
            if (i6 -= i < i8) {
                X(i8);
                i = this.i;
            }
            byte[] bArr = this.f;
            this.i = i + 4;
            return i4 |= i12;
        }

        @Override // com.google.protobuf.k
        public long S() {
            int i;
            int i8 = 8;
            if (i6 -= i < i8) {
                X(i8);
                i = this.i;
            }
            byte[] bArr = this.f;
            this.i = i + 8;
            final int i28 = 255;
            return i4 |= i14;
        }

        @Override // com.google.protobuf.k
        public int T() {
            int i4;
            int i;
            int i3;
            byte[] bArr;
            int i5;
            int i2;
            i4 = this.i;
            i = this.g;
            if (i == i4) {
                return (int)l;
            } else {
                bArr = this.f;
                i5 = i4 + 1;
                i4 = bArr[i4];
                if (i4 >= 0) {
                    this.i = i5;
                    return i4;
                }
                if (i -= i5 < 9) {
                } else {
                    i = i5 + 1;
                    i4 ^= i5;
                    if (i6 < 0) {
                        i6 ^= -128;
                    } else {
                        i5 = i + 1;
                        i6 ^= i3;
                        if (i7 >= 0) {
                            i7 ^= 16256;
                            i = i5;
                        } else {
                        }
                    }
                }
            }
            this.i = i;
            return i4;
        }

        @Override // com.google.protobuf.k
        public long U() {
            int cmp;
            int i6;
            int i5;
            byte[] bArr;
            int i3;
            int i4;
            int i2;
            int i;
            long l;
            long l2;
            cmp = this.i;
            i6 = this.g;
            if (i6 == cmp) {
                return V();
            } else {
                bArr = this.f;
                i4 = cmp + 1;
                cmp = bArr[cmp];
                if (cmp >= 0) {
                    this.i = i4;
                    return (long)cmp;
                }
                if (i6 -= i4 < 9) {
                } else {
                    i6 = i4 + 1;
                    cmp ^= i4;
                    if (i7 < 0) {
                        i7 ^= -128;
                        i3 = (long)cmp;
                    } else {
                    }
                }
            }
            this.i = i6;
            return i3;
        }

        @Override // com.google.protobuf.k
        long V() {
            int i4;
            int i;
            int i2;
            int i3;
            i4 = 0;
            i = 0;
            while (i < 64) {
                byte b = N();
                i += 7;
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.k
        public void Z() {
            int i;
            i = F();
            while (i != 0) {
                if (J(i)) {
                }
                i = F();
            }
        }

        @Override // com.google.protobuf.k
        public void a(int i) {
            if (this.j != i) {
            } else {
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.k
        public void a0(int i) {
            int i2;
            i2 = this.i;
            if (i <= i3 -= i2 && i >= 0) {
                if (i >= 0) {
                    this.i = i2 += i;
                } else {
                    b0(i);
                }
            } else {
            }
        }

        @Override // com.google.protobuf.k
        public int d() {
            return i += i3;
        }

        @Override // com.google.protobuf.k
        public boolean e() {
            int i2;
            int i;
            if (this.i == this.g && !f0(1)) {
                if (!f0(i)) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        @Override // com.google.protobuf.k
        public void n(int i) {
            this.l = i;
            W();
        }

        @Override // com.google.protobuf.k
        public int o(int i) {
            if (i < 0) {
            } else {
                i += i3;
                int i4 = this.l;
                if (obj3 > i4) {
                } else {
                    this.l = obj3;
                    W();
                    return i4;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.k
        public boolean p() {
            int i;
            i = Long.compare(l, i2) != 0 ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.k
        public com.google.protobuf.j q() {
            int i = T();
            int i4 = this.i;
            if (i <= i2 -= i4 && i > 0) {
                if (i > 0) {
                    this.i = i5 += i;
                    return j.t(this.f, i4, i);
                }
            }
            if (i == 0) {
                return j.a;
            }
            return M(i);
        }

        @Override // com.google.protobuf.k
        public double r() {
            return Double.longBitsToDouble(S());
        }

        @Override // com.google.protobuf.k
        public int s() {
            return T();
        }

        @Override // com.google.protobuf.k
        public int t() {
            return R();
        }

        @Override // com.google.protobuf.k
        public long u() {
            return S();
        }

        @Override // com.google.protobuf.k
        public float v() {
            return Float.intBitsToFloat(R());
        }

        @Override // com.google.protobuf.k
        public int w() {
            return T();
        }

        @Override // com.google.protobuf.k
        public long x() {
            return U();
        }

        @Override // com.google.protobuf.k
        public int z() {
            return R();
        }
    }

    private static final class e extends com.google.protobuf.k {

        private final ByteBuffer e;
        private final boolean f;
        private final long g;
        private long h;
        private long i;
        private long j;
        private int k;
        private int l;
        private boolean m;
        private int n;
        private e(ByteBuffer byteBuffer, boolean z2) {
            super(0);
            this.n = Integer.MAX_VALUE;
            this.e = byteBuffer;
            long l = w1.k(byteBuffer);
            this.g = l;
            this.h = l2 += l;
            l += l3;
            this.i = i3;
            this.j = i3;
            this.f = z2;
        }

        e(ByteBuffer byteBuffer, boolean z2, com.google.protobuf.k.a k$a3) {
            super(byteBuffer, z2);
        }

        private int K(long l) {
            return (int)obj3;
        }

        static boolean L() {
            return w1.J();
        }

        private void S() {
            int i;
            long l;
            l2 += l3;
            this.h = i2;
            l = (int)i4;
            final int i6 = this.n;
            if (l > i6) {
                l -= i6;
                this.k = i5;
                this.h = i2 -= l;
            } else {
                this.k = 0;
            }
        }

        private int T() {
            return (int)i;
        }

        private void W() {
            if (T() >= 10) {
                X();
            } else {
                Y();
            }
        }

        private void X() {
            int i;
            byte b;
            int i2;
            i = 0;
            while (i < 10) {
                long l = this.i;
                this.i = i4 += l;
                i++;
            }
            throw InvalidProtocolBufferException.f();
        }

        private void Y() {
            int i;
            byte b;
            i = 0;
            while (i < 10) {
                i++;
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer Z(long l, long l2) {
            this.e.position(K(l));
            this.e.limit(K(obj6));
            this.e.position(this.e.position());
            this.e.limit(this.e.limit());
            return this.e.slice();
        }

        @Override // com.google.protobuf.k
        public long A() {
            return O();
        }

        @Override // com.google.protobuf.k
        public int B() {
            return k.b(P());
        }

        @Override // com.google.protobuf.k
        public long C() {
            return k.c(Q());
        }

        @Override // com.google.protobuf.k
        public String D() {
            int i;
            int i2 = P();
            if (i2 > 0 && i2 <= T()) {
                if (i2 <= T()) {
                    byte[] bArr = new byte[i2];
                    final long l4 = (long)i2;
                    w1.p(this.i, obj3, bArr, 0);
                    String string = new String(bArr, c0.a);
                    this.i = l += l4;
                    return string;
                }
            }
            if (i2 == 0) {
                return "";
            }
            if (i2 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public String E() {
            int i;
            int i2 = P();
            if (i2 > 0 && i2 <= T()) {
                if (i2 <= T()) {
                    this.i = l2 += l3;
                    return x1.g(this.e, K(this.i), i2);
                }
            }
            if (i2 == 0) {
                return "";
            }
            if (i2 <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public int F() {
            if (e()) {
                int i = 0;
                this.l = i;
                return i;
            }
            int i2 = P();
            this.l = i2;
            if (y1.a(i2) == 0) {
            } else {
                return this.l;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.k
        public int G() {
            return P();
        }

        @Override // com.google.protobuf.k
        public long H() {
            return Q();
        }

        @Override // com.google.protobuf.k
        public boolean J(int i) {
            final int i2 = y1.b(i);
            final int i3 = 1;
            final int i6 = 4;
            if (i2 != 0 && i2 != i3 && i2 != 2 && i2 != 3 && i2 != i6) {
                if (i2 != i3) {
                    if (i2 != 2) {
                        i6 = 4;
                        if (i2 != 3) {
                            if (i2 != i6) {
                                if (i2 != 5) {
                                } else {
                                    V(i6);
                                    return i3;
                                }
                                throw InvalidProtocolBufferException.e();
                            }
                            return 0;
                        }
                        U();
                        a(y1.c(y1.a(i), i6));
                        return i3;
                    }
                    V(P());
                    return i3;
                }
                V(8);
                return i3;
            }
            W();
            return i3;
        }

        @Override // com.google.protobuf.k
        public byte M() {
            long l = this.i;
            if (Long.compare(l, l2) == 0) {
            } else {
                this.i = i += l;
                return w1.w(l);
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public int N() {
            long l = this.i;
            int i18 = 4;
            if (Long.compare(i5, i18) < 0) {
            } else {
                i18 += l;
                this.i = i19;
                return i3 |= i8;
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public long O() {
            long l = this.i;
            int i13 = 8;
            if (Long.compare(i5, i13) < 0) {
            } else {
                this.i = i13 += l;
                int i15 = 255;
                return i3 |= i12;
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public int P() {
            int l;
            int cmp;
            int cmp2;
            int i2;
            int i3;
            int i;
            l = this.i;
            if (Long.compare(l3, l) == 0) {
                return (int)l2;
            } else {
                cmp2 = 1;
                i2 = l + cmp2;
                l = w1.w(l);
                if (l >= 0) {
                    this.i = i2;
                    return l;
                }
                if (Long.compare(i3, i) < 0) {
                } else {
                    i3 = i2 + cmp2;
                    l ^= cmp;
                    if (i4 < 0) {
                        i4 ^= -128;
                    } else {
                        i2 = i3 + cmp2;
                        i4 ^= cmp;
                        if (i5 >= 0) {
                            i5 ^= 16256;
                            i3 = i2;
                        } else {
                        }
                    }
                }
            }
            this.i = i3;
            return l;
        }

        @Override // com.google.protobuf.k
        public long Q() {
            int l;
            int i5;
            int i2;
            int i;
            int cmp2;
            int cmp3;
            int cmp4;
            int i4;
            int cmp;
            int i3;
            l = this.i;
            if (Long.compare(l5, l) == 0) {
                return R();
            } else {
                cmp3 = 1;
                cmp4 = l + cmp3;
                l = w1.w(l);
                if (l >= 0) {
                    this.i = cmp4;
                    return (long)l;
                }
                if (Long.compare(i4, cmp) < 0) {
                } else {
                    i4 = cmp4 + cmp3;
                    l ^= cmp2;
                    if (i6 < 0) {
                        i6 ^= -128;
                        l = (long)i;
                    } else {
                    }
                }
            }
            this.i = i4;
            return l;
        }

        @Override // com.google.protobuf.k
        long R() {
            int i;
            int i3;
            int i4;
            int i2;
            i = 0;
            i3 = 0;
            while (i3 < 64) {
                byte b = M();
                i3 += 7;
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.k
        public void U() {
            int i;
            i = F();
            while (i != 0) {
                if (J(i)) {
                }
                i = F();
            }
        }

        @Override // com.google.protobuf.k
        public void V(int i) {
            int i2;
            if (i >= 0 && i <= T()) {
                if (i <= T()) {
                    this.i = l += l2;
                }
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public void a(int i) {
            if (this.l != i) {
            } else {
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.k
        public int d() {
            return (int)i;
        }

        @Override // com.google.protobuf.k
        public boolean e() {
            int i;
            i = Long.compare(l, l2) == 0 ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.k
        public void n(int i) {
            this.n = i;
            S();
        }

        @Override // com.google.protobuf.k
        public int o(int i) {
            if (i < 0) {
            } else {
                i += i2;
                int i3 = this.n;
                if (obj2 > i3) {
                } else {
                    this.n = obj2;
                    S();
                    return i3;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.k
        public boolean p() {
            int i;
            i = Long.compare(l, i2) != 0 ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.k
        public com.google.protobuf.j q() {
            int i;
            boolean z;
            int i2 = P();
            if (i2 > 0 && i2 <= T() && this.f && this.m) {
                if (i2 <= T()) {
                    if (this.f) {
                        if (this.m) {
                            long l2 = this.i;
                            long l5 = (long)i2;
                            this.i = l3 += l5;
                            return j.U(Z(l2, obj2));
                        }
                    }
                    final byte[] bArr2 = new byte[i2];
                    final long l7 = (long)i2;
                    w1.p(this.i, obj2, bArr2, 0);
                    this.i = l += l7;
                    return j.W(bArr2);
                }
            }
            if (i2 == 0) {
                return j.a;
            }
            if (i2 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // com.google.protobuf.k
        public double r() {
            return Double.longBitsToDouble(O());
        }

        @Override // com.google.protobuf.k
        public int s() {
            return P();
        }

        @Override // com.google.protobuf.k
        public int t() {
            return N();
        }

        @Override // com.google.protobuf.k
        public long u() {
            return O();
        }

        @Override // com.google.protobuf.k
        public float v() {
            return Float.intBitsToFloat(N());
        }

        @Override // com.google.protobuf.k
        public int w() {
            return P();
        }

        @Override // com.google.protobuf.k
        public long x() {
            return Q();
        }

        @Override // com.google.protobuf.k
        public int z() {
            return N();
        }
    }
    private k() {
        super();
        this.b = 100;
        this.c = Integer.MAX_VALUE;
    }

    k(com.google.protobuf.k.a k$a) {
        super();
    }

    public static int b(int i) {
        return obj1 ^= i2;
    }

    public static long c(long l) {
        return obj4 ^= i2;
    }

    public static com.google.protobuf.k f(InputStream inputStream) {
        return k.g(inputStream, 4096);
    }

    public static com.google.protobuf.k g(InputStream inputStream, int i2) {
        if (i2 <= 0) {
        } else {
            if (inputStream == null) {
                return k.k(c0.b);
            }
            k.d dVar = new k.d(inputStream, i2, 0);
            return dVar;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("bufferSize must be > 0");
        throw obj2;
    }

    static com.google.protobuf.k h(Iterable<ByteBuffer> iterable, boolean z2) {
        int i2;
        int i;
        Object direct;
        boolean array;
        Iterator iterator = iterable.iterator();
        i = i2;
        while (iterator.hasNext()) {
            direct = iterator.next();
            i += remaining;
            if (direct.hasArray()) {
            } else {
            }
            if (direct.isDirect()) {
            } else {
            }
            i2 |= 4;
            i2 |= 2;
            i2 |= 1;
        }
        if (i2 == 2) {
            k.c cVar = new k.c(iterable, i, z2, 0);
            return cVar;
        }
        d0 obj6 = new d0(iterable);
        return k.f(obj6);
    }

    public static com.google.protobuf.k i(ByteBuffer byteBuffer) {
        return k.j(byteBuffer, false);
    }

    static com.google.protobuf.k j(ByteBuffer byteBuffer, boolean z2) {
        boolean direct;
        if (byteBuffer.hasArray()) {
            return k.m(byteBuffer.array(), arrayOffset += position, byteBuffer.remaining(), z2);
        }
        if (byteBuffer.isDirect() && k.e.L()) {
            if (k.e.L()) {
                k.e eVar = new k.e(byteBuffer, z2, 0);
                return eVar;
            }
        }
        final int obj4 = byteBuffer.remaining();
        byte[] bArr = new byte[obj4];
        byteBuffer.duplicate().get(bArr);
        return k.m(bArr, 0, obj4, true);
    }

    public static com.google.protobuf.k k(byte[] bArr) {
        return k.l(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.k l(byte[] bArr, int i2, int i3) {
        return k.m(bArr, i2, i3, false);
    }

    static com.google.protobuf.k m(byte[] bArr, int i2, int i3, boolean z4) {
        super(bArr, i2, i3, z4, 0);
        bVar2.o(i3);
        return bVar2;
    }

    public static int y(int i, InputStream inputStream2) {
        int i4;
        int i5;
        int i3;
        int i2;
        int obj3;
        if (i & 128 == 0) {
            return i;
        }
        i &= 127;
        i4 = 7;
        int i8 = -1;
        while (i4 < 32) {
            int read2 = inputStream2.read();
            i4 += 7;
            i8 = -1;
        }
        while (i4 < 64) {
            int read = inputStream2.read();
            i4 += 7;
        }
        throw InvalidProtocolBufferException.f();
    }

    public abstract long A();

    public abstract int B();

    public abstract long C();

    public abstract String D();

    public abstract String E();

    public abstract int F();

    public abstract int G();

    public abstract long H();

    public final int I(int i) {
        if (i < 0) {
        } else {
            this.c = i;
            return this.c;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size limit cannot be negative: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public abstract boolean J(int i);

    public abstract void a(int i);

    public abstract int d();

    public abstract boolean e();

    public abstract void n(int i);

    public abstract int o(int i);

    public abstract boolean p();

    public abstract com.google.protobuf.j q();

    public abstract double r();

    public abstract int s();

    public abstract int t();

    public abstract long u();

    public abstract float v();

    public abstract int w();

    public abstract long x();

    public abstract int z();
}
