package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/* loaded from: classes.dex */
public class e extends ViewGroup {

    androidx.constraintlayout.widget.d a;

    public static class a extends androidx.constraintlayout.widget.ConstraintLayout.b {

        public float A0 = 1f;
        public float B0 = 1f;
        public float C0 = 0f;
        public float D0 = 0f;
        public float E0 = 0f;
        public float F0 = 0f;
        public float G0 = 0f;
        public float u0 = 1f;
        public boolean v0;
        public float w0 = 0f;
        public float x0 = 0f;
        public float y0 = 0f;
        public float z0 = 0f;
        public a(int i, int i2) {
            super(i, i2);
            final int obj1 = 1065353216;
            this.v0 = false;
            int obj2 = 0;
        }

        public a(Context context, AttributeSet attributeSet2) {
            int[] index;
            int i;
            int sDK_INT;
            int i2;
            super(context, attributeSet2);
            int i3 = 1065353216;
            this.v0 = false;
            sDK_INT = 0;
            final TypedArray obj5 = context.obtainStyledAttributes(attributeSet2, i.O3);
            while (i < obj5.getIndexCount()) {
                index = obj5.getIndex(i);
                if (index == i.P3) {
                } else {
                }
                i2 = 21;
                if (index == i.a4) {
                } else {
                }
                if (index == i.X3) {
                } else {
                }
                if (index == i.Y3) {
                } else {
                }
                if (index == i.W3) {
                } else {
                }
                if (index == i.U3) {
                } else {
                }
                if (index == i.V3) {
                } else {
                }
                if (index == i.Q3) {
                } else {
                }
                if (index == i.R3) {
                } else {
                }
                if (index == i.S3) {
                } else {
                }
                if (index == i.T3) {
                } else {
                }
                if (index == i.Z3 && Build.VERSION.SDK_INT >= i2) {
                }
                i++;
                if (Build.VERSION.SDK_INT >= i2) {
                }
                this.G0 = obj5.getFloat(index, this.G0);
                this.F0 = obj5.getFloat(index, this.F0);
                this.E0 = obj5.getFloat(index, this.E0);
                this.D0 = obj5.getFloat(index, this.D0);
                this.C0 = obj5.getFloat(index, this.C0);
                this.B0 = obj5.getFloat(index, this.B0);
                this.A0 = obj5.getFloat(index, this.A0);
                this.x0 = obj5.getFloat(index, this.x0);
                this.z0 = obj5.getFloat(index, this.z0);
                this.y0 = obj5.getFloat(index, this.y0);
                if (Build.VERSION.SDK_INT >= i2) {
                }
                this.w0 = obj5.getFloat(index, this.w0);
                this.v0 = true;
                this.u0 = obj5.getFloat(index, this.u0);
            }
            obj5.recycle();
        }
    }
    @Override // android.view.ViewGroup
    protected androidx.constraintlayout.widget.e.a a() {
        final int i = -2;
        e.a aVar = new e.a(i, i);
        return aVar;
    }

    @Override // android.view.ViewGroup
    public androidx.constraintlayout.widget.e.a b(AttributeSet attributeSet) {
        e.a aVar = new e.a(getContext(), attributeSet);
        return aVar;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        ConstraintLayout.b bVar = new ConstraintLayout.b(layoutParams);
        return bVar;
    }

    @Override // android.view.ViewGroup
    public androidx.constraintlayout.widget.d getConstraintSet() {
        androidx.constraintlayout.widget.d dVar;
        if (this.a == null) {
            dVar = new d();
            this.a = dVar;
        }
        this.a.h(this);
        return this.a;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }
}
