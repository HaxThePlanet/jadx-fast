package com.google.android.exoplayer2.l2.u;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.c0;
import com.google.android.exoplayer2.audio.m;
import com.google.android.exoplayer2.audio.n;
import com.google.android.exoplayer2.audio.o;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.l;
import com.google.android.exoplayer2.l2.n;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.video.m;
import com.google.android.exoplayer2.video.n;
import com.google.android.exoplayer2.video.o;
import com.google.android.exoplayer2.video.r;
import com.google.common.base.g;
import com.google.common.collect.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
final class d {

    private static final byte[] a;

    private static final class a {

        public final int a;
        public int b = -1;
        public int c;
        public long d;
        private final boolean e;
        private final d0 f;
        private final d0 g;
        private int h;
        private int i;
        public a(d0 d0, d0 d02, boolean z3) {
            int obj2;
            super();
            this.g = d0;
            this.f = d02;
            this.e = z3;
            final int obj3 = 12;
            d02.I(obj3);
            this.a = d02.B();
            d0.I(obj3);
            this.i = d0.B();
            if (d0.n() == 1) {
            } else {
                obj2 = 0;
            }
            l.a(obj2, "first_chunk must be 1");
            int obj1 = -1;
        }

        public boolean a() {
            d0 d0Var;
            int i2;
            long l;
            int i;
            final int i10 = 1;
            i3 += i10;
            this.b = i4;
            if (i4 == this.a) {
                return 0;
            }
            if (this.e) {
                l = this.f.C();
            } else {
                l = this.f.z();
            }
            this.d = l;
            if (this.b == this.h) {
                this.c = this.g.B();
                this.g.J(4);
                i6 -= i10;
                this.i = i7;
                if (i7 > 0) {
                    i8 -= i10;
                } else {
                    i2 = -1;
                }
                this.h = i2;
            }
            return i10;
        }
    }

    private interface b {
        public abstract int a();

        public abstract int b();

        public abstract int c();
    }

    private static final class c {

        public final com.google.android.exoplayer2.l2.u.k[] a;
        public i1 b;
        public int c;
        public int d = 0;
        public c(int i) {
            super();
            this.a = new k[i];
            int obj1 = 0;
        }
    }

    private static final class f {

        private final int a;
        private final long b;
        private final int c;
        public f(int i, long l2, int i3) {
            super();
            this.a = i;
            this.b = l2;
            this.c = obj4;
        }

        static long a(com.google.android.exoplayer2.l2.u.d.f d$f) {
            return f.b;
        }

        static int b(com.google.android.exoplayer2.l2.u.d.f d$f) {
            return f.a;
        }

        static int c(com.google.android.exoplayer2.l2.u.d.f d$f) {
            return f.c;
        }
    }

    static final class d implements com.google.android.exoplayer2.l2.u.d.b {

        private final int a = -1;
        private final int b;
        private final d0 c;
        public d(com.google.android.exoplayer2.l2.u.c.b c$b, i1 i12) {
            int i;
            int equals;
            Object stringBuilder;
            Object obj5;
            super();
            d0 obj4 = b.b;
            this.c = obj4;
            obj4.I(12);
            i = obj4.B();
            if ("audio/raw".equals(i12.D)) {
                obj5 = p0.U(i12.S, i12.Q);
                if (i != 0) {
                    if (i % obj5 != 0) {
                        stringBuilder = new StringBuilder(88);
                        stringBuilder.append("Audio sample size mismatch. stsd sample size: ");
                        stringBuilder.append(obj5);
                        stringBuilder.append(", stsz sample size: ");
                        stringBuilder.append(i);
                        v.h("AtomParsers", stringBuilder.toString());
                        i = obj5;
                    }
                } else {
                }
            }
            int i3 = -1;
            this.b = obj4.B();
        }

        @Override // com.google.android.exoplayer2.l2.u.d$b
        public int a() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.l2.u.d$b
        public int b() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.l2.u.d$b
        public int c() {
            int i;
            if (this.a == -1) {
                i = this.c.B();
            }
            return i;
        }
    }

    static final class e implements com.google.android.exoplayer2.l2.u.d.b {

        private final d0 a;
        private final int b;
        private final int c;
        private int d;
        private int e;
        public e(com.google.android.exoplayer2.l2.u.c.b c$b) {
            super();
            d0 obj2 = b.b;
            this.a = obj2;
            obj2.I(12);
            this.c = i2 &= 255;
            this.b = obj2.B();
        }

        @Override // com.google.android.exoplayer2.l2.u.d$b
        public int a() {
            return -1;
        }

        @Override // com.google.android.exoplayer2.l2.u.d$b
        public int b() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.l2.u.d$b
        public int c() {
            int i = this.c;
            if (i == 8) {
                return this.a.x();
            }
            if (i == 16) {
                return this.a.D();
            }
            int i4 = this.d;
            this.d = i4 + 1;
            if (i4 %= 2 == 0) {
                int i6 = this.a.x();
                this.e = i6;
                return i7 >>= 4;
            }
            return i9 &= 15;
        }
    }
    static {
        d.a = p0.d0("OpusHead");
    }

    private static boolean a(long[] lArr, long l2, long l3, long l4) {
        int i;
        int i2;
        int obj7;
        long obj10;
        length -= i;
        int i5 = 4;
        final int i6 = 0;
        if (Long.compare(l, l4) <= 0 && Long.compare(l4, i2) < 0 && Long.compare(obj10, obj12) < 0 && Long.compare(obj12, l2) <= 0) {
            if (Long.compare(l4, i2) < 0) {
                if (Long.compare(obj10, obj12) < 0) {
                    if (Long.compare(obj12, l2) <= 0) {
                    } else {
                        i = i6;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static int b(d0 d0, int i2, int i3) {
        int i;
        int i4;
        int i7;
        int i5;
        int i6;
        i = d0.e();
        while (i - i2 < i3) {
            d0.I(i);
            i4 = d0.n();
            if (i4 > 0) {
            } else {
            }
            i5 = 0;
            l.a(i5, "childAtomSize must be positive");
            i += i4;
            i5 = 1;
        }
        return -1;
    }

    private static int c(int i) {
        int i2;
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i != 1952807028 && i != 1935832172 && i != 1937072756) {
            if (i != 1935832172) {
                if (i != 1937072756) {
                    if (i == 1668047728) {
                    } else {
                        if (i == 1835365473) {
                            return 5;
                        }
                    }
                    return -1;
                }
            }
        }
        return 3;
    }

    private static void d(d0 d0, int i2, int i3, int i4, int i5, String string6, boolean z7, t t8, com.google.android.exoplayer2.l2.u.d.c d$c9, int i10) {
        i1 i1Var;
        int i;
        v intValue2;
        int bArr;
        t tVar;
        int i15;
        int i7;
        int i23;
        int i11;
        int i12;
        int i13;
        int i8;
        int i18;
        int i6;
        int i24;
        int i17;
        int first;
        int i22;
        byte[] copyOf;
        int i19;
        int i9;
        int second;
        int i14;
        t tVar2;
        int intValue;
        int i16;
        int i25;
        String str;
        int i20;
        int i21;
        d0 d0Var = d0;
        i = i3;
        final int i42 = i5;
        final String str3 = string6;
        tVar = t8;
        final Object obj = c9;
        int i47 = 8;
        d0Var.I(i44 += i47);
        int i46 = 6;
        if (z7) {
            i12 = d0.D();
            d0Var.J(i46);
        } else {
            d0Var.J(i47);
            i12 = 0;
        }
        i24 = 16;
        i22 = 1;
        if (i12 != 0) {
            if (i12 == i22) {
            } else {
                if (i12 == 2) {
                    d0Var.J(i24);
                    i11 = (int)round;
                    i13 = d0.B();
                    d0Var.J(20);
                    if (i2 == 1701733217) {
                        second = d.o(d0Var, i, i4);
                        if (second != null) {
                            intValue = (Integer)second.first.intValue();
                            if (tVar == null) {
                                tVar2 = 0;
                            } else {
                                tVar2 = tVar;
                            }
                            obj.a[i10] = (k)second.second;
                        } else {
                            tVar2 = tVar;
                        }
                        d0Var.I(d0.e());
                    } else {
                        tVar2 = tVar;
                    }
                    str = "audio/raw";
                    if (intValue == 1633889587) {
                        str = "audio/ac3";
                        i23 = -1;
                    } else {
                    }
                    first = str;
                    i16 = 0;
                    i21 = 0;
                    while (i17 - i < bArr) {
                        d0Var.I(i17);
                        i14 = d0.n();
                        if (i14 > 0) {
                        } else {
                        }
                        i22 = 0;
                        l.a(i22, "childAtomSize must be positive");
                        int i49 = d0.n();
                        if (i49 == 1835557187) {
                        } else {
                        }
                        int i28 = 1702061171;
                        if (i49 != i28) {
                        } else {
                        }
                        bArr = 1634492771;
                        i22 = 1;
                        i25 = 2;
                        str = 0;
                        if (i49 == i28) {
                        } else {
                        }
                        intValue2 = d.b(d0Var, i17, i14);
                        Pair pair = d.g(d0Var, intValue2);
                        intValue2 = pair.second;
                        if (intValue2 != -1 && (byte[])intValue2 != null && "audio/mp4a-latm".equals((String)pair.first)) {
                        }
                        i17 += i14;
                        i = i3;
                        bArr = i4;
                        pair = d.g(d0Var, intValue2);
                        intValue2 = pair.second;
                        if ((byte[])(byte[])intValue2 != null) {
                        }
                        if ("audio/mp4a-latm".equals((String)pair.first)) {
                        }
                        i21 = v.A((byte[])(byte[])intValue2);
                        bArr = m.f(intValue2);
                        i11 = bArr.a;
                        i13 = bArr.b;
                        i16 = bArr.c;
                        intValue2 = i17;
                        if (z7) {
                        } else {
                        }
                        if (i49 == 1684103987) {
                        } else {
                        }
                        if (i49 == 1684366131) {
                        } else {
                        }
                        if (i49 == 1684103988) {
                        } else {
                        }
                        if (i49 == 1684305011) {
                        } else {
                        }
                        if (i49 == 1682927731) {
                        } else {
                        }
                        if (i49 == 1684425825) {
                        } else {
                        }
                        i22 = 1;
                        i25 = 2;
                        if (i49 == 1634492771) {
                        } else {
                        }
                        i6 = 0;
                        str = i6;
                        i8 = -1;
                        int i35 = i14 + -12;
                        byte[] bArr2 = new byte[i35];
                        d0Var.I(i17 + 12);
                        int i50 = 0;
                        d0Var.j(bArr2, i50, i35);
                        Pair pair2 = j.e(bArr2);
                        i21 = vVar;
                        i11 = intValue3;
                        str = i50;
                        i8 = -1;
                        i13 = intValue2;
                        int i36 = i14 + -12;
                        bArr = new byte[i36 + 4];
                        bArr[0] = 102;
                        bArr[1] = 76;
                        bArr[2] = 97;
                        bArr[3] = 67;
                        d0Var.I(i17 + 12);
                        d0Var.j(bArr, 4, i36);
                        i21 = intValue2;
                        i8 = -1;
                        str = 0;
                        int i37 = i14 + -8;
                        i18 = d.a;
                        copyOf = Arrays.copyOf(i18, length += i37);
                        d0Var.I(i17 + 8);
                        d0Var.j(copyOf, i18.length, i37);
                        intValue2 = c0.a(copyOf);
                        i21 = intValue2;
                        i8 = -1;
                        i22 = 1;
                        i25 = 2;
                        i1.b bVar2 = new i1.b();
                        bVar2.R(i42);
                        bVar2.e0(first);
                        bVar2.H(i13);
                        bVar2.f0(i11);
                        bVar2.L(tVar2);
                        bVar2.V(str3);
                        obj.b = bVar2.E();
                        bArr = 1634492771;
                        i6 = 0;
                        i22 = 1;
                        i25 = 2;
                        d0Var.I(i17 + 8);
                        obj.b = o.b(d0Var, Integer.toString(i5), str3, tVar2);
                        d0Var.I(i17 + 8);
                        obj.b = n.g(d0Var, Integer.toString(i5), str3, tVar2);
                        d0Var.I(i17 + 8);
                        obj.b = n.c(d0Var, Integer.toString(i5), str3, tVar2);
                        if (i49 == 2002876005) {
                        } else {
                        }
                        i18 = i14 + -13;
                        copyOf = new byte[i18];
                        d0Var.I(i17 + 13);
                        d0Var.j(copyOf, 0, i18);
                        intValue2 = v.A(copyOf);
                    }
                    if (obj.b == null && first != 0) {
                        if (first != 0) {
                            i1.b bVar = new i1.b();
                            bVar.R(i42);
                            bVar.e0(first);
                            bVar.I(i16);
                            bVar.H(i13);
                            bVar.f0(i11);
                            bVar.Y(i23);
                            bVar.T(i21);
                            bVar.L(tVar2);
                            bVar.V(str3);
                            obj.b = bVar.E();
                        }
                    }
                }
            }
        }
        d0Var.J(i46);
        i11 = d0.y();
        if (i12 == i22) {
            d0Var.J(i24);
        }
        i13 = i9;
    }

    static Pair<Integer, com.google.android.exoplayer2.l2.u.k> e(d0 d0, int i2, int i3) {
        int i4;
        int i8;
        int i;
        int i9;
        int valueOf;
        int i7;
        int i10;
        int i5;
        int i6;
        boolean obj12;
        int obj13;
        i4 = i2 + 8;
        final int i11 = -1;
        final int i12 = 0;
        i8 = 0;
        i9 = i11;
        valueOf = i;
        i7 = i8;
        while (i4 - i2 < i3) {
            d0.I(i4);
            i10 = d0.n();
            i5 = d0.n();
            if (i5 == 1718775137) {
            } else {
            }
            if (i5 == 1935894637) {
            } else {
            }
            if (i5 == 1935894633) {
            }
            i4 += i10;
            i9 = i4;
            i7 = i10;
            int i13 = 4;
            d0.J(i13);
            i = d0.u(i13);
            valueOf = Integer.valueOf(d0.n());
        }
        if (!"cenc".equals(i) && !"cbc1".equals(i) && !"cens".equals(i) && "cbcs".equals(i)) {
            if (!"cbc1".equals(i)) {
                if (!"cens".equals(i)) {
                    if ("cbcs".equals(i)) {
                    }
                    return i12;
                }
            }
        }
        obj12 = 1;
        obj13 = valueOf != 0 ? obj12 : i8;
        l.a(obj13, "frma atom is mandatory");
        obj13 = i9 != i11 ? obj12 : i8;
        l.a(obj13, "schi atom is mandatory");
        com.google.android.exoplayer2.l2.u.k obj11 = d.p(d0, i9, i7, i);
        if (obj11 != null) {
            i8 = obj12;
        }
        l.a(i8, "tenc atom is mandatory");
        p0.i(obj11);
        return Pair.create(valueOf, (k)obj11);
    }

    private static Pair<long[], long[]> f(com.google.android.exoplayer2.l2.u.c.a c$a) {
        int i2;
        int i;
        short s;
        long l;
        long l2;
        com.google.android.exoplayer2.l2.u.c.b obj8 = a.g(1701606260);
        if (obj8 == null) {
            return 0;
        }
        obj8 = obj8.b;
        obj8.I(8);
        int i6 = c.c(obj8.n());
        final int i7 = obj8.B();
        final long[] lArr = new long[i7];
        final long[] lArr2 = new long[i7];
        i2 = 0;
        while (i2 < i7) {
            int i8 = 1;
            if (i6 == i8) {
            } else {
            }
            l = obj8.z();
            lArr[i2] = l;
            if (i6 == i8) {
            } else {
            }
            l2 = (long)i9;
            lArr2[i2] = l2;
            obj8.J(2);
            i2++;
            l2 = obj8.r();
            l = obj8.C();
        }
        return Pair.create(lArr, lArr2);
    }

    private static Pair<String, byte[]> g(d0 d0, int i2) {
        boolean equals;
        int i;
        d0.I(obj4 += 4);
        int obj4 = 1;
        d0.J(obj4);
        d.h(d0);
        int i3 = 2;
        d0.J(i3);
        int i5 = d0.x();
        if (i5 & 128 != 0) {
            d0.J(i3);
        }
        if (i5 & 64 != 0) {
            d0.J(d0.D());
        }
        if (i5 &= 32 != 0) {
            d0.J(i3);
        }
        d0.J(obj4);
        d.h(d0);
        String str = z.h(d0.x());
        if (!"audio/mpeg".equals(str) && !"audio/vnd.dts".equals(str) && "audio/vnd.dts.hd".equals(str)) {
            if (!"audio/vnd.dts".equals(str)) {
                if ("audio/vnd.dts.hd".equals(str)) {
                }
                d0.J(12);
                d0.J(obj4);
                obj4 = d.h(d0);
                byte[] bArr = new byte[obj4];
                d0.j(bArr, 0, obj4);
                return Pair.create(str, bArr);
            }
        }
        return Pair.create(str, 0);
    }

    private static int h(d0 d0) {
        int i;
        int i2;
        int i3;
        i2 = i & 127;
        int i6 = 128;
        while (i &= i6 == i6) {
            i5 |= i3;
            i6 = 128;
        }
        return i2;
    }

    private static int i(d0 d0) {
        d0.I(16);
        return d0.n();
    }

    private static Pair<Long, String> j(d0 d0) {
        int i2;
        int i;
        i2 = 8;
        d0.I(i2);
        int i7 = c.c(d0.n());
        i = i7 == 0 ? i2 : 16;
        d0.J(i);
        if (i7 == 0) {
            i2 = 4;
        }
        d0.J(i2);
        int obj6 = d0.D();
        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append((char)i5);
        stringBuilder.append((char)i10);
        stringBuilder.append((char)obj6);
        return Pair.create(Long.valueOf(d0.z()), stringBuilder.toString());
    }

    private static void k(d0 d0, int i2, int i3, int i4, com.google.android.exoplayer2.l2.u.d.c d$c5) {
        Object obj0;
        int obj1;
        d0.I(obj2 += 8);
        d0.s();
        obj0 = d0.s();
        if (i2 == 1835365492 && obj0 != null) {
            d0.s();
            obj0 = d0.s();
            if (obj0 != null) {
                obj1 = new i1.b();
                obj1.R(i4);
                obj1.e0(obj0);
                c5.b = obj1.E();
            }
        }
    }

    private static long l(d0 d0) {
        int i;
        d0.I(8);
        if (c.c(d0.n()) == 0) {
        } else {
            i = 16;
        }
        d0.J(i);
        return d0.z();
    }

    private static float m(d0 d0, int i2) {
        d0.I(i2 += 8);
        return obj1 /= obj0;
    }

    private static byte[] n(d0 d0, int i2, int i3) {
        int i6;
        int i;
        int i4;
        int i5;
        i6 = i2 + 8;
        while (i6 - i2 < i3) {
            d0.I(i6);
            i = d0.n();
            i6 += i;
        }
        return null;
    }

    private static Pair<Integer, com.google.android.exoplayer2.l2.u.k> o(d0 d0, int i2, int i3) {
        int i4;
        int i;
        int i7;
        int i6;
        int i5;
        i4 = d0.e();
        while (i4 - i2 < i3) {
            d0.I(i4);
            i = d0.n();
            if (i > 0) {
            } else {
            }
            i6 = 0;
            l.a(i6, "childAtomSize must be positive");
            i4 += i;
            i7 = d.e(d0, i4, i);
            i6 = 1;
        }
        return 0;
    }

    private static com.google.android.exoplayer2.l2.u.k p(d0 d0, int i2, int i3, String string4) {
        int i4;
        int i5;
        int bArr;
        int i7;
        int i6;
        int i8;
        int i9;
        int i;
        int obj12;
        i4 = i2 + 8;
        while (i4 - i2 < i3) {
            d0.I(i4);
            i4 += i5;
        }
        return null;
    }

    private static com.google.android.exoplayer2.l2.u.m q(com.google.android.exoplayer2.l2.u.j j, com.google.android.exoplayer2.l2.u.c.a c$a2, n n3) {
        int i23;
        int string;
        String str;
        int i52;
        int i22;
        int[] iArr5;
        int i38;
        int i15;
        int str4;
        long[] length;
        int length3;
        int[] iArr9;
        int[] iArr;
        int i26;
        int i56;
        int i34;
        int i50;
        long[] lArr;
        int[] iArr2;
        int i11;
        com.google.android.exoplayer2.l2.u.c.b bVar2;
        int stringBuilder;
        int i49;
        int[] iArr8;
        int i44;
        int i16;
        boolean equals;
        int i43;
        long[] copyOf3;
        int i39;
        int i53;
        int i46;
        int i32;
        Object eVar;
        Object obj;
        i1 i1Var;
        int[] copyOf4;
        int cmp3;
        int cmp;
        long[] lArr2;
        com.google.android.exoplayer2.l2.u.c.b bVar;
        int copyOf;
        int l3;
        int i40;
        int[] iArr4;
        int[] copyOf2;
        int cmp2;
        int i55;
        int[] iArr3;
        int i35;
        int str2;
        int i;
        int i21;
        int i33;
        int i37;
        int i27;
        String str5;
        int i28;
        int i19;
        int i36;
        long i41;
        int i29;
        int i2;
        int i47;
        int i24;
        int i5;
        int i9;
        long[] lArr3;
        int i30;
        int i12;
        int[] iArr6;
        int length2;
        int i51;
        int str3;
        int i25;
        int i3;
        int i17;
        int i48;
        long l5;
        long l4;
        int i20;
        int i6;
        int[] iArr7;
        long[] lArr4;
        int i13;
        int i45;
        d0 d0Var;
        int i7;
        int i10;
        int i31;
        int i4;
        int i54;
        long l2;
        int i18;
        int i14;
        int i57;
        int i8;
        long l;
        int i42;
        int obj38;
        str4 = j;
        Object obj2 = a2;
        Object obj3 = n3;
        bVar2 = obj2.g(1937011578);
        if (bVar2 != null) {
            eVar = new d.d(bVar2, str4.f);
            stringBuilder = eVar.b();
            int i83 = 0;
            if (stringBuilder == null) {
                super(j, new long[i83], new int[i83], 0, new long[i83], new int[i83], 0, obj8);
                return mVar9;
            }
            int i97 = 1;
            if (obj2.g(1937007471) == null) {
                g.e(obj2.g(1668232756));
                i35 = i97;
            } else {
                i35 = i83;
            }
            com.google.android.exoplayer2.l2.u.c.b bVar5 = obj2.g(1937011555);
            g.e(bVar5);
            com.google.android.exoplayer2.l2.u.c.b bVar6 = obj2.g(1937011827);
            g.e(bVar6);
            d0 d0Var4 = bVar6.b;
            com.google.android.exoplayer2.l2.u.c.b bVar7 = obj2.g(1937011571);
            i24 = bVar7 != null ? bVar7.b : 0;
            com.google.android.exoplayer2.l2.u.c.b bVar3 = obj2.g(1668576371);
            i23 = bVar3 != null ? bVar3.b : 0;
            d.a aVar = new d.a(bVar5.b, bVar.b, i35);
            int i94 = 12;
            d0Var4.I(i94);
            i100 -= i97;
            i33 = d0Var4.B();
            int i112 = d0Var4.B();
            if (i23 != 0) {
                i23.I(i94);
                i51 = i23.B();
            } else {
                i51 = i83;
            }
            equals = -1;
            if (i24 != 0) {
                i24.I(i94);
                if (i24.B() > 0) {
                    i120--;
                } else {
                    i3 = equals;
                    i24 = 0;
                }
            } else {
                i3 = equals;
                copyOf = i83;
            }
            int i84 = eVar.a();
            copyOf2 = i1Var4.D;
            if (i84 != equals) {
                if (!"audio/raw".equals(copyOf2) && !"audio/g711-mlaw".equals(copyOf2)) {
                    if (!"audio/g711-mlaw".equals(copyOf2)) {
                        if ("audio/g711-alaw".equals(copyOf2) && i21 == 0 && i51 == 0 && copyOf == 0) {
                            if (i21 == 0) {
                                if (i51 == 0) {
                                    i43 = copyOf == 0 ? 1 : 0;
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (i43 != 0) {
                int i60 = aVar.a;
                long[] lArr13 = new long[i60];
                int[] iArr10 = new int[i60];
                while (aVar.a()) {
                    eVar = aVar.b;
                    lArr13[eVar] = aVar.d;
                    iArr10[eVar] = aVar.c;
                }
                com.google.android.exoplayer2.l2.u.f.b bVar4 = f.a(i84, lArr13, iArr10, (long)i112);
                i52 = stringBuilder;
                lArr = lArr14;
                iArr8 = iArr13;
                i39 = copyOf4;
                lArr3 = str2;
                iArr6 = str5;
                i25 = i36;
                obj = str4;
            } else {
                copyOf3 = new long[stringBuilder];
                copyOf4 = new int[stringBuilder];
                copyOf = new long[stringBuilder];
                copyOf2 = new int[stringBuilder];
                d0Var = d0Var4;
                i26 = i3;
                i15 = 0;
                i36 = 0;
                i20 = 0;
                i6 = 0;
                i13 = 0;
                i7 = 0;
                i4 = 0;
                i17 = i51;
                str3 = i112;
                i30 = i33;
                i42 = i21;
                str2 = obj38;
                obj38 = i42;
                str5 = "AtomParsers";
                while (i15 < stringBuilder) {
                    i54 = i4;
                    i4 = i20;
                    i20 = 1;
                    while (i4 == 0) {
                        if (aVar.a() != 0) {
                        }
                        i4 = i71;
                        i54 = l42;
                        i30 = i18;
                        str3 = i14;
                        stringBuilder = i57;
                    }
                    if (i23 != 0) {
                    }
                    int i70 = i6;
                    copyOf3[i15] = i54;
                    copyOf4[i15] = eVar.c();
                    if (copyOf4[i15] > i36) {
                    }
                    copyOf[i15] = l41 += i7;
                    if (i24 == 0) {
                    } else {
                    }
                    i27 = 0;
                    copyOf2[i15] = i27;
                    i27 = 1;
                    copyOf2[i15] = i27;
                    if (i15 == i26 && str2-- > 0) {
                    }
                    int i114 = i14;
                    i7 += l10;
                    if (i18 + -1 == 0 && obj38 > 0) {
                    } else {
                    }
                    i49 = i114;
                    i12 = obj38;
                    i15++;
                    i4 = i65;
                    i26 = i117;
                    str3 = i121;
                    i20 = i122;
                    stringBuilder = i57;
                    i6 = i33;
                    i42 = i12;
                    i30 = obj38;
                    obj38 = i42;
                    str5 = "AtomParsers";
                    if (obj38 > 0) {
                    } else {
                    }
                    i56 = d0Var.B();
                    i49 = d0Var.n();
                    i12 = obj38 + -1;
                    i27 = 1;
                    copyOf2[i15] = i27;
                    if (str2-- > 0) {
                    }
                    g.e(i24);
                    i67 -= i27;
                    i27 = 1;
                    i36 = i37;
                    while (i13 == 0) {
                        if (i17 > 0) {
                        }
                        i13 = i23.B();
                        i6 = i23.n();
                        i17--;
                    }
                    i13--;
                    if (i17 > 0) {
                    }
                    i13 = i23.B();
                    i6 = i23.n();
                    i17--;
                    if (aVar.a() != 0) {
                    }
                    i4 = i71;
                    i54 = l42;
                    i30 = i18;
                    str3 = i14;
                    stringBuilder = i57;
                }
                i57 = stringBuilder;
                i18 = i30;
                str4 = i20;
                i34 = i6;
                if (i23 != 0) {
                } else {
                    string = 1;
                }
                if (str2 == null && i18 == 0 && str4 == null && obj38 == null) {
                    if (i18 == 0) {
                        if (str4 == null) {
                            if (obj38 == null) {
                                if (i13 == 0) {
                                    if (string == null) {
                                        str = string == null ? ", ctts invalid" : "";
                                        i3 = stringBuilder;
                                        stringBuilder = new StringBuilder(length7 += 262);
                                        stringBuilder.append("Inconsistent stbl box for track ");
                                        stringBuilder.append(obj.a);
                                        stringBuilder.append(": remainingSynchronizationSamples ");
                                        stringBuilder.append(str2);
                                        stringBuilder.append(", remainingSamplesAtTimestampDelta ");
                                        stringBuilder.append(i18);
                                        stringBuilder.append(", remainingSamplesInChunk ");
                                        stringBuilder.append(str4);
                                        stringBuilder.append(", remainingTimestampDeltaChanges ");
                                        stringBuilder.append(obj38);
                                        stringBuilder.append(", remainingSamplesAtTimestampOffset ");
                                        stringBuilder.append(i50);
                                        stringBuilder.append(str);
                                        v.h(str5, stringBuilder.toString());
                                    } else {
                                        obj = j;
                                        i3 = stringBuilder;
                                    }
                                } else {
                                }
                            } else {
                                i50 = i13;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                lArr = copyOf3;
                iArr8 = copyOf4;
                iArr6 = copyOf2;
                i39 = i36;
                i52 = i3;
                i25 = i24;
                lArr3 = copyOf;
            }
            cmp2 = 1000000;
            long l31 = obj.c;
            long[] lArr8 = obj.h;
            i41 = 1000000;
            if (lArr8 == null) {
                p0.z0(lArr3, i41, i24);
                super(j, lArr, iArr8, i39, lArr3, iArr6, p0.y0(i25, copyOf, cmp2), cmp2);
                return mVar8;
            }
            cmp3 = 1;
            if (lArr8.length == cmp3 && obj.b == cmp3 && lArr3.length >= 2) {
                if (obj.b == cmp3) {
                    if (lArr3.length >= 2) {
                        long[] lArr9 = obj.i;
                        g.e(lArr9);
                        int i86 = 0;
                        i20 = (long[])lArr9[i86];
                        length = obj.h;
                        cmp2 = obj.d;
                        i4 = cmp2;
                        i13 = i20 + l18;
                        i10 = i52;
                        i52 = i41;
                        if (d.a(lArr3, i25, cmp2, i20)) {
                            str2 = (long)i89;
                            i45 = i25;
                            iArr6 = l38;
                            i41 = l6;
                            i52 = p0.y0(i25 - i13, cmp2, str2);
                            cmp3 = 0;
                            if (Long.compare(iArr6, cmp3) == 0) {
                                cmp3 = Integer.MAX_VALUE;
                                if (Long.compare(i52, cmp3) != 0 && Long.compare(iArr6, cmp3) <= 0 && Long.compare(i52, cmp3) <= 0) {
                                    cmp3 = Integer.MAX_VALUE;
                                    if (Long.compare(iArr6, cmp3) <= 0) {
                                        if (Long.compare(i52, cmp3) <= 0) {
                                            Object obj4 = n3;
                                            obj4.a = (int)iArr6;
                                            obj4.b = (int)i52;
                                            p0.z0(lArr3, 1000000, obj4);
                                            int i98 = 1000000;
                                            super(j, lArr, iArr8, i39, lArr3, iArr6, p0.y0(obj.h[0], obj4, i98), i98);
                                            return mVar6;
                                        }
                                    }
                                }
                            } else {
                            }
                        } else {
                            obj38 = iArr6;
                            i45 = i25;
                        }
                    } else {
                        i10 = i52;
                    }
                } else {
                }
            } else {
            }
            long[] lArr6 = obj.h;
            length3 = 0;
            if (lArr6.length == 1 && Long.compare(l20, cmp2) == 0) {
                length3 = 0;
                if (Long.compare(l20, cmp2) == 0) {
                    long[] lArr7 = obj.i;
                    g.e(lArr7);
                    long l21 = (long[])lArr7[length3];
                    i22 = 0;
                    for (long l25 : obj13) {
                        lArr3[i22] = p0.y0(l25 - l21, i25, 1000000);
                    }
                    super(j, lArr, iArr8, i39, lArr3, obj38, p0.y0(i45 - l21, i25, 1000000), cmp2);
                    return mVar7;
                }
            }
            i28 = obj.b == 1 ? 1 : 0;
            iArr9 = new int[lArr6.length];
            iArr5 = new int[lArr6.length];
            long[] lArr21 = obj.i;
            g.e(lArr21);
            i40 = 0;
            i55 = 0;
            i = 0;
            i29 = 0;
            long[] lArr23 = obj.h;
            for (long i31 : obj12) {
                iArr6 = (long[])lArr21[i40];
                if (Long.compare(iArr6, i20) != 0) {
                } else {
                }
                i6 = iArr8;
                i3 = i39;
                i24 = i29;
                i44 = 0;
                i2 = 1;
                i29 = i24;
                i39 = i3;
                iArr8 = i6;
                lArr23 = obj.h;
                i3 = i39;
                i6 = iArr19;
                i2 = 1;
                iArr9[i40] = p0.h(lArr3, iArr6, i25, i2);
                i44 = 0;
                iArr5[i40] = p0.d(lArr3, iArr6 += l16, i25, i28);
                while (iArr9[i40] < iArr5[i40]) {
                    if (i77 &= i2 == 0) {
                    }
                    iArr9[i40] = i78 += i2;
                }
                i += i74;
                if (i29 != iArr9[i40]) {
                } else {
                }
                i32 = i44;
                i24 = i99;
                i55 = i39;
                i32 = i2;
                if (i77 &= i2 == 0) {
                }
                iArr9[i40] = i78 += i2;
            }
            i48 = i39;
            i16 = 0;
            i47 = 1;
            if (i != i10) {
            } else {
                i47 = i16;
            }
            int i80 = i55 | i47;
            lArr2 = i80 != 0 ? new long[i] : lArr;
            iArr4 = i80 != 0 ? new int[i] : iArr7;
            if (i80 != 0) {
                i48 = i16;
            }
            iArr3 = i80 != 0 ? new int[i] : obj38;
            long[] lArr22 = new long[i];
            i9 = i16;
            i19 = 0;
            while (i16 < lArr24.length) {
                length2 = iArr9[i16];
                i25 = iArr5[i16];
                if (i80 != 0) {
                } else {
                }
                l2 = iArr9;
                iArr = iArr7;
                lArr4 = lArr;
                iArr2 = obj38;
                i38 = i48;
                while (length2 < i25) {
                    i48 = length2;
                    lArr22[i9] = l13 += l35;
                    if (i80 != 0 && iArr4[i9] > i38) {
                    }
                    i9++;
                    length2 = i68;
                    lArr3 = i45;
                    i19 = i10;
                    i16 = i18;
                    iArr2 = obj38;
                    if (iArr4[i9] > i38) {
                    }
                    i38 = iArr[i48];
                }
                obj38 = iArr2;
                i18 = i16;
                int i110 = 0;
                l33 += i10;
                i16 = i18 + 1;
                i48 = i38;
                iArr5 = i20;
                lArr = lArr4;
                lArr3 = i45;
                iArr7 = iArr;
                iArr9 = l2;
                i48 = length2;
                lArr22[i9] = l13 += l35;
                if (i80 != 0 && iArr4[i9] > i38) {
                }
                i9++;
                length2 = i68;
                lArr3 = i45;
                i19 = i10;
                i16 = i18;
                iArr2 = obj38;
                if (iArr4[i9] > i38) {
                }
                i38 = iArr[i48];
                iArr5 = i25 - length2;
                System.arraycopy(lArr, length2, lArr2, i9, iArr5);
                l2 = iArr9;
                System.arraycopy(iArr7, length2, iArr4, i9, iArr5);
                lArr4 = lArr;
                System.arraycopy(obj38, length2, iArr3, i9, iArr5);
            }
            super(j, lArr2, iArr4, i48, lArr22, iArr3, p0.y0(i19, d0Var, 1000000), iArr3);
            return mVar10;
        } else {
            bVar2 = obj2.g(1937013298);
            if (bVar2 == null) {
            } else {
                eVar = new d.e(bVar2);
            }
        }
        throw ParserException.a("Track has no sample table size information", 0);
    }

    private static com.google.android.exoplayer2.l2.u.d.c r(d0 d0, int i2, int i3, String string4, t t5, boolean z6) {
        int i9;
        int i8;
        int i4;
        int i13;
        int i15;
        int str2;
        int i10;
        int i5;
        int i12;
        String str;
        com.google.android.exoplayer2.l2.u.d.c cVar;
        t tVar;
        com.google.android.exoplayer2.l2.u.d.c cVar2;
        int i;
        int i11;
        int i14;
        int i6;
        int i7;
        final d0 d0Var = d0;
        final int i16 = i2;
        d0Var.I(12);
        final int i17 = d0.n();
        d.c cVar3 = new d.c(i17);
        final int i18 = 0;
        i14 = i18;
        while (i14 < i17) {
            i11 = d0.e();
            i6 = d0.n();
            if (i6 > 0) {
            } else {
            }
            i8 = i18;
            l.a(i8, "childAtomSize must be positive");
            str2 = d0.n();
            if (str2 != 1635148593 && str2 != 1635148595 && str2 != 1701733238 && str2 != 1831958048 && str2 != 1836070006 && str2 != 1752589105 && str2 != 1751479857 && str2 != 1932670515 && str2 != 1211250227 && str2 != 1987063864 && str2 != 1987063865 && str2 != 1635135537 && str2 != 1685479798 && str2 != 1685479729 && str2 != 1685481573) {
            } else {
            }
            d.w(d0, str2, i11, i6, i2, i3, t5, cVar3, i14);
            d0Var.I(i7 + i6);
            i14++;
            if (str2 != 1635148595) {
            } else {
            }
            if (str2 != 1701733238) {
            } else {
            }
            if (str2 != 1831958048) {
            } else {
            }
            if (str2 != 1836070006) {
            } else {
            }
            if (str2 != 1752589105) {
            } else {
            }
            if (str2 != 1751479857) {
            } else {
            }
            if (str2 != 1932670515) {
            } else {
            }
            if (str2 != 1211250227) {
            } else {
            }
            if (str2 != 1987063864) {
            } else {
            }
            if (str2 != 1987063865) {
            } else {
            }
            if (str2 != 1635135537) {
            } else {
            }
            if (str2 != 1685479798) {
            } else {
            }
            if (str2 != 1685479729) {
            } else {
            }
            if (str2 != 1685481573) {
            } else {
            }
            if (str2 == 1685481521) {
            } else {
            }
            if (str2 != 1836069985 && str2 != 1701733217 && str2 != 1633889587 && str2 != 1700998451 && str2 != 1633889588 && str2 != 1685353315 && str2 != 1685353317 && str2 != 1685353320 && str2 != 1685353324 && str2 != 1685353336 && str2 != 1935764850 && str2 != 1935767394 && str2 != 1819304813 && str2 != 1936684916 && str2 != 1953984371 && str2 != 778924082 && str2 != 778924083 && str2 != 1835557169 && str2 != 1835560241 && str2 != 1634492771 && str2 != 1634492791 && str2 != 1970037111 && str2 != 1332770163) {
            } else {
            }
            i7 = i11;
            d.d(d0, str2, i11, i6, i2, string4, z6, t5, cVar3, i14);
            if (str2 != 1701733217) {
            } else {
            }
            if (str2 != 1633889587) {
            } else {
            }
            if (str2 != 1700998451) {
            } else {
            }
            if (str2 != 1633889588) {
            } else {
            }
            if (str2 != 1685353315) {
            } else {
            }
            if (str2 != 1685353317) {
            } else {
            }
            if (str2 != 1685353320) {
            } else {
            }
            if (str2 != 1685353324) {
            } else {
            }
            if (str2 != 1685353336) {
            } else {
            }
            if (str2 != 1935764850) {
            } else {
            }
            if (str2 != 1935767394) {
            } else {
            }
            if (str2 != 1819304813) {
            } else {
            }
            if (str2 != 1936684916) {
            } else {
            }
            if (str2 != 1953984371) {
            } else {
            }
            if (str2 != 778924082) {
            } else {
            }
            if (str2 != 778924083) {
            } else {
            }
            if (str2 != 1835557169) {
            } else {
            }
            if (str2 != 1835560241) {
            } else {
            }
            if (str2 != 1634492771) {
            } else {
            }
            if (str2 != 1634492791) {
            } else {
            }
            if (str2 != 1970037111) {
            } else {
            }
            if (str2 != 1332770163) {
            } else {
            }
            if (str2 == 1716281667) {
            } else {
            }
            if (str2 != 1414810956 && str2 != 1954034535 && str2 != 2004251764 && str2 != 1937010800) {
            } else {
            }
            d.s(d0, str2, i11, i6, i2, string4, cVar3);
            i7 = i11;
            if (str2 != 1954034535) {
            } else {
            }
            if (str2 != 2004251764) {
            } else {
            }
            if (str2 != 1937010800) {
            } else {
            }
            if (str2 == 1664495672) {
            } else {
            }
            if (str2 == 1835365492) {
            } else {
            }
            if (str2 == 1667329389) {
            }
            i1.b bVar = new i1.b();
            bVar.R(i16);
            bVar.e0("application/x-camera-motion");
            cVar3.b = bVar.E();
            d.k(d0Var, str2, i11, i16, cVar3);
            i8 = 1;
        }
        return cVar3;
    }

    private static void s(d0 d0, int i2, int i3, int i4, int i5, String string6, com.google.android.exoplayer2.l2.u.d.c d$c7) {
        v i6;
        long l;
        int i;
        int obj4;
        byte[] obj5;
        String obj6;
        int obj7;
        d0.I(obj6 += 8);
        obj6 = "application/ttml+xml";
        i6 = 0;
        l = Long.MAX_VALUE;
        if (i2 == 1414810956) {
            obj4 = new i1.b();
            obj4.R(i5);
            obj4.e0(obj6);
            obj4.V(string6);
            obj4.i0(l);
            obj4.T(i6);
            c7.b = obj4.E();
        } else {
            if (i2 == 1954034535) {
                obj7 += -8;
                obj5 = new byte[obj7];
                d0.j(obj5, 0, obj7);
                i6 = v.A(obj5);
                obj6 = "application/x-quicktime-tx3g";
            } else {
                if (i2 == 2004251764) {
                    obj6 = "application/x-mp4-vtt";
                } else {
                    if (i2 == 1937010800) {
                        l = 0;
                    } else {
                        if (i2 != 1664495672) {
                        } else {
                            c7.d = 1;
                            obj6 = "application/x-mp4-cea-608";
                        }
                    }
                }
            }
        }
        obj4 = new IllegalStateException();
        throw obj4;
    }

    private static com.google.android.exoplayer2.l2.u.d.f t(d0 d0) {
        int i3;
        int i;
        int cmp;
        int i5;
        int i2;
        long l;
        byte b;
        int i4;
        i3 = 8;
        d0.I(i3);
        int i8 = c.c(d0.n());
        int i10 = 16;
        i = i8 == 0 ? i3 : i10;
        d0.J(i);
        int i13 = 4;
        d0.J(i13);
        if (i8 == 0) {
            i3 = i13;
        }
        i5 = 0;
        i2 = i5;
        while (i2 < i3) {
            i2++;
        }
        cmp = 1;
        l = -9223372036854775807L;
        if (cmp != 0) {
            d0.J(i3);
        } else {
            if (i8 == 0) {
                i3 = d0.z();
            } else {
                i3 = d0.C();
            }
            if (Long.compare(i3, i4) == 0) {
            } else {
                l = i3;
            }
        }
        d0.J(i10);
        int i6 = d0.n();
        int i9 = d0.n();
        d0.J(i13);
        int i11 = d0.n();
        int obj11 = d0.n();
        int i14 = 65536;
        int i16 = -65536;
        if (i6 == 0 && i9 == i14 && i11 == i16 && obj11 == null) {
            if (i9 == i14) {
                if (i11 == i16) {
                    if (obj11 == null) {
                        i5 = 90;
                    } else {
                        if (i6 == 0 && i9 == i16 && i11 == i14 && obj11 == null) {
                            if (i9 == i16) {
                                if (i11 == i14) {
                                    if (obj11 == null) {
                                        i5 = 270;
                                    } else {
                                        if (i6 == i16 && i9 == 0 && i11 == 0 && obj11 == i16) {
                                            if (i9 == 0) {
                                                if (i11 == 0) {
                                                    if (obj11 == i16) {
                                                        i5 = 180;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        obj11 = new d.f(d0.n(), l, b, i5);
        return obj11;
    }

    private static com.google.android.exoplayer2.l2.u.j u(com.google.android.exoplayer2.l2.u.c.a c$a, com.google.android.exoplayer2.l2.u.c.b c$b2, long l3, t t4, boolean z5, boolean z6) {
        Object second;
        i1 i1Var;
        Object first;
        int jVar;
        Object fVar;
        Object obj2;
        com.google.android.exoplayer2.l2.u.d.c cVar;
        long l5;
        int longValue;
        long l4;
        long l2;
        int i2;
        Object d0Var;
        int i;
        long l;
        int i3;
        Object obj3;
        Object obj4;
        Object obj;
        second = a;
        com.google.android.exoplayer2.l2.u.c.a aVar = second.f(1835297121);
        g.e(aVar);
        com.google.android.exoplayer2.l2.u.c.b bVar2 = (c.a)aVar.g(1751411826);
        g.e(bVar2);
        final int i10 = d.c(d.i(bVar2.b));
        jVar = 0;
        if (i10 == -1) {
            return jVar;
        }
        com.google.android.exoplayer2.l2.u.c.b bVar3 = second.g(1953196132);
        g.e(bVar3);
        fVar = d.t(bVar3.b);
        l5 = -9223372036854775807L;
        if (Long.compare(l3, l5) == 0) {
            obj2 = b2;
            l2 = l4;
        } else {
            obj2 = b2;
            l2 = l3;
        }
        long l6 = d.l(obj2.b);
        if (Long.compare(l2, l5) == 0) {
        } else {
            l5 = p0.y0(l2, obj11, 1000000);
        }
        com.google.android.exoplayer2.l2.u.c.a aVar2 = aVar.f(1835626086);
        g.e(aVar2);
        com.google.android.exoplayer2.l2.u.c.a aVar3 = (c.a)aVar2.f(1937007212);
        g.e(aVar3);
        com.google.android.exoplayer2.l2.u.c.b bVar = aVar.g(1835296868);
        g.e(bVar);
        first = d.j(bVar.b);
        com.google.android.exoplayer2.l2.u.c.b bVar4 = (c.a)aVar3.g(1937011556);
        g.e(bVar4);
        cVar = d.r(bVar4.b, d.f.b(fVar), d.f.c(fVar), (String)first.second, z5, obj24);
        second = second.f(1701082227);
        second = d.f(second);
        if (!z6 && second != null && second != null) {
            second = second.f(1701082227);
            if (second != null) {
                second = d.f(second);
                if (second != null) {
                    obj = second;
                    obj4 = longValue;
                } else {
                    obj = obj4;
                }
            } else {
            }
        } else {
        }
        if (cVar.b == null) {
        } else {
            super(d.f.b(fVar), i10, (Long)first.first.longValue(), obj7, l6, obj9, l5, obj11, cVar.b, cVar.d, cVar.a, cVar.c, obj4, obj);
        }
        return jVar;
    }

    public static List<com.google.android.exoplayer2.l2.u.m> v(com.google.android.exoplayer2.l2.u.c.a c$a, n n2, long l3, t t4, boolean z5, boolean z6, g<com.google.android.exoplayer2.l2.u.j, com.google.android.exoplayer2.l2.u.j> g7) {
        int i;
        Object obj;
        int apply;
        Object obj4;
        n nVar;
        t tVar;
        boolean z;
        boolean z2;
        final Object obj2 = a;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < obj2.d.size()) {
            obj = obj2.d.get(i);
            if (obj.a != 1953653099) {
            } else {
            }
            com.google.android.exoplayer2.l2.u.c.b bVar = a.g(1836476516);
            g.e(bVar);
            apply = obj18.apply(d.u((c.a)obj, (c.b)bVar, l3, obj7, z5, z6));
            if ((j)apply == null) {
            } else {
            }
            com.google.android.exoplayer2.l2.u.c.a aVar = obj.f(1835297121);
            g.e(aVar);
            com.google.android.exoplayer2.l2.u.c.a aVar2 = (c.a)aVar.f(1835626086);
            g.e(aVar2);
            com.google.android.exoplayer2.l2.u.c.a aVar3 = (c.a)aVar2.f(1937007212);
            g.e(aVar3);
            nVar = n2;
            arrayList.add(d.q((j)apply, (c.a)aVar3, n2));
            i++;
            nVar = n2;
            nVar = n2;
            obj4 = obj18;
        }
        return arrayList;
    }

    private static void w(d0 d0, int i2, int i3, int i4, int i5, int i6, t t7, com.google.android.exoplayer2.l2.u.d.c d$c8, int i9) {
        d0 d0Var;
        int i22;
        int i11;
        int second;
        int nVar;
        t tVar;
        int i16;
        int i18;
        int i17;
        int first;
        int i12;
        int i10;
        int i14;
        int i23;
        int i8;
        int length;
        Object second2;
        int str3;
        int intValue;
        String str;
        String str2;
        int i13;
        int i15;
        int i;
        int i7;
        int i20;
        int i24;
        int i19;
        int i21;
        Object obj26;
        int obj28;
        d0Var = d0;
        i11 = i3;
        tVar = t7;
        final Object obj = c8;
        d0Var.I(i44 += 8);
        d0Var.J(16);
        d0Var.J(50);
        second2 = d.o(d0Var, i11, i4);
        if (i2 == 1701733238 && second2 != null) {
            second2 = d.o(d0Var, i11, nVar);
            if (second2 != null) {
                intValue = (Integer)second2.first.intValue();
                if (tVar == null) {
                    tVar = 0;
                } else {
                    tVar = tVar.c(second3.b);
                }
                obj.a[i9] = (k)second2.second;
            }
            d0Var.I(d0.e());
        }
        str3 = intValue == 1831958048 ? "video/mpeg" : intValue == i54 ? str2 : 0;
        i13 = -1;
        i = 1065353216;
        i15 = 0;
        i7 = 0;
        i20 = 0;
        i24 = 0;
        i19 = 0;
        while (i8 - i11 < nVar) {
            d0Var.I(i8);
            length = d0.e();
            obj26 = str2;
            str2 = d0.n();
            obj28 = tVar;
            if (str2 > 0) {
            } else {
            }
            i16 = 0;
            l.a(i16, "childAtomSize must be positive");
            second = d0.n();
            if (second == 1635148611) {
            } else {
            }
            if (second == 1752589123) {
            } else {
            }
            if (second != 1685480259) {
            } else {
            }
            i22 = 0;
            second = o.a(d0);
            if (second != null) {
            }
            i8 += str2;
            d0Var = d0;
            i11 = i3;
            nVar = i4;
            str2 = obj26;
            tVar = obj28;
            i15 = second.a;
            str3 = "video/dolby-vision";
            if (second == 1685485123) {
            } else {
            }
            if (second == 1987076931) {
            } else {
            }
            if (second == 1635135811) {
            } else {
            }
            if (second == 1681012275) {
            } else {
            }
            if (second == 1702061171) {
            } else {
            }
            if (second == 1885434736) {
            } else {
            }
            if (second == 1937126244) {
            } else {
            }
            length = 2;
            if (second == 1936995172) {
            } else {
            }
            if (second == 1668246642) {
            } else {
            }
            i22 = 0;
            int i32 = d0.n();
            if (i32 == 1852009592) {
            } else {
            }
            i10 = 0;
            if (i10 == 0) {
            } else {
            }
            d0Var.J(2);
            if (i10 != 0 && i43 &= 128 != 0) {
            } else {
            }
            i14 = 0;
            if (i14 != 0) {
            } else {
            }
            first = 2;
            nVar = new n(n.a(d0.D()), first, n.b(d0.D()), 0);
            i24 = nVar;
            first = 1;
            if (i43 &= 128 != 0) {
            } else {
            }
            i14 = 1;
            if (i32 == 1852009571) {
            } else {
            }
            String str6 = "Unsupported color type: ";
            String valueOf = String.valueOf(c.a(i32));
            if (valueOf.length() != 0) {
            } else {
            }
            second = new String(str6);
            v.h("AtomParsers", second);
            second = str6.concat(valueOf);
            i10 = 1;
            d0Var.J(3);
            if (d0.x() == 0) {
            }
            second = d0.x();
            if (second != 0) {
            } else {
            }
            i13 = 0;
            if (second != 1) {
            } else {
            }
            i13 = first;
            if (second != length) {
            } else {
            }
            i13 = length;
            if (second != 3) {
            } else {
            }
            i20 = d.n(d0Var, length, str2);
            i = second;
            i22 = 0;
            i19 = 1;
            if (str3 == null) {
            } else {
            }
            i12 = 0;
            l.a(i12, 0);
            Pair pair = d.g(d0Var, length);
            second = pair.second;
            if ((byte[])second != null) {
            }
            str3 = first;
            i7 = v.A((byte[])second);
            i12 = 1;
            second = 0;
            if (str3 == null) {
            } else {
            }
            first = 0;
            l.a(first, second);
            str3 = obj26;
            i22 = second;
            first = 1;
            second = 0;
            if (str3 == null) {
            } else {
            }
            i23 = 0;
            l.a(i23, second);
            i22 = second;
            str3 = first;
            i23 = 1;
            if (str3 == null) {
            } else {
            }
            first = 0;
            l.a(first, 0);
            if (intValue == 1987063864) {
            } else {
            }
            second = "video/x-vnd.on2.vp9";
            str3 = second;
            second = "video/x-vnd.on2.vp8";
            first = 1;
            if (str3 == null) {
            } else {
            }
            i17 = 0;
            l.a(i17, 0);
            d0Var.I(length += 8);
            r rVar = r.a(d0);
            i7 = rVar.a;
            obj.c = rVar.b;
            i15 = rVar.c;
            second = "video/hevc";
            i17 = 1;
            if (str3 == null) {
            } else {
            }
            i18 = 0;
            l.a(i18, 0);
            d0Var.I(length += 8);
            m mVar = m.b(d0);
            i7 = mVar.a;
            obj.c = mVar.b;
            if (i19 == 0) {
            }
            i15 = mVar.d;
            second = "video/avc";
            i = mVar.c;
            i18 = 1;
            i16 = 1;
            obj28 = tVar;
        }
        obj28 = tVar;
        if (str3 == null) {
        }
        i1.b bVar = new i1.b();
        bVar.R(i5);
        bVar.e0(str3);
        bVar.I(i15);
        bVar.j0(d0.D());
        bVar.Q(d0.D());
        bVar.a0(i);
        bVar.d0(i6);
        bVar.b0(i20);
        bVar.h0(i13);
        bVar.T(i7);
        bVar.L(obj28);
        bVar.J(i24);
        obj.b = bVar.E();
    }
}
