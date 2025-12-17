package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* loaded from: classes.dex */
class b implements androidx.cardview.widget.e {
    private androidx.cardview.widget.f p(androidx.cardview.widget.d d) {
        return (f)d.f();
    }

    @Override // androidx.cardview.widget.e
    public void a(androidx.cardview.widget.d d, Context context2, ColorStateList colorStateList3, float f4, float f5, float f6) {
        f obj2 = new f(colorStateList3, f4);
        d.c(obj2);
        obj2 = d.g();
        obj2.setClipToOutline(true);
        obj2.setElevation(f5);
        o(d, f6);
    }

    @Override // androidx.cardview.widget.e
    public void b(androidx.cardview.widget.d d, float f2) {
        p(d).h(f2);
    }

    @Override // androidx.cardview.widget.e
    public float c(androidx.cardview.widget.d d) {
        return d.g().getElevation();
    }

    @Override // androidx.cardview.widget.e
    public float d(androidx.cardview.widget.d d) {
        return p(d).d();
    }

    @Override // androidx.cardview.widget.e
    public void e(androidx.cardview.widget.d d) {
        o(d, g(d));
    }

    @Override // androidx.cardview.widget.e
    public void f(androidx.cardview.widget.d d, float f2) {
        d.g().setElevation(f2);
    }

    @Override // androidx.cardview.widget.e
    public float g(androidx.cardview.widget.d d) {
        return p(d).c();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList h(androidx.cardview.widget.d d) {
        return p(d).b();
    }

    @Override // androidx.cardview.widget.e
    public void i(androidx.cardview.widget.d d) {
        if (!d.e()) {
            int i = 0;
            d.a(i, i, i, i);
        }
        float f = g(d);
        final float f3 = d(d);
        int i3 = (int)ceil2;
        int i2 = (int)ceil;
        d.a(i3, i2, i3, i2);
    }

    @Override // androidx.cardview.widget.e
    public void j() {
    }

    @Override // androidx.cardview.widget.e
    public float k(androidx.cardview.widget.d d) {
        return obj2 *= i;
    }

    @Override // androidx.cardview.widget.e
    public float l(androidx.cardview.widget.d d) {
        return obj2 *= i;
    }

    @Override // androidx.cardview.widget.e
    public void m(androidx.cardview.widget.d d) {
        o(d, g(d));
    }

    @Override // androidx.cardview.widget.e
    public void n(androidx.cardview.widget.d d, ColorStateList colorStateList2) {
        p(d).f(colorStateList2);
    }

    @Override // androidx.cardview.widget.e
    public void o(androidx.cardview.widget.d d, float f2) {
        p(d).g(f2, d.e(), d.d());
        i(d);
    }
}
