package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.internal.n;
import com.google.android.material.internal.n.d;
import com.google.android.material.internal.n.e;
import d.h.h.a;
import d.h.l.d0;
import d.h.l.e0.c.a;
import d.h.l.e0.f;
import d.h.l.e0.f.a;
import d.h.l.u;
import d.j.a.a;
import d.j.b.c;
import d.j.b.c.c;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.j;
import f.c.a.e.k;
import f.c.a.e.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View>  extends CoordinatorLayout.c<V> {

    private static final int Z;
    int A;
    float B = 0.5f;
    int C;
    float D = -1f;
    boolean E;
    private boolean F;
    private boolean G = true;
    int H = 4;
    c I;
    private boolean J;
    private int K;
    private boolean L;
    private int M;
    int N;
    int O;
    WeakReference<V> P;
    WeakReference<View> Q;
    private final ArrayList<com.google.android.material.bottomsheet.BottomSheetBehavior.f> R;
    private VelocityTracker S;
    int T;
    private int U;
    boolean V;
    private Map<View, Integer> W;
    private int X = -1;
    private final c.c Y;
    private int a = 0;
    private boolean b = true;
    private boolean c = false;
    private float d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private boolean i;
    private g j;
    private int k = -1;
    private int l = -1;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private k u;
    private boolean v;
    private com.google.android.material.bottomsheet.BottomSheetBehavior.h<V> w = null;
    private ValueAnimator x;
    int y;
    int z;

    class a implements Runnable {

        final View a;
        final int b;
        final com.google.android.material.bottomsheet.BottomSheetBehavior c;
        a(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior, View view2, int i3) {
            this.c = bottomSheetBehavior;
            this.a = view2;
            this.b = i3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.c0(this.a, this.b);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.bottomsheet.BottomSheetBehavior a;
        b(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
            this.a = bottomSheetBehavior;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            g gVar;
            if (BottomSheetBehavior.a(this.a) != null) {
                BottomSheetBehavior.a(this.a).a0((Float)valueAnimator.getAnimatedValue().floatValue());
            }
        }
    }

    public static abstract class f {
        public abstract void onSlide(View view, float f2);

        public abstract void onStateChanged(View view, int i2);
    }

    private class h implements Runnable {

        private final View a;
        private boolean b;
        int c;
        final com.google.android.material.bottomsheet.BottomSheetBehavior v;
        h(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior, View view2, int i3) {
            this.v = bottomSheetBehavior;
            super();
            this.a = view2;
            this.c = i3;
        }

        static boolean a(com.google.android.material.bottomsheet.BottomSheetBehavior.h bottomSheetBehavior$h) {
            return h.b;
        }

        static boolean b(com.google.android.material.bottomsheet.BottomSheetBehavior.h bottomSheetBehavior$h, boolean z2) {
            h.b = z2;
            return z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            Object bottomSheetBehavior;
            int i;
            cVar = bottomSheetBehavior2.I;
            if (cVar != null && cVar.k(true)) {
                if (cVar.k(true)) {
                    u.d0(this.a, this);
                } else {
                    this.v.a0(this.c);
                }
            } else {
            }
            this.b = false;
        }
    }

    class c implements n.d {

        final boolean a;
        final com.google.android.material.bottomsheet.BottomSheetBehavior b;
        c(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior, boolean z2) {
            this.b = bottomSheetBehavior;
            this.a = z2;
            super();
        }

        @Override // com.google.android.material.internal.n$d
        public d0 a(View view, d0 d02, n.e n$e3) {
            boolean z2;
            int paddingBottom;
            int i;
            int paddingLeft;
            int paddingRight;
            boolean z;
            boolean z3;
            boolean obj6;
            Object obj8;
            BottomSheetBehavior.c(this.b, d02.l());
            z2 = n.e(view);
            paddingBottom = view.getPaddingBottom();
            paddingLeft = view.getPaddingLeft();
            paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.f(this.b)) {
                BottomSheetBehavior.h(this.b, d02.i());
                i3 += z;
            }
            if (BottomSheetBehavior.i(this.b)) {
                i = z2 ? e3.c : e3.a;
                i += z3;
            }
            if (BottomSheetBehavior.j(this.b)) {
                obj8 = z2 ? e3.a : e3.c;
                paddingRight = obj8 + z2;
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.a) {
                BottomSheetBehavior.k(this.b, obj8.d);
            }
            if (!BottomSheetBehavior.f(this.b)) {
                if (this.a) {
                    BottomSheetBehavior.l(this.b, false);
                }
            } else {
            }
            return d02;
        }
    }

    class d extends c.c {

        private long a;
        final com.google.android.material.bottomsheet.BottomSheetBehavior b;
        d(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
            this.b = bottomSheetBehavior;
            super();
        }

        private boolean n(View view) {
            int obj3;
            com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = this.b;
            obj3 = view.getTop() > i3 /= 2 ? 1 : 0;
            return obj3;
        }

        @Override // d.j.b.c$c
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // d.j.b.c$c
        public int b(View view, int i2, int i3) {
            int obj4;
            obj4 = this.b;
            obj4 = obj4.E ? obj4.O : obj4.C;
            return a.b(i2, this.b.A(), obj4);
        }

        @Override // d.j.b.c$c
        public int e(View view) {
            com.google.android.material.bottomsheet.BottomSheetBehavior obj2 = this.b;
            if (obj2.E) {
                return obj2.O;
            }
            return obj2.C;
        }

        @Override // d.j.b.c$c
        public void j(int i) {
            int obj2;
            final int i2 = 1;
            if (i == i2 && BottomSheetBehavior.m(this.b)) {
                if (BottomSheetBehavior.m(this.b)) {
                    this.b.a0(i2);
                }
            }
        }

        @Override // d.j.b.c$c
        public void k(View view, int i2, int i3, int i4, int i5) {
            this.b.w(i3);
        }

        @Override // d.j.b.c$c
        public void l(View view, float f2, float f3) {
            int cmp;
            int cmp2;
            int i;
            boolean z;
            int obj9;
            int obj10;
            cmp = 0;
            cmp2 = Float.compare(f3, cmp);
            i = 6;
            if (cmp2 < 0 && BottomSheetBehavior.b(this.b)) {
                if (BottomSheetBehavior.b(this.b)) {
                    obj9 = obj9.z;
                    i = i3;
                } else {
                }
            } else {
            }
            obj10 = this.b;
            obj10.j0(view, i, obj9, obj10.i0());
        }

        @Override // d.j.b.c$c
        public boolean m(View view, int i2) {
            com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior;
            int i;
            int i3;
            int obj7;
            bottomSheetBehavior = this.b;
            i = bottomSheetBehavior.H;
            final int i4 = 0;
            if (i == 1) {
                return i4;
            }
            if (bottomSheetBehavior.V) {
                return i4;
            }
            if (i == 3 && bottomSheetBehavior.T == i2) {
                if (bottomSheetBehavior.T == i2) {
                    obj7 = bottomSheetBehavior.Q;
                    if (obj7 != null) {
                        obj7 = obj7.get();
                    } else {
                        obj7 = 0;
                    }
                    if (obj7 != null && obj7.canScrollVertically(-1)) {
                        if (obj7.canScrollVertically(-1)) {
                            return i4;
                        }
                    }
                }
            }
            this.a = System.currentTimeMillis();
            obj7 = obj7.P;
            if (obj7 != null && obj7.get() == view) {
                if (obj7.get() == view) {
                } else {
                    i3 = i4;
                }
            } else {
            }
            return i3;
        }
    }

    class e implements f {

        final int a;
        final com.google.android.material.bottomsheet.BottomSheetBehavior b;
        e(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior, int i2) {
            this.b = bottomSheetBehavior;
            this.a = i2;
            super();
        }

        @Override // d.h.l.e0.f
        public boolean a(View view, f.a f$a2) {
            this.b.Z(this.a);
            return 1;
        }
    }

    protected static class g extends a {

        public static final Parcelable.Creator<com.google.android.material.bottomsheet.BottomSheetBehavior.g> CREATOR;
        final int c;
        int v;
        boolean w;
        boolean x;
        boolean y;
        static {
            BottomSheetBehavior.g.a aVar = new BottomSheetBehavior.g.a();
            BottomSheetBehavior.g.CREATOR = aVar;
        }

        public g(Parcel parcel, java.lang.ClassLoader classLoader2) {
            int i;
            int obj4;
            super(parcel, classLoader2);
            this.c = parcel.readInt();
            this.v = parcel.readInt();
            i = 0;
            final int i2 = 1;
            obj4 = parcel.readInt() == i2 ? i2 : i;
            this.w = obj4;
            obj4 = parcel.readInt() == i2 ? i2 : i;
            this.x = obj4;
            i = parcel.readInt() == i2 ? i2 : i;
            this.y = i;
        }

        public g(Parcelable parcelable, com.google.android.material.bottomsheet.BottomSheetBehavior<?> bottomSheetBehavior2) {
            super(parcelable);
            this.c = bottomSheetBehavior2.H;
            this.v = BottomSheetBehavior.d(bottomSheetBehavior2);
            this.w = BottomSheetBehavior.b(bottomSheetBehavior2);
            this.x = bottomSheetBehavior2.E;
            this.y = BottomSheetBehavior.e(bottomSheetBehavior2);
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
            parcel.writeInt(this.v);
            parcel.writeInt(this.w);
            parcel.writeInt(this.x);
            parcel.writeInt(this.y);
        }
    }
    static {
        BottomSheetBehavior.Z = k.j;
    }

    public BottomSheetBehavior() {
        super();
        int i = 0;
        int i3 = 1;
        int i2 = -1;
        int i5 = 0;
        int i6 = 1056964608;
        int i7 = -1082130432;
        int i4 = 4;
        ArrayList arrayList = new ArrayList();
        this.R = arrayList;
        BottomSheetBehavior.d dVar = new BottomSheetBehavior.d(this);
        this.Y = dVar;
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet2) {
        int type;
        TypedValue peekValue;
        ColorStateList i;
        int obj10;
        super(context, attributeSet2);
        final int i2 = 0;
        final int i3 = 1;
        int i4 = -1;
        int i5 = 0;
        int i7 = 4;
        ArrayList arrayList = new ArrayList();
        this.R = arrayList;
        BottomSheetBehavior.d dVar = new BottomSheetBehavior.d(this);
        this.Y = dVar;
        this.h = context.getResources().getDimensionPixelSize(d.f0);
        TypedArray styledAttributes = context.obtainStyledAttributes(attributeSet2, l.M);
        this.i = styledAttributes.hasValue(l.e0);
        i = l.Q;
        final boolean value4 = styledAttributes.hasValue(i);
        if (value4 != null) {
            u(context, attributeSet2, value4, c.a(context, styledAttributes, i));
        } else {
            t(context, attributeSet2, value4);
        }
        v();
        if (Build.VERSION.SDK_INT >= 21) {
            this.D = styledAttributes.getDimension(l.P, -1082130432);
        }
        obj10 = l.N;
        if (styledAttributes.hasValue(obj10)) {
            U(styledAttributes.getDimensionPixelSize(obj10, i4));
        }
        obj10 = l.O;
        if (styledAttributes.hasValue(obj10)) {
            T(styledAttributes.getDimensionPixelSize(obj10, i4));
        }
        obj10 = l.W;
        peekValue = styledAttributes.peekValue(obj10);
        peekValue = peekValue.data;
        if (peekValue != null && peekValue == i4) {
            peekValue = peekValue.data;
            if (peekValue == i4) {
                V(peekValue);
            } else {
                V(styledAttributes.getDimensionPixelSize(obj10, i4));
            }
        } else {
        }
        S(styledAttributes.getBoolean(l.V, i2));
        Q(styledAttributes.getBoolean(l.Z, i2));
        P(styledAttributes.getBoolean(l.T, i3));
        Y(styledAttributes.getBoolean(l.Y, i2));
        N(styledAttributes.getBoolean(l.R, i3));
        X(styledAttributes.getInt(l.X, i2));
        R(styledAttributes.getFloat(l.U, 1056964608));
        obj10 = l.S;
        TypedValue peekValue2 = styledAttributes.peekValue(obj10);
        if (peekValue2 != null && peekValue2.type == 16) {
            if (peekValue2.type == 16) {
                O(peekValue2.data);
            } else {
                O(styledAttributes.getDimensionPixelOffset(obj10, i2));
            }
        } else {
        }
        this.o = styledAttributes.getBoolean(l.a0, i2);
        this.p = styledAttributes.getBoolean(l.b0, i2);
        this.q = styledAttributes.getBoolean(l.c0, i2);
        this.r = styledAttributes.getBoolean(l.d0, i3);
        styledAttributes.recycle();
        this.d = (float)obj9;
    }

    private float E() {
        VelocityTracker velocityTracker = this.S;
        if (velocityTracker == null) {
            return 0;
        }
        velocityTracker.computeCurrentVelocity(1000, this.d);
        return this.S.getYVelocity(this.T);
    }

    private void J(V v, c.a c$a2, int i3) {
        u.h0(v, a2, 0, s(i3));
    }

    private void K() {
        VelocityTracker velocityTracker;
        this.T = -1;
        velocityTracker = this.S;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.S = 0;
        }
    }

    private void L(com.google.android.material.bottomsheet.BottomSheetBehavior.g bottomSheetBehavior$g) {
        int i3;
        int i2;
        int i;
        int i4;
        Object obj5;
        i3 = this.a;
        if (i3 == 0) {
        }
        i2 = -1;
        if (i3 != i2) {
            if (i3 & 1 == 1) {
                this.e = g.v;
            }
        } else {
        }
        if (i3 != i2) {
            if (i3 & 2 == 2) {
                this.b = g.w;
            }
        } else {
        }
        if (i3 != i2) {
            if (i3 & 4 == 4) {
                this.E = g.x;
            }
        } else {
        }
        if (i3 != i2) {
            i2 = 8;
            if (i3 &= i2 == i2) {
                this.F = g.y;
            }
        } else {
        }
    }

    static g a(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.j;
    }

    static boolean b(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.b;
    }

    private void b0(View view) {
        int i;
        int sDK_INT;
        boolean z;
        if (Build.VERSION.SDK_INT >= 29 && !F() && !this.f) {
            if (!F()) {
                i = !this.f ? 1 : 0;
            } else {
            }
        } else {
        }
        if (!this.o && !this.p && !this.q && i == 0) {
            if (!this.p) {
                if (!this.q) {
                    if (i == 0) {
                    }
                }
            }
        }
        BottomSheetBehavior.c cVar = new BottomSheetBehavior.c(this, i);
        n.b(view, cVar);
    }

    static int c(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior, int i2) {
        bottomSheetBehavior.t = i2;
        return i2;
    }

    static int d(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.e;
    }

    private void d0(int i) {
        Object layoutRequested;
        Object obj = this.P.get();
        if ((View)obj == null) {
        }
        layoutRequested = (View)obj.getParent();
        if (layoutRequested != null && layoutRequested.isLayoutRequested() && u.Q(obj)) {
            if (layoutRequested.isLayoutRequested()) {
                if (u.Q(obj)) {
                    layoutRequested = new BottomSheetBehavior.a(this, obj, i);
                    obj.post(layoutRequested);
                } else {
                    c0(obj, i);
                }
            } else {
            }
        } else {
        }
    }

    static boolean e(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.F;
    }

    static boolean f(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.o;
    }

    private boolean f0() {
        boolean cVar;
        int i;
        if (this.I != null) {
            if (!this.G) {
                if (this.H == 1) {
                } else {
                    i = 0;
                }
            }
        } else {
        }
        return i;
    }

    static int g(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.s;
    }

    static int h(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior, int i2) {
        bottomSheetBehavior.s = i2;
        return i2;
    }

    static boolean i(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.p;
    }

    static boolean j(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.q;
    }

    static int k(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior, int i2) {
        bottomSheetBehavior.m = i2;
        return i2;
    }

    private void k0() {
        boolean z;
        boolean z2;
        c.a i;
        int i2;
        int i3;
        WeakReference weakReference = this.P;
        if (weakReference == null) {
        }
        Object obj = weakReference.get();
        if ((View)obj == null) {
        }
        u.f0((View)obj, 524288);
        u.f0(obj, 262144);
        u.f0(obj, 1048576);
        int i7 = this.X;
        if (i7 != -1) {
            u.f0(obj, i7);
        }
        i2 = 6;
        if (!this.b && this.H != i2) {
            if (this.H != i2) {
                this.X = n(obj, j.a, i2);
            }
        }
        i3 = 5;
        if (this.E && this.H != i3) {
            i3 = 5;
            if (this.H != i3) {
                J(obj, c.a.j, i3);
            }
        }
        i = this.H;
        int i10 = 4;
        final int i11 = 3;
        if (i != i11) {
            if (i != i10) {
                if (i != i2) {
                } else {
                    J(obj, c.a.i, i10);
                    J(obj, c.a.h, i11);
                }
            } else {
                if (this.b) {
                    i2 = i11;
                }
                J(obj, c.a.h, i2);
            }
        } else {
            if (this.b) {
                i2 = i10;
            }
            J(obj, c.a.i, i2);
        }
    }

    static void l(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior, boolean z2) {
        bottomSheetBehavior.n0(z2);
    }

    private void l0(int i) {
        int fArr;
        boolean running;
        ValueAnimator valueAnimator;
        int obj6;
        fArr = 2;
        if (i == fArr) {
        }
        final int i4 = 1;
        final int i5 = 0;
        obj6 = i == 3 ? i4 : i5;
        this.v = obj6;
        running = this.x;
        if (this.v != obj6 && this.j != null && running != null) {
            this.v = obj6;
            if (this.j != null) {
                running = this.x;
                if (running != null) {
                    if (running.isRunning()) {
                        this.x.reverse();
                    } else {
                        int i3 = 1065353216;
                        obj6 = obj6 != null ? 0 : i3;
                        fArr = new float[fArr];
                        fArr[i5] = i3 -= obj6;
                        fArr[i4] = obj6;
                        this.x.setFloatValues(fArr);
                        this.x.start();
                    }
                }
            }
        }
    }

    static boolean m(com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.G;
    }

    private void m0(boolean z) {
        ViewParent parent;
        int sDK_INT2;
        int i;
        View childAt;
        Object intValue;
        int sDK_INT;
        Integer valueOf;
        boolean obj8;
        WeakReference weakReference = this.P;
        if (weakReference == null) {
        }
        parent = (View)weakReference.get().getParent();
        if (!parent instanceof CoordinatorLayout) {
        }
        int childCount = (CoordinatorLayout)parent.getChildCount();
        final int i2 = 16;
        if (Build.VERSION.SDK_INT >= i2 && z && this.W == null) {
            if (z) {
                if (this.W == null) {
                    sDK_INT2 = new HashMap(childCount);
                    this.W = sDK_INT2;
                }
            }
        }
        i = 0;
        while (i < childCount) {
            childAt = parent.getChildAt(i);
            if (childAt == this.P.get()) {
            } else {
            }
            if (z) {
            } else {
            }
            intValue = this.W;
            if (this.c && intValue != null && intValue.containsKey(childAt)) {
            }
            i++;
            intValue = this.W;
            if (intValue != null) {
            }
            if (intValue.containsKey(childAt)) {
            }
            u.v0(childAt, (Integer)this.W.get(childAt).intValue());
            if (Build.VERSION.SDK_INT >= i2) {
            }
            if (this.c) {
            }
            u.v0(childAt, 4);
            this.W.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
        }
        if (!z) {
            this.W = 0;
        } else {
            if (this.c) {
                (View)this.P.get().sendAccessibilityEvent(8);
            }
        }
    }

    private int n(V v, int i2, int i3) {
        return u.b(v, v.getResources().getString(i2), s(i3));
    }

    private void n0(boolean z) {
        WeakReference weakReference;
        int i;
        int obj3;
        p();
        weakReference = this.P.get();
        if (this.P != null && this.H == 4 && (View)weakReference != null) {
            p();
            if (this.H == 4) {
                weakReference = this.P.get();
                if ((View)(View)weakReference != null) {
                    if (z != 0) {
                        d0(this.H);
                    } else {
                        (View)(View)weakReference.requestLayout();
                    }
                }
            }
        }
    }

    private void p() {
        int i2;
        int i;
        i2 = r();
        if (this.b) {
            this.C = Math.max(i4 -= i2, this.z);
        } else {
            this.C = i5 -= i2;
        }
    }

    private void q() {
        this.A = (int)i2;
    }

    private int r() {
        boolean z;
        if (this.f) {
            return i3 += i12;
        }
        z = this.m;
        if (!this.n && !this.o && z > 0) {
            if (!this.o) {
                z = this.m;
                if (z > 0) {
                    return Math.max(this.e, z += i18);
                }
            }
        }
        return i7 += i14;
    }

    private f s(int i) {
        BottomSheetBehavior.e eVar = new BottomSheetBehavior.e(this, i);
        return eVar;
    }

    private void t(Context context, AttributeSet attributeSet2, boolean z3) {
        u(context, attributeSet2, z3, 0);
    }

    private void u(Context context, AttributeSet attributeSet2, boolean z3, ColorStateList colorStateList4) {
        boolean z;
        int i;
        Object obj3;
        AttributeSet obj4;
        int obj5;
        ColorStateList obj6;
        if (this.i) {
            this.u = k.e(context, attributeSet2, b.g, BottomSheetBehavior.Z).m();
            obj4 = new g(this.u);
            this.j = obj4;
            obj4.O(context);
            if (z3 != 0 && colorStateList4 != null) {
                if (colorStateList4 != null) {
                    this.j.Z(colorStateList4);
                } else {
                    obj4 = new TypedValue();
                    context.getTheme().resolveAttribute(16842801, obj4, true);
                    this.j.setTint(obj4.data);
                }
            } else {
            }
        }
    }

    private void v() {
        float[] fArr = new float[2];
        fArr = new int[]{0, 1065353216};
        ValueAnimator float = ValueAnimator.ofFloat(fArr);
        this.x = float;
        float.setDuration(500);
        BottomSheetBehavior.b bVar = new BottomSheetBehavior.b(this);
        this.x.addUpdateListener(bVar);
    }

    public static <V extends View> com.google.android.material.bottomsheet.BottomSheetBehavior<V> y(V v) {
        android.view.ViewGroup.LayoutParams obj1 = v.getLayoutParams();
        if (!obj1 instanceof CoordinatorLayout.f) {
        } else {
            obj1 = (CoordinatorLayout.f)obj1.f();
            if (!obj1 instanceof BottomSheetBehavior) {
            } else {
                return (BottomSheetBehavior)obj1;
            }
            obj1 = new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
            throw obj1;
        }
        obj1 = new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        throw obj1;
    }

    private int z(int i, int i2, int i3, int i4) {
        int obj3;
        int obj1 = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return obj1;
        }
        obj1 = View.MeasureSpec.getSize(obj1);
        final int obj4 = 1073741824;
        if (View.MeasureSpec.getMode(obj1) != obj4) {
            if (obj1 == null) {
            } else {
                obj3 = Math.min(obj1, i3);
            }
            return View.MeasureSpec.makeMeasureSpec(obj3, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(obj1, i3), obj4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public int A() {
        int i2;
        int i;
        if (this.b) {
            i2 = this.z;
        } else {
            i = this.r ? 0 : this.t;
            i2 = Math.max(this.y, i);
        }
        return i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    g B() {
        return this.j;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public int C() {
        int i;
        i = this.f ? -1 : this.e;
        return i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public int D() {
        return this.H;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean F() {
        return this.n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean G() {
        return this.E;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean H() {
        return 1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void I(com.google.android.material.bottomsheet.BottomSheetBehavior.f bottomSheetBehavior$f) {
        this.R.remove(f);
    }

    @Deprecated
    public void M(com.google.android.material.bottomsheet.BottomSheetBehavior.f bottomSheetBehavior$f) {
        ArrayList list;
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.R.clear();
        if (f != null) {
            this.R.add(f);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void N(boolean z) {
        this.G = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void O(int i) {
        if (i < 0) {
        } else {
            this.y = i;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("offset must be greater than or equal to 0");
        throw obj2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void P(boolean z) {
        boolean z2;
        boolean obj2;
        if (this.b == z) {
        }
        this.b = z;
        if (this.P != null) {
            p();
        }
        if (this.b && this.H == 6) {
            obj2 = this.H == 6 ? 3 : this.H;
        } else {
        }
        a0(obj2);
        k0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void Q(boolean z) {
        this.n = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void R(float f) {
        int cmp;
        if (Float.compare(f, i) <= 0) {
        } else {
            if (Float.compare(f, i2) >= 0) {
            } else {
                this.B = f;
                if (this.P != null) {
                    q();
                }
            }
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("ratio must be a float value between 0 and 1");
        throw obj2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void S(boolean z) {
        boolean z2;
        boolean obj2;
        this.E = z;
        if (this.E != z && !z && this.H == 5) {
            this.E = z;
            if (!z) {
                if (this.H == 5) {
                    Z(4);
                }
            }
            k0();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void T(int i) {
        this.l = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void U(int i) {
        this.k = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void V(int i) {
        W(i, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public final void W(int i, boolean z2) {
        int i2;
        boolean i3;
        int obj4;
        final int i4 = 0;
        if (i == -1) {
            if (!this.f) {
                this.f = true;
            } else {
                i2 = i4;
            }
        } else {
            if (!this.f) {
                if (this.e != i) {
                    this.f = i4;
                    this.e = Math.max(i4, i);
                } else {
                }
            } else {
            }
        }
        if (i2 != 0) {
            n0(z2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void X(int i) {
        this.a = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void Y(boolean z) {
        this.F = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void Z(int i) {
        int i2;
        if (i == this.H) {
        }
        if (this.P == null) {
            if (i != 4 && i != 3 && i != 6) {
                if (i != 3) {
                    if (i != 6) {
                        if (this.E && i == 5) {
                            if (i == 5) {
                                this.H = i;
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        d0(i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    void a0(int i) {
        int i2;
        boolean z;
        int i3;
        if (this.H == i) {
        }
        this.H = i;
        final int i5 = 6;
        final int i6 = 3;
        final int i7 = 4;
        if (i != i7 && i != i6 && i != i5) {
            if (i != i6) {
                if (i != i5) {
                    z = this.E;
                }
            }
        }
        WeakReference weakReference = this.P;
        if (weakReference == null) {
        }
        Object obj = weakReference.get();
        if ((View)obj == null) {
        }
        if (i == i6) {
            m0(true);
        } else {
            if (i != i5 && i != 5) {
                if (i != 5) {
                    if (i == i7) {
                        m0(false);
                    }
                } else {
                }
            } else {
            }
        }
        l0(i);
        while (i3 < this.R.size()) {
            (BottomSheetBehavior.f)this.R.get(i3).onStateChanged((View)obj, i);
            i3++;
        }
        k0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    void c0(View view, int i2) {
        boolean z;
        int i3;
        int i;
        boolean z2;
        int obj5;
        int i4 = 3;
        if (i2 == 4) {
            i3 = this.C;
            j0(view, obj5, i3, false);
        } else {
            if (i2 == 6) {
                i = this.A;
                z2 = this.z;
                if (this.b && i <= z2) {
                    z2 = this.z;
                    i3 = i <= z2 ? z2 : i;
                } else {
                }
            } else {
                if (i2 == i4) {
                    i3 = A();
                } else {
                    if (this.E && i2 == 5) {
                        if (i2 == 5) {
                            i3 = this.O;
                        }
                    }
                }
            }
        }
        Log.w("BottomSheetBehavior", "The bottom sheet may be in an invalid state. Ensure `hideable` is true when using `STATE_HIDDEN`.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean e0(long l, float f2) {
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    boolean g0(View view, float f2) {
        int i;
        if (this.F) {
            return 1;
        }
        final int i5 = 0;
        if (view.getTop() < this.C) {
            return i5;
        }
        if (Float.compare(obj5, obj6) > 0) {
        } else {
            i = i5;
        }
        return i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean h0() {
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean i0() {
        return 1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    void j0(View view, int i2, int i3, boolean z4) {
        Object obj3;
        int obj5;
        int obj6;
        final c cVar = this.I;
        final int i = 1;
        if (cVar != null) {
            if (z4 != 0) {
                if (cVar.F(view.getLeft(), i3)) {
                    obj5 = i;
                } else {
                    obj5 = 0;
                }
            } else {
                if (cVar.H(view, view.getLeft(), i3)) {
                } else {
                }
            }
        } else {
        }
        if (obj5 != null) {
            a0(2);
            l0(i2);
            if (this.w == null) {
                obj5 = new BottomSheetBehavior.h(this, view, i2);
                this.w = obj5;
            }
            if (!BottomSheetBehavior.h.a(this.w)) {
                obj5 = this.w;
                obj5.c = i2;
                u.d0(view, obj5);
                BottomSheetBehavior.h.b(this.w, i);
            } else {
                obj3.c = i2;
            }
        } else {
            a0(i2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void o(com.google.android.material.bottomsheet.BottomSheetBehavior.f bottomSheetBehavior$f) {
        boolean contains;
        if (!this.R.contains(f)) {
            this.R.add(f);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void onAttachedToLayoutParams(CoordinatorLayout.f coordinatorLayout$f) {
        super.onAttachedToLayoutParams(f);
        final int obj1 = 0;
        this.P = obj1;
        this.I = obj1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        final int i = 0;
        this.P = i;
        this.I = i;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent3) {
        boolean shown;
        int actionMasked;
        int i4;
        VelocityTracker obtain;
        int i2;
        int i;
        int i3;
        int i6;
        Object pointInChildBounds;
        int i5;
        boolean obj10;
        int obj11;
        i4 = 0;
        final int i7 = 1;
        if (v2.isShown()) {
            if (!this.G) {
            } else {
                actionMasked = motionEvent3.getActionMasked();
                if (actionMasked == 0) {
                    K();
                }
                if (this.S == null) {
                    this.S = VelocityTracker.obtain();
                }
                this.S.addMovement(motionEvent3);
                i = -1;
                final int i8 = 2;
                if (actionMasked != 0) {
                    if (actionMasked != i7 && actionMasked != 3) {
                        if (actionMasked != 3) {
                        } else {
                            this.V = i4;
                            this.T = i;
                            if (this.J) {
                                this.J = i4;
                                return i4;
                            }
                        }
                    } else {
                    }
                } else {
                    i3 = (int)f2;
                    this.U = (int)f3;
                    if (this.H != i8) {
                        WeakReference weakReference = this.Q;
                        if (weakReference != null) {
                            pointInChildBounds = weakReference.get();
                        } else {
                            pointInChildBounds = i2;
                        }
                        if (pointInChildBounds != null && coordinatorLayout.isPointInChildBounds(pointInChildBounds, i3, this.U)) {
                            if (coordinatorLayout.isPointInChildBounds(pointInChildBounds, i3, this.U)) {
                                this.T = motionEvent3.getPointerId(motionEvent3.getActionIndex());
                                this.V = i7;
                            }
                        }
                    }
                    if (this.T == i && !coordinatorLayout.isPointInChildBounds(v2, i3, this.U)) {
                        obj11 = !coordinatorLayout.isPointInChildBounds(v2, i3, this.U) ? i7 : i4;
                    } else {
                    }
                    this.J = obj11;
                }
                obj11 = this.I;
                if (!this.J && obj11 != null && obj11.G(motionEvent3)) {
                    obj11 = this.I;
                    if (obj11 != null) {
                        if (obj11.G(motionEvent3)) {
                            return i7;
                        }
                    }
                }
                obj11 = this.Q;
                if (obj11 != null) {
                    i2 = obj11;
                }
                if (actionMasked == i8 && i2 != 0 && !this.J && this.H != i7 && !coordinatorLayout.isPointInChildBounds(i2, (int)obj11, (int)f) && this.I != null && Float.compare(obj10, obj11) > 0) {
                    if (i2 != 0) {
                        if (!this.J) {
                            if (this.H != i7) {
                                if (!coordinatorLayout.isPointInChildBounds(i2, (int)obj11, (int)f)) {
                                    if (this.I != null) {
                                        if (Float.compare(obj10, obj11) > 0) {
                                            i4 = i7;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return i4;
        }
        this.J = i7;
        return i4;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i3) {
        boolean z;
        boolean z2;
        int i;
        int gVar;
        WeakReference weakReference;
        c cVar;
        int top;
        float f;
        int i2;
        int cmp;
        int obj7;
        int obj9;
        final int i5 = 1;
        if (u.y(coordinatorLayout) && !u.y(v2)) {
            if (!u.y(v2)) {
                v2.setFitsSystemWindows(i5);
            }
        }
        final int i6 = 3;
        final int i7 = 0;
        this.g = coordinatorLayout.getResources().getDimensionPixelSize(d.h);
        b0(v2);
        WeakReference weakReference2 = new WeakReference(v2);
        this.P = weakReference2;
        z2 = this.j;
        if (this.P == null && this.i && z2 != null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(d.h);
            b0(v2);
            weakReference2 = new WeakReference(v2);
            this.P = weakReference2;
            if (this.i) {
                z2 = this.j;
                if (z2 != null) {
                    u.o0(v2, z2);
                }
            }
            gVar = this.j;
            if (gVar != null && Float.compare(f, i9) == 0) {
                if (Float.compare(f, i9) == 0) {
                    f = u.w(v2);
                }
                gVar.Y(f);
                i = this.H == i6 ? i5 : i7;
                this.v = i;
                gVar = i != 0 ? 0 : 1065353216;
                this.j.a0(gVar);
            }
            k0();
            if (u.z(v2) == 0) {
                u.v0(v2, i5);
            }
        }
        if (this.I == null) {
            this.I = c.m(coordinatorLayout, this.Y);
        }
        coordinatorLayout.onLayoutChild(v2, i3);
        this.N = coordinatorLayout.getWidth();
        this.O = coordinatorLayout.getHeight();
        obj7 = v2.getHeight();
        this.M = obj7;
        obj9 = this.O;
        int i8 = this.t;
        if (obj9 - obj7 < i8) {
            if (this.r) {
                this.M = obj9;
            } else {
                this.M = obj9 - i8;
            }
        }
        this.z = Math.max(i7, obj9 -= obj7);
        q();
        p();
        obj7 = this.H;
        if (obj7 == i6) {
            u.X(v2, A());
        } else {
            if (obj7 == 6) {
                u.X(v2, this.A);
            } else {
                if (this.E && obj7 == 5) {
                    if (obj7 == 5) {
                        u.X(v2, this.O);
                    } else {
                        if (obj7 == 4) {
                            u.X(v2, this.C);
                        } else {
                            if (obj7 != i5) {
                                if (obj7 == 2) {
                                    u.X(v2, top -= obj7);
                                }
                            } else {
                            }
                        }
                    }
                } else {
                }
            }
        }
        obj7 = new WeakReference(x(v2));
        this.Q = obj7;
        return i5;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v2, int i3, int i4, int i5, int i6) {
        final android.view.ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        v2.measure(z(i3, i7 += i4, this.k, layoutParams.width), z(i5, obj7 += i6, this.l, layoutParams.height));
        return 1;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v2, View view3, float f4, float f5) {
        boolean z;
        int i2;
        int i;
        CoordinatorLayout obj4;
        i2 = 0;
        z = this.Q;
        if (H() && z != null && view3 == z.get()) {
            z = this.Q;
            if (z != null) {
                if (view3 == z.get()) {
                    if (this.H == 3) {
                        if (super.onNestedPreFling(coordinatorLayout, v2, view3, f4, f5)) {
                            i2 = 1;
                        }
                    } else {
                    }
                }
            }
        }
        return i2;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v2, View view3, int i4, int i5, int[] i6Arr6, int i7) {
        int i;
        Object obj4;
        Object obj5;
        int obj8;
        final int obj2 = 1;
        if (i7 == obj2) {
        }
        obj5 = this.Q;
        if (obj5 != null) {
            obj5 = obj5.get();
        } else {
            obj5 = 0;
        }
        if (H() && view3 != obj5) {
            if (view3 != obj5) {
            }
        }
        obj5 = v2.getTop();
        obj8 = obj5 - i5;
        if (i5 > 0) {
            if (obj8 < A()) {
                i6Arr6[obj2] = obj5 -= obj4;
                u.X(v2, -obj4);
                a0(3);
            } else {
                if (!this.G) {
                }
                i6Arr6[obj2] = i5;
                u.X(v2, -i5);
                a0(obj2);
            }
        } else {
            if (i5 < 0 && !view3.canScrollVertically(-1)) {
                if (!view3.canScrollVertically(-1)) {
                    obj4 = this.C;
                    if (obj8 > obj4) {
                        if (this.E) {
                            if (!this.G) {
                            }
                            i6Arr6[obj2] = i5;
                            u.X(v2, -i5);
                            a0(obj2);
                        } else {
                            i6Arr6[obj2] = obj5 -= obj4;
                            u.X(v2, -obj4);
                            a0(4);
                        }
                    } else {
                    }
                }
            }
        }
        w(v2.getTop());
        this.K = i5;
        this.L = obj2;
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view3, int i4, int i5, int i6, int i7, int i8, int[] i9Arr9) {
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable3) {
        int obj2;
        int obj3;
        super.onRestoreInstanceState(coordinatorLayout, v2, (BottomSheetBehavior.g)parcelable3.a());
        L(parcelable3);
        obj2 = parcelable3.c;
        if (obj2 != 1) {
            if (obj2 == 2) {
                this.H = 4;
            } else {
                this.H = obj2;
            }
        } else {
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v2) {
        BottomSheetBehavior.g gVar = new BottomSheetBehavior.g(super.onSaveInstanceState(coordinatorLayout, v2), this);
        return gVar;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view3, View view4, int i5, int i6) {
        int obj1;
        obj1 = 0;
        this.K = obj1;
        this.L = obj1;
        if (i5 & 2 != 0) {
            obj1 = 1;
        }
        return obj1;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view3, int i4) {
        int i;
        int i2;
        WeakReference obj3;
        int obj5;
        int obj6;
        if (v2.getTop() == A()) {
            a0(3);
        }
        obj3 = this.Q;
        if (H() && obj3 != null && view3 == obj3.get() && !this.L) {
            obj3 = this.Q;
            if (obj3 != null) {
                if (view3 == obj3.get()) {
                    if (!this.L) {
                    }
                }
            }
        }
        obj5 = 6;
        if (this.K > 0) {
            if (this.b) {
                obj3 = this.z;
            } else {
                obj6 = this.A;
                if (v2.getTop() > obj6) {
                    i = obj5;
                    obj3 = obj6;
                } else {
                    obj3 = A();
                }
            }
        } else {
            if (this.E && g0(v2, E())) {
                if (g0(v2, E())) {
                    obj3 = this.O;
                    i = 5;
                } else {
                    if (this.K == 0) {
                        obj3 = v2.getTop();
                        if (this.b) {
                            if (Math.abs(obj3 - obj5) < Math.abs(obj3 -= i2)) {
                                obj3 = this.z;
                            } else {
                                obj3 = this.C;
                                i = obj6;
                            }
                        } else {
                            int i7 = this.A;
                            if (obj3 < i7) {
                                if (obj3 < Math.abs(obj3 - i8)) {
                                    obj3 = A();
                                } else {
                                    if (h0()) {
                                        obj3 = this.C;
                                    } else {
                                        obj3 = this.A;
                                        i = obj5;
                                    }
                                }
                            } else {
                                obj3 = Math.abs(obj3 - i7) < Math.abs(obj3 -= i2) ? this.A : this.C;
                            }
                        }
                    } else {
                        if (this.b) {
                            obj3 = this.C;
                        } else {
                        }
                    }
                }
            } else {
            }
        }
        obj5 = 0;
        j0(v2, i, obj3, obj5);
        this.L = obj5;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent3) {
        boolean z;
        VelocityTracker obtain;
        boolean actionIndex;
        int obj3;
        MotionEvent obj5;
        if (!v2.isShown()) {
            return 0;
        }
        obj3 = motionEvent3.getActionMasked();
        final int i3 = 1;
        if (this.H == i3 && obj3 == null) {
            if (obj3 == null) {
                return i3;
            }
        }
        if (f0()) {
            this.I.z(motionEvent3);
        }
        if (obj3 == null) {
            K();
        }
        if (this.S == null) {
            this.S = VelocityTracker.obtain();
        }
        this.S.addMovement(motionEvent3);
        if (f0() && obj3 == 2 && !this.J && Float.compare(obj3, actionIndex) > 0) {
            if (obj3 == 2) {
                if (!this.J) {
                    if (Float.compare(obj3, actionIndex) > 0) {
                        this.I.b(v2, motionEvent3.getPointerId(motionEvent3.getActionIndex()));
                    }
                }
            }
        }
        return obj3 ^= i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    void w(int i) {
        boolean empty;
        float f;
        int size;
        int i2;
        int obj4;
        Object obj = this.P.get();
        if ((View)obj != null && !this.R.isEmpty()) {
            if (!this.R.isEmpty()) {
                int i3 = this.C;
                if (i <= i3) {
                    if (i3 == A()) {
                        int i6 = this.C;
                        obj4 = (float)obj4;
                        f = (float)i2;
                    } else {
                        int i4 = this.C;
                        obj4 = (float)obj4;
                        f = (float)i5;
                    }
                } else {
                }
                empty = 0;
                while (empty < this.R.size()) {
                    (BottomSheetBehavior.f)this.R.get(empty).onSlide((View)obj, obj4 /= f);
                    empty++;
                }
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    View x(View view) {
        int i;
        int childCount;
        View view2;
        if (u.S(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            i = 0;
            while (i < (ViewGroup)view.getChildCount()) {
                view2 = x(view.getChildAt(i));
                i++;
            }
        }
        return null;
    }
}
