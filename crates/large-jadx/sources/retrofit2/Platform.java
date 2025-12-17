package retrofit2;

import android.os.Build.VERSION;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
class Platform {

    private static final retrofit2.Platform PLATFORM;
    private final boolean hasJava8Types;
    private final Constructor<MethodHandles.Lookup> lookupConstructor;

    static final class Android extends retrofit2.Platform {
        Android() {
            int i;
            i = Build.VERSION.SDK_INT >= 24 ? 1 : 0;
            super(i);
        }

        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            Platform.Android.MainThreadExecutor mainThreadExecutor = new Platform.Android.MainThreadExecutor();
            return mainThreadExecutor;
        }

        Object invokeDefaultMethod(Method method, Class<?> class2, Object object3, Object... object4Arr4) {
            if (Build.VERSION.SDK_INT < 26) {
            } else {
                return super.invokeDefaultMethod(method, class2, object3, object4Arr4);
            }
            UnsupportedOperationException obj3 = new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
            throw obj3;
        }
    }
    static {
        Platform.PLATFORM = Platform.findPlatform();
    }

    Platform(boolean z) {
        int declaredConstructor;
        Class[] arr;
        Class tYPE;
        int i;
        boolean obj5;
        super();
        this.hasJava8Types = z;
        declaredConstructor = 0;
        if (z) {
            arr = new Class[2];
            i = 1;
            arr[i] = Integer.TYPE;
            MethodHandles.Lookup.class.getDeclaredConstructor(arr).setAccessible(i);
        }
        this.lookupConstructor = declaredConstructor;
    }

    private static retrofit2.Platform findPlatform() {
        retrofit2.Platform platform;
        String str;
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            platform = new Platform.Android();
        } else {
            platform = new Platform(1);
        }
        return platform;
    }

    static retrofit2.Platform get() {
        return Platform.PLATFORM;
    }

    List<? extends retrofit2.CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
        int i;
        retrofit2.CallAdapter.Factory iNSTANCE;
        List obj4;
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
        if (this.hasJava8Types) {
            obj4 = new CallAdapter.Factory[2];
            obj4 = Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory);
        } else {
            obj4 = Collections.singletonList(defaultCallAdapterFactory);
        }
        return obj4;
    }

    int defaultCallAdapterFactoriesSize() {
        int i;
        i = this.hasJava8Types ? 2 : 1;
        return i;
    }

    Executor defaultCallbackExecutor() {
        return null;
    }

    List<? extends retrofit2.Converter.Factory> defaultConverterFactories() {
        List singletonList;
        if (this.hasJava8Types) {
            singletonList = Collections.singletonList(OptionalConverterFactory.INSTANCE);
        } else {
            singletonList = Collections.emptyList();
        }
        return singletonList;
    }

    int defaultConverterFactoriesSize() {
        return this.hasJava8Types;
    }

    Object invokeDefaultMethod(Method method, Class<?> class2, Object object3, Object... object4Arr4) {
        Object instance;
        Object[] arr;
        int i;
        Integer valueOf;
        Constructor lookupConstructor = this.lookupConstructor;
        if (lookupConstructor != null) {
            arr = new Object[2];
            instance = lookupConstructor.newInstance(class2, -1);
        } else {
            instance = MethodHandles.lookup();
        }
        return instance.unreflectSpecial(method, class2).bindTo(object3).invokeWithArguments(object4Arr4);
    }

    boolean isDefaultMethod(Method method) {
        boolean obj2;
        if (this.hasJava8Types && method.isDefault()) {
            obj2 = method.isDefault() ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
