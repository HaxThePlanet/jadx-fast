package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import d.a.j;
import d.h.l.u;

/* loaded from: classes.dex */
class e {

    private final View a;
    private final androidx.appcompat.widget.i b;
    private int c = -1;
    private androidx.appcompat.widget.r0 d;
    private androidx.appcompat.widget.r0 e;
    private androidx.appcompat.widget.r0 f;
    e(View view) {
        super();
        final int i = -1;
        this.a = view;
        this.b = i.b();
    }

    private boolean a(Drawable drawable) {
        androidx.appcompat.widget.r0 r0Var;
        boolean z;
        if (this.f == null) {
            r0Var = new r0();
            this.f = r0Var;
        }
        androidx.appcompat.widget.r0 r0Var2 = this.f;
        r0Var2.a();
        ColorStateList list = u.s(this.a);
        final int i = 1;
        if (list != null) {
            r0Var2.d = i;
            r0Var2.a = list;
        }
        PorterDuff.Mode mode = u.t(this.a);
        if (mode != null) {
            r0Var2.c = i;
            r0Var2.b = mode;
        }
        if (!r0Var2.d && r0Var2.c) {
            if (r0Var2.c) {
            }
            return 0;
        }
        i.i(drawable, r0Var2, this.a.getDrawableState());
        return i;
    }

    private boolean k() {
        int i;
        int sDK_INT = Build.VERSION.SDK_INT;
        final int i2 = 0;
        final int i3 = 21;
        if (sDK_INT > i3) {
            if (this.d != null) {
            } else {
                i = i2;
            }
            return i;
        }
        if (sDK_INT == i3) {
            return 1;
        }
        return i2;
    }

    void b() {
        boolean z;
        androidx.appcompat.widget.r0 r0Var;
        int[] drawableState;
        Drawable background = this.a.getBackground();
        if (background != null && k() && a(background)) {
            if (k()) {
                if (a(background)) {
                }
            }
            r0Var = this.e;
            if (r0Var != null) {
                i.i(background, r0Var, this.a.getDrawableState());
            } else {
                r0Var = this.d;
                if (r0Var != null) {
                    i.i(background, r0Var, this.a.getDrawableState());
                }
            }
        }
    }

    ColorStateList c() {
        ColorStateList list;
        androidx.appcompat.widget.r0 r0Var = this.e;
        list = r0Var != null ? r0Var.a : 0;
        return list;
    }

    PorterDuff.Mode d() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.r0 r0Var = this.e;
        mode = r0Var != null ? r0Var.b : 0;
        return mode;
    }

    void e(AttributeSet attributeSet, int i2) {
        int i;
        android.content.Context context;
        int obj9;
        boolean obj10;
        final int[] d3 = j.D3;
        androidx.appcompat.widget.t0 t0Var = t0.v(this.a.getContext(), attributeSet, d3, i2, 0);
        View view2 = this.a;
        u.j0(view2, view2.getContext(), d3, attributeSet, t0Var.r(), i2, 0);
        obj9 = j.E3;
        i = -1;
        this.c = t0Var.n(obj9, i);
        obj9 = this.b.f(this.a.getContext(), this.c);
        if (t0Var.s(obj9) && obj9 != null) {
            this.c = t0Var.n(obj9, i);
            obj9 = this.b.f(this.a.getContext(), this.c);
            if (obj9 != null) {
                h(obj9);
            }
        }
        obj9 = j.F3;
        if (t0Var.s(obj9)) {
            u.p0(this.a, t0Var.c(obj9));
        }
        obj9 = j.G3;
        if (t0Var.s(obj9)) {
            u.q0(this.a, a0.e(t0Var.k(obj9, i), 0));
        }
        t0Var.w();
    }

    void f(Drawable drawable) {
        this.c = -1;
        h(0);
        b();
    }

    void g(int i) {
        android.content.Context context;
        ColorStateList obj3;
        this.c = i;
        final androidx.appcompat.widget.i iVar = this.b;
        if (iVar != null) {
            obj3 = iVar.f(this.a.getContext(), i);
        } else {
            obj3 = 0;
        }
        h(obj3);
        b();
    }

    void h(ColorStateList colorStateList) {
        androidx.appcompat.widget.r0 r0Var2;
        androidx.appcompat.widget.r0 r0Var;
        int obj2;
        if (colorStateList != null) {
            if (this.d == null) {
                r0Var2 = new r0();
                this.d = r0Var2;
            }
            r0Var = this.d;
            r0Var.a = colorStateList;
            r0Var.d = true;
        } else {
            this.d = 0;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        androidx.appcompat.widget.r0 r0Var;
        if (this.e == null) {
            r0Var = new r0();
            this.e = r0Var;
        }
        androidx.appcompat.widget.r0 r0Var2 = this.e;
        r0Var2.a = colorStateList;
        r0Var2.d = true;
        b();
    }

    void j(PorterDuff.Mode porterDuff$Mode) {
        androidx.appcompat.widget.r0 r0Var;
        if (this.e == null) {
            r0Var = new r0();
            this.e = r0Var;
        }
        androidx.appcompat.widget.r0 r0Var2 = this.e;
        r0Var2.b = mode;
        r0Var2.c = true;
        b();
    }
}
