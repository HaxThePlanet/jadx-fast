package f.g.c;

import f.g.e.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LoggerHelper.java */
/* loaded from: classes2.dex */
class b {
    static String a(String str) {
        String substring;
        if (g.e(str)) {
            return "Zendesk";
        }
        final int i = 23;
        if (str.length() > i) {
            int length = 0;
            substring = str.substring(length, i);
        }
        return substring;
    }

    static List<String> c(String str, int i) {
        int min = 0;
        int indexOf;
        final ArrayList arrayList = new ArrayList();
        String str2 = "";
        if (i < 1) {
            if (!g.c(str)) {
                arrayList.add(str2);
                return arrayList;
            }
            arrayList.add(str);
            return arrayList;
        }
        if (!g.c(str)) {
            arrayList.add(str2);
            return arrayList;
        }
        if (str.length() < i) {
            arrayList.add(str);
            return arrayList;
        }
        min = 0;
        indexOf = str.length();
        while (min < indexOf) {
            min = -1;
            min = Math.min(indexOf, min + i);
            arrayList.add(str.substring(min, min));
            while (min >= g.b) {
                min = Math.min(indexOf, min + i);
                arrayList.add(str.substring(min, min));
            }
            min = min + 1;
        }
        return arrayList;
    }

    static char b(int i) {
        if (i != 2 && i != 3) {
            if (i != 5 && i != 6) {
                if (i != 7) {
                    return 73;
                }
                return 65;
            }
            return 87;
        }
        return 86;
    }
}
