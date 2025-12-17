package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import d.h.l.u;

/* loaded from: classes.dex */
public abstract class c implements View.OnTouchListener {

    private static final int J;
    private float[] A;
    private float[] B;
    private float[] C;
    private boolean D;
    boolean E;
    boolean F;
    boolean G;
    private boolean H;
    private boolean I;
    final androidx.core.widget.c.a a;
    private final Interpolator b;
    final View c;
    private Runnable v;
    private float[] w;
    private float[] x;
    private int y;
    private int z;

    private static class a {

        private int a;
        private int b;
        private float c;
        private float d;
        private long e = Long.MIN_VALUE;
        private long f = 0;
        private int g = 0;
        private int h = 0;
        private long i = -1;
        private float j;
        private int k;
        a() {
            super();
            long l = Long.MIN_VALUE;
            int i = -1;
            int i2 = 0;
            int i3 = 0;
        }

        private float e(long l) {
            int cmp;
            long l2 = this.e;
            final int i5 = 0;
            if (Long.compare(l, l2) < 0) {
                return i5;
            }
            final long l3 = this.i;
            int i7 = 1065353216;
            if (Long.compare(l3, i6) >= 0 && Long.compare(l, l3) < 0) {
                if (Long.compare(l, l3) < 0) {
                }
                float f = this.j;
                return i3 += i;
            }
            return obj9 *= i2;
        }

        private float g(float f) {
            return i3 += obj3;
        }

        public void a() {
            if (Long.compare(l, i6) == 0) {
            } else {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                this.f = currentAnimationTimeMillis;
                f *= f5;
                this.g = (int)i4;
                this.h = (int)i2;
            }
            RuntimeException runtimeException = new RuntimeException("Cannot compute scroll delta before calling start()");
            throw runtimeException;
        }

        public int b() {
            return this.g;
        }

        public int c() {
            return this.h;
        }

        public int d() {
            float f = this.c;
            return (int)i;
        }

        public int f() {
            float f = this.d;
            return (int)i;
        }

        public boolean h() {
            int cmp;
            int i;
            int i2;
            long l;
            if (Long.compare(l2, i2) > 0 && Long.compare(currentAnimationTimeMillis, i2) > 0) {
                i = Long.compare(currentAnimationTimeMillis, i2) > 0 ? 1 : 0;
            } else {
            }
            return i;
        }

        public void i() {
            final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = c.f((int)i, 0, this.b);
            this.j = e(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void j(int i) {
            this.b = i;
        }

        public void k(int i) {
            this.a = i;
        }

        public void l(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.e = currentAnimationTimeMillis;
            this.i = -1;
            this.f = currentAnimationTimeMillis;
            this.j = 1056964608;
            int i2 = 0;
            this.g = i2;
            this.h = i2;
        }
    }

    private class b implements Runnable {

        final androidx.core.widget.c a;
        b(androidx.core.widget.c c) {
            this.a = c;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object cVar;
            boolean z;
            cVar = this.a;
            if (!cVar.G) {
            }
            int i3 = 0;
            if (cVar.E) {
                cVar.E = i3;
                cVar.a.m();
            }
            androidx.core.widget.c.a aVar = cVar2.a;
            if (!aVar.h()) {
                if (!this.a.u()) {
                } else {
                    androidx.core.widget.c cVar6 = this.a;
                    if (cVar6.F) {
                        cVar6.F = i3;
                        cVar6.c();
                    }
                }
                aVar.a();
                this.a.j(aVar.b(), aVar.c());
                u.d0(cVar4.c, this);
            }
            cVar3.G = i3;
        }
    }
    static {
        c.J = ViewConfiguration.getTapTimeout();
    }

    public c(View view) {
        super();
        c.a aVar = new c.a();
        this.a = aVar;
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.b = accelerateInterpolator;
        int i = 2;
        float[] fArr2 = new float[i];
        fArr2 = new int[]{0, 0};
        this.w = fArr2;
        float[] fArr3 = new float[i];
        fArr3 = new int[]{2139095039, 2139095039};
        this.x = fArr3;
        float[] fArr4 = new float[i];
        fArr4 = new int[]{0, 0};
        this.A = fArr4;
        float[] fArr5 = new float[i];
        fArr5 = new int[]{0, 0};
        this.B = fArr5;
        float[] fArr = new float[i];
        fArr = new int[]{2139095039, 2139095039};
        this.C = fArr;
        this.c = view;
        float obj4 = obj4.density;
        int i6 = 1056964608;
        float f = (float)i5;
        o(f, f);
        obj4 = (float)obj4;
        p(obj4, obj4);
        l(1);
        obj4 = 2139095039;
        n(obj4, obj4);
        obj4 = 1045220557;
        s(obj4, obj4);
        obj4 = 1065353216;
        t(obj4, obj4);
        k(c.J);
        obj4 = 500;
        r(obj4);
        q(obj4);
    }

    private float d(int i, float f2, float f3, float f4) {
        float obj5 = h(this.w[i], f3, this.x[i], f2);
        int obj6 = 0;
        int cmp = Float.compare(obj5, obj6);
        if (cmp == 0) {
            return obj6;
        }
        float f6 = this.B[i];
        float obj4 = this.C[i];
        obj6 *= f4;
        if (cmp > 0) {
            return c.e(obj5 *= obj6, f6, obj4);
        }
        return -obj4;
    }

    static float e(float f, float f2, float f3) {
        if (Float.compare(f, f3) > 0) {
            return f3;
        }
        if (Float.compare(f, f2) < 0) {
            return f2;
        }
        return f;
    }

    static int f(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    private float g(float f, float f2) {
        int cmp2;
        int i;
        int cmp;
        int i2;
        int obj6;
        final int i3 = 0;
        if (Float.compare(f2, i3) == 0) {
            return i3;
        }
        cmp2 = this.y;
        i = 1;
        if (cmp2 != 0 && cmp2 != i) {
            if (cmp2 != i) {
                if (cmp2 != 2) {
                } else {
                    if (Float.compare(f, i3) < 0) {
                        return f /= obj7;
                    }
                }
            } else {
                i2 = 1065353216;
                if (Float.compare(f, f2) < 0 && Float.compare(f, i3) >= 0) {
                    i2 = 1065353216;
                    if (Float.compare(f, i3) >= 0) {
                        return i2 -= obj6;
                    }
                    if (this.G && cmp2 == i) {
                        if (cmp2 == i) {
                            return i2;
                        }
                    }
                }
            }
        } else {
        }
        return i3;
    }

    private float h(float f, float f2, float f3, float f4) {
        int obj2;
        Interpolator obj3;
        final int i = 0;
        obj2 = c.e(f *= f2, i, f3);
        obj2 -= obj4;
        if (Float.compare(obj2, i) < 0) {
            obj2 = -obj2;
            return c.e(obj2, -1082130432, 1065353216);
        } else {
            if (Float.compare(obj2, i) > 0) {
                obj2 = this.b.getInterpolation(obj2);
            }
        }
        return i;
    }

    private void i() {
        int i;
        if (this.E) {
            this.G = false;
        } else {
            this.a.i();
        }
    }

    private void v() {
        Runnable bVar;
        boolean z;
        View view;
        Runnable runnable;
        long l;
        if (this.v == null) {
            bVar = new c.b(this);
            this.v = bVar;
        }
        int i = 1;
        this.G = i;
        this.E = i;
        z = this.z;
        if (!this.D && z > 0) {
            z = this.z;
            if (z > 0) {
                u.e0(this.c, this.v, (long)z);
            } else {
                this.v.run();
            }
        } else {
        }
        this.D = i;
    }

    @Override // android.view.View$OnTouchListener
    public abstract boolean a(int i);

    @Override // android.view.View$OnTouchListener
    public abstract boolean b(int i);

    @Override // android.view.View$OnTouchListener
    void c() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, obj1, uptimeMillis, obj3, 3, 0);
        this.c.onTouchEvent(obtain);
        obtain.recycle();
    }

    @Override // android.view.View$OnTouchListener
    public abstract void j(int i, int i2);

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c k(int i) {
        this.z = i;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c l(int i) {
        this.y = i;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c m(boolean z) {
        if (this.H && !z) {
            if (!z) {
                i();
            }
        }
        this.H = z;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c n(float f, float f2) {
        final float[] fArr = this.x;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c o(float f, float f2) {
        final float[] fArr = this.C;
        final int i = 1148846080;
        fArr[0] = f /= i;
        fArr[1] = f2 /= i;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent2) {
        int actionMasked;
        int i2;
        int i;
        float f;
        int obj6;
        androidx.core.widget.c.a obj7;
        i2 = 0;
        if (!this.H) {
            return i2;
        }
        actionMasked = motionEvent2.getActionMasked();
        final int i3 = 1;
        if (actionMasked != 0) {
            if (actionMasked != i3) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    } else {
                        i();
                    }
                } else {
                    this.a.l(d(i2, motionEvent2.getX(), (float)width, (float)width2), d(i3, motionEvent2.getY(), (float)obj6, (float)height));
                    if (!this.G && u()) {
                        if (u()) {
                            v();
                        }
                    }
                }
            } else {
            }
        } else {
            this.F = i3;
            this.D = i2;
        }
        if (this.I && this.G) {
            if (this.G) {
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c p(float f, float f2) {
        final float[] fArr = this.B;
        final int i = 1148846080;
        fArr[0] = f /= i;
        fArr[1] = f2 /= i;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c q(int i) {
        this.a.j(i);
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c r(int i) {
        this.a.k(i);
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c s(float f, float f2) {
        final float[] fArr = this.w;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.c t(float f, float f2) {
        final float[] fArr = this.A;
        final int i = 1148846080;
        fArr[0] = f /= i;
        fArr[1] = f2 /= i;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    boolean u() {
        int i;
        int i3;
        boolean i2;
        androidx.core.widget.c.a aVar = this.a;
        i2 = aVar.f();
        i3 = aVar.d();
        if (i2 != 0) {
            if (!b(i2)) {
                if (i3 != 0 && a(i3)) {
                    i = a(i3) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
