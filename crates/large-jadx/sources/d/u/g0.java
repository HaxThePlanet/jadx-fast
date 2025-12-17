package d.u;

import android.view.View;

/* loaded from: classes.dex */
class g0 extends d.u.l0 {

    private static boolean e = true;
    static {
    }

    @Override // d.u.l0
    public void a(View view) {
    }

    @Override // d.u.l0
    public float c(View view) {
        boolean z;
        if (g0.e) {
            return view.getTransitionAlpha();
        }
        return view.getAlpha();
    }

    @Override // d.u.l0
    public void d(View view) {
    }

    @Override // d.u.l0
    public void f(View view, float f2) {
        boolean z;
        if (g0.e) {
            view.setTransitionAlpha(f2);
        }
        view.setAlpha(f2);
    }
}
