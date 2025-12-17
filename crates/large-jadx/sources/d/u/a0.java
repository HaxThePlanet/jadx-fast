package d.u;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class a0 {

    private static boolean a = true;
    static {
    }

    static d.u.z a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            y yVar = new y(viewGroup);
            return yVar;
        }
        return x.g(viewGroup);
    }

    private static void b(ViewGroup viewGroup, boolean z2) {
        int obj1;
        if (a0.a) {
            viewGroup.suppressLayout(z2);
        }
    }

    static void c(ViewGroup viewGroup, boolean z2) {
        int i;
        final int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 29) {
            viewGroup.suppressLayout(z2);
        } else {
            if (sDK_INT >= 18) {
                a0.b(viewGroup, z2);
            } else {
                b0.b(viewGroup, z2);
            }
        }
    }
}
