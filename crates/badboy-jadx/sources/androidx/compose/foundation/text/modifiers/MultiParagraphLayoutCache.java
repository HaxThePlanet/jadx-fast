package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0011\u0008\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r\u0012\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010¢\u0006\u0002\u0010\u0013J\u0016\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001eJ\"\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\u00085\u00106J \u00107\u001a\u00020\u000b2\u0006\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\u00088\u00109J\u0008\u0010:\u001a\u00020;H\u0002J\u000e\u0010<\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001eJ\u001a\u0010=\u001a\u00020\r2\u0006\u00103\u001a\u000204H\u0002ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J\u000e\u0010@\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001eJ\u0010\u0010A\u001a\u00020+2\u0006\u00100\u001a\u00020\u001eH\u0002J*\u0010,\u001a\u00020#2\u0006\u00100\u001a\u00020\u001e2\u0006\u0010B\u001a\u0002042\u0006\u0010C\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ^\u0010F\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJ(\u0010I\u001a\u00020\u000b*\u0004\u0018\u00010#2\u0006\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\u0008J\u0010KR\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u00020 X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010$\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\u0008-\u0010&\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006L", d2 = {"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "cachedIntrinsicHeight", "cachedIntrinsicHeightInputWidth", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "layoutCache", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutOrNull", "getLayoutOrNull", "()Landroidx/compose/ui/text/TextLayoutResult;", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "I", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "textLayoutResult", "getTextLayoutResult", "intrinsicHeight", "width", "layoutDirection", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "layoutWithConstraints", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "", "maxIntrinsicWidth", "maxWidth", "maxWidth-BRTryo0", "(J)I", "minIntrinsicWidth", "setLayoutDirection", "finalConstraints", "multiParagraph", "textLayoutResult-VKLhPVY", "(Landroidx/compose/ui/unit/LayoutDirection;JLandroidx/compose/ui/text/MultiParagraph;)Landroidx/compose/ui/text/TextLayoutResult;", "update", "update-ZNqEYIc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;)V", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-VKLhPVY", "(Landroidx/compose/ui/text/TextLayoutResult;JLandroidx/compose/ui/unit/LayoutDirection;)Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiParagraphLayoutCache {

    public static final int $stable = 8;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private TextLayoutResult layoutCache;
    private androidx.compose.foundation.text.modifiers.MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;
    static {
        final int i = 8;
    }

    private MultiParagraphLayoutCache(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders) {
        super();
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.placeholders = placeholders;
        this.lastDensity = InlineDensity.Companion.getUnspecified-L26CHvs();
        int i = -1;
        this.cachedIntrinsicHeightInputWidth = i;
        this.cachedIntrinsicHeight = i;
    }

    public MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, int i4, boolean z5, int i6, int i7, List list8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        int i3;
        int clip-gIe3tQ8;
        int i;
        int i10;
        int i8;
        int i5;
        int i11;
        int i2;
        int i12 = i9;
        if (i12 & 8 != 0) {
            i10 = clip-gIe3tQ8;
        } else {
            i10 = i4;
        }
        int i15 = 1;
        i8 = i12 & 16 != 0 ? i15 : z5;
        i5 = i12 & 32 != 0 ? i : i6;
        i11 = i12 & 64 != 0 ? i15 : i7;
        i2 = i12 &= 128 != 0 ? i3 : list8;
        super(annotatedString, textStyle2, resolver3, i10, i8, i5, i11, i2, 0);
    }

    public MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, int i4, boolean z5, int i6, int i7, List list8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(annotatedString, textStyle2, resolver3, i4, z5, i6, i7, list8);
    }

    private final MultiParagraph layoutText-K40F9xA(long constraints, LayoutDirection layoutDirection) {
        final MultiParagraphIntrinsics layoutDirection2 = setLayoutDirection(obj10);
        final int overflow = this.overflow;
        MultiParagraph multiParagraph = new MultiParagraph(layoutDirection2, LayoutUtilsKt.finalConstraints-tfFHcEY(constraints, layoutDirection, this.softWrap, overflow), overflow, LayoutUtilsKt.finalMaxLines-xdlQI24(this.softWrap, this.overflow, this.maxLines), TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8()), 0);
        return multiParagraph;
    }

    private final void markDirty() {
        int i = 0;
        this.paragraphIntrinsics = i;
        this.layoutCache = i;
        int i2 = -1;
        this.cachedIntrinsicHeight = i2;
        this.cachedIntrinsicHeightInputWidth = i2;
    }

    private final int maxWidth-BRTryo0(long constraints) {
        MultiParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        Intrinsics.checkNotNull(paragraphIntrinsics);
        return LayoutUtilsKt.finalMaxWidth-tfFHcEY(constraints, obj5, this.softWrap, this.overflow);
    }

    private final boolean newLayoutWillBeDifferent-VKLhPVY(TextLayoutResult $this$newLayoutWillBeDifferent_u2dVKLhPVY, long constraints, LayoutDirection layoutDirection) {
        int didExceedMaxLines;
        final int i = 1;
        if ($this$newLayoutWillBeDifferent_u2dVKLhPVY == null) {
            return i;
        }
        if ($this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return i;
        }
        if (obj9 != $this$newLayoutWillBeDifferent_u2dVKLhPVY.getLayoutInput().getLayoutDirection()) {
            return i;
        }
        final int i2 = 0;
        if (Constraints.equals-impl0(constraints, layoutDirection)) {
            return i2;
        }
        if (Constraints.getMaxWidth-impl(constraints) != Constraints.getMaxWidth-impl($this$newLayoutWillBeDifferent_u2dVKLhPVY.getLayoutInput().getConstraints-msEJaDk())) {
            return i;
        }
        if (Float.compare(f, height) >= 0 && $this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getDidExceedMaxLines()) {
            if ($this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getDidExceedMaxLines()) {
            }
            return i2;
        }
        return i;
    }

    private final MultiParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        LayoutDirection intrinsicsLayoutDirection;
        MultiParagraphIntrinsics multiParagraphIntrinsics;
        AnnotatedString text;
        TextStyle resolveDefaults;
        List list;
        Density density;
        FontFamily.Resolver fontFamilyResolver;
        final MultiParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics != null && layoutDirection == this.intrinsicsLayoutDirection) {
            if (layoutDirection == this.intrinsicsLayoutDirection) {
                if (paragraphIntrinsics.getHasStaleResolvedFonts()) {
                    this.intrinsicsLayoutDirection = layoutDirection;
                    density = this.density;
                    Intrinsics.checkNotNull(density);
                    if (this.placeholders == null) {
                        intrinsicsLayoutDirection = CollectionsKt.emptyList();
                    }
                    multiParagraphIntrinsics = new MultiParagraphIntrinsics(this.text, TextStyleKt.resolveDefaults(this.style, layoutDirection), intrinsicsLayoutDirection, density, this.fontFamilyResolver);
                } else {
                    multiParagraphIntrinsics = paragraphIntrinsics;
                }
            } else {
            }
        } else {
        }
        this.paragraphIntrinsics = multiParagraphIntrinsics;
        return multiParagraphIntrinsics;
    }

    private final TextLayoutResult textLayoutResult-VKLhPVY(LayoutDirection layoutDirection, long finalConstraints, MultiParagraph multiParagraph) {
        List emptyList;
        final Object obj = this;
        if (obj.placeholders == null) {
            emptyList = CollectionsKt.emptyList();
        }
        final Density density = obj.density;
        Intrinsics.checkNotNull(density);
        final long l2 = finalConstraints;
        TextLayoutInput textLayoutInput = new TextLayoutInput(obj.text, obj.style, emptyList, obj.maxLines, obj.softWrap, obj.overflow, density, layoutDirection, obj.fontFamilyResolver, l2, obj14, 0);
        int ceilToIntPx2 = TextDelegateKt.ceilToIntPx(obj20.getHeight());
        TextLayoutResult textLayoutResult = new TextLayoutResult(textLayoutInput, obj20, ConstraintsKt.constrain-4WqzIAM(l2, obj14), emptyList, 0);
        return textLayoutResult;
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final TextLayoutResult getLayoutOrNull() {
        return this.layoutCache;
    }

    public final TextLayoutResult getTextLayoutResult() {
        TextLayoutResult layoutCache = this.layoutCache;
        if (layoutCache == null) {
        } else {
            return layoutCache;
        }
        IllegalStateException illegalStateException = new IllegalStateException("You must call layoutWithConstraints first");
        throw illegalStateException;
    }

    public final int intrinsicHeight(int width, LayoutDirection layoutDirection) {
        int i;
        final int cachedIntrinsicHeightInputWidth = this.cachedIntrinsicHeightInputWidth;
        if (width == cachedIntrinsicHeightInputWidth && cachedIntrinsicHeightInputWidth != -1) {
            if (cachedIntrinsicHeightInputWidth != -1) {
                return this.cachedIntrinsicHeight;
            }
        }
        final int i3 = 0;
        int ceilToIntPx = TextDelegateKt.ceilToIntPx(layoutText-K40F9xA(ConstraintsKt.Constraints(i3, width, i3, Integer.MAX_VALUE), i3).getHeight());
        this.cachedIntrinsicHeightInputWidth = width;
        this.cachedIntrinsicHeight = ceilToIntPx;
        return ceilToIntPx;
    }

    public final boolean layoutWithConstraints-K40F9xA(long constraints, LayoutDirection layoutDirection) {
        int minLines;
        long coerceMinLines-Oh53vG4$foundation_release;
        androidx.compose.foundation.text.modifiers.MinLinesConstrainer mMinLinesConstrainer;
        LayoutDirection layoutDirection2;
        TextStyle style;
        Density density;
        FontFamily.Resolver fontFamilyResolver;
        Object obj11;
        final int i = 1;
        if (this.minLines > i) {
            density = this.density;
            Intrinsics.checkNotNull(density);
            obj11 = MinLinesConstrainer.Companion.from(this.mMinLinesConstrainer, obj11, this.style, density, this.fontFamilyResolver);
            int i2 = 0;
            this.mMinLinesConstrainer = obj11;
            coerceMinLines-Oh53vG4$foundation_release = obj11.coerceMinLines-Oh53vG4$foundation_release(constraints, layoutDirection);
        } else {
            layoutDirection2 = obj11;
            coerceMinLines-Oh53vG4$foundation_release = constraints;
        }
        obj11 = this.layoutCache;
        Intrinsics.checkNotNull(obj11);
        if (!newLayoutWillBeDifferent-VKLhPVY(this.layoutCache, coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer) && Constraints.equals-impl0(coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer)) {
            obj11 = this.layoutCache;
            Intrinsics.checkNotNull(obj11);
            if (Constraints.equals-impl0(coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer)) {
                return 0;
            }
            obj11 = this.layoutCache;
            Intrinsics.checkNotNull(obj11);
            this.layoutCache = textLayoutResult-VKLhPVY(layoutDirection2, coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer);
            return i;
        }
        this.layoutCache = textLayoutResult-VKLhPVY(layoutDirection2, coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer);
        return i;
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    public final void setDensity$foundation_release(Density value) {
        long it;
        int i;
        boolean equals-impl0;
        if (value != null) {
            i = 0;
            it = InlineDensity.constructor-impl(value);
        } else {
            it = InlineDensity.Companion.getUnspecified-L26CHvs();
        }
        if (this.density == null) {
            this.density = value;
            this.lastDensity = it;
        }
        if (value != null) {
            if (!InlineDensity.equals-impl0(this.lastDensity, obj4)) {
                this.density = value;
                this.lastDensity = it;
                markDirty();
            }
        } else {
        }
    }

    public final void update-ZNqEYIc(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders) {
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.placeholders = placeholders;
        markDirty();
    }
}
