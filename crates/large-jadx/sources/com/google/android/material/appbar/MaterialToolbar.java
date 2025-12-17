package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.a;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;
import com.google.android.material.theme.a.a;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.h;
import f.c.a.e.k;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {

    private static final int n0;
    private Integer k0;
    private boolean l0;
    private boolean m0;
    static {
        MaterialToolbar.n0 = k.C;
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.Z);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet2, int i3) {
        boolean value;
        int obj10;
        final int i2 = MaterialToolbar.n0;
        super(a.c(context, attributeSet2, i3, i2), attributeSet2, i3);
        Context obj8 = getContext();
        final int i4 = 0;
        final TypedArray obj9 = l.h(obj8, attributeSet2, l.v3, i3, i2, new int[i4]);
        obj10 = l.w3;
        if (obj9.hasValue(obj10)) {
            setNavigationIconTint(obj9.getColor(obj10, -1));
        }
        this.l0 = obj9.getBoolean(l.y3, i4);
        this.m0 = obj9.getBoolean(l.x3, i4);
        obj9.recycle();
        Q(obj8);
    }

    private Pair<Integer, Integer> P(TextView textView, TextView textView2) {
        int left;
        int paddingLeft;
        int i2;
        View childAt;
        int visibility;
        int right;
        int i;
        int measuredWidth = getMeasuredWidth();
        final int i3 = measuredWidth / 2;
        paddingLeft = getPaddingLeft();
        measuredWidth -= paddingRight;
        i2 = 0;
        while (i2 < getChildCount()) {
            childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2 && childAt.getRight() < i3 && childAt.getRight() > paddingLeft) {
            }
            i2++;
            if (childAt != textView) {
            }
            if (childAt != textView2) {
            }
            if (childAt.getRight() < i3) {
            }
            if (childAt.getLeft() > i3 && childAt.getLeft() < left) {
            }
            if (childAt.getLeft() < left) {
            }
            left = childAt.getLeft();
            if (childAt.getRight() > paddingLeft) {
            }
            paddingLeft = childAt.getRight();
        }
        Pair obj8 = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(left));
        return obj8;
    }

    private void Q(Context context) {
        int color;
        boolean z;
        Drawable background = getBackground();
        if (background != null && !background instanceof ColorDrawable) {
            if (!background instanceof ColorDrawable) {
            }
        }
        g gVar = new g();
        if (background != null) {
            color = (ColorDrawable)background.getColor();
        } else {
            color = 0;
        }
        gVar.Z(ColorStateList.valueOf(color));
        gVar.O(context);
        gVar.Y(u.w(this));
        u.o0(this, gVar);
    }

    private void R(View view, Pair<Integer, Integer> pair2) {
        int i;
        int i2;
        int measuredHeightAndState;
        int obj6;
        int measuredWidth2 = view.getMeasuredWidth();
        i3 -= i4;
        measuredWidth2 += i;
        final int i7 = 0;
        obj6 = Math.max(Math.max(intValue -= i, i7), Math.max(i2 - obj6, i7));
        if (obj6 > 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i, view.getTop(), i2, view.getBottom());
    }

    private void S() {
        boolean z;
        if (!this.l0 && !this.m0) {
            if (!this.m0) {
            }
        }
        TextView view = m.c(this);
        final TextView view2 = m.a(this);
        if (view == null && view2 == null) {
            if (view2 == null) {
            }
        }
        final Pair pair = P(view, view2);
        if (this.l0 && view != null) {
            if (view != null) {
                R(view, pair);
            }
        }
        if (this.m0 && view2 != null) {
            if (view2 != null) {
                R(view2, pair);
            }
        }
    }

    private Drawable T(Drawable drawable) {
        Integer intValue;
        Drawable obj2;
        if (drawable != null && this.k0 != null) {
            if (this.k0 != null) {
                a.n(a.r(drawable.mutate()), this.k0.intValue());
            }
        }
        return obj2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Integer getNavigationIconTint() {
        return this.k0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        S();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setElevation(float f) {
        super.setElevation(f);
        h.d(this, f);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(T(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIconTint(int i) {
        this.k0 = Integer.valueOf(i);
        Drawable obj1 = getNavigationIcon();
        if (obj1 != null) {
            setNavigationIcon(obj1);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleCentered(boolean z) {
        if (this.m0 != z) {
            this.m0 = z;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleCentered(boolean z) {
        if (this.l0 != z) {
            this.l0 = z;
            requestLayout();
        }
    }
}
