package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextPaint;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b", d2 = {"minIntrinsicWidth", "", "text", "", "paint", "Landroid/text/TextPaint;", "shouldIncreaseMaxIntrinsic", "", "desiredWidth", "charSequence", "textPaint", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutIntrinsics_androidKt {
    public static int $r8$lambda$YaJM_KIWhbbdwtoHjAWE3OCARfw(Pair pair, Pair pair2) {
        return LayoutIntrinsics_androidKt.minIntrinsicWidth$lambda$0(pair, pair2);
    }

    public static final boolean access$shouldIncreaseMaxIntrinsic(float desiredWidth, java.lang.CharSequence charSequence, TextPaint textPaint) {
        return LayoutIntrinsics_androidKt.shouldIncreaseMaxIntrinsic(desiredWidth, charSequence, textPaint);
    }

    public static final float minIntrinsicWidth(java.lang.CharSequence text, TextPaint paint) {
        int start;
        int end;
        Pair pair;
        int minWidth;
        Integer valueOf4;
        Integer valueOf2;
        int valueOf3;
        Integer valueOf;
        int intValue2;
        int i;
        int intValue;
        float desiredWidth;
        BreakIterator lineInstance = BreakIterator.getLineInstance(paint.getTextLocale());
        CharSequenceCharacterIterator charSequenceCharacterIterator = new CharSequenceCharacterIterator(text, 0, text.length());
        lineInstance.setText((CharacterIterator)charSequenceCharacterIterator);
        int i2 = 10;
        LayoutIntrinsics_androidKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LayoutIntrinsics_androidKt$$ExternalSyntheticLambda0();
        PriorityQueue priorityQueue = new PriorityQueue(i2, externalSyntheticLambda0);
        start = 0;
        int i4 = 0;
        end = lineInstance.next();
        while (end != -1) {
            if (priorityQueue.size() < i2) {
            } else {
            }
            pair = priorityQueue.peek();
            valueOf4 = 0;
            if (pair != null && intValue3 -= intValue4 < end - start) {
            }
            start = end;
            end = lineInstance.next();
            valueOf4 = 0;
            if (intValue3 -= intValue4 < end - start) {
            }
            priorityQueue.poll();
            valueOf2 = new Pair(Integer.valueOf(start), Integer.valueOf(end));
            priorityQueue.add(valueOf2);
            pair = new Pair(Integer.valueOf(start), Integer.valueOf(end));
            priorityQueue.add(pair);
        }
        minWidth = 0;
        int i6 = 0;
        Iterator iterator = (Iterable)priorityQueue.iterator();
        for (Object valueOf : iterator) {
            Object obj = valueOf;
            i = 0;
            minWidth = Math.max(minWidth, Layout.getDesiredWidth(text, (Number)(Pair)obj.component1().intValue(), (Number)obj.component2().intValue(), paint));
        }
        return minWidth;
    }

    private static final int minIntrinsicWidth$lambda$0(Pair left, Pair right) {
        return i -= i3;
    }

    private static final boolean shouldIncreaseMaxIntrinsic(float desiredWidth, java.lang.CharSequence charSequence, TextPaint textPaint) {
        int i;
        int letterSpacing;
        int i2;
        Class<androidx.compose.ui.text.android.style.LetterSpacingSpanEm> obj;
        i = 0;
        i2 = 1;
        final int i3 = 0;
        letterSpacing = Float.compare(desiredWidth, i) == 0 ? i2 : i3;
        if (letterSpacing == 0) {
            if (charSequence instanceof Spanned) {
                if (!SpannedExtensions_androidKt.hasSpan((Spanned)charSequence, LetterSpacingSpanPx.class) && !SpannedExtensions_androidKt.hasSpan((Spanned)charSequence, LetterSpacingSpanEm.class)) {
                    if (!SpannedExtensions_androidKt.hasSpan((Spanned)charSequence, LetterSpacingSpanEm.class)) {
                        i = Float.compare(letterSpacing, i) == 0 ? i2 : i3;
                        if (i == 0) {
                        } else {
                            i2 = i3;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }
}
