package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "isIdentity", "", "isIdentity-58bKbWc", "([F)Z", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MatrixKt {
    public static final float access$dot-p89u6pk(float[] m1, int row, float[] m2, int column) {
        return MatrixKt.dot-p89u6pk(m1, row, m2, column);
    }

    private static final float dot-p89u6pk(float[] m1, int row, float[] m2, int column) {
        int i6 = 0;
        int i15 = 0;
        int i16 = 0;
        int i23 = 0;
        int i17 = 0;
        int i26 = 0;
        int i18 = 0;
        int i29 = 0;
        return i4 += i12;
    }

    public static final boolean isIdentity-58bKbWc(float[] $this$isIdentity_u2d58bKbWc) {
        int row;
        int i3;
        int i5;
        int column;
        int i;
        int i2;
        int i4;
        row = 0;
        i3 = 4;
        i5 = 1;
        while (row < i3) {
            column = 0;
            while (column < i3) {
                if (row == column) {
                } else {
                }
                i = 0;
                int i6 = 0;
                i4 = 0;
                if (Float.compare($i$f$getImpl, i) == 0) {
                } else {
                }
                i2 = i4;
                column++;
                i2 = i5;
                i = 1065353216;
            }
            row++;
            i3 = 4;
            i5 = 1;
            if (row == column) {
            } else {
            }
            i = 0;
            i6 = 0;
            i4 = 0;
            if (Float.compare($i$f$getImpl, i) == 0) {
            } else {
            }
            i2 = i4;
            column++;
            i2 = i5;
            i = 1065353216;
        }
        return i5;
    }
}
