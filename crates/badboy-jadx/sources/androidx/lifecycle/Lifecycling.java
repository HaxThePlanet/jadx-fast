package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0007J \u0010\u0011\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0\u000c2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002J\u001e\u0010\u0013\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u00020\r\u0018\u00010\u000c2\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\tH\u0002J\u0014\u0010\u0015\u001a\u00020\u00052\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\tH\u0002J\u0014\u0010\u0016\u001a\u00020\u00052\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\tH\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u000c\u0010\u0014\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t\u0012\u0004\u0012\u00020\u00050\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001a \u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t\u0012\u0012\u0012\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\r0\u000c0\u000b0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Landroidx/lifecycle/Lifecycling;", "", "<init>", "()V", "REFLECTIVE_CALLBACK", "", "GENERATED_CALLBACK", "callbackCache", "", "Ljava/lang/Class;", "classToAdapters", "", "Ljava/lang/reflect/Constructor;", "Landroidx/lifecycle/GeneratedAdapter;", "lifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "object", "createGeneratedAdapter", "constructor", "generatedConstructor", "klass", "getObserverConstructorType", "resolveObserverCallbackType", "isLifecycleParent", "", "getAdapterName", "", "className", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Lifecycling {

    private static final int GENERATED_CALLBACK = 2;
    public static final androidx.lifecycle.Lifecycling INSTANCE = null;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static final Map<Class<?>, Integer> callbackCache;
    private static final Map<Class<?>, List<Constructor<? extends androidx.lifecycle.GeneratedAdapter>>> classToAdapters;
    static {
        Lifecycling lifecycling = new Lifecycling();
        Lifecycling.INSTANCE = lifecycling;
        HashMap hashMap = new HashMap();
        Lifecycling.callbackCache = (Map)hashMap;
        HashMap hashMap2 = new HashMap();
        Lifecycling.classToAdapters = (Map)hashMap2;
    }

    private final androidx.lifecycle.GeneratedAdapter createGeneratedAdapter(Constructor<? extends androidx.lifecycle.GeneratedAdapter> constructor, Object object) {
        Object instance = constructor.newInstance(/* result */);
        Intrinsics.checkNotNull(instance);
        return (GeneratedAdapter)instance;
    }

    private final Constructor<? extends androidx.lifecycle.GeneratedAdapter> generatedConstructor(Class<?> klass) {
        java.lang.Package package;
        String name;
        int i2;
        String substring;
        Constructor declaredConstructor;
        String str;
        int i3;
        String string;
        int i;
        package = klass.getPackage();
        final String canonicalName = klass.getCanonicalName();
        if (package != null) {
            try {
                name = package.getName();
                name = "";
                Intrinsics.checkNotNull(name);
                int i6 = 0;
                final int i7 = 1;
                if ((CharSequence)name.length() == 0) {
                } else {
                }
                i2 = i7;
                i2 = i6;
                if (i2 != 0) {
                } else {
                }
                substring = canonicalName;
                Intrinsics.checkNotNull(canonicalName);
                Intrinsics.checkNotNullExpressionValue(canonicalName.substring(length2 += i7), "substring(...)");
                Intrinsics.checkNotNull(substring);
                String adapterName = Lifecycling.getAdapterName(substring);
                if ((CharSequence)name.length() == 0) {
                } else {
                }
                i3 = i7;
                i3 = i6;
                if (i3 != 0) {
                } else {
                }
                string = adapterName;
                StringBuilder stringBuilder = new StringBuilder();
                string = stringBuilder.append(name).append('.').append(adapterName).toString();
                Class forName = Class.forName(string);
                Intrinsics.checkNotNull(forName, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
                Class[] arr = new Class[i7];
                arr[i6] = klass;
                declaredConstructor = forName.getDeclaredConstructor(arr);
                if (!declaredConstructor.isAccessible()) {
                }
                declaredConstructor.setAccessible(i7);
                RuntimeException runtimeException = new RuntimeException((Throwable)e);
                throw runtimeException;
                int i5 = 0;
                return declaredConstructor;
            }
        } else {
        }
    }

    @JvmStatic
    public static final String getAdapterName(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(StringsKt.replace$default(className, ".", "_", false, 4, 0)).append("_LifecycleAdapter").toString();
    }

    private final int getObserverConstructorType(Class<?> klass) {
        Object obj = Lifecycling.callbackCache.get(klass);
        if ((Integer)obj != null) {
            return (Integer)obj.intValue();
        }
        int resolveObserverCallbackType = resolveObserverCallbackType(klass);
        Lifecycling.callbackCache.put(klass, Integer.valueOf(resolveObserverCallbackType));
        return resolveObserverCallbackType;
    }

    private final boolean isLifecycleParent(Class<?> klass) {
        boolean assignableFrom;
        int i;
        if (klass != null && LifecycleObserver.class.isAssignableFrom(klass)) {
            i = LifecycleObserver.class.isAssignableFrom(klass) ? 1 : 0;
        } else {
        }
        return i;
    }

    @JvmStatic
    public static final androidx.lifecycle.LifecycleEventObserver lifecycleEventObserver(Object object) {
        int i;
        androidx.lifecycle.GeneratedAdapter generatedAdapter;
        Object obj;
        Intrinsics.checkNotNullParameter(object, "object");
        boolean z = object instanceof LifecycleEventObserver;
        final boolean z2 = object instanceof DefaultLifecycleObserver;
        if (z && z2) {
            if (z2) {
                DefaultLifecycleObserverAdapter defaultLifecycleObserverAdapter2 = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver)object, (LifecycleEventObserver)object);
                return (LifecycleEventObserver)defaultLifecycleObserverAdapter2;
            }
        }
        if (z2) {
            DefaultLifecycleObserverAdapter defaultLifecycleObserverAdapter = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver)object, 0);
            return (LifecycleEventObserver)defaultLifecycleObserverAdapter;
        }
        if (z) {
            return (LifecycleEventObserver)object;
        }
        Class class = object.getClass();
        Object obj5 = Lifecycling.classToAdapters.get(class);
        Intrinsics.checkNotNull(obj5);
        if (Lifecycling.INSTANCE.getObserverConstructorType(class) == 2 && (List)obj5.size() == 1) {
            obj5 = Lifecycling.classToAdapters.get(class);
            Intrinsics.checkNotNull(obj5);
            if ((List)obj5.size() == 1) {
                SingleGeneratedAdapterObserver singleGeneratedAdapterObserver = new SingleGeneratedAdapterObserver(Lifecycling.INSTANCE.createGeneratedAdapter((Constructor)obj5.get(0), object));
                return (LifecycleEventObserver)singleGeneratedAdapterObserver;
            }
            int size2 = obj5.size();
            androidx.lifecycle.GeneratedAdapter[] arr = new GeneratedAdapter[size2];
            while (i < size2) {
                arr[i] = Lifecycling.INSTANCE.createGeneratedAdapter((Constructor)obj5.get(i), object);
                i++;
            }
            CompositeGeneratedAdaptersObserver compositeGeneratedAdaptersObserver = new CompositeGeneratedAdaptersObserver(arr);
            return (LifecycleEventObserver)compositeGeneratedAdaptersObserver;
        }
        ReflectiveGenericLifecycleObserver constructors = new ReflectiveGenericLifecycleObserver(object);
        return (LifecycleEventObserver)constructors;
    }

    private final int resolveObserverCallbackType(Class<?> klass) {
        int adapterConstructors;
        boolean lifecycleParent;
        Object next;
        Object lifecycleParent2;
        int observerConstructorType;
        int i = 1;
        if (klass.getCanonicalName() == null) {
            return i;
        }
        Constructor generatedConstructor = generatedConstructor(klass);
        final int i2 = 2;
        if (generatedConstructor != null) {
            Lifecycling.classToAdapters.put(klass, CollectionsKt.listOf(generatedConstructor));
            return i2;
        }
        if (ClassesInfoCache.sInstance.hasLifecycleMethods(klass)) {
            return i;
        }
        final Class superclass = klass.getSuperclass();
        adapterConstructors = 0;
        Intrinsics.checkNotNull(superclass);
        if (isLifecycleParent(superclass) && getObserverConstructorType(superclass) == i) {
            Intrinsics.checkNotNull(superclass);
            if (getObserverConstructorType(superclass) == i) {
                return i;
            }
            next = Lifecycling.classToAdapters.get(superclass);
            Intrinsics.checkNotNull(next);
            lifecycleParent = new ArrayList((Collection)next);
            adapterConstructors = lifecycleParent;
        }
        Iterator iterator = ArrayIteratorKt.iterator(klass.getInterfaces());
        for (Class next : iterator) {
            Intrinsics.checkNotNull(next);
            if (adapterConstructors == 0) {
            }
            lifecycleParent2 = Lifecycling.classToAdapters.get(next);
            Intrinsics.checkNotNull(lifecycleParent2);
            adapterConstructors.addAll((Collection)lifecycleParent2);
            observerConstructorType = new ArrayList();
            adapterConstructors = observerConstructorType;
        }
        if (adapterConstructors != 0) {
            Lifecycling.classToAdapters.put(klass, adapterConstructors);
            return i2;
        }
        return i;
    }
}
