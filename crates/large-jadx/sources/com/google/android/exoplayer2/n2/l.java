package com.google.android.exoplayer2.n2;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.v;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class l implements Parcelable {

    public static final Parcelable.Creator<com.google.android.exoplayer2.n2.l> CREATOR;
    public static final com.google.android.exoplayer2.n2.l O;
    public final int A;
    public final int B;
    public final boolean C;
    public final v<String> D;
    public final v<String> E;
    public final int F;
    public final int G;
    public final int H;
    public final v<String> I;
    public final v<String> J;
    public final int K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final int a;
    public final int b;
    public final int c;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.n2.l> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.n2.l a(Parcel parcel) {
            l lVar = new l(parcel);
            return lVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.n2.l[] b(int i) {
            return new l[i];
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

    public static class b {

        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private v<String> l;
        private v<String> m;
        private int n;
        private int o;
        private int p;
        private v<String> q;
        private v<String> r;
        private int s;
        private boolean t;
        private boolean u;
        private boolean v;
        @Deprecated
        public b() {
            super();
            int i = Integer.MAX_VALUE;
            this.a = i;
            this.b = i;
            this.c = i;
            this.d = i;
            this.i = i;
            this.j = i;
            this.k = true;
            this.l = v.z();
            this.m = v.z();
            int i3 = 0;
            this.n = i3;
            this.o = i;
            this.p = i;
            this.q = v.z();
            this.r = v.z();
            this.s = i3;
            this.t = i3;
            this.u = i3;
            this.v = i3;
        }

        public b(Context context) {
            super();
            x(context);
            A(context, true);
        }

        static int a(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.a;
        }

        static int b(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.b;
        }

        static boolean c(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.k;
        }

        static v d(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.l;
        }

        static v e(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.m;
        }

        static int f(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.n;
        }

        static int g(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.o;
        }

        static int h(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.p;
        }

        static v i(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.q;
        }

        static v j(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.r;
        }

        static int k(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.s;
        }

        static boolean l(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.t;
        }

        static int m(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.c;
        }

        static boolean n(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.u;
        }

        static boolean o(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.v;
        }

        static int p(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.d;
        }

        static int q(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.e;
        }

        static int r(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.f;
        }

        static int s(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.g;
        }

        static int t(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.h;
        }

        static int u(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.i;
        }

        static int v(com.google.android.exoplayer2.n2.l.b l$b) {
            return b.j;
        }

        private void y(Context context) {
            int myLooper;
            String enabled;
            Object obj3;
            if (p0.a < 23 && Looper.myLooper() == null) {
                if (Looper.myLooper() == null) {
                }
            }
            obj3 = context.getSystemService("captioning");
            if ((CaptioningManager)obj3 != null) {
                if (!(CaptioningManager)obj3.isEnabled()) {
                } else {
                    this.s = 1088;
                    obj3 = obj3.getLocale();
                    if (obj3 != null) {
                        this.r = v.A(p0.O(obj3));
                    }
                }
            }
        }

        public com.google.android.exoplayer2.n2.l.b A(Context context, boolean z2) {
            android.graphics.Point obj2 = p0.H(context);
            return z(obj2.x, obj2.y, z2);
        }

        public com.google.android.exoplayer2.n2.l w() {
            l lVar = new l(this);
            return lVar;
        }

        public com.google.android.exoplayer2.n2.l.b x(Context context) {
            if (p0.a >= 19) {
                y(context);
            }
            return this;
        }

        public com.google.android.exoplayer2.n2.l.b z(int i, int i2, boolean z3) {
            this.i = i;
            this.j = i2;
            this.k = z3;
            return this;
        }
    }
    static {
        l.b bVar = new l.b();
        l.O = bVar.w();
        l.a aVar = new l.a();
        l.CREATOR = aVar;
    }

    l(Parcel parcel) {
        super();
        ArrayList arrayList = new ArrayList();
        final int i = 0;
        parcel.readList(arrayList, i);
        this.E = v.u(arrayList);
        this.F = parcel.readInt();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, i);
        this.J = v.u(arrayList2);
        this.K = parcel.readInt();
        this.L = p0.w0(parcel);
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = p0.w0(parcel);
        ArrayList arrayList3 = new ArrayList();
        parcel.readList(arrayList3, i);
        this.D = v.u(arrayList3);
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        ArrayList arrayList4 = new ArrayList();
        parcel.readList(arrayList4, i);
        this.I = v.u(arrayList4);
        this.M = p0.w0(parcel);
        this.N = p0.w0(parcel);
    }

    protected l(com.google.android.exoplayer2.n2.l.b l$b) {
        super();
        this.a = l.b.a(b);
        this.b = l.b.b(b);
        this.c = l.b.m(b);
        this.v = l.b.p(b);
        this.w = l.b.q(b);
        this.x = l.b.r(b);
        this.y = l.b.s(b);
        this.z = l.b.t(b);
        this.A = l.b.u(b);
        this.B = l.b.v(b);
        this.C = l.b.c(b);
        this.D = l.b.d(b);
        this.E = l.b.e(b);
        this.F = l.b.f(b);
        this.G = l.b.g(b);
        this.H = l.b.h(b);
        this.I = l.b.i(b);
        this.J = l.b.j(b);
        this.K = l.b.k(b);
        this.L = l.b.l(b);
        this.M = l.b.n(b);
        this.N = l.b.o(b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i2;
        int equals;
        Class class2;
        int i;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.a == object.a && this.b == object.b && this.c == object.c && this.v == object.v && this.w == object.w && this.x == object.x && this.y == object.y && this.z == object.z && this.C == object.C && this.A == object.A && this.B == object.B && this.D.equals(object.D) && this.E.equals(object.E) && this.F == object.F && this.G == object.G && this.H == object.H && this.I.equals(object.I) && this.J.equals(object.J) && this.K == object.K && this.L == object.L && this.M == object.M && this.N == object.N) {
                    if (this.b == object.b) {
                        if (this.c == object.c) {
                            if (this.v == object.v) {
                                if (this.w == object.w) {
                                    if (this.x == object.x) {
                                        if (this.y == object.y) {
                                            if (this.z == object.z) {
                                                if (this.C == object.C) {
                                                    if (this.A == object.A) {
                                                        if (this.B == object.B) {
                                                            if (this.D.equals(object.D)) {
                                                                if (this.E.equals(object.E)) {
                                                                    if (this.F == object.F) {
                                                                        if (this.G == object.G) {
                                                                            if (this.H == object.H) {
                                                                                if (this.I.equals(object.I)) {
                                                                                    if (this.J.equals(object.J)) {
                                                                                        if (this.K == object.K) {
                                                                                            if (this.L == object.L) {
                                                                                                if (this.M == object.M) {
                                                                                                    if (this.N == object.N) {
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
            }
            return i2;
        }
        return i3;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i45 = 31;
        return i43 += z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.E);
        parcel.writeInt(this.F);
        parcel.writeList(this.J);
        parcel.writeInt(this.K);
        p0.L0(parcel, this.L);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        p0.L0(parcel, this.C);
        parcel.writeList(this.D);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeList(this.I);
        p0.L0(parcel, this.M);
        p0.L0(parcel, this.N);
    }
}
