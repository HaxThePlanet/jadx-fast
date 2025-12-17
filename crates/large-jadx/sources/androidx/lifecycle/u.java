package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class u {

    private static Map<Class<?>, Integer> a;
    private static Map<Class<?>, List<Constructor<? extends androidx.lifecycle.h>>> b;
    static {
        HashMap hashMap = new HashMap();
        u.a = hashMap;
        HashMap hashMap2 = new HashMap();
        u.b = hashMap2;
    }

    private static androidx.lifecycle.h a(Constructor<? extends androidx.lifecycle.h> constructor, Object object2) {
        Object[] arr = new Object[1];
        return (h)constructor.newInstance(object2);
    }

    private static Constructor<? extends androidx.lifecycle.h> b(Class<?> class) {
        String name;
        String canonicalName;
        String string;
        int empty;
        boolean stringBuilder;
        try {
            java.lang.Package package = class.getPackage();
            if (package != null) {
            } else {
            }
            name = package.getName();
            name = "";
            final int i2 = 1;
            if (name.isEmpty()) {
            } else {
            }
            canonicalName = class.getCanonicalName().substring(length += i2);
            if (name.isEmpty()) {
            } else {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(name);
            stringBuilder.append(".");
            stringBuilder.append(u.c(canonicalName));
            string = stringBuilder.toString();
            Class[] arr = new Class[i2];
            arr[0] = class;
            final Constructor obj4 = Class.forName(string).getDeclaredConstructor(arr);
            if (!obj4.isAccessible()) {
            }
            obj4.setAccessible(i2);
            return obj4;
            RuntimeException runtimeException = new RuntimeException(class);
            throw runtimeException;
            class = null;
            return class;
        }
    }

    public static String c(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.replace(".", "_"));
        stringBuilder.append("_LifecycleAdapter");
        return stringBuilder.toString();
    }

    private static int d(Class<?> class) {
        Object obj = u.a.get(class);
        if ((Integer)obj != null) {
            return (Integer)obj.intValue();
        }
        int i = u.g(class);
        u.a.put(class, Integer.valueOf(i));
        return i;
    }

    private static boolean e(Class<?> class) {
        Class<androidx.lifecycle.p> obj;
        Class obj1;
        if (class != null && p.class.isAssignableFrom(class)) {
            obj1 = p.class.isAssignableFrom(class) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    static androidx.lifecycle.n f(Object object) {
        int i2;
        int i;
        boolean z = object instanceof n;
        boolean z2 = object instanceof g;
        if (z && z2) {
            if (z2) {
                FullLifecycleObserverAdapter fullLifecycleObserverAdapter2 = new FullLifecycleObserverAdapter((g)object, (n)object);
                return fullLifecycleObserverAdapter2;
            }
        }
        if (z2) {
            FullLifecycleObserverAdapter fullLifecycleObserverAdapter = new FullLifecycleObserverAdapter((g)object, 0);
            return fullLifecycleObserverAdapter;
        }
        if (z) {
            return (n)object;
        }
        Class class = object.getClass();
        Object obj = u.b.get(class);
        if (u.d(class) == 2 && (List)obj.size() == 1) {
            obj = u.b.get(class);
            if ((List)obj.size() == 1) {
                SingleGeneratedAdapterObserver singleGeneratedAdapterObserver = new SingleGeneratedAdapterObserver(u.a((Constructor)obj.get(0), object));
                return singleGeneratedAdapterObserver;
            }
            androidx.lifecycle.h[] arr = new h[obj.size()];
            while (i2 < obj.size()) {
                arr[i2] = u.a((Constructor)obj.get(i2), object);
                i2++;
            }
            CompositeGeneratedAdaptersObserver obj4 = new CompositeGeneratedAdaptersObserver(arr);
            return obj4;
        }
        ReflectiveGenericLifecycleObserver reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(object);
        return reflectiveGenericLifecycleObserver;
    }

    private static int g(Class<?> class) {
        Object superclass;
        int arrayList;
        boolean z;
        int i;
        Object obj;
        Map map;
        int i2 = 1;
        if (class.getCanonicalName() == null) {
            return i2;
        }
        Constructor constructor = u.b(class);
        final int i3 = 2;
        if (constructor != null) {
            u.b.put(class, Collections.singletonList(constructor));
            return i3;
        }
        if (c.c.d(class)) {
            return i2;
        }
        superclass = class.getSuperclass();
        arrayList = 0;
        if (u.e(superclass) && u.d(superclass) == i2) {
            if (u.d(superclass) == i2) {
                return i2;
            }
            arrayList = new ArrayList((Collection)u.b.get(superclass));
        }
        Class[] interfaces = class.getInterfaces();
        i = 0;
        while (i < interfaces.length) {
            obj = interfaces[i];
            if (arrayList == null) {
            }
            arrayList.addAll((Collection)u.b.get(obj));
            i++;
            arrayList = new ArrayList();
        }
        if (arrayList != null) {
            u.b.put(class, arrayList);
            return i3;
        }
        return i2;
    }
}
