package d.j.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import d.h.l.u;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class c {

    private static final Interpolator x = new c$a();
    private int a;
    private int b;
    private int c = -1;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private final int p;
    private int q;
    private OverScroller r = new OverScroller();
    private final c.c s;
    private View t;
    private boolean u;
    private final ViewGroup v;
    private final Runnable w = new c$b();

    class a implements Interpolator {
        a() {
            super();
        }

        public float getInterpolation(float f) {
            final float f2 = 1f;
            f -= f2;
            return (f8 * f8) * f8 * f8 * f8 + f2;
        }
    }

    class b implements Runnable {

        final /* synthetic */ c a;
        b() {
            this.a = cVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.E(0);
        }
    }

    public static abstract class c {
        public abstract int a(View view, int i, int i2);

        public abstract int b(View view, int i, int i2);

        public int c(int i) {
            return i;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i, int i2) {
        }

        public boolean g(int i) {
            return false;
        }

        public void h(int i, int i2) {
        }

        public void i(View view, int i) {
        }

        public abstract void j(int i);

        public abstract void k(View view, int i, int i2, int i3, int i4);

        public abstract void l(View view, float f, float f2);

        public abstract boolean m(View view, int i);
    }

    private c(Context context, ViewGroup viewGroup, c.c cVar) {
        super();
        d.j.b.c.b bVar = new c.b(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else {
            if (cVar == null) {
                throw new IllegalArgumentException("Callback may not be null");
            } else {
                this.v = viewGroup;
                this.s = cVar;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int i4 = (int)(context.getResources().getDisplayMetrics().density * 20f) + 0.5f;
                this.p = i4;
                this.o = i4;
                this.b = viewConfiguration.getScaledTouchSlop();
                this.m = (float)viewConfiguration.getScaledMaximumFlingVelocity();
                this.n = (float)viewConfiguration.getScaledMinimumFlingVelocity();
                OverScroller overScroller = new OverScroller(context, c.x);
                return;
            }
        }
    }

    private void A() {
        this.l.computeCurrentVelocity(1000, this.m);
        n(e(this.l.getXVelocity(this.c), this.n, this.m), e(this.l.getYVelocity(this.c), this.n, this.m));
    }

    private void B(float f, float f2, int i) {
        i = 1;
        if (!(c(f, f2, i, i))) {
            i = 0;
        }
        if (c(f2, f, i, 4)) {
            i = i | 4;
        }
        if (c(f, f2, i, 2)) {
            i = i | 2;
        }
        if (c(f2, f, i, 8)) {
            i = i | 8;
        }
        if (i != 0) {
            i2 = iArr[i] | i;
            this.i[i] = i2;
            this.s.f(i, i);
        }
    }

    private void C(float f, float f2, int i) {
        q(i);
        this.f[i] = f;
        this.d[i] = f;
        this.g[i] = f2;
        this.e[i] = f2;
        this.h[i] = t((int)f, (int)f2);
        this.k |= i8;
    }

    private void D(MotionEvent motionEvent) {
        int i = 0;
        boolean z;
        float f;
        float[] fArr;
        i = 0;
        while (i < motionEvent.getPointerCount()) {
            int pointerId = motionEvent.getPointerId(i);
            i = i + 1;
        }
    }

    private boolean c(float f, float f2, int i, int i2) {
        boolean z = false;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        cmp = this.h[i] & i2;
        z = false;
        if ((this.h[i] & i2) == i2) {
            cmp = this.q & i2;
            if (this.q & i2 != 0) {
                cmp = this.j[i] & i2;
                if ((this.j[i] & i2) != i2) {
                    cmp = this.i[i] & i2;
                    if ((this.i[i] & i2) != i2) {
                        float f5 = (float)cmp;
                        if (abs <= f5) {
                            float f4 = (float)cmp;
                            if (abs2 > this.h) {
                                abs2 *= f3;
                                if (abs < this.s && this.s.g(i2)) {
                                    this.j[i] = iArr4[i] | i2;
                                    return false;
                                }
                                if (this.i[i] & i2 == 0) {
                                    abs2 = (float)this.b;
                                    if (abs > this.i[i] & i2) {
                                        int i7 = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    private boolean d(View view, float f, float f2) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int cmp;
        cmp = 0;
        if (view == null) {
            return false;
        }
        cmp = 1;
        int r1 = cmp;
        view = cmp;
        if (this.s != 0 && cmp != 0) {
            float f6 = (f * f) + (f2 * f2);
            float f4 = (float)(i3 * i3);
            if (f6 > this.b) {
            }
            return z;
        }
        if (this.s != 0) {
            float abs = Math.abs(f);
            float f7 = (float)this.b;
            if (abs > this.b) {
            }
            return z2;
        }
        if (this.b != 0) {
            float abs2 = Math.abs(f2);
            f = (float)this.b;
            if (abs2 > this.b) {
            }
        }
        return z3;
    }

    private float e(float f, float f2, float f3) {
        int i;
        final float abs = Math.abs(f);
        final float f4 = 0.0f;
        if (abs < f2) {
            return 0.0f;
        }
        if (abs > f3) {
            if (f <= 0.0f) {
                i = -f3;
            }
            return i;
        }
        return f;
    }

    private int f(int i, int i2, int i3) {
        int i4;
        final int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs > i3 && i > 0) {
            return i4;
        }
        return i;
    }

    private void g() {
        if (this.d == null) {
            return;
        }
        float f = 0.0f;
        Arrays.fill(this.d, f);
        Arrays.fill(this.e, f);
        Arrays.fill(this.f, f);
        Arrays.fill(this.g, f);
        int i = 0;
        Arrays.fill(this.h, i);
        Arrays.fill(this.i, i);
        Arrays.fill(this.j, i);
        this.k = i;
    }

    private void h(int i) {
    }

    private int i(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f4 = 1f;
        float f5 = (float)(width / 2);
        f = f5 + (o(Math.min(f4, (float)Math.abs(i) / (float)width))) * f5;
        int abs3 = Math.abs(i2);
        if (abs3 > 0) {
            f = (f5 + this.o(Math.min(f4, (float)Math.abs(i) / (float)width)) * f5) / (float)abs3;
            f2 = Math.abs(f) * 1000f;
            i4 = Math.round(f2) * 4;
        } else {
            float f2 = 256f;
            i4 = (int)(float)Math.abs(i) / (float)i3 + f4 * f2;
        }
        return Math.min(i4, 600);
    }

    private int j(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int i16 = f(i3, (int)this.n, (int)this.m);
        final int i17 = f(i4, (int)this.n, (int)this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i16);
        final int abs4 = Math.abs(i17);
        final int i10 = abs3 + abs4;
        final int i11 = abs + abs2;
        f3 = i16 != 0 ? (float)i10 : (float)i11;
        f4 = i17 != 0 ? (float)i10 : (float)i11;
        return (int)(float)(i(i, i16, this.s.d(view))) * (f / f3) + (float)(i(i2, i17, this.s.e(view))) * (f2 / f4);
    }

    public static c l(ViewGroup viewGroup, float f, c.c cVar) {
        final d.j.b.c cVar2 = c.m(viewGroup, cVar);
        cVar2.b = (int)(float)cVar2.b * (1f / f);
        return cVar2;
    }

    public static c m(ViewGroup viewGroup, c.c cVar) {
        return new c(viewGroup.getContext(), viewGroup, cVar);
    }

    private void n(float f, float f2) {
        final boolean z = true;
        this.u = z;
        this.s.l(this.t, f, f2);
        final boolean z2 = false;
        this.u = z2;
        if (this.a == z) {
            E(z2);
        }
    }

    private float o(float f) {
        return (float)(Math.sin((double)(f - 0.5f) * 0.47123894f));
    }

    private void p(int i, int i2, int i3, int i4) {
        View view;
        int i6;
        int i22;
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i3 != 0) {
            i5 = (this.s.a(this.t, i, i3)) - left;
            u.W(this.t, i5);
        }
        if (i4 != 0) {
            u.X(this.t, (this.s.b(this.t, i2, i4)) - top);
        }
        if (i3 != 0 || i4 != 0) {
            i7 = i6 - left;
            i8 = i22 - top;
            this.s.k(this.t, i6, i22, i7, i8);
        }
    }

    private void q(int i) {
        float[] fArr;
        int length2;
        int i2 = 0;
        if (this.d != null) {
            length = fArr.length;
            if (fArr.length <= i) {
                i++;
                float[] fArr8 = new float[i3];
                float[] fArr2 = new float[i3];
                float[] fArr3 = new float[i3];
                float[] fArr4 = new float[i3];
                int[] iArr = new int[i3];
                int[] iArr2 = new int[i3];
                int[] iArr3 = new int[i3];
                if (this.d != null) {
                    i2 = 0;
                    System.arraycopy(this.d, i2, fArr8, i2, fArr.length);
                    System.arraycopy(this.e, i2, fArr2, i2, fArr5.length);
                    System.arraycopy(this.f, i2, fArr3, i2, fArr6.length);
                    System.arraycopy(this.g, i2, fArr4, i2, fArr7.length);
                    System.arraycopy(this.h, i2, iArr, i2, iArr4.length);
                    System.arraycopy(this.i, i2, iArr2, i2, iArr5.length);
                    length2 = iArr6.length;
                    System.arraycopy(this.j, i2, iArr3, i2, length2);
                }
                this.d = fArr8;
                this.e = fArr2;
                this.f = fArr3;
                this.g = fArr4;
                this.h = iArr;
                this.i = iArr2;
                this.j = iArr3;
            }
        }
    }

    private boolean s(int i, int i2, int i3, int i4) {
        final int left = this.t.getLeft();
        final int top = this.t.getTop();
        i -= left;
        i2 -= top;
        if (i5 == 0 && i22 == 0) {
            this.r.abortAnimation();
            int i10 = 0;
            E(i10);
            return false;
        }
        this.r.startScroll(left, top, i5, i22, this.j(this.t, i5, i22, i3, i4));
        E(2);
        return true;
    }

    private int t(int i, int i2) {
        int i3 = 0;
        int r0 = i < this.v.getLeft() + this.o ? 1 : 0;
        if (i2 < this.v.getTop() + this.o) {
            i3 = i3 | 4;
        }
        if (i > this.v.getRight() - this.o) {
            i3 = i3 | 2;
        }
        if (i2 > this.v.getBottom() - this.o) {
            i3 = i3 | 8;
        }
        return i3;
    }

    private boolean x(int i) {
        if (!w(i)) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Ignoring pointerId=";
            String str3 = " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.";
            str4 = str2 + i + str3;
            Log.e("ViewDragHelper", str4);
            return false;
        }
        return true;
    }

    void E(int i) {
        this.v.removeCallbacks(this.w);
        if (this.a != i) {
            this.a = i;
            this.s.j(i);
            if (this.a == 0) {
                this.t = null;
            }
        }
    }

    public boolean F(int i, int i2) {
        if (!this.u) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        } else {
            return s(i, i2, (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c));
        }
    }

    public boolean G(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        float[] fArr;
        int actionIndex = 0;
        int pointerId = 2;
        int i = 0;
        boolean z2;
        int i3;
        View view2;
        int i4 = 3;
        int i2;
        float f;
        float f2;
        int left;
        int i6;
        int top;
        int i7;
        int i8;
        final Object motionEvent3 = this;
        motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (motionEvent3.l == null) {
            motionEvent3.l = VelocityTracker.obtain();
        }
        motionEvent3.l.addMovement(motionEvent2);
        pointerId = 2;
        i2 = 1;
        if (actionMasked != 0) {
            if (actionMasked == i2 || actionMasked != pointerId) {
                a();
            } else {
                i4 = 3;
                if (actionMasked != 3) {
                    i4 = 5;
                    if (actionMasked != 5) {
                        pointerId = 6;
                        if (actionMasked == 6) {
                            motionEvent3.h(motionEvent2.getPointerId(actionIndex));
                        }
                    } else {
                        int pointerId4 = motionEvent2.getPointerId(actionIndex);
                        i4 = motionEvent2.getX(actionIndex);
                        float f3 = motionEvent2.getY(actionIndex);
                        motionEvent3.C(i4, f3, pointerId4);
                        if (motionEvent3.a == 0) {
                            motionEvent2 = motionEvent3.h[pointerId4];
                            pointerId = motionEvent2 & actionIndex;
                            if (motionEvent2 & actionIndex != 0) {
                                motionEvent3.s.h(motionEvent2 & actionIndex, pointerId4);
                            }
                        } else {
                            if (motionEvent3.a == pointerId) {
                                Object obj = motionEvent3.r((int)i4, (int)f3);
                                if (obj == motionEvent3.t) {
                                    motionEvent3.I(obj, pointerId4);
                                }
                            }
                        }
                    }
                }
            }
            i = 0;
        } else {
            float f4 = motionEvent.getX();
            float f5 = motionEvent.getY();
            i = 0;
            int pointerId3 = motionEvent2.getPointerId(i);
            motionEvent3.C(f4, f5, pointerId3);
            View view3 = motionEvent3.r((int)f4, (int)f5);
            if (view3 == motionEvent3.t && motionEvent3.a == pointerId) {
                motionEvent3.I(view3, pointerId3);
            }
            int i13 = motionEvent3.h[pointerId3];
            pointerId = i13 & actionIndex;
            if (i13 & actionIndex != 0) {
                motionEvent3.s.h(i13 & actionIndex, pointerId3);
            }
        }
        if (motionEvent3.a == i2) {
        }
        return z2;
    }

    public boolean H(View view, int i, int i2) {
        this.t = view;
        this.c = -1;
        int i5 = 0;
        boolean z = s(i, i2, i5, i5);
        if (!z && this.a == 0 && this.t != null) {
            this.t = null;
        }
        return this.s(i, i2, i5, i5);
    }

    boolean I(View view, int i) {
        View view2;
        final boolean z2 = true;
        if (view == this.t && this.c == i) {
            return true;
        }
        if (view != null) {
            if (this.s.m(view, i)) {
                this.c = i;
                b(view, i);
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.c = -1;
        g();
        if (this.l != null) {
            this.l.recycle();
            VelocityTracker velocityTracker = null;
            this.l = velocityTracker;
        }
    }

    public void b(View view, int i) {
        if (view.getParent() != this.v) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (";
            String str2 = ")";
            i = str + this.v + str2;
            throw new IllegalArgumentException(i);
        } else {
            this.t = view;
            this.c = i;
            this.s.i(view, i);
            E(1);
            return;
        }
    }

    public boolean k(boolean z) {
        boolean scrollOffset;
        boolean z2 = false;
        int finalY;
        int finalX;
        View view;
        int currY;
        final int i5 = 2;
        int i2 = 0;
        if (this.a == i5) {
            finalY = this.r.getCurrX();
            currY = this.r.getCurrY();
            i3 = finalY - this.t.getLeft();
            i4 = currY - this.t.getTop();
            if (i3 != 0) {
                u.W(this.t, i3);
            }
            if (i4 != 0) {
                u.X(this.t, i4);
            }
            if (i3 != 0 || i4 != 0) {
                this.s.k(this.t, finalY, currY, i3, i4);
            }
            if (this.r.computeScrollOffset() && finalY == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
            }
            if (!this.r) {
                if (z) {
                    this.v.post(this.w);
                } else {
                    E(i2);
                }
            }
        }
        if (this.a == i5) {
            int i6 = 1;
        }
        return z2;
    }

    public View r(int i, int i2) {
        int i3;
        int bottom;
        i3 = this.v.getChildCount() - 1;
        while (this.v >= 0) {
            this.s.c(i3);
            View childAt = this.v.getChildAt(i3);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
            }
        }
        return null;
    }

    public int u() {
        return this.b;
    }

    public boolean v(int i, int i2) {
        return y(this.t, i, i2);
    }

    public boolean w(int i) {
        boolean z = true;
        if ((1 << i) & this.k == 0) {
            int i4 = 0;
        }
        return z;
    }

    public boolean y(View view, int i, int i2) {
        boolean z = false;
        z = false;
        if (view == null) {
            return false;
        }
        if (i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            i = 1;
        }
        return z;
    }

    public void z(MotionEvent motionEvent) {
        int pointerCount;
        int i = 0;
        int pointerId = 1;
        int pointerId2 = 2;
        boolean z;
        boolean z2;
        View view;
        float f;
        View view2;
        float f2;
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        pointerCount = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        i = 0;
        if (actionMasked != 0) {
            pointerId = 1;
            if (actionMasked != pointerId) {
                pointerId2 = 2;
                if (actionMasked != 2) {
                    pointerId2 = 3;
                    if (actionMasked != 3) {
                        pointerId2 = 5;
                        if (actionMasked != 5) {
                            pointerId2 = 6;
                            if (actionMasked == 6) {
                                actionMasked = motionEvent.getPointerId(pointerCount);
                                if (this.a == pointerId && actionMasked == this.c) {
                                    pointerId = -1;
                                    while (this.l < motionEvent.getPointerCount()) {
                                        pointerId2 = motionEvent.getPointerId(i);
                                        if (pointerId2 != this.c) {
                                            break;
                                        }
                                    }
                                    if (pointerId == pointerId) {
                                        A();
                                    }
                                }
                                h(actionMasked);
                            }
                        } else {
                            actionMasked = motionEvent.getPointerId(pointerCount);
                            float f11 = motionEvent.getX(pointerCount);
                            float f19 = motionEvent.getY(pointerCount);
                            C(f11, f19, actionMasked);
                            if (this.a == 0) {
                                I(r((int)f11, (int)f19), actionMasked);
                                pointerId = this.h[actionMasked];
                                i = pointerId & pointerCount;
                                if (pointerId & pointerCount != 0) {
                                    pointerId = pointerId & pointerCount;
                                    this.s.h(pointerId, actionMasked);
                                }
                            } else {
                                pointerCount = (int)f11;
                                if (v(pointerCount, (int)f19)) {
                                    I(this.t, actionMasked);
                                }
                            }
                        }
                    } else {
                        if (this.a == pointerId) {
                            float f18 = 0.0f;
                            n(f18, f18);
                        }
                        a();
                    }
                } else {
                    if (this.a != pointerId) {
                        while (this.s < motionEvent.getPointerCount()) {
                            pointerCount = motionEvent.getPointerId(i);
                            if (x(pointerCount)) {
                                break;
                            }
                        }
                        D(motionEvent);
                    } else {
                        if (x(this.c)) {
                            int pointerIndex = motionEvent.findPointerIndex(this.c);
                            pointerCount = (int)(motionEvent.getX(pointerIndex) - this.f[i9]);
                            actionMasked = (int)(motionEvent.getY(pointerIndex) - this.g[i9]);
                            i = this.t.getLeft() + pointerCount;
                            pointerId = this.t.getTop() + actionMasked;
                            p(i, pointerId, pointerCount, actionMasked);
                            D(motionEvent);
                        }
                    }
                }
            } else {
                if (this.a == pointerId) {
                    A();
                }
                a();
            }
        } else {
            float f5 = motionEvent.getX();
            float f8 = motionEvent.getY();
            pointerId = motionEvent.getPointerId(0);
            pointerId = (int)f8;
            C(f5, f8, pointerId);
            I(r((int)f5, pointerId), pointerId);
            actionMasked = this.h[pointerId];
            i = actionMasked & pointerCount;
            if (actionMasked & pointerCount != 0) {
                actionMasked = actionMasked & pointerCount;
                this.s.h(actionMasked, pointerId);
            }
        }
    }
}
