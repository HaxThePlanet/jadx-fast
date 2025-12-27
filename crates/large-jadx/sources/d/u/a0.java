package d.u;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
class a0 {

    private static boolean a = true;
    static z a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new y(viewGroup);
        }
        return x.g(viewGroup);
    }

    private static void b(ViewGroup viewGroup, boolean z) {
        if (a0.a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (java.lang.NoSuchMethodError unused) {
                viewGroup = false;
                a0.a = viewGroup;
            }
        }
    }

    static void c(ViewGroup viewGroup, boolean z) {
        final int sDK_INT2 = Build.VERSION.SDK_INT;
        int i = 29;
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else {
            i = 18;
            if (Build.VERSION.SDK_INT >= 18) {
                a0.b(viewGroup, z);
            } else {
                b0.b(viewGroup, z);
            }
        }
    }

}
