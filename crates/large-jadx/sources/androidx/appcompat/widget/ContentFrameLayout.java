package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import d.h.l.u;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    private TypedValue a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue v;
    private TypedValue w;
    private TypedValue x;
    private final Rect y;
    private androidx.appcompat.widget.ContentFrameLayout.a z;

    public interface a {
        public abstract void a();

        public abstract void onDetachedFromWindow();
    }
    public ContentFrameLayout(Context context) {
        super(context, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        Rect obj1 = new Rect();
        this.y = obj1;
    }

    @Override // android.widget.FrameLayout
    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    @Override // android.widget.FrameLayout
    public void b(int i, int i2, int i3, int i4) {
        this.y.set(i, i2, i3, i4);
        if (u.R(this)) {
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout
    public TypedValue getFixedHeightMajor() {
        TypedValue typedValue;
        if (this.w == null) {
            typedValue = new TypedValue();
            this.w = typedValue;
        }
        return this.w;
    }

    @Override // android.widget.FrameLayout
    public TypedValue getFixedHeightMinor() {
        TypedValue typedValue;
        if (this.x == null) {
            typedValue = new TypedValue();
            this.x = typedValue;
        }
        return this.x;
    }

    @Override // android.widget.FrameLayout
    public TypedValue getFixedWidthMajor() {
        TypedValue typedValue;
        if (this.c == null) {
            typedValue = new TypedValue();
            this.c = typedValue;
        }
        return this.c;
    }

    @Override // android.widget.FrameLayout
    public TypedValue getFixedWidthMinor() {
        TypedValue typedValue;
        if (this.v == null) {
            typedValue = new TypedValue();
            this.v = typedValue;
        }
        return this.v;
    }

    @Override // android.widget.FrameLayout
    public TypedValue getMinWidthMajor() {
        TypedValue typedValue;
        if (this.a == null) {
            typedValue = new TypedValue();
            this.a = typedValue;
        }
        return this.a;
    }

    @Override // android.widget.FrameLayout
    public TypedValue getMinWidthMinor() {
        TypedValue typedValue;
        if (this.b == null) {
            typedValue = new TypedValue();
            this.b = typedValue;
        }
        return this.b;
    }

    @Override // android.widget.FrameLayout
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final androidx.appcompat.widget.ContentFrameLayout.a aVar = this.z;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.widget.FrameLayout
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final androidx.appcompat.widget.ContentFrameLayout.a aVar = this.z;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.widget.FrameLayout
    protected void onMeasure(int i, int i2) {
        android.util.DisplayMetrics displayMetrics;
        float dimension2;
        int right;
        int mode;
        int i4;
        int mode2;
        int measureSpec;
        float dimension;
        int i3;
        TypedValue typedValue;
        float dimension3;
        int bottom;
        int i5;
        int obj14;
        int obj15;
        displayMetrics = getContext().getResources().getDisplayMetrics();
        i4 = 1;
        final int i6 = 0;
        right = displayMetrics.widthPixels < displayMetrics.heightPixels ? i4 : i6;
        mode = View.MeasureSpec.getMode(i);
        final int i7 = 6;
        final int i8 = 5;
        final int i9 = Integer.MIN_VALUE;
        final int i10 = 1073741824;
        if (mode == i9) {
            typedValue = right != 0 ? this.v : this.c;
            bottom = typedValue.type;
            if (typedValue != null && bottom != 0) {
                bottom = typedValue.type;
                if (bottom != 0) {
                    if (bottom == i8) {
                        dimension3 = typedValue.getDimension(displayMetrics);
                        typedValue = (int)dimension3;
                    } else {
                    }
                    if (typedValue > 0) {
                        Rect rect3 = this.y;
                        obj14 = View.MeasureSpec.makeMeasureSpec(Math.min(typedValue -= i5, View.MeasureSpec.getSize(i)), i10);
                        i3 = i4;
                    } else {
                        i3 = i6;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (View.MeasureSpec.getMode(i2) == i9) {
            mode2 = right != 0 ? this.w : this.x;
            bottom = mode2.type;
            if (mode2 != null && bottom != 0) {
                bottom = mode2.type;
                if (bottom != 0) {
                    if (bottom == i8) {
                        dimension = mode2.getDimension(displayMetrics);
                        mode2 = (int)dimension;
                    } else {
                    }
                    if (mode2 > 0) {
                        Rect rect2 = this.y;
                        obj15 = View.MeasureSpec.makeMeasureSpec(Math.min(mode2 -= i5, View.MeasureSpec.getSize(i2)), i10);
                    }
                }
            }
        }
        super.onMeasure(obj14, obj15);
        obj14 = getMeasuredWidth();
        measureSpec = View.MeasureSpec.makeMeasureSpec(obj14, i10);
        if (i3 == 0 && mode == i9) {
            if (mode == i9) {
                right = right != 0 ? this.b : this.a;
                mode = right.type;
                if (right != null && mode != 0) {
                    mode = right.type;
                    if (mode != 0) {
                        if (mode == i8) {
                            dimension2 = right.getDimension(displayMetrics);
                            displayMetrics = (int)dimension2;
                        } else {
                        }
                        if (displayMetrics > 0) {
                            Rect rect = this.y;
                            displayMetrics -= mode;
                        }
                        if (obj14 < displayMetrics) {
                            measureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics, i10);
                        } else {
                            i4 = i6;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i4 != 0) {
            super.onMeasure(measureSpec, obj15);
        }
    }

    @Override // android.widget.FrameLayout
    public void setAttachListener(androidx.appcompat.widget.ContentFrameLayout.a contentFrameLayout$a) {
        this.z = a;
    }
}
