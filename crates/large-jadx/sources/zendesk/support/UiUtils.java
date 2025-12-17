package zendesk.support;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import f.g.c.a;
import java.util.Locale;

/* loaded from: classes3.dex */
public class UiUtils {

    private static zendesk.support.UiUtils IMPL = null;
    private static final String LOG_TAG = "UiUtils";
    static {
        UiUtils uiUtils = new UiUtils();
        UiUtils.IMPL = uiUtils;
    }

    public static java.lang.CharSequence decodeHtmlEntities(String string) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(string, 0);
        }
        return Html.fromHtml(string);
    }

    public static void dismissKeyboard(Activity activity) {
        UiUtils.IMPL.internalDismissKeyboard(activity);
    }

    public static void dismissKeyboard(View view) {
        UiUtils.IMPL.internalDismissKeyboard(view);
    }

    public static int resolveColor(int i, Context context2) {
        return UiUtils.IMPL.internalResolveColor(i, context2);
    }

    public static void setTint(int i, Drawable drawable2, View view3) {
        UiUtils.IMPL.internalSetTint(i, drawable2, view3);
    }

    public static void setUiUtils(zendesk.support.UiUtils uiUtils) {
        UiUtils.IMPL = uiUtils;
    }

    public static void setVisibility(View view, int i2) {
        String str;
        Object[] obj1;
        String obj2;
        if (view == null) {
            a.k("UiUtils", "View is null and can't change visibility", new Object[0]);
        } else {
            view.setVisibility(i2);
        }
    }

    public static void showKeyboard(View view) {
        UiUtils.IMPL.internalShowKeyboard(view);
    }

    public static int themeAttributeToColor(int i, Context context2, int i3) {
        return UiUtils.IMPL.internalThemeAttributeToColor(i, context2, i3);
    }

    public void internalDismissKeyboard(Activity activity) {
        String str;
        Object[] obj5;
        final String str2 = "UiUtils";
        str = 0;
        if (activity == null) {
            a.k(str2, "Cannot dismiss the keyboard when fragment is detached or the activity is null.", new Object[str]);
        }
        Object systemService = activity.getSystemService("input_method");
        if (systemService instanceof InputMethodManager != null) {
            obj5 = activity.getCurrentFocus();
            if (obj5 != null) {
                (InputMethodManager)systemService.hideSoftInputFromWindow(obj5.getWindowToken(), str);
            } else {
                a.k(str2, "Cannot hide soft input because window token could not be obtained", new Object[str]);
            }
        } else {
            a.k(str2, "Cannot hide soft input because we could not get the InputMethodManager", new Object[str]);
        }
    }

    public void internalDismissKeyboard(View view) {
        int str;
        android.os.IBinder obj5;
        final String str2 = "UiUtils";
        str = 0;
        if (view == null) {
            a.k(str2, "Cannot hide soft input because window token could not be obtained", new Object[str]);
        }
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager != null) {
            (InputMethodManager)systemService.hideSoftInputFromWindow(view.getWindowToken(), str);
        } else {
            a.k(str2, "Cannot hide soft input because we could not get the InputMethodManager", new Object[str]);
        }
    }

    public int internalResolveColor(int i, Context context2) {
        return a.d(context2, i);
    }

    public void internalSetTint(int i, Drawable drawable2, View view3) {
        if (drawable2 == null) {
            a.e("UiUtils", "Drawable is null, cannot apply a tint", new Object[0]);
        }
        a.n(a.r(drawable2).mutate(), i);
        if (view3 != null) {
            view3.invalidate();
        }
    }

    public void internalShowKeyboard(View view) {
        int str;
        View obj5;
        int i = 0;
        final String str3 = "UiUtils";
        if (view == null) {
            a.k(str3, "Cannot show soft input because window token could not be obtained", new Object[i]);
        }
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager != null) {
            (InputMethodManager)systemService.showSoftInput(view, 1);
        } else {
            a.k(str3, "Cannot hide soft input because we could not get the InputMethodManager", new Object[i]);
        }
    }

    public int internalThemeAttributeToColor(int i, Context context2, int i3) {
        int obj6;
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
                        return UiUtils.resolveColor(i3, context2);
                    }
                    obj6 = typedValue.resourceId;
                    if (obj6 == null) {
                        obj6 = typedValue.data;
                    } else {
                        obj6 = UiUtils.resolveColor(obj6, context2);
                    }
                }
                return obj6;
            }
        }
        a.b(str, "themeAttributeId, context, and fallbackColorId are required.", new Object[i2]);
        return -16777216;
    }

    public int internalThemeAttributeToPixels(int i, Context context2, int i3, float f4) {
        TypedValue typedValue = new TypedValue();
        int i2 = 1;
        if (!context2.getTheme().resolveAttribute(i, typedValue, i2)) {
            Object[] arr2 = new Object[i2];
            int i4 = 0;
            arr2[i4] = Integer.valueOf(i);
            a.e("UiUtils", String.format(Locale.US, "Resource %d not found. Resource is either missing or you are using a non-ui context.", arr2), new Object[i4]);
            return Math.round(TypedValue.applyDimension(i3, f4, context2.getResources().getDisplayMetrics()));
        }
        return Math.round(typedValue.getDimension(context2.getResources().getDisplayMetrics()));
    }
}
