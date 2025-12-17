package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u000eJ\u001e\u0010\u0011\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J&\u0010\u0016\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi21;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "tmpLocation", "", "[F", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "transformMatrixToWindow", "transformMatrixToWindow-EL8BTi8", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CalculateMatrixToWindowApi21 implements androidx.compose.ui.platform.CalculateMatrixToWindow {

    private final int[] tmpLocation;
    private final float[] tmpMatrix;
    private CalculateMatrixToWindowApi21(float[] tmpMatrix) {
        super();
        this.tmpMatrix = tmpMatrix;
        this.tmpLocation = new int[2];
    }

    public CalculateMatrixToWindowApi21(float[] fArr, DefaultConstructorMarker defaultConstructorMarker2) {
        super(fArr);
    }

    private final void preConcat-tU-YjHk(float[] $this$preConcat_u2dtU_u2dYjHk, Matrix other) {
        AndroidMatrixConversions_androidKt.setFrom-tU-YjHk(this.tmpMatrix, other);
        AndroidComposeView_androidKt.access$preTransform-JiSxe2E($this$preConcat_u2dtU_u2dYjHk, this.tmpMatrix);
    }

    private final void preTranslate-3XD1CNM(float[] $this$preTranslate_u2d3XD1CNM, float x, float y) {
        AndroidComposeView_androidKt.access$preTranslate-cG2Xzmc($this$preTranslate_u2d3XD1CNM, x, y, this.tmpMatrix);
    }

    private final void transformMatrixToWindow-EL8BTi8(View view, float[] matrix) {
        float tmpLocation;
        float f2;
        float f;
        final android.view.ViewParent parent = view.getParent();
        if (parent instanceof View != null) {
            transformMatrixToWindow-EL8BTi8((View)parent, matrix);
            preTranslate-3XD1CNM(matrix, -f3, -f4);
            preTranslate-3XD1CNM(matrix, (float)left, (float)top);
        } else {
            tmpLocation = this.tmpLocation;
            view.getLocationInWindow(tmpLocation);
            preTranslate-3XD1CNM(matrix, -f5, -f6);
            preTranslate-3XD1CNM(matrix, (float)i5, (float)i8);
        }
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            preConcat-tU-YjHk(matrix, matrix2);
        }
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    public void calculateMatrixToWindow-EL8BTi8(View view, float[] matrix) {
        Matrix.reset-impl(matrix);
        transformMatrixToWindow-EL8BTi8(view, matrix);
    }
}
