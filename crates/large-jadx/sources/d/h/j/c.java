package d.h.j;

import android.icu.util.ULocale;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c {

    private static Method a;
    private static Method b;
    static {
        Class<String> method;
        Object forName;
        int sDK_INT;
        int arr;
        method = String.class;
        forName = "libcore.icu.ICU";
        sDK_INT = Build.VERSION.SDK_INT;
        final String str2 = "addLikelySubtags";
        final int i = 0;
        final int i2 = 1;
        if (sDK_INT < 21) {
            forName = Class.forName(forName);
            if (forName != null) {
                arr = new Class[i2];
                arr[i] = method;
                c.a = forName.getMethod("getScript", arr);
                sDK_INT = new Class[i2];
                sDK_INT[i] = method;
                c.b = forName.getMethod(str2, sDK_INT);
            }
        } else {
            if (sDK_INT < 24) {
                forName = new Class[i2];
                forName[i] = Locale.class;
                c.b = Class.forName(forName).getMethod(str2, forName);
            }
        }
    }

    private static String a(Locale locale) {
        Method method;
        final String str = "ICUCompat";
        final String obj4 = locale.toString();
        method = c.b;
        if (method != null) {
            Object[] arr = new Object[1];
            return (String)method.invoke(0, obj4);
        }
        return obj4;
    }

    private static String b(String string) {
        Object obj5;
        final String str = "ICUCompat";
        final int i = 0;
        final Method method = c.a;
        if (method != null) {
            Object[] arr = new Object[1];
            return (String)method.invoke(i, string);
        }
        return i;
    }

    public static String c(Locale locale) {
        Throwable th;
        final String str = "ICUCompat";
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        final int i5 = 0;
        if (sDK_INT >= 21) {
            Object[] arr = new Object[1];
            return (Locale)c.b.invoke(i5, locale).getScript();
        }
        String obj4 = c.a(locale);
        if (obj4 != null) {
            return c.b(obj4);
        }
        return i5;
    }
}
