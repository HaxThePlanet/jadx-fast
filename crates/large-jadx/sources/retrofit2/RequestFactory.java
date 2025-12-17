package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;

/* loaded from: classes3.dex */
final class RequestFactory {

    private final HttpUrl baseUrl;
    private final MediaType contentType;
    private final boolean hasBody;
    private final Headers headers;
    final String httpMethod;
    private final boolean isFormEncoded;
    final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    private final Method method;
    private final retrofit2.ParameterHandler<?>[] parameterHandlers;
    private final String relativeUrl;

    static final class Builder {

        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX;
        private static final Pattern PARAM_URL_REGEX;
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;
        Headers headers;
        String httpMethod;
        boolean isFormEncoded;
        boolean isKotlinSuspendFunction;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        retrofit2.ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        final retrofit2.Retrofit retrofit;
        static {
            RequestFactory.Builder.PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
            RequestFactory.Builder.PARAM_NAME_REGEX = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        }

        Builder(retrofit2.Retrofit retrofit, Method method2) {
            super();
            this.retrofit = retrofit;
            this.method = method2;
            this.methodAnnotations = method2.getAnnotations();
            this.parameterTypes = method2.getGenericParameterTypes();
            this.parameterAnnotationsArray = method2.getParameterAnnotations();
        }

        private static Class<?> boxIfPrimitive(Class<?> class) {
            Class obj1;
            if (Boolean.TYPE == class) {
                return Boolean.class;
            }
            if (Byte.TYPE == class) {
                return Byte.class;
            }
            if (Character.TYPE == class) {
                return Character.class;
            }
            if (Double.TYPE == class) {
                return Double.class;
            }
            if (Float.TYPE == class) {
                return Float.class;
            }
            if (Integer.TYPE == class) {
                return Integer.class;
            }
            if (Long.TYPE == class) {
                return Long.class;
            }
            if (Short.TYPE == class) {
                obj1 = Short.class;
            }
            return obj1;
        }

        private Headers parseHeaders(String[] stringArr) {
            int i3;
            Object trim;
            MediaType equalsIgnoreCase;
            String substring;
            int i;
            int i2;
            Headers.Builder builder = new Headers.Builder();
            final int i4 = 0;
            i3 = i4;
            while (i3 < stringArr.length) {
                Object obj = stringArr[i3];
                int indexOf = obj.indexOf(58);
                i2 = 1;
                substring = obj.substring(i4, indexOf);
                trim = obj.substring(indexOf++).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                } else {
                }
                builder.add(substring, trim);
                i3++;
                this.contentType = MediaType.get(trim);
            }
            return builder.build();
        }

        private void parseHttpMethodAndPath(String string, String string2, boolean z3) {
            int obj4;
            int obj6;
            final String httpMethod = this.httpMethod;
            final int i = 0;
            final int i2 = 1;
            if (httpMethod != null) {
            } else {
                this.httpMethod = string;
                this.hasBody = z3;
                if (string2.isEmpty()) {
                }
                obj4 = string2.indexOf(63);
                if (obj4 != -1 && obj4 < obj6 -= i2) {
                    if (obj4 < obj6 -= i2) {
                        obj4 = string2.substring(obj4 += i2);
                        if (RequestFactory.Builder.PARAM_URL_REGEX.matcher(obj4).find()) {
                        } else {
                        }
                        obj6 = new Object[i2];
                        obj6[i] = obj4;
                        throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", obj6);
                    }
                }
                this.relativeUrl = string2;
                this.relativeUrlParamNames = RequestFactory.Builder.parsePathParameters(string2);
            }
            obj6 = new Object[2];
            obj6[i] = httpMethod;
            obj6[i2] = string;
            throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", obj6);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            String method;
            int path;
            int i;
            String str;
            String obj5;
            path = 0;
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", (DELETE)annotation.value(), path);
            } else {
                if (annotation instanceof GET) {
                    parseHttpMethodAndPath("GET", (GET)annotation.value(), path);
                } else {
                    if (annotation instanceof HEAD) {
                        parseHttpMethodAndPath("HEAD", (HEAD)annotation.value(), path);
                    } else {
                        i = 1;
                        if (annotation instanceof PATCH) {
                            parseHttpMethodAndPath("PATCH", (PATCH)annotation.value(), i);
                        } else {
                            if (annotation instanceof POST) {
                                parseHttpMethodAndPath("POST", (POST)annotation.value(), i);
                            } else {
                                if (annotation instanceof PUT) {
                                    parseHttpMethodAndPath("PUT", (PUT)annotation.value(), i);
                                } else {
                                    if (annotation instanceof OPTIONS) {
                                        parseHttpMethodAndPath("OPTIONS", (OPTIONS)annotation.value(), path);
                                    } else {
                                        if (annotation instanceof HTTP) {
                                            parseHttpMethodAndPath((HTTP)annotation.method(), annotation.path(), annotation.hasBody());
                                        } else {
                                            if (annotation instanceof Headers) {
                                                obj5 = (Headers)annotation.value();
                                                if (obj5.length == 0) {
                                                } else {
                                                    this.headers = parseHeaders(obj5);
                                                }
                                                throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[path]);
                                            }
                                            str = "Only one encoding annotation is allowed.";
                                            if (annotation instanceof Multipart) {
                                                if (this.isFormEncoded) {
                                                } else {
                                                    this.isMultipart = i;
                                                }
                                                throw Utils.methodError(this.method, str, new Object[path]);
                                            }
                                            if (annotation instanceof FormUrlEncoded) {
                                                if (this.isMultipart) {
                                                } else {
                                                    this.isFormEncoded = i;
                                                }
                                                throw Utils.methodError(this.method, str, new Object[path]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        private retrofit2.ParameterHandler<?> parseParameter(int i, Type type2, Annotation[] annotation3Arr3, boolean z4) {
            int length;
            int i2;
            int i3;
            retrofit2.ParameterHandler parameterAnnotation;
            Object obj8;
            Annotation[] obj9;
            final int i4 = 0;
            final int i5 = 0;
            if (annotation3Arr3 != null) {
                i3 = i4;
                i2 = i5;
                while (i2 < annotation3Arr3.length) {
                    parameterAnnotation = parseParameterAnnotation(i, type2, annotation3Arr3, annotation3Arr3[i2]);
                    i3 = parameterAnnotation;
                    i2++;
                }
            } else {
                i3 = i4;
            }
            if (i3 == 0) {
                if (!z4) {
                } else {
                    if (Utils.getRawType(type2) != d.class) {
                    } else {
                        this.isKotlinSuspendFunction = true;
                        return i4;
                    }
                }
                throw Utils.parameterError(this.method, i, "No Retrofit annotation found.", new Object[i5]);
            }
            return i3;
        }

        private retrofit2.ParameterHandler<?> parseParameterAnnotation(int i, Type type2, Annotation[] annotation3Arr3, Annotation annotation4) {
            boolean z;
            Type obj12;
            int obj13;
            boolean obj14;
            Class<String> obj = String.class;
            Class<okhttp3.MultipartBody.Part> obj3 = MultipartBody.Part.class;
            String str4 = "@Path parameters may not be used with @Url.";
            int i5 = 1;
            int i6 = 0;
            if (annotation4 instanceof Url) {
                validateResolvableType(i, type2);
                if (this.gotUrl) {
                } else {
                    if (this.gotPath != null) {
                    } else {
                        if (this.gotQuery) {
                        } else {
                            if (this.gotQueryName) {
                            } else {
                                if (this.gotQueryMap != null) {
                                } else {
                                    if (this.relativeUrl != null) {
                                    } else {
                                        this.gotUrl = i5;
                                        if (type2 != HttpUrl.class && type2 != obj && type2 != URI.class) {
                                            if (type2 != obj) {
                                                if (type2 != URI.class) {
                                                    if (!type2 instanceof Class) {
                                                    } else {
                                                        if (!"android.net.Uri".equals((Class)type2.getName())) {
                                                        } else {
                                                        }
                                                    }
                                                    throw Utils.parameterError(this.method, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[i6]);
                                                }
                                            }
                                        }
                                        obj12 = new ParameterHandler.RelativeUrl(this.method, i);
                                        return obj12;
                                    }
                                    obj13 = new Object[i5];
                                    obj13[i6] = this.httpMethod;
                                    throw Utils.parameterError(this.method, i, "@Url cannot be used with @%s URL", obj13);
                                }
                                throw Utils.parameterError(this.method, i, "A @Url parameter must not come after a @QueryMap.", new Object[i6]);
                            }
                            throw Utils.parameterError(this.method, i, "A @Url parameter must not come after a @QueryName.", new Object[i6]);
                        }
                        throw Utils.parameterError(this.method, i, "A @Url parameter must not come after a @Query.", new Object[i6]);
                    }
                    throw Utils.parameterError(this.method, i, str4, new Object[i6]);
                }
                throw Utils.parameterError(this.method, i, "Multiple @Url method annotations found.", new Object[i6]);
            }
            if (annotation4 instanceof Path != null) {
                validateResolvableType(i, type2);
                if (this.gotQuery) {
                } else {
                    if (this.gotQueryName) {
                    } else {
                        if (this.gotQueryMap != null) {
                        } else {
                            if (this.gotUrl) {
                            } else {
                                if (this.relativeUrl == null) {
                                } else {
                                    this.gotPath = i5;
                                    String value4 = (Path)annotation4.value();
                                    validatePathName(i, value4);
                                    super(this.method, i, value4, this.retrofit.stringConverter(type2, annotation3Arr3), annotation4.encoded());
                                    return obj12;
                                }
                                obj13 = new Object[i5];
                                obj13[i6] = this.httpMethod;
                                throw Utils.parameterError(this.method, i, "@Path can only be used with relative url on @%s", obj13);
                            }
                            throw Utils.parameterError(this.method, i, str4, new Object[i6]);
                        }
                        throw Utils.parameterError(this.method, i, "A @Path parameter must not come after a @QueryMap.", new Object[i6]);
                    }
                    throw Utils.parameterError(this.method, i, "A @Path parameter must not come after a @QueryName.", new Object[i6]);
                }
                throw Utils.parameterError(this.method, i, "A @Path parameter must not come after a @Query.", new Object[i6]);
            }
            String str5 = "<String>)";
            final String str8 = " must include generic type (e.g., ";
            validateResolvableType(i, type2);
            String value = (Query)annotation4.value();
            obj14 = annotation4.encoded();
            Class rawType5 = Utils.getRawType(type2);
            this.gotQuery = i5;
            if (annotation4 instanceof Query && Iterable.class.isAssignableFrom(rawType5)) {
                validateResolvableType(i, type2);
                value = (Query)annotation4.value();
                obj14 = annotation4.encoded();
                rawType5 = Utils.getRawType(type2);
                this.gotQuery = i5;
                if (Iterable.class.isAssignableFrom(rawType5)) {
                    if (!type2 instanceof ParameterizedType) {
                    } else {
                        obj12 = new ParameterHandler.Query(value, this.retrofit.stringConverter(Utils.getParameterUpperBound(i6, (ParameterizedType)type2), annotation3Arr3), obj14);
                        return obj12.iterable();
                    }
                    obj13 = new StringBuilder();
                    obj13.append(rawType5.getSimpleName());
                    obj13.append(str8);
                    obj13.append(rawType5.getSimpleName());
                    obj13.append(str5);
                    throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                }
                if (rawType5.isArray()) {
                    obj12 = new ParameterHandler.Query(value, this.retrofit.stringConverter(RequestFactory.Builder.boxIfPrimitive(rawType5.getComponentType()), annotation3Arr3), obj14);
                    return obj12.array();
                }
                obj12 = new ParameterHandler.Query(value, this.retrofit.stringConverter(type2, annotation3Arr3), obj14);
                return obj12;
            }
            validateResolvableType(i, type2);
            obj14 = (QueryName)annotation4.encoded();
            Class rawType4 = Utils.getRawType(type2);
            this.gotQueryName = i5;
            if (annotation4 instanceof QueryName && Iterable.class.isAssignableFrom(rawType4)) {
                validateResolvableType(i, type2);
                obj14 = (QueryName)annotation4.encoded();
                rawType4 = Utils.getRawType(type2);
                this.gotQueryName = i5;
                if (Iterable.class.isAssignableFrom(rawType4)) {
                    if (!type2 instanceof ParameterizedType) {
                    } else {
                        obj12 = new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(i6, (ParameterizedType)type2), annotation3Arr3), obj14);
                        return obj12.iterable();
                    }
                    obj13 = new StringBuilder();
                    obj13.append(rawType4.getSimpleName());
                    obj13.append(str8);
                    obj13.append(rawType4.getSimpleName());
                    obj13.append(str5);
                    throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                }
                if (rawType4.isArray()) {
                    obj12 = new ParameterHandler.QueryName(this.retrofit.stringConverter(RequestFactory.Builder.boxIfPrimitive(rawType4.getComponentType()), annotation3Arr3), obj14);
                    return obj12.array();
                }
                obj12 = new ParameterHandler.QueryName(this.retrofit.stringConverter(type2, annotation3Arr3), obj14);
                return obj12;
            }
            String str9 = "Map must include generic types (e.g., Map<String, String>)";
            if (annotation4 instanceof QueryMap != null) {
                validateResolvableType(i, type2);
                Class rawType6 = Utils.getRawType(type2);
                this.gotQueryMap = i5;
                if (!Map.class.isAssignableFrom(rawType6)) {
                } else {
                    obj12 = Utils.getSupertype(type2, rawType6, Map.class);
                    if (!obj12 instanceof ParameterizedType) {
                    } else {
                        Type parameterUpperBound = Utils.getParameterUpperBound(i6, (ParameterizedType)obj12);
                        if (obj != parameterUpperBound) {
                        } else {
                            obj13 = new ParameterHandler.QueryMap(this.method, i, this.retrofit.stringConverter(Utils.getParameterUpperBound(i5, obj12), annotation3Arr3), (QueryMap)annotation4.encoded());
                            return obj13;
                        }
                        obj13 = new StringBuilder();
                        obj13.append("@QueryMap keys must be of type String: ");
                        obj13.append(parameterUpperBound);
                        throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                    }
                    throw Utils.parameterError(this.method, i, str9, new Object[i6]);
                }
                throw Utils.parameterError(this.method, i, "@QueryMap parameter type must be Map.", new Object[i6]);
            }
            validateResolvableType(i, type2);
            obj14 = (Header)annotation4.value();
            Class rawType = Utils.getRawType(type2);
            if (annotation4 instanceof Header && Iterable.class.isAssignableFrom(rawType)) {
                validateResolvableType(i, type2);
                obj14 = (Header)annotation4.value();
                rawType = Utils.getRawType(type2);
                if (Iterable.class.isAssignableFrom(rawType)) {
                    if (!type2 instanceof ParameterizedType) {
                    } else {
                        obj12 = new ParameterHandler.Header(obj14, this.retrofit.stringConverter(Utils.getParameterUpperBound(i6, (ParameterizedType)type2), annotation3Arr3));
                        return obj12.iterable();
                    }
                    obj13 = new StringBuilder();
                    obj13.append(rawType.getSimpleName());
                    obj13.append(str8);
                    obj13.append(rawType.getSimpleName());
                    obj13.append(str5);
                    throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                }
                if (rawType.isArray()) {
                    obj12 = new ParameterHandler.Header(obj14, this.retrofit.stringConverter(RequestFactory.Builder.boxIfPrimitive(rawType.getComponentType()), annotation3Arr3));
                    return obj12.array();
                }
                obj12 = new ParameterHandler.Header(obj14, this.retrofit.stringConverter(type2, annotation3Arr3));
                return obj12;
            }
            if (annotation4 instanceof HeaderMap != null && type2 == Headers.class) {
                if (type2 == Headers.class) {
                    obj12 = new ParameterHandler.Headers(this.method, i);
                    return obj12;
                }
                validateResolvableType(i, type2);
                obj14 = Utils.getRawType(type2);
                if (!Map.class.isAssignableFrom(obj14)) {
                } else {
                    obj12 = Utils.getSupertype(type2, obj14, Map.class);
                    if (!obj12 instanceof ParameterizedType) {
                    } else {
                        obj14 = Utils.getParameterUpperBound(i6, (ParameterizedType)obj12);
                        if (obj != obj14) {
                        } else {
                            obj13 = new ParameterHandler.HeaderMap(this.method, i, this.retrofit.stringConverter(Utils.getParameterUpperBound(i5, obj12), annotation3Arr3));
                            return obj13;
                        }
                        obj13 = new StringBuilder();
                        obj13.append("@HeaderMap keys must be of type String: ");
                        obj13.append(obj14);
                        throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                    }
                    throw Utils.parameterError(this.method, i, str9, new Object[i6]);
                }
                throw Utils.parameterError(this.method, i, "@HeaderMap parameter type must be Map.", new Object[i6]);
            }
            if (annotation4 instanceof Field) {
                validateResolvableType(i, type2);
                if (!this.isFormEncoded) {
                } else {
                    String value3 = (Field)annotation4.value();
                    obj14 = annotation4.encoded();
                    this.gotField = i5;
                    Class rawType8 = Utils.getRawType(type2);
                    if (Iterable.class.isAssignableFrom(rawType8)) {
                        if (!type2 instanceof ParameterizedType) {
                        } else {
                            obj12 = new ParameterHandler.Field(value3, this.retrofit.stringConverter(Utils.getParameterUpperBound(i6, (ParameterizedType)type2), annotation3Arr3), obj14);
                            return obj12.iterable();
                        }
                        obj13 = new StringBuilder();
                        obj13.append(rawType8.getSimpleName());
                        obj13.append(str8);
                        obj13.append(rawType8.getSimpleName());
                        obj13.append(str5);
                        throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                    }
                    if (rawType8.isArray()) {
                        obj12 = new ParameterHandler.Field(value3, this.retrofit.stringConverter(RequestFactory.Builder.boxIfPrimitive(rawType8.getComponentType()), annotation3Arr3), obj14);
                        return obj12.array();
                    }
                    obj12 = new ParameterHandler.Field(value3, this.retrofit.stringConverter(type2, annotation3Arr3), obj14);
                    return obj12;
                }
                throw Utils.parameterError(this.method, i, "@Field parameters can only be used with form encoding.", new Object[i6]);
            }
            if (annotation4 instanceof FieldMap != null) {
                validateResolvableType(i, type2);
                if (!this.isFormEncoded) {
                } else {
                    Class rawType7 = Utils.getRawType(type2);
                    if (!Map.class.isAssignableFrom(rawType7)) {
                    } else {
                        obj12 = Utils.getSupertype(type2, rawType7, Map.class);
                        if (!obj12 instanceof ParameterizedType) {
                        } else {
                            Type parameterUpperBound2 = Utils.getParameterUpperBound(i6, (ParameterizedType)obj12);
                            if (obj != parameterUpperBound2) {
                            } else {
                                this.gotField = i5;
                                obj13 = new ParameterHandler.FieldMap(this.method, i, this.retrofit.stringConverter(Utils.getParameterUpperBound(i5, obj12), annotation3Arr3), (FieldMap)annotation4.encoded());
                                return obj13;
                            }
                            obj13 = new StringBuilder();
                            obj13.append("@FieldMap keys must be of type String: ");
                            obj13.append(parameterUpperBound2);
                            throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                        }
                        throw Utils.parameterError(this.method, i, str9, new Object[i6]);
                    }
                    throw Utils.parameterError(this.method, i, "@FieldMap parameter type must be Map.", new Object[i6]);
                }
                throw Utils.parameterError(this.method, i, "@FieldMap parameters can only be used with form encoding.", new Object[i6]);
            }
            if (annotation4 instanceof Part) {
                validateResolvableType(i, type2);
                if (!this.isMultipart) {
                } else {
                    this.gotPart = i5;
                    String value2 = (Part)annotation4.value();
                    Class rawType10 = Utils.getRawType(type2);
                    obj14 = "@Part annotation must supply a name or use MultipartBody.Part parameter type.";
                    if (value2.isEmpty() && Iterable.class.isAssignableFrom(rawType10)) {
                        obj14 = "@Part annotation must supply a name or use MultipartBody.Part parameter type.";
                        if (Iterable.class.isAssignableFrom(rawType10)) {
                            if (!type2 instanceof ParameterizedType) {
                            } else {
                                if (!obj3.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(i6, (ParameterizedType)type2)))) {
                                } else {
                                    return ParameterHandler.RawPart.INSTANCE.iterable();
                                }
                                throw Utils.parameterError(this.method, i, obj14, new Object[i6]);
                            }
                            obj13 = new StringBuilder();
                            obj13.append(rawType10.getSimpleName());
                            obj13.append(str8);
                            obj13.append(rawType10.getSimpleName());
                            obj13.append(str5);
                            throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                        }
                        if (rawType10.isArray()) {
                            if (!obj3.isAssignableFrom(rawType10.getComponentType())) {
                            } else {
                                return ParameterHandler.RawPart.INSTANCE.array();
                            }
                            throw Utils.parameterError(this.method, i, obj14, new Object[i6]);
                        }
                        if (!obj3.isAssignableFrom(rawType10)) {
                        } else {
                            return ParameterHandler.RawPart.INSTANCE;
                        }
                        throw Utils.parameterError(this.method, i, obj14, new Object[i6]);
                    }
                    String[] strArr = new String[4];
                    strArr[i6] = "Content-Disposition";
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("form-data; name=\"");
                    stringBuilder2.append(value2);
                    stringBuilder2.append("\"");
                    strArr[i5] = stringBuilder2.toString();
                    strArr[2] = "Content-Transfer-Encoding";
                    strArr[3] = annotation4.encoding();
                    obj14 = Headers.of(strArr);
                    String str7 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.";
                    if (Iterable.class.isAssignableFrom(rawType10)) {
                        if (!type2 instanceof ParameterizedType) {
                        } else {
                            obj12 = Utils.getParameterUpperBound(i6, (ParameterizedType)type2);
                            if (obj3.isAssignableFrom(Utils.getRawType(obj12))) {
                            } else {
                                obj13 = new ParameterHandler.Part(this.method, i, obj14, this.retrofit.requestBodyConverter(obj12, annotation3Arr3, this.methodAnnotations));
                                return obj13.iterable();
                            }
                            throw Utils.parameterError(this.method, i, str7, new Object[i6]);
                        }
                        obj13 = new StringBuilder();
                        obj13.append(rawType10.getSimpleName());
                        obj13.append(str8);
                        obj13.append(rawType10.getSimpleName());
                        obj13.append(str5);
                        throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                    }
                    if (rawType10.isArray()) {
                        obj12 = RequestFactory.Builder.boxIfPrimitive(rawType10.getComponentType());
                        if (obj3.isAssignableFrom(obj12)) {
                        } else {
                            obj13 = new ParameterHandler.Part(this.method, i, obj14, this.retrofit.requestBodyConverter(obj12, annotation3Arr3, this.methodAnnotations));
                            return obj13.array();
                        }
                        throw Utils.parameterError(this.method, i, str7, new Object[i6]);
                    }
                    if (obj3.isAssignableFrom(rawType10)) {
                    } else {
                        obj13 = new ParameterHandler.Part(this.method, i, obj14, this.retrofit.requestBodyConverter(type2, annotation3Arr3, this.methodAnnotations));
                        return obj13;
                    }
                    throw Utils.parameterError(this.method, i, str7, new Object[i6]);
                }
                throw Utils.parameterError(this.method, i, "@Part parameters can only be used with multipart encoding.", new Object[i6]);
            }
            if (annotation4 instanceof PartMap != null) {
                validateResolvableType(i, type2);
                if (!this.isMultipart) {
                } else {
                    this.gotPart = i5;
                    Class rawType9 = Utils.getRawType(type2);
                    if (!Map.class.isAssignableFrom(rawType9)) {
                    } else {
                        obj12 = Utils.getSupertype(type2, rawType9, Map.class);
                        if (!obj12 instanceof ParameterizedType) {
                        } else {
                            Type parameterUpperBound3 = Utils.getParameterUpperBound(i6, (ParameterizedType)obj12);
                            if (obj != parameterUpperBound3) {
                            } else {
                                obj12 = Utils.getParameterUpperBound(i5, obj12);
                                if (obj3.isAssignableFrom(Utils.getRawType(obj12))) {
                                } else {
                                    obj13 = new ParameterHandler.PartMap(this.method, i, this.retrofit.requestBodyConverter(obj12, annotation3Arr3, this.methodAnnotations), (PartMap)annotation4.encoding());
                                    return obj13;
                                }
                                throw Utils.parameterError(this.method, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[i6]);
                            }
                            obj13 = new StringBuilder();
                            obj13.append("@PartMap keys must be of type String: ");
                            obj13.append(parameterUpperBound3);
                            throw Utils.parameterError(this.method, i, obj13.toString(), new Object[i6]);
                        }
                        throw Utils.parameterError(this.method, i, str9, new Object[i6]);
                    }
                    throw Utils.parameterError(this.method, i, "@PartMap parameter type must be Map.", new Object[i6]);
                }
                throw Utils.parameterError(this.method, i, "@PartMap parameters can only be used with multipart encoding.", new Object[i6]);
            }
            if (annotation4 instanceof Body) {
                validateResolvableType(i, type2);
                if (this.isFormEncoded) {
                } else {
                    if (this.isMultipart) {
                    } else {
                        if (this.gotBody) {
                        } else {
                            this.gotBody = i5;
                            obj13 = new ParameterHandler.Body(this.method, i, this.retrofit.requestBodyConverter(type2, annotation3Arr3, this.methodAnnotations));
                            return obj13;
                        }
                        throw Utils.parameterError(this.method, i, "Multiple @Body method annotations found.", new Object[i6]);
                    }
                }
                throw Utils.parameterError(this.method, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[i6]);
            }
            if (annotation4 instanceof Tag) {
                validateResolvableType(i, type2);
                obj12 = Utils.getRawType(type2);
                obj13 = i + -1;
                while (obj13 >= 0) {
                    obj14 = this.parameterHandlers[obj13];
                    obj13--;
                }
                ParameterHandler.Tag obj11 = new ParameterHandler.Tag(obj12);
                return obj11;
            }
            return 0;
        }

        static Set<String> parsePathParameters(String string) {
            String group;
            final Matcher obj2 = RequestFactory.Builder.PARAM_URL_REGEX.matcher(string);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (obj2.find()) {
                linkedHashSet.add(obj2.group(1));
            }
            return linkedHashSet;
        }

        private void validatePathName(int i, String string2) {
            final int i2 = 1;
            final int i3 = 0;
            int i4 = 2;
            if (!RequestFactory.Builder.PARAM_NAME_REGEX.matcher(string2).matches()) {
            } else {
                if (!this.relativeUrlParamNames.contains(string2)) {
                } else {
                }
                Object[] arr = new Object[i4];
                arr[i3] = this.relativeUrl;
                arr[i2] = string2;
                throw Utils.parameterError(this.method, i, "URL \"%s\" does not contain \"{%s}\".", arr);
            }
            Object[] arr2 = new Object[i4];
            arr2[i3] = RequestFactory.Builder.PARAM_URL_REGEX.pattern();
            arr2[i2] = string2;
            throw Utils.parameterError(this.method, i, "@Path parameter name must match %s. Found: %s", arr2);
        }

        private void validateResolvableType(int i, Type type2) {
            if (Utils.hasUnresolvableType(type2)) {
            } else {
            }
            Object[] arr = new Object[1];
            throw Utils.parameterError(this.method, i, "Parameter type must not include a type variable or wildcard: %s", type2);
        }

        retrofit2.RequestFactory build() {
            boolean isFormEncoded;
            String relativeUrl;
            boolean isFormEncoded2;
            boolean isMultipart2;
            int isMultipart;
            int i;
            int i2;
            Annotation parameter;
            int i3;
            retrofit2.ParameterHandler[] parameterHandlers;
            Type type;
            Annotation[] objArr;
            Annotation[] methodAnnotations = this.methodAnnotations;
            int i4 = 0;
            i = i4;
            while (i < methodAnnotations.length) {
                parseMethodAnnotation(methodAnnotations[i]);
                i++;
            }
            if (this.httpMethod == null) {
            } else {
                if (!this.hasBody) {
                    if (this.isMultipart) {
                    } else {
                        if (this.isFormEncoded) {
                        } else {
                        }
                        throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[i4]);
                    }
                    throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[i4]);
                }
                int length = parameterAnnotationsArray.length;
                this.parameterHandlers = new ParameterHandler[length];
                i2 = i4;
                while (i2 < length) {
                    if (i2 == length + -1) {
                    } else {
                    }
                    i3 = i4;
                    this.parameterHandlers[i2] = parseParameter(i2, this.parameterTypes[i2], this.parameterAnnotationsArray[i2], i3);
                    i2++;
                }
                if (this.relativeUrl == null) {
                    if (!this.gotUrl) {
                    } else {
                    }
                    Object[] arr4 = new Object[1];
                    arr4[i4] = this.httpMethod;
                    throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", arr4);
                }
                isFormEncoded2 = this.isFormEncoded;
                if (!isFormEncoded2 && !this.isMultipart && !this.hasBody) {
                    if (!this.isMultipart) {
                        if (!this.hasBody) {
                            if (this.gotBody) {
                            } else {
                            }
                            throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[i4]);
                        }
                    }
                }
                if (isFormEncoded2) {
                    if (!this.gotField) {
                    } else {
                    }
                    throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[i4]);
                }
                if (this.isMultipart) {
                    if (!this.gotPart) {
                    } else {
                    }
                    throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[i4]);
                }
                RequestFactory requestFactory = new RequestFactory(this);
                return requestFactory;
            }
            throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[i4]);
        }
    }
    RequestFactory(retrofit2.RequestFactory.Builder requestFactory$Builder) {
        super();
        this.method = builder.method;
        this.baseUrl = retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
        this.isKotlinSuspendFunction = builder.isKotlinSuspendFunction;
    }

    static retrofit2.RequestFactory parseAnnotations(retrofit2.Retrofit retrofit, Method method2) {
        RequestFactory.Builder builder = new RequestFactory.Builder(retrofit, method2);
        return builder.build();
    }

    Request create(Object[] objectArr) {
        int length;
        int i;
        HttpUrl baseUrl;
        String relativeUrl;
        retrofit2.ParameterHandler[] parameterHandlers = this.parameterHandlers;
        length = objectArr.length;
        if (length != parameterHandlers.length) {
        } else {
            super(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
            if (this.isKotlinSuspendFunction) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            i = 0;
            while (i < length) {
                arrayList.add(objectArr[i]);
                parameterHandlers[i].apply(requestBuilder, objectArr[i]);
                i++;
            }
            Invocation invocation = new Invocation(this.method, arrayList);
            return requestBuilder.get().tag(Invocation.class, invocation).build();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Argument count (");
        stringBuilder.append(length);
        stringBuilder.append(") doesn't match expected count (");
        stringBuilder.append(parameterHandlers.length);
        stringBuilder.append(")");
        IllegalArgumentException obj13 = new IllegalArgumentException(stringBuilder.toString());
        throw obj13;
    }
}
