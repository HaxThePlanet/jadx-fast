package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import f.c.a.e.m.a;

/* loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View>  extends CoordinatorLayout.c<V> {

    private int a = 0;
    private int b = 2;
    private int c = 0;
    private ViewPropertyAnimator d;

    class a extends AnimatorListenerAdapter {

        final com.google.android.material.behavior.HideBottomViewOnScrollBehavior a;
        a(com.google.android.material.behavior.HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
            this.a = hideBottomViewOnScrollBehavior;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.a(this.a, 0);
        }
    }
    public HideBottomViewOnScrollBehavior() {
        super();
        final int i = 0;
        final int i2 = 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        final int obj1 = 0;
        final int obj2 = 2;
    }

    static ViewPropertyAnimator a(com.google.android.material.behavior.HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, ViewPropertyAnimator viewPropertyAnimator2) {
        hideBottomViewOnScrollBehavior.d = viewPropertyAnimator2;
        return viewPropertyAnimator2;
    }

    private void b(V v, int i2, long l3, TimeInterpolator timeInterpolator4) {
        HideBottomViewOnScrollBehavior.a obj2 = new HideBottomViewOnScrollBehavior.a(this);
        this.d = v.animate().translationY((float)i2).setInterpolator(obj5).setDuration(l3).setListener(obj2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean c() {
        int i;
        if (this.b == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean d() {
        int i;
        i = this.b == 2 ? 1 : 0;
        return i;
    }

    public void e(V v, int i2) {
        int i;
        int obj4;
        this.c = i2;
        if (this.b == 1) {
            v.setTranslationY((float)i);
        }
    }

    public void f(V v) {
        g(v, true);
    }

    public void g(V v, boolean z2) {
        Object obj;
        View view;
        int i;
        TimeInterpolator time;
        float obj10;
        if (c()) {
        }
        ViewPropertyAnimator view2 = this.d;
        if (view2 != null) {
            view2.cancel();
            v.clearAnimation();
        }
        this.b = 1;
        final int i5 = i3 + i4;
        if (z2 != 0) {
            this.b(v, i5, 175, obj6);
        } else {
            v.setTranslationY((float)i5);
        }
    }

    public void h(V v) {
        i(v, true);
    }

    public void i(V v, boolean z2) {
        Object obj;
        View view;
        int i;
        int i2;
        TimeInterpolator time;
        float obj9;
        if (d()) {
        }
        ViewPropertyAnimator view2 = this.d;
        if (view2 != null) {
            view2.cancel();
            v.clearAnimation();
        }
        this.b = 2;
        if (z2 != 0) {
            this.b(v, 0, 225, obj5);
        } else {
            v.setTranslationY((float)i4);
        }
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i3) {
        this.a = measuredHeight += bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v2, i3);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view3, int i4, int i5, int i6, int i7, int i8, int[] i9Arr9) {
        if (i5 > 0) {
            f(v2);
        } else {
            if (i5 < 0) {
                h(v2);
            }
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view3, View view4, int i5, int i6) {
        int obj1;
        obj1 = i5 == 2 ? 1 : 0;
        return obj1;
    }
}
