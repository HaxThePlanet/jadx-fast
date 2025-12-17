package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class TypefaceCompatApi26Impl extends androidx.core.graphics.TypefaceCompatApi21Impl {

    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation = null;
    protected final Method mAddFontFromAssetManager = null;
    protected final Method mAddFontFromBuffer = null;
    protected final Method mCreateFromFamiliesWithDefault = null;
    protected final Class<?> mFontFamily = null;
    protected final Constructor<?> mFontFamilyCtor = null;
    protected final Method mFreeze = null;
    public TypefaceCompatApi26Impl() {
        super();
        final Class fontFamily = obtainFontFamily();
        final Constructor fontFamilyCtor = obtainFontFamilyCtor(fontFamily);
        final Method addFontFromAssetManagerMethod = obtainAddFontFromAssetManagerMethod(fontFamily);
        final Method addFontFromBufferMethod = obtainAddFontFromBufferMethod(fontFamily);
        final Method freezeMethod = obtainFreezeMethod(fontFamily);
        final Method abortCreationMethod = obtainAbortCreationMethod(fontFamily);
        final Method createFromFamiliesWithDefaultMethod = obtainCreateFromFamiliesWithDefaultMethod(fontFamily);
    }

    private void abortCreation(Object family) {
        Method mAbortCreation;
        try {
            this.mAbortCreation.invoke(family, new Object[0]);
        }
    }

    private boolean addFontFromAssetManager(Context context, Object family, String fileName, int ttcIndex, int weight, int style, FontVariationAxis[] axes) {
        final int i = 0;
        return (Boolean)this.mAddFontFromAssetManager.invoke(family, /* result */).booleanValue();
    }

    private boolean addFontFromBuffer(Object family, ByteBuffer buffer, int ttcIndex, int weight, int style) {
        try {
            return (Boolean)this.mAddFontFromBuffer.invoke(family, /* result */).booleanValue();
            return 0;
        }
    }

    private boolean freeze(Object family) {
        return (Boolean)this.mFreeze.invoke(family, new Object[0]).booleanValue();
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        Object mAddFontFromAssetManager;
        int i;
        String str;
        if (this.mAddFontFromAssetManager == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        i = this.mAddFontFromAssetManager != null ? 1 : 0;
        return i;
    }

    private Object newFamily() {
        try {
            return this.mFontFamilyCtor.newInstance(new Object[0]);
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl
    protected Typeface createFromFamiliesWithDefault(Object family) {
        Object instance = Array.newInstance(this.mFontFamily, 1);
        Array.set(instance, 0, family);
        int i4 = -1;
        return (Typeface)this.mCreateFromFamiliesWithDefault.invoke(0, /* result */);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry entry, Resources resources, int style) {
        int i;
        Context context2;
        boolean fontFromAssetManager;
        int ttcIndex;
        int weight;
        boolean italic;
        FontVariationAxis[] fontVariationSettings;
        int i2;
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry;
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, entry, resources, style);
        }
        final Object family = newFamily();
        int i3 = 0;
        if (family == null) {
            return i3;
        }
        final FontResourcesParserCompat.FontFileResourceEntry[] entries = entry.getEntries();
        i2 = i;
        while (i2 < entries.length) {
            fontFileResourceEntry = entries[i2];
            i2++;
        }
        if (!freeze(family)) {
            return i3;
        }
        return createFromFamiliesWithDefault(family);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fonts, int style) {
        int i;
        int fontFromBuffer;
        Throwable th2;
        boolean italic;
        int atLeastOneFont;
        int i2;
        FontsContractCompat.FontInfo fontInfo;
        final Object obj = this;
        final CancellationSignal cancellationSignal2 = cancellationSignal;
        final FontsContractCompat.FontInfo[] objArr = fonts;
        final int i4 = style;
        final int i5 = 0;
        if (objArr.length < 1) {
            return i5;
        }
        FontsContractCompat.FontInfo bestInfo = obj.findBestInfo(objArr, i4);
        ParcelFileDescriptor parcelFileDescriptor = fileDescriptor;
        if (!obj.isFontFamilyPrivateAPIAvailable() && parcelFileDescriptor == null && parcelFileDescriptor != null) {
            bestInfo = obj.findBestInfo(objArr, i4);
            parcelFileDescriptor = fileDescriptor;
            if (parcelFileDescriptor == null) {
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                return i5;
            }
            Typeface.Builder builder = new Typeface.Builder(parcelFileDescriptor.getFileDescriptor());
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            return builder.setWeight(bestInfo.getWeight()).setItalic(bestInfo.isItalic()).build();
        }
        Object family = obj.newFamily();
        if (family == null) {
            return i5;
        }
        atLeastOneFont = i;
        i2 = fontFromBuffer;
        while (i2 < objArr.length) {
            fontInfo = objArr[i2];
            i = TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, objArr, cancellationSignal2).get(fontInfo.getUri());
            atLeastOneFont = th2;
            i2++;
        }
        if (atLeastOneFont == 0) {
            obj.abortCreation(family);
            return i5;
        }
        if (!obj.freeze(family)) {
            return i5;
        }
        try {
            Typeface fromFamiliesWithDefault = obj.createFromFamiliesWithDefault(family);
            if (fromFamiliesWithDefault == null) {
            }
            return i5;
            return Typeface.create(fromFamiliesWithDefault, i4);
        } catch (Throwable th) {
        }
    }

    public Typeface createFromFontInfoWithFallback(Context context, CancellationSignal cancellationSignal2, List list3, int i4) {
        return super.createFromFontInfoWithFallback(context, cancellationSignal2, list3, i4);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int id, String path, int style) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, id, path, style);
        }
        final Object family = newFamily();
        int i = 0;
        if (family == null) {
            return i;
        }
        if (!this.addFontFromAssetManager(context, family, path, 0, -1, -1, 0)) {
            abortCreation(family);
            return i;
        }
        if (!freeze(family)) {
            return i;
        }
        return createFromFamiliesWithDefault(family);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl
    Typeface createWeightStyle(Context context, Typeface base, int weight, boolean italic) {
        Typeface out;
        Typeface weightStyle;
        int i = 0;
        if (WeightTypefaceApi26.createWeightStyle(base, weight, italic) == null) {
            out = super.createWeightStyle(context, base, weight, italic);
        }
        return out;
    }

    protected Method obtainAbortCreationMethod(Class<?> class) throws java.lang.NoSuchMethodException {
        return class.getMethod("abortCreation", new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class<?> class) throws java.lang.NoSuchMethodException {
        Class[] arr = new Class[8];
        return class.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method obtainAddFontFromBufferMethod(Class<?> class) throws java.lang.NoSuchMethodException {
        Class[] arr = new Class[5];
        return class.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> class) throws java.lang.NoSuchMethodException {
        final int i = 1;
        Class[] arr = new Class[3];
        arr[i] = Integer.TYPE;
        arr[2] = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr);
        declaredMethod.setAccessible(i);
        return declaredMethod;
    }

    protected Class<?> obtainFontFamily() throws java.lang.ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> obtainFontFamilyCtor(Class<?> class) throws java.lang.NoSuchMethodException {
        return class.getConstructor(new Class[0]);
    }

    protected Method obtainFreezeMethod(Class<?> class) throws java.lang.NoSuchMethodException {
        return class.getMethod("freeze", new Class[0]);
    }
}
