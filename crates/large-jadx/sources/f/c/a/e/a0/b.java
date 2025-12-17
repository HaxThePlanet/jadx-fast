package f.c.a.e.a0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes2.dex */
public class b {
    public static TypedValue a(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i2, boolean z3) {
        int i;
        TypedValue obj1;
        int obj2;
        int obj3;
        obj1 = b.a(context, i2);
        if (obj1 != null && obj1.type == 18) {
            if (obj1.type == 18) {
                obj3 = obj1.data != null ? 1 : 0;
            }
        }
        return obj3;
    }

    public static int c(Context context, int i2, int i3) {
        int i;
        int obj2;
        int obj3;
        final TypedValue obj1 = b.a(context, i2);
        if (obj1 != null && obj1.type == 16) {
            if (obj1.type == 16) {
                obj3 = obj1.data;
            }
        }
        return obj3;
    }

    public static int d(Context context, int i2, String string3) {
        TypedValue typedValue = b.a(context, i2);
        if (typedValue == null) {
        } else {
            return typedValue.data;
        }
        Object[] arr = new Object[2];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", string3, context.getResources().getResourceName(i2)));
        throw illegalArgumentException;
    }

    public static int e(View view, int i2) {
        return b.d(view.getContext(), i2, view.getClass().getCanonicalName());
    }
}
