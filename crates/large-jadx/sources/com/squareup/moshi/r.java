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

/* compiled from: Moshi.java */
/* loaded from: classes2.dex */
public final class r {

    static final List<f.d> d = new ArrayList<>(5);
    private final List<f.d> a;
    private final java.lang.ThreadLocal<r.c> b = new ThreadLocal<>();
    private final Map<Object, f<?>> c = new LinkedHashMap<>();

    public static final class a {

        final List<f.d> a = new ArrayList<>();
        int b = 0;
        public a() {
            super();
            ArrayList arrayList = new ArrayList();
        }

        public r.a a(f.d dVar) {
            if (dVar == null) {
                throw new IllegalArgumentException("factory == null");
            } else {
                this.b++;
                this.a.add(this.b, dVar);
                return this;
            }
        }

        public r b() {
            return new r(this);
        }
    }

    final class c {

        final List<r.b<?>> a = new ArrayList<>();
        final Deque<r.b<?>> b = new ArrayDeque<>();
        boolean c;
        final /* synthetic */ r d;
        c() {
            this.d = rVar;
            super();
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
        }

        <T> void a(f<T> fVar) {
            (r.b)this.b.getLast().d = fVar;
        }

        java.lang.IllegalArgumentException b(java.lang.IllegalArgumentException exc) {
            if (this.c) {
                return exc;
            }
            boolean z = true;
            this.c = z;
            if (this.b.size() == z && this.b.getFirst().b == null) {
                return exc;
            }
            StringBuilder stringBuilder = new StringBuilder(exc.getMessage());
            Iterator it = this.b.descendingIterator();
            while (it.hasNext()) {
                Object item = it.next();
                stringBuilder.append("\nfor ");
                stringBuilder.append(item.a);
            }
            return new IllegalArgumentException(stringBuilder.toString(), exc);
        }

        void c(boolean z) {
            int i = 0;
            Object item;
            Object obj;
            Object obj2;
            com.squareup.moshi.f fVar;
            this.b.removeLast();
            if (!this.b.isEmpty()) {
                return;
            }
            this.d.b.remove();
            if (z) {
                Map map = this.d.c;
                i = 0;
                synchronized (map) {
                    try {
                        while (this.d.b < this.a.size()) {
                            item = this.a.get(i);
                            obj = this.d.c.put(item.c, item.d);
                            if (obj != null) {
                                item.d = obj;
                                this.d.c.put(item.c, obj);
                            }
                            i = i + 1;
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }

        <T> f<T> d(Type type, String str, Object object) {
            int i = 0;
            Object item;
            i = 0;
            while (i < this.a.size()) {
                item = this.a.get(i);
                if (item.c.equals(object)) {
                    this.b.add(item);
                }
            }
            com.squareup.moshi.r.b bVar = new r.b(type, str, object);
            this.a.add(bVar);
            this.b.add(bVar);
            return null;
        }
    }

    static final class b<T> extends f<T> {

        final Type a;
        final String b;
        final Object c;
        f<T> d;
        b(Type type, String str, Object object) {
            super();
            this.a = type;
            this.b = str;
            this.c = object;
        }

        @Override // com.squareup.moshi.f
        public T b(i iVar) {
            if (this.d == null) {
                throw new IllegalStateException("JsonAdapter isn't ready");
            } else {
                return this.d.b(iVar);
            }
        }

        @Override // com.squareup.moshi.f
        public void i(o oVar, T t) {
            if (this.d == null) {
                throw new IllegalStateException("JsonAdapter isn't ready");
            } else {
                this.d.i(oVar, t);
                return;
            }
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            String object;
            if (this.d != null) {
                object = this.d.toString();
            } else {
                object = super.toString();
            }
            return object;
        }
    }
    static {
        obj.add(s.a);
        obj.add(d.b);
        obj.add(q.c);
        obj.add(a.c);
        obj.add(c.d);
    }

    r(r.a aVar) {
        super();
        java.lang.ThreadLocal threadLocal = new ThreadLocal();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final List list3 = r.d;
        ArrayList arrayList = new ArrayList(aVar.a.size() + list3.size());
        arrayList.addAll(aVar.a);
        arrayList.addAll(list3);
        this.a = Collections.unmodifiableList(arrayList);
    }

    static /* synthetic */ java.lang.ThreadLocal a(r rVar) {
        return rVar.b;
    }

    static /* synthetic */ Map b(r rVar) {
        return rVar.c;
    }

    private Object g(Type type, Set<? extends Annotation> set) {
        if (set.isEmpty()) {
            return type;
        }
        Object[] arr = new Object[2];
        return Arrays.asList(new Object[] { type, set });
    }

    public <T> f<T> c(Class<T> cls) {
        return e(cls, b.a);
    }

    public <T> f<T> d(Type type) {
        return e(type, b.a);
    }

    public <T> f<T> e(Type type, Set<? extends Annotation> set) {
        return f(type, set, null);
    }

    public <T> f<T> f(Type type, Set<? extends Annotation> set, String str) {
        Object obj;
        int i;
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(set, "annotations == null");
        Type type3 = b.m(b.a(type));
        Object obj2 = g(type3, set);
        synchronized (map) {
            try {
                Object value = this.c.get(obj2);
                if (value != null) {
                    return value;
                }
            } catch (Throwable th) {
            } catch (java.lang.IllegalArgumentException iae1) {
            }
        }
        if ((r.c)this.b.get() == null) {
            this.b.set(new r.c(this));
        }
        com.squareup.moshi.f fVar2 = obj.d(type3, str, obj2);
        boolean z = false;
        if (fVar2 != null) {
            obj.c(z);
            return fVar2;
        }
        try {
            while (this.c < this.a.size()) {
                com.squareup.moshi.f fVar = (f.d)this.a.get(i).a(type3, set, this);
                if (fVar != null) {
                    obj.a(fVar);
                } else {
                    i = i + 1;
                    while (this.c < this.a.size()) {
                        fVar = (f.d)this.a.get(this.c).a(type3, set, this);
                        if (fVar != null) {
                            obj.a(fVar);
                        }
                    }
                }
            }
            obj.a(fVar);
        } catch (Throwable th) {
        } catch (java.lang.IllegalArgumentException iae1) {
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "No JsonAdapter for ";
            String str5 = b.r(type3, set);
            iae1 = str4 + str5;
            throw new IllegalArgumentException(iae1);
        } catch (Throwable th) {
        } catch (java.lang.IllegalArgumentException iae1) {
        }
        obj3.c(z2);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) iae1;
    }
}
