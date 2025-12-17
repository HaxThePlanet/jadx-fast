package zendesk.commonui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import f.g.c.a;
import java.util.Locale;

/* loaded from: classes3.dex */
public class d {
    public static java.lang.CharSequence a(String string) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(string, 0);
        }
        return Html.fromHtml(string);
    }

    public static int b(int i, Context context2) {
        return a.d(context2, i);
    }

    public static void c(int i, Drawable drawable2, View view3) {
        if (drawable2 == null) {
            a.e("UiUtils", "Drawable is null, cannot apply a tint", new Object[0]);
        }
        a.n(a.r(drawable2).mutate(), i);
        if (view3 != null) {
            view3.invalidate();
        }
    }

    public static void d(View view, int i2) {
        String str;
        Object[] obj1;
        String obj2;
        if (view == null) {
            a.k("UiUtils", "View is null and can't change visibility", new Object[0]);
        } else {
            view.setVisibility(i2);
        }
    }

    public static int e(int i, Context context2, int i3) {
        int obj5;
        final String str = "UiUtils";
        int i2 = 0;
        if (i != 0 && context2 != null) {
            if (context2 != null) {
                if (i3 == 0) {
                } else {
                    TypedValue typedValue = new TypedValue();
                    final int i4 = 1;
                    if (!context2.getTheme().resolveAttribute(i, typedValue, i4)) {
                        Object[] arr2 = new Object[i4];
                        arr2[i2] = Integer.valueOf(i);
                        a.e(str, String.format(Locale.US, "Resource %d not found. Resource is either missing or you are using a non-ui context.", arr2), new Object[i2]);
                        return d.b(i3, context2);
                    }
                    obj5 = typedValue.resourceId;
                    if (obj5 == null) {
                        obj5 = typedValue.data;
                    } else {
                        obj5 = d.b(obj5, context2);
                    }
                }
                return obj5;
            }
        }
        a.b(str, "themeAttributeId, context, and fallbackColorId are required.", new Object[i2]);
        return -16777216;
    }
}
