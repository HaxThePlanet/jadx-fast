package androidx.fragment.app;

import d.e.g;

/* loaded from: classes.dex */
public class j {

    private static final g<java.lang.ClassLoader, g<String, Class<?>>> a;
    static {
        g gVar = new g();
        j.a = gVar;
    }

    static boolean b(java.lang.ClassLoader classLoader, String string2) {
        try {
            return Fragment.class.isAssignableFrom(j.c(classLoader, string2));
            classLoader = null;
            return classLoader;
        }
    }

    private static Class<?> c(java.lang.ClassLoader classLoader, String string2) {
        Object forName;
        Object gVar;
        g gVar2 = j.a;
        if ((g)gVar2.get(classLoader) == null) {
            gVar = new g();
            gVar2.put(classLoader, gVar);
        }
        if ((Class)gVar.get(string2) == null) {
            gVar.put(string2, Class.forName(string2, false, classLoader));
        }
        return forName;
    }

    public static Class<? extends androidx.fragment.app.Fragment> d(java.lang.ClassLoader classLoader, String string2) {
        final String str = "Unable to instantiate fragment ";
        return j.c(classLoader, string2);
    }

    public androidx.fragment.app.Fragment a(java.lang.ClassLoader classLoader, String string2) {
        throw 0;
    }
}
