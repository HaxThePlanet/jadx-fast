package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import d.h.h.a;
import d.h.j.e;
import d.h.j.f;
import d.h.k.i;
import d.h.l.e;
import d.h.l.u;
import f.c.a.e.a0.a;
import f.c.a.e.a0.a.a;
import f.c.a.e.a0.d;
import f.c.a.e.m.a;

/* loaded from: classes2.dex */
public final class a {

    private static final boolean k0 = false;
    private static final Paint l0 = null;
    private a A;
    private java.lang.CharSequence B;
    private java.lang.CharSequence C;
    private boolean D;
    private boolean E = true;
    private boolean F;
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private int[] K;
    private boolean L;
    private final TextPaint M;
    private final TextPaint N;
    private TimeInterpolator O;
    private TimeInterpolator P;
    private float Q;
    private float R;
    private float S;
    private ColorStateList T;
    private float U;
    private float V;
    private float W;
    private ColorStateList X;
    private float Y;
    private float Z;
    private final View a;
    private StaticLayout a0;
    private boolean b;
    private float b0;
    private float c;
    private float c0;
    private boolean d;
    private float d0;
    private float e;
    private float e0;
    private float f;
    private java.lang.CharSequence f0;
    private int g;
    private int g0 = 1;
    private final Rect h;
    private float h0 = 0f;
    private final Rect i;
    private float i0 = 1f;
    private final RectF j;
    private int j0 = 1065353216;
    private int k = 16;
    private int l = 16;
    private float m = 15f;
    private float n = 15f;
    private ColorStateList o;
    private ColorStateList p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private Typeface w;
    private Typeface x;
    private Typeface y;
    private a z;

    class a implements a.a {

        final com.google.android.material.internal.a a;
        a(com.google.android.material.internal.a a) {
            this.a = a;
            super();
        }

        @Override // f.c.a.e.a0.a$a
        public void a(Typeface typeface) {
            this.a.Q(typeface);
        }
    }
    static {
        int i;
        i = 1;
        if (Build.VERSION.SDK_INT < 18) {
            int i2 = i;
        }
        int i3 = 0;
        int i4 = 0;
        if (i4 != 0) {
            i4.setAntiAlias(i);
            i4.setColor(-65281);
        }
    }

    public a(View view) {
        super();
        int i = 16;
        int i2 = 1097859072;
        int i3 = 1;
        int i4 = 0;
        int i5 = 1065353216;
        int i6 = h.n;
        this.a = view;
        TextPaint obj2 = new TextPaint(129);
        this.M = obj2;
        TextPaint textPaint = new TextPaint(obj2);
        this.N = textPaint;
        obj2 = new Rect();
        this.i = obj2;
        obj2 = new Rect();
        this.h = obj2;
        obj2 = new RectF();
        this.j = obj2;
        this.f = e();
    }

    private void A(float f) {
        RectF rectF;
        float f2;
        float f3;
        TimeInterpolator time;
        Rect obj5;
        if (this.d) {
            obj5 = Float.compare(f, f2) < 0 ? this.h : this.i;
            this.j.set(obj5);
        } else {
            rectF2.left = a.F((float)left, (float)left2, f, this.O);
            rectF3.top = a.F(this.q, this.r, f, this.O);
            rectF4.right = a.F((float)right, (float)right2, f, this.O);
            rectF.bottom = a.F((float)bottom, (float)bottom2, f, this.O);
        }
    }

    private static boolean B(float f, float f2) {
        int obj0;
        obj0 = Float.compare(obj0, obj1) < 0 ? 1 : 0;
        return obj0;
    }

    private boolean C() {
        int i;
        if (u.B(this.a) == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private boolean E(java.lang.CharSequence charSequence, boolean z2) {
        e obj4;
        obj4 = z2 ? f.d : f.c;
        return obj4.a(charSequence, 0, charSequence.length());
    }

    private static float F(float f, float f2, float f3, TimeInterpolator timeInterpolator4) {
        float obj2;
        if (timeInterpolator4 != null) {
            obj2 = timeInterpolator4.getInterpolation(f3);
        }
        return a.a(f, f2, obj2);
    }

    private static boolean J(Rect rect, int i2, int i3, int i4, int i5) {
        Object obj1;
        int obj2;
        if (rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5) {
            if (rect.top == i3) {
                if (rect.right == i4) {
                    obj1 = rect.bottom == i5 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private void N(float f) {
        this.c0 = f;
        u.c0(this.a);
    }

    private boolean R(Typeface typeface) {
        a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        if (this.w != typeface) {
            this.w = typeface;
            return 1;
        }
        return 0;
    }

    private void U(float f) {
        this.d0 = f;
        u.c0(this.a);
    }

    private boolean Y(Typeface typeface) {
        a aVar = this.z;
        if (aVar != null) {
            aVar.c();
        }
        if (this.x != typeface) {
            this.x = typeface;
            return 1;
        }
        return 0;
    }

    private static int a(int i, int i2, float f3) {
        i3 -= f3;
        return Color.argb((int)i7, (int)i11, (int)i15, (int)obj5);
    }

    private void a0(float f) {
        int i;
        boolean obj2;
        h(f);
        if (a.k0 && Float.compare(obj2, i) != 0) {
            obj2 = Float.compare(obj2, i) != 0 ? 1 : 0;
        } else {
        }
        this.F = obj2;
        if (obj2 != null) {
            n();
        }
        u.c0(this.a);
    }

    private void b(boolean z) {
        java.lang.CharSequence ellipsize;
        float measureText;
        float f;
        int measureText2;
        StaticLayout staticLayout;
        int lineStart;
        TextPaint textPaint;
        int lineLeft;
        int i;
        TextUtils.TruncateAt eND;
        int i2;
        int sDK_INT;
        int length;
        float ascent;
        float f2;
        int length2;
        int obj13;
        i(this.n, z);
        ellipsize = this.C;
        staticLayout = this.a0;
        if (ellipsize != null && staticLayout != null) {
            staticLayout = this.a0;
            if (staticLayout != null) {
                this.f0 = TextUtils.ellipsize(ellipsize, this.M, (float)width2, TextUtils.TruncateAt.END);
            }
        }
        lineStart = 0;
        lineLeft = 0;
        if (this.f0 != null) {
            TextPaint textPaint2 = new TextPaint(this.M);
            if (Build.VERSION.SDK_INT >= 21) {
                textPaint2.setLetterSpacing(this.Y);
            }
            eND = this.f0;
            this.b0 = textPaint2.measureText(eND, lineStart, eND.length());
        } else {
            this.b0 = lineLeft;
        }
        int i4 = e.b(this.l, this.D);
        int i10 = i4 & 112;
        int i13 = 80;
        final int i15 = 48;
        final int i16 = 1073741824;
        if (i10 != i15) {
            if (i10 != i13) {
                this.r = f11 -= i2;
            } else {
                this.r = f10 += ascent;
            }
        } else {
            this.r = (float)top;
        }
        int i12 = 8388615;
        i4 &= i12;
        int i17 = 5;
        final int i18 = 1;
        if (i5 != i18) {
            if (i5 != i17) {
                this.t = (float)left;
            } else {
                this.t = f6 -= f2;
            }
        } else {
            this.t = f7 -= f2;
        }
        i(this.m, z);
        obj13 = this.a0;
        if (obj13 != null) {
            obj13 = (float)obj13;
        } else {
            obj13 = lineLeft;
        }
        StaticLayout staticLayout2 = this.a0;
        if (staticLayout2 != null) {
            staticLayout2.getLineCount();
        }
        java.lang.CharSequence charSequence = this.C;
        if (charSequence != null) {
            measureText2 = this.M.measureText(charSequence, lineStart, charSequence.length());
        } else {
            measureText2 = lineLeft;
        }
        StaticLayout staticLayout3 = this.a0;
        if (staticLayout3 != null && this.g0 > i18) {
            if (this.g0 > i18) {
                measureText2 = (float)width;
            }
        }
        StaticLayout staticLayout4 = this.a0;
        if (staticLayout4 != null) {
            if (this.g0 > i18) {
                lineLeft = (float)lineStart;
            } else {
                lineLeft = staticLayout4.getLineLeft(lineStart);
            }
        }
        this.e0 = lineLeft;
        int i7 = e.b(this.k, this.D);
        i = i7 & 112;
        if (i != i15) {
            if (i != i13) {
                this.q = f9 -= obj13;
            } else {
                this.q = i9 += obj13;
            }
        } else {
            this.q = (float)obj13;
        }
        obj13 = i7 & i12;
        if (obj13 != i18) {
            if (obj13 != i17) {
                this.s = (float)obj13;
            } else {
                this.s = obj13 -= measureText2;
            }
        } else {
            this.s = obj13 -= measureText2;
        }
        j();
        a0(this.J);
    }

    private void c() {
        g(this.c);
    }

    private float d(float f) {
        final float f2 = this.f;
        final int i = 0;
        final int i2 = 1065353216;
        if (Float.compare(f, f2) <= 0) {
            return a.b(i2, i, this.e, f2, f);
        }
        return a.b(i, i2, f2, i2, f);
    }

    private float e() {
        float f = this.e;
        return f += i4;
    }

    private boolean f(java.lang.CharSequence charSequence) {
        boolean z;
        if (this.E) {
            z = E(charSequence, C());
        }
        return z;
    }

    private void g(float f) {
        int i;
        int i4;
        int sDK_INT;
        boolean z;
        TextPaint textPaint;
        int i5;
        int cmp;
        float f2;
        int i3;
        int i2;
        float obj7;
        A(f);
        int i7 = 0;
        int i8 = 1065353216;
        if (this.d) {
            if (Float.compare(f, f3) < 0) {
                this.u = this.s;
                this.v = this.q;
                a0(this.m);
                i = i7;
            } else {
                this.u = this.t;
                this.v = f5 -= f2;
                a0(this.n);
                i = i8;
            }
        } else {
            this.u = a.F(this.s, this.t, f, this.O);
            this.v = a.F(this.q, this.r, f, this.O);
            a0(a.F(this.m, this.n, f, this.P));
            i = f;
        }
        TimeInterpolator time3 = a.b;
        N(i8 - f25);
        U(a.F(i8, i7, f, time3));
        if (this.p != this.o) {
            this.M.setColor(a.a(v(), t(), i));
        } else {
            this.M.setColor(t());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            sDK_INT = this.Y;
            i5 = this.Z;
            if (Float.compare(sDK_INT, i5) != 0) {
                this.M.setLetterSpacing(a.F(i5, sDK_INT, f, time3));
            } else {
                this.M.setLetterSpacing(sDK_INT);
            }
        }
        int i12 = 0;
        this.M.setShadowLayer(a.F(this.U, this.Q, f, i12), a.F(this.V, this.R, f, i12), a.F(this.W, this.S, f, i12), a.a(u(this.X), u(this.T), f));
        if (this.d) {
            this.M.setAlpha((int)obj7);
        }
        u.c0(this.a);
    }

    private boolean g0() {
        boolean i;
        int i2;
        if (this.g0 > 1) {
            if (this.D) {
                if (this.d && !this.F) {
                    if (!this.F) {
                    } else {
                        i2 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    private void h(float f) {
        i(f, false);
    }

    private void i(float f, boolean z2) {
        float f2;
        Typeface typeface;
        int cmp;
        boolean z;
        int i3;
        int i2;
        int i;
        float z3;
        int i4;
        int obj9;
        int obj10;
        if (this.B == null) {
        }
        f2 = (float)width;
        typeface = (float)width2;
        final int i7 = 1065353216;
        i3 = 0;
        i2 = 1;
        if (a.B(f, this.n)) {
            obj9 = this.n;
            this.I = i7;
            typeface = this.w;
            obj10 = this.y != typeface ? i2 : i3;
        } else {
            z = this.m;
            Typeface typeface3 = this.x;
            i = this.y != typeface3 ? i2 : i3;
            if (a.B(f, z)) {
                this.I = i7;
            } else {
                this.I = f /= z3;
            }
            obj9 /= f5;
            if (z2 != 0) {
                f2 = typeface;
            } else {
            }
            obj9 = z;
            obj10 = i;
        }
        if (Float.compare(f2, i6) > 0) {
            if (Float.compare(f3, obj9) == 0 && !this.L) {
                if (!this.L) {
                    if (obj10 != null) {
                        obj10 = i2;
                    } else {
                        obj10 = i3;
                    }
                } else {
                }
            } else {
            }
            this.J = obj9;
            this.L = i3;
        }
        if (this.C != null) {
            this.M.setTextSize(this.J);
            this.M.setTypeface(this.y);
            if (obj10 != null && Float.compare(obj10, i7) != 0) {
                this.M.setTextSize(this.J);
                this.M.setTypeface(this.y);
                if (Float.compare(obj10, i7) != 0) {
                    i3 = i2;
                }
                this.M.setLinearText(i3);
                this.D = f(this.B);
                if (g0()) {
                    i2 = this.g0;
                }
                obj9 = k(i2, f2, this.D);
                this.a0 = obj9;
                this.C = obj9.getText();
            }
        } else {
        }
    }

    private void j() {
        Bitmap bitmap;
        bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = 0;
        }
    }

    private StaticLayout k(int i, float f2, boolean z3) {
        StaticLayout obj3;
        com.google.android.material.internal.h obj4;
        float obj5;
        try {
            obj4 = h.c(this.B, this.M, (int)f2);
            obj4.e(TextUtils.TruncateAt.END);
            obj4.h(z3);
            obj4.d(Layout.Alignment.ALIGN_NORMAL);
            obj4.g(false);
            obj4.j(i);
            obj4.i(this.h0, this.i0);
            obj4.f(this.j0);
            obj3 = obj4.a();
            f2 = i.getCause();
            f2 = f2.getMessage();
            z3 = "CollapsingTextHelper";
            Log.e(z3, f2, i);
            i = 0;
            i.c(obj3);
            return (StaticLayout)obj3;
        }
    }

    private void m(Canvas canvas, float f2, float f3) {
        boolean endsWith;
        int i2;
        float f;
        TextPaint textPaint;
        int i;
        int i3;
        TextPaint textPaint2;
        String obj14;
        int obj15;
        int alpha = this.M.getAlpha();
        canvas.translate(f2, f3);
        float f4 = (float)alpha;
        this.M.setAlpha((int)obj15);
        this.a0.draw(canvas);
        this.M.setAlpha((int)obj15);
        obj15 = 0;
        final java.lang.CharSequence charSequence = this.f0;
        final float f5 = (float)obj14;
        canvas.drawText(charSequence, 0, charSequence.length(), 0, f5, this.M);
        obj14 = this.f0.toString().trim();
        if (!this.d && obj14.endsWith("…")) {
            obj14 = this.f0.toString().trim();
            if (obj14.endsWith("…")) {
                obj14 = obj14.substring(obj15, length--);
            }
            f = obj14;
            this.M.setAlpha(alpha);
            canvas.drawText(f, 0, Math.min(this.a0.getLineEnd(obj15), f.length()), 0, f5, this.M);
        }
    }

    private void n() {
        Bitmap empty;
        int height;
        Bitmap.Config config;
        if (this.G == null && !this.h.isEmpty()) {
            if (!this.h.isEmpty()) {
                if (TextUtils.isEmpty(this.C)) {
                } else {
                    g(0);
                    empty = this.a0.getWidth();
                    height = this.a0.getHeight();
                    if (empty > 0) {
                        if (height <= 0) {
                        } else {
                            this.G = Bitmap.createBitmap(empty, height, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(this.G);
                            this.a0.draw(canvas);
                            if (this.H == null) {
                                empty = new Paint(3);
                                this.H = empty;
                            }
                        }
                    }
                }
            }
        }
    }

    private float r(int i, int i2) {
        int i3;
        int i4;
        int obj3;
        float obj4;
        if (i2 != 17) {
            if (i2 & 7 == 1) {
            } else {
                obj3 = 8388613;
                if (i2 & obj3 != obj3) {
                    obj3 = 5;
                    if (i2 &= obj3 == obj3) {
                    } else {
                        if (this.D) {
                            obj3 -= obj4;
                        } else {
                            obj3 = (float)obj3;
                        }
                    }
                    return obj3;
                }
                if (this.D) {
                    obj3 = (float)obj3;
                } else {
                    obj3 -= obj4;
                }
            }
            return obj3;
        }
        obj4 = 1073741824;
        return obj3 -= i5;
    }

    private float s(RectF rectF, int i2, int i3) {
        int i4;
        int i;
        float obj3;
        boolean obj4;
        int obj5;
        if (i3 != 17) {
            if (i3 & 7 == 1) {
            } else {
                obj4 = 8388613;
                if (i3 & obj4 != obj4) {
                    obj4 = 5;
                    if (i3 &= obj4 == obj4) {
                    } else {
                        if (this.D) {
                            obj3 = (float)obj3;
                        } else {
                            obj3 += obj4;
                        }
                    }
                    return obj3;
                }
                if (this.D) {
                    obj3 += obj4;
                } else {
                    obj3 = (float)obj3;
                }
            }
            return obj3;
        }
        obj4 = 1073741824;
        return obj3 += obj5;
    }

    private int u(ColorStateList colorStateList) {
        final int i = 0;
        if (colorStateList == null) {
            return i;
        }
        final int[] iArr = this.K;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, i);
        }
        return colorStateList.getDefaultColor();
    }

    private int v() {
        return u(this.o);
    }

    private void y(TextPaint textPaint) {
        int sDK_INT;
        textPaint.setTextSize(this.n);
        textPaint.setTypeface(this.w);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Y);
        }
    }

    private void z(TextPaint textPaint) {
        int sDK_INT;
        textPaint.setTextSize(this.m);
        textPaint.setTypeface(this.x);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Z);
        }
    }

    public final boolean D() {
        int i;
        boolean stateful;
        stateful = this.p;
        if (stateful != null) {
            if (!stateful.isStateful()) {
                stateful = this.o;
                if (stateful != null && stateful.isStateful()) {
                    i = stateful.isStateful() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    void G() {
        int height;
        int i;
        if (this.i.width() > 0 && this.i.height() > 0 && this.h.width() > 0 && this.h.height() > 0) {
            if (this.i.height() > 0) {
                if (this.h.width() > 0) {
                    i = this.h.height() > 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        this.b = i;
    }

    public void H() {
        I(false);
    }

    public void I(boolean z) {
        int height;
        if (this.a.getHeight() > 0) {
            if (this.a.getWidth() <= 0) {
                if (z) {
                    b(z);
                    c();
                }
            } else {
            }
        } else {
        }
    }

    public void K(int i, int i2, int i3, int i4) {
        boolean z;
        int obj2;
        if (!a.J(this.i, i, i2, i3, i4)) {
            this.i.set(i, i2, i3, i4);
            this.L = true;
            G();
        }
    }

    public void L(Rect rect) {
        K(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void M(int i) {
        ColorStateList obj4;
        d dVar = new d(this.a.getContext(), i);
        if (dVar.i() != null) {
            this.p = dVar.i();
        }
        if (Float.compare(obj4, i2) != 0) {
            this.n = dVar.j();
        }
        obj4 = dVar.a;
        if (obj4 != null) {
            this.T = obj4;
        }
        this.R = dVar.e;
        this.S = dVar.f;
        this.Q = dVar.g;
        this.Y = dVar.i;
        obj4 = this.A;
        if (obj4 != null) {
            obj4.c();
        }
        a.a aVar = new a.a(this);
        obj4 = new a(aVar, dVar.e());
        this.A = obj4;
        dVar.h(this.a.getContext(), this.A);
        H();
    }

    public void O(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            H();
        }
    }

    public void P(int i) {
        if (this.l != i) {
            this.l = i;
            H();
        }
    }

    public void Q(Typeface typeface) {
        if (R(typeface)) {
            H();
        }
    }

    public void S(int i, int i2, int i3, int i4) {
        boolean z;
        int obj2;
        if (!a.J(this.h, i, i2, i3, i4)) {
            this.h.set(i, i2, i3, i4);
            this.L = true;
            G();
        }
    }

    public void T(Rect rect) {
        S(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void V(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            H();
        }
    }

    public void W(int i) {
        if (this.k != i) {
            this.k = i;
            H();
        }
    }

    public void X(float f) {
        if (Float.compare(f2, f) != 0) {
            this.m = f;
            H();
        }
    }

    public void Z(float f) {
        final float obj3 = a.a(f, 0, 1065353216);
        if (Float.compare(obj3, f2) != 0) {
            this.c = obj3;
            c();
        }
    }

    public void b0(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        H();
    }

    public final boolean c0(int[] iArr) {
        this.K = iArr;
        if (D()) {
            H();
            return 1;
        }
        return 0;
    }

    public void d0(java.lang.CharSequence charSequence) {
        boolean equals;
        java.lang.CharSequence obj2;
        if (charSequence != null) {
            if (!TextUtils.equals(this.B, charSequence)) {
                this.B = charSequence;
                this.C = 0;
                j();
                H();
            }
        } else {
        }
    }

    public void e0(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        H();
    }

    public void f0(Typeface typeface) {
        if (!R(typeface)) {
            if (Y(typeface)) {
                H();
            }
        } else {
        }
    }

    public void l(Canvas canvas) {
        java.lang.CharSequence charSequence;
        float lineLeft;
        boolean cmp2;
        int i2;
        float f;
        int i;
        float f2;
        int cmp;
        Bitmap z;
        final int save = canvas.save();
        if (this.C != null && this.b) {
            if (this.b) {
                int i5 = 0;
                if (this.g0 > 1) {
                    lineLeft = (float)lineStart;
                } else {
                    lineLeft = this.a0.getLineLeft(i5);
                }
                this.M.setTextSize(this.J);
                charSequence = this.u;
                f2 = this.v;
                if (this.F && this.G != null) {
                    if (this.G != null) {
                    } else {
                        i2 = i5;
                    }
                } else {
                }
                f = this.I;
                if (Float.compare(f, i8) != 0 && !this.d) {
                    if (!this.d) {
                        canvas.scale(f, f, charSequence, f2);
                    }
                }
                if (i2 != 0) {
                    canvas.drawBitmap(this.G, charSequence, f2, this.H);
                    canvas.restoreToCount(save);
                }
                if (g0()) {
                    if (this.d) {
                        if (Float.compare(f4, f) > 0) {
                            m(canvas, i6 -= i4, f2);
                        } else {
                            canvas.translate(charSequence, f2);
                            this.a0.draw(canvas);
                        }
                    } else {
                    }
                } else {
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void o(RectF rectF, int i2, int i3) {
        this.D = f(this.B);
        rectF.left = r(i2, i3);
        rectF.top = (float)top;
        rectF.right = s(rectF, i2, i3);
        rectF.bottom = obj3 += obj4;
    }

    public ColorStateList p() {
        return this.p;
    }

    public float q() {
        y(this.N);
        return -ascent;
    }

    public int t() {
        return u(this.p);
    }

    public float w() {
        z(this.N);
        return -ascent;
    }

    public float x() {
        return this.c;
    }
}
