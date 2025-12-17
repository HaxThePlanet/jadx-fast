package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "inputTextStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getInputTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lineHeightCache", "", "oneLineHeightCache", "resolvedStyle", "coerceMinLines", "Landroidx/compose/ui/unit/Constraints;", "inConstraints", "minLines", "", "coerceMinLines-Oh53vG4$foundation_release", "(JI)J", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MinLinesConstrainer {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.text.modifiers.MinLinesConstrainer.Companion Companion;
    private static androidx.compose.foundation.text.modifiers.MinLinesConstrainer last;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private final TextStyle inputTextStyle;
    private final LayoutDirection layoutDirection;
    private float lineHeightCache;
    private float oneLineHeightCache;
    private final TextStyle resolvedStyle;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer$Companion;", "", "()V", "last", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "from", "minMaxUtil", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "paramStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.foundation.text.modifiers.MinLinesConstrainer from(androidx.compose.foundation.text.modifiers.MinLinesConstrainer minMaxUtil, LayoutDirection layoutDirection, TextStyle paramStyle, Density density, FontFamily.Resolver fontFamilyResolver) {
            int fontFamilyResolver2;
            Object obj;
            int i;
            LayoutDirection fontFamilyResolver3;
            float density2;
            final int i2 = 0;
            obj = minMaxUtil;
            i = 0;
            if (minMaxUtil != null && layoutDirection == obj.getLayoutDirection() && Intrinsics.areEqual(paramStyle, obj.getInputTextStyle())) {
                obj = minMaxUtil;
                i = 0;
                if (layoutDirection == obj.getLayoutDirection()) {
                    if (Intrinsics.areEqual(paramStyle, obj.getInputTextStyle())) {
                        fontFamilyResolver3 = Float.compare(density3, density2) == 0 ? fontFamilyResolver2 : i2;
                        if (fontFamilyResolver3 != 0 && fontFamilyResolver == obj.getFontFamilyResolver()) {
                            if (fontFamilyResolver == obj.getFontFamilyResolver()) {
                                return obj;
                            }
                        }
                    }
                }
            }
            androidx.compose.foundation.text.modifiers.MinLinesConstrainer minLinesConstrainer = MinLinesConstrainer.access$getLast$cp();
            i = 0;
            if (minLinesConstrainer != null && layoutDirection == minLinesConstrainer.getLayoutDirection() && Intrinsics.areEqual(paramStyle, minLinesConstrainer.getInputTextStyle())) {
                i = 0;
                if (layoutDirection == minLinesConstrainer.getLayoutDirection()) {
                    if (Intrinsics.areEqual(paramStyle, minLinesConstrainer.getInputTextStyle())) {
                        if (Float.compare(density4, density2) == 0) {
                        } else {
                            fontFamilyResolver2 = i2;
                        }
                        if (fontFamilyResolver2 != 0 && fontFamilyResolver == minLinesConstrainer.getFontFamilyResolver()) {
                            if (fontFamilyResolver == minLinesConstrainer.getFontFamilyResolver()) {
                                return minLinesConstrainer;
                            }
                        }
                    }
                }
            }
            MinLinesConstrainer minLinesConstrainer2 = new MinLinesConstrainer(layoutDirection, TextStyleKt.resolveDefaults(paramStyle, layoutDirection), density, fontFamilyResolver, 0);
            final int obj14 = 0;
            final androidx.compose.foundation.text.modifiers.MinLinesConstrainer.Companion obj15 = MinLinesConstrainer.Companion;
            MinLinesConstrainer.access$setLast$cp(minLinesConstrainer2);
            return minLinesConstrainer2;
        }
    }
    static {
        MinLinesConstrainer.Companion companion = new MinLinesConstrainer.Companion(0);
        MinLinesConstrainer.Companion = companion;
        int i = 8;
    }

    private MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle inputTextStyle, Density density, FontFamily.Resolver fontFamilyResolver) {
        super();
        this.layoutDirection = layoutDirection;
        this.inputTextStyle = inputTextStyle;
        this.density = density;
        this.fontFamilyResolver = fontFamilyResolver;
        this.resolvedStyle = TextStyleKt.resolveDefaults(this.inputTextStyle, this.layoutDirection);
        int i = 2143289344;
        this.lineHeightCache = i;
        this.oneLineHeightCache = i;
    }

    public MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle textStyle2, Density density3, FontFamily.Resolver fontFamily$Resolver4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(layoutDirection, textStyle2, density3, resolver4);
    }

    public static final androidx.compose.foundation.text.modifiers.MinLinesConstrainer access$getLast$cp() {
        return MinLinesConstrainer.last;
    }

    public static final void access$setLast$cp(androidx.compose.foundation.text.modifiers.MinLinesConstrainer <set-?>) {
        MinLinesConstrainer.last = <set-?>;
    }

    public final long coerceMinLines-Oh53vG4$foundation_release(long inConstraints, int minLines) {
        float oneLineHeight;
        float lineHeight;
        boolean naN;
        int minHeight-impl;
        TextStyle maxHeight-impl;
        long l;
        int i4;
        Density density;
        FontFamily.Resolver fontFamilyResolver;
        int i;
        int i8;
        int i5;
        int i6;
        int i2;
        int i7;
        int i3;
        final Object obj = this;
        final int i9 = obj20;
        if (!Float.isNaN(obj.oneLineHeightCache)) {
            if (Float.isNaN(obj.lineHeightCache)) {
                int i23 = 0;
                int i16 = 0;
                i8 = 0;
                oneLineHeight = height;
                i4 = 0;
                obj.oneLineHeightCache = oneLineHeight;
                obj.lineHeightCache = naN - oneLineHeight;
            }
        } else {
        }
        if (i9 != 1) {
            int i13 = 0;
            minHeight-impl = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(Math.round(i11 += oneLineHeight), 0), Constraints.getMaxHeight-impl(inConstraints));
        } else {
            minHeight-impl = Constraints.getMinHeight-impl(inConstraints);
        }
        return ConstraintsKt.Constraints(Constraints.getMinWidth-impl(inConstraints), Constraints.getMaxWidth-impl(inConstraints), minHeight-impl, Constraints.getMaxHeight-impl(inConstraints));
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final TextStyle getInputTextStyle() {
        return this.inputTextStyle;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }
}
