package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.a0;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.video.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class i1 implements Parcelable {

    public static final Parcelable.Creator<com.google.android.exoplayer2.i1> CREATOR;
    public final String A;
    public final a B;
    public final String C;
    public final String D;
    public final int E;
    public final List<byte[]> F;
    public final t G;
    public final long H;
    public final int I;
    public final int J;
    public final float K;
    public final int L;
    public final float M;
    public final byte[] N;
    public final int O;
    public final n P;
    public final int Q;
    public final int R;
    public final int S;
    public final int T;
    public final int U;
    public final int V;
    public final Class<? extends a0> W;
    private int X;
    public final String a;
    public final String b;
    public final String c;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.i1> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.i1 a(Parcel parcel) {
            i1 i1Var = new i1(parcel);
            return i1Var;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.i1[] b(int i) {
            return new i1[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }

    public static final class b {

        private int A;
        private int B;
        private int C;
        private Class<? extends a0> D;
        private String a;
        private String b;
        private String c;
        private int d;
        private int e;
        private int f;
        private int g;
        private String h;
        private a i;
        private String j;
        private String k;
        private int l;
        private List<byte[]> m;
        private t n;
        private long o;
        private int p;
        private int q;
        private float r;
        private int s;
        private float t;
        private byte[] u;
        private int v;
        private n w;
        private int x;
        private int y;
        private int z;
        public b() {
            super();
            final int i = -1;
            this.f = i;
            this.g = i;
            this.l = i;
            this.o = Long.MAX_VALUE;
            this.p = i;
            this.q = i;
            this.r = -1082130432;
            this.t = 1065353216;
            this.v = i;
            this.x = i;
            this.y = i;
            this.z = i;
            this.C = i;
        }

        private b(com.google.android.exoplayer2.i1 i1) {
            super();
            this.a = i1.a;
            this.b = i1.b;
            this.c = i1.c;
            this.d = i1.v;
            this.e = i1.w;
            this.f = i1.x;
            this.g = i1.y;
            this.h = i1.A;
            this.i = i1.B;
            this.j = i1.C;
            this.k = i1.D;
            this.l = i1.E;
            this.m = i1.F;
            this.n = i1.G;
            this.o = i1.H;
            this.p = i1.I;
            this.q = i1.J;
            this.r = i1.K;
            this.s = i1.L;
            this.t = i1.M;
            this.u = i1.N;
            this.v = i1.O;
            this.w = i1.P;
            this.x = i1.Q;
            this.y = i1.R;
            this.z = i1.S;
            this.A = i1.T;
            this.B = i1.U;
            this.C = i1.V;
            this.D = i1.W;
        }

        b(com.google.android.exoplayer2.i1 i1, com.google.android.exoplayer2.i1.a i1$a2) {
            super(i1);
        }

        static int A(com.google.android.exoplayer2.i1.b i1$b) {
            return b.f;
        }

        static int B(com.google.android.exoplayer2.i1.b i1$b) {
            return b.g;
        }

        static String C(com.google.android.exoplayer2.i1.b i1$b) {
            return b.h;
        }

        static a D(com.google.android.exoplayer2.i1.b i1$b) {
            return b.i;
        }

        static String a(com.google.android.exoplayer2.i1.b i1$b) {
            return b.a;
        }

        static String b(com.google.android.exoplayer2.i1.b i1$b) {
            return b.j;
        }

        static String c(com.google.android.exoplayer2.i1.b i1$b) {
            return b.k;
        }

        static int d(com.google.android.exoplayer2.i1.b i1$b) {
            return b.l;
        }

        static List e(com.google.android.exoplayer2.i1.b i1$b) {
            return b.m;
        }

        static t f(com.google.android.exoplayer2.i1.b i1$b) {
            return b.n;
        }

        static long g(com.google.android.exoplayer2.i1.b i1$b) {
            return b.o;
        }

        static int h(com.google.android.exoplayer2.i1.b i1$b) {
            return b.p;
        }

        static int i(com.google.android.exoplayer2.i1.b i1$b) {
            return b.q;
        }

        static float j(com.google.android.exoplayer2.i1.b i1$b) {
            return b.r;
        }

        static int k(com.google.android.exoplayer2.i1.b i1$b) {
            return b.s;
        }

        static String l(com.google.android.exoplayer2.i1.b i1$b) {
            return b.b;
        }

        static float m(com.google.android.exoplayer2.i1.b i1$b) {
            return b.t;
        }

        static byte[] n(com.google.android.exoplayer2.i1.b i1$b) {
            return b.u;
        }

        static int o(com.google.android.exoplayer2.i1.b i1$b) {
            return b.v;
        }

        static n p(com.google.android.exoplayer2.i1.b i1$b) {
            return b.w;
        }

        static int q(com.google.android.exoplayer2.i1.b i1$b) {
            return b.x;
        }

        static int r(com.google.android.exoplayer2.i1.b i1$b) {
            return b.y;
        }

        static int s(com.google.android.exoplayer2.i1.b i1$b) {
            return b.z;
        }

        static int t(com.google.android.exoplayer2.i1.b i1$b) {
            return b.A;
        }

        static int u(com.google.android.exoplayer2.i1.b i1$b) {
            return b.B;
        }

        static int v(com.google.android.exoplayer2.i1.b i1$b) {
            return b.C;
        }

        static String w(com.google.android.exoplayer2.i1.b i1$b) {
            return b.c;
        }

        static Class x(com.google.android.exoplayer2.i1.b i1$b) {
            return b.D;
        }

        static int y(com.google.android.exoplayer2.i1.b i1$b) {
            return b.d;
        }

        static int z(com.google.android.exoplayer2.i1.b i1$b) {
            return b.e;
        }

        public com.google.android.exoplayer2.i1 E() {
            i1 i1Var = new i1(this, 0);
            return i1Var;
        }

        public com.google.android.exoplayer2.i1.b F(int i) {
            this.C = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b G(int i) {
            this.f = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b H(int i) {
            this.x = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b I(String string) {
            this.h = string;
            return this;
        }

        public com.google.android.exoplayer2.i1.b J(n n) {
            this.w = n;
            return this;
        }

        public com.google.android.exoplayer2.i1.b K(String string) {
            this.j = string;
            return this;
        }

        public com.google.android.exoplayer2.i1.b L(t t) {
            this.n = t;
            return this;
        }

        public com.google.android.exoplayer2.i1.b M(int i) {
            this.A = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b N(int i) {
            this.B = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b O(Class<? extends a0> class) {
            this.D = class;
            return this;
        }

        public com.google.android.exoplayer2.i1.b P(float f) {
            this.r = f;
            return this;
        }

        public com.google.android.exoplayer2.i1.b Q(int i) {
            this.q = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b R(int i) {
            this.a = Integer.toString(i);
            return this;
        }

        public com.google.android.exoplayer2.i1.b S(String string) {
            this.a = string;
            return this;
        }

        public com.google.android.exoplayer2.i1.b T(List<byte[]> list) {
            this.m = list;
            return this;
        }

        public com.google.android.exoplayer2.i1.b U(String string) {
            this.b = string;
            return this;
        }

        public com.google.android.exoplayer2.i1.b V(String string) {
            this.c = string;
            return this;
        }

        public com.google.android.exoplayer2.i1.b W(int i) {
            this.l = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b X(a a) {
            this.i = a;
            return this;
        }

        public com.google.android.exoplayer2.i1.b Y(int i) {
            this.z = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b Z(int i) {
            this.g = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b a0(float f) {
            this.t = f;
            return this;
        }

        public com.google.android.exoplayer2.i1.b b0(byte[] bArr) {
            this.u = bArr;
            return this;
        }

        public com.google.android.exoplayer2.i1.b c0(int i) {
            this.e = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b d0(int i) {
            this.s = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b e0(String string) {
            this.k = string;
            return this;
        }

        public com.google.android.exoplayer2.i1.b f0(int i) {
            this.y = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b g0(int i) {
            this.d = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b h0(int i) {
            this.v = i;
            return this;
        }

        public com.google.android.exoplayer2.i1.b i0(long l) {
            this.o = l;
            return this;
        }

        public com.google.android.exoplayer2.i1.b j0(int i) {
            this.p = i;
            return this;
        }
    }
    static {
        i1.a aVar = new i1.a();
        i1.CREATOR = aVar;
    }

    i1(Parcel parcel) {
        int int;
        int i3;
        int byteArray;
        int i;
        int i2;
        byte[] byteArray2;
        super();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
        int int6 = parcel.readInt();
        this.y = int6;
        int = int6 != -1 ? int6 : int;
        this.z = int;
        this.A = parcel.readString();
        this.B = (a)parcel.readParcelable(a.class.getClassLoader());
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readInt();
        int int5 = parcel.readInt();
        ArrayList arrayList = new ArrayList(int5);
        this.F = arrayList;
        i3 = 0;
        while (i3 < int5) {
            byteArray2 = parcel.createByteArray();
            g.e(byteArray2);
            this.F.add((byte[])byteArray2);
            i3++;
        }
        Parcelable parcelable2 = parcel.readParcelable(t.class.getClassLoader());
        this.G = (t)parcelable2;
        this.H = parcel.readLong();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readFloat();
        this.L = parcel.readInt();
        this.M = parcel.readFloat();
        if (p0.w0(parcel)) {
            byteArray = parcel.createByteArray();
        } else {
            byteArray = i2;
        }
        this.N = byteArray;
        this.O = parcel.readInt();
        this.P = (n)parcel.readParcelable(n.class.getClassLoader());
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        this.T = parcel.readInt();
        this.U = parcel.readInt();
        this.V = parcel.readInt();
        i2 = parcelable2 != null ? g0.class : i2;
        this.W = i2;
    }

    private i1(com.google.android.exoplayer2.i1.b i1$b) {
        int i;
        List emptyList;
        int i4;
        int i5;
        int i2;
        int i3;
        Class obj6;
        super();
        this.a = i1.b.a(b);
        this.b = i1.b.l(b);
        this.c = p0.p0(i1.b.w(b));
        this.v = i1.b.y(b);
        this.w = i1.b.z(b);
        this.x = i1.b.A(b);
        int i9 = i1.b.B(b);
        this.y = i9;
        final int i20 = -1;
        i = i9 != i20 ? i9 : i;
        this.z = i;
        this.A = i1.b.C(b);
        this.B = i1.b.D(b);
        this.C = i1.b.b(b);
        this.D = i1.b.c(b);
        this.E = i1.b.d(b);
        if (i1.b.e(b) == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = i1.b.e(b);
        }
        this.F = emptyList;
        t tVar = i1.b.f(b);
        this.G = tVar;
        this.H = i1.b.g(b);
        this.I = i1.b.h(b);
        this.J = i1.b.i(b);
        this.K = i1.b.j(b);
        i3 = 0;
        if (i1.b.k(b) == i20) {
            i4 = i3;
        } else {
            i4 = i1.b.k(b);
        }
        this.L = i4;
        if (Float.compare(f2, i21) == 0) {
            i5 = 1065353216;
        } else {
            i5 = i1.b.m(b);
        }
        this.M = i5;
        this.N = i1.b.n(b);
        this.O = i1.b.o(b);
        this.P = i1.b.p(b);
        this.Q = i1.b.q(b);
        this.R = i1.b.r(b);
        this.S = i1.b.s(b);
        if (i1.b.t(b) == i20) {
            i2 = i3;
        } else {
            i2 = i1.b.t(b);
        }
        this.T = i2;
        if (i1.b.u(b) == i20) {
        } else {
            i3 = i1.b.u(b);
        }
        this.U = i3;
        this.V = i1.b.v(b);
        if (i1.b.x(b) == null && tVar != null) {
            if (tVar != null) {
                this.W = g0.class;
            } else {
                this.W = i1.b.x(b);
            }
        } else {
        }
    }

    i1(com.google.android.exoplayer2.i1.b i1$b, com.google.android.exoplayer2.i1.a i1$a2) {
        super(b);
    }

    @Override // android.os.Parcelable
    public com.google.android.exoplayer2.i1.b a() {
        i1.b bVar = new i1.b(this, 0);
        return bVar;
    }

    public com.google.android.exoplayer2.i1 b(Class<? extends a0> class) {
        final com.google.android.exoplayer2.i1.b bVar = a();
        bVar.O(class);
        return bVar.E();
    }

    @Override // android.os.Parcelable
    public int c() {
        int i2;
        int i;
        final int i3 = this.I;
        i2 = -1;
        if (i3 != i2) {
            i = this.J;
            if (i == i2) {
            } else {
                i2 = i3 * i;
            }
        }
        return i2;
    }

    @Override // android.os.Parcelable
    public boolean d(com.google.android.exoplayer2.i1 i1) {
        int i;
        int equals;
        Object obj;
        final int i2 = 0;
        if (this.F.size() != i1.F.size()) {
            return i2;
        }
        i = i2;
        while (i < this.F.size()) {
            i++;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public com.google.android.exoplayer2.i1 e(com.google.android.exoplayer2.i1 i1) {
        String str3;
        String str2;
        int i2;
        int i3;
        a aVar;
        String str;
        int i;
        String str4;
        float f;
        int length;
        int cmp;
        if (this == i1) {
            return this;
        }
        int i4 = z.k(this.D);
        if (i1.b != null) {
        } else {
            str3 = this.b;
        }
        str2 = this.c;
        int i7 = 1;
        if (i4 != 3) {
            i2 = i1.c;
            if (i4 == i7 && i2 != null) {
                i2 = i1.c;
                if (i2 != null) {
                    str2 = i2;
                }
            }
        } else {
        }
        int i8 = -1;
        if (this.x == i8) {
            i3 = i1.x;
        }
        if (this.y == i8) {
            i = i1.y;
        }
        str4 = p0.F(i1.A, i4);
        if (this.A == null && strArr.length == i7) {
            str4 = p0.F(i1.A, i4);
            if (strArr.length == i7) {
                str = str4;
            }
        }
        a aVar2 = this.B;
        if (aVar2 == null) {
            aVar = i1.B;
        } else {
            aVar = aVar2.b(i1.B);
        }
        if (Float.compare(f, i9) == 0 && i4 == 2) {
            if (i4 == 2) {
                f = i1.K;
            }
        }
        com.google.android.exoplayer2.i1.b bVar = a();
        bVar.S(i1.a);
        bVar.U(str3);
        bVar.V(str2);
        bVar.g0(i5 |= i10);
        bVar.c0(i11 |= i13);
        bVar.G(i3);
        bVar.Z(i);
        bVar.I(str);
        bVar.X(aVar);
        bVar.L(t.d(i1.G, this.G));
        bVar.P(f);
        return bVar.E();
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i2;
        int compare;
        Class<com.google.android.exoplayer2.i1> obj;
        Class class;
        int i;
        long l;
        Object obj7;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (i1.class != object.getClass()) {
            } else {
                int i4 = this.X;
                class = object.X;
                if (i4 != 0 && class != null && i4 != class) {
                    class = object.X;
                    if (class != null) {
                        if (i4 != class) {
                            return i3;
                        }
                    }
                }
                if (this.v == object.v && this.w == object.w && this.x == object.x && this.y == object.y && this.E == object.E && Long.compare(l2, l) == 0 && this.I == object.I && this.J == object.J && this.L == object.L && this.O == object.O && this.Q == object.Q && this.R == object.R && this.S == object.S && this.T == object.T && this.U == object.U && this.V == object.V && Float.compare(this.K, object.K) == 0 && Float.compare(this.M, object.M) == 0 && p0.b(this.W, object.W) && p0.b(this.a, object.a) && p0.b(this.b, object.b) && p0.b(this.A, object.A) && p0.b(this.C, object.C) && p0.b(this.D, object.D) && p0.b(this.c, object.c) && Arrays.equals(this.N, object.N) && p0.b(this.B, object.B) && p0.b(this.P, object.P) && p0.b(this.G, object.G) && d((i1)object)) {
                    if (this.w == object.w) {
                        if (this.x == object.x) {
                            if (this.y == object.y) {
                                if (this.E == object.E) {
                                    if (Long.compare(l2, l) == 0) {
                                        if (this.I == object.I) {
                                            if (this.J == object.J) {
                                                if (this.L == object.L) {
                                                    if (this.O == object.O) {
                                                        if (this.Q == object.Q) {
                                                            if (this.R == object.R) {
                                                                if (this.S == object.S) {
                                                                    if (this.T == object.T) {
                                                                        if (this.U == object.U) {
                                                                            if (this.V == object.V) {
                                                                                if (Float.compare(this.K, object.K) == 0) {
                                                                                    if (Float.compare(this.M, object.M) == 0) {
                                                                                        if (p0.b(this.W, object.W)) {
                                                                                            if (p0.b(this.a, object.a)) {
                                                                                                if (p0.b(this.b, object.b)) {
                                                                                                    if (p0.b(this.A, object.A)) {
                                                                                                        if (p0.b(this.C, object.C)) {
                                                                                                            if (p0.b(this.D, object.D)) {
                                                                                                                if (p0.b(this.c, object.c)) {
                                                                                                                    if (Arrays.equals(this.N, object.N)) {
                                                                                                                        if (p0.b(this.B, object.B)) {
                                                                                                                            if (p0.b(this.P, object.P)) {
                                                                                                                                if (p0.b(this.G, object.G)) {
                                                                                                                                    if (d(object)) {
                                                                                                                                    } else {
                                                                                                                                        i2 = i3;
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
            }
            return i2;
        }
        return i3;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i4;
        int i3;
        int i9;
        int i;
        int i2;
        int i5;
        int i7;
        int i8;
        Class cls;
        int i6;
        long l;
        if (this.X == 0) {
            String str = this.a;
            i6 = 0;
            if (str == null) {
                i3 = i6;
            } else {
                i3 = str.hashCode();
            }
            String str2 = this.b;
            if (str2 != null) {
                i9 = str2.hashCode();
            } else {
                i9 = i6;
            }
            String str3 = this.c;
            if (str3 == null) {
                i = i6;
            } else {
                i = str3.hashCode();
            }
            String str4 = this.A;
            if (str4 == null) {
                i2 = i6;
            } else {
                i2 = str4.hashCode();
            }
            a aVar = this.B;
            if (aVar == null) {
                i5 = i6;
            } else {
                i5 = aVar.hashCode();
            }
            String str5 = this.C;
            if (str5 == null) {
                i7 = i6;
            } else {
                i7 = str5.hashCode();
            }
            String str6 = this.D;
            if (str6 == null) {
                i8 = i6;
            } else {
                i8 = str6.hashCode();
            }
            cls = this.W;
            if (cls == null) {
            } else {
                i6 = cls.hashCode();
            }
            this.X = i60 += i6;
        }
        return this.X;
    }

    @Override // android.os.Parcelable
    public String toString() {
        String str = this.a;
        String str4 = this.b;
        final String str7 = this.C;
        final String str8 = this.D;
        final String str9 = this.A;
        final String str10 = this.c;
        StringBuilder stringBuilder = new StringBuilder(i10 += length6);
        stringBuilder.append("Format(");
        stringBuilder.append(str);
        String str2 = ", ";
        stringBuilder.append(str2);
        stringBuilder.append(str4);
        stringBuilder.append(str2);
        stringBuilder.append(str7);
        stringBuilder.append(str2);
        stringBuilder.append(str8);
        stringBuilder.append(str2);
        stringBuilder.append(str9);
        stringBuilder.append(str2);
        stringBuilder.append(this.z);
        stringBuilder.append(str2);
        stringBuilder.append(str10);
        stringBuilder.append(", [");
        stringBuilder.append(this.I);
        stringBuilder.append(str2);
        stringBuilder.append(this.J);
        stringBuilder.append(str2);
        stringBuilder.append(this.K);
        stringBuilder.append("], [");
        stringBuilder.append(this.Q);
        stringBuilder.append(str2);
        stringBuilder.append(this.R);
        stringBuilder.append("])");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int i3;
        Object obj;
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeString(this.A);
        i = 0;
        parcel.writeParcelable(this.B, i);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeInt(this.E);
        int size = this.F.size();
        parcel.writeInt(size);
        i3 = i;
        while (i3 < size) {
            parcel.writeByteArray((byte[])this.F.get(i3));
            i3++;
        }
        parcel.writeParcelable(this.G, i);
        parcel.writeLong(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeFloat(this.K);
        parcel.writeInt(this.L);
        parcel.writeFloat(this.M);
        if (this.N != null) {
            i = 1;
        }
        p0.L0(parcel, i);
        byte[] bArr2 = this.N;
        if (bArr2 != null) {
            parcel.writeByteArray(bArr2);
        }
        parcel.writeInt(this.O);
        parcel.writeParcelable(this.P, i2);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
    }
}
