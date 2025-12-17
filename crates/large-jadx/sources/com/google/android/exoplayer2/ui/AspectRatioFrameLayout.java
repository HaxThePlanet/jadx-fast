package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    private final com.google.android.exoplayer2.ui.AspectRatioFrameLayout.c a;
    private com.google.android.exoplayer2.ui.AspectRatioFrameLayout.b b;
    private float c;
    private int v = 0;

    static class a {
    }

    public interface b {
        public abstract void a(float f, float f2, boolean z3);
    }

    private final class c implements Runnable {

        private float a;
        private float b;
        private boolean c;
        private boolean v;
        final com.google.android.exoplayer2.ui.AspectRatioFrameLayout w;
        private c(com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout) {
            this.w = aspectRatioFrameLayout;
            super();
        }

        c(com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout, com.google.android.exoplayer2.ui.AspectRatioFrameLayout.a aspectRatioFrameLayout$a2) {
            super(aspectRatioFrameLayout);
        }

        @Override // java.lang.Runnable
        public void a(float f, float f2, boolean z3) {
            boolean obj1;
            this.a = f;
            this.b = f2;
            this.c = z3;
            if (!this.v) {
                this.v = true;
                this.w.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.v = false;
            if (AspectRatioFrameLayout.a(this.w) == null) {
            }
            AspectRatioFrameLayout.a(this.w).a(this.a, this.b, this.c);
        }
    }
    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet2) {
        int[] iArr;
        Object obj3;
        AttributeSet obj4;
        super(context, attributeSet2);
        final int i = 0;
        if (attributeSet2 != null) {
            obj3 = context.getTheme().obtainStyledAttributes(attributeSet2, v.a, i, i);
            this.v = obj3.getInt(v.b, i);
            obj3.recycle();
        }
        obj3 = new AspectRatioFrameLayout.c(this, 0);
        this.a = obj3;
    }

    static com.google.android.exoplayer2.ui.AspectRatioFrameLayout.b a(com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout) {
        return aspectRatioFrameLayout.b;
    }

    @Override // android.widget.FrameLayout
    public int getResizeMode() {
        return this.v;
    }

    @Override // android.widget.FrameLayout
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int i5;
        float i3;
        int i4;
        float obj9;
        float obj10;
        super.onMeasure(i, i2);
        obj10 = 0;
        if (Float.compare(obj9, obj10) <= 0) {
        }
        i5 = (float)obj9;
        i3 = (float)measuredHeight;
        final int i7 = i5 / i3;
        i8 -= i10;
        if (Float.compare(f3, i12) <= 0) {
            this.a.a(this.c, i7, false);
        }
        int i11 = this.v;
        int i13 = 1;
        if (i11 != 0) {
            if (i11 != i13) {
                if (i11 != 2) {
                    if (i11 != 4) {
                    } else {
                        if (Float.compare(i9, obj10) > 0) {
                            obj9 = this.c;
                            obj9 = (int)i3;
                        } else {
                            obj10 = this.c;
                            measuredHeight = (int)i5;
                        }
                    }
                } else {
                    obj9 = this.c;
                }
            } else {
                obj10 = this.c;
            }
        } else {
        }
        this.a.a(this.c, i7, i13);
        obj10 = 1073741824;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(obj9, obj10), View.MeasureSpec.makeMeasureSpec(measuredHeight, obj10));
    }

    @Override // android.widget.FrameLayout
    public void setAspectRatio(float f) {
        if (Float.compare(f2, f) != 0) {
            this.c = f;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout
    public void setAspectRatioListener(com.google.android.exoplayer2.ui.AspectRatioFrameLayout.b aspectRatioFrameLayout$b) {
        this.b = b;
    }

    @Override // android.widget.FrameLayout
    public void setResizeMode(int i) {
        if (this.v != i) {
            this.v = i;
            requestLayout();
        }
    }
}
