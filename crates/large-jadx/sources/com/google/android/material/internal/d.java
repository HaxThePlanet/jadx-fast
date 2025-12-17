package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import androidx.appcompat.widget.e0;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class d extends e0 {

    private Drawable a;
    private final Rect b;
    private final Rect c;
    private int v;
    protected boolean w;
    boolean x;
    public d(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public d(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        Rect rect = new Rect();
        this.b = rect;
        Rect rect2 = new Rect();
        this.c = rect2;
        this.v = 119;
        int i2 = 1;
        this.w = i2;
        final int i4 = 0;
        this.x = i4;
        final TypedArray obj9 = l.h(context, attributeSet2, l.O1, i3, 0, new int[i4]);
        this.v = obj9.getInt(l.Q1, this.v);
        Drawable obj10 = obj9.getDrawable(l.P1);
        if (obj10 != null) {
            setForeground(obj10);
        }
        this.w = obj9.getBoolean(l.R1, i2);
        obj9.recycle();
    }

    @Override // androidx.appcompat.widget.e0
    public void draw(Canvas canvas) {
        boolean z;
        int paddingLeft;
        Rect rect2;
        Rect rect;
        int intrinsicWidth;
        int i;
        int intrinsicHeight;
        int i2;
        boolean paddingTop;
        int paddingBottom;
        super.draw(canvas);
        final Drawable drawable = this.a;
        if (drawable != null && this.x) {
            if (this.x) {
                paddingLeft = 0;
                this.x = paddingLeft;
                rect2 = this.b;
                rect = this.c;
                right -= left;
                bottom -= top;
                if (this.w) {
                    rect2.set(paddingLeft, paddingLeft, i, i2);
                } else {
                    rect2.set(getPaddingLeft(), getPaddingTop(), i -= paddingRight, i2 -= paddingBottom);
                }
                Gravity.apply(this.v, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect2, rect);
                drawable.setBounds(rect);
            }
            drawable.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        final Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // androidx.appcompat.widget.e0
    protected void drawableStateChanged() {
        Drawable stateful;
        int[] drawableState;
        super.drawableStateChanged();
        stateful = this.a;
        if (stateful != null && stateful.isStateful()) {
            if (stateful.isStateful()) {
                this.a.setState(getDrawableState());
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    public Drawable getForeground() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.e0
    public int getForegroundGravity() {
        return this.v;
    }

    @Override // androidx.appcompat.widget.e0
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        final Drawable drawable = this.a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.e0
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.x = z |= obj2;
    }

    @Override // androidx.appcompat.widget.e0
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.x = true;
    }

    @Override // androidx.appcompat.widget.e0
    public void setForeground(Drawable drawable) {
        Drawable rect;
        boolean drawableState;
        int i;
        Drawable obj3;
        rect = this.a;
        if (rect != drawable && rect != null) {
            if (rect != null) {
                rect.setCallback(0);
                unscheduleDrawable(this.a);
            }
            this.a = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.v == 119) {
                    rect = new Rect();
                    drawable.getPadding(rect);
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void setForegroundGravity(int i) {
        int i2;
        int i3;
        int obj2;
        if (this.v != i && i4 &= i == 0) {
            if (i4 &= i == 0) {
                i |= i3;
            }
            if (obj2 & 112 == 0) {
                obj2 |= 48;
            }
            this.v = obj2;
            if (obj2 == 119 && this.a != null) {
                if (this.a != null) {
                    obj2 = new Rect();
                    this.a.getPadding(obj2);
                }
            }
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.e0
    protected boolean verifyDrawable(Drawable drawable) {
        Drawable verifyDrawable;
        int obj2;
        if (!super.verifyDrawable(drawable)) {
            if (drawable == this.a) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }
}
