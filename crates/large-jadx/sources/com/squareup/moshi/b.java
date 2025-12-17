package com.squareup.moshi;

import com.squareup.moshi.v.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
abstract class b<T>  {

    class a extends com.squareup.moshi.b<T> {

        final Constructor a;
        final Class b;
        a(Constructor constructor, Class class2) {
            this.a = constructor;
            this.b = class2;
            super();
        }

        public T b() {
            return this.a.newInstance(0);
        }

        @Override // com.squareup.moshi.b
        public String toString() {
            return this.b.getName();
        }
    }

    class b extends com.squareup.moshi.b<T> {

        final Method a;
        final Object b;
        final Class c;
        b(Method method, Object object2, Class class3) {
            this.a = method;
            this.b = object2;
            this.c = class3;
            super();
        }

        public T b() {
            Object[] arr = new Object[1];
            return this.a.invoke(this.b, this.c);
        }

        @Override // com.squareup.moshi.b
        public String toString() {
            return this.c.getName();
        }
    }

    class c extends com.squareup.moshi.b<T> {

        final Method a;
        final Class b;
        final int c;
        c(Method method, Class class2, int i3) {
            this.a = method;
            this.b = class2;
            this.c = i3;
            super();
        }

        public T b() {
            Object[] arr = new Object[2];
            return this.a.invoke(0, this.b, Integer.valueOf(this.c));
        }

        @Override // com.squareup.moshi.b
        public String toString() {
            return this.b.getName();
        }
    }

    class d extends com.squareup.moshi.b<T> {

        final Method a;
        final Class b;
        d(Method method, Class class2) {
            this.a = method;
            this.b = class2;
            super();
        }

        public T b() {
            Object[] arr = new Object[2];
            return this.a.invoke(0, this.b, Object.class);
        }

        @Override // com.squareup.moshi.b
        public String toString() {
            return this.b.getName();
        }
    }
    public static <T> com.squareup.moshi.b<T> a(Class<?> class) {
        final String str = "newInstance";
        Constructor declaredConstructor = class.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        b.a aVar = new b.a(declaredConstructor, class);
        return aVar;
    }

    abstract T b();
}
