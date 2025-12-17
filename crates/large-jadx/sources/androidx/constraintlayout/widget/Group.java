package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import d.f.a.m.e;

/* loaded from: classes.dex */
public class Group extends androidx.constraintlayout.widget.b {
    public Group(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // androidx.constraintlayout.widget.b
    protected void i(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        h(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.b
    protected void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        this.w = false;
    }

    @Override // androidx.constraintlayout.widget.b
    public void o(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        android.view.ViewGroup.LayoutParams obj3 = getLayoutParams();
        final int i = 0;
        obj3.s0.b1(i);
        obj3.s0.C0(i);
    }

    @Override // androidx.constraintlayout.widget.b
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // androidx.constraintlayout.widget.b
    public void setElevation(float f) {
        super.setElevation(f);
        g();
    }

    @Override // androidx.constraintlayout.widget.b
    public void setVisibility(int i) {
        super.setVisibility(i);
        g();
    }
}
