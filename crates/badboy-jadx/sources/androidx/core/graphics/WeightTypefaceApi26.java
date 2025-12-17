package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
final class WeightTypefaceApi26 {

    private static final String NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD = "nativeCreateFromTypefaceWithExactStyle";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor = null;
    private static final Method sNativeCreateFromTypefaceWithExactStyle = null;
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache;
    static {
        Field declaredField = Typeface.class.getDeclaredField("native_instance");
        Class[] arr = new Class[3];
        final int i3 = 0;
        arr[i3] = Long.TYPE;
        final int i4 = 1;
        arr[i4] = Integer.TYPE;
        arr[2] = Boolean.TYPE;
        Typeface.class.getDeclaredMethod("nativeCreateFromTypefaceWithExactStyle", arr).setAccessible(i4);
        Class[] arr2 = new Class[i4];
        arr2[i3] = Long.TYPE;
        Typeface.class.getDeclaredConstructor(arr2).setAccessible(i4);
    }

    private static Typeface create(long nativeInstance) {
        final int i = 0;
        return (Typeface)WeightTypefaceApi26.sConstructor.newInstance(/* result */);
    }

    static Typeface createWeightStyle(Typeface base, int weight, boolean italic) {
        Object innerCache;
        Object sWeightTypefaceCache;
        int i;
        if (!WeightTypefaceApi26.isPrivateApiAvailable()) {
            return null;
        }
        i3 |= italic;
        final Object sWeightCacheLock = WeightTypefaceApi26.sWeightCacheLock;
        final long nativeInstance = WeightTypefaceApi26.getNativeInstance(base);
        innerCache = WeightTypefaceApi26.sWeightTypefaceCache.get(nativeInstance);
        synchronized (sWeightCacheLock) {
            SparseArray sparseArray = new SparseArray(4);
            WeightTypefaceApi26.sWeightTypefaceCache.put(nativeInstance, obj3);
            Typeface create = WeightTypefaceApi26.create(WeightTypefaceApi26.nativeCreateFromTypefaceWithExactStyle(nativeInstance, obj3, weight));
            innerCache.put(i4, create);
            return create;
        }
    }

    private static long getNativeInstance(Typeface typeface) {
        try {
            return WeightTypefaceApi26.sNativeInstance.getLong(typeface);
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
        }
    }

    private static boolean isPrivateApiAvailable() {
        int i;
        i = WeightTypefaceApi26.sNativeInstance != null ? 1 : 0;
        return i;
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long nativeInstance, int weight, boolean italic) {
        try {
            return (Long)WeightTypefaceApi26.sNativeCreateFromTypefaceWithExactStyle.invoke(0, /* result */).longValue();
            RuntimeException runtimeException = new RuntimeException(e);
            throw runtimeException;
            runtimeException = new RuntimeException(e);
            throw runtimeException;
        }
    }
}
