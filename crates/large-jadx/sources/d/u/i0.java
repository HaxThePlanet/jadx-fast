package d.u;

import android.view.View;

/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
class i0 extends h0 {

    private static boolean h = true;
    i0() {
        super();
    }

    @Override // d.u.h0
    public void e(View view, int i, int i2, int i3, int i4) {
        if (i0.h) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (java.lang.NoSuchMethodError unused) {
                view = false;
                i0.h = view;
            }
        }
    }

}
