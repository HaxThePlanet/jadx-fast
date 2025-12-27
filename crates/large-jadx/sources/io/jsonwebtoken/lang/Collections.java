package io.jsonwebtoken.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: Collections.java */
/* loaded from: classes3.dex */
public final class Collections {

    private static class EnumerationIterator<E> implements Iterator<E> {

        private Enumeration<E> enumeration;
        public EnumerationIterator(Enumeration<E> enumeration) {
            super();
            this.enumeration = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.enumeration.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }
    private Collections() {
        super();
    }

    public static List arrayToList(Object object) {
        return Arrays.asList(Objects.toObjectArray(object));
    }

    public static boolean contains(Iterator it, Object object) {
        if (it != null) {
            while (it.hasNext()) {
                if (Objects.nullSafeEquals(it.next(), object)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsAny(Collection list, Collection list2) {
        return false;
    }

    public static boolean containsInstance(Collection list, Object object) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == object) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Class<?> findCommonElementType(Collection list) {
        int i;
        i = 0;
        if (Collections.isEmpty(list)) {
            return null;
        }
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item != null) {
            }
        }
        return i;
    }

    public static Object findFirstMatch(Collection list, Collection list2) {
        boolean contains;
        return null;
    }

    public static <T> T findValueOfType(Collection<?> collection, Class<T> cls) {
        int i;
        boolean instance;
        i = 0;
        if (Collections.isEmpty(collection)) {
            return null;
        }
        final Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (cls == null || cls.isInstance(item)) {
            }
        }
        return i;
    }

    public static boolean hasUniqueObject(Collection list) {
        int i = 0;
        int i2;
        i2 = 0;
        if (Collections.isEmpty(list)) {
            return false;
        }
        i = 0;
        final Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Object item = it.next();
            if (i2 != 0) {
            }
        }
        return true;
    }

    public static boolean isEmpty(Collection list) {
        boolean z = false;
        if (list == null || list.isEmpty()) {
            int i2 = 1;
        }
        return z;
    }

    public static void mergeArrayIntoCollection(Object object, Collection list) {
        int i = 0;
        if (list == null) {
            throw new IllegalArgumentException("Collection must not be null");
        } else {
            Object[] objectArray = Objects.toObjectArray(object);
            i = 0;
            for (Object obj : objectArray) {
                list.add(obj);
            }
            return;
        }
    }

    public static void mergePropertiesIntoMap(Properties properties, Map map) {
        Object obj;
        String property;
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        } else {
            if (properties != null) {
                Enumeration propertyNames = properties.propertyNames();
                while (propertyNames.hasMoreElements()) {
                    Object nextElement = propertyNames.nextElement();
                    map.put(nextElement, property);
                }
            }
            return;
        }
    }

    public static int size(Collection list) {
        int size = 0;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        return size;
    }

    public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] aArr) {
        final ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList.toArray(aArr);
    }

    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        return new Collections.EnumerationIterator(enumeration);
    }

    public static boolean isEmpty(Map map) {
        boolean z = false;
        if (map == null || map.isEmpty()) {
            int i2 = 1;
        }
        return z;
    }

    public static int size(Map map) {
        int size = 0;
        if (map == null) {
            size = 0;
        } else {
            size = map.size();
        }
        return size;
    }

    public static boolean contains(Enumeration enumeration, Object object) {
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                if (Objects.nullSafeEquals(enumeration.nextElement(), object)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Object findValueOfType(Collection<?> collection, Class<?>[] clsArr) {
        int i = 0;
        Object valueOfType;
        return null;
    }
}
