package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
class TypefaceCompatBaseImpl {

    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies;

    private interface StyleExtractor {
        public abstract int getWeight(T t);

        public abstract boolean isItalic(T t);
    }
    TypefaceCompatBaseImpl() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mFontFamilies = concurrentHashMap;
    }

    private void addFontFamily(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry entry) {
        int mFontFamilies;
        Long valueOf;
        final long uniqueKey = TypefaceCompatBaseImpl.getUniqueKey(typeface);
        if (Long.compare(uniqueKey, i) != 0) {
            this.mFontFamilies.put(Long.valueOf(uniqueKey), entry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry entry, int style) {
        TypefaceCompatBaseImpl.2 anon = new TypefaceCompatBaseImpl.2(this);
        return (FontResourcesParserCompat.FontFileResourceEntry)TypefaceCompatBaseImpl.findBestFont(entry.getEntries(), style, anon);
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry entry, int weight, boolean italic) {
        TypefaceCompatBaseImpl.3 anon = new TypefaceCompatBaseImpl.3(this);
        return (FontResourcesParserCompat.FontFileResourceEntry)TypefaceCompatBaseImpl.findBestFont(entry.getEntries(), weight, italic, anon);
    }

    private static <T> T findBestFont(T[] tArr, int style, androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor<T> typefaceCompatBaseImpl$StyleExtractor3) {
        int i2;
        int i;
        i2 = style & 1 == 0 ? 400 : 700;
        i = style & 2 != 0 ? 1 : 0;
        return TypefaceCompatBaseImpl.findBestFont(tArr, i2, i, styleExtractor3);
    }

    private static <T> T findBestFont(T[] tArr, int targetWeight, boolean isTargetItalic, androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor<T> typefaceCompatBaseImpl$StyleExtractor4) {
        int best;
        int bestScore;
        int i;
        Object obj;
        int i2;
        int i3;
        best = 0;
        bestScore = Integer.MAX_VALUE;
        final int i4 = 0;
        i = i4;
        while (i < tArr.length) {
            obj = tArr[i];
            if (styleExtractor4.isItalic(obj) == isTargetItalic) {
            } else {
            }
            i3 = 1;
            i7 += i3;
            if (best != 0) {
            } else {
            }
            best = obj;
            bestScore = i2;
            i++;
            if (bestScore > i2) {
            }
            i3 = i4;
        }
        return best;
    }

    private static long getUniqueKey(Typeface typeface) {
        String str = "Could not retrieve font from family.";
        final String str2 = "TypefaceCompatBaseImpl";
        if (typeface == null) {
            return 0;
        }
        Field declaredField = Typeface.class.getDeclaredField("native_instance");
        declaredField.setAccessible(true);
        return (Number)declaredField.get(typeface).longValue();
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry entry, Resources resources, int style) {
        final FontResourcesParserCompat.FontFileResourceEntry bestEntry = findBestEntry(entry, style);
        if (bestEntry == null) {
            return null;
        }
        final Typeface obj9 = TypefaceCompat.createFromResourcesFontFile(context, resources, bestEntry.getResourceId(), bestEntry.getFileName(), 0, style);
        addFontFamily(obj9, entry);
        return obj9;
    }

    Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry entry, Resources resources, int weight, boolean italic) {
        final FontResourcesParserCompat.FontFileResourceEntry bestEntry = findBestEntry(entry, weight, italic);
        if (bestEntry == null) {
            return null;
        }
        final Typeface obj9 = TypefaceCompat.createFromResourcesFontFile(context, resources, bestEntry.getResourceId(), bestEntry.getFileName(), 0, 0);
        addFontFamily(obj9, entry);
        return obj9;
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fonts, int style) {
        if (fonts.length < 1) {
            return null;
        }
        int i2 = 0;
        InputStream is = inputStream;
        TypefaceCompatUtil.closeQuietly(is);
        return createFromInputStream(context, is);
    }

    public Typeface createFromFontInfoWithFallback(Context context, CancellationSignal cancellationSignal, List<FontsContractCompat.FontInfo[]> list3, int style) {
        IllegalStateException illegalStateException = new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
        throw illegalStateException;
    }

    protected Typeface createFromInputStream(Context context, InputStream is) {
        final File tempFile = TypefaceCompatUtil.getTempFile(context);
        int i = 0;
        if (tempFile == null) {
            return i;
        }
        if (TypefaceCompatUtil.copyToFile(tempFile, is) == null) {
            tempFile.delete();
            return i;
        }
        tempFile.delete();
        return Typeface.createFromFile(tempFile.getPath());
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int id, String path, int style) {
        final File tempFile = TypefaceCompatUtil.getTempFile(context);
        int i = 0;
        if (tempFile == null) {
            return i;
        }
        if (TypefaceCompatUtil.copyToFile(tempFile, resources, id) == null) {
            tempFile.delete();
            return i;
        }
        tempFile.delete();
        return Typeface.createFromFile(tempFile.getPath());
    }

    Typeface createWeightStyle(Context context, Typeface base, int weight, boolean italic) {
        Typeface out;
        Typeface weightStyle;
        int i = 0;
        if (WeightTypefaceApi14.createWeightStyle(this, context, base, weight, italic) == null) {
            out = base;
        }
        return out;
    }

    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fonts, int style) {
        TypefaceCompatBaseImpl.1 anon = new TypefaceCompatBaseImpl.1(this);
        return (FontsContractCompat.FontInfo)TypefaceCompatBaseImpl.findBestFont(fonts, style, anon);
    }

    FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface typeface) {
        final long uniqueKey = TypefaceCompatBaseImpl.getUniqueKey(typeface);
        if (Long.compare(uniqueKey, i) == 0) {
            return null;
        }
        return (FontResourcesParserCompat.FontFamilyFilesResourceEntry)this.mFontFamilies.get(Long.valueOf(uniqueKey));
    }
}
