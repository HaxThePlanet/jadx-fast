package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import d.f.a.m.k;

/* loaded from: classes.dex */
public abstract class l extends androidx.constraintlayout.widget.b {

    private boolean B;
    private boolean C;
    @Override // androidx.constraintlayout.widget.b
    protected void i(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        h(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.b
    protected void m(AttributeSet attributeSet) {
        int indexCount;
        int i;
        int index;
        int i2;
        int i3;
        Object obj6;
        super.m(attributeSet);
        if (attributeSet != null) {
            obj6 = getContext().obtainStyledAttributes(attributeSet, i.T0);
            i = 0;
            while (i < obj6.getIndexCount()) {
                index = obj6.getIndex(i);
                i3 = 1;
                if (index == i.V0) {
                } else {
                }
                if (index == i.a1) {
                }
                i++;
                this.C = i3;
                this.B = i3;
            }
            obj6.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.b
    public void onAttachedToWindow() {
        boolean parent;
        boolean visibility;
        float elevation;
        int i2;
        int i3;
        int i;
        View view;
        boolean sDK_INT;
        super.onAttachedToWindow();
        if (!this.B) {
            parent = getParent();
            if (this.C && parent instanceof ConstraintLayout) {
                parent = getParent();
                if (parent instanceof ConstraintLayout) {
                    i2 = 21;
                    i3 = 0;
                    if (Build.VERSION.SDK_INT >= i2) {
                        elevation = getElevation();
                    } else {
                        elevation = i3;
                    }
                    i = 0;
                    while (i < this.b) {
                        view = (ConstraintLayout)parent.i(this.a[i]);
                        if (view != null && this.B) {
                        }
                        i++;
                        if (this.B) {
                        }
                        if (this.C && Float.compare(elevation, i3) > 0 && Build.VERSION.SDK_INT >= i2) {
                        }
                        if (Float.compare(elevation, i3) > 0) {
                        }
                        if (Build.VERSION.SDK_INT >= i2) {
                        }
                        view.setTranslationZ(translationZ += elevation);
                        view.setVisibility(getVisibility());
                    }
                }
            }
        } else {
        }
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

    @Override // androidx.constraintlayout.widget.b
    public void t(k k, int i2, int i3) {
    }
}
