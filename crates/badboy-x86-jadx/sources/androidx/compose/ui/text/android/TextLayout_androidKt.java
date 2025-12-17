package androidx.compose.ui.text.android;

import android.graphics.Paint.FontMetricsInt;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0007H\u0000\u001a3\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u0003*\u0008\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014*\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u00020\u0003*\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006!", d2 = {"SharedTextAndroidCanvas", "Landroidx/compose/ui/text/android/TextAndroidCanvas;", "ZeroVerticalPadding", "Landroidx/compose/ui/text/android/VerticalPaddings;", "J", "VerticalPaddings", "topPadding", "", "bottomPadding", "(II)J", "getTextDirectionHeuristic", "Landroid/text/TextDirectionHeuristic;", "textDirectionHeuristic", "getLastLineMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "Landroidx/compose/ui/text/android/TextLayout;", "textPaint", "Landroid/text/TextPaint;", "frameworkTextDir", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "(Landroidx/compose/ui/text/android/TextLayout;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)Landroid/graphics/Paint$FontMetricsInt;", "getLineHeightPaddings", "([Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)J", "getLineHeightSpans", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "getVerticalPaddings", "(Landroidx/compose/ui/text/android/TextLayout;)J", "isLineEllipsized", "", "Landroid/text/Layout;", "lineIndex", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextLayout_androidKt {

    private static final androidx.compose.ui.text.android.TextAndroidCanvas SharedTextAndroidCanvas;
    private static final long ZeroVerticalPadding;
    static {
        TextAndroidCanvas textAndroidCanvas = new TextAndroidCanvas();
        TextLayout_androidKt.SharedTextAndroidCanvas = textAndroidCanvas;
        int i = 0;
        TextLayout_androidKt.ZeroVerticalPadding = TextLayout_androidKt.VerticalPaddings(i, i);
    }

    public static final long VerticalPaddings(int topPadding, int bottomPadding) {
        int i = 0;
        l <<= i3;
        return VerticalPaddings.constructor-impl(i2 | i4);
    }

    public static final Paint.FontMetricsInt access$getLastLineMetrics(androidx.compose.ui.text.android.TextLayout $receiver, TextPaint textPaint, TextDirectionHeuristic frameworkTextDir, LineHeightStyleSpan[] lineHeightSpans) {
        return TextLayout_androidKt.getLastLineMetrics($receiver, textPaint, frameworkTextDir, lineHeightSpans);
    }

    public static final long access$getLineHeightPaddings(LineHeightStyleSpan[] $receiver) {
        return TextLayout_androidKt.getLineHeightPaddings($receiver);
    }

    public static final LineHeightStyleSpan[] access$getLineHeightSpans(androidx.compose.ui.text.android.TextLayout $receiver) {
        return TextLayout_androidKt.getLineHeightSpans($receiver);
    }

    public static final androidx.compose.ui.text.android.TextAndroidCanvas access$getSharedTextAndroidCanvas$p() {
        return TextLayout_androidKt.SharedTextAndroidCanvas;
    }

    public static final long access$getVerticalPaddings(androidx.compose.ui.text.android.TextLayout $receiver) {
        return TextLayout_androidKt.getVerticalPaddings($receiver);
    }

    public static final long access$getZeroVerticalPadding$p() {
        return TextLayout_androidKt.ZeroVerticalPadding;
    }

    private static final Paint.FontMetricsInt getLastLineMetrics(androidx.compose.ui.text.android.TextLayout $this$getLastLineMetrics, TextPaint textPaint, TextDirectionHeuristic frameworkTextDir, LineHeightStyleSpan[] lineHeightSpans) {
        int i;
        int lineStart;
        int lineEnd;
        boolean trimLastLineBottom;
        boolean trimLastLineBottom2;
        final Object[] objArr = lineHeightSpans;
        i = 1;
        lineCount -= i;
        lineStart = 0;
        if ($this$getLastLineMetrics.getLayout().getLineStart(i2) == $this$getLastLineMetrics.getLayout().getLineEnd(i2) && objArr != null) {
            lineStart = 0;
            if (objArr != null) {
                lineEnd = objArr.length == 0 ? i : lineStart;
                if (lineEnd != 0) {
                } else {
                    i = lineStart;
                }
            }
            if (i == 0) {
                SpannableString spannableString = new SpannableString((CharSequence)"​");
                Object first = ArraysKt.first(objArr);
                if (i2 != 0 && (LineHeightStyleSpan)first.getTrimLastLineBottom()) {
                    if (first.getTrimLastLineBottom()) {
                        trimLastLineBottom2 = lineStart;
                    } else {
                        trimLastLineBottom2 = first.getTrimLastLineBottom();
                    }
                } else {
                }
                spannableString.setSpan(first.copy$ui_text_release(lineStart, spannableString.length(), trimLastLineBottom2), lineStart, spannableString.length(), 33);
                StaticLayout create$default = StaticLayoutFactory.create$default(StaticLayoutFactory.INSTANCE, (CharSequence)spannableString, textPaint, Integer.MAX_VALUE, 0, spannableString.length(), frameworkTextDir, 0, 0, 0, 0, 0, 0, 0, $this$getLastLineMetrics.getIncludePadding(), $this$getLastLineMetrics.getFallbackLineSpacing(), 0, 0, 0, 0, 0, 0, 2072512, 0);
                Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
                Paint.FontMetricsInt fontMetricsInt2 = fontMetricsInt;
                int i4 = 0;
                fontMetricsInt2.ascent = create$default.getLineAscent(lineStart);
                fontMetricsInt2.descent = create$default.getLineDescent(lineStart);
                fontMetricsInt2.top = create$default.getLineTop(lineStart);
                fontMetricsInt2.bottom = create$default.getLineBottom(lineStart);
                return fontMetricsInt;
            }
        }
        return null;
    }

    private static final long getLineHeightPaddings(LineHeightStyleSpan[] $this$getLineHeightPaddings) {
        int firstAscentDiff2;
        int lastDescentDiff;
        long zeroVerticalPadding;
        int i;
        Object obj;
        int lastDescentDiff2;
        int firstAscentDiff;
        firstAscentDiff2 = 0;
        lastDescentDiff = 0;
        i = 0;
        while (i < $this$getLineHeightPaddings.length) {
            obj = $this$getLineHeightPaddings[i];
            if (obj.getFirstAscentDiff() < 0) {
            }
            if (obj.getLastDescentDiff() < 0) {
            }
            i++;
            lastDescentDiff = Math.max(firstAscentDiff2, Math.abs(obj.getLastDescentDiff()));
            firstAscentDiff2 = Math.max(firstAscentDiff2, Math.abs(obj.getFirstAscentDiff()));
        }
        if (firstAscentDiff2 == 0 && lastDescentDiff == 0) {
            if (lastDescentDiff == 0) {
                zeroVerticalPadding = TextLayout_androidKt.ZeroVerticalPadding;
            } else {
                zeroVerticalPadding = TextLayout_androidKt.VerticalPaddings(firstAscentDiff2, lastDescentDiff);
            }
        } else {
        }
        return zeroVerticalPadding;
    }

    private static final LineHeightStyleSpan[] getLineHeightSpans(androidx.compose.ui.text.android.TextLayout $this$getLineHeightSpans) {
        int span;
        int i = 0;
        if (!text instanceof Spanned) {
            return i;
        }
        java.lang.CharSequence text2 = $this$getLineHeightSpans.getText();
        String str = "null cannot be cast to non-null type android.text.Spanned";
        Intrinsics.checkNotNull(text2, str);
        int i2 = 0;
        if (!SpannedExtensions_androidKt.hasSpan((Spanned)text2, LineHeightStyleSpan.class)) {
            span = $this$getLineHeightSpans.getText().length() > 0 ? 1 : i2;
            if (span != 0) {
                return i;
            }
        }
        java.lang.CharSequence text4 = $this$getLineHeightSpans.getText();
        Intrinsics.checkNotNull(text4, str);
        return (LineHeightStyleSpan[])(Spanned)text4.getSpans(i2, $this$getLineHeightSpans.getText().length(), LineHeightStyleSpan.class);
    }

    public static final TextDirectionHeuristic getTextDirectionHeuristic(int textDirectionHeuristic) {
        TextDirectionHeuristic fIRSTSTRONG_LTR;
        switch (textDirectionHeuristic) {
            case 0:
                fIRSTSTRONG_LTR = TextDirectionHeuristics.LTR;
                break;
            case 1:
                fIRSTSTRONG_LTR = TextDirectionHeuristics.RTL;
                break;
            case 2:
                fIRSTSTRONG_LTR = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                break;
            case 3:
                fIRSTSTRONG_LTR = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                break;
            case 4:
                fIRSTSTRONG_LTR = TextDirectionHeuristics.ANYRTL_LTR;
                break;
            case 5:
                fIRSTSTRONG_LTR = TextDirectionHeuristics.LOCALE;
                break;
            default:
                fIRSTSTRONG_LTR = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        return fIRSTSTRONG_LTR;
    }

    private static final long getVerticalPaddings(androidx.compose.ui.text.android.TextLayout $this$getVerticalPaddings) {
        boolean fallbackLinespacingApplied$ui_text_release;
        int topPadding;
        int lineCount;
        int bottomPadding;
        android.graphics.Rect charSequenceBounds;
        int lineEnd;
        long zeroVerticalPadding;
        if (!$this$getVerticalPaddings.getIncludePadding()) {
            if ($this$getVerticalPaddings.isFallbackLinespacingApplied$ui_text_release()) {
            } else {
                TextPaint paint2 = $this$getVerticalPaddings.getLayout().getPaint();
                java.lang.CharSequence text = $this$getVerticalPaddings.getLayout().getText();
                int i = 0;
                android.graphics.Rect charSequenceBounds2 = PaintExtensions_androidKt.getCharSequenceBounds(paint2, text, $this$getVerticalPaddings.getLayout().getLineStart(i), $this$getVerticalPaddings.getLayout().getLineEnd(i));
                int lineAscent = $this$getVerticalPaddings.getLayout().getLineAscent(i);
                if (charSequenceBounds2.top < lineAscent) {
                    topPadding = lineAscent - top2;
                } else {
                    topPadding = $this$getVerticalPaddings.getLayout().getTopPadding();
                }
                int i2 = 1;
                if ($this$getVerticalPaddings.getLineCount() == i2) {
                    charSequenceBounds = charSequenceBounds2;
                } else {
                    lineCount2 -= i2;
                    charSequenceBounds = PaintExtensions_androidKt.getCharSequenceBounds(paint2, text, $this$getVerticalPaddings.getLayout().getLineStart(lineCount), $this$getVerticalPaddings.getLayout().getLineEnd(lineCount));
                }
                int lineDescent = $this$getVerticalPaddings.getLayout().getLineDescent(lineCount3 -= i2);
                if (charSequenceBounds.bottom > lineDescent) {
                    bottom2 -= lineDescent;
                } else {
                    bottomPadding = $this$getVerticalPaddings.getLayout().getBottomPadding();
                }
                if (topPadding == 0 && bottomPadding == 0) {
                    if (bottomPadding == 0) {
                        zeroVerticalPadding = TextLayout_androidKt.ZeroVerticalPadding;
                    } else {
                        zeroVerticalPadding = TextLayout_androidKt.VerticalPaddings(topPadding, bottomPadding);
                    }
                } else {
                }
            }
            return zeroVerticalPadding;
        }
        return TextLayout_androidKt.ZeroVerticalPadding;
    }

    public static final boolean isLineEllipsized(Layout $this$isLineEllipsized, int lineIndex) {
        int i;
        i = $this$isLineEllipsized.getEllipsisCount(lineIndex) > 0 ? 1 : 0;
        return i;
    }
}
