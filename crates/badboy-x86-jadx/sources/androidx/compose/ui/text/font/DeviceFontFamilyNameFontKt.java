package androidx.compose.ui.text.font;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "familyName", "Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-vxs03AY", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DeviceFontFamilyNameFontKt {
    public static final androidx.compose.ui.text.font.Font Font-vxs03AY(String familyName, androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = new DeviceFontFamilyNameFont(familyName, weight, style, variationSettings, 0);
        return (Font)deviceFontFamilyNameFont;
    }

    public static androidx.compose.ui.text.font.Font Font-vxs03AY$default(String string, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings4, int i5, Object object6) {
        androidx.compose.ui.text.font.FontWeight obj1;
        int obj2;
        androidx.compose.ui.text.font.FontVariation.Settings obj3;
        int obj4;
        if (i5 & 2 != 0) {
            obj1 = FontWeight.Companion.getNormal();
        }
        if (i5 & 4 != 0) {
            obj2 = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if (i5 &= 8 != 0) {
            obj3 = new FontVariation.Settings(new FontVariation.Setting[0]);
        }
        return DeviceFontFamilyNameFontKt.Font-vxs03AY(string, obj1, obj2, obj3);
    }
}
