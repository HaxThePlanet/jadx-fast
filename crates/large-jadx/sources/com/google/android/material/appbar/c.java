package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;

/* loaded from: classes2.dex */
class c<V extends android.view.View>  extends CoordinatorLayout.c<V> {

    private int tempLeftRightOffset = 0;
    private int tempTopBottomOffset = 0;
    private com.google.android.material.appbar.d viewOffsetHelper;
    public c() {
        super();
        final int i = 0;
    }

    public c(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        final int obj1 = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public int getLeftAndRightOffset() {
        int i;
        com.google.android.material.appbar.d viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            i = viewOffsetHelper.b();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public int getTopAndBottomOffset() {
        int i;
        com.google.android.material.appbar.d viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            i = viewOffsetHelper.c();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean isHorizontalOffsetEnabled() {
        com.google.android.material.appbar.d viewOffsetHelper;
        int i;
        viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null && viewOffsetHelper.d()) {
            i = viewOffsetHelper.d() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean isVerticalOffsetEnabled() {
        com.google.android.material.appbar.d viewOffsetHelper;
        int i;
        viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null && viewOffsetHelper.e()) {
            i = viewOffsetHelper.e() ? 1 : 0;
        } else {
        }
        return i;
    }

    protected void layoutChild(CoordinatorLayout coordinatorLayout, V v2, int i3) {
        coordinatorLayout.onLayoutChild(v2, i3);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i3) {
        com.google.android.material.appbar.d obj1;
        int obj3;
        layoutChild(coordinatorLayout, v2, i3);
        if (this.viewOffsetHelper == null) {
            obj1 = new d(v2);
            this.viewOffsetHelper = obj1;
        }
        this.viewOffsetHelper.f();
        this.viewOffsetHelper.a();
        obj1 = this.tempTopBottomOffset;
        final int obj2 = 0;
        if (obj1 != null) {
            this.viewOffsetHelper.i(obj1);
            this.tempTopBottomOffset = obj2;
        }
        obj1 = this.tempLeftRightOffset;
        if (obj1 != null) {
            this.viewOffsetHelper.h(obj1);
            this.tempLeftRightOffset = obj2;
        }
        return 1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void setHorizontalOffsetEnabled(boolean z) {
        final com.google.android.material.appbar.d viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.g(z);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean setLeftAndRightOffset(int i) {
        final com.google.android.material.appbar.d viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.h(i);
        }
        this.tempLeftRightOffset = i;
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean setTopAndBottomOffset(int i) {
        final com.google.android.material.appbar.d viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.i(i);
        }
        this.tempTopBottomOffset = i;
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void setVerticalOffsetEnabled(boolean z) {
        final com.google.android.material.appbar.d viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.j(z);
        }
    }
}
