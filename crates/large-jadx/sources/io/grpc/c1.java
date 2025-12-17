package io.grpc;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* loaded from: classes2.dex */
final class c1 {

    class a implements Comparator<T> {

        final io.grpc.c1.b a;
        a(io.grpc.c1.b c1$b) {
            this.a = b;
            super();
        }

        public int compare(T t, T t2) {
            i -= i3;
            if (i2 != 0) {
                return i2;
            }
            return t.getClass().getName().compareTo(t2.getClass().getName());
        }
    }

    public interface b {
        public abstract boolean a(T t);

        public abstract int b(T t);
    }
    static <T> T a(Class<T> class, Class<?> class2) {
        final int i = 0;
        return class2.asSubclass(class).getConstructor(new Class[i]).newInstance(new Object[i]);
    }

    static <T> Iterable<T> b(Class<T> class, Iterable<Class<?>> iterable2) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        final Iterator obj3 = iterable2.iterator();
        for (Class next2 : obj3) {
            arrayList.add(c1.a(class, next2));
        }
        return arrayList;
    }

    public static <T> Iterable<T> c(Class<T> class, java.lang.ClassLoader classLoader2) {
        ServiceLoader obj2;
        if (!ServiceLoader.load(class, classLoader2).iterator().hasNext()) {
            obj2 = ServiceLoader.load(class);
        }
        return obj2;
    }

    static boolean d(java.lang.ClassLoader classLoader) {
        Class.forName("android.app.Application", false, classLoader);
        return 1;
    }

    public static <T> List<T> e(Class<T> class, Iterable<Class<?>> iterable2, java.lang.ClassLoader classLoader3, io.grpc.c1.b<T> c1$b4) {
        boolean z;
        Iterable obj1;
        java.lang.ClassLoader obj3;
        if (c1.d(classLoader3)) {
            obj1 = c1.b(class, iterable2);
        } else {
            obj1 = c1.c(class, classLoader3);
        }
        ArrayList obj2 = new ArrayList();
        obj1 = obj1.iterator();
        while (obj1.hasNext()) {
            obj3 = obj1.next();
            if (!b4.a(obj3)) {
            } else {
            }
            obj2.add(obj3);
        }
        obj1 = new c1.a(b4);
        Collections.sort(obj2, Collections.reverseOrder(obj1));
        return Collections.unmodifiableList(obj2);
    }
}
