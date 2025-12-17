package retrofit2;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
abstract class ParameterHandler<T>  {

    static final class Body extends retrofit2.ParameterHandler<T> {

        private final retrofit2.Converter<T, RequestBody> converter;
        private final Method method;
        private final int p;
        Body(Method method, int i2, retrofit2.Converter<T, RequestBody> converter3) {
            super();
            this.method = method;
            this.p = i2;
            this.converter = converter3;
        }

        void apply(retrofit2.RequestBuilder requestBuilder, T t2) {
            if (t2 == null) {
            } else {
                requestBuilder.setBody((RequestBody)this.converter.convert(t2));
            }
            try {
                throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    static final class Field extends retrofit2.ParameterHandler<T> {

        private final boolean encoded;
        private final String name;
        private final retrofit2.Converter<T, String> valueConverter;
        Field(String string, retrofit2.Converter<T, String> converter2, boolean z3) {
            super();
            Objects.requireNonNull(string, "name == null");
            this.name = (String)string;
            this.valueConverter = converter2;
            this.encoded = z3;
        }

        void apply(retrofit2.RequestBuilder requestBuilder, T t2) {
            if (t2 == null) {
            }
            final Object obj4 = this.valueConverter.convert(t2);
            if ((String)obj4 == null) {
            }
            requestBuilder.addFormField(this.name, (String)obj4, this.encoded);
        }
    }

    static final class FieldMap extends retrofit2.ParameterHandler<Map<String, T>> {

        private final boolean encoded;
        private final Method method;
        private final int p;
        private final retrofit2.Converter<T, String> valueConverter;
        FieldMap(Method method, int i2, retrofit2.Converter<T, String> converter3, boolean z4) {
            super();
            this.method = method;
            this.p = i2;
            this.valueConverter = converter3;
            this.encoded = z4;
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, Object object2) {
            apply(requestBuilder, (Map)object2);
        }

        void apply(retrofit2.RequestBuilder requestBuilder, Map<String, T> map2) {
            boolean encoded;
            Object key;
            String str;
            Object convert;
            int i = 0;
            if (map2 == null) {
            } else {
                Iterator obj8 = map2.entrySet().iterator();
                for (Map.Entry next2 : obj8) {
                    key = next2.getKey();
                    Object value = next2.getValue();
                    str = "'.";
                    convert = this.valueConverter.convert(value);
                    requestBuilder.addFormField((String)key, (String)convert, this.encoded);
                }
            }
            throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[i]);
        }
    }

    static final class Header extends retrofit2.ParameterHandler<T> {

        private final String name;
        private final retrofit2.Converter<T, String> valueConverter;
        Header(String string, retrofit2.Converter<T, String> converter2) {
            super();
            Objects.requireNonNull(string, "name == null");
            this.name = (String)string;
            this.valueConverter = converter2;
        }

        void apply(retrofit2.RequestBuilder requestBuilder, T t2) {
            if (t2 == null) {
            }
            final Object obj3 = this.valueConverter.convert(t2);
            if ((String)obj3 == null) {
            }
            requestBuilder.addHeader(this.name, (String)obj3);
        }
    }

    static final class HeaderMap extends retrofit2.ParameterHandler<Map<String, T>> {

        private final Method method;
        private final int p;
        private final retrofit2.Converter<T, String> valueConverter;
        HeaderMap(Method method, int i2, retrofit2.Converter<T, String> converter3) {
            super();
            this.method = method;
            this.p = i2;
            this.valueConverter = converter3;
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, Object object2) {
            apply(requestBuilder, (Map)object2);
        }

        void apply(retrofit2.RequestBuilder requestBuilder, Map<String, T> map2) {
            Object convert;
            Object key;
            retrofit2.Converter valueConverter;
            int i = 0;
            if (map2 == null) {
            } else {
                Iterator obj6 = map2.entrySet().iterator();
                for (Map.Entry next2 : obj6) {
                    key = next2.getKey();
                    Object value = next2.getValue();
                    requestBuilder.addHeader((String)key, (String)this.valueConverter.convert(value));
                }
            }
            throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[i]);
        }
    }

    static final class Headers extends retrofit2.ParameterHandler<Headers> {

        private final Method method;
        private final int p;
        Headers(Method method, int i2) {
            super();
            this.method = method;
            this.p = i2;
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, Object object2) {
            apply(requestBuilder, (Headers)object2);
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, Headers headers2) {
            if (headers2 == null) {
            } else {
                requestBuilder.addHeaders(headers2);
            }
            throw Utils.parameterError(this.method, this.p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    static final class Part extends retrofit2.ParameterHandler<T> {

        private final retrofit2.Converter<T, RequestBody> converter;
        private final Headers headers;
        private final Method method;
        private final int p;
        Part(Method method, int i2, Headers headers3, retrofit2.Converter<T, RequestBody> converter4) {
            super();
            this.method = method;
            this.p = i2;
            this.headers = headers3;
            this.converter = converter4;
        }

        void apply(retrofit2.RequestBuilder requestBuilder, T t2) {
            if (t2 == null) {
            }
            requestBuilder.addPart(this.headers, (RequestBody)this.converter.convert(t2));
        }
    }

    static final class PartMap extends retrofit2.ParameterHandler<Map<String, T>> {

        private final Method method;
        private final int p;
        private final String transferEncoding;
        private final retrofit2.Converter<T, RequestBody> valueConverter;
        PartMap(Method method, int i2, retrofit2.Converter<T, RequestBody> converter3, String string4) {
            super();
            this.method = method;
            this.p = i2;
            this.valueConverter = converter3;
            this.transferEncoding = string4;
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, Object object2) {
            apply(requestBuilder, (Map)object2);
        }

        void apply(retrofit2.RequestBuilder requestBuilder, Map<String, T> map2) {
            Object convert;
            Headers headers;
            retrofit2.Converter valueConverter;
            String transferEncoding;
            StringBuilder stringBuilder;
            String str;
            int i = 0;
            if (map2 == null) {
            } else {
                Iterator obj9 = map2.entrySet().iterator();
                for (Map.Entry next2 : obj9) {
                    Object key = next2.getKey();
                    Object value = next2.getValue();
                    String[] strArr = new String[4];
                    strArr[i] = "Content-Disposition";
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("form-data; name=\"");
                    stringBuilder.append((String)key);
                    stringBuilder.append("\"");
                    strArr[1] = stringBuilder.toString();
                    strArr[2] = "Content-Transfer-Encoding";
                    strArr[3] = this.transferEncoding;
                    requestBuilder.addPart(Headers.of(strArr), (RequestBody)this.valueConverter.convert(value));
                }
            }
            throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[i]);
        }
    }

    static final class Path extends retrofit2.ParameterHandler<T> {

        private final boolean encoded;
        private final Method method;
        private final String name;
        private final int p;
        private final retrofit2.Converter<T, String> valueConverter;
        Path(Method method, int i2, String string3, retrofit2.Converter<T, String> converter4, boolean z5) {
            super();
            this.method = method;
            this.p = i2;
            Objects.requireNonNull(string3, "name == null");
            this.name = (String)string3;
            this.valueConverter = converter4;
            this.encoded = z5;
        }

        void apply(retrofit2.RequestBuilder requestBuilder, T t2) {
            if (t2 == null) {
            } else {
                requestBuilder.addPathParam(this.name, (String)this.valueConverter.convert(t2), this.encoded);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Path parameter \"");
            stringBuilder.append(this.name);
            stringBuilder.append("\" value must not be null.");
            throw Utils.parameterError(this.method, this.p, stringBuilder.toString(), new Object[0]);
        }
    }

    static final class Query extends retrofit2.ParameterHandler<T> {

        private final boolean encoded;
        private final String name;
        private final retrofit2.Converter<T, String> valueConverter;
        Query(String string, retrofit2.Converter<T, String> converter2, boolean z3) {
            super();
            Objects.requireNonNull(string, "name == null");
            this.name = (String)string;
            this.valueConverter = converter2;
            this.encoded = z3;
        }

        void apply(retrofit2.RequestBuilder requestBuilder, T t2) {
            if (t2 == null) {
            }
            final Object obj4 = this.valueConverter.convert(t2);
            if ((String)obj4 == null) {
            }
            requestBuilder.addQueryParam(this.name, (String)obj4, this.encoded);
        }
    }

    static final class QueryMap extends retrofit2.ParameterHandler<Map<String, T>> {

        private final boolean encoded;
        private final Method method;
        private final int p;
        private final retrofit2.Converter<T, String> valueConverter;
        QueryMap(Method method, int i2, retrofit2.Converter<T, String> converter3, boolean z4) {
            super();
            this.method = method;
            this.p = i2;
            this.valueConverter = converter3;
            this.encoded = z4;
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, Object object2) {
            apply(requestBuilder, (Map)object2);
        }

        void apply(retrofit2.RequestBuilder requestBuilder, Map<String, T> map2) {
            boolean encoded;
            Object key;
            String str;
            Object convert;
            int i = 0;
            if (map2 == null) {
            } else {
                Iterator obj8 = map2.entrySet().iterator();
                for (Map.Entry next2 : obj8) {
                    key = next2.getKey();
                    Object value = next2.getValue();
                    str = "'.";
                    convert = this.valueConverter.convert(value);
                    requestBuilder.addQueryParam((String)key, (String)convert, this.encoded);
                }
            }
            throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[i]);
        }
    }

    static final class QueryName extends retrofit2.ParameterHandler<T> {

        private final boolean encoded;
        private final retrofit2.Converter<T, String> nameConverter;
        QueryName(retrofit2.Converter<T, String> converter, boolean z2) {
            super();
            this.nameConverter = converter;
            this.encoded = z2;
        }

        void apply(retrofit2.RequestBuilder requestBuilder, T t2) {
            if (t2 == null) {
            }
            requestBuilder.addQueryParam((String)this.nameConverter.convert(t2), 0, this.encoded);
        }
    }

    static final class RawPart extends retrofit2.ParameterHandler<MultipartBody.Part> {

        static final retrofit2.ParameterHandler.RawPart INSTANCE;
        static {
            ParameterHandler.RawPart rawPart = new ParameterHandler.RawPart();
            ParameterHandler.RawPart.INSTANCE = rawPart;
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, Object object2) {
            apply(requestBuilder, (MultipartBody.Part)object2);
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, MultipartBody.Part multipartBody$Part2) {
            if (part2 != null) {
                requestBuilder.addPart(part2);
            }
        }
    }

    static final class RelativeUrl extends retrofit2.ParameterHandler<Object> {

        private final Method method;
        private final int p;
        RelativeUrl(Method method, int i2) {
            super();
            this.method = method;
            this.p = i2;
        }

        @Override // retrofit2.ParameterHandler
        void apply(retrofit2.RequestBuilder requestBuilder, Object object2) {
            if (object2 == null) {
            } else {
                requestBuilder.setRelativeUrl(object2);
            }
            throw Utils.parameterError(this.method, this.p, "@Url parameter is null.", new Object[0]);
        }
    }

    static final class Tag extends retrofit2.ParameterHandler<T> {

        final Class<T> cls;
        Tag(Class<T> class) {
            super();
            this.cls = class;
        }

        void apply(retrofit2.RequestBuilder requestBuilder, T t2) {
            requestBuilder.addTag(this.cls, t2);
        }
    }
    abstract void apply(retrofit2.RequestBuilder requestBuilder, T t2);

    final retrofit2.ParameterHandler<Object> array() {
        ParameterHandler.2 anon = new ParameterHandler.2(this);
        return anon;
    }

    final retrofit2.ParameterHandler<Iterable<T>> iterable() {
        ParameterHandler.1 anon = new ParameterHandler.1(this);
        return anon;
    }
}
