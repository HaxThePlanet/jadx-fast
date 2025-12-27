package d.h.j;

import android.icu.util.ULocale;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class c {

    private static Method a;
    private static Method b;
    static {
        Class<String> obj = String.class;
        str = "libcore.icu.ICU";
        sDK_INT2 = Build.VERSION.SDK_INT;
        final String str3 = "addLikelySubtags";
        final int i3 = 0;
        final int i4 = 1;
        int i2 = 21;
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class cls2 = Class.forName("libcore.icu.ICU");
                Class[] arr3 = new Class[i4];
                c.a = cls2.getMethod("getScript", new Class[] { obj });
                Class[] arr2 = new Class[i4];
                c.b = cls2.getMethod(str3, new Class[] { obj });
            } catch (Exception e) {
                Method illegalStateException = new IllegalStateException(e);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) illegalStateException;
            }
        } else {
            int i = 24;
            if (Build.VERSION.SDK_INT < 24) {
                try {
                    Class[] arr = new Class[i4];
                    c.b = Class.forName("libcore.icu.ICU").getMethod(str3, new Class[] { Locale.class });
                } catch (Exception e) {
                    illegalStateException = new IllegalStateException(e);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) illegalStateException;
                }
            }
        }
    }

    private static String a(Locale locale) {
        final String locale2 = locale.toString();
        try {
            method = c.b;
            Object[] arr = new Object[1];
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
            Log.w(str, invocationTarget);
        } catch (java.lang.IllegalAccessException illegalAccess1) {
            Log.w(str, illegalAccess1);
        }
        return locale2;
    }

    private static String b(String str) {
        final Object obj = null;
        try {
            final Method method = c.a;
            Object[] arr = new Object[1];
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
            Log.w(str2, invocationTarget);
        } catch (java.lang.IllegalAccessException illegalAccess1) {
            Log.w(str2, illegalAccess1);
        }
        return obj;
    }

    public static String c(Locale locale) {
        Throwable th;
        int sDK_INT2 = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        final Object obj = null;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Object[] arr = new Object[1];
            } catch (java.lang.IllegalAccessException illegalAccess) {
                Log.w(str, illegalAccess);
            } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
                Log.w(str, invocationTarget1);
            }
            return (Locale)c.b.invoke(obj, new Object[] { locale }).getScript();
        }
        String str3 = c.a(locale);
        if (str3 != null) {
            return c.b(str3);
        }
        return obj;
    }
}
