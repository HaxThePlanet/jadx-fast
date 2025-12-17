package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.widget.Button;
import androidx.core.graphics.drawable.a;
import com.google.android.material.internal.n;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.b0.a;
import f.c.a.e.b0.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.d0.n;
import f.c.a.e.l;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
class a {

    private static final boolean t = false;
    private static final boolean u = false;
    private final com.google.android.material.button.MaterialButton a;
    private k b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private Drawable m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private LayerDrawable r;
    private int s;
    static {
        int i;
        final int sDK_INT = Build.VERSION.SDK_INT;
        final int i4 = 0;
        i = 21;
        if (sDK_INT >= i) {
            int i5 = i2;
        }
        int i6 = i4;
        if (sDK_INT >= i && sDK_INT <= 22) {
            if (sDK_INT <= 22) {
            }
        }
        int i3 = i4;
    }

    a(com.google.android.material.button.MaterialButton materialButton, k k2) {
        super();
        final int i = 0;
        this.a = materialButton;
        this.b = k2;
    }

    private void E(int i, int i2) {
        this.f = i2;
        this.e = i;
        if (!this.o) {
            F();
        }
        u.y0(this.a, u.G(this.a), i4 -= i9, u.F(this.a), i7 -= i10);
    }

    private void F() {
        Drawable drawable;
        this.a.setInternalBackground(a());
        g gVar = f();
        if (gVar != null) {
            gVar.Y((float)i);
        }
    }

    private void G(k k) {
        boolean z;
        g gVar;
        g gVar2;
        n paddingTop;
        int i;
        int paddingBottom;
        com.google.android.material.button.MaterialButton materialButton;
        k obj5;
        if (a.u && !this.o) {
            if (!this.o) {
                F();
                u.y0(this.a, u.G(this.a), this.a.getPaddingTop(), u.F(this.a), this.a.getPaddingBottom());
            } else {
                if (f() != null) {
                    f().setShapeAppearanceModel(k);
                }
                if (n() != null) {
                    n().setShapeAppearanceModel(k);
                }
                if (e() != null) {
                    e().setShapeAppearanceModel(k);
                }
            }
        } else {
        }
    }

    private void I() {
        g gVar;
        int i;
        int list;
        gVar = f();
        final g gVar2 = n();
        gVar.h0((float)i3, this.k);
        if (gVar != null && gVar2 != null) {
            gVar.h0((float)i3, this.k);
            if (gVar2 != null) {
                if (this.n) {
                    i = a.d(this.a, b.q);
                } else {
                    i = 0;
                }
                gVar2.g0((float)i2, i);
            }
        }
    }

    private InsetDrawable J(Drawable drawable) {
        super(drawable, this.c, this.e, this.d, this.f);
        return insetDrawable2;
    }

    private Drawable a() {
        int i2;
        int i;
        g gVar = new g(this.b);
        gVar.O(this.a.getContext());
        a.o(gVar, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            a.p(gVar, mode);
        }
        gVar.h0((float)i3, this.k);
        g gVar2 = new g(this.b);
        int i4 = 0;
        gVar2.setTint(i4);
        if (this.n) {
            i2 = a.d(this.a, b.q);
        } else {
            i2 = i4;
        }
        gVar2.g0((float)i5, i2);
        int i6 = 2;
        int i7 = 1;
        if (a.t) {
            g gVar3 = new g(this.b);
            this.m = gVar3;
            a.n(gVar3, -1);
            Drawable[] arr = new Drawable[i6];
            arr[i4] = gVar2;
            arr[i7] = gVar;
            LayerDrawable layerDrawable2 = new LayerDrawable(arr);
            RippleDrawable rippleDrawable = new RippleDrawable(b.d(this.l), J(layerDrawable2), this.m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        a aVar = new a(this.b);
        this.m = aVar;
        a.o(aVar, b.d(this.l));
        Drawable[] arr2 = new Drawable[3];
        arr2[i4] = gVar2;
        arr2[i7] = gVar;
        arr2[i6] = this.m;
        LayerDrawable layerDrawable = new LayerDrawable(arr2);
        this.r = layerDrawable;
        return J(layerDrawable);
    }

    private g g(boolean z) {
        LayerDrawable numberOfLayers;
        numberOfLayers = this.r;
        if (numberOfLayers != null && numberOfLayers.getNumberOfLayers() > 0 && a.t) {
            if (numberOfLayers.getNumberOfLayers() > 0) {
                if (a.t) {
                    return (g)(LayerDrawable)(InsetDrawable)this.r.getDrawable(0).getDrawable().getDrawable(z ^= 1);
                }
                return (g)this.r.getDrawable(z ^= 1);
            }
        }
        return null;
    }

    private g n() {
        return g(true);
    }

    void A(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            I();
        }
    }

    void B(int i) {
        if (this.h != i) {
            this.h = i;
            I();
        }
    }

    void C(ColorStateList colorStateList) {
        ColorStateList list;
        Object obj2;
        this.j = colorStateList;
        if (this.j != colorStateList && f() != null) {
            this.j = colorStateList;
            if (f() != null) {
                a.o(f(), this.j);
            }
        }
    }

    void D(PorterDuff.Mode porterDuff$Mode) {
        PorterDuff.Mode mode2;
        Object obj2;
        this.i = mode;
        if (this.i != mode && f() != null && this.i != null) {
            this.i = mode;
            if (f() != null) {
                if (this.i != null) {
                    a.p(f(), this.i);
                }
            }
        }
    }

    void H(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int obj5;
        int obj6;
        final Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(this.c, this.e, i2 -= i6, i -= i5);
        }
    }

    int b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.e;
    }

    public n e() {
        LayerDrawable numberOfLayers;
        int i;
        numberOfLayers = this.r;
        i = 1;
        final int i3 = 2;
        if (numberOfLayers != null && numberOfLayers.getNumberOfLayers() > i && this.r.getNumberOfLayers() > i3) {
            i = 1;
            if (numberOfLayers.getNumberOfLayers() > i) {
                i3 = 2;
                if (this.r.getNumberOfLayers() > i3) {
                    return (n)this.r.getDrawable(i3);
                }
                return (n)this.r.getDrawable(i);
            }
        }
        return null;
    }

    g f() {
        return g(false);
    }

    ColorStateList h() {
        return this.l;
    }

    k i() {
        return this.b;
    }

    ColorStateList j() {
        return this.k;
    }

    int k() {
        return this.h;
    }

    ColorStateList l() {
        return this.j;
    }

    PorterDuff.Mode m() {
        return this.i;
    }

    boolean o() {
        return this.o;
    }

    boolean p() {
        return this.q;
    }

    void q(TypedArray typedArray) {
        int i;
        boolean value;
        int i12 = 0;
        this.c = typedArray.getDimensionPixelOffset(l.b2, i12);
        this.d = typedArray.getDimensionPixelOffset(l.c2, i12);
        this.e = typedArray.getDimensionPixelOffset(l.d2, i12);
        this.f = typedArray.getDimensionPixelOffset(l.e2, i12);
        i = l.i2;
        int i19 = -1;
        if (typedArray.hasValue(i)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i, i19);
            this.g = dimensionPixelSize;
            y(this.b.w((float)dimensionPixelSize));
            this.p = true;
        }
        this.h = typedArray.getDimensionPixelSize(l.s2, i12);
        this.i = n.f(typedArray.getInt(l.h2, i19), PorterDuff.Mode.SRC_IN);
        this.j = c.a(this.a.getContext(), typedArray, l.g2);
        this.k = c.a(this.a.getContext(), typedArray, l.r2);
        this.l = c.a(this.a.getContext(), typedArray, l.q2);
        this.q = typedArray.getBoolean(l.f2, i12);
        this.s = typedArray.getDimensionPixelSize(l.j2, i12);
        if (typedArray.hasValue(l.a2)) {
            s();
        } else {
            F();
        }
        u.y0(this.a, i10 += i22, paddingTop += i23, i17 += i24, paddingBottom += i25);
    }

    void r(int i) {
        g gVar;
        if (f() != null) {
            f().setTint(i);
        }
    }

    void s() {
        this.o = true;
        this.a.setSupportBackgroundTintList(this.j);
        this.a.setSupportBackgroundTintMode(this.i);
    }

    void t(boolean z) {
        this.q = z;
    }

    void u(int i) {
        int z;
        int obj2;
        if (this.p) {
            if (this.g != i) {
                this.g = i;
                this.p = true;
                y(this.b.w((float)i));
            }
        } else {
        }
    }

    public void v(int i) {
        E(this.e, i);
    }

    public void w(int i) {
        E(i, this.f);
    }

    void x(ColorStateList colorStateList) {
        ColorStateList background;
        boolean z;
        ColorStateList obj3;
        if (this.l != colorStateList) {
            this.l = colorStateList;
            background = a.t;
            if (background && background3 instanceof RippleDrawable) {
                if (background3 instanceof RippleDrawable) {
                    (RippleDrawable)this.a.getBackground().setColor(b.d(colorStateList));
                } else {
                    if (!background && background2 instanceof a) {
                        if (background2 instanceof a) {
                            (a)this.a.getBackground().setTintList(b.d(colorStateList));
                        }
                    }
                }
            } else {
            }
        }
    }

    void y(k k) {
        this.b = k;
        G(k);
    }

    void z(boolean z) {
        this.n = z;
        I();
    }
}
