package androidx.compose.ui.graphics;

import _COROUTINE.ArtificialStackFrames;
import androidx.graphics.path.PathIterator;
import androidx.graphics.path.PathIterator.ConicEvaluation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0016H\u0096\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0096\u0002J\u0018\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001d", d2 = {"Landroidx/compose/ui/graphics/AndroidPathIterator;", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "implementation", "Landroidx/graphics/path/PathIterator;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "segmentPoints", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/compose/ui/graphics/PathSegment;", "Landroidx/compose/ui/graphics/PathSegment$Type;", "outPoints", "offset", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidPathIterator implements androidx.compose.ui.graphics.PathIterator {

    private final androidx.compose.ui.graphics.PathIterator.ConicEvaluation conicEvaluation;
    private final PathIterator implementation;
    private final androidx.compose.ui.graphics.Path path;
    private final float[] segmentPoints;
    private final float tolerance;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        static {
            int i;
            int ordinal3;
            int ordinal4;
            int ordinal6;
            int ordinal5;
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            i = 1;
            iArr[PathIterator.ConicEvaluation.AsConic.ordinal()] = i;
            int i2 = 2;
            iArr[PathIterator.ConicEvaluation.AsQuadratics.ordinal()] = i2;
            AndroidPathIterator.WhenMappings.$EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[PathSegment.Type.Move.ordinal()] = i;
            iArr2[PathSegment.Type.Line.ordinal()] = i2;
            try {
                iArr2[PathSegment.Type.Quadratic.ordinal()] = 3;
                iArr2[PathSegment.Type.Conic.ordinal()] = 4;
                iArr2[PathSegment.Type.Cubic.ordinal()] = 5;
                AndroidPathIterator.WhenMappings.$EnumSwitchMapping$1 = iArr2;
            } catch (java.lang.NoSuchFieldError e) {
            }
        }
    }
    public AndroidPathIterator(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        PathIterator.ConicEvaluation asQuadratics;
        super();
        this.path = path;
        this.conicEvaluation = conicEvaluation;
        this.tolerance = tolerance;
        this.segmentPoints = new float[8];
        androidx.compose.ui.graphics.Path path2 = getPath();
        int i3 = 0;
        if (path2 instanceof AndroidPath == null) {
        } else {
            switch (i2) {
                case 1:
                    asQuadratics = PathIterator.ConicEvaluation.AsConic;
                    break;
                case 2:
                    asQuadratics = PathIterator.ConicEvaluation.AsQuadratics;
                    break;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
            }
            super((AndroidPath)path2.getInternalPath(), asQuadratics, getTolerance());
            this.implementation = pathIterator;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public int calculateSize(boolean includeConvertedConics) {
        return this.implementation.calculateSize(includeConvertedConics);
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public androidx.compose.ui.graphics.PathIterator.ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public androidx.compose.ui.graphics.Path getPath() {
        return this.path;
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public float getTolerance() {
        return this.tolerance;
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public boolean hasNext() {
        return this.implementation.hasNext();
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public androidx.compose.ui.graphics.PathSegment.Type next(float[] outPoints, int offset) {
        return AndroidPathIterator_androidKt.access$toPathSegmentType(this.implementation.next(outPoints, offset));
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public androidx.compose.ui.graphics.PathSegment next() {
        int i2;
        float[] fArr;
        float f;
        float i;
        float f2;
        final float[] segmentPoints = this.segmentPoints;
        i2 = 0;
        androidx.compose.ui.graphics.PathSegment.Type type = AndroidPathIterator_androidKt.access$toPathSegmentType(this.implementation.next(segmentPoints, i2));
        if (type == PathSegment.Type.Done) {
            return PathSegmentKt.getDoneSegment();
        }
        if (type == PathSegment.Type.Close) {
            return PathSegmentKt.getCloseSegment();
        }
        int i5 = 6;
        i = 5;
        final int i6 = 4;
        final int i7 = 3;
        final int i8 = 2;
        final int i9 = 1;
        switch (i3) {
            case 1:
                fArr = new float[i8];
                fArr[i2] = segmentPoints[i2];
                fArr[i9] = segmentPoints[i9];
                break;
            case 2:
                fArr = new float[i6];
                fArr[i2] = segmentPoints[i2];
                fArr[i9] = segmentPoints[i9];
                fArr[i8] = segmentPoints[i8];
                fArr[i7] = segmentPoints[i7];
                break;
            case 3:
                fArr = new float[i5];
                fArr[i2] = segmentPoints[i2];
                fArr[i9] = segmentPoints[i9];
                fArr[i8] = segmentPoints[i8];
                fArr[i7] = segmentPoints[i7];
                fArr[i6] = segmentPoints[i6];
                fArr[i] = segmentPoints[i];
                break;
            case 4:
                fArr = new float[i5];
                fArr[i2] = segmentPoints[i2];
                fArr[i9] = segmentPoints[i9];
                fArr[i8] = segmentPoints[i8];
                fArr[i7] = segmentPoints[i7];
                fArr[i6] = segmentPoints[i6];
                fArr[i] = segmentPoints[i];
                break;
            case 5:
                fArr = new float[8];
                fArr[i2] = segmentPoints[i2];
                fArr[i9] = segmentPoints[i9];
                fArr[i8] = segmentPoints[i8];
                fArr[i7] = segmentPoints[i7];
                fArr[i6] = segmentPoints[i6];
                fArr[i] = segmentPoints[i];
                fArr[i5] = segmentPoints[i5];
                i2 = 7;
                fArr[i2] = segmentPoints[i2];
                break;
            default:
                fArr = new float[i2];
        }
        f = type == PathSegment.Type.Conic ? segmentPoints[i5] : 0;
        PathSegment pathSegment = new PathSegment(type, fArr, f);
        return pathSegment;
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public Object next() {
        return next();
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}
