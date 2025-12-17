package d.h.l;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* loaded from: classes.dex */
public final class h {
    public static int a(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    public static int b(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    public static void c(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(i2);
        } else {
            marginLayoutParams.rightMargin = i2;
        }
    }

    public static void d(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(i2);
        } else {
            marginLayoutParams.leftMargin = i2;
        }
    }
}
