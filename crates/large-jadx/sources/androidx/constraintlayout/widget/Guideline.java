package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        final int obj1 = 0;
        setMeasuredDimension(obj1, obj1);
    }

    @Override // android.view.View
    public void setGuidelineBegin(int i) {
        final android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.a = i;
        setLayoutParams((ConstraintLayout.b)layoutParams);
    }

    @Override // android.view.View
    public void setGuidelineEnd(int i) {
        final android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.b = i;
        setLayoutParams((ConstraintLayout.b)layoutParams);
    }

    @Override // android.view.View
    public void setGuidelinePercent(float f) {
        final android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.c = f;
        setLayoutParams((ConstraintLayout.b)layoutParams);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
