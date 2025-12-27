package d.h.l;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

/* compiled from: GravityCompat.java */
/* loaded from: classes.dex */
public final class e {
    public static void a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(i, i2, i3, rect, rect2, i4);
        } else {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    public static int b(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Gravity.getAbsoluteGravity(i, i2);
        }
        return i & (-8388609);
    }
}
