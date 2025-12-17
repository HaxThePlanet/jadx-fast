package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
final class WeightTypefaceApi14 {

    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache;
    static {
        try {
            Typeface.class.getDeclaredField("native_instance").setAccessible(true);
            Class cls = object.getClass();
            cls = cls.getName();
            Log.e("WeightTypeface", cls, object);
            cls = null;
            Throwable object = cls;
            cls = 3;
            object = new LongSparseArray(cls);
            WeightTypefaceApi14.sWeightTypefaceCache = object;
            object = new Object();
            WeightTypefaceApi14.sWeightCacheLock = object;
        }
    }

    static Typeface createWeightStyle(androidx.core.graphics.TypefaceCompatBaseImpl compat, Context context, Typeface base, int weight, boolean italic) {
        Object innerCache;
        Object sWeightTypefaceCache;
        Typeface typeface;
        int platformTypefaceCreate;
        if (!WeightTypefaceApi14.isPrivateApiAvailable()) {
            return null;
        }
        i |= italic;
        final Object sWeightCacheLock = WeightTypefaceApi14.sWeightCacheLock;
        final long nativeInstance = WeightTypefaceApi14.getNativeInstance(base);
        innerCache = WeightTypefaceApi14.sWeightTypefaceCache.get(nativeInstance);
        synchronized (sWeightCacheLock) {
            SparseArray sparseArray = new SparseArray(4);
            WeightTypefaceApi14.sWeightTypefaceCache.put(nativeInstance, obj3);
            if (WeightTypefaceApi14.getBestFontFromFamily(compat, context, base, weight, italic) == null) {
                typeface = platformTypefaceCreate;
            }
            innerCache.put(i2, typeface);
            return typeface;
        }
    }

    private static Typeface getBestFontFromFamily(androidx.core.graphics.TypefaceCompatBaseImpl compat, Context context, Typeface base, int weight, boolean italic) {
        final androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = compat.getFontFamily(base);
        if (fontFamily == null) {
            return null;
        }
        return compat.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), weight, italic);
    }

    private static long getNativeInstance(Typeface typeface) {
        try {
            return (Number)WeightTypefaceApi14.sNativeInstance.get(typeface).longValue();
            RuntimeException runtimeException = new RuntimeException(num);
            throw runtimeException;
        }
    }

    private static boolean isPrivateApiAvailable() {
        int i;
        i = WeightTypefaceApi14.sNativeInstance != null ? 1 : 0;
        return i;
    }

    private static Typeface platformTypefaceCreate(Typeface base, int weight, boolean italic) {
        int i;
        int style;
        i = weight >= 600 ? 1 : 0;
        int i3 = 0;
        if (i == 0 && !italic) {
            style = !italic ? 0 : i == 0 ? 2 : !italic ? 1 : 3;
        } else {
        }
        return Typeface.create(base, style);
    }
}
