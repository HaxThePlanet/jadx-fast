package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B=\u00126\u0010\u0003\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00028\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00028\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0018J\u0006\u0010\u001b\u001a\u00020\nR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R>\u0010\u0003\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/ui/platform/LayerMatrixCache;", "T", "", "getMatrix", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "target", "Landroid/graphics/Matrix;", "matrix", "", "(Lkotlin/jvm/functions/Function2;)V", "androidMatrixCache", "inverseMatrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "isDirty", "", "isInverseDirty", "isInverseValid", "matrixCache", "previousAndroidMatrix", "calculateInverseMatrix", "calculateInverseMatrix-bWbORWo", "(Ljava/lang/Object;)[F", "calculateMatrix", "calculateMatrix-GrdbGEg", "invalidate", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayerMatrixCache<T>  {

    public static final int $stable = 8;
    private Matrix androidMatrixCache;
    private final Function2<T, Matrix, Unit> getMatrix;
    private float[] inverseMatrixCache;
    private boolean isDirty = true;
    private boolean isInverseDirty = true;
    private boolean isInverseValid = true;
    private float[] matrixCache;
    private Matrix previousAndroidMatrix;
    static {
        final int i = 8;
    }

    public LayerMatrixCache(Function2<? super T, ? super Matrix, Unit> getMatrix) {
        super();
        this.getMatrix = getMatrix;
        final int i = 1;
    }

    public final float[] calculateInverseMatrix-bWbORWo(T target) {
        float[] inverseMatrixCache;
        int i;
        float[] fArr;
        boolean isInverseDirty;
        int i2;
        i = 0;
        if (this.inverseMatrixCache == null) {
            i2 = 0;
            this.inverseMatrixCache = Matrix.constructor-impl$default(i, 1, i);
        }
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.invertTo-JiSxe2E(calculateMatrix-GrdbGEg(target), inverseMatrixCache);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            i = inverseMatrixCache;
        }
        return i;
    }

    public final float[] calculateMatrix-GrdbGEg(T target) {
        float[] constructor-impl$default;
        float[] fArr;
        Matrix androidMatrixCache;
        int i;
        int equal;
        if (this.matrixCache == null) {
            int i3 = 0;
            i = 0;
            this.matrixCache = Matrix.constructor-impl$default(i3, 1, i3);
        }
        if (!this.isDirty) {
            return constructor-impl$default;
        }
        if (this.androidMatrixCache == null) {
            androidMatrixCache = new Matrix();
            equal = 0;
            this.androidMatrixCache = androidMatrixCache;
        }
        this.getMatrix.invoke(target, androidMatrixCache);
        Matrix previousAndroidMatrix = this.previousAndroidMatrix;
        if (previousAndroidMatrix != null) {
            if (!Intrinsics.areEqual(androidMatrixCache, previousAndroidMatrix)) {
                AndroidMatrixConversions_androidKt.setFrom-tU-YjHk(constructor-impl$default, androidMatrixCache);
                this.androidMatrixCache = previousAndroidMatrix;
                this.previousAndroidMatrix = androidMatrixCache;
            }
        } else {
        }
        this.isDirty = false;
        return constructor-impl$default;
    }

    public final void invalidate() {
        final int i = 1;
        this.isDirty = i;
        this.isInverseDirty = i;
    }
}
