package d.f.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import java.nio.CharBuffer;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context, int i2) {
        if (i2 != -1) {
            return context.getResources().getResourceEntryName(i2);
        }
        return "UNKNOWN";
    }

    public static String b(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
            view = "UNKNOWN";
            return view;
        }
    }

    public static String c(d.f.b.b.j j, int i2) {
        return a.d(j, i2, -1);
    }

    public static String d(d.f.b.b.j j, int i2, int i3) {
        int str;
        int i;
        String obj2;
        int obj3;
        int obj4;
        str = -1;
        if (i2 == str) {
            return "UNDEFINED";
        }
        obj2 = j.getContext().getResources().getResourceEntryName(i2);
        if (i3 != str && obj2.length() > i3) {
            if (obj2.length() > i3) {
                obj2 = obj2.replaceAll("([^_])[aeiou]+", "$1");
            }
            obj3 = obj2.replaceAll("[^_]", "").length();
            if (obj2.length() > i3 && obj3 > 0) {
                obj3 = obj2.replaceAll("[^_]", "").length();
                if (obj3 > 0) {
                    obj3 = new StringBuilder();
                    obj3.append(CharBuffer.allocate(i4 /= obj3).toString().replace('\0', '.'));
                    obj4 = "_";
                    obj3.append(obj4);
                    obj2 = obj2.replaceAll(obj3.toString(), obj4);
                }
            }
        }
        return obj2;
    }
}
