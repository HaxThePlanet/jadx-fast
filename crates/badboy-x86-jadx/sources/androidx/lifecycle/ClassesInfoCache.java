package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes5.dex */
@Deprecated
final class ClassesInfoCache {

    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    static androidx.lifecycle.ClassesInfoCache sInstance;
    private final Map<Class<?>, androidx.lifecycle.ClassesInfoCache.CallbackInfo> mCallbackMap;
    private final Map<Class<?>, Boolean> mHasLifecycleMethods;

    @Deprecated
    static class CallbackInfo {

        final Map<androidx.lifecycle.Lifecycle.Event, List<androidx.lifecycle.ClassesInfoCache.MethodReference>> mEventToHandlers;
        final Map<androidx.lifecycle.ClassesInfoCache.MethodReference, androidx.lifecycle.Lifecycle.Event> mHandlerToEvent;
        CallbackInfo(Map<androidx.lifecycle.ClassesInfoCache.MethodReference, androidx.lifecycle.Lifecycle.Event> map) {
            Object next;
            Object value;
            Object methodReferences;
            Object mEventToHandlers;
            super();
            this.mHandlerToEvent = map;
            HashMap hashMap = new HashMap();
            this.mEventToHandlers = hashMap;
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                value = (Map.Entry)next.getValue();
                if ((List)this.mEventToHandlers.get((Lifecycle.Event)value) == null) {
                }
                methodReferences.add((ClassesInfoCache.MethodReference)next.getKey());
                ArrayList arrayList = new ArrayList();
                this.mEventToHandlers.put(value, arrayList);
            }
        }

        private static void invokeMethodsForEvent(List<androidx.lifecycle.ClassesInfoCache.MethodReference> list, androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event, Object mWrapped) {
            int i;
            Object obj;
            if (list != null) {
                size--;
                while (i >= 0) {
                    (ClassesInfoCache.MethodReference)list.get(i).invokeCallback(source, event, mWrapped);
                    i--;
                }
            }
        }

        void invokeCallbacks(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event, Object target) {
            ClassesInfoCache.CallbackInfo.invokeMethodsForEvent((List)this.mEventToHandlers.get(event), source, event, target);
            ClassesInfoCache.CallbackInfo.invokeMethodsForEvent((List)this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), source, event, target);
        }
    }

    @Deprecated
    static final class MethodReference {

        final int mCallType;
        final Method mMethod;
        MethodReference(int callType, Method method) {
            super();
            this.mCallType = callType;
            this.mMethod = method;
            this.mMethod.setAccessible(true);
        }

        public boolean equals(Object o) {
            int i;
            int mCallType2;
            int mCallType;
            if (this == o) {
                return 1;
            }
            final int i2 = 0;
            if (o instanceof ClassesInfoCache.MethodReference == null) {
                return i2;
            }
            Object obj = o;
            if (this.mCallType == obj.mCallType && this.mMethod.getName().equals(obj.mMethod.getName())) {
                if (this.mMethod.getName().equals(obj.mMethod.getName())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            return i += i3;
        }

        void invokeCallback(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event, Object target) {
            Method mCallType;
            Object runtimeException;
            try {
                this.mMethod.invoke(target, /* result */);
                this.mMethod.invoke(target, /* result */);
                this.mMethod.invoke(target, new Object[0]);
                runtimeException = new RuntimeException(e);
                throw runtimeException;
                runtimeException = new RuntimeException("Failed to call observer method", e.getCause());
                throw runtimeException;
                Throwable e = e;
                e = 1125899907760128;
            }
        }
    }
    static {
        ClassesInfoCache classesInfoCache = new ClassesInfoCache();
        ClassesInfoCache.sInstance = classesInfoCache;
    }

    ClassesInfoCache() {
        super();
        HashMap hashMap = new HashMap();
        this.mCallbackMap = hashMap;
        HashMap hashMap2 = new HashMap();
        this.mHasLifecycleMethods = hashMap2;
    }

    private androidx.lifecycle.ClassesInfoCache.CallbackInfo createInfo(Class<?> class, Method[] declaredMethods) {
        androidx.lifecycle.ClassesInfoCache.CallbackInfo info;
        Map mHandlerToEvent;
        Method[] declaredMethods2;
        int methodReference;
        int oN_ANY;
        int i3;
        int hasLifecycleMethods;
        Class cls;
        Iterator iterator;
        int i2;
        boolean next;
        Object annotation;
        Object parameterTypes;
        int callType;
        androidx.lifecycle.Lifecycle.Event value;
        int assignableFrom;
        int i;
        int length;
        final Object obj = this;
        final Class cls2 = class;
        final Class superclass = cls2.getSuperclass();
        HashMap hashMap = new HashMap();
        info = obj.getInfo(superclass);
        if (superclass != null && info != null) {
            info = obj.getInfo(superclass);
            if (info != null) {
                hashMap.putAll(info.mHandlerToEvent);
            }
        }
        Class[] interfaces = cls2.getInterfaces();
        methodReference = 0;
        i3 = methodReference;
        while (i3 < interfaces.length) {
            iterator = info2.mHandlerToEvent.entrySet().iterator();
            for (Map.Entry next : iterator) {
                obj.verifyAndPutHandler(hashMap, (ClassesInfoCache.MethodReference)next.getKey(), (Lifecycle.Event)next.getValue(), cls2);
            }
            i3++;
            next = iterator.next();
            obj.verifyAndPutHandler(hashMap, (ClassesInfoCache.MethodReference)(Map.Entry)next.getKey(), (Lifecycle.Event)next.getValue(), cls2);
        }
        if (declaredMethods != null) {
            declaredMethods2 = declaredMethods;
        } else {
            declaredMethods2 = getDeclaredMethods(class);
        }
        hasLifecycleMethods = 0;
        i2 = methodReference;
        while (i2 < declaredMethods2.length) {
            next = declaredMethods2[i2];
            annotation = next.getAnnotation(OnLifecycleEvent.class);
            hasLifecycleMethods = 1;
            parameterTypes = next.getParameterTypes();
            callType = 0;
            value = (OnLifecycleEvent)annotation.value();
            oN_ANY = 1;
            methodReference = new ClassesInfoCache.MethodReference(callType, next);
            obj.verifyAndPutHandler(hashMap, methodReference, value, cls2);
            i2++;
            methodReference = 0;
            callType = 2;
            callType = 1;
        }
        ClassesInfoCache.CallbackInfo callbackInfo = new ClassesInfoCache.CallbackInfo(hashMap);
        obj.mCallbackMap.put(cls2, callbackInfo);
        obj.mHasLifecycleMethods.put(cls2, Boolean.valueOf(hasLifecycleMethods));
        return callbackInfo;
    }

    private Method[] getDeclaredMethods(Class<?> class) {
        try {
            return class.getDeclaredMethods();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", th);
            throw illegalArgumentException;
        }
    }

    private void verifyAndPutHandler(Map<androidx.lifecycle.ClassesInfoCache.MethodReference, androidx.lifecycle.Lifecycle.Event> map, androidx.lifecycle.ClassesInfoCache.MethodReference newHandler, androidx.lifecycle.Lifecycle.Event newEvent, Class<?> class4) {
        final Object obj = map.get(newHandler);
        if ((Lifecycle.Event)obj != null) {
            if (newEvent != (Lifecycle.Event)obj) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Method ").append(newHandler.mMethod.getName()).append(" in ").append(class4.getName()).append(" already declared with different @OnLifecycleEvent value: previous value ").append((Lifecycle.Event)obj).append(", new value ").append(newEvent).toString());
            throw illegalArgumentException;
        }
        if (obj == null) {
            map.put(newHandler, newEvent);
        }
    }

    androidx.lifecycle.ClassesInfoCache.CallbackInfo getInfo(Class<?> class) {
        Object obj = this.mCallbackMap.get(class);
        if ((ClassesInfoCache.CallbackInfo)obj != null) {
            return (ClassesInfoCache.CallbackInfo)obj;
        }
        return createInfo(class, 0);
    }

    boolean hasLifecycleMethods(Class<?> class) {
        int i;
        Method method;
        java.lang.annotation.Annotation annotation;
        Object obj = this.mHasLifecycleMethods.get(class);
        if ((Boolean)obj != null) {
            return (Boolean)obj.booleanValue();
        }
        Method[] declaredMethods = getDeclaredMethods(class);
        final int i3 = 0;
        i = i3;
        while (i < declaredMethods.length) {
            i++;
        }
        this.mHasLifecycleMethods.put(class, Boolean.valueOf(i3));
        return i3;
    }
}
