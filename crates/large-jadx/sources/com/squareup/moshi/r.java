package com.squareup.moshi;

import com.squareup.moshi.v.b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class r {

    static final List<com.squareup.moshi.f.d> d;
    private final List<com.squareup.moshi.f.d> a;
    private final java.lang.ThreadLocal<com.squareup.moshi.r.c> b;
    private final Map<Object, com.squareup.moshi.f<?>> c;

    public static final class a {

        final List<com.squareup.moshi.f.d> a;
        int b = 0;
        public a() {
            super();
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            int i = 0;
        }

        public com.squareup.moshi.r.a a(com.squareup.moshi.f.d f$d) {
            if (d == null) {
            } else {
                final int i = this.b;
                this.b = i + 1;
                this.a.add(i, d);
                return this;
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("factory == null");
            throw obj4;
        }

        public com.squareup.moshi.r b() {
            r rVar = new r(this);
            return rVar;
        }
    }

    final class c {

        final List<com.squareup.moshi.r.b<?>> a;
        final Deque<com.squareup.moshi.r.b<?>> b;
        boolean c;
        final com.squareup.moshi.r d;
        c(com.squareup.moshi.r r) {
            this.d = r;
            super();
            ArrayList obj1 = new ArrayList();
            this.a = obj1;
            obj1 = new ArrayDeque();
            this.b = obj1;
        }

        <T> void a(com.squareup.moshi.f<T> f) {
            last.d = f;
        }

        java.lang.IllegalArgumentException b(java.lang.IllegalArgumentException illegalArgumentException) {
            int i;
            Object next;
            String str;
            if (this.c) {
                return illegalArgumentException;
            }
            i = 1;
            this.c = i;
            if (this.b.size() == i && first.b == null) {
                if (first.b == null) {
                    return illegalArgumentException;
                }
            }
            StringBuilder stringBuilder = new StringBuilder(illegalArgumentException.getMessage());
            Iterator descendingIterator = this.b.descendingIterator();
            while (descendingIterator.hasNext()) {
                next = descendingIterator.next();
                stringBuilder.append("\nfor ");
                stringBuilder.append(next.a);
                if (next.b != null) {
                }
                stringBuilder.append(' ');
                stringBuilder.append(next.b);
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder.toString(), illegalArgumentException);
            return illegalArgumentException2;
        }

        void c(boolean z) {
            int threadLocal;
            int size;
            Object obj3;
            Object obj;
            Object obj2;
            com.squareup.moshi.f fVar;
            Map obj7;
            this.b.removeLast();
            if (!this.b.isEmpty()) {
            }
            r.a(this.d).remove();
            if (z != null) {
                obj7 = r.b(this.d);
                threadLocal = 0;
                synchronized (obj7) {
                    while (threadLocal < this.a.size()) {
                        obj3 = this.a.get(threadLocal);
                        obj = r.b(this.d).put(obj3.c, obj3.d);
                        if ((f)obj != null) {
                        }
                        threadLocal++;
                        obj3.d = (f)obj;
                        r.b(this.d).put(obj3.c, obj);
                    }
                }
            }
        }

        <T> com.squareup.moshi.f<T> d(Type type, String string2, Object object3) {
            int i;
            Object obj;
            boolean equals;
            i = 0;
            while (i < this.a.size()) {
                obj = this.a.get(i);
                i++;
            }
            r.b bVar = new r.b(type, string2, object3);
            this.a.add(bVar);
            this.b.add(bVar);
            return 0;
        }
    }

    static final class b extends com.squareup.moshi.f<T> {

        final Type a;
        final String b;
        final Object c;
        com.squareup.moshi.f<T> d;
        b(Type type, String string2, Object object3) {
            super();
            this.a = type;
            this.b = string2;
            this.c = object3;
        }

        public T b(com.squareup.moshi.i i) {
            com.squareup.moshi.f fVar = this.d;
            if (fVar == null) {
            } else {
                return fVar.b(i);
            }
            IllegalStateException obj2 = new IllegalStateException("JsonAdapter isn't ready");
            throw obj2;
        }

        public void i(com.squareup.moshi.o o, T t2) {
            final com.squareup.moshi.f fVar = this.d;
            if (fVar == null) {
            } else {
                fVar.i(o, t2);
            }
            IllegalStateException obj2 = new IllegalStateException("JsonAdapter isn't ready");
            throw obj2;
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            String string;
            com.squareup.moshi.f fVar = this.d;
            if (fVar != null) {
                string = fVar.toString();
            } else {
                string = super.toString();
            }
            return string;
        }
    }
    static {
        ArrayList arrayList = new ArrayList(5);
        r.d = arrayList;
        arrayList.add(s.a);
        arrayList.add(d.b);
        arrayList.add(q.c);
        arrayList.add(a.c);
        arrayList.add(c.d);
    }

    r(com.squareup.moshi.r.a r$a) {
        super();
        ThreadLocal threadLocal = new ThreadLocal();
        this.b = threadLocal;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.c = linkedHashMap;
        final List list3 = r.d;
        ArrayList arrayList = new ArrayList(size += size2);
        arrayList.addAll(a.a);
        arrayList.addAll(list3);
        this.a = Collections.unmodifiableList(arrayList);
        final int obj5 = a.b;
    }

    static java.lang.ThreadLocal a(com.squareup.moshi.r r) {
        return r.b;
    }

    static Map b(com.squareup.moshi.r r) {
        return r.c;
    }

    private Object g(Type type, Set<? extends Annotation> set2) {
        if (set2.isEmpty()) {
            return type;
        }
        Object[] arr = new Object[2];
        return Arrays.asList(type, set2);
    }

    public <T> com.squareup.moshi.f<T> c(Class<T> class) {
        return e(class, b.a);
    }

    public <T> com.squareup.moshi.f<T> d(Type type) {
        return e(type, b.a);
    }

    public <T> com.squareup.moshi.f<T> e(Type type, Set<? extends Annotation> set2) {
        return f(type, set2, 0);
    }

    public <T> com.squareup.moshi.f<T> f(Type type, Set<? extends Annotation> set2, String string3) {
        Object cVar;
        Object obj;
        int i;
        com.squareup.moshi.f fVar;
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(set2, "annotations == null");
        Type obj5 = b.m(b.a(type));
        Object obj2 = g(obj5, set2);
        Map map = this.c;
        obj = this.c.get(obj2);
        synchronized (map) {
            return (f)obj;
        }
        cVar = new r.c(this);
        this.b.set(cVar);
        com.squareup.moshi.f obj7 = cVar.d(obj5, string3, obj2);
        int i2 = 0;
        if (obj7 != null) {
            cVar.c(i2);
            return obj7;
        }
        i = i2;
        while (i < this.a.size()) {
            fVar = (f.d)this.a.get(i).a(obj5, set2, this);
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No JsonAdapter for ");
        stringBuilder.append(b.r(obj5, set2));
        obj7 = new IllegalArgumentException(stringBuilder.toString());
        throw obj7;
    }
}
