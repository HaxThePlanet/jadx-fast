package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.core.content.a;
import androidx.core.widget.i;
import d.h.l.k;
import d.h.l.l;
import d.h.l.o;
import d.h.l.p;
import d.h.l.u;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements o, k {

    private static final String j0;
    private static final int[] k0;
    private final int[] A;
    private final int[] B;
    private boolean C;
    private int D;
    int E;
    private float F;
    private float G;
    private boolean H;
    private int I = -1;
    boolean J;
    private boolean K;
    private final DecelerateInterpolator L;
    androidx.swiperefreshlayout.widget.a M;
    private int N = -1;
    protected int O;
    float P;
    protected int Q;
    int R;
    int S;
    androidx.swiperefreshlayout.widget.b T;
    private Animation U;
    private Animation V;
    private Animation W;
    private View a;
    private Animation a0;
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j b;
    private Animation b0;
    boolean c = false;
    boolean c0;
    private int d0 = 1073741824;
    boolean e0;
    private androidx.swiperefreshlayout.widget.SwipeRefreshLayout.i f0;
    private Animation.AnimationListener g0;
    private final Animation h0;
    private final Animation i0;
    private int v;
    private float w = -1f;
    private float x;
    private final p y;
    private final l z;

    class a implements Animation.AnimationListener {

        final androidx.swiperefreshlayout.widget.SwipeRefreshLayout a;
        a(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
            super();
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationEnd(Animation animation) {
            boolean top;
            Object obj2;
            obj2 = this.a;
            if (obj2.c) {
                obj2.T.setAlpha(255);
                obj2.T.start();
                obj2 = this.a;
                obj2 = obj2.b;
                if (obj2.c0 && obj2 != null) {
                    obj2 = obj2.b;
                    if (obj2 != null) {
                        obj2.onRefresh();
                    }
                }
                obj2 = this.a;
                obj2.E = obj2.M.getTop();
            } else {
                obj2.l();
            }
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {

        final androidx.swiperefreshlayout.widget.SwipeRefreshLayout a;
        b(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
            super();
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation2) {
            this.a.setAnimationProgress(f);
        }
    }

    class c extends Animation {

        final androidx.swiperefreshlayout.widget.SwipeRefreshLayout a;
        c(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
            super();
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation2) {
            this.a.setAnimationProgress(i -= f);
        }
    }

    class d extends Animation {

        final int a;
        final int b;
        final androidx.swiperefreshlayout.widget.SwipeRefreshLayout c;
        d(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout, int i2, int i3) {
            this.c = swipeRefreshLayout;
            this.a = i2;
            this.b = i3;
            super();
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation2) {
            int i = this.a;
            obj5.T.setAlpha((int)i3);
        }
    }

    class e implements Animation.AnimationListener {

        final androidx.swiperefreshlayout.widget.SwipeRefreshLayout a;
        e(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
            super();
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationEnd(Animation animation) {
            boolean z;
            final androidx.swiperefreshlayout.widget.SwipeRefreshLayout obj2 = this.a;
            if (!obj2.J) {
                obj2.s(0);
            }
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {

        final androidx.swiperefreshlayout.widget.SwipeRefreshLayout a;
        f(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
            super();
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation2) {
            int i;
            int obj4;
            obj4 = this.a;
            if (!obj4.e0) {
                i7 -= obj4;
            } else {
                i = obj4.R;
            }
            obj4 = this.a;
            int i8 = obj4.O;
            this.a.setTargetOffsetTopAndBottom(i9 -= obj4);
            obj4.T.e(i5 -= f);
        }
    }

    class g extends Animation {

        final androidx.swiperefreshlayout.widget.SwipeRefreshLayout a;
        g(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
            super();
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation2) {
            this.a.j(f);
        }
    }

    class h extends Animation {

        final androidx.swiperefreshlayout.widget.SwipeRefreshLayout a;
        h(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
            super();
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation2) {
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout obj4 = this.a;
            float f2 = obj4.P;
            obj4.setAnimationProgress(f2 += i3);
            this.a.j(f);
        }
    }

    public interface i {
        public abstract boolean a(androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout, View view2);
    }

    public interface j {
        public abstract void onRefresh();
    }
    static {
        SwipeRefreshLayout.j0 = SwipeRefreshLayout.class.getSimpleName();
        int[] iArr = new int[1];
        SwipeRefreshLayout.k0 = iArr;
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        final int i = 0;
        int i2 = -1082130432;
        int i3 = 2;
        this.A = new int[i3];
        this.B = new int[i3];
        int i4 = -1;
        SwipeRefreshLayout.a aVar = new SwipeRefreshLayout.a(this);
        this.g0 = aVar;
        SwipeRefreshLayout.f fVar = new SwipeRefreshLayout.f(this);
        this.h0 = fVar;
        SwipeRefreshLayout.g gVar = new SwipeRefreshLayout.g(this);
        this.i0 = gVar;
        this.v = ViewConfiguration.get(context).getScaledTouchSlop();
        this.D = getResources().getInteger(17694721);
        setWillNotDraw(i);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(1073741824);
        this.L = decelerateInterpolator;
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i13 = (int)i12;
        d();
        int i14 = 1;
        setChildrenDrawingOrderEnabled(i14);
        int i6 = (int)i5;
        this.R = i6;
        this.w = (float)i6;
        p pVar = new p(this);
        this.y = pVar;
        l lVar = new l(this);
        this.z = lVar;
        setNestedScrollingEnabled(i14);
        int i8 = -i7;
        this.E = i8;
        this.Q = i8;
        j(1065353216);
        final TypedArray obj5 = context.obtainStyledAttributes(attributeSet2, SwipeRefreshLayout.k0);
        setEnabled(obj5.getBoolean(i, i14));
        obj5.recycle();
    }

    private void a(int i, Animation.AnimationListener animation$AnimationListener2) {
        Object obj3;
        this.O = i;
        this.h0.reset();
        this.h0.setDuration(200);
        this.h0.setInterpolator(this.L);
        if (animationListener2 != null) {
            this.M.b(animationListener2);
        }
        this.M.clearAnimation();
        this.M.startAnimation(this.h0);
    }

    private void b(int i, Animation.AnimationListener animation$AnimationListener2) {
        boolean z;
        int obj3;
        Object obj4;
        if (this.J) {
            t(i, animationListener2);
        } else {
            this.O = i;
            this.i0.reset();
            this.i0.setDuration(200);
            this.i0.setInterpolator(this.L);
            if (animationListener2 != null) {
                this.M.b(animationListener2);
            }
            this.M.clearAnimation();
            this.M.startAnimation(this.i0);
        }
    }

    private void d() {
        a aVar = new a(getContext(), -328966);
        this.M = aVar;
        b bVar = new b(getContext());
        this.T = bVar;
        bVar.m(1);
        this.M.setImageDrawable(this.T);
        this.M.setVisibility(8);
        addView(this.M);
    }

    private void e() {
        int view;
        View childCount;
        boolean equals;
        if (this.a == null) {
            view = 0;
            while (view < getChildCount()) {
                childCount = getChildAt(view);
                if (!childCount.equals(this.M)) {
                    break;
                } else {
                }
                view++;
            }
        }
    }

    private void f(float f) {
        float f2;
        int eVar;
        int i;
        int obj3;
        if (Float.compare(f, f2) > 0) {
            obj3 = 1;
            n(obj3, obj3);
        } else {
            obj3 = 0;
            this.c = obj3;
            int i2 = 0;
            this.T.k(i2, i2);
            eVar = 0;
            if (!this.J) {
                eVar = new SwipeRefreshLayout.e(this);
            }
            b(this.E, eVar);
            this.T.d(obj3);
        }
    }

    private boolean g(Animation animation) {
        boolean started;
        int obj2;
        if (animation && animation.hasStarted() && !animation.hasEnded()) {
            if (animation.hasStarted()) {
                obj2 = !animation.hasEnded() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private void i(float f) {
        int visibility;
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        int obj12;
        this.T.d(true);
        int i11 = 1065353216;
        float f4 = Math.min(i11, Math.abs(f / f2));
        i13 /= i20;
        if (this.S <= 0) {
            if (this.e0) {
                i28 -= i4;
            } else {
                i2 = this.R;
            }
        }
        float f14 = (float)i2;
        int i29 = 1073741824;
        int i31 = 0;
        double d3 = (double)i23;
        f12 *= i29;
        if (this.M.getVisibility() != 0) {
            this.M.setVisibility(0);
        }
        if (!this.J) {
            this.M.setScaleX(i11);
            this.M.setScaleY(i11);
        }
        if (this.J) {
            setAnimationProgress(Math.min(i11, f / f7));
        }
        if (Float.compare(f, f5) < 0) {
            if (this.T.getAlpha() > 76 && !g(this.W)) {
                if (!g(this.W)) {
                    r();
                }
            }
        } else {
            if (this.T.getAlpha() < 255 && !g(this.a0)) {
                if (!g(this.a0)) {
                    q();
                }
            }
        }
        obj12 = 1061997773;
        this.T.k(i31, Math.min(obj12, i14 * obj12));
        this.T.e(Math.min(i11, i14));
        this.T.h(i17 *= obj12);
        setTargetOffsetTopAndBottom(i37 -= obj12);
    }

    private void k(MotionEvent motionEvent) {
        int actionIndex;
        int obj4;
        actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.I) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.I = motionEvent.getPointerId(actionIndex);
        }
    }

    private void n(boolean z, boolean z2) {
        boolean obj2;
        boolean obj3;
        if (this.c != z) {
            this.c0 = z2;
            e();
            this.c = z;
            if (z) {
                a(this.E, this.g0);
            } else {
                s(this.g0);
            }
        }
    }

    private Animation o(int i, int i2) {
        SwipeRefreshLayout.d dVar = new SwipeRefreshLayout.d(this, i, i2);
        dVar.setDuration(300);
        this.M.b(0);
        this.M.clearAnimation();
        this.M.startAnimation(dVar);
        return dVar;
    }

    private void p(float f) {
        float f2;
        int obj4;
        f2 = this.G;
        final int i2 = this.v;
        if (Float.compare(obj4, f3) > 0 && !this.H) {
            if (!this.H) {
                this.F = f2 += obj4;
                this.H = true;
                this.T.setAlpha(76);
            }
        }
    }

    private void q() {
        this.a0 = o(this.T.getAlpha(), 255);
    }

    private void r() {
        this.W = o(this.T.getAlpha(), 76);
    }

    private void setColorViewAlpha(int i) {
        this.M.getBackground().setAlpha(i);
        this.T.setAlpha(i);
    }

    private void t(int i, Animation.AnimationListener animation$AnimationListener2) {
        Object obj3;
        this.O = i;
        this.P = this.M.getScaleX();
        obj3 = new SwipeRefreshLayout.h(this);
        this.b0 = obj3;
        obj3.setDuration(150);
        if (animationListener2 != null) {
            this.M.b(animationListener2);
        }
        this.M.clearAnimation();
        this.M.startAnimation(this.b0);
    }

    private void u(Animation.AnimationListener animation$AnimationListener) {
        Object bVar;
        this.M.setVisibility(0);
        this.T.setAlpha(255);
        bVar = new SwipeRefreshLayout.b(this);
        this.U = bVar;
        bVar.setDuration((long)i3);
        if (animationListener != null) {
            this.M.b(animationListener);
        }
        this.M.clearAnimation();
        this.M.startAnimation(this.U);
    }

    @Override // android.view.ViewGroup
    public boolean c() {
        androidx.swiperefreshlayout.widget.SwipeRefreshLayout.i iVar = this.f0;
        if (iVar != null) {
            return iVar.a(this, this.a);
        }
        View view = this.a;
        final int i = -1;
        if (view instanceof ListView != null) {
            return i.a((ListView)view, i);
        }
        return view.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchNestedFling(float f, float f2, boolean z3) {
        return this.z.a(f, f2, z3);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.z.b(f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchNestedPreScroll(int i, int i2, int[] i3Arr3, int[] i4Arr4) {
        return this.z.c(i, i2, i3Arr3, i4Arr4);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] i5Arr5) {
        return this.z.f(i, i2, i3, i4, i5Arr5);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int obj3;
        final int i3 = this.N;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i--) {
            return i3;
        }
        if (i2 >= i3) {
            i2++;
        }
        return obj3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.y.a();
    }

    @Override // android.view.ViewGroup
    public int getProgressCircleDiameter() {
        return this.d0;
    }

    @Override // android.view.ViewGroup
    public int getProgressViewEndOffset() {
        return this.R;
    }

    @Override // android.view.ViewGroup
    public int getProgressViewStartOffset() {
        return this.Q;
    }

    @Override // android.view.ViewGroup
    public boolean h() {
        return this.c;
    }

    @Override // android.view.ViewGroup
    public boolean hasNestedScrollingParent() {
        return this.z.j();
    }

    @Override // android.view.ViewGroup
    public boolean isNestedScrollingEnabled() {
        return this.z.l();
    }

    @Override // android.view.ViewGroup
    void j(float f) {
        int i = this.O;
        setTargetOffsetTopAndBottom(i2 -= obj3);
    }

    @Override // android.view.ViewGroup
    void l() {
        int i;
        int i2;
        this.M.clearAnimation();
        this.T.stop();
        this.M.setVisibility(8);
        setColorViewAlpha(255);
        if (this.J) {
            setAnimationProgress(0);
        } else {
            setTargetOffsetTopAndBottom(i4 -= i2);
        }
        this.E = this.M.getTop();
    }

    @Override // android.view.ViewGroup
    public void m(boolean z, int i2, int i3) {
        this.J = z;
        this.Q = i2;
        this.R = i3;
        this.e0 = true;
        l();
        this.c = false;
    }

    @Override // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        int top;
        boolean enabled;
        int i;
        float obj5;
        e();
        actionMasked = motionEvent.getActionMasked();
        final int i5 = 0;
        if (this.K && actionMasked == 0) {
            if (actionMasked == 0) {
                this.K = i5;
            }
        }
        if (isEnabled() && !this.K && !c() && !this.c) {
            if (!this.K) {
                if (!c()) {
                    if (!this.c) {
                        if (this.C) {
                        } else {
                            if (actionMasked != 0) {
                                i = -1;
                                if (actionMasked != 1) {
                                    if (actionMasked != 2) {
                                        if (actionMasked != 3) {
                                            if (actionMasked != 6) {
                                            } else {
                                                k(motionEvent);
                                            }
                                        } else {
                                            this.H = i5;
                                            this.I = i;
                                        }
                                    } else {
                                        int i4 = this.I;
                                        if (i4 == i) {
                                            Log.e(SwipeRefreshLayout.j0, "Got ACTION_MOVE event but don't have an active pointer id.");
                                            return i5;
                                        }
                                        actionMasked = motionEvent.findPointerIndex(i4);
                                        if (actionMasked < 0) {
                                            return i5;
                                        }
                                        p(motionEvent.getY(actionMasked));
                                    }
                                } else {
                                }
                            } else {
                                setTargetOffsetTopAndBottom(i2 -= top);
                                int pointerId = motionEvent.getPointerId(i5);
                                this.I = pointerId;
                                this.H = i5;
                                actionMasked = motionEvent.findPointerIndex(pointerId);
                                if (actionMasked < 0) {
                                    return i5;
                                }
                                this.G = motionEvent.getY(actionMasked);
                            }
                        }
                        return this.H;
                    }
                }
            }
        }
        return i5;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int obj3 = getMeasuredWidth();
        if (getChildCount() == 0) {
        }
        if (this.a == null) {
            e();
        }
        View obj5 = this.a;
        if (obj5 == null) {
        }
        int obj6 = getPaddingLeft();
        int obj7 = getPaddingTop();
        obj5.layout(obj6, obj7, i6 += obj6, obj4 += obj7);
        obj3 /= 2;
        obj4 /= 2;
        int i8 = this.E;
        this.M.layout(obj3 - obj4, i8, obj3 += obj4, obj5 += i8);
    }

    @Override // android.view.ViewGroup
    public void onMeasure(int i, int i2) {
        int measureSpec;
        int obj4;
        int obj5;
        super.onMeasure(i, i2);
        if (this.a == null) {
            e();
        }
        obj4 = this.a;
        if (obj4 == null) {
        }
        int i3 = 1073741824;
        obj4.measure(View.MeasureSpec.makeMeasureSpec(obj5 -= paddingRight, i3), View.MeasureSpec.makeMeasureSpec(i4 -= paddingBottom, i3));
        this.M.measure(View.MeasureSpec.makeMeasureSpec(this.d0, i3), View.MeasureSpec.makeMeasureSpec(this.d0, i3));
        this.N = -1;
        obj4 = 0;
        while (obj4 < getChildCount()) {
            if (getChildAt(obj4) == this.M) {
                break;
            } else {
            }
            obj4++;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onNestedFling(View view, float f2, float f3, boolean z4) {
        return dispatchNestedFling(f2, f3, z4);
    }

    @Override // android.view.ViewGroup
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup
    public void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4) {
        float f;
        boolean z;
        int i;
        int cmp;
        int cmp2;
        int obj5;
        boolean obj6;
        int obj7;
        obj5 = 0;
        final int i4 = 1;
        f = this.x;
        if (i3 > 0 && Float.compare(f, obj5) > 0) {
            f = this.x;
            if (Float.compare(f, obj5) > 0) {
                cmp = (float)i3;
                if (Float.compare(cmp, f) > 0) {
                    i4Arr4[i4] = i3 - i6;
                    this.x = obj5;
                } else {
                    this.x = f -= cmp;
                    i4Arr4[i4] = i3;
                }
                i(this.x);
            }
        }
        if (this.e0 && i3 > 0 && Float.compare(z, obj5) == 0 && Math.abs(i3 - obj5) > 0) {
            if (i3 > 0) {
                if (Float.compare(z, obj5) == 0) {
                    if (Math.abs(i3 - obj5) > 0) {
                        this.M.setVisibility(8);
                    }
                }
            }
        }
        obj5 = this.A;
        int i5 = 0;
        if (dispatchNestedPreScroll(i2 -= i7, i3 -= i8, obj5, 0)) {
            i4Arr4[i5] = obj6 += obj7;
            i4Arr4[i4] = obj6 += obj5;
        }
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int obj7;
        int obj8;
        this.dispatchNestedScroll(i2, i3, i4, i5, this.B);
        i5 += obj7;
        if (obj11 < 0 && !c()) {
            if (!c()) {
                obj7 += obj8;
                this.x = obj7;
                i(obj7);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.y.b(view, view2, i3);
        startNestedScroll(i3 & 2);
        this.x = 0;
        this.C = true;
    }

    @Override // android.view.ViewGroup
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        boolean obj1;
        if (isEnabled() && !this.K && !this.c && i3 & 2 != 0) {
            if (!this.K) {
                if (!this.c) {
                    obj1 = i3 & 2 != 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    @Override // android.view.ViewGroup
    public void onStopNestedScroll(View view) {
        this.y.d(view);
        this.C = false;
        float obj3 = this.x;
        int i = 0;
        if (Float.compare(obj3, i) > 0) {
            f(obj3);
            this.x = i;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        int pointerIndex;
        boolean enabled;
        int i2;
        int i;
        int i3;
        MotionEvent obj6;
        actionMasked = motionEvent.getActionMasked();
        i2 = 0;
        if (this.K && actionMasked == 0) {
            if (actionMasked == 0) {
                this.K = i2;
            }
        }
        if (isEnabled() && !this.K && !c() && !this.c) {
            if (!this.K) {
                if (!c()) {
                    if (!this.c) {
                        if (this.C) {
                        } else {
                            int i7 = 1;
                            if (actionMasked != 0) {
                                i = 1056964608;
                                if (actionMasked != i7) {
                                    if (actionMasked != 2 && actionMasked != 3) {
                                        if (actionMasked != 3) {
                                            if (actionMasked != 5) {
                                                if (actionMasked != 6) {
                                                } else {
                                                    k(motionEvent);
                                                }
                                            } else {
                                                actionMasked = motionEvent.getActionIndex();
                                                if (actionMasked < 0) {
                                                    Log.e(SwipeRefreshLayout.j0, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                                                    return i2;
                                                }
                                                this.I = motionEvent.getPointerId(actionMasked);
                                            }
                                        }
                                        return i2;
                                    }
                                    int pointerIndex2 = motionEvent.findPointerIndex(this.I);
                                    if (pointerIndex2 < 0) {
                                        Log.e(SwipeRefreshLayout.j0, "Got ACTION_MOVE event but have an invalid active pointer id.");
                                        return i2;
                                    }
                                    obj6 = motionEvent.getY(pointerIndex2);
                                    p(obj6);
                                    obj6 *= i;
                                    if (this.H && Float.compare(obj6, i6) > 0) {
                                        obj6 *= i;
                                        if (Float.compare(obj6, i6) > 0) {
                                            i(obj6);
                                        }
                                        return i2;
                                    }
                                } else {
                                    pointerIndex = motionEvent.findPointerIndex(this.I);
                                    if (pointerIndex < 0) {
                                        Log.e(SwipeRefreshLayout.j0, "Got ACTION_UP event but don't have an active pointer id.");
                                        return i2;
                                    }
                                    if (this.H) {
                                        this.H = i2;
                                        f(obj6 *= i);
                                    }
                                }
                                this.I = -1;
                                return i2;
                            }
                            this.I = motionEvent.getPointerId(i2);
                            this.H = i2;
                        }
                        return i7;
                    }
                }
            }
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    public void requestDisallowInterceptTouchEvent(boolean z) {
        boolean sDK_INT;
        if (Build.VERSION.SDK_INT < 21) {
            if (view instanceof AbsListView == null) {
                sDK_INT = this.a;
                if (sDK_INT != null && !u.S(sDK_INT)) {
                    if (!u.S(sDK_INT)) {
                    } else {
                        super.requestDisallowInterceptTouchEvent(z);
                    }
                } else {
                }
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    void s(Animation.AnimationListener animation$AnimationListener) {
        SwipeRefreshLayout.c cVar = new SwipeRefreshLayout.c(this);
        this.V = cVar;
        cVar.setDuration(150);
        this.M.b(animationListener);
        this.M.clearAnimation();
        this.M.startAnimation(this.V);
    }

    @Override // android.view.ViewGroup
    void setAnimationProgress(float f) {
        this.M.setScaleX(f);
        this.M.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    @Override // android.view.ViewGroup
    public void setColorSchemeColors(int... iArr) {
        e();
        this.T.g(iArr);
    }

    @Override // android.view.ViewGroup
    public void setColorSchemeResources(int... iArr) {
        int i;
        int i2;
        int[] iArr2 = new int[iArr.length];
        i = 0;
        for (int i3 : iArr) {
            iArr2[i] = a.d(getContext(), i3);
        }
        setColorSchemeColors(iArr2);
    }

    @Override // android.view.ViewGroup
    public void setDistanceToTriggerSync(int i) {
        this.w = (float)i;
    }

    @Override // android.view.ViewGroup
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            l();
        }
    }

    @Override // android.view.ViewGroup
    public void setNestedScrollingEnabled(boolean z) {
        this.z.m(z);
    }

    @Override // android.view.ViewGroup
    public void setOnChildScrollUpCallback(androidx.swiperefreshlayout.widget.SwipeRefreshLayout.i swipeRefreshLayout$i) {
        this.f0 = i;
    }

    @Override // android.view.ViewGroup
    public void setOnRefreshListener(androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j swipeRefreshLayout$j) {
        this.b = j;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    @Override // android.view.ViewGroup
    public void setProgressBackgroundColorSchemeColor(int i) {
        this.M.setBackgroundColor(i);
    }

    @Override // android.view.ViewGroup
    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(a.d(getContext(), i));
    }

    @Override // android.view.ViewGroup
    public void setRefreshing(boolean z) {
        boolean z2;
        boolean obj3;
        final int i = 0;
        if (z && this.c != z) {
            if (this.c != z) {
                this.c = z;
                if (!this.e0) {
                    obj3 += z2;
                } else {
                    obj3 = this.R;
                }
                setTargetOffsetTopAndBottom(obj3 -= z2);
                this.c0 = i;
                u(this.g0);
            } else {
                n(z, i);
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    public void setSize(int i) {
        int i4;
        int i3;
        int i2;
        if (i != 0 && i != 1) {
            if (i != 1) {
            }
        }
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i == 0) {
            this.d0 = (int)i6;
        } else {
            this.d0 = (int)i5;
        }
        this.M.setImageDrawable(0);
        this.T.m(i);
        this.M.setImageDrawable(this.T);
    }

    @Override // android.view.ViewGroup
    public void setSlingshotDistance(int i) {
        this.S = i;
    }

    @Override // android.view.ViewGroup
    void setTargetOffsetTopAndBottom(int i) {
        this.M.bringToFront();
        u.X(this.M, i);
        this.E = this.M.getTop();
    }

    @Override // android.view.ViewGroup
    public boolean startNestedScroll(int i) {
        return this.z.o(i);
    }

    @Override // android.view.ViewGroup
    public void stopNestedScroll() {
        this.z.q();
    }
}
