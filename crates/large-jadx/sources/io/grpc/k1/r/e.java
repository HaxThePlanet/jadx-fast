package io.grpc.k1.r;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class e<T>  {

    private final Class<?> a;
    private final String b;
    private final Class[] c;
    public e(Class<?> class, String string2, Class... class3Arr3) {
        super();
        this.a = class;
        this.b = string2;
        this.c = class3Arr3;
    }

    private Method a(Class<?> class) {
        String assignableFrom;
        int i;
        Class[] returnType;
        Object obj4;
        assignableFrom = this.b;
        i = 0;
        if (assignableFrom != null) {
            obj4 = e.b(class, assignableFrom, this.c);
            assignableFrom = this.a;
            if (obj4 != null && assignableFrom != null && !assignableFrom.isAssignableFrom(obj4.getReturnType())) {
                assignableFrom = this.a;
                if (assignableFrom != null) {
                    if (!assignableFrom.isAssignableFrom(obj4.getReturnType())) {
                    } else {
                        i = obj4;
                    }
                } else {
                }
            } else {
            }
        }
        return i;
    }

    private static Method b(Class<?> class, String string2, Class[] class3Arr3) {
        Method i;
        if (class == null) {
            return null;
        }
        if (modifiers &= 1 == 0) {
            return e.b(class.getSuperclass(), string2, class3Arr3);
        }
        try {
            Method obj2 = class.getMethod(string2, class3Arr3);
            if (obj3 &= 1 == 0) {
            } else {
            }
            i = obj2;
            return i;
        } catch (java.lang.NoSuchMethodException noSuchMethod) {
        }
    }

    public Object c(T t, Object... object2Arr2) {
        Method method = a(t.getClass());
        if (method == null) {
        } else {
            return method.invoke(t, object2Arr2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Method ");
        stringBuilder.append(this.b);
        stringBuilder.append(" not supported for object ");
        stringBuilder.append(t);
        AssertionError obj5 = new AssertionError(stringBuilder.toString());
        throw obj5;
    }

    public Object d(T t, Object... object2Arr2) {
        Method method = a(t.getClass());
        if (method == null) {
            return null;
        }
        return method.invoke(t, object2Arr2);
    }

    public Object e(T t, Object... object2Arr2) {
        try {
            return d(t, object2Arr2);
            t = t.getTargetException();
            object2Arr2 = t instanceof RuntimeException;
            if (object2Arr2 != null) {
            }
            throw (RuntimeException)t;
            object2Arr2 = new AssertionError("Unexpected exception");
            object2Arr2.initCause(t);
            throw object2Arr2;
        }
    }

    public Object f(T t, Object... object2Arr2) {
        try {
            return c(t, object2Arr2);
            t = t.getTargetException();
            object2Arr2 = t instanceof RuntimeException;
            if (object2Arr2 != null) {
            }
            throw (RuntimeException)t;
            object2Arr2 = new AssertionError("Unexpected exception");
            object2Arr2.initCause(t);
            throw object2Arr2;
        }
    }

    public boolean g(T t) {
        int obj1;
        obj1 = a(t.getClass()) != null ? 1 : 0;
        return obj1;
    }
}
