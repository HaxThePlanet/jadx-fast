package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a \u0010\u0007\u001a\u0004\u0018\u00010\u0008*\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0001¨\u0006\r", d2 = {"PlatformTypefaces", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "getWeightSuffixForFallbackFamilyName", "", "name", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlatformTypefaces_androidKt {
    public static final androidx.compose.ui.text.font.PlatformTypefaces PlatformTypefaces() {
        PlatformTypefacesApi28 platformTypefacesApi28 = new PlatformTypefacesApi28();
        return (PlatformTypefaces)platformTypefacesApi28;
    }

    public static final String getWeightSuffixForFallbackFamilyName(String name, androidx.compose.ui.text.font.FontWeight fontWeight) {
        String string;
        int str;
        int i;
        int i2;
        weight /= 100;
        int i4 = 2;
        i = 1;
        final int i7 = 0;
        if (i3 >= 0 && i3 < i4) {
            i2 = i3 < i4 ? i : i7;
        } else {
        }
        if (i2 != 0) {
            StringBuilder stringBuilder4 = new StringBuilder();
            string = stringBuilder4.append(name).append("-thin").toString();
        } else {
            i2 = 4;
            if (i4 <= i3 && i3 < i2) {
                str = i3 < i2 ? i : i7;
            } else {
            }
            if (str != null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                string = stringBuilder3.append(name).append("-light").toString();
            } else {
                if (i3 == i2) {
                    string = name;
                } else {
                    if (i3 == 5) {
                        StringBuilder stringBuilder = new StringBuilder();
                        string = stringBuilder.append(name).append("-medium").toString();
                    } else {
                        i2 = 8;
                        if (6 <= i3 && i3 < i2) {
                            str = i3 < i2 ? i : i7;
                        } else {
                        }
                        if (str != null) {
                        } else {
                            if (i2 <= i3 && i3 < 11) {
                                if (i3 < 11) {
                                } else {
                                    i = i7;
                                }
                            } else {
                            }
                            if (i != 0) {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                string = stringBuilder2.append(name).append("-black").toString();
                            } else {
                            }
                        }
                    }
                }
            }
        }
        return string;
    }

    public static final Typeface setFontVariationSettings(Typeface $this$setFontVariationSettings, androidx.compose.ui.text.font.FontVariation.Settings variationSettings, Context context) {
        return TypefaceCompatApi26.INSTANCE.setFontVariationSettings($this$setFontVariationSettings, variationSettings, context);
    }
}
