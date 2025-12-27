package d.u;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class h0 extends g0 {

    private static boolean f = true;
    private static boolean g = true;
    h0() {
        super();
    }

    @Override // d.u.g0
    public void h(View view, Matrix matrix) {
        if (h0.f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (java.lang.NoSuchMethodError unused) {
                view = false;
                h0.f = view;
            }
        }
    }

    @Override // d.u.g0
    public void i(View view, Matrix matrix) {
        if (h0.g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (java.lang.NoSuchMethodError unused) {
                view = false;
                h0.g = view;
            }
        }
    }

}
