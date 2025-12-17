package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public interface CallAdapter<R, T>  {

    public static abstract class Factory {
        protected static Type getParameterUpperBound(int i, ParameterizedType parameterizedType2) {
            return Utils.getParameterUpperBound(i, parameterizedType2);
        }

        protected static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public abstract retrofit2.CallAdapter<?, ?> get(Type type, Annotation[] annotation2Arr2, retrofit2.Retrofit retrofit3);
    }
    public abstract T adapt(retrofit2.Call<R> call);

    public abstract Type responseType();
}
