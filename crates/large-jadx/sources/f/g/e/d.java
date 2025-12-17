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

/* loaded from: classes2.dex */
public class d {

    private static final String a = "d";
    private static final List<String> b;
    static {
        d.b = Arrays.asList(/* result */);
    }

    private static Locale a(String string, String string2) {
        Class<String> obj = String.class;
        final int i = 0;
        final int i4 = 1;
        if (Build.VERSION.SDK_INT >= 14) {
            int i3 = 3;
            final Class[] arr5 = new Class[i3];
            arr5[i] = Boolean.TYPE;
            arr5[i4] = obj;
            int i5 = 2;
            arr5[i5] = obj;
            Constructor declaredConstructor = Locale.class.getDeclaredConstructor(arr5);
            declaredConstructor.setAccessible(i4);
            Object[] arr2 = new Object[i3];
            arr2[i] = Boolean.TRUE;
            arr2[i4] = string;
            arr2[i5] = string2;
            return (Locale)declaredConstructor.newInstance(arr2);
        }
        Constructor declaredConstructor2 = Locale.class.getDeclaredConstructor(new Class[i]);
        declaredConstructor2.setAccessible(i4);
        Object instance = declaredConstructor2.newInstance(new Object[i]);
        Class class = (Locale)instance.getClass();
        Field declaredField = class.getDeclaredField("languageCode");
        declaredField.setAccessible(i4);
        declaredField.set(instance, string);
        Field obj7 = class.getDeclaredField("countryCode");
        obj7.setAccessible(i4);
        obj7.set(instance, string2);
        return instance;
    }

    private static Locale b(String string, String string2) {
        Class<String> obj = String.class;
        final int i2 = 0;
        final int i3 = 2;
        final Class[] arr3 = new Class[i3];
        arr3[i2] = obj;
        final int i4 = 1;
        arr3[i4] = obj;
        Method declaredMethod = Locale.class.getDeclaredMethod("createConstant", arr3);
        declaredMethod.setAccessible(i4);
        Object[] arr2 = new Object[i3];
        arr2[i2] = string;
        arr2[i4] = string2;
        return (Locale)declaredMethod.invoke(0, arr2);
    }

    public static Locale c(String string) {
        Locale locale;
        int str;
        String nextToken;
        Locale default;
        boolean stringTokenizer;
        int countTokens;
        int i2;
        int i;
        int i3;
        String obj8;
        locale = d.a;
        str = 0;
        a.b(locale, "Assuming Locale.getDefault()", new Object[str]);
        default = Locale.getDefault();
        if (g.c(string)) {
            stringTokenizer = new StringTokenizer(string, "-");
            countTokens = stringTokenizer.countTokens();
            i = 1;
            if (countTokens != i) {
                if (countTokens == 2) {
                    i3 = i;
                } else {
                    i3 = str;
                }
            } else {
            }
            if (i3 != 0) {
                if (countTokens == i) {
                } else {
                    i2 = 5;
                }
                if (i2 != string.length()) {
                    a.b(locale, "number of tokens is correct but the length of the locale string does not match the expected length", new Object[str]);
                } else {
                    obj8 = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        nextToken = stringTokenizer.nextToken();
                    } else {
                        nextToken = "";
                    }
                    String upperCase = nextToken.toUpperCase(Locale.US);
                    if (d.b.contains(obj8)) {
                        a.b(locale, "New ISO-6390-Alpha3 locale detected trying to create new locale per reflection", new Object[str]);
                        if (d.b(obj8, upperCase) == null) {
                            locale = d.a(obj8, upperCase);
                        }
                        if (locale == null) {
                            locale = new Locale(obj8, upperCase);
                        }
                    } else {
                        locale = new Locale(obj8, upperCase);
                    }
                    default = locale;
                }
            } else {
                a.k(locale, "Unexpected number of tokens, must be at least one and at most two", new Object[str]);
            }
        }
        return default;
    }

    public static String d(Locale locale) {
        boolean z;
        String obj2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage());
        if (locale != null && g.c(locale.getCountry())) {
            stringBuilder = new StringBuilder();
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
