package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\t", d2 = {"setFrom", "", "Landroid/graphics/Matrix;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidMatrixConversions_androidKt {
    public static final void setFrom-EL8BTi8(Matrix $this$setFrom_u2dEL8BTi8, float[] matrix) {
        int i = 0;
        final int i2 = matrix[i];
        int i3 = 1;
        final int i4 = matrix[i3];
        final int i5 = 2;
        final int i7 = 3;
        final int i8 = matrix[i7];
        final int i9 = 4;
        final int i10 = matrix[i9];
        final int i11 = 5;
        final int i12 = matrix[i11];
        final int i13 = 6;
        final int i15 = 7;
        final int i16 = matrix[i15];
        final int i17 = 8;
        int[] iArr2 = matrix;
        iArr2[i] = i2;
        iArr2[i3] = i10;
        iArr2[i5] = matrix[12];
        iArr2[i7] = i4;
        iArr2[i9] = i12;
        iArr2[i11] = matrix[13];
        iArr2[i13] = i8;
        iArr2[i15] = i16;
        iArr2[i17] = matrix[15];
        int[] iArr = iArr3;
        $this$setFrom_u2dEL8BTi8.setValues(iArr);
        iArr[i] = i2;
        iArr[i3] = i4;
        iArr[i5] = matrix[i5];
        iArr[i7] = i8;
        iArr[i9] = i10;
        iArr[i11] = i12;
        iArr[i13] = matrix[i13];
        iArr[i15] = i16;
        iArr[i17] = matrix[i17];
    }

    public static final void setFrom-tU-YjHk(float[] $this$setFrom_u2dtU_u2dYjHk, Matrix matrix) {
        final float[] fArr = $this$setFrom_u2dtU_u2dYjHk;
        matrix.getValues(fArr);
        int i = 0;
        int i4 = 1;
        int i11 = 2;
        final int i13 = 3;
        final int i14 = 4;
        final int i15 = 5;
        final int i16 = 6;
        final int i17 = 7;
        final int i18 = 8;
        fArr[i] = fArr[i];
        fArr[i4] = fArr[i13];
        int i2 = 0;
        fArr[i11] = i2;
        fArr[i13] = fArr[i16];
        fArr[i14] = fArr[i4];
        fArr[i15] = fArr[i14];
        fArr[i16] = i2;
        fArr[i17] = fArr[i17];
        fArr[i18] = i2;
        fArr[9] = i2;
        fArr[10] = 1065353216;
        fArr[11] = i2;
        fArr[12] = fArr[i11];
        fArr[13] = fArr[i15];
        fArr[14] = i2;
        fArr[15] = fArr[i18];
    }
}
