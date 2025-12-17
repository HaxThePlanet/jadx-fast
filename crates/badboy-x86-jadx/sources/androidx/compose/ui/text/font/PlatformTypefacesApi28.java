package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J,\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u000cJ<\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006!", d2 = {"Landroidx/compose/ui/text/font/PlatformTypefacesApi28;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "()V", "createAndroidTypefaceApi28", "Landroid/graphics/Typeface;", "genericFontFamily", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "createAndroidTypefaceApi28-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createDefault", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "familyName", "weight", "style", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "optionalOnDeviceFontFamilyByName", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PlatformTypefacesApi28 implements androidx.compose.ui.text.font.PlatformTypefaces {
    private final Typeface createAndroidTypefaceApi28-RetOiIg(String genericFontFamily, androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle) {
        boolean equal;
        Typeface dEFAULT;
        int length;
        int i = 0;
        if (FontStyle.equals-impl0(fontStyle, FontStyle.Companion.getNormal-_-LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal())) {
            if (Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal())) {
                length = genericFontFamily;
                if ((CharSequence)length != null) {
                    if ((CharSequence)length.length() == 0) {
                        equal = 1;
                    } else {
                        equal = i;
                    }
                } else {
                }
                if (equal != 0) {
                    return Typeface.DEFAULT;
                }
            }
        }
        if (genericFontFamily == null) {
            dEFAULT = Typeface.DEFAULT;
        } else {
            dEFAULT = Typeface.create(genericFontFamily, i);
        }
        return Typeface.create(dEFAULT, fontWeight.getWeight(), FontStyle.equals-impl0(fontStyle, FontStyle.Companion.getItalic-_-LCdwA()));
    }

    static Typeface createAndroidTypefaceApi28-RetOiIg$default(androidx.compose.ui.text.font.PlatformTypefacesApi28 platformTypefacesApi28, String string2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, int i5, Object object6) {
        int obj1;
        if (i5 &= 1 != 0) {
            obj1 = 0;
        }
        return platformTypefacesApi28.createAndroidTypefaceApi28-RetOiIg(obj1, fontWeight3, i4);
    }

    private final Typeface loadNamedFromTypefaceCacheOrNull-RetOiIg(String familyName, androidx.compose.ui.text.font.FontWeight weight, int style) {
        int i3;
        int i;
        int i2;
        boolean equal;
        final int i4 = 0;
        i3 = (CharSequence)familyName.length() == 0 ? i : i4;
        i2 = 0;
        if (i3 != 0) {
            return i2;
        }
        Typeface androidTypefaceApi28-RetOiIg = createAndroidTypefaceApi28-RetOiIg(familyName, weight, style);
        final Typeface typeface = androidTypefaceApi28-RetOiIg;
        final int i5 = 0;
        if (!Intrinsics.areEqual(typeface, TypefaceHelperMethodsApi28.INSTANCE.create(Typeface.DEFAULT, weight.getWeight(), FontStyle.equals-impl0(style, FontStyle.Companion.getItalic-_-LCdwA()))) && !Intrinsics.areEqual(typeface, createAndroidTypefaceApi28-RetOiIg(i2, weight, style))) {
            if (!Intrinsics.areEqual(typeface, createAndroidTypefaceApi28-RetOiIg(i2, weight, style))) {
            } else {
                i = i4;
            }
        } else {
        }
        if (i != 0) {
            i2 = androidTypefaceApi28-RetOiIg;
        }
        return i2;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    public Typeface createDefault-FO1MlWM(androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle) {
        return createAndroidTypefaceApi28-RetOiIg(0, fontWeight, fontStyle);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    public Typeface createNamed-RetOiIg(androidx.compose.ui.text.font.GenericFontFamily name, androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle) {
        return createAndroidTypefaceApi28-RetOiIg(name.getName(), fontWeight, fontStyle);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    public Typeface optionalOnDeviceFontFamilyByName-78DK7lM(String familyName, androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings, Context context) {
        Typeface namedFromTypefaceCacheOrNull-RetOiIg;
        if (Intrinsics.areEqual(familyName, FontFamily.Companion.getSansSerif().getName())) {
            namedFromTypefaceCacheOrNull-RetOiIg = createNamed-RetOiIg(FontFamily.Companion.getSansSerif(), weight, style);
        } else {
            if (Intrinsics.areEqual(familyName, FontFamily.Companion.getSerif().getName())) {
                namedFromTypefaceCacheOrNull-RetOiIg = createNamed-RetOiIg(FontFamily.Companion.getSerif(), weight, style);
            } else {
                if (Intrinsics.areEqual(familyName, FontFamily.Companion.getMonospace().getName())) {
                    namedFromTypefaceCacheOrNull-RetOiIg = createNamed-RetOiIg(FontFamily.Companion.getMonospace(), weight, style);
                } else {
                    if (Intrinsics.areEqual(familyName, FontFamily.Companion.getCursive().getName())) {
                        namedFromTypefaceCacheOrNull-RetOiIg = createNamed-RetOiIg(FontFamily.Companion.getCursive(), weight, style);
                    } else {
                        namedFromTypefaceCacheOrNull-RetOiIg = loadNamedFromTypefaceCacheOrNull-RetOiIg(familyName, weight, style);
                    }
                }
            }
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(namedFromTypefaceCacheOrNull-RetOiIg, variationSettings, context);
    }
}
