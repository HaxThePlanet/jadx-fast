package com.squareup.moshi;

import com.squareup.moshi.v.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ClassFactory.java */
/* loaded from: classes2.dex */
abstract class b<T> {

    class a extends b<T> {

        final /* synthetic */ Constructor a;
        final /* synthetic */ Class b;
        a(Constructor constructor, Class cls) {
            this.a = constructor;
            this.b = cls;
            super();
        }

        @Override // com.squareup.moshi.b
        public T b() throws InvocationTargetException, java.lang.IllegalAccessException, java.lang.InstantiationException {
            return this.a.newInstance(null);
        }

        @Override // com.squareup.moshi.b
        public String toString() {
            return this.b.getName();
        }
    }

    class b extends b<T> {

        final /* synthetic */ Method a;
        final /* synthetic */ Object b;
        final /* synthetic */ Class c;
        b(Method method, Object object, Class cls) {
            this.a = method;
            this.b = object;
            this.c = cls;
            super();
        }

        @Override // com.squareup.moshi.b
        public T b() throws java.lang.IllegalAccessException, InvocationTargetException {
            Object[] arr = new Object[1];
            return this.a.invoke(this.b, new Object[] { this.c });
        }

        @Override // com.squareup.moshi.b
        public String toString() {
            return this.c.getName();
        }
    }

    class c extends b<T> {

        final /* synthetic */ Method a;
        final /* synthetic */ Class b;
        final /* synthetic */ int c;
        c(Method method, Class cls, int i) {
            this.a = method;
            this.b = cls;
            this.c = i;
            super();
        }

        @Override // com.squareup.moshi.b
        public T b() throws InvocationTargetException, java.lang.IllegalAccessException {
            Object[] arr = new Object[2];
            return this.a.invoke(null, new Object[] { this.b, Integer.valueOf(this.c) });
        }

        @Override // com.squareup.moshi.b
        public String toString() {
            return this.b.getName();
        }
    }

    class d extends b<T> {

        final /* synthetic */ Method a;
        final /* synthetic */ Class b;
        d(Method method, Class cls) {
            this.a = method;
            this.b = cls;
            super();
        }

        @Override // com.squareup.moshi.b
        public T b() throws java.lang.IllegalAccessException, InvocationTargetException {
            Object[] arr = new Object[2];
            return this.a.invoke(null, new Object[] { this.b, Object.class });
        }

        @Override // com.squareup.moshi.b
        public String toString() {
            return this.b.getName();
        }
    }
    b() {
        super();
    }

    public static <T> b<T> a(Class<?> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException | java.lang.NoSuchFieldException unused) {
            String arr2 = 2;
        } catch (java.lang.IllegalAccessException unused) {
            cls = new AssertionError();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) cls;
        }
        return new b.a(declaredConstructor, cls);
    }

    abstract T b();
}
