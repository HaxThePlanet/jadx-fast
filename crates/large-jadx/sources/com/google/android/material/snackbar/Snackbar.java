package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import f.c.a.e.b;
import f.c.a.e.h;

/* loaded from: classes2.dex */
public class Snackbar extends com.google.android.material.snackbar.BaseTransientBottomBar<com.google.android.material.snackbar.Snackbar> {

    private static final int[] z;
    private final AccessibilityManager x;
    private boolean y;

    class a implements View.OnClickListener {

        final View.OnClickListener a;
        final com.google.android.material.snackbar.Snackbar b;
        a(com.google.android.material.snackbar.Snackbar snackbar, View.OnClickListener view$OnClickListener2) {
            this.b = snackbar;
            this.a = onClickListener2;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.onClick(view);
            this.b.v(1);
        }
    }

    public static final class SnackbarLayout extends com.google.android.material.snackbar.BaseTransientBottomBar.w {
        public SnackbarLayout(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$w
        protected void onMeasure(int i, int i2) {
            int i3;
            View childAt;
            int measureSpec2;
            int measureSpec;
            int measuredHeight;
            super.onMeasure(i, i2);
            i3 = 0;
            while (i3 < getChildCount()) {
                childAt = getChildAt(i3);
                if (layoutParams.width == -1) {
                }
                i3++;
                int i4 = 1073741824;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(obj7 -= paddingRight, i4), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), i4));
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$w
        public void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$w
        public void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$w
        public void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$w
        public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$w
        public void setOnClickListener(View.OnClickListener view$OnClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }
    static {
        int[] iArr = new int[2];
        Snackbar.z = iArr;
    }

    private Snackbar(Context context, ViewGroup viewGroup2, View view3, com.google.android.material.snackbar.a a4) {
        super(context, viewGroup2, view3, a4);
        this.x = (AccessibilityManager)viewGroup2.getContext().getSystemService("accessibility");
    }

    private static ViewGroup b0(View view) {
        int i;
        boolean z;
        Object obj3;
        final int i2 = 0;
        i = i2;
        while (obj3 instanceof CoordinatorLayout) {
            if (obj3 != null) {
            }
            if (obj3 instanceof View != null) {
            } else {
            }
            obj3 = i2;
            i = obj3;
        }
        return (ViewGroup)obj3;
    }

    private static boolean c0(Context context) {
        int i;
        final TypedArray obj5 = context.obtainStyledAttributes(Snackbar.z);
        final int i2 = -1;
        final int i3 = 1;
        obj5.recycle();
        if (obj5.getResourceId(0, i2) != i2 && obj5.getResourceId(i3, i2) != i2) {
            if (obj5.getResourceId(i3, i2) != i2) {
                i = i3;
            }
        }
        return i;
    }

    public static com.google.android.material.snackbar.Snackbar d0(View view, int i2, int i3) {
        return Snackbar.e0(view, view.getResources().getText(i2), i3);
    }

    public static com.google.android.material.snackbar.Snackbar e0(View view, java.lang.CharSequence charSequence2, int i3) {
        return Snackbar.f0(0, view, charSequence2, i3);
    }

    private static com.google.android.material.snackbar.Snackbar f0(Context context, View view2, java.lang.CharSequence charSequence3, int i4) {
        int i;
        Context obj3;
        ViewGroup obj4 = Snackbar.b0(view2);
        if (obj4 == null) {
        } else {
            if (context == null) {
                obj3 = obj4.getContext();
            }
            i = Snackbar.c0(obj3) ? h.x : h.d;
            View inflate = LayoutInflater.from(obj3).inflate(i, obj4, false);
            Snackbar snackbar = new Snackbar(obj3, obj4, (SnackbarContentLayout)inflate, inflate);
            snackbar.j0(charSequence3);
            snackbar.P(i4);
            return snackbar;
        }
        obj3 = new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        throw obj3;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void T() {
        super.T();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public com.google.android.material.snackbar.Snackbar g0(int i, View.OnClickListener view$OnClickListener2) {
        h0(y().getText(i), onClickListener2);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public com.google.android.material.snackbar.Snackbar h0(java.lang.CharSequence charSequence, View.OnClickListener view$OnClickListener2) {
        int empty;
        com.google.android.material.snackbar.Snackbar.a obj4;
        final int i = 0;
        android.widget.Button actionView = (SnackbarContentLayout)this.c.getChildAt(i).getActionView();
        if (!TextUtils.isEmpty(charSequence)) {
            if (onClickListener2 == null) {
                actionView.setVisibility(8);
                actionView.setOnClickListener(0);
                this.y = i;
            } else {
                this.y = true;
                actionView.setVisibility(i);
                actionView.setText(charSequence);
                obj4 = new Snackbar.a(this, onClickListener2);
                actionView.setOnClickListener(obj4);
            }
        } else {
        }
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public com.google.android.material.snackbar.Snackbar i0(int i) {
        j0(y().getText(i));
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public com.google.android.material.snackbar.Snackbar j0(java.lang.CharSequence charSequence) {
        (SnackbarContentLayout)this.c.getChildAt(0).getMessageView().setText(charSequence);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void u() {
        super.u();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int z() {
        int i2;
        int i;
        boolean touchExplorationEnabled;
        i2 = super.z();
        int i3 = -2;
        if (i2 == i3) {
            return i3;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            i = this.y ? 4 : 0;
            return this.x.getRecommendedTimeoutMillis(i2, i4 |= 2);
        }
        if (this.y && this.x.isTouchExplorationEnabled()) {
            if (this.x.isTouchExplorationEnabled()) {
                i2 = i3;
            }
        }
        return i2;
    }
}
