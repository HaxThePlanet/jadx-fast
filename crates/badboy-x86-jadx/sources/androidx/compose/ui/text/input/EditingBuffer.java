package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000c\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000c\u0008\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0017\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\u0008&J\r\u0010'\u001a\u00020%H\u0000¢\u0006\u0002\u0008(J\u001d\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\u0008,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\rH\u0080\u0002¢\u0006\u0002\u00080J\r\u00101\u001a\u000202H\u0000¢\u0006\u0002\u00083J%\u00104\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0002\u00085J%\u00104\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u00085J\u001d\u00106\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\u00087J\u001d\u00108\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\u00089J\r\u0010:\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0008;J\u0008\u0010<\u001a\u00020\u0003H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8@@@X\u0080\u000e¢\u0006\u000c\u001a\u0004\u0008\u0014\u0010\u0010\"\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010\u0010\"\u0004\u0008 \u0010\u0016R$\u0010!\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010\u0010\"\u0004\u0008#\u0010\u0016\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006>", d2 = {"Landroidx/compose/ui/text/input/EditingBuffer;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "composition", "getComposition-MzsxiRA$ui_text_release", "()Landroidx/compose/ui/text/TextRange;", "<set-?>", "", "compositionEnd", "getCompositionEnd$ui_text_release", "()I", "compositionStart", "getCompositionStart$ui_text_release", "cursor", "getCursor$ui_text_release", "setCursor$ui_text_release", "(I)V", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "length", "getLength$ui_text_release", "getSelection-d9O1mEE$ui_text_release", "()J", "value", "selectionEnd", "getSelectionEnd$ui_text_release", "setSelectionEnd", "selectionStart", "getSelectionStart$ui_text_release", "setSelectionStart", "cancelComposition", "", "cancelComposition$ui_text_release", "commitComposition", "commitComposition$ui_text_release", "delete", "start", "end", "delete$ui_text_release", "get", "", "index", "get$ui_text_release", "hasComposition", "", "hasComposition$ui_text_release", "replace", "replace$ui_text_release", "setComposition", "setComposition$ui_text_release", "setSelection", "setSelection$ui_text_release", "toAnnotatedString", "toAnnotatedString$ui_text_release", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EditingBuffer {

    public static final int $stable = 0;
    public static final androidx.compose.ui.text.input.EditingBuffer.Companion Companion = null;
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;
    private final androidx.compose.ui.text.input.PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/ui/text/input/EditingBuffer$Companion;", "", "()V", "NOWHERE", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        int length;
        super();
        PartialGapBuffer partialGapBuffer = new PartialGapBuffer(text.getText());
        this.gapBuffer = partialGapBuffer;
        this.selectionStart = TextRange.getMin-impl(selection);
        this.selectionEnd = TextRange.getMax-impl(selection);
        int i = -1;
        this.compositionStart = i;
        this.compositionEnd = i;
        int min-impl2 = TextRange.getMin-impl(selection);
        int max-impl2 = TextRange.getMax-impl(selection);
        String str = ") offset is outside of text region ";
        if (min-impl2 < 0) {
        } else {
            if (min-impl2 > text.length()) {
            } else {
                if (max-impl2 < 0) {
                } else {
                    if (max-impl2 > text.length()) {
                    } else {
                        if (min-impl2 > max-impl2) {
                        } else {
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Do not set reversed range: ").append(min-impl2).append(" > ").append(max-impl2).toString());
                        throw illegalArgumentException;
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append("end (").append(max-impl2).append(str).append(text.length()).toString());
                throw indexOutOfBoundsException;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder3.append("start (").append(min-impl2).append(str).append(text.length()).toString());
        throw indexOutOfBoundsException2;
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

    private final void setSelectionEnd(int value) {
        int i;
        i = value >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            this.selectionEnd = value;
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
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot set selectionStart to a negative value: ").append(value).toString().toString());
        throw illegalArgumentException;
    }

    public final void cancelComposition$ui_text_release() {
        replace$ui_text_release(this.compositionStart, this.compositionEnd, "");
        int i = -1;
        this.compositionStart = i;
        this.compositionEnd = i;
    }

    public final void commitComposition$ui_text_release() {
        final int i = -1;
        this.compositionStart = i;
        this.compositionEnd = i;
    }

    public final void delete$ui_text_release(int start, int end) {
        boolean composition$ui_text_release;
        int compositionEnd;
        long rangeAfterDelete-pWDy79M;
        int collapsed-impl;
        final long l = TextRangeKt.TextRange(start, end);
        this.gapBuffer.replace(start, end, "");
        int selectionEnd = this.selectionEnd;
        long rangeAfterDelete-pWDy79M2 = EditingBufferKt.updateRangeAfterDelete-pWDy79M(TextRangeKt.TextRange(this.selectionStart, selectionEnd), selectionEnd);
        setSelectionStart(TextRange.getMin-impl(rangeAfterDelete-pWDy79M2));
        setSelectionEnd(TextRange.getMax-impl(rangeAfterDelete-pWDy79M2));
        if (hasComposition$ui_text_release()) {
            compositionEnd = this.compositionEnd;
            rangeAfterDelete-pWDy79M = EditingBufferKt.updateRangeAfterDelete-pWDy79M(TextRangeKt.TextRange(this.compositionStart, compositionEnd), compositionEnd);
            if (TextRange.getCollapsed-impl(rangeAfterDelete-pWDy79M)) {
                commitComposition$ui_text_release();
            } else {
                this.compositionStart = TextRange.getMin-impl(rangeAfterDelete-pWDy79M);
                this.compositionEnd = TextRange.getMax-impl(rangeAfterDelete-pWDy79M);
            }
        }
    }

    public final char get$ui_text_release(int index) {
        return this.gapBuffer.get(index);
    }

    public final TextRange getComposition-MzsxiRA$ui_text_release() {
        TextRange box-impl;
        int compositionEnd;
        if (hasComposition$ui_text_release()) {
            compositionEnd = this.compositionEnd;
            box-impl = TextRange.box-impl(TextRangeKt.TextRange(this.compositionStart, compositionEnd));
        } else {
            box-impl = 0;
        }
        return box-impl;
    }

    public final int getCompositionEnd$ui_text_release() {
        return this.compositionEnd;
    }

    public final int getCompositionStart$ui_text_release() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text_release() {
        int selectionEnd;
        selectionEnd = this.selectionStart == this.selectionEnd ? this.selectionEnd : -1;
        return selectionEnd;
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    public final long getSelection-d9O1mEE$ui_text_release() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getSelectionEnd$ui_text_release() {
        return this.selectionEnd;
    }

    public final int getSelectionStart$ui_text_release() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text_release() {
        int i;
        i = this.compositionStart != -1 ? 1 : 0;
        return i;
    }

    public final void replace$ui_text_release(int start, int end, AnnotatedString text) {
        replace$ui_text_release(start, end, text.getText());
    }

    public final void replace$ui_text_release(int start, int end, String text) {
        int length;
        String str = ") offset is outside of text region ";
        if (start < 0) {
        } else {
            if (start > this.gapBuffer.getLength()) {
            } else {
                if (end < 0) {
                } else {
                    if (end > this.gapBuffer.getLength()) {
                    } else {
                        if (start > end) {
                        } else {
                            this.gapBuffer.replace(start, end, text);
                            setSelectionStart(length2 += start);
                            setSelectionEnd(length3 += start);
                            int i3 = -1;
                            this.compositionStart = i3;
                            this.compositionEnd = i3;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Do not set reversed range: ").append(start).append(" > ").append(end).toString());
                        throw illegalArgumentException;
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append("end (").append(end).append(str).append(this.gapBuffer.getLength()).toString());
                throw indexOutOfBoundsException;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder3.append("start (").append(start).append(str).append(this.gapBuffer.getLength()).toString());
        throw indexOutOfBoundsException2;
    }

    public final void setComposition$ui_text_release(int start, int end) {
        int length;
        String str = ") offset is outside of text region ";
        if (start < 0) {
        } else {
            if (start > this.gapBuffer.getLength()) {
            } else {
                if (end < 0) {
                } else {
                    if (end > this.gapBuffer.getLength()) {
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
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append("end (").append(end).append(str).append(this.gapBuffer.getLength()).toString());
                throw indexOutOfBoundsException;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder3.append("start (").append(start).append(str).append(this.gapBuffer.getLength()).toString());
        throw indexOutOfBoundsException2;
    }

    public final void setCursor$ui_text_release(int cursor) {
        setSelection$ui_text_release(cursor, cursor);
    }

    public final void setSelection$ui_text_release(int start, int end) {
        int length;
        String str = ") offset is outside of text region ";
        if (start < 0) {
        } else {
            if (start > this.gapBuffer.getLength()) {
            } else {
                if (end < 0) {
                } else {
                    if (end > this.gapBuffer.getLength()) {
                    } else {
                        if (start > end) {
                        } else {
                            setSelectionStart(start);
                            setSelectionEnd(end);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Do not set reversed range: ").append(start).append(" > ").append(end).toString());
                        throw illegalArgumentException;
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append("end (").append(end).append(str).append(this.gapBuffer.getLength()).toString());
                throw indexOutOfBoundsException;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder3.append("start (").append(start).append(str).append(this.gapBuffer.getLength()).toString());
        throw indexOutOfBoundsException2;
    }

    public final AnnotatedString toAnnotatedString$ui_text_release() {
        AnnotatedString annotatedString = new AnnotatedString(toString(), 0, 0, 6, 0);
        return annotatedString;
    }

    public String toString() {
        return this.gapBuffer.toString();
    }
}
