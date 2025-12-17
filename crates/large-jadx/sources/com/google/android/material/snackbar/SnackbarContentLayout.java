package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.f;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout implements com.google.android.material.snackbar.a {

    private TextView a;
    private Button b;
    private int c;
    public SnackbarContentLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    private static void d(View view, int i2, int i3) {
        int paddingLeft;
        int paddingRight;
        if (u.T(view)) {
            u.y0(view, u.G(view), i2, u.F(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    private boolean e(int i, int i2, int i3) {
        int paddingBottom;
        int i4;
        int obj3;
        obj3 = i != getOrientation() ? i4 : 0;
        if (this.a.getPaddingTop() == i2) {
            if (this.a.getPaddingBottom() != i3) {
                SnackbarContentLayout.d(this.a, i2, i3);
            } else {
                i4 = obj3;
            }
        } else {
        }
        return i4;
    }

    @Override // android.widget.LinearLayout
    public void a(int i, int i2) {
        int obj8;
        final int i3 = 0;
        this.a.setAlpha(i3);
        final int i4 = 1065353216;
        final long l = (long)i2;
        final long l2 = (long)i;
        this.a.animate().alpha(i4).setDuration(l).setStartDelay(l2).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(i3);
            this.b.animate().alpha(i4).setDuration(l).setStartDelay(l2).start();
        }
    }

    @Override // android.widget.LinearLayout
    public void b(int i, int i2) {
        int obj8;
        final int i3 = 1065353216;
        this.a.setAlpha(i3);
        final int i4 = 0;
        final long l = (long)i2;
        final long l2 = (long)i;
        this.a.animate().alpha(i4).setDuration(l).setStartDelay(l2).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(i3);
            this.b.animate().alpha(i4).setDuration(l).setStartDelay(l2).start();
        }
    }

    @Override // android.widget.LinearLayout
    void c(float f) {
        int cmp;
        int i;
        int obj3;
        if (Float.compare(f, i2) != 0) {
            this.b.setTextColor(a.h(a.d(this, b.q), this.b.getCurrentTextColor(), f));
        }
    }

    @Override // android.widget.LinearLayout
    public Button getActionView() {
        return this.b;
    }

    @Override // android.widget.LinearLayout
    public TextView getMessageView() {
        return this.a;
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView)findViewById(f.b0);
        this.b = (Button)findViewById(f.a0);
    }

    @Override // android.widget.LinearLayout
    protected void onMeasure(int i, int i2) {
        boolean z;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int i5;
        int i4;
        int measuredWidth;
        int i3;
        super.onMeasure(i, i2);
        dimensionPixelSize = getResources().getDimensionPixelSize(d.m);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(d.l);
        i4 = 0;
        final int i8 = 1;
        i5 = this.a.getLayout().getLineCount() > i8 ? i8 : i4;
        if (i5 != 0 && this.c > 0 && this.b.getMeasuredWidth() > this.c) {
            if (this.c > 0) {
                if (this.b.getMeasuredWidth() > this.c) {
                    if (e(i8, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                        i4 = i8;
                    }
                } else {
                    if (i5 != 0) {
                    } else {
                        dimensionPixelSize = dimensionPixelSize2;
                    }
                    if (e(i4, dimensionPixelSize, dimensionPixelSize)) {
                    }
                }
            } else {
            }
        } else {
        }
        if (i4 != 0) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.LinearLayout
    public void setMaxInlineActionWidth(int i) {
        this.c = i;
    }
}
