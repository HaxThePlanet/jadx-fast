package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\u0008 \u0010!J\u001a\u0010\"\u001a\u00020\u00112\u0008\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008$\u0010%J\u0010\u0010&\u001a\u00020\tHÖ\u0001¢\u0006\u0004\u0008'\u0010\u000bJ\u000f\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\u0008*\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u000b\u0088\u0001\u0002¨\u0006,", d2 = {"Landroidx/compose/ui/node/Snake;", "", "data", "", "constructor-impl", "([I)[I", "getData", "()[I", "diagonalSize", "", "getDiagonalSize-impl", "([I)I", "endX", "getEndX-impl", "endY", "getEndY-impl", "hasAdditionOrRemoval", "", "getHasAdditionOrRemoval-impl", "([I)Z", "isAddition", "isAddition-impl", "reverse", "getReverse-impl", "startX", "getStartX-impl", "startY", "getStartY-impl", "addDiagonalToStack", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "equals", "other", "equals-impl", "([ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class Snake {

    private final int[] data;
    private Snake(int[] data) {
        super();
        this.data = data;
    }

    public static final void addDiagonalToStack-impl(int[] arg0, androidx.compose.ui.node.IntStack diagonals) {
        int startX-impl2;
        int startY-impl;
        int diagonalSize-impl;
        int startX-impl;
        if (Snake.getHasAdditionOrRemoval-impl(arg0)) {
            if (Snake.getReverse-impl(arg0)) {
                diagonals.pushDiagonal(Snake.getStartX-impl(arg0), Snake.getStartY-impl(arg0), Snake.getDiagonalSize-impl(arg0));
            } else {
                if (Snake.isAddition-impl(arg0)) {
                    diagonals.pushDiagonal(Snake.getStartX-impl(arg0), startY-impl2++, Snake.getDiagonalSize-impl(arg0));
                } else {
                    diagonals.pushDiagonal(startX-impl3++, Snake.getStartY-impl(arg0), Snake.getDiagonalSize-impl(arg0));
                }
            }
        } else {
            diagonals.pushDiagonal(Snake.getStartX-impl(arg0), Snake.getStartY-impl(arg0), endX-impl -= startX-impl);
        }
    }

    public static final androidx.compose.ui.node.Snake box-impl(int[] iArr) {
        Snake snake = new Snake(iArr);
        return snake;
    }

    public static int[] constructor-impl(int[] iArr) {
        return iArr;
    }

    public static boolean equals-impl(int[] iArr, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof Snake) {
            return i2;
        }
        if (!Intrinsics.areEqual(iArr, (Snake)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(int[] iArr, int[] i2Arr2) {
        return Intrinsics.areEqual(iArr, i2Arr2);
    }

    public static final int getDiagonalSize-impl(int[] arg0) {
        return Math.min(endX-impl -= startX-impl, endY-impl -= startY-impl);
    }

    public static final int getEndX-impl(int[] arg0) {
        return arg0[2];
    }

    public static final int getEndY-impl(int[] arg0) {
        return arg0[3];
    }

    private static final boolean getHasAdditionOrRemoval-impl(int[] arg0) {
        int i;
        i = endY-impl -= startY-impl != endX-impl -= startX-impl ? 1 : 0;
        return i;
    }

    public static final boolean getReverse-impl(int[] arg0) {
        int i;
        i = arg0[4] != 0 ? 1 : 0;
        return i;
    }

    public static final int getStartX-impl(int[] arg0) {
        return arg0[0];
    }

    public static final int getStartY-impl(int[] arg0) {
        return arg0[1];
    }

    public static int hashCode-impl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    private static final boolean isAddition-impl(int[] arg0) {
        int i;
        i = endY-impl -= startY-impl > endX-impl -= startX-impl ? 1 : 0;
        return i;
    }

    public static String toString-impl(int[] arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 44;
        return stringBuilder.append("Snake(").append(Snake.getStartX-impl(arg0)).append(i).append(Snake.getStartY-impl(arg0)).append(i).append(Snake.getEndX-impl(arg0)).append(i).append(Snake.getEndY-impl(arg0)).append(i).append(Snake.getReverse-impl(arg0)).append(')').toString();
    }

    public boolean equals(Object object) {
        return Snake.equals-impl(this.data, object);
    }

    public final int[] getData() {
        return this.data;
    }

    public int hashCode() {
        return Snake.hashCode-impl(this.data);
    }

    public String toString() {
        return Snake.toString-impl(this.data);
    }

    public final int[] unbox-impl() {
        return this.data;
    }
}
