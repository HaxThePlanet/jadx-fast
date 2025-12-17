package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import d.a.f;
import d.h.l.e;
import d.h.l.u;

/* loaded from: classes.dex */
public class AlertDialogLayout extends androidx.appcompat.widget.e0 {
    public AlertDialogLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    private static int c(View view) {
        boolean childCount;
        int i;
        int i2 = u.C(view);
        if (i2 > 0) {
            return i2;
        }
        final int i3 = 0;
        if (view instanceof ViewGroup && (ViewGroup)view.getChildCount() == 1) {
            if ((ViewGroup)view.getChildCount() == 1) {
                return AlertDialogLayout.c(view.getChildAt(i3));
            }
        }
        return i3;
    }

    private boolean d(int i, int i2) {
        int i4;
        int combineMeasuredStates;
        int measuredState2;
        int measuredState3;
        int i5;
        int i9;
        int i7;
        int i10;
        int measuredWidth;
        int i8;
        View childAt;
        int visibility;
        int visibility2;
        int i6;
        int measuredHeight3;
        int measuredHeight;
        int i3;
        int measuredState;
        int measuredHeight2;
        int measureSpec;
        final Object obj = this;
        int i11 = i;
        final int i13 = i2;
        final int childCount = getChildCount();
        measuredState2 = 0;
        i9 = measuredState3;
        i10 = measuredState2;
        i8 = 8;
        while (i10 < childCount) {
            childAt = obj.getChildAt(i10);
            i8 = childAt.getId();
            i9 = childAt;
            i10++;
            i8 = 8;
            measuredState3 = childAt;
            i4 = childAt;
        }
        measuredWidth = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i4 != 0) {
            i4.measure(i11, measuredState2);
            i6 += measuredHeight3;
            combineMeasuredStates = View.combineMeasuredStates(measuredState2, i4.getMeasuredState());
        } else {
            combineMeasuredStates = measuredState2;
        }
        if (measuredState3 != 0) {
            measuredState3.measure(i11, measuredState2);
            measuredHeight = AlertDialogLayout.c(measuredState3);
            measuredHeight5 -= measuredHeight;
            i6 += measuredHeight;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, measuredState3.getMeasuredState());
        } else {
            i3 = measuredHeight;
        }
        if (i9 != 0) {
            if (measuredWidth == 0) {
                measureSpec = measuredState2;
            } else {
                measureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(measuredState2, size - i6), measuredWidth);
            }
            i9.measure(i11, measureSpec);
            i6 += measuredHeight2;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, i9.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        size -= i6;
        int i15 = 1073741824;
        i3 = Math.min(visibility, i3);
        if (measuredState3 != 0 && i3 > 0) {
            i3 = Math.min(visibility, i3);
            if (i3 > 0) {
                visibility -= i3;
                measuredHeight += i3;
            }
            measuredState3.measure(i11, View.MeasureSpec.makeMeasureSpec(measuredHeight, i15));
            i18 += measuredHeight;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, measuredState3.getMeasuredState());
        }
        if (i9 != 0 && visibility > 0) {
            if (visibility > 0) {
                i9.measure(i11, View.MeasureSpec.makeMeasureSpec(measuredHeight2 += visibility, measuredWidth));
                i19 += measuredHeight4;
                combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, i9.getMeasuredState());
            }
        }
        i5 = 0;
        i7 = 0;
        while (i5 < childCount) {
            measuredWidth = obj.getChildAt(i5);
            if (measuredWidth.getVisibility() != i8) {
            }
            i5++;
            i7 = Math.max(i7, measuredWidth.getMeasuredWidth());
        }
        obj.setMeasuredDimension(View.resolveSizeAndState(i7 += i16, i11, combineMeasuredStates), View.resolveSizeAndState(i6, i13, 0));
        if (View.MeasureSpec.getMode(i) != i15) {
            obj.forceUniformWidth(childCount, i13);
        }
        return 1;
    }

    private void forceUniformWidth(int i, int i2) {
        int i3;
        int visibility;
        View childAt;
        int i4;
        int i5;
        int i6;
        int i7;
        android.view.ViewGroup.LayoutParams view;
        int height;
        i3 = 0;
        while (i3 < i) {
            childAt = getChildAt(i3);
            view = layoutParams;
            if (childAt.getVisibility() != 8 && view.width == -1) {
            }
            i3++;
            view = layoutParams;
            if (view.width == -1) {
            }
            view.height = childAt.getMeasuredHeight();
            this.measureChildWithMargins(childAt, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), 0, i2, 0);
            view.height = view.height;
        }
    }

    private void setChildFrame(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 += i2, i5 += i3);
    }

    @Override // androidx.appcompat.widget.e0
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingTop;
        int paddingTop2;
        Drawable dividerDrawable;
        int i10;
        int visibility;
        int i6;
        int i13;
        int i;
        int rightMargin;
        int measuredWidth;
        int i11;
        int i9;
        int i7;
        int i8;
        android.view.ViewGroup.LayoutParams view;
        int i12;
        final View view3 = this;
        final int paddingLeft = getPaddingLeft();
        int i14 = i4 - i2;
        int measuredHeight = getMeasuredHeight();
        int gravity = getGravity();
        i10 = gravity & 112;
        if (i10 != 16) {
            if (i10 != 80) {
                paddingTop = getPaddingTop();
            } else {
                paddingTop = paddingTop2 - measuredHeight;
            }
        } else {
            paddingTop = paddingTop2 + i10;
        }
        dividerDrawable = getDividerDrawable();
        visibility = 0;
        if (dividerDrawable == null) {
            i9 = visibility;
        } else {
            i9 = dividerDrawable;
        }
        i7 = visibility;
        while (i7 < getChildCount()) {
            dividerDrawable = view3.getChildAt(i7);
            measuredWidth = dividerDrawable.getMeasuredWidth();
            int measuredHeight2 = dividerDrawable.getMeasuredHeight();
            view = layoutParams;
            if (dividerDrawable != null && dividerDrawable.getVisibility() != 8 && view.b < 0) {
            }
            i7++;
            if (dividerDrawable.getVisibility() != 8) {
            }
            measuredWidth = dividerDrawable.getMeasuredWidth();
            measuredHeight2 = dividerDrawable.getMeasuredHeight();
            view = layoutParams;
            if (view.b < 0) {
            }
            i20 &= 7;
            if (i21 != 1) {
            } else {
            }
            i24 += leftMargin2;
            rightMargin = view.rightMargin;
            i13 -= rightMargin;
            if (view3.hasDividerBeforeChildAt(i7)) {
            }
            int i30 = paddingTop + topMargin;
            this.setChildFrame(dividerDrawable, visibility, i30, measuredWidth, measuredHeight2);
            paddingTop = i12;
            paddingTop += i9;
            if (i21 != 5) {
            } else {
            }
            i13 = i27 - measuredWidth;
            rightMargin = view.rightMargin;
            leftMargin += paddingLeft;
            i6 = i29;
        }
    }

    @Override // androidx.appcompat.widget.e0
    protected void onMeasure(int i, int i2) {
        if (!d(i, i2)) {
            super.onMeasure(i, i2);
        }
    }
}
