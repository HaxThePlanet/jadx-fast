package d.u;

import android.os.Build.VERSION;
import android.view.View;

/* loaded from: classes.dex */
class j0 extends d.u.i0 {

    private static boolean i = true;
    static {
    }

    @Override // d.u.i0
    public void g(View view, int i2) {
        int sDK_INT;
        View obj3;
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i2);
        } else {
            if (j0.i) {
                view.setTransitionVisibility(i2);
            }
        }
    }
}
