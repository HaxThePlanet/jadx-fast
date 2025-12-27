package d.f.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import java.nio.CharBuffer;

/* compiled from: Debug.java */
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, int i) throws android.content.res.Resources.NotFoundException {
        if (i != -1) {
            try {
                return context.getResources().getResourceEntryName(i);
            } catch (Exception unused) {
                context = new StringBuilder();
                context.append("?");
                context.append(i);
                context = context.toString();
                return context;
            }
            return str2;
        }
    }

    public static String b(View view) throws android.content.res.Resources.NotFoundException {
        try {
        } catch (Exception unused) {
            view = "UNKNOWN";
            return view;
        }
        return view.getContext().getResources().getResourceEntryName(view.getId());
    }

    public static String c(j jVar, int i) {
        return a.d(jVar, i, -1);
    }

    public static String d(j jVar, int i, int i2) throws android.content.res.Resources.NotFoundException {
        String resourceEntryName;
        i = -1;
        if (i == i) {
            return "UNDEFINED";
        }
        resourceEntryName = jVar.getContext().getResources().getResourceEntryName(i);
        if (i2 != i && resourceEntryName.length() > i2) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
            if (resourceEntryName.length() > i2) {
                int length2 = resourceEntryName.replaceAll("[^_]", "").length();
                if (length2 > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    char c = '.';
                    String replaced2 = CharBuffer.allocate((resourceEntryName.length() - i2) / length2).toString().replace('\0', c);
                    str = "_";
                    str6 = replaced2 + str;
                    resourceEntryName = resourceEntryName.replaceAll(str6, str);
                }
            }
        }
        return resourceEntryName;
    }
}
