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

/* compiled from: ClassJsonAdapter.java */
/* loaded from: classes2.dex */
final class c<T> extends f<T> {

    public static final f.d d = new c$a();
    private final b<T> a;
    private final c.b<?>[] b;
    private final i.a c;

    static class b<T> {

        final String a;
        final Field b;
        final f<T> c;
        b(String str, Field field, f<T> fVar) {
            super();
            this.a = str;
            this.b = field;
            this.c = fVar;
        }

        void a(i iVar, Object object) throws java.lang.IllegalAccessException {
            this.b.set(object, this.c.b(iVar));
        }

        void b(o oVar, Object object) throws java.lang.IllegalAccessException {
            this.c.i(oVar, this.b.get(object));
        }
    }

    class a implements f.d {
        a() {
            super();
        }

        private void b(r rVar, Type type, Map<String, c.b<?>> map) throws java.lang.reflect.GenericSignatureFormatError {
            int i = 0;
            Field field;
            boolean z;
            com.squareup.moshi.c.b bVar;
            String name;
            final Class cls = t.g(type);
            final Field[] declaredFields = cls.getDeclaredFields();
            i = 0;
            for (Field field : declaredFields) {
            }
        }

        private boolean c(boolean z, int i) {
            boolean z2 = false;
            boolean _protected;
            i = 0;
            return z2;
        }

        private void d(Type type, Class<?> cls) {
            cls = t.g(type);
            if (cls.isAssignableFrom(cls)) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "No JsonAdapter for ";
                String str2 = ", you should probably use ";
                String simpleName = cls.getSimpleName();
                String str3 = " instead of ";
                String simpleName2 = cls.getSimpleName();
                String str4 = " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.";
                type = str + type + str2 + simpleName + str3 + simpleName2 + str4;
                throw new IllegalArgumentException(type);
            }
        }

        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            Type type2;
            String str;
            z = type instanceof Class;
            int i = 0;
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class cls = t.g(type);
            return i;
        }
    }

    c(b<T> bVar, Map<String, c.b<?>> map) {
        super();
        this.a = bVar;
        this.b = (c.b[])map.values().toArray(new c.b[map.size()]);
        this.c = i.a.a((String[])map.keySet().toArray(new String[map.size()]));
    }

    @Override // com.squareup.moshi.f
    public T b(i iVar) {
        try {
            Object obj = this.a.b();
        } catch (java.lang.IllegalAccessException unused) {
            iVar = new AssertionError();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) iVar;
        }
        try {
            iVar.c();
            while (iVar.j()) {
                int i = iVar.J(this.c);
                com.squareup.moshi.c.b[] objArr = -1;
                if (i == -1) {
                    iVar.T();
                    iVar.U();
                } else {
                    this.b[i].a(iVar, obj);
                }
            }
            iVar.f();
        } catch (java.lang.IllegalAccessException unused) {
            iVar = new AssertionError();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) iVar;
        }
        return obj;
    }

    @Override // com.squareup.moshi.f
    public void i(o oVar, T t) {
        int i = 0;
        try {
            oVar.c();
            i = 0;
            for (com.squareup.moshi.c.b bVar : objArr) {
                oVar.m(bVar.a);
                bVar.b(oVar, t);
            }
            oVar.i();
        } catch (java.lang.IllegalAccessException unused) {
            oVar = new AssertionError();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) oVar;
        }
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "JsonAdapter(";
        String str3 = ")";
        str = str2 + this.a + str3;
        return str;
    }
}
