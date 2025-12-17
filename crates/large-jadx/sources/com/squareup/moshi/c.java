package com.squareup.moshi;

import com.squareup.moshi.v.b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes2.dex */
final class c<T>  extends com.squareup.moshi.f<T> {

    public static final com.squareup.moshi.f.d d;
    private final com.squareup.moshi.b<T> a;
    private final com.squareup.moshi.c.b<?>[] b;
    private final com.squareup.moshi.i.a c;

    static class b {

        final String a;
        final Field b;
        final com.squareup.moshi.f<T> c;
        b(String string, Field field2, com.squareup.moshi.f<T> f3) {
            super();
            this.a = string;
            this.b = field2;
            this.c = f3;
        }

        void a(com.squareup.moshi.i i, Object object2) {
            this.b.set(object2, this.c.b(i));
        }

        void b(com.squareup.moshi.o o, Object object2) {
            this.c.i(o, this.b.get(object2));
        }
    }

    class a implements com.squareup.moshi.f.d {
        private void b(com.squareup.moshi.r r, Type type2, Map<String, com.squareup.moshi.c.b<?>> map3) {
            int i;
            Field field;
            boolean z;
            com.squareup.moshi.c.b bVar;
            String name;
            final Class cls = t.g(type2);
            final Field[] declaredFields = cls.getDeclaredFields();
            i = 0;
            while (i < declaredFields.length) {
                field = declaredFields[i];
                field.setAccessible(true);
                Annotation annotation = field.getAnnotation(e.class);
                if ((e)annotation != null) {
                }
                bVar = new c.b(name, field, r.f(b.n(type2, cls, field.getGenericType()), b.j(field), field.getName()));
                field = map3.put(name, bVar);
                i++;
                name = (e)annotation.name();
            }
        }

        private boolean c(boolean z, int i2) {
            boolean transient;
            int i;
            int obj4;
            i = 0;
            if (!Modifier.isStatic(i2)) {
                if (Modifier.isTransient(i2)) {
                } else {
                    if (!Modifier.isPublic(i2) && !Modifier.isProtected(i2)) {
                        if (!Modifier.isProtected(i2)) {
                            if (!z) {
                                i = 1;
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
            return i;
        }

        private void d(Type type, Class<?> class2) {
            final Class cls = t.g(type);
            if (class2.isAssignableFrom(cls)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No JsonAdapter for ");
            stringBuilder.append(type);
            stringBuilder.append(", you should probably use ");
            stringBuilder.append(class2.getSimpleName());
            stringBuilder.append(" instead of ");
            stringBuilder.append(cls.getSimpleName());
            stringBuilder.append(" (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        public com.squareup.moshi.f<?> a(Type type, Set<? extends Annotation> set2, com.squareup.moshi.r r3) {
            boolean z;
            int i;
            boolean interface;
            Object obj4;
            String obj5;
            boolean obj6;
            i = 0;
            if (!type instanceof Class && !type instanceof ParameterizedType) {
                if (!type instanceof ParameterizedType) {
                    return i;
                }
            }
            Class cls = t.g(type);
            if (!cls.isInterface()) {
                if (cls.isEnum()) {
                } else {
                    if (!set2.isEmpty()) {
                        return i;
                    }
                    if (b.i(cls)) {
                        d(type, List.class);
                        d(type, Set.class);
                        d(type, Map.class);
                        d(type, Collection.class);
                        obj5 = new StringBuilder();
                        obj5.append("Platform ");
                        obj5.append(cls);
                        if (!type instanceof ParameterizedType) {
                        } else {
                            obj6 = new StringBuilder();
                            obj6.append(obj5.toString());
                            obj6.append(" in ");
                            obj6.append(type);
                            obj5 = obj6.toString();
                        }
                        obj6 = new StringBuilder();
                        obj6.append(obj5);
                        obj6.append(" requires explicit JsonAdapter to be registered");
                        obj4 = new IllegalArgumentException(obj6.toString());
                        throw obj4;
                    }
                    if (cls.isAnonymousClass()) {
                    } else {
                        if (cls.isLocalClass()) {
                        } else {
                            if (cls.getEnclosingClass() != null) {
                                if (!Modifier.isStatic(cls.getModifiers())) {
                                } else {
                                }
                                obj5 = new StringBuilder();
                                obj5.append("Cannot serialize non-static nested class ");
                                obj5.append(cls.getName());
                                obj4 = new IllegalArgumentException(obj5.toString());
                                throw obj4;
                            }
                            if (Modifier.isAbstract(cls.getModifiers())) {
                            } else {
                                if (b.h(cls)) {
                                } else {
                                    TreeMap treeMap = new TreeMap();
                                    while (obj4 != Object.class) {
                                        b(r3, obj4, treeMap);
                                        obj4 = t.f(obj4);
                                    }
                                    obj4 = new c(b.a(cls), treeMap);
                                    return obj4.f();
                                }
                                obj5 = new StringBuilder();
                                obj5.append("Cannot serialize Kotlin type ");
                                obj5.append(cls.getName());
                                obj5.append(". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
                                obj4 = new IllegalArgumentException(obj5.toString());
                                throw obj4;
                            }
                            obj5 = new StringBuilder();
                            obj5.append("Cannot serialize abstract class ");
                            obj5.append(cls.getName());
                            obj4 = new IllegalArgumentException(obj5.toString());
                            throw obj4;
                        }
                        obj5 = new StringBuilder();
                        obj5.append("Cannot serialize local class ");
                        obj5.append(cls.getName());
                        obj4 = new IllegalArgumentException(obj5.toString());
                        throw obj4;
                    }
                }
                obj5 = new StringBuilder();
                obj5.append("Cannot serialize anonymous class ");
                obj5.append(cls.getName());
                obj4 = new IllegalArgumentException(obj5.toString());
                throw obj4;
            }
            return i;
        }
    }
    static {
        c.a aVar = new c.a();
        c.d = aVar;
    }

    c(com.squareup.moshi.b<T> b, Map<String, com.squareup.moshi.c.b<?>> map2) {
        super();
        this.a = b;
        this.b = (c.b[])map2.values().toArray(new c.b[map2.size()]);
        this.c = i.a.a((String[])map2.keySet().toArray(new String[map2.size()]));
    }

    public T b(com.squareup.moshi.i i) {
        int i2;
        int i3;
        try {
            Object obj = this.a.b();
            i.c();
            while (i.j()) {
                i2 = i.J(this.c);
                if (i2 == -1) {
                } else {
                }
                this.b[i2].a(i, obj);
                i.T();
                i.U();
            }
            i2 = i.J(this.c);
            if (i2 == -1) {
            } else {
            }
            i.T();
            i.U();
            this.b[i2].a(i, obj);
            i.f();
            return obj;
        } catch (java.lang.IllegalAccessException illegalAccess) {
        }
    }

    public void i(com.squareup.moshi.o o, T t2) {
        int i;
        com.squareup.moshi.c.b bVar;
        String str;
        try {
            o.c();
            final com.squareup.moshi.c.b[] objArr = this.b;
            i = 0;
            while (i < objArr.length) {
                bVar = objArr[i];
                o.m(bVar.a);
                bVar.b(o, t2);
                i++;
            }
            bVar = objArr[i];
            o.m(bVar.a);
            bVar.b(o, t2);
            i++;
            o.i();
            o = new AssertionError();
            throw o;
        }
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonAdapter(");
        stringBuilder.append(this.a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
