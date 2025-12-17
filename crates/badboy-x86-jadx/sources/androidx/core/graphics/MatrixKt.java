package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\u000c\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\u0008¨\u0006\u0010", d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", "px", "py", "scaleMatrix", "sx", "sy", "translationMatrix", "tx", "ty", "times", "m", "values", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MatrixKt {
    public static final Matrix rotationMatrix(float degrees, float px, float py) {
        Matrix matrix = new Matrix();
        final int i = 0;
        matrix.setRotate(degrees, px, py);
        return matrix;
    }

    public static Matrix rotationMatrix$default(float f, float f2, float f3, int i4, Object object5) {
        int obj2;
        int obj3;
        final int i = 0;
        if (i4 & 2 != 0) {
            obj2 = i;
        }
        if (i4 &= 4 != 0) {
            obj3 = i;
        }
        return MatrixKt.rotationMatrix(f, obj2, obj3);
    }

    public static final Matrix scaleMatrix(float sx, float sy) {
        Matrix matrix = new Matrix();
        final int i = 0;
        matrix.setScale(sx, sy);
        return matrix;
    }

    public static Matrix scaleMatrix$default(float f, float f2, int i3, Object object4) {
        int obj1;
        int obj2;
        final int i = 1065353216;
        if (i3 & 1 != 0) {
            obj1 = i;
        }
        if (i3 &= 2 != 0) {
            obj2 = i;
        }
        return MatrixKt.scaleMatrix(obj1, obj2);
    }

    public static final Matrix times(Matrix $this$times, Matrix m) {
        final int i = 0;
        Matrix matrix = new Matrix($this$times);
        final int i2 = 0;
        matrix.preConcat(m);
        return matrix;
    }

    public static final Matrix translationMatrix(float tx, float ty) {
        Matrix matrix = new Matrix();
        final int i = 0;
        matrix.setTranslate(tx, ty);
        return matrix;
    }

    public static Matrix translationMatrix$default(float f, float f2, int i3, Object object4) {
        int obj1;
        int obj2;
        final int i = 0;
        if (i3 & 1 != 0) {
            obj1 = i;
        }
        if (i3 &= 2 != 0) {
            obj2 = i;
        }
        return MatrixKt.translationMatrix(obj1, obj2);
    }

    public static final float[] values(Matrix $this$values) {
        final int i = 0;
        float[] fArr = new float[9];
        final int i3 = 0;
        $this$values.getValues(fArr);
        return fArr;
    }
}
