package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyle.Companion;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.LineHeightStyle.Alignment;
import androidx.compose.ui.text.style.LineHeightStyle.Alignment.Companion;
import androidx.compose.ui.text.style.LineHeightStyle.Trim;
import androidx.compose.ui.text.style.LineHeightStyle.Trim.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u001a\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0010", d2 = {"DefaultLineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefaultLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultTextStyle", "Landroidx/compose/ui/text/TextStyle;", "getDefaultTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Typography;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "withDefaultFontFamily", "default", "Landroidx/compose/ui/text/font/FontFamily;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TypographyKt {

    private static final LineHeightStyle DefaultLineHeightStyle;
    private static final TextStyle DefaultTextStyle;
    private static final ProvidableCompositionLocal<androidx.compose.material.Typography> LocalTypography;
    static {
        final int i2 = 0;
        LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.Companion.getCenter-PIaL0Z0(), LineHeightStyle.Trim.Companion.getNone-EVpEnUU(), i2);
        TypographyKt.DefaultLineHeightStyle = lineHeightStyle;
        TypographyKt.DefaultTextStyle = TextStyle.copy-p1EtxEg$default(TextStyle.Companion.getDefault(), 0, i2, 0, obj5, 0, 0, 0, 0, 0, 0, obj12, 0, 0, 0, 0, obj17, 0, 0, 0, 0, 0, 0, obj24, 0, DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), TypographyKt.DefaultLineHeightStyle);
        TypographyKt.LocalTypography = CompositionLocalKt.staticCompositionLocalOf((Function0)TypographyKt.LocalTypography.1.INSTANCE);
    }

    public static final TextStyle access$withDefaultFontFamily(TextStyle $receiver, FontFamily default) {
        return TypographyKt.withDefaultFontFamily($receiver, default);
    }

    public static final LineHeightStyle getDefaultLineHeightStyle() {
        return TypographyKt.DefaultLineHeightStyle;
    }

    public static final TextStyle getDefaultTextStyle() {
        return TypographyKt.DefaultTextStyle;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material.Typography> getLocalTypography() {
        return TypographyKt.LocalTypography;
    }

    private static final TextStyle withDefaultFontFamily(TextStyle $this$withDefaultFontFamily, FontFamily default) {
        TextStyle copy-p1EtxEg$default;
        TextStyle textStyle;
        int i18;
        int i9;
        int i14;
        int i24;
        int i4;
        String str;
        int i11;
        int i2;
        int i10;
        int i19;
        int i20;
        int i5;
        int i16;
        int i3;
        int i;
        int i6;
        int i12;
        int i23;
        int i7;
        int i15;
        int i8;
        int i21;
        int i22;
        int i25;
        int i13;
        int i17;
        if ($this$withDefaultFontFamily.getFontFamily() != null) {
            copy-p1EtxEg$default = $this$withDefaultFontFamily;
        } else {
            copy-p1EtxEg$default = TextStyle.copy-p1EtxEg$default($this$withDefaultFontFamily, 0, obj3, 0, obj5, 0, 0, 0, default, 0, 0, obj12, 0, 0, 0, 0, obj17, 0, 0, 0, 0, 0, 0, obj24, 0, 0, 0);
        }
        return copy-p1EtxEg$default;
    }
}
