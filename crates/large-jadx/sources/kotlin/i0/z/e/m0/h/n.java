package kotlin.i0.z.e.m0.h;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class n {
    public static final String a(c c) {
        n.f(c, "<this>");
        List obj1 = c.h();
        n.e(obj1, "pathSegments()");
        return n.c(obj1);
    }

    public static final String b(e e) {
        String str;
        Object stringBuilder;
        String obj2;
        n.f(e, "<this>");
        stringBuilder = "asString()";
        if (n.d(e)) {
            obj2 = e.c();
            n.e(obj2, stringBuilder);
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf('`'));
            stringBuilder.append(obj2);
            obj2 = n.o(stringBuilder.toString(), "`");
        } else {
            n.e(e.c(), stringBuilder);
        }
        return obj2;
    }

    public static final String c(List<e> list) {
        String str;
        int length;
        n.f(list, "pathSegments");
        StringBuilder stringBuilder = new StringBuilder();
        Iterator obj3 = list.iterator();
        while (obj3.hasNext()) {
            if (stringBuilder.length() > 0) {
            }
            stringBuilder.append(n.b((e)obj3.next()));
            stringBuilder.append(".");
        }
        obj3 = stringBuilder.toString();
        n.e(obj3, "StringBuilder().apply(builderAction).toString()");
        return obj3;
    }

    private static final boolean d(e e) {
        int contains;
        int i;
        int length;
        int letterOrDigit;
        int obj5;
        i = 0;
        if (e.k()) {
            return i;
        }
        obj5 = e.c();
        n.e(obj5, "asString()");
        final int i2 = 1;
        if (!i.a.contains(obj5)) {
            contains = i;
            while (contains < obj5.length()) {
                char charAt = obj5.charAt(contains);
                if (!Character.isLetterOrDigit(charAt) && charAt != 95) {
                } else {
                }
                length = i;
                contains++;
                if (charAt != 95) {
                } else {
                }
                length = i2;
            }
            obj5 = i;
            if (obj5 != null) {
                i = i2;
            }
        } else {
        }
        return i;
    }
}
