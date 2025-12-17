package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
final class WeightTypefaceApi21 {

    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor = null;
    private static final Method sNativeCreateFromTypeface = null;
    private static final Method sNativeCreateWeightAlias = null;
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache;
    static {
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            int i = 2;
            Class[] arr2 = new Class[i];
            final int i3 = 0;
            arr2[i3] = Long.TYPE;
            final int i4 = 1;
            arr2[i4] = Integer.TYPE;
            Typeface.class.getDeclaredMethod("nativeCreateFromTypeface", arr2).setAccessible(i4);
            Class[] arr = new Class[i];
            arr[i3] = Long.TYPE;
            arr[i4] = Integer.TYPE;
            Typeface.class.getDeclaredMethod("nativeCreateWeightAlias", arr).setAccessible(i4);
            Class[] arr3 = new Class[i4];
            arr3[i3] = Long.TYPE;
            Typeface.class.getDeclaredConstructor(arr3).setAccessible(i4);
            Class cls = object.getClass();
            cls = cls.getName();
            String nativeCreateFromTypeface = "WeightTypeface";
            Log.e(nativeCreateFromTypeface, cls, object);
            cls = null;
            nativeCreateFromTypeface = null;
            Throwable object = cls;
            cls = nativeCreateFromTypeface;
            nativeCreateFromTypeface = nativeCreateWeightAlias;
            cls = 3;
            object = new LongSparseArray(cls);
            WeightTypefaceApi21.sWeightTypefaceCache = object;
            object = new Object();
            WeightTypefaceApi21.sWeightCacheLock = object;
        }
    }

    private static Typeface create(long nativeInstance) {
        final int i = 0;
        return (Typeface)WeightTypefaceApi21.sConstructor.newInstance(/* result */);
    }

    static Typeface createWeightStyle(Typeface base, int weight, boolean italic) {
        Object innerCache;
        Object sWeightTypefaceCache;
        Typeface create;
        int i;
        if (!WeightTypefaceApi21.isPrivateApiAvailable()) {
            return null;
        }
        i2 |= italic;
        final Object sWeightCacheLock = WeightTypefaceApi21.sWeightCacheLock;
        final long nativeInstance = WeightTypefaceApi21.getNativeInstance(base);
        innerCache = WeightTypefaceApi21.sWeightTypefaceCache.get(nativeInstance);
        synchronized (sWeightCacheLock) {
            SparseArray sparseArray = new SparseArray(4);
            WeightTypefaceApi21.sWeightTypefaceCache.put(nativeInstance, obj3);
            if (italic == base.isItalic()) {
                create = WeightTypefaceApi21.create(WeightTypefaceApi21.nativeCreateWeightAlias(nativeInstance, obj3));
            } else {
                create = WeightTypefaceApi21.create(WeightTypefaceApi21.nativeCreateFromTypefaceWithExactStyle(nativeInstance, obj3, weight));
            }
            innerCache.put(i3, create);
            return create;
        }
    }

    private static long getNativeInstance(Typeface typeface) {
        try {
            return WeightTypefaceApi21.sNativeInstance.getLong(typeface);
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
        }
    }

    private static boolean isPrivateApiAvailable() {
        int i;
        i = WeightTypefaceApi21.sNativeInstance != null ? 1 : 0;
        return i;
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long nativeInstance, int weight, boolean italic) {
        int i;
        i = obj8 != null ? 2 : 0;
        int i2 = 0;
        return (Long)WeightTypefaceApi21.sNativeCreateWeightAlias.invoke(i2, /* result */).longValue();
    }

    private static long nativeCreateWeightAlias(long nativeInstance, int weight) {
        try {
            return (Long)WeightTypefaceApi21.sNativeCreateWeightAlias.invoke(0, /* result */).longValue();
            RuntimeException runtimeException = new RuntimeException(e);
            throw runtimeException;
            runtimeException = new RuntimeException(e);
            throw runtimeException;
        }
    }
}
