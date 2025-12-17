package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
class TypefaceCompatApi21Impl extends androidx.core.graphics.TypefaceCompatBaseImpl {

    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle;
    private static Method sCreateFromFamiliesWithDefault;
    private static Class<?> sFontFamily;
    private static Constructor<?> sFontFamilyCtor;
    private static boolean sHasInitBeenCalled;
    static {
        TypefaceCompatApi21Impl.sHasInitBeenCalled = false;
    }

    private static boolean addFontWeightStyle(Object family, String name, int weight, boolean style) {
        TypefaceCompatApi21Impl.init();
        return (Boolean)TypefaceCompatApi21Impl.sAddFontWeightStyle.invoke(family, /* result */).booleanValue();
    }

    private static Typeface createFromFamiliesWithDefault(Object family) {
        TypefaceCompatApi21Impl.init();
        Object instance = Array.newInstance(TypefaceCompatApi21Impl.sFontFamily, 1);
        Array.set(instance, 0, family);
        return (Typeface)TypefaceCompatApi21Impl.sCreateFromFamiliesWithDefault.invoke(0, /* result */);
    }

    private File getFile(ParcelFileDescriptor fd) {
        StringBuilder stringBuilder = new StringBuilder();
        String readlink = Os.readlink(stringBuilder.append("/proc/self/fd/").append(fd.getFd()).toString());
        if (OsConstants.S_ISREG(stat.st_mode)) {
            try {
                File file = new File(readlink);
                return file;
                return null;
                return obj0;
            }
        }
    }

    private static void init() {
        Method method;
        Class forName;
        int i;
        Constructor constructor;
        Method method2;
        if (TypefaceCompatApi21Impl.sHasInitBeenCalled) {
        }
        int i2 = 1;
        TypefaceCompatApi21Impl.sHasInitBeenCalled = i2;
        forName = Class.forName("android.graphics.FontFamily");
        i = 0;
        constructor = forName.getConstructor(new Class[i]);
        Class[] arr3 = new Class[3];
        arr3[i] = String.class;
        arr3[i2] = Integer.TYPE;
        arr3[2] = Boolean.TYPE;
        method2 = forName.getMethod("addFontWeightStyle", arr3);
        Class[] arr = new Class[i2];
        arr[i] = Array.newInstance(forName, i2).getClass();
        method = Typeface.class.getMethod("createFromFamiliesWithDefault", arr);
        TypefaceCompatApi21Impl.sFontFamilyCtor = constructor;
        TypefaceCompatApi21Impl.sFontFamily = forName;
        TypefaceCompatApi21Impl.sAddFontWeightStyle = method2;
        TypefaceCompatApi21Impl.sCreateFromFamiliesWithDefault = method;
    }

    private static Object newFamily() {
        TypefaceCompatApi21Impl.init();
        return TypefaceCompatApi21Impl.sFontFamilyCtor.newInstance(new Object[0]);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry entry, Resources resources, int style) {
        int i;
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry;
        File tempFile;
        int i2;
        boolean fontWeightStyle;
        int weight;
        boolean italic;
        final Object family = TypefaceCompatApi21Impl.newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = entry.getEntries();
        i = 0;
        while (i < entries.length) {
            fontFileResourceEntry = entries[i];
            tempFile = TypefaceCompatUtil.getTempFile(context);
            i2 = 0;
            tempFile.delete();
            i++;
        }
        return TypefaceCompatApi21Impl.createFromFamiliesWithDefault(family);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fonts, int style) {
        Throwable file;
        Throwable read;
        Throwable th;
        Throwable th2;
        final int i2 = 0;
        if (fonts.length < 1) {
            return i2;
        }
        ParcelFileDescriptor fileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo(fonts, style).getUri(), "r", cancellationSignal);
        if (fileDescriptor == null && fileDescriptor != null) {
            if (fileDescriptor != null) {
                fileDescriptor.close();
            }
            return i2;
        }
        File file2 = getFile(fileDescriptor);
        if (file2 != null) {
            if (file2.canRead() == null) {
            } else {
                if (fileDescriptor != null) {
                    fileDescriptor.close();
                }
            }
            return Typeface.createFromFile(file2);
        }
        FileInputStream fileInputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        fileInputStream.close();
        if (fileDescriptor != null) {
            fileDescriptor.close();
        }
        return super.createFromInputStream(context, fileInputStream);
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
