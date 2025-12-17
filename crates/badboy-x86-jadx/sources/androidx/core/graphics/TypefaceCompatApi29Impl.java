package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes5.dex */
public class TypefaceCompatApi29Impl extends androidx.core.graphics.TypefaceCompatBaseImpl {

    private static final String TAG = "TypefaceCompatApi29Impl";
    private Font findBaseFont(FontFamily family, int style) {
        int i;
        Font bestFont;
        int i2;
        int bestScore;
        int i3;
        Font font;
        int matchScore;
        i = style & 1 != 0 ? 700 : 400;
        int i6 = 0;
        i2 = style & 2 != 0 ? 1 : i6;
        FontStyle fontStyle = new FontStyle(i, i2);
        bestScore = TypefaceCompatApi29Impl.getMatchScore(fontStyle, family.getFont(i6).getStyle());
        i3 = 1;
        while (i3 < family.getSize()) {
            font = family.getFont(i3);
            matchScore = TypefaceCompatApi29Impl.getMatchScore(fontStyle, font.getStyle());
            if (matchScore < bestScore) {
            }
            i3++;
            bestFont = font;
            bestScore = matchScore;
        }
        return bestFont;
    }

    private static FontFamily getFontFamily(CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fonts, ContentResolver resolver) {
        int familyBuilder;
        int i;
        Object obj;
        Object pfd;
        Throwable build;
        Throwable ttcIndex;
        int i2;
        familyBuilder = 0;
        final int i4 = 0;
        i = i4;
        while (i < fonts.length) {
            obj = fonts[i];
            pfd = resolver.openFileDescriptor(obj.getUri(), "r", cancellationSignal);
            if (pfd == null) {
            } else {
            }
            Font.Builder builder = new Font.Builder(pfd);
            if (obj.isItalic()) {
            } else {
            }
            i2 = i4;
            build = builder.setWeight(obj.getWeight()).setSlant(i2).setTtcIndex(obj.getTtcIndex()).build();
            if (familyBuilder == null) {
            } else {
            }
            familyBuilder.addFont(build);
            if (pfd != null) {
            }
            i++;
            pfd.close();
            ttcIndex = new FontFamily.Builder(build);
            familyBuilder = ttcIndex;
            i2 = 1;
            if (pfd != null) {
            }
            pfd.close();
            build = "TypefaceCompatApi29Impl";
            ttcIndex = "Font load failed";
            Log.w(build, ttcIndex, pfd);
        }
        if (familyBuilder == null) {
            return null;
        }
        return familyBuilder.build();
    }

    private static int getMatchScore(FontStyle o1, FontStyle o2) {
        int i;
        i = o1.getSlant() == o2.getSlant() ? 0 : 2;
        return i4 += i;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry familyEntry, Resources resources, int style) {
        int familyBuilder;
        int i;
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry;
        Object build;
        String variationSettings;
        int i2;
        familyBuilder = 0;
        FontResourcesParserCompat.FontFileResourceEntry[] entries = familyEntry.getEntries();
        int i4 = 0;
        i = i4;
        while (i < entries.length) {
            fontFileResourceEntry = entries[i];
            Font.Builder builder = new Font.Builder(resources, fontFileResourceEntry.getResourceId());
            if (fontFileResourceEntry.isItalic() != null) {
            } else {
            }
            i2 = i4;
            build = builder.setWeight(fontFileResourceEntry.getWeight()).setSlant(i2).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
            if (familyBuilder == null) {
            } else {
            }
            familyBuilder.addFont(build);
            i++;
            variationSettings = new FontFamily.Builder(build);
            familyBuilder = variationSettings;
            i2 = 1;
        }
        if (familyBuilder == null) {
            return null;
        }
        try {
            FontFamily build3 = familyBuilder.build();
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(build3);
            return customFallbackBuilder.setStyle(findBaseFont(build3, style).getStyle()).build();
            Log.w("TypefaceCompatApi29Impl", "Font load failed", familyBuilder2);
            return obj1;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fonts, int style) {
        final FontFamily fontFamily = TypefaceCompatApi29Impl.getFontFamily(cancellationSignal, fonts, context.getContentResolver());
        if (fontFamily == null) {
            return null;
        }
        Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamily);
        return customFallbackBuilder.setStyle(findBaseFont(fontFamily, style).getStyle()).build();
    }

    public Typeface createFromFontInfoWithFallback(Context context, CancellationSignal cancellationSignal, List<FontsContractCompat.FontInfo[]> list3, int style) {
        int i;
        FontFamily fontFamily;
        final ContentResolver contentResolver = context.getContentResolver();
        FontFamily fontFamily2 = TypefaceCompatApi29Impl.getFontFamily(cancellationSignal, (FontsContractCompat.FontInfo[])list3.get(0), contentResolver);
        if (fontFamily2 == null) {
            return null;
        }
        Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamily2);
        i = 1;
        while (i < list3.size()) {
            fontFamily = TypefaceCompatApi29Impl.getFontFamily(cancellationSignal, (FontsContractCompat.FontInfo[])list3.get(i), contentResolver);
            if (fontFamily != null) {
            }
            i++;
            customFallbackBuilder.addCustomFallback(fontFamily);
        }
        return customFallbackBuilder.setStyle(findBaseFont(fontFamily2, style).getStyle()).build();
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected Typeface createFromInputStream(Context context, InputStream is) {
        RuntimeException runtimeException = new RuntimeException("Do not use this function in API 29 or later.");
        throw runtimeException;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int id, String path, int style) {
        int i = 0;
        int i2 = 0;
        Font.Builder builder = new Font.Builder(resources, id);
        Font font = build;
        FontFamily.Builder builder2 = new FontFamily.Builder(font);
        Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(builder2.build());
        return customFallbackBuilder.setStyle(font.getStyle()).build();
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    Typeface createWeightStyle(Context context, Typeface base, int weight, boolean italic) {
        return Typeface.create(base, weight, italic);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fonts, int style) {
        RuntimeException runtimeException = new RuntimeException("Do not use this function in API 29 or later.");
        throw runtimeException;
    }
}
