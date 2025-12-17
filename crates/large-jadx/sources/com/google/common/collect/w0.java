package com.google.common.collect;

import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class w0 {

    static class a {
    }

    static final class b {

        private final Field a;
        private b(Field field) {
            super();
            this.a = field;
            field.setAccessible(true);
        }

        b(Field field, com.google.common.collect.w0.a w0$a2) {
            super(field);
        }

        void a(T t, int i2) {
            try {
                this.a.set(t, Integer.valueOf(i2));
                i2 = new AssertionError(t);
                throw i2;
            }
        }

        void b(T t, Object object2) {
            try {
                this.a.set(t, object2);
                object2 = new AssertionError(t);
                throw object2;
            }
        }
    }
    static <T> com.google.common.collect.w0.b<T> a(Class<T> class, String string2) {
        try {
            w0.b obj2 = new w0.b(class.getDeclaredField(string2), 0);
            return obj2;
            string2 = new AssertionError(class);
            throw string2;
        }
    }

    static <K, V> void b(com.google.common.collect.i0<K, V> i0, ObjectOutputStream objectOutputStream2) {
        int iterator;
        boolean next;
        int size;
        objectOutputStream2.writeInt(i0.a().size());
        Iterator obj2 = i0.a().entrySet().iterator();
        for (Map.Entry next3 : obj2) {
            objectOutputStream2.writeObject(next3.getKey());
            objectOutputStream2.writeInt((Collection)next3.getValue().size());
            iterator = (Collection)next3.getValue().iterator();
            for (Object size : iterator) {
                objectOutputStream2.writeObject(size);
            }
            objectOutputStream2.writeObject(iterator.next());
        }
    }
}
