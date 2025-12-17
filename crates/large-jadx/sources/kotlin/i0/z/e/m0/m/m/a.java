package kotlin.i0.z.e.m0.m.m;

import java.util.Iterator;
import java.util.Objects;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes3.dex */
public final class a {
    public static final String a(String string) {
        int i2;
        char valueOf;
        int stringBuilder;
        int i;
        int i3;
        Object obj4;
        n.f(string, "<this>");
        stringBuilder = 1;
        i = 0;
        i2 = string.length() == 0 ? stringBuilder : i;
        if (i2 != 0) {
            return string;
        }
        valueOf = string.charAt(i);
        if (97 <= valueOf && valueOf <= 122) {
            if (valueOf <= 122) {
                i = stringBuilder;
            }
        }
        if (i != 0) {
            obj4 = string.substring(stringBuilder);
            n.e(obj4, "(this as java.lang.String).substring(startIndex)");
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(Character.toUpperCase(valueOf)));
            stringBuilder.append(obj4);
            obj4 = stringBuilder.toString();
        }
        return obj4;
    }

    public static final String b(String string) {
        int i2;
        char valueOf;
        int stringBuilder;
        int i;
        int i3;
        Object obj4;
        n.f(string, "<this>");
        stringBuilder = 1;
        i = 0;
        i2 = string.length() == 0 ? stringBuilder : i;
        if (i2 != 0) {
            return string;
        }
        valueOf = string.charAt(i);
        if (65 <= valueOf && valueOf <= 90) {
            if (valueOf <= 90) {
                i = stringBuilder;
            }
        }
        if (i != 0) {
            obj4 = string.substring(stringBuilder);
            n.e(obj4, "(this as java.lang.String).substring(startIndex)");
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(Character.toLowerCase(valueOf)));
            stringBuilder.append(obj4);
            obj4 = stringBuilder.toString();
        }
        return obj4;
    }

    public static final String c(String string, boolean z2) {
        int length;
        Object next;
        int i;
        Object obj5;
        n.f(string, "<this>");
        int i3 = 0;
        int i4 = 1;
        length = string.length() == 0 ? i4 : i3;
        if (length == 0) {
            if (!a.d(string, i3, z2)) {
            } else {
                if (string.length() != i4) {
                    if (!a.d(string, i4, z2)) {
                    } else {
                        Iterator iterator = l.X(string).iterator();
                        for (Object next : iterator) {
                        }
                        next = 0;
                        if ((Integer)next == null) {
                            return a.e(string, z2);
                        }
                    }
                    intValue -= i4;
                    String substring = string.substring(i3, i2);
                    n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    obj5 = string.substring(i2);
                    n.e(obj5, "(this as java.lang.String).substring(startIndex)");
                    return n.o(a.e(substring, z2), obj5);
                }
                if (z2) {
                    obj5 = a.b(string);
                } else {
                    obj5 = l.u(string);
                }
            }
        }
        return obj5;
    }

    private static final boolean d(String string, int i2, boolean z3) {
        int obj1;
        int obj2;
        final char obj0 = string.charAt(i2);
        obj1 = 0;
        if (z3 != 0) {
            if (65 <= obj0 && obj0 <= 90) {
                if (obj0 <= 90) {
                    obj1 = 1;
                }
            }
        } else {
            obj1 = Character.isUpperCase(obj0);
        }
        return obj1;
    }

    private static final String e(String string, boolean z2) {
        String obj0;
        String obj1;
        if (z2 != null) {
            obj0 = a.f(string);
        } else {
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            n.e(string.toLowerCase(), "(this as java.lang.String).toLowerCase()");
        }
        return obj0;
    }

    public static final String f(String string) {
        int i;
        char lowerCase;
        int i3;
        int i2;
        n.f(string, "<this>");
        StringBuilder stringBuilder = new StringBuilder(string.length());
        final int i4 = 0;
        i = i4;
        while (i < string.length()) {
            lowerCase = string.charAt(i);
            i++;
            if (65 <= lowerCase && lowerCase <= 90) {
            } else {
            }
            i3 = i4;
            if (i3 != 0) {
            }
            stringBuilder.append(lowerCase);
            lowerCase = Character.toLowerCase(lowerCase);
            if (lowerCase <= 90) {
            } else {
            }
            i3 = 1;
        }
        final String obj6 = stringBuilder.toString();
        n.e(obj6, "builder.toString()");
        return obj6;
    }
}
