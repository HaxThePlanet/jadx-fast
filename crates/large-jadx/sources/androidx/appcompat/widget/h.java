package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.e;
import d.a.j;
import d.a.k.a.a;
import d.h.l.u;

/* loaded from: classes.dex */
class h {

    private final CompoundButton a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;
    h(CompoundButton compoundButton) {
        super();
        int i = 0;
        int i2 = 0;
        this.a = compoundButton;
    }

    void a() {
        Drawable mutate;
        CompoundButton compoundButton;
        boolean z2;
        boolean z;
        boolean drawableState;
        mutate = e.a(this.a);
        if (mutate != null) {
            if (!this.d) {
                mutate = a.r(mutate).mutate();
                if (this.e && this.d) {
                    mutate = a.r(mutate).mutate();
                    if (this.d) {
                        a.o(mutate, this.b);
                    }
                    if (this.e) {
                        a.p(mutate, this.c);
                    }
                    if (mutate.isStateful()) {
                        mutate.setState(this.a.getDrawableState());
                    }
                    this.a.setButtonDrawable(mutate);
                }
            } else {
            }
        }
    }

    int b(int i) {
        int intrinsicWidth;
        int obj3;
        intrinsicWidth = e.a(this.a);
        if (Build.VERSION.SDK_INT < 17 && intrinsicWidth != null) {
            intrinsicWidth = e.a(this.a);
            if (intrinsicWidth != null) {
                i += intrinsicWidth;
            }
        }
        return obj3;
    }

    ColorStateList c() {
        return this.b;
    }

    PorterDuff.Mode d() {
        return this.c;
    }

    void e(AttributeSet attributeSet, int i2) {
        Object context;
        int obj10;
        boolean obj11;
        final int[] l0 = j.L0;
        final int i5 = 0;
        androidx.appcompat.widget.t0 t0Var = t0.v(this.a.getContext(), attributeSet, l0, i2, i5);
        context = this.a;
        u.j0(context, context.getContext(), l0, attributeSet, t0Var.r(), i2, 0);
        obj10 = j.N0;
        obj10 = t0Var.n(obj10, i5);
        if (t0Var.s(obj10) && obj10 != null) {
            obj10 = t0Var.n(obj10, i5);
            if (obj10 != null) {
                obj11 = this.a;
                obj11.setButtonDrawable(a.d(obj11.getContext(), obj10));
                obj10 = 1;
            } else {
                obj10 = i5;
            }
        } else {
        }
        obj10 = j.M0;
        obj10 = t0Var.n(obj10, i5);
        if (obj10 == null && t0Var.s(obj10) && obj10 != null) {
            obj10 = j.M0;
            if (t0Var.s(obj10)) {
                obj10 = t0Var.n(obj10, i5);
                if (obj10 != null) {
                    obj11 = this.a;
                    obj11.setButtonDrawable(a.d(obj11.getContext(), obj10));
                }
            }
        }
        obj10 = j.O0;
        if (t0Var.s(obj10)) {
            e.c(this.a, t0Var.c(obj10));
        }
        obj10 = j.P0;
        if (t0Var.s(obj10)) {
            e.d(this.a, a0.e(t0Var.k(obj10, -1), 0));
        }
        t0Var.w();
    }

    void f() {
        if (this.f) {
            this.f = false;
        }
        this.f = true;
        a();
    }

    void g(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    void h(PorterDuff.Mode porterDuff$Mode) {
        this.c = mode;
        this.e = true;
        a();
    }
}
