package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import d.a.f;
import d.a.j;
import d.h.l.u;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    private boolean a;
    private int b = -1;
    private int c = 0;
    public ButtonBarLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        int i = -1;
        int i2 = 0;
        final int[] j0 = j.J0;
        TypedArray styledAttributes = context.obtainStyledAttributes(attributeSet2, j0);
        u.j0(this, context, j0, attributeSet2, styledAttributes, 0, 0);
        this.a = styledAttributes.getBoolean(j.K0, true);
        styledAttributes.recycle();
    }

    private int a(int i) {
        int visibility;
        int obj3;
        while (obj3 < getChildCount()) {
            obj3++;
        }
        return -1;
    }

    private boolean b() {
        int i;
        if (getOrientation() == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private void setStacked(boolean z) {
        int i;
        View viewById;
        int obj2;
        setOrientation(z);
        i = z != 0 ? 5 : 80;
        setGravity(i);
        viewById = findViewById(f.G);
        if (viewById != null) {
            obj2 = z != 0 ? 8 : 4;
            viewById.setVisibility(obj2);
        }
        obj2 += -2;
        while (obj2 >= 0) {
            bringChildToFront(getChildAt(obj2));
            obj2--;
        }
    }

    @Override // android.widget.LinearLayout
    public int getMinimumHeight() {
        return Math.max(this.c, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout
    protected void onMeasure(int i, int i2) {
        int measureSpec;
        int layoutParams;
        int z;
        int i4;
        boolean mode;
        int i3;
        int i5;
        int obj6;
        int obj7;
        int size = View.MeasureSpec.getSize(i);
        i3 = 0;
        if (this.a && size > this.b && b()) {
            if (size > this.b) {
                if (b()) {
                    setStacked(i3);
                }
            }
            this.b = size;
        }
        final int i11 = 1;
        if (!b() && View.MeasureSpec.getMode(i) == 1073741824) {
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                measureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                i4 = i11;
            } else {
                measureSpec = i;
                i4 = i3;
            }
        } else {
        }
        super.onMeasure(measureSpec, i2);
        if (this.a && !b()) {
            if (!b()) {
                layoutParams = measuredWidthAndState &= i12 == 16777216 ? i11 : i3;
                if (layoutParams != 0) {
                    setStacked(i11);
                    i4 = i11;
                }
            }
        }
        if (i4 != 0) {
            super.onMeasure(i, i2);
        }
        obj6 = a(i3);
        if (obj6 >= 0) {
            obj7 = getChildAt(obj6);
            layoutParams = obj7.getLayoutParams();
            i10 += i3;
            if (b()) {
                obj6 = a(obj6 += i11);
                if (obj6 >= 0) {
                    i4 += obj6;
                }
                i3 = i4;
            } else {
                i3 = i4 + obj6;
            }
        }
        if (u.C(this) != i3) {
            setMinimumHeight(i3);
        }
    }

    @Override // android.widget.LinearLayout
    public void setAllowStacking(boolean z) {
        boolean z2;
        boolean obj2;
        this.a = z;
        if (this.a != z && !z && getOrientation() == 1) {
            this.a = z;
            if (!z) {
                if (getOrientation() == 1) {
                    setStacked(false);
                }
            }
            requestLayout();
        }
    }
}
