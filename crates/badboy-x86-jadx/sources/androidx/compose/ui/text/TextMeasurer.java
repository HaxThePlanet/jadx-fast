package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u008a\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\t2\u0014\u0008\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00052\u0008\u0008\u0002\u0010 \u001a\u00020\u00032\u0008\u0008\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#Jt\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00052\u0008\u0008\u0002\u0010 \u001a\u00020\u00032\u0008\u0008\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006(", d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "defaultFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "defaultDensity", "Landroidx/compose/ui/unit/Density;", "defaultLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextMeasurer {

    public static final int $stable;
    public static final androidx.compose.ui.text.TextMeasurer.Companion Companion;
    private final int cacheSize;
    private final Density defaultDensity;
    private final FontFamily.Resolver defaultFontFamilyResolver;
    private final LayoutDirection defaultLayoutDirection;
    private final androidx.compose.ui.text.TextLayoutCache textLayoutCache;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final androidx.compose.ui.text.TextLayoutResult access$layout(androidx.compose.ui.text.TextMeasurer.Companion $this, androidx.compose.ui.text.TextLayoutInput textLayoutInput) {
            return $this.layout(textLayoutInput);
        }

        private final androidx.compose.ui.text.TextLayoutResult layout(androidx.compose.ui.text.TextLayoutInput textLayoutInput) {
            boolean softWrap;
            int hasBoundedWidth-impl;
            int maxWidth-impl;
            boolean softWrap2;
            int i;
            int coerceIn;
            int maxLines;
            FontFamily.Resolver constraints-msEJaDk;
            final androidx.compose.ui.text.TextLayoutInput textLayoutInput2 = textLayoutInput;
            final int i2 = 0;
            androidx.compose.ui.text.AnnotatedString text = textLayoutInput2.getText();
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(text, TextStyleKt.resolveDefaults(textLayoutInput2.getStyle(), textLayoutInput2.getLayoutDirection()), textLayoutInput2.getPlaceholders(), textLayoutInput2.getDensity(), textLayoutInput2.getFontFamilyResolver());
            androidx.compose.ui.text.MultiParagraphIntrinsics multiParagraphIntrinsics2 = multiParagraphIntrinsics;
            int minWidth-impl = Constraints.getMinWidth-impl(textLayoutInput2.getConstraints-msEJaDk());
            maxLines = 1;
            int i4 = 0;
            if (!textLayoutInput2.getSoftWrap()) {
                if (TextOverflow.equals-impl0(textLayoutInput2.getOverflow-gIe3tQ8(), TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                    hasBoundedWidth-impl = maxLines;
                } else {
                    hasBoundedWidth-impl = i4;
                }
            } else {
            }
            if (hasBoundedWidth-impl != 0 && Constraints.getHasBoundedWidth-impl(textLayoutInput2.getConstraints-msEJaDk())) {
                if (Constraints.getHasBoundedWidth-impl(textLayoutInput2.getConstraints-msEJaDk())) {
                    maxWidth-impl = Constraints.getMaxWidth-impl(textLayoutInput2.getConstraints-msEJaDk());
                } else {
                    maxWidth-impl = Integer.MAX_VALUE;
                }
            } else {
            }
            final int i9 = maxWidth-impl;
            if (!textLayoutInput2.getSoftWrap() && TextOverflow.equals-impl0(textLayoutInput2.getOverflow-gIe3tQ8(), TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                i = TextOverflow.equals-impl0(textLayoutInput2.getOverflow-gIe3tQ8(), TextOverflow.Companion.getEllipsis-gIe3tQ8()) ? maxLines : i4;
            } else {
            }
            if (i != 0) {
            } else {
                maxLines = textLayoutInput2.getMaxLines();
            }
            if (minWidth-impl == i9) {
                coerceIn = i9;
            } else {
                coerceIn = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics2.getMaxIntrinsicWidth()), minWidth-impl, i9);
            }
            int i7 = 0;
            MultiParagraph multiParagraph = new MultiParagraph(multiParagraphIntrinsics2, Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(i4, coerceIn, i4, Constraints.getMaxHeight-impl(textLayoutInput2.getConstraints-msEJaDk())), i4, maxLines, TextOverflow.equals-impl0(textLayoutInput2.getOverflow-gIe3tQ8(), TextOverflow.Companion.getEllipsis-gIe3tQ8()), i7);
            final androidx.compose.ui.text.MultiParagraph multiParagraph2 = multiParagraph;
            TextLayoutResult textLayoutResult = new TextLayoutResult(textLayoutInput, multiParagraph2, ConstraintsKt.constrain-4WqzIAM(textLayoutInput2.getConstraints-msEJaDk(), i4), obj18, 0);
            return textLayoutResult;
        }
    }
    static {
        TextMeasurer.Companion companion = new TextMeasurer.Companion(0);
        TextMeasurer.Companion = companion;
    }

    public TextMeasurer(FontFamily.Resolver defaultFontFamilyResolver, Density defaultDensity, LayoutDirection defaultLayoutDirection, int cacheSize) {
        androidx.compose.ui.text.TextLayoutCache textLayoutCache;
        int cacheSize2;
        super();
        this.defaultFontFamilyResolver = defaultFontFamilyResolver;
        this.defaultDensity = defaultDensity;
        this.defaultLayoutDirection = defaultLayoutDirection;
        this.cacheSize = cacheSize;
        if (this.cacheSize > 0) {
            textLayoutCache = new TextLayoutCache(this.cacheSize);
        } else {
            textLayoutCache = 0;
        }
        this.textLayoutCache = textLayoutCache;
    }

    public TextMeasurer(FontFamily.Resolver fontFamily$Resolver, Density density2, LayoutDirection layoutDirection3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj4;
        if (i5 &= 8 != 0) {
            obj4 = TextMeasurerKt.access$getDefaultCacheSize$p();
        }
        super(resolver, density2, layoutDirection3, obj4);
    }

    public static androidx.compose.ui.text.TextLayoutResult measure-wNUYSr0$default(androidx.compose.ui.text.TextMeasurer textMeasurer, String string2, androidx.compose.ui.text.TextStyle textStyle3, int i4, boolean z5, int i6, long l7, LayoutDirection layoutDirection8, Density density9, FontFamily.Resolver fontFamily$Resolver10, boolean z11, int i12, Object object13) {
        androidx.compose.ui.text.TextStyle textStyle;
        int i2;
        int i10;
        int i;
        long l;
        int i3;
        int i8;
        LayoutDirection layoutDirection;
        int i11;
        Density density;
        int i9;
        FontFamily.Resolver resolver;
        int i5;
        int i7;
        androidx.compose.ui.text.TextStyle obj14;
        int obj15;
        int i13 = object13;
        if (i13 & 2 != 0) {
            textStyle = obj14;
        } else {
            textStyle = textStyle3;
        }
        if (i13 & 4 != 0) {
            i2 = obj15;
        } else {
            i2 = i4;
        }
        i10 = i13 & 8 != 0 ? obj14 : z5;
        i = i13 & 16 != 0 ? obj14 : i6;
        if (i13 & 32 != 0) {
            l = obj14;
        } else {
            l = l7;
        }
        layoutDirection = i13 & 64 != 0 ? obj14 : density9;
        density = i13 & 128 != 0 ? obj14 : resolver10;
        resolver = i13 & 256 != 0 ? obj14 : z11;
        i7 = i13 & 512 != 0 ? obj14 : i12;
        return textMeasurer.measure-wNUYSr0(string2, textStyle, i2, i10, i, l, i3, layoutDirection, density, resolver);
    }

    public static androidx.compose.ui.text.TextLayoutResult measure-xDpz5zY$default(androidx.compose.ui.text.TextMeasurer textMeasurer, androidx.compose.ui.text.AnnotatedString annotatedString2, androidx.compose.ui.text.TextStyle textStyle3, int i4, boolean z5, int i6, List list7, long l8, LayoutDirection layoutDirection9, Density density10, FontFamily.Resolver fontFamily$Resolver11, boolean z12, int i13, Object object14) {
        int i8;
        androidx.compose.ui.text.TextStyle textStyle;
        int i3;
        int i9;
        int i2;
        List list;
        long l;
        int i5;
        int i7;
        LayoutDirection layoutDirection;
        int i10;
        Density density;
        FontFamily.Resolver resolver;
        int i;
        androidx.compose.ui.text.TextStyle obj15;
        int obj16;
        int obj17;
        int obj18;
        int obj19;
        int obj20;
        int obj21;
        int i11 = object14;
        if (i11 & 2 != 0) {
            textStyle = obj15;
        } else {
            textStyle = textStyle3;
        }
        if (i11 & 4 != 0) {
            i3 = obj15;
        } else {
            i3 = i4;
        }
        i9 = i11 & 8 != 0 ? obj15 : z5;
        i2 = i11 & 16 != 0 ? obj15 : i6;
        if (i11 & 32 != 0) {
            list = obj15;
        } else {
            list = list7;
        }
        if (i11 & 64 != 0) {
            l = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0);
        } else {
            l = l8;
        }
        layoutDirection = i11 & 128 != 0 ? obj15 : density10;
        density = i11 & 256 != 0 ? obj15 : resolver11;
        resolver = i11 & 512 != 0 ? obj15 : z12;
        i = i11 & 1024 != 0 ? obj15 : i13;
        return textMeasurer.measure-xDpz5zY(annotatedString2, textStyle, i3, i9, i2, list, l, i5, layoutDirection, density, resolver);
    }

    public final androidx.compose.ui.text.TextLayoutResult measure-wNUYSr0(String text, androidx.compose.ui.text.TextStyle style, int overflow, boolean softWrap, int maxLines, long constraints, LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        AnnotatedString annotatedString = new AnnotatedString(text, 0, 0, 6, 0);
        return TextMeasurer.measure-xDpz5zY$default(this, annotatedString, style, overflow, softWrap, maxLines, 0, constraints, obj8, density, fontFamilyResolver, skipCache, obj26, 32);
    }

    public final androidx.compose.ui.text.TextLayoutResult measure-xDpz5zY(androidx.compose.ui.text.AnnotatedString text, androidx.compose.ui.text.TextStyle style, int overflow, boolean softWrap, int maxLines, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, long constraints, LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        Object textLayoutCache;
        int i;
        androidx.compose.ui.text.TextLayoutResult copy-O0kMr_c;
        androidx.compose.ui.text.TextLayoutResult ceilToInt;
        int i2;
        androidx.compose.ui.text.TextLayoutCache textLayoutCache2;
        long l;
        TextLayoutInput textLayoutInput = new TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, fontFamilyResolver, density, skipCache, constraints, obj11, 0);
        if (obj25 == null && this.textLayoutCache != null) {
            if (this.textLayoutCache != null) {
                i = this.textLayoutCache.get(textLayoutInput);
            } else {
                i = 0;
            }
        } else {
        }
        if (i != 0) {
            ceilToInt = ParagraphKt.ceilToInt(i.getMultiParagraph().getHeight());
            copy-O0kMr_c = i.copy-O0kMr_c(textLayoutInput, ConstraintsKt.constrain-4WqzIAM(constraints, obj11));
        } else {
            l = constraints;
            i2 = 0;
            textLayoutCache2 = this.textLayoutCache;
            if (textLayoutCache2 != null) {
                textLayoutCache2.put(textLayoutInput, TextMeasurer.Companion.access$layout(TextMeasurer.Companion, textLayoutInput));
            }
        }
        return copy-O0kMr_c;
    }
}
