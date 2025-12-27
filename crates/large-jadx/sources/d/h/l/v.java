package d.h.l;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* compiled from: ViewConfigurationCompat.java */
/* loaded from: classes.dex */
public final class v {

    private static Method a;
    static {
        int i = 25;
        if (Build.VERSION.SDK_INT == 25) {
            try {
                v.a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private static float a(ViewConfiguration viewConfiguration, Context context) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 25 && v.a != null) {
            try {
            } catch (Exception unused) {
                viewConfiguration = "ViewConfigCompat";
                Log.i(viewConfiguration, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
            return (float)(Integer)v.a.invoke(viewConfiguration, new Object[0]).intValue();
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return v.a(viewConfiguration, context);
    }

    public static int c(ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.getScaledHoverSlop();
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static float d(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return v.a(viewConfiguration, context);
    }

    public static boolean e(ViewConfiguration viewConfiguration, Context context) throws android.content.res.Resources.NotFoundException {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        viewConfiguration = identifier != 0 && resources.getBoolean(identifier) ? 1 : 0;
        return (identifier != 0 && resources.getBoolean(identifier) ? 1 : 0);
    }
}
