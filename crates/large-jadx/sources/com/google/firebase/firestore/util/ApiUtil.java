package com.google.firebase.firestore.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ApiUtil {
    static Object invoke(Method method, Object object2, Object... object3Arr3) {
        try {
            return method.invoke(object2, object3Arr3);
            object2 = new RuntimeException(method);
            throw object2;
            object2 = new RuntimeException(method);
            throw object2;
        }
    }

    public static java.lang.AssertionError newAssertionError(String string, Throwable throwable2) {
        AssertionError assertionError = new AssertionError(string);
        assertionError.initCause(throwable2);
        return assertionError;
    }

    static <T> T newInstance(Constructor<T> constructor) {
        return constructor.newInstance(new Object[0]);
    }
}
