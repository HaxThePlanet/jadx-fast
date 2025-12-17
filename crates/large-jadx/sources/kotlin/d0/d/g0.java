package kotlin.d0.d;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class g0 {
    public static Collection a(Object object) {
        boolean z;
        if (object instanceof a) {
            if (!object instanceof b) {
            } else {
            }
            g0.n(object, "kotlin.collections.MutableCollection");
            throw 0;
        }
        return g0.f(object);
    }

    public static List b(Object object) {
        boolean z;
        if (object instanceof a) {
            if (!object instanceof c) {
            } else {
            }
            g0.n(object, "kotlin.collections.MutableList");
            throw 0;
        }
        return g0.g(object);
    }

    public static Map c(Object object) {
        boolean z;
        if (object instanceof a) {
            if (!object instanceof d) {
            } else {
            }
            g0.n(object, "kotlin.collections.MutableMap");
            throw 0;
        }
        return g0.h(object);
    }

    public static Set d(Object object) {
        boolean z;
        if (object instanceof a) {
            if (!object instanceof e) {
            } else {
            }
            g0.n(object, "kotlin.collections.MutableSet");
            throw 0;
        }
        return g0.i(object);
    }

    public static Object e(Object object, int i2) {
        boolean z;
        if (object != null) {
            if (!g0.k(object, i2)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.jvm.functions.Function");
            stringBuilder.append(i2);
            g0.n(object, stringBuilder.toString());
            throw 0;
        }
        return object;
    }

    public static Collection f(Object object) {
        try {
            return (Collection)object;
            g0.m(object);
            object = null;
            throw object;
        }
    }

    public static List g(Object object) {
        try {
            return (List)object;
            g0.m(object);
            object = null;
            throw object;
        }
    }

    public static Map h(Object object) {
        try {
            return (Map)object;
            g0.m(object);
            object = null;
            throw object;
        }
    }

    public static Set i(Object object) {
        try {
            return (Set)object;
            g0.m(object);
            object = null;
            throw object;
        }
    }

    public static int j(Object object) {
        if (object instanceof i) {
            return (i)object.getArity();
        }
        if (object instanceof a) {
            return 0;
        }
        if (object instanceof l) {
            return 1;
        }
        if (object instanceof p) {
            return 2;
        }
        if (object instanceof q) {
            return 3;
        }
        if (object instanceof r) {
            return 4;
        }
        if (object instanceof s) {
            return 5;
        }
        if (object instanceof t) {
            return 6;
        }
        if (object instanceof u) {
            return 7;
        }
        if (object instanceof v) {
            return 8;
        }
        if (object instanceof w) {
            return 9;
        }
        if (object instanceof b) {
            return 10;
        }
        if (object instanceof c) {
            return 11;
        }
        if (object instanceof d) {
            return 12;
        }
        if (object instanceof e) {
            return 13;
        }
        if (object instanceof f) {
            return 14;
        }
        if (object instanceof g) {
            return 15;
        }
        if (object instanceof h) {
            return 16;
        }
        if (object instanceof i) {
            return 17;
        }
        if (object instanceof j) {
            return 18;
        }
        if (object instanceof k) {
            return 19;
        }
        if (object instanceof m) {
            return 20;
        }
        if (object instanceof n) {
            return 21;
        }
        if (object instanceof o) {
            return 22;
        }
        return -1;
    }

    public static boolean k(Object object, int i2) {
        Object obj1;
        if (object instanceof d && g0.j(object) == i2) {
            obj1 = g0.j(object) == i2 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static <T extends Throwable> T l(T t) {
        n.n(t, g0.class.getName());
        return t;
    }

    public static java.lang.ClassCastException m(java.lang.ClassCastException classCastException) {
        g0.l(classCastException);
        throw (ClassCastException)classCastException;
    }

    public static void n(Object object, String string2) {
        String obj1;
        if (object == null) {
            obj1 = "null";
        } else {
            obj1 = object.getClass().getName();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj1);
        stringBuilder.append(" cannot be cast to ");
        stringBuilder.append(string2);
        g0.o(stringBuilder.toString());
        throw 0;
    }

    public static void o(String string) {
        ClassCastException classCastException = new ClassCastException(string);
        g0.m(classCastException);
        throw 0;
    }
}
