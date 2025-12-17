package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
abstract class j0 {

    private static final com.google.protobuf.j0 a;
    private static final com.google.protobuf.j0 b;

    static class a {
    }

    private static final class b extends com.google.protobuf.j0 {

        private static final Class<?> c;
        static {
            j0.b.c = Collections.unmodifiableList(Collections.emptyList()).getClass();
        }

        private b() {
            super(0);
        }

        b(com.google.protobuf.j0.a j0$a) {
            super();
        }

        static <E> List<E> f(Object object, long l2) {
            return (List)w1.G(object, l2);
        }

        private static <L> List<L> g(Object object, long l2, int i3) {
            Object arrayList;
            boolean arrayList2;
            Class class;
            int obj6;
            arrayList = j0.b.f(object, l2);
            if (arrayList.isEmpty()) {
                if (arrayList instanceof i0) {
                    arrayList = new h0(obj6);
                } else {
                    if (arrayList instanceof e1 && arrayList instanceof c0.j) {
                        if (arrayList instanceof c0.j) {
                            arrayList = obj6;
                        } else {
                            arrayList = new ArrayList(obj6);
                        }
                    } else {
                    }
                }
                w1.V(object, l2, i3);
            } else {
                if (j0.b.c.isAssignableFrom(arrayList.getClass())) {
                    arrayList2 = new ArrayList(size3 += obj6);
                    arrayList2.addAll(arrayList);
                    w1.V(object, l2, i3);
                    arrayList = arrayList2;
                } else {
                }
            }
            return arrayList;
        }

        @Override // com.google.protobuf.j0
        void c(Object object, long l2) {
            List unmodifiableList;
            boolean z;
            Class class;
            Object obj = w1.G(object, l2);
            if (obj instanceof i0) {
                unmodifiableList = (i0)(List)obj.n();
            } else {
                if (j0.b.c.isAssignableFrom(obj.getClass())) {
                }
                if (obj instanceof e1 && obj instanceof c0.j && (c0.j)obj.c2()) {
                    if (obj instanceof c0.j) {
                        if ((c0.j)obj.c2()) {
                            obj.F();
                        }
                    }
                }
                unmodifiableList = Collections.unmodifiableList(obj);
            }
            w1.V(object, l2, obj6);
        }

        <E> void d(Object object, Object object2, long l3) {
            List obj5;
            obj5 = j0.b.f(object2, l3);
            List list = j0.b.g(object, l3, obj7);
            final int size2 = list.size();
            if (size2 > 0 && obj5.size() > 0) {
                if (obj5.size() > 0) {
                    list.addAll(obj5);
                }
            }
            if (size2 > 0) {
                obj5 = list;
            }
            w1.V(object, l3, obj7);
        }

        <L> List<L> e(Object object, long l2) {
            return j0.b.g(object, l2, obj4);
        }
    }

    private static final class c extends com.google.protobuf.j0 {
        private c() {
            super(0);
        }

        c(com.google.protobuf.j0.a j0$a) {
            super();
        }

        static <E> com.google.protobuf.c0.j<E> f(Object object, long l2) {
            return (c0.j)w1.G(object, l2);
        }

        @Override // com.google.protobuf.j0
        void c(Object object, long l2) {
            j0.c.f(object, l2).F();
        }

        <E> void d(Object object, Object object2, long l3) {
            com.google.protobuf.c0.j jVar;
            int size;
            boolean z;
            com.google.protobuf.c0.j obj6;
            jVar = j0.c.f(object, l3);
            obj6 = j0.c.f(object2, l3);
            final int size2 = jVar.size();
            size = obj6.size();
            if (size2 > 0 && size > 0 && !jVar.c2()) {
                if (size > 0) {
                    if (!jVar.c2()) {
                        jVar = jVar.c(size += size2);
                    }
                    jVar.addAll(obj6);
                }
            }
            if (size2 > 0) {
                obj6 = jVar;
            }
            w1.V(object, l3, obj8);
        }

        <L> List<L> e(Object object, long l2) {
            com.google.protobuf.c0.j jVar;
            int z;
            jVar = j0.c.f(object, l2);
            if (!jVar.c2()) {
                int size = jVar.size();
                z = size == 0 ? 10 : size * 2;
                w1.V(object, l2, obj5);
            }
            return jVar;
        }
    }
    static {
        final int i = 0;
        j0.b bVar = new j0.b(i);
        j0.a = bVar;
        j0.c cVar = new j0.c(i);
        j0.b = cVar;
    }

    j0(com.google.protobuf.j0.a j0$a) {
        super();
    }

    static com.google.protobuf.j0 a() {
        return j0.a;
    }

    static com.google.protobuf.j0 b() {
        return j0.b;
    }

    abstract void c(Object object, long l2);

    abstract <L> void d(Object object, Object object2, long l3);

    abstract <L> List<L> e(Object object, long l2);
}
