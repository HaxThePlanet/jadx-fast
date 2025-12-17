package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyTokens;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\u009c\u0001\u0010#\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0003J\u0013\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010'\u001a\u00020(H\u0016J\u0008\u0010)\u001a\u00020*H\u0016R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0014R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0014¨\u0006+", d2 = {"Landroidx/compose/material3/Typography;", "", "displayLarge", "Landroidx/compose/ui/text/TextStyle;", "displayMedium", "displaySmall", "headlineLarge", "headlineMedium", "headlineSmall", "titleLarge", "titleMedium", "titleSmall", "bodyLarge", "bodyMedium", "bodySmall", "labelLarge", "labelMedium", "labelSmall", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "getBodyMedium", "getBodySmall", "getDisplayLarge", "getDisplayMedium", "getDisplaySmall", "getHeadlineLarge", "getHeadlineMedium", "getHeadlineSmall", "getLabelLarge", "getLabelMedium", "getLabelSmall", "getTitleLarge", "getTitleMedium", "getTitleSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Typography {

    public static final int $stable;
    private final TextStyle bodyLarge;
    private final TextStyle bodyMedium;
    private final TextStyle bodySmall;
    private final TextStyle displayLarge;
    private final TextStyle displayMedium;
    private final TextStyle displaySmall;
    private final TextStyle headlineLarge;
    private final TextStyle headlineMedium;
    private final TextStyle headlineSmall;
    private final TextStyle labelLarge;
    private final TextStyle labelMedium;
    private final TextStyle labelSmall;
    private final TextStyle titleLarge;
    private final TextStyle titleMedium;
    private final TextStyle titleSmall;
    static {
    }

    public Typography() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, 0);
    }

    public Typography(TextStyle displayLarge, TextStyle displayMedium, TextStyle displaySmall, TextStyle headlineLarge, TextStyle headlineMedium, TextStyle headlineSmall, TextStyle titleLarge, TextStyle titleMedium, TextStyle titleSmall, TextStyle bodyLarge, TextStyle bodyMedium, TextStyle bodySmall, TextStyle labelLarge, TextStyle labelMedium, TextStyle labelSmall) {
        final Object obj = this;
        super();
        obj.displayLarge = displayLarge;
        obj.displayMedium = displayMedium;
        obj.displaySmall = displaySmall;
        obj.headlineLarge = headlineLarge;
        obj.headlineMedium = headlineMedium;
        obj.headlineSmall = headlineSmall;
        obj.titleLarge = titleLarge;
        obj.titleMedium = titleMedium;
        obj.titleSmall = titleSmall;
        obj.bodyLarge = bodyLarge;
        obj.bodyMedium = bodyMedium;
        obj.bodySmall = bodySmall;
        obj.labelLarge = labelLarge;
        obj.labelMedium = labelMedium;
        obj.labelSmall = labelSmall;
    }

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, int i16, DefaultConstructorMarker defaultConstructorMarker17) {
        TextStyle labelSmall;
        TextStyle displayLarge;
        TextStyle displayMedium;
        TextStyle displaySmall;
        TextStyle headlineLarge;
        TextStyle headlineMedium;
        TextStyle headlineSmall;
        TextStyle titleLarge;
        TextStyle titleMedium;
        TextStyle titleSmall;
        TextStyle bodyLarge;
        TextStyle bodyMedium;
        TextStyle bodySmall;
        TextStyle labelLarge;
        TextStyle labelMedium;
        int i = i16;
        if (i & 1 != 0) {
            displayLarge = TypographyTokens.INSTANCE.getDisplayLarge();
        } else {
            displayLarge = textStyle;
        }
        if (i & 2 != 0) {
            displayMedium = TypographyTokens.INSTANCE.getDisplayMedium();
        } else {
            displayMedium = textStyle2;
        }
        if (i & 4 != 0) {
            displaySmall = TypographyTokens.INSTANCE.getDisplaySmall();
        } else {
            displaySmall = textStyle3;
        }
        if (i & 8 != 0) {
            headlineLarge = TypographyTokens.INSTANCE.getHeadlineLarge();
        } else {
            headlineLarge = textStyle4;
        }
        if (i & 16 != 0) {
            headlineMedium = TypographyTokens.INSTANCE.getHeadlineMedium();
        } else {
            headlineMedium = textStyle5;
        }
        if (i & 32 != 0) {
            headlineSmall = TypographyTokens.INSTANCE.getHeadlineSmall();
        } else {
            headlineSmall = textStyle6;
        }
        if (i & 64 != 0) {
            titleLarge = TypographyTokens.INSTANCE.getTitleLarge();
        } else {
            titleLarge = textStyle7;
        }
        if (i & 128 != 0) {
            titleMedium = TypographyTokens.INSTANCE.getTitleMedium();
        } else {
            titleMedium = textStyle8;
        }
        if (i & 256 != 0) {
            titleSmall = TypographyTokens.INSTANCE.getTitleSmall();
        } else {
            titleSmall = textStyle9;
        }
        if (i & 512 != 0) {
            bodyLarge = TypographyTokens.INSTANCE.getBodyLarge();
        } else {
            bodyLarge = textStyle10;
        }
        if (i & 1024 != 0) {
            bodyMedium = TypographyTokens.INSTANCE.getBodyMedium();
        } else {
            bodyMedium = textStyle11;
        }
        if (i & 2048 != 0) {
            bodySmall = TypographyTokens.INSTANCE.getBodySmall();
        } else {
            bodySmall = textStyle12;
        }
        if (i & 4096 != 0) {
            labelLarge = TypographyTokens.INSTANCE.getLabelLarge();
        } else {
            labelLarge = textStyle13;
        }
        if (i & 8192 != 0) {
            labelMedium = TypographyTokens.INSTANCE.getLabelMedium();
        } else {
            labelMedium = textStyle14;
        }
        if (i &= 16384 != 0) {
            labelSmall = TypographyTokens.INSTANCE.getLabelSmall();
        } else {
            labelSmall = textStyle15;
        }
        super(displayLarge, displayMedium, displaySmall, headlineLarge, headlineMedium, headlineSmall, titleLarge, titleMedium, titleSmall, bodyLarge, bodyMedium, bodySmall, labelLarge, labelMedium, labelSmall);
    }

    public static androidx.compose.material3.Typography copy$default(androidx.compose.material3.Typography typography, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, TextStyle textStyle16, int i17, Object object18) {
        TextStyle labelSmall;
        TextStyle displayLarge;
        TextStyle displayMedium;
        TextStyle displaySmall;
        TextStyle headlineLarge;
        TextStyle headlineMedium;
        TextStyle headlineSmall;
        TextStyle titleLarge;
        TextStyle titleMedium;
        TextStyle titleSmall;
        TextStyle bodyLarge;
        TextStyle bodyMedium;
        TextStyle bodySmall;
        TextStyle labelLarge;
        TextStyle labelMedium;
        Object obj = typography;
        int i = i17;
        displayLarge = i & 1 != 0 ? obj.displayLarge : textStyle2;
        displayMedium = i & 2 != 0 ? obj.displayMedium : textStyle3;
        displaySmall = i & 4 != 0 ? obj.displaySmall : textStyle4;
        headlineLarge = i & 8 != 0 ? obj.headlineLarge : textStyle5;
        headlineMedium = i & 16 != 0 ? obj.headlineMedium : textStyle6;
        headlineSmall = i & 32 != 0 ? obj.headlineSmall : textStyle7;
        titleLarge = i & 64 != 0 ? obj.titleLarge : textStyle8;
        titleMedium = i & 128 != 0 ? obj.titleMedium : textStyle9;
        titleSmall = i & 256 != 0 ? obj.titleSmall : textStyle10;
        bodyLarge = i & 512 != 0 ? obj.bodyLarge : textStyle11;
        bodyMedium = i & 1024 != 0 ? obj.bodyMedium : textStyle12;
        bodySmall = i & 2048 != 0 ? obj.bodySmall : textStyle13;
        labelLarge = i & 4096 != 0 ? obj.labelLarge : textStyle14;
        labelMedium = i & 8192 != 0 ? obj.labelMedium : textStyle15;
        labelSmall = i &= 16384 != 0 ? obj.labelSmall : textStyle16;
        return obj.copy(displayLarge, displayMedium, displaySmall, headlineLarge, headlineMedium, headlineSmall, titleLarge, titleMedium, titleSmall, bodyLarge, bodyMedium, bodySmall, labelLarge, labelMedium, labelSmall);
    }

    public final androidx.compose.material3.Typography copy(TextStyle displayLarge, TextStyle displayMedium, TextStyle displaySmall, TextStyle headlineLarge, TextStyle headlineMedium, TextStyle headlineSmall, TextStyle titleLarge, TextStyle titleMedium, TextStyle titleSmall, TextStyle bodyLarge, TextStyle bodyMedium, TextStyle bodySmall, TextStyle labelLarge, TextStyle labelMedium, TextStyle labelSmall) {
        Typography typography = new Typography(displayLarge, displayMedium, displaySmall, headlineLarge, headlineMedium, headlineSmall, titleLarge, titleMedium, titleSmall, bodyLarge, bodyMedium, bodySmall, labelLarge, labelMedium, labelSmall);
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
        if (!Intrinsics.areEqual(this.displayLarge, obj.displayLarge)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.displayMedium, obj2.displayMedium)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.displaySmall, obj3.displaySmall)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.headlineLarge, obj4.headlineLarge)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.headlineMedium, obj5.headlineMedium)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.headlineSmall, obj6.headlineSmall)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.titleLarge, obj7.titleLarge)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.titleMedium, obj8.titleMedium)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.titleSmall, obj9.titleSmall)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.bodyLarge, obj10.bodyLarge)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.bodyMedium, obj11.bodyMedium)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.bodySmall, obj12.bodySmall)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.labelLarge, obj13.labelLarge)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.labelMedium, obj14.labelMedium)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.labelSmall, obj15.labelSmall)) {
            return i2;
        }
        return i;
    }

    public final TextStyle getBodyLarge() {
        return this.bodyLarge;
    }

    public final TextStyle getBodyMedium() {
        return this.bodyMedium;
    }

    public final TextStyle getBodySmall() {
        return this.bodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return this.displayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return this.displayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return this.displaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return this.headlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return this.headlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return this.headlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return this.labelLarge;
    }

    public final TextStyle getLabelMedium() {
        return this.labelMedium;
    }

    public final TextStyle getLabelSmall() {
        return this.labelSmall;
    }

    public final TextStyle getTitleLarge() {
        return this.titleLarge;
    }

    public final TextStyle getTitleMedium() {
        return this.titleMedium;
    }

    public final TextStyle getTitleSmall() {
        return this.titleSmall;
    }

    public int hashCode() {
        return result7 += i30;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Typography(displayLarge=").append(this.displayLarge).append(", displayMedium=").append(this.displayMedium).append(",displaySmall=").append(this.displaySmall).append(", headlineLarge=").append(this.headlineLarge).append(", headlineMedium=").append(this.headlineMedium).append(", headlineSmall=").append(this.headlineSmall).append(", titleLarge=").append(this.titleLarge).append(", titleMedium=").append(this.titleMedium).append(", titleSmall=").append(this.titleSmall).append(", bodyLarge=").append(this.bodyLarge).append(", bodyMedium=").append(this.bodyMedium).append(", bodySmall=");
        stringBuilder.append(this.bodySmall).append(", labelLarge=").append(this.labelLarge).append(", labelMedium=").append(this.labelMedium).append(", labelSmall=").append(this.labelSmall).append(')');
        return stringBuilder.toString();
    }
}
