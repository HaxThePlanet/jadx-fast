package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003J\u0008\u0010\u0017\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0004¨\u0006\u0019", d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer;", "", "text", "", "(Ljava/lang/String;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/ui/text/input/GapBuffer;", "length", "getLength", "()I", "getText", "()Ljava/lang/String;", "setText", "get", "", "index", "replace", "", "start", "end", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialGapBuffer {

    public static final int $stable = 0;
    public static final int BUF_SIZE = 255;
    public static final androidx.compose.ui.text.input.PartialGapBuffer.Companion Companion = null;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd = -1;
    private int bufStart = -1;
    private androidx.compose.ui.text.input.GapBuffer buffer;
    private String text;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer$Companion;", "", "()V", "BUF_SIZE", "", "NOWHERE", "SURROUNDING_SIZE", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        PartialGapBuffer.Companion companion = new PartialGapBuffer.Companion(0);
        PartialGapBuffer.Companion = companion;
        PartialGapBuffer.$stable = 8;
    }

    public PartialGapBuffer(String text) {
        super();
        this.text = text;
        final int i = -1;
    }

    public final char get(int index) {
        androidx.compose.ui.text.input.GapBuffer buffer = this.buffer;
        if (buffer == null) {
            return this.text.charAt(index);
        }
        if (index < this.bufStart) {
            return this.text.charAt(index);
        }
        int length = buffer.length();
        if (index < bufStart2 += length) {
            return buffer.get(index - bufStart3);
        }
        return this.text.charAt(index - i4);
    }

    public final int getLength() {
        androidx.compose.ui.text.input.GapBuffer buffer = this.buffer;
        if (buffer == null) {
            return this.text.length();
        }
        return i += length3;
    }

    public final String getText() {
        return this.text;
    }

    public final void replace(int start, int end, String text) {
        int i2;
        int i;
        int length;
        int i4 = 0;
        i = start <= end ? i2 : i4;
        if (i == 0) {
        } else {
            if (start >= 0) {
            } else {
                i2 = i4;
            }
            if (i2 == 0) {
            } else {
                androidx.compose.ui.text.input.GapBuffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    char[] cArr = new char[Math.max(255, length2 += 128)];
                    int i12 = 64;
                    final int i16 = Math.min(start, i12);
                    int i13 = Math.min(length3 -= end, i12);
                    GapBuffer_jvmKt.toCharArray(this.text, cArr, i4, start - i16, start);
                    GapBuffer_jvmKt.toCharArray(this.text, cArr, length4 -= i13, end, end + i13);
                    GapBufferKt.access$toCharArray(text, cArr, i16);
                    GapBuffer gapBuffer = new GapBuffer(cArr, length5 += i16, length6 -= i13);
                    this.buffer = gapBuffer;
                    this.bufStart = start - i16;
                    this.bufEnd = end + i13;
                }
                int i7 = start - bufStart;
                int i10 = end - bufStart2;
                if (i7 >= 0 && i10 > buffer2.length()) {
                    if (i10 > buffer2.length()) {
                    }
                    buffer2.replace(i7, i10, text);
                }
                this.text = toString();
                this.buffer = 0;
                int i15 = -1;
                this.bufStart = i15;
                this.bufEnd = i15;
                replace(start, end, text);
            }
            int buffer = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("start must be non-negative, but was ").append(start).toString().toString());
            throw illegalArgumentException;
        }
        int i3 = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("start index must be less than or equal to end index: ").append(start).append(" > ").append(end).toString().toString());
        throw illegalArgumentException2;
    }

    public final void setText(String <set-?>) {
        this.text = <set-?>;
    }

    public String toString() {
        androidx.compose.ui.text.input.GapBuffer buffer = this.buffer;
        if (buffer == null) {
            return this.text;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((CharSequence)this.text, 0, this.bufStart);
        buffer.append(stringBuilder);
        stringBuilder.append((CharSequence)this.text, this.bufEnd, this.text.length());
        return stringBuilder.toString();
    }
}
