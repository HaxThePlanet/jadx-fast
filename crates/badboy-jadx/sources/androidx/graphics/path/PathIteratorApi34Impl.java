package androidx.graphics.path;

import android.graphics.Path;
import android.graphics.PathIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0008\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/graphics/path/PathIteratorApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "conicConverter", "Landroidx/graphics/path/ConicConverter;", "platformIterator", "Landroid/graphics/PathIterator;", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "offset", "peek", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathIteratorApi34Impl extends androidx.graphics.path.PathIteratorImpl {

    private final androidx.graphics.path.ConicConverter conicConverter;
    private final PathIterator platformIterator;
    public PathIteratorApi34Impl(Path path, androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        super(path, conicEvaluation, tolerance);
        PathIterator pathIterator = path.getPathIterator();
        Intrinsics.checkNotNullExpressionValue(pathIterator, "path.pathIterator");
        this.platformIterator = pathIterator;
        ConicConverter conicConverter = new ConicConverter();
        this.conicConverter = conicConverter;
    }

    public PathIteratorApi34Impl(Path path, androidx.graphics.path.PathIterator.ConicEvaluation pathIterator$ConicEvaluation2, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.graphics.path.PathIterator.ConicEvaluation obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? PathIterator.ConicEvaluation.AsQuadratics : obj2;
        obj3 = i4 &= 4 != 0 ? 1048576000 : obj3;
        super(path, obj2, obj3);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public int calculateSize(boolean includeConvertedConics) {
        androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation;
        int i;
        androidx.graphics.path.PathIterator.ConicEvaluation asQuadratics;
        int numVerbs;
        int next;
        androidx.graphics.path.ConicConverter conicConverter;
        int quadraticCount;
        float tolerance;
        int i4;
        int i2;
        int i5;
        int i3;
        final int i6 = 0;
        if (includeConvertedConics && getConicEvaluation() == PathIterator.ConicEvaluation.AsQuadratics) {
            i = getConicEvaluation() == PathIterator.ConicEvaluation.AsQuadratics ? 1 : i6;
        } else {
        }
        numVerbs = 0;
        PathIterator pathIterator = getPath().getPathIterator();
        Intrinsics.checkNotNullExpressionValue(pathIterator, "path.pathIterator");
        final float[] fArr = new float[8];
        while (pathIterator.hasNext()) {
            if (pathIterator.next(fArr, i6) == 3 && i != 0) {
            } else {
            }
            numVerbs++;
            if (i != 0) {
            } else {
            }
            conicConverter = this.conicConverter;
            i3 = 0;
            ConicConverter.convert$default(conicConverter, fArr, fArr[6], getTolerance(), 0, 8, 0);
            numVerbs += quadraticCount;
        }
        return numVerbs;
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public boolean hasNext() {
        return this.platformIterator.hasNext();
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public androidx.graphics.path.PathSegment.Type next(float[] points, int offset) {
        Enum conicEvaluation;
        androidx.graphics.path.PathIterator.ConicEvaluation asQuadratics;
        Intrinsics.checkNotNullParameter(points, "points");
        if (this.conicConverter.getCurrentQuadratic() < this.conicConverter.getQuadraticCount()) {
            this.conicConverter.nextQuadratic(points, offset);
            return PathSegment.Type.Quadratic;
        }
        androidx.graphics.path.PathSegment.Type type = PathIteratorImplKt.access$platformToAndroidXSegmentType(this.platformIterator.next(points, offset));
        androidx.graphics.path.ConicConverter conicConverter4 = this.conicConverter;
        int i = 0;
        conicConverter4.convert(points, points[offset + 6], getTolerance(), offset);
        if (type == PathSegment.Type.Conic && getConicEvaluation() == PathIterator.ConicEvaluation.AsQuadratics && conicConverter4.getQuadraticCount() > 0) {
            if (getConicEvaluation() == PathIterator.ConicEvaluation.AsQuadratics) {
                conicConverter4 = this.conicConverter;
                i = 0;
                conicConverter4.convert(points, points[offset + 6], getTolerance(), offset);
                if (conicConverter4.getQuadraticCount() > 0) {
                    conicConverter4.nextQuadratic(points, offset);
                }
                return PathSegment.Type.Quadratic;
            }
        }
        return type;
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public androidx.graphics.path.PathSegment.Type peek() {
        return PathIteratorImplKt.access$platformToAndroidXSegmentType(this.platformIterator.peek());
    }
}
