package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.g2.b;
import com.google.android.exoplayer2.g2.c;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.v1.d;
import com.google.android.exoplayer2.v1.e;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.x0;
import com.google.android.exoplayer2.y0;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class o extends FrameLayout {

    private final ImageView A;
    private final ImageView B;
    private final View C;
    private final TextView D;
    private final TextView E;
    private final com.google.android.exoplayer2.ui.z F = null;
    private final StringBuilder G;
    private final Formatter H;
    private final g2.b I;
    private final g2.c J;
    private final Runnable K;
    private final Runnable L;
    private final Drawable M;
    private final Drawable N;
    private final Drawable O;
    private final String P;
    private final String Q;
    private final String R;
    private final Drawable S;
    private final Drawable T;
    private final float U;
    private final float V;
    private final String W;
    private final com.google.android.exoplayer2.ui.o.c a;
    private final String a0;
    private final CopyOnWriteArrayList<com.google.android.exoplayer2.ui.o.e> b;
    private v1 b0;
    private final View c;
    private x0 c0;
    private com.google.android.exoplayer2.ui.o.d d0;
    private boolean e0;
    private boolean f0;
    private boolean g0;
    private boolean h0;
    private int i0 = 5000;
    private int j0 = 200;
    private int k0 = 0;
    private boolean l0 = true;
    private boolean m0 = true;
    private boolean n0 = true;
    private boolean o0 = true;
    private boolean p0 = false;
    private long q0 = -9223372036854775807L;
    private long[] r0;
    private boolean[] s0;
    private long[] t0;
    private boolean[] u0;
    private final View v;
    private long v0;
    private final View w;
    private long w0;
    private final View x;
    private long x0;
    private final View y;
    private final View z;

    static class a {
    }

    private static final class b {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    public interface d {
        public abstract void a(long l, long l2);
    }

    public interface e {
        public abstract void t(int i);
    }

    private final class c implements v1.e, com.google.android.exoplayer2.ui.z.a, View.OnClickListener {

        final com.google.android.exoplayer2.ui.o a;
        private c(com.google.android.exoplayer2.ui.o o) {
            this.a = o;
            super();
        }

        c(com.google.android.exoplayer2.ui.o o, com.google.android.exoplayer2.ui.o.a o$a2) {
            super(o);
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void D(com.google.android.exoplayer2.ui.z z, long l2, boolean z3) {
            Object obj2;
            v1 obj5;
            o.v(this.a, false);
            if (obj5 == null && o.c(this.a) != null) {
                if (o.c(this.a) != null) {
                    obj2 = this.a;
                    o.d(obj2, o.c(obj2), l2);
                }
            }
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void E(com.google.android.exoplayer2.ui.z z, long l2) {
            int i;
            Formatter formatter;
            TextView obj3;
            Object obj4;
            o.v(this.a, true);
            if (o.w(this.a) != null) {
                o.w(this.a).setText(p0.X(o.x(this.a), o.b(this.a), l2));
            }
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void onClick(View view) {
            View view2;
            int i;
            x0 obj4;
            v1 v1Var = o.c(this.a);
            if (v1Var == null) {
            }
            if (o.e(this.a) == view) {
                o.f(this.a).i(v1Var);
            } else {
                if (o.g(this.a) == view) {
                    o.f(this.a).h(v1Var);
                } else {
                    if (o.h(this.a) == view) {
                        if (v1Var.E() != 4) {
                            o.f(this.a).b(v1Var);
                        }
                    } else {
                        if (o.i(this.a) == view) {
                            o.f(this.a).d(v1Var);
                        } else {
                            if (o.j(this.a) == view) {
                                o.k(this.a, v1Var);
                            } else {
                                if (o.m(this.a) == view) {
                                    o.n(this.a, v1Var);
                                } else {
                                    if (o.o(this.a) == view) {
                                        o.f(this.a).a(v1Var, f0.a(v1Var.N(), o.p(this.a)));
                                    } else {
                                        if (o.q(this.a) == view) {
                                            o.f(this.a).f(v1Var, z ^= 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void p(v1 v1, v1.d v1$d2) {
            boolean z;
            boolean z3;
            boolean z4;
            boolean z2;
            boolean z5;
            boolean obj2;
            obj2 = 2;
            int[] iArr = new int[obj2];
            iArr = new int[]{5, 6};
            if (d2.b(iArr)) {
                o.a(this.a);
            }
            int[] iArr2 = new int[3];
            iArr2 = new int[]{5, 6, 8};
            if (d2.b(iArr2)) {
                o.l(this.a);
            }
            if (d2.a(9)) {
                o.r(this.a);
            }
            if (d2.a(10)) {
                o.s(this.a);
            }
            int[] iArr3 = new int[5];
            iArr3 = new int[]{9, 10, 12, 0, 14};
            if (d2.b(iArr3)) {
                o.t(this.a);
            }
            obj2 = new int[obj2];
            obj2 = new int[]{12, 0};
            if (d2.b(obj2)) {
                o.u(this.a);
            }
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void t(com.google.android.exoplayer2.ui.z z, long l2) {
            StringBuilder sb;
            Formatter formatter;
            TextView obj3;
            Object obj4;
            if (o.w(this.a) != null) {
                o.w(this.a).setText(p0.X(o.x(this.a), o.b(this.a), l2));
            }
        }
    }
    static {
        h1.a("goog.exo.ui");
    }

    public o(Context context, AttributeSet attributeSet2, int i3, AttributeSet attributeSet4) {
        int int;
        int i;
        View viewById;
        int obj6;
        int obj7;
        AttributeSet obj8;
        super(context, attributeSet2, i3);
        int i2 = 5000;
        int i4 = 0;
        int i5 = 200;
        long l = -9223372036854775807L;
        int = 1;
        if (attributeSet4 != null) {
            obj7 = context.getTheme().obtainStyledAttributes(attributeSet4, v.r, i3, i4);
            this.i0 = obj7.getInt(v.z, this.i0);
            obj6 = obj7.getResourceId(v.s, t.b);
            this.k0 = o.E(obj7, this.k0);
            this.l0 = obj7.getBoolean(v.x, this.l0);
            this.m0 = obj7.getBoolean(v.u, this.m0);
            this.n0 = obj7.getBoolean(v.w, this.n0);
            this.o0 = obj7.getBoolean(v.v, this.o0);
            this.p0 = obj7.getBoolean(v.y, this.p0);
            setTimeBarMinUpdateInterval(obj7.getInt(v.A, this.j0));
            obj7.recycle();
        }
        obj7 = new CopyOnWriteArrayList();
        this.b = obj7;
        obj7 = new g2.b();
        this.I = obj7;
        obj7 = new g2.c();
        this.J = obj7;
        obj7 = new StringBuilder();
        this.G = obj7;
        Formatter formatter = new Formatter(obj7, Locale.getDefault());
        this.H = formatter;
        this.r0 = new long[i4];
        this.s0 = new boolean[i4];
        this.t0 = new long[i4];
        this.u0 = new boolean[i4];
        int i6 = 0;
        obj7 = new o.c(this, i6);
        this.a = obj7;
        y0 y0Var = new y0();
        this.c0 = y0Var;
        d dVar = new d(this);
        this.K = dVar;
        a aVar = new a(this);
        this.L = aVar;
        LayoutInflater.from(context).inflate(obj6, this);
        setDescendantFocusability(262144);
        obj6 = r.p;
        viewById = findViewById(obj6);
        View viewById2 = findViewById(r.q);
        if ((z)viewById != null) {
            this.F = (z)viewById;
        } else {
            viewById = new l(context, i6, i4, attributeSet4);
            viewById.setId(obj6);
            viewById.setLayoutParams(viewById2.getLayoutParams());
            obj6 = viewById2.getParent();
            obj6.removeView(viewById2);
            obj6.addView(viewById, (ViewGroup)obj6.indexOfChild(viewById2));
            this.F = viewById;
        }
        this.D = (TextView)findViewById(r.g);
        this.E = (TextView)findViewById(r.n);
        obj6 = this.F;
        if (obj6 != null) {
            obj6.b(obj7);
        }
        obj6 = findViewById(r.m);
        this.w = obj6;
        if (obj6 != null) {
            obj6.setOnClickListener(obj7);
        }
        obj6 = findViewById(r.l);
        this.x = obj6;
        if (obj6 != null) {
            obj6.setOnClickListener(obj7);
        }
        obj6 = findViewById(r.o);
        this.c = obj6;
        if (obj6 != null) {
            obj6.setOnClickListener(obj7);
        }
        obj6 = findViewById(r.j);
        this.v = obj6;
        if (obj6 != null) {
            obj6.setOnClickListener(obj7);
        }
        obj6 = findViewById(r.s);
        this.z = obj6;
        if (obj6 != null) {
            obj6.setOnClickListener(obj7);
        }
        obj6 = findViewById(r.i);
        this.y = obj6;
        if (obj6 != null) {
            obj6.setOnClickListener(obj7);
        }
        obj6 = findViewById(r.r);
        this.A = (ImageView)obj6;
        if (obj6 != null) {
            obj6.setOnClickListener(obj7);
        }
        obj6 = findViewById(r.t);
        this.B = (ImageView)obj6;
        if (obj6 != null) {
            obj6.setOnClickListener(obj7);
        }
        obj6 = findViewById(r.w);
        this.C = obj6;
        setShowVrButton(i4);
        S(i4, i4, obj6);
        Resources obj5 = context.getResources();
        obj7 = 1120403456;
        this.U = obj6 /= obj7;
        this.V = obj6 /= obj7;
        this.M = obj5.getDrawable(q.b);
        this.N = obj5.getDrawable(q.c);
        this.O = obj5.getDrawable(q.a);
        this.S = obj5.getDrawable(q.e);
        this.T = obj5.getDrawable(q.d);
        this.P = obj5.getString(u.c);
        this.Q = obj5.getString(u.d);
        this.R = obj5.getString(u.b);
        this.W = obj5.getString(u.g);
        this.a0 = obj5.getString(u.f);
    }

    private void B(v1 v1) {
        this.c0.k(v1, false);
    }

    private void C(v1 v1) {
        x0 i;
        int i2;
        i = v1.E();
        final int i3 = 1;
        if (i == i3) {
            this.c0.g(v1);
        } else {
            if (i == 4) {
                N(v1, v1.x(), -9223372036854775807L);
            }
        }
        this.c0.k(v1, i3);
    }

    private void D(v1 v1) {
        int i;
        int i2;
        i = v1.E();
        if (i != 1 && i != 4) {
            if (i != 4) {
                if (!v1.l()) {
                    C(v1);
                } else {
                    B(v1);
                }
            } else {
            }
        } else {
        }
    }

    private static int E(TypedArray typedArray, int i2) {
        return typedArray.getInt(v.t, i2);
    }

    private void G() {
        long l;
        long l3;
        int i;
        long l2;
        removeCallbacks(this.L);
        if (this.i0 > 0) {
            i = this.i0;
            this.q0 = uptimeMillis += l2;
            if (this.e0) {
                postDelayed(this.L, (long)i);
            }
        } else {
            this.q0 = -9223372036854775807L;
        }
    }

    private static boolean H(int i) {
        int i2;
        int obj1;
        if (i != 90 && i != 89 && i != 85 && i != 79 && i != 126 && i != 127 && i != 87) {
            if (i != 89) {
                if (i != 85) {
                    if (i != 79) {
                        if (i != 126) {
                            if (i != 127) {
                                if (i != 87) {
                                    if (i == 88) {
                                        obj1 = 1;
                                    } else {
                                        obj1 = 0;
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
        return obj1;
    }

    public static void J(com.google.android.exoplayer2.ui.o o) {
        o.V();
    }

    private void L() {
        boolean z;
        View view;
        z = P();
        final int i = 8;
        view = this.w;
        if (!z && view != null) {
            view = this.w;
            if (view != null) {
                view.sendAccessibilityEvent(i);
            } else {
                z = this.x;
                if (z && z != null) {
                    z = this.x;
                    if (z != null) {
                        z.sendAccessibilityEvent(i);
                    }
                }
            }
        } else {
        }
    }

    private void M() {
        boolean z;
        View view;
        z = P();
        view = this.w;
        if (!z && view != null) {
            view = this.w;
            if (view != null) {
                view.requestFocus();
            } else {
                z = this.x;
                if (z && z != null) {
                    z = this.x;
                    if (z != null) {
                        z.requestFocus();
                    }
                }
            }
        } else {
        }
    }

    private boolean N(v1 v1, int i2, long l3) {
        return this.c0.e(v1, i2, l3);
    }

    private void O(v1 v1, long l2) {
        int z;
        int i;
        long l;
        int cmp;
        long obj8;
        final g2 g2Var = v1.O();
        if (this.g0 && !g2Var.q()) {
            if (!g2Var.q()) {
                i = 0;
                l = g2Var.n(i, this.J).d();
                while (Long.compare(obj8, l) < 0) {
                    obj8 -= l;
                    i++;
                    l = g2Var.n(i, this.J).d();
                }
            } else {
                i = v1.x();
            }
        } else {
        }
        N(v1, i, obj8);
        V();
    }

    private boolean P() {
        v1 v1Var;
        int i;
        int i2;
        v1Var = this.b0;
        if (v1Var != null && v1Var.E() != 4 && this.b0.E() != 1 && this.b0.l()) {
            if (v1Var.E() != 4) {
                if (this.b0.E() != 1) {
                    if (this.b0.l()) {
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private void R() {
        U();
        T();
        W();
        X();
        Y();
    }

    private void S(boolean z, boolean z2, View view3) {
        int obj1;
        float obj2;
        if (view3 == null) {
        }
        view3.setEnabled(z2);
        obj2 = z2 ? this.U : this.V;
        view3.setAlpha(obj2);
        obj1 = z ? 0 : 8;
        view3.setVisibility(obj1);
    }

    private void T() {
        int i;
        boolean z;
        int i6;
        View view;
        int i4;
        int i3;
        boolean z3;
        int i5;
        View view2;
        int i2;
        boolean z2;
        boolean z4;
        if (I()) {
            if (!this.e0) {
            } else {
                v1 v1Var = this.b0;
                i6 = 0;
                if (v1Var != null) {
                    int i10 = 1;
                    if (v1Var.I(10) && this.c0.c()) {
                        i5 = this.c0.c() ? i10 : i6;
                    } else {
                    }
                    if (v1Var.I(11) && this.c0.j()) {
                        if (this.c0.j()) {
                            i6 = i10;
                        }
                    }
                    i4 = z5;
                    i = i6;
                    i6 = z10;
                    i3 = z4;
                } else {
                    i5 = i3;
                }
                S(this.n0, i6, this.c);
                S(this.l0, i5, this.z);
                S(this.m0, i, this.y);
                S(this.o0, i4, this.v);
                z = this.F;
                if (z != null) {
                    z.setEnabled(i3);
                }
            }
        }
    }

    private void U() {
        boolean z;
        int i10;
        int i9;
        View focused;
        int i3;
        int i4;
        int i2;
        int i7;
        int i11;
        int i8;
        int i5;
        View focused2;
        int i6;
        int i;
        if (I()) {
            if (!this.e0) {
            } else {
                z = P();
                focused = this.w;
                i4 = 21;
                i2 = 1;
                i7 = 0;
                if (focused != null) {
                    if (z && focused.isFocused()) {
                        i9 = focused.isFocused() ? i2 : i7;
                    } else {
                    }
                    if (p0.a < i4) {
                        i8 = i10;
                    } else {
                        if (z && o.b.a(this.w)) {
                            i8 = o.b.a(this.w) ? i2 : i7;
                        } else {
                        }
                    }
                    i8 |= i7;
                    i = z ? i3 : i7;
                    this.w.setVisibility(i);
                } else {
                    i11 = i10;
                }
                focused2 = this.x;
                if (focused2 != null) {
                    if (!z && focused2.isFocused()) {
                        i6 = focused2.isFocused() ? i2 : i7;
                    } else {
                    }
                    if (p0.a < i4) {
                        i2 = i10;
                    } else {
                        if (!z && o.b.a(this.x)) {
                            if (o.b.a(this.x)) {
                            } else {
                                i2 = i7;
                            }
                        } else {
                        }
                    }
                    i11 |= i2;
                    if (z) {
                        i3 = i7;
                    }
                    this.x.setVisibility(i3);
                }
                if (i10 != 0) {
                    M();
                }
                if (i11 != 0) {
                    L();
                }
            }
        }
    }

    private void V() {
        boolean z2;
        int i;
        long runnable;
        int i3;
        int cmp;
        int i5;
        long l;
        int i2;
        int preferredUpdateDelay;
        int i4;
        com.google.android.exoplayer2.ui.z zVar;
        long dVar;
        boolean z;
        Formatter formatter;
        if (I()) {
            if (!this.e0) {
            } else {
                v1 v1Var = this.b0;
                if (v1Var != null) {
                    l2 += l3;
                    l4 += l;
                } else {
                    i3 = i;
                }
                i4 = 1;
                l = Long.compare(i, l5) != 0 ? i4 : i2;
                if (Long.compare(i3, l6) != 0) {
                    i2 = i4;
                }
                this.w0 = i;
                this.x0 = i3;
                TextView view = this.E;
                if (view != null && !this.h0 && l != 0) {
                    if (!this.h0) {
                        if (l != 0) {
                            view.setText(p0.X(this.G, this.H, i));
                        }
                    }
                }
                zVar = this.F;
                if (zVar != null) {
                    zVar.setPosition(i);
                    this.F.setBufferedPosition(i3);
                }
                dVar = this.d0;
                if (dVar != null) {
                    if (l == 0) {
                        if (i2 != 0) {
                            dVar.a(i, obj2);
                        }
                    } else {
                    }
                }
                removeCallbacks(this.K);
                if (v1Var == null) {
                    cmp = i4;
                } else {
                    cmp = v1Var.E();
                }
                i5 = 1000;
                if (v1Var != null && v1Var.F()) {
                    if (v1Var.F()) {
                        com.google.android.exoplayer2.ui.z zVar2 = this.F;
                        if (zVar2 != null) {
                            preferredUpdateDelay = zVar2.getPreferredUpdateDelay();
                        } else {
                            preferredUpdateDelay = i5;
                        }
                        float f = u1Var.a;
                        if (Float.compare(f, i9) > 0) {
                            i5 = (long)i;
                        }
                        postDelayed(this.K, p0.q(i5, i4, (long)i6));
                    } else {
                        if (cmp != 4 && cmp != i4) {
                            if (cmp != i4) {
                                postDelayed(this.K, i5);
                            }
                        }
                    }
                } else {
                }
            }
        }
    }

    private void W() {
        ImageView i2;
        boolean z;
        String str;
        int i3;
        int i;
        if (I() && this.e0) {
            if (this.e0) {
                z = this.A;
                if (z == null) {
                } else {
                    i3 = 0;
                    if (this.k0 == 0) {
                        S(i3, i3, z);
                    }
                    v1 v1Var = this.b0;
                    i = 1;
                    if (v1Var == null) {
                        S(i, i3, z);
                        this.A.setImageDrawable(this.M);
                        this.A.setContentDescription(this.P);
                    }
                    S(i, i, z);
                    i2 = v1Var.N();
                    if (i2 != 0) {
                        if (i2 != i) {
                            if (i2 != 2) {
                            } else {
                                this.A.setImageDrawable(this.O);
                                this.A.setContentDescription(this.R);
                            }
                        } else {
                            this.A.setImageDrawable(this.N);
                            this.A.setContentDescription(this.Q);
                        }
                    } else {
                        this.A.setImageDrawable(this.M);
                        this.A.setContentDescription(this.P);
                    }
                    this.A.setVisibility(i3);
                }
            }
        }
    }

    private void X() {
        boolean z;
        String v1Var;
        Drawable z2;
        int i;
        if (I() && this.e0) {
            if (this.e0) {
                z = this.B;
                if (z == null) {
                } else {
                    v1Var = this.b0;
                    i = 0;
                    if (!this.p0) {
                        S(i, i, z);
                    } else {
                        z2 = 1;
                        if (v1Var == null) {
                            S(z2, i, z);
                            this.B.setImageDrawable(this.T);
                            this.B.setContentDescription(this.a0);
                        } else {
                            S(z2, z2, z);
                            z2 = v1Var.Q() ? this.S : this.T;
                            this.B.setImageDrawable(z2);
                            v1Var = v1Var.Q() ? this.W : this.a0;
                            this.B.setContentDescription(v1Var);
                        }
                    }
                }
            }
        }
    }

    private void Y() {
        int v1Var;
        long l3;
        int i3;
        g2 g2Var;
        boolean z;
        long cmp3;
        long[] copyOf2;
        com.google.android.exoplayer2.ui.z zVar;
        long[] copyOf;
        int i6;
        g2.b cmp;
        int length;
        g2.c cVar2;
        int i;
        int z2;
        int i2;
        int i7;
        int i5;
        g2.c cVar;
        int cmp4;
        int i4;
        long l;
        int cmp2;
        long l2;
        long l4;
        final Object obj = this;
        v1Var = obj.b0;
        if (v1Var == null) {
        }
        i6 = 1;
        if (obj.f0 && o.z(v1Var.O(), obj.J)) {
            i3 = o.z(v1Var.O(), obj.J) ? i6 : 0;
        } else {
        }
        obj.g0 = i3;
        i = 0;
        obj.v0 = i;
        g2Var = v1Var.O();
        if (!g2Var.q()) {
            v1Var = v1Var.x();
            boolean z4 = obj.g0;
            i2 = z4 ? 0 : v1Var;
            if (z4) {
                i8 -= i6;
            } else {
                z2 = v1Var;
            }
            i7 = i;
            i5 = 0;
            while (i2 <= z2) {
                if (i2 == v1Var) {
                }
                g2Var.n(i2, obj.J);
                cVar = obj.J;
                l = -9223372036854775807L;
                if (Long.compare(l6, l) == 0) {
                    break;
                } else {
                }
                cVar = cVar.o;
                cmp4 = obj.J;
                while (cVar <= cmp4.p) {
                    g2Var.f(cVar, obj.I);
                    cmp4 = obj.I.n();
                    while (cmp4 < obj.I.c()) {
                        if (Long.compare(l2, l4) == 0) {
                        } else {
                        }
                        l2 += l5;
                        copyOf = obj.r0;
                        if (Long.compare(cmp2, i) >= 0 && i5 == copyOf.length) {
                        }
                        cmp4++;
                        i6 = 1;
                        copyOf = obj.r0;
                        if (i5 == copyOf.length) {
                        }
                        obj.r0[i5] = w0.e(cmp2 += i7);
                        obj.s0[i5] = obj.I.o(cmp4);
                        i5++;
                        if (copyOf.length == 0) {
                        } else {
                        }
                        length5 *= 2;
                        obj.r0 = Arrays.copyOf(copyOf, length);
                        obj.s0 = Arrays.copyOf(obj.s0, length);
                        length = 1;
                        cmp3 = cmp.d;
                        if (Long.compare(cmp3, l) == 0) {
                        } else {
                        }
                        l2 = cmp3;
                    }
                    cVar++;
                    i6 = 1;
                    cmp4 = obj.J;
                    if (Long.compare(l2, l4) == 0) {
                    } else {
                    }
                    l2 += l5;
                    copyOf = obj.r0;
                    if (Long.compare(cmp2, i) >= 0 && i5 == copyOf.length) {
                    }
                    cmp4++;
                    i6 = 1;
                    copyOf = obj.r0;
                    if (i5 == copyOf.length) {
                    }
                    obj.r0[i5] = w0.e(cmp2 += i7);
                    obj.s0[i5] = obj.I.o(cmp4);
                    i5++;
                    if (copyOf.length == 0) {
                    } else {
                    }
                    length5 *= 2;
                    obj.r0 = Arrays.copyOf(copyOf, length);
                    obj.s0 = Arrays.copyOf(obj.s0, length);
                    length = 1;
                    cmp3 = cmp.d;
                    if (Long.compare(cmp3, l) == 0) {
                    } else {
                    }
                    l2 = cmp3;
                }
                i7 += cmp3;
                i2++;
                i6 = 1;
                g2Var.f(cVar, obj.I);
                cmp4 = obj.I.n();
                while (cmp4 < obj.I.c()) {
                    if (Long.compare(l2, l4) == 0) {
                    } else {
                    }
                    l2 += l5;
                    copyOf = obj.r0;
                    if (Long.compare(cmp2, i) >= 0 && i5 == copyOf.length) {
                    }
                    cmp4++;
                    i6 = 1;
                    copyOf = obj.r0;
                    if (i5 == copyOf.length) {
                    }
                    obj.r0[i5] = w0.e(cmp2 += i7);
                    obj.s0[i5] = obj.I.o(cmp4);
                    i5++;
                    if (copyOf.length == 0) {
                    } else {
                    }
                    length5 *= 2;
                    obj.r0 = Arrays.copyOf(copyOf, length);
                    obj.s0 = Arrays.copyOf(obj.s0, length);
                    length = 1;
                    cmp3 = cmp.d;
                    if (Long.compare(cmp3, l) == 0) {
                    } else {
                    }
                    l2 = cmp3;
                }
                cVar++;
                i6 = 1;
                if (Long.compare(l2, l4) == 0) {
                } else {
                }
                l2 += l5;
                copyOf = obj.r0;
                if (Long.compare(cmp2, i) >= 0 && i5 == copyOf.length) {
                }
                cmp4++;
                i6 = 1;
                copyOf = obj.r0;
                if (i5 == copyOf.length) {
                }
                obj.r0[i5] = w0.e(cmp2 += i7);
                obj.s0[i5] = obj.I.o(cmp4);
                i5++;
                if (copyOf.length == 0) {
                } else {
                }
                length5 *= 2;
                obj.r0 = Arrays.copyOf(copyOf, length);
                obj.s0 = Arrays.copyOf(obj.s0, length);
                length = 1;
                cmp3 = cmp.d;
                if (Long.compare(cmp3, l) == 0) {
                } else {
                }
                l2 = cmp3;
                obj.v0 = w0.e(i7);
            }
            i = i7;
        } else {
            i5 = 0;
        }
        l3 = w0.e(i);
        TextView view = obj.D;
        if (view != null) {
            view.setText(p0.X(obj.G, obj.H, l3));
        }
        zVar = obj.F;
        zVar.setDuration(l3);
        int length2 = lArr.length;
        g2Var = i5 + length2;
        copyOf2 = obj.r0;
        if (zVar != null && g2Var > copyOf2.length) {
            zVar.setDuration(l3);
            length2 = lArr.length;
            g2Var = i5 + length2;
            copyOf2 = obj.r0;
            if (g2Var > copyOf2.length) {
                obj.r0 = Arrays.copyOf(copyOf2, g2Var);
                obj.s0 = Arrays.copyOf(obj.s0, g2Var);
            }
            i = 0;
            System.arraycopy(obj.t0, i, obj.r0, i5, length2);
            System.arraycopy(obj.u0, i, obj.s0, i5, length2);
            obj.F.a(obj.r0, obj.s0, g2Var);
        }
        V();
    }

    static void a(com.google.android.exoplayer2.ui.o o) {
        o.U();
    }

    static Formatter b(com.google.android.exoplayer2.ui.o o) {
        return o.H;
    }

    static v1 c(com.google.android.exoplayer2.ui.o o) {
        return o.b0;
    }

    static void d(com.google.android.exoplayer2.ui.o o, v1 v12, long l3) {
        o.O(v12, l3);
    }

    static View e(com.google.android.exoplayer2.ui.o o) {
        return o.v;
    }

    static x0 f(com.google.android.exoplayer2.ui.o o) {
        return o.c0;
    }

    static View g(com.google.android.exoplayer2.ui.o o) {
        return o.c;
    }

    static View h(com.google.android.exoplayer2.ui.o o) {
        return o.y;
    }

    static View i(com.google.android.exoplayer2.ui.o o) {
        return o.z;
    }

    static View j(com.google.android.exoplayer2.ui.o o) {
        return o.w;
    }

    static void k(com.google.android.exoplayer2.ui.o o, v1 v12) {
        o.C(v12);
    }

    static void l(com.google.android.exoplayer2.ui.o o) {
        o.V();
    }

    static View m(com.google.android.exoplayer2.ui.o o) {
        return o.x;
    }

    static void n(com.google.android.exoplayer2.ui.o o, v1 v12) {
        o.B(v12);
    }

    static ImageView o(com.google.android.exoplayer2.ui.o o) {
        return o.A;
    }

    static int p(com.google.android.exoplayer2.ui.o o) {
        return o.k0;
    }

    static ImageView q(com.google.android.exoplayer2.ui.o o) {
        return o.B;
    }

    static void r(com.google.android.exoplayer2.ui.o o) {
        o.W();
    }

    static void s(com.google.android.exoplayer2.ui.o o) {
        o.X();
    }

    static void t(com.google.android.exoplayer2.ui.o o) {
        o.T();
    }

    static void u(com.google.android.exoplayer2.ui.o o) {
        o.Y();
    }

    static boolean v(com.google.android.exoplayer2.ui.o o, boolean z2) {
        o.h0 = z2;
        return z2;
    }

    static TextView w(com.google.android.exoplayer2.ui.o o) {
        return o.E;
    }

    static StringBuilder x(com.google.android.exoplayer2.ui.o o) {
        return o.G;
    }

    private static boolean z(g2 g2, g2.c g2$c2) {
        int i;
        int cmp;
        long l;
        final int i4 = 0;
        if (g2.p() > 100) {
            return i4;
        }
        i = i4;
        while (i < g2.p()) {
            i++;
        }
        return 1;
    }

    @Override // android.widget.FrameLayout
    public boolean A(KeyEvent keyEvent) {
        int keyCode;
        int action;
        boolean z;
        int obj4;
        keyCode = keyEvent.getKeyCode();
        final v1 v1Var = this.b0;
        if (v1Var != null) {
            if (!o.H(keyCode)) {
            } else {
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 90) {
                        if (v1Var.E() != 4) {
                            this.c0.b(v1Var);
                        }
                    } else {
                        if (keyCode == 89) {
                            this.c0.d(v1Var);
                        } else {
                            if (keyEvent.getRepeatCount() == 0) {
                                if (keyCode != 79 && keyCode != 85) {
                                    if (keyCode != 85) {
                                        if (keyCode != 87) {
                                            if (keyCode != 88) {
                                                if (keyCode != 126) {
                                                    if (keyCode != 127) {
                                                    } else {
                                                        B(v1Var);
                                                    }
                                                } else {
                                                    C(v1Var);
                                                }
                                            } else {
                                                this.c0.h(v1Var);
                                            }
                                        } else {
                                            this.c0.i(v1Var);
                                        }
                                    } else {
                                        D(v1Var);
                                    }
                                } else {
                                }
                            }
                        }
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout
    public void F() {
        boolean z;
        boolean next;
        int visibility;
        if (I()) {
            setVisibility(8);
            Iterator iterator = this.b.iterator();
            for (o.e next : iterator) {
                next.t(getVisibility());
            }
            removeCallbacks(this.K);
            removeCallbacks(this.L);
            this.q0 = -9223372036854775807L;
        }
    }

    @Override // android.widget.FrameLayout
    public boolean I() {
        int i;
        i = getVisibility() == 0 ? 1 : 0;
        return i;
    }

    @Override // android.widget.FrameLayout
    public void K(com.google.android.exoplayer2.ui.o.e o$e) {
        this.b.remove(e);
    }

    @Override // android.widget.FrameLayout
    public void Q() {
        boolean iterator;
        boolean next;
        int visibility;
        if (!I()) {
            setVisibility(0);
            iterator = this.b.iterator();
            for (o.e next : iterator) {
                next.t(getVisibility());
            }
            R();
            M();
            L();
        }
        G();
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int obj2;
        if (!A(keyEvent)) {
            if (super.dispatchKeyEvent(keyEvent)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.widget.FrameLayout
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Runnable action;
        int i;
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.L);
        } else {
            if (motionEvent.getAction() == 1) {
                G();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout
    public v1 getPlayer() {
        return this.b0;
    }

    @Override // android.widget.FrameLayout
    public int getRepeatToggleModes() {
        return this.k0;
    }

    @Override // android.widget.FrameLayout
    public boolean getShowShuffleButton() {
        return this.p0;
    }

    @Override // android.widget.FrameLayout
    public int getShowTimeoutMs() {
        return this.i0;
    }

    @Override // android.widget.FrameLayout
    public boolean getShowVrButton() {
        View visibility;
        int i;
        visibility = this.C;
        if (visibility != null && visibility.getVisibility() == 0) {
            i = visibility.getVisibility() == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.widget.FrameLayout
    public void onAttachedToWindow() {
        int i;
        Runnable cmp;
        super.onAttachedToWindow();
        this.e0 = true;
        long l = this.q0;
        if (Long.compare(l, l2) != 0) {
            l -= uptimeMillis;
            if (Long.compare(i, i3) <= 0) {
                F();
            } else {
                postDelayed(this.L, i);
            }
        } else {
            if (I()) {
                G();
            }
        }
        R();
    }

    @Override // android.widget.FrameLayout
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e0 = false;
        removeCallbacks(this.K);
        removeCallbacks(this.L);
    }

    @Deprecated
    public void setControlDispatcher(x0 x0) {
        if (this.c0 != x0) {
            this.c0 = x0;
            T();
        }
    }

    @Override // android.widget.FrameLayout
    public void setPlayer(v1 v1) {
        int i;
        Object v1Var;
        Looper mainLooper;
        int i2;
        final int i3 = 0;
        i = Looper.myLooper() == Looper.getMainLooper() ? i2 : i3;
        g.f(i);
        if (v1 != null) {
            if (v1.P() == Looper.getMainLooper()) {
            } else {
                i2 = i3;
            }
        }
        g.a(i2);
        v1Var = this.b0;
        if (v1Var == v1) {
        }
        if (v1Var != null) {
            v1Var.t(this.a);
        }
        this.b0 = v1;
        if (v1 != null) {
            v1.D(this.a);
        }
        R();
    }

    @Override // android.widget.FrameLayout
    public void setProgressUpdateListener(com.google.android.exoplayer2.ui.o.d o$d) {
        this.d0 = d;
    }

    @Override // android.widget.FrameLayout
    public void setRepeatToggleModes(int i) {
        v1 v1Var;
        int i2;
        int i3;
        int obj4;
        this.k0 = i;
        v1Var = this.b0;
        if (v1Var != null) {
            v1Var = v1Var.N();
            if (i == 0 && v1Var != 0) {
                if (v1Var != 0) {
                    this.c0.a(this.b0, 0);
                } else {
                    i2 = 2;
                    i3 = 1;
                    if (i == i3 && v1Var == i2) {
                        if (v1Var == i2) {
                            this.c0.a(this.b0, i3);
                        } else {
                            if (i == i2 && v1Var == i3) {
                                if (v1Var == i3) {
                                    this.c0.a(this.b0, i2);
                                }
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        W();
    }

    @Override // android.widget.FrameLayout
    public void setShowFastForwardButton(boolean z) {
        this.m0 = z;
        T();
    }

    @Override // android.widget.FrameLayout
    public void setShowMultiWindowTimeBar(boolean z) {
        this.f0 = z;
        Y();
    }

    @Override // android.widget.FrameLayout
    public void setShowNextButton(boolean z) {
        this.o0 = z;
        T();
    }

    @Override // android.widget.FrameLayout
    public void setShowPreviousButton(boolean z) {
        this.n0 = z;
        T();
    }

    @Override // android.widget.FrameLayout
    public void setShowRewindButton(boolean z) {
        this.l0 = z;
        T();
    }

    @Override // android.widget.FrameLayout
    public void setShowShuffleButton(boolean z) {
        this.p0 = z;
        X();
    }

    @Override // android.widget.FrameLayout
    public void setShowTimeoutMs(int i) {
        this.i0 = i;
        if (I()) {
            G();
        }
    }

    @Override // android.widget.FrameLayout
    public void setShowVrButton(boolean z) {
        int obj2;
        final View view = this.C;
        if (view != null) {
            obj2 = z != 0 ? 0 : 8;
            view.setVisibility(obj2);
        }
    }

    @Override // android.widget.FrameLayout
    public void setTimeBarMinUpdateInterval(int i) {
        this.j0 = p0.p(i, 16, 1000);
    }

    @Override // android.widget.FrameLayout
    public void setVrButtonListener(View.OnClickListener view$OnClickListener) {
        View showVrButton;
        View view;
        int obj3;
        showVrButton = this.C;
        if (showVrButton != null) {
            showVrButton.setOnClickListener(onClickListener);
            obj3 = onClickListener != null ? 1 : 0;
            S(getShowVrButton(), obj3, this.C);
        }
    }

    @Override // android.widget.FrameLayout
    public void y(com.google.android.exoplayer2.ui.o.e o$e) {
        g.e(e);
        this.b.add(e);
    }
}
