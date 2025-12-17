package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
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
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u0000 G2\u00020\u0001:\u0001GBc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0014\u0008\u0002\u0010\u0011\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\u0002\u0010\u0015J,\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001b2\n\u0008\u0002\u0010>\u001a\u0004\u0018\u00010:ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J\u000e\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u00020\u001bJ\"\u0010C\u001a\u00020D2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\u0008E\u0010FR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\"R\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008%\u0010\"R\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\"R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010*R\u0019\u0010\u000b\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\u0008+\u0010\"R\u001c\u0010-\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010*\"\u0004\u0008/\u00100R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006H", d2 = {"Landroidx/compose/foundation/text/TextDelegate;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "maxLines", "", "minLines", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IIZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getIntrinsicsLayoutDirection$foundation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setIntrinsicsLayoutDirection$foundation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()I", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getMinLines", "nonNullIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getNonNullIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getOverflow-gIe3tQ8", "I", "paragraphIntrinsics", "getParagraphIntrinsics$foundation_release", "setParagraphIntrinsics$foundation_release", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;)V", "getPlaceholders", "()Ljava/util/List;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "prevResult", "layout-NN6Ew-U", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/ui/text/TextLayoutResult;", "layoutIntrinsics", "", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextDelegate {

    public static final int $stable;
    public static final androidx.compose.foundation.text.TextDelegate.Companion Companion;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private final int maxLines;
    private final int minLines;
    private final int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"Landroidx/compose/foundation/text/TextDelegate$Companion;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }
    }
    static {
        TextDelegate.Companion companion = new TextDelegate.Companion(0);
        TextDelegate.Companion = companion;
    }

    private TextDelegate(AnnotatedString text, TextStyle style, int maxLines, int minLines, boolean softWrap, int overflow, Density density, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> placeholders) {
        int i2;
        int i3;
        int i;
        super();
        this.text = text;
        this.style = style;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.softWrap = softWrap;
        this.overflow = overflow;
        this.density = density;
        this.fontFamilyResolver = fontFamilyResolver;
        this.placeholders = placeholders;
        i = 1;
        final int i7 = 0;
        i2 = this.maxLines > 0 ? i : i7;
        if (i2 == 0) {
        } else {
            i3 = this.minLines > 0 ? i : i7;
            if (i3 == 0) {
            } else {
                if (this.minLines <= this.maxLines) {
                } else {
                    i = i7;
                }
                if (i == 0) {
                } else {
                }
                int i5 = 0;
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("minLines greater than maxLines".toString());
                throw illegalArgumentException2;
            }
            int i4 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("no minLines".toString());
            throw illegalArgumentException;
        }
        int i6 = 0;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("no maxLines".toString());
        throw illegalArgumentException3;
    }

    public TextDelegate(AnnotatedString annotatedString, TextStyle textStyle2, int i3, int i4, boolean z5, int i6, Density density7, FontFamily.Resolver fontFamily$Resolver8, List list9, int i10, DefaultConstructorMarker defaultConstructorMarker11) {
        int emptyList;
        int i8;
        int clip-gIe3tQ8;
        int i;
        int i5;
        int i7;
        int i2;
        List list;
        int i9 = i10;
        i = i9 & 4 != 0 ? i8 : i3;
        int i13 = 1;
        i5 = i9 & 8 != 0 ? i13 : i4;
        i7 = i9 & 16 != 0 ? i13 : z5;
        if (i9 & 32 != 0) {
            i2 = clip-gIe3tQ8;
        } else {
            i2 = i6;
        }
        if (i9 &= 256 != 0) {
            list = emptyList;
        } else {
            list = list9;
        }
        super(annotatedString, textStyle2, i, i5, i7, i2, density7, resolver8, list, 0);
    }

    public TextDelegate(AnnotatedString annotatedString, TextStyle textStyle2, int i3, int i4, boolean z5, int i6, Density density7, FontFamily.Resolver fontFamily$Resolver8, List list9, DefaultConstructorMarker defaultConstructorMarker10) {
        super(annotatedString, textStyle2, i3, i4, z5, i6, density7, resolver8, list9);
    }

    private final MultiParagraphIntrinsics getNonNullIntrinsics() {
        MultiParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics == null) {
        } else {
            return paragraphIntrinsics;
        }
        IllegalStateException illegalStateException = new IllegalStateException("layoutIntrinsics must be called first");
        throw illegalStateException;
    }

    public static TextLayoutResult layout-NN6Ew-U$default(androidx.compose.foundation.text.TextDelegate textDelegate, long l2, LayoutDirection layoutDirection3, TextLayoutResult textLayoutResult4, int i5, Object object6) {
        int obj4;
        if (object6 &= 4 != 0) {
            obj4 = 0;
        }
        return textDelegate.layout-NN6Ew-U(l2, layoutDirection3, textLayoutResult4);
    }

    private final MultiParagraph layoutText-K40F9xA(long constraints, LayoutDirection layoutDirection) {
        boolean softWrap;
        int i;
        int maxLines;
        int coerceIn;
        int hasBoundedWidth-impl;
        int maxWidth-impl;
        boolean softWrap2;
        int i2;
        int ellipsis-gIe3tQ8;
        layoutIntrinsics(obj17);
        final int minWidth-impl = Constraints.getMinWidth-impl(constraints);
        maxLines = 1;
        int i3 = 0;
        if (!this.softWrap) {
            if (TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                i = maxLines;
            } else {
                i = i3;
            }
        } else {
        }
        if (i != 0 && Constraints.getHasBoundedWidth-impl(constraints)) {
            if (Constraints.getHasBoundedWidth-impl(constraints)) {
                maxWidth-impl = Constraints.getMaxWidth-impl(constraints);
            } else {
                maxWidth-impl = Integer.MAX_VALUE;
            }
        } else {
        }
        if (!this.softWrap && TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
            i2 = TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8()) ? maxLines : i3;
        } else {
        }
        if (i2 != 0) {
        } else {
            maxLines = this.maxLines;
        }
        if (minWidth-impl == maxWidth-impl) {
            coerceIn = maxWidth-impl;
        } else {
            coerceIn = RangesKt.coerceIn(getMaxIntrinsicWidth(), minWidth-impl, maxWidth-impl);
        }
        final int maxHeight-impl = Constraints.getMaxHeight-impl(constraints);
        MultiParagraph multiParagraph = new MultiParagraph(getNonNullIntrinsics(), Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(i3, coerceIn, i3, maxHeight-impl), maxHeight-impl, maxLines, TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8()), 0);
        return multiParagraph;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final LayoutDirection getIntrinsicsLayoutDirection$foundation_release() {
        return this.intrinsicsLayoutDirection;
    }

    public final int getMaxIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMaxIntrinsicWidth());
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getMinIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMinIntrinsicWidth());
    }

    public final int getMinLines() {
        return this.minLines;
    }

    public final int getOverflow-gIe3tQ8() {
        return this.overflow;
    }

    public final MultiParagraphIntrinsics getParagraphIntrinsics$foundation_release() {
        return this.paragraphIntrinsics;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final TextLayoutResult layout-NN6Ew-U(long constraints, LayoutDirection layoutDirection, TextLayoutResult prevResult) {
        Object obj2;
        boolean reuse-7_7YC6M;
        TextStyle style;
        List placeholders;
        int maxLines;
        boolean softWrap;
        int overflow;
        Density density;
        Density density2;
        FontFamily.Resolver fontFamilyResolver;
        FontFamily.Resolver resolver;
        final Object obj = this;
        if (obj22 != null && TextLayoutHelperKt.canReuse-7_7YC6M(obj22, obj.text, obj.style, obj.placeholders, obj.maxLines, obj.softWrap, obj.overflow, obj.density, prevResult, obj.fontFamilyResolver, constraints)) {
            if (TextLayoutHelperKt.canReuse-7_7YC6M(obj22, obj.text, obj.style, obj.placeholders, obj.maxLines, obj.softWrap, obj.overflow, obj.density, prevResult, obj.fontFamilyResolver, constraints)) {
                Object obj3 = obj22;
                int i4 = 0;
                long l5 = constraints;
                TextLayoutInput textLayoutInput2 = new TextLayoutInput(obj3.getLayoutInput().getText(), obj.style, obj3.getLayoutInput().getPlaceholders(), obj3.getLayoutInput().getMaxLines(), obj3.getLayoutInput().getSoftWrap(), obj3.getLayoutInput().getOverflow-gIe3tQ8(), obj3.getLayoutInput().getDensity(), obj3.getLayoutInput().getLayoutDirection(), obj3.getLayoutInput().getFontFamilyResolver(), l5, obj12, 0);
                int ceilToIntPx4 = TextDelegateKt.ceilToIntPx(obj3.getMultiParagraph().getHeight());
                return obj3.copy-O0kMr_c(textLayoutInput2, ConstraintsKt.constrain-4WqzIAM(l5, obj12));
            }
        }
        long l4 = constraints;
        MultiParagraph layoutText-K40F9xA = layoutText-K40F9xA(constraints, layoutDirection);
        int ceilToIntPx2 = TextDelegateKt.ceilToIntPx(layoutText-K40F9xA.getHeight());
        boolean softWrap2 = obj.softWrap;
        TextLayoutInput textLayoutInput = new TextLayoutInput(obj.text, obj.style, obj.placeholders, obj.maxLines, softWrap2, obj.overflow, obj.density, prevResult, obj.fontFamilyResolver, l4, obj12, 0);
        TextLayoutResult textLayoutResult = textLayoutResult2;
        super(textLayoutInput, layoutText-K40F9xA, ConstraintsKt.constrain-4WqzIAM(l4, obj12), softWrap2, 0);
        return textLayoutResult;
    }

    public final void layoutIntrinsics(LayoutDirection layoutDirection) {
        LayoutDirection intrinsicsLayoutDirection;
        MultiParagraphIntrinsics multiParagraphIntrinsics;
        AnnotatedString text;
        TextStyle resolveDefaults;
        List placeholders;
        Density density;
        FontFamily.Resolver fontFamilyResolver;
        final MultiParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics != null && layoutDirection == this.intrinsicsLayoutDirection) {
            if (layoutDirection == this.intrinsicsLayoutDirection) {
                if (paragraphIntrinsics.getHasStaleResolvedFonts()) {
                    this.intrinsicsLayoutDirection = layoutDirection;
                    multiParagraphIntrinsics = new MultiParagraphIntrinsics(this.text, TextStyleKt.resolveDefaults(this.style, layoutDirection), this.placeholders, this.density, this.fontFamilyResolver);
                } else {
                    multiParagraphIntrinsics = paragraphIntrinsics;
                }
            } else {
            }
        } else {
        }
        this.paragraphIntrinsics = multiParagraphIntrinsics;
    }

    public final void setIntrinsicsLayoutDirection$foundation_release(LayoutDirection <set-?>) {
        this.intrinsicsLayoutDirection = <set-?>;
    }

    public final void setParagraphIntrinsics$foundation_release(MultiParagraphIntrinsics <set-?>) {
        this.paragraphIntrinsics = <set-?>;
    }
}
