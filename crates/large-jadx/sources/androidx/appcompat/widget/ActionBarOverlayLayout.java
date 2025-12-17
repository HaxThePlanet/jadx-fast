package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.m.a;
import d.a.a;
import d.a.f;
import d.h.f.b;
import d.h.l.d0;
import d.h.l.d0.b;
import d.h.l.m;
import d.h.l.n;
import d.h.l.o;
import d.h.l.p;
import d.h.l.u;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements androidx.appcompat.widget.y, o, m, n {

    static final int[] a0;
    private boolean A;
    private boolean B;
    boolean C;
    private int D;
    private int E;
    private final Rect F;
    private final Rect G;
    private final Rect H;
    private final Rect I;
    private final Rect J;
    private final Rect K;
    private final Rect L;
    private d0 M;
    private d0 N;
    private d0 O;
    private d0 P;
    private androidx.appcompat.widget.ActionBarOverlayLayout.d Q;
    private OverScroller R;
    ViewPropertyAnimator S;
    final AnimatorListenerAdapter T;
    private final Runnable U;
    private final Runnable V;
    private final p W;
    private int a;
    private int b = 0;
    private androidx.appcompat.widget.ContentFrameLayout c;
    androidx.appcompat.widget.ActionBarContainer v;
    private androidx.appcompat.widget.z w;
    private Drawable x;
    private boolean y;
    private boolean z;

    class a extends AnimatorListenerAdapter {

        final androidx.appcompat.widget.ActionBarOverlayLayout a;
        a(androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout) {
            this.a = actionBarOverlayLayout;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            final androidx.appcompat.widget.ActionBarOverlayLayout obj2 = this.a;
            obj2.S = 0;
            obj2.C = false;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            final androidx.appcompat.widget.ActionBarOverlayLayout obj2 = this.a;
            obj2.S = 0;
            obj2.C = false;
        }
    }

    class b implements Runnable {

        final androidx.appcompat.widget.ActionBarOverlayLayout a;
        b(androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout) {
            this.a = actionBarOverlayLayout;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.o();
            androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout2 = this.a;
            actionBarOverlayLayout2.S = actionBarOverlayLayout2.v.animate().translationY(0).setListener(actionBarOverlayLayout3.T);
        }
    }

    class c implements Runnable {

        final androidx.appcompat.widget.ActionBarOverlayLayout a;
        c(androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout) {
            this.a = actionBarOverlayLayout;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.o();
            androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout2 = this.a;
            actionBarOverlayLayout2.S = actionBarOverlayLayout2.v.animate().translationY((float)i).setListener(actionBarOverlayLayout4.T);
        }
    }

    public interface d {
        public abstract void a();

        public abstract void b();

        public abstract void c(boolean z);

        public abstract void d();

        public abstract void e();

        public abstract void f(int i);
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i, int i2) {
            super(i, i2);
        }

        public e(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
        }

        public e(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
        }
    }
    static {
        int[] iArr = new int[2];
        ActionBarOverlayLayout.a0 = iArr;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        int obj2 = 0;
        obj2 = new Rect();
        this.F = obj2;
        obj2 = new Rect();
        this.G = obj2;
        obj2 = new Rect();
        this.H = obj2;
        obj2 = new Rect();
        this.I = obj2;
        obj2 = new Rect();
        this.J = obj2;
        obj2 = new Rect();
        this.K = obj2;
        obj2 = new Rect();
        this.L = obj2;
        obj2 = d0.b;
        this.M = obj2;
        this.N = obj2;
        this.O = obj2;
        this.P = obj2;
        obj2 = new ActionBarOverlayLayout.a(this);
        this.T = obj2;
        obj2 = new ActionBarOverlayLayout.b(this);
        this.U = obj2;
        obj2 = new ActionBarOverlayLayout.c(this);
        this.V = obj2;
        p(context);
        p obj1 = new p(this);
        this.W = obj1;
    }

    private void j() {
        o();
        this.V.run();
    }

    private boolean k(View view, Rect rect2, boolean z3, boolean z4, boolean z5, boolean z6) {
        int i;
        int left;
        int obj4;
        int obj5;
        int obj6;
        int obj8;
        final ViewGroup.LayoutParams obj3 = view.getLayoutParams();
        i = 1;
        left = rect2.left;
        if (z3 != 0 && obj3.leftMargin != left) {
            left = rect2.left;
            obj5 = obj3.leftMargin != left ? i : 0;
        } else {
        }
        left = rect2.top;
        if (z4 != 0 && obj3.topMargin != left) {
            left = rect2.top;
            if (obj3.topMargin != left) {
                obj3.topMargin = left;
                obj5 = i;
            }
        }
        obj8 = rect2.right;
        if (z6 != 0 && obj3.rightMargin != obj8) {
            obj8 = rect2.right;
            if (obj3.rightMargin != obj8) {
                obj3.rightMargin = obj8;
                obj5 = i;
            }
        }
        obj4 = rect2.bottom;
        if (z5 && obj3.bottomMargin != obj4) {
            obj4 = rect2.bottom;
            if (obj3.bottomMargin != obj4) {
                obj3.bottomMargin = obj4;
            } else {
                i = obj5;
            }
        } else {
        }
        return i;
    }

    private androidx.appcompat.widget.z n(View view) {
        if (view instanceof z) {
            return (z)view;
        }
        if (!view instanceof Toolbar) {
        } else {
            return (Toolbar)view.getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        stringBuilder.append(view.getClass().getSimpleName());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    private void p(Context context) {
        int i;
        int i2;
        TypedArray styledAttributes = getContext().getTheme().obtainStyledAttributes(ActionBarOverlayLayout.a0);
        i = 0;
        this.a = styledAttributes.getDimensionPixelSize(i, i);
        int i3 = 1;
        Drawable drawable = styledAttributes.getDrawable(i3);
        this.x = drawable;
        i2 = drawable == null ? i3 : i;
        setWillNotDraw(i2);
        styledAttributes.recycle();
        if (applicationInfo.targetSdkVersion < 19) {
            i = i3;
        }
        this.y = i;
        OverScroller overScroller = new OverScroller(context);
        this.R = overScroller;
    }

    private void r() {
        o();
        postDelayed(this.V, 600);
    }

    private void s() {
        o();
        postDelayed(this.U, 600);
    }

    private void u() {
        o();
        this.U.run();
    }

    private boolean v(float f) {
        int obj10;
        this.R.fling(0, 0, 0, (int)f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        obj10 = this.R.getFinalY() > this.v.getHeight() ? 1 : 0;
        return obj10;
    }

    @Override // android.view.ViewGroup
    public void a(Menu menu, m.a m$a2) {
        t();
        this.w.a(menu, a2);
    }

    @Override // android.view.ViewGroup
    public boolean b() {
        t();
        return this.w.b();
    }

    @Override // android.view.ViewGroup
    public void c() {
        t();
        this.w.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return layoutParams instanceof ActionBarOverlayLayout.e;
    }

    @Override // android.view.ViewGroup
    public boolean d() {
        t();
        return this.w.d();
    }

    @Override // android.view.ViewGroup
    public void draw(Canvas canvas) {
        int i3;
        Drawable drawable;
        int i2;
        int i4;
        int width;
        int i;
        super.draw(canvas);
        if (this.x != null && !this.y) {
            if (!this.y) {
                i2 = 0;
                if (this.v.getVisibility() == 0) {
                    i3 = (int)i6;
                } else {
                    i3 = i2;
                }
                this.x.setBounds(i2, i3, getWidth(), intrinsicHeight += i3);
                this.x.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean e() {
        t();
        return this.w.e();
    }

    @Override // android.view.ViewGroup
    public boolean f() {
        t();
        return this.w.f();
    }

    @Override // android.view.ViewGroup
    protected boolean fitSystemWindows(Rect rect) {
        boolean z;
        boolean obj8;
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        t();
        z = this.k(this.v, rect, true, true, false, true);
        this.I.set(rect);
        z0.a(this, this.I, this.F);
        int i2 = 1;
        if (!this.J.equals(this.I)) {
            this.J.set(this.I);
            z = i2;
        }
        if (!this.G.equals(this.F)) {
            this.G.set(this.F);
            z = i2;
        }
        if (z) {
            requestLayout();
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    public boolean g() {
        t();
        return this.w.g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m(attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        ActionBarOverlayLayout.e eVar = new ActionBarOverlayLayout.e(layoutParams);
        return eVar;
    }

    @Override // android.view.ViewGroup
    public int getActionBarHideOffset() {
        int i;
        androidx.appcompat.widget.ActionBarContainer actionBarContainer = this.v;
        if (actionBarContainer != null) {
            i = -i2;
        } else {
            i = 0;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.W.a();
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getTitle() {
        t();
        return this.w.getTitle();
    }

    @Override // android.view.ViewGroup
    public void h(int i) {
        int i2;
        androidx.appcompat.widget.z obj2;
        t();
        if (i != 2) {
            if (i != 5) {
                if (i != 109) {
                } else {
                    setOverlayMode(true);
                }
            } else {
                this.w.v();
            }
        } else {
            this.w.u();
        }
    }

    @Override // android.view.ViewGroup
    public void i() {
        t();
        this.w.h();
    }

    @Override // android.view.ViewGroup
    protected androidx.appcompat.widget.ActionBarOverlayLayout.e l() {
        final int i = -1;
        ActionBarOverlayLayout.e eVar = new ActionBarOverlayLayout.e(i, i);
        return eVar;
    }

    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.ActionBarOverlayLayout.e m(AttributeSet attributeSet) {
        ActionBarOverlayLayout.e eVar = new ActionBarOverlayLayout.e(getContext(), attributeSet);
        return eVar;
    }

    @Override // android.view.ViewGroup
    void o() {
        removeCallbacks(this.U);
        removeCallbacks(this.V);
        ViewPropertyAnimator view = this.S;
        if (view != null) {
            view.cancel();
        }
    }

    @Override // android.view.ViewGroup
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        boolean z;
        Rect equals;
        int i;
        t();
        d0 obj8 = d0.v(windowInsets);
        Rect rect4 = new Rect(obj8.j(), obj8.l(), obj8.k(), obj8.i());
        z = this.k(this.v, rect4, true, true, false, true);
        u.g(this, obj8, this.F);
        Rect rect2 = this.F;
        d0 d0Var2 = obj8.m(rect2.left, rect2.top, rect2.right, rect2.bottom);
        this.M = d0Var2;
        if (!this.N.equals(d0Var2)) {
            this.N = this.M;
            z = i;
        }
        if (!this.G.equals(this.F)) {
            this.G.set(this.F);
        } else {
            i = z;
        }
        if (i != 0) {
            requestLayout();
        }
        return obj8.a().c().b().u();
    }

    @Override // android.view.ViewGroup
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p(getContext());
        u.i0(this);
    }

    @Override // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int visibility;
        int i6;
        int i7;
        int i;
        int obj8;
        View obj9;
        obj8 = 0;
        while (obj8 < getChildCount()) {
            obj9 = getChildAt(obj8);
            if (obj9.getVisibility() != 8) {
            }
            obj8++;
            ViewGroup.LayoutParams layoutParams = obj9.getLayoutParams();
            leftMargin += obj6;
            topMargin += obj7;
            obj9.layout(i, visibility, measuredWidth += i, measuredHeight += visibility);
        }
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        int i5;
        Object rect;
        Object equals;
        int measuredHeight;
        Object contentFrameLayout;
        int i3;
        boolean tabContainer;
        Object d0Var;
        int i4;
        Rect rect2;
        t();
        this.measureChildWithMargins(this.v, i, 0, i2, 0);
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        i3 = 0;
        i5 = i6 &= 256 != 0 ? 1 : i3;
        if (i5 != 0) {
            if (this.A && this.v.getTabContainer() != null) {
                if (this.v.getTabContainer() != null) {
                    measuredHeight += tabContainer;
                }
            }
        } else {
            if (this.v.getVisibility() != 8) {
                measuredHeight = this.v.getMeasuredHeight();
            } else {
                measuredHeight = i3;
            }
        }
        this.H.set(this.F);
        final int sDK_INT = Build.VERSION.SDK_INT;
        final int i44 = 21;
        if (sDK_INT >= i44) {
            this.O = this.M;
        } else {
            this.K.set(this.I);
        }
        if (!this.z && i5 == 0) {
            if (i5 == 0) {
                rect = this.H;
                rect.top = top += measuredHeight;
                rect.bottom = bottom2 += i3;
                if (sDK_INT >= i44) {
                    this.O = this.O.m(i3, measuredHeight, i3, i3);
                }
            } else {
                if (sDK_INT >= i44) {
                    measuredHeight = new d0.b(this.O);
                    measuredHeight.c(b.b(this.O.j(), i29 += measuredHeight, this.O.k(), i35 += i3));
                    this.O = measuredHeight.a();
                } else {
                    rect = this.K;
                    rect.top = top2 += measuredHeight;
                    rect.bottom = bottom += i3;
                }
            }
        } else {
        }
        this.k(this.c, this.H, true, true, true, true);
        if (sDK_INT >= i44 && !this.P.equals(this.O)) {
            if (!this.P.equals(this.O)) {
                equals = this.O;
                this.P = equals;
                u.h(this.c, equals);
            } else {
                if (sDK_INT < i44 && !this.L.equals(this.K)) {
                    if (!this.L.equals(this.K)) {
                        this.L.set(this.K);
                        this.c.a(this.K);
                    }
                }
            }
        } else {
        }
        this.measureChildWithMargins(this.c, i, 0, i2, 0);
        ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
        int combineMeasuredStates = View.combineMeasuredStates(View.combineMeasuredStates(i3, this.v.getMeasuredState()), this.c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i19 += i32, getSuggestedMinimumWidth()), i, combineMeasuredStates), View.resolveSizeAndState(Math.max(i9 += i33, getSuggestedMinimumHeight()), i2, combineMeasuredStates <<= 16));
    }

    @Override // android.view.ViewGroup
    public boolean onNestedFling(View view, float f2, float f3, boolean z4) {
        if (this.B) {
            if (!z4) {
            } else {
                if (v(f3)) {
                    j();
                } else {
                    u();
                }
            }
            int obj1 = 1;
            this.C = obj1;
            return obj1;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4) {
    }

    @Override // android.view.ViewGroup
    public void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4, int i5) {
        if (i5 == 0) {
            onNestedPreScroll(view, i2, i3, i4Arr4);
        }
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        obj1 += i3;
        this.D = obj1;
        setActionBarHideOffset(obj1);
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] i7Arr7) {
        onNestedScroll(view, i2, i3, i4, i5, i6);
    }

    @Override // android.view.ViewGroup
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.W.b(view, view2, i3);
        this.D = getActionBarHideOffset();
        o();
        androidx.appcompat.widget.ActionBarOverlayLayout.d obj2 = this.Q;
        if (obj2 != null) {
            obj2.e();
        }
    }

    @Override // android.view.ViewGroup
    public void onNestedScrollAccepted(View view, View view2, int i3, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        int obj1;
        if (i3 & 2 != 0 && this.v.getVisibility() != 0) {
            if (this.v.getVisibility() != 0) {
            }
            return this.B;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean onStartNestedScroll(View view, View view2, int i3, int i4) {
        View obj1;
        if (i4 == 0 && onStartNestedScroll(view, view2, i3)) {
            obj1 = onStartNestedScroll(view, view2, i3) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // android.view.ViewGroup
    public void onStopNestedScroll(View view) {
        int height;
        boolean obj2;
        if (this.B && !this.C) {
            if (!this.C) {
                if (this.D <= this.v.getHeight()) {
                    s();
                } else {
                    r();
                }
            }
        }
        obj2 = this.Q;
        if (obj2 != null) {
            obj2.b();
        }
    }

    @Override // android.view.ViewGroup
    public void onStopNestedScroll(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public void onWindowSystemUiVisibilityChanged(int i) {
        int i3;
        int i4;
        int i2;
        androidx.appcompat.widget.ActionBarOverlayLayout.d obj5;
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        t();
        this.E = i;
        i2 = 1;
        i3 = i & 4 == 0 ? i2 : i4;
        if (i &= 256 != 0) {
            i4 = i2;
        }
        obj5 = this.Q;
        if (obj5 != null) {
            obj5.c(i4 ^ 1);
            if (i3 == 0) {
                if (i4 == 0) {
                    this.Q.a();
                } else {
                    this.Q.d();
                }
            } else {
            }
        }
        if (i6 & 256 != 0 && this.Q != null) {
            if (this.Q != null) {
                u.i0(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.b = i;
        final androidx.appcompat.widget.ActionBarOverlayLayout.d dVar = this.Q;
        if (dVar != null) {
            dVar.f(i);
        }
    }

    @Override // android.view.ViewGroup
    public boolean q() {
        return this.z;
    }

    @Override // android.view.ViewGroup
    public void setActionBarHideOffset(int i) {
        o();
        this.v.setTranslationY((float)obj2);
    }

    @Override // android.view.ViewGroup
    public void setActionBarVisibilityCallback(androidx.appcompat.widget.ActionBarOverlayLayout.d actionBarOverlayLayout$d) {
        int i;
        android.os.IBinder obj2;
        this.Q = d;
        this.Q.f(this.b);
        obj2 = this.E;
        if (getWindowToken() != null && obj2 != null) {
            this.Q.f(this.b);
            obj2 = this.E;
            if (obj2 != null) {
                onWindowSystemUiVisibilityChanged(obj2);
                u.i0(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setHasNonEmbeddedTabs(boolean z) {
        this.A = z;
    }

    @Override // android.view.ViewGroup
    public void setHideOnContentScrollEnabled(boolean z) {
        boolean obj2;
        this.B = z;
        if (z != this.B && !z) {
            this.B = z;
            if (!z) {
                o();
                setActionBarHideOffset(0);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setIcon(int i) {
        t();
        this.w.setIcon(i);
    }

    @Override // android.view.ViewGroup
    public void setIcon(Drawable drawable) {
        t();
        this.w.setIcon(drawable);
    }

    @Override // android.view.ViewGroup
    public void setLogo(int i) {
        t();
        this.w.m(i);
    }

    @Override // android.view.ViewGroup
    public void setOverlayMode(boolean z) {
        int i;
        boolean obj2;
        this.z = z;
        if (z && obj2.targetSdkVersion < 19) {
            obj2 = obj2.targetSdkVersion < 19 ? 1 : 0;
        } else {
        }
        this.y = obj2;
    }

    @Override // android.view.ViewGroup
    public void setShowingForActionMode(boolean z) {
    }

    @Override // android.view.ViewGroup
    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup
    public void setWindowCallback(Window.Callback window$Callback) {
        t();
        this.w.setWindowCallback(callback);
    }

    @Override // android.view.ViewGroup
    public void setWindowTitle(java.lang.CharSequence charSequence) {
        t();
        this.w.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return 0;
    }

    @Override // android.view.ViewGroup
    void t() {
        Object contentFrameLayout;
        if (this.c == null) {
            this.c = (ContentFrameLayout)findViewById(f.b);
            this.v = (ActionBarContainer)findViewById(f.c);
            this.w = n(findViewById(f.a));
        }
    }
}
