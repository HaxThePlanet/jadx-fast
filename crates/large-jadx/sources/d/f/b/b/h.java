package d.f.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.b;
import androidx.constraintlayout.widget.i;

/* loaded from: classes.dex */
public class h extends b implements d.f.b.b.j.f {

    private boolean B;
    private boolean C;
    private float D;
    protected View[] E;
    @Override // androidx.constraintlayout.widget.b
    public void a(d.f.b.b.j j, int i2, int i3, float f4) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void b(d.f.b.b.j j, int i2, int i3) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void c(d.f.b.b.j j, int i2) {
    }

    @Override // androidx.constraintlayout.widget.b
    public float getProgress() {
        return this.D;
    }

    @Override // androidx.constraintlayout.widget.b
    protected void m(AttributeSet attributeSet) {
        int indexCount;
        int i2;
        int boolean;
        int i;
        Object obj5;
        super.m(attributeSet);
        if (attributeSet != null) {
            obj5 = getContext().obtainStyledAttributes(attributeSet, i.H5);
            i2 = 0;
            while (i2 < obj5.getIndexCount()) {
                boolean = obj5.getIndex(i2);
                if (boolean == i.J5) {
                } else {
                }
                if (boolean == i.I5) {
                }
                i2++;
                this.C = obj5.getBoolean(boolean, this.C);
                this.B = obj5.getBoolean(boolean, this.B);
            }
            obj5.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.b
    public void setProgress(float f) {
        int parent;
        View[] objArr;
        int i;
        int childCount;
        View childAt;
        boolean z;
        this.D = f;
        i = 0;
        if (this.b > 0) {
            this.E = l((ConstraintLayout)getParent());
            while (i < this.b) {
                y(this.E[i], f);
                i++;
            }
        } else {
            parent = getParent();
            while (i < (ViewGroup)parent.getChildCount()) {
                childAt = parent.getChildAt(i);
                if (childAt instanceof h) {
                } else {
                }
                y(childAt, f);
                i++;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.b
    public boolean t() {
        return 0;
    }

    @Override // androidx.constraintlayout.widget.b
    public boolean u() {
        return this.C;
    }

    @Override // androidx.constraintlayout.widget.b
    public boolean v() {
        return this.B;
    }

    @Override // androidx.constraintlayout.widget.b
    public void w(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void x(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void y(View view, float f2) {
    }
}
