package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.g;
import d.a.j;
import d.a.k.a.a;
import d.h.l.u;

/* loaded from: classes.dex */
public class l {

    private final ImageView a;
    private androidx.appcompat.widget.r0 b;
    private androidx.appcompat.widget.r0 c;
    private androidx.appcompat.widget.r0 d;
    public l(ImageView imageView) {
        super();
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        androidx.appcompat.widget.r0 r0Var;
        boolean z;
        if (this.d == null) {
            r0Var = new r0();
            this.d = r0Var;
        }
        androidx.appcompat.widget.r0 r0Var2 = this.d;
        r0Var2.a();
        ColorStateList list = g.a(this.a);
        final int i = 1;
        if (list != null) {
            r0Var2.d = i;
            r0Var2.a = list;
        }
        PorterDuff.Mode mode = g.b(this.a);
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

    private boolean j() {
        int i;
        int sDK_INT = Build.VERSION.SDK_INT;
        final int i2 = 0;
        final int i3 = 21;
        if (sDK_INT > i3) {
            if (this.b != null) {
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
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            a0.b(drawable);
        }
        if (drawable != null && j() && a(drawable)) {
            if (j()) {
                if (a(drawable)) {
                }
            }
            r0Var = this.c;
            if (r0Var != null) {
                i.i(drawable, r0Var, this.a.getDrawableState());
            } else {
                r0Var = this.b;
                if (r0Var != null) {
                    i.i(drawable, r0Var, this.a.getDrawableState());
                }
            }
        }
    }

    ColorStateList c() {
        ColorStateList list;
        androidx.appcompat.widget.r0 r0Var = this.c;
        list = r0Var != null ? r0Var.a : 0;
        return list;
    }

    PorterDuff.Mode d() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.r0 r0Var = this.c;
        mode = r0Var != null ? r0Var.b : 0;
        return mode;
    }

    boolean e() {
        Drawable background;
        if (Build.VERSION.SDK_INT >= 21 && background instanceof RippleDrawable) {
            if (background instanceof RippleDrawable) {
                return 0;
            }
        }
        return 1;
    }

    public void f(AttributeSet attributeSet, int i2) {
        ImageView view;
        boolean z;
        boolean z2;
        Drawable obj9;
        int obj10;
        final int[] iArr = j.M;
        androidx.appcompat.widget.t0 t0Var = t0.v(this.a.getContext(), attributeSet, iArr, i2, 0);
        view = this.a;
        u.j0(view, view.getContext(), iArr, attributeSet, t0Var.r(), i2, 0);
        obj10 = -1;
        view = t0Var.n(j.N, obj10);
        obj9 = a.d(this.a.getContext(), view);
        if (this.a.getDrawable() == null && view != obj10 && obj9 != null) {
            view = t0Var.n(j.N, obj10);
            if (view != obj10) {
                obj9 = a.d(this.a.getContext(), view);
                if (obj9 != null) {
                    this.a.setImageDrawable(obj9);
                }
            }
        }
        if (obj9 != null) {
            a0.b(obj9);
        }
        obj9 = j.O;
        if (t0Var.s(obj9)) {
            g.c(this.a, t0Var.c(obj9));
        }
        obj9 = j.P;
        if (t0Var.s(obj9)) {
            g.d(this.a, a0.e(t0Var.k(obj9, obj10), 0));
        }
        t0Var.w();
    }

    public void g(int i) {
        ImageView view;
        Object obj2;
        if (i != 0) {
            obj2 = a.d(this.a.getContext(), i);
            if (obj2 != null) {
                a0.b(obj2);
            }
            this.a.setImageDrawable(obj2);
        } else {
            this.a.setImageDrawable(0);
        }
        b();
    }

    void h(ColorStateList colorStateList) {
        androidx.appcompat.widget.r0 r0Var;
        if (this.c == null) {
            r0Var = new r0();
            this.c = r0Var;
        }
        androidx.appcompat.widget.r0 r0Var2 = this.c;
        r0Var2.a = colorStateList;
        r0Var2.d = true;
        b();
    }

    void i(PorterDuff.Mode porterDuff$Mode) {
        androidx.appcompat.widget.r0 r0Var;
        if (this.c == null) {
            r0Var = new r0();
            this.c = r0Var;
        }
        androidx.appcompat.widget.r0 r0Var2 = this.c;
        r0Var2.b = mode;
        r0Var2.c = true;
        b();
    }
}
