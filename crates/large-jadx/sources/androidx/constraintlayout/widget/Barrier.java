package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import d.f.a.m.a;
import d.f.a.m.e;

/* loaded from: classes.dex */
public class Barrier extends androidx.constraintlayout.widget.b {

    private int B;
    private int C;
    private a D;
    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        super.setVisibility(8);
    }

    private void t(e e, int i2, boolean z3) {
        int obj7;
        this.C = i2;
        final int i = 1;
        final int i3 = 0;
        final int i4 = 6;
        final int i5 = 5;
        if (Build.VERSION.SDK_INT < 17) {
            obj7 = this.B;
            if (obj7 == i5) {
                this.C = i3;
            } else {
                if (obj7 == i4) {
                    this.C = i;
                }
            }
        } else {
            if (z3) {
                obj7 = this.B;
                if (obj7 == i5) {
                    this.C = i;
                } else {
                    if (obj7 == i4) {
                        this.C = i3;
                    }
                }
            } else {
                obj7 = this.B;
                if (obj7 == i5) {
                    this.C = i3;
                } else {
                    if (obj7 == i4) {
                        this.C = i;
                    }
                }
            }
        }
        if (e instanceof a) {
            (a)e.r1(this.C);
        }
    }

    @Override // androidx.constraintlayout.widget.b
    public boolean getAllowsGoneWidget() {
        return this.D.l1();
    }

    @Override // androidx.constraintlayout.widget.b
    public int getMargin() {
        return this.D.n1();
    }

    @Override // androidx.constraintlayout.widget.b
    public int getType() {
        return this.B;
    }

    @Override // androidx.constraintlayout.widget.b
    protected void m(AttributeSet attributeSet) {
        a indexCount;
        int i4;
        int i2;
        int dimensionPixelSize;
        int i3;
        int i;
        Object obj7;
        super.m(attributeSet);
        indexCount = new a();
        this.D = indexCount;
        if (attributeSet != null) {
            obj7 = getContext().obtainStyledAttributes(attributeSet, i.T0);
            i4 = 0;
            i2 = i4;
            while (i2 < obj7.getIndexCount()) {
                dimensionPixelSize = obj7.getIndex(i2);
                if (dimensionPixelSize == i.c1) {
                } else {
                }
                if (dimensionPixelSize == i.b1) {
                } else {
                }
                if (dimensionPixelSize == i.d1) {
                }
                i2++;
                this.D.s1(obj7.getDimensionPixelSize(dimensionPixelSize, i4));
                this.D.q1(obj7.getBoolean(dimensionPixelSize, true));
                setType(obj7.getInt(dimensionPixelSize, i4));
            }
            obj7.recycle();
        }
        this.v = this.D;
        s();
    }

    @Override // androidx.constraintlayout.widget.b
    public void n(e e, boolean z2) {
        t(e, this.B, z2);
    }

    @Override // androidx.constraintlayout.widget.b
    public void setAllowsGoneWidget(boolean z) {
        this.D.q1(z);
    }

    @Override // androidx.constraintlayout.widget.b
    public void setDpMargin(int i) {
        this.D.s1((int)obj2);
    }

    @Override // androidx.constraintlayout.widget.b
    public void setMargin(int i) {
        this.D.s1(i);
    }

    @Override // androidx.constraintlayout.widget.b
    public void setType(int i) {
        this.B = i;
    }
}
