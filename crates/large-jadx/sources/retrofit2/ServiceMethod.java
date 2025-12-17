package retrofit2;

import java.lang.reflect.Method;

/* loaded from: classes3.dex */
abstract class ServiceMethod<T>  {
    static <T> retrofit2.ServiceMethod<T> parseAnnotations(retrofit2.Retrofit retrofit, Method method2) {
        final java.lang.reflect.Type genericReturnType = method2.getGenericReturnType();
        final int i = 0;
        if (Utils.hasUnresolvableType(genericReturnType)) {
        } else {
            if (genericReturnType == Void.TYPE) {
            } else {
                return HttpServiceMethod.parseAnnotations(retrofit, method2, RequestFactory.parseAnnotations(retrofit, method2));
            }
            throw Utils.methodError(method2, "Service methods cannot return void.", new Object[i]);
        }
        Object[] obj4 = new Object[1];
        obj4[i] = genericReturnType;
        throw Utils.methodError(method2, "Method return type must not include a type variable or wildcard: %s", obj4);
    }

    abstract T invoke(Object[] objectArr);
}
