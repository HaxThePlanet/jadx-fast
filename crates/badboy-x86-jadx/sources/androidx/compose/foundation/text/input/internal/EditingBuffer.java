package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\u0008\t\u0008\u0000\u0018\u0000 D2\u00020\u0001:\u0001DB\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011H\u0002J\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u000200J\u0016\u00105\u001a\u0002002\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011J\u0011\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0011H\u0086\u0002J\u0006\u00109\u001a\u00020:J\u001e\u0010;\u001a\u0002002\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020<J\u0016\u0010=\u001a\u0002002\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011J(\u0010\"\u001a\u0002002\u0006\u0010>\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J\u0016\u0010A\u001a\u0002002\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011J\u0006\u0010B\u001a\u00020\u0007J\u0008\u0010C\u001a\u00020\u0003H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0018\u0010\u0014\"\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\u0011\u0010$\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008%\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008&\u0010'R$\u0010)\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010\u0014\"\u0004\u0008+\u0010\u001aR$\u0010,\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010\u0014\"\u0004\u0008.\u0010\u001a\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006E", d2 = {"Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "changeTracker", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "getChangeTracker", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "<set-?>", "", "compositionEnd", "getCompositionEnd", "()I", "compositionStart", "getCompositionStart", "cursor", "getCursor", "setCursor", "(I)V", "gapBuffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "getHighlight", "()Lkotlin/Pair;", "setHighlight", "(Lkotlin/Pair;)V", "length", "getLength", "getSelection-d9O1mEE", "()J", "value", "selectionEnd", "getSelectionEnd", "setSelectionEnd", "selectionStart", "getSelectionStart", "setSelectionStart", "checkRange", "", "start", "end", "clearHighlight", "commitComposition", "delete", "get", "", "index", "hasComposition", "", "replace", "", "setComposition", "type", "setHighlight-K7f2yys", "(III)V", "setSelection", "toAnnotatedString", "toString", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EditingBuffer {

    public static final int $stable = 0;
    public static final androidx.compose.foundation.text.input.internal.EditingBuffer.Companion Companion = null;
    public static final int NOWHERE = -1;
    private final androidx.compose.foundation.text.input.internal.ChangeTracker changeTracker;
    private int compositionEnd;
    private int compositionStart;
    private final androidx.compose.foundation.text.input.internal.PartialGapBuffer gapBuffer;
    private Pair<TextHighlightType, TextRange> highlight;
    private int selectionEnd;
    private int selectionStart;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/foundation/text/input/internal/EditingBuffer$Companion;", "", "()V", "NOWHERE", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        EditingBuffer.Companion companion = new EditingBuffer.Companion(0);
        EditingBuffer.Companion = companion;
        EditingBuffer.$stable = 8;
    }

    private EditingBuffer(AnnotatedString text, long selection) {
        super();
        PartialGapBuffer partialGapBuffer = new PartialGapBuffer((CharSequence)text.getText());
        this.gapBuffer = partialGapBuffer;
        int i2 = 0;
        ChangeTracker changeTracker = new ChangeTracker(i2, 1, i2);
        this.changeTracker = changeTracker;
        this.selectionStart = TextRange.getStart-impl(selection);
        this.selectionEnd = TextRange.getEnd-impl(selection);
        int i = -1;
        this.compositionStart = i;
        this.compositionEnd = i;
        checkRange(TextRange.getStart-impl(selection), TextRange.getEnd-impl(selection));
    }

    public EditingBuffer(AnnotatedString annotatedString, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(annotatedString, l2, defaultConstructorMarker3);
    }

    private EditingBuffer(String text, long selection) {
        AnnotatedString annotatedString = new AnnotatedString(text, 0, 0, 6, 0);
        super(annotatedString, selection, obj9, 0);
    }

    public EditingBuffer(String string, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(string, l2, defaultConstructorMarker3);
    }

    private final void checkRange(int start, int end) {
        int length;
        String str = ") offset is outside of text region ";
        if (start < 0) {
        } else {
            if (start > this.gapBuffer.length()) {
            } else {
                if (end < 0) {
                } else {
                    if (end > this.gapBuffer.length()) {
                    } else {
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("end (").append(end).append(str).append(this.gapBuffer.length()).toString());
                throw indexOutOfBoundsException;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder2.append("start (").append(start).append(str).append(this.gapBuffer.length()).toString());
        throw indexOutOfBoundsException2;
    }

    private final void setSelectionEnd(int value) {
        int i;
        i = value >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            this.selectionEnd = value;
            this.highlight = 0;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot set selectionEnd to a negative value: ").append(value).toString().toString());
        throw illegalArgumentException;
    }

    private final void setSelectionStart(int value) {
        int i;
        i = value >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            this.selectionStart = value;
            this.highlight = 0;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot set selectionStart to a negative value: ").append(value).toString().toString());
        throw illegalArgumentException;
    }

    public final void clearHighlight() {
        this.highlight = 0;
    }

    public final void commitComposition() {
        final int i = -1;
        this.compositionStart = i;
        this.compositionEnd = i;
    }

    public final void delete(int start, int end) {
        boolean composition;
        int compositionEnd;
        int rangeAfterDelete-pWDy79M;
        int collapsed-impl;
        checkRange(start, end);
        final long l = TextRangeKt.TextRange(start, end);
        this.changeTracker.trackChange(start, end, 0);
        final String str2 = str;
        PartialGapBuffer.replace$default(this.gapBuffer, TextRange.getMin-impl(l), TextRange.getMax-impl(l), (CharSequence)str2, 0, 0, 24, 0);
        int selectionEnd = this.selectionEnd;
        long rangeAfterDelete-pWDy79M2 = EditingBufferKt.updateRangeAfterDelete-pWDy79M(TextRangeKt.TextRange(this.selectionStart, selectionEnd), selectionEnd);
        setSelectionStart(TextRange.getStart-impl(rangeAfterDelete-pWDy79M2));
        setSelectionEnd(TextRange.getEnd-impl(rangeAfterDelete-pWDy79M2));
        if (hasComposition()) {
            compositionEnd = this.compositionEnd;
            rangeAfterDelete-pWDy79M = EditingBufferKt.updateRangeAfterDelete-pWDy79M(TextRangeKt.TextRange(this.compositionStart, compositionEnd), compositionEnd);
            if (TextRange.getCollapsed-impl(rangeAfterDelete-pWDy79M)) {
                commitComposition();
            } else {
                this.compositionStart = TextRange.getMin-impl(rangeAfterDelete-pWDy79M);
                this.compositionEnd = TextRange.getMax-impl(rangeAfterDelete-pWDy79M);
            }
        }
        this.highlight = 0;
    }

    public final char get(int index) {
        return this.gapBuffer.charAt(index);
    }

    public final androidx.compose.foundation.text.input.internal.ChangeTracker getChangeTracker() {
        return this.changeTracker;
    }

    public final TextRange getComposition-MzsxiRA() {
        TextRange box-impl;
        int compositionEnd;
        if (hasComposition()) {
            compositionEnd = this.compositionEnd;
            box-impl = TextRange.box-impl(TextRangeKt.TextRange(this.compositionStart, compositionEnd));
        } else {
            box-impl = 0;
        }
        return box-impl;
    }

    public final int getCompositionEnd() {
        return this.compositionEnd;
    }

    public final int getCompositionStart() {
        return this.compositionStart;
    }

    public final int getCursor() {
        int selectionEnd;
        selectionEnd = this.selectionStart == this.selectionEnd ? this.selectionEnd : -1;
        return selectionEnd;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    public final int getLength() {
        return this.gapBuffer.length();
    }

    public final long getSelection-d9O1mEE() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    public final int getSelectionStart() {
        return this.selectionStart;
    }

    public final boolean hasComposition() {
        int i;
        i = this.compositionStart != -1 ? 1 : 0;
        return i;
    }

    public final void replace(int start, int end, java.lang.CharSequence text) {
        int charAt3;
        int charAt;
        int charAt2;
        int charAt4;
        int i;
        int i2;
        int cMin;
        int j;
        int cMax;
        checkRange(start, end);
        final int i4 = Math.min(start, end);
        final int i5 = Math.max(start, end);
        i2 = charAt3;
        cMin = charAt2;
        while (cMin < i5) {
            if (i2 < text.length()) {
            }
            if (text.charAt(i2) == this.gapBuffer.charAt(cMin)) {
            }
            i2++;
            cMin++;
        }
        j = charAt;
        cMax = charAt4;
        while (cMax > i4) {
            if (j > i2) {
            }
            if (text.charAt(j + -1) == this.gapBuffer.charAt(cMax + -1)) {
            }
            j--;
            cMax--;
        }
        this.changeTracker.trackChange(cMin, cMax, j - i2);
        java.lang.CharSequence charSequence = text;
        PartialGapBuffer.replace$default(this.gapBuffer, i4, i5, charSequence, 0, 0, 24, 0);
        setSelectionStart(obj15 += i4);
        setSelectionEnd(obj15 += i4);
        int obj15 = -1;
        this.compositionStart = obj15;
        this.compositionEnd = obj15;
        this.highlight = 0;
    }

    public final void setComposition(int start, int end) {
        int length;
        String str = ") offset is outside of text region ";
        if (start < 0) {
        } else {
            if (start > this.gapBuffer.length()) {
            } else {
                if (end < 0) {
                } else {
                    if (end > this.gapBuffer.length()) {
                    } else {
                        if (start >= end) {
                        } else {
                            this.compositionStart = start;
                            this.compositionEnd = end;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Do not set reversed or empty range: ").append(start).append(" > ").append(end).toString());
                        throw illegalArgumentException;
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append("end (").append(end).append(str).append(this.gapBuffer.length()).toString());
                throw indexOutOfBoundsException;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder3.append("start (").append(start).append(str).append(this.gapBuffer.length()).toString());
        throw indexOutOfBoundsException2;
    }

    public final void setCursor(int cursor) {
        setSelection(cursor, cursor);
    }

    public final void setHighlight(Pair<TextHighlightType, TextRange> <set-?>) {
        this.highlight = <set-?>;
    }

    public final void setHighlight-K7f2yys(int type, int start, int end) {
        if (start >= end) {
        } else {
            int i = 0;
            Pair pair = new Pair(TextHighlightType.box-impl(type), TextRange.box-impl(TextRangeKt.TextRange(RangesKt.coerceIn(start, i, getLength()), RangesKt.coerceIn(end, i, getLength()))));
            this.highlight = pair;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException clampedStart = new IllegalArgumentException(stringBuilder.append("Do not set reversed or empty range: ").append(start).append(" > ").append(end).toString());
        throw clampedStart;
    }

    public final void setSelection(int start, int end) {
        int i = 0;
        setSelectionStart(RangesKt.coerceIn(start, i, getLength()));
        setSelectionEnd(RangesKt.coerceIn(end, i, getLength()));
    }

    public final AnnotatedString toAnnotatedString() {
        AnnotatedString annotatedString = new AnnotatedString(toString(), 0, 0, 6, 0);
        return annotatedString;
    }

    public String toString() {
        return this.gapBuffer.toString();
    }
}
