package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0096\u0002J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0005J\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "", "text", "(Ljava/lang/CharSequence;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/foundation/text/input/internal/GapBuffer;", "length", "getLength", "()I", "contentEquals", "", "other", "get", "", "index", "replace", "", "start", "end", "textStart", "textEnd", "subSequence", "startIndex", "endIndex", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialGapBuffer implements java.lang.CharSequence {

    public static final int $stable = 0;
    public static final int BUF_SIZE = 255;
    public static final androidx.compose.foundation.text.input.internal.PartialGapBuffer.Companion Companion = null;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd = -1;
    private int bufStart = -1;
    private androidx.compose.foundation.text.input.internal.GapBuffer buffer;
    private java.lang.CharSequence text;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer$Companion;", "", "()V", "BUF_SIZE", "", "NOWHERE", "SURROUNDING_SIZE", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public PartialGapBuffer(java.lang.CharSequence text) {
        super();
        this.text = text;
        final int i = -1;
    }

    public static void replace$default(androidx.compose.foundation.text.input.internal.PartialGapBuffer partialGapBuffer, int i2, int i3, java.lang.CharSequence charSequence4, int i5, int i6, int i7, Object object8) {
        int i4;
        int i;
        int obj10;
        int obj11;
        i4 = i7 & 8 != 0 ? obj10 : i5;
        if (i7 & 16 != 0) {
            i = obj11;
        } else {
            i = i6;
        }
        partialGapBuffer.replace(i2, i3, charSequence4, i4, i);
    }

    @Override // java.lang.CharSequence
    public final char charAt(int index) {
        return get(index);
    }

    @Override // java.lang.CharSequence
    public final boolean contentEquals(java.lang.CharSequence other) {
        return Intrinsics.areEqual(toString(), other.toString());
    }

    @Override // java.lang.CharSequence
    public char get(int index) {
        androidx.compose.foundation.text.input.internal.GapBuffer buffer = this.buffer;
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

    @Override // java.lang.CharSequence
    public int getLength() {
        androidx.compose.foundation.text.input.internal.GapBuffer buffer = this.buffer;
        if (buffer == null) {
            return this.text.length();
        }
        return i += length3;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return getLength();
    }

    @Override // java.lang.CharSequence
    public final void replace(int start, int end, java.lang.CharSequence text, int textStart, int textEnd) {
        int i;
        int bufStart;
        int i3;
        int i2;
        int i4;
        i = 1;
        int i9 = 0;
        i3 = start <= end ? i : i9;
        if (i3 == 0) {
        } else {
            i2 = textStart <= textEnd ? i : i9;
            if (i2 == 0) {
            } else {
                i4 = start >= 0 ? i : i9;
                if (i4 == 0) {
                } else {
                    if (textStart >= 0) {
                    } else {
                        i = i9;
                    }
                    if (i == 0) {
                    } else {
                        androidx.compose.foundation.text.input.internal.GapBuffer buffer = this.buffer;
                        int i6 = textEnd - textStart;
                        if (buffer == null) {
                            char[] cArr = new char[Math.max(255, i6 + 128)];
                            int i18 = 64;
                            int i21 = Math.min(start, i18);
                            int i19 = Math.min(length -= end, i18);
                            ToCharArray_androidKt.toCharArray(this.text, cArr, i9, start - i21, start);
                            ToCharArray_androidKt.toCharArray(this.text, cArr, length2 -= i19, end, end + i19);
                            ToCharArray_androidKt.toCharArray(text, cArr, i21, textStart, textEnd);
                            GapBuffer gapBuffer = new GapBuffer(cArr, i21 + i6, length3 -= i19);
                            this.buffer = gapBuffer;
                            this.bufStart = start - i21;
                            this.bufEnd = end + i19;
                        }
                        int i16 = start - bufStart2;
                        int i20 = end - bufStart;
                        if (i16 >= 0 && i20 > buffer.length()) {
                            if (i20 > buffer.length()) {
                            }
                            buffer.replace(i16, i20, text, textStart, textEnd);
                        }
                        this.text = (CharSequence)toString();
                        this.buffer = 0;
                        int i13 = -1;
                        this.bufStart = i13;
                        this.bufEnd = i13;
                        replace(start, end, text, textStart, textEnd);
                    }
                    int textLength = 0;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("textStart must be non-negative, but was ").append(textStart).toString().toString());
                    throw illegalArgumentException2;
                }
                int i7 = 0;
                StringBuilder stringBuilder3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.append("start must be non-negative, but was ").append(start).toString().toString());
                throw illegalArgumentException3;
            }
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("textStart=").append(textStart).append(" > textEnd=").append(textEnd).toString().toString());
            throw illegalArgumentException;
        }
        int i8 = 0;
        StringBuilder stringBuilder4 = new StringBuilder();
        IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(stringBuilder4.append("start=").append(start).append(" > end=").append(end).toString().toString());
        throw illegalArgumentException4;
    }

    @Override // java.lang.CharSequence
    public java.lang.CharSequence subSequence(int startIndex, int endIndex) {
        return toString().subSequence(startIndex, endIndex);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        androidx.compose.foundation.text.input.internal.GapBuffer buffer = this.buffer;
        if (buffer == null) {
            return this.text.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.text, 0, this.bufStart);
        buffer.append(stringBuilder);
        stringBuilder.append(this.text, this.bufEnd, this.text.length());
        return stringBuilder.toString();
    }
}
