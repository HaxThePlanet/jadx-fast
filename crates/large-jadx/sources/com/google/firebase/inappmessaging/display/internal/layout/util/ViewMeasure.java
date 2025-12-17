package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class ViewMeasure {

    private boolean flex;
    private int maxHeight;
    private int maxWidth;
    private View view;
    public ViewMeasure(View view, boolean z2) {
        super();
        this.view = view;
        this.flex = z2;
    }

    public int getDesiredHeight() {
        final int i = 0;
        if (this.view.getVisibility() == 8) {
            return i;
        }
        View view2 = this.view;
        if (view2 instanceof ScrollView != null) {
            return i3 += measuredHeight;
        }
        return view2.getMeasuredHeight();
    }

    public int getDesiredWidth() {
        if (this.view.getVisibility() == 8) {
            return 0;
        }
        return this.view.getMeasuredHeight();
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public View getView() {
        return this.view;
    }

    public boolean isFlex() {
        return this.flex;
    }

    public void preMeasure(int i, int i2) {
        MeasureUtils.measureAtMost(this.view, i, i2);
    }

    public void setMaxDimens(int i, int i2) {
        this.maxWidth = i;
        this.maxHeight = i2;
    }
}
