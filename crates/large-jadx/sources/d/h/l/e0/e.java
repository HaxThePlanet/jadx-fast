package d.h.l.e0;

import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public class e {
    public static void a(AccessibilityRecord accessibilityRecord, int i2) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i2);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i2) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i2);
        }
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view2, int i3) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view2, i3);
        }
    }
}
