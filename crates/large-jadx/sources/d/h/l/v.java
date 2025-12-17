package d.h.l;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class v {

    private static Method a;
    static {
        int declaredMethod;
        int str;
        Class[] arr;
        if (Build.VERSION.SDK_INT == 25) {
            v.a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
        }
    }

    private static float a(ViewConfiguration viewConfiguration, Context context2) {
        int sDK_INT;
        Object obj3;
        sDK_INT = v.a;
        if (Build.VERSION.SDK_INT >= 25 && sDK_INT != null) {
            sDK_INT = v.a;
            if (sDK_INT != null) {
                return (float)obj3;
            }
        }
        obj3 = new TypedValue();
        if (context2.getTheme().resolveAttribute(16842829, obj3, true)) {
            return obj3.getDimension(context2.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static float b(ViewConfiguration viewConfiguration, Context context2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return v.a(viewConfiguration, context2);
    }

    public static int c(ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.getScaledHoverSlop();
        }
        return obj2 /= 2;
    }

    public static float d(ViewConfiguration viewConfiguration, Context context2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return v.a(viewConfiguration, context2);
    }

    public static boolean e(ViewConfiguration viewConfiguration, Context context2) {
        Resources obj2;
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        obj2 = context2.getResources();
        int obj3 = obj2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        if (obj3 != null && obj2.getBoolean(obj3)) {
            obj2 = obj2.getBoolean(obj3) ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
