package d.h.l;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

/* loaded from: classes.dex */
public final class e {
    public static void a(int i, int i2, int i3, Rect rect4, Rect rect5, int i6) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(i, i2, i3, rect4, rect5, i6);
        } else {
            Gravity.apply(i, i2, i3, rect4, rect5);
        }
    }

    public static int b(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Gravity.getAbsoluteGravity(i, i2);
        }
        return i &= obj3;
    }
}
