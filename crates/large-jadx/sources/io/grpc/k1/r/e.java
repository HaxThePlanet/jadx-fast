package io.grpc.k1.r;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod.java */
/* loaded from: classes3.dex */
public class e<T> {

    private final Class<?> a;
    private final String b;
    private final Class[] c;
    public e(Class<?> cls, String str, Class... clsArr) {
        super();
        this.a = cls;
        this.b = str;
        this.c = clsArr;
    }

    private Method a(Class<?> cls) {
        String str;
        int i = 0;
        Class[] objArr;
        i = 0;
        if (this.b != null) {
            Method cls2 = e.b(cls, this.b, this.c);
            if (cls2 != null && this.a != null) {
                if (this.a.isAssignableFrom(cls2.getReturnType())) {
                }
            }
        }
        return i;
    }

    private static Method b(Class<?> cls, String str, Class[] clsArr) {
        int i = 0;
        i = 0;
        if (cls == null) {
            return null;
        }
        try {
            if (cls.getModifiers() & 1 == 0) {
                return e.b(cls.getSuperclass(), str, clsArr);
            }
            Method cls2 = cls.getMethod(str, clsArr);
        } catch (java.lang.NoSuchMethodException unused) {
        }
        try {
        } catch (java.lang.NoSuchMethodException unused) {
        }
        return i;
    }

    public Object c(T t, Object... objectArr) throws InvocationTargetException {
        Method method = a(t.getClass());
        if (method == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Method ";
            String str4 = " not supported for object ";
            t = str2 + this.b + str4 + t;
            throw new AssertionError(t);
        } else {
            try {
            } catch (java.lang.IllegalAccessException illegalAccess) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str5 = "Unexpectedly could not call: ";
                str = str5 + str;
                objectArr = new AssertionError(str);
                objectArr.initCause(illegalAccess);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) objectArr;
            }
            return method.invoke(t, objectArr);
        }
    }

    public Object d(T t, Object... objectArr) throws InvocationTargetException {
        Method method = a(t.getClass());
        if (method == null) {
            return null;
        }
        try {
        } catch (java.lang.IllegalAccessException unused) {
            return obj;
        }
        return method.invoke(t, objectArr);
    }

    public Object e(T t, Object... objectArr) {
        try {
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
            invocationTarget = invocationTarget.getTargetException();
            objectArr = invocationTarget instanceof RuntimeException;
        }
        return d(t, objectArr);
    }

    public Object f(T t, Object... objectArr) {
        try {
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
            invocationTarget = invocationTarget.getTargetException();
            objectArr = invocationTarget instanceof RuntimeException;
        }
        return c(t, objectArr);
    }

    public boolean g(T t) {
        boolean z = true;
        t = a(t.getClass()) != null ? 1 : 0;
        return (a(t.getClass()) != null ? 1 : 0);
    }
}
