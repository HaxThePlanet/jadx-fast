package kotlin.i0.z.e.m0.d.a;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.m.m.a;
import kotlin.k0.l;

/* loaded from: classes3.dex */
public final class x {

    public static final kotlin.i0.z.e.m0.d.a.x a;
    public static final b b;
    static {
        x xVar = new x();
        x.a = xVar;
        b bVar = new b("kotlin.jvm.JvmField");
        x.b = bVar;
        b bVar2 = new b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl");
        n.e(a.m(bVar2), "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
    }

    public static final String a(String string) {
        boolean str;
        Object obj1;
        n.f(string, "propertyName");
        if (x.e(string)) {
        } else {
            obj1 = n.o("get", a.a(string));
        }
        return obj1;
    }

    public static final boolean b(String string) {
        String str;
        int i;
        boolean obj4;
        n.f(string, "name");
        i = 0;
        final int i2 = 2;
        final int i3 = 0;
        if (!l.M(string, "get", i, i2, i3)) {
            if (l.M(string, "is", i, i2, i3)) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    public static final boolean c(String string) {
        n.f(string, "name");
        return l.M(string, "set", false, 2, 0);
    }

    public static final String d(String string) {
        String str;
        String obj1;
        n.f(string, "propertyName");
        if (x.e(string)) {
            n.e(string.substring(2), "(this as java.lang.String).substring(startIndex)");
        } else {
            obj1 = a.a(string);
        }
        return n.o("set", obj1);
    }

    public static final boolean e(String string) {
        int i2;
        int i;
        char obj4;
        n.f(string, "name");
        i = 0;
        final int i4 = 2;
        if (!l.M(string, "is", i, i4, 0)) {
            return i;
        }
        if (string.length() == i4) {
            return i;
        }
        obj4 = string.charAt(i4);
        if (n.h(97, obj4) <= 0) {
            if (n.h(obj4, 122) > 0) {
                i = 1;
            }
        } else {
        }
        return i;
    }
}
