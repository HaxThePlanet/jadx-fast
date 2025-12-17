package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import okhttp3.Call.Factory;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
abstract class HttpServiceMethod<ResponseT, ReturnT>  extends retrofit2.ServiceMethod<ReturnT> {

    private final Call.Factory callFactory;
    private final retrofit2.RequestFactory requestFactory;
    private final retrofit2.Converter<ResponseBody, ResponseT> responseConverter;

    static final class CallAdapted extends retrofit2.HttpServiceMethod<ResponseT, ReturnT> {

        private final retrofit2.CallAdapter<ResponseT, ReturnT> callAdapter;
        CallAdapted(retrofit2.RequestFactory requestFactory, Call.Factory call$Factory2, retrofit2.Converter<ResponseBody, ResponseT> converter3, retrofit2.CallAdapter<ResponseT, ReturnT> callAdapter4) {
            super(requestFactory, factory2, converter3);
            this.callAdapter = callAdapter4;
        }

        protected ReturnT adapt(retrofit2.Call<ResponseT> call, Object[] object2Arr2) {
            return this.callAdapter.adapt(call);
        }
    }

    static final class SuspendForBody extends retrofit2.HttpServiceMethod<ResponseT, Object> {

        private final retrofit2.CallAdapter<ResponseT, retrofit2.Call<ResponseT>> callAdapter;
        private final boolean isNullable;
        SuspendForBody(retrofit2.RequestFactory requestFactory, Call.Factory call$Factory2, retrofit2.Converter<ResponseBody, ResponseT> converter3, retrofit2.CallAdapter<ResponseT, retrofit2.Call<ResponseT>> callAdapter4, boolean z5) {
            super(requestFactory, factory2, converter3);
            this.callAdapter = callAdapter4;
            this.isNullable = z5;
        }

        protected Object adapt(retrofit2.Call<ResponseT> call, Object[] object2Arr2) {
            Object obj2;
            obj2 = this.callAdapter.adapt(call);
            final Object obj3 = object2Arr2[length--];
            if (this.isNullable) {
                obj2 = KotlinExtensions.awaitNullable((Call)obj2, (d)obj3);
            } else {
                obj2 = KotlinExtensions.await(obj2, obj3);
            }
            return obj2;
        }
    }

    static final class SuspendForResponse extends retrofit2.HttpServiceMethod<ResponseT, Object> {

        private final retrofit2.CallAdapter<ResponseT, retrofit2.Call<ResponseT>> callAdapter;
        SuspendForResponse(retrofit2.RequestFactory requestFactory, Call.Factory call$Factory2, retrofit2.Converter<ResponseBody, ResponseT> converter3, retrofit2.CallAdapter<ResponseT, retrofit2.Call<ResponseT>> callAdapter4) {
            super(requestFactory, factory2, converter3);
            this.callAdapter = callAdapter4;
        }

        protected Object adapt(retrofit2.Call<ResponseT> call, Object[] object2Arr2) {
            return KotlinExtensions.awaitResponse((Call)this.callAdapter.adapt(call), (d)object2Arr2[length--]);
        }
    }
    HttpServiceMethod(retrofit2.RequestFactory requestFactory, Call.Factory call$Factory2, retrofit2.Converter<ResponseBody, ResponseT> converter3) {
        super();
        this.requestFactory = requestFactory;
        this.callFactory = factory2;
        this.responseConverter = converter3;
    }

    private static <ResponseT, ReturnT> retrofit2.CallAdapter<ResponseT, ReturnT> createCallAdapter(retrofit2.Retrofit retrofit, Method method2, Type type3, Annotation[] annotation4Arr4) {
        try {
            return retrofit.callAdapter(type3, annotation4Arr4);
            annotation4Arr4 = 1;
            annotation4Arr4 = new Object[annotation4Arr4];
            annotation4Arr4[0] = type3;
            type3 = "Unable to create call adapter for %s";
            retrofit = Utils.methodError(method2, retrofit, type3, annotation4Arr4);
            throw retrofit;
        }
    }

    private static <ResponseT> retrofit2.Converter<ResponseBody, ResponseT> createResponseConverter(retrofit2.Retrofit retrofit, Method method2, Type type3) {
        return retrofit.responseBodyConverter(type3, method2.getAnnotations());
    }

    static <ResponseT, ReturnT> retrofit2.HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(retrofit2.Retrofit retrofit, Method method2, retrofit2.RequestFactory requestFactory3) {
        boolean equals;
        Annotation[] ensurePresent;
        Type parameterLowerBound;
        Class rawType;
        int i;
        Type[] arr;
        Object parameterizedTypeImpl;
        int i2;
        Class<retrofit2.Call> obj;
        Class<retrofit2.Response> obj3 = Response.class;
        boolean isKotlinSuspendFunction = requestFactory3.isKotlinSuspendFunction;
        int i4 = 0;
        if (isKotlinSuspendFunction) {
            Type[] genericParameterTypes = method2.getGenericParameterTypes();
            int i7 = 1;
            parameterLowerBound = Utils.getParameterLowerBound(i4, (ParameterizedType)genericParameterTypes[length -= i7]);
            if (Utils.getRawType(parameterLowerBound) == obj3 && parameterLowerBound instanceof ParameterizedType) {
                if (parameterLowerBound instanceof ParameterizedType) {
                    parameterLowerBound = Utils.getParameterUpperBound(i4, (ParameterizedType)parameterLowerBound);
                    i = i7;
                } else {
                    i = i4;
                }
            } else {
            }
            arr = new Type[i7];
            arr[i4] = parameterLowerBound;
            parameterizedTypeImpl = new Utils.ParameterizedTypeImpl(0, Call.class, arr);
            ensurePresent = SkipCallbackExecutorImpl.ensurePresent(method2.getAnnotations());
        } else {
            parameterizedTypeImpl = method2.getGenericReturnType();
            i = i4;
        }
        retrofit2.CallAdapter callAdapter2 = HttpServiceMethod.createCallAdapter(retrofit, method2, parameterizedTypeImpl, ensurePresent);
        Type responseType = callAdapter2.responseType();
        if (responseType == Response.class) {
        } else {
            if (responseType == obj3) {
            } else {
                if (requestFactory3.httpMethod.equals("HEAD")) {
                    if (!Void.class.equals(responseType)) {
                    } else {
                    }
                    throw Utils.methodError(method2, "HEAD method must use Void as response type.", new Object[i4]);
                }
                retrofit2.Converter responseConverter = HttpServiceMethod.createResponseConverter(retrofit, method2, responseType);
                Call.Factory callFactory = retrofit.callFactory;
                if (!isKotlinSuspendFunction) {
                    HttpServiceMethod.CallAdapted callAdapted = new HttpServiceMethod.CallAdapted(requestFactory3, callFactory, responseConverter, callAdapter2);
                    return callAdapted;
                }
                if (i != 0) {
                    HttpServiceMethod.SuspendForResponse suspendForResponse = new HttpServiceMethod.SuspendForResponse(requestFactory3, callFactory, responseConverter, callAdapter2);
                    return suspendForResponse;
                }
                super(requestFactory3, callFactory, responseConverter, callAdapter2, 0);
                return suspendForBody;
            }
            throw Utils.methodError(method2, "Response must include generic type (e.g., Response<String>)", new Object[i4]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("'");
        stringBuilder.append(Utils.getRawType(responseType).getName());
        stringBuilder.append("' is not a valid response body type. Did you mean ResponseBody?");
        throw Utils.methodError(method2, stringBuilder.toString(), new Object[i4]);
    }

    protected abstract ReturnT adapt(retrofit2.Call<ResponseT> call, Object[] object2Arr2);

    final ReturnT invoke(Object[] objectArr) {
        OkHttpCall okHttpCall = new OkHttpCall(this.requestFactory, objectArr, this.callFactory, this.responseConverter);
        return adapt(okHttpCall, objectArr);
    }
}
