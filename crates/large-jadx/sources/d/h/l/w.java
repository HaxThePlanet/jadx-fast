package d.h.l;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import d.h.c;

/* loaded from: classes.dex */
public final class w {
    public static boolean a(ViewGroup viewGroup) {
        boolean booleanValue;
        int obj2;
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        booleanValue = viewGroup.getTag(c.O);
        if ((Boolean)booleanValue != null) {
            if (!(Boolean)booleanValue.booleanValue() && viewGroup.getBackground() == null) {
                if (viewGroup.getBackground() == null) {
                    if (u.J(viewGroup) != null) {
                        obj2 = 1;
                    } else {
                        obj2 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }
}
