package io.jsonwebtoken.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes3.dex */
public final class Collections {

    private static class EnumerationIterator implements Iterator<E> {

        private Enumeration<E> enumeration;
        public EnumerationIterator(Enumeration<E> enumeration) {
            super();
            this.enumeration = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }

        public E next() {
            return this.enumeration.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not supported");
            throw unsupportedOperationException;
        }
    }
    public static List arrayToList(Object object) {
        return Arrays.asList(Objects.toObjectArray(object));
    }

    public static boolean contains(Enumeration enumeration, Object object2) {
        boolean nullSafeEquals;
        if (enumeration != null) {
        }
        return 0;
    }

    public static boolean contains(Iterator iterator, Object object2) {
        boolean nullSafeEquals;
        if (iterator != null) {
        }
        return 0;
    }

    public static boolean containsAny(Collection collection, Collection collection2) {
        boolean contains;
        Object obj3;
        if (!Collections.isEmpty(collection)) {
            if (Collections.isEmpty(collection2)) {
            } else {
                obj3 = collection2.iterator();
                for (Object next : obj3) {
                }
            }
        }
        return 0;
    }

    public static boolean containsInstance(Collection collection, Object object2) {
        boolean next;
        Iterator obj1;
        if (collection != null) {
            obj1 = collection.iterator();
            for (Object next : obj1) {
            }
        }
        return 0;
    }

    public static Class<?> findCommonElementType(Collection collection) {
        int class;
        Object class2;
        final int i = 0;
        if (Collections.isEmpty(collection)) {
            return i;
        }
        final Iterator obj3 = collection.iterator();
        class = i;
        for (Object class2 : obj3) {
            class = class2.getClass();
        }
        return class;
    }

    public static Object findFirstMatch(Collection collection, Collection collection2) {
        boolean empty;
        boolean contains;
        Object obj4;
        if (!Collections.isEmpty(collection)) {
            if (Collections.isEmpty(collection2)) {
            } else {
                obj4 = collection2.iterator();
                for (Object empty : obj4) {
                }
            }
        }
        return null;
    }

    public static <T> T findValueOfType(Collection<?> collection, Class<T> class2) {
        int i;
        Object next;
        boolean instance;
        final int i2 = 0;
        if (Collections.isEmpty(collection)) {
            return i2;
        }
        final Iterator obj4 = collection.iterator();
        i = i2;
        for (Object next : obj4) {
            i = next;
        }
        return i;
    }

    public static Object findValueOfType(Collection<?> collection, Class<?>[] class2Arr2) {
        boolean length;
        int i;
        Object valueOfType;
        if (!Collections.isEmpty(collection)) {
            if (Objects.isEmpty(class2Arr2)) {
            } else {
                i = 0;
                while (i < class2Arr2.length) {
                    valueOfType = Collections.findValueOfType(collection, class2Arr2[i]);
                    i++;
                }
            }
        }
        return null;
    }

    public static boolean hasUniqueObject(Collection collection) {
        int i3;
        int i;
        Object next;
        int i2;
        final int i4 = 0;
        if (Collections.isEmpty(collection)) {
            return i4;
        }
        i3 = 0;
        final Iterator obj5 = collection.iterator();
        i = i4;
        i2 = 1;
        for (Object next : obj5) {
            i2 = 1;
            i3 = next;
            i = i2;
        }
        return i2;
    }

    public static boolean isEmpty(Collection collection) {
        int obj0;
        if (collection != null) {
            if (collection.isEmpty()) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    public static boolean isEmpty(Map map) {
        int obj0;
        if (map != null) {
            if (map.isEmpty()) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    public static void mergeArrayIntoCollection(Object object, Collection collection2) {
        int i;
        Object obj;
        if (collection2 == null) {
        } else {
            Object[] obj3 = Objects.toObjectArray(object);
            i = 0;
            while (i < obj3.length) {
                collection2.add(obj3[i]);
                i++;
            }
        }
        obj3 = new IllegalArgumentException("Collection must not be null");
        throw obj3;
    }

    public static void mergePropertiesIntoMap(Properties properties, Map map2) {
        Enumeration propertyNames;
        boolean moreElements;
        String property;
        if (map2 == null) {
        } else {
            if (properties != null) {
                propertyNames = properties.propertyNames();
                while (propertyNames.hasMoreElements()) {
                    moreElements = propertyNames.nextElement();
                    if (properties.getProperty((String)moreElements) == null) {
                    }
                    map2.put(moreElements, property);
                    property = properties.get(moreElements);
                }
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Map must not be null");
        throw obj3;
    }

    public static int size(Collection collection) {
        int obj0;
        if (collection == null) {
            obj0 = 0;
        } else {
            obj0 = collection.size();
        }
        return obj0;
    }

    public static int size(Map map) {
        int obj0;
        if (map == null) {
            obj0 = 0;
        } else {
            obj0 = map.size();
        }
        return obj0;
    }

    public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] a2Arr2) {
        Object nextElement;
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList.toArray(a2Arr2);
    }

    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        Collections.EnumerationIterator enumerationIterator = new Collections.EnumerationIterator(enumeration);
        return enumerationIterator;
    }
}
