package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import d.h.l.h;
import d.h.l.u;
import f.c.a.e.f;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class c extends ViewGroup {

    private int a;
    private int b;
    private boolean c;
    private int v;
    public c(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public c(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        this.c = false;
        h(context, attributeSet2);
    }

    private static int e(int i, int i2, int i3) {
        if (i2 != Integer.MIN_VALUE && i2 != 1073741824) {
            if (i2 != 1073741824) {
                return i3;
            }
            return i;
        }
        return Math.min(i3, i);
    }

    private void h(Context context, AttributeSet attributeSet2) {
        final int i = 0;
        TypedArray obj3 = context.getTheme().obtainStyledAttributes(attributeSet2, l.L1, i, i);
        this.a = obj3.getDimensionPixelSize(l.N1, i);
        this.b = obj3.getDimensionPixelSize(l.M1, i);
        obj3.recycle();
    }

    @Override // android.view.ViewGroup
    public int f(View view) {
        Object obj2 = view.getTag(f.Y);
        if (!obj2 instanceof Integer) {
            return -1;
        }
        return (Integer)obj2.intValue();
    }

    @Override // android.view.ViewGroup
    public boolean g() {
        return this.c;
    }

    @Override // android.view.ViewGroup
    protected int getItemSpacing() {
        return this.b;
    }

    @Override // android.view.ViewGroup
    protected int getLineSpacing() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    protected int getRowCount() {
        return this.v;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingRight;
        int paddingRight2;
        int i10;
        int paddingTop;
        int i7;
        int i6;
        View childAt;
        int i8;
        Integer valueOf;
        int i11;
        int i;
        int i9;
        int obj11;
        int obj14;
        final int obj12 = 0;
        if (getChildCount() == 0) {
            this.v = obj12;
        }
        int obj10 = 1;
        this.v = obj10;
        obj14 = u.B(this) == obj10 ? obj10 : obj12;
        if (obj14 != null) {
            paddingRight = getPaddingRight();
        } else {
            paddingRight = getPaddingLeft();
        }
        if (obj14 != null) {
            paddingRight2 = getPaddingLeft();
        } else {
            paddingRight2 = getPaddingRight();
        }
        obj13 -= paddingRight2;
        i10 = obj12;
        i6 = paddingRight;
        obj11 = paddingTop;
        while (i10 < getChildCount()) {
            childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
            } else {
            }
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            } else {
            }
            i11 = i8;
            if (!this.c && i19 += measuredWidth3 > obj13) {
            }
            childAt.setTag(f.Y, Integer.valueOf(i21 -= obj10));
            i7 = i6 + i11;
            measuredWidth2 += i7;
            measuredHeight += obj11;
            if (obj14 != null) {
            } else {
            }
            childAt.layout(i7, obj11, i, i9);
            i6 += valueOf;
            paddingTop = i9;
            i10++;
            childAt.layout(obj13 - i, obj11, i23 -= i11, i9);
            if (i19 += measuredWidth3 > obj13) {
            }
            obj11 += paddingTop;
            this.v = i14 += obj10;
            i6 = paddingRight;
            i11 = h.b((ViewGroup.MarginLayoutParams)layoutParams);
            i8 = h.a(layoutParams);
            childAt.setTag(f.Y, -1);
        }
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        int i11;
        int i5;
        int paddingLeft;
        int i7;
        int paddingLeft2;
        int paddingTop;
        int paddingRight;
        int i13;
        int i15;
        int i3;
        int i4;
        View childAt;
        int i14;
        int i8;
        int i9;
        int i6;
        int i10;
        int measuredWidth;
        int i12;
        final Object obj = this;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                i5 = size;
            } else {
                i5 = Integer.MAX_VALUE;
            }
        } else {
        }
        paddingLeft = getPaddingLeft();
        i15 = paddingTop;
        i3 = 0;
        i4 = 0;
        while (i3 < getChildCount()) {
            childAt = obj.getChildAt(i3);
            if (childAt.getVisibility() == 8) {
            } else {
            }
            obj.measureChild(childAt, i, i2);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            } else {
            }
            i9 = i13;
            if (i29 + measuredWidth > i5 -= paddingRight && !g()) {
            } else {
            }
            paddingLeft2 = i12;
            i20 += measuredWidth3;
            if (i21 > i4) {
            }
            paddingLeft2 += paddingRight;
            if (i3 == childCount--) {
            }
            paddingTop = i10;
            i3++;
            i4 += i9;
            i4 = i21;
            if (!g()) {
            } else {
            }
            paddingLeft2 = getPaddingLeft();
            i26 += paddingTop;
            i6 = 0;
            i13 = leftMargin + 0;
            i9 = rightMargin + 0;
            i14 = i;
            i8 = i2;
            i6 = 0;
        }
        obj.setMeasuredDimension(c.e(size, mode, i4 += paddingRight2), c.e(View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2), paddingTop += paddingBottom));
    }

    @Override // android.view.ViewGroup
    protected void setItemSpacing(int i) {
        this.b = i;
    }

    @Override // android.view.ViewGroup
    protected void setLineSpacing(int i) {
        this.a = i;
    }

    @Override // android.view.ViewGroup
    public void setSingleLine(boolean z) {
        this.c = z;
    }
}
