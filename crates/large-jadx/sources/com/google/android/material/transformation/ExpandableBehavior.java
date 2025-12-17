package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import d.h.l.u;
import f.c.a.e.v.a;
import java.util.List;

/* loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    private int a = 0;

    class a implements ViewTreeObserver.OnPreDrawListener {

        final View a;
        final int b;
        final a c;
        final com.google.android.material.transformation.ExpandableBehavior v;
        a(com.google.android.material.transformation.ExpandableBehavior expandableBehavior, View view2, int i3, a a4) {
            this.v = expandableBehavior;
            this.a = view2;
            this.b = i3;
            this.c = a4;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnPreDrawListener
        public boolean onPreDraw() {
            int i;
            int i2;
            a aVar;
            View view;
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            final int i3 = 0;
            if (ExpandableBehavior.a(this.v) == this.b) {
                a aVar2 = this.c;
                this.v.d((View)aVar2, this.a, aVar2.a(), i3);
            }
            return i3;
        }
    }
    public ExpandableBehavior() {
        super();
        final int i = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        final int obj1 = 0;
    }

    static int a(com.google.android.material.transformation.ExpandableBehavior expandableBehavior) {
        return expandableBehavior.a;
    }

    private boolean b(boolean z) {
        int i;
        int i2;
        i = 0;
        final int i3 = 1;
        if (z) {
            int obj4 = this.a;
            if (obj4 != null) {
                if (obj4 == 2) {
                    i = i3;
                }
            } else {
            }
            return i;
        }
        if (this.a == i3) {
            i = i3;
        }
        return i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    protected a c(CoordinatorLayout coordinatorLayout, View view2) {
        int i;
        Object obj;
        boolean layoutDependsOn;
        final List dependencies = coordinatorLayout.getDependencies(view2);
        i = 0;
        while (i < dependencies.size()) {
            obj = dependencies.get(i);
            i++;
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    protected abstract boolean d(View view, View view2, boolean z3, boolean z4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view2, View view3) {
        int obj2;
        if (b((a)view3.a())) {
            final int i = 1;
            obj2 = view3.a() ? i : 2;
            this.a = obj2;
            return d((View)view3, view2, view3.a(), i);
        }
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view2, int i3) {
        ViewTreeObserver viewTreeObserver;
        com.google.android.material.transformation.ExpandableBehavior.a aVar;
        Object obj3;
        boolean obj5;
        obj3 = c(coordinatorLayout, view2);
        if (!u.R(view2) && obj3 != null && b(obj3.a())) {
            obj3 = c(coordinatorLayout, view2);
            if (obj3 != null) {
                if (b(obj3.a())) {
                    obj5 = obj3.a() ? 1 : 2;
                    this.a = obj5;
                    aVar = new ExpandableBehavior.a(this, view2, obj5, obj3);
                    view2.getViewTreeObserver().addOnPreDrawListener(aVar);
                }
            }
        }
        return 0;
    }
}
