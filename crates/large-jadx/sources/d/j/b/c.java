package d.j.b;

import android.content.Context;
import android.content.res.Resources;
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

/* loaded from: classes.dex */
public class c {

    private static final Interpolator x;
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
    private OverScroller r;
    private final d.j.b.c.c s;
    private View t;
    private boolean u;
    private final ViewGroup v;
    private final Runnable w;

    class a implements Interpolator {
        @Override // android.view.animation.Interpolator
        public float getInterpolation(float f) {
            final int i = 1065353216;
            f -= i;
            return i5 += i;
        }
    }

    class b implements Runnable {

        final d.j.b.c a;
        b(d.j.b.c c) {
            this.a = c;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.E(0);
        }
    }

    public static abstract class c {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

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
            return 0;
        }

        public void h(int i, int i2) {
        }

        public void i(View view, int i2) {
        }

        public abstract void j(int i);

        public abstract void k(View view, int i2, int i3, int i4, int i5);

        public abstract void l(View view, float f2, float f3);

        public abstract boolean m(View view, int i2);
    }
    static {
        c.a aVar = new c.a();
        c.x = aVar;
    }

    private c(Context context, ViewGroup viewGroup2, d.j.b.c.c c$c3) {
        super();
        int i = -1;
        c.b bVar = new c.b(this);
        this.w = bVar;
        if (viewGroup2 == null) {
        } else {
            if (c3 == null) {
            } else {
                this.v = viewGroup2;
                this.s = c3;
                ViewConfiguration obj3 = ViewConfiguration.get(context);
                int obj4 = (int)obj4;
                this.p = obj4;
                this.o = obj4;
                this.b = obj3.getScaledTouchSlop();
                this.m = (float)obj4;
                this.n = (float)obj3;
                obj3 = new OverScroller(context, c.x);
                this.r = obj3;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Callback may not be null");
            throw obj2;
        }
        obj2 = new IllegalArgumentException("Parent view may not be null");
        throw obj2;
    }

    private void A() {
        this.l.computeCurrentVelocity(1000, this.m);
        n(e(this.l.getXVelocity(this.c), this.n, this.m), e(this.l.getYVelocity(this.c), this.n, this.m));
    }

    private void B(float f, float f2, int i3) {
        int i;
        boolean obj3;
        float obj4;
        if (c(f, f2, i3, 1)) {
        } else {
            i = 0;
        }
        if (c(f2, f, i3, 4)) {
            i |= 4;
        }
        if (c(f, f2, i3, 2)) {
            i |= 2;
        }
        if (c(f2, f, i3, 8)) {
            i |= 8;
        }
        if (i != 0) {
            obj3 = this.i;
            obj3[i3] = obj4 |= i;
            this.s.f(i, i3);
        }
    }

    private void C(float f, float f2, int i3) {
        q(i3);
        this.f[i3] = f;
        this.d[i3] = f;
        this.g[i3] = f2;
        this.e[i3] = f2;
        this.h[i3] = t((int)f, (int)f2);
        this.k = obj3 |= obj4;
    }

    private void D(MotionEvent motionEvent) {
        int i;
        int pointerId;
        boolean z;
        float f;
        float[] fArr;
        i = 0;
        while (i < motionEvent.getPointerCount()) {
            pointerId = motionEvent.getPointerId(i);
            if (!x(pointerId)) {
            } else {
            }
            this.f[pointerId] = motionEvent.getX(i);
            this.g[pointerId] = motionEvent.getY(i);
            i++;
        }
    }

    private boolean c(float f, float f2, int i3, int i4) {
        int cmp2;
        int i;
        int cmp;
        float obj4;
        float obj5;
        obj4 = Math.abs(f);
        obj5 = Math.abs(f2);
        if (i2 &= i4 == i4 && i5 &= i4 != 0 && i6 &= i4 != i4 && i7 &= i4 != i4) {
            if (i5 &= i4 != 0) {
                if (i6 &= i4 != i4) {
                    if (i7 &= i4 != i4) {
                        cmp2 = this.b;
                        if (Float.compare(obj4, f4) <= 0 && Float.compare(obj5, f3) <= 0) {
                            if (Float.compare(obj5, f3) <= 0) {
                            } else {
                                if (Float.compare(obj4, obj5) < 0 && this.s.g(i4)) {
                                    if (this.s.g(i4)) {
                                        obj4 = this.j;
                                        obj4[i3] = obj5 |= i4;
                                        return 0;
                                    }
                                }
                                if (obj5 &= i4 == 0 && Float.compare(obj4, obj5) > 0) {
                                    if (Float.compare(obj4, obj5) > 0) {
                                        i = 1;
                                    }
                                }
                            }
                        } else {
                        }
                    }
                }
            }
        }
        return i;
    }

    private boolean d(View view, float f2, float f3) {
        int i;
        int i2;
        int obj5;
        int obj6;
        i = 0;
        if (view == null) {
            return i;
        }
        final int i4 = 1;
        i2 = this.s.d(view) > 0 ? i4 : i;
        obj5 = this.s.e(view) > 0 ? i4 : i;
        obj5 = this.b;
        if (i2 != 0 && obj5 != null && Float.compare(obj6, obj5) > 0) {
            if (obj5 != null) {
                obj5 = this.b;
                if (Float.compare(obj6, obj5) > 0) {
                    i = i4;
                }
                return i;
            }
        }
        if (i2 != 0 && Float.compare(obj5, obj6) > 0) {
            if (Float.compare(obj5, obj6) > 0) {
                i = i4;
            }
            return i;
        }
        if (obj5 != null && Float.compare(obj5, obj6) > 0) {
            if (Float.compare(obj5, obj6) > 0) {
                i = i4;
            }
        }
        return i;
    }

    private float e(float f, float f2, float f3) {
        int obj5;
        final float f4 = Math.abs(f);
        final int i = 0;
        if (Float.compare(f4, f2) < 0) {
            return i;
        }
        if (Float.compare(f4, f3) > 0) {
            if (Float.compare(f, i) > 0) {
            } else {
                obj5 = -f3;
            }
            return obj5;
        }
        return f;
    }

    private int f(int i, int i2, int i3) {
        int obj4;
        final int i4 = Math.abs(i);
        if (i4 < i2) {
            return 0;
        }
        if (i4 > i3) {
            if (i > 0) {
            } else {
                obj4 = -i3;
            }
            return obj4;
        }
        return i;
    }

    private void g() {
        float[] fArr = this.d;
        if (fArr == null) {
        }
        int i = 0;
        Arrays.fill(fArr, i);
        Arrays.fill(this.e, i);
        Arrays.fill(this.f, i);
        Arrays.fill(this.g, i);
        int i2 = 0;
        Arrays.fill(this.h, i2);
        Arrays.fill(this.i, i2);
        Arrays.fill(this.j, i2);
        this.k = i2;
    }

    private void h(int i) {
        float[] fArr;
        int i2;
        int obj3;
        if (this.d != null) {
            if (!w(i)) {
            } else {
                int i3 = 0;
                this.d[i] = i3;
                this.e[i] = i3;
                this.f[i] = i3;
                this.g[i] = i3;
                int i4 = 0;
                this.h[i] = i4;
                this.i[i] = i4;
                this.j[i] = i4;
                this.k = obj3 &= fArr;
            }
        }
    }

    private int i(int i, int i2, int i3) {
        int i4;
        int obj4;
        int obj5;
        if (i == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        int i5 = 1065353216;
        float f2 = (float)i6;
        obj5 = Math.abs(i2);
        if (obj5 > 0) {
            obj4 *= 4;
        } else {
            obj4 = (int)obj4;
        }
        return Math.min(obj4, 600);
    }

    private int j(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f;
        float f4;
        float f3;
        int obj10 = f(i4, (int)f5, (int)f7);
        final int obj11 = f(i5, (int)f6, (int)f8);
        int i7 = Math.abs(i2);
        int i11 = Math.abs(i3);
        int i13 = Math.abs(obj10);
        final int i15 = Math.abs(obj11);
        final int i16 = i13 + i15;
        final int i17 = i7 + i11;
        f4 = obj10 != null ? (float)i16 : (float)i17;
        f3 = obj11 != null ? (float)i16 : (float)i17;
        return (int)obj8;
    }

    public static d.j.b.c l(ViewGroup viewGroup, float f2, d.j.b.c.c c$c3) {
        final d.j.b.c obj1 = c.m(viewGroup, c3);
        obj1.b = (int)obj3;
        return obj1;
    }

    public static d.j.b.c m(ViewGroup viewGroup, d.j.b.c.c c$c2) {
        c cVar = new c(viewGroup.getContext(), viewGroup, c2);
        return cVar;
    }

    private void n(float f, float f2) {
        final int i = 1;
        this.u = i;
        this.s.l(this.t, f, f2);
        final int obj4 = 0;
        this.u = obj4;
        if (this.a == i) {
            E(obj4);
        }
    }

    private float o(float f) {
        return (float)d2;
    }

    private void p(int i, int i2, int i3, int i4) {
        View view2;
        int i5;
        d.j.b.c.c cVar;
        View view;
        int i6;
        int i7;
        int obj11;
        int obj12;
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i3 != 0) {
            u.W(this.t, obj11 - left);
        }
        final int i8 = obj11;
        if (i4 != 0) {
            u.X(this.t, obj12 - top);
        }
        final int i9 = obj12;
        if (i3 == 0) {
            if (i4 != 0) {
                this.s.k(this.t, i8, i9, i8 - left, i9 - top);
            }
        } else {
        }
    }

    private void q(int i) {
        float[] fArr4;
        int fArr2;
        float[] fArr3;
        float[] fArr5;
        float[] fArr;
        int[] iArr;
        int[] iArr2;
        int length;
        int i2;
        int obj10;
        fArr4 = this.d;
        if (fArr4 != null) {
            i++;
            fArr2 = new float[obj10];
            fArr3 = new float[obj10];
            fArr5 = new float[obj10];
            fArr = new float[obj10];
            iArr = new int[obj10];
            iArr2 = new int[obj10];
            obj10 = new int[obj10];
            if (fArr4.length <= i && fArr4 != null) {
                i++;
                fArr2 = new float[obj10];
                fArr3 = new float[obj10];
                fArr5 = new float[obj10];
                fArr = new float[obj10];
                iArr = new int[obj10];
                iArr2 = new int[obj10];
                obj10 = new int[obj10];
                if (fArr4 != null) {
                    i2 = 0;
                    System.arraycopy(fArr4, i2, fArr2, i2, fArr4.length);
                    float[] fArr6 = this.e;
                    System.arraycopy(fArr6, i2, fArr3, i2, fArr6.length);
                    float[] fArr7 = this.f;
                    System.arraycopy(fArr7, i2, fArr5, i2, fArr7.length);
                    float[] fArr8 = this.g;
                    System.arraycopy(fArr8, i2, fArr, i2, fArr8.length);
                    int[] iArr3 = this.h;
                    System.arraycopy(iArr3, i2, iArr, i2, iArr3.length);
                    int[] iArr4 = this.i;
                    System.arraycopy(iArr4, i2, iArr2, i2, iArr4.length);
                    fArr4 = this.j;
                    System.arraycopy(fArr4, i2, obj10, i2, fArr4.length);
                }
                this.d = fArr2;
                this.e = fArr3;
                this.f = fArr5;
                this.g = fArr;
                this.h = iArr;
                this.i = iArr2;
                this.j = obj10;
            }
        } else {
        }
    }

    private boolean s(int i, int i2, int i3, int i4) {
        final int left = this.t.getLeft();
        final int top = this.t.getTop();
        i -= left;
        i2 -= top;
        if (obj11 == null && obj12 == null) {
            if (obj12 == null) {
                this.r.abortAnimation();
                int obj11 = 0;
                E(obj11);
                return obj11;
            }
        }
        this.r.startScroll(left, top, obj11, obj12, this.j(this.t, obj11, obj12, i3, i4));
        E(2);
        return 1;
    }

    private int t(int i, int i2) {
        int i3;
        i3 = i < left += i5 ? 1 : 0;
        if (i2 < top += i9) {
            i3 |= 4;
        }
        if (i > right -= i10) {
            i3 |= 2;
        }
        if (i2 > obj4 -= i8) {
            i3 |= 8;
        }
        return i3;
    }

    private boolean x(int i) {
        if (!w(i)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring pointerId=");
            stringBuilder.append(i);
            stringBuilder.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            Log.e("ViewDragHelper", stringBuilder.toString());
            return 0;
        }
        return 1;
    }

    void E(int i) {
        int i2;
        int obj3;
        this.v.removeCallbacks(this.w);
        this.a = i;
        this.s.j(i);
        if (this.a != i && this.a == 0) {
            this.a = i;
            this.s.j(i);
            if (this.a == 0) {
                this.t = 0;
            }
        }
    }

    public boolean F(int i, int i2) {
        if (!this.u) {
        } else {
            return s(i, i2, (int)xVelocity, (int)yVelocity);
        }
        IllegalStateException obj4 = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        throw obj4;
    }

    public boolean G(MotionEvent motionEvent) {
        MotionEvent pointerId2;
        int actionMasked;
        int actionIndex;
        View view;
        VelocityTracker obtain;
        int pointerId;
        int i3;
        int i2;
        int i7;
        int i8;
        int i;
        int i6;
        int i4;
        int left;
        int i5;
        int top;
        int i9;
        int i10;
        final Object obj = this;
        pointerId2 = motionEvent;
        actionMasked = motionEvent.getActionMasked();
        actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (obj.l == null) {
            obj.l = VelocityTracker.obtain();
        }
        obj.l.addMovement(pointerId2);
        pointerId = 2;
        final int i16 = 1;
        if (actionMasked != 0) {
            if (actionMasked != i16) {
                if (actionMasked != pointerId) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                obj.h(pointerId2.getPointerId(actionIndex));
                            }
                        } else {
                            actionMasked = pointerId2.getPointerId(actionIndex);
                            i7 = pointerId2.getX(actionIndex);
                            pointerId2 = pointerId2.getY(actionIndex);
                            obj.C(i7, pointerId2, actionMasked);
                            actionIndex = obj.a;
                            if (actionIndex == 0) {
                                pointerId2 = obj.h[actionMasked];
                                actionIndex = obj.q;
                                if (pointerId2 & actionIndex != 0) {
                                    obj.s.h(pointerId2 &= actionIndex, actionMasked);
                                }
                            } else {
                                pointerId2 = obj.r((int)i7, (int)pointerId2);
                                if (actionIndex == pointerId && pointerId2 == obj.t) {
                                    pointerId2 = obj.r((int)i7, (int)pointerId2);
                                    if (pointerId2 == obj.t) {
                                        obj.I(pointerId2, actionMasked);
                                    }
                                }
                            }
                        }
                    } else {
                        a();
                    }
                } else {
                    if (obj.d != null) {
                        if (obj.e == null) {
                        } else {
                            actionIndex = 0;
                            while (actionIndex < motionEvent.getPointerCount()) {
                                pointerId = pointerId2.getPointerId(actionIndex);
                                if (obj.x(pointerId)) {
                                    break;
                                } else {
                                }
                                float f3 = pointerId2.getX(actionIndex);
                                float f4 = pointerId2.getY(actionIndex);
                                i6 = f3 - f5;
                                i4 = f4 - f6;
                                i7 = obj.r((int)f3, (int)f4);
                                if (i7 != null && obj.d(i7, i6, i4)) {
                                } else {
                                }
                                i8 = 0;
                                obj.B(i6, i4, pointerId);
                                actionIndex++;
                                left = i7.getLeft();
                                int i18 = (int)i6;
                                top = i7.getTop();
                                int i20 = (int)i4;
                                i9 = obj.s.d(i7);
                                i10 = obj.s.e(i7);
                                if (i10 != 0) {
                                    break;
                                }
                                if (obj.d(i7, i6, i4)) {
                                } else {
                                }
                                i8 = i16;
                            }
                            D(motionEvent);
                        }
                    }
                }
            } else {
            }
            i3 = 0;
        } else {
            float f = motionEvent.getX();
            float f2 = motionEvent.getY();
            pointerId2 = pointerId2.getPointerId(0);
            obj.C(f, f2, pointerId2);
            View view2 = obj.r((int)f, (int)f2);
            if (view2 == obj.t && obj.a == pointerId) {
                if (obj.a == pointerId) {
                    obj.I(view2, pointerId2);
                }
            }
            actionMasked = obj.h[pointerId2];
            actionIndex = obj.q;
            if (actionMasked & actionIndex != 0) {
                obj.s.h(actionMasked &= actionIndex, pointerId2);
            }
        }
        if (obj.a == i16) {
            i3 = i16;
        }
        return i3;
    }

    public boolean H(View view, int i2, int i3) {
        int obj2;
        this.t = view;
        this.c = -1;
        int obj1 = 0;
        obj1 = s(i2, i3, obj1, obj1);
        if (obj1 == null && this.a == 0 && this.t != null) {
            if (this.a == 0) {
                if (this.t != null) {
                    this.t = 0;
                }
            }
        }
        return obj1;
    }

    boolean I(View view, int i2) {
        View view2;
        final int i = 1;
        if (view == this.t && this.c == i2) {
            if (this.c == i2) {
                return i;
            }
        }
        if (view != null && this.s.m(view, i2)) {
            if (this.s.m(view, i2)) {
                this.c = i2;
                b(view, i2);
                return i;
            }
        }
        return 0;
    }

    public void a() {
        VelocityTracker velocityTracker;
        this.c = -1;
        g();
        velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = 0;
        }
    }

    public void b(View view, int i2) {
        if (view.getParent() != this.v) {
        } else {
            this.t = view;
            this.c = i2;
            this.s.i(view, i2);
            E(1);
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        obj4.append(this.v);
        obj4.append(")");
        IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
        throw obj3;
    }

    public boolean k(boolean z) {
        boolean scrollOffset;
        int i4;
        int finalY;
        int finalX;
        View view;
        int i3;
        int i5;
        int i;
        int i2;
        int currY;
        ViewGroup obj12;
        final int i6 = 2;
        i4 = 0;
        finalY = this.r.getCurrX();
        currY = this.r.getCurrY();
        i = finalY - left;
        i2 = currY - finalX;
        if (this.a == i6 && i != 0) {
            finalY = this.r.getCurrX();
            currY = this.r.getCurrY();
            i = finalY - left;
            i2 = currY - finalX;
            if (i != 0) {
                u.W(this.t, i);
            }
            if (i2 != 0) {
                u.X(this.t, i2);
            }
            if (i == 0) {
                if (i2 != 0) {
                    this.s.k(this.t, finalY, currY, i, i2);
                }
            } else {
            }
            if (this.r.computeScrollOffset() && finalY == this.r.getFinalX() && currY == this.r.getFinalY()) {
                if (finalY == this.r.getFinalX()) {
                    if (currY == this.r.getFinalY()) {
                        this.r.abortAnimation();
                        scrollOffset = i4;
                    }
                }
            }
            if (scrollOffset == null) {
                if (z != null) {
                    this.v.post(this.w);
                } else {
                    E(i4);
                }
            }
        }
        if (this.a == i6) {
            i4 = 1;
        }
        return i4;
    }

    public View r(int i, int i2) {
        int i3;
        View childAt;
        int bottom;
        childCount--;
        while (i3 >= 0) {
            this.s.c(i3);
            childAt = this.v.getChildAt(i3);
            i3--;
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
        int i2;
        if (obj3 &= i3 != 0) {
        } else {
            i2 = 0;
        }
        return i2;
    }

    public boolean y(View view, int i2, int i3) {
        int i;
        int right;
        int obj3;
        int obj4;
        if (view == null) {
            return 0;
        }
        if (i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            if (i2 < view.getRight()) {
                if (i3 >= view.getTop()) {
                    if (i3 < view.getBottom()) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    public void z(MotionEvent motionEvent) {
        int actionMasked;
        int pointerCount;
        VelocityTracker obtain;
        int i3;
        int i4;
        int pointerId;
        boolean z;
        int i5;
        int i;
        int i2;
        MotionEvent obj10;
        actionMasked = motionEvent.getActionMasked();
        pointerCount = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        if (actionMasked != 0) {
            i4 = 1;
            if (actionMasked != i4) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked != 6) {
                            } else {
                                actionMasked = motionEvent.getPointerId(pointerCount);
                                if (this.a == i4 && actionMasked == this.c) {
                                    if (actionMasked == this.c) {
                                        i4 = -1;
                                        while (i3 < motionEvent.getPointerCount()) {
                                            pointerId = motionEvent.getPointerId(i3);
                                            i5 = this.t;
                                            i3++;
                                            i4 = -1;
                                        }
                                        obj10 = i4;
                                        if (obj10 == i4) {
                                            A();
                                        }
                                    }
                                }
                                h(actionMasked);
                            }
                        } else {
                            actionMasked = motionEvent.getPointerId(pointerCount);
                            i3 = motionEvent.getX(pointerCount);
                            obj10 = motionEvent.getY(pointerCount);
                            C(i3, obj10, actionMasked);
                            if (this.a == 0) {
                                I(r((int)i3, (int)obj10), actionMasked);
                                obj10 = this.h[actionMasked];
                                pointerCount = this.q;
                                if (obj10 & pointerCount != 0) {
                                    this.s.h(obj10 &= pointerCount, actionMasked);
                                }
                            } else {
                                if (v((int)i3, (int)obj10)) {
                                    I(this.t, actionMasked);
                                }
                            }
                        }
                    } else {
                        if (this.a == i4) {
                            obj10 = 0;
                            n(obj10, obj10);
                        }
                        a();
                    }
                } else {
                    if (this.a == i4) {
                        if (!x(this.c)) {
                        } else {
                            int pointerIndex = motionEvent.findPointerIndex(this.c);
                            int i14 = this.c;
                            pointerCount = (int)i10;
                            actionMasked = (int)i9;
                            p(left += pointerCount, top += actionMasked, pointerCount, actionMasked);
                            D(motionEvent);
                        }
                    } else {
                        while (i3 < motionEvent.getPointerCount()) {
                            pointerCount = motionEvent.getPointerId(i3);
                            if (x(pointerCount)) {
                                break;
                            } else {
                            }
                            pointerId = motionEvent.getX(i3);
                            z = motionEvent.getY(i3);
                            i5 = pointerId - f8;
                            i = z - f10;
                            B(i5, i, pointerCount);
                            pointerId = r((int)pointerId, (int)z);
                            i3++;
                        }
                        D(motionEvent);
                    }
                }
            } else {
                if (this.a == i4) {
                    A();
                }
                a();
            }
        } else {
            float f2 = motionEvent.getX();
            float f4 = motionEvent.getY();
            obj10 = motionEvent.getPointerId(0);
            C(f2, f4, obj10);
            I(r((int)f2, (int)f4), obj10);
            actionMasked = this.h[obj10];
            pointerCount = this.q;
            if (actionMasked & pointerCount != 0) {
                this.s.h(actionMasked &= pointerCount, obj10);
            }
        }
    }
}
