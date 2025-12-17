package kotlin.i0.z.e.m0.f;

import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes3.dex */
public final class d {

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[h.BEGINNING.ordinal()] = 1;
            iArr[h.AFTER_DOT.ordinal()] = 2;
            iArr[h.MIDDLE.ordinal()] = 3;
            d.a.a = iArr;
        }
    }
    private static final boolean a(String string, String string2) {
        int i;
        String obj3;
        String obj4;
        if (l.M(string, string2, false, 2, 0) && string.charAt(string2.length()) == 46) {
            if (string.charAt(string2.length()) == 46) {
                i = 1;
            }
        }
        return i;
    }

    public static final boolean b(kotlin.i0.z.e.m0.f.b b, kotlin.i0.z.e.m0.f.b b2) {
        boolean str;
        int i;
        Object obj2;
        Object obj3;
        n.f(b, "<this>");
        n.f(b2, "packageName");
        i = 1;
        if (n.b(b, b2)) {
        } else {
            if (b2.d()) {
            } else {
                obj2 = b.b();
                n.e(obj2, "this.asString()");
                obj3 = b2.b();
                n.e(obj3, "packageName.asString()");
                i = d.a(obj2, obj3);
            }
        }
        return i;
    }

    public static final boolean c(String string) {
        int i2;
        kotlin.i0.z.e.m0.f.h bEGINNING;
        int i4;
        char javaIdentifierPart;
        int i;
        int i3;
        int ordinal;
        i2 = 0;
        if (string == null) {
            return i2;
        }
        bEGINNING = h.BEGINNING;
        i4 = i2;
        i = 1;
        while (i4 < string.length()) {
            javaIdentifierPart = string.charAt(i4);
            i4++;
            i3 = d.a.a[bEGINNING.ordinal()];
            bEGINNING = h.MIDDLE;
            i = 1;
            bEGINNING = h.AFTER_DOT;
        }
        if (bEGINNING != h.AFTER_DOT) {
            i2 = i;
        }
        return i2;
    }

    public static final kotlin.i0.z.e.m0.f.b d(kotlin.i0.z.e.m0.f.b b, kotlin.i0.z.e.m0.f.b b2) {
        boolean bVar;
        String str;
        Object obj2;
        Object obj3;
        n.f(b, "<this>");
        n.f(b2, "prefix");
        if (d.b(b, b2)) {
            if (b2.d()) {
            } else {
                if (n.b(b, b2)) {
                    n.e(b.c, "ROOT");
                } else {
                    obj2 = b.b();
                    n.e(obj2, "asString()");
                    obj2 = obj2.substring(obj3++);
                    n.e(obj2, "(this as java.lang.String).substring(startIndex)");
                    bVar = new b(obj2);
                    obj2 = bVar;
                }
            }
        }
        return obj2;
    }
}
