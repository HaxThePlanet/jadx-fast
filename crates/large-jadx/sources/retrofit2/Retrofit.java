package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call.Factory;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public final class Retrofit {

    final HttpUrl baseUrl;
    final List<retrofit2.CallAdapter.Factory> callAdapterFactories;
    final Call.Factory callFactory;
    final Executor callbackExecutor;
    final List<retrofit2.Converter.Factory> converterFactories;
    private final Map<Method, retrofit2.ServiceMethod<?>> serviceMethodCache;
    final boolean validateEagerly;

    public static final class Builder {

        private HttpUrl baseUrl;
        private final List<retrofit2.CallAdapter.Factory> callAdapterFactories;
        private Call.Factory callFactory;
        private Executor callbackExecutor;
        private final List<retrofit2.Converter.Factory> converterFactories;
        private final retrofit2.Platform platform;
        private boolean validateEagerly;
        public Builder() {
            super(Platform.get());
        }

        Builder(retrofit2.Platform platform) {
            super();
            ArrayList arrayList = new ArrayList();
            this.converterFactories = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.callAdapterFactories = arrayList2;
            this.platform = platform;
        }

        Builder(retrofit2.Retrofit retrofit) {
            int i2;
            int i;
            List converterFactories;
            int defaultCallAdapterFactoriesSize;
            Object obj;
            super();
            ArrayList arrayList = new ArrayList();
            this.converterFactories = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.callAdapterFactories = arrayList2;
            retrofit2.Platform platform = Platform.get();
            this.platform = platform;
            this.callFactory = retrofit.callFactory;
            this.baseUrl = retrofit.baseUrl;
            i2 = 1;
            while (i2 < size -= defaultConverterFactoriesSize) {
                this.converterFactories.add((Converter.Factory)retrofit.converterFactories.get(i2));
                i2++;
            }
            i = 0;
            while (i < size2 -= defaultCallAdapterFactoriesSize) {
                this.callAdapterFactories.add((CallAdapter.Factory)retrofit.callAdapterFactories.get(i));
                i++;
            }
            this.callbackExecutor = retrofit.callbackExecutor;
            this.validateEagerly = retrofit.validateEagerly;
        }

        public retrofit2.Retrofit.Builder addCallAdapterFactory(retrofit2.CallAdapter.Factory callAdapter$Factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.callAdapterFactories.add((CallAdapter.Factory)factory);
            return this;
        }

        public retrofit2.Retrofit.Builder addConverterFactory(retrofit2.Converter.Factory converter$Factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.converterFactories.add((Converter.Factory)factory);
            return this;
        }

        public retrofit2.Retrofit.Builder baseUrl(String string) {
            Objects.requireNonNull(string, "baseUrl == null");
            return baseUrl(HttpUrl.get(string));
        }

        public retrofit2.Retrofit.Builder baseUrl(URL uRL) {
            Objects.requireNonNull(uRL, "baseUrl == null");
            return baseUrl(HttpUrl.get(uRL.toString()));
        }

        public retrofit2.Retrofit.Builder baseUrl(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            List pathSegments = httpUrl.pathSegments();
            if (!"".equals(pathSegments.get(size--))) {
            } else {
                this.baseUrl = httpUrl;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("baseUrl must end in /: ");
            stringBuilder.append(httpUrl);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        public retrofit2.Retrofit build() {
            Call.Factory okHttpClient;
            Executor defaultCallbackExecutor;
            if (this.baseUrl == null) {
            } else {
                if (this.callFactory == null) {
                    okHttpClient = new OkHttpClient();
                }
                if (this.callbackExecutor == null) {
                    defaultCallbackExecutor = this.platform.defaultCallbackExecutor();
                }
                final Executor executor = defaultCallbackExecutor;
                ArrayList arrayList = new ArrayList(this.callAdapterFactories);
                arrayList.addAll(this.platform.defaultCallAdapterFactories(executor));
                ArrayList arrayList2 = new ArrayList(i += defaultConverterFactoriesSize);
                BuiltInConverters builtInConverters = new BuiltInConverters();
                arrayList2.add(builtInConverters);
                arrayList2.addAll(this.converterFactories);
                arrayList2.addAll(this.platform.defaultConverterFactories());
                super(okHttpClient, this.baseUrl, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.validateEagerly);
                return retrofit2;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Base URL required.");
            throw illegalStateException;
        }

        public List<retrofit2.CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public retrofit2.Retrofit.Builder callFactory(Call.Factory call$Factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.callFactory = (Call.Factory)factory;
            return this;
        }

        public retrofit2.Retrofit.Builder callbackExecutor(Executor executor) {
            Objects.requireNonNull(executor, "executor == null");
            this.callbackExecutor = (Executor)executor;
            return this;
        }

        public retrofit2.Retrofit.Builder client(OkHttpClient okHttpClient) {
            Objects.requireNonNull(okHttpClient, "client == null");
            return callFactory((Call.Factory)okHttpClient);
        }

        public List<retrofit2.Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public retrofit2.Retrofit.Builder validateEagerly(boolean z) {
            this.validateEagerly = z;
            return this;
        }
    }
    Retrofit(Call.Factory call$Factory, HttpUrl httpUrl2, List<retrofit2.Converter.Factory> list3, List<retrofit2.CallAdapter.Factory> list4, Executor executor5, boolean z6) {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.serviceMethodCache = concurrentHashMap;
        this.callFactory = factory;
        this.baseUrl = httpUrl2;
        this.converterFactories = list3;
        this.callAdapterFactories = list4;
        this.callbackExecutor = executor5;
        this.validateEagerly = z6;
    }

    private void validateServiceInterface(Class<?> class) {
        boolean validateEagerly;
        int interfaces;
        Object first;
        boolean length;
        int length2;
        Method method;
        boolean defaultMethod;
        Object obj6;
        if (!class.isInterface()) {
        } else {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(class);
            while (!arrayDeque.isEmpty()) {
                first = arrayDeque.removeFirst();
                Collections.addAll(arrayDeque, first.getInterfaces());
            }
            if (this.validateEagerly) {
                obj6 = class.getDeclaredMethods();
                length2 = 0;
                while (length2 < obj6.length) {
                    method = obj6[length2];
                    if (!Platform.get().isDefaultMethod(method) && !Modifier.isStatic(method.getModifiers())) {
                    }
                    length2++;
                    if (!Modifier.isStatic(method.getModifiers())) {
                    }
                    loadServiceMethod(method);
                }
            }
        }
        obj6 = new IllegalArgumentException("API declarations must be interfaces.");
        throw obj6;
    }

    public HttpUrl baseUrl() {
        return this.baseUrl;
    }

    public retrofit2.CallAdapter<?, ?> callAdapter(Type type, Annotation[] annotation2Arr2) {
        return nextCallAdapter(0, type, annotation2Arr2);
    }

    public List<retrofit2.CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public Call.Factory callFactory() {
        return this.callFactory;
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public List<retrofit2.Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> T create(Class<T> class) {
        validateServiceInterface(class);
        Class[] arr = new Class[1];
        Retrofit.1 anon = new Retrofit.1(this, class);
        return Proxy.newProxyInstance(class.getClassLoader(), arr, anon);
    }

    retrofit2.ServiceMethod<?> loadServiceMethod(Method method) {
        Object annotations;
        Map serviceMethodCache;
        Object obj = this.serviceMethodCache.get(method);
        if ((ServiceMethod)obj != null) {
            return (ServiceMethod)obj;
        }
        Map serviceMethodCache3 = this.serviceMethodCache;
        synchronized (serviceMethodCache3) {
            this.serviceMethodCache.put(method, ServiceMethod.parseAnnotations(this, method));
            return annotations;
        }
    }

    public retrofit2.Retrofit.Builder newBuilder() {
        Retrofit.Builder builder = new Retrofit.Builder(this);
        return builder;
    }

    public retrofit2.CallAdapter<?, ?> nextCallAdapter(retrofit2.CallAdapter.Factory callAdapter$Factory, Type type2, Annotation[] annotation3Arr3) {
        int i;
        String name;
        int i2;
        retrofit2.CallAdapter callAdapter;
        Object obj5;
        Objects.requireNonNull(type2, "returnType == null");
        Objects.requireNonNull(annotation3Arr3, "annotations == null");
        indexOf++;
        i2 = i;
        while (i2 < this.callAdapterFactories.size()) {
            callAdapter = (CallAdapter.Factory)this.callAdapterFactories.get(i2).get(type2, annotation3Arr3, this);
            i2++;
        }
        StringBuilder obj7 = new StringBuilder("Could not locate call adapter for ");
        obj7.append(type2);
        obj7.append(".\n");
        String obj6 = "\n   * ";
        if (factory != null) {
            obj7.append("  Skipped:");
            obj5 = 0;
            while (obj5 < i) {
                obj7.append(obj6);
                obj7.append((CallAdapter.Factory)this.callAdapterFactories.get(obj5).getClass().getName());
                obj5++;
            }
            obj7.append('\n');
        }
        obj7.append("  Tried:");
        while (i < this.callAdapterFactories.size()) {
            obj7.append(obj6);
            obj7.append((CallAdapter.Factory)this.callAdapterFactories.get(i).getClass().getName());
            i++;
        }
        obj5 = new IllegalArgumentException(obj7.toString());
        throw obj5;
    }

    public <T> retrofit2.Converter<T, RequestBody> nextRequestBodyConverter(retrofit2.Converter.Factory converter$Factory, Type type2, Annotation[] annotation3Arr3, Annotation[] annotation4Arr4) {
        int i2;
        int i;
        retrofit2.Converter requestBodyConverter;
        Object obj5;
        String obj8;
        Objects.requireNonNull(type2, "type == null");
        Objects.requireNonNull(annotation3Arr3, "parameterAnnotations == null");
        Objects.requireNonNull(annotation4Arr4, "methodAnnotations == null");
        indexOf++;
        i = i2;
        while (i < this.converterFactories.size()) {
            requestBodyConverter = (Converter.Factory)this.converterFactories.get(i).requestBodyConverter(type2, annotation3Arr3, annotation4Arr4, this);
            i++;
        }
        StringBuilder obj7 = new StringBuilder("Could not locate RequestBody converter for ");
        obj7.append(type2);
        obj7.append(".\n");
        String obj6 = "\n   * ";
        if (factory != null) {
            obj7.append("  Skipped:");
            obj5 = 0;
            while (obj5 < i2) {
                obj7.append(obj6);
                obj7.append((Converter.Factory)this.converterFactories.get(obj5).getClass().getName());
                obj5++;
            }
            obj7.append('\n');
        }
        obj7.append("  Tried:");
        while (i2 < this.converterFactories.size()) {
            obj7.append(obj6);
            obj7.append((Converter.Factory)this.converterFactories.get(i2).getClass().getName());
            i2++;
        }
        obj5 = new IllegalArgumentException(obj7.toString());
        throw obj5;
    }

    public <T> retrofit2.Converter<ResponseBody, T> nextResponseBodyConverter(retrofit2.Converter.Factory converter$Factory, Type type2, Annotation[] annotation3Arr3) {
        int i2;
        String name;
        int i;
        retrofit2.Converter responseBodyConverter;
        Object obj5;
        Objects.requireNonNull(type2, "type == null");
        Objects.requireNonNull(annotation3Arr3, "annotations == null");
        indexOf++;
        i = i2;
        while (i < this.converterFactories.size()) {
            responseBodyConverter = (Converter.Factory)this.converterFactories.get(i).responseBodyConverter(type2, annotation3Arr3, this);
            i++;
        }
        StringBuilder obj7 = new StringBuilder("Could not locate ResponseBody converter for ");
        obj7.append(type2);
        obj7.append(".\n");
        String obj6 = "\n   * ";
        if (factory != null) {
            obj7.append("  Skipped:");
            obj5 = 0;
            while (obj5 < i2) {
                obj7.append(obj6);
                obj7.append((Converter.Factory)this.converterFactories.get(obj5).getClass().getName());
                obj5++;
            }
            obj7.append('\n');
        }
        obj7.append("  Tried:");
        while (i2 < this.converterFactories.size()) {
            obj7.append(obj6);
            obj7.append((Converter.Factory)this.converterFactories.get(i2).getClass().getName());
            i2++;
        }
        obj5 = new IllegalArgumentException(obj7.toString());
        throw obj5;
    }

    public <T> retrofit2.Converter<T, RequestBody> requestBodyConverter(Type type, Annotation[] annotation2Arr2, Annotation[] annotation3Arr3) {
        return nextRequestBodyConverter(0, type, annotation2Arr2, annotation3Arr3);
    }

    public <T> retrofit2.Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotation2Arr2) {
        return nextResponseBodyConverter(0, type, annotation2Arr2);
    }

    public <T> retrofit2.Converter<T, String> stringConverter(Type type, Annotation[] annotation2Arr2) {
        int i;
        retrofit2.Converter stringConverter;
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotation2Arr2, "annotations == null");
        i = 0;
        while (i < this.converterFactories.size()) {
            stringConverter = (Converter.Factory)this.converterFactories.get(i).stringConverter(type, annotation2Arr2, this);
            i++;
        }
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }
}
