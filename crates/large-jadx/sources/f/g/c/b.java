package f.g.c;

import f.g.e.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class b {
    static String a(String string) {
        int length;
        String obj2;
        if (g.e(string)) {
            return "Zendesk";
        }
        final int i = 23;
        if (string.length() > i) {
            obj2 = string.substring(0, i);
        }
        return obj2;
    }

    static char b(int i) {
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 7) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            return 73;
                        }
                        return 65;
                    }
                    return 69;
                }
                return 87;
            }
            return 68;
        }
        return 86;
    }

    static List<String> c(String string, int i2) {
        int i3;
        int indexOf;
        int i;
        ArrayList arrayList = new ArrayList();
        String str = "";
        if (i2 < 1 && !g.c(string)) {
            if (!g.c(string)) {
                arrayList.add(str);
                return arrayList;
            }
            arrayList.add(string);
            return arrayList;
        }
        if (!g.c(string)) {
            arrayList.add(str);
            return arrayList;
        }
        if (string.length() < i2) {
            arrayList.add(string);
            return arrayList;
        }
        i3 = 0;
        int length2 = string.length();
        while (i3 < length2) {
            if (string.indexOf(g.b, i3) != -1) {
            } else {
            }
            indexOf = length2;
            i = Math.min(indexOf, i3 + i2);
            arrayList.add(string.substring(i3, i));
            while (i >= indexOf) {
                i3 = i;
                i = Math.min(indexOf, i3 + i2);
                arrayList.add(string.substring(i3, i));
            }
            i3 = i;
            i3 = i + 1;
        }
        return arrayList;
    }
}
