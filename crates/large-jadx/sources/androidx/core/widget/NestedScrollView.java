package androidx.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import d.h.a;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.e0.c.a;
import d.h.l.e0.e;
import d.h.l.k;
import d.h.l.l;
import d.h.l.n;
import d.h.l.p;
import d.h.l.u;
import java.util.List;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements n, k {

    private static final androidx.core.widget.NestedScrollView.a S;
    private static final int[] T;
    private View A;
    private boolean B;
    private VelocityTracker C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private final int[] J;
    private final int[] K;
    private int L;
    private int M;
    private androidx.core.widget.NestedScrollView.c N;
    private final p O;
    private final l P;
    private float Q;
    private androidx.core.widget.NestedScrollView.b R;
    private long a;
    private final Rect b;
    private OverScroller c;
    private EdgeEffect v;
    private EdgeEffect w;
    private int x;
    private boolean y;
    private boolean z;

    public interface b {
        public abstract void a(androidx.core.widget.NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    static class c extends View.BaseSavedState {

        public static final Parcelable.Creator<androidx.core.widget.NestedScrollView.c> CREATOR;
        public int a;
        static {
            NestedScrollView.c.a aVar = new NestedScrollView.c.a();
            NestedScrollView.c.CREATOR = aVar;
        }

        c(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View$BaseSavedState
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HorizontalScrollView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" scrollPosition=");
            stringBuilder.append(this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        @Override // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
        }
    }

    static class a extends a {
        @Override // d.h.l.a
        public void f(View view, AccessibilityEvent accessibilityEvent2) {
            int i;
            super.f(view, accessibilityEvent2);
            accessibilityEvent2.setClassName(ScrollView.class.getName());
            i = (NestedScrollView)view.getScrollRange() > 0 ? 1 : 0;
            accessibilityEvent2.setScrollable(i);
            accessibilityEvent2.setScrollX(view.getScrollX());
            accessibilityEvent2.setScrollY(view.getScrollY());
            e.a(accessibilityEvent2, view.getScrollX());
            e.b(accessibilityEvent2, view.getScrollRange());
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            boolean scrollRange;
            int scrollY;
            View obj3;
            super.g(view, c2);
            c2.X(ScrollView.class.getName());
            scrollRange = view.getScrollRange();
            c2.q0(true);
            if ((NestedScrollView)view.isEnabled() && scrollRange > 0 && view.getScrollY() > 0) {
                scrollRange = view.getScrollRange();
                if (scrollRange > 0) {
                    c2.q0(true);
                    if (view.getScrollY() > 0) {
                        c2.b(c.a.g);
                        c2.b(c.a.k);
                    }
                    if (view.getScrollY() < scrollRange) {
                        c2.b(c.a.f);
                        c2.b(c.a.l);
                    }
                }
            }
        }

        @Override // d.h.l.a
        public boolean j(View view, int i2, Bundle bundle3) {
            int obj5;
            final int i = 1;
            if (super.j(view, i2, bundle3)) {
                return i;
            }
            final int i3 = 0;
            if (!(NestedScrollView)view.isEnabled()) {
                return i3;
            }
            if (i2 != 4096) {
                if (i2 != 8192 && i2 != 16908344) {
                    if (i2 != 16908344) {
                        if (i2 != 16908346) {
                            return i3;
                        }
                    } else {
                        int obj4 = Math.max(obj5 -= obj4, i3);
                        if (obj4 != view.getScrollY()) {
                            view.J(i3, obj4, i);
                            return i;
                        }
                    }
                } else {
                }
                return i3;
            }
            obj4 = Math.min(obj5 += obj4, view.getScrollRange());
            if (obj4 != view.getScrollY()) {
                view.J(i3, obj4, i);
                return i;
            }
            return i3;
        }
    }
    static {
        NestedScrollView.a aVar = new NestedScrollView.a();
        NestedScrollView.S = aVar;
        int[] iArr = new int[1];
        NestedScrollView.T = iArr;
    }

    public NestedScrollView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.b);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        Rect rect = new Rect();
        this.b = rect;
        int i = 1;
        this.y = i;
        final int i2 = 0;
        this.z = i2;
        this.A = 0;
        this.B = i2;
        this.E = i;
        this.I = -1;
        int i6 = 2;
        this.J = new int[i6];
        this.K = new int[i6];
        r();
        TypedArray obj5 = context.obtainStyledAttributes(attributeSet2, NestedScrollView.T, i3, i2);
        setFillViewport(obj5.getBoolean(i2, i2));
        obj5.recycle();
        obj5 = new p(this);
        this.O = obj5;
        obj5 = new l(this);
        this.P = obj5;
        setNestedScrollingEnabled(i);
        u.l0(this, NestedScrollView.S);
    }

    private void A() {
        VelocityTracker velocityTracker;
        velocityTracker = this.C;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.C = 0;
        }
    }

    private void B(boolean z) {
        int obj2;
        final int i = 1;
        if (z != 0) {
            K(2, i);
        } else {
            L(i);
        }
        this.M = getScrollY();
        u.c0(this);
    }

    private boolean C(int i, int i2, int i3) {
        int i4;
        int i5;
        View view;
        int obj8;
        final int scrollY = getScrollY();
        height += scrollY;
        final int i7 = 1;
        i5 = i == 33 ? i7 : i4;
        if (l(i5, i2, i3) == null) {
            view = this;
        }
        if (i2 >= scrollY && i3 <= i6) {
            if (i3 <= i6) {
            } else {
                obj8 = i5 != 0 ? i2 - scrollY : i3 - i6;
                h(obj8);
                i4 = i7;
            }
        } else {
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return i4;
    }

    private void D(View view) {
        Rect rect;
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        int obj2 = e(this.b);
        if (obj2 != null) {
            scrollBy(0, obj2);
        }
    }

    private boolean E(Rect rect, boolean z2) {
        int i;
        final int obj3 = e(rect);
        final int i2 = 0;
        i = obj3 != null ? 1 : i2;
        if (i != 0) {
            if (z2) {
                scrollBy(i2, obj3);
            } else {
                F(i2, obj3);
            }
        }
        return i;
    }

    private void G(int i, int i2, int i3, boolean z4) {
        int cmp;
        int i7;
        OverScroller i5;
        int scrollX;
        int scrollY;
        int i6;
        int i4;
        int i8;
        int obj9;
        int obj10;
        boolean obj11;
        if (getChildCount() == 0) {
        }
        if (Long.compare(i9, i5) > 0) {
            obj9 = 0;
            View childAt = getChildAt(obj9);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            scrollY = getScrollY();
            this.c.startScroll(getScrollX(), scrollY, 0, obj9 - scrollY, i3);
            B(z4);
        } else {
            if (!this.c.isFinished()) {
                a();
            }
            scrollBy(i, i2);
        }
        this.a = AnimationUtils.currentAnimationTimeMillis();
    }

    private void a() {
        this.c.abortAnimation();
        L(1);
    }

    private boolean c() {
        int childCount;
        int i;
        int i2;
        int paddingBottom;
        View childAt = getChildAt(0);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (getChildCount() > 0 && i3 += bottomMargin > i4 -= paddingBottom) {
            childAt = getChildAt(i);
            layoutParams = childAt.getLayoutParams();
            if (i3 += bottomMargin > i4 -= paddingBottom) {
                i = 1;
            }
        }
        return i;
    }

    private static int d(int i, int i2, int i3) {
        if (i2 < i3) {
            if (i < 0) {
            } else {
                if (i2 + i > i3) {
                    return i3 -= i2;
                }
            }
            return i;
        }
        return 0;
    }

    private float getVerticalScrollFactorCompat() {
        int dimension;
        int displayMetrics;
        boolean resolveAttribute;
        int i;
        int i2;
        if (Float.compare(f, displayMetrics) == 0) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            } else {
                this.Q = typedValue.getDimension(context.getResources().getDisplayMetrics());
            }
            IllegalStateException illegalStateException = new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            throw illegalStateException;
        }
        return this.Q;
    }

    private void h(int i) {
        boolean z;
        int i2;
        if (i != 0) {
            i2 = 0;
            if (this.E) {
                F(i2, i);
            } else {
                scrollBy(i2, i);
            }
        }
    }

    private void i() {
        EdgeEffect edgeEffect;
        int i = 0;
        this.B = i;
        A();
        L(i);
        edgeEffect = this.v;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.w.onRelease();
        }
    }

    private void j() {
        int context;
        int edgeEffect;
        if (getOverScrollMode() != 2) {
            if (this.v == null) {
                context = getContext();
                EdgeEffect edgeEffect2 = new EdgeEffect(context);
                this.v = edgeEffect2;
                edgeEffect = new EdgeEffect(context);
                this.w = edgeEffect;
            }
        } else {
            context = 0;
            this.v = context;
            this.w = context;
        }
    }

    private View l(boolean z, int i2, int i3) {
        int i6;
        int i;
        int i4;
        Object obj;
        int bottom2;
        int bottom;
        int i5;
        int i7;
        int top;
        java.util.ArrayList focusables = getFocusables(2);
        final int i9 = 0;
        i6 = 0;
        i4 = i;
        while (i < focusables.size()) {
            obj = focusables.get(i);
            bottom2 = (View)obj.getTop();
            bottom = obj.getBottom();
            i5 = 1;
            if (i2 < bottom && bottom2 < i3) {
            }
            i++;
            if (bottom2 < i3) {
            }
            if (i2 < bottom2 && bottom < i3) {
            } else {
            }
            i7 = i9;
            if (i6 == 0) {
            } else {
            }
            if (z) {
            } else {
            }
            if (!z && bottom > i6.getBottom()) {
            } else {
            }
            bottom2 = i9;
            if (i4 != 0) {
            } else {
            }
            if (i7 != 0) {
            } else {
            }
            if (bottom2 != 0) {
            }
            i6 = obj;
            i6 = obj;
            i4 = i5;
            if (i7 != 0 && bottom2 != 0) {
            }
            if (bottom2 != 0) {
            }
            if (bottom > i6.getBottom()) {
            } else {
            }
            bottom2 = i5;
            if (bottom2 >= i6.getTop()) {
            } else {
            }
            i6 = obj;
            i4 = i7;
            if (bottom < i3) {
            } else {
            }
            i7 = i5;
        }
        return i6;
    }

    private boolean p(int i, int i2) {
        int childCount;
        int i3;
        View childAt;
        int i4;
        int obj6;
        childCount = getScrollY();
        childAt = getChildAt(0);
        if (getChildCount() > 0 && i2 >= top -= childCount && i2 < bottom -= childCount && i >= childAt.getLeft() && i < childAt.getRight()) {
            childCount = getScrollY();
            childAt = getChildAt(i3);
            if (i2 >= top -= childCount) {
                if (i2 < bottom -= childCount) {
                    if (i >= childAt.getLeft()) {
                        if (i < childAt.getRight()) {
                            i3 = 1;
                        }
                    }
                }
            }
        }
        return i3;
    }

    private void q() {
        VelocityTracker obtain;
        obtain = this.C;
        if (obtain == null) {
            this.C = VelocityTracker.obtain();
        } else {
            obtain.clear();
        }
    }

    private void r() {
        OverScroller overScroller = new OverScroller(getContext());
        this.c = overScroller;
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration view = ViewConfiguration.get(getContext());
        this.F = view.getScaledTouchSlop();
        this.G = view.getScaledMinimumFlingVelocity();
        this.H = view.getScaledMaximumFlingVelocity();
    }

    private void s() {
        VelocityTracker obtain;
        if (this.C == null) {
            this.C = VelocityTracker.obtain();
        }
    }

    private boolean t(View view) {
        return obj3 ^= 1;
    }

    private static boolean u(View view, View view2) {
        int i;
        ViewParent obj2;
        if (view == view2) {
            return 1;
        }
        obj2 = view.getParent();
        if (obj2 instanceof ViewGroup && NestedScrollView.u((View)obj2, view2)) {
            if (NestedScrollView.u((View)obj2, view2)) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean v(View view, int i2, int i3) {
        int obj2;
        int obj3;
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        if (obj2 += i2 >= getScrollY() && obj2 -= i2 <= obj3 += i3) {
            obj2 = obj2 -= i2 <= obj3 += i3 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private void w(int i, int i2, int[] i3Arr3) {
        int scrollY;
        int scrollY2;
        scrollBy(0, i);
        final int i6 = scrollY2 - scrollY;
        if (i3Arr3 != null) {
            scrollY = 1;
            i3Arr3[scrollY] = i4 += i6;
        }
        this.P.e(0, i6, 0, i - i6, 0, i2, i3Arr3);
    }

    private void x(MotionEvent motionEvent) {
        int actionIndex;
        int pointerId;
        VelocityTracker obj4;
        actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.I) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.x = (int)f;
            this.I = motionEvent.getPointerId(actionIndex);
            obj4 = this.C;
            if (obj4 != null) {
                obj4.clear();
            }
        }
    }

    @Override // android.widget.FrameLayout
    public final void F(int i, int i2) {
        G(i, i2, 250, false);
    }

    @Override // android.widget.FrameLayout
    public final void H(int i, int i2, int i3) {
        I(i, i2, i3, false);
    }

    @Override // android.widget.FrameLayout
    void I(int i, int i2, int i3, boolean z4) {
        G(i -= scrollX, i2 -= scrollY, i3, z4);
    }

    @Override // android.widget.FrameLayout
    void J(int i, int i2, boolean z3) {
        I(i, i2, 250, z3);
    }

    @Override // android.widget.FrameLayout
    public boolean K(int i, int i2) {
        return this.P.p(i, i2);
    }

    @Override // android.widget.FrameLayout
    public void L(int i) {
        this.P.r(i);
    }

    @Override // android.widget.FrameLayout
    public void addView(View view) {
        if (getChildCount() > 0) {
        } else {
            super.addView(view);
        }
        IllegalStateException obj2 = new IllegalStateException("ScrollView can host only one direct child");
        throw obj2;
    }

    @Override // android.widget.FrameLayout
    public void addView(View view, int i2) {
        if (getChildCount() > 0) {
        } else {
            super.addView(view, i2);
        }
        IllegalStateException obj2 = new IllegalStateException("ScrollView can host only one direct child");
        throw obj2;
    }

    @Override // android.widget.FrameLayout
    public void addView(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        if (getChildCount() > 0) {
        } else {
            super.addView(view, i2, layoutParams3);
        }
        IllegalStateException obj2 = new IllegalStateException("ScrollView can host only one direct child");
        throw obj2;
    }

    @Override // android.widget.FrameLayout
    public void addView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        if (getChildCount() > 0) {
        } else {
            super.addView(view, layoutParams2);
        }
        IllegalStateException obj2 = new IllegalStateException("ScrollView can host only one direct child");
        throw obj2;
    }

    @Override // android.widget.FrameLayout
    public boolean b(int i) {
        View focus;
        View childCount;
        int maxScrollAmount;
        boolean z;
        int i3;
        int i2;
        int paddingBottom;
        int obj8;
        if (findFocus() == this) {
            focus = 0;
        }
        childCount = FocusFinder.getInstance().findNextFocus(this, focus, i);
        maxScrollAmount = getMaxScrollAmount();
        if (childCount != null && v(childCount, maxScrollAmount, getHeight())) {
            if (v(childCount, maxScrollAmount, getHeight())) {
                childCount.getDrawingRect(this.b);
                offsetDescendantRectToMyCoords(childCount, this.b);
                h(e(this.b));
                childCount.requestFocus(i);
            } else {
                z = 0;
                i3 = 130;
                if (i == 33 && getScrollY() < maxScrollAmount) {
                    if (getScrollY() < maxScrollAmount) {
                        maxScrollAmount = getScrollY();
                    } else {
                        if (i == i3 && getChildCount() > 0) {
                            if (getChildCount() > 0) {
                                View childAt = getChildAt(z);
                                maxScrollAmount = Math.min(i4 -= i2, maxScrollAmount);
                            }
                        }
                    }
                } else {
                }
                if (maxScrollAmount == 0) {
                    return z;
                }
                if (i == i3) {
                } else {
                    maxScrollAmount = -maxScrollAmount;
                }
                h(maxScrollAmount);
            }
        } else {
        }
        if (focus != null && focus.isFocused() && t(focus)) {
            if (focus.isFocused()) {
                if (t(focus)) {
                    setDescendantFocusability(131072);
                    requestFocus();
                    setDescendantFocusability(getDescendantFocusability());
                }
            }
        }
        return 1;
    }

    @Override // android.widget.FrameLayout
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.widget.FrameLayout
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.widget.FrameLayout
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.widget.FrameLayout
    public void computeScroll() {
        int overScrollMode;
        int i2;
        int i9;
        int[] iArr2;
        int i5;
        int i4;
        int i;
        int[] iArr;
        int i8;
        int i3;
        int i6;
        int i7;
        int scrollY;
        final Object obj = this;
        if (obj.c.isFinished()) {
        }
        obj.c.computeScrollOffset();
        int currY = obj.c.getCurrY();
        i = currY - i10;
        obj.M = currY;
        iArr2 = obj.K;
        final int i16 = 1;
        i6 = 0;
        iArr2[i16] = i6;
        this.f(0, i, iArr2, 0, 1);
        i7 = i - overScrollMode;
        final int scrollRange = getScrollRange();
        if (i7 != 0) {
            scrollY = getScrollY();
            i2 = 0;
            this.y(i2, i7, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            i9 = scrollY2 - scrollY;
            i7 -= i9;
            iArr = obj.K;
            iArr[i16] = i6;
            this.g(i2, i9, 0, i17, obj.J, 1, iArr);
            i17 -= overScrollMode;
        }
        if (i7 != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (overScrollMode == i16 && scrollRange > 0) {
                    if (scrollRange > 0) {
                        i6 = i16;
                    }
                }
            } else {
            }
            if (i6 != 0) {
                j();
                if (i7 < 0) {
                    if (obj.v.isFinished()) {
                        obj.v.onAbsorb((int)currVelocity);
                    }
                } else {
                    if (obj.w.isFinished()) {
                        obj.w.onAbsorb((int)currVelocity2);
                    }
                }
            }
            a();
        }
        if (!obj.c.isFinished()) {
            u.c0(this);
        } else {
            obj.L(i16);
        }
    }

    @Override // android.widget.FrameLayout
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.widget.FrameLayout
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.widget.FrameLayout
    public int computeVerticalScrollRange() {
        int i;
        int scrollY;
        i4 -= paddingTop;
        if (getChildCount() == 0) {
            return i5;
        }
        int i2 = 0;
        View childAt = getChildAt(i2);
        bottom += bottomMargin;
        scrollY = getScrollY();
        int i3 = Math.max(i2, i - i5);
        if (scrollY < 0) {
            i -= scrollY;
        } else {
            if (scrollY > i3) {
                i += scrollY;
            }
        }
        return i;
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int obj2;
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (k(keyEvent)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedFling(float f, float f2, boolean z3) {
        return this.P.a(f, f2, z3);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.P.b(f, f2);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedPreScroll(int i, int i2, int[] i3Arr3, int[] i4Arr4) {
        return this.f(i, i2, i3Arr3, i4Arr4, 0);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] i5Arr5) {
        return this.P.f(i, i2, i3, i4, i5Arr5);
    }

    @Override // android.widget.FrameLayout
    public void draw(Canvas canvas) {
        int i;
        EdgeEffect scrollY;
        boolean finished2;
        boolean finished;
        int i3;
        int clipToPadding2;
        int width;
        boolean width2;
        int height;
        int i2;
        EdgeEffect paddingBottom;
        int clipToPadding;
        float clipToPadding4;
        boolean clipToPadding3;
        int paddingBottom2;
        super.draw(canvas);
        scrollY = getScrollY();
        i3 = 0;
        clipToPadding2 = 21;
        if (this.v != null && !this.v.isFinished()) {
            scrollY = getScrollY();
            i3 = 0;
            clipToPadding2 = 21;
            if (!this.v.isFinished()) {
                clipToPadding = Build.VERSION.SDK_INT;
                if (clipToPadding >= clipToPadding2) {
                    if (getClipToPadding()) {
                        width -= i10;
                        paddingLeft3 += i3;
                    } else {
                        clipToPadding3 = i3;
                    }
                } else {
                }
                if (clipToPadding >= clipToPadding2 && getClipToPadding()) {
                    if (getClipToPadding()) {
                        height -= i8;
                        i2 += clipToPadding;
                    }
                }
                canvas.translate((float)clipToPadding3, (float)i2);
                this.v.setSize(width, height);
                if (this.v.draw(canvas)) {
                    u.c0(this);
                }
                canvas.restoreToCount(canvas.save());
            }
            if (!this.w.isFinished()) {
                height = getHeight();
                paddingBottom = Build.VERSION.SDK_INT;
                if (paddingBottom >= clipToPadding2) {
                    if (getClipToPadding()) {
                        width2 -= i9;
                        i3 += clipToPadding4;
                    }
                } else {
                }
                if (paddingBottom >= clipToPadding2 && getClipToPadding()) {
                    if (getClipToPadding()) {
                        height -= i7;
                        i -= clipToPadding2;
                    }
                }
                canvas.translate((float)i6, (float)i);
                canvas.rotate(1127481344, (float)width2, 0);
                this.w.setSize(width2, height);
                if (this.w.draw(canvas)) {
                    u.c0(this);
                }
                canvas.restoreToCount(canvas.save());
            }
        }
    }

    @Override // android.widget.FrameLayout
    protected int e(Rect rect) {
        int height2;
        int i3;
        int i2;
        int scrollY;
        int height;
        int i;
        int bottom;
        int top;
        int obj11;
        i2 = 0;
        if (getChildCount() == 0) {
            return i2;
        }
        height2 = getHeight();
        scrollY = getScrollY();
        height = scrollY + height2;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(i2);
        final ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        i = rect.bottom < i5 += bottomMargin2 ? height - verticalFadingEdgeLength : height;
        bottom = rect.bottom;
        if (bottom > i && rect.top > scrollY) {
            if (rect.top > scrollY) {
                obj11 = rect.height() > height2 ? obj11 - scrollY : obj11 - i;
                i2 = Math.min(obj11 += i2, i4 -= height);
            } else {
                if (rect.top < scrollY && bottom < i) {
                    if (bottom < i) {
                        if (rect.height() > height2) {
                            i2 -= i;
                        } else {
                            i2 -= scrollY;
                        }
                        i2 = Math.max(i3, -obj11);
                    }
                }
            }
        } else {
        }
        return i2;
    }

    @Override // android.widget.FrameLayout
    public boolean f(int i, int i2, int[] i3Arr3, int[] i4Arr4, int i5) {
        return this.P.d(i, i2, i3Arr3, i4Arr4, i5);
    }

    @Override // android.widget.FrameLayout
    public void g(int i, int i2, int i3, int i4, int[] i5Arr5, int i6, int[] i7Arr7) {
        this.P.e(i, i2, i3, i4, i5Arr5, i6, i7Arr7);
    }

    @Override // android.widget.FrameLayout
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        final int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        i4 -= i8;
        if (i5 < verticalFadingEdgeLength) {
            return f /= f2;
        }
        return 1065353216;
    }

    @Override // android.widget.FrameLayout
    public int getMaxScrollAmount() {
        return (int)i;
    }

    @Override // android.widget.FrameLayout
    public int getNestedScrollAxes() {
        return this.O.a();
    }

    @Override // android.widget.FrameLayout
    int getScrollRange() {
        int childCount;
        int i;
        int i2;
        int paddingBottom;
        i = 0;
        if (getChildCount() > 0) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            i = Math.max(i, i4 -= i2);
        }
        return i;
    }

    @Override // android.widget.FrameLayout
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return f2 /= f;
        }
        return 1065353216;
    }

    @Override // android.widget.FrameLayout
    public boolean hasNestedScrollingParent() {
        return o(0);
    }

    @Override // android.widget.FrameLayout
    public boolean isNestedScrollingEnabled() {
        return this.P.l();
    }

    @Override // android.widget.FrameLayout
    public boolean k(KeyEvent keyEvent) {
        boolean instance;
        int keyCode;
        int i3;
        int i;
        int i4;
        int i2;
        int obj6;
        this.b.setEmpty();
        i3 = 0;
        i = 130;
        if (!c() && isFocused() && keyEvent.getKeyCode() != 4 && findFocus() == this) {
            if (isFocused()) {
                if (keyEvent.getKeyCode() != 4) {
                    if (findFocus() == this) {
                        obj6 = 0;
                    }
                    obj6 = FocusFinder.getInstance().findNextFocus(this, obj6, i);
                    if (obj6 != null && obj6 != this && obj6.requestFocus(i)) {
                        if (obj6 != this) {
                            if (obj6.requestFocus(i)) {
                                i3 = 1;
                            }
                        }
                    }
                }
            }
            return i3;
        }
        if (keyEvent.getAction() == 0) {
            keyCode = keyEvent.getKeyCode();
            i2 = 33;
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                    } else {
                        if (keyEvent.isShiftPressed()) {
                            i = i2;
                        }
                        z(i);
                    }
                } else {
                    if (!keyEvent.isAltPressed()) {
                        i3 = b(i);
                    } else {
                        i3 = n(i);
                    }
                }
            } else {
                if (!keyEvent.isAltPressed()) {
                    i3 = b(i2);
                } else {
                    i3 = n(i2);
                }
            }
        }
        return i3;
    }

    @Override // android.widget.FrameLayout
    public void m(int i) {
        OverScroller overScroller;
        int scrollX;
        int scrollY;
        int i9;
        int i5;
        int i3;
        int i4;
        int i8;
        int i7;
        int i2;
        int i6;
        int obj13;
        if (getChildCount() > 0) {
            this.c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            B(true);
        }
    }

    @Override // android.widget.FrameLayout
    protected void measureChild(View view, int i2, int i3) {
        int obj5 = 0;
        view.measure(FrameLayout.getChildMeasureSpec(i2, paddingLeft += paddingRight, obj5.width), View.MeasureSpec.makeMeasureSpec(obj5, obj5));
    }

    @Override // android.widget.FrameLayout
    protected void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams obj5 = view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, obj6 += i3, obj5.width), View.MeasureSpec.makeMeasureSpec(obj4 += obj5, 0));
    }

    @Override // android.widget.FrameLayout
    public boolean n(int i) {
        int i3;
        int childCount;
        int i2;
        i3 = 1;
        childCount = 0;
        i2 = i == 130 ? i3 : childCount;
        final int height = getHeight();
        final Rect rect2 = this.b;
        rect2.top = childCount;
        rect2.bottom = height;
        childCount = getChildCount();
        if (i2 != 0 && childCount > 0) {
            childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount -= i3);
                i2.bottom = i4 += paddingBottom;
                i3 = this.b;
                i3.top = bottom3 -= height;
            }
        }
        Rect rect = this.b;
        return C(i, rect.top, rect.bottom);
    }

    @Override // android.widget.FrameLayout
    public boolean o(int i) {
        return this.P.k(i);
    }

    @Override // android.widget.FrameLayout
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.z = false;
    }

    @Override // android.widget.FrameLayout
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int scrollRange;
        int scrollY;
        float obj4;
        final int i3 = 0;
        if (source &= 2 != 0) {
            if (motionEvent.getAction() != 8) {
            } else {
                obj4 = motionEvent.getAxisValue(9);
                if (!this.B && Float.compare(obj4, i2) != 0) {
                    obj4 = motionEvent.getAxisValue(9);
                    if (Float.compare(obj4, i2) != 0) {
                        scrollY = getScrollY();
                        obj4 = scrollY - obj4;
                        if (obj4 < 0) {
                            scrollRange = i3;
                        } else {
                            if (obj4 > getScrollRange()) {
                            } else {
                                scrollRange = obj4;
                            }
                        }
                        if (scrollRange != scrollY) {
                            super.scrollTo(getScrollX(), scrollRange);
                            return 1;
                        }
                    }
                }
            }
        }
        return i3;
    }

    @Override // android.widget.FrameLayout
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int str2;
        int str;
        boolean z;
        OverScroller nestedScrollAxes;
        int pointerIndex;
        int scrollY;
        int i2;
        int i;
        int i3;
        int scrollRange;
        boolean obj12;
        int action = motionEvent.getAction();
        str = 2;
        final int i4 = 1;
        if (action == str && this.B) {
            if (this.B) {
                return i4;
            }
        }
        action &= 255;
        int i5 = 0;
        if (str2 != null) {
            nestedScrollAxes = -1;
            if (str2 != i4) {
                if (str2 != str) {
                    if (str2 != 3) {
                        if (str2 != 6) {
                        } else {
                            x(motionEvent);
                        }
                    } else {
                        this.B = i5;
                        this.I = nestedScrollAxes;
                        A();
                        if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            u.c0(this);
                        }
                        L(i5);
                    }
                } else {
                    str2 = this.I;
                    if (str2 == nestedScrollAxes) {
                    } else {
                        pointerIndex = motionEvent.findPointerIndex(str2);
                        if (pointerIndex == nestedScrollAxes) {
                            obj12 = new StringBuilder();
                            obj12.append("Invalid pointerId=");
                            obj12.append(str2);
                            obj12.append(" in onInterceptTouchEvent");
                            Log.e("NestedScrollView", obj12.toString());
                        } else {
                            str2 = (int)f;
                            this.B = i4;
                            this.x = str2;
                            s();
                            this.C.addMovement(motionEvent);
                            this.L = i5;
                            obj12 = getParent();
                            if (Math.abs(str2 - i6) > this.F && str &= nestedScrollAxes == 0 && obj12 != null) {
                                if (str &= nestedScrollAxes == 0) {
                                    this.B = i4;
                                    this.x = str2;
                                    s();
                                    this.C.addMovement(motionEvent);
                                    this.L = i5;
                                    obj12 = getParent();
                                    if (obj12 != null) {
                                        obj12.requestDisallowInterceptTouchEvent(i4);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
            }
        } else {
            str2 = (int)f2;
            if (!p((int)f3, str2)) {
                this.B = i5;
                A();
            } else {
                this.x = str2;
                this.I = motionEvent.getPointerId(i5);
                q();
                this.C.addMovement(motionEvent);
                this.c.computeScrollOffset();
                this.B = obj12 ^= i4;
                K(str, i5);
            }
        }
        return this.B;
    }

    @Override // android.widget.FrameLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i;
        int obj2;
        View obj3;
        boolean obj5;
        int obj6;
        super.onLayout(z, i2, i3, i4, i5);
        obj2 = 0;
        this.y = obj2;
        obj3 = this.A;
        if (obj3 != null && NestedScrollView.u(obj3, this)) {
            if (NestedScrollView.u(obj3, this)) {
                D(this.A);
            }
        }
        obj3 = 0;
        this.A = obj3;
        if (!this.z && this.N != null) {
            if (this.N != null) {
                scrollTo(getScrollX(), view.a);
                this.N = obj3;
            }
            if (getChildCount() > 0) {
                obj2 = getChildAt(obj2);
                obj3 = obj2.getLayoutParams();
                obj2 += obj3;
            }
            obj3 = getScrollY();
            obj2 = NestedScrollView.d(obj3, obj6 -= obj3, obj2);
            if (obj2 != obj3) {
                scrollTo(getScrollX(), obj2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.z = true;
    }

    @Override // android.widget.FrameLayout
    protected void onMeasure(int i, int i2) {
        boolean layoutParams;
        int measuredHeight;
        int i3;
        int bottomMargin;
        int obj5;
        int obj6;
        super.onMeasure(i, i2);
        if (!this.D) {
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
        }
        obj6 = getChildAt(0);
        layoutParams = obj6.getLayoutParams();
        i9 -= bottomMargin;
        if (getChildCount() > 0 && obj6.getMeasuredHeight() < i3) {
            obj6 = getChildAt(0);
            layoutParams = obj6.getLayoutParams();
            i9 -= bottomMargin;
            if (obj6.getMeasuredHeight() < i3) {
                obj6.measure(FrameLayout.getChildMeasureSpec(i, i6 += bottomMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            }
        }
    }

    @Override // android.widget.FrameLayout
    public boolean onNestedFling(View view, float f2, float f3, boolean z4) {
        if (!z4) {
            final int obj2 = 1;
            dispatchNestedFling(0, f3, obj2);
            m((int)f3);
            return obj2;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.widget.FrameLayout
    public void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4) {
        this.onNestedPreScroll(view, i2, i3, i4Arr4, 0);
    }

    @Override // android.widget.FrameLayout
    public void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4, int i5) {
        this.f(i2, i3, i4Arr4, 0, i5);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        w(i5, 0, 0);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        w(i5, i6, 0);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] i7Arr7) {
        w(i5, i6, i7Arr7);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        onNestedScrollAccepted(view, view2, i3, 0);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScrollAccepted(View view, View view2, int i3, int i4) {
        this.O.c(view, view2, i3, i4);
        K(2, i4);
    }

    @Override // android.widget.FrameLayout
    protected void onOverScrolled(int i, int i2, boolean z3, boolean z4) {
        super.scrollTo(i, i2);
    }

    @Override // android.widget.FrameLayout
    protected boolean onRequestFocusInDescendants(int i, Rect rect2) {
        int i2;
        View nextFocusFromRect;
        int i3;
        int obj4;
        if (i == 2) {
            obj4 = 130;
        } else {
            if (i == 1) {
                obj4 = 33;
            }
        }
        if (rect2 == null) {
            nextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, 0, obj4);
        } else {
            nextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect2, obj4);
        }
        int i4 = 0;
        if (nextFocusFromRect == null) {
            return i4;
        }
        if (t(nextFocusFromRect)) {
            return i4;
        }
        return nextFocusFromRect.requestFocus(obj4, rect2);
    }

    @Override // android.widget.FrameLayout
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof NestedScrollView.c) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((NestedScrollView.c)parcelable.getSuperState());
        this.N = parcelable;
        requestLayout();
    }

    @Override // android.widget.FrameLayout
    protected Parcelable onSaveInstanceState() {
        NestedScrollView.c cVar = new NestedScrollView.c(super.onSaveInstanceState());
        cVar.a = getScrollY();
        return cVar;
    }

    @Override // android.widget.FrameLayout
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i8;
        int i7;
        super.onScrollChanged(i, i2, i3, i4);
        final androidx.core.widget.NestedScrollView.b view = this.R;
        if (view != null) {
            view.a(this, i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        View obj1;
        int obj2;
        super.onSizeChanged(i, i2, i3, i4);
        obj1 = findFocus();
        if (obj1 != null) {
            if (this == obj1) {
            } else {
                if (v(obj1, 0, i4)) {
                    obj1.getDrawingRect(this.b);
                    offsetDescendantRectToMyCoords(obj1, this.b);
                    h(e(this.b));
                }
            }
        }
    }

    @Override // android.widget.FrameLayout
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return onStartNestedScroll(view, view2, i3, 0);
    }

    @Override // android.widget.FrameLayout
    public boolean onStartNestedScroll(View view, View view2, int i3, int i4) {
        int obj1;
        obj1 = i3 & 2 != 0 ? 1 : 0;
        return obj1;
    }

    @Override // android.widget.FrameLayout
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.widget.FrameLayout
    public void onStopNestedScroll(View view, int i2) {
        this.O.e(view, i2);
        L(i2);
    }

    @Override // android.widget.FrameLayout
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        int parent;
        int i7;
        boolean z;
        boolean z2;
        int finished;
        int str;
        int i;
        int i5;
        int i11;
        int dispatchNestedPreFling;
        int[] iArr;
        int i8;
        int i10;
        int i4;
        int i2;
        OverScroller pointerIndex;
        int scrollX;
        int scrollY;
        int i3;
        int i6;
        int i9;
        int scrollRange;
        int i12;
        final Object obj = this;
        final MotionEvent motionEvent2 = motionEvent;
        s();
        actionMasked = motionEvent.getActionMasked();
        final int i45 = 0;
        if (actionMasked == 0) {
            obj.L = i45;
        }
        final MotionEvent obtain = MotionEvent.obtain(motionEvent);
        i5 = 0;
        obtain.offsetLocation(i5, (float)i27);
        str = 2;
        final int i46 = 1;
        if (actionMasked != 0) {
            i11 = -1;
            if (actionMasked != i46) {
                if (actionMasked != str) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked != 6) {
                            } else {
                                x(motionEvent);
                                obj.x = (int)f2;
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            obj.x = (int)f7;
                            obj.I = motionEvent2.getPointerId(actionIndex);
                        }
                    } else {
                        if (obj.B && getChildCount() > 0 && obj.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            if (getChildCount() > 0) {
                                if (obj.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                                    u.c0(this);
                                }
                            }
                        }
                        obj.I = i11;
                        i();
                    }
                } else {
                    pointerIndex = motionEvent2.findPointerIndex(obj.I);
                    if (pointerIndex == i11) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid pointerId=");
                        stringBuilder.append(obj.I);
                        stringBuilder.append(" in onTouchEvent");
                        Log.e("NestedScrollView", stringBuilder.toString());
                    } else {
                        i8 = (int)f3;
                        i16 -= i8;
                        ViewParent parent2 = getParent();
                        if (!obj.B && Math.abs(i7) > obj.F && parent2 != null) {
                            if (Math.abs(i7) > obj.F) {
                                parent2 = getParent();
                                if (parent2 != null) {
                                    parent2.requestDisallowInterceptTouchEvent(i46);
                                }
                                obj.B = i46;
                                i7 = i7 > 0 ? i7 - str : i7 + str;
                            }
                        }
                        i10 = i7;
                        if (obj.B && this.f(0, i10, obj.K, obj.J, 0)) {
                            if (this.f(0, i10, obj.K, obj.J, 0)) {
                                i10 -= i24;
                                obj.L = i25 += i;
                            }
                            scrollX = i10;
                            obj.x = i8 -= i17;
                            scrollY = getScrollY();
                            int scrollRange2 = getScrollRange();
                            int overScrollMode = getOverScrollMode();
                            if (overScrollMode != 0) {
                                if (overScrollMode == i46 && scrollRange2 > 0) {
                                    if (scrollRange2 > 0) {
                                        i3 = i46;
                                    } else {
                                        i3 = i45;
                                    }
                                } else {
                                }
                            } else {
                            }
                            if (this.y(0, scrollX, 0, getScrollY(), 0, scrollRange2, 0, 0, true) && !obj.o(i45)) {
                                if (!obj.o(i45)) {
                                    obj.C.clear();
                                }
                            }
                            int i36 = scrollY2 - scrollY;
                            i10 = obj.K;
                            i10[i46] = i45;
                            this.g(0, i36, 0, scrollX - i36, obj.J, 0, i10);
                            int[] iArr5 = obj.J;
                            obj.x = i18 -= i5;
                            obj.L = i20 += str;
                            if (i3 != 0) {
                                finished = scrollX - i21;
                                j();
                                str = scrollY + finished;
                                if (str < 0) {
                                    f.a(obj.v, f5 /= f9, f10 /= i11);
                                    if (!obj.w.isFinished()) {
                                        obj.w.onRelease();
                                    }
                                } else {
                                    f.a(obj.w, f4 /= f8, i37 -= i11);
                                    if (str > scrollRange2 && !obj.v.isFinished()) {
                                        f.a(obj.w, f4 /= f8, i37 -= i11);
                                        if (!obj.v.isFinished()) {
                                            obj.v.onRelease();
                                        }
                                    }
                                }
                                actionMasked = obj.v;
                                if (actionMasked != null) {
                                    if (actionMasked.isFinished()) {
                                        if (!obj.w.isFinished()) {
                                            u.c0(this);
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker2 = obj.C;
                velocityTracker2.computeCurrentVelocity(1000, (float)i39);
                int i26 = (int)yVelocity;
                if (Math.abs(i26) >= obj.G) {
                    actionMasked = -i26;
                    str = (float)actionMasked;
                    if (!obj.dispatchNestedPreFling(i5, str)) {
                        obj.dispatchNestedFling(i5, str, i46);
                        obj.m(actionMasked);
                    }
                } else {
                    if (obj.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        u.c0(this);
                    }
                }
                obj.I = i11;
                i();
            }
        } else {
            if (getChildCount() == 0) {
                return i45;
            }
            finished2 ^= i46;
            obj.B = parent;
            parent = getParent();
            if (parent != 0 && parent != null) {
                parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(i46);
                }
            }
            if (!obj.c.isFinished()) {
                a();
            }
            obj.x = (int)f;
            obj.I = motionEvent2.getPointerId(i45);
            obj.K(str, i45);
        }
        VelocityTracker velocityTracker = obj.C;
        if (velocityTracker != null) {
            velocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return i46;
    }

    @Override // android.widget.FrameLayout
    public void requestChildFocus(View view, View view2) {
        if (!this.y) {
            D(view2);
        } else {
            this.A = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.widget.FrameLayout
    public boolean requestChildRectangleOnScreen(View view, Rect rect2, boolean z3) {
        rect2.offset(left -= scrollX, top -= obj3);
        return E(rect2, z3);
    }

    @Override // android.widget.FrameLayout
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            A();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.widget.FrameLayout
    public void requestLayout() {
        this.y = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout
    public void scrollTo(int i, int i2) {
        int childCount;
        int bottomMargin;
        int i5;
        int i4;
        int i3;
        int topMargin;
        int obj7;
        int obj8;
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            obj7 = NestedScrollView.d(i, i9 -= paddingRight, i10 += rightMargin);
            obj8 = NestedScrollView.d(i2, i11 -= paddingBottom, i7 += bottomMargin);
            if (obj7 == getScrollX()) {
                if (obj8 != getScrollY()) {
                    super.scrollTo(obj7, obj8);
                }
            } else {
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void setFillViewport(boolean z) {
        if (z != this.D) {
            this.D = z;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout
    public void setNestedScrollingEnabled(boolean z) {
        this.P.m(z);
    }

    @Override // android.widget.FrameLayout
    public void setOnScrollChangeListener(androidx.core.widget.NestedScrollView.b nestedScrollView$b) {
        this.R = b;
    }

    @Override // android.widget.FrameLayout
    public void setSmoothScrollingEnabled(boolean z) {
        this.E = z;
    }

    @Override // android.widget.FrameLayout
    public boolean shouldDelayChildPressedState() {
        return 1;
    }

    @Override // android.widget.FrameLayout
    public boolean startNestedScroll(int i) {
        return K(i, 0);
    }

    @Override // android.widget.FrameLayout
    public void stopNestedScroll() {
        L(0);
    }

    @Override // android.widget.FrameLayout
    boolean y(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z9) {
        int i12;
        int i13;
        int i18;
        int i15;
        int i9;
        int i19;
        int i10;
        int i11;
        int i23;
        int i20;
        int i16;
        int i21;
        int i22;
        int i14;
        int i17;
        int scrollRange;
        int obj13;
        int obj14;
        int obj15;
        int obj16;
        int obj17;
        int obj18;
        int obj19;
        int overScrollMode = getOverScrollMode();
        i20 = 0;
        final int i26 = 1;
        i15 = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? i26 : i20;
        i11 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? i26 : i20;
        if (overScrollMode != 0) {
            if (overScrollMode == i26 && i15 != 0) {
                if (i15 != 0) {
                    i9 = i26;
                } else {
                    i9 = i20;
                }
            } else {
            }
        } else {
        }
        if (overScrollMode != 0) {
            if (overScrollMode == i26 && i11 != 0) {
                if (i11 != 0) {
                    i12 = i26;
                } else {
                    i12 = i20;
                }
            } else {
            }
        } else {
        }
        i23 = i3 + i;
        i19 = i9 == 0 ? i20 : i7;
        i16 = i4 + i2;
        i13 = i12 == 0 ? i20 : i8;
        i21 = -i19;
        i19 += i5;
        i22 = -i13;
        i13 += i6;
        if (i23 > i25) {
            i23 = i25;
            i10 = i26;
        } else {
            if (i23 < i21) {
                i10 = i26;
                i23 = i21;
            } else {
                i10 = i20;
            }
        }
        if (i16 > i24) {
            i16 = i24;
            i18 = i26;
        } else {
            if (i16 < i22) {
                i18 = i26;
                i16 = i22;
            } else {
                i18 = i20;
            }
        }
        if (i18 != 0 && !o(i26)) {
            if (!o(i26)) {
                obj.c.springBack(i23, i16, 0, 0, 0, getScrollRange());
            }
        }
        onOverScrolled(i23, i16, i10, i18);
        if (i10 == 0) {
            if (i18 != 0) {
                i20 = i26;
            }
        } else {
        }
        return i20;
    }

    @Override // android.widget.FrameLayout
    public boolean z(int i) {
        Rect i2;
        int childCount;
        int i3;
        int top;
        i2 = 1;
        childCount = 0;
        i3 = i == 130 ? i2 : childCount;
        int height = getHeight();
        if (i3 != 0) {
            rect3.top = scrollY2 += height;
            childCount = getChildCount();
            View childAt = getChildAt(childCount -= i2);
            i4 += paddingBottom;
            childCount = this.b;
            if (childCount > 0 && top3 += height > i2) {
                childAt = getChildAt(childCount -= i2);
                i4 += paddingBottom;
                childCount = this.b;
                if (top3 += height > i2) {
                    childCount.top = i2 -= height;
                }
            }
        } else {
            rect.top = scrollY -= height;
            i2 = this.b;
            if (i2.top < 0) {
                i2.top = childCount;
            }
        }
        Rect rect2 = this.b;
        int top2 = rect2.top;
        height += top2;
        rect2.bottom = i8;
        return C(i, top2, i8);
    }
}
