package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0016\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\"\u0010=\u001a\u0002012\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J \u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\u0008B\u0010CJ\u0008\u0010D\u001a\u00020,H\u0002J\u000e\u0010E\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001fJ\"\u0010G\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\u0008H\u0010CJ\u0010\u0010I\u001a\u0002072\u0006\u0010<\u001a\u00020\u001fH\u0002J\u0010\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010\u0004\u001a\u00020\u0005J\u0008\u0010L\u001a\u00020\u0003H\u0016JH\u0010M\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\u0008N\u0010OR\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u00020!X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"R\"\u0010#\u001a\u00020$X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u0016\u0010\u0008\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00082\u00103\"\u0004\u00084\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\u000209X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006P", d2 = {"Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "cachedIntrinsicHeight", "cachedIntrinsicHeightInputWidth", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "didOverflow", "getDidOverflow$foundation_release", "()Z", "setDidOverflow$foundation_release", "(Z)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "layoutSize", "Landroidx/compose/ui/unit/IntSize;", "getLayoutSize-YbymL2g$foundation_release", "()J", "setLayoutSize-ozmzZPI$foundation_release", "(J)V", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "observeFontChanges", "", "getObserveFontChanges$foundation_release", "()Lkotlin/Unit;", "I", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "getParagraph$foundation_release", "()Landroidx/compose/ui/text/Paragraph;", "setParagraph$foundation_release", "(Landroidx/compose/ui/text/Paragraph;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "prevConstraints", "Landroidx/compose/ui/unit/Constraints;", "intrinsicHeight", "width", "layoutDirection", "layoutText", "constraints", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/Paragraph;", "layoutWithConstraints", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "maxIntrinsicWidth", "minIntrinsicWidth", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-K40F9xA", "setLayoutDirection", "slowCreateTextLayoutResultOrNull", "Landroidx/compose/ui/text/TextLayoutResult;", "toString", "update", "update-L6sJoHM", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZII)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParagraphLayoutCache {

    public static final int $stable = 8;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private boolean didOverflow;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private long layoutSize;
    private androidx.compose.foundation.text.modifiers.MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private Paragraph paragraph;
    private ParagraphIntrinsics paragraphIntrinsics;
    private long prevConstraints;
    private boolean softWrap;
    private TextStyle style;
    private String text;
    static {
        final int i = 8;
    }

    private ParagraphLayoutCache(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines) {
        super();
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.lastDensity = InlineDensity.Companion.getUnspecified-L26CHvs();
        int i = 0;
        this.layoutSize = IntSizeKt.IntSize(i, i);
        this.prevConstraints = Constraints.Companion.fixed-JhjzzOo(i, i);
        int i2 = -1;
        this.cachedIntrinsicHeightInputWidth = i2;
        this.cachedIntrinsicHeight = i2;
    }

    public ParagraphLayoutCache(String string, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, int i4, boolean z5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        int i3;
        int i;
        int i2;
        int i5;
        int obj13;
        if (i8 & 8 != 0) {
            i3 = obj13;
        } else {
            i3 = i4;
        }
        int i10 = 1;
        i = i8 & 16 != 0 ? i10 : z5;
        i2 = i8 & 32 != 0 ? obj13 : i6;
        i5 = i8 & 64 != 0 ? i10 : i7;
        super(string, textStyle2, resolver3, i3, i, i2, i5, 0);
    }

    public ParagraphLayoutCache(String string, TextStyle textStyle2, FontFamily.Resolver fontFamily$Resolver3, int i4, boolean z5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        super(string, textStyle2, resolver3, i4, z5, i6, i7);
    }

    private final Paragraph layoutText-K40F9xA(long constraints, LayoutDirection layoutDirection) {
        final ParagraphIntrinsics layoutDirection2 = setLayoutDirection(obj9);
        final int overflow = this.overflow;
        return ParagraphKt.Paragraph-_EkL_-Y(layoutDirection2, LayoutUtilsKt.finalConstraints-tfFHcEY(constraints, layoutDirection, this.softWrap, overflow), overflow, LayoutUtilsKt.finalMaxLines-xdlQI24(this.softWrap, this.overflow, this.maxLines));
    }

    private final void markDirty() {
        int i = 0;
        this.paragraph = i;
        this.paragraphIntrinsics = i;
        this.intrinsicsLayoutDirection = i;
        int i2 = -1;
        this.cachedIntrinsicHeightInputWidth = i2;
        this.cachedIntrinsicHeight = i2;
        final int i3 = 0;
        this.prevConstraints = Constraints.Companion.fixed-JhjzzOo(i3, i3);
        this.layoutSize = IntSizeKt.IntSize(i3, i3);
        this.didOverflow = i3;
    }

    private final boolean newLayoutWillBeDifferent-K40F9xA(long constraints, LayoutDirection layoutDirection) {
        int didExceedMaxLines;
        final Paragraph paragraph = this.paragraph;
        final int i = 1;
        if (paragraph == null) {
            return i;
        }
        final ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics == null) {
            return i;
        }
        if (paragraphIntrinsics.getHasStaleResolvedFonts()) {
            return i;
        }
        if (obj10 != this.intrinsicsLayoutDirection) {
            return i;
        }
        final int i2 = 0;
        if (Constraints.equals-impl0(constraints, layoutDirection)) {
            return i2;
        }
        if (Constraints.getMaxWidth-impl(constraints) != Constraints.getMaxWidth-impl(this.prevConstraints)) {
            return i;
        }
        if (Float.compare(f, height) >= 0 && paragraph.getDidExceedMaxLines()) {
            if (paragraph.getDidExceedMaxLines()) {
            }
            return i2;
        }
        return i;
    }

    private final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        LayoutDirection intrinsicsLayoutDirection;
        ParagraphIntrinsics paragraphIntrinsics;
        String text;
        TextStyle resolveDefaults;
        int i3;
        int i4;
        Density density;
        FontFamily.Resolver fontFamilyResolver;
        int i2;
        int i;
        final ParagraphIntrinsics paragraphIntrinsics2 = this.paragraphIntrinsics;
        if (paragraphIntrinsics2 != null && layoutDirection == this.intrinsicsLayoutDirection) {
            if (layoutDirection == this.intrinsicsLayoutDirection) {
                if (paragraphIntrinsics2.getHasStaleResolvedFonts()) {
                    this.intrinsicsLayoutDirection = layoutDirection;
                    density = this.density;
                    Intrinsics.checkNotNull(density);
                    paragraphIntrinsics = ParagraphIntrinsicsKt.ParagraphIntrinsics$default(this.text, TextStyleKt.resolveDefaults(this.style, layoutDirection), 0, 0, density, this.fontFamilyResolver, 12, 0);
                } else {
                    paragraphIntrinsics = paragraphIntrinsics2;
                }
            } else {
            }
        } else {
        }
        this.paragraphIntrinsics = paragraphIntrinsics;
        return paragraphIntrinsics;
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final boolean getDidOverflow$foundation_release() {
        return this.didOverflow;
    }

    public final long getLayoutSize-YbymL2g$foundation_release() {
        return this.layoutSize;
    }

    public final Unit getObserveFontChanges$foundation_release() {
        ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics != null) {
            paragraphIntrinsics.getHasStaleResolvedFonts();
        }
        return Unit.INSTANCE;
    }

    public final Paragraph getParagraph$foundation_release() {
        return this.paragraph;
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
        int i;
        int i2;
        long coerceMinLines-Oh53vG4$foundation_release;
        androidx.compose.foundation.text.modifiers.MinLinesConstrainer mMinLinesConstrainer;
        LayoutDirection layoutDirection2;
        TextStyle style;
        long prevConstraints;
        Density constrain-4WqzIAM;
        FontFamily.Resolver fontFamilyResolver;
        int cmp;
        int cmp2;
        float height;
        float height2;
        androidx.compose.foundation.text.modifiers.MinLinesConstrainer obj14;
        i2 = 1;
        if (this.minLines > i2) {
            constrain-4WqzIAM = this.density;
            Intrinsics.checkNotNull(constrain-4WqzIAM);
            obj14 = MinLinesConstrainer.Companion.from(this.mMinLinesConstrainer, obj14, this.style, constrain-4WqzIAM, this.fontFamilyResolver);
            int i3 = 0;
            this.mMinLinesConstrainer = obj14;
            coerceMinLines-Oh53vG4$foundation_release = obj14.coerceMinLines-Oh53vG4$foundation_release(constraints, layoutDirection);
        } else {
            layoutDirection2 = obj14;
            coerceMinLines-Oh53vG4$foundation_release = constraints;
        }
        i = 0;
        if (!newLayoutWillBeDifferent-K40F9xA(coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer) && !Constraints.equals-impl0(coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer)) {
            if (!Constraints.equals-impl0(coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer)) {
                obj14 = this.paragraph;
                Intrinsics.checkNotNull(obj14);
                fontFamilyResolver = TextDelegateKt.ceilToIntPx(obj14.getHeight());
                constrain-4WqzIAM = ConstraintsKt.constrain-4WqzIAM(coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer);
                this.layoutSize = constrain-4WqzIAM;
                if (!TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getVisible-gIe3tQ8())) {
                    if (Float.compare(f, height) >= 0) {
                        if (Float.compare(f2, height) < 0) {
                        } else {
                            i2 = i;
                        }
                    } else {
                    }
                } else {
                }
                this.didOverflow = i2;
                this.prevConstraints = coerceMinLines-Oh53vG4$foundation_release;
            }
            return i;
        }
        obj14 = layoutText-K40F9xA(coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer);
        Paragraph paragraph = obj14;
        int i4 = 0;
        this.prevConstraints = coerceMinLines-Oh53vG4$foundation_release;
        int ceilToIntPx3 = TextDelegateKt.ceilToIntPx(paragraph.getHeight());
        long constrain-4WqzIAM2 = ConstraintsKt.constrain-4WqzIAM(coerceMinLines-Oh53vG4$foundation_release, mMinLinesConstrainer);
        this.layoutSize = constrain-4WqzIAM2;
        if (!TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getVisible-gIe3tQ8())) {
            if (Float.compare(f3, height2) >= 0) {
                if (Float.compare(f4, height2) < 0) {
                    i = i2;
                } else {
                }
            } else {
            }
        } else {
        }
        this.didOverflow = i;
        this.paragraph = obj14;
        return i2;
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

    public final void setDidOverflow$foundation_release(boolean <set-?>) {
        this.didOverflow = <set-?>;
    }

    public final void setLayoutSize-ozmzZPI$foundation_release(long <set-?>) {
        this.layoutSize = <set-?>;
    }

    public final void setParagraph$foundation_release(Paragraph <set-?>) {
        this.paragraph = <set-?>;
    }

    public final TextLayoutResult slowCreateTextLayoutResultOrNull(TextStyle style) {
        final Object obj = this;
        LayoutDirection intrinsicsLayoutDirection = obj.intrinsicsLayoutDirection;
        int i = 0;
        if (intrinsicsLayoutDirection == null) {
            return i;
        }
        Density density3 = obj.density;
        if (density3 == null) {
            return i;
        }
        String text = obj.text;
        super(text, 0, 0, 6, 0);
        if (obj.paragraph == null) {
            return i;
        }
        if (obj.paragraphIntrinsics == null) {
            return i;
        }
        int i3 = 0;
        int i8 = 0;
        final long copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(obj.prevConstraints, text, i3, 0, i8, 0, 10);
        Density density4 = density;
        TextStyle textStyle = style;
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString, textStyle, CollectionsKt.emptyList(), obj.maxLines, obj.softWrap, obj.overflow, density4, intrinsicsLayoutDirection, obj.fontFamilyResolver, copy-Zbe2FdA$default, i3, 0);
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, textStyle, CollectionsKt.emptyList(), density4, obj.fontFamilyResolver);
        super(multiParagraphIntrinsics, copy-Zbe2FdA$default, obj23, obj.maxLines, TextOverflow.equals-impl0(obj.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8()), 0);
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        super(textLayoutInput, multiParagraph, obj.layoutSize, i8, 0);
        return textLayoutResult2;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        str = this.paragraph != null ? "<paragraph>" : "null";
        return stringBuilder.append("ParagraphLayoutCache(paragraph=").append(str).append(", lastDensity=").append(InlineDensity.toString-impl(this.lastDensity)).append(')').toString();
    }

    public final void update-L6sJoHM(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines) {
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        markDirty();
    }
}
