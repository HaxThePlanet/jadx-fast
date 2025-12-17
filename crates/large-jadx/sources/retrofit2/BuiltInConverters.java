package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.w;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
final class BuiltInConverters extends retrofit2.Converter.Factory {

    private boolean checkForKotlinUnit = true;

    static final class BufferingResponseBodyConverter implements retrofit2.Converter<ResponseBody, ResponseBody> {

        static final retrofit2.BuiltInConverters.BufferingResponseBodyConverter INSTANCE;
        static {
            BuiltInConverters.BufferingResponseBodyConverter bufferingResponseBodyConverter = new BuiltInConverters.BufferingResponseBodyConverter();
            BuiltInConverters.BufferingResponseBodyConverter.INSTANCE = bufferingResponseBodyConverter;
        }

        @Override // retrofit2.Converter
        public Object convert(Object object) {
            return convert((ResponseBody)object);
        }

        @Override // retrofit2.Converter
        public ResponseBody convert(ResponseBody responseBody) {
            try {
                responseBody.close();
                return Utils.buffer(responseBody);
                responseBody.close();
                throw th;
            }
        }
    }

    static final class RequestBodyConverter implements retrofit2.Converter<RequestBody, RequestBody> {

        static final retrofit2.BuiltInConverters.RequestBodyConverter INSTANCE;
        static {
            BuiltInConverters.RequestBodyConverter requestBodyConverter = new BuiltInConverters.RequestBodyConverter();
            BuiltInConverters.RequestBodyConverter.INSTANCE = requestBodyConverter;
        }

        @Override // retrofit2.Converter
        public Object convert(Object object) {
            return convert((RequestBody)object);
        }

        @Override // retrofit2.Converter
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    static final class StreamingResponseBodyConverter implements retrofit2.Converter<ResponseBody, ResponseBody> {

        static final retrofit2.BuiltInConverters.StreamingResponseBodyConverter INSTANCE;
        static {
            BuiltInConverters.StreamingResponseBodyConverter streamingResponseBodyConverter = new BuiltInConverters.StreamingResponseBodyConverter();
            BuiltInConverters.StreamingResponseBodyConverter.INSTANCE = streamingResponseBodyConverter;
        }

        @Override // retrofit2.Converter
        public Object convert(Object object) {
            return convert((ResponseBody)object);
        }

        @Override // retrofit2.Converter
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    static final class ToStringConverter implements retrofit2.Converter<Object, String> {

        static final retrofit2.BuiltInConverters.ToStringConverter INSTANCE;
        static {
            BuiltInConverters.ToStringConverter toStringConverter = new BuiltInConverters.ToStringConverter();
            BuiltInConverters.ToStringConverter.INSTANCE = toStringConverter;
        }

        @Override // retrofit2.Converter
        public Object convert(Object object) {
            return convert(object);
        }

        @Override // retrofit2.Converter
        public String convert(Object object) {
            return object.toString();
        }
    }

    static final class UnitResponseBodyConverter implements retrofit2.Converter<ResponseBody, w> {

        static final retrofit2.BuiltInConverters.UnitResponseBodyConverter INSTANCE;
        static {
            BuiltInConverters.UnitResponseBodyConverter unitResponseBodyConverter = new BuiltInConverters.UnitResponseBodyConverter();
            BuiltInConverters.UnitResponseBodyConverter.INSTANCE = unitResponseBodyConverter;
        }

        @Override // retrofit2.Converter
        public Object convert(Object object) {
            return convert((ResponseBody)object);
        }

        @Override // retrofit2.Converter
        public w convert(ResponseBody responseBody) {
            responseBody.close();
            return w.a;
        }
    }

    static final class VoidResponseBodyConverter implements retrofit2.Converter<ResponseBody, Void> {

        static final retrofit2.BuiltInConverters.VoidResponseBodyConverter INSTANCE;
        static {
            BuiltInConverters.VoidResponseBodyConverter voidResponseBodyConverter = new BuiltInConverters.VoidResponseBodyConverter();
            BuiltInConverters.VoidResponseBodyConverter.INSTANCE = voidResponseBodyConverter;
        }

        @Override // retrofit2.Converter
        public Object convert(Object object) {
            return convert((ResponseBody)object);
        }

        @Override // retrofit2.Converter
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }
    BuiltInConverters() {
        super();
        final int i = 1;
    }

    public retrofit2.Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotation2Arr2, Annotation[] annotation3Arr3, retrofit2.Retrofit retrofit4) {
        if (RequestBody.class.isAssignableFrom(Utils.getRawType(type))) {
            return BuiltInConverters.RequestBodyConverter.INSTANCE;
        }
        return 0;
    }

    public retrofit2.Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotation2Arr2, retrofit2.Retrofit retrofit3) {
        Class<ResponseBody> obj1;
        boolean obj2;
        if (type == ResponseBody.class) {
            obj1 = Utils.isAnnotationPresent(annotation2Arr2, Streaming.class) ? BuiltInConverters.StreamingResponseBodyConverter.INSTANCE : BuiltInConverters.BufferingResponseBodyConverter.INSTANCE;
            return obj1;
        }
        if (type == Void.class) {
            return BuiltInConverters.VoidResponseBodyConverter.INSTANCE;
        }
        if (this.checkForKotlinUnit && type == w.class) {
            if (type == w.class) {
                return BuiltInConverters.UnitResponseBodyConverter.INSTANCE;
            }
        }
        return 0;
    }
}
