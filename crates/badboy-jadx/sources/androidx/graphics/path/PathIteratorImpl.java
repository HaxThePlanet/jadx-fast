package androidx.graphics.path;

import android.app.Notification.Action;
import android.graphics.Path;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008 \u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J#\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0008\u0010\u001b\u001a\u00020\u0014H&J\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0012H&J\u0008\u0010 \u001a\u00020\u0019H&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\"", d2 = {"Landroidx/graphics/path/PathIteratorImpl;", "", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/graphics/path/PathIterator$ConicEvaluation;", "getPath", "()Landroid/graphics/Path;", "pointsData", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "floatsToPoints", "", "Landroid/graphics/PointF;", "type", "Landroidx/graphics/path/PathSegment$Type;", "([FLandroidx/graphics/path/PathSegment$Type;)[Landroid/graphics/PointF;", "hasNext", "next", "Landroidx/graphics/path/PathSegment;", "points", "offset", "peek", "Companion", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PathIteratorImpl {

    private static final androidx.graphics.path.PathIteratorImpl.Companion Companion;
    private final androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation;
    private final Path path;
    private final float[] pointsData;
    private final float tolerance;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/graphics/path/PathIteratorImpl$Companion;", "", "()V", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal4;
            int ordinal3;
            int ordinal5;
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[PathSegment.Type.Move.ordinal()] = 1;
            iArr[PathSegment.Type.Line.ordinal()] = 2;
            iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            iArr[PathSegment.Type.Conic.ordinal()] = 4;
            iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            PathIteratorImpl.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        PathIteratorImpl.Companion companion = new PathIteratorImpl.Companion(0);
        PathIteratorImpl.Companion = companion;
        System.loadLibrary("androidx.graphics.path");
    }

    public PathIteratorImpl(Path path, androidx.graphics.path.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        super();
        this.path = path;
        this.conicEvaluation = conicEvaluation;
        this.tolerance = tolerance;
        this.pointsData = new float[8];
    }

    public PathIteratorImpl(Path path, androidx.graphics.path.PathIterator.ConicEvaluation pathIterator$ConicEvaluation2, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.graphics.path.PathIterator.ConicEvaluation obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? PathIterator.ConicEvaluation.AsQuadratics : obj2;
        obj3 = i4 &= 4 != 0 ? 1048576000 : obj3;
        super(path, obj2, obj3);
    }

    private final PointF[] floatsToPoints(float[] pointsData, androidx.graphics.path.PathSegment.Type type) {
        PointF[] $i$f$emptyArray;
        int pointF3;
        int i3;
        PointF pointF2;
        int i2;
        int pointF4;
        PointF pointF;
        int i;
        int i4;
        int i5;
        int i8 = 5;
        i3 = 4;
        pointF2 = 3;
        i2 = 2;
        pointF4 = 1;
        pointF = 0;
        switch (i6) {
            case 1:
                pointF3 = new PointF(pointsData[pointF], pointsData[pointF4]);
                new PointF[pointF4][pointF] = pointF3;
                break;
            case 2:
                $i$f$emptyArray = new PointF[i2];
                PointF pointF5 = new PointF(pointsData[pointF], pointsData[pointF4]);
                $i$f$emptyArray[pointF] = pointF5;
                pointF3 = new PointF(pointsData[i2], pointsData[pointF2]);
                $i$f$emptyArray[pointF4] = pointF3;
                break;
            case 3:
                $i$f$emptyArray = new PointF[pointF2];
                PointF pointF6 = new PointF(pointsData[pointF], pointsData[pointF4]);
                $i$f$emptyArray[pointF] = pointF6;
                pointF = new PointF(pointsData[i2], pointsData[pointF2]);
                $i$f$emptyArray[pointF4] = pointF;
                pointF2 = new PointF(pointsData[i3], pointsData[i8]);
                $i$f$emptyArray[i2] = pointF2;
                break;
            case 4:
                $i$f$emptyArray = new PointF[i3];
                PointF pointF7 = new PointF(pointsData[pointF], pointsData[pointF4]);
                $i$f$emptyArray[pointF] = pointF7;
                pointF = new PointF(pointsData[i2], pointsData[pointF2]);
                $i$f$emptyArray[pointF4] = pointF;
                pointF4 = new PointF(pointsData[i3], pointsData[i8]);
                $i$f$emptyArray[i2] = pointF4;
                pointF3 = new PointF(pointsData[6], pointsData[7]);
                $i$f$emptyArray[pointF2] = pointF3;
                break;
            default:
                int i7 = 0;
                $i$f$emptyArray = pointF3;
        }
        return $i$f$emptyArray;
    }

    public static androidx.graphics.path.PathSegment.Type next$default(androidx.graphics.path.PathIteratorImpl pathIteratorImpl, float[] f2Arr2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            return pathIteratorImpl.next(f2Arr2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: next");
        throw obj0;
    }

    public abstract int calculateSize(boolean z);

    public final androidx.graphics.path.PathIterator.ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    public final Path getPath() {
        return this.path;
    }

    public final float getTolerance() {
        return this.tolerance;
    }

    public abstract boolean hasNext();

    public abstract androidx.graphics.path.PathSegment.Type next(float[] fArr, int i2);

    public final androidx.graphics.path.PathSegment next() {
        int i2;
        int i;
        androidx.graphics.path.PathSegment.Type next = next(this.pointsData, 0);
        if (next == PathSegment.Type.Done) {
            return PathSegmentUtilities.getDoneSegment();
        }
        if (next == PathSegment.Type.Close) {
            return PathSegmentUtilities.getCloseSegment();
        }
        if (next == PathSegment.Type.Conic) {
            i2 = this.pointsData[6];
        } else {
            i2 = 0;
        }
        PathSegment pathSegment = new PathSegment(next, floatsToPoints(this.pointsData, next), i2);
        return pathSegment;
    }

    public abstract androidx.graphics.path.PathSegment.Type peek();
}
