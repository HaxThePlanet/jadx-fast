package androidx.compose.ui.node;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0015\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001aZ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u001a \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002\u001a \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a8\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H\u0000\u001aZ\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\u0008 \u0010\u0014\u001aR\u0010!\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001a\u001c\u0010$\u001a\u00020\u0001*\u00020\u00122\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006'", d2 = {"applyDiff", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "callback", "Landroidx/compose/ui/node/DiffCallback;", "backward", "", "oldStart", "", "oldEnd", "newStart", "newEnd", "cb", "forward", "Landroidx/compose/ui/node/CenteredArray;", "d", "snake", "", "backward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "calculateDiff", "oldSize", "newSize", "executeDiff", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "forward-4l5_RBY", "midPoint", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "swap", "i", "j", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MyersDiffKt {
    public static final void access$swap(int[] $receiver, int i, int j) {
        MyersDiffKt.swap($receiver, i, j);
    }

    private static final void applyDiff(androidx.compose.ui.node.IntStack diagonals, androidx.compose.ui.node.DiffCallback callback) {
        int posX;
        int posY;
        int i3;
        int i5;
        int i;
        int i2;
        int i4;
        posX = 0;
        posY = 0;
        i3 = 0;
        while (i3 < diagonals.getSize()) {
            i2 = diagonals.get(i3 + 2);
            i3 += 3;
            while (posX < i6 -= i8) {
                callback.remove(posY, posX);
                posX++;
            }
            while (posY < i10 -= i12) {
                callback.insert(posY);
                posY++;
            }
            while (i2 > 0) {
                callback.same(posX, posY);
                posX++;
                posY++;
                i2 = i4;
            }
            callback.same(posX, posY);
            posX++;
            posY++;
            i2 = i4;
            callback.insert(posY);
            posY++;
            callback.remove(posY, posX);
            posX++;
        }
    }

    private static final boolean backward-4l5_RBY(int oldStart, int oldEnd, int newStart, int newEnd, androidx.compose.ui.node.DiffCallback cb, int[] forward, int[] backward, int d, int[] snake) {
        int i4;
        Object obj;
        int i3;
        int k;
        int itemsTheSame;
        int startX;
        int[] iArr;
        int x2;
        int x;
        int i8;
        int i2;
        int y;
        int i7;
        int i6;
        int i;
        int i5;
        final int i9 = oldStart;
        final int i10 = newStart;
        final int[] iArr2 = backward;
        final int i11 = d;
        final int i12 = oldEnd - i9;
        final int i13 = newEnd - i10;
        i4 = i14 %= 2 == 0 ? 1 : 0;
        k = -i11;
        while (k <= i11) {
            int i17 = 0;
            int i20 = 0;
            if (k != -i11) {
            } else {
            }
            startX = CenteredArray.get-impl(iArr2, k + 1);
            x2 = startX;
            i7 = startX;
            itemsTheSame = newEnd - i18;
            if (i11 != 0) {
            } else {
            }
            i6 = itemsTheSame;
            y = itemsTheSame;
            x = x2;
            while (x > i9) {
                i = 0;
                if (cb.areItemsTheSame(x + -1, y + -1) != 0) {
                    break loop_17;
                }
                x--;
                y--;
            }
            obj = cb;
            i = 0;
            CenteredArray.set-impl(iArr2, k, x);
            iArr = forward;
            i5 = 1;
            k += 2;
            itemsTheSame = i16 - k;
            iArr = forward;
            i5 = 1;
            if (y > i10) {
            } else {
            }
            i = 0;
            if (cb.areItemsTheSame(x + -1, y + -1) != 0) {
            }
            x--;
            y--;
            if (x2 != i7) {
            } else {
            }
            i6 = i2;
            if (k != i11 && CenteredArray.get-impl(iArr2, k + 1) < CenteredArray.get-impl(iArr2, k + -1)) {
            } else {
            }
            startX = CenteredArray.get-impl(iArr2, k + -1);
            x2 = startX + -1;
            i7 = startX;
            if (CenteredArray.get-impl(iArr2, k + 1) < CenteredArray.get-impl(iArr2, k + -1)) {
            } else {
            }
        }
        Object obj2 = cb;
        int[] iArr3 = forward;
        return 0;
    }

    private static final androidx.compose.ui.node.IntStack calculateDiff(int oldSize, int newSize, androidx.compose.ui.node.DiffCallback cb) {
        int[] midPoint-q5eDKzI;
        int i2;
        int i;
        int i3;
        int i4;
        androidx.compose.ui.node.DiffCallback endX-impl;
        int endY-impl;
        final int i5 = oldSize;
        final int i6 = newSize;
        i8 /= 2;
        IntStack intStack = new IntStack(i9 * 3);
        IntStack intStack2 = new IntStack(i9 * 4);
        int i12 = 0;
        intStack2.pushRange(i12, i5, i12, i6);
        final int[] constructor-impl3 = Snake.constructor-impl(new int[5]);
        while (intStack2.isNotEmpty()) {
            i4 = intStack2.pop();
            i3 = intStack2.pop();
            i = intStack2.pop();
            i2 = intStack2.pop();
            if (MyersDiffKt.midPoint-q5eDKzI(i2, i, i3, i4, cb, CenteredArray.constructor-impl(new int[i13++]), CenteredArray.constructor-impl(new int[i15++]), constructor-impl3) != null && Snake.getDiagonalSize-impl(constructor-impl3) > 0) {
            }
            if (Snake.getDiagonalSize-impl(constructor-impl3) > 0) {
            }
            intStack2.pushRange(i2, Snake.getStartX-impl(constructor-impl3), i3, Snake.getStartY-impl(constructor-impl3));
            intStack2.pushRange(Snake.getEndX-impl(constructor-impl3), i, Snake.getEndY-impl(constructor-impl3), i4);
            Snake.addDiagonalToStack-impl(constructor-impl3, intStack);
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i5, i6, i12);
        return intStack;
    }

    public static final void executeDiff(int oldSize, int newSize, androidx.compose.ui.node.DiffCallback callback) {
        MyersDiffKt.applyDiff(MyersDiffKt.calculateDiff(oldSize, newSize, callback), callback);
    }

    public static final void fillSnake(int startX, int startY, int endX, int endY, boolean reverse, int[] data) {
        data[0] = startX;
        data[1] = startY;
        data[2] = endX;
        data[3] = endY;
        data[4] = reverse;
    }

    private static final boolean forward-4l5_RBY(int oldStart, int oldEnd, int newStart, int newEnd, androidx.compose.ui.node.DiffCallback cb, int[] forward, int[] backward, int d, int[] snake) {
        int i6;
        int i2;
        int i9;
        int i11;
        int[] iArr;
        int i3;
        int k;
        int y;
        int startX;
        int i;
        int x;
        int i4;
        int i5;
        int i8;
        int itemsTheSame;
        int i7;
        int i10;
        final int i12 = newEnd;
        final int[] iArr2 = forward;
        final int i13 = d;
        final int i14 = i6 - oldStart;
        final int i15 = i12 - newStart;
        i11 = 1;
        i2 = i17 %= 2 == i11 ? i11 : 0;
        k = -i13;
        while (k <= i13) {
            int i21 = 0;
            i = 0;
            int i24 = 0;
            if (k != -i13) {
            } else {
            }
            startX = CenteredArray.get-impl(iArr2, k + 1);
            x = startX;
            i4 = startX;
            i22 -= k;
            if (i13 != 0) {
            } else {
            }
            i8 = y;
            while (x < i6) {
                if (cb.areItemsTheSame(x, y)) {
                    break loop_16;
                }
                x++;
                y++;
            }
            i = cb;
            CenteredArray.set-impl(iArr2, k, x);
            i10 = i11;
            i7 = y;
            itemsTheSame = 0;
            iArr = backward;
            k += 2;
            i6 = oldEnd;
            i11 = i10;
            itemsTheSame = 0;
            i9 = i20 - k;
            iArr = backward;
            i7 = y;
            if (y < i12) {
            } else {
            }
            if (cb.areItemsTheSame(x, y)) {
            }
            x++;
            y++;
            if (x != i4) {
            } else {
            }
            i8 = y + -1;
            if (k != i13 && CenteredArray.get-impl(iArr2, k + 1) > CenteredArray.get-impl(iArr2, k + -1)) {
            } else {
            }
            startX = CenteredArray.get-impl(iArr2, k + -1);
            x = startX + 1;
            i4 = startX;
            if (CenteredArray.get-impl(iArr2, k + 1) > CenteredArray.get-impl(iArr2, k + -1)) {
            } else {
            }
        }
        int i23 = cb;
        int[] iArr3 = backward;
        return 0;
    }

    private static final boolean midPoint-q5eDKzI(int oldStart, int oldEnd, int newStart, int newEnd, androidx.compose.ui.node.DiffCallback cb, int[] forward, int[] backward, int[] snake) {
        int i2;
        int i;
        int i4;
        int i3;
        androidx.compose.ui.node.DiffCallback diffCallback;
        int[] iArr;
        int[] iArr2;
        int d;
        int[] iArr3;
        boolean forward-4l5_RBY;
        boolean backward-4l5_RBY;
        i2 = oldStart;
        i = oldEnd;
        final int i11 = i - i2;
        final int i12 = newEnd - newStart;
        final int i13 = 0;
        final int i14 = 1;
        if (i11 >= i14) {
            if (i12 < i14) {
            } else {
                CenteredArray.set-impl(forward, i14, i2);
                CenteredArray.set-impl(backward, i14, i);
                d = i4;
                while (d < i8 / 2) {
                    d++;
                    i2 = oldStart;
                    i = oldEnd;
                    iArr = forward;
                    iArr2 = backward;
                }
            }
            return i13;
        }
        return i13;
    }

    private static final void swap(int[] $this$swap, int i, int j) {
        $this$swap[i] = $this$swap[j];
        $this$swap[j] = $this$swap[i];
    }
}
