package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0096\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\nH\u0016J\"\u0010(\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J*\u0010(\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.J\u001a\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\u00081\u00102J\u001a\u00103\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\u00084\u00102J\u001a\u00105\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\u00086\u00102J\u001a\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\u00089\u00102J\"\u0010:\u001a\u00020;2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=H\u0016ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J\u001a\u0010@\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJ\u001a\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\u0008E\u00102R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008 \u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006F", d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "introducesMotionFrameOfReference", "", "getIntroducesMotionFrameOfReference", "()Z", "isAttached", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "()J", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LookaheadLayoutCoordinates implements androidx.compose.ui.layout.LayoutCoordinates {

    public static final int $stable;
    private final LookaheadDelegate lookaheadDelegate;
    static {
    }

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        super();
        this.lookaheadDelegate = lookaheadDelegate;
    }

    private final long getLookaheadOffset-F1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        final int i = 0;
        long zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
        final NodeCoordinator coordinator2 = rootLookaheadDelegate.getCoordinator();
        return Offset.minus-MK-Hz9U(localPositionOf-R5De75A(rootLookaheadDelegate.getCoordinates(), zero-F1C5BW0), zero-F1C5BW0);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public int get(androidx.compose.ui.layout.AlignmentLine alignmentLine) {
        return this.lookaheadDelegate.get(alignmentLine);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean getIntroducesMotionFrameOfReference() {
        return this.lookaheadDelegate.isPlacedUnderMotionFrameOfReference();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public androidx.compose.ui.layout.LayoutCoordinates getParentCoordinates() {
        androidx.compose.ui.node.LookaheadCapablePlaceable wrappedBy$ui_release;
        androidx.compose.ui.layout.LayoutCoordinates coordinates;
        String $i$a$CheckPreconditionLookaheadLayoutCoordinates$parentCoordinates$1;
        final int i = 0;
        if (!isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        wrappedBy$ui_release = getCoordinator().getWrappedBy$ui_release();
        wrappedBy$ui_release = wrappedBy$ui_release.getLookaheadDelegate();
        if (wrappedBy$ui_release != null && wrappedBy$ui_release != null) {
            wrappedBy$ui_release = wrappedBy$ui_release.getLookaheadDelegate();
            if (wrappedBy$ui_release != null) {
                coordinates = wrappedBy$ui_release.getCoordinates();
            } else {
                coordinates = 0;
            }
        } else {
        }
        return coordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public androidx.compose.ui.layout.LayoutCoordinates getParentLayoutCoordinates() {
        int coordinates;
        String $i$a$CheckPreconditionLookaheadLayoutCoordinates$parentLayoutCoordinates$1;
        LookaheadDelegate lookaheadDelegate;
        int i = 0;
        if (!isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator wrappedBy$ui_release = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy$ui_release();
        coordinates = 0;
        $i$a$CheckPreconditionLookaheadLayoutCoordinates$parentLayoutCoordinates$1 = 0;
        lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate();
        if (wrappedBy$ui_release != null && lookaheadDelegate != null) {
            $i$a$CheckPreconditionLookaheadLayoutCoordinates$parentLayoutCoordinates$1 = 0;
            lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate();
            if (lookaheadDelegate != null) {
                coordinates = lookaheadDelegate.getCoordinates();
            }
        }
        return coordinates;
    }

    public Set<androidx.compose.ui.layout.AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long getSize-YbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        final int i = 0;
        return IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long localPositionOf-R5De75A(androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return localPositionOf-S_NoaFU(sourceCoordinates, relativeToSource, obj5);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long localPositionOf-S_NoaFU(androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        long lookaheadDelegate2;
        float commonAncestor$ui_release;
        androidx.compose.ui.node.LookaheadCapablePlaceable lookaheadDelegate3;
        int i3;
        LookaheadDelegate rootLookaheadDelegate2;
        long plus-qkQi6aY;
        long positionIn-iSbpLlY$ui_release;
        LookaheadDelegate rootLookaheadDelegate;
        long lookaheadPosition;
        int i;
        NodeCoordinator wrappedBy$ui_release2;
        NodeCoordinator wrappedBy$ui_release;
        int i2;
        LookaheadDelegate lookaheadDelegate;
        NodeCoordinator nodeCoordinator;
        final Object obj = this;
        final Object obj2 = sourceCoordinates;
        final int i4 = obj22;
        if (obj2 instanceof LookaheadLayoutCoordinates) {
            lookaheadDelegate2 = obj3.lookaheadDelegate;
            lookaheadDelegate2.getCoordinator().onCoordinatesUsed$ui_release();
            commonAncestor$ui_release = obj.getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate2.getCoordinator());
            lookaheadDelegate3 = commonAncestor$ui_release.getLookaheadDelegate();
            if (lookaheadDelegate3 != null) {
                i3 = 0;
                rootLookaheadDelegate = i4 ^ 1;
                long minus-qkQi6aY = IntOffset.minus-qkQi6aY(IntOffset.plus-qkQi6aY(lookaheadDelegate2.positionIn-iSbpLlY$ui_release(lookaheadDelegate3, i4 ^ 1), obj8), obj8);
                wrappedBy$ui_release2 = 0;
                lookaheadPosition = OffsetKt.Offset((float)x-impl2, (float)y-impl2);
                lookaheadDelegate = lookaheadDelegate2;
                nodeCoordinator = commonAncestor$ui_release;
            } else {
                lookaheadDelegate3 = commonAncestor$ui_release;
                i3 = 0;
                rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate2);
                rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(obj.lookaheadDelegate);
                i = i4 ^ 1;
                long minus-qkQi6aY2 = IntOffset.minus-qkQi6aY(IntOffset.plus-qkQi6aY(IntOffset.plus-qkQi6aY(lookaheadDelegate2.positionIn-iSbpLlY$ui_release(rootLookaheadDelegate2, i4 ^ 1), obj9), obj9), obj9);
                i2 = 0;
                lookaheadDelegate = lookaheadDelegate2;
                nodeCoordinator = commonAncestor$ui_release;
                commonAncestor$ui_release = (float)y-impl;
                wrappedBy$ui_release2 = rootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
                Intrinsics.checkNotNull(wrappedBy$ui_release2);
                wrappedBy$ui_release = rootLookaheadDelegate2.getCoordinator().getWrappedBy$ui_release();
                Intrinsics.checkNotNull(wrappedBy$ui_release);
                lookaheadPosition = wrappedBy$ui_release2.localPositionOf-S_NoaFU((LayoutCoordinates)wrappedBy$ui_release, OffsetKt.Offset((float)x-impl, commonAncestor$ui_release), commonAncestor$ui_release);
            }
            return lookaheadPosition;
        }
        LookaheadDelegate rootLookaheadDelegate3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(obj.lookaheadDelegate);
        return Offset.plus-MK-Hz9U(obj.localPositionOf-S_NoaFU((LayoutCoordinates)rootLookaheadDelegate3.getLookaheadLayoutCoordinates(), relativeToSource, obj6), obj8);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long localToRoot-MK-Hz9U(long relativeToLocal) {
        return getCoordinator().localToRoot-MK-Hz9U(Offset.plus-MK-Hz9U(relativeToLocal, obj5));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long localToScreen-MK-Hz9U(long relativeToLocal) {
        return getCoordinator().localToScreen-MK-Hz9U(Offset.plus-MK-Hz9U(relativeToLocal, obj5));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long localToWindow-MK-Hz9U(long relativeToLocal) {
        return getCoordinator().localToWindow-MK-Hz9U(Offset.plus-MK-Hz9U(relativeToLocal, obj5));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long screenToLocal-MK-Hz9U(long relativeToScreen) {
        return Offset.plus-MK-Hz9U(getCoordinator().screenToLocal-MK-Hz9U(relativeToScreen), obj1);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public void transformFrom-EL8BTi8(androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, float[] matrix) {
        getCoordinator().transformFrom-EL8BTi8(sourceCoordinates, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public void transformToScreen-58bKbWc(float[] matrix) {
        getCoordinator().transformToScreen-58bKbWc(matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long windowToLocal-MK-Hz9U(long relativeToWindow) {
        return Offset.plus-MK-Hz9U(getCoordinator().windowToLocal-MK-Hz9U(relativeToWindow), obj1);
    }
}
