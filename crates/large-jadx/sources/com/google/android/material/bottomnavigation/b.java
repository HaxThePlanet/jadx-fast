package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.view.menu.g;
import d.h.l.u;
import f.c.a.e.d;
import f.c.a.e.y.a;
import f.c.a.e.y.c;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class b extends c {

    private final int W;
    private final int a0;
    private final int b0;
    private final int c0;
    private boolean d0;
    private int[] e0;
    public b(Context context) {
        super(context);
        int i = -2;
        FrameLayout.LayoutParams obj2 = new FrameLayout.LayoutParams(i, i);
        obj2.gravity = 17;
        setLayoutParams(obj2);
        obj2 = getResources();
        this.W = obj2.getDimensionPixelSize(d.d);
        this.a0 = obj2.getDimensionPixelSize(d.e);
        this.b0 = obj2.getDimensionPixelSize(d.b);
        this.c0 = obj2.getDimensionPixelSize(d.c);
        this.e0 = new int[5];
    }

    @Override // f.c.a.e.y.c
    protected a g(Context context) {
        a aVar = new a(context);
        return aVar;
    }

    @Override // f.c.a.e.y.c
    public boolean m() {
        return this.d0;
    }

    @Override // f.c.a.e.y.c
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        View measuredWidth;
        int visibility;
        int i;
        int obj7;
        i5 -= i3;
        final int obj6 = 0;
        i6 = obj7;
        while (obj7 < getChildCount()) {
            measuredWidth = getChildAt(obj7);
            if (measuredWidth.getVisibility() == 8) {
            } else {
            }
            if (u.B(this) == 1) {
            } else {
            }
            measuredWidth.layout(i6, obj6, measuredWidth2 += i6, obj9);
            i6 += measuredWidth;
            obj7++;
            visibility = obj8 - i6;
            measuredWidth.layout(visibility - measuredWidth3, obj6, visibility, obj9);
        }
    }

    @Override // f.c.a.e.y.c
    protected void onMeasure(int i, int i2) {
        int i4;
        int i3;
        int measuredWidth3;
        boolean z;
        int i10;
        int i6;
        int layoutParams;
        int measuredWidth2;
        int i7;
        int i5;
        int i9;
        int measuredWidth;
        int i8;
        int obj13;
        obj13 = View.MeasureSpec.getSize(i);
        int size = getMenu().G().size();
        final int childCount = getChildCount();
        final int size2 = View.MeasureSpec.getSize(i2);
        final int i14 = 1073741824;
        final int measureSpec = View.MeasureSpec.makeMeasureSpec(size2, i14);
        final int i19 = 8;
        layoutParams = 1;
        final int i21 = 0;
        if (h(getLabelVisibilityMode(), size) && m()) {
            if (m()) {
                View childAt = getChildAt(getSelectedItemPosition());
                if (childAt.getVisibility() != i19) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.b0, Integer.MIN_VALUE), measureSpec);
                    i7 = Math.max(this.c0, childAt.getMeasuredWidth());
                }
                i6 = childAt.getVisibility() != i19 ? layoutParams : i21;
                size -= i6;
                measuredWidth3 = Math.min(obj13 - i17, Math.min(i7, this.b0));
                obj13 -= measuredWidth3;
                i5 = i12 == 0 ? layoutParams : i12;
                measuredWidth2 = Math.min(obj13 / i5, this.W);
                obj13 -= i13;
                i4 = i21;
                while (i4 < childCount) {
                    if (getChildAt(i4).getVisibility() != i19) {
                    } else {
                    }
                    this.e0[i4] = i21;
                    i4++;
                    if (i4 == getSelectedItemPosition()) {
                    } else {
                    }
                    i8 = measuredWidth2;
                    this.e0[i4] = i8;
                    if (obj13 > 0) {
                    }
                    i9 = this.e0;
                    i9[i4] = i27 += layoutParams;
                    obj13--;
                    i8 = measuredWidth3;
                }
            } else {
                i10 = size == 0 ? layoutParams : size;
                measuredWidth3 = Math.min(obj13 / i10, this.b0);
                obj13 -= i11;
                i4 = i21;
                while (i4 < childCount) {
                    if (getChildAt(i4).getVisibility() != i19) {
                    } else {
                    }
                    this.e0[i4] = i21;
                    i4++;
                    measuredWidth2 = this.e0;
                    measuredWidth2[i4] = measuredWidth3;
                    if (obj13 > 0) {
                    }
                    measuredWidth2[i4] = i24 += layoutParams;
                    obj13--;
                }
            }
        } else {
        }
        i3 = obj13;
        while (obj13 < childCount) {
            measuredWidth3 = getChildAt(obj13);
            if (measuredWidth3.getVisibility() == i19) {
            } else {
            }
            measuredWidth3.measure(View.MeasureSpec.makeMeasureSpec(this.e0[obj13], i14), measureSpec);
            layoutParams.width = measuredWidth3.getMeasuredWidth();
            i3 += measuredWidth3;
            obj13++;
        }
        setMeasuredDimension(View.resolveSizeAndState(i3, View.MeasureSpec.makeMeasureSpec(i3, i14), i21), View.resolveSizeAndState(size2, i2, i21));
    }

    @Override // f.c.a.e.y.c
    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.d0 = z;
    }
}
