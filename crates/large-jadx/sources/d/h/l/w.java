package d.h.l;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import d.h.c;

/* compiled from: ViewGroupCompat.java */
/* loaded from: classes.dex */
public final class w {
    public static boolean a(ViewGroup viewGroup) {
        boolean booleanValue;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Object tag = viewGroup.getTag(c.O);
        if (tag == null || !tag.booleanValue()) {
            if (viewGroup.getBackground() != null || u.J(viewGroup) != null) {
                int i3 = 1;
            }
        }
        return z;
    }
}
