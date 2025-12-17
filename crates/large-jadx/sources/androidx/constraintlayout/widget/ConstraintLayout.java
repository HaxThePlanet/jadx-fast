package androidx.constraintlayout.widget;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import d.f.a.m.f;
import d.f.a.m.g;
import d.f.a.m.j;
import d.f.a.m.l;
import d.f.a.m.m.b.a;
import d.f.a.m.m.b.b;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    private static androidx.constraintlayout.widget.j L;
    private int A = 257;
    private androidx.constraintlayout.widget.d B = null;
    protected androidx.constraintlayout.widget.c C = null;
    private int D = -1;
    private HashMap<String, Integer> E;
    private int F = -1;
    private int G = -1;
    private SparseArray<e> H;
    androidx.constraintlayout.widget.ConstraintLayout.c I;
    private int J = 0;
    private int K = 0;
    SparseArray<View> a;
    private ArrayList<androidx.constraintlayout.widget.b> b;
    protected f c;
    private int v = 0;
    private int w = 0;
    private int x = Integer.MAX_VALUE;
    private int y = Integer.MAX_VALUE;
    protected boolean z = true;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            ConstraintLayout.a.a = iArr;
            iArr[e.b.FIXED.ordinal()] = 1;
            ConstraintLayout.a.a[e.b.WRAP_CONTENT.ordinal()] = 2;
            ConstraintLayout.a.a[e.b.MATCH_PARENT.ordinal()] = 3;
            ConstraintLayout.a.a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
        }
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        public int A = Integer.MIN_VALUE;
        public int B = Integer.MIN_VALUE;
        public int C = 0;
        public float D = 0.5f;
        public float E = 0.5f;
        public String F = null;
        float G;
        int H;
        public float I = -1f;
        public float J = -1f;
        public int K = 0;
        public int L = 0;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public float S = 1f;
        public float T = 1f;
        public int U = -1;
        public int V = -1;
        public int W = -1;
        public boolean X = false;
        public boolean Y = false;
        public String Z = null;
        public int a = -1;
        public int a0 = 0;
        public int b = -1;
        boolean b0 = true;
        public float c = -1f;
        boolean c0 = true;
        public int d = -1;
        boolean d0 = false;
        public int e = -1;
        boolean e0 = false;
        public int f = -1;
        boolean f0 = false;
        public int g = -1;
        boolean g0 = false;
        public int h = -1;
        boolean h0 = false;
        public int i = -1;
        int i0 = -1;
        public int j = -1;
        int j0 = -1;
        public int k = -1;
        int k0 = -1;
        public int l = -1;
        int l0 = -1;
        public int m = -1;
        int m0 = Integer.MIN_VALUE;
        public int n = -1;
        int n0 = Integer.MIN_VALUE;
        public int o = -1;
        float o0 = 0.5f;
        public int p = 0;
        int p0;
        public float q = 0f;
        int q0;
        public int r = -1;
        float r0;
        public int s = -1;
        e s0;
        public int t = -1;
        public boolean t0;
        public int u = -1;
        public int v = Integer.MIN_VALUE;
        public int w = Integer.MIN_VALUE;
        public int x = Integer.MIN_VALUE;
        public int y = Integer.MIN_VALUE;
        public int z = Integer.MIN_VALUE;
        public b(int i, int i2) {
            super(i, i2);
            int obj5 = -1;
            int obj6 = -1082130432;
            final int i3 = 0;
            int i4 = 0;
            int i5 = Integer.MIN_VALUE;
            final int i6 = 1056964608;
            final int i7 = 0;
            this.M = i3;
            this.N = i3;
            this.O = i3;
            this.P = i3;
            this.Q = i3;
            this.R = i3;
            obj6 = 1065353216;
            obj6 = 1;
            obj5 = new e();
            this.s0 = obj5;
        }

        public b(Context context, AttributeSet attributeSet2) {
            int i5;
            int f;
            int i4;
            int dimensionPixelOffset;
            int dimensionPixelSize;
            String str;
            int i3;
            int i2;
            super(context, attributeSet2);
            final int i6 = -1;
            int i7 = -1082130432;
            final int i10 = 0;
            final int i11 = 0;
            int i12 = Integer.MIN_VALUE;
            dimensionPixelOffset = 1056964608;
            dimensionPixelSize = 0;
            this.M = i10;
            this.N = i10;
            this.O = i10;
            this.P = i10;
            this.Q = i10;
            this.R = i10;
            int i8 = 1065353216;
            int i9 = 1;
            e eVar = new e();
            this.s0 = eVar;
            final TypedArray obj11 = context.obtainStyledAttributes(attributeSet2, i.T0);
            i4 = i10;
            while (i4 < obj11.getIndexCount()) {
                dimensionPixelOffset = obj11.getIndex(i4);
                dimensionPixelSize = ConstraintLayout.b.a.a.get(dimensionPixelOffset);
                str = "ConstraintLayout";
                i3 = 2;
                i2 = -2;
                i4++;
                this.a0 = obj11.getInt(dimensionPixelOffset, this.a0);
                d.q(this, obj11, dimensionPixelOffset, i9);
                d.q(this, obj11, dimensionPixelOffset, i10);
                this.B = obj11.getDimensionPixelSize(dimensionPixelOffset, this.B);
                this.C = obj11.getDimensionPixelSize(dimensionPixelOffset, this.C);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.n);
                this.n = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.n = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.m);
                this.m = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.m = obj11.getInt(dimensionPixelOffset, i6);
                this.Z = obj11.getString(dimensionPixelOffset);
                this.V = obj11.getDimensionPixelOffset(dimensionPixelOffset, this.V);
                this.U = obj11.getDimensionPixelOffset(dimensionPixelOffset, this.U);
                this.L = obj11.getInt(dimensionPixelOffset, i10);
                this.K = obj11.getInt(dimensionPixelOffset, i10);
                this.J = obj11.getFloat(dimensionPixelOffset, this.J);
                this.I = obj11.getFloat(dimensionPixelOffset, this.I);
                d.s(this, obj11.getString(dimensionPixelOffset));
                this.T = Math.max(i11, obj11.getFloat(dimensionPixelOffset, this.T));
                this.N = i3;
                this.R = obj11.getDimensionPixelSize(dimensionPixelOffset, this.R);
                this.P = obj11.getDimensionPixelSize(dimensionPixelOffset, this.P);
                this.S = Math.max(i11, obj11.getFloat(dimensionPixelOffset, this.S));
                this.M = i3;
                this.Q = obj11.getDimensionPixelSize(dimensionPixelOffset, this.Q);
                this.O = obj11.getDimensionPixelSize(dimensionPixelOffset, this.O);
                dimensionPixelOffset = obj11.getInt(dimensionPixelOffset, i10);
                this.N = dimensionPixelOffset;
                if (dimensionPixelOffset == i9) {
                }
                Log.e(str, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                dimensionPixelOffset = obj11.getInt(dimensionPixelOffset, i10);
                this.M = dimensionPixelOffset;
                if (dimensionPixelOffset == i9) {
                }
                Log.e(str, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                this.E = obj11.getFloat(dimensionPixelOffset, this.E);
                this.D = obj11.getFloat(dimensionPixelOffset, this.D);
                this.Y = obj11.getBoolean(dimensionPixelOffset, this.Y);
                this.X = obj11.getBoolean(dimensionPixelOffset, this.X);
                this.A = obj11.getDimensionPixelSize(dimensionPixelOffset, this.A);
                this.z = obj11.getDimensionPixelSize(dimensionPixelOffset, this.z);
                this.y = obj11.getDimensionPixelSize(dimensionPixelOffset, this.y);
                this.x = obj11.getDimensionPixelSize(dimensionPixelOffset, this.x);
                this.w = obj11.getDimensionPixelSize(dimensionPixelOffset, this.w);
                this.v = obj11.getDimensionPixelSize(dimensionPixelOffset, this.v);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.u);
                this.u = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.u = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.t);
                this.t = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.t = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.s);
                this.s = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.s = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.r);
                this.r = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.r = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.l);
                this.l = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.l = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.k);
                this.k = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.k = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.j);
                this.j = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.j = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.i);
                this.i = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.i = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.h);
                this.h = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.h = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.g);
                this.g = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.g = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.f);
                this.f = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.f = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.e);
                this.e = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.e = obj11.getInt(dimensionPixelOffset, i6);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.d);
                this.d = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.d = obj11.getInt(dimensionPixelOffset, i6);
                this.c = obj11.getFloat(dimensionPixelOffset, this.c);
                this.b = obj11.getDimensionPixelOffset(dimensionPixelOffset, this.b);
                this.a = obj11.getDimensionPixelOffset(dimensionPixelOffset, this.a);
                dimensionPixelSize = 1135869952;
                float2 %= dimensionPixelSize;
                this.q = dimensionPixelOffset;
                if (Float.compare(dimensionPixelOffset, i11) < 0) {
                }
                this.q = i13 %= dimensionPixelSize;
                this.p = obj11.getDimensionPixelSize(dimensionPixelOffset, this.p);
                dimensionPixelSize = obj11.getResourceId(dimensionPixelOffset, this.o);
                this.o = dimensionPixelSize;
                if (dimensionPixelSize == i6) {
                }
                this.o = obj11.getInt(dimensionPixelOffset, i6);
                this.W = obj11.getInt(dimensionPixelOffset, this.W);
                int i14 = this.R;
                int int = context.getInt(int, i14);
                if (int == obj9) {
                }
                this.R = obj9;
                i14 = this.P;
                int = context.getInt(int, i14);
                if (int == obj9) {
                }
                this.P = obj9;
                i14 = this.Q;
                int = context.getInt(int, i14);
                if (int == obj9) {
                }
                this.Q = obj9;
                i14 = this.O;
                int = context.getInt(int, i14);
                if (int == obj9) {
                }
                this.O = obj9;
            }
            obj11.recycle();
            a();
        }

        public b(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
            int obj6 = -1;
            int i = -1082130432;
            final int i4 = 0;
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            final int i7 = 1056964608;
            final int i8 = 0;
            this.M = i4;
            this.N = i4;
            this.O = i4;
            this.P = i4;
            this.Q = i4;
            this.R = i4;
            int i2 = 1065353216;
            int i3 = 1;
            obj6 = new e();
            this.s0 = obj6;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public void a() {
            int i;
            int cmp;
            boolean gVar;
            int i2;
            int width;
            boolean z;
            boolean z2;
            i = 0;
            this.e0 = i;
            i2 = 1;
            this.b0 = i2;
            this.c0 = i2;
            width = this.width;
            final int i4 = -2;
            this.b0 = i;
            if (width == i4 && this.X && this.M == 0) {
                if (this.X) {
                    this.b0 = i;
                    if (this.M == 0) {
                        this.M = i2;
                    }
                }
            }
            int height = this.height;
            this.c0 = i;
            if (height == i4 && this.Y && this.N == 0) {
                if (this.Y) {
                    this.c0 = i;
                    if (this.N == 0) {
                        this.N = i2;
                    }
                }
            }
            int i5 = -1;
            if (width != 0) {
                this.b0 = i;
                if (width == i5 && width == 0 && this.M == i2) {
                    this.b0 = i;
                    if (width == 0) {
                        if (this.M == i2) {
                            this.width = i4;
                            this.X = i2;
                        }
                    }
                }
            } else {
            }
            if (height != 0) {
                this.c0 = i;
                if (height == i5 && height == 0 && this.N == i2) {
                    this.c0 = i;
                    if (height == 0) {
                        if (this.N == i2) {
                            this.height = i4;
                            this.Y = i2;
                        }
                    }
                }
            } else {
            }
            if (Float.compare(f, i3) == 0 && this.a == i5) {
                if (this.a == i5) {
                    this.e0 = i2;
                    this.b0 = i2;
                    this.c0 = i2;
                    if (this.b != i5 && !eVar instanceof g) {
                        this.e0 = i2;
                        this.b0 = i2;
                        this.c0 = i2;
                        if (!eVar instanceof g) {
                            gVar = new g();
                            this.s0 = gVar;
                        }
                        (g)this.s0.r1(this.W);
                    }
                } else {
                }
            } else {
            }
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public void resolveLayoutDirection(int i) {
            int i2;
            int cmp;
            int obj11;
            final int leftMargin = this.leftMargin;
            final int rightMargin = this.rightMargin;
            cmp = 1;
            super.resolveLayoutDirection(i);
            if (Build.VERSION.SDK_INT >= 17 && cmp == getLayoutDirection()) {
                super.resolveLayoutDirection(i);
                obj11 = cmp == getLayoutDirection() ? cmp : i2;
            } else {
            }
            int i3 = -1;
            this.k0 = i3;
            this.l0 = i3;
            this.i0 = i3;
            this.j0 = i3;
            this.m0 = i3;
            this.n0 = i3;
            this.m0 = this.v;
            this.n0 = this.x;
            float f = this.D;
            this.o0 = f;
            final int i7 = this.a;
            this.p0 = i7;
            final int i8 = this.b;
            this.q0 = i8;
            final float f2 = this.c;
            this.r0 = f2;
            final int i9 = Integer.MIN_VALUE;
            if (obj11 != null) {
                obj11 = this.r;
                if (obj11 != i3) {
                    this.k0 = obj11;
                    i2 = cmp;
                } else {
                }
                obj11 = this.t;
                if (obj11 != i3) {
                    this.j0 = obj11;
                    i2 = cmp;
                }
                obj11 = this.u;
                if (obj11 != i3) {
                    this.i0 = obj11;
                    i2 = cmp;
                }
                obj11 = this.z;
                if (obj11 != i9) {
                    this.n0 = obj11;
                }
                obj11 = this.A;
                if (obj11 != i9) {
                    this.m0 = obj11;
                }
                obj11 = 1065353216;
                if (i2 != 0) {
                    this.o0 = obj11 - f;
                }
                if (this.e0 && this.W == cmp) {
                    if (this.W == cmp) {
                        i2 = -1082130432;
                        if (Float.compare(f2, i2) != 0) {
                            this.r0 = obj11 -= f2;
                            this.p0 = i3;
                            this.q0 = i3;
                        } else {
                            if (i7 != i3) {
                                this.q0 = i7;
                                this.p0 = i3;
                                this.r0 = i2;
                            } else {
                                if (i8 != i3) {
                                    this.p0 = i8;
                                    this.q0 = i3;
                                    this.r0 = i2;
                                }
                            }
                        }
                    }
                }
            } else {
                obj11 = this.r;
                if (obj11 != i3) {
                    this.j0 = obj11;
                }
                obj11 = this.s;
                if (obj11 != i3) {
                    this.i0 = obj11;
                }
                obj11 = this.t;
                if (obj11 != i3) {
                    this.k0 = obj11;
                }
                obj11 = this.u;
                if (obj11 != i3) {
                    this.l0 = obj11;
                }
                obj11 = this.z;
                if (obj11 != i9) {
                    this.m0 = obj11;
                }
                obj11 = this.A;
                if (obj11 != i9) {
                    this.n0 = obj11;
                }
            }
            if (this.t == i3 && this.u == i3 && this.s == i3 && this.r == i3) {
                if (this.u == i3) {
                    if (this.s == i3) {
                        if (this.r == i3) {
                            obj11 = this.f;
                            if (obj11 != i3) {
                                this.k0 = obj11;
                                if (this.rightMargin <= 0 && rightMargin > 0) {
                                    if (rightMargin > 0) {
                                        this.rightMargin = rightMargin;
                                    }
                                }
                            } else {
                                obj11 = this.g;
                                this.l0 = obj11;
                                if (obj11 != i3 && this.rightMargin <= 0 && rightMargin > 0) {
                                    this.l0 = obj11;
                                    if (this.rightMargin <= 0) {
                                        if (rightMargin > 0) {
                                            this.rightMargin = rightMargin;
                                        }
                                    }
                                }
                            }
                            obj11 = this.d;
                            if (obj11 != i3) {
                                this.i0 = obj11;
                                if (this.leftMargin <= 0 && leftMargin > 0) {
                                    if (leftMargin > 0) {
                                        this.leftMargin = leftMargin;
                                    }
                                }
                            } else {
                                obj11 = this.e;
                                this.j0 = obj11;
                                if (obj11 != i3 && this.leftMargin <= 0 && leftMargin > 0) {
                                    this.j0 = obj11;
                                    if (this.leftMargin <= 0) {
                                        if (leftMargin > 0) {
                                            this.leftMargin = leftMargin;
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

    class c implements b.b {

        androidx.constraintlayout.widget.ConstraintLayout a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        final androidx.constraintlayout.widget.ConstraintLayout h;
        public c(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2) {
            this.h = constraintLayout;
            super();
            this.a = constraintLayout2;
        }

        private boolean d(int i, int i2, int i3) {
            int obj4;
            final int i4 = 1;
            if (i == i2) {
                return i4;
            }
            final int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                if (mode != Integer.MIN_VALUE) {
                    if (mode == 0 && i3 == View.MeasureSpec.getSize(i2)) {
                        if (i3 == View.MeasureSpec.getSize(i2)) {
                            return i4;
                        }
                    }
                } else {
                }
            }
            return 0;
        }

        @Override // d.f.a.m.m.b$b
        public final void a() {
            int i2;
            int i;
            View childAt;
            boolean z;
            i = i2;
            while (i < this.a.getChildCount()) {
                childAt = this.a.getChildAt(i);
                if (childAt instanceof g) {
                }
                i++;
                (g)childAt.a(this.a);
            }
            int size = ConstraintLayout.c(this.a).size();
            if (size > 0) {
            }
        }

        @Override // d.f.a.m.m.b$b
        public final void b(e e, b.a b$a2) {
            int i15;
            int i;
            int i4;
            Object obj;
            int i11;
            int i14;
            int i16;
            boolean z2;
            int i5;
            int i12;
            int measuredHeight3;
            int childMeasureSpec2;
            int childMeasureSpec;
            int i10;
            e baseline;
            int measuredWidth2;
            boolean z;
            boolean z3;
            int i2;
            int measuredHeight;
            int measuredHeight2;
            int iArr;
            e.b mATCH_PARENT;
            int i3;
            int cmp;
            int fIXED;
            int i8;
            int i13;
            int i6;
            int baseline2;
            int i9;
            int measuredWidth;
            int i7;
            Object obj2 = this;
            obj = e;
            final Object obj3 = a2;
            if (obj == null) {
            }
            int i23 = 0;
            if (e.Q() == 8 && !e.e0()) {
                if (!e.e0()) {
                    obj3.e = i23;
                    obj3.f = i23;
                    obj3.g = i23;
                }
            }
            if (e.I() == null) {
            }
            e.b bVar = obj3.a;
            e.b bVar2 = obj3.b;
            i41 += i45;
            i2 = obj2.d;
            final Object obj4 = e.q();
            iArr = ConstraintLayout.a.a;
            fIXED = iArr[bVar.ordinal()];
            int i55 = 2;
            int i24 = 1;
            if (fIXED != i24) {
                if (fIXED != i55) {
                    if (fIXED != 3) {
                        if (fIXED != 4) {
                            childMeasureSpec2 = 0;
                        } else {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(obj2.f, i2, -2);
                            i2 = obj.s == i24 ? i24 : 0;
                            fIXED = obj3.j;
                            if (fIXED != b.a.l) {
                                if (fIXED == b.a.m) {
                                    fIXED = (View)obj4.getMeasuredHeight() == e.v() ? i24 : 0;
                                    if (obj3.j != b.a.m && i2 != 0) {
                                        if (i2 != 0) {
                                            if (i2 != 0) {
                                                if (fIXED == 0 && !obj4 instanceof g) {
                                                    if (!obj4 instanceof g) {
                                                        if (e.i0()) {
                                                            i2 = i24;
                                                        } else {
                                                            i2 = 0;
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
                                    if (i2 != 0) {
                                        childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(e.R(), 1073741824);
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                        childMeasureSpec2 = ViewGroup.getChildMeasureSpec(obj2.f, i2 += i52, -1);
                    }
                } else {
                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(obj2.f, i2, -2);
                }
            } else {
                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(obj3.c, 1073741824);
            }
            measuredHeight = iArr[bVar2.ordinal()];
            if (measuredHeight != i24) {
                if (measuredHeight != i55) {
                    if (measuredHeight != 3) {
                        if (measuredHeight != 4) {
                            childMeasureSpec = 0;
                        } else {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(obj2.g, i10, -2);
                            i10 = obj.t == i24 ? i24 : 0;
                            measuredHeight = obj3.j;
                            if (measuredHeight != b.a.l) {
                                if (measuredHeight == b.a.m) {
                                    measuredHeight = obj4.getMeasuredWidth() == e.R() ? i24 : 0;
                                    if (obj3.j != b.a.m && i10 != 0) {
                                        if (i10 != 0) {
                                            if (i10 != 0) {
                                                if (measuredHeight == 0 && !obj4 instanceof g) {
                                                    if (!obj4 instanceof g) {
                                                        if (e.j0()) {
                                                            i10 = i24;
                                                        } else {
                                                            i10 = 0;
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
                                    if (i10 != 0) {
                                        childMeasureSpec = View.MeasureSpec.makeMeasureSpec(e.v(), 1073741824);
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                        childMeasureSpec = ViewGroup.getChildMeasureSpec(obj2.g, i10 += i48, -1);
                    }
                } else {
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(obj2.g, i10, -2);
                }
            } else {
                childMeasureSpec = View.MeasureSpec.makeMeasureSpec(obj3.d, 1073741824);
            }
            baseline = e.I();
            if (baseline != null && j.b(ConstraintLayout.a(obj2.h), 256) && obj4.getMeasuredWidth() == e.R() && obj4.getMeasuredWidth() < (f)baseline.R() && obj4.getMeasuredHeight() == e.v() && obj4.getMeasuredHeight() < baseline.v() && obj4.getBaseline() == e.n() && !e.h0()) {
                if (j.b(ConstraintLayout.a(obj2.h), 256)) {
                    if (obj4.getMeasuredWidth() == e.R()) {
                        if (obj4.getMeasuredWidth() < baseline.R()) {
                            if (obj4.getMeasuredHeight() == e.v()) {
                                if (obj4.getMeasuredHeight() < baseline.v()) {
                                    if (obj4.getBaseline() == e.n()) {
                                        if (!e.h0()) {
                                            if (obj2.d(e.A(), childMeasureSpec2, e.R()) && obj2.d(e.B(), childMeasureSpec, e.v())) {
                                                baseline = obj2.d(e.B(), childMeasureSpec, e.v()) ? i24 : 0;
                                            } else {
                                            }
                                            if (baseline != 0) {
                                                obj3.e = e.R();
                                                obj3.f = e.v();
                                                obj3.g = e.n();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            e.b mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
            measuredHeight2 = bVar == mATCH_CONSTRAINT ? i24 : 0;
            measuredWidth2 = bVar2 == mATCH_CONSTRAINT ? i24 : 0;
            mATCH_PARENT = e.b.MATCH_PARENT;
            if (bVar2 != mATCH_PARENT) {
                if (bVar2 == e.b.FIXED) {
                    i12 = i24;
                } else {
                    i12 = 0;
                }
            } else {
            }
            if (bVar != mATCH_PARENT) {
                if (bVar == e.b.FIXED) {
                    i14 = i24;
                } else {
                    i14 = 0;
                }
            } else {
            }
            cmp = 0;
            if (measuredHeight2 != 0 && Float.compare(f3, cmp) > 0) {
                i8 = Float.compare(f3, cmp) > 0 ? i24 : 0;
            } else {
            }
            if (measuredWidth2 != 0 && Float.compare(i13, cmp) > 0) {
                i3 = Float.compare(i13, cmp) > 0 ? i24 : 0;
            } else {
            }
            if (obj4 == null) {
            }
            int i54 = obj3.j;
            if (i54 != b.a.l && i54 != b.a.m && measuredHeight2 != 0 && obj.s == 0 && measuredWidth2 != 0) {
                if (i54 != b.a.m) {
                    if (measuredHeight2 != 0) {
                        if (obj.s == 0) {
                            if (measuredWidth2 != 0) {
                                if (obj.t != 0) {
                                    if (obj4 instanceof l && obj instanceof k) {
                                        if (obj instanceof k) {
                                            (l)obj4.t((k)obj, childMeasureSpec2, childMeasureSpec);
                                        } else {
                                            obj4.measure(childMeasureSpec2, childMeasureSpec);
                                        }
                                    } else {
                                    }
                                    obj.M0(childMeasureSpec2, childMeasureSpec);
                                    measuredWidth2 = obj4.getMeasuredWidth();
                                    measuredHeight2 = obj4.getMeasuredHeight();
                                    baseline2 = obj4.getBaseline();
                                    int i56 = obj.v;
                                    if (i56 > 0) {
                                        measuredWidth = Math.max(i56, measuredWidth2);
                                    } else {
                                        measuredWidth = measuredWidth2;
                                    }
                                    int i25 = obj.w;
                                    if (i25 > 0) {
                                        measuredWidth = Math.min(i25, measuredWidth);
                                    }
                                    int i26 = obj.y;
                                    if (i26 > 0) {
                                        measuredHeight3 = Math.max(i26, measuredHeight2);
                                        i7 = childMeasureSpec2;
                                    } else {
                                        i7 = childMeasureSpec2;
                                        measuredHeight3 = measuredHeight2;
                                    }
                                    int i28 = obj.z;
                                    if (i28 > 0) {
                                        measuredHeight3 = Math.min(i28, measuredHeight3);
                                    }
                                    if (!j.b(ConstraintLayout.a(obj2.h), 1)) {
                                        i15 = 1056964608;
                                        if (i8 != 0 && i12 != 0) {
                                            if (i12 != 0) {
                                                measuredWidth = (int)i12;
                                            } else {
                                                if (i3 != 0 && i14 != 0) {
                                                    if (i14 != 0) {
                                                        measuredHeight3 = (int)i12;
                                                    }
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                    if (measuredWidth2 == measuredWidth) {
                                        if (measuredHeight2 != measuredHeight3) {
                                            i15 = 1073741824;
                                            if (measuredWidth2 != measuredWidth) {
                                                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, i15);
                                            } else {
                                                childMeasureSpec2 = i7;
                                            }
                                            if (measuredHeight2 != measuredHeight3) {
                                                childMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight3, i15);
                                            }
                                            obj4.measure(childMeasureSpec2, childMeasureSpec);
                                            obj.M0(childMeasureSpec2, childMeasureSpec);
                                            measuredWidth = obj4.getMeasuredWidth();
                                            measuredHeight3 = obj4.getMeasuredHeight();
                                            baseline2 = obj4.getBaseline();
                                        }
                                    } else {
                                    }
                                    i = -1;
                                } else {
                                    i = -1;
                                    measuredHeight3 = 0;
                                    baseline2 = 0;
                                    measuredWidth = 0;
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
            i4 = baseline2 != i ? 1 : 0;
            if (measuredWidth == obj3.c) {
                if (measuredHeight3 != obj3.d) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
            } else {
            }
            obj3.i = i16;
            if (layoutParams.d0) {
                i4 = 1;
            }
            if (i4 != 0 && baseline2 != -1 && e.n() != baseline2) {
                if (baseline2 != -1) {
                    if (e.n() != baseline2) {
                        obj3.i = true;
                    }
                }
            }
            obj3.e = measuredWidth;
            obj3.f = measuredHeight3;
            obj3.h = i4;
            obj3.g = baseline2;
        }

        @Override // d.f.a.m.m.b$b
        public void c(int i, int i2, int i3, int i4, int i5, int i6) {
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f = i;
            this.g = i2;
        }
    }
    static {
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        SparseArray obj3 = new SparseArray();
        this.a = obj3;
        obj3 = new ArrayList(4);
        this.b = obj3;
        obj3 = new f();
        this.c = obj3;
        obj3 = 0;
        int i2 = Integer.MAX_VALUE;
        int i3 = 1;
        int i4 = 257;
        int i5 = 0;
        int i6 = -1;
        HashMap hashMap = new HashMap();
        this.E = hashMap;
        SparseArray sparseArray = new SparseArray();
        this.H = sparseArray;
        ConstraintLayout.c cVar = new ConstraintLayout.c(this, this);
        this.I = cVar;
        k(attributeSet2, obj3, obj3);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        SparseArray obj3 = new SparseArray();
        this.a = obj3;
        obj3 = new ArrayList(4);
        this.b = obj3;
        obj3 = new f();
        this.c = obj3;
        int i2 = Integer.MAX_VALUE;
        int i4 = 1;
        int i5 = 257;
        int i6 = 0;
        int i7 = -1;
        HashMap hashMap = new HashMap();
        this.E = hashMap;
        SparseArray sparseArray = new SparseArray();
        this.H = sparseArray;
        ConstraintLayout.c cVar = new ConstraintLayout.c(this, this);
        this.I = cVar;
        k(attributeSet2, i3, 0);
    }

    static int a(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        return constraintLayout.A;
    }

    static ArrayList c(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        return constraintLayout.b;
    }

    private int getPaddingWidth() {
        int i;
        int i2;
        int sDK_INT;
        int paddingEnd;
        i2 = 0;
        i3 += i5;
        if (Build.VERSION.SDK_INT >= 17) {
            i4 += sDK_INT;
        }
        if (i2 > 0) {
            i = i2;
        }
        return i;
    }

    public static androidx.constraintlayout.widget.j getSharedValues() {
        androidx.constraintlayout.widget.j jVar;
        if (ConstraintLayout.L == null) {
            jVar = new j();
            ConstraintLayout.L = jVar;
        }
        return ConstraintLayout.L;
    }

    private final e h(int i) {
        Object viewById;
        int obj2;
        if (i == 0) {
            return this.c;
        }
        viewById = findViewById(i);
        if ((View)this.a.get(i) == null && viewById != null && viewById != this && viewById.getParent() == this) {
            viewById = findViewById(i);
            if (viewById != null) {
                if (viewById != this) {
                    if (viewById.getParent() == this) {
                        onViewAdded(viewById);
                    }
                }
            }
        }
        if (viewById == this) {
            return this.c;
        }
        if (viewById == null) {
            obj2 = 0;
        } else {
            obj2 = obj2.s0;
        }
        return obj2;
    }

    private void k(AttributeSet attributeSet, int i2, int i3) {
        int i;
        int[] dimensionPixelOffset;
        int dVar;
        Context context;
        Object obj6;
        int obj7;
        int obj8;
        this.c.s0(this);
        this.c.L1(this.I);
        this.a.put(getId(), this);
        this.B = 0;
        if (attributeSet != null) {
            obj6 = getContext().obtainStyledAttributes(attributeSet, i.T0, i2, i3);
            obj8 = 0;
            i = obj8;
            while (i < obj6.getIndexCount()) {
                dimensionPixelOffset = obj6.getIndex(i);
                if (dimensionPixelOffset == i.Y0) {
                } else {
                }
                if (dimensionPixelOffset == i.Z0) {
                } else {
                }
                if (dimensionPixelOffset == i.W0) {
                } else {
                }
                if (dimensionPixelOffset == i.X0) {
                } else {
                }
                if (dimensionPixelOffset == i.m2) {
                } else {
                }
                if (dimensionPixelOffset == i.h1) {
                } else {
                }
                if (dimensionPixelOffset == i.e1) {
                }
                i++;
                dimensionPixelOffset = obj6.getResourceId(dimensionPixelOffset, obj8);
                dVar = new d();
                this.B = dVar;
                dVar.n(getContext(), dimensionPixelOffset);
                this.D = dimensionPixelOffset;
                dimensionPixelOffset = obj6.getResourceId(dimensionPixelOffset, obj8);
                if (dimensionPixelOffset != null) {
                }
                n(dimensionPixelOffset);
                this.A = obj6.getInt(dimensionPixelOffset, this.A);
                this.y = obj6.getDimensionPixelOffset(dimensionPixelOffset, this.y);
                this.x = obj6.getDimensionPixelOffset(dimensionPixelOffset, this.x);
                this.w = obj6.getDimensionPixelOffset(dimensionPixelOffset, this.w);
                this.v = obj6.getDimensionPixelOffset(dimensionPixelOffset, this.v);
                this.C = obj0;
                this.B = obj0;
            }
            obj6.recycle();
        }
        this.c.M1(this.A);
    }

    private void m() {
        this.z = true;
        int i2 = -1;
        this.F = i2;
        this.G = i2;
    }

    private void q() {
        int i6;
        int i;
        int i2;
        int i4;
        int i5;
        e eVar2;
        int constraintSet;
        int childAt;
        e eVar;
        f fVar;
        String resourceName;
        int indexOf;
        int i3;
        final boolean inEditMode = isInEditMode();
        final int childCount = getChildCount();
        i6 = 0;
        i = i6;
        while (i < childCount) {
            eVar2 = j(getChildAt(i));
            if (eVar2 == null) {
            } else {
            }
            eVar2.o0();
            i++;
        }
        i2 = -1;
        if (inEditMode) {
            eVar2 = i6;
            while (eVar2 < childCount) {
                View childAt4 = getChildAt(eVar2);
                resourceName = getResources().getResourceName(childAt4.getId());
                r(i6, resourceName, Integer.valueOf(childAt4.getId()));
                indexOf = resourceName.indexOf(47);
                if (indexOf != i2) {
                }
                h(childAt4.getId()).t0(resourceName);
                eVar2++;
                resourceName = resourceName.substring(indexOf++);
            }
        }
        if (this.D != i2) {
            i2 = i6;
            while (i2 < childCount) {
                constraintSet = getChildAt(i2);
                if (constraintSet.getId() == this.D && constraintSet instanceof e) {
                }
                i2++;
                if (constraintSet instanceof e) {
                }
                this.B = (e)constraintSet.getConstraintSet();
            }
        }
        androidx.constraintlayout.widget.d dVar = this.B;
        if (dVar != null) {
            dVar.d(this, true);
        }
        this.c.l1();
        int size = this.b.size();
        if (size > 0) {
            constraintSet = i6;
            while (constraintSet < size) {
                (b)this.b.get(constraintSet).r(this);
                constraintSet++;
            }
        }
        i4 = i6;
        while (i4 < childCount) {
            constraintSet = getChildAt(i4);
            if (constraintSet instanceof g) {
            }
            i4++;
            (g)constraintSet.b(this);
        }
        this.H.clear();
        this.H.put(i6, this.c);
        this.H.put(getId(), this.c);
        i5 = i6;
        while (i5 < childCount) {
            View childAt2 = getChildAt(i5);
            this.H.put(childAt2.getId(), j(childAt2));
            i5++;
        }
        i3 = i6;
        while (i3 < childCount) {
            childAt = getChildAt(i3);
            fVar = j(childAt);
            if (fVar == null) {
            } else {
            }
            this.c.b(fVar);
            this.d(inEditMode, childAt, fVar, (ConstraintLayout.b)childAt.getLayoutParams(), this.H);
            i3++;
        }
        try {
        }
    }

    private void t(e e, androidx.constraintlayout.widget.ConstraintLayout.b constraintLayout$b2, SparseArray<e> sparseArray3, int i4, d.b d$b5) {
        Object obj;
        d.b bASELINE;
        d obj3;
        Object obj4;
        Object obj5;
        int obj6;
        d.b obj7;
        obj = this.a.get(i4);
        obj5 = sparseArray3.get(i4);
        obj6 = 1;
        b2.d0 = obj6;
        bASELINE = d.b.BASELINE;
        if ((e)obj5 != null && obj != null && obj6 instanceof ConstraintLayout.b && b5 == bASELINE) {
            if (obj != null) {
                if (obj6 instanceof ConstraintLayout.b) {
                    obj6 = 1;
                    b2.d0 = obj6;
                    bASELINE = d.b.BASELINE;
                    if (b5 == bASELINE) {
                        ViewGroup.LayoutParams layoutParams = obj.getLayoutParams();
                        layoutParams.d0 = obj6;
                        layoutParams.s0.B0(obj6);
                    }
                    e.m(bASELINE).a((e)obj5.m(b5), b2.C, b2.B, obj6);
                    e.B0(obj6);
                    e.m(d.b.TOP).p();
                    e.m(d.b.BOTTOM).p();
                }
            }
        }
    }

    private boolean u() {
        int i2;
        int i;
        boolean layoutRequested;
        i = i2;
        while (i < getChildCount()) {
            if (getChildAt(i).isLayoutRequested()) {
                break;
            } else {
            }
            i++;
        }
        if (i2 != 0) {
            q();
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return layoutParams instanceof ConstraintLayout.b;
    }

    protected void d(boolean z, View view2, e e3, androidx.constraintlayout.widget.ConstraintLayout.b constraintLayout$b4, SparseArray<e> sparseArray5) {
        e eVar;
        int i2;
        Object cmp;
        d mATCH_CONSTRAINT4;
        e.b mATCH_CONSTRAINT2;
        e.b mATCH_CONSTRAINT3;
        e.b mATCH_CONSTRAINT;
        int i6;
        int i9;
        boolean z3;
        boolean z2;
        int cmp2;
        int i;
        int bOTTOM2;
        int bottomMargin;
        int i8;
        int rightMargin;
        int i7;
        int bOTTOM;
        float bottomMargin2;
        int bASELINE;
        Object obj;
        int i4;
        int i3;
        int i5;
        int i10;
        float f;
        Object obj2 = view2;
        final e eVar2 = e3;
        final Object obj3 = b4;
        final SparseArray sparseArray = sparseArray5;
        b4.a();
        final int i24 = 0;
        obj3.t0 = i24;
        eVar2.a1(view2.getVisibility());
        if (obj3.g0) {
            eVar2.K0(true);
            eVar2.a1(8);
        }
        eVar2.s0(obj2);
        if (obj2 instanceof b) {
            (b)obj2.n(eVar2, obj.c.F1());
        } else {
            obj = this;
        }
        i = 17;
        final int i25 = -1;
        if (obj3.e0) {
            eVar = eVar2;
            i8 = obj3.p0;
            i7 = obj3.q0;
            bottomMargin2 = obj3.r0;
            if (Build.VERSION.SDK_INT < i) {
                i8 = obj3.a;
                i7 = obj3.b;
                bottomMargin2 = obj3.c;
            }
            if (Float.compare(bottomMargin2, i18) != 0) {
                (g)eVar.q1(bottomMargin2);
            } else {
                if (i8 != i25) {
                    eVar.o1(i8);
                } else {
                    if (i7 != i25) {
                        eVar.p1(i7);
                    }
                }
            }
        } else {
            i2 = obj3.i0;
            rightMargin = obj3.j0;
            bASELINE = obj3.m0;
            if (Build.VERSION.SDK_INT < i) {
                bOTTOM = obj3.f;
                bottomMargin2 = obj3.g;
                int i22 = obj3.v;
                int i23 = obj3.x;
                float f6 = obj3.D;
                if (obj3.d == i25 && obj3.e == i25) {
                    if (obj3.e == i25) {
                        i3 = obj3.s;
                        if (i3 != i25) {
                            i2 = i3;
                        } else {
                            i3 = obj3.r;
                            if (i3 != i25) {
                                i = i3;
                            }
                        }
                    }
                }
                if (bOTTOM == i25 && bottomMargin2 == i25) {
                    if (bottomMargin2 == i25) {
                        if (obj3.t != i25) {
                            i10 = i23;
                            f = f6;
                            bASELINE = i22;
                            i5 = bottomMargin2;
                            rightMargin = i;
                        } else {
                            i3 = obj3.u;
                            if (i3 != i25) {
                                i10 = i23;
                                f = f6;
                                bASELINE = i22;
                                i5 = i3;
                                rightMargin = i;
                                i4 = bOTTOM;
                            } else {
                                i4 = bOTTOM;
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
                i10 = i3;
                f = f5;
                i4 = bOTTOM;
                i5 = bottomMargin2;
            }
            bOTTOM2 = obj3.o;
            if (bOTTOM2 != i25) {
                cmp = sparseArray.get(bOTTOM2);
                if ((e)cmp != null) {
                    eVar2.j((e)cmp, obj3.q, obj3.p);
                }
            } else {
                if (i2 != i25) {
                    rightMargin = i2;
                    if ((e)rightMargin != null) {
                        bOTTOM = d.b.LEFT;
                        e3.Z(bOTTOM, (e)rightMargin, bOTTOM, obj3.leftMargin, bASELINE);
                    }
                } else {
                    rightMargin = i2;
                    if (rightMargin != i25 && (e)rightMargin != null) {
                        rightMargin = i2;
                        if ((e)(e)rightMargin != null) {
                            e3.Z(d.b.LEFT, (e)(e)rightMargin, d.b.RIGHT, obj3.leftMargin, bASELINE);
                        }
                    }
                }
                if (i4 != i25) {
                    rightMargin = i2;
                    if ((e)rightMargin != null) {
                        e3.Z(d.b.RIGHT, (e)rightMargin, d.b.LEFT, obj3.rightMargin, i10);
                    }
                } else {
                    rightMargin = i2;
                    if (i5 != i25 && (e)rightMargin != null) {
                        rightMargin = i2;
                        if ((e)(e)rightMargin != null) {
                            bOTTOM = d.b.RIGHT;
                            e3.Z(bOTTOM, (e)(e)rightMargin, bOTTOM, obj3.rightMargin, i10);
                        }
                    }
                }
                int i15 = obj3.h;
                if (i15 != i25) {
                    rightMargin = i6;
                    if ((e)rightMargin != null) {
                        bOTTOM = d.b.TOP;
                        e3.Z(bOTTOM, (e)rightMargin, bOTTOM, obj3.topMargin, obj3.w);
                    }
                } else {
                    i6 = obj3.i;
                    rightMargin = i6;
                    if (i6 != i25 && (e)rightMargin != null) {
                        rightMargin = i6;
                        if ((e)(e)rightMargin != null) {
                            e3.Z(d.b.TOP, (e)(e)rightMargin, d.b.BOTTOM, obj3.topMargin, obj3.w);
                        }
                    }
                }
                int i16 = obj3.j;
                if (i16 != i25) {
                    rightMargin = i9;
                    if ((e)rightMargin != null) {
                        e3.Z(d.b.BOTTOM, (e)rightMargin, d.b.TOP, obj3.bottomMargin, obj3.y);
                    }
                } else {
                    i9 = obj3.k;
                    rightMargin = i9;
                    if (i9 != i25 && (e)rightMargin != null) {
                        rightMargin = i9;
                        if ((e)(e)rightMargin != null) {
                            bOTTOM = d.b.BOTTOM;
                            e3.Z(bOTTOM, (e)(e)rightMargin, bOTTOM, obj3.bottomMargin, obj3.y);
                        }
                    }
                }
                bottomMargin2 = obj3.l;
                if (bottomMargin2 != i25) {
                    this.t(e3, b4, sparseArray5, bottomMargin2, d.b.BASELINE);
                } else {
                    bottomMargin2 = obj3.m;
                    if (bottomMargin2 != i25) {
                        this.t(e3, b4, sparseArray5, bottomMargin2, d.b.TOP);
                    } else {
                        bottomMargin2 = obj3.n;
                        if (bottomMargin2 != i25) {
                            this.t(e3, b4, sparseArray5, bottomMargin2, d.b.BOTTOM);
                        }
                    }
                }
                int i17 = 0;
                if (Float.compare(f, i17) >= 0) {
                    eVar2.D0(f);
                }
                bOTTOM2 = obj3.E;
                if (Float.compare(bOTTOM2, i17) >= 0) {
                    eVar2.U0(bOTTOM2);
                }
            }
            if (z) {
                cmp = obj3.U;
                if (cmp == i25) {
                    if (obj3.V != i25) {
                        eVar2.S0(cmp, obj3.V);
                    }
                } else {
                }
            }
            bottomMargin = -2;
            if (!obj3.b0) {
                if (obj3.width == i25) {
                    if (obj3.X) {
                        eVar2.G0(e.b.MATCH_CONSTRAINT);
                    } else {
                        eVar2.G0(e.b.MATCH_PARENT);
                    }
                    dVar2.g = obj3.leftMargin;
                    mATCH_CONSTRAINT4.g = obj3.rightMargin;
                } else {
                    eVar2.G0(e.b.MATCH_CONSTRAINT);
                    eVar2.b1(i24);
                }
            } else {
                eVar2.G0(e.b.FIXED);
                eVar2.b1(obj3.width);
                if (obj3.width == bottomMargin) {
                    eVar2.G0(e.b.WRAP_CONTENT);
                }
            }
            if (!obj3.c0) {
                if (obj3.height == i25) {
                    if (obj3.Y) {
                        eVar2.X0(e.b.MATCH_CONSTRAINT);
                    } else {
                        eVar2.X0(e.b.MATCH_PARENT);
                    }
                    dVar.g = obj3.topMargin;
                    mATCH_CONSTRAINT3.g = obj3.bottomMargin;
                } else {
                    eVar2.X0(e.b.MATCH_CONSTRAINT);
                    eVar2.C0(i24);
                }
            } else {
                eVar2.X0(e.b.FIXED);
                eVar2.C0(obj3.height);
                if (obj3.height == bottomMargin) {
                    eVar2.X0(e.b.WRAP_CONTENT);
                }
            }
            eVar2.u0(obj3.F);
            eVar2.I0(obj3.I);
            eVar2.Z0(obj3.J);
            eVar2.E0(obj3.K);
            eVar2.V0(obj3.L);
            eVar2.c1(obj3.a0);
            eVar2.H0(obj3.M, obj3.O, obj3.Q, obj3.S);
            eVar2.Y0(obj3.N, obj3.P, obj3.R, obj3.T);
        }
    }

    @Override // android.view.ViewGroup
    protected void dispatchDraw(Canvas canvas) {
        ArrayList size;
        boolean inEditMode;
        int i4;
        Object obj;
        int i;
        int childCount;
        int i2;
        View childAt;
        int visibility;
        int i3;
        float f5;
        Canvas canvas2;
        float f6;
        float f3;
        float f4;
        float f;
        Paint paint2;
        float f2;
        Paint paint;
        final Object obj2 = this;
        size = obj2.b;
        final int i5 = 0;
        size = size.size();
        if (size != null && size > 0) {
            size = size.size();
            if (size > 0) {
                i4 = i5;
                while (i4 < size) {
                    (b)obj2.b.get(i4).q(obj2);
                    i4++;
                }
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            inEditMode = (float)width;
            i4 = (float)height;
            obj = 1149698048;
            i = 1156579328;
            i2 = i5;
            while (i2 < getChildCount()) {
                childAt = obj2.getChildAt(i2);
                if (childAt.getVisibility() == 8) {
                } else {
                }
                childAt = childAt.getTag();
                childAt = (String)childAt.split(",");
                if (childAt != null && childAt instanceof String != null && childAt.length == 4) {
                }
                i2++;
                if (childAt instanceof String != null) {
                }
                childAt = (String)childAt.split(",");
                if (childAt.length == 4) {
                }
                int i11 = (int)i10;
                int i16 = (int)i15;
                Paint paint3 = new Paint();
                paint3.setColor(-65536);
                float f14 = (float)i11;
                visibility = (float)i12;
                canvas2 = canvas;
                f5 = f11;
                f2 = f14;
                float f15 = f5;
                paint = paint3;
                float f18 = visibility;
                Paint paint5 = paint;
                canvas2.drawLine(f14, f15, f18, f5, paint5);
                childAt = (float)i17;
                float f13 = visibility;
                float f21 = childAt;
                canvas2.drawLine(f13, f15, f18, f21, paint5);
                float f16 = childAt;
                float f19 = f2;
                canvas2.drawLine(f13, f16, f19, f21, paint5);
                f6 = f2;
                canvas2.drawLine(f6, f16, f19, f5, paint5);
                Paint paint4 = paint;
                paint4.setColor(-16711936);
                f4 = visibility;
                paint2 = i3;
                canvas2.drawLine(f6, f5, f4, childAt, paint2);
                canvas2.drawLine(f6, childAt, f4, f5, paint2);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected androidx.constraintlayout.widget.ConstraintLayout.b e() {
        final int i = -2;
        ConstraintLayout.b bVar = new ConstraintLayout.b(i, i);
        return bVar;
    }

    @Override // android.view.ViewGroup
    public androidx.constraintlayout.widget.ConstraintLayout.b f(AttributeSet attributeSet) {
        ConstraintLayout.b bVar = new ConstraintLayout.b(getContext(), attributeSet);
        return bVar;
    }

    @Override // android.view.ViewGroup
    public void forceLayout() {
        m();
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public Object g(int i, Object object2) {
        boolean obj1;
        obj1 = this.E;
        if (!i && object2 instanceof String != null && obj1 != null && obj1.containsKey((String)object2)) {
            if (object2 instanceof String != null) {
                obj1 = this.E;
                if (obj1 != null) {
                    if (obj1.containsKey((String)object2)) {
                        return this.E.get(object2);
                    }
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return e();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return f(attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        ConstraintLayout.b bVar = new ConstraintLayout.b(layoutParams);
        return bVar;
    }

    @Override // android.view.ViewGroup
    public int getMaxHeight() {
        return this.y;
    }

    @Override // android.view.ViewGroup
    public int getMaxWidth() {
        return this.x;
    }

    @Override // android.view.ViewGroup
    public int getMinHeight() {
        return this.w;
    }

    @Override // android.view.ViewGroup
    public int getMinWidth() {
        return this.v;
    }

    @Override // android.view.ViewGroup
    public int getOptimizationLevel() {
        return this.c.A1();
    }

    @Override // android.view.ViewGroup
    public View i(int i) {
        return (View)this.a.get(i);
    }

    @Override // android.view.ViewGroup
    public final e j(View view) {
        boolean z;
        if (view == this) {
            return this.c;
        }
        if (view != null && layoutParams instanceof ConstraintLayout.b) {
            if (layoutParams instanceof ConstraintLayout.b) {
                return obj2.s0;
            }
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (layoutParams4 instanceof ConstraintLayout.b) {
                return obj2.s0;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    protected boolean l() {
        int layoutDirection;
        int i2;
        int i;
        if (Build.VERSION.SDK_INT >= 17) {
            i = 1;
            layoutDirection = flags &= i4 != 0 ? i : i2;
            if (layoutDirection != 0 && i == getLayoutDirection()) {
                if (i == getLayoutDirection()) {
                    i2 = i;
                }
            }
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    protected void n(int i) {
        c cVar = new c(getContext(), this, i);
        this.C = cVar;
    }

    @Override // android.view.ViewGroup
    protected void o(int i, int i2, int i3, int i4, boolean z5, boolean z6) {
        int obj3;
        int obj4;
        androidx.constraintlayout.widget.ConstraintLayout.c cVar = this.I;
        int i6 = 0;
        int obj5 = 16777215;
        obj5 = 16777216;
        if (z5) {
            obj3 |= obj5;
        }
        if (z6) {
            obj4 |= obj5;
        }
        setMeasuredDimension(obj3, obj4);
        this.F = obj3;
        this.G = obj4;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        e eVar;
        boolean visibility;
        int i;
        boolean z2;
        boolean obj7;
        int obj8;
        int obj9;
        View obj10;
        obj8 = 0;
        obj9 = obj8;
        while (obj9 < getChildCount()) {
            obj10 = getChildAt(obj9);
            layoutParams = obj10.getLayoutParams();
            eVar = layoutParams.s0;
            if (obj10.getVisibility() == 8 && !layoutParams.e0 && !layoutParams.f0 && !layoutParams.h0 && !isInEditMode()) {
            } else {
            }
            if (layoutParams.g0) {
            } else {
            }
            layoutParams = eVar.S();
            visibility = eVar.T();
            i7 += layoutParams;
            i6 += visibility;
            obj10.layout(layoutParams, visibility, i, eVar);
            obj10 = (g)obj10.getContent();
            if (obj10 instanceof g && obj10 != null) {
            }
            obj9++;
            obj10 = (g)obj10.getContent();
            if (obj10 != null) {
            }
            obj10.setVisibility(obj8);
            obj10.layout(layoutParams, visibility, i, eVar);
            if (!layoutParams.e0) {
            } else {
            }
            if (!layoutParams.f0) {
            } else {
            }
            if (!layoutParams.h0) {
            } else {
            }
            if (!isInEditMode()) {
            } else {
            }
        }
        int obj6 = this.b.size();
        if (obj6 > 0) {
        }
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        int i4;
        boolean childCount;
        boolean z;
        int i3;
        boolean layoutRequested;
        if (this.J == i) {
            i4 = this.K;
        }
        int i5 = 0;
        if (!this.z) {
            i3 = i5;
            while (i3 < getChildCount()) {
                if (getChildAt(i3).isLayoutRequested()) {
                    break;
                } else {
                }
                i3++;
            }
        }
        boolean z2 = this.z;
        this.J = i;
        this.K = i2;
        this.c.O1(l());
        this.z = i5;
        if (this.z && u()) {
            this.z = i5;
            if (u()) {
                this.c.Q1();
            }
        }
        p(this.c, this.A, i, i2);
        this.o(i, i2, this.c.R(), this.c.v(), this.c.G1(), this.c.E1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        e eVar;
        boolean z;
        boolean gVar;
        super.onViewAdded(view);
        final int i = 1;
        if (view instanceof Guideline && !eVar instanceof g) {
            if (!eVar instanceof g) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                gVar = new g();
                layoutParams.s0 = gVar;
                layoutParams.e0 = i;
                (g)gVar.r1(layoutParams.W);
            }
        }
        z = view;
        (b)z.s();
        layoutParams2.f0 = i;
        if (view instanceof b && !this.b.contains(z)) {
            z = view;
            (b)z.s();
            layoutParams2.f0 = i;
            if (!this.b.contains(z)) {
                this.b.add(z);
            }
        }
        this.a.put(view.getId(), view);
        this.z = i;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.a.remove(view.getId());
        this.c.k1(j(view));
        this.b.remove(view);
        this.z = true;
    }

    @Override // android.view.ViewGroup
    protected void p(f f, int i2, int i3, int i4) {
        int i;
        int paddingLeft;
        int i5;
        int i6;
        final Object obj2 = this;
        final int mode = View.MeasureSpec.getMode(i3);
        final int mode2 = View.MeasureSpec.getMode(i4);
        i = 0;
        final int i24 = Math.max(i, getPaddingTop());
        int i20 = Math.max(i, getPaddingBottom());
        int i7 = i24 + i20;
        int paddingWidth = getPaddingWidth();
        obj2.I.c(i3, i4, i24, i20, paddingWidth, i7);
        if (Build.VERSION.SDK_INT >= 17) {
            i5 = Math.max(i, getPaddingEnd());
            if (Math.max(i, getPaddingStart()) <= 0) {
                if (i5 > 0) {
                    if (l()) {
                        paddingLeft = i5;
                    }
                } else {
                    paddingLeft = Math.max(i, getPaddingLeft());
                }
            } else {
            }
            i6 = paddingLeft;
        } else {
            i6 = i;
        }
        final int i13 = size - paddingWidth;
        int i14 = size2 - i7;
        this.s(f, mode, i13, mode2, i14);
        f.H1(i2, mode, i13, mode2, i14, obj2.F, obj2.G, i6, i24);
    }

    @Override // android.view.ViewGroup
    public void r(int i, Object object2, Object object3) {
        int i2;
        HashMap obj2;
        Object obj3;
        Object obj4;
        if (!i && object2 instanceof String != null && object3 instanceof Integer && this.E == null) {
            if (object2 instanceof String != null) {
                if (object3 instanceof Integer) {
                    if (this.E == null) {
                        obj2 = new HashMap();
                        this.E = obj2;
                    }
                    obj2 = (String)object2.indexOf("/");
                    if (obj2 != -1) {
                        obj3 = object2.substring(obj2++);
                    }
                    this.E.put(obj3, Integer.valueOf((Integer)object3.intValue()));
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void requestLayout() {
        m();
        super.requestLayout();
    }

    @Override // android.view.ViewGroup
    protected void s(f f, int i2, int i3, int i4, int i5) {
        e.b wRAP_CONTENT;
        e.b obj9;
        int obj10;
        int obj11;
        int obj12;
        androidx.constraintlayout.widget.ConstraintLayout.c cVar = this.I;
        final int i6 = cVar.e;
        int i = cVar.d;
        wRAP_CONTENT = e.b.FIXED;
        final int childCount = getChildCount();
        final int i7 = 1073741824;
        final int i8 = Integer.MIN_VALUE;
        final int i9 = 0;
        if (i2 != i8) {
            if (i2 != 0) {
                if (i2 != i7) {
                    obj9 = wRAP_CONTENT;
                    obj10 = i9;
                } else {
                    obj10 = Math.min(obj9 -= i, i3);
                    obj9 = wRAP_CONTENT;
                }
            } else {
            }
        } else {
            obj9 = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                obj10 = Math.max(i9, this.v);
            }
        }
        if (i4 != i8) {
            if (i4 != 0) {
                if (i4 != i7) {
                    obj12 = i9;
                } else {
                    obj12 = Math.min(obj11 -= i6, i5);
                }
            } else {
            }
        } else {
            wRAP_CONTENT = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                obj12 = Math.max(i9, this.w);
            }
        }
        if (obj10 == f.R()) {
            if (obj12 != f.v()) {
                f.D1();
            }
        } else {
        }
        f.d1(i9);
        f.e1(i9);
        f.O0(obj11 -= i);
        f.N0(obj11 -= i6);
        f.R0(i9);
        f.Q0(i9);
        f.G0(obj9);
        f.b1(obj10);
        f.X0(wRAP_CONTENT);
        f.C0(obj12);
        f.R0(obj9 -= i);
        f.Q0(obj9 -= i6);
    }

    @Override // android.view.ViewGroup
    public void setConstraintSet(androidx.constraintlayout.widget.d d) {
        this.B = d;
    }

    @Override // android.view.ViewGroup
    public void setId(int i) {
        this.a.remove(getId());
        super.setId(i);
        this.a.put(getId(), this);
    }

    @Override // android.view.ViewGroup
    public void setMaxHeight(int i) {
        if (i == this.y) {
        }
        this.y = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setMaxWidth(int i) {
        if (i == this.x) {
        }
        this.x = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setMinHeight(int i) {
        if (i == this.w) {
        }
        this.w = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setMinWidth(int i) {
        if (i == this.v) {
        }
        this.v = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setOnConstraintsChanged(androidx.constraintlayout.widget.f f) {
        final androidx.constraintlayout.widget.c cVar = this.C;
        if (cVar != null) {
            cVar.c(f);
        }
    }

    @Override // android.view.ViewGroup
    public void setOptimizationLevel(int i) {
        this.A = i;
        this.c.M1(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}
