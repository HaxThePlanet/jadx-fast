package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import d.h.k.i;
import d.n.a.a.b;

/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    private static final int[] A;
    private static final Interpolator y;
    private static final Interpolator z;
    private final androidx.swiperefreshlayout.widget.b.c a;
    private float b;
    private Resources c;
    private Animator v;
    float w;
    boolean x;

    class a implements ValueAnimator.AnimatorUpdateListener {

        final androidx.swiperefreshlayout.widget.b.c a;
        final androidx.swiperefreshlayout.widget.b b;
        a(androidx.swiperefreshlayout.widget.b b, androidx.swiperefreshlayout.widget.b.c b$c2) {
            this.b = b;
            this.a = c2;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float obj4 = (Float)valueAnimator.getAnimatedValue().floatValue();
            this.b.o(obj4, this.a);
            this.b.b(obj4, this.a, false);
            this.b.invalidateSelf();
        }
    }

    class b implements Animator.AnimatorListener {

        final androidx.swiperefreshlayout.widget.b.c a;
        final androidx.swiperefreshlayout.widget.b b;
        b(androidx.swiperefreshlayout.widget.b b, androidx.swiperefreshlayout.widget.b.c b$c2) {
            this.b = b;
            this.a = c2;
            super();
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            int z;
            int i;
            androidx.swiperefreshlayout.widget.b.c obj5;
            i = 1065353216;
            final int i2 = 1;
            this.b.b(i, this.a, i2);
            this.a.A();
            this.a.l();
            androidx.swiperefreshlayout.widget.b bVar2 = this.b;
            if (bVar2.x) {
                z = 0;
                bVar2.x = z;
                animator.cancel();
                animator.setDuration(1332);
                animator.start();
                this.a.x(z);
            } else {
                bVar2.w = obj5 += i;
            }
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationStart(Animator animator) {
            obj2.w = 0;
        }
    }

    private static class c {

        final RectF a;
        final Paint b;
        final Paint c;
        final Paint d;
        float e = 0f;
        float f = 0f;
        float g = 0f;
        float h = 5f;
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p = 1f;
        float q;
        int r;
        int s;
        int t = 255;
        int u;
        c() {
            super();
            RectF rectF = new RectF();
            this.a = rectF;
            Paint paint = new Paint();
            this.b = paint;
            Paint paint2 = new Paint();
            this.c = paint2;
            Paint paint3 = new Paint();
            this.d = paint3;
            int i2 = 0;
            int i3 = 1084227584;
            int i4 = 1065353216;
            int i5 = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            int i6 = 1;
            paint.setAntiAlias(i6);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(i6);
            paint3.setColor(0);
        }

        void A() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }

        void a(Canvas canvas, Rect rect2) {
            int cmp;
            int i2;
            int i;
            final RectF rectF2 = this.a;
            float f = this.q;
            int i14 = 1073741824;
            i7 += f;
            if (Float.compare(f, i) <= 0) {
                i2 = cmp - f8;
            }
            rectF2.set(f2 -= i2, f9 -= i2, f13 += i2, obj10 += i2);
            float f3 = this.g;
            int i8 = 1135869952;
            obj10 *= i8;
            final int i23 = i18 - obj10;
            this.b.setColor(this.u);
            this.b.setAlpha(this.t);
            f4 /= i14;
            rectF2.inset(i4, i4);
            canvas.drawCircle(rectF2.centerX(), rectF2.centerY(), width2 /= i14, this.d);
            int i5 = -i4;
            rectF2.inset(i5, i5);
            canvas.drawArc(rectF2, obj10, i23, false, this.b);
            b(canvas, obj10, i23, rectF2);
        }

        void b(Canvas canvas, float f2, float f3, RectF rectF4) {
            Path path2;
            boolean z;
            Path.FillType eVEN_ODD;
            int i3;
            Path path;
            int i;
            float f;
            int i2;
            int obj9;
            int obj10;
            float obj11;
            if (this.n) {
                path2 = this.o;
                if (path2 == null) {
                    path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path2.reset();
                }
                int i7 = 1073741824;
                int i12 = 0;
                this.o.moveTo(i12, i12);
                this.o.lineTo(f9 *= f10, i12);
                f = this.p;
                this.o.lineTo(i14 /= i7, f11 *= f);
                this.o.offset(i5 -= i11, centerY += i);
                this.o.close();
                this.c.setColor(this.u);
                this.c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 += f3, rectF4.centerX(), rectF4.centerY());
                canvas.drawPath(this.o, this.c);
                canvas.restore();
            }
        }

        int c() {
            return this.t;
        }

        float d() {
            return this.f;
        }

        int e() {
            return this.i[f()];
        }

        int f() {
            return i2 %= length;
        }

        float g() {
            return this.e;
        }

        int h() {
            return this.i[this.j];
        }

        float i() {
            return this.l;
        }

        float j() {
            return this.m;
        }

        float k() {
            return this.k;
        }

        void l() {
            t(f());
        }

        void m() {
            final int i = 0;
            this.k = i;
            this.l = i;
            this.m = i;
            y(i);
            v(i);
            w(i);
        }

        void n(int i) {
            this.t = i;
        }

        void o(float f, float f2) {
            this.r = (int)f;
            this.s = (int)f2;
        }

        void p(float f) {
            if (Float.compare(f, f2) != 0) {
                this.p = f;
            }
        }

        void q(float f) {
            this.q = f;
        }

        void r(int i) {
            this.u = i;
        }

        void s(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }

        void t(int i) {
            this.j = i;
            this.u = this.i[i];
        }

        void u(int[] iArr) {
            this.i = iArr;
            t(0);
        }

        void v(float f) {
            this.f = f;
        }

        void w(float f) {
            this.g = f;
        }

        void x(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void y(float f) {
            this.e = f;
        }

        void z(float f) {
            this.h = f;
            this.b.setStrokeWidth(f);
        }
    }
    static {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        b.y = linearInterpolator;
        b bVar = new b();
        b.z = bVar;
        int[] iArr = new int[1];
        b.A = iArr;
    }

    public b(Context context) {
        super();
        i.c(context);
        this.c = (Context)context.getResources();
        b.c obj2 = new b.c();
        this.a = obj2;
        obj2.u(b.A);
        l(1075838976);
        n();
    }

    private void a(float f, androidx.swiperefreshlayout.widget.b.c b$c2) {
        o(f, c2);
        int i5 = 1061997773;
        c2.y(f4 += i10);
        c2.v(c2.i());
        c2.w(f6 += i4);
    }

    private int c(float f, int i2, int i3) {
        i &= 255;
        i9 &= 255;
        i16 &= 255;
        i2 &= 255;
        return i8 | obj8;
    }

    private void i(float f) {
        this.b = f;
    }

    private void j(float f, float f2, float f3, float f4) {
        final androidx.swiperefreshlayout.widget.b.c cVar = this.a;
        float density = displayMetrics.density;
        cVar.z(f2 *= density);
        cVar.q(f *= density);
        cVar.t(0);
        cVar.o(f3 *= density, f4 *= density);
    }

    private void n() {
        final androidx.swiperefreshlayout.widget.b.c cVar = this.a;
        float[] fArr = new float[2];
        fArr = new int[]{0, 1065353216};
        ValueAnimator float = ValueAnimator.ofFloat(fArr);
        b.a aVar = new b.a(this, cVar);
        float.addUpdateListener(aVar);
        float.setRepeatCount(-1);
        float.setRepeatMode(1);
        float.setInterpolator(b.y);
        b.b bVar = new b.b(this, cVar);
        float.addListener(bVar);
        this.v = float;
    }

    @Override // android.graphics.drawable.Drawable
    void b(float f, androidx.swiperefreshlayout.widget.b.c b$c2, boolean z3) {
        int z;
        int cmp;
        float interpolation;
        int i2;
        float f2;
        int i3;
        Interpolator interpolator;
        int i;
        float obj8;
        int obj10;
        if (this.x) {
            a(f, c2);
        } else {
            z = 1065353216;
            if (Float.compare(f, z) == 0) {
                if (z3 != 0) {
                    int i11 = 1056964608;
                    int i17 = 1008981770;
                    i3 = 1061830001;
                    if (Float.compare(f, i11) < 0) {
                        i10 += cmp;
                    } else {
                        f3 += i3;
                        cmp = i7;
                        z = i;
                    }
                    c2.y(cmp);
                    c2.v(z);
                    c2.w(obj10 += i14);
                    i(obj8 *= i2);
                }
            } else {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void d(boolean z) {
        this.a.x(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        final Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.b, bounds.exactCenterX(), bounds.exactCenterY());
        this.a.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void e(float f) {
        this.a.p(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void f(float f) {
        this.a.q(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void g(int... iArr) {
        this.a.u(iArr);
        this.a.t(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void h(float f) {
        this.a.w(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isRunning() {
        return this.v.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void k(float f, float f2) {
        this.a.y(f);
        this.a.v(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void l(float f) {
        this.a.z(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void m(int i) {
        int i2;
        int i3;
        int i4;
        int obj4;
        if (i == 0) {
            j(1093664768, 1077936128, 1094713344, 1086324736);
        } else {
            j(1089470464, 1075838976, 1092616192, 1084227584);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    void o(float f, androidx.swiperefreshlayout.widget.b.c b$c2) {
        int i;
        int cmp;
        int obj3;
        i = 1061158912;
        if (Float.compare(f, i) > 0) {
            c2.r(c(obj3 /= i2, c2.h(), c2.e()));
        } else {
            c2.r(c2.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.n(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void start() {
        Animator animator;
        int i;
        this.v.cancel();
        this.a.A();
        if (Float.compare(f, f2) != 0) {
            this.x = true;
            this.v.setDuration(666);
            this.v.start();
        } else {
            this.a.t(0);
            this.a.m();
            this.v.setDuration(1332);
            this.v.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void stop() {
        this.v.cancel();
        i(0);
        final int i2 = 0;
        this.a.x(i2);
        this.a.t(i2);
        this.a.m();
        invalidateSelf();
    }
}
