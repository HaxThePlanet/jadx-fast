package d.u;

import android.view.View;

/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
class g0 extends l0 {

    private static boolean e = true;
    g0() {
        super();
    }

    @Override // d.u.l0
    public float c(View view) {
        if (g0.e) {
            try {
            } catch (java.lang.NoSuchMethodError unused) {
                g0.e = false;
            }
            return view.getTransitionAlpha();
        }
        return view.getAlpha();
    }

    @Override // d.u.l0
    public void f(View view, float f) {
        if (g0.e) {
            try {
                view.setTransitionAlpha(f);
            } catch (java.lang.NoSuchMethodError unused) {
                g0.e = false;
            }
            return;
        }
        view.setAlpha(f);
    }


    @Override // d.u.l0
    public void a(View view) {
    }

    @Override // d.u.l0
    public void d(View view) {
    }
}
