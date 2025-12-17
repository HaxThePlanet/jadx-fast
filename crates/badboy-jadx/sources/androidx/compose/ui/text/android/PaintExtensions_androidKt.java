package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a,\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a$\u0010\u000b\u001a\u00020\u0002*\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0000\u001a$\u0010\u000f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0001¨\u0006\u0010", d2 = {"extendWith", "", "Landroid/graphics/Rect;", "rect", "fillStringBounds", "Landroid/graphics/Paint;", "text", "", "start", "", "end", "getCharSequenceBounds", "Landroid/text/TextPaint;", "startInclusive", "endExclusive", "getStringBounds", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaintExtensions_androidKt {
    private static final void extendWith(Rect $this$extendWith, Rect rect) {
        $this$extendWith.right = right += width;
        $this$extendWith.top = Math.min($this$extendWith.top, rect.top);
        $this$extendWith.bottom = Math.max($this$extendWith.bottom, rect.bottom);
    }

    private static final void fillStringBounds(Paint $this$fillStringBounds, java.lang.CharSequence text, int start, int end, Rect rect) {
        Paint29.getTextBounds($this$fillStringBounds, text, start, end, rect);
    }

    public static final Rect getCharSequenceBounds(TextPaint $this$getCharSequenceBounds, java.lang.CharSequence text, int startInclusive, int endExclusive) {
        boolean span;
        int tmpStart;
        int nextSpanTransition;
        Object[] spans;
        TextPaint textPaint;
        int i;
        Object obj;
        int spanStart;
        int spanEnd;
        final Class<MetricAffectingSpan> obj2 = MetricAffectingSpan.class;
        if (text instanceof Spanned) {
            if (!SpannedExtensions_androidKt.hasSpan((Spanned)text, obj2, startInclusive, endExclusive)) {
            } else {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                tmpStart = startInclusive;
                while (tmpStart < endExclusive) {
                    nextSpanTransition = (Spanned)text.nextSpanTransition(tmpStart, endExclusive, obj2);
                    spans = (Spanned)text.getSpans(tmpStart, nextSpanTransition, obj2);
                    textPaint2.set($this$getCharSequenceBounds);
                    i = 0;
                    while (i < spans.length) {
                        obj = (MetricAffectingSpan[])spans[i];
                        if ((Spanned)text.getSpanStart(obj) != (Spanned)text.getSpanEnd(obj)) {
                        }
                        i++;
                        obj.updateMeasureState(textPaint2);
                    }
                    PaintExtensions_androidKt.fillStringBounds((Paint)textPaint2, text, tmpStart, nextSpanTransition, rect2);
                    PaintExtensions_androidKt.extendWith(rect, rect2);
                    tmpStart = nextSpanTransition;
                    obj = spans[i];
                    if ((Spanned)text.getSpanStart(obj) != (Spanned)text.getSpanEnd(obj)) {
                    }
                    i++;
                    obj.updateMeasureState(textPaint2);
                }
            }
            return rect;
        }
        return PaintExtensions_androidKt.getStringBounds((Paint)$this$getCharSequenceBounds, text, startInclusive, endExclusive);
    }

    public static final Rect getStringBounds(Paint $this$getStringBounds, java.lang.CharSequence text, int start, int end) {
        Rect rect = new Rect();
        PaintExtensions_androidKt.fillStringBounds($this$getStringBounds, text, start, end, rect);
        return rect;
    }
}
