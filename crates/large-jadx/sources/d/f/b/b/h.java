package d.f.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.b;
import androidx.constraintlayout.widget.i;

/* compiled from: MotionHelper.java */
/* loaded from: classes.dex */
public class h extends b implements j.f {

    private boolean B;
    private boolean C;
    private float D;
    protected View[] E;
    @Override // androidx.constraintlayout.widget.b
    public float getProgress() {
        return this.D;
    }

    @Override // androidx.constraintlayout.widget.b
    protected void m(AttributeSet set) throws android.content.res.Resources.NotFoundException {
        int i = 0;
        int index;
        int i2;
        super.m(set);
        if (set != null) {
            TypedArray styledAttributes = getContext().obtainStyledAttributes(set, i.H5);
            i = 0;
            while (i.H5 < styledAttributes.getIndexCount()) {
                index = styledAttributes.getIndex(i);
                i = i + 1;
            }
            styledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.b
    public void setProgress(float f) {
        int i2 = 0;
        View childAt;
        boolean z;
        this.D = f;
        i2 = 0;
        if (this.b > 0) {
            this.E = l((ConstraintLayout)getParent());
            while (i2 < this.b) {
                y(this.E[i2], f);
                i2 = i2 + 1;
            }
        } else {
            android.view.ViewParent parent2 = getParent();
            while (i2 < parent2.getChildCount()) {
                childAt = parent2.getChildAt(i2);
                z = childAt instanceof h;
                i2 = i2 + 1;
            }
        }
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
    public void a(j jVar, int i, int i2, float f) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void b(j jVar, int i, int i2) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void c(j jVar, int i) {
    }

    @Override // androidx.constraintlayout.widget.b
    public boolean t() {
        return false;
    }

    @Override // androidx.constraintlayout.widget.b
    public void w(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void x(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.widget.b
    public void y(View view, float f) {
    }
}
