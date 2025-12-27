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

/* compiled from: Path.java */
/* loaded from: classes2.dex */
public class j {

    static Pattern a;
    static {
        j.a = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");
    }

    public static String a(a aVar) {
        return j.b(aVar, "");
    }

    private static String b(a aVar, String str) {
        int i;
        boolean equals;
        String type;
        final b parent = aVar.getParent();
        Iterator it = parent.getBoxes().iterator();
        i = 0;
        while (!it.hasNext()) {
            Object item = it.next();
        }
        Object[] arr = new Object[2];
        arr[i] = aVar.getType();
        arr[1] = Integer.valueOf(i);
        String str4 = String.valueOf(String.format("/%s[%d]", arr));
        str = str4 + str;
        if (parent instanceof a) {
            str = j.b(parent, str4 + str);
        }
        return str;
    }

    public static <T extends a> T c(AbstractContainerBox abstractContainerBox, String str) {
        int i = 0;
        List list = j.h(abstractContainerBox, str, true);
        if (list.isEmpty()) {
            i = 0;
        } else {
            Object item = list.get(0);
        }
        return i;
    }

    public static <T extends a> List<T> d(a aVar, String str) {
        return j.e(aVar, str, false);
    }

    private static <T extends a> List<T> e(a aVar, String str, boolean z) {
        return j.i(aVar, str, z);
    }

    public static <T extends a> List<T> f(b bVar, String str) {
        return j.g(bVar, str, false);
    }

    private static <T extends a> List<T> g(b bVar, String str, boolean z) {
        return j.i(bVar, str, z);
    }

    private static <T extends a> List<T> h(AbstractContainerBox abstractContainerBox, String str, boolean z) {
        return j.i(abstractContainerBox, str, z);
    }

    private static <T extends a> List<T> i(Object object, String str, boolean z) {
        int parsed;
        int i = 0;
        String substring2;
        List list;
        boolean empty;
        b parent;
        String substring;
        Object obj;
        str = "/";
        int i3 = 1;
        if (str.startsWith(str)) {
            z = parent instanceof a;
            while (!(parent instanceof a)) {
                parent = parent.getParent();
                z = parent instanceof a;
            }
        }
        if (substring.length() == 0) {
            if (!(parent instanceof a)) {
                throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
            } else {
                return Collections.singletonList(parent);
            }
        }
        i = 0;
        if (substring.contains(str)) {
            int i2 = 47;
            substring2 = substring.substring(substring.indexOf(i2) + i3);
            String substring3 = substring.substring(0, substring.indexOf(i2));
        } else {
            substring2 = "";
        }
        Matcher matcher = j.a.matcher(obj);
        if (!matcher.matches()) {
            String str5 = String.valueOf(obj);
            String str6 = " is invalid path.";
            str = str5 + str6;
            throw new RuntimeException(str);
        } else {
            String group3 = matcher.group(i3);
            if ("..".equals(group3)) {
                if (parent instanceof a) {
                    return j.g(parent.getParent(), substring2, z);
                }
                return Collections.emptyList();
            }
            if (parent instanceof b) {
                parsed = -1;
                if (matcher.group(2) != null) {
                    parsed = Integer.parseInt(matcher.group(3));
                } else {
                }
                LinkedList linkedList = new LinkedList();
                Iterator it = parent.getBoxes().iterator();
                while (!it.hasNext()) {
                    Object item = it.next();
                    if (z || j.a >= 0) {
                    }
                }
                return linkedList;
            }
            return Collections.emptyList();
        }
    }
}
