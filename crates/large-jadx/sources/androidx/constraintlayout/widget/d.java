package androidx.constraintlayout.widget;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import d.f.a.k.a.b;
import d.f.b.b.a;
import d.f.b.b.j;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class d {

    private static final int[] d;
    private static SparseIntArray e;
    private static SparseIntArray f;
    private HashMap<String, androidx.constraintlayout.widget.a> a;
    private boolean b = true;
    private HashMap<Integer, androidx.constraintlayout.widget.d.a> c;

    public static class a {

        int a;
        String b;
        public final androidx.constraintlayout.widget.d.d c;
        public final androidx.constraintlayout.widget.d.c d;
        public final androidx.constraintlayout.widget.d.b e;
        public final androidx.constraintlayout.widget.d.e f;
        public HashMap<String, androidx.constraintlayout.widget.a> g;
        androidx.constraintlayout.widget.d.a.a h;
        public a() {
            super();
            d.d dVar = new d.d();
            this.c = dVar;
            d.c cVar = new d.c();
            this.d = cVar;
            d.b bVar = new d.b();
            this.e = bVar;
            d.e eVar = new d.e();
            this.f = eVar;
            HashMap hashMap = new HashMap();
            this.g = hashMap;
        }

        static void a(androidx.constraintlayout.widget.d.a d$a, int i2, androidx.constraintlayout.widget.ConstraintLayout.b constraintLayout$b3) {
            a.f(i2, b3);
        }

        static void b(androidx.constraintlayout.widget.d.a d$a, androidx.constraintlayout.widget.b b2, int i3, androidx.constraintlayout.widget.e.a e$a4) {
            a.h(b2, i3, a4);
        }

        static void c(androidx.constraintlayout.widget.d.a d$a, int i2, androidx.constraintlayout.widget.e.a e$a3) {
            a.g(i2, a3);
        }

        private void f(int i, androidx.constraintlayout.widget.ConstraintLayout.b constraintLayout$b2) {
            int marginEnd;
            androidx.constraintlayout.widget.d.b obj3;
            Object obj4;
            this.a = i;
            obj3 = this.e;
            obj3.h = b2.d;
            obj3.i = b2.e;
            obj3.j = b2.f;
            obj3.k = b2.g;
            obj3.l = b2.h;
            obj3.m = b2.i;
            obj3.n = b2.j;
            obj3.o = b2.k;
            obj3.p = b2.l;
            obj3.q = b2.m;
            obj3.r = b2.n;
            obj3.s = b2.r;
            obj3.t = b2.s;
            obj3.u = b2.t;
            obj3.v = b2.u;
            obj3.w = b2.D;
            obj3.x = b2.E;
            obj3.y = b2.F;
            obj3.z = b2.o;
            obj3.A = b2.p;
            obj3.B = b2.q;
            obj3.C = b2.U;
            obj3.D = b2.V;
            obj3.E = b2.W;
            obj3.g = b2.c;
            obj3 = this.e;
            obj3.e = b2.a;
            obj3.f = b2.b;
            obj3.c = b2.width;
            obj3.d = b2.height;
            obj3.F = b2.leftMargin;
            obj3.G = b2.rightMargin;
            obj3.H = b2.topMargin;
            obj3.I = b2.bottomMargin;
            obj3.L = b2.C;
            obj3.T = b2.J;
            obj3.U = b2.I;
            obj3.W = b2.L;
            obj3.V = b2.K;
            obj3.l0 = b2.X;
            obj3.m0 = b2.Y;
            obj3.X = b2.M;
            obj3.Y = b2.N;
            obj3.Z = b2.Q;
            obj3.a0 = b2.R;
            obj3.b0 = b2.O;
            obj3.c0 = b2.P;
            obj3.d0 = b2.S;
            obj3.e0 = b2.T;
            obj3.k0 = b2.Z;
            obj3.N = b2.w;
            obj3 = this.e;
            obj3.P = b2.y;
            obj3.M = b2.v;
            obj3.O = b2.x;
            obj3.R = b2.z;
            obj3.Q = b2.A;
            obj3.S = b2.B;
            obj3.o0 = b2.a0;
            if (Build.VERSION.SDK_INT >= 17) {
                obj3.J = b2.getMarginEnd();
                obj3.K = b2.getMarginStart();
            }
        }

        private void g(int i, androidx.constraintlayout.widget.e.a e$a2) {
            f(i, a2);
            obj2.d = a2.u0;
            androidx.constraintlayout.widget.d.e obj2 = this.f;
            obj2.b = a2.x0;
            obj2.c = a2.y0;
            obj2.d = a2.z0;
            obj2.e = a2.A0;
            obj2.f = a2.B0;
            obj2.g = a2.C0;
            obj2.h = a2.D0;
            obj2.j = a2.E0;
            obj2.k = a2.F0;
            obj2.l = a2.G0;
            obj2.n = a2.w0;
            obj2.m = a2.v0;
        }

        private void h(androidx.constraintlayout.widget.b b, int i2, androidx.constraintlayout.widget.e.a e$a3) {
            Object obj1;
            boolean obj2;
            androidx.constraintlayout.widget.e.a obj3;
            g(i2, a3);
            if (b instanceof Barrier) {
                obj2 = this.e;
                obj2.h0 = 1;
                obj2.f0 = (Barrier)b.getType();
                obj2.i0 = b.getReferencedIds();
                obj2.g0 = b.getMargin();
            }
        }

        public Object clone() {
            return e();
        }

        public void d(androidx.constraintlayout.widget.ConstraintLayout.b constraintLayout$b) {
            androidx.constraintlayout.widget.d.b bVar;
            androidx.constraintlayout.widget.d.b bVar2 = this.e;
            b.d = bVar2.h;
            b.e = bVar2.i;
            b.f = bVar2.j;
            b.g = bVar2.k;
            b.h = bVar2.l;
            b.i = bVar2.m;
            b.j = bVar2.n;
            b.k = bVar2.o;
            b.l = bVar2.p;
            b.m = bVar2.q;
            b.n = bVar2.r;
            b.r = bVar2.s;
            b.s = bVar2.t;
            b.t = bVar2.u;
            b.u = bVar2.v;
            b.leftMargin = bVar2.F;
            b.rightMargin = bVar2.G;
            b.topMargin = bVar2.H;
            b.bottomMargin = bVar2.I;
            b.z = bVar2.R;
            b.A = bVar2.Q;
            b.w = bVar2.N;
            b.y = bVar2.P;
            b.D = bVar2.w;
            b.E = bVar2.x;
            androidx.constraintlayout.widget.d.b bVar3 = this.e;
            b.o = bVar3.z;
            b.p = bVar3.A;
            b.q = bVar3.B;
            b.F = bVar3.y;
            b.U = bVar3.C;
            b.V = bVar3.D;
            b.J = bVar3.T;
            b.I = bVar3.U;
            b.L = bVar3.W;
            b.K = bVar3.V;
            b.X = bVar3.l0;
            b.Y = bVar3.m0;
            b.M = bVar3.X;
            b.N = bVar3.Y;
            b.Q = bVar3.Z;
            b.R = bVar3.a0;
            b.O = bVar3.b0;
            b.P = bVar3.c0;
            b.S = bVar3.d0;
            b.T = bVar3.e0;
            b.W = bVar3.E;
            b.c = bVar3.g;
            b.a = bVar3.e;
            b.b = bVar3.f;
            b.width = bVar3.c;
            bVar = this.e;
            b.height = bVar.d;
            String str2 = bVar.k0;
            if (str2 != null) {
                b.Z = str2;
            }
            b.a0 = bVar.o0;
            if (Build.VERSION.SDK_INT >= 17) {
                b.setMarginStart(bVar.K);
                b.setMarginEnd(bVar4.J);
            }
            b.a();
        }

        public androidx.constraintlayout.widget.d.a e() {
            d.a aVar = new d.a();
            aVar.e.a(this.e);
            aVar.d.a(this.d);
            aVar.c.a(this.c);
            aVar.f.a(this.f);
            aVar.a = this.a;
            aVar.h = this.h;
            return aVar;
        }
    }

    public static class b {

        private static SparseIntArray p0;
        public int A = 0;
        public float B = 0f;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = Integer.MIN_VALUE;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public float T = -1f;
        public float U = -1f;
        public int V = 0;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = -1;
        public boolean a = false;
        public int a0 = -1;
        public boolean b = false;
        public int b0 = -1;
        public int c;
        public int c0 = -1;
        public int d;
        public float d0 = 1f;
        public int e = -1;
        public float e0 = 1f;
        public int f = -1;
        public int f0 = -1;
        public float g = -1f;
        public int g0 = 0;
        public int h = -1;
        public int h0 = -1;
        public int i = -1;
        public int[] i0;
        public int j = -1;
        public String j0;
        public int k = -1;
        public String k0;
        public int l = -1;
        public boolean l0 = false;
        public int m = -1;
        public boolean m0 = false;
        public int n = -1;
        public boolean n0 = true;
        public int o = -1;
        public int o0 = 0;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public float w = 0.5f;
        public float x = 0.5f;
        public String y = null;
        public int z = -1;
        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            d.b.p0 = sparseIntArray;
            sparseIntArray.append(i.Y4, 24);
            d.b.p0.append(i.Z4, 25);
            d.b.p0.append(i.b5, 28);
            d.b.p0.append(i.c5, 29);
            d.b.p0.append(i.h5, 35);
            d.b.p0.append(i.g5, 34);
            d.b.p0.append(i.I4, 4);
            d.b.p0.append(i.H4, 3);
            d.b.p0.append(i.F4, 1);
            d.b.p0.append(i.n5, 6);
            d.b.p0.append(i.o5, 7);
            d.b.p0.append(i.P4, 17);
            d.b.p0.append(i.Q4, 18);
            d.b.p0.append(i.R4, 19);
            d.b.p0.append(i.o4, 26);
            d.b.p0.append(i.d5, 31);
            d.b.p0.append(i.e5, 32);
            d.b.p0.append(i.O4, 10);
            d.b.p0.append(i.N4, 9);
            d.b.p0.append(i.r5, 13);
            d.b.p0.append(i.u5, 16);
            d.b.p0.append(i.s5, 14);
            d.b.p0.append(i.p5, 11);
            d.b.p0.append(i.t5, 15);
            d.b.p0.append(i.q5, 12);
            d.b.p0.append(i.k5, 38);
            d.b.p0.append(i.W4, 37);
            d.b.p0.append(i.V4, 39);
            d.b.p0.append(i.j5, 40);
            d.b.p0.append(i.U4, 20);
            d.b.p0.append(i.i5, 36);
            d.b.p0.append(i.M4, 5);
            int i68 = 76;
            d.b.p0.append(i.X4, i68);
            d.b.p0.append(i.f5, i68);
            d.b.p0.append(i.a5, i68);
            d.b.p0.append(i.G4, i68);
            d.b.p0.append(i.E4, i68);
            d.b.p0.append(i.r4, 23);
            d.b.p0.append(i.t4, 27);
            d.b.p0.append(i.v4, 30);
            d.b.p0.append(i.w4, 8);
            d.b.p0.append(i.s4, 33);
            d.b.p0.append(i.u4, 2);
            d.b.p0.append(i.p4, 22);
            d.b.p0.append(i.q4, 21);
            int i77 = 41;
            d.b.p0.append(i.l5, i77);
            final int i89 = 42;
            d.b.p0.append(i.S4, i89);
            d.b.p0.append(i.D4, i77);
            d.b.p0.append(i.C4, i89);
            d.b.p0.append(i.v5, 97);
            d.b.p0.append(i.J4, 61);
            d.b.p0.append(i.L4, 62);
            d.b.p0.append(i.K4, 63);
            d.b.p0.append(i.m5, 69);
            d.b.p0.append(i.T4, 70);
            d.b.p0.append(i.A4, 71);
            d.b.p0.append(i.y4, 72);
            d.b.p0.append(i.z4, 73);
            d.b.p0.append(i.B4, 74);
            d.b.p0.append(i.x4, 75);
        }

        public b() {
            super();
            final int i = 0;
            int i2 = -1;
            int i4 = -1082130432;
            int i6 = 1056964608;
            int i7 = 0;
            int i8 = 0;
            int i9 = Integer.MIN_VALUE;
            int i5 = 1065353216;
            int i3 = 1;
        }

        public void a(androidx.constraintlayout.widget.d.b d$b) {
            int[] copyOf;
            int length;
            this.a = b.a;
            this.c = b.c;
            this.b = b.b;
            this.d = b.d;
            this.e = b.e;
            this.f = b.f;
            this.g = b.g;
            this.h = b.h;
            this.i = b.i;
            this.j = b.j;
            this.k = b.k;
            this.l = b.l;
            this.m = b.m;
            this.n = b.n;
            this.o = b.o;
            this.p = b.p;
            this.q = b.q;
            this.r = b.r;
            this.s = b.s;
            this.t = b.t;
            this.u = b.u;
            this.v = b.v;
            this.w = b.w;
            this.x = b.x;
            this.y = b.y;
            this.z = b.z;
            this.A = b.A;
            this.B = b.B;
            this.C = b.C;
            this.D = b.D;
            this.E = b.E;
            this.F = b.F;
            this.G = b.G;
            this.H = b.H;
            this.I = b.I;
            this.J = b.J;
            this.K = b.K;
            this.L = b.L;
            this.M = b.M;
            this.N = b.N;
            this.O = b.O;
            this.P = b.P;
            this.Q = b.Q;
            this.R = b.R;
            this.S = b.S;
            this.T = b.T;
            this.U = b.U;
            this.V = b.V;
            this.W = b.W;
            this.X = b.X;
            this.Y = b.Y;
            this.Z = b.Z;
            this.a0 = b.a0;
            this.b0 = b.b0;
            this.c0 = b.c0;
            this.d0 = b.d0;
            this.e0 = b.e0;
            this.f0 = b.f0;
            this.g0 = b.g0;
            this.h0 = b.h0;
            this.k0 = b.k0;
            int[] iArr = b.i0;
            if (iArr != null) {
                this.i0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.i0 = 0;
            }
            this.j0 = b.j0;
            this.l0 = b.l0;
            this.m0 = b.m0;
            this.n0 = b.n0;
            this.o0 = b.o0;
        }

        void b(Context context, AttributeSet attributeSet2) {
            int i2;
            int i3;
            int i4;
            boolean dimensionPixelOffset;
            boolean stringBuilder;
            int i;
            String str;
            String str2;
            final TypedArray obj9 = context.obtainStyledAttributes(attributeSet2, i.n4);
            final int obj10 = 1;
            this.b = obj10;
            final int i6 = 0;
            i4 = i6;
            while (i4 < obj9.getIndexCount()) {
                dimensionPixelOffset = obj9.getIndex(i4);
                stringBuilder = d.b.p0.get(dimensionPixelOffset);
                if (stringBuilder != 80) {
                } else {
                }
                this.l0 = obj9.getBoolean(dimensionPixelOffset, this.l0);
                i4++;
                if (stringBuilder != 81) {
                } else {
                }
                this.m0 = obj9.getBoolean(dimensionPixelOffset, this.m0);
                if (stringBuilder != 97) {
                } else {
                }
                this.o0 = obj9.getInt(dimensionPixelOffset, this.o0);
                i = 17;
                i = 1065353216;
                str = "   ";
                str2 = "ConstraintSet";
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown attribute 0x");
                stringBuilder.append(Integer.toHexString(dimensionPixelOffset));
                stringBuilder.append(str);
                stringBuilder.append(d.b.p0.get(dimensionPixelOffset));
                Log.w(str2, stringBuilder.toString());
                this.S = obj9.getDimensionPixelSize(dimensionPixelOffset, this.S);
                this.L = obj9.getDimensionPixelSize(dimensionPixelOffset, this.L);
                this.r = d.a(obj9, dimensionPixelOffset, this.r);
                this.q = d.a(obj9, dimensionPixelOffset, this.q);
                this.k0 = obj9.getString(dimensionPixelOffset);
                stringBuilder = new StringBuilder();
                stringBuilder.append("unused attribute 0x");
                stringBuilder.append(Integer.toHexString(dimensionPixelOffset));
                stringBuilder.append(str);
                stringBuilder.append(d.b.p0.get(dimensionPixelOffset));
                Log.w(str2, stringBuilder.toString());
                this.n0 = obj9.getBoolean(dimensionPixelOffset, this.n0);
                this.j0 = obj9.getString(dimensionPixelOffset);
                this.g0 = obj9.getDimensionPixelSize(dimensionPixelOffset, this.g0);
                this.f0 = obj9.getInt(dimensionPixelOffset, this.f0);
                Log.e(str2, "CURRENTLY UNSUPPORTED");
                this.e0 = obj9.getFloat(dimensionPixelOffset, i);
                this.d0 = obj9.getFloat(dimensionPixelOffset, i);
                this.B = obj9.getFloat(dimensionPixelOffset, this.B);
                this.A = obj9.getDimensionPixelSize(dimensionPixelOffset, this.A);
                this.z = d.a(obj9, dimensionPixelOffset, this.z);
                this.c0 = obj9.getDimensionPixelSize(dimensionPixelOffset, this.c0);
                this.b0 = obj9.getDimensionPixelSize(dimensionPixelOffset, this.b0);
                this.a0 = obj9.getDimensionPixelSize(dimensionPixelOffset, this.a0);
                this.Z = obj9.getDimensionPixelSize(dimensionPixelOffset, this.Z);
                this.Y = obj9.getInt(dimensionPixelOffset, this.Y);
                this.X = obj9.getInt(dimensionPixelOffset, this.X);
                d.q(this, obj9, dimensionPixelOffset, obj10);
                d.q(this, obj9, dimensionPixelOffset, i6);
                this.W = obj9.getInt(dimensionPixelOffset, this.W);
                this.V = obj9.getInt(dimensionPixelOffset, this.V);
                this.T = obj9.getFloat(dimensionPixelOffset, this.T);
                this.U = obj9.getFloat(dimensionPixelOffset, this.U);
                this.x = obj9.getFloat(dimensionPixelOffset, this.x);
                this.l = d.a(obj9, dimensionPixelOffset, this.l);
                this.m = d.a(obj9, dimensionPixelOffset, this.m);
                this.H = obj9.getDimensionPixelSize(dimensionPixelOffset, this.H);
                this.t = d.a(obj9, dimensionPixelOffset, this.t);
                this.s = d.a(obj9, dimensionPixelOffset, this.s);
                if (Build.VERSION.SDK_INT >= i) {
                }
                this.K = obj9.getDimensionPixelSize(dimensionPixelOffset, this.K);
                this.k = d.a(obj9, dimensionPixelOffset, this.k);
                this.j = d.a(obj9, dimensionPixelOffset, this.j);
                this.G = obj9.getDimensionPixelSize(dimensionPixelOffset, this.G);
                this.E = obj9.getInt(dimensionPixelOffset, this.E);
                this.i = d.a(obj9, dimensionPixelOffset, this.i);
                this.h = d.a(obj9, dimensionPixelOffset, this.h);
                this.F = obj9.getDimensionPixelSize(dimensionPixelOffset, this.F);
                this.c = obj9.getLayoutDimension(dimensionPixelOffset, this.c);
                this.d = obj9.getLayoutDimension(dimensionPixelOffset, this.d);
                this.w = obj9.getFloat(dimensionPixelOffset, this.w);
                this.g = obj9.getFloat(dimensionPixelOffset, this.g);
                this.f = obj9.getDimensionPixelOffset(dimensionPixelOffset, this.f);
                this.e = obj9.getDimensionPixelOffset(dimensionPixelOffset, this.e);
                this.N = obj9.getDimensionPixelSize(dimensionPixelOffset, this.N);
                this.R = obj9.getDimensionPixelSize(dimensionPixelOffset, this.R);
                this.O = obj9.getDimensionPixelSize(dimensionPixelOffset, this.O);
                this.M = obj9.getDimensionPixelSize(dimensionPixelOffset, this.M);
                this.Q = obj9.getDimensionPixelSize(dimensionPixelOffset, this.Q);
                this.P = obj9.getDimensionPixelSize(dimensionPixelOffset, this.P);
                this.u = d.a(obj9, dimensionPixelOffset, this.u);
                this.v = d.a(obj9, dimensionPixelOffset, this.v);
                if (Build.VERSION.SDK_INT >= i) {
                }
                this.J = obj9.getDimensionPixelSize(dimensionPixelOffset, this.J);
                this.D = obj9.getDimensionPixelOffset(dimensionPixelOffset, this.D);
                this.C = obj9.getDimensionPixelOffset(dimensionPixelOffset, this.C);
                this.y = obj9.getString(dimensionPixelOffset);
                this.n = d.a(obj9, dimensionPixelOffset, this.n);
                this.o = d.a(obj9, dimensionPixelOffset, this.o);
                this.I = obj9.getDimensionPixelSize(dimensionPixelOffset, this.I);
                this.p = d.a(obj9, dimensionPixelOffset, this.p);
            }
            obj9.recycle();
        }
    }

    public static class c {

        private static SparseIntArray o;
        public boolean a = false;
        public int b = -1;
        public int c = 0;
        public String d = null;
        public int e = -1;
        public int f = 0;
        public float g = NaNf;
        public int h = -1;
        public float i = NaNf;
        public float j = NaNf;
        public int k = -1;
        public String l = null;
        public int m = -3;
        public int n = -1;
        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            d.c.o = sparseIntArray;
            sparseIntArray.append(i.A5, 1);
            d.c.o.append(i.C5, 2);
            d.c.o.append(i.G5, 3);
            d.c.o.append(i.z5, 4);
            d.c.o.append(i.y5, 5);
            d.c.o.append(i.x5, 6);
            d.c.o.append(i.B5, 7);
            d.c.o.append(i.F5, 8);
            d.c.o.append(i.E5, 9);
            d.c.o.append(i.D5, 10);
        }

        public c() {
            super();
            int i = 0;
            final int i4 = -1;
            final int i5 = 0;
            int i2 = 2143289344;
            int i3 = -3;
        }

        public void a(androidx.constraintlayout.widget.d.c d$c) {
            this.a = c.a;
            this.b = c.b;
            this.d = c.d;
            this.e = c.e;
            this.f = c.f;
            this.i = c.i;
            this.g = c.g;
            this.h = c.h;
        }

        void b(Context context, AttributeSet attributeSet2) {
            int i3;
            int resourceId;
            int indexOf;
            int str;
            int i2;
            int i;
            final TypedArray obj9 = context.obtainStyledAttributes(attributeSet2, i.w5);
            final int obj10 = 1;
            this.a = obj10;
            final int i4 = 0;
            i3 = i4;
            while (i3 < obj9.getIndexCount()) {
                resourceId = obj9.getIndex(i3);
                str = 3;
                i3++;
                indexOf = peekValue.type;
                i2 = -2;
                i = -1;
                if (indexOf == obj10) {
                } else {
                }
                if (indexOf == str) {
                } else {
                }
                this.m = obj9.getInteger(resourceId, this.n);
                String string = obj9.getString(resourceId);
                this.l = string;
                if (string.indexOf("/") > 0) {
                } else {
                }
                this.m = i;
                this.n = obj9.getResourceId(resourceId, i);
                this.m = i2;
                resourceId = obj9.getResourceId(resourceId, i);
                this.n = resourceId;
                if (resourceId != i) {
                }
                this.m = i2;
                this.j = obj9.getFloat(resourceId, this.j);
                this.k = obj9.getInteger(resourceId, this.k);
                this.g = obj9.getFloat(resourceId, this.g);
                this.c = obj9.getInteger(resourceId, this.c);
                this.b = d.a(obj9, resourceId, this.b);
                this.f = obj9.getInt(resourceId, i4);
                if (peekValue2.type == str) {
                } else {
                }
                this.d = b.c[obj9.getInteger(resourceId, i4)];
                this.d = obj9.getString(resourceId);
                this.e = obj9.getInt(resourceId, this.e);
                this.i = obj9.getFloat(resourceId, this.i);
            }
            obj9.recycle();
        }
    }

    public static class d {

        public boolean a = false;
        public int b = 0;
        public int c = 0;
        public float d = 1f;
        public float e = NaNf;
        public d() {
            super();
            int i = 0;
            int i2 = 1065353216;
            int i3 = 2143289344;
        }

        public void a(androidx.constraintlayout.widget.d.d d$d) {
            this.a = d.a;
            this.b = d.b;
            this.d = d.d;
            this.e = d.e;
            this.c = d.c;
        }

        void b(Context context, AttributeSet attributeSet2) {
            int i;
            float index;
            float f;
            final TypedArray obj4 = context.obtainStyledAttributes(attributeSet2, i.K5);
            this.a = true;
            i = 0;
            while (i < obj4.getIndexCount()) {
                index = obj4.getIndex(i);
                if (index == i.M5) {
                } else {
                }
                if (index == i.L5) {
                } else {
                }
                if (index == i.O5) {
                } else {
                }
                if (index == i.N5) {
                }
                i++;
                this.e = obj4.getFloat(index, this.e);
                this.c = obj4.getInt(index, this.c);
                this.b = obj4.getInt(index, this.b);
                this.b = d.b()[this.b];
                this.d = obj4.getFloat(index, this.d);
            }
            obj4.recycle();
        }
    }

    public static class e {

        private static SparseIntArray o;
        public boolean a = false;
        public float b = 0f;
        public float c = 0f;
        public float d = 0f;
        public float e = 1f;
        public float f = 1f;
        public float g = NaNf;
        public float h = NaNf;
        public int i = -1;
        public float j = 0f;
        public float k = 0f;
        public float l = 0f;
        public boolean m = false;
        public float n = 0f;
        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            d.e.o = sparseIntArray;
            sparseIntArray.append(i.Z5, 1);
            d.e.o.append(i.a6, 2);
            d.e.o.append(i.b6, 3);
            d.e.o.append(i.X5, 4);
            d.e.o.append(i.Y5, 5);
            d.e.o.append(i.T5, 6);
            d.e.o.append(i.U5, 7);
            d.e.o.append(i.V5, 8);
            d.e.o.append(i.W5, 9);
            d.e.o.append(i.c6, 10);
            d.e.o.append(i.d6, 11);
            d.e.o.append(i.e6, 12);
        }

        public e() {
            super();
            final int i = 0;
            final int i2 = 0;
            int i3 = 1065353216;
            int i4 = 2143289344;
            int i5 = -1;
        }

        public void a(androidx.constraintlayout.widget.d.e d$e) {
            this.a = e.a;
            this.b = e.b;
            this.c = e.c;
            this.d = e.d;
            this.e = e.e;
            this.f = e.f;
            this.g = e.g;
            this.h = e.h;
            this.i = e.i;
            this.j = e.j;
            this.k = e.k;
            this.l = e.l;
            this.m = e.m;
            this.n = e.n;
        }

        void b(Context context, AttributeSet attributeSet2) {
            int i2;
            float dimension;
            float sDK_INT;
            int i;
            final TypedArray obj6 = context.obtainStyledAttributes(attributeSet2, i.S5);
            final int obj7 = 1;
            this.a = obj7;
            i2 = 0;
            while (i2 < obj6.getIndexCount()) {
                dimension = obj6.getIndex(i2);
                i = 21;
                i2++;
                this.i = d.a(obj6, dimension, this.i);
                if (Build.VERSION.SDK_INT >= i) {
                }
                this.m = obj7;
                this.n = obj6.getDimension(dimension, this.n);
                if (Build.VERSION.SDK_INT >= i) {
                }
                this.l = obj6.getDimension(dimension, this.l);
                this.k = obj6.getDimension(dimension, this.k);
                this.j = obj6.getDimension(dimension, this.j);
                this.h = obj6.getDimension(dimension, this.h);
                this.g = obj6.getDimension(dimension, this.g);
                this.f = obj6.getFloat(dimension, this.f);
                this.e = obj6.getFloat(dimension, this.e);
                this.d = obj6.getFloat(dimension, this.d);
                this.c = obj6.getFloat(dimension, this.c);
                this.b = obj6.getFloat(dimension, this.b);
            }
            obj6.recycle();
        }
    }
    static {
        int i = 3;
        int[] iArr = new int[i];
        iArr = new int[]{0, 4, 8};
        d.d = iArr;
        SparseIntArray sparseIntArray167 = new SparseIntArray();
        d.e = sparseIntArray167;
        SparseIntArray sparseIntArray168 = new SparseIntArray();
        d.f = sparseIntArray168;
        d.e.append(i.g0, 25);
        d.e.append(i.h0, 26);
        d.e.append(i.j0, 29);
        d.e.append(i.k0, 30);
        d.e.append(i.q0, 36);
        d.e.append(i.p0, 35);
        d.e.append(i.N, 4);
        d.e.append(i.M, i);
        d.e.append(i.I, 1);
        d.e.append(i.K, 91);
        d.e.append(i.J, 92);
        int i119 = 6;
        d.e.append(i.z0, i119);
        int i188 = 7;
        d.e.append(i.A0, i188);
        d.e.append(i.U, 17);
        d.e.append(i.V, 18);
        d.e.append(i.W, 19);
        int i192 = 27;
        d.e.append(i.b, i192);
        d.e.append(i.l0, 32);
        d.e.append(i.m0, 33);
        d.e.append(i.T, 10);
        d.e.append(i.S, 9);
        int i197 = 13;
        d.e.append(i.D0, i197);
        final int i198 = 16;
        d.e.append(i.G0, i198);
        final int i199 = 14;
        d.e.append(i.E0, i199);
        final int i200 = 11;
        d.e.append(i.B0, i200);
        final int i201 = 15;
        d.e.append(i.F0, i201);
        final int i202 = 12;
        d.e.append(i.C0, i202);
        final int i203 = 40;
        d.e.append(i.t0, i203);
        final int i204 = 39;
        d.e.append(i.e0, i204);
        final int i205 = 41;
        d.e.append(i.d0, i205);
        final int i206 = 42;
        d.e.append(i.s0, i206);
        d.e.append(i.c0, 20);
        d.e.append(i.r0, 37);
        d.e.append(i.R, 5);
        int i211 = 87;
        d.e.append(i.f0, i211);
        d.e.append(i.o0, i211);
        d.e.append(i.i0, i211);
        d.e.append(i.L, i211);
        d.e.append(i.H, i211);
        d.e.append(i.g, 24);
        d.e.append(i.i, 28);
        d.e.append(i.u, 31);
        d.e.append(i.v, 8);
        d.e.append(i.h, 34);
        d.e.append(i.j, 2);
        d.e.append(i.e, 23);
        d.e.append(i.f, 21);
        d.e.append(i.u0, 95);
        d.e.append(i.X, 96);
        d.e.append(i.d, 22);
        d.e.append(i.k, 43);
        d.e.append(i.x, 44);
        d.e.append(i.s, 45);
        d.e.append(i.t, 46);
        d.e.append(i.r, 60);
        d.e.append(i.p, 47);
        d.e.append(i.q, 48);
        d.e.append(i.l, 49);
        d.e.append(i.m, 50);
        d.e.append(i.n, 51);
        d.e.append(i.o, 52);
        d.e.append(i.w, 53);
        d.e.append(i.v0, 54);
        d.e.append(i.Y, 55);
        d.e.append(i.w0, 56);
        d.e.append(i.Z, 57);
        d.e.append(i.x0, 58);
        d.e.append(i.a0, 59);
        d.e.append(i.O, 61);
        d.e.append(i.Q, 62);
        d.e.append(i.P, 63);
        d.e.append(i.y, 64);
        d.e.append(i.Q0, 65);
        d.e.append(i.E, 66);
        d.e.append(i.R0, 67);
        d.e.append(i.J0, 79);
        d.e.append(i.c, 38);
        d.e.append(i.I0, 68);
        d.e.append(i.y0, 69);
        d.e.append(i.b0, 70);
        d.e.append(i.H0, 97);
        d.e.append(i.C, 71);
        d.e.append(i.A, 72);
        d.e.append(i.B, 73);
        d.e.append(i.D, 74);
        d.e.append(i.z, 75);
        d.e.append(i.K0, 76);
        d.e.append(i.n0, 77);
        d.e.append(i.S0, 78);
        d.e.append(i.G, 80);
        d.e.append(i.F, 81);
        d.e.append(i.L0, 82);
        d.e.append(i.P0, 83);
        d.e.append(i.O0, 84);
        d.e.append(i.N0, 85);
        d.e.append(i.M0, 86);
        int i71 = i.u3;
        d.f.append(i71, i119);
        d.f.append(i71, i188);
        d.f.append(i.p2, i192);
        d.f.append(i.x3, i197);
        d.f.append(i.A3, i198);
        d.f.append(i.y3, i199);
        d.f.append(i.v3, i200);
        d.f.append(i.z3, i201);
        d.f.append(i.w3, i202);
        d.f.append(i.o3, i203);
        d.f.append(i.h3, i204);
        d.f.append(i.g3, i205);
        d.f.append(i.n3, i206);
        d.f.append(i.f3, 20);
        d.f.append(i.m3, 37);
        d.f.append(i.Z2, 5);
        int i123 = 87;
        d.f.append(i.i3, i123);
        d.f.append(i.l3, i123);
        d.f.append(i.j3, i123);
        d.f.append(i.W2, i123);
        d.f.append(i.V2, i123);
        d.f.append(i.u2, 24);
        d.f.append(i.w2, 28);
        d.f.append(i.I2, 31);
        d.f.append(i.J2, 8);
        d.f.append(i.v2, 34);
        d.f.append(i.x2, 2);
        d.f.append(i.s2, 23);
        d.f.append(i.t2, 21);
        d.f.append(i.p3, 95);
        d.f.append(i.a3, 96);
        d.f.append(i.r2, 22);
        d.f.append(i.y2, 43);
        d.f.append(i.L2, 44);
        d.f.append(i.G2, 45);
        d.f.append(i.H2, 46);
        d.f.append(i.F2, 60);
        d.f.append(i.D2, 47);
        d.f.append(i.E2, 48);
        d.f.append(i.z2, 49);
        d.f.append(i.A2, 50);
        d.f.append(i.B2, 51);
        d.f.append(i.C2, 52);
        d.f.append(i.K2, 53);
        d.f.append(i.q3, 54);
        d.f.append(i.b3, 55);
        d.f.append(i.r3, 56);
        d.f.append(i.c3, 57);
        d.f.append(i.s3, 58);
        d.f.append(i.d3, 59);
        d.f.append(i.Y2, 62);
        d.f.append(i.X2, 63);
        d.f.append(i.M2, 64);
        d.f.append(i.L3, 65);
        d.f.append(i.S2, 66);
        d.f.append(i.M3, 67);
        d.f.append(i.D3, 79);
        d.f.append(i.q2, 38);
        d.f.append(i.E3, 98);
        d.f.append(i.C3, 68);
        d.f.append(i.t3, 69);
        d.f.append(i.e3, 70);
        d.f.append(i.Q2, 71);
        d.f.append(i.O2, 72);
        d.f.append(i.P2, 73);
        d.f.append(i.R2, 74);
        d.f.append(i.N2, 75);
        d.f.append(i.F3, 76);
        d.f.append(i.k3, 77);
        d.f.append(i.N3, 78);
        d.f.append(i.U2, 80);
        d.f.append(i.T2, 81);
        d.f.append(i.G3, 82);
        d.f.append(i.K3, 83);
        d.f.append(i.J3, 84);
        d.f.append(i.I3, 85);
        d.f.append(i.H3, 86);
        d.f.append(i.B3, 97);
    }

    public d() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        int i = 1;
        HashMap hashMap2 = new HashMap();
        this.c = hashMap2;
    }

    static int a(TypedArray typedArray, int i2, int i3) {
        return d.p(typedArray, i2, i3);
    }

    static int[] b() {
        return d.d;
    }

    private int[] k(View view, String string2) {
        int[] copyOf;
        int i;
        int i3;
        int i2;
        Object trim;
        int intValue;
        int packageName;
        String str;
        final String[] obj11 = string2.split(",");
        Context context = view.getContext();
        copyOf = new int[obj11.length];
        final int i4 = 0;
        i3 = i;
        for (Object str3 : string2) {
            trim = str3.trim();
            intValue = h.class.getField(trim).getInt(0);
            if (intValue == 0) {
            }
            trim = (ConstraintLayout)view.getParent().g(i4, trim);
            if (intValue == 0 && view.isInEditMode() && parent instanceof ConstraintLayout && trim != null && trim instanceof Integer) {
            }
            copyOf[i3] = intValue;
            i3 = i2;
            if (view.isInEditMode()) {
            }
            if (parent instanceof ConstraintLayout) {
            }
            trim = (ConstraintLayout)view.getParent().g(i4, trim);
            if (trim != null) {
            }
            if (trim instanceof Integer) {
            }
            intValue = (Integer)trim.intValue();
            intValue = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            intValue = obj2;
        }
        if (i3 != obj11.length) {
            copyOf = Arrays.copyOf(copyOf, i3);
        }
        return copyOf;
    }

    private androidx.constraintlayout.widget.d.a l(Context context, AttributeSet attributeSet2, boolean z3) {
        int[] iArr;
        d.a aVar = new d.a();
        iArr = z3 ? i.o2 : i.a;
        final TypedArray obj4 = context.obtainStyledAttributes(attributeSet2, iArr);
        t(context, aVar, obj4, z3);
        obj4.recycle();
        return aVar;
    }

    private androidx.constraintlayout.widget.d.a m(int i) {
        boolean key;
        Integer valueOf;
        androidx.constraintlayout.widget.d.a aVar;
        if (!this.c.containsKey(Integer.valueOf(i))) {
            aVar = new d.a();
            this.c.put(Integer.valueOf(i), aVar);
        }
        return (d.a)this.c.get(Integer.valueOf(i));
    }

    private static int p(TypedArray typedArray, int i2, int i3) {
        int obj3;
        final int i = -1;
        if (typedArray.getResourceId(i2, i3) == i) {
            obj3 = typedArray.getInt(i2, i);
        }
        return obj3;
    }

    static void q(Object object, TypedArray typedArray2, int i3, int i4) {
        int dimensionPixelSize;
        int i;
        int obj5;
        int obj6;
        if (object == null) {
        }
        int type = peekValue.type;
        if (type != 3) {
            i = 0;
            if (type != 5) {
                obj5 = typedArray2.getInt(i3, i);
                if (obj5 != -4) {
                    if (obj5 != -3) {
                        if (obj5 != -2 && obj5 != -1) {
                            dimensionPixelSize = obj5 != -1 ? i : obj5;
                        } else {
                        }
                    } else {
                    }
                } else {
                    i = 1;
                }
            } else {
                dimensionPixelSize = typedArray2.getDimensionPixelSize(i3, i);
            }
            if (object instanceof ConstraintLayout.b) {
                if (i4 == 0) {
                    object.width = dimensionPixelSize;
                    object.X = i;
                } else {
                    object.height = dimensionPixelSize;
                    object.Y = i;
                }
            } else {
                if (object instanceof d.b) {
                    if (i4 == 0) {
                        object.c = dimensionPixelSize;
                        object.l0 = i;
                    } else {
                        object.d = dimensionPixelSize;
                        object.m0 = i;
                    }
                } else {
                    if (object instanceof d.a.a) {
                        if (i4 == 0) {
                            (d.a.a)(d.b)(ConstraintLayout.b)object.b(23, dimensionPixelSize);
                            object.d(80, i);
                        } else {
                            object.b(21, dimensionPixelSize);
                            object.d(81, i);
                        }
                    }
                }
            }
        }
        d.r(object, typedArray2.getString(i3), i4);
    }

    static void r(Object object, String string2, int i3) {
        int equalsIgnoreCase;
        int length;
        String equalsIgnoreCase2;
        int i2;
        int i;
        String obj6;
        boolean obj7;
        if (string2 == null) {
        }
        equalsIgnoreCase = string2.indexOf(61);
        length = 0;
        obj6 = string2.substring(equalsIgnoreCase++);
        if (equalsIgnoreCase > 0 && equalsIgnoreCase < length-- && obj6.length() > 0) {
            if (equalsIgnoreCase < length--) {
                length = 0;
                obj6 = string2.substring(equalsIgnoreCase++);
                if (obj6.length() > 0) {
                    String trim = string2.substring(length, equalsIgnoreCase).trim();
                    obj6 = obj6.trim();
                    if ("ratio".equalsIgnoreCase(trim)) {
                        if (object instanceof ConstraintLayout.b) {
                            if (!i3) {
                                object.width = length;
                            } else {
                                object.height = length;
                            }
                            d.s((ConstraintLayout.b)object, obj6);
                        } else {
                            if (object instanceof d.b) {
                                object.y = obj6;
                            } else {
                                if (object instanceof d.a.a) {
                                    (d.a.a)(d.b)object.c(5, obj6);
                                }
                            }
                        }
                    } else {
                        i2 = 23;
                        i = 21;
                        if ("weight".equalsIgnoreCase(trim)) {
                            obj6 = Float.parseFloat(obj6);
                            if (object instanceof ConstraintLayout.b) {
                                if (!i3) {
                                    object.width = length;
                                    object.I = obj6;
                                } else {
                                    object.height = length;
                                    object.J = obj6;
                                }
                            } else {
                                if (object instanceof d.b) {
                                    if (!i3) {
                                        object.c = length;
                                        object.U = obj6;
                                    } else {
                                        object.d = length;
                                        object.T = obj6;
                                    }
                                } else {
                                    if (object instanceof d.a.a) {
                                        if (!i3) {
                                            (d.a.a)(d.b)(ConstraintLayout.b)object.b(i2, length);
                                            object.a(39, obj6);
                                        } else {
                                            object.b(i, length);
                                            object.a(40, obj6);
                                        }
                                    }
                                }
                            }
                        } else {
                            if ("parent".equalsIgnoreCase(trim)) {
                                obj6 = Math.max(0, Math.min(1065353216, Float.parseFloat(obj6)));
                                equalsIgnoreCase2 = 2;
                                if (object instanceof ConstraintLayout.b) {
                                    if (!i3) {
                                        object.width = length;
                                        object.S = obj6;
                                        object.M = equalsIgnoreCase2;
                                    } else {
                                        object.height = length;
                                        object.T = obj6;
                                        object.N = equalsIgnoreCase2;
                                    }
                                } else {
                                    if (object instanceof d.b) {
                                        if (!i3) {
                                            object.c = length;
                                            object.d0 = obj6;
                                            object.X = equalsIgnoreCase2;
                                        } else {
                                            object.d = length;
                                            object.e0 = obj6;
                                            object.Y = equalsIgnoreCase2;
                                        }
                                    } else {
                                        if (object instanceof d.a.a) {
                                            if (!i3) {
                                                (d.a.a)(d.b)(ConstraintLayout.b)object.b(i2, length);
                                                object.b(54, equalsIgnoreCase2);
                                            } else {
                                                object.b(i, length);
                                                object.b(55, equalsIgnoreCase2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void s(androidx.constraintlayout.widget.ConstraintLayout.b constraintLayout$b, String string2) {
        int float;
        int i2;
        int length;
        String substring;
        int substring2;
        int equalsIgnoreCase2;
        int i;
        int substring3;
        boolean equalsIgnoreCase;
        float = 2143289344;
        i2 = -1;
        length = string2.length();
        int indexOf = string2.indexOf(44);
        equalsIgnoreCase2 = 0;
        i = 1;
        if (string2 != null && indexOf > 0 && indexOf < length + -1) {
            length = string2.length();
            indexOf = string2.indexOf(44);
            equalsIgnoreCase2 = 0;
            i = 1;
            if (indexOf > 0) {
                if (indexOf < length + -1) {
                    substring3 = string2.substring(equalsIgnoreCase2, indexOf);
                    if (substring3.equalsIgnoreCase("W")) {
                        i2 = equalsIgnoreCase2;
                    } else {
                        if (substring3.equalsIgnoreCase("H")) {
                            i2 = i;
                        }
                    }
                    equalsIgnoreCase2 = indexOf + 1;
                }
            }
            int indexOf2 = string2.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length -= i) {
                if (indexOf2 < length -= i) {
                    substring = string2.substring(equalsIgnoreCase2, indexOf2);
                    substring2 = string2.substring(indexOf2 += i);
                    substring = Float.parseFloat(substring);
                    substring2 = Float.parseFloat(substring2);
                    equalsIgnoreCase2 = 0;
                    if (substring.length() > 0 && substring2.length() > 0 && Float.compare(substring, equalsIgnoreCase2) > 0 && Float.compare(substring2, equalsIgnoreCase2) > 0) {
                        if (substring2.length() > 0) {
                            substring = Float.parseFloat(substring);
                            substring2 = Float.parseFloat(substring2);
                            equalsIgnoreCase2 = 0;
                            if (Float.compare(substring, equalsIgnoreCase2) > 0) {
                                if (Float.compare(substring2, equalsIgnoreCase2) > 0) {
                                    if (i2 == i) {
                                        float = Math.abs(substring2 /= substring);
                                    } else {
                                        float = Math.abs(substring /= substring2);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    substring = string2.substring(equalsIgnoreCase2);
                    if (substring.length() > 0) {
                        float = Float.parseFloat(substring);
                    }
                }
            } else {
            }
        }
        b.F = string2;
        b.G = float;
        b.H = i2;
    }

    private void t(Context context, androidx.constraintlayout.widget.d.a d$a2, TypedArray typedArray3, boolean z4) {
        int i6;
        int dimensionPixelOffset;
        int stringBuilder;
        int i;
        int str2;
        int str3;
        int i2;
        int i5;
        int i3;
        int i4;
        String str4;
        if (z4) {
            d.u(context, a2, typedArray3);
        }
        final int obj14 = 0;
        i6 = obj14;
        while (i6 < typedArray3.getIndexCount()) {
            dimensionPixelOffset = typedArray3.getIndex(i6);
            str2 = 1;
            if (dimensionPixelOffset != i.c && i.u != dimensionPixelOffset && i.v != dimensionPixelOffset) {
            }
            str3 = "   ";
            i2 = 1065353216;
            i5 = 3;
            i3 = 21;
            i4 = 17;
            str4 = "ConstraintSet";
            stringBuilder = a2.e;
            stringBuilder.o0 = typedArray3.getInt(dimensionPixelOffset, stringBuilder.o0);
            i6++;
            d.q(a2.e, typedArray3, dimensionPixelOffset, str2);
            d.q(a2.e, typedArray3, dimensionPixelOffset, obj14);
            stringBuilder = a2.e;
            stringBuilder.S = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.S);
            stringBuilder = a2.e;
            stringBuilder.L = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.L);
            stringBuilder = a2.e;
            stringBuilder.r = d.p(typedArray3, dimensionPixelOffset, stringBuilder.r);
            stringBuilder = a2.e;
            stringBuilder.q = d.p(typedArray3, dimensionPixelOffset, stringBuilder.q);
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown attribute 0x");
            stringBuilder.append(Integer.toHexString(dimensionPixelOffset));
            stringBuilder.append(str3);
            stringBuilder.append(d.e.get(dimensionPixelOffset));
            Log.w(str4, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("unused attribute 0x");
            stringBuilder.append(Integer.toHexString(dimensionPixelOffset));
            stringBuilder.append(str3);
            stringBuilder.append(d.e.get(dimensionPixelOffset));
            Log.w(str4, stringBuilder.toString());
            int type2 = peekValue2.type;
            str3 = -2;
            i2 = -1;
            if (type2 == str2) {
            } else {
            }
            if (type2 == i5) {
            } else {
            }
            stringBuilder = a2.d;
            stringBuilder.m = typedArray3.getInteger(dimensionPixelOffset, stringBuilder.n);
            cVar.l = typedArray3.getString(dimensionPixelOffset);
            if (cVar2.l.indexOf("/") > 0) {
            } else {
            }
            dimensionPixelOffset.m = i2;
            stringBuilder.n = typedArray3.getResourceId(dimensionPixelOffset, i2);
            dimensionPixelOffset.m = str3;
            cVar3.n = typedArray3.getResourceId(dimensionPixelOffset, i2);
            dimensionPixelOffset = a2.d;
            if (dimensionPixelOffset.n != i2) {
            }
            dimensionPixelOffset.m = str3;
            stringBuilder = a2.d;
            stringBuilder.j = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.j);
            stringBuilder = a2.d;
            stringBuilder.k = typedArray3.getInteger(dimensionPixelOffset, stringBuilder.k);
            stringBuilder = a2.f;
            stringBuilder.i = d.p(typedArray3, dimensionPixelOffset, stringBuilder.i);
            stringBuilder = a2.d;
            stringBuilder.c = typedArray3.getInteger(dimensionPixelOffset, stringBuilder.c);
            stringBuilder = a2.e;
            stringBuilder.m0 = typedArray3.getBoolean(dimensionPixelOffset, stringBuilder.m0);
            stringBuilder = a2.e;
            stringBuilder.l0 = typedArray3.getBoolean(dimensionPixelOffset, stringBuilder.l0);
            stringBuilder = a2.d;
            stringBuilder.g = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.g);
            stringBuilder = a2.c;
            stringBuilder.c = typedArray3.getInt(dimensionPixelOffset, stringBuilder.c);
            stringBuilder.k0 = typedArray3.getString(dimensionPixelOffset);
            stringBuilder = a2.d;
            stringBuilder.e = typedArray3.getInt(dimensionPixelOffset, stringBuilder.e);
            stringBuilder = a2.e;
            stringBuilder.n0 = typedArray3.getBoolean(dimensionPixelOffset, stringBuilder.n0);
            stringBuilder.j0 = typedArray3.getString(dimensionPixelOffset);
            stringBuilder = a2.e;
            stringBuilder.g0 = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.g0);
            stringBuilder = a2.e;
            stringBuilder.f0 = typedArray3.getInt(dimensionPixelOffset, stringBuilder.f0);
            Log.e(str4, "CURRENTLY UNSUPPORTED");
            stringBuilder.e0 = typedArray3.getFloat(dimensionPixelOffset, i2);
            stringBuilder.d0 = typedArray3.getFloat(dimensionPixelOffset, i2);
            stringBuilder = a2.c;
            stringBuilder.e = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.e);
            stringBuilder = a2.d;
            stringBuilder.i = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.i);
            stringBuilder.f = typedArray3.getInt(dimensionPixelOffset, obj14);
            if (peekValue.type == i5) {
            } else {
            }
            stringBuilder.d = b.c[typedArray3.getInteger(dimensionPixelOffset, obj14)];
            stringBuilder.d = typedArray3.getString(dimensionPixelOffset);
            stringBuilder = a2.d;
            stringBuilder.b = d.p(typedArray3, dimensionPixelOffset, stringBuilder.b);
            stringBuilder = a2.e;
            stringBuilder.B = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.B);
            stringBuilder = a2.e;
            stringBuilder.A = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.A);
            stringBuilder = a2.e;
            stringBuilder.z = d.p(typedArray3, dimensionPixelOffset, stringBuilder.z);
            stringBuilder = a2.f;
            stringBuilder.b = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.b);
            stringBuilder = a2.e;
            stringBuilder.c0 = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.c0);
            stringBuilder = a2.e;
            stringBuilder.b0 = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.b0);
            stringBuilder = a2.e;
            stringBuilder.a0 = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.a0);
            stringBuilder = a2.e;
            stringBuilder.Z = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.Z);
            stringBuilder = a2.e;
            stringBuilder.Y = typedArray3.getInt(dimensionPixelOffset, stringBuilder.Y);
            stringBuilder = a2.e;
            stringBuilder.X = typedArray3.getInt(dimensionPixelOffset, stringBuilder.X);
            if (Build.VERSION.SDK_INT >= i3) {
            }
            stringBuilder = a2.f;
            stringBuilder.l = typedArray3.getDimension(dimensionPixelOffset, stringBuilder.l);
            stringBuilder = a2.f;
            stringBuilder.k = typedArray3.getDimension(dimensionPixelOffset, stringBuilder.k);
            stringBuilder = a2.f;
            stringBuilder.j = typedArray3.getDimension(dimensionPixelOffset, stringBuilder.j);
            stringBuilder = a2.f;
            stringBuilder.h = typedArray3.getDimension(dimensionPixelOffset, stringBuilder.h);
            stringBuilder = a2.f;
            stringBuilder.g = typedArray3.getDimension(dimensionPixelOffset, stringBuilder.g);
            stringBuilder = a2.f;
            stringBuilder.f = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.f);
            stringBuilder = a2.f;
            stringBuilder.e = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.e);
            stringBuilder = a2.f;
            stringBuilder.d = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.d);
            stringBuilder = a2.f;
            stringBuilder.c = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.c);
            if (Build.VERSION.SDK_INT >= i3) {
            }
            stringBuilder = a2.f;
            stringBuilder.m = str2;
            stringBuilder.n = typedArray3.getDimension(dimensionPixelOffset, stringBuilder.n);
            stringBuilder = a2.c;
            stringBuilder.d = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.d);
            stringBuilder = a2.e;
            stringBuilder.W = typedArray3.getInt(dimensionPixelOffset, stringBuilder.W);
            stringBuilder = a2.e;
            stringBuilder.V = typedArray3.getInt(dimensionPixelOffset, stringBuilder.V);
            stringBuilder = a2.e;
            stringBuilder.T = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.T);
            stringBuilder = a2.e;
            stringBuilder.U = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.U);
            a2.a = typedArray3.getResourceId(dimensionPixelOffset, a2.a);
            stringBuilder = a2.e;
            stringBuilder.x = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.x);
            stringBuilder = a2.e;
            stringBuilder.l = d.p(typedArray3, dimensionPixelOffset, stringBuilder.l);
            stringBuilder = a2.e;
            stringBuilder.m = d.p(typedArray3, dimensionPixelOffset, stringBuilder.m);
            stringBuilder = a2.e;
            stringBuilder.H = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.H);
            stringBuilder = a2.e;
            stringBuilder.t = d.p(typedArray3, dimensionPixelOffset, stringBuilder.t);
            stringBuilder = a2.e;
            stringBuilder.s = d.p(typedArray3, dimensionPixelOffset, stringBuilder.s);
            if (Build.VERSION.SDK_INT >= i4) {
            }
            stringBuilder = a2.e;
            stringBuilder.K = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.K);
            stringBuilder = a2.e;
            stringBuilder.k = d.p(typedArray3, dimensionPixelOffset, stringBuilder.k);
            stringBuilder = a2.e;
            stringBuilder.j = d.p(typedArray3, dimensionPixelOffset, stringBuilder.j);
            stringBuilder = a2.e;
            stringBuilder.G = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.G);
            stringBuilder = a2.e;
            stringBuilder.E = typedArray3.getInt(dimensionPixelOffset, stringBuilder.E);
            stringBuilder = a2.e;
            stringBuilder.i = d.p(typedArray3, dimensionPixelOffset, stringBuilder.i);
            stringBuilder = a2.e;
            stringBuilder.h = d.p(typedArray3, dimensionPixelOffset, stringBuilder.h);
            stringBuilder = a2.e;
            stringBuilder.F = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.F);
            stringBuilder = a2.e;
            stringBuilder.c = typedArray3.getLayoutDimension(dimensionPixelOffset, stringBuilder.c);
            androidx.constraintlayout.widget.d.d dVar = a2.c;
            dVar.b = typedArray3.getInt(dimensionPixelOffset, dVar.b);
            dimensionPixelOffset = a2.c;
            dimensionPixelOffset.b = d.d[dimensionPixelOffset.b];
            stringBuilder = a2.e;
            stringBuilder.d = typedArray3.getLayoutDimension(dimensionPixelOffset, stringBuilder.d);
            stringBuilder = a2.e;
            stringBuilder.w = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.w);
            stringBuilder = a2.e;
            stringBuilder.g = typedArray3.getFloat(dimensionPixelOffset, stringBuilder.g);
            stringBuilder = a2.e;
            stringBuilder.f = typedArray3.getDimensionPixelOffset(dimensionPixelOffset, stringBuilder.f);
            stringBuilder = a2.e;
            stringBuilder.e = typedArray3.getDimensionPixelOffset(dimensionPixelOffset, stringBuilder.e);
            stringBuilder = a2.e;
            stringBuilder.N = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.N);
            stringBuilder = a2.e;
            stringBuilder.R = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.R);
            stringBuilder = a2.e;
            stringBuilder.O = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.O);
            stringBuilder = a2.e;
            stringBuilder.M = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.M);
            stringBuilder = a2.e;
            stringBuilder.Q = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.Q);
            stringBuilder = a2.e;
            stringBuilder.P = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.P);
            stringBuilder = a2.e;
            stringBuilder.u = d.p(typedArray3, dimensionPixelOffset, stringBuilder.u);
            stringBuilder = a2.e;
            stringBuilder.v = d.p(typedArray3, dimensionPixelOffset, stringBuilder.v);
            if (Build.VERSION.SDK_INT >= i4) {
            }
            stringBuilder = a2.e;
            stringBuilder.J = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.J);
            stringBuilder = a2.e;
            stringBuilder.D = typedArray3.getDimensionPixelOffset(dimensionPixelOffset, stringBuilder.D);
            stringBuilder = a2.e;
            stringBuilder.C = typedArray3.getDimensionPixelOffset(dimensionPixelOffset, stringBuilder.C);
            stringBuilder.y = typedArray3.getString(dimensionPixelOffset);
            stringBuilder = a2.e;
            stringBuilder.n = d.p(typedArray3, dimensionPixelOffset, stringBuilder.n);
            stringBuilder = a2.e;
            stringBuilder.o = d.p(typedArray3, dimensionPixelOffset, stringBuilder.o);
            stringBuilder = a2.e;
            stringBuilder.I = typedArray3.getDimensionPixelSize(dimensionPixelOffset, stringBuilder.I);
            stringBuilder = a2.e;
            stringBuilder.p = d.p(typedArray3, dimensionPixelOffset, stringBuilder.p);
            if (i.u != dimensionPixelOffset) {
            }
            if (i.v != dimensionPixelOffset) {
            }
            cVar4.a = str2;
            bVar.b = str2;
            dVar2.a = str2;
            i.a = str2;
        }
    }

    private static void u(Context context, androidx.constraintlayout.widget.d.a d$a2, TypedArray typedArray3) {
        int i7;
        int i4;
        int i6;
        int dimensionPixelOffset;
        int stringBuilder;
        long l;
        String str3;
        int str2;
        int i5;
        int i;
        String str;
        int i2;
        int i3;
        d.a.a aVar = new d.a.a();
        a2.h = aVar;
        final int i9 = 0;
        cVar.a = i9;
        bVar.b = i9;
        dVar.a = i9;
        eVar.a = i9;
        i4 = i9;
        while (i4 < typedArray3.getIndexCount()) {
            dimensionPixelOffset = typedArray3.getIndex(i4);
            l = 1065353216;
            str3 = "   ";
            str2 = 3;
            i5 = 21;
            i = 17;
            str = "ConstraintSet";
            i2 = 1;
            i3 = -1;
            if (j.S0) {
            } else {
            }
            if (peekValue2.type == str2) {
            } else {
            }
            a2.a = typedArray3.getResourceId(dimensionPixelOffset, a2.a);
            i4++;
            a2.b = typedArray3.getString(dimensionPixelOffset);
            stringBuilder = typedArray3.getResourceId(dimensionPixelOffset, a2.a);
            a2.a = stringBuilder;
            if (stringBuilder == i3) {
            }
            a2.b = typedArray3.getString(dimensionPixelOffset);
            aVar.b(97, typedArray3.getInt(dimensionPixelOffset, bVar21.o0));
            d.q(aVar, typedArray3, dimensionPixelOffset, i2);
            d.q(aVar, typedArray3, dimensionPixelOffset, i9);
            aVar.b(94, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar42.S));
            aVar.b(93, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar36.L));
            stringBuilder = new StringBuilder();
            stringBuilder.append("unused attribute 0x");
            stringBuilder.append(Integer.toHexString(dimensionPixelOffset));
            stringBuilder.append(str3);
            stringBuilder.append(d.e.get(dimensionPixelOffset));
            Log.w(str, stringBuilder.toString());
            int type = peekValue3.type;
            l = -2;
            str3 = 89;
            i5 = 88;
            if (type == i2) {
            } else {
            }
            if (type == str2) {
            } else {
            }
            stringBuilder = a2.d;
            stringBuilder.m = typedArray3.getInteger(dimensionPixelOffset, stringBuilder.n);
            aVar.b(i5, cVar3.m);
            cVar6.l = typedArray3.getString(dimensionPixelOffset);
            aVar.c(90, cVar15.l);
            if (cVar7.l.indexOf("/") > 0) {
            } else {
            }
            dimensionPixelOffset.m = i3;
            aVar.b(i5, i3);
            stringBuilder.n = typedArray3.getResourceId(dimensionPixelOffset, i3);
            aVar.b(str3, cVar4.n);
            dimensionPixelOffset.m = l;
            aVar.b(i5, l);
            cVar5.n = typedArray3.getResourceId(dimensionPixelOffset, i3);
            aVar.b(str3, cVar2.n);
            dimensionPixelOffset = a2.d;
            if (dimensionPixelOffset.n != i3) {
            }
            dimensionPixelOffset.m = l;
            aVar.b(i5, l);
            aVar.a(85, typedArray3.getFloat(dimensionPixelOffset, cVar9.j));
            aVar.b(84, typedArray3.getInteger(dimensionPixelOffset, cVar8.k));
            aVar.b(83, d.p(typedArray3, dimensionPixelOffset, eVar11.i));
            aVar.b(82, typedArray3.getInteger(dimensionPixelOffset, cVar13.c));
            aVar.d(81, typedArray3.getBoolean(dimensionPixelOffset, bVar27.m0));
            aVar.d(80, typedArray3.getBoolean(dimensionPixelOffset, bVar19.l0));
            aVar.a(79, typedArray3.getFloat(dimensionPixelOffset, cVar10.g));
            aVar.b(78, typedArray3.getInt(dimensionPixelOffset, dVar3.c));
            aVar.c(77, typedArray3.getString(dimensionPixelOffset));
            aVar.b(76, typedArray3.getInt(dimensionPixelOffset, cVar14.e));
            aVar.d(75, typedArray3.getBoolean(dimensionPixelOffset, bVar31.n0));
            aVar.c(74, typedArray3.getString(dimensionPixelOffset));
            aVar.b(73, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar14.g0));
            aVar.b(72, typedArray3.getInt(dimensionPixelOffset, bVar8.f0));
            Log.e(str, "CURRENTLY UNSUPPORTED");
            aVar.a(70, typedArray3.getFloat(dimensionPixelOffset, l));
            aVar.a(69, typedArray3.getFloat(dimensionPixelOffset, l));
            aVar.a(68, typedArray3.getFloat(dimensionPixelOffset, dVar4.e));
            aVar.a(67, typedArray3.getFloat(dimensionPixelOffset, cVar11.i));
            aVar.b(66, typedArray3.getInt(dimensionPixelOffset, i9));
            l = 65;
            if (peekValue.type == str2) {
            } else {
            }
            aVar.c(l, b.c[typedArray3.getInteger(dimensionPixelOffset, i9)]);
            aVar.c(l, typedArray3.getString(dimensionPixelOffset));
            aVar.b(64, d.p(typedArray3, dimensionPixelOffset, cVar12.b));
            aVar.a(63, typedArray3.getFloat(dimensionPixelOffset, bVar17.B));
            aVar.b(62, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar11.A));
            aVar.a(60, typedArray3.getFloat(dimensionPixelOffset, eVar2.b));
            aVar.b(59, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar39.c0));
            aVar.b(58, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar34.b0));
            aVar.b(57, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar29.a0));
            aVar.b(56, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar22.Z));
            aVar.b(55, typedArray3.getInt(dimensionPixelOffset, bVar13.Y));
            aVar.b(54, typedArray3.getInt(dimensionPixelOffset, bVar6.X));
            if (Build.VERSION.SDK_INT >= i5) {
            }
            aVar.a(53, typedArray3.getDimension(dimensionPixelOffset, eVar12.l));
            aVar.a(52, typedArray3.getDimension(dimensionPixelOffset, eVar8.k));
            aVar.a(51, typedArray3.getDimension(dimensionPixelOffset, eVar6.j));
            aVar.a(50, typedArray3.getDimension(dimensionPixelOffset, eVar4.h));
            aVar.a(49, typedArray3.getDimension(dimensionPixelOffset, eVar3.g));
            aVar.a(48, typedArray3.getFloat(dimensionPixelOffset, eVar13.f));
            aVar.a(47, typedArray3.getFloat(dimensionPixelOffset, eVar10.e));
            aVar.a(46, typedArray3.getFloat(dimensionPixelOffset, eVar9.d));
            aVar.a(45, typedArray3.getFloat(dimensionPixelOffset, eVar7.c));
            if (Build.VERSION.SDK_INT >= i5) {
            }
            stringBuilder = 44;
            aVar.d(stringBuilder, i2);
            aVar.a(stringBuilder, typedArray3.getDimension(dimensionPixelOffset, eVar5.n));
            aVar.a(43, typedArray3.getFloat(dimensionPixelOffset, dVar2.d));
            aVar.b(42, typedArray3.getInt(dimensionPixelOffset, bVar38.W));
            aVar.b(41, typedArray3.getInt(dimensionPixelOffset, bVar33.V));
            aVar.a(40, typedArray3.getFloat(dimensionPixelOffset, bVar28.T));
            aVar.a(39, typedArray3.getFloat(dimensionPixelOffset, bVar20.U));
            dimensionPixelOffset = typedArray3.getResourceId(dimensionPixelOffset, a2.a);
            a2.a = dimensionPixelOffset;
            aVar.b(38, dimensionPixelOffset);
            aVar.a(37, typedArray3.getFloat(dimensionPixelOffset, bVar5.x));
            aVar.b(34, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar41.H));
            if (Build.VERSION.SDK_INT >= i) {
            }
            aVar.b(31, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar35.K));
            aVar.b(28, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar24.G));
            aVar.b(27, typedArray3.getInt(dimensionPixelOffset, bVar15.E));
            aVar.b(24, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar9.F));
            aVar.b(23, typedArray3.getLayoutDimension(dimensionPixelOffset, bVar43.c));
            aVar.b(22, d.d[typedArray3.getInt(dimensionPixelOffset, dVar5.b)]);
            aVar.b(i5, typedArray3.getLayoutDimension(dimensionPixelOffset, bVar3.d));
            aVar.a(20, typedArray3.getFloat(dimensionPixelOffset, bVar25.w));
            aVar.a(19, typedArray3.getFloat(dimensionPixelOffset, bVar16.g));
            aVar.b(18, typedArray3.getDimensionPixelOffset(dimensionPixelOffset, bVar10.f));
            aVar.b(i, typedArray3.getDimensionPixelOffset(dimensionPixelOffset, bVar2.e));
            aVar.b(16, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar37.N));
            aVar.b(15, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar32.R));
            aVar.b(14, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar26.O));
            aVar.b(13, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar18.M));
            aVar.b(12, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar12.Q));
            aVar.b(11, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar4.P));
            if (Build.VERSION.SDK_INT >= i) {
            }
            aVar.b(8, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar40.J));
            aVar.b(7, typedArray3.getDimensionPixelOffset(dimensionPixelOffset, bVar30.D));
            aVar.b(6, typedArray3.getDimensionPixelOffset(dimensionPixelOffset, bVar23.C));
            aVar.c(5, typedArray3.getString(dimensionPixelOffset));
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown attribute 0x");
            stringBuilder.append(Integer.toHexString(dimensionPixelOffset));
            stringBuilder.append(str3);
            stringBuilder.append(d.e.get(dimensionPixelOffset));
            Log.w(str, stringBuilder.toString());
            aVar.b(2, typedArray3.getDimensionPixelSize(dimensionPixelOffset, bVar7.I));
        }
    }

    private String v(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void c(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(0);
        constraintLayout.requestLayout();
    }

    void d(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, boolean z2) {
        HashSet hashSet;
        boolean next;
        int i2;
        int i;
        String sDK_INT;
        androidx.constraintlayout.widget.d.d dVar;
        String childAt;
        int barrier;
        String context;
        androidx.constraintlayout.widget.d.b bVar;
        boolean naN;
        boolean viewById;
        boolean key;
        String valueOf;
        int i3;
        Integer valueOf2;
        Iterator obj13;
        final int childCount = constraintLayout.getChildCount();
        hashSet = new HashSet(this.c.keySet());
        i = i2;
        sDK_INT = 1;
        while (i < childCount) {
            childAt = constraintLayout.getChildAt(i);
            context = childAt.getId();
            valueOf = "ConstraintSet";
            i3 = -1;
            if (context == i3) {
            } else {
            }
            if (this.c.containsKey(Integer.valueOf(context))) {
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("WARNING NO CONSTRAINTS for view ");
            stringBuilder2.append(context);
            Log.v(valueOf, stringBuilder2.toString());
            i++;
            sDK_INT = 1;
            hashSet.remove(Integer.valueOf(context));
            key = this.c.get(Integer.valueOf(context));
            if ((d.a)key == null) {
            } else {
            }
            if (childAt instanceof Barrier) {
            }
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            (ConstraintLayout.b)layoutParams.a();
            (d.a)key.d(layoutParams);
            if (z2) {
            }
            childAt.setLayoutParams(layoutParams);
            dVar = key.c;
            if (dVar.c == 0) {
            }
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 17) {
            }
            childAt.setAlpha(dVar2.d);
            childAt.setRotation(eVar2.b);
            childAt.setRotationX(eVar3.c);
            childAt.setRotationY(eVar4.d);
            childAt.setScaleX(eVar5.e);
            childAt.setScaleY(eVar6.f);
            androidx.constraintlayout.widget.d.e eVar7 = key.f;
            if (eVar7.i != i3) {
            } else {
            }
            if (!Float.isNaN(eVar7.g)) {
            }
            if (!Float.isNaN(eVar8.h)) {
            }
            childAt.setTranslationX(eVar11.j);
            childAt.setTranslationY(eVar12.k);
            childAt.setTranslationZ(eVar.l);
            sDK_INT = key.f;
            if (sDK_INT >= 21 && sDK_INT.m) {
            }
            childAt.setTranslationZ(eVar.l);
            sDK_INT = key.f;
            if (sDK_INT.m) {
            }
            childAt.setElevation(sDK_INT.n);
            childAt.setPivotY(eVar9.h);
            childAt.setPivotX(eVar10.g);
            viewById = (View)childAt.getParent().findViewById(eVar13.i);
            int i10 = 1073741824;
            if (viewById != null && right2 -= valueOf2 > 0 && bottom2 -= valueOf2 > 0) {
            }
            i10 = 1073741824;
            if (right2 -= valueOf2 > 0) {
            }
            if (bottom2 -= valueOf2 > 0) {
            }
            childAt.setPivotX(viewById -= f14);
            childAt.setPivotY(valueOf -= i3);
            childAt.setVisibility(dVar.b);
            a.d(childAt, key.g);
            bVar11.h0 = sDK_INT;
            sDK_INT = childAt;
            (Barrier)sDK_INT.setId(context);
            sDK_INT.setType(bVar7.f0);
            sDK_INT.setMargin(bVar8.g0);
            sDK_INT.setAllowsGoneWidget(bVar9.n0);
            context = key.e;
            valueOf = context.i0;
            if (valueOf != null) {
            } else {
            }
            valueOf = context.j0;
            if (valueOf != null) {
            }
            context.i0 = k(sDK_INT, valueOf);
            sDK_INT.setReferencedIds(bVar10.i0);
            sDK_INT.setReferencedIds(valueOf);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("id unknown ");
            stringBuilder.append(a.b(childAt));
            Log.w(valueOf, stringBuilder.toString());
        }
        obj13 = hashSet.iterator();
        while (obj13.hasNext()) {
            hashSet = obj13.next();
            i = this.c.get((Integer)hashSet);
            if ((d.a)i == 0) {
            } else {
            }
            if (bVar2.h0 == sDK_INT) {
            }
            if (bVar3.a) {
            }
            childAt = new Guideline(constraintLayout.getContext());
            childAt.setId(hashSet.intValue());
            hashSet = constraintLayout.e();
            (d.a)i.d(hashSet);
            constraintLayout.addView(childAt, hashSet);
            barrier = new Barrier(constraintLayout.getContext());
            barrier.setId(hashSet.intValue());
            bVar = i.e;
            key = bVar.i0;
            if (key != null) {
            } else {
            }
            key = bVar.j0;
            if (key != null) {
            }
            barrier.setType(bVar5.f0);
            barrier.setMargin(bVar6.g0);
            context = constraintLayout.e();
            barrier.s();
            i.d(context);
            constraintLayout.addView(barrier, context);
            bVar.i0 = k(barrier, key);
            barrier.setReferencedIds(bVar4.i0);
            barrier.setReferencedIds(key);
        }
        while (i2 < childCount) {
            obj13 = constraintLayout.getChildAt(i2);
            if (obj13 instanceof b) {
            }
            i2++;
            (b)obj13.i(constraintLayout);
        }
    }

    public void e(int i, int i2) {
        boolean key;
        Integer valueOf;
        int i3;
        int obj4;
        int obj5;
        obj4 = this.c.get(Integer.valueOf(i));
        if (this.c.containsKey(Integer.valueOf(i)) && (d.a)obj4 == null) {
            obj4 = this.c.get(Integer.valueOf(i));
            if ((d.a)(d.a)obj4 == null) {
            }
            key = 0;
            valueOf = Integer.MIN_VALUE;
            i3 = -1;
            switch (i2) {
                case 1:
                    obj4 = obj4.e;
                    obj4.i = i3;
                    obj4.h = i3;
                    obj4.F = i3;
                    obj4.M = valueOf;
                    break;
                case 2:
                    obj4 = obj4.e;
                    obj4.k = i3;
                    obj4.j = i3;
                    obj4.G = i3;
                    obj4.O = valueOf;
                    break;
                case 3:
                    obj4 = obj4.e;
                    obj4.m = i3;
                    obj4.l = i3;
                    obj4.H = key;
                    obj4.N = valueOf;
                    break;
                case 4:
                    obj4 = obj4.e;
                    obj4.n = i3;
                    obj4.o = i3;
                    obj4.I = key;
                    obj4.P = valueOf;
                    break;
                case 5:
                    obj4 = obj4.e;
                    obj4.p = i3;
                    obj4.q = i3;
                    obj4.r = i3;
                    obj4.L = key;
                    obj4.S = valueOf;
                    break;
                case 6:
                    obj4 = obj4.e;
                    obj4.s = i3;
                    obj4.t = i3;
                    obj4.K = key;
                    obj4.R = valueOf;
                    break;
                case 7:
                    obj4 = obj4.e;
                    obj4.u = i3;
                    obj4.v = i3;
                    obj4.J = key;
                    obj4.Q = valueOf;
                    break;
                case 8:
                    obj4 = obj4.e;
                    obj4.B = -1082130432;
                    obj4.A = i3;
                    obj4.z = i3;
                    break;
                default:
                    obj4 = new IllegalArgumentException("unknown constraint");
                    throw obj4;
            }
        }
    }

    public void f(Context context, int i2) {
        g((ConstraintLayout)LayoutInflater.from(context).inflate(i2, 0));
    }

    public void g(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int i;
        View childAt;
        android.view.ViewGroup.LayoutParams layoutParams;
        int sDK_INT;
        int elevation;
        Object obj;
        boolean z;
        boolean key;
        Integer translationY;
        Integer valueOf;
        androidx.constraintlayout.widget.d.a aVar;
        int i2;
        this.c.clear();
        i = 0;
        while (i < constraintLayout.getChildCount()) {
            childAt = constraintLayout.getChildAt(i);
            elevation = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(elevation))) {
            }
            obj = this.c.get(Integer.valueOf(elevation));
            if ((d.a)obj == null) {
            } else {
            }
            obj.g = a.b(this.a, childAt);
            d.a.a((d.a)obj, elevation, (ConstraintLayout.b)childAt.getLayoutParams());
            dVar.b = childAt.getVisibility();
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 17) {
            }
            if (childAt instanceof Barrier) {
            }
            i++;
            bVar.n0 = (Barrier)childAt.getAllowsGoneWidget();
            bVar2.i0 = childAt.getReferencedIds();
            bVar3.f0 = childAt.getType();
            layoutParams.g0 = childAt.getMargin();
            dVar2.d = childAt.getAlpha();
            eVar2.b = childAt.getRotation();
            eVar3.c = childAt.getRotationX();
            eVar4.d = childAt.getRotationY();
            eVar5.e = childAt.getScaleX();
            eVar6.f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            i2 = 0;
            if (Double.compare(d, i2) == 0) {
            } else {
            }
            aVar = obj.f;
            aVar.g = pivotX;
            aVar.h = pivotY;
            eVar7.j = childAt.getTranslationX();
            eVar8.k = childAt.getTranslationY();
            eVar.l = childAt.getTranslationZ();
            sDK_INT = obj.f;
            if (sDK_INT >= 21 && sDK_INT.m) {
            }
            eVar.l = childAt.getTranslationZ();
            sDK_INT = obj.f;
            if (sDK_INT.m) {
            }
            sDK_INT.n = childAt.getElevation();
            if (Double.compare(d2, i2) != 0) {
            }
            aVar = new d.a();
            this.c.put(Integer.valueOf(elevation), aVar);
        }
    }

    public void h(androidx.constraintlayout.widget.e e) {
        int i2;
        View childAt;
        android.view.ViewGroup.LayoutParams layoutParams;
        int i;
        Object obj;
        boolean z;
        boolean key;
        Integer valueOf2;
        Integer valueOf;
        androidx.constraintlayout.widget.d.a aVar;
        this.c.clear();
        i2 = 0;
        while (i2 < e.getChildCount()) {
            childAt = e.getChildAt(i2);
            layoutParams = childAt.getLayoutParams();
            i = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(i))) {
            }
            obj = this.c.get(Integer.valueOf(i));
            if ((d.a)obj == null) {
            } else {
            }
            if (childAt instanceof b) {
            }
            d.a.c((d.a)obj, i, (e.a)layoutParams);
            i2++;
            d.a.b(obj, (b)childAt, i, layoutParams);
            aVar = new d.a();
            this.c.put(Integer.valueOf(i), aVar);
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5) {
        boolean key;
        Integer valueOf;
        androidx.constraintlayout.widget.d.a aVar;
        androidx.constraintlayout.widget.d.b obj10;
        androidx.constraintlayout.widget.d.b obj11;
        if (!this.c.containsKey(Integer.valueOf(i))) {
            aVar = new d.a();
            this.c.put(Integer.valueOf(i), aVar);
        }
        obj10 = this.c.get(Integer.valueOf(i));
        if ((d.a)obj10 == null) {
        }
        int i6 = 2;
        int i7 = 7;
        int i8 = 6;
        final int i9 = 1;
        final int i10 = 4;
        final int i11 = 3;
        final String str = "right to ";
        final String str2 = " undefined";
        final int i12 = -1;
        switch (i2) {
            case 1:
                obj11 = obj10.e;
                obj11.h = i3;
                obj11.i = i12;
                obj11 = obj10.e;
                obj11.i = i3;
                obj11.h = i12;
                obj10.F = i5;
                obj11 = new StringBuilder();
                obj11.append("Left to ");
                obj11.append(v(i4));
                obj11.append(str2);
                obj10 = new IllegalArgumentException(obj11.toString());
                throw obj10;
            case 2:
                obj11 = obj10.e;
                obj11.j = i3;
                obj11.k = i12;
                obj11 = obj10.e;
                obj11.k = i3;
                obj11.j = i12;
                obj10.G = i5;
                obj11 = new StringBuilder();
                obj11.append(str);
                obj11.append(v(i4));
                obj11.append(str2);
                obj10 = new IllegalArgumentException(obj11.toString());
                throw obj10;
            case 3:
                obj11 = obj10.e;
                obj11.l = i3;
                obj11.m = i12;
                obj11.p = i12;
                obj11.q = i12;
                obj11.r = i12;
                obj11 = obj10.e;
                obj11.m = i3;
                obj11.l = i12;
                obj11.p = i12;
                obj11.q = i12;
                obj11.r = i12;
                obj10.H = i5;
                obj11 = new StringBuilder();
                obj11.append(str);
                obj11.append(v(i4));
                obj11.append(str2);
                obj10 = new IllegalArgumentException(obj11.toString());
                throw obj10;
            case 4:
                obj11 = obj10.e;
                obj11.o = i3;
                obj11.n = i12;
                obj11.p = i12;
                obj11.q = i12;
                obj11.r = i12;
                obj11 = obj10.e;
                obj11.n = i3;
                obj11.o = i12;
                obj11.p = i12;
                obj11.q = i12;
                obj11.r = i12;
                obj10.I = i5;
                obj11 = new StringBuilder();
                obj11.append(str);
                obj11.append(v(i4));
                obj11.append(str2);
                obj10 = new IllegalArgumentException(obj11.toString());
                throw obj10;
            case 5:
                obj10 = obj10.e;
                obj10.p = i3;
                obj10.o = i12;
                obj10.n = i12;
                obj10.l = i12;
                obj10.m = i12;
                obj10 = obj10.e;
                obj10.q = i3;
                obj10.o = i12;
                obj10.n = i12;
                obj10.l = i12;
                obj10.m = i12;
                obj10 = obj10.e;
                obj10.r = i3;
                obj10.o = i12;
                obj10.n = i12;
                obj10.l = i12;
                obj10.m = i12;
                obj11 = new StringBuilder();
                obj11.append(str);
                obj11.append(v(i4));
                obj11.append(str2);
                obj10 = new IllegalArgumentException(obj11.toString());
                throw obj10;
            case 6:
                obj11 = obj10.e;
                obj11.t = i3;
                obj11.s = i12;
                obj11 = obj10.e;
                obj11.s = i3;
                obj11.t = i12;
                obj10.K = i5;
                obj11 = new StringBuilder();
                obj11.append(str);
                obj11.append(v(i4));
                obj11.append(str2);
                obj10 = new IllegalArgumentException(obj11.toString());
                throw obj10;
            case 7:
                obj11 = obj10.e;
                obj11.v = i3;
                obj11.u = i12;
                obj11 = obj10.e;
                obj11.u = i3;
                obj11.v = i12;
                obj10.J = i5;
                obj11 = new StringBuilder();
                obj11.append(str);
                obj11.append(v(i4));
                obj11.append(str2);
                obj10 = new IllegalArgumentException(obj11.toString());
                throw obj10;
            default:
                StringBuilder obj12 = new StringBuilder();
                obj12.append(v(i2));
                obj12.append(" to ");
                obj12.append(v(i4));
                obj12.append(" unknown");
                obj10 = new IllegalArgumentException(obj12.toString());
                throw obj10;
        }
    }

    public void j(int i, int i2, int i3, float f4) {
        androidx.constraintlayout.widget.d.b obj1 = obj1.e;
        obj1.z = i2;
        obj1.A = i3;
        obj1.B = f4;
    }

    public void n(Context context, int i2) {
        int eventType;
        boolean equalsIgnoreCase;
        Integer valueOf;
        androidx.constraintlayout.widget.d.a aVar;
        String str;
        Context obj5;
        final android.content.res.XmlResourceParser obj6 = context.getResources().getXml(i2);
        eventType = obj6.getEventType();
        valueOf = 1;
        while (eventType != valueOf) {
            if (eventType != 0) {
            } else {
            }
            obj6.getName();
            eventType = obj6.next();
            valueOf = 1;
            if (eventType != 2) {
            } else {
            }
            aVar = l(context, Xml.asAttributeSet(obj6), false);
            if (obj6.getName().equalsIgnoreCase("Guideline")) {
            }
            this.c.put(Integer.valueOf(aVar.a), aVar);
            equalsIgnoreCase.a = valueOf;
        }
    }

    public void o(Context context, XmlPullParser xmlPullParser2) {
        int eventType;
        boolean equals;
        int i;
        int attributeSet;
        int i2;
        String str2;
        Context str;
        int str3;
        int str4;
        Context obj10;
        try {
            eventType = xmlPullParser2.getEventType();
            int i3 = 0;
            i = i3;
            attributeSet = 1;
            while (eventType != attributeSet) {
                xmlPullParser2.getName();
                eventType = xmlPullParser2.next();
                attributeSet = 1;
                i2 = -1;
                str2 = 3;
                str = 2;
                str3 = 0;
                equals = xmlPullParser2.getName();
                eventType = "XML parser error must be within a Constraint ";
                a.c(context, xmlPullParser2, i.g);
                i.d.b(context, Xml.asAttributeSet(xmlPullParser2));
                i.e.b(context, Xml.asAttributeSet(xmlPullParser2));
                i.f.b(context, Xml.asAttributeSet(xmlPullParser2));
                i.c.b(context, Xml.asAttributeSet(xmlPullParser2));
                i.h0 = attributeSet;
                i = eventType;
                i = eventType.e;
                i.a = attributeSet;
                i.b = attributeSet;
                eventType = l(context, Xml.asAttributeSet(xmlPullParser2), attributeSet);
                eventType = l(context, Xml.asAttributeSet(xmlPullParser2), str3);
                if (equals.equals("Constraint")) {
                }
                i2 = str3;
                if (equals.equals("CustomAttribute")) {
                }
                i2 = 8;
                if (equals.equals("Barrier")) {
                }
                i2 = str2;
                if (equals.equals("CustomMethod")) {
                }
                i2 = 9;
                if (equals.equals("Guideline")) {
                }
                i2 = str;
                if (equals.equals("Transform")) {
                }
                i2 = 5;
                if (equals.equals("PropertySet")) {
                }
                i2 = 4;
                if (equals.equals("ConstraintOverride")) {
                }
                i2 = attributeSet;
                if (equals.equals("Motion")) {
                }
                i2 = 7;
                if (equals.equals("Layout")) {
                }
                i2 = 6;
                eventType = xmlPullParser2.getName().toLowerCase(Locale.ROOT);
                if (i2 != attributeSet && i2 != str && i2 != str2) {
                } else {
                }
                this.c.put(Integer.valueOf(i.a), i);
                i = i3;
                if (i2 != str) {
                } else {
                }
                if (i2 != str2) {
                } else {
                }
                if (eventType.equals("constraintset")) {
                }
                i2 = str3;
                if (eventType.equals("constraintoverride")) {
                }
                i2 = str;
                if (eventType.equals("constraint")) {
                }
                i2 = attributeSet;
                if (eventType.equals("guideline")) {
                }
                i2 = str2;
            }
            if (eventType != 0) {
            } else {
            }
            i2 = -1;
            str2 = 3;
            str = 2;
            str3 = 0;
            if (eventType != str) {
            } else {
            }
            if (eventType != str2) {
            } else {
            }
            eventType = xmlPullParser2.getName().toLowerCase(Locale.ROOT);
            if (eventType.equals("constraintset")) {
            }
            i2 = str3;
            if (eventType.equals("constraintoverride")) {
            }
            i2 = str;
            if (eventType.equals("constraint")) {
            }
            i2 = attributeSet;
            if (eventType.equals("guideline")) {
            }
            i2 = str2;
            if (i2 != 0) {
            }
            if (i2 != attributeSet && i2 != str && i2 != str2) {
            } else {
            }
            if (i2 != str) {
            } else {
            }
            if (i2 != str2) {
            } else {
            }
            this.c.put(Integer.valueOf(i.a), i);
            i = i3;
            equals = xmlPullParser2.getName();
            if (equals.equals("Constraint")) {
            }
            i2 = str3;
            if (equals.equals("CustomAttribute")) {
            }
            i2 = 8;
            if (equals.equals("Barrier")) {
            }
            i2 = str2;
            if (equals.equals("CustomMethod")) {
            }
            i2 = 9;
            if (equals.equals("Guideline")) {
            }
            i2 = str;
            if (equals.equals("Transform")) {
            }
            i2 = 5;
            if (equals.equals("PropertySet")) {
            }
            i2 = 4;
            if (equals.equals("ConstraintOverride")) {
            }
            i2 = attributeSet;
            if (equals.equals("Motion")) {
            }
            i2 = 7;
            if (equals.equals("Layout")) {
            }
            i2 = 6;
            eventType = "XML parser error must be within a Constraint ";
            if (i == 0) {
            } else {
            }
            a.c(context, xmlPullParser2, i.g);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(eventType);
            stringBuilder3.append(xmlPullParser2.getLineNumber());
            obj10 = new RuntimeException(stringBuilder3.toString());
            throw obj10;
            if (i == 0) {
            } else {
            }
            i.d.b(context, Xml.asAttributeSet(xmlPullParser2));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(eventType);
            stringBuilder.append(xmlPullParser2.getLineNumber());
            obj10 = new RuntimeException(stringBuilder.toString());
            throw obj10;
            if (i == 0) {
            } else {
            }
            i.e.b(context, Xml.asAttributeSet(xmlPullParser2));
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(eventType);
            stringBuilder4.append(xmlPullParser2.getLineNumber());
            obj10 = new RuntimeException(stringBuilder4.toString());
            throw obj10;
            if (i == 0) {
            } else {
            }
            i.f.b(context, Xml.asAttributeSet(xmlPullParser2));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(eventType);
            stringBuilder2.append(xmlPullParser2.getLineNumber());
            obj10 = new RuntimeException(stringBuilder2.toString());
            throw obj10;
            if (i == 0) {
            } else {
            }
            i.c.b(context, Xml.asAttributeSet(xmlPullParser2));
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(eventType);
            stringBuilder5.append(xmlPullParser2.getLineNumber());
            obj10 = new RuntimeException(stringBuilder5.toString());
            throw obj10;
            i.h0 = attributeSet;
            i = eventType.e;
            i.a = attributeSet;
            i.b = attributeSet;
            eventType = l(context, Xml.asAttributeSet(xmlPullParser2), attributeSet);
            eventType = l(context, Xml.asAttributeSet(xmlPullParser2), str3);
            i = eventType;
            xmlPullParser2.getName();
            eventType = xmlPullParser2.next();
            context.printStackTrace();
            context.printStackTrace();
            byte b = b;
            obj132 = obj221[obj21];
            obj244 = obj169 - obj4;
            field#64869 = obj25;
            b = (byte) 0;
            b = /* result */;
            obj231 = obj63[obj135];
            xmlPullParser2 = context | -30281;
            obj139 = /* result */;
            obj194 = Float.compare(obj84, obj180);
            obj48[obj182] = obj139;
            obj12 = obj2 + -1095;
            attributeSet = obj8 * 5592;
            obj59 = obj93 ^ obj79;
            obj70 = /* result */;
            context *= obj6;
            /* invoke-custom #27512(obj97, obj98, obj99, obj100, obj101, obj102, obj103, obj104, obj105, obj106, obj107, obj108, obj109, obj110, obj111, obj112, obj113, obj114, obj115, obj116, obj117, obj118, obj119, obj120, obj121, obj122, obj123, obj124, obj125, obj126, obj127, obj128, obj129, obj130, obj131, obj132, obj133, obj134, obj135, obj136, obj137, obj138, obj139, obj140, obj141, obj142, obj143, obj144, obj145, obj146, obj147, obj148, obj149, obj150, obj151, obj152, obj153, obj154, obj155, obj156, obj157, obj158, obj159, obj160, obj161, obj162, obj163, obj164, obj165, obj166, obj167, obj168, obj169, obj170, obj171, obj172, obj173, obj174, obj175, obj176, obj177, obj178, obj179, obj180, obj181, obj182, obj183, obj184, obj185, obj186, obj187, obj188, obj189, obj190, obj191, obj192, obj193, obj194, obj195, obj196, obj197, obj198, obj199, obj200, obj201, obj202, obj203, obj204, obj205, obj206, obj207, obj208, obj209, obj210, obj211, obj212, obj213, obj214, obj215, obj216, obj217, obj218, obj219, obj220, obj221, obj222, obj223, obj224, obj225, obj226, obj227, obj228, obj229, obj230, obj231, obj232, obj233, obj234, obj235, obj236, obj237, obj238, obj239, obj240, obj241, obj242, obj243, obj244, obj245, obj246, obj247, obj248, obj249, obj250, obj251, obj252, obj253, obj254, obj255, obj256, obj257, obj258, obj259, obj260, obj261, obj262, obj263, obj264, obj265, obj266, obj267, obj268, obj269, obj270, obj271, obj272, obj273, obj274, obj275, obj276, obj277, obj278, obj279, obj280, obj281, obj282, obj283, obj284, obj285, obj286, obj287, obj288, obj289, obj290, obj291, obj292, obj293, obj294, obj295, obj296, obj297, obj298, obj299, obj300, obj301, obj302, obj303, obj304, obj305, obj306, obj307, obj308, obj309, obj310, obj311, obj312, obj313, obj314, obj315, obj316, obj317, obj318, obj319, obj320, obj321, obj322, obj323, obj324, obj325, obj326, obj327, obj328, obj329, obj330, obj331, obj332, obj333, obj334, obj335, obj336, obj337) */;
            b = b.condition;
            b[b] = b;
            while (b == 0) {
            }
            b = Double.compare(b, b);
            return b;
            b = b;
            b = /* result */;
            b *= 0;
            b += b;
            b /= b;
            b >>= b;
            b[b] = b;
            throw b;
            b = b;
            b = b;
        }
    }
}
