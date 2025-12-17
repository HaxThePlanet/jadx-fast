package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000c\n\u0002\u0008\u0006\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000c\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0008\u0010\u0014\u001a\u00020\u0005H\u0002J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0086\u0002J\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J2\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0005J\u0008\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Landroidx/compose/foundation/text/input/internal/GapBuffer;", "", "initBuffer", "", "initGapStart", "", "initGapEnd", "([CII)V", "buffer", "capacity", "gapEnd", "gapStart", "append", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "delete", "start", "end", "gapLength", "get", "", "index", "length", "makeSureAvailableSpace", "requestSize", "replace", "text", "", "textStart", "textEnd", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class GapBuffer {

    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;
    public GapBuffer(char[] initBuffer, int initGapStart, int initGapEnd) {
        super();
        this.capacity = initBuffer.length;
        this.buffer = initBuffer;
        this.gapStart = initGapStart;
        this.gapEnd = initGapEnd;
    }

    private final void delete(int start, int end) {
        int i2;
        int gapStart3;
        int gapStart;
        int i3;
        int buffer;
        int i;
        char[] gapStart4;
        int gapStart2;
        int gapEnd;
        if (start < this.gapStart && end <= this.gapStart) {
            if (end <= this.gapStart) {
                gapStart5 -= end;
                ArraysKt.copyInto(this.buffer, this.buffer, gapEnd4 -= i2, end, this.gapStart);
                this.gapStart = start;
                this.gapEnd = gapEnd2 -= i2;
            } else {
                if (start < this.gapStart && end >= this.gapStart) {
                    if (end >= this.gapStart) {
                        this.gapEnd = gapLength2 += end;
                        this.gapStart = start;
                    } else {
                        gapLength += start;
                        ArraysKt.copyInto(this.buffer, this.buffer, this.gapStart, this.gapEnd, i2);
                        this.gapStart = gapStart6 += buffer;
                        this.gapEnd = gapLength3 += end;
                    }
                } else {
                }
            }
        } else {
        }
    }

    private final int gapLength() {
        return gapEnd -= gapStart;
    }

    private final void makeSureAvailableSpace(int requestSize) {
        int newCapacity;
        int i;
        if (requestSize <= gapLength()) {
        }
        capacity *= 2;
        while (newCapacity - capacity2 < requestSize - gapLength2) {
            newCapacity *= 2;
        }
        char[] cArr = new char[newCapacity];
        int i5 = 0;
        ArraysKt.copyInto(this.buffer, cArr, i5, i5, this.gapStart);
        capacity3 -= gapEnd;
        int i4 = newCapacity - i3;
        ArraysKt.copyInto(this.buffer, cArr, i4, this.gapEnd, gapEnd3 += i3);
        this.buffer = cArr;
        this.capacity = newCapacity;
        this.gapEnd = i4;
    }

    public static void replace$default(androidx.compose.foundation.text.input.internal.GapBuffer gapBuffer, int i2, int i3, java.lang.CharSequence charSequence4, int i5, int i6, int i7, Object object8) {
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
        gapBuffer.replace(i2, i3, charSequence4, i4, i);
    }

    public final void append(StringBuilder builder) {
        builder.append(this.buffer, 0, this.gapStart);
        builder.append(this.buffer, this.gapEnd, capacity -= gapEnd2);
    }

    public final char get(int index) {
        if (index < this.gapStart) {
            return this.buffer[index];
        }
        return this.buffer[i += gapEnd];
    }

    public final int length() {
        return capacity -= gapLength;
    }

    public final void replace(int start, int end, java.lang.CharSequence text, int textStart, int textEnd) {
        final int i = textEnd - textStart;
        makeSureAvailableSpace(i - i2);
        delete(start, end);
        ToCharArray_androidKt.toCharArray(text, this.buffer, this.gapStart, textStart, textEnd);
        this.gapStart = gapStart += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i = 0;
        sb.append((CharSequence)sb);
        return stringBuilder.toString();
    }
}
