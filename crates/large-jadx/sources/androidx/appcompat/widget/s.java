package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.a;
import d.a.j;
import d.h.l.u;

/* loaded from: classes.dex */
class s extends androidx.appcompat.widget.o {

    private final SeekBar d;
    private Drawable e;
    private ColorStateList f = null;
    private PorterDuff.Mode g = null;
    private boolean h = false;
    private boolean i = false;
    s(SeekBar seekBar) {
        super(seekBar);
        int i = 0;
        int i2 = 0;
        this.d = seekBar;
    }

    private void f() {
        Drawable stateful;
        boolean z;
        boolean drawableState;
        stateful = this.e;
        if (stateful != null) {
            if (!this.h) {
                Drawable drawable = a.r(stateful.mutate());
                this.e = drawable;
                if (this.i && this.h) {
                    drawable = a.r(stateful.mutate());
                    this.e = drawable;
                    if (this.h) {
                        a.o(drawable, this.f);
                    }
                    if (this.i) {
                        a.p(this.e, this.g);
                    }
                    if (this.e.isStateful()) {
                        this.e.setState(this.d.getDrawableState());
                    }
                }
            } else {
            }
        }
    }

    @Override // androidx.appcompat.widget.o
    void c(AttributeSet attributeSet, int i2) {
        int obj9;
        int obj10;
        super.c(attributeSet, i2);
        final int[] iArr = j.Q;
        androidx.appcompat.widget.t0 t0Var = t0.v(this.d.getContext(), attributeSet, iArr, i2, 0);
        SeekBar seekBar2 = this.d;
        u.j0(seekBar2, seekBar2.getContext(), iArr, attributeSet, t0Var.r(), i2, 0);
        obj9 = t0Var.h(j.R);
        if (obj9 != null) {
            this.d.setThumb(obj9);
        }
        j(t0Var.g(j.S));
        obj9 = j.U;
        int i3 = 1;
        if (t0Var.s(obj9)) {
            this.g = a0.e(t0Var.k(obj9, -1), this.g);
            this.i = i3;
        }
        obj9 = j.T;
        if (t0Var.s(obj9)) {
            this.f = t0Var.c(obj9);
            this.h = i3;
        }
        t0Var.w();
        f();
    }

    @Override // androidx.appcompat.widget.o
    void g(Canvas canvas) {
        Drawable max;
        int i3;
        int save;
        int i;
        int i2;
        float f;
        int i4;
        max = this.d.getMax();
        i3 = 1;
        if (this.e != null && max > i3) {
            max = this.d.getMax();
            i3 = 1;
            if (max > i3) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : i3;
                if (intrinsicHeight >= 0) {
                    i3 = intrinsicHeight / 2;
                }
                this.e.setBounds(-i, -i3, i, i3);
                canvas.translate((float)paddingLeft2, (float)i8);
                i2 = 0;
                while (i2 <= max) {
                    this.e.draw(canvas);
                    canvas.translate(f2 /= f3, 0.0f);
                    i2++;
                }
                canvas.restoreToCount(canvas.save());
            }
        }
    }

    @Override // androidx.appcompat.widget.o
    void h() {
        boolean stateful;
        final Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.d.getDrawableState())) {
            if (drawable.isStateful()) {
                if (drawable.setState(this.d.getDrawableState())) {
                    this.d.invalidateDrawable(drawable);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.o
    void i() {
        final Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.o
    void j(Drawable drawable) {
        boolean drawableState;
        int i;
        drawableState = this.e;
        if (drawableState != null) {
            drawableState.setCallback(0);
        }
        this.e = drawable;
        drawable.setCallback(this.d);
        a.m(drawable, u.B(this.d));
        if (drawable != null && drawable.isStateful()) {
            drawable.setCallback(this.d);
            a.m(drawable, u.B(this.d));
            if (drawable.isStateful()) {
                drawable.setState(this.d.getDrawableState());
            }
            f();
        }
        this.d.invalidate();
    }
}
