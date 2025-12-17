package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.selection.SegmentFinder_androidKt;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001af\u0010\u0008\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aH\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00032\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0000\u001af\u0010\u001d\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aV\u0010\u001e\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010 \u001a\u00020\u0014H\u0002\u001a\u001c\u0010!\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0002¨\u0006$", d2 = {"getCharacterLeftBounds", "", "offset", "", "lineStart", "horizontalBounds", "", "getCharacterRightBounds", "getEndOffsetForRectWithinRun", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "rect", "Landroid/graphics/RectF;", "lineTop", "lineBottom", "runLeft", "runRight", "segmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "inclusionStrategy", "Lkotlin/Function2;", "", "getRangeForRect", "", "Landroidx/compose/ui/text/android/TextLayout;", "layout", "Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "granularity", "getStartOffsetForRectWithinRun", "getStartOrEndOffsetForRectWithinLine", "lineIndex", "getStart", "horizontalOverlap", "left", "right", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutGetRangeForRectExtensions_androidKt {
    private static final float getCharacterLeftBounds(int offset, int lineStart, float[] horizontalBounds) {
        return horizontalBounds[i *= 2];
    }

    private static final float getCharacterRightBounds(int offset, int lineStart, float[] horizontalBounds) {
        return horizontalBounds[i2++];
    }

    private static final int getEndOffsetForRectWithinRun(androidx.compose.ui.text.android.LayoutHelper.BidiRun $this$getEndOffsetForRectWithinRun, RectF rect, int lineStart, int lineTop, int lineBottom, float runLeft, float runRight, float[] horizontalBounds, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> inclusionStrategy) {
        int segmentStart;
        int rtl;
        int low;
        int low2;
        int i2;
        int segmentEnd;
        int high;
        int i;
        float characterLeftBounds;
        float f;
        float characterLeftBounds2;
        float characterRightBounds;
        boolean rtl2;
        float previousStartBoundary;
        boolean booleanValue;
        int start;
        final RectF rectF = rect;
        final int i3 = lineStart;
        final float f2 = runLeft;
        final float f3 = runRight;
        final float[] fArr = horizontalBounds;
        final Object obj = segmentFinder;
        final int i5 = -1;
        if (!TextLayoutGetRangeForRectExtensions_androidKt.horizontalOverlap(rectF, f2, f3)) {
            return i5;
        }
        int i4 = 0;
        i2 = 1;
        if (!$this$getEndOffsetForRectWithinRun.isRtl()) {
            if (Float.compare(right, f3) < 0) {
                if ($this$getEndOffsetForRectWithinRun.isRtl() && Float.compare(left, f2) <= 0) {
                    if (Float.compare(left, f2) <= 0) {
                        end -= i2;
                    } else {
                        low = $this$getEndOffsetForRectWithinRun.getStart();
                        high = $this$getEndOffsetForRectWithinRun.getEnd();
                        while (high - low > i2) {
                            i6 /= 2;
                            characterLeftBounds = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(i, i3, fArr);
                            if (!$this$getEndOffsetForRectWithinRun.isRtl()) {
                            } else {
                            }
                            if ($this$getEndOffsetForRectWithinRun.isRtl() && Float.compare(characterLeftBounds, left2) < 0) {
                            } else {
                            }
                            low = i;
                            if (Float.compare(characterLeftBounds, left2) < 0) {
                            } else {
                            }
                            high = i;
                            if (Float.compare(characterLeftBounds, right2) <= 0) {
                            } else {
                            }
                        }
                        i2 = $this$getEndOffsetForRectWithinRun.isRtl() ? high : low;
                        low2 = i2;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        int previousStartBoundary2 = obj.previousStartBoundary(low2 + 1);
        if (previousStartBoundary2 == i5) {
            return i5;
        }
        int nextEndBoundary = obj.nextEndBoundary(previousStartBoundary2);
        if (nextEndBoundary <= $this$getEndOffsetForRectWithinRun.getStart()) {
            return i5;
        }
        segmentStart = RangesKt.coerceAtLeast(previousStartBoundary2, $this$getEndOffsetForRectWithinRun.getStart());
        segmentEnd = RangesKt.coerceAtMost(nextEndBoundary, $this$getEndOffsetForRectWithinRun.getEnd());
        start = 0;
        RectF rectF2 = new RectF(start, (float)obj2, start, (float)obj3);
        while ($this$getEndOffsetForRectWithinRun.isRtl()) {
            characterLeftBounds2 = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(segmentEnd + -1, i3, fArr);
            rectF2.left = characterLeftBounds2;
            if ($this$getEndOffsetForRectWithinRun.isRtl()) {
            } else {
            }
            characterRightBounds = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(segmentEnd + -1, i3, fArr);
            rectF2.right = characterRightBounds;
            segmentEnd = obj.previousEndBoundary(segmentEnd);
            segmentStart = RangesKt.coerceAtLeast(obj.previousStartBoundary(segmentEnd), $this$getEndOffsetForRectWithinRun.getStart());
            characterLeftBounds2 = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(segmentStart, i3, fArr);
            characterRightBounds = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(segmentStart, i3, fArr);
        }
        return segmentEnd;
    }

    public static final int[] getRangeForRect(androidx.compose.ui.text.android.TextLayout $this$getRangeForRect, Layout layout, androidx.compose.ui.text.android.LayoutHelper layoutHelper, RectF rect, int granularity, Function2<? super RectF, ? super RectF, Boolean> inclusionStrategy) {
        SegmentFinder graphemeClusterSegmentFinder;
        int startLine;
        int lineForVertical;
        Object textPaint;
        int lineCount;
        androidx.compose.ui.text.android.selection.WordIterator wordIterator;
        float lineBottom;
        int i4;
        int i2;
        int i;
        int i3;
        int obj10;
        int obj11;
        androidx.compose.ui.text.android.LayoutHelper obj12;
        int obj13;
        if (granularity == 1) {
            graphemeClusterSegmentFinder = new WordSegmentFinder($this$getRangeForRect.getText(), $this$getRangeForRect.getWordIterator());
        } else {
            graphemeClusterSegmentFinder = SegmentFinder_androidKt.createGraphemeClusterSegmentFinder($this$getRangeForRect.getText(), $this$getRangeForRect.getTextPaint());
        }
        final WordSegmentFinder wordSegmentFinder = graphemeClusterSegmentFinder;
        startLine = layout.getLineForVertical((int)top);
        final int i9 = 0;
        if (Float.compare(top2, lineBottom) > 0) {
            startLine++;
            if (startLine >= $this$getRangeForRect.getLineCount()) {
                return i9;
            }
            i4 = startLine;
        } else {
            i4 = startLine;
        }
        lineForVertical = layout.getLineForVertical((int)startLine2);
        if (lineForVertical == 0 && Float.compare(bottom, lineBottom) < 0) {
            if (Float.compare(bottom, lineBottom) < 0) {
                return i9;
            }
        }
        androidx.compose.ui.text.android.TextLayout textLayout = $this$getRangeForRect;
        Layout layout2 = layout;
        final androidx.compose.ui.text.android.LayoutHelper layoutHelper2 = layoutHelper;
        final Object obj = rect;
        final Function2 function2 = inclusionStrategy;
        obj10 = TextLayoutGetRangeForRectExtensions_androidKt.getStartOrEndOffsetForRectWithinLine(textLayout, layout2, layoutHelper2, i4, obj, wordSegmentFinder, function2, true);
        obj11 = i4;
        obj12 = -1;
        while (obj10 == obj12) {
            if (obj11 < lineForVertical) {
            }
            i4 = obj11 + 1;
            obj10 = TextLayoutGetRangeForRectExtensions_androidKt.getStartOrEndOffsetForRectWithinLine(textLayout, layout2, layoutHelper2, i4, obj, wordSegmentFinder, function2, true);
            obj11 = i4;
            obj12 = -1;
        }
        if (obj10 == obj12) {
            return i9;
        }
        obj13 = TextLayoutGetRangeForRectExtensions_androidKt.getStartOrEndOffsetForRectWithinLine(textLayout, layout2, layoutHelper2, lineForVertical, obj, wordSegmentFinder, function2, false);
        while (obj13 == obj12) {
            if (obj11 < lineForVertical) {
            }
            i2 = lineForVertical + -1;
            obj13 = TextLayoutGetRangeForRectExtensions_androidKt.getStartOrEndOffsetForRectWithinLine(textLayout, layout2, layoutHelper2, i2, obj, wordSegmentFinder, function2, false);
            lineForVertical = i2;
        }
        if (obj13 == obj12) {
            return i9;
        }
        return /* result */;
    }

    private static final int getStartOffsetForRectWithinRun(androidx.compose.ui.text.android.LayoutHelper.BidiRun $this$getStartOffsetForRectWithinRun, RectF rect, int lineStart, int lineTop, int lineBottom, float runLeft, float runRight, float[] horizontalBounds, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> inclusionStrategy) {
        int firstCharOffset;
        int low;
        int segmentEnd;
        int high;
        int segmentStart;
        int i;
        float characterLeftBounds;
        boolean rtl;
        float f;
        float characterLeftBounds2;
        float characterRightBounds;
        float nextEndBoundary;
        boolean booleanValue;
        int end;
        final RectF rectF = rect;
        final int i2 = lineStart;
        final float f2 = runLeft;
        final float f3 = runRight;
        final float[] fArr = horizontalBounds;
        final Object obj = segmentFinder;
        final int i4 = -1;
        if (!TextLayoutGetRangeForRectExtensions_androidKt.horizontalOverlap(rectF, f2, f3)) {
            return i4;
        }
        int i3 = 0;
        if (!$this$getStartOffsetForRectWithinRun.isRtl()) {
            if (Float.compare(left, f2) > 0) {
                if ($this$getStartOffsetForRectWithinRun.isRtl() && Float.compare(right, f3) >= 0) {
                    if (Float.compare(right, f3) >= 0) {
                        firstCharOffset = $this$getStartOffsetForRectWithinRun.getStart();
                    } else {
                        low = $this$getStartOffsetForRectWithinRun.getStart();
                        high = $this$getStartOffsetForRectWithinRun.getEnd();
                        while (high - low > 1) {
                            i6 /= 2;
                            characterLeftBounds = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(i, i2, fArr);
                            if (!$this$getStartOffsetForRectWithinRun.isRtl()) {
                            } else {
                            }
                            if ($this$getStartOffsetForRectWithinRun.isRtl() && Float.compare(characterLeftBounds, right2) < 0) {
                            } else {
                            }
                            low = i;
                            if (Float.compare(characterLeftBounds, right2) < 0) {
                            } else {
                            }
                            high = i;
                            if (Float.compare(characterLeftBounds, left2) <= 0) {
                            } else {
                            }
                        }
                        i = $this$getStartOffsetForRectWithinRun.isRtl() ? high : low;
                        firstCharOffset = i;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        int nextEndBoundary2 = obj.nextEndBoundary(firstCharOffset);
        if (nextEndBoundary2 == i4) {
            return i4;
        }
        int previousStartBoundary = obj.previousStartBoundary(nextEndBoundary2);
        if (previousStartBoundary >= $this$getStartOffsetForRectWithinRun.getEnd()) {
            return i4;
        }
        segmentStart = RangesKt.coerceAtLeast(previousStartBoundary, $this$getStartOffsetForRectWithinRun.getStart());
        segmentEnd = RangesKt.coerceAtMost(nextEndBoundary2, $this$getStartOffsetForRectWithinRun.getEnd());
        end = 0;
        RectF rectF2 = new RectF(end, (float)obj2, end, (float)obj3);
        while ($this$getStartOffsetForRectWithinRun.isRtl()) {
            characterLeftBounds2 = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(segmentEnd + -1, i2, fArr);
            rectF2.left = characterLeftBounds2;
            if ($this$getStartOffsetForRectWithinRun.isRtl()) {
            } else {
            }
            characterRightBounds = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(segmentEnd + -1, i2, fArr);
            rectF2.right = characterRightBounds;
            segmentStart = obj.nextStartBoundary(segmentStart);
            segmentEnd = RangesKt.coerceAtMost(obj.nextEndBoundary(segmentStart), $this$getStartOffsetForRectWithinRun.getEnd());
            characterLeftBounds2 = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(segmentStart, i2, fArr);
            characterRightBounds = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(segmentStart, i2, fArr);
        }
        return segmentStart;
    }

    private static final int getStartOrEndOffsetForRectWithinLine(androidx.compose.ui.text.android.TextLayout $this$getStartOrEndOffsetForRectWithinLine, Layout layout, androidx.compose.ui.text.android.LayoutHelper layoutHelper, int lineIndex, RectF rect, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> inclusionStrategy, boolean getStart) {
        int runIndex;
        Object downTo;
        int runIndex2;
        int i2;
        int last;
        float runIndex3;
        float runLeft;
        float characterLeftBounds;
        SegmentFinder runRight;
        float characterRightBounds;
        Function2 function2;
        int i3;
        int i;
        int endOffsetForRectWithinRun;
        runIndex = layout;
        final int i4 = lineIndex;
        final int lineTop = runIndex.getLineTop(i4);
        final int lineBottom = runIndex.getLineBottom(i4);
        final int lineStart = runIndex.getLineStart(i4);
        final int lineEnd = runIndex.getLineEnd(i4);
        i3 = -1;
        if (lineStart == lineEnd) {
            return i3;
        }
        final float[] fArr = new float[i5 *= 2];
        $this$getStartOrEndOffsetForRectWithinLine.fillLineHorizontalBounds$ui_text_release(i4, fArr);
        final androidx.compose.ui.text.android.LayoutHelper.BidiRun[] lineBidiRuns$ui_text_release = layoutHelper.getLineBidiRuns$ui_text_release(lineIndex);
        if (getStart) {
            downTo = ArraysKt.getIndices(lineBidiRuns$ui_text_release);
        } else {
            downTo = RangesKt.downTo(ArraysKt.getLastIndex(lineBidiRuns$ui_text_release), 0);
        }
        final kotlin.ranges.IntRange intRange = downTo;
        runIndex2 = intRange.getFirst();
        last = intRange.getLast();
        final int step = intRange.getStep();
        if (step > 0) {
            if (runIndex2 > last) {
                if (step < 0 && last <= runIndex2) {
                    if (last <= runIndex2) {
                    } else {
                        i = i3;
                    }
                } else {
                }
            }
        } else {
        }
        return i;
    }

    private static final boolean horizontalOverlap(RectF $this$horizontalOverlap, float left, float right) {
        int cmp;
        int i;
        if (Float.compare(right, left2) >= 0 && Float.compare(left, right2) <= 0) {
            i = Float.compare(left, right2) <= 0 ? 1 : 0;
        } else {
        }
        return i;
    }
}
