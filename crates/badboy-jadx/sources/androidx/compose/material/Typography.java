package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamily.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0093\u0001\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012Bo\u0008\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u0088\u0001\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00052\u0008\u0008\u0002\u0010\r\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0005J\u0013\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010&\u001a\u00020'H\u0016J\u0008\u0010(\u001a\u00020)H\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0015R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0015R\u0011\u0010\u000c\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0015¨\u0006*", d2 = {"Landroidx/compose/material/Typography;", "", "defaultFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "h1", "Landroidx/compose/ui/text/TextStyle;", "h2", "h3", "h4", "h5", "h6", "subtitle1", "subtitle2", "body1", "body2", "button", "caption", "overline", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getBody1", "()Landroidx/compose/ui/text/TextStyle;", "getBody2", "getButton", "getCaption", "getH1", "getH2", "getH3", "getH4", "getH5", "getH6", "getOverline", "getSubtitle1", "getSubtitle2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Typography {

    public static final int $stable;
    private final TextStyle body1;
    private final TextStyle body2;
    private final TextStyle button;
    private final TextStyle caption;
    private final TextStyle h1;
    private final TextStyle h2;
    private final TextStyle h3;
    private final TextStyle h4;
    private final TextStyle h5;
    private final TextStyle h6;
    private final TextStyle overline;
    private final TextStyle subtitle1;
    private final TextStyle subtitle2;
    static {
    }

    public Typography(TextStyle h1, TextStyle h2, TextStyle h3, TextStyle h4, TextStyle h5, TextStyle h6, TextStyle subtitle1, TextStyle subtitle2, TextStyle body1, TextStyle body2, TextStyle button, TextStyle caption, TextStyle overline) {
        super();
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
        this.h4 = h4;
        this.h5 = h5;
        this.h6 = h6;
        this.subtitle1 = subtitle1;
        this.subtitle2 = subtitle2;
        this.body1 = body1;
        this.body2 = body2;
        this.button = button;
        this.caption = caption;
        this.overline = overline;
    }

    public Typography(FontFamily defaultFontFamily, TextStyle h1, TextStyle h2, TextStyle h3, TextStyle h4, TextStyle h5, TextStyle h6, TextStyle subtitle1, TextStyle subtitle2, TextStyle body1, TextStyle body2, TextStyle button, TextStyle caption, TextStyle overline) {
        final FontFamily fontFamily = defaultFontFamily;
        super(TypographyKt.access$withDefaultFontFamily(h1, fontFamily), TypographyKt.access$withDefaultFontFamily(h2, fontFamily), TypographyKt.access$withDefaultFontFamily(h3, fontFamily), TypographyKt.access$withDefaultFontFamily(h4, fontFamily), TypographyKt.access$withDefaultFontFamily(h5, fontFamily), TypographyKt.access$withDefaultFontFamily(h6, fontFamily), TypographyKt.access$withDefaultFontFamily(subtitle1, fontFamily), TypographyKt.access$withDefaultFontFamily(subtitle2, fontFamily), TypographyKt.access$withDefaultFontFamily(body1, fontFamily), TypographyKt.access$withDefaultFontFamily(body2, fontFamily), TypographyKt.access$withDefaultFontFamily(button, fontFamily), TypographyKt.access$withDefaultFontFamily(caption, fontFamily), TypographyKt.access$withDefaultFontFamily(overline, fontFamily));
    }

    public Typography(FontFamily fontFamily, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, int i15, DefaultConstructorMarker defaultConstructorMarker16) {
        TextStyle copy-p1EtxEg$default8;
        androidx.compose.ui.text.font.SystemFontFamily default;
        TextStyle copy-p1EtxEg$default6;
        TextStyle defaultTextStyle6;
        TextStyle copy-p1EtxEg$default3;
        int defaultTextStyle5;
        TextStyle copy-p1EtxEg$default4;
        double d;
        TextStyle copy-p1EtxEg$default12;
        long defaultTextStyle;
        TextStyle copy-p1EtxEg$default10;
        FontWeight fontWeight;
        TextStyle copy-p1EtxEg$default2;
        FontWeight light;
        TextStyle copy-p1EtxEg$default5;
        int defaultTextStyle3;
        int companion2;
        TextStyle copy-p1EtxEg$default11;
        int i34;
        TextStyle copy-p1EtxEg$default;
        int defaultTextStyle2;
        TextStyle copy-p1EtxEg$default7;
        int i17;
        TextStyle copy-p1EtxEg$default13;
        long l;
        long i22;
        TextStyle copy-p1EtxEg$default9;
        androidx.compose.ui.text.style.TextGeometricTransform defaultTextStyle4;
        FontWeight.Companion companion;
        long i28;
        int i27;
        int defaultTextStyle7;
        int i31;
        int i9;
        androidx.compose.ui.graphics.drawscope.DrawStyle medium;
        int i18;
        int normal;
        int i14;
        int i24;
        int i19;
        long l2;
        int i7;
        int i25;
        int i5;
        int i6;
        int i26;
        int i30;
        int i21;
        int i32;
        int i3;
        int i8;
        int i20;
        int i12;
        int i23;
        int i11;
        int i29;
        int i16;
        int i4;
        int i2;
        int i;
        int i13;
        int i33;
        int i10;
        int i35 = i15;
        if (i35 & 1 != 0) {
            default = FontFamily.Companion.getDefault();
        } else {
            default = fontFamily;
        }
        if (i35 & 2 != 0) {
            copy-p1EtxEg$default6 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, obj5, TextUnitKt.getSp(96), obj7, FontWeight.Companion.getLight(), 0, 0, 0, 0, TextUnitKt.getSp(-4613937818241073152L), obj14, 0, 0, 0, 0, obj19, 0, 0, 0, 0, 0, TextUnitKt.getSp(112), obj26, 0, 0, 0);
        } else {
            copy-p1EtxEg$default6 = textStyle2;
        }
        if (i35 & 4 != 0) {
            copy-p1EtxEg$default3 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, defaultTextStyle, TextUnitKt.getSp(60), light, FontWeight.Companion.getLight(), 0, 0, 0, 0, TextUnitKt.getSp(-4620693217682128896L), i27, 0, 0, 0, 0, i18, 0, 0, 0, 0, 0, TextUnitKt.getSp(72), i25, 0, 0, 0);
        } else {
            copy-p1EtxEg$default3 = textStyle3;
        }
        int i48 = 0;
        if (i35 & 8 != 0) {
            copy-p1EtxEg$default4 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, light, TextUnitKt.getSp(48), i34, FontWeight.Companion.getNormal(), 0, 0, 0, 0, TextUnitKt.getSp(i48), i31, 0, 0, 0, 0, i14, 0, 0, 0, 0, 0, TextUnitKt.getSp(56), i6, 0, 0, 0);
        } else {
            copy-p1EtxEg$default4 = textStyle4;
        }
        long l5 = 4598175219545276416L;
        if (i35 & 16 != 0) {
            copy-p1EtxEg$default10 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, defaultTextStyle2, TextUnitKt.getSp(34), l, FontWeight.Companion.getNormal(), 0, 0, 0, 0, TextUnitKt.getSp(l5), i18, 0, 0, 0, 0, l2, 0, 0, 0, 0, 0, TextUnitKt.getSp(36), i21, 0, 0, 0);
        } else {
            copy-p1EtxEg$default10 = textStyle5;
        }
        int i55 = 24;
        if (i35 & 32 != 0) {
            copy-p1EtxEg$default12 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, l, TextUnitKt.getSp(i55), i27, FontWeight.Companion.getNormal(), 0, 0, 0, 0, TextUnitKt.getSp(i48), i14, 0, 0, 0, 0, i25, 0, 0, 0, 0, 0, TextUnitKt.getSp(i55), i3, 0, 0, 0);
        } else {
            copy-p1EtxEg$default12 = textStyle6;
        }
        long l7 = 4594572339843380019L;
        i22 = 20;
        if (i35 & 64 != 0) {
            copy-p1EtxEg$default11 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, defaultTextStyle7, TextUnitKt.getSp(i22), i9, FontWeight.Companion.getMedium(), 0, 0, 0, 0, TextUnitKt.getSp(l7), l2, 0, 0, 0, 0, i26, 0, 0, 0, 0, 0, TextUnitKt.getSp(i55), i12, 0, 0, 0);
        } else {
            copy-p1EtxEg$default11 = textStyle7;
        }
        int i60 = 16;
        if (i35 & 128 != 0) {
            copy-p1EtxEg$default7 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, i9, TextUnitKt.getSp(i60), i18, FontWeight.Companion.getNormal(), 0, 0, 0, 0, TextUnitKt.getSp(l7), i25, 0, 0, 0, 0, i21, 0, 0, 0, 0, 0, TextUnitKt.getSp(i55), i11, 0, 0, 0);
        } else {
            copy-p1EtxEg$default7 = textStyle8;
        }
        i28 = 14;
        if (i35 & 256 != 0) {
            copy-p1EtxEg$default13 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, i9, TextUnitKt.getSp(i28), i18, FontWeight.Companion.getMedium(), 0, 0, 0, 0, TextUnitKt.getSp(4591870180066957722L), i25, 0, 0, 0, 0, i21, 0, 0, 0, 0, 0, TextUnitKt.getSp(i55), i11, 0, 0, 0);
        } else {
            copy-p1EtxEg$default13 = textStyle9;
        }
        if (i35 & 512 != 0) {
            copy-p1EtxEg$default2 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, i9, TextUnitKt.getSp(i60), i18, FontWeight.Companion.getNormal(), 0, 0, 0, 0, TextUnitKt.getSp(4602678819172646912L), i25, 0, 0, 0, 0, i21, 0, 0, 0, 0, 0, TextUnitKt.getSp(i55), i11, 0, 0, 0);
        } else {
            copy-p1EtxEg$default2 = textStyle10;
        }
        if (i35 & 1024 != 0) {
            copy-p1EtxEg$default5 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, i9, TextUnitKt.getSp(i28), i18, FontWeight.Companion.getNormal(), 0, 0, 0, 0, TextUnitKt.getSp(l5), i25, 0, 0, 0, 0, i21, 0, 0, 0, 0, 0, TextUnitKt.getSp(i22), i11, 0, 0, 0);
        } else {
            copy-p1EtxEg$default5 = textStyle11;
        }
        if (i35 & 2048 != 0) {
            copy-p1EtxEg$default = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, i9, TextUnitKt.getSp(i28), i18, FontWeight.Companion.getMedium(), 0, 0, 0, 0, TextUnitKt.getSp(4608308318706860032L), i25, 0, 0, 0, 0, i21, 0, 0, 0, 0, 0, TextUnitKt.getSp(i60), i11, 0, 0, 0);
        } else {
            copy-p1EtxEg$default = textStyle12;
        }
        if (i35 & 4096 != 0) {
            copy-p1EtxEg$default9 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, i9, TextUnitKt.getSp(12), i18, FontWeight.Companion.getNormal(), 0, 0, 0, 0, TextUnitKt.getSp(4600877379321698714L), i25, 0, 0, 0, 0, i21, 0, 0, 0, 0, 0, TextUnitKt.getSp(i60), i11, 0, 0, 0);
        } else {
            copy-p1EtxEg$default9 = textStyle13;
        }
        if (i35 &= 8192 != 0) {
            copy-p1EtxEg$default8 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0, i9, TextUnitKt.getSp(10), i18, FontWeight.Companion.getNormal(), 0, 0, 0, 0, TextUnitKt.getSp(4609434218613702656L), i25, 0, 0, 0, 0, i21, 0, 0, 0, 0, 0, TextUnitKt.getSp(i60), i11, 0, 0, 0);
        } else {
            copy-p1EtxEg$default8 = textStyle14;
        }
        super(default, copy-p1EtxEg$default6, copy-p1EtxEg$default3, copy-p1EtxEg$default4, copy-p1EtxEg$default10, copy-p1EtxEg$default12, copy-p1EtxEg$default11, copy-p1EtxEg$default7, copy-p1EtxEg$default13, copy-p1EtxEg$default2, copy-p1EtxEg$default5, copy-p1EtxEg$default, copy-p1EtxEg$default9, copy-p1EtxEg$default8);
    }

    public static androidx.compose.material.Typography copy$default(androidx.compose.material.Typography typography, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, int i15, Object object16) {
        TextStyle overline;
        TextStyle textStyle17;
        TextStyle textStyle15;
        TextStyle textStyle16;
        TextStyle textStyle18;
        TextStyle textStyle;
        TextStyle subtitle1;
        TextStyle subtitle2;
        TextStyle body1;
        TextStyle body2;
        TextStyle button;
        TextStyle caption;
        TextStyle obj13;
        int i = i15;
        if (i & 1 != 0) {
            obj13 = typography.h1;
        }
        textStyle17 = i & 2 != 0 ? typography.h2 : textStyle3;
        textStyle15 = i & 4 != 0 ? typography.h3 : textStyle4;
        textStyle16 = i & 8 != 0 ? typography.h4 : textStyle5;
        textStyle18 = i & 16 != 0 ? typography.h5 : textStyle6;
        textStyle = i & 32 != 0 ? typography.h6 : textStyle7;
        subtitle1 = i & 64 != 0 ? typography.subtitle1 : textStyle8;
        subtitle2 = i & 128 != 0 ? typography.subtitle2 : textStyle9;
        body1 = i & 256 != 0 ? typography.body1 : textStyle10;
        body2 = i & 512 != 0 ? typography.body2 : textStyle11;
        button = i & 1024 != 0 ? typography.button : textStyle12;
        caption = i & 2048 != 0 ? typography.caption : textStyle13;
        overline = i &= 4096 != 0 ? typography.overline : textStyle14;
        return typography.copy(obj13, textStyle17, textStyle15, textStyle16, textStyle18, textStyle, subtitle1, subtitle2, body1, body2, button, caption, overline);
    }

    public final androidx.compose.material.Typography copy(TextStyle h1, TextStyle h2, TextStyle h3, TextStyle h4, TextStyle h5, TextStyle h6, TextStyle subtitle1, TextStyle subtitle2, TextStyle body1, TextStyle body2, TextStyle button, TextStyle caption, TextStyle overline) {
        Typography typography = new Typography(h1, h2, h3, h4, h5, h6, subtitle1, subtitle2, body1, body2, button, caption, overline);
        return typography;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof Typography) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.h1, obj.h1)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.h2, obj2.h2)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.h3, obj3.h3)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.h4, obj4.h4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.h5, obj5.h5)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.h6, obj6.h6)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.subtitle1, obj7.subtitle1)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.subtitle2, obj8.subtitle2)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.body1, obj9.body1)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.body2, obj10.body2)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.button, obj11.button)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.caption, obj12.caption)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.overline, obj13.overline)) {
            return i2;
        }
        return i;
    }

    public final TextStyle getBody1() {
        return this.body1;
    }

    public final TextStyle getBody2() {
        return this.body2;
    }

    public final TextStyle getButton() {
        return this.button;
    }

    public final TextStyle getCaption() {
        return this.caption;
    }

    public final TextStyle getH1() {
        return this.h1;
    }

    public final TextStyle getH2() {
        return this.h2;
    }

    public final TextStyle getH3() {
        return this.h3;
    }

    public final TextStyle getH4() {
        return this.h4;
    }

    public final TextStyle getH5() {
        return this.h5;
    }

    public final TextStyle getH6() {
        return this.h6;
    }

    public final TextStyle getOverline() {
        return this.overline;
    }

    public final TextStyle getSubtitle1() {
        return this.subtitle1;
    }

    public final TextStyle getSubtitle2() {
        return this.subtitle2;
    }

    public int hashCode() {
        return result6 += i26;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Typography(h1=").append(this.h1).append(", h2=").append(this.h2).append(", h3=").append(this.h3).append(", h4=").append(this.h4).append(", h5=").append(this.h5).append(", h6=").append(this.h6).append(", subtitle1=").append(this.subtitle1).append(", subtitle2=").append(this.subtitle2).append(", body1=").append(this.body1).append(", body2=").append(this.body2).append(", button=").append(this.button).append(", caption=");
        stringBuilder.append(this.caption).append(", overline=").append(this.overline).append(')');
        return stringBuilder.toString();
    }
}
