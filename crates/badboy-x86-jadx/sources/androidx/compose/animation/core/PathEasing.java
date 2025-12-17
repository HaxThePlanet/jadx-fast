package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import androidx.compose.ui.graphics.Interval;
import androidx.compose.ui.graphics.IntervalTree;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathIterator.ConicEvaluation;
import androidx.compose.ui.graphics.PathSegment;
import androidx.compose.ui.graphics.PathSegment.Type;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0008\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/animation/core/PathEasing;", "Landroidx/compose/animation/core/Easing;", "path", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/Path;)V", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "initializeEasing", "", "transform", "", "fraction", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathEasing implements androidx.compose.animation.core.Easing {

    public static final int $stable;
    private IntervalTree<PathSegment> intervals;
    private final Path path;
    static {
    }

    public PathEasing(Path path) {
        super();
        this.path = path;
    }

    private final void initializeEasing() {
        boolean contains;
        int $i$a$RequirePreconditionPathEasing$initializeEasing$1;
        PathIterator.ConicEvaluation asQuadratics;
        int horizontalBounds$default;
        int i2;
        int i3;
        PathSegment.Type $i$f$getFirstImpl;
        PathSegment.Type $i$a$RequirePreconditionPathEasing$initializeEasing$segmentIntervals$1$1;
        float bits$iv$iv;
        int i;
        IntervalTree intervalTree = new IntervalTree();
        $i$a$RequirePreconditionPathEasing$initializeEasing$1 = 0;
        PathIterator iterator = this.path.iterator(PathIterator.ConicEvaluation.AsQuadratics, 961656599);
        i2 = 1;
        i3 = 0;
        while (iterator.hasNext()) {
            asQuadratics = iterator.next();
            if (asQuadratics.getType() != PathSegment.Type.Close) {
            } else {
            }
            i2 = i3;
            int i10 = 0;
            if (i2 == 0) {
            }
            if (asQuadratics.getType() != PathSegment.Type.Move && asQuadratics.getType() != PathSegment.Type.Done) {
            }
            i2 = 1;
            i3 = 0;
            if (asQuadratics.getType() != PathSegment.Type.Done) {
            }
            horizontalBounds$default = BezierKt.computeHorizontalBounds$default(asQuadratics, new float[5], i3, 4, 0);
            int i12 = 0;
            int i17 = 0;
            $i$f$getFirstImpl = 0;
            i = 0;
            intervalTree.addInterval(Float.intBitsToFloat((int)i15), Float.intBitsToFloat((int)i18), asQuadratics);
            int i13 = 0;
            PreconditionsKt.throwIllegalArgumentException("The path cannot contain a close() command.");
        }
        if (intervalTree.contains(0) && intervalTree.contains(1065353216)) {
            if (intervalTree.contains(1065353216)) {
            } else {
                i2 = i3;
            }
        } else {
        }
        int i7 = 0;
        if (i2 == 0) {
            int i8 = 0;
            PreconditionsKt.throwIllegalArgumentException("The easing path must start at 0.0f and end at 1.0f.");
        }
        this.intervals = intervalTree;
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float fraction) {
        IntervalTree intervals;
        String $i$a$CheckPreconditionPathEasing$transform$1;
        int i = 0;
        if (Float.compare(fraction, i) <= 0) {
            return i;
        }
        int i2 = 1065353216;
        if (Float.compare(fraction, i2) >= 0) {
            return i2;
        }
        if (this.intervals == null) {
            initializeEasing();
        }
        int i3 = 0;
        if (this.intervals == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intervals");
            intervals = i3;
        }
        Object data = IntervalTree.findFirstOverlap$default(intervals, fraction, i, 2, i3).getData();
        int i4 = 0;
        if (data == null) {
        } else {
            float firstRoot = BezierKt.findFirstRoot((PathSegment)data, fraction);
            final int i8 = 0;
            if (naN ^= 1 == 0) {
                int i9 = 0;
                PreconditionsKt.throwIllegalStateException("The easing path is invalid. Make sure it does not contain NaN/Infinity values.");
            }
            return BezierKt.evaluateY(data, firstRoot);
        }
        int i7 = 0;
        PreconditionsKt.throwIllegalStateExceptionForNullCheck("The easing path is invalid. Make sure it is continuous on the x axis.");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}
