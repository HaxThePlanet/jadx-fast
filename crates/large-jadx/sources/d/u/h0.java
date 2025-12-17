package d.u;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class h0 extends d.u.g0 {

    private static boolean f = true;
    private static boolean g = true;
    static {
    }

    @Override // d.u.g0
    public void h(View view, Matrix matrix2) {
        int obj2;
        if (h0.f) {
            view.transformMatrixToGlobal(matrix2);
        }
    }

    @Override // d.u.g0
    public void i(View view, Matrix matrix2) {
        int obj2;
        if (h0.g) {
            view.transformMatrixToLocal(matrix2);
        }
    }
}
