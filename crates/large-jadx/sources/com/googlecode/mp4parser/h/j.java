package com.googlecode.mp4parser.h;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class j {

    static Pattern a;
    static {
        j.a = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");
    }

    public static String a(a a) {
        return j.b(a, "");
    }

    private static String b(a a, String string2) {
        int i;
        Object next;
        boolean equals;
        String type;
        String obj7;
        final b parent = a.getParent();
        Iterator iterator = parent.getBoxes().iterator();
        int i2 = 0;
        i = i2;
        for (a next : iterator) {
            if (next != a) {
                break;
            }
            i++;
        }
        Object[] arr = new Object[2];
        arr[i2] = a.getType();
        arr[1] = Integer.valueOf(i);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(String.format("/%s[%d]", arr)));
        stringBuilder.append(string2);
        if (parent instanceof a) {
            obj7 = j.b((a)parent, stringBuilder.toString());
        }
        return obj7;
    }

    public static <T extends a> T c(AbstractContainerBox abstractContainerBox, String string2) {
        int obj1;
        boolean obj2;
        obj1 = j.h(abstractContainerBox, string2, true);
        if (obj1.isEmpty()) {
            obj1 = 0;
        } else {
            obj1 = obj1.get(0);
        }
        return obj1;
    }

    public static <T extends a> List<T> d(a a, String string2) {
        return j.e(a, string2, false);
    }

    private static <T extends a> List<T> e(a a, String string2, boolean z3) {
        return j.i(a, string2, z3);
    }

    public static <T extends a> List<T> f(b b, String string2) {
        return j.g(b, string2, false);
    }

    private static <T extends a> List<T> g(b b, String string2, boolean z3) {
        return j.i(b, string2, z3);
    }

    private static <T extends a> List<T> h(AbstractContainerBox abstractContainerBox, String string2, boolean z3) {
        return j.i(abstractContainerBox, string2, z3);
    }

    private static <T extends a> List<T> i(Object object, String string2, boolean z3) {
        boolean indexOf;
        int int;
        boolean startsWith;
        int i;
        String group;
        String substring;
        boolean empty;
        boolean matches;
        Object obj7;
        String obj8;
        String str = "/";
        int i3 = 1;
        if (string2.startsWith(str)) {
            while (!obj7 instanceof a) {
                obj7 = (a)obj7.getParent();
            }
            obj8 = startsWith;
        }
        if (obj8.length() == 0) {
            if (!obj7 instanceof a) {
            } else {
                return Collections.singletonList((a)obj7);
            }
            obj7 = new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
            throw obj7;
        }
        if (obj8.contains(str)) {
            int i2 = 47;
            substring = obj8.substring(indexOf2 += i3);
            obj8 = obj8.substring(0, obj8.indexOf(i2));
        } else {
            substring = "";
        }
        Matcher matcher = j.a.matcher(obj8);
        if (!matcher.matches()) {
        } else {
            obj8 = matcher.group(i3);
            if ("..".equals(obj8) && obj7 instanceof a) {
                if (obj7 instanceof a) {
                    return j.g((a)obj7.getParent(), substring, z3);
                }
                return Collections.emptyList();
            }
            if (obj7 instanceof b) {
                int i6 = -1;
                if (matcher.group(2) != null) {
                    int = Integer.parseInt(matcher.group(3));
                } else {
                    int = i6;
                }
                LinkedList linkedList = new LinkedList();
                obj7 = (b)obj7.getBoxes().iterator();
                while (!obj7.hasNext()) {
                    empty = obj7.next();
                    if ((a)empty.getType().matches(obj8)) {
                    }
                    if (int != i6) {
                    } else {
                    }
                    linkedList.addAll(j.e(empty, substring, z3));
                    i++;
                    if (int == i) {
                    }
                }
                return linkedList;
            }
            return Collections.emptyList();
        }
        StringBuilder obj9 = new StringBuilder(String.valueOf(obj8));
        obj9.append(" is invalid path.");
        obj7 = new RuntimeException(obj9.toString());
        throw obj7;
    }
}
