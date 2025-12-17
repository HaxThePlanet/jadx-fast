package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
class TypefaceCompatApi24Impl extends androidx.core.graphics.TypefaceCompatBaseImpl {

    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle = null;
    private static final Method sCreateFromFamiliesWithDefault = null;
    private static final Class<?> sFontFamily = null;
    private static final Constructor<?> sFontFamilyCtor = null;
    static {
        try {
            Class forName = Class.forName("android.graphics.FontFamily");
            int i = 0;
            Constructor constructor = forName.getConstructor(new Class[i]);
            Class[] arr2 = new Class[5];
            arr2[i] = ByteBuffer.class;
            int i5 = 1;
            arr2[i5] = Integer.TYPE;
            arr2[2] = List.class;
            arr2[3] = Integer.TYPE;
            arr2[4] = Boolean.TYPE;
            Method method2 = forName.getMethod("addFontWeightStyle", arr2);
            Class[] arr3 = new Class[i5];
            arr3[i] = Array.newInstance(forName, i5).getClass();
            Method method = Typeface.class.getMethod("createFromFamiliesWithDefault", arr3);
            Class fontFamilyClass = e.getClass();
            fontFamilyClass = fontFamilyClass.getName();
            Log.e("TypefaceCompatApi24Impl", fontFamilyClass, e);
            fontFamilyClass = null;
            int i2 = 0;
            Throwable e = fontFamilyClass;
            fontFamilyClass = i3;
        }
    }

    private static boolean addFontWeightStyle(Object family, ByteBuffer buffer, int ttcIndex, int weight, boolean style) {
        try {
            return (Boolean)TypefaceCompatApi24Impl.sAddFontWeightStyle.invoke(family, /* result */).booleanValue();
            return 0;
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object family) {
        Object instance = Array.newInstance(TypefaceCompatApi24Impl.sFontFamily, 1);
        Array.set(instance, 0, family);
        return (Typeface)TypefaceCompatApi24Impl.sCreateFromFamiliesWithDefault.invoke(0, /* result */);
    }

    public static boolean isUsable() {
        Object sAddFontWeightStyle;
        int i;
        String str;
        if (TypefaceCompatApi24Impl.sAddFontWeightStyle == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        i = TypefaceCompatApi24Impl.sAddFontWeightStyle != null ? 1 : 0;
        return i;
    }

    private static Object newFamily() {
        try {
            return TypefaceCompatApi24Impl.sFontFamilyCtor.newInstance(new Object[0]);
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry entry, Resources resources, int style) {
        int i;
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry;
        ByteBuffer copyToDirectBuffer;
        boolean fontWeightStyle;
        int weight;
        boolean italic;
        final Object family = TypefaceCompatApi24Impl.newFamily();
        int i2 = 0;
        if (family == null) {
            return i2;
        }
        final FontResourcesParserCompat.FontFileResourceEntry[] entries = entry.getEntries();
        i = 0;
        while (i < entries.length) {
            fontFileResourceEntry = entries[i];
            copyToDirectBuffer = TypefaceCompatUtil.copyToDirectBuffer(context, resources, fontFileResourceEntry.getResourceId());
            i++;
        }
        return TypefaceCompatApi24Impl.createFromFamiliesWithDefault(family);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fonts, int style) {
        int i;
        Object obj;
        android.net.Uri uri;
        Object buffer;
        boolean fontWeightStyle;
        int weight;
        boolean italic;
        final Object family = TypefaceCompatApi24Impl.newFamily();
        int i2 = 0;
        if (family == null) {
            return i2;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        i = 0;
        while (i < fonts.length) {
            obj = fonts[i];
            uri = obj.getUri();
            if ((ByteBuffer)simpleArrayMap.get(uri) == null) {
            }
            i++;
            simpleArrayMap.put(uri, TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
        }
        Typeface fromFamiliesWithDefault = TypefaceCompatApi24Impl.createFromFamiliesWithDefault(family);
        if (fromFamiliesWithDefault == null) {
            return i2;
        }
        return Typeface.create(fromFamiliesWithDefault, style);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    Typeface createWeightStyle(Context context, Typeface base, int weight, boolean italic) {
        Typeface out;
        Typeface weightStyle;
        int i = 0;
        if (WeightTypefaceApi21.createWeightStyle(base, weight, italic) == null) {
            out = super.createWeightStyle(context, base, weight, italic);
        }
        return out;
    }
}
