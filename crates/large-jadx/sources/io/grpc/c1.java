package io.grpc;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* compiled from: ServiceProviders.java */
/* loaded from: classes2.dex */
final class c1 {

    class a implements Comparator<T> {

        final /* synthetic */ c1.b a;
        a(c1.b bVar) {
            this.a = bVar;
            super();
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            int i2 = this.a.b(t) - this.a.b(t2);
            if (this.a != 0) {
                return i2;
            }
            return t.getClass().getName().compareTo(t2.getClass().getName());
        }
    }

    public interface b<T> {
        boolean a(T t);

        int b(T t);
    }
    static <T> T a(Class<T> cls, Class<?> cls2) {
        final int i2 = 0;
        try {
        } finally {
            int arr3 = 2;
            arr3 = new Object[arr3];
            cls2 = cls2.getName();
            arr3[i] = cls2;
            cls2 = 1;
            arr3[cls2] = cls;
            cls2 = "Provider %s could not be instantiated %s";
            cls2 = String.format(cls2, arr3);
            throw new ServiceConfigurationError(cls2, cls);
        }
        return cls2.asSubclass(cls).getConstructor(new Class[i2]).newInstance(new Object[i2]);
    }

    static <T> Iterable<T> b(Class<T> cls, Iterable<Class<?>> iterable) {
        final ArrayList arrayList = new ArrayList();
        final Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(c1.a(cls, (Class)it.next()));
        }
        return arrayList;
    }

    public static <T> Iterable<T> c(Class<T> cls, java.lang.ClassLoader classLoader) {
        ServiceLoader load;
        if (!ServiceLoader.load(cls, classLoader).iterator().hasNext()) {
            load = ServiceLoader.load(cls);
        }
        return load;
    }

    static boolean d(java.lang.ClassLoader classLoader) throws java.lang.ClassNotFoundException {
        try {
            Class.forName("android.app.Application", false, classLoader);
        } catch (Exception unused) {
            return z;
        }
        return true;
    }

    public static <T> List<T> e(Class<T> cls, Iterable<Class<?>> iterable, java.lang.ClassLoader classLoader, c1.b<T> bVar) {
        if (c1.d(classLoader)) {
            iterable = c1.b(cls, iterable);
        } else {
            iterable = c1.c(cls, classLoader);
        }
        final ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        Collections.sort(arrayList, Collections.reverseOrder(new c1.a(bVar)));
        return Collections.unmodifiableList(arrayList);
    }
}
