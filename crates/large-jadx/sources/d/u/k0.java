package d.u;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class k0 extends d.u.j0 {
    @Override // d.u.j0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // d.u.j0
    public void e(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // d.u.j0
    public void f(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // d.u.j0
    public void g(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    @Override // d.u.j0
    public void h(View view, Matrix matrix2) {
        view.transformMatrixToGlobal(matrix2);
    }

    @Override // d.u.j0
    public void i(View view, Matrix matrix2) {
        view.transformMatrixToLocal(matrix2);
    }
}
