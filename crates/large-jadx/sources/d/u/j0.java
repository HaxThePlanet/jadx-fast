package d.u;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ViewUtilsApi23.java */
/* loaded from: classes.dex */
class j0 extends i0 {

    private static boolean i = true;
    j0() {
        super();
    }

    @Override // d.u.i0
    public void g(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i);
        } else {
            if (j0.i) {
                try {
                    view.setTransitionVisibility(i);
                } catch (java.lang.NoSuchMethodError unused) {
                    view = null;
                    j0.i = view;
                }
            }
        }
    }

}
