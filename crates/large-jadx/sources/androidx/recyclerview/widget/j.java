package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.ViewGroup;
import d.h.l.u;

/* loaded from: classes.dex */
class j extends androidx.recyclerview.widget.RecyclerView.o implements androidx.recyclerview.widget.RecyclerView.t {

    private static final int[] D;
    private static final int[] E;
    int A = 0;
    private final Runnable B;
    private final androidx.recyclerview.widget.RecyclerView.u C;
    private final int a;
    private final int b;
    final StateListDrawable c;
    final Drawable d;
    private final int e;
    private final int f;
    private final StateListDrawable g;
    private final Drawable h;
    private final int i;
    private final int j;
    int k;
    int l;
    float m;
    int n;
    int o;
    float p;
    private int q = 0;
    private int r = 0;
    private androidx.recyclerview.widget.RecyclerView s;
    private boolean t = false;
    private boolean u = false;
    private int v = 0;
    private int w = 0;
    private final int[] x;
    private final int[] y;
    final ValueAnimator z;

    class a implements Runnable {

        final androidx.recyclerview.widget.j a;
        a(androidx.recyclerview.widget.j j) {
            this.a = j;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.m(500);
        }
    }

    private class c extends AnimatorListenerAdapter {

        private boolean a = false;
        final androidx.recyclerview.widget.j b;
        c(androidx.recyclerview.widget.j j) {
            this.b = j;
            super();
            final int obj1 = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i;
            androidx.recyclerview.widget.j obj3;
            i = 0;
            if (this.a) {
                this.a = i;
            }
            if (Float.compare(obj3, i2) == 0) {
                obj3 = this.b;
                obj3.A = i;
                obj3.u(i);
            } else {
                obj3 = this.b;
                obj3.A = 2;
                obj3.r();
            }
        }
    }

    private class d implements ValueAnimator.AnimatorUpdateListener {

        final androidx.recyclerview.widget.j a;
        d(androidx.recyclerview.widget.j j) {
            this.a = j;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int obj2 = (int)obj2;
            jVar.c.setAlpha(obj2);
            jVar2.d.setAlpha(obj2);
            this.a.r();
        }
    }

    class b extends androidx.recyclerview.widget.RecyclerView.u {

        final androidx.recyclerview.widget.j a;
        b(androidx.recyclerview.widget.j j) {
            this.a = j;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
            this.a.x(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }
    static {
        int[] iArr = new int[1];
        final int i3 = 0;
        iArr[i3] = 16842919;
        j.D = iArr;
        j.E = new int[i3];
    }

    j(androidx.recyclerview.widget.RecyclerView recyclerView, StateListDrawable stateListDrawable2, Drawable drawable3, StateListDrawable stateListDrawable4, Drawable drawable5, int i6, int i7, int i8) {
        super();
        int i = 0;
        int i4 = 2;
        this.x = new int[i4];
        this.y = new int[i4];
        float[] fArr = new float[i4];
        fArr = new int[]{0, 1065353216};
        ValueAnimator float = ValueAnimator.ofFloat(fArr);
        this.z = float;
        j.a aVar = new j.a(this);
        this.B = aVar;
        j.b bVar = new j.b(this);
        this.C = bVar;
        this.c = stateListDrawable2;
        this.d = drawable3;
        this.g = stateListDrawable4;
        this.h = drawable5;
        this.e = Math.max(i6, stateListDrawable2.getIntrinsicWidth());
        this.f = Math.max(i6, drawable3.getIntrinsicWidth());
        this.i = Math.max(i6, stateListDrawable4.getIntrinsicWidth());
        this.j = Math.max(i6, drawable5.getIntrinsicWidth());
        this.a = i7;
        this.b = i8;
        int obj7 = 255;
        stateListDrawable2.setAlpha(obj7);
        drawable3.setAlpha(obj7);
        j.c obj5 = new j.c(this);
        float.addListener(obj5);
        obj5 = new j.d(this);
        float.addUpdateListener(obj5);
        f(recyclerView);
    }

    private void g() {
        this.s.removeCallbacks(this.B);
    }

    private void h() {
        this.s.d1(this);
        this.s.g1(this);
        this.s.h1(this.C);
        g();
    }

    private void i(Canvas canvas) {
        int i4 = this.i;
        i -= i4;
        int i8 = this.n;
        i6 -= i11;
        final int i13 = 0;
        this.g.setBounds(i13, i13, i8, i4);
        this.h.setBounds(i13, i13, this.q, this.j);
        int i10 = 0;
        canvas.translate(i10, (float)i2);
        this.h.draw(canvas);
        canvas.translate((float)i7, i10);
        this.g.draw(canvas);
        canvas.translate((float)i5, (float)i3);
    }

    private void j(Canvas canvas) {
        float f2;
        float f;
        StateListDrawable list;
        int i8 = this.e;
        i -= i8;
        int i14 = this.k;
        i12 -= i16;
        final int i18 = 0;
        this.c.setBounds(i18, i18, i8, i14);
        this.d.setBounds(i18, i18, this.f, this.r);
        if (o()) {
            this.d.draw(canvas);
            canvas.translate((float)i3, (float)i13);
            int i4 = -1082130432;
            int i9 = 1065353216;
            canvas.scale(i4, i9);
            this.c.draw(canvas);
            canvas.scale(i4, i9);
            canvas.translate((float)i6, (float)i10);
        } else {
            list = 0;
            canvas.translate((float)i2, list);
            this.d.draw(canvas);
            canvas.translate(list, (float)i13);
            this.c.draw(canvas);
            canvas.translate((float)i7, (float)i11);
        }
    }

    private int[] k() {
        final int[] iArr = this.y;
        int i = this.b;
        iArr[0] = i;
        iArr[1] = i4 -= i;
        return iArr;
    }

    private int[] l() {
        final int[] iArr = this.x;
        int i = this.b;
        iArr[0] = i;
        iArr[1] = i4 -= i;
        return iArr;
    }

    private void n(float f) {
        float f2;
        final int[] iArr = k();
        final int i9 = 0;
        float obj9 = Math.max((float)i, Math.min((float)i6, f));
        if (Float.compare(f5, i7) < 0) {
        }
        int i4 = this.t(this.p, obj9, iArr, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
        if (i4 != 0) {
            this.s.scrollBy(i4, i9);
        }
        this.p = obj9;
    }

    private boolean o() {
        int i;
        if (u.B(this.s) == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private void s(int i) {
        g();
        this.s.postDelayed(this.B, (long)i);
    }

    private int t(float f, float f2, int[] i3Arr3, int i4, int i5, int i6) {
        final int i7 = 0;
        i2 -= obj5;
        if (i3 == 0) {
            return i7;
        }
        i4 -= i6;
        int obj3 = (int)obj4;
        i5 += obj3;
        if (obj7 < obj6 && obj7 >= 0) {
            if (obj7 >= 0) {
                return obj3;
            }
        }
        return i7;
    }

    private void v() {
        this.s.h(this);
        this.s.k(this);
        this.s.l(this.C);
    }

    private void y(float f) {
        float f2;
        final int[] iArr = l();
        final int i9 = 0;
        float obj9 = Math.max((float)i, Math.min((float)i6, f));
        if (Float.compare(f5, i7) < 0) {
        }
        int i4 = this.t(this.m, obj9, iArr, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
        if (i4 != 0) {
            this.s.scrollBy(i9, i4);
        }
        this.m = obj9;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void a(androidx.recyclerview.widget.RecyclerView recyclerView, MotionEvent motionEvent2) {
        boolean z;
        float f;
        float obj5;
        if (this.v == 0) {
        }
        final int i = 1;
        final int i2 = 2;
        if (motionEvent2.getAction() == 0) {
            obj5 = q(motionEvent2.getX(), motionEvent2.getY());
            z = p(motionEvent2.getX(), motionEvent2.getY());
            if (obj5 == null) {
                if (z) {
                    if (z) {
                        this.w = i;
                        this.p = (float)obj5;
                    } else {
                        if (obj5 != null) {
                            this.w = i2;
                            this.m = (float)obj5;
                        }
                    }
                    u(i2);
                }
            } else {
            }
        } else {
            if (motionEvent2.getAction() == i && this.v == i2) {
                if (this.v == i2) {
                    obj5 = 0;
                    this.m = obj5;
                    this.p = obj5;
                    u(i);
                    this.w = 0;
                } else {
                    w();
                    if (motionEvent2.getAction() == i2 && this.v == i2 && this.w == i) {
                        if (this.v == i2) {
                            w();
                            if (this.w == i) {
                                n(motionEvent2.getX());
                            }
                            if (this.w == i2) {
                                y(motionEvent2.getY());
                            }
                        }
                    }
                }
            } else {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public boolean c(androidx.recyclerview.widget.RecyclerView recyclerView, MotionEvent motionEvent2) {
        int i;
        boolean z;
        int action;
        int obj6;
        obj6 = this.v;
        i = 0;
        final int i2 = 2;
        final int i3 = 1;
        if (obj6 == i3) {
            obj6 = q(motionEvent2.getX(), motionEvent2.getY());
            z = p(motionEvent2.getX(), motionEvent2.getY());
            if (motionEvent2.getAction() == 0) {
                if (obj6 == null) {
                    if (z) {
                        if (z) {
                            this.w = i3;
                            this.p = (float)obj6;
                        } else {
                            if (obj6 != null) {
                                this.w = i2;
                                this.m = (float)obj6;
                            }
                        }
                        u(i2);
                        i = i3;
                    }
                } else {
                }
            }
        } else {
            if (obj6 == i2) {
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void e(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void f(androidx.recyclerview.widget.RecyclerView recyclerView) {
        final androidx.recyclerview.widget.RecyclerView view = this.s;
        if (view == recyclerView) {
        }
        if (view != null) {
            h();
        }
        this.s = recyclerView;
        if (recyclerView != null) {
            v();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void m(int i) {
        int i3;
        int i4;
        int i2;
        float floatValue;
        ValueAnimator obj6;
        i3 = this.A;
        i4 = 2;
        final int i6 = 1;
        if (i3 != i6) {
            if (i3 != i4) {
            } else {
                this.A = 3;
                ValueAnimator valueAnimator = this.z;
                float[] fArr = new float[i4];
                fArr[0] = (Float)valueAnimator.getAnimatedValue().floatValue();
                fArr[i6] = 0;
                valueAnimator.setFloatValues(fArr);
                this.z.setDuration((long)i);
                this.z.start();
            }
        } else {
            this.z.cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        int obj2;
        int obj3;
        if (this.q == this.s.getWidth()) {
            if (this.r != this.s.getHeight()) {
            } else {
                if (this.A != 0 && this.t) {
                    if (this.t) {
                        j(canvas);
                    }
                    if (this.u) {
                        i(canvas);
                    }
                }
            }
        }
        this.q = this.s.getWidth();
        this.r = this.s.getHeight();
        u(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    boolean p(float f, float f2) {
        int i;
        int cmp;
        int obj3;
        float obj4;
        obj4 = this.o;
        i = this.n;
        if (Float.compare(f2, i) >= 0 && Float.compare(f, f3) >= 0 && Float.compare(f, obj4) <= 0) {
            obj4 = this.o;
            i = this.n;
            if (Float.compare(f, f3) >= 0) {
                obj3 = Float.compare(f, obj4) <= 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    boolean q(float f, float f2) {
        float f3;
        int cmp;
        int obj3;
        if (o()) {
            if (Float.compare(f, f3) <= 0) {
                obj3 = this.l;
                f3 = this.k;
                if (Float.compare(f2, f4) >= 0) {
                    obj3 = Float.compare(f2, obj3) <= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
            obj3 = this.l;
            f3 = this.k;
            if (Float.compare(f, f3) >= 0 && Float.compare(f2, f4) >= 0 && Float.compare(f2, obj3) <= 0) {
            } else {
            }
        }
        return obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void r() {
        this.s.invalidate();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void u(int i) {
        int i3;
        int i2;
        int[] i4;
        int[] iArr;
        int i5 = 2;
        if (i == i5 && this.v != i5) {
            if (this.v != i5) {
                this.c.setState(j.D);
                g();
            }
        }
        if (i == 0) {
            r();
        } else {
            w();
        }
        if (this.v == i5 && i != i5) {
            if (i != i5) {
                this.c.setState(j.E);
                s(1200);
            } else {
                if (i == 1) {
                    s(1500);
                }
            }
        } else {
        }
        this.v = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void w() {
        int i3;
        int i;
        float[] fArr;
        int i2;
        float floatValue;
        i3 = this.A;
        if (i3 != 0) {
            if (i3 != 3) {
            } else {
                this.z.cancel();
                int i4 = 1;
                this.A = i4;
                ValueAnimator valueAnimator3 = this.z;
                fArr = new float[2];
                fArr[i4] = 1065353216;
                valueAnimator3.setFloatValues(fArr);
                this.z.setDuration(500);
                this.z.setStartDelay(0);
                this.z.start();
            }
        } else {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void x(int i, int i2) {
        int verticalScrollRange;
        int i6;
        int i5;
        int i3;
        int i4;
        boolean z;
        int obj9;
        int obj10;
        verticalScrollRange = this.s.computeVerticalScrollRange();
        final int i7 = this.r;
        int i8 = 0;
        final int i10 = 1;
        if (verticalScrollRange - i7 > 0 && i7 >= this.a) {
            i5 = i7 >= this.a ? i10 : i8;
        } else {
        }
        this.t = i5;
        int horizontalScrollRange = this.s.computeHorizontalScrollRange();
        final int i11 = this.q;
        if (horizontalScrollRange - i11 > 0 && i11 >= this.a) {
            i4 = i11 >= this.a ? i10 : i8;
        } else {
        }
        this.u = i4;
        z = this.t;
        if (!z && i4 == 0 && this.v != 0) {
            if (i4 == 0) {
                if (this.v != 0) {
                    u(i8);
                }
            }
        }
        int i9 = 1073741824;
        if (z) {
            float f = (float)i7;
            this.l = (int)i4;
            this.k = Math.min(i7, obj10 /= verticalScrollRange);
        }
        if (this.u) {
            obj10 = (float)i11;
            this.o = (int)obj10;
            this.n = Math.min(i11, obj9 /= horizontalScrollRange);
        }
        obj9 = this.v;
        if (obj9 != null) {
            if (obj9 == i10) {
                u(i10);
            }
        } else {
        }
    }
}
