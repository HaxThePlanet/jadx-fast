package d.u;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29.java */
/* loaded from: classes.dex */
class k0 extends j0 {
    k0() {
        super();
    }

    @Override // d.u.j0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // d.u.j0
    public void e(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // d.u.j0
    public void f(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // d.u.j0
    public void g(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // d.u.j0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // d.u.j0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
