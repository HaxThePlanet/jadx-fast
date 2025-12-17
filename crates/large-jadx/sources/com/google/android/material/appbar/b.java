package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d.h.h.a;
import d.h.l.d0;
import d.h.l.e;
import d.h.l.u;
import java.util.List;

/* loaded from: classes2.dex */
abstract class b extends com.google.android.material.appbar.c<View> {

    private int overlayTop;
    final Rect tempRect1;
    final Rect tempRect2;
    private int verticalLayoutGap = 0;
    public b() {
        super();
        Rect rect = new Rect();
        this.tempRect1 = rect;
        Rect rect2 = new Rect();
        this.tempRect2 = rect2;
        int i = 0;
    }

    public b(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        Rect obj1 = new Rect();
        this.tempRect1 = obj1;
        obj1 = new Rect();
        this.tempRect2 = obj1;
        obj1 = 0;
    }

    private static int resolveGravity(int i) {
        int obj0;
        if (i == 0) {
            obj0 = 8388659;
        }
        return obj0;
    }

    abstract View findFirstDependency(List<View> list);

    @Override // com.google.android.material.appbar.c
    final int getOverlapPixelsForOffset(View view) {
        int overlayTop;
        int i;
        float f;
        View obj4;
        if (this.overlayTop == 0) {
        } else {
            overlayTop = this.overlayTop;
            i = a.b((int)obj4, 0, overlayTop);
        }
        return i;
    }

    @Override // com.google.android.material.appbar.c
    abstract float getOverlapRatioForOffset(View view);

    @Override // com.google.android.material.appbar.c
    public final int getOverlayTop() {
        return this.overlayTop;
    }

    @Override // com.google.android.material.appbar.c
    int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    @Override // com.google.android.material.appbar.c
    final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    @Override // com.google.android.material.appbar.c
    protected void layoutChild(CoordinatorLayout coordinatorLayout, View view2, int i3) {
        int left;
        int i4;
        d0 lastWindowInsets;
        int right;
        int i;
        int i5;
        Rect tempRect1;
        Rect rect;
        int i2;
        int obj9;
        View obj10;
        int obj11;
        View firstDependency = findFirstDependency(coordinatorLayout.getDependencies(view2));
        if (firstDependency != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            tempRect1 = this.tempRect1;
            tempRect1.set(paddingLeft += leftMargin, bottom += topMargin, i8 -= rightMargin, i11 -= bottomMargin);
            lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && u.y(coordinatorLayout) && !u.y(view2)) {
                if (u.y(coordinatorLayout)) {
                    if (!u.y(view2)) {
                        tempRect1.left = obj9 += i;
                        tempRect1.right = obj9 -= lastWindowInsets;
                    }
                }
            }
            obj9 = this.tempRect2;
            e.a(b.resolveGravity(layoutParams.c), view2.getMeasuredWidth(), view2.getMeasuredHeight(), tempRect1, obj9, i3);
            obj11 = getOverlapPixelsForOffset(firstDependency);
            view2.layout(obj9.left, top -= obj11, obj9.right, bottom2 -= obj11);
            this.verticalLayoutGap = obj9 -= obj10;
        } else {
            super.layoutChild(coordinatorLayout, view2, i3);
            this.verticalLayoutGap = 0;
        }
    }

    @Override // com.google.android.material.appbar.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view2, int i3, int i4, int i5, int i6) {
        int i;
        int firstDependency;
        float measuredHeight;
        boolean lastWindowInsets;
        int i2;
        int obj12;
        int height = layoutParams.height;
        int i7 = -1;
        if (height != i7) {
            firstDependency = findFirstDependency(coordinatorLayout.getDependencies(view2));
            if (height == -2 && firstDependency != null) {
                firstDependency = findFirstDependency(coordinatorLayout.getDependencies(view2));
                if (firstDependency != null) {
                    obj12 = View.MeasureSpec.getSize(i5);
                    if (obj12 > 0) {
                        lastWindowInsets = coordinatorLayout.getLastWindowInsets();
                        if (u.y(firstDependency) && lastWindowInsets != null) {
                            lastWindowInsets = coordinatorLayout.getLastWindowInsets();
                            if (lastWindowInsets != null) {
                                obj12 += i2;
                            }
                        }
                    } else {
                        obj12 = coordinatorLayout.getHeight();
                    }
                    measuredHeight = firstDependency.getMeasuredHeight();
                    if (shouldHeaderOverlapScrollingChild()) {
                        view2.setTranslationY((float)i8);
                    } else {
                        obj12 -= measuredHeight;
                    }
                    i = height == i7 ? 1073741824 : -2147483648;
                    coordinatorLayout.onMeasureChild(view2, i3, i4, View.MeasureSpec.makeMeasureSpec(obj12, i), i6);
                    return 1;
                }
            }
        } else {
        }
        return 0;
    }

    @Override // com.google.android.material.appbar.c
    public final void setOverlayTop(int i) {
        this.overlayTop = i;
    }

    @Override // com.google.android.material.appbar.c
    protected boolean shouldHeaderOverlapScrollingChild() {
        return 0;
    }
}
