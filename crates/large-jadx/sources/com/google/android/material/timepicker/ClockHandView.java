package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.k;
import f.c.a.e.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class ClockHandView extends View {

    private final float A;
    private final Paint B;
    private final RectF C;
    private final int D;
    private float E;
    private boolean F;
    private com.google.android.material.timepicker.ClockHandView.c G;
    private double H;
    private int I;
    private ValueAnimator a;
    private boolean b;
    private float c;
    private float v;
    private boolean w;
    private int x;
    private final List<com.google.android.material.timepicker.ClockHandView.d> y;
    private final int z;

    class a implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.timepicker.ClockHandView a;
        a(com.google.android.material.timepicker.ClockHandView clockHandView) {
            this.a = clockHandView;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.a(this.a, (Float)valueAnimator.getAnimatedValue().floatValue(), true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b(com.google.android.material.timepicker.ClockHandView clockHandView) {
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        public abstract void d(float f, boolean z2);
    }

    public interface d {
        public abstract void b(float f, boolean z2);
    }
    public ClockHandView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.E);
    }

    public ClockHandView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        ArrayList arrayList = new ArrayList();
        this.y = arrayList;
        Paint paint = new Paint();
        this.B = paint;
        RectF rectF = new RectF();
        this.C = rectF;
        final TypedArray obj5 = context.obtainStyledAttributes(attributeSet2, l.m1, i3, k.B);
        int i = 0;
        this.I = obj5.getDimensionPixelSize(l.o1, i);
        this.z = obj5.getDimensionPixelSize(l.p1, i);
        Resources obj6 = getResources();
        this.D = obj6.getDimensionPixelSize(d.s);
        this.A = (float)obj6;
        paint.setAntiAlias(true);
        paint.setColor(obj5.getColor(l.n1, i));
        l(0);
        this.x = ViewConfiguration.get(context).getScaledTouchSlop();
        u.v0(this, 2);
        obj5.recycle();
    }

    static void a(com.google.android.material.timepicker.ClockHandView clockHandView, float f2, boolean z3) {
        clockHandView.n(f2, z3);
    }

    private void c(Canvas canvas) {
        height /= 2;
        width /= 2;
        final float f13 = (float)i3;
        final float f14 = (float)i;
        i11 += f14;
        this.B.setStrokeWidth(0);
        Paint paint4 = this.B;
        canvas.drawCircle(i8 += f13, i12, (float)i13, paint4);
        double d9 = (double)f11;
        this.B.setStrokeWidth((float)i6);
        canvas.drawLine(f13, f14, (float)i4, (float)i2, this.B);
        canvas.drawCircle(f13, f14, this.A, this.B);
    }

    private int e(float f, float f2) {
        int obj5;
        f2 -= obj5;
        obj5 += 90;
        if (obj5 < 0) {
            obj5 += 360;
        }
        return obj5;
    }

    private Pair<Float, Float> h(float f) {
        float f2;
        int cmp2;
        int cmp;
        int i;
        int obj5;
        f2 = f();
        final int i3 = 1127481344;
        i = 1135869952;
        if (Float.compare(f3, i3) > 0 && Float.compare(f2, i3) > 0 && Float.compare(f, i3) < 0) {
            i = 1135869952;
            if (Float.compare(f2, i3) > 0) {
                if (Float.compare(f, i3) < 0) {
                    f += i;
                }
            }
            if (Float.compare(f2, i3) < 0 && Float.compare(obj5, i3) > 0) {
                if (Float.compare(obj5, i3) > 0) {
                    f2 += i;
                }
            }
        }
        Pair pair = new Pair(Float.valueOf(f2), Float.valueOf(obj5));
        return pair;
    }

    private boolean i(float f, float f2, boolean z3, boolean z4, boolean z5) {
        int i;
        int obj4;
        float obj3 = (float)obj3;
        i = 0;
        final int i2 = 1;
        obj4 = Float.compare(obj4, obj3) != 0 ? i2 : i;
        if (z4 && obj4 != null) {
            if (obj4 != null) {
                return i2;
            }
        }
        if (obj4 == null && z3) {
            if (z3) {
            }
            return i;
        }
        if (z5 && this.b) {
            if (this.b) {
                i = i2;
            }
        }
        m(obj3, i);
        return i2;
    }

    private void n(float f, boolean z2) {
        int next;
        f %= i;
        this.E = obj8;
        this.H = Math.toRadians((double)i3);
        f3 += i10;
        f2 += i12;
        int i13 = this.z;
        this.C.set(i8 - f9, i5 - f10, i8 += f11, i5 += f8);
        Iterator iterator = this.y.iterator();
        for (ClockHandView.d next : iterator) {
            next.b(obj8, z2);
        }
        invalidate();
    }

    @Override // android.view.View
    public void b(com.google.android.material.timepicker.ClockHandView.d clockHandView$d) {
        this.y.add(d);
    }

    @Override // android.view.View
    public RectF d() {
        return this.C;
    }

    @Override // android.view.View
    public float f() {
        return this.E;
    }

    @Override // android.view.View
    public int g() {
        return this.z;
    }

    @Override // android.view.View
    public void j(boolean z) {
        this.b = z;
    }

    @Override // android.view.View
    public void k(int i) {
        this.I = i;
        invalidate();
    }

    @Override // android.view.View
    public void l(float f) {
        m(f, false);
    }

    @Override // android.view.View
    public void m(float f, boolean z2) {
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i = 0;
        if (!z2) {
            n(f, i);
        }
        Pair obj3 = h(f);
        float[] obj4 = new float[2];
        float floatValue = (Float)obj3.first.floatValue();
        obj4[i] = floatValue;
        obj4[1] = (Float)obj3.second.floatValue();
        obj3 = ValueAnimator.ofFloat(obj4);
        this.a = obj3;
        obj3.setDuration(200);
        obj4 = new ClockHandView.a(this);
        this.a.addUpdateListener(obj4);
        obj4 = new ClockHandView.b(this);
        this.a.addListener(obj4);
        this.a.start();
    }

    @Override // android.view.View
    public void o(com.google.android.material.timepicker.ClockHandView.c clockHandView$c) {
        this.G = c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        l(f());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        int i6;
        int i4;
        int i5;
        int i;
        int i7;
        float obj11;
        int actionMasked = motionEvent.getActionMasked();
        final float f5 = motionEvent.getX();
        obj11 = motionEvent.getY();
        int i8 = 0;
        final int i17 = 1;
        if (actionMasked != 0) {
            if (actionMasked != i17 && actionMasked != 2) {
                if (actionMasked != 2) {
                    i7 = i;
                } else {
                    int i10 = (int)i9;
                    int i14 = (int)i13;
                    i4 = i11 += i15 > this.x ? i17 : i8;
                    this.w = i4;
                    i2 = actionMasked == i17 ? i17 : i8;
                    i7 = i8;
                    i = i6;
                }
            } else {
            }
        } else {
            this.c = f5;
            this.v = obj11;
            this.w = i17;
            this.F = i8;
            i = i2;
            i7 = i17;
        }
        z |= z2;
        this.F = i3;
        i2 = this.G;
        if (i3 != 0 && i2 != 0 && i2 != null) {
            if (i2 != 0) {
                i2 = this.G;
                if (i2 != null) {
                    i2.d((float)obj11, this.w);
                }
            }
        }
        return i17;
    }
}
