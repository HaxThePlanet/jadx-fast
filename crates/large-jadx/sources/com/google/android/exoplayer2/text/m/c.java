package com.google.android.exoplayer2.text.m;

import android.accounts.Account;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class c extends com.google.android.exoplayer2.text.m.e {

    private static final int[] A;
    private static final int[] B;
    private static final int[] C;
    private static final int[] D;
    private static final int[] E;
    private static final boolean[] F;
    private static final int[] y;
    private static final int[] z;
    private final d0 g;
    private final int h = 3;
    private final int i;
    private final int j;
    private final long k = -9223372036854775807L;
    private final ArrayList<com.google.android.exoplayer2.text.m.c.a> l;
    private com.google.android.exoplayer2.text.m.c.a m;
    private List<c> n;
    private List<c> o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private byte t;
    private byte u;
    private int v = 0;
    private boolean w = true;
    private long x = -9223372036854775807L;

    private static final class a {

        private final List<com.google.android.exoplayer2.text.m.c.a.a> a;
        private final List<SpannableString> b;
        private final StringBuilder c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        public a(int i, int i2) {
            super();
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.b = arrayList2;
            StringBuilder stringBuilder = new StringBuilder();
            this.c = stringBuilder;
            j(i);
            this.h = i2;
        }

        static int a(com.google.android.exoplayer2.text.m.c.a c$a, int i2) {
            a.f = i2;
            return i2;
        }

        static int b(com.google.android.exoplayer2.text.m.c.a c$a) {
            return a.d;
        }

        static int c(com.google.android.exoplayer2.text.m.c.a c$a, int i2) {
            a.d = i2;
            return i2;
        }

        static int d(com.google.android.exoplayer2.text.m.c.a c$a, int i2) {
            a.e = i2;
            return i2;
        }

        private SpannableString h() {
            int i7;
            int i8;
            int i9;
            int i10;
            int i2;
            int i;
            int i3;
            int i5;
            boolean z;
            int i4;
            int i6;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            final int i11 = 0;
            final int i12 = -1;
            i3 = i10;
            i = i2;
            while (i7 < this.a.size()) {
                Object obj = this.a.get(i7);
                z = obj.b;
                int i14 = obj.a;
                if (i14 != 8) {
                }
                i5 = obj.c;
                i7++;
                if (i7 < this.a.size()) {
                } else {
                }
                i4 = length;
                if (i5 == i4) {
                } else {
                }
                if (i8 != i12 && !z) {
                } else {
                }
                if (i8 == i12 && z) {
                }
                if (i9 != i12 && i3 == 0) {
                } else {
                }
                if (i9 == i12 && i3 != 0) {
                }
                if (i != i2) {
                }
                c.a.n(spannableStringBuilder, i10, i5, i2);
                i2 = i;
                i10 = i5;
                if (i3 != 0) {
                }
                i9 = i5;
                if (i3 == 0) {
                } else {
                }
                c.a.o(spannableStringBuilder, i9, i5);
                i9 = i12;
                if (z) {
                }
                i8 = i5;
                if (!z) {
                } else {
                }
                c.a.q(spannableStringBuilder, i8, i5);
                i8 = i12;
                i4 = obj2.c;
                int i13 = 7;
                if (i14 == i13) {
                } else {
                }
                i6 = i11;
                if (i14 == i13) {
                } else {
                }
                i = c.p()[i14];
                i3 = i6;
                i6 = 1;
            }
            if (i8 != i12 && i8 != length) {
                if (i8 != length) {
                    c.a.q(spannableStringBuilder, i8, length);
                }
            }
            if (i9 != i12 && i9 != length) {
                if (i9 != length) {
                    c.a.o(spannableStringBuilder, i9, length);
                }
            }
            if (i10 != length) {
                c.a.n(spannableStringBuilder, i10, length, i2);
            }
            SpannableString spannableString = new SpannableString(spannableStringBuilder);
            return spannableString;
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
            if (i4 == -1) {
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i4);
            spannableStringBuilder.setSpan(foregroundColorSpan, i2, i3, 33);
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            StyleSpan styleSpan = new StyleSpan(2);
            spannableStringBuilder.setSpan(styleSpan, i2, i3, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            UnderlineSpan underlineSpan = new UnderlineSpan();
            spannableStringBuilder.setSpan(underlineSpan, i2, i3, 33);
        }

        public void e(char c) {
            int length;
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }

        public void f() {
            int i;
            int i2;
            int i3;
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length + -1, length);
                size--;
                while (i >= 0) {
                    i2 = this.a.get(i);
                    i3 = i2.c;
                    if (i3 == length) {
                    }
                    i2.c = i3--;
                    i--;
                }
            }
        }

        public c g(int i) {
            int i7;
            int i8;
            int i2;
            int i6;
            int i3;
            int i5;
            int i4;
            int i9;
            int i10;
            int obj9;
            i11 += i14;
            int i15 = i8 - 32;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            i6 = 0;
            i5 = i6;
            while (i5 < this.b.size()) {
                spannableStringBuilder.append(p0.J0((CharSequence)this.b.get(i5), i15));
                spannableStringBuilder.append('\n');
                i5++;
            }
            spannableStringBuilder.append(p0.J0(h(), i15));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            i15 -= length2;
            i4 = i8 - i16;
            final int i19 = 2;
            final int i20 = 1;
            if (i != Integer.MIN_VALUE) {
            } else {
                if (this.g == i19) {
                    if (Math.abs(i4) >= 3) {
                        if (i16 < 0) {
                            obj9 = i20;
                        } else {
                            if (this.g == i19 && i4 > 0) {
                                obj9 = i4 > 0 ? i19 : i6;
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
            if (obj9 != i20) {
                if (obj9 == i19) {
                    i8 = i16 - 32;
                }
                i13 += i6;
            } else {
                i7 = 1056964608;
            }
            i2 = this.d;
            if (i2 > 7) {
                i17 += -2;
            } else {
                if (this.g == i20) {
                    i2 -= i3;
                }
            }
            c.b bVar = new c.b();
            bVar.o(spannableStringBuilder);
            bVar.p(Layout.Alignment.ALIGN_NORMAL);
            bVar.h((float)i2, i20);
            bVar.k(i7);
            bVar.l(obj9);
            return bVar.a();
        }

        public boolean i() {
            int i;
            boolean length;
            if (this.a.isEmpty() && this.b.isEmpty() && this.c.length() == 0) {
                if (this.b.isEmpty()) {
                    i = this.c.length() == 0 ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }

        public void j(int i) {
            this.g = i;
            this.a.clear();
            this.b.clear();
            final int i2 = 0;
            this.c.setLength(i2);
            this.d = 15;
            this.e = i2;
            this.f = i2;
        }

        public void k() {
            int i;
            this.b.add(h());
            int i4 = 0;
            this.c.setLength(i4);
            this.a.clear();
            while (this.b.size() >= Math.min(this.h, this.d)) {
                this.b.remove(i4);
            }
        }

        public void l(int i) {
            this.g = i;
        }

        public void m(int i) {
            this.h = i;
        }

        public void p(int i, boolean z2) {
            c.a.a aVar = new c.a.a(i, z2, this.c.length());
            this.a.add(aVar);
        }
    }
    static {
        int i2 = 8;
        int[] iArr6 = new int[i2];
        iArr6 = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
        c.y = iArr6;
        int[] iArr = new int[i2];
        iArr = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
        c.z = iArr;
        int[] iArr2 = new int[7];
        iArr2 = new int[]{-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
        c.A = iArr2;
        int[] iArr3 = new int[96];
        iArr3 = new int[]{
            32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
            225, 43, 44, 45, 46, 47, 48, 49, 50, 51,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61,
            62, 63, 64, 65, 66, 67, 68, 69, 70, 71,
            72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
            82, 83, 84, 85, 86, 87, 88, 89, 90, 91,
            233, 93, 237, 243, 250, 97, 98, 99, 100, 101,
            102, 103, 104, 105, 106, 107, 108, 109, 110, 111,
            112, 113, 114, 115, 116, 117, 118, 119, 120, 121,
            122, 231, 247, 209, 241, 9632
        };
        c.B = iArr3;
        int[] iArr4 = new int[16];
        iArr4 = new int[]{174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
        c.C = iArr4;
        int i6 = 32;
        int[] iArr7 = new int[i6];
        iArr7 = new int[]{
            193, 201, 211, 218, 220, 252, 8216, 161, 42, 39,
            8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200,
            202, 203, 235, 206, 207, 239, 212, 217, 249, 219,
            171, 187
        };
        c.D = iArr7;
        int[] iArr5 = new int[i6];
        iArr5 = new int[]{
            195, 227, 205, 204, 236, 210, 242, 213, 245, 123,
            125, 92, 94, 95, 124, 126, 196, 228, 214, 246,
            223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488,
            9492, 9496
        };
        c.E = iArr5;
        boolean[] zArr = new boolean[256];
        zArr = new byte[]{
            0, 1, 1, 0, 1, 0, 0, 1, 1, 0,
            0, 1, 0, 1, 1, 0, 1, 0, 0, 1,
            0, 1, 1, 0, 0, 1, 1, 0, 1, 0,
            0, 1, 1, 0, 0, 1, 0, 1, 1, 0,
            0, 1, 1, 0, 1, 0, 0, 1, 0, 1,
            1, 0, 1, 0, 0, 1, 1, 0, 0, 1,
            0, 1, 1, 0, 1, 0, 0, 1, 0, 1,
            1, 0, 0, 1, 1, 0, 1, 0, 0, 1,
            0, 1, 1, 0, 1, 0, 0, 1, 1, 0,
            0, 1, 0, 1, 1, 0, 0, 1, 1, 0,
            1, 0, 0, 1, 1, 0, 0, 1, 0, 1,
            1, 0, 1, 0, 0, 1, 0, 1, 1, 0,
            0, 1, 1, 0, 1, 0, 0, 1, 1, 0,
            0, 1, 0, 1, 1, 0, 0, 1, 1, 0,
            1, 0, 0, 1, 0, 1, 1, 0, 1, 0,
            0, 1, 1, 0, 0, 1, 0, 1, 1, 0,
            0, 1, 1, 0, 1, 0, 0, 1, 1, 0,
            0, 1, 0, 1, 1, 0, 1, 0, 0, 1,
            0, 1, 1, 0, 0, 1, 1, 0, 1, 0,
            0, 1, 0, 1, 1, 0, 1, 0, 0, 1,
            1, 0, 0, 1, 0, 1, 1, 0, 1, 0,
            0, 1, 0, 1, 1, 0, 0, 1, 1, 0,
            1, 0, 0, 1, 1, 0, 0, 1, 0, 1,
            1, 0, 0, 1, 1, 0, 1, 0, 0, 1,
            0, 1, 1, 0, 1, 0, 0, 1, 1, 0,
            0, 1, 0, 1, 1, 0
        };
        c.F = zArr;
    }

    public c(String string, int i2, long l3) {
        int obj9;
        int obj10;
        super();
        d0 d0Var = new d0();
        this.g = d0Var;
        ArrayList arrayList = new ArrayList();
        this.l = arrayList;
        final int i = 0;
        final int i3 = 4;
        c.a aVar = new c.a(i, i3);
        this.m = aVar;
        if (Long.compare(l3, i4) > 0) {
            l3 *= i5;
        }
        obj10 = l;
        obj10 = 2;
        final int obj11 = 3;
        int obj8 = "application/x-mp4-cea-608".equals(string) ? obj10 : obj8;
        obj8 = obj11;
        obj8 = 1;
        if (i2 != obj8) {
            if (i2 != obj10) {
                if (i2 != obj11) {
                    if (i2 != i3) {
                        v.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                        this.j = i;
                        this.i = i;
                    } else {
                        this.j = obj8;
                        this.i = obj8;
                    }
                } else {
                    this.j = i;
                    this.i = obj8;
                }
            } else {
                this.j = obj8;
                this.i = i;
            }
        } else {
            this.j = i;
            this.i = i;
        }
        N(i);
        M();
    }

    private static boolean A(byte b) {
        int obj0;
        obj0 = b &= 224 == 0 ? 1 : 0;
        return obj0;
    }

    private static boolean B(byte b, byte b2) {
        int obj1;
        int obj2;
        if (b &= 246 == 18 && b2 & 224 == 32) {
            obj1 = b2 & 224 == 32 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static boolean C(byte b, byte b2) {
        int obj1;
        int obj2;
        if (b &= 247 == 17 && b2 & 240 == 32) {
            obj1 = b2 & 240 == 32 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static boolean D(byte b, byte b2) {
        int obj1;
        int obj2;
        if (b &= 246 == 20 && b2 & 240 == 32) {
            obj1 = b2 & 240 == 32 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static boolean E(byte b, byte b2) {
        int obj1;
        int obj2;
        if (b &= 240 == 16 && b2 & 192 == 64) {
            obj1 = b2 & 192 == 64 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static boolean F(byte b) {
        int obj1;
        obj1 = b &= 240 == 16 ? 1 : 0;
        return obj1;
    }

    private boolean G(boolean z, byte b2, byte b3) {
        int i;
        boolean obj3;
        final int i2 = 0;
        if (z && c.F(b2)) {
            if (c.F(b2)) {
                i = 1;
                if (this.s && this.t == b2 && this.u == b3) {
                    if (this.t == b2) {
                        if (this.u == b3) {
                            this.s = i2;
                            return i;
                        }
                    }
                }
                this.s = i;
                this.t = b2;
                this.u = b3;
            } else {
                this.s = i2;
            }
        } else {
        }
        return i2;
    }

    private static boolean H(byte b) {
        int obj1;
        obj1 = b &= 247 == 20 ? 1 : 0;
        return obj1;
    }

    private static boolean I(byte b, byte b2) {
        int obj1;
        int obj2;
        if (b &= 247 == 17 && b2 & 240 == 48) {
            obj1 = b2 & 240 == 48 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static boolean J(byte b, byte b2) {
        int obj1;
        if (b &= 247 == 23 && b2 >= 33 && b2 <= 35) {
            if (b2 >= 33) {
                obj1 = b2 <= 35 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static boolean K(byte b) {
        int i2;
        int i;
        if (1 <= b && b <= 15) {
            if (b <= 15) {
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    private void L(byte b, byte b2) {
        boolean obj3;
        final int i = 0;
        if (c.K(b)) {
            this.w = i;
        } else {
            if (c.H(b)) {
                if (b2 != 32 && b2 != 47) {
                    if (b2 != 47) {
                        if (/* condition */) {
                            this.w = true;
                        } else {
                            switch (b2) {
                                case 41:
                                    this.w = true;
                                    break;
                                case 42:
                                    this.w = i;
                                    break;
                                default:
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        }
    }

    private void M() {
        this.m.j(this.p);
        this.l.clear();
        this.l.add(this.m);
    }

    private void N(int i) {
        int i2;
        int i4;
        int i3;
        List obj3;
        i2 = this.p;
        if (i2 == i) {
        }
        this.p = i;
        i3 = 3;
        if (i == i3) {
            i4 = 0;
            while (i4 < this.l.size()) {
                (c.a)this.l.get(i4).l(i);
                i4++;
            }
        }
        M();
        if (i2 != i3 && i != 1) {
            if (i != 1) {
                if (i == 0) {
                    this.n = Collections.emptyList();
                }
            } else {
            }
        } else {
        }
    }

    private void O(int i) {
        this.q = i;
        this.m.m(i);
    }

    private boolean P() {
        int cmp;
        int i;
        long l2;
        long l;
        l2 = -9223372036854775807L;
        i = 0;
        if (Long.compare(l3, l2) != 0) {
            if (Long.compare(l, l2) == 0) {
            } else {
                if (Long.compare(l2, l) >= 0) {
                    i = 1;
                }
            }
        }
        return i;
    }

    private boolean Q(byte b) {
        byte obj2;
        if (c.A(b)) {
            this.v = c.r(b);
        }
        obj2 = this.v == this.j ? 1 : 0;
        return obj2;
    }

    static int[] p() {
        return c.A;
    }

    private static char q(byte b) {
        return (char)obj1;
    }

    private static int r(byte b) {
        return obj0 &= 1;
    }

    private List<c> s() {
        int i3;
        int i2;
        int i4;
        c cVar;
        int i;
        int size = this.l.size();
        ArrayList arrayList = new ArrayList(size);
        i2 = 2;
        i4 = i3;
        while (i4 < size) {
            cVar = (c.a)this.l.get(i4).g(Integer.MIN_VALUE);
            arrayList.add(cVar);
            if (cVar != null) {
            }
            i4++;
            i2 = Math.min(i2, cVar.i);
        }
        ArrayList arrayList2 = new ArrayList(size);
        while (i3 < size) {
            cVar = arrayList.get(i3);
            if ((c)cVar != null && cVar.i != i2) {
            }
            i3++;
            if (cVar.i != i2) {
            }
            arrayList2.add(cVar);
            g.e((c.a)this.l.get(i3).g(i2));
        }
        return arrayList2;
    }

    private static char t(byte b) {
        return (char)obj1;
    }

    private static char u(byte b) {
        return (char)obj1;
    }

    private static char v(byte b, byte b2) {
        if (b &= 1 == 0) {
            return c.t(b2);
        }
        return c.u(b2);
    }

    private static char w(byte b) {
        return (char)obj1;
    }

    private void x(byte b) {
        int i;
        this.m.e(' ');
        int i4 = 1;
        i = b & 1 == i4 ? i4 : 0;
        this.m.p(obj3 &= 7, i);
    }

    private void y(byte b) {
        int obj5;
        int i4 = 2;
        final int i6 = 3;
        if (b != 32 && b != 41) {
            i6 = 3;
            if (b != 41) {
                int i3 = 1;
                switch (b) {
                    case 37:
                        N(i3);
                        O(i4);
                    case 38:
                        N(i3);
                        O(i6);
                    case 39:
                        N(i3);
                        O(4);
                    default:
                        int i5 = this.p;
                        this.n = s();
                        M();
                        M();
                        this.m.k();
                        this.n = Collections.emptyList();
                        obj5 = this.p;
                        M();
                        this.m.f();
                }
            }
            N(i6);
        }
        N(i4);
    }

    private void z(byte b, byte b2) {
        int i3;
        int aVar2;
        int i;
        com.google.android.exoplayer2.text.m.c.a aVar;
        int i2;
        int i4;
        ArrayList list;
        int i5;
        int obj6;
        int obj7;
        i2 = 0;
        int i9 = 1;
        i3 = b2 & 32 != 0 ? i9 : i2;
        if (i3 != 0) {
            obj6++;
        }
        if (obj6 != c.a.b(this.m) && this.p != i9 && !this.m.i()) {
            if (this.p != i9) {
                if (!this.m.i()) {
                    aVar2 = new c.a(this.p, this.q);
                    this.m = aVar2;
                    this.l.add(aVar2);
                }
            }
            c.a.c(this.m, obj6);
        }
        obj6 = b2 & 16 == 16 ? i9 : i2;
        if (b2 & 1 == i9) {
            i2 = i9;
        }
        obj7 &= 7;
        i4 = obj6 != null ? 8 : obj7;
        this.m.p(i4, i2);
        if (obj6 != null) {
            c.a.d(this.m, c.z[obj7]);
        }
    }

    @Override // com.google.android.exoplayer2.text.m.e
    public void a() {
    }

    @Override // com.google.android.exoplayer2.text.m.e
    public Object c() {
        return i();
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected f f() {
        final List list = this.n;
        this.o = list;
        g.e(list);
        f fVar = new f((List)list);
        return fVar;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    public void flush() {
        super.flush();
        int i = 0;
        this.n = i;
        this.o = i;
        int i2 = 0;
        N(i2);
        O(4);
        M();
        this.r = i2;
        this.s = i2;
        this.t = i2;
        this.u = i2;
        this.v = i2;
        this.w = true;
        this.x = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected void g(i i) {
        int i5;
        int i6;
        int i3;
        int i4;
        int i8;
        int i7;
        int i10;
        int i2;
        byte b;
        boolean z;
        int i9;
        int obj10;
        obj10 = i.c;
        g.e(obj10);
        this.g.G((ByteBuffer)obj10.array(), obj10.limit());
        obj10 = 0;
        i5 = 1;
        i6 = obj10;
        int i14 = this.h;
        while (this.g.a() >= i14) {
            if (i14 == 2) {
            } else {
            }
            i3 = (byte)i13;
            i7 = this.g.x();
            i10 = this.g.x();
            if (i3 & 2 != 0) {
            } else {
            }
            if (i3 & 1 != this.i) {
            } else {
            }
            i2 = (byte)i15;
            b = (byte)i16;
            if (i2 == 0 && b == 0) {
            } else {
            }
            i8 = c.F;
            if (i3 &= 4 == 4 && i8[i7] && i8[i10]) {
            } else {
            }
            i4 = obj10;
            this.r = i4;
            if (G(i4, i2, b)) {
            } else {
            }
            if (!this.r) {
            } else {
            }
            L(i2, b);
            if (!this.w) {
            } else {
            }
            if (!Q(i2)) {
            } else {
            }
            if (c.A(i2)) {
            } else {
            }
            this.m.e(c.q(i2));
            if (b & 224 != 0) {
            }
            i6 = i5;
            i14 = this.h;
            this.m.e(c.q(b));
            if (c.I(i2, b)) {
            } else {
            }
            if (c.B(i2, b)) {
            } else {
            }
            if (c.C(i2, b) != 0) {
            } else {
            }
            if (c.E(i2, b) != 0) {
            } else {
            }
            if (c.J(i2, b)) {
            } else {
            }
            if (c.D(i2, b) != 0) {
            }
            y(b);
            c.a.a(this.m, b += -32);
            z(i2, b);
            x(b);
            this.m.f();
            this.m.e(c.v(i2, b));
            this.m.e(c.w(b));
            if (this.r) {
            }
            M();
            i8 = c.F;
            if (i8[i7]) {
            } else {
            }
            if (i8[i10]) {
            } else {
            }
            i4 = i5;
            if (b == 0) {
            } else {
            }
            i3 = -4;
        }
        if (i6 != 0) {
            obj10 = this.p;
            if (obj10 != i5) {
                if (obj10 == 3) {
                    this.n = s();
                    this.x = k();
                }
            } else {
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.m.e
    public j i() {
        boolean z;
        j jVar = super.i();
        if (jVar != null) {
            return jVar;
        }
        z = j();
        if (P() && z != null) {
            z = j();
            if (z != null) {
                this.n = Collections.emptyList();
                this.x = -9223372036854775807L;
                z.t(k(), obj3, f());
                return z;
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected boolean l() {
        int i;
        i = this.n != this.o ? 1 : 0;
        return i;
    }
}
