package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\u0008\u0004\u001a\u0013\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a$\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"TextRange", "Landroidx/compose/ui/text/TextRange;", "index", "", "(I)J", "start", "end", "(II)J", "packWithCheck", "", "coerceIn", "minimumValue", "maximumValue", "coerceIn-8ffj60Q", "(JII)J", "substring", "", "", "range", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextRangeKt {
    public static final long TextRange(int index) {
        return TextRangeKt.TextRange(index, index);
    }

    public static final long TextRange(int start, int end) {
        return TextRange.constructor-impl(TextRangeKt.packWithCheck(start, end));
    }

    public static final long coerceIn-8ffj60Q(long $this$coerceIn_u2d8ffj60Q, int minimumValue, int maximumValue) {
        int start-impl;
        int coerceIn = RangesKt.coerceIn(TextRange.getStart-impl($this$coerceIn_u2d8ffj60Q), maximumValue, obj7);
        int coerceIn2 = RangesKt.coerceIn(TextRange.getEnd-impl($this$coerceIn_u2d8ffj60Q), maximumValue, obj7);
        if (coerceIn == TextRange.getStart-impl($this$coerceIn_u2d8ffj60Q) && coerceIn2 != TextRange.getEnd-impl($this$coerceIn_u2d8ffj60Q)) {
            if (coerceIn2 != TextRange.getEnd-impl($this$coerceIn_u2d8ffj60Q)) {
            }
            return $this$coerceIn_u2d8ffj60Q;
        }
        return TextRangeKt.TextRange(coerceIn, coerceIn2);
    }

    private static final long packWithCheck(int start, int end) {
        int i2;
        int i;
        int i6 = 0;
        i = start >= 0 ? i2 : i6;
        int i8 = 93;
        final String str3 = ", end: ";
        if (i == 0) {
        } else {
            if (end >= 0) {
            } else {
                i2 = i6;
            }
            if (i2 == 0) {
            } else {
                int i5 = 0;
                return i7 | i10;
            }
            int i4 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("end cannot be negative. [start: ").append(start).append(str3).append(end).append(i8).toString().toString());
            throw illegalArgumentException2;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("start cannot be negative. [start: ").append(start).append(str3).append(end).append(i8).toString().toString());
        throw illegalArgumentException;
    }

    public static final String substring-FDrldGo(java.lang.CharSequence $this$substring_u2dFDrldGo, long range) {
        return $this$substring_u2dFDrldGo.subSequence(TextRange.getMin-impl(range), TextRange.getMax-impl(range)).toString();
    }
}
