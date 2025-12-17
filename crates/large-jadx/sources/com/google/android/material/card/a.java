package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.a;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.b0.b;
import f.c.a.e.d0.d;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.f;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
class a {

    private static final double t;
    private final com.google.android.material.card.MaterialCardView a;
    private final Rect b;
    private final g c;
    private final g d;
    private int e;
    private int f;
    private int g;
    private Drawable h;
    private Drawable i;
    private ColorStateList j;
    private ColorStateList k;
    private k l;
    private ColorStateList m;
    private Drawable n;
    private LayerDrawable o;
    private g p;
    private g q;
    private boolean r = false;
    private boolean s;

    class a extends InsetDrawable {
        a(com.google.android.material.card.a a, Drawable drawable2, int i3, int i4, int i5, int i6) {
            super(drawable2, i3, i4, i5, i6);
        }

        @Override // android.graphics.drawable.InsetDrawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable
        public boolean getPadding(Rect rect) {
            return 0;
        }
    }
    static {
        a.t = Math.cos(Math.toRadians(4631530004285489152L));
    }

    public a(com.google.android.material.card.MaterialCardView materialCardView, AttributeSet attributeSet2, int i3, int i4) {
        int obj4;
        boolean obj5;
        super();
        Rect rect = new Rect();
        this.b = rect;
        int i = 0;
        this.a = materialCardView;
        g gVar = new g(materialCardView.getContext(), attributeSet2, i3, i4);
        this.c = gVar;
        gVar.O(materialCardView.getContext());
        gVar.e0(-12303292);
        k.b obj6 = gVar.E().v();
        TypedArray obj3 = materialCardView.getContext().obtainStyledAttributes(attributeSet2, l.f0, i3, k.a);
        obj4 = l.g0;
        if (obj3.hasValue(obj4)) {
            obj6.o(obj3.getDimension(obj4, 0));
        }
        obj4 = new g();
        this.d = obj4;
        R(obj6.m());
        obj3.recycle();
    }

    private Drawable A(Drawable drawable) {
        int useCompatPadding;
        int i3;
        double ceil;
        int i;
        int i2;
        i3 = 0;
        useCompatPadding = Build.VERSION.SDK_INT < 21 ? 1 : i3;
        if (useCompatPadding == 0) {
            if (this.a.getUseCompatPadding()) {
                i = useCompatPadding;
                i2 = i3;
            } else {
                i2 = i;
            }
        } else {
        }
        super(this, drawable, i, i2, i, i2);
        return aVar;
    }

    private boolean V() {
        boolean preventCornerOverlap;
        int i;
        if (this.a.getPreventCornerOverlap() && !e()) {
            i = !e() ? 1 : 0;
        } else {
        }
        return i;
    }

    private boolean W() {
        int i;
        boolean preventCornerOverlap;
        if (this.a.getPreventCornerOverlap() && e() && this.a.getUseCompatPadding()) {
            if (e()) {
                i = this.a.getUseCompatPadding() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private float a() {
        return Math.max(Math.max(b(this.l.q(), this.c.H()), b(this.l.s(), this.c.I())), Math.max(b(this.l.k(), this.c.t()), b(this.l.i(), this.c.s())));
    }

    private void a0(Drawable drawable) {
        int sDK_INT;
        Object foreground;
        Drawable obj3;
        if (Build.VERSION.SDK_INT >= 23 && foreground2 instanceof InsetDrawable) {
            if (foreground2 instanceof InsetDrawable) {
                (InsetDrawable)this.a.getForeground().setDrawable(drawable);
            } else {
                this.a.setForeground(A(drawable));
            }
        } else {
        }
    }

    private float b(d d, float f2) {
        if (d instanceof j) {
            return (float)i2;
        }
        if (d instanceof e) {
            return f2 /= obj5;
        }
        return 0;
    }

    private float c() {
        float f;
        if (W()) {
            f = a();
        } else {
            f = 0;
        }
        return maxCardElevation += f;
    }

    private void c0() {
        boolean z;
        ColorStateList list;
        z = this.n;
        if (b.a && z != null) {
            z = this.n;
            if (z != null) {
                (RippleDrawable)z.setColor(this.j);
            } else {
                z = this.p;
                if (z != null) {
                    z.Z(this.j);
                }
            }
        } else {
        }
    }

    private float d() {
        float f;
        if (W()) {
            f = a();
        } else {
            f = 0;
        }
        return i += f;
    }

    private boolean e() {
        int sDK_INT;
        int i;
        if (Build.VERSION.SDK_INT >= 21 && this.c.R()) {
            i = this.c.R() ? 1 : 0;
        } else {
        }
        return i;
    }

    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        g gVar = h();
        this.p = gVar;
        gVar.Z(this.j);
        int[] iArr = new int[1];
        stateListDrawable.addState(iArr, this.p);
        return stateListDrawable;
    }

    private Drawable g() {
        if (b.a) {
            this.q = h();
            RippleDrawable rippleDrawable = new RippleDrawable(this.j, 0, this.q);
            return rippleDrawable;
        }
        return f();
    }

    private g h() {
        g gVar = new g(this.l);
        return gVar;
    }

    private Drawable q() {
        Drawable drawable2;
        LayerDrawable layerDrawable;
        int i2;
        Drawable drawable;
        int i;
        if (this.n == null) {
            this.n = g();
        }
        if (this.o == null) {
            Drawable[] arr = new Drawable[3];
            i = 2;
            arr[i] = this.i;
            layerDrawable = new LayerDrawable(arr);
            this.o = layerDrawable;
            layerDrawable.setId(i, f.L);
        }
        return this.o;
    }

    private float s() {
        int preventCornerOverlap;
        int i;
        if (this.a.getPreventCornerOverlap() && Build.VERSION.SDK_INT >= 21 && this.a.getUseCompatPadding()) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.a.getUseCompatPadding()) {
                }
            }
            return (float)i3;
        }
        return 0;
    }

    boolean B() {
        return this.r;
    }

    boolean C() {
        return this.s;
    }

    void D(TypedArray typedArray) {
        ColorStateList valueOf2;
        ColorStateList valueOf;
        int i;
        Drawable obj4;
        valueOf2 = c.a(this.a.getContext(), typedArray, l.Z2);
        this.m = valueOf2;
        if (valueOf2 == null) {
            this.m = ColorStateList.valueOf(-1);
        }
        int i5 = 0;
        this.g = typedArray.getDimensionPixelSize(l.a3, i5);
        boolean boolean = typedArray.getBoolean(l.S2, i5);
        this.s = boolean;
        this.a.setLongClickable(boolean);
        this.k = c.a(this.a.getContext(), typedArray, l.X2);
        K(c.d(this.a.getContext(), typedArray, l.U2));
        M(typedArray.getDimensionPixelSize(l.W2, i5));
        L(typedArray.getDimensionPixelSize(l.V2, i5));
        valueOf = c.a(this.a.getContext(), typedArray, l.Y2);
        this.j = valueOf;
        if (valueOf == null) {
            this.j = ColorStateList.valueOf(a.d(this.a, b.m));
        }
        H(c.a(this.a.getContext(), typedArray, l.T2));
        c0();
        Z();
        d0();
        this.a.setBackgroundInternal(A(this.c));
        if (this.a.isClickable()) {
            obj4 = q();
        } else {
            obj4 = this.d;
        }
        this.h = obj4;
        this.a.setForeground(A(obj4));
    }

    void E(int i, int i2) {
        LayerDrawable layerDrawable;
        int useCompatPadding;
        int i4;
        int i5;
        double ceil;
        double d;
        int i7;
        int i6;
        int i8;
        int i3;
        int obj10;
        int obj11;
        if (this.o != null) {
            int i9 = this.e;
            int i13 = this.f;
            i5 = 1;
            useCompatPadding = Build.VERSION.SDK_INT < 21 ? i5 : 0;
            if (useCompatPadding == 0) {
                if (this.a.getUseCompatPadding()) {
                    i4 = 1073741824;
                    obj11 -= i11;
                    obj10 -= useCompatPadding;
                }
            } else {
            }
            obj11 = this.e;
            if (u.B(this.a) == i5) {
                i8 = obj10;
                i7 = obj11;
            } else {
                i7 = obj10;
                i8 = obj11;
            }
            this.o.setLayerInset(2, i7, this.e, i8, obj11);
        }
    }

    void F(boolean z) {
        this.r = z;
    }

    void G(ColorStateList colorStateList) {
        this.c.Z(colorStateList);
    }

    void H(ColorStateList colorStateList) {
        ColorStateList obj2;
        if (colorStateList == null) {
            obj2 = ColorStateList.valueOf(0);
        }
        this.d.Z(obj2);
    }

    void I(boolean z) {
        this.s = z;
    }

    public void J(boolean z) {
        int obj2;
        final Drawable drawable = this.i;
        if (drawable != null) {
            obj2 = z != 0 ? 255 : 0;
            drawable.setAlpha(obj2);
        }
    }

    void K(Drawable drawable) {
        ColorStateList list;
        Drawable drawable2;
        Drawable obj3;
        this.i = drawable;
        if (drawable != null) {
            obj3 = a.r(drawable).mutate();
            this.i = obj3;
            a.o(obj3, this.k);
            J(this.a.isChecked());
        }
        obj3 = this.o;
        if (obj3 != null) {
            obj3.setDrawableByLayerId(f.L, this.i);
        }
    }

    void L(int i) {
        this.e = i;
    }

    void M(int i) {
        this.f = i;
    }

    void N(ColorStateList colorStateList) {
        this.k = colorStateList;
        final Drawable drawable = this.i;
        if (drawable != null) {
            a.o(drawable, colorStateList);
        }
    }

    void O(float f) {
        boolean obj2;
        R(this.l.w(f));
        this.h.invalidateSelf();
        if (!W()) {
            if (V()) {
                Y();
            }
        } else {
        }
        if (W()) {
            b0();
        }
    }

    void P(float f) {
        this.c.a0(f);
        g gVar2 = this.d;
        if (gVar2 != null) {
            gVar2.a0(f);
        }
        g gVar3 = this.q;
        if (gVar3 != null) {
            gVar3.a0(f);
        }
    }

    void Q(ColorStateList colorStateList) {
        this.j = colorStateList;
        c0();
    }

    void R(k k) {
        this.l = k;
        this.c.setShapeAppearanceModel(k);
        g gVar2 = this.c;
        gVar2.d0(z ^= 1);
        g gVar3 = this.d;
        if (gVar3 != null) {
            gVar3.setShapeAppearanceModel(k);
        }
        g gVar4 = this.q;
        if (gVar4 != null) {
            gVar4.setShapeAppearanceModel(k);
        }
        g gVar5 = this.p;
        if (gVar5 != null) {
            gVar5.setShapeAppearanceModel(k);
        }
    }

    void S(ColorStateList colorStateList) {
        if (this.m == colorStateList) {
        }
        this.m = colorStateList;
        d0();
    }

    void T(int i) {
        if (i == this.g) {
        }
        this.g = i;
        d0();
    }

    void U(int i, int i2, int i3, int i4) {
        this.b.set(i, i2, i3, i4);
        Y();
    }

    void X() {
        Drawable drawable;
        if (this.a.isClickable()) {
            drawable = q();
        } else {
            drawable = this.d;
        }
        this.h = drawable;
        if (this.h != drawable) {
            a0(drawable);
        }
    }

    void Y() {
        int i2;
        int i;
        boolean z;
        if (!V()) {
            if (W()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        if (i2 != 0) {
            i = a();
        } else {
            i = 0;
        }
        int i4 = (int)i3;
        Rect rect = this.b;
        this.a.g(left += i4, top += i4, right += i4, bottom += i4);
    }

    void Z() {
        this.c.Y(this.a.getCardElevation());
    }

    void b0() {
        boolean z;
        Drawable drawable;
        if (!B()) {
            this.a.setBackgroundInternal(A(this.c));
        }
        this.a.setForeground(A(this.h));
    }

    void d0() {
        this.d.h0((float)i, this.m);
    }

    void i() {
        Drawable right;
        int bottom;
        Drawable drawable;
        int left;
        int top;
        int right2;
        int i;
        right = this.n;
        if (right != null) {
            Rect bounds = right.getBounds();
            bottom = bounds.bottom;
            this.n.setBounds(bounds.left, bounds.top, bounds.right, bottom + -1);
            this.n.setBounds(bounds.left, bounds.top, bounds.right, bottom);
        }
    }

    g j() {
        return this.c;
    }

    ColorStateList k() {
        return this.c.x();
    }

    ColorStateList l() {
        return this.d.x();
    }

    Drawable m() {
        return this.i;
    }

    int n() {
        return this.e;
    }

    int o() {
        return this.f;
    }

    ColorStateList p() {
        return this.k;
    }

    float r() {
        return this.c.H();
    }

    float t() {
        return this.c.y();
    }

    ColorStateList u() {
        return this.j;
    }

    k v() {
        return this.l;
    }

    int w() {
        int defaultColor;
        ColorStateList list = this.m;
        if (list == null) {
            defaultColor = -1;
        } else {
            defaultColor = list.getDefaultColor();
        }
        return defaultColor;
    }

    ColorStateList x() {
        return this.m;
    }

    int y() {
        return this.g;
    }

    Rect z() {
        return this.b;
    }
}
