package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import androidx.core.graphics.drawable.a;
import com.google.android.material.internal.l;
import com.google.android.material.theme.a.a;
import d.a.k.a.a;
import d.h.h.a;
import d.h.k.c;
import d.h.l.d0;
import d.h.l.e0.c.a;
import d.h.l.q;
import d.h.l.u;
import d.j.a.a;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.d0.g;
import f.c.a.e.d0.h;
import f.c.a.e.g;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.m.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    private static final int K;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private WeakReference<View> F;
    private ValueAnimator G;
    private final List<com.google.android.material.appbar.AppBarLayout.g> H;
    private int[] I;
    private Drawable J;
    private int a;
    private int b;
    private int c;
    private int v;
    private boolean w;
    private int x;
    private d0 y;
    private List<com.google.android.material.appbar.AppBarLayout.c> z;

    class b implements ValueAnimator.AnimatorUpdateListener {

        final g a;
        final com.google.android.material.appbar.AppBarLayout b;
        b(com.google.android.material.appbar.AppBarLayout appBarLayout, g g2) {
            this.b = appBarLayout;
            this.a = g2;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            boolean drawable;
            Object next;
            int i;
            float obj4 = (Float)valueAnimator.getAnimatedValue().floatValue();
            this.a.Y(obj4);
            if (drawable2 instanceof g) {
                (g)AppBarLayout.a(this.b).Y(obj4);
            }
            Iterator iterator = AppBarLayout.b(this.b).iterator();
            for (AppBarLayout.g next : iterator) {
                next.a(obj4, this.a.A());
            }
        }
    }

    public interface c {
        public abstract void a(T t, int i2);
    }

    public static abstract class d {
        public abstract void a(com.google.android.material.appbar.AppBarLayout appBarLayout, View view2, float f3);
    }

    public static class f extends LinearLayout.LayoutParams {

        int a = 1;
        private com.google.android.material.appbar.AppBarLayout.d b;
        Interpolator c;
        public f(int i, int i2) {
            super(i, i2);
            final int obj1 = 1;
        }

        public f(Context context, AttributeSet attributeSet2) {
            int resourceId;
            Object obj4;
            super(context, attributeSet2);
            int i = 1;
            final TypedArray obj5 = context.obtainStyledAttributes(attributeSet2, l.j);
            final int i4 = 0;
            this.a = obj5.getInt(l.l, i4);
            f(a(obj5.getInt(l.k, i4)));
            resourceId = l.m;
            if (obj5.hasValue(resourceId)) {
                this.c = AnimationUtils.loadInterpolator(context, obj5.getResourceId(resourceId, i4));
            }
            obj5.recycle();
        }

        public f(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
            final int obj1 = 1;
        }

        public f(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(marginLayoutParams);
            final int obj1 = 1;
        }

        public f(LinearLayout.LayoutParams linearLayout$LayoutParams) {
            super(layoutParams);
            final int obj1 = 1;
        }

        private com.google.android.material.appbar.AppBarLayout.d a(int i) {
            if (i != 1) {
                return null;
            }
            AppBarLayout.e obj2 = new AppBarLayout.e();
            return obj2;
        }

        @Override // android.widget.LinearLayout$LayoutParams
        public com.google.android.material.appbar.AppBarLayout.d b() {
            return this.b;
        }

        @Override // android.widget.LinearLayout$LayoutParams
        public int c() {
            return this.a;
        }

        @Override // android.widget.LinearLayout$LayoutParams
        public Interpolator d() {
            return this.c;
        }

        @Override // android.widget.LinearLayout$LayoutParams
        boolean e() {
            int i;
            int i2;
            i = this.a;
            if (i & 1 == 1 && i &= 10 != 0) {
                if (i &= 10 != 0) {
                } else {
                    i2 = 0;
                }
            } else {
            }
            return i2;
        }

        @Override // android.widget.LinearLayout$LayoutParams
        public void f(com.google.android.material.appbar.AppBarLayout.d appBarLayout$d) {
            this.b = d;
        }
    }

    public interface g {
        public abstract void a(float f, int i2);
    }

    class a implements q {

        final com.google.android.material.appbar.AppBarLayout a;
        a(com.google.android.material.appbar.AppBarLayout appBarLayout) {
            this.a = appBarLayout;
            super();
        }

        @Override // d.h.l.q
        public d0 a(View view, d0 d02) {
            this.a.n(d02);
            return d02;
        }
    }

    public static class e extends com.google.android.material.appbar.AppBarLayout.d {

        private final Rect a;
        private final Rect b;
        public e() {
            super();
            Rect rect = new Rect();
            this.a = rect;
            Rect rect2 = new Rect();
            this.b = rect2;
        }

        private static void b(Rect rect, com.google.android.material.appbar.AppBarLayout appBarLayout2, View view3) {
            view3.getDrawingRect(rect);
            appBarLayout2.offsetDescendantRectToMyCoords(view3, rect);
            rect.offset(0, -obj1);
        }

        @Override // com.google.android.material.appbar.AppBarLayout$d
        public void a(com.google.android.material.appbar.AppBarLayout appBarLayout, View view2, float f3) {
            int cmp;
            int i;
            Rect obj3;
            Rect obj5;
            AppBarLayout.e.b(this.a, appBarLayout, view2);
            obj3 -= obj5;
            obj5 = 0;
            if (Float.compare(obj3, obj5) <= 0) {
                int i4 = 1065353216;
                obj5 = i4 - obj5;
                obj3 -= obj5;
                view2.setTranslationY(obj3);
                view2.getDrawingRect(this.b);
                this.b.offset(0, (int)obj3);
                u.r0(view2, this.b);
            } else {
                u.r0(view2, 0);
                view2.setTranslationY(obj5);
            }
        }
    }

    protected static class BaseBehavior extends com.google.android.material.appbar.a<T> {

        private int h;
        private int i;
        private ValueAnimator j;
        private com.google.android.material.appbar.AppBarLayout.BaseBehavior.e k;
        private WeakReference<View> l;
        private com.google.android.material.appbar.AppBarLayout.BaseBehavior.d m;
        public BaseBehavior(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
        }

        private boolean I(CoordinatorLayout coordinatorLayout, T t2) {
            int i;
            int i2;
            CoordinatorLayout.c cVar;
            boolean z;
            List obj5 = coordinatorLayout.getDependents(t2);
            i = 0;
            i2 = i;
            while (i2 < obj5.size()) {
                cVar = (CoordinatorLayout.f)(View)obj5.get(i2).getLayoutParams().f();
                i2++;
            }
            return i;
        }

        private void J(CoordinatorLayout coordinatorLayout, T t2) {
            int i4;
            int i5;
            View childAt;
            boolean bottomMargin;
            ViewGroup.LayoutParams layoutParams;
            int i;
            int i2;
            int i3;
            int paddingTop;
            boolean z;
            i4 = f();
            i5 = u(t2, i4);
            childAt = t2.getChildAt(i5);
            layoutParams = childAt.getLayoutParams();
            i = (AppBarLayout.f)layoutParams.c();
            i2 = -top;
            if (i5 >= 0 && i & 17 == 17 && i5 == childCount--) {
                childAt = t2.getChildAt(i5);
                layoutParams = childAt.getLayoutParams();
                i = (AppBarLayout.f)layoutParams.c();
                if (i & 17 == 17) {
                    i2 = -top;
                    if (i5 == childCount--) {
                        i3 += i5;
                    }
                    int i7 = 2;
                    if (AppBarLayout.BaseBehavior.r(i, i7)) {
                        i3 += childAt;
                    } else {
                        if (AppBarLayout.BaseBehavior.r(i, 5)) {
                            i9 += i3;
                            if (i4 < childAt) {
                                i2 = childAt;
                            } else {
                                i3 = childAt;
                            }
                        }
                    }
                    if (AppBarLayout.BaseBehavior.r(i, 32)) {
                        i2 += topMargin;
                        i3 -= bottomMargin;
                    }
                    if (i4 < i11 /= i7) {
                        i2 = i3;
                    }
                    n(coordinatorLayout, t2, a.b(i2, -totalScrollRange, 0), 0);
                }
            }
        }

        private void K(CoordinatorLayout coordinatorLayout, T t2) {
            boolean totalScrollRange;
            u.f0(coordinatorLayout, c.a.f.b());
            u.f0(coordinatorLayout, c.a.g.b());
            View view = s(coordinatorLayout);
            if (view != null) {
                if (t2.getTotalScrollRange() == 0) {
                } else {
                    if (!cVar instanceof AppBarLayout.ScrollingViewBehavior) {
                    }
                    l(coordinatorLayout, t2, view);
                }
            }
        }

        private void L(CoordinatorLayout coordinatorLayout, T t2, int i3, int i4, boolean z5) {
            View topInset;
            int i;
            int i6;
            int i2;
            int i5;
            CoordinatorLayout obj6;
            int obj8;
            int obj9;
            topInset = AppBarLayout.BaseBehavior.t(t2, i3);
            i = 0;
            i6 = (AppBarLayout.f)topInset.getLayoutParams().c();
            if (topInset != null && i6 & 1 != 0) {
                i6 = (AppBarLayout.f)topInset.getLayoutParams().c();
                if (i6 & 1 != 0) {
                    i2 = u.C(topInset);
                    if (i4 > 0 && i6 & 12 != 0) {
                        if (i6 & 12 != 0) {
                            if (-i3 >= obj9 -= topInset) {
                                i = i5;
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
            if (t2.l()) {
                i = t2.v(s(coordinatorLayout));
            }
            if (!z5) {
                if (t2.s(i) && I(coordinatorLayout, t2)) {
                    if (I(coordinatorLayout, t2)) {
                        t2.jumpDrawablesToCurrentState();
                    }
                }
            } else {
            }
        }

        static int k(com.google.android.material.appbar.AppBarLayout.BaseBehavior appBarLayout$BaseBehavior) {
            return baseBehavior.h;
        }

        private void l(CoordinatorLayout coordinatorLayout, T t2, View view3) {
            int scrollVertically;
            int downNestedPreScrollRange;
            int i2;
            int i;
            CoordinatorLayout coordinatorLayout2;
            com.google.android.material.appbar.AppBarLayout appBarLayout;
            View view;
            int i3;
            int i4;
            com.google.android.material.appbar.AppBarLayout.BaseBehavior.b bVar;
            c.a obj12;
            i = 1;
            if (f() != -totalScrollRange && view3.canScrollVertically(i)) {
                if (view3.canScrollVertically(i)) {
                    m(coordinatorLayout, t2, c.a.f, false);
                }
            }
            if (f() != 0) {
                if (view3.canScrollVertically(-1)) {
                    i3 = -downNestedPreScrollRange;
                    if (i3 != 0) {
                        super(this, coordinatorLayout, t2, view3, i3);
                        u.h0(coordinatorLayout, c.a.g, 0, bVar);
                    }
                } else {
                    m(coordinatorLayout, t2, c.a.g, i);
                }
            }
        }

        private void m(CoordinatorLayout coordinatorLayout, T t2, c.a c$a3, boolean z4) {
            AppBarLayout.BaseBehavior.c cVar = new AppBarLayout.BaseBehavior.c(this, t2, z4);
            u.h0(coordinatorLayout, a3, 0, cVar);
        }

        private void n(CoordinatorLayout coordinatorLayout, T t2, int i3, float f4) {
            int i;
            int cmp;
            int obj6;
            int i5 = Math.abs(i2 -= i3);
            obj6 = Math.abs(f4);
            if (Float.compare(obj6, i8) > 0) {
                obj6 *= 3;
            } else {
                obj6 = (int)obj6;
            }
            o(coordinatorLayout, t2, i3, obj6);
        }

        private void o(CoordinatorLayout coordinatorLayout, T t2, int i3, int i4) {
            ValueAnimator valueAnimator;
            com.google.android.material.appbar.AppBarLayout.BaseBehavior.a aVar;
            ValueAnimator obj4;
            final int i = f();
            obj4 = this.j;
            if (i == i3 && obj4 != null && obj4.isRunning()) {
                obj4 = this.j;
                if (obj4 != null) {
                    if (obj4.isRunning()) {
                        this.j.cancel();
                    }
                }
            }
            valueAnimator = this.j;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.j = valueAnimator2;
                valueAnimator2.setInterpolator(a.e);
                aVar = new AppBarLayout.BaseBehavior.a(this, coordinatorLayout, t2);
                this.j.addUpdateListener(aVar);
            } else {
                valueAnimator.cancel();
            }
            this.j.setDuration((long)obj5);
            int[] obj5 = new int[2];
            this.j.setIntValues(i, i3);
            this.j.start();
        }

        private boolean q(CoordinatorLayout coordinatorLayout, T t2, View view3) {
            int obj2;
            int obj3;
            int obj4;
            if (t2.j() && obj2 -= obj4 <= t2.getHeight()) {
                obj2 = obj2 -= obj4 <= t2.getHeight() ? 1 : 0;
            } else {
            }
            return obj2;
        }

        private static boolean r(int i, int i2) {
            int obj0;
            obj0 = i &= i2 == i2 ? 1 : 0;
            return obj0;
        }

        private View s(CoordinatorLayout coordinatorLayout) {
            int i;
            View childAt;
            boolean z;
            i = 0;
            while (i < coordinatorLayout.getChildCount()) {
                childAt = coordinatorLayout.getChildAt(i);
                i++;
            }
            return null;
        }

        private static View t(com.google.android.material.appbar.AppBarLayout appBarLayout, int i2) {
            int i;
            View childAt;
            int bottom;
            final int obj5 = Math.abs(i2);
            i = 0;
            while (i < appBarLayout.getChildCount()) {
                childAt = appBarLayout.getChildAt(i);
                i++;
            }
            return null;
        }

        private int u(T t, int i2) {
            int i3;
            int i4;
            ViewGroup.LayoutParams layoutParams;
            int top;
            int bottom;
            boolean topMargin;
            int i;
            i3 = 0;
            while (i3 < t.getChildCount()) {
                View childAt = t.getChildAt(i3);
                layoutParams = childAt.getLayoutParams();
                if (AppBarLayout.BaseBehavior.r((AppBarLayout.f)layoutParams.c(), 32)) {
                }
                i4 = -i2;
                i3++;
                top -= topMargin;
                bottom += layoutParams;
            }
            return -1;
        }

        private int x(T t, int i2) {
            int i3;
            int childCount;
            int i4;
            int i;
            View childAt;
            ViewGroup.LayoutParams layoutParams;
            Interpolator interpolator;
            int topMargin;
            int obj9;
            int i5 = Math.abs(i2);
            i4 = 0;
            i = i4;
            while (i < t.getChildCount()) {
                childAt = t.getChildAt(i);
                layoutParams = childAt.getLayoutParams();
                interpolator = (AppBarLayout.f)layoutParams.d();
                i++;
            }
            return i2;
        }

        public boolean A(CoordinatorLayout coordinatorLayout, T t2, int i3, int i4, int i5, int i6) {
            if (layoutParams.height == -2) {
                final int obj11 = 0;
                coordinatorLayout.onMeasureChild(t2, i3, i4, View.MeasureSpec.makeMeasureSpec(obj11, obj11), i6);
                return 1;
            }
            return super.onMeasureChild(coordinatorLayout, t2, i3, i4, i5, i6);
        }

        public void B(CoordinatorLayout coordinatorLayout, T t2, View view3, int i4, int i5, int[] i6Arr6, int i7) {
            Object obj;
            CoordinatorLayout coordinatorLayout2;
            View view;
            int i2;
            int i;
            int i3;
            int obj7;
            int obj10;
            int obj13;
            if (i5 != 0) {
                if (i5 < 0) {
                    obj13 += obj10;
                } else {
                    obj10 = -obj10;
                    obj13 = 0;
                }
                i = obj10;
                i3 = obj13;
                if (i != i3) {
                    i6Arr6[1] = this.h(coordinatorLayout, t2, i5, i, i3);
                }
            }
            if (t2.l()) {
                t2.s(t2.v(view3));
            }
        }

        public void C(CoordinatorLayout coordinatorLayout, T t2, View view3, int i4, int i5, int i6, int i7, int i8, int[] i9Arr9) {
            Object obj;
            CoordinatorLayout coordinatorLayout2;
            View view;
            int i3;
            int i;
            int i2;
            int obj9;
            int obj10;
            if (i7 < 0) {
                i9Arr9[1] = this.h(coordinatorLayout, t2, i7, -obj10, 0);
            }
            if (i7 == 0) {
                K(coordinatorLayout, t2);
            }
        }

        public void D(CoordinatorLayout coordinatorLayout, T t2, Parcelable parcelable3) {
            CoordinatorLayout obj2;
            Object obj4;
            if (parcelable3 instanceof AppBarLayout.BaseBehavior.e) {
                this.k = (AppBarLayout.BaseBehavior.e)parcelable3;
                super.onRestoreInstanceState(coordinatorLayout, t2, parcelable3.a());
            } else {
                super.onRestoreInstanceState(coordinatorLayout, t2, parcelable3);
                this.k = 0;
            }
        }

        public Parcelable E(CoordinatorLayout coordinatorLayout, T t2) {
            int i3;
            int i4;
            View childAt;
            int i2;
            int i;
            int obj8;
            obj8 = super.onSaveInstanceState(coordinatorLayout, t2);
            int topAndBottomOffset = getTopAndBottomOffset();
            i3 = 0;
            i4 = i3;
            while (i4 < t2.getChildCount()) {
                childAt = t2.getChildAt(i4);
                bottom += topAndBottomOffset;
                i4++;
            }
            return obj8;
        }

        public boolean F(CoordinatorLayout coordinatorLayout, T t2, View view3, View view4, int i5, int i6) {
            int obj1;
            Object obj2;
            boolean obj4;
            if (i5 & 2 != 0) {
                if (!t2.l()) {
                    obj1 = q(coordinatorLayout, t2, view3) ? 1 : 0;
                } else {
                }
            } else {
            }
            obj2 = this.j;
            if (obj1 != null && obj2 != null) {
                obj2 = this.j;
                if (obj2 != null) {
                    obj2.cancel();
                }
            }
            this.l = 0;
            this.i = i6;
            return obj1;
        }

        public void G(CoordinatorLayout coordinatorLayout, T t2, View view3, int i4) {
            int i;
            CoordinatorLayout obj2;
            if (this.i != 0) {
                J(coordinatorLayout, t2);
                if (i4 == 1 && t2.l()) {
                    J(coordinatorLayout, t2);
                    if (t2.l()) {
                        t2.s(t2.v(view3));
                    }
                }
            } else {
            }
            obj2 = new WeakReference(view3);
            this.l = obj2;
        }

        int H(CoordinatorLayout coordinatorLayout, T t2, int i3, int i4, int i5) {
            int i6;
            Object layoutParams;
            CoordinatorLayout coordinatorLayout2;
            com.google.android.material.appbar.AppBarLayout appBarLayout;
            int i7;
            int i;
            int i2;
            int obj11;
            int obj12;
            int obj13;
            final int i8 = f();
            if (i4 != 0 && i8 >= i4 && i8 <= i5) {
                if (i8 >= i4) {
                    if (i8 <= i5) {
                        i7 = a.b(i3, i4, i5);
                        if (i8 != i7) {
                            if (t2.h()) {
                                obj11 = x(t2, i7);
                            } else {
                                obj11 = i7;
                            }
                            obj12 = setTopAndBottomOffset(obj11);
                            this.h = i7 - obj11;
                            if (obj12 != null) {
                            }
                            if (obj12 == null && t2.h()) {
                                if (t2.h()) {
                                    coordinatorLayout.dispatchDependentViewsChanged(t2);
                                }
                            }
                            t2.m(getTopAndBottomOffset());
                            if (i7 < i8) {
                                obj11 = -1;
                            }
                            this.L(coordinatorLayout, t2, i7, obj11, false);
                            i6 = obj13;
                        }
                    } else {
                        this.h = 0;
                    }
                } else {
                }
            } else {
            }
            K(coordinatorLayout, t2);
            return i6;
        }

        @Override // com.google.android.material.appbar.a
        boolean a(View view) {
            return p((AppBarLayout)view);
        }

        @Override // com.google.android.material.appbar.a
        int d(View view) {
            return v((AppBarLayout)view);
        }

        @Override // com.google.android.material.appbar.a
        int e(View view) {
            return w((AppBarLayout)view);
        }

        @Override // com.google.android.material.appbar.a
        int f() {
            return topAndBottomOffset += i2;
        }

        @Override // com.google.android.material.appbar.a
        void g(CoordinatorLayout coordinatorLayout, View view2) {
            y(coordinatorLayout, (AppBarLayout)view2);
        }

        @Override // com.google.android.material.appbar.a
        int j(CoordinatorLayout coordinatorLayout, View view2, int i3, int i4, int i5) {
            return H(coordinatorLayout, (AppBarLayout)view2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.a
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view2, int i3) {
            return z(coordinatorLayout, (AppBarLayout)view2, i3);
        }

        @Override // com.google.android.material.appbar.a
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view2, int i3, int i4, int i5, int i6) {
            return A(coordinatorLayout, (AppBarLayout)view2, i3, i4, i5, i6);
        }

        @Override // com.google.android.material.appbar.a
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view2, View view3, int i4, int i5, int[] i6Arr6, int i7) {
            B(coordinatorLayout, (AppBarLayout)view2, view3, i4, i5, i6Arr6, i7);
        }

        @Override // com.google.android.material.appbar.a
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view2, View view3, int i4, int i5, int i6, int i7, int i8, int[] i9Arr9) {
            C(coordinatorLayout, (AppBarLayout)view2, view3, i4, i5, i6, i7, i8, i9Arr9);
        }

        @Override // com.google.android.material.appbar.a
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view2, Parcelable parcelable3) {
            D(coordinatorLayout, (AppBarLayout)view2, parcelable3);
        }

        @Override // com.google.android.material.appbar.a
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view2) {
            return E(coordinatorLayout, (AppBarLayout)view2);
        }

        @Override // com.google.android.material.appbar.a
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view2, View view3, View view4, int i5, int i6) {
            return F(coordinatorLayout, (AppBarLayout)view2, view3, view4, i5, i6);
        }

        @Override // com.google.android.material.appbar.a
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view2, View view3, int i4) {
            G(coordinatorLayout, (AppBarLayout)view2, view3, i4);
        }

        boolean p(T t) {
            int i;
            boolean shown;
            Object obj3;
            com.google.android.material.appbar.AppBarLayout.BaseBehavior.d dVar = this.m;
            if (dVar != null) {
                return dVar.a(t);
            }
            obj3 = this.l;
            i = 1;
            if (obj3 != null) {
                obj3 = obj3.get();
                if (obj3 != null && (View)obj3.isShown() && !obj3.canScrollVertically(-1)) {
                    if (obj3.isShown()) {
                        if (!obj3.canScrollVertically(-1)) {
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }

        int v(T t) {
            return -obj1;
        }

        int w(T t) {
            return t.getTotalScrollRange();
        }

        void y(CoordinatorLayout coordinatorLayout, T t2) {
            CoordinatorLayout obj2;
            J(coordinatorLayout, t2);
            if (t2.l()) {
                t2.s(t2.v(s(coordinatorLayout)));
            }
        }

        public boolean z(CoordinatorLayout coordinatorLayout, T t2, int i3) {
            int pendingAction;
            com.google.android.material.appbar.AppBarLayout.BaseBehavior.e eVar;
            int topInset;
            int i2;
            int i;
            pendingAction = t2.getPendingAction();
            eVar = this.k;
            int i12 = 0;
            if (eVar != null && pendingAction & 8 == 0) {
                if (pendingAction & 8 == 0) {
                    if (eVar.c) {
                        i(coordinatorLayout, t2, -totalScrollRange);
                    } else {
                        View childAt = t2.getChildAt(eVar.v);
                        if (eVar2.x) {
                            i8 += topInset;
                        } else {
                            pendingAction = Math.round(f *= topInset);
                        }
                        i(coordinatorLayout, t2, i10 += pendingAction);
                    }
                } else {
                    if (pendingAction != 0) {
                        topInset = 1;
                        eVar = pendingAction & 4 != 0 ? topInset : i12;
                        i = 0;
                        if (pendingAction & 2 != 0) {
                            pendingAction = -upNestedPreScrollRange;
                            if (eVar != 0) {
                                n(coordinatorLayout, t2, pendingAction, i);
                            } else {
                                i(coordinatorLayout, t2, pendingAction);
                            }
                        } else {
                            if (pendingAction &= topInset != null) {
                                if (eVar != 0) {
                                    n(coordinatorLayout, t2, i12, i);
                                } else {
                                    i(coordinatorLayout, t2, i12);
                                }
                            }
                        }
                    }
                }
            } else {
            }
            t2.o();
            this.k = 0;
            setTopAndBottomOffset(a.b(getTopAndBottomOffset(), -totalScrollRange2, i12));
            this.L(coordinatorLayout, t2, getTopAndBottomOffset(), 0, true);
            t2.m(getTopAndBottomOffset());
            K(coordinatorLayout, t2);
            return super.onLayoutChild(coordinatorLayout, t2, i3);
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, l.W3);
            setOverlayTop(obj2.getDimensionPixelSize(l.X3, 0));
            obj2.recycle();
        }

        private static int getAppBarLayoutOffset(com.google.android.material.appbar.AppBarLayout appBarLayout) {
            CoordinatorLayout.c obj1 = (CoordinatorLayout.f)appBarLayout.getLayoutParams().f();
            if (obj1 instanceof AppBarLayout.BaseBehavior) {
                return (AppBarLayout.BaseBehavior)obj1.f();
            }
            return 0;
        }

        private void offsetChildAsNeeded(View view, View view2) {
            CoordinatorLayout.c verticalLayoutGap;
            boolean z;
            int top;
            View obj5;
            verticalLayoutGap = (CoordinatorLayout.f)view2.getLayoutParams().f();
            if (verticalLayoutGap instanceof AppBarLayout.BaseBehavior) {
                u.X(view, i4 -= obj5);
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            boolean z;
            View obj2;
            if (view2 instanceof AppBarLayout && (AppBarLayout)view2.l()) {
                if ((AppBarLayout)view2.l()) {
                    view2.s(view2.v(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.b
        View findFirstDependency(List list) {
            return findFirstDependency(list);
        }

        com.google.android.material.appbar.AppBarLayout findFirstDependency(List<View> list) {
            int i;
            Object obj;
            boolean z;
            i = 0;
            while (i < list.size()) {
                obj = list.get(i);
                i++;
            }
            return null;
        }

        @Override // com.google.android.material.appbar.b
        public int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.b
        float getOverlapRatioForOffset(View view) {
            boolean i;
            int downNestedPreScrollRange;
            int i2;
            Object obj5;
            int i3 = 0;
            int totalScrollRange = (AppBarLayout)view.getTotalScrollRange();
            downNestedPreScrollRange = view.getDownNestedPreScrollRange();
            obj5 = AppBarLayout.ScrollingViewBehavior.getAppBarLayoutOffset(view);
            if (view instanceof AppBarLayout && downNestedPreScrollRange != 0 && totalScrollRange + obj5 <= downNestedPreScrollRange) {
                totalScrollRange = (AppBarLayout)view.getTotalScrollRange();
                downNestedPreScrollRange = view.getDownNestedPreScrollRange();
                obj5 = AppBarLayout.ScrollingViewBehavior.getAppBarLayoutOffset(view);
                if (downNestedPreScrollRange != 0) {
                    if (totalScrollRange + obj5 <= downNestedPreScrollRange) {
                        return i3;
                    }
                }
                totalScrollRange -= downNestedPreScrollRange;
                if (i != 0) {
                    return obj5 += i4;
                }
            }
            return i3;
        }

        @Override // com.google.android.material.appbar.b
        int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return (AppBarLayout)view.getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }

        @Override // com.google.android.material.appbar.b
        public int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.b
        public boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.b
        public boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.b
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            return view3 instanceof AppBarLayout;
        }

        @Override // com.google.android.material.appbar.b
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            offsetChildAsNeeded(view2, view3);
            updateLiftedStateIfNeeded(view2, view3);
            return 0;
        }

        @Override // com.google.android.material.appbar.b
        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            boolean obj2;
            if (view3 instanceof AppBarLayout) {
                u.f0(coordinatorLayout, c.a.f.b());
                u.f0(coordinatorLayout, c.a.g.b());
            }
        }

        @Override // com.google.android.material.appbar.b
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view2, int i3) {
            return super.onLayoutChild(coordinatorLayout, view2, i3);
        }

        @Override // com.google.android.material.appbar.b
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view2, int i3, int i4, int i5, int i6) {
            return super.onMeasureChild(coordinatorLayout, view2, i3, i4, i5, i6);
        }

        @Override // com.google.android.material.appbar.b
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view2, Rect rect3, boolean z4) {
            int width;
            boolean obj4;
            Object obj5;
            com.google.android.material.appbar.AppBarLayout firstDependency = findFirstDependency(coordinatorLayout.getDependencies(view2));
            final int i = 0;
            rect3.offset(view2.getLeft(), view2.getTop());
            obj5 = this.tempRect1;
            obj5.set(i, i, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
            if (firstDependency != null && !obj5.contains(rect3)) {
                rect3.offset(view2.getLeft(), view2.getTop());
                obj5 = this.tempRect1;
                obj5.set(i, i, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!obj5.contains(rect3)) {
                    firstDependency.p(i, z4 ^ 1);
                    return 1;
                }
            }
            return i;
        }

        @Override // com.google.android.material.appbar.b
        public void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        @Override // com.google.android.material.appbar.b
        public boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        @Override // com.google.android.material.appbar.b
        public boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        @Override // com.google.android.material.appbar.b
        public void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }
    }

    public static class Behavior extends com.google.android.material.appbar.AppBarLayout.BaseBehavior<com.google.android.material.appbar.AppBarLayout> {
        public Behavior(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
        }
    }
    static {
        AppBarLayout.K = k.h;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.b);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet2, int i3) {
        int outlineProvider;
        Object gVar;
        boolean value;
        ViewOutlineProvider bACKGROUND;
        boolean obj13;
        final int i2 = AppBarLayout.K;
        super(a.c(context, attributeSet2, i3, i2), attributeSet2, i3);
        int obj11 = -1;
        this.b = obj11;
        this.c = obj11;
        this.v = obj11;
        final int i4 = 0;
        this.x = i4;
        ArrayList arrayList = new ArrayList();
        this.H = arrayList;
        final Context context2 = getContext();
        setOrientation(1);
        final int sDK_INT = Build.VERSION.SDK_INT;
        final int i5 = 21;
        if (sDK_INT >= i5 && getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
                e.a(this);
            }
            e.c(this, attributeSet2, i3, i2);
        }
        final TypedArray obj12 = l.h(context2, attributeSet2, l.a, i3, i2, new int[i4]);
        u.o0(this, obj12.getDrawable(l.b));
        if (obj13 instanceof ColorDrawable) {
            gVar = new g();
            gVar.Z(ColorStateList.valueOf((ColorDrawable)getBackground().getColor()));
            gVar.O(context2);
            u.o0(this, gVar);
        }
        obj13 = l.f;
        if (obj12.hasValue(obj13)) {
            q(obj12.getBoolean(obj13, i4), i4, i4);
        }
        obj13 = l.e;
        if (sDK_INT >= i5 && obj12.hasValue(obj13)) {
            obj13 = l.e;
            if (obj12.hasValue(obj13)) {
                e.b(this, (float)obj13);
            }
        }
        obj13 = l.d;
        if (sDK_INT >= 26 && obj12.hasValue(obj13)) {
            obj13 = l.d;
            if (obj12.hasValue(obj13)) {
                setKeyboardNavigationCluster(obj12.getBoolean(obj13, i4));
            }
            obj13 = l.c;
            if (obj12.hasValue(obj13)) {
                setTouchscreenBlocksFocus(obj12.getBoolean(obj13, i4));
            }
        }
        this.D = obj12.getBoolean(l.g, i4);
        this.E = obj12.getResourceId(l.h, obj11);
        setStatusBarForeground(obj12.getDrawable(l.i));
        obj12.recycle();
        obj11 = new AppBarLayout.a(this);
        u.x0(this, obj11);
    }

    static Drawable a(com.google.android.material.appbar.AppBarLayout appBarLayout) {
        return appBarLayout.J;
    }

    static List b(com.google.android.material.appbar.AppBarLayout appBarLayout) {
        return appBarLayout.H;
    }

    private void c() {
        WeakReference weakReference = this.F;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.F = 0;
    }

    private View d(View view) {
        WeakReference weakReference;
        int i2;
        int i;
        View obj4;
        weakReference = this.E;
        if (this.F == null && weakReference != -1) {
            weakReference = this.E;
            if (weakReference != -1) {
                if (view != null) {
                    obj4 = view.findViewById(weakReference);
                } else {
                    obj4 = i2;
                }
                if (obj4 == null && parent instanceof ViewGroup) {
                    if (parent instanceof ViewGroup) {
                        obj4 = (ViewGroup)getParent().findViewById(this.E);
                    }
                }
                if (obj4 != null) {
                    weakReference = new WeakReference(obj4);
                    this.F = weakReference;
                }
            }
        }
        obj4 = this.F;
        if (obj4 != null) {
            i2 = obj4;
        }
        return i2;
    }

    private boolean i() {
        int i;
        boolean z;
        final int i3 = 0;
        i = i3;
        while (i < getChildCount()) {
            i++;
        }
        return i3;
    }

    private void k() {
        final int i = -1;
        this.b = i;
        this.c = i;
        this.v = i;
    }

    private void q(boolean z, boolean z2, boolean z3) {
        int i;
        int obj2;
        int obj3;
        obj2 = z ? 1 : 2;
        obj3 = z2 ? 4 : i;
        if (z3) {
            i = 8;
        }
        this.x = obj2 |= i;
        requestLayout();
    }

    private boolean r(boolean z) {
        if (this.B != z) {
            this.B = z;
            refreshDrawableState();
            return 1;
        }
        return 0;
    }

    private boolean u() {
        Drawable topInset;
        int i;
        if (this.J != null && getTopInset() > 0) {
            i = getTopInset() > 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    private boolean w() {
        int childCount;
        int i;
        int visibility;
        int i2;
        childCount = getChildAt(0);
        if (getChildCount() > 0 && childCount.getVisibility() != 8 && !u.y(childCount)) {
            childCount = getChildAt(i);
            if (childCount.getVisibility() != 8) {
                if (!u.y(childCount)) {
                    i = 1;
                }
            }
        }
        return i;
    }

    private void x(g g, boolean z2) {
        int dimension;
        float f;
        int i2 = 0;
        f = z2 ? i2 : dimension;
        if (z2) {
        } else {
            dimension = i2;
        }
        ValueAnimator obj5 = this.G;
        if (obj5 != null) {
            obj5.cancel();
        }
        obj5 = new float[2];
        obj5 = ValueAnimator.ofFloat(f, dimension);
        this.G = obj5;
        int i5 = g.a;
        obj5.setDuration((long)integer);
        this.G.setInterpolator(a.a);
        AppBarLayout.b bVar = new AppBarLayout.b(this, g);
        this.G.addUpdateListener(bVar);
        this.G.start();
    }

    private void y() {
        setWillNotDraw(z ^= 1);
    }

    @Override // android.widget.LinearLayout
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return layoutParams instanceof AppBarLayout.f;
    }

    @Override // android.widget.LinearLayout
    public void draw(Canvas canvas) {
        boolean save;
        Drawable drawable;
        float f;
        super.draw(canvas);
        if (u()) {
            canvas.translate(0, (float)i3);
            this.J.draw(canvas);
            canvas.restoreToCount(canvas.save());
        }
    }

    @Override // android.widget.LinearLayout
    protected void drawableStateChanged() {
        int[] drawableState;
        boolean stateful;
        super.drawableStateChanged();
        final Drawable drawable = this.J;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            if (drawable.isStateful()) {
                if (drawable.setState(drawableState)) {
                    invalidateDrawable(drawable);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout
    protected com.google.android.material.appbar.AppBarLayout.f e() {
        AppBarLayout.f fVar = new AppBarLayout.f(-1, -2);
        return fVar;
    }

    @Override // android.widget.LinearLayout
    public com.google.android.material.appbar.AppBarLayout.f f(AttributeSet attributeSet) {
        AppBarLayout.f fVar = new AppBarLayout.f(getContext(), attributeSet);
        return fVar;
    }

    @Override // android.widget.LinearLayout
    protected com.google.android.material.appbar.AppBarLayout.f g(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 19 && layoutParams instanceof LinearLayout.LayoutParams) {
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                AppBarLayout.f fVar3 = new AppBarLayout.f((LinearLayout.LayoutParams)layoutParams);
                return fVar3;
            }
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            AppBarLayout.f fVar2 = new AppBarLayout.f((ViewGroup.MarginLayoutParams)layoutParams);
            return fVar2;
        }
        AppBarLayout.f fVar = new AppBarLayout.f(layoutParams);
        return fVar;
    }

    @Override // android.widget.LinearLayout
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return e();
    }

    @Override // android.widget.LinearLayout
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return e();
    }

    @Override // android.widget.LinearLayout
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return f(attributeSet);
    }

    @Override // android.widget.LinearLayout
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return g(layoutParams);
    }

    @Override // android.widget.LinearLayout
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return f(attributeSet);
    }

    @Override // android.widget.LinearLayout
    protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return g(layoutParams);
    }

    public CoordinatorLayout.c<com.google.android.material.appbar.AppBarLayout> getBehavior() {
        AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
        return behavior;
    }

    @Override // android.widget.LinearLayout
    int getDownNestedPreScrollRange() {
        int i;
        int i2;
        View topInset;
        ViewGroup.LayoutParams layoutParams;
        int measuredHeight;
        int i3;
        int i5;
        int i4;
        int i6 = this.c;
        if (i6 != -1) {
            return i6;
        }
        childCount--;
        int i9 = 0;
        i2 = i9;
        while (i >= 0) {
            topInset = getChildAt(i);
            layoutParams = topInset.getLayoutParams();
            measuredHeight = topInset.getMeasuredHeight();
            i3 = layoutParams.a;
            if (i3 & 5 != 5) {
                break;
            } else {
            }
            if (i2 > 0) {
                break;
            } else {
            }
            i--;
            topMargin += bottomMargin;
            if (i3 & 8 != 0) {
            } else {
            }
            if (i3 & 2 != 0) {
            } else {
            }
            i12 += measuredHeight;
            if (i == 0 && u.y(topInset)) {
            }
            i2 += i5;
            if (u.y(topInset)) {
            }
            i5 = Math.min(i5, measuredHeight -= topInset);
            layoutParams = measuredHeight - i11;
            i12 += layoutParams;
            layoutParams = u.C(topInset);
        }
        int i7 = Math.max(i9, i2);
        this.c = i7;
        return i7;
    }

    @Override // android.widget.LinearLayout
    int getDownNestedScrollRange() {
        int childCount;
        int i;
        int i4;
        View childAt;
        int i5;
        int i3;
        int i2;
        int bottomMargin;
        int i6 = this.v;
        if (i6 != -1) {
            return i6;
        }
        int i9 = 0;
        i4 = i;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            i5 = layoutParams.a;
            if (i5 & 1 != 0) {
                break;
            }
            if (i5 &= 2 != 0) {
                break;
            } else {
            }
            i++;
        }
        int i7 = Math.max(i9, i4);
        this.v = i7;
        return i7;
    }

    @Override // android.widget.LinearLayout
    public int getLiftOnScrollTargetViewId() {
        return this.E;
    }

    @Override // android.widget.LinearLayout
    public final int getMinimumHeightForVisibleOverlappingContent() {
        int i2;
        int i;
        if (u.C(this) != 0) {
            return i5 += topInset;
        } else {
        }
        return height /= 3;
    }

    @Override // android.widget.LinearLayout
    int getPendingAction() {
        return this.x;
    }

    @Override // android.widget.LinearLayout
    public Drawable getStatusBarForeground() {
        return this.J;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0;
    }

    @Override // android.widget.LinearLayout
    final int getTopInset() {
        int i;
        d0 d0Var = this.y;
        if (d0Var != null) {
            i = d0Var.l();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // android.widget.LinearLayout
    public final int getTotalScrollRange() {
        int childCount;
        int i;
        int i2;
        View childAt;
        int layoutParams;
        int bottomMargin;
        int measuredHeight;
        int i3;
        int topMargin;
        int i4 = this.b;
        if (i4 != -1) {
            return i4;
        }
        int i7 = 0;
        i2 = i;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            layoutParams = childAt.getLayoutParams();
            i3 = layoutParams.a;
            if (i3 & 1 != 0) {
                break;
            }
            if (i == 0 && u.y(childAt)) {
            }
            if (i3 & 2 != 0) {
                break;
            } else {
            }
            i++;
            if (u.y(childAt)) {
            }
            i2 -= bottomMargin;
        }
        int i5 = Math.max(i7, i2);
        this.b = i5;
        return i5;
    }

    @Override // android.widget.LinearLayout
    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.widget.LinearLayout
    boolean h() {
        return this.w;
    }

    @Override // android.widget.LinearLayout
    boolean j() {
        int i;
        i = getTotalScrollRange() != 0 ? 1 : 0;
        return i;
    }

    @Override // android.widget.LinearLayout
    public boolean l() {
        return this.D;
    }

    @Override // android.widget.LinearLayout
    void m(int i) {
        List size;
        int i2;
        Object obj;
        this.a = i;
        if (!willNotDraw()) {
            u.c0(this);
        }
        size = this.z;
        if (size != null) {
            i2 = 0;
            while (i2 < size.size()) {
                obj = this.z.get(i2);
                if ((AppBarLayout.c)obj != null) {
                }
                i2++;
                (AppBarLayout.c)obj.a(this, i);
            }
        }
    }

    @Override // android.widget.LinearLayout
    d0 n(d0 d0) {
        int i;
        i = u.y(this) ? d0 : 0;
        if (!c.a(this.y, i)) {
            this.y = i;
            y();
            requestLayout();
        }
        return d0;
    }

    @Override // android.widget.LinearLayout
    void o() {
        this.x = 0;
    }

    @Override // android.widget.LinearLayout
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.widget.LinearLayout
    protected int[] onCreateDrawableState(int i) {
        int[] iArr;
        boolean z;
        int i4;
        int i3;
        int i5;
        int i2;
        if (this.I == null) {
            this.I = new int[4];
        }
        int[] iArr2 = this.I;
        z = this.B;
        if (z) {
        } else {
            i3 = -i3;
        }
        iArr2[0] = i3;
        if (z && this.C) {
            i5 = this.C ? b.T : -i12;
        } else {
        }
        iArr2[1] = i5;
        if (z) {
        } else {
            i2 = -i2;
        }
        iArr2[2] = i2;
        if (z && this.C) {
            i4 = this.C ? b.P : -i11;
        } else {
        }
        iArr2[3] = i4;
        return LinearLayout.mergeDrawableStates(super.onCreateDrawableState(i += length), iArr2);
    }

    @Override // android.widget.LinearLayout
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean obj1;
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        super.onLayout(z, i2, i3, i4, i5);
        obj2 = 1;
        if (u.y(this) && w()) {
            if (w()) {
                obj3 -= obj2;
                while (obj3 >= 0) {
                    u.X(getChildAt(obj3), getTopInset());
                    obj3--;
                }
            }
        }
        k();
        obj1 = 0;
        this.w = obj1;
        obj4 = obj1;
        while (obj4 < getChildCount()) {
            if ((AppBarLayout.f)getChildAt(obj4).getLayoutParams().d() != 0) {
                break;
            } else {
            }
            obj4++;
        }
        obj3 = this.J;
        if (obj3 != null) {
            obj3.setBounds(obj1, obj1, getWidth(), getTopInset());
        }
        if (!this.A && !this.D) {
            if (!this.D) {
                if (i()) {
                } else {
                    obj2 = obj1;
                }
            }
            r(obj2);
        }
    }

    @Override // android.widget.LinearLayout
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        int obj3;
        int obj4;
        super.onMeasure(i, i2);
        obj3 = View.MeasureSpec.getMode(i2);
        if (obj3 != 1073741824 && u.y(this) && w()) {
            if (u.y(this)) {
                if (w()) {
                    if (obj3 != Integer.MIN_VALUE) {
                        if (obj3 != null) {
                        } else {
                            measuredHeight += obj3;
                        }
                    } else {
                        measuredHeight = a.b(obj3 += topInset, 0, View.MeasureSpec.getSize(i2));
                    }
                    setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                }
            }
        }
        k();
    }

    @Override // android.widget.LinearLayout
    public void p(boolean z, boolean z2) {
        q(z, z2, true);
    }

    @Override // android.widget.LinearLayout
    boolean s(boolean z) {
        return t(z, z2 ^= 1);
    }

    @Override // android.widget.LinearLayout
    public void setElevation(float f) {
        super.setElevation(f);
        h.d(this, f);
    }

    @Override // android.widget.LinearLayout
    public void setExpanded(boolean z) {
        p(z, u.R(this));
    }

    @Override // android.widget.LinearLayout
    public void setLiftOnScroll(boolean z) {
        this.D = z;
    }

    @Override // android.widget.LinearLayout
    public void setLiftOnScrollTargetViewId(int i) {
        this.E = i;
        c();
    }

    @Override // android.widget.LinearLayout
    public void setLiftableOverrideEnabled(boolean z) {
        this.A = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
        } else {
            super.setOrientation(i);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        throw obj2;
    }

    @Override // android.widget.LinearLayout
    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawableState;
        int mutate;
        Drawable obj3;
        drawableState = this.J;
        if (drawableState != drawable && drawableState != null) {
            if (drawableState != null) {
                drawableState.setCallback(0);
            }
            if (drawable != null) {
                mutate = drawable.mutate();
            }
            this.J = mutate;
            if (mutate != 0 && mutate.isStateful()) {
                if (mutate.isStateful()) {
                    this.J.setState(getDrawableState());
                }
                a.m(this.J, u.B(this));
                mutate = 0;
                drawableState = getVisibility() == 0 ? 1 : mutate;
                this.J.setVisible(drawableState, mutate);
                this.J.setCallback(this);
            }
            y();
            u.c0(this);
        }
    }

    @Override // android.widget.LinearLayout
    public void setStatusBarForegroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        setStatusBarForeground(colorDrawable);
    }

    @Override // android.widget.LinearLayout
    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(a.d(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.b(this, f);
        }
    }

    @Override // android.widget.LinearLayout
    public void setVisibility(int i) {
        int obj3;
        super.setVisibility(i);
        final int i2 = 0;
        obj3 = i == 0 ? 1 : i2;
        final Drawable drawable = this.J;
        if (drawable != null) {
            drawable.setVisible(obj3, i2);
        }
    }

    @Override // android.widget.LinearLayout
    boolean t(boolean z, boolean z2) {
        boolean obj2;
        this.C = z;
        refreshDrawableState();
        if (z2 && this.C != z && this.D && obj2 instanceof g) {
            if (this.C != z) {
                this.C = z;
                refreshDrawableState();
                if (this.D) {
                    if (obj2 instanceof g) {
                        x((g)getBackground(), z);
                    }
                }
                return 1;
            }
        }
        return 0;
    }

    @Override // android.widget.LinearLayout
    boolean v(View view) {
        View scrollVertically;
        View obj2;
        scrollVertically = d(view);
        if (scrollVertically == null) {
        } else {
            obj2 = scrollVertically;
        }
        if (obj2 != null) {
            if (!obj2.canScrollVertically(-1)) {
                obj2 = obj2.getScrollY() > 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // android.widget.LinearLayout
    protected boolean verifyDrawable(Drawable drawable) {
        Drawable verifyDrawable;
        int obj2;
        if (!super.verifyDrawable(drawable)) {
            if (drawable == this.J) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }
}
