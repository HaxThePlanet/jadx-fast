package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes.dex */
class c implements androidx.cardview.widget.e {

    final RectF a;

    class a implements androidx.cardview.widget.g.a {

        final androidx.cardview.widget.c a;
        a(androidx.cardview.widget.c c) {
            this.a = c;
            super();
        }

        @Override // androidx.cardview.widget.g$a
        public void a(Canvas canvas, RectF rectF2, float f3, Paint paint4) {
            int cmp;
            int i4;
            int i6;
            int i5;
            float bottom;
            Paint paint;
            int i;
            int save;
            int i2;
            int i3;
            final Object obj = this;
            final int i32 = canvas;
            final Object obj2 = rectF2;
            i7 *= f3;
            final int i33 = 1065353216;
            final int i34 = i21 - i33;
            if (Float.compare(f3, i33) >= 0) {
                i = f3 + i10;
                int i22 = -i;
                cVar.a.set(i22, i22, i, i);
                i32.translate(left += i, top2 += i);
                int i26 = 1127481344;
                int i27 = 1119092736;
                int i30 = 1;
                paint = paint4;
                canvas.drawArc(cVar2.a, i26, i27, i30, paint);
                i2 = 0;
                i32.translate(i34, i2);
                i3 = 1119092736;
                i32.rotate(i3);
                canvas.drawArc(cVar3.a, i26, i27, i30, paint);
                i32.translate(i4 - i33, i2);
                i32.rotate(i3);
                canvas.drawArc(cVar4.a, i26, i27, i30, paint);
                i32.translate(i34, i2);
                i32.rotate(i3);
                canvas.drawArc(cVar5.a, i26, i27, i30, paint);
                i32.restoreToCount(canvas.save());
                float top3 = obj2.top;
                canvas.drawRect(i16 - i33, top3, i17 + i33, top3 + i, paint);
                bottom = obj2.bottom;
                canvas.drawRect(i19 - i33, bottom - i, i20 + i33, bottom, paint);
            }
            canvas.drawRect(obj2.left, top + f3, obj2.right, bottom2 - f3, paint4);
        }
    }
    c() {
        super();
        RectF rectF = new RectF();
        this.a = rectF;
    }

    private androidx.cardview.widget.g p(Context context, ColorStateList colorStateList2, float f3, float f4, float f5) {
        super(context.getResources(), colorStateList2, f3, f4, f5);
        return gVar2;
    }

    private androidx.cardview.widget.g q(androidx.cardview.widget.d d) {
        return (g)d.f();
    }

    @Override // androidx.cardview.widget.e
    public void a(androidx.cardview.widget.d d, Context context2, ColorStateList colorStateList3, float f4, float f5, float f6) {
        final androidx.cardview.widget.g obj8 = this.p(context2, colorStateList3, f4, f5, f6);
        obj8.m(d.d());
        d.c(obj8);
        i(d);
    }

    @Override // androidx.cardview.widget.e
    public void b(androidx.cardview.widget.d d, float f2) {
        q(d).p(f2);
        i(d);
    }

    @Override // androidx.cardview.widget.e
    public float c(androidx.cardview.widget.d d) {
        return q(d).l();
    }

    @Override // androidx.cardview.widget.e
    public float d(androidx.cardview.widget.d d) {
        return q(d).g();
    }

    @Override // androidx.cardview.widget.e
    public void e(androidx.cardview.widget.d d) {
    }

    @Override // androidx.cardview.widget.e
    public void f(androidx.cardview.widget.d d, float f2) {
        q(d).r(f2);
    }

    @Override // androidx.cardview.widget.e
    public float g(androidx.cardview.widget.d d) {
        return q(d).i();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList h(androidx.cardview.widget.d d) {
        return q(d).f();
    }

    @Override // androidx.cardview.widget.e
    public void i(androidx.cardview.widget.d d) {
        Rect rect = new Rect();
        q(d).h(rect);
        d.b((int)ceil, (int)ceil2);
        d.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.widget.e
    public void j() {
        c.a aVar = new c.a(this);
        g.r = aVar;
    }

    @Override // androidx.cardview.widget.e
    public float k(androidx.cardview.widget.d d) {
        return q(d).j();
    }

    @Override // androidx.cardview.widget.e
    public float l(androidx.cardview.widget.d d) {
        return q(d).k();
    }

    @Override // androidx.cardview.widget.e
    public void m(androidx.cardview.widget.d d) {
        q(d).m(d.d());
        i(d);
    }

    @Override // androidx.cardview.widget.e
    public void n(androidx.cardview.widget.d d, ColorStateList colorStateList2) {
        q(d).o(colorStateList2);
    }

    @Override // androidx.cardview.widget.e
    public void o(androidx.cardview.widget.d d, float f2) {
        q(d).q(f2);
        i(d);
    }
}
