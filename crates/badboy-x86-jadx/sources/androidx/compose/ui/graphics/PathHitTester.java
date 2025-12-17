package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0003\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"Landroidx/compose/ui/graphics/PathHitTester;", "", "()V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "curves", "", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "path", "Landroidx/compose/ui/graphics/Path;", "roots", "tolerance", "", "contains", "", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "updatePath", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathHitTester {

    private Rect bounds;
    private final float[] curves;
    private final androidx.compose.ui.graphics.IntervalTree<androidx.compose.ui.graphics.PathSegment> intervals;
    private androidx.compose.ui.graphics.Path path;
    private final float[] roots;
    private float tolerance = 0.5f;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal3;
            int ordinal4;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[PathSegment.Type.Line.ordinal()] = 1;
            iArr[PathSegment.Type.Quadratic.ordinal()] = 2;
            iArr[PathSegment.Type.Cubic.ordinal()] = 3;
            iArr[PathSegment.Type.Done.ordinal()] = 4;
            PathHitTester.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public PathHitTester() {
        super();
        this.path = PathHitTesterKt.access$getEmptyPath$p();
        int i = 1056964608;
        this.bounds = Rect.Companion.getZero();
        IntervalTree intervalTree = new IntervalTree();
        this.intervals = intervalTree;
        this.curves = new float[20];
        this.roots = new float[2];
    }

    public static void updatePath$default(androidx.compose.ui.graphics.PathHitTester pathHitTester, androidx.compose.ui.graphics.Path path2, float f3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1056964608;
        }
        pathHitTester.updatePath(path2, obj2);
    }

    public final boolean contains-k-4lQ0M(long position) {
        int points;
        androidx.compose.ui.graphics.IntervalTree.Node left;
        androidx.compose.ui.graphics.IntervalTree.Node right;
        boolean contains-k-4lQ0M;
        long l;
        int winding;
        Object node;
        androidx.compose.ui.graphics.IntervalTree.Node size;
        androidx.compose.ui.graphics.IntervalTree.Node last;
        androidx.compose.ui.graphics.IntervalTree.Node node2;
        boolean overlaps;
        int i;
        Object data;
        int i2;
        int isInverse2;
        int isInverse;
        int quadraticWinding;
        int[] $EnumSwitchMapping$0;
        final Object obj = this;
        points = 0;
        if (!obj.path.isEmpty()) {
            l = position;
            if (!obj.bounds.contains-k-4lQ0M(l)) {
                i2 = points;
                return i2;
            } else {
                int i4 = 0;
                float $i$f$component1Impl = Offset.getX-impl(l);
                int i5 = 0;
                float $i$f$component2Impl = Offset.getY-impl(l);
                final float[] curves = obj.curves;
                final float[] roots = obj.roots;
                winding = 0;
                androidx.compose.ui.graphics.IntervalTree intervals = obj.intervals;
                final float f = $i$f$component2Impl;
                final int i8 = 0;
                if (IntervalTree.access$getRoot$p(intervals) != IntervalTree.access$getTerminator$p(intervals)) {
                    node = IntervalTree.access$getStack$p(intervals);
                    node.add(IntervalTree.access$getRoot$p(intervals));
                    while (node.size() > 0) {
                        last = CollectionsKt.removeLast((List)node);
                        if ((IntervalTree.Node)last.overlaps($i$f$component2Impl, f)) {
                        } else {
                        }
                        isInverse = points;
                        if (last.getLeft() != IntervalTree.access$getTerminator$p(intervals) && Float.compare(max, $i$f$component2Impl) >= 0) {
                        }
                        if (last.getRight() != IntervalTree.access$getTerminator$p(intervals) && Float.compare(min, f) <= 0) {
                        }
                        points = isInverse;
                        if (Float.compare(min, f) <= 0) {
                        }
                        node.add(last.getRight());
                        if (Float.compare(max, $i$f$component2Impl) >= 0) {
                        }
                        node.add(last.getLeft());
                        i = 0;
                        data = (Interval)last.getData();
                        Intrinsics.checkNotNull(data);
                        isInverse = points;
                        points = (PathSegment)data.getPoints();
                        winding += quadraticWinding;
                        winding += quadraticWinding;
                        winding += quadraticWinding;
                    }
                    isInverse2 = points;
                    node.clear();
                } else {
                    isInverse2 = points;
                }
                if (PathFillType.equals-impl0(obj.path.getFillType-Rg-k1Os(), PathFillType.Companion.getEvenOdd-Rg-k1Os())) {
                    winding &= 1;
                }
                if (winding != 0) {
                    return 1;
                }
            }
            return 0;
        }
        l = position;
        i2 = points;
    }

    public final void updatePath(androidx.compose.ui.graphics.Path path, float tolerance) {
        androidx.compose.ui.graphics.PathSegment next;
        int bits$iv$iv;
        int[] intervals;
        int i;
        float bits$iv$iv2;
        long l;
        this.path = path;
        this.tolerance = tolerance;
        this.bounds = path.getBounds();
        this.intervals.clear();
        androidx.compose.ui.graphics.PathIterator iterator2 = path.iterator(PathIterator.ConicEvaluation.AsQuadratics, tolerance);
        for (Object next : iterator2) {
            long verticalBounds$default = BezierKt.computeVerticalBounds$default(next, this.curves, 0, 4, 0);
            int i7 = 0;
            int i12 = 0;
            i = 0;
            int i5 = 0;
            this.intervals.addInterval(Float.intBitsToFloat((int)i10), Float.intBitsToFloat((int)i2), next);
        }
    }
}
