package com.google.android.exoplayer2.text.m;

import android.accounts.Account;
import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class d extends com.google.android.exoplayer2.text.m.e {

    private final d0 g;
    private final c0 h;
    private int i = -1;
    private final int j = 1;
    private final com.google.android.exoplayer2.text.m.d.b[] k;
    private com.google.android.exoplayer2.text.m.d.b l = 8;
    private List<c> m;
    private List<c> n;
    private com.google.android.exoplayer2.text.m.d.c o;
    private int p;

    private static final class a {

        private static final Comparator<com.google.android.exoplayer2.text.m.d.a> c;
        public final c a;
        public final int b;
        static {
            d.a.c = a.a;
        }

        public a(java.lang.CharSequence charSequence, Layout.Alignment layout$Alignment2, float f3, int i4, int i5, float f6, int i7, float f8, boolean z9, int i10, int i11) {
            super();
            c.b bVar = new c.b();
            bVar.o(charSequence);
            bVar.p(alignment2);
            bVar.h(f3, i4);
            bVar.i(i5);
            bVar.k(f6);
            bVar.l(i7);
            bVar.n(f8);
            if (z9) {
                bVar.s(i10);
            }
            this.a = bVar.a();
            this.b = i11;
        }

        static Comparator a() {
            return d.a.c;
        }

        static int b(com.google.android.exoplayer2.text.m.d.a d$a, com.google.android.exoplayer2.text.m.d.a d$a2) {
            return Integer.compare(a2.b, a.b);
        }
    }

    private static final class b {

        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;
        public static final int w;
        public static final int x;
        public static final int y;
        private static final int[] z;
        private final List<SpannableString> a;
        private final SpannableStringBuilder b;
        private boolean c;
        private boolean d;
        private int e;
        private boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u;
        private int v;
        static {
            final int i = 2;
            final int i2 = 0;
            d.b.w = d.b.h(i, i, i, i2);
            int i4 = d.b.h(i2, i2, i2, i2);
            d.b.x = i4;
            final int i5 = 3;
            final int i6 = d.b.h(i2, i2, i2, i5);
            d.b.y = i6;
            int i7 = 7;
            int[] iArr2 = new int[i7];
            iArr2 = new int[]{0, 0, 0, 0, 0, 2, 0};
            d.b.z = iArr2;
            int[] iArr3 = new int[i7];
            iArr3 = new int[]{0, 0, 0, 0, 0, 0, 2};
            d.b.A = iArr3;
            int[] iArr4 = new int[i7];
            iArr4 = new int[]{3, 3, 3, 3, 3, 3, 1};
            d.b.B = iArr4;
            boolean[] zArr = new boolean[i7];
            zArr = new byte[]{0, 0, 0, 1, 1, 1, 0};
            d.b.C = zArr;
            int[] iArr5 = new int[i7];
            iArr5[i2] = i4;
            final int i8 = 1;
            iArr5[i8] = i6;
            iArr5[i] = i4;
            iArr5[i5] = i4;
            final int i9 = 4;
            iArr5[i9] = i6;
            final int i10 = 5;
            iArr5[i10] = i4;
            final int i11 = 6;
            iArr5[i11] = i4;
            d.b.D = iArr5;
            int[] iArr6 = new int[i7];
            iArr6 = new int[]{0, 1, 2, 3, 4, 3, 4};
            d.b.E = iArr6;
            int[] iArr7 = new int[i7];
            iArr7 = new int[]{0, 0, 0, 0, 0, 3, 3};
            d.b.F = iArr7;
            int[] iArr = new int[i7];
            iArr[i2] = i4;
            iArr[i8] = i4;
            iArr[i] = i4;
            iArr[i5] = i4;
            iArr[i9] = i4;
            iArr[i10] = i6;
            iArr[i11] = i6;
            d.b.G = iArr;
        }

        public b() {
            super();
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.b = spannableStringBuilder;
            l();
        }

        public static int g(int i, int i2, int i3) {
            return d.b.h(i, i2, i3, 0);
        }

        public static int h(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int obj4;
            int obj5;
            int obj7;
            i5 = 0;
            int i7 = 4;
            g.c(i, i5, i7);
            g.c(i2, i5, i7);
            g.c(i3, i5, i7);
            g.c(i4, i5, i7);
            int i8 = 1;
            final int i9 = 255;
            if (i4 != 0 && i4 != i8) {
                if (i4 != i8) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            obj7 = i9;
                        } else {
                            obj7 = i5;
                        }
                    } else {
                        obj7 = 127;
                    }
                } else {
                }
            } else {
            }
            obj4 = i > i8 ? i9 : i5;
            obj5 = i2 > i8 ? i9 : i5;
            if (i3 > i8) {
                i5 = i9;
            }
            return Color.argb(obj7, obj4, obj5, i5);
        }

        public void a(char c) {
            int i;
            int i2;
            int obj3;
            if (c == 10) {
                this.a.add(d());
                this.b.clear();
                i = -1;
                i2 = 0;
                if (this.p != i) {
                    this.p = i2;
                }
                if (this.q != i) {
                    this.q = i2;
                }
                if (this.r != i) {
                    this.r = i2;
                }
                if (this.t != i) {
                    this.t = i2;
                }
                while (this.k) {
                    if (this.a.size() >= this.j) {
                    }
                    this.a.remove(i2);
                    if (this.a.size() >= 15) {
                    }
                }
            } else {
                this.b.append(c);
            }
        }

        public void b() {
            SpannableStringBuilder sb;
            int i;
            int length = this.b.length();
            if (length > 0) {
                this.b.delete(length + -1, length);
            }
        }

        public com.google.android.exoplayer2.text.m.d.a c() {
            int i5;
            int i4;
            Layout.Alignment aLIGN_OPPOSITE;
            int i;
            int i2;
            int i7;
            int i3;
            int i6;
            int i8;
            int i9;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            i5 = 0;
            i4 = i5;
            while (i4 < this.a.size()) {
                spannableStringBuilder.append((CharSequence)this.a.get(i4));
                spannableStringBuilder.append('\n');
                i4++;
            }
            spannableStringBuilder.append(d());
            int i11 = this.l;
            int i18 = 2;
            int i20 = 3;
            int i22 = 1;
            if (i11 != 0) {
                if (i11 != i22) {
                    if (i11 != i18) {
                        if (i11 != i20) {
                        } else {
                            aLIGN_OPPOSITE = Layout.Alignment.ALIGN_NORMAL;
                        }
                        StringBuilder stringBuilder = new StringBuilder(43);
                        stringBuilder.append("Unexpected justification value: ");
                        stringBuilder.append(this.l);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                        throw illegalArgumentException;
                    }
                    aLIGN_OPPOSITE = Layout.Alignment.ALIGN_CENTER;
                } else {
                    aLIGN_OPPOSITE = Layout.Alignment.ALIGN_OPPOSITE;
                }
            } else {
            }
            if (this.f) {
                i3 = 1120272384;
                f /= i3;
                f3 /= i3;
            } else {
                f2 /= i28;
                i6 = i3 / i35;
            }
            int i25 = 1063675494;
            int i36 = 1028443341;
            i2 = this.i;
            i8 = i2 / 3 == 0 ? i5 : i34 == i22 ? i22 : i18;
            i9 = i2 % 3 == 0 ? i5 : i2 == i22 ? i22 : i18;
            if (this.o != d.b.x) {
                i5 = i22;
            }
            super(spannableStringBuilder, aLIGN_OPPOSITE, i31 + i36, 0, i8, i14 + i36, i9, -8388609, i5, this.o, this.e);
            return aVar2;
        }

        public SpannableString d() {
            int backgroundColorSpan;
            int styleSpan;
            int underlineSpan;
            int foregroundColorSpan;
            int i3;
            int i;
            int i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.b);
            int length = spannableStringBuilder.length();
            i3 = 33;
            i = -1;
            if (length > 0 && this.p != i) {
                i3 = 33;
                i = -1;
                if (this.p != i) {
                    styleSpan = new StyleSpan(2);
                    spannableStringBuilder.setSpan(styleSpan, this.p, length, i3);
                }
                if (this.q != i) {
                    underlineSpan = new UnderlineSpan();
                    spannableStringBuilder.setSpan(underlineSpan, this.q, length, i3);
                }
                if (this.r != i) {
                    foregroundColorSpan = new ForegroundColorSpan(this.s);
                    spannableStringBuilder.setSpan(foregroundColorSpan, this.r, length, i3);
                }
                if (this.t != i) {
                    backgroundColorSpan = new BackgroundColorSpan(this.u);
                    spannableStringBuilder.setSpan(backgroundColorSpan, this.t, length, i3);
                }
            }
            SpannableString spannableString = new SpannableString(spannableStringBuilder);
            return spannableString;
        }

        public void e() {
            this.a.clear();
            this.b.clear();
            int i = -1;
            this.p = i;
            this.q = i;
            this.r = i;
            this.t = i;
            this.v = 0;
        }

        public void f(boolean z, boolean z2, boolean z3, int i4, boolean z5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            boolean z4;
            int i3;
            int i14;
            int i13;
            int size;
            int i;
            int i5;
            int i2;
            int i15;
            int[] iArr;
            boolean obj12;
            int obj13;
            int obj14;
            boolean obj15;
            int obj16;
            int obj17;
            int obj18;
            int obj19;
            final Object obj = this;
            z4 = z2;
            i3 = i11;
            i14 = i12;
            obj.c = true;
            obj.d = z;
            obj.k = z4;
            obj.e = i4;
            obj.f = z5;
            obj.g = i6;
            obj.h = i7;
            obj.i = i10;
            i = i8 + 1;
            if (obj.j != i) {
                obj.j = i;
                while (z4) {
                    if (obj.a.size() >= obj.j) {
                    }
                    obj.a.remove(0);
                    if (obj.a.size() >= 15) {
                    }
                }
            }
            if (i3 != 0 && obj.m != i3) {
                if (obj.m != i3) {
                    obj.m = i3;
                    int i16 = i3 + -1;
                    this.q(d.b.D[i16], d.b.y, d.b.C[i16], 0, d.b.A[i16], d.b.B[i16], d.b.z[i16]);
                }
            }
            if (i14 != 0 && obj.n != i14) {
                if (obj.n != i14) {
                    obj.n = i14;
                    int i17 = i14 + -1;
                    this.m(0, 1, 1, false, false, d.b.F[i17], d.b.E[i17]);
                    n(d.b.w, d.b.G[i17], d.b.x);
                }
            }
        }

        public boolean i() {
            return this.c;
        }

        public boolean j() {
            boolean length;
            int i;
            if (i()) {
                if (this.a.isEmpty() && this.b.length() == 0) {
                    if (this.b.length() == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public boolean k() {
            return this.d;
        }

        public void l() {
            e();
            int i = 0;
            this.c = i;
            this.d = i;
            this.e = 4;
            this.f = i;
            this.g = i;
            this.h = i;
            this.i = i;
            this.j = 15;
            this.k = true;
            this.l = i;
            this.m = i;
            this.n = i;
            int i2 = d.b.x;
            this.o = i2;
            this.s = d.b.w;
            this.u = i2;
        }

        public void m(int i, int i2, int i3, boolean z4, boolean z5, int i6, int i7) {
            int obj1;
            StyleSpan obj4;
            int obj5;
            int obj6;
            int obj7;
            final int obj2 = 33;
            final int obj3 = -1;
            if (this.p != obj3) {
                if (z4 == null) {
                    obj4 = new StyleSpan(2);
                    this.b.setSpan(obj4, this.p, this.b.length(), obj2);
                    this.p = obj3;
                }
            } else {
                if (z4 != null) {
                    this.p = this.b.length();
                }
            }
            if (this.q != obj3) {
                if (z5 == 0) {
                    obj4 = new UnderlineSpan();
                    this.b.setSpan(obj4, this.q, this.b.length(), obj2);
                    this.q = obj3;
                }
            } else {
                if (z5 != 0) {
                    this.q = this.b.length();
                }
            }
        }

        public void n(int i, int i2, int i3) {
            int i4;
            ForegroundColorSpan foregroundColorSpan;
            int i5;
            int length;
            int obj6;
            int obj8;
            final int i6 = 33;
            i4 = -1;
            if (this.r != i4 && this.s != i) {
                if (this.s != i) {
                    foregroundColorSpan = new ForegroundColorSpan(this.s);
                    this.b.setSpan(foregroundColorSpan, this.r, this.b.length(), i6);
                }
            }
            if (i != d.b.w) {
                this.r = this.b.length();
                this.s = i;
            }
            if (this.t != i4 && this.u != i2) {
                if (this.u != i2) {
                    obj8 = new BackgroundColorSpan(this.u);
                    this.b.setSpan(obj8, this.t, this.b.length(), i6);
                }
            }
            if (i2 != d.b.x) {
                this.t = this.b.length();
                this.u = i2;
            }
        }

        public void o(int i, int i2) {
            int obj2;
            if (this.v != i) {
                a('\n');
            }
            this.v = i;
        }

        public void p(boolean z) {
            this.d = z;
        }

        public void q(int i, int i2, boolean z3, int i4, int i5, int i6, int i7) {
            this.o = i;
            this.l = i7;
        }
    }

    private static final class c {

        public final int a;
        public final int b;
        public final byte[] c;
        int d = 0;
        public c(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
            this.c = new byte[obj2--];
            int obj1 = 0;
        }
    }
    public d(int i, List<byte[]> list2) {
        int i2;
        com.google.android.exoplayer2.text.m.d.b[] objArr;
        com.google.android.exoplayer2.text.m.d.b bVar;
        int obj4;
        super();
        d0 d0Var = new d0();
        this.g = d0Var;
        c0 c0Var = new c0();
        this.h = c0Var;
        obj4 = 1;
        if (list2 != null) {
            obj4 = j.f(list2);
        }
        obj4 = 8;
        this.k = new d.b[obj4];
        int obj5 = 0;
        i2 = obj5;
        while (i2 < obj4) {
            bVar = new d.b();
            this.k[i2] = bVar;
            i2++;
        }
        obj4 = this.k[obj5];
    }

    private void A() {
        int i2 = 2;
        int i3 = 3;
        this.l.m(this.h.h(4), this.h.h(i2), this.h.h(i2), this.h.g(), this.h.g(), this.h.h(i3), this.h.h(i3));
    }

    private void B() {
        int i3 = 2;
        this.h.q(i3);
        this.l.n(d.b.h(this.h.h(i3), this.h.h(i3), this.h.h(i3), this.h.h(i3)), d.b.h(this.h.h(i3), this.h.h(i3), this.h.h(i3), this.h.h(i3)), d.b.g(this.h.h(i3), this.h.h(i3), this.h.h(i3)));
    }

    private void C() {
        int i2 = 4;
        this.h.q(i2);
        this.h.q(2);
        this.l.o(this.h.h(i2), this.h.h(6));
    }

    private void D() {
        int i;
        int i3 = 2;
        if (this.h.g()) {
            i |= 4;
        }
        this.h.q(8);
        this.l.q(d.b.h(this.h.h(i3), this.h.h(i3), this.h.h(i3), this.h.h(i3)), d.b.g(this.h.h(i3), this.h.h(i3), this.h.h(i3)), this.h.g(), i, this.h.h(i3), this.h.h(i3), this.h.h(i3));
    }

    @RequiresNonNull("currentDtvCcPacket")
    private void E() {
        Object string3;
        int string2;
        int i2;
        int str;
        int str2;
        int string;
        int str3;
        int stringBuilder2;
        int stringBuilder;
        int i3;
        StringBuilder stringBuilder3;
        int i;
        int i4;
        string3 = this.o;
        str = string3.d;
        str3 = string3.b;
        final int i18 = 1;
        i3 = 2;
        final String str7 = "Cea708Decoder";
        if (str != i16 -= i18) {
            stringBuilder3 = new StringBuilder(115);
            stringBuilder3.append("DtvCcPacket ended prematurely; size is ");
            stringBuilder3.append(i14 -= i18);
            stringBuilder3.append(", but current index is ");
            stringBuilder3.append(str);
            stringBuilder3.append(" (sequence number ");
            stringBuilder3.append(string3.a);
            stringBuilder3.append(");");
            v.b(str7, stringBuilder3.toString());
        }
        com.google.android.exoplayer2.text.m.d.c cVar = this.o;
        this.h.n(cVar.c, cVar.d);
        stringBuilder2 = 7;
        this.h.q(i3);
        string2 = this.h.h(6);
        if (this.h.h(3) == stringBuilder2 && string2 < stringBuilder2) {
            this.h.q(i3);
            string2 = this.h.h(6);
            if (string2 < stringBuilder2) {
                stringBuilder = new StringBuilder(44);
                stringBuilder.append("Invalid extended service number: ");
                stringBuilder.append(string2);
                v.h(str7, stringBuilder.toString());
            }
        }
        if (this.h.h(5) == 0 && string2 != null) {
            if (string2 != null) {
                stringBuilder2 = new StringBuilder(59);
                stringBuilder2.append("serviceNumber is non-zero (");
                stringBuilder2.append(string2);
                stringBuilder2.append(") when blockSize is 0");
                v.h(str7, stringBuilder2.toString());
            }
        }
        if (string2 != this.j) {
        }
        i2 = 0;
        while (this.h.b() > 0) {
            stringBuilder2 = 8;
            string = this.h.h(stringBuilder2);
            i3 = 255;
            stringBuilder3 = 159;
            i = 127;
            i4 = 31;
            if (string != 16) {
            } else {
            }
            string = this.h.h(stringBuilder2);
            if (string <= i4) {
            } else {
            }
            if (string <= i) {
            } else {
            }
            if (string <= stringBuilder3) {
            } else {
            }
            if (string <= i3) {
            } else {
            }
            stringBuilder = new StringBuilder(37);
            stringBuilder.append("Invalid extended command: ");
            stringBuilder.append(string);
            v.h(str7, stringBuilder.toString());
            z(string);
            i2 = i18;
            u(string);
            y(string);
            t(string);
            if (string <= i4) {
            } else {
            }
            if (string <= i) {
            } else {
            }
            if (string <= stringBuilder3) {
            } else {
            }
            if (string <= i3) {
            } else {
            }
            stringBuilder = new StringBuilder(33);
            stringBuilder.append("Invalid base command: ");
            stringBuilder.append(string);
            v.h(str7, stringBuilder.toString());
            x(string);
            s(string);
            w(string);
            r(string);
        }
        if (i2 != 0) {
            this.m = q();
        }
    }

    private void F() {
        int i;
        com.google.android.exoplayer2.text.m.d.b bVar;
        i = 0;
        while (i < 8) {
            this.k[i].l();
            i++;
        }
    }

    private void p() {
        if (this.o == null) {
        }
        E();
        this.o = 0;
    }

    private List<c> q() {
        int i2;
        int i;
        boolean z;
        int size;
        ArrayList arrayList = new ArrayList();
        i = i2;
        while (i < 8) {
            z = this.k[i].c();
            if (!this.k[i].j() && this.k[i].k() && z != null) {
            }
            i++;
            if (this.k[i].k()) {
            }
            z = this.k[i].c();
            if (z != null) {
            }
            arrayList.add(z);
        }
        Collections.sort(arrayList, d.a.a());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        while (i2 < arrayList.size()) {
            arrayList2.add(obj.a);
            i2++;
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void r(int i) {
        int stringBuilder;
        int i2;
        Object stringBuilder2;
        String str;
        StringBuilder stringBuilder3;
        int obj5;
        if (i != 0) {
            if (i != 3) {
                stringBuilder = 8;
                if (i != stringBuilder) {
                    switch (i) {
                        case 12:
                            F();
                            break;
                        case 13:
                            this.l.a('\n');
                            break;
                        default:
                            str = "Cea708Decoder";
                            stringBuilder3 = new StringBuilder(55);
                            stringBuilder3.append("Currently unsupported COMMAND_EXT1 Command: ");
                            stringBuilder3.append(i);
                            v.h(str, stringBuilder3.toString());
                            this.h.q(stringBuilder);
                            int i5 = 31;
                            stringBuilder2 = new StringBuilder(54);
                            stringBuilder2.append("Currently unsupported COMMAND_P16 Command: ");
                            stringBuilder2.append(i);
                            v.h(str, stringBuilder2.toString());
                            this.h.q(16);
                            stringBuilder = new StringBuilder(i5);
                            stringBuilder.append("Invalid C0 command: ");
                            stringBuilder.append(i);
                            v.h(str, stringBuilder.toString());
                    }
                } else {
                    this.l.b();
                }
            } else {
                this.m = q();
            }
        }
    }

    private void s(int i) {
        int str;
        int stringBuilder;
        int i2;
        boolean z;
        int obj5;
        str = 16;
        stringBuilder = 8;
        i2 = 1;
        switch (i) {
            case 128:
                i += -128;
                this.p = obj5;
                this.l = this.k[obj5];
                break;
            case 129:
                this.k[i2 - 8].e();
                i2++;
                break;
            case 130:
                obj5 = i2;
                this.k[obj5 - 8].p(i2);
                obj5++;
                break;
            case 131:
                this.k[i2 - 8].p(false);
                i2++;
                break;
            case 132:
                obj5 = i2;
                str = this.k[obj5 - 8];
                str.p(z2 ^= i2);
                obj5++;
                break;
            case 133:
                this.k[i2 - 8].l();
                i2++;
                break;
            case 134:
                this.h.q(stringBuilder);
                break;
            case 136:
                F();
                break;
            case 137:
                this.h.q(str);
                A();
                break;
            case 138:
                this.h.q(24);
                B();
                break;
            case 139:
                this.h.q(str);
                C();
                break;
            case 140:
                stringBuilder = new StringBuilder(31);
                stringBuilder.append("Invalid C1 command: ");
                stringBuilder.append(i);
                v.h("Cea708Decoder", stringBuilder.toString());
                break;
            case 141:
                this.h.q(32);
                D();
                break;
            default:
                i += -152;
                v(obj5);
                this.p = obj5;
                this.l = this.k[obj5];
        }
    }

    private void t(int i) {
        int i2;
        c0 obj2;
        if (i <= 7) {
        } else {
            if (i <= 15) {
                this.h.q(8);
            } else {
                if (i <= 23) {
                    this.h.q(16);
                } else {
                    if (i <= 31) {
                        this.h.q(24);
                    }
                }
            }
        }
    }

    private void u(int i) {
        int i2;
        c0 obj2;
        if (i <= 135) {
            this.h.q(32);
        } else {
            if (i <= 143) {
                this.h.q(40);
            } else {
                if (i <= 159) {
                    this.h.q(2);
                    this.h.q(obj2 *= 8);
                }
            }
        }
    }

    private void v(int i) {
        int i2 = 2;
        this.h.q(i2);
        int i3 = 3;
        int i10 = 4;
        this.h.q(i2);
        this.h.q(i2);
        this.k[i].f(this.h.g(), this.h.g(), this.h.g(), this.h.h(i3), this.h.g(), this.h.h(7), this.h.h(8), this.h.h(i10), this.h.h(6), this.h.h(i10), this.h.h(i3), this.h.h(i3));
    }

    private void w(int i) {
        int i2;
        com.google.android.exoplayer2.text.m.d.b obj2;
        if (i == 127) {
            this.l.a('\u266b');
        } else {
            this.l.a((char)obj2);
        }
    }

    private void x(int i) {
        this.l.a((char)obj2);
    }

    private void y(int i) {
        int str;
        int stringBuilder;
        Object obj3;
        str = 32;
        if (i != str) {
            int i2 = 33;
            if (i != i2) {
                if (i != 37) {
                    if (i != 42) {
                        if (i != 44) {
                            if (i != 63) {
                                if (i != 57) {
                                    if (i != 58) {
                                        if (i != 60) {
                                            if (i != 61) {
                                                switch (i) {
                                                    case 48:
                                                        this.l.a('\u2588');
                                                        break;
                                                    case 49:
                                                        this.l.a('\u2018');
                                                        break;
                                                    case 50:
                                                        this.l.a('\u2019');
                                                        break;
                                                    case 51:
                                                        this.l.a('\u201c');
                                                        break;
                                                    case 52:
                                                        this.l.a('\u201d');
                                                        break;
                                                    case 53:
                                                        this.l.a('\u2022');
                                                        break;
                                                    default:
                                                        stringBuilder = new StringBuilder(i2);
                                                        stringBuilder.append("Invalid G2 character: ");
                                                        stringBuilder.append(i);
                                                        v.h("Cea708Decoder", stringBuilder.toString());
                                                        this.l.a('\u250c');
                                                        this.l.a('\u2518');
                                                        this.l.a('\u2500');
                                                        this.l.a('\u2514');
                                                        this.l.a('\u2510');
                                                        this.l.a('\u2502');
                                                        this.l.a('\u215e');
                                                        this.l.a('\u215d');
                                                        this.l.a('\u215c');
                                                        this.l.a('\u215b');
                                                }
                                            } else {
                                                this.l.a('\u2120');
                                            }
                                        } else {
                                            this.l.a('\u0153');
                                        }
                                    } else {
                                        this.l.a('\u0161');
                                    }
                                } else {
                                    this.l.a('\u2122');
                                }
                            } else {
                                this.l.a('\u0178');
                            }
                        } else {
                            this.l.a('\u0152');
                        }
                    } else {
                        this.l.a('\u0160');
                    }
                } else {
                    this.l.a('\u2026');
                }
            } else {
                this.l.a('\u00a0');
            }
        } else {
            this.l.a(str);
        }
    }

    private void z(int i) {
        int i2;
        StringBuilder stringBuilder;
        com.google.android.exoplayer2.text.m.d.b obj3;
        if (i == 160) {
            this.l.a('\u33c4');
        } else {
            stringBuilder = new StringBuilder(33);
            stringBuilder.append("Invalid G3 character: ");
            stringBuilder.append(i);
            v.h("Cea708Decoder", stringBuilder.toString());
            this.l.a('_');
        }
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected f f() {
        final List list = this.m;
        this.n = list;
        g.e(list);
        f fVar = new f((List)list);
        return fVar;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    public void flush() {
        super.flush();
        final int i = 0;
        this.m = i;
        this.n = i;
        int i2 = 0;
        this.p = i2;
        this.l = this.k[i2];
        F();
        this.o = i;
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected void g(i i) {
        byte[] array;
        int i3;
        d0 cVar;
        int string;
        int str;
        int stringBuilder;
        int i4;
        byte b2;
        byte b;
        int i2;
        int obj9;
        obj9 = i.c;
        g.e(obj9);
        this.g.G((ByteBuffer)obj9.array(), obj9.limit());
        array = 3;
        while (this.g.a() >= array) {
            obj9 &= 7;
            cVar = obj9 & 3;
            str = 4;
            i4 = 1;
            if (obj9 &= str == str) {
            } else {
            }
            obj9 = stringBuilder;
            b2 = (byte)i11;
            b = (byte)i12;
            i2 = 2;
            if (cVar != i2 && cVar != array) {
            } else {
            }
            if (obj9 == null) {
            } else {
            }
            obj9 = "Cea708Decoder";
            if (cVar == array) {
            } else {
            }
            if (cVar == i2) {
            }
            g.a(stringBuilder);
            i3 = this.o;
            if (i3 == null) {
            } else {
            }
            obj9 = i3.c;
            int i9 = i3.d;
            str = i9 + 1;
            i3.d = str;
            obj9[i9] = b2;
            i3.d = str + 1;
            obj9[str] = b;
            obj9 = this.o;
            if (obj9.d == obj9 -= i4) {
            }
            array = 3;
            p();
            v.c(obj9, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
            stringBuilder = i4;
            p();
            i5 >>= 6;
            string = this.i;
            if (string != -1 && i6 != i7 %= str) {
            }
            this.i = i6;
            if (b2 & 63 == 0) {
            }
            cVar = new d.c(i6, obj9);
            this.o = cVar;
            i3 = cVar.d;
            cVar.d = i3 + 1;
            cVar.c[i3] = b;
            obj9 = 64;
            if (i6 != i7 %= str) {
            }
            F();
            stringBuilder = new StringBuilder(71);
            stringBuilder.append("Sequence number discontinuity. previous=");
            stringBuilder.append(this.i);
            stringBuilder.append(" current=");
            stringBuilder.append(i6);
            v.h(obj9, stringBuilder.toString());
            if (cVar != array) {
            } else {
            }
            obj9 = i4;
        }
    }

    @Override // com.google.android.exoplayer2.text.m.e
    protected boolean l() {
        int i;
        i = this.m != this.n ? 1 : 0;
        return i;
    }
}
