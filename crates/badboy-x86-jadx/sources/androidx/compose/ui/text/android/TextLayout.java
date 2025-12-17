package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Trace;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.IndentationFixSpan_androidKt;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005\u0012\u0008\u0008\u0003\u0010\u000e\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\t\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ&\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\tJ\u001d\u0010]\u001a\u00020W2\u0006\u0010^\u001a\u00020\t2\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\u0008_J\u000e\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\tJ\u0010\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tH\u0002J\u000e\u0010e\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010f\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010g\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010h\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010i\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010j\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010k\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010l\u001a\u00020\t2\u0006\u0010b\u001a\u00020\tJ\u000e\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\tJ\u000e\u0010o\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010p\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010q\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u000e\u0010r\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010s\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\tJ\u000e\u0010t\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010u\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\tJ\u0016\u0010v\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010w\u001a\u00020\u0005J\u000e\u0010x\u001a\u00020\t2\u0006\u0010d\u001a\u00020\tJ\u0018\u0010y\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\t2\u0008\u0008\u0002\u0010z\u001a\u00020\u0010J2\u0010{\u001a\u0004\u0018\u00010\u00192\u0006\u0010H\u001a\u00020a2\u0006\u0010|\u001a\u00020\t2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\u00100~J\u0018\u0010\u007f\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\t2\u0008\u0008\u0002\u0010z\u001a\u00020\u0010J#\u0010\u0080\u0001\u001a\u00020W2\u0007\u0010\u0081\u0001\u001a\u00020\t2\u0007\u0010\u0082\u0001\u001a\u00020\t2\u0008\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\u0008\u0086\u0001J\u000f\u0010\u0087\u0001\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\tJ\u000f\u0010\u0088\u0001\u001a\u00020\u00102\u0006\u0010b\u001a\u00020\tJ\u0011\u0010\u0089\u0001\u001a\u00020W2\u0008\u0010\u008a\u0001\u001a\u00030\u008b\u0001R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008#\u0010$\u001a\u0004\u0008%\u0010&R\u0011\u0010'\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010)R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008,\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010)R\u000e\u0010.\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0002038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00084\u0010$\u001a\u0004\u00085\u00106R\u0014\u00107\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00088\u00109R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u000e\u0010<\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010=\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010&R\u0018\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u0011\u0010C\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008D\u0010ER\u0011\u0010F\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008G\u0010ER\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008L\u0010MR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010OR\u001c\u0010P\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008Q\u0010$\u001a\u0004\u0008R\u0010&R\u0011\u0010S\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\u0008T\u0010U¨\u0006\u008c\u0001", d2 = {"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "fallbackLineSpacing", "maxLines", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "backingLayoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "backingWordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "bottomPadding", "getBottomPadding$ui_text_release$annotations", "()V", "getBottomPadding$ui_text_release", "()I", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getFallbackLineSpacing", "height", "getHeight", "getIncludePadding", "isBoringLayout", "lastLineExtra", "lastLineFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "layout", "Landroid/text/Layout;", "getLayout$annotations", "getLayout", "()Landroid/text/Layout;", "layoutHelper", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "leftPadding", "lineCount", "getLineCount", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "rect", "Landroid/graphics/Rect;", "rightPadding", "text", "getText", "()Ljava/lang/CharSequence;", "getTextPaint", "()Landroid/text/TextPaint;", "topPadding", "getTopPadding$ui_text_release$annotations", "getTopPadding$ui_text_release", "wordIterator", "getWordIterator", "()Landroidx/compose/ui/text/android/selection/WordIterator;", "fillBoundingBoxes", "", "startOffset", "endOffset", "array", "", "arrayStart", "fillLineHorizontalBounds", "lineIndex", "fillLineHorizontalBounds$ui_text_release", "getBoundingBox", "Landroid/graphics/RectF;", "offset", "getHorizontalPadding", "line", "getLineAscent", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineEllipsisCount", "getLineEllipsisOffset", "getLineEnd", "getLineForOffset", "getLineForVertical", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineVisibleEnd", "getLineWidth", "getOffsetForHorizontal", "horizontal", "getParagraphDirection", "getPrimaryHorizontal", "upstream", "getRangeForRect", "granularity", "inclusionStrategy", "Lkotlin/Function2;", "getSecondaryHorizontal", "getSelectionPath", "start", "end", "dest", "Landroid/graphics/Path;", "isFallbackLinespacingApplied", "isFallbackLinespacingApplied$ui_text_release", "isLineEllipsized", "isRtlCharAt", "paint", "canvas", "Landroid/graphics/Canvas;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextLayout {

    public static final int $stable = 8;
    private androidx.compose.ui.text.android.LayoutHelper backingLayoutHelper;
    private WordIterator backingWordIterator;
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;
    private final Paint.FontMetricsInt lastLineFontMetrics;
    private final Layout layout;
    private final androidx.compose.ui.text.android.LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;
    private final LineHeightStyleSpan[] lineHeightSpans;
    private final Rect rect;
    private final float rightPadding;
    private final TextPaint textPaint;
    private final int topPadding;
    static {
        final int i = 8;
    }

    public TextLayout(java.lang.CharSequence charSequence, float width, TextPaint textPaint, int alignment, TextUtils.TruncateAt ellipsize, int textDirectionHeuristic, float lineSpacingMultiplier, float lineSpacingExtra, boolean includePadding, boolean fallbackLineSpacing, int maxLines, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle, int hyphenationFrequency, int justificationMode, int[] leftIndents, int[] rightIndents, androidx.compose.ui.text.android.LayoutIntrinsics layoutIntrinsics) {
        int i11;
        int boringMetrics;
        Object create;
        Object obj;
        int ellipsisCount;
        TextPaint end;
        int i9;
        long l;
        int i10;
        int i8;
        int i12;
        android.text.Layout.Alignment alignment2;
        Object obj6;
        android.text.TextDirectionHeuristic textDirectionHeuristic2;
        int i2;
        android.text.Layout.Alignment widthInt;
        Class<androidx.compose.ui.text.android.style.BaselineShiftSpan> cmp;
        Class<androidx.compose.ui.text.android.style.BaselineShiftSpan> obj2;
        TextUtils.TruncateAt truncateAt;
        int lineHeightSpans;
        int f;
        float textPaint2;
        float z;
        int z2;
        boolean frameworkTextDir;
        boolean z3;
        int i5;
        int i3;
        int i4;
        int i;
        int[] iArr2;
        int[] iArr;
        int i6;
        Class<androidx.compose.ui.text.android.style.BaselineShiftSpan> obj3;
        int i7;
        android.text.BoringLayout.Metrics metrics;
        final Object obj5 = this;
        obj = charSequence;
        f = width;
        super();
        obj5.textPaint = textPaint;
        obj5.includePadding = includePadding;
        obj5.fallbackLineSpacing = fallbackLineSpacing;
        obj5.layoutIntrinsics = layoutIntrinsics;
        Rect rect = new Rect();
        obj5.rect = rect;
        int length = obj.length();
        frameworkTextDir = TextLayout_androidKt.getTextDirectionHeuristic(textDirectionHeuristic);
        alignment2 = TextAlignmentAdapter.INSTANCE.get(alignment);
        int i17 = 1;
        int i18 = 0;
        if (obj instanceof Spanned) {
            i11 = (Spanned)obj.nextSpanTransition(-1, length, BaselineShiftSpan.class) < length ? i17 : i18;
        } else {
            i11 = i18;
        }
        Trace.beginSection("TextLayout:initLayout");
        android.text.BoringLayout.Metrics boringMetrics2 = obj5.layoutIntrinsics.getBoringMetrics();
        int i19 = (int)f3;
        if (boringMetrics2 != null && Float.compare(maxIntrinsicWidth, f) <= 0) {
            if (Float.compare(maxIntrinsicWidth, f) <= 0) {
                if (i11 == 0) {
                    obj5.isBoringLayout = i17;
                    i9 = i19;
                    i6 = i17;
                    i7 = i22;
                    i10 = boringMetrics2;
                    boringMetrics = z3;
                    create = BoringLayoutFactory.INSTANCE.create(obj, obj5.textPaint, i9, i10, alignment2, obj5.includePadding, obj5.fallbackLineSpacing, ellipsize, i9);
                    metrics = i10;
                    obj2 = maxLines;
                    textDirectionHeuristic2 = frameworkTextDir;
                } else {
                    metrics = boringMetrics2;
                    i7 = length;
                    i6 = i17;
                    boringMetrics = i18;
                    i9 = i19;
                    obj5.isBoringLayout = boringMetrics;
                    widthInt = alignment2;
                    create = StaticLayoutFactory.INSTANCE.create(charSequence, obj5.textPaint, i9, 0, charSequence.length(), frameworkTextDir, widthInt, maxLines, ellipsize, (int)f2, lineSpacingMultiplier, lineSpacingExtra, justificationMode, obj5.includePadding, obj5.fallbackLineSpacing, breakStrategy, lineBreakStyle, lineBreakWordStyle, hyphenationFrequency, leftIndents, rightIndents);
                    alignment2 = widthInt;
                }
            } else {
                metrics = boringMetrics2;
                i7 = length;
                i6 = i17;
                boringMetrics = i18;
                i9 = i19;
            }
        } else {
        }
        obj5.layout = create;
        Trace.endSection();
        obj5.lineCount = Math.min(obj5.layout.getLineCount(), obj2);
        lineCount2--;
        if (obj5.lineCount < obj2) {
            i8 = boringMetrics;
        } else {
            if (obj5.layout.getEllipsisCount(i14) <= 0) {
                if (obj5.layout.getLineEnd(i14) != charSequence.length()) {
                    i8 = i6;
                } else {
                    i8 = boringMetrics;
                }
            } else {
            }
        }
        obj5.didExceedMaxLines = i8;
        long l2 = TextLayout_androidKt.access$getVerticalPaddings(obj5);
        obj5.lineHeightSpans = TextLayout_androidKt.access$getLineHeightSpans(obj5);
        LineHeightStyleSpan[] lineHeightSpans2 = obj5.lineHeightSpans;
        if (lineHeightSpans2 != null) {
            l = TextLayout_androidKt.access$getLineHeightPaddings(lineHeightSpans2);
        } else {
            l = TextLayout_androidKt.access$getZeroVerticalPadding$p();
        }
        obj5.topPadding = Math.max(VerticalPaddings.getTopPadding-impl(l2), VerticalPaddings.getTopPadding-impl(l));
        obj5.bottomPadding = Math.max(VerticalPaddings.getBottomPadding-impl(l2), VerticalPaddings.getBottomPadding-impl(l));
        Paint.FontMetricsInt fontMetricsInt = TextLayout_androidKt.access$getLastLineMetrics(obj5, obj5.textPaint, textDirectionHeuristic2, obj5.lineHeightSpans);
        if (fontMetricsInt != null) {
            bottom -= lineHeightSpans;
        } else {
        }
        obj5.lastLineExtra = boringMetrics;
        obj5.lastLineFontMetrics = fontMetricsInt;
        int i24 = 0;
        int i25 = 2;
        obj5.leftPadding = IndentationFixSpan_androidKt.getEllipsizedLeftPadding$default(obj5.layout, i14, i24, i25, i24);
        obj5.rightPadding = IndentationFixSpan_androidKt.getEllipsizedRightPadding$default(obj5.layout, i14, i24, i25, i24);
    }

    public TextLayout(java.lang.CharSequence charSequence, float f2, TextPaint textPaint3, int i4, TextUtils.TruncateAt textUtils$TruncateAt5, int i6, float f7, float f8, boolean z9, boolean z10, int i11, int i12, int i13, int i14, int i15, int i16, int[] i17Arr17, int[] i18Arr18, androidx.compose.ui.text.android.LayoutIntrinsics layoutIntrinsics19, int i20, DefaultConstructorMarker defaultConstructorMarker21) {
        int layoutIntrinsics;
        int i24;
        int i10;
        int i9;
        int i28;
        int i25;
        java.lang.CharSequence charSequence2;
        TextPaint textPaint;
        int i17;
        int i26;
        int i19;
        int i18;
        int i22;
        int i2;
        int i27;
        int i;
        int i3;
        int i21;
        int i7;
        int i5;
        int i29;
        int i8;
        int i23;
        androidx.compose.ui.text.android.LayoutIntrinsics layoutIntrinsics2;
        int i30 = i20;
        final int i45 = 0;
        i17 = i30 & 8 != 0 ? i45 : i4;
        int i46 = 0;
        i26 = i30 & 16 != 0 ? i46 : truncateAt5;
        i19 = i30 & 32 != 0 ? i24 : i6;
        i18 = i30 & 64 != 0 ? i10 : f7;
        i22 = i30 & 128 != 0 ? i9 : f8;
        i2 = i30 & 256 != 0 ? i45 : z9;
        i27 = i30 & 512 != 0 ? i28 : z10;
        i = i30 & 1024 != 0 ? i25 : i11;
        i3 = i30 & 2048 != 0 ? i45 : i12;
        i21 = i30 & 4096 != 0 ? i45 : i13;
        i7 = i30 & 8192 != 0 ? i45 : i14;
        i5 = i30 & 16384 != 0 ? i45 : i15;
        i29 = i38 &= i30 != 0 ? i45 : i16;
        i8 = i40 &= i30 != 0 ? i46 : i17Arr17;
        i23 = i42 &= i30 != 0 ? i46 : i18Arr18;
        if (i30 &= i44 != 0) {
            layoutIntrinsics = new LayoutIntrinsics(charSequence, textPaint3, i19);
            layoutIntrinsics2 = layoutIntrinsics;
        } else {
            charSequence2 = charSequence;
            textPaint = textPaint3;
            layoutIntrinsics2 = layoutIntrinsics19;
        }
        super(charSequence2, f2, textPaint, i17, i26, i19, i18, i22, i2, i27, i, i3, i21, i7, i5, i29, i8, i23, layoutIntrinsics2);
    }

    public static void getBottomPadding$ui_text_release$annotations() {
    }

    private final float getHorizontalPadding(int line) {
        int i;
        float rightPadding;
        if (line == lineCount--) {
            leftPadding += rightPadding;
        } else {
            i = 0;
        }
        return i;
    }

    public static void getLayout$annotations() {
    }

    private final androidx.compose.ui.text.android.LayoutHelper getLayoutHelper() {
        if (this.backingLayoutHelper == null) {
            LayoutHelper layoutHelper = new LayoutHelper(this.layout);
            final int i = 0;
            this.backingLayoutHelper = layoutHelper;
            return layoutHelper;
        }
        androidx.compose.ui.text.android.LayoutHelper backingLayoutHelper2 = this.backingLayoutHelper;
        Intrinsics.checkNotNull(backingLayoutHelper2);
        return backingLayoutHelper2;
    }

    public static float getPrimaryHorizontal$default(androidx.compose.ui.text.android.TextLayout textLayout, int i2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return textLayout.getPrimaryHorizontal(i2, obj2);
    }

    public static float getSecondaryHorizontal$default(androidx.compose.ui.text.android.TextLayout textLayout, int i2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return textLayout.getSecondaryHorizontal(i2, obj2);
    }

    public static void getTopPadding$ui_text_release$annotations() {
    }

    public final void fillBoundingBoxes(int startOffset, int endOffset, float[] array, int arrayStart) {
        androidx.compose.ui.text.android.TextLayout textLayout;
        float secondaryUpstream;
        int i7;
        int i4;
        int offset;
        int i10;
        int i11;
        int i6;
        int i9;
        int i;
        int arrayOffset;
        int line;
        int lineStart;
        int lineEnd;
        int i3;
        float lineTop;
        float lineBottom;
        int i2;
        int i5;
        boolean rtlCharAt;
        float left;
        int i8;
        int right;
        textLayout = this;
        i7 = startOffset;
        final int i19 = endOffset;
        final float[] fArr = array;
        int length = textLayout.getText().length();
        offset = 1;
        i10 = i7 >= 0 ? offset : 0;
        if (i10 == 0) {
        } else {
            i11 = i7 < length ? offset : 0;
            if (i11 == 0) {
            } else {
                i6 = i19 > i7 ? offset : 0;
                if (i6 == 0) {
                } else {
                    i9 = i19 <= length ? offset : 0;
                    if (i9 == 0) {
                    } else {
                        i = length2 -= arrayStart >= i20 * 4 ? offset : 0;
                        if (i == 0) {
                        } else {
                            int lineForOffset2 = textLayout.getLineForOffset(i19 + -1);
                            HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(textLayout);
                            arrayOffset = arrayStart;
                            if (getLineForOffset(startOffset) <= lineForOffset2) {
                            }
                        }
                        int i15 = 0;
                        IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4".toString());
                        throw illegalArgumentException4;
                    }
                    int i14 = 0;
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("endOffset must be smaller or equal to text length".toString());
                    throw illegalArgumentException3;
                }
                int i18 = 0;
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("endOffset must be greater than startOffset".toString());
                throw illegalArgumentException5;
            }
            int i13 = 0;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("startOffset must be less than text length".toString());
            throw illegalArgumentException2;
        }
        int i12 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("startOffset must be > 0".toString());
        throw illegalArgumentException;
    }

    public final void fillLineHorizontalBounds$ui_text_release(int lineIndex, float[] array) {
        int i4;
        int i;
        int arrayOffset;
        int offset;
        boolean rtlCharAt;
        float left;
        float right;
        int i3;
        int i2;
        final int lineStart = getLineStart(lineIndex);
        final int lineEnd = getLineEnd(lineIndex);
        int i7 = 1;
        i4 = array.length >= i5 * 2 ? i7 : i;
        if (i4 == 0) {
        } else {
            HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
            if (getParagraphDirection(lineIndex) == i7) {
                i = i7;
            }
            arrayOffset = 0;
            offset = lineStart;
            while (offset < lineEnd) {
                rtlCharAt = isRtlCharAt(offset);
                int i8 = 0;
                int i9 = 0;
                if (i != 0 && !rtlCharAt) {
                } else {
                }
                if (i != 0 && rtlCharAt) {
                } else {
                }
                if (rtlCharAt) {
                } else {
                }
                left = horizontalPositionCache.getSecondaryDownstream(offset);
                right = horizontalPositionCache.getSecondaryUpstream(offset + 1);
                array[arrayOffset] = left;
                array[arrayOffset + 1] = right;
                arrayOffset += 2;
                offset++;
                right = horizontalPositionCache.getPrimaryDownstream(offset);
                left = horizontalPositionCache.getPrimaryUpstream(offset + 1);
                if (rtlCharAt) {
                } else {
                }
                right = horizontalPositionCache.getSecondaryDownstream(offset);
                left = horizontalPositionCache.getSecondaryUpstream(offset + 1);
                if (!rtlCharAt) {
                } else {
                }
                left = horizontalPositionCache.getPrimaryDownstream(offset);
                right = horizontalPositionCache.getPrimaryUpstream(offset + 1);
            }
        }
        int cache = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2".toString());
        throw illegalArgumentException;
    }

    public final int getBottomPadding$ui_text_release() {
        return this.bottomPadding;
    }

    public final RectF getBoundingBox(int offset) {
        int i;
        float right;
        float secondaryHorizontal;
        int left;
        int right2;
        float f;
        final int lineForOffset = getLineForOffset(offset);
        int i2 = 0;
        int i3 = 1;
        i = getParagraphDirection(lineForOffset) == i3 ? i3 : i2;
        boolean rtlCharAt = this.layout.isRtlCharAt(offset);
        left = 0;
        right2 = 0;
        if (i != 0 && !rtlCharAt) {
            if (!rtlCharAt) {
                right = getPrimaryHorizontal(offset, i2);
                secondaryHorizontal = getPrimaryHorizontal(offset + 1, i3);
            } else {
                if (i != 0 && rtlCharAt) {
                    if (rtlCharAt) {
                        secondaryHorizontal = secondaryHorizontal2;
                        right = f;
                    } else {
                        if (rtlCharAt) {
                            secondaryHorizontal = primaryHorizontal;
                            right = f;
                        } else {
                            right = getSecondaryHorizontal(offset, i2);
                            secondaryHorizontal = getSecondaryHorizontal(offset + 1, i3);
                        }
                    }
                } else {
                }
            }
        } else {
        }
        RectF rectF = new RectF(right, getLineTop(lineForOffset), secondaryHorizontal, getLineBottom(lineForOffset));
        return rectF;
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final int getHeight() {
        int lineBottom;
        int i;
        if (this.didExceedMaxLines) {
            lineBottom = this.layout.getLineBottom(lineCount--);
        } else {
            lineBottom = this.layout.getHeight();
        }
        return i3 += lastLineExtra;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final androidx.compose.ui.text.android.LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final float getLineAscent(int line) {
        int lastLineFontMetrics;
        float f;
        if (line == lineCount-- && this.lastLineFontMetrics != null) {
            if (this.lastLineFontMetrics != null) {
                f = (float)ascent;
            } else {
                f = (float)lineAscent;
            }
        } else {
        }
        return f;
    }

    public final float getLineBaseline(int line) {
        int lastLineFontMetrics;
        float i;
        float f;
        if (line == lineCount-- && this.lastLineFontMetrics != null) {
            if (this.lastLineFontMetrics != null) {
                lineTop -= f;
            } else {
                i = (float)lineBaseline;
            }
        } else {
        }
        return f2 += i;
    }

    public final float getLineBottom(int line) {
        int lastLineFontMetrics;
        int bottomPadding;
        if (line == lineCount-- && this.lastLineFontMetrics != null) {
            if (this.lastLineFontMetrics != null) {
                return f2 += f5;
            }
        }
        bottomPadding = line == lineCount2-- ? this.bottomPadding : 0;
        return i += f4;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final float getLineDescent(int line) {
        int lastLineFontMetrics;
        float f;
        if (line == lineCount-- && this.lastLineFontMetrics != null) {
            if (this.lastLineFontMetrics != null) {
                f = (float)descent;
            } else {
                f = (float)lineDescent;
            }
        } else {
        }
        return f;
    }

    public final int getLineEllipsisCount(int lineIndex) {
        return this.layout.getEllipsisCount(lineIndex);
    }

    public final int getLineEllipsisOffset(int lineIndex) {
        return this.layout.getEllipsisStart(lineIndex);
    }

    public final int getLineEnd(int lineIndex) {
        int lineEnd;
        if (this.layout.getEllipsisStart(lineIndex) == 0) {
            lineEnd = this.layout.getLineEnd(lineIndex);
        } else {
            lineEnd = this.layout.getText().length();
        }
        return lineEnd;
    }

    public final int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    public final int getLineForVertical(int vertical) {
        return this.layout.getLineForVertical(vertical - topPadding);
    }

    public final float getLineHeight(int lineIndex) {
        return lineBottom -= lineTop;
    }

    public final float getLineLeft(int lineIndex) {
        float leftPadding;
        leftPadding = lineIndex == lineCount-- ? this.leftPadding : 0;
        return lineLeft += leftPadding;
    }

    public final float getLineRight(int lineIndex) {
        float rightPadding;
        rightPadding = lineIndex == lineCount-- ? this.rightPadding : 0;
        return lineRight += rightPadding;
    }

    public final int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    public final float getLineTop(int line) {
        int topPadding;
        topPadding = line == 0 ? 0 : this.topPadding;
        return f2 += f;
    }

    public final int getLineVisibleEnd(int lineIndex) {
        int lineVisibleEnd;
        int ellipsisStart;
        if (this.layout.getEllipsisStart(lineIndex) == 0) {
            lineVisibleEnd = getLayoutHelper().getLineVisibleEnd(lineIndex);
        } else {
            lineStart += ellipsisStart;
        }
        return lineVisibleEnd;
    }

    public final float getLineWidth(int lineIndex) {
        return this.layout.getLineWidth(lineIndex);
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final int getOffsetForHorizontal(int line, float horizontal) {
        return this.layout.getOffsetForHorizontal(line, i2 += horizontal);
    }

    public final int getParagraphDirection(int line) {
        return this.layout.getParagraphDirection(line);
    }

    public final float getPrimaryHorizontal(int offset, boolean upstream) {
        return horizontalPosition += horizontalPadding;
    }

    public final int[] getRangeForRect(RectF rect, int granularity, Function2<? super RectF, ? super RectF, Boolean> inclusionStrategy) {
        if (Build.VERSION.SDK_INT >= 34) {
            return AndroidLayoutApi34.INSTANCE.getRangeForRect$ui_text_release(this, rect, granularity, inclusionStrategy);
        }
        return TextLayoutGetRangeForRectExtensions_androidKt.getRangeForRect(this, this.layout, getLayoutHelper(), rect, granularity, inclusionStrategy);
    }

    public final float getSecondaryHorizontal(int offset, boolean upstream) {
        return horizontalPosition += horizontalPadding;
    }

    public final void getSelectionPath(int start, int end, Path dest) {
        int topPadding;
        int i;
        this.layout.getSelectionPath(start, end, dest);
        if (this.topPadding != 0 && !dest.isEmpty()) {
            if (!dest.isEmpty()) {
                dest.offset(0, (float)topPadding2);
            }
        }
    }

    public final java.lang.CharSequence getText() {
        return this.layout.getText();
    }

    public final TextPaint getTextPaint() {
        return this.textPaint;
    }

    public final int getTopPadding$ui_text_release() {
        return this.topPadding;
    }

    public final WordIterator getWordIterator() {
        final WordIterator backingWordIterator = this.backingWordIterator;
        if (backingWordIterator != null) {
            return backingWordIterator;
        }
        WordIterator wordIterator = new WordIterator(this.layout.getText(), 0, this.layout.getText().length(), this.textPaint.getTextLocale());
        int i = 0;
        this.backingWordIterator = wordIterator;
        return wordIterator;
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        boolean fallbackLineSpacingEnabled;
        Layout layout;
        String fallbackLineSpacing;
        if (this.isBoringLayout) {
            layout = this.layout;
            Intrinsics.checkNotNull(layout, "null cannot be cast to non-null type android.text.BoringLayout");
            fallbackLineSpacingEnabled = BoringLayoutFactory.INSTANCE.isFallbackLineSpacingEnabled((BoringLayout)layout);
        } else {
            layout = this.layout;
            Intrinsics.checkNotNull(layout, "null cannot be cast to non-null type android.text.StaticLayout");
            fallbackLineSpacingEnabled = StaticLayoutFactory.INSTANCE.isFallbackLineSpacingEnabled((StaticLayout)layout, this.fallbackLineSpacing);
        }
        return fallbackLineSpacingEnabled;
    }

    public final boolean isLineEllipsized(int lineIndex) {
        return TextLayout_androidKt.isLineEllipsized(this.layout, lineIndex);
    }

    public final boolean isRtlCharAt(int offset) {
        return this.layout.isRtlCharAt(offset);
    }

    public final void paint(Canvas canvas) {
        int topPadding2;
        int topPadding;
        int i;
        if (!canvas.getClipBounds(this.rect)) {
        }
        final int i3 = 0;
        if (this.topPadding != 0) {
            canvas.translate(i3, (float)topPadding3);
        }
        androidx.compose.ui.text.android.TextAndroidCanvas textAndroidCanvas = TextLayout_androidKt.access$getSharedTextAndroidCanvas$p();
        i = 0;
        textAndroidCanvas.setCanvas(canvas);
        this.layout.draw((Canvas)textAndroidCanvas);
        if (this.topPadding != 0) {
            canvas.translate(i3, f *= i);
        }
    }
}
