package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutModifierNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J`\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020/022\u0019\u00104\u001a\u0015\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207\u0018\u000105¢\u0006\u0002\u000882\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020705¢\u0006\u0002\u00088H\u0016JH\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0014\u0008\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020/022\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020705¢\u0006\u0002\u00088H\u0096\u0001J\u0017\u0010:\u001a\u00020/*\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J\u0017\u0010:\u001a\u00020/*\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J\u0017\u0010A\u001a\u00020;*\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008B\u0010CJ\u001a\u0010A\u001a\u00020;*\u00020\u0016H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ\u001a\u0010A\u001a\u00020;*\u00020/H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008D\u0010FJ\u0017\u0010G\u001a\u00020H*\u00020IH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008J\u0010KJ\u000c\u0010L\u001a\u00020(*\u00020(H\u0016J\u0017\u0010M\u001a\u00020\u0016*\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008N\u0010EJ\u0017\u0010M\u001a\u00020\u0016*\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008O\u0010CJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u0017\u0010S\u001a\u00020I*\u00020HH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008T\u0010KJ\u0017\u0010U\u001a\u00020>*\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008V\u0010WJ\u001a\u0010U\u001a\u00020>*\u00020\u0016H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008X\u0010WJ\u001a\u0010U\u001a\u00020>*\u00020/H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008X\u0010YR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u000cR\u0012\u0010\u001c\u001a\u00020\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u001a\u0010$\u001a\u00020%8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008&\u0010#R\u0018\u0010'\u001a\u00020(*\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010+\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Z", d2 = {"Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "coordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "approachNode", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;Landroidx/compose/ui/layout/ApproachLayoutModifierNode;)V", "approachMeasureRequired", "", "getApproachMeasureRequired$ui_release", "()Z", "setApproachMeasureRequired$ui_release", "(Z)V", "getApproachNode", "()Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "setApproachNode", "(Landroidx/compose/ui/layout/ApproachLayoutModifierNode;)V", "getCoordinator", "()Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-msEJaDk", "()J", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toLookaheadCoordinates", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ApproachMeasureScopeImpl implements androidx.compose.ui.layout.ApproachMeasureScope, androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.LookaheadScope {

    public static final int $stable;
    private boolean approachMeasureRequired;
    private androidx.compose.ui.layout.ApproachLayoutModifierNode approachNode;
    private final LayoutModifierNodeCoordinator coordinator;
    static {
    }

    public ApproachMeasureScopeImpl(LayoutModifierNodeCoordinator coordinator, androidx.compose.ui.layout.ApproachLayoutModifierNode approachNode) {
        super();
        this.coordinator = coordinator;
        this.approachNode = approachNode;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public final boolean getApproachMeasureRequired$ui_release() {
        return this.approachMeasureRequired;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public final androidx.compose.ui.layout.ApproachLayoutModifierNode getApproachNode() {
        return this.approachNode;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public final LayoutModifierNodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public float getDensity() {
        return this.coordinator.getDensity();
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public long getLookaheadConstraints-msEJaDk() {
        Constraints lookaheadConstraints-DWUhwKw$ui_release = this.coordinator.getLookaheadConstraints-DWUhwKw$ui_release();
        if (lookaheadConstraints-DWUhwKw$ui_release == null) {
        } else {
            return lookaheadConstraints-DWUhwKw$ui_release.unbox-impl();
        }
        int i = 0;
        IllegalArgumentException $i$a$RequireNotNullApproachMeasureScopeImpl$lookaheadConstraints$1 = new IllegalArgumentException("Error: Lookahead constraints requested before lookahead measure.".toString());
        throw $i$a$RequireNotNullApproachMeasureScopeImpl$lookaheadConstraints$1;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public androidx.compose.ui.layout.LayoutCoordinates getLookaheadScopeCoordinates(androidx.compose.ui.layout.Placeable.PlacementScope $this$lookaheadScopeCoordinates) {
        NodeCoordinator outerCoordinator$ui_release;
        int i;
        LayoutNode lookaheadRoot$ui_release = this.coordinator.getLayoutNode().getLookaheadRoot$ui_release();
        if (lookaheadRoot$ui_release == null) {
        } else {
            if (lookaheadRoot$ui_release.isVirtualLookaheadRoot$ui_release()) {
                outerCoordinator$ui_release = lookaheadRoot$ui_release.getParent$ui_release();
                if (outerCoordinator$ui_release != null) {
                    if (outerCoordinator$ui_release.getInnerCoordinator$ui_release() == null) {
                        outerCoordinator$ui_release = (LayoutNode)lookaheadRoot$ui_release.getChildren$ui_release().get(0).getOuterCoordinator$ui_release();
                    }
                } else {
                }
            } else {
                outerCoordinator$ui_release = lookaheadRoot$ui_release.getOuterCoordinator$ui_release();
            }
            return outerCoordinator$ui_release;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireNotNullApproachMeasureScopeImpl$lookaheadScopeCoordinates$1 = new IllegalArgumentException("Error: Requesting LookaheadScopeCoordinates is not permitted from outside of a LookaheadScope.".toString());
        throw $i$a$RequireNotNullApproachMeasureScopeImpl$lookaheadScopeCoordinates$1;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public long getLookaheadSize-YbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.coordinator.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        androidx.compose.ui.layout.MeasureResult measureResult$ui_release = lookaheadDelegate.getMeasureResult$ui_release();
        final int i = 0;
        return IntSizeKt.IntSize(measureResult$ui_release.getWidth(), measureResult$ui_release.getHeight());
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public boolean isLookingAhead() {
        return 0;
    }

    public androidx.compose.ui.layout.MeasureResult layout(int i, int i2, Map<androidx.compose.ui.layout.AlignmentLine, Integer> map3, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> function14) {
        return this.coordinator.layout(i, i2, map3, function14);
    }

    public androidx.compose.ui.layout.MeasureResult layout(int width, int height, Map<androidx.compose.ui.layout.AlignmentLine, Integer> alignmentLines, Function1<? super androidx.compose.ui.layout.RulerScope, Unit> rulers, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> placementBlock) {
        int i;
        int i2;
        String $i$a$CheckPreconditionLookaheadDelegateKt$checkMeasuredSize$1$iv;
        StringBuilder append;
        String str;
        int i3 = 0;
        i = -16777216;
        if (width & i == 0 && i &= height == 0) {
            i2 = i &= height == 0 ? 1 : 0;
        } else {
        }
        int i7 = 0;
        if (i2 == 0) {
            int i8 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Size(").append(width).append(" x ").append(height).append(") is out of range. Each dimension must be between 0 and 16777215.").toString());
        }
        ApproachMeasureScopeImpl.layout.1 $i$f$checkMeasuredSize = new ApproachMeasureScopeImpl.layout.1(width, height, alignmentLines, rulers, placementBlock, this);
        return (MeasureResult)$i$f$checkMeasuredSize;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public int roundToPx--R2X_6o(long l) {
        return this.coordinator.roundToPx--R2X_6o(l);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public int roundToPx-0680j_4(float f) {
        return this.coordinator.roundToPx-0680j_4(f);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public final void setApproachMeasureRequired$ui_release(boolean <set-?>) {
        this.approachMeasureRequired = <set-?>;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public final void setApproachNode(androidx.compose.ui.layout.ApproachLayoutModifierNode <set-?>) {
        this.approachNode = <set-?>;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public float toDp-GaN1DYA(long l) {
        return this.coordinator.toDp-GaN1DYA(l);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public float toDp-u2uoSUM(float f) {
        return this.coordinator.toDp-u2uoSUM(f);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public float toDp-u2uoSUM(int i) {
        return this.coordinator.toDp-u2uoSUM(i);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public long toDpSize-k-rfVVM(long l) {
        return this.coordinator.toDpSize-k-rfVVM(l);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public androidx.compose.ui.layout.LayoutCoordinates toLookaheadCoordinates(androidx.compose.ui.layout.LayoutCoordinates $this$toLookaheadCoordinates) {
        Object lookaheadLayoutCoordinates;
        if ($this$toLookaheadCoordinates instanceof LookaheadLayoutCoordinates) {
            return $this$toLookaheadCoordinates;
        }
        if (!$this$toLookaheadCoordinates instanceof NodeCoordinator) {
        } else {
            lookaheadLayoutCoordinates = (NodeCoordinator)$this$toLookaheadCoordinates.getLookaheadDelegate();
            if (lookaheadLayoutCoordinates != null && lookaheadLayoutCoordinates.getLookaheadLayoutCoordinates() != null) {
                if (lookaheadLayoutCoordinates.getLookaheadLayoutCoordinates() != null) {
                } else {
                    lookaheadLayoutCoordinates = $this$toLookaheadCoordinates;
                }
            } else {
            }
            return lookaheadLayoutCoordinates;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unsupported LayoutCoordinates: ").append($this$toLookaheadCoordinates).toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public float toPx--R2X_6o(long l) {
        return this.coordinator.toPx--R2X_6o(l);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public float toPx-0680j_4(float f) {
        return this.coordinator.toPx-0680j_4(f);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public Rect toRect(DpRect dpRect) {
        return this.coordinator.toRect(dpRect);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public long toSize-XkaWNTQ(long l) {
        return this.coordinator.toSize-XkaWNTQ(l);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public long toSp-0xMU5do(float f) {
        return this.coordinator.toSp-0xMU5do(f);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public long toSp-kPz2Gy4(float f) {
        return this.coordinator.toSp-kPz2Gy4(f);
    }

    @Override // androidx.compose.ui.layout.ApproachMeasureScope
    public long toSp-kPz2Gy4(int i) {
        return this.coordinator.toSp-kPz2Gy4(i);
    }
}
