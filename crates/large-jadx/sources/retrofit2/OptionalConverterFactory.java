package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
final class OptionalConverterFactory extends retrofit2.Converter.Factory {

    static final retrofit2.Converter.Factory INSTANCE;

    static final class OptionalConverter implements retrofit2.Converter<ResponseBody, Optional<T>> {

        final retrofit2.Converter<ResponseBody, T> delegate;
        OptionalConverter(retrofit2.Converter<ResponseBody, T> converter) {
            super();
            this.delegate = converter;
        }

        @Override // retrofit2.Converter
        public Object convert(Object object) {
            return convert((ResponseBody)object);
        }

        public Optional<T> convert(ResponseBody responseBody) {
            return Optional.ofNullable(this.delegate.convert(responseBody));
        }
    }
    static {
        OptionalConverterFactory optionalConverterFactory = new OptionalConverterFactory();
        OptionalConverterFactory.INSTANCE = optionalConverterFactory;
    }

    public retrofit2.Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotation2Arr2, retrofit2.Retrofit retrofit3) {
        if (Converter.Factory.getRawType(type) != Optional.class) {
            return 0;
        }
        OptionalConverterFactory.OptionalConverter obj4 = new OptionalConverterFactory.OptionalConverter(retrofit3.responseBodyConverter(Converter.Factory.getParameterUpperBound(0, (ParameterizedType)type), annotation2Arr2));
        return obj4;
    }
}
