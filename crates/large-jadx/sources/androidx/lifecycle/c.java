package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
final class c {

    static androidx.lifecycle.c c;
    private final Map<Class<?>, androidx.lifecycle.c.a> a;
    private final Map<Class<?>, Boolean> b;

    static class a {

        final Map<androidx.lifecycle.j.b, List<androidx.lifecycle.c.b>> a;
        final Map<androidx.lifecycle.c.b, androidx.lifecycle.j.b> b;
        a(Map<androidx.lifecycle.c.b, androidx.lifecycle.j.b> map) {
            HashMap hashMap;
            Object value;
            Object arrayList;
            Map map2;
            super();
            this.b = map;
            hashMap = new HashMap();
            this.a = hashMap;
            Iterator obj5 = map.entrySet().iterator();
            while (obj5.hasNext()) {
                Object next2 = obj5.next();
                value = (Map.Entry)next2.getValue();
                if ((List)this.a.get((j.b)value) == null) {
                }
                arrayList.add(next2.getKey());
                arrayList = new ArrayList();
                this.a.put(value, arrayList);
            }
        }

        private static void b(List<androidx.lifecycle.c.b> list, androidx.lifecycle.q q2, androidx.lifecycle.j.b j$b3, Object object4) {
            int i;
            Object obj;
            if (list != null) {
                size--;
                while (i >= 0) {
                    (c.b)list.get(i).a(q2, b3, object4);
                    i--;
                }
            }
        }

        void a(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2, Object object3) {
            c.a.b((List)this.a.get(b2), q, b2, object3);
            c.a.b((List)this.a.get(j.b.ON_ANY), q, b2, object3);
        }
    }

    static final class b {

        final int a;
        final Method b;
        b(int i, Method method2) {
            super();
            this.a = i;
            this.b = method2;
            method2.setAccessible(true);
        }

        void a(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2, Object object3) {
            int arr2;
            int i;
            int arr;
            Object obj5;
            Object obj6;
            try {
                arr2 = this.a;
                final int i2 = 0;
                if (arr2 != 0) {
                } else {
                }
                i = 1;
                if (arr2 != i) {
                } else {
                }
                arr = 2;
                if (arr2 != arr) {
                } else {
                }
                arr = new Object[arr];
                arr[i2] = q;
                arr[i] = b2;
                this.b.invoke(object3, arr);
                arr2 = new Object[i];
                arr2[i2] = q;
                this.b.invoke(object3, arr2);
                this.b.invoke(object3, new Object[i2]);
                b2 = new RuntimeException(q);
                throw b2;
                q = q.getCause();
                object3 = "Failed to call observer method";
                b2 = new RuntimeException(object3, q);
                throw b2;
            }
        }

        public boolean equals(Object object) {
            int i;
            int name;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof c.b) {
                return i2;
            }
            if (this.a == object.a && this.b.getName().equals(object.b.getName())) {
                if (this.b.getName().equals(object.b.getName())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            return i2 += i4;
        }
    }
    static {
        c cVar = new c();
        c.c = cVar;
    }

    c() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.b = hashMap2;
    }

    private androidx.lifecycle.c.a a(Class<?> class, Method[] method2Arr2) {
        Object superclass;
        int i3;
        int i;
        int i5;
        Iterator iterator;
        boolean annotation;
        Object key;
        int i4;
        Class<androidx.lifecycle.q> length;
        int i2;
        Method[] obj13;
        superclass = class.getSuperclass();
        HashMap hashMap = new HashMap();
        superclass = c(superclass);
        if (superclass != null && superclass != null) {
            superclass = c(superclass);
            if (superclass != null) {
                hashMap.putAll(superclass.b);
            }
        }
        Class[] interfaces = class.getInterfaces();
        final int i6 = 0;
        i = i6;
        while (i < interfaces.length) {
            iterator = aVar.b.entrySet().iterator();
            for (Map.Entry next : iterator) {
                e(hashMap, (c.b)next.getKey(), (j.b)next.getValue(), class);
            }
            i++;
            Object next = iterator.next();
            e(hashMap, (c.b)(Map.Entry)next.getKey(), (j.b)next.getValue(), class);
        }
        if (method2Arr2 != null) {
        } else {
            obj13 = b(class);
        }
        i5 = i3;
        while (i3 < obj13.length) {
            iterator = obj13[i3];
            annotation = iterator.getAnnotation(z.class);
            key = 1;
            Class[] parameterTypes = iterator.getParameterTypes();
            i4 = i6;
            annotation = (z)annotation.value();
            i2 = 2;
            c.b bVar = new c.b(i4, iterator);
            e(hashMap, bVar, annotation, class);
            i5 = key;
            i3++;
            i4 = i2;
            i4 = key;
        }
        obj13 = new c.a(hashMap);
        this.a.put(class, obj13);
        this.b.put(class, Boolean.valueOf(i5));
        return obj13;
    }

    private Method[] b(Class<?> class) {
        try {
            return class.getDeclaredMethods();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", class);
            throw illegalArgumentException;
        }
    }

    private void e(Map<androidx.lifecycle.c.b, androidx.lifecycle.j.b> map, androidx.lifecycle.c.b c$b2, androidx.lifecycle.j.b j$b3, Class<?> class4) {
        final Object obj = map.get(b2);
        if ((j.b)obj != null) {
            if (b3 != (j.b)obj) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(b2.b.getName());
            stringBuilder.append(" in ");
            stringBuilder.append(class4.getName());
            stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous value ");
            stringBuilder.append((j.b)obj);
            stringBuilder.append(", new value ");
            stringBuilder.append(b3);
            IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder.toString());
            throw obj5;
        }
        if (obj == null) {
            map.put(b2, b3);
        }
    }

    androidx.lifecycle.c.a c(Class<?> class) {
        Object obj = this.a.get(class);
        if ((c.a)obj != null) {
            return (c.a)obj;
        }
        return a(class, 0);
    }

    boolean d(Class<?> class) {
        int i;
        java.lang.annotation.Annotation annotation;
        Class<androidx.lifecycle.z> obj;
        Object obj2 = this.b.get(class);
        if ((Boolean)obj2 != null) {
            return (Boolean)obj2.booleanValue();
        }
        Method[] objArr = b(class);
        final int i2 = 0;
        i = i2;
        while (i < objArr.length) {
            i++;
        }
        this.b.put(class, Boolean.FALSE);
        return i2;
    }
}
