package f.g.e;

import android.os.Build.VERSION;
import f.g.c.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: LocaleUtil.java */
/* loaded from: classes2.dex */
public class d {

    private static final String a = "d";
    private static final List<String> b;
    static {
        d.b = Arrays.asList(new String[] { "he", "yi", "id" });
    }

    private static Locale a(String str, String str2) throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
        Class<String> obj = String.class;
        final int i = 0;
        try {
            final int i4 = 1;
            if (Build.VERSION.SDK_INT >= 14) {
                int i3 = 3;
                final Class[] arr5 = new Class[i3];
                arr5[i] = Boolean.TYPE;
                arr5[i4] = obj;
                int i5 = 2;
                arr5[i5] = obj;
                Constructor declaredConstructor2 = Locale.class.getDeclaredConstructor(arr5);
                declaredConstructor2.setAccessible(true);
                Object[] arr4 = new Object[i3];
                arr4[i] = Boolean.TRUE;
                arr4[i4] = str;
                arr4[i5] = str2;
                return (Locale)declaredConstructor2.newInstance(arr4);
            }
            Constructor declaredConstructor = Locale.class.getDeclaredConstructor(new Class[i]);
            declaredConstructor.setAccessible(true);
            Object constructor = declaredConstructor.newInstance(new Object[i]);
            Class cls = constructor.getClass();
            Field declaredField = cls.getDeclaredField("languageCode");
            declaredField.setAccessible(true);
            declaredField.set(constructor, str);
            Field declaredField2 = cls.getDeclaredField("countryCode");
            declaredField2.setAccessible(true);
            declaredField2.set(constructor, str2);
        } catch (Exception e) {
            str2 = d.a;
            int str3 = "Unable to create ISO-6390-Alpha3 per reflection";
            a.d(str2, str3, e, new Object[str3]);
            e = null;
            return e;
        }
        return constructor;
    }

    private static Locale b(String str, String str2) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException {
        Class<String> obj = String.class;
        final int i2 = 0;
        try {
            final int i3 = 2;
            final Class[] arr3 = new Class[i3];
            arr3[i2] = obj;
            final int i4 = 1;
            arr3[i4] = obj;
            Method declaredMethod = Locale.class.getDeclaredMethod("createConstant", arr3);
            declaredMethod.setAccessible(true);
            Object[] arr2 = new Object[i3];
            arr2[i2] = str;
            arr2[i4] = str2;
        } catch (Exception e) {
            str2 = d.a;
            int str3 = "Unable to create ISO-6390-Alpha3 per reflection";
            a.d(str2, str3, e, new Object[str3]);
            return obj2;
        }
        return (Locale)declaredMethod.invoke(null, arr2);
    }

    public static Locale c(String str) {
        Locale _default;
        int i = 0;
        String nextToken;
        boolean contains;
        int i2 = 5;
        str2 = d.a;
        i = 0;
        a.b(str2, "Assuming Locale.getDefault()", new Object[i]);
        _default = Locale.getDefault();
        if (g.c(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "-");
            int countTokens = stringTokenizer.countTokens();
            i2 = 2;
            i = 1;
            if (countTokens == i || countTokens == 2) {
            }
            if (i != 0) {
                if (countTokens != i) {
                    i2 = 5;
                }
                if (i2 != str.length()) {
                    a.b(d.a, "number of tokens is correct but the length of the locale string does not match the expected length", new Object[i]);
                } else {
                    String nextToken2 = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        nextToken = stringTokenizer.nextToken();
                    } else {
                        nextToken = "";
                    }
                    String str5 = nextToken.toUpperCase(Locale.US);
                    if (d.b.contains(nextToken2)) {
                        a.b(d.a, "New ISO-6390-Alpha3 locale detected trying to create new locale per reflection", new Object[i]);
                        if (d.b(nextToken2, str5) == null) {
                            _default = d.a(nextToken2, str5);
                        }
                        if (d.a == null) {
                            _default = new Locale(nextToken2, str5);
                        }
                    } else {
                        _default = new Locale(nextToken2, str5);
                    }
                }
            } else {
                a.k(d.a, "Unexpected number of tokens, must be at least one and at most two", new Object[i]);
            }
        }
        return _default;
    }

    public static String d(Locale locale) {
        if (locale != null) {
            final StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(locale.getLanguage());
            if (g.c(locale.getCountry())) {
                stringBuilder.append("-");
                stringBuilder.append(locale.getCountry().toLowerCase(Locale.US));
            }
            return stringBuilder.toString();
        }
        return null;
    }
}
