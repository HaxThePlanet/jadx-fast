package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u00085\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0006\u0010P\u001a\u00020QR\"\u0010\u0017\u001a\u00020\u0003X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R\"\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%R\"\u0010\u0002\u001a\u00020\u0003X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\u0008&\u0010\u001e\"\u0004\u0008'\u0010 R\u001c\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010)\"\u0004\u0008*\u0010+R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008,\u0010-\"\u0004\u0008.\u0010/R\"\u0010\u0004\u001a\u00020\u0005X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\u00080\u0010\u001e\"\u0004\u00081\u0010 R\"\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\u00082\u00103\"\u0004\u00084\u00105R\"\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u0010;\"\u0004\u0008<\u0010=R\"\u0010\u0010\u001a\u00020\u0005X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\u0008>\u0010\u001e\"\u0004\u0008?\u0010 R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u0010A\"\u0004\u0008B\u0010CR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008D\u0010E\"\u0004\u0008F\u0010GR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008H\u0010I\"\u0004\u0008J\u0010KR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008L\u0010M\"\u0004\u0008N\u0010O\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006R", d2 = {"Landroidx/compose/ui/platform/MutableSpanStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA", "(J)V", "J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-_isdbwI", "(Landroidx/compose/ui/text/style/BaselineShift;)V", "getColor-0d7_KjU", "setColor-8_81llA", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "setFontFamily", "(Landroidx/compose/ui/text/font/FontFamily;)V", "getFontFeatureSettings", "()Ljava/lang/String;", "setFontFeatureSettings", "(Ljava/lang/String;)V", "getFontSize-XSAIIZE", "setFontSize--R2X_6o", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "setFontStyle-mLjRB2g", "(Landroidx/compose/ui/text/font/FontStyle;)V", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "setFontSynthesis-tDdu0R4", "(Landroidx/compose/ui/text/font/FontSynthesis;)V", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "setFontWeight", "(Landroidx/compose/ui/text/font/FontWeight;)V", "getLetterSpacing-XSAIIZE", "setLetterSpacing--R2X_6o", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "setLocaleList", "(Landroidx/compose/ui/text/intl/LocaleList;)V", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow", "(Landroidx/compose/ui/graphics/Shadow;)V", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "setTextDecoration", "(Landroidx/compose/ui/text/style/TextDecoration;)V", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "setTextGeometricTransform", "(Landroidx/compose/ui/text/style/TextGeometricTransform;)V", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MutableSpanStyle {

    private long background;
    private BaselineShift baselineShift;
    private long color;
    private FontFamily fontFamily;
    private String fontFeatureSettings;
    private long fontSize;
    private FontStyle fontStyle;
    private FontSynthesis fontSynthesis;
    private FontWeight fontWeight;
    private long letterSpacing;
    private LocaleList localeList;
    private Shadow shadow;
    private TextDecoration textDecoration;
    private TextGeometricTransform textGeometricTransform;
    private MutableSpanStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow) {
        final Object obj = this;
        super();
        obj.color = color;
        obj.fontSize = fontWeight;
        obj.fontWeight = fontSynthesis;
        obj.fontStyle = fontFamily;
        obj.fontSynthesis = fontFeatureSettings;
        obj.fontFamily = letterSpacing;
        obj.fontFeatureSettings = baselineShift;
        obj.letterSpacing = textGeometricTransform;
        obj.baselineShift = background;
        obj.textGeometricTransform = textDecoration;
        obj.localeList = shadow;
        obj.background = obj31;
        obj.textDecoration = obj33;
        obj.shadow = obj34;
    }

    public MutableSpanStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, int i15, DefaultConstructorMarker defaultConstructorMarker16) {
        int i10;
        long unspecified-0d7_KjU;
        long unspecified-XSAIIZE;
        int i;
        Color.Companion companion;
        int i2;
        int i4;
        int i7;
        int i9;
        int i6;
        long unspecified-XSAIIZE2;
        int i5;
        int i3;
        int i8;
        long unspecified-0d7_KjU2;
        int i11 = obj38;
        if (i11 & 1 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l;
        }
        if (i11 & 2 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = fontWeight3;
        }
        i = i11 & 4 != 0 ? 0 : fontSynthesis5;
        i4 = i11 & 8 != 0 ? 0 : fontFamily6;
        i7 = i11 & 16 != 0 ? 0 : string7;
        i9 = i11 & 32 != 0 ? 0 : l8;
        i6 = i11 & 64 != 0 ? 0 : baselineShift9;
        if (i11 & 128 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = textGeometricTransform10;
        }
        i5 = i11 & 256 != 0 ? 0 : l12;
        i3 = i11 & 512 != 0 ? 0 : textDecoration13;
        i8 = i11 & 1024 != 0 ? 0 : shadow14;
        if (i11 & 2048 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = i15;
        }
        i2 = i11 & 4096 != 0 ? 0 : obj36;
        i10 = i11 &= 8192 != 0 ? 0 : obj37;
        super(unspecified-0d7_KjU, fontWeight3, unspecified-XSAIIZE, fontSynthesis5, i, i4, i7, i9, i6, unspecified-XSAIIZE2, l12, i5, i3, i8, unspecified-0d7_KjU2, obj36, i2, i10, 0);
    }

    public MutableSpanStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, DefaultConstructorMarker defaultConstructorMarker15) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, defaultConstructorMarker15, obj16, obj17, obj18);
    }

    public final long getBackground-0d7_KjU() {
        return this.background;
    }

    public final BaselineShift getBaselineShift-5SSeXJ0() {
        return this.baselineShift;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final long getFontSize-XSAIIZE() {
        return this.fontSize;
    }

    public final FontStyle getFontStyle-4Lr2A7w() {
        return this.fontStyle;
    }

    public final FontSynthesis getFontSynthesis-ZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final long getLetterSpacing-XSAIIZE() {
        return this.letterSpacing;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final void setBackground-8_81llA(long <set-?>) {
        this.background = <set-?>;
    }

    public final void setBaselineShift-_isdbwI(BaselineShift <set-?>) {
        this.baselineShift = <set-?>;
    }

    public final void setColor-8_81llA(long <set-?>) {
        this.color = <set-?>;
    }

    public final void setFontFamily(FontFamily <set-?>) {
        this.fontFamily = <set-?>;
    }

    public final void setFontFeatureSettings(String <set-?>) {
        this.fontFeatureSettings = <set-?>;
    }

    public final void setFontSize--R2X_6o(long <set-?>) {
        this.fontSize = <set-?>;
    }

    public final void setFontStyle-mLjRB2g(FontStyle <set-?>) {
        this.fontStyle = <set-?>;
    }

    public final void setFontSynthesis-tDdu0R4(FontSynthesis <set-?>) {
        this.fontSynthesis = <set-?>;
    }

    public final void setFontWeight(FontWeight <set-?>) {
        this.fontWeight = <set-?>;
    }

    public final void setLetterSpacing--R2X_6o(long <set-?>) {
        this.letterSpacing = <set-?>;
    }

    public final void setLocaleList(LocaleList <set-?>) {
        this.localeList = <set-?>;
    }

    public final void setShadow(Shadow <set-?>) {
        this.shadow = <set-?>;
    }

    public final void setTextDecoration(TextDecoration <set-?>) {
        this.textDecoration = <set-?>;
    }

    public final void setTextGeometricTransform(TextGeometricTransform <set-?>) {
        this.textGeometricTransform = <set-?>;
    }

    public final SpanStyle toSpanStyle() {
        final Object obj = this;
        final long l3 = color;
        final TextDecoration textDecoration = obj.textDecoration;
        SpanStyle spanStyle2 = spanStyle3;
        spanStyle2 = new SpanStyle(l3, textDecoration, obj.fontSize, obj5, obj.fontWeight, obj.fontStyle, obj.fontSynthesis, obj.fontFamily, obj.fontFeatureSettings, obj.letterSpacing, obj12, obj.baselineShift, obj.textGeometricTransform, obj.localeList, obj.background, l3, textDecoration, obj.shadow, 0, 0, 49152, 0);
        return spanStyle2;
    }
}
