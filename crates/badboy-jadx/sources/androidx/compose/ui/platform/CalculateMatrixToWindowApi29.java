package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000f", d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi29;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "()V", "tmpMatrix", "Landroid/graphics/Matrix;", "tmpPosition", "", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CalculateMatrixToWindowApi29 implements androidx.compose.ui.platform.CalculateMatrixToWindow {

    private final Matrix tmpMatrix;
    private final int[] tmpPosition;
    public CalculateMatrixToWindowApi29() {
        super();
        Matrix matrix = new Matrix();
        this.tmpMatrix = matrix;
        this.tmpPosition = new int[2];
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    public void calculateMatrixToWindow-EL8BTi8(View view, float[] matrix) {
        android.view.ViewParent parent;
        android.view.ViewParent root;
        boolean z;
        this.tmpMatrix.reset();
        view.transformMatrixToGlobal(this.tmpMatrix);
        parent = view.getParent();
        root = view;
        while (parent instanceof View != null) {
            parent = (View)parent.getParent();
        }
        root.getLocationOnScreen(this.tmpPosition);
        int[] tmpPosition2 = this.tmpPosition;
        int i2 = 0;
        int i5 = 1;
        root.getLocationInWindow(this.tmpPosition);
        int[] tmpPosition4 = this.tmpPosition;
        this.tmpMatrix.postTranslate((float)i7, (float)i8);
        AndroidMatrixConversions_androidKt.setFrom-tU-YjHk(matrix, this.tmpMatrix);
    }
}
