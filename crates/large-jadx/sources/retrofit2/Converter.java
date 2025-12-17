package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public interface Converter<F, T>  {

    public static abstract class Factory {
        protected static Type getParameterUpperBound(int i, ParameterizedType parameterizedType2) {
            return Utils.getParameterUpperBound(i, parameterizedType2);
        }

        protected static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public retrofit2.Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotation2Arr2, Annotation[] annotation3Arr3, retrofit2.Retrofit retrofit4) {
            return 0;
        }

        public retrofit2.Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotation2Arr2, retrofit2.Retrofit retrofit3) {
            return 0;
        }

        public retrofit2.Converter<?, String> stringConverter(Type type, Annotation[] annotation2Arr2, retrofit2.Retrofit retrofit3) {
            return 0;
        }
    }
    public abstract T convert(F f);
}
