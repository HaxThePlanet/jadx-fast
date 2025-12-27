package f.c.a.e.a0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;

/* compiled from: MaterialAttributes.java */
/* loaded from: classes2.dex */
public class b {
    public static TypedValue a(Context context, int i) {
        final TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i, boolean z) {
        TypedValue typedValue = b.a(context, i);
        if (typedValue != null) {
            i = 18;
            if (typedValue.type == 18 && typedValue.data != null) {
                int i3 = 1;
            }
        }
        return z;
    }

    public static int c(Context context, int i, int i2) {
        int data2;
        final TypedValue typedValue = b.a(context, i);
        if (typedValue != null) {
            i = 16;
            if (typedValue.type == 16) {
            }
        }
        return data2;
    }

    public static int d(Context context, int i, String str) throws android.content.res.Resources.NotFoundException {
        TypedValue typedValue = b.a(context, i);
        if (typedValue == null) {
            Object[] arr = new Object[2];
            throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[] { str, context.getResources().getResourceName(i) }));
        } else {
            return typedValue.data;
        }
    }

    public static int e(View view, int i) {
        return b.d(view.getContext(), i, view.getClass().getCanonicalName());
    }
}
