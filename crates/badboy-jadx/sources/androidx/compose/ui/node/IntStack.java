package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\r\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u0011\u001a\u00020\u000cJ \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010\u0016\u001a\u00020\u0003J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J&\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J \u0010 \u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010!\u001a\u00020\u0018J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Landroidx/compose/ui/node/IntStack;", "", "initialCapacity", "", "(I)V", "lastIndex", "size", "getSize", "()I", "stack", "", "compareDiagonal", "", "a", "b", "get", "index", "isNotEmpty", "partition", "start", "end", "elSize", "pop", "pushDiagonal", "", "x", "y", "pushRange", "oldStart", "oldEnd", "newStart", "newEnd", "quickSort", "sortDiagonals", "swapDiagonal", "i", "j", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class IntStack {

    private int lastIndex;
    private int[] stack;
    public IntStack(int initialCapacity) {
        super();
        this.stack = new int[initialCapacity];
    }

    private final boolean compareDiagonal(int a, int b) {
        int i2;
        int i;
        int i3;
        final int[] stack = this.stack;
        final int i4 = stack[a];
        final int i5 = stack[b];
        if (i4 >= i5) {
            if (i4 == i5 && stack[a + 1] <= stack[b + 1]) {
                if (stack[a + 1] <= stack[b + 1]) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final int partition(int start, int end, int elSize) {
        int i;
        int j;
        boolean compareDiagonal;
        i = start - elSize;
        j = start;
        while (j < end) {
            if (compareDiagonal(j, end)) {
            }
            j += elSize;
            swapDiagonal(i += elSize, j);
        }
        swapDiagonal(i + elSize, end);
        return i + elSize;
    }

    private final void quickSort(int start, int end, int elSize) {
        int partition;
        int i;
        if (start < end) {
            partition = partition(start, end, elSize);
            quickSort(start, partition - elSize, elSize);
            quickSort(partition + elSize, end, elSize);
        }
    }

    private final void swapDiagonal(int i, int j) {
        final int[] stack = this.stack;
        MyersDiffKt.access$swap(stack, i, j);
        MyersDiffKt.access$swap(stack, i + 1, j + 1);
        MyersDiffKt.access$swap(stack, i + 2, j + 2);
    }

    public final int get(int index) {
        return this.stack[index];
    }

    public final int getSize() {
        return this.lastIndex;
    }

    public final boolean isNotEmpty() {
        int i;
        i = this.lastIndex != 0 ? 1 : 0;
        return i;
    }

    public final int pop() {
        this.lastIndex = lastIndex--;
        return this.stack[this.lastIndex];
    }

    public final void pushDiagonal(int x, int y, int size) {
        int copyOf;
        int length;
        final int lastIndex = this.lastIndex;
        if (lastIndex + 3 >= stack3.length) {
            copyOf = Arrays.copyOf(this.stack, length2 *= 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] stack = this.stack;
        stack[lastIndex + 0] = x + size;
        stack[lastIndex + 1] = y + size;
        stack[lastIndex + 2] = size;
        this.lastIndex = lastIndex + 3;
    }

    public final void pushRange(int oldStart, int oldEnd, int newStart, int newEnd) {
        int copyOf;
        int length;
        final int lastIndex = this.lastIndex;
        if (lastIndex + 4 >= stack3.length) {
            copyOf = Arrays.copyOf(this.stack, length2 *= 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] stack = this.stack;
        stack[lastIndex + 0] = oldStart;
        stack[lastIndex + 1] = oldEnd;
        stack[lastIndex + 2] = newStart;
        stack[lastIndex + 3] = newEnd;
        this.lastIndex = lastIndex + 4;
    }

    public final void sortDiagonals() {
        int i2;
        int i;
        String $i$a$CheckPreconditionIntStack$sortDiagonals$1;
        final int lastIndex = this.lastIndex;
        final int i4 = 0;
        i2 = lastIndex % 3 == 0 ? 1 : i4;
        i = 0;
        if (i2 == 0) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalStateException("Array size not a multiple of 3");
        }
        int value$iv = 3;
        if (lastIndex > value$iv) {
            quickSort(i4, lastIndex + -3, value$iv);
        }
    }
}
