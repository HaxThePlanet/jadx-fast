package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.PaintingStyle.Companion;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScopeImpl;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u0000 G2\u00020\u0001:\u0002GHB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0008\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020$H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\u00080\u00101J\u0010\u00102\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u0010,\u001a\u00020$H\u0016J\u0008\u00104\u001a\u00020(H\u0002J\u001a\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\u0008\u00108\u001a\u0004\u0018\u000109H\u0016J=\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0019\u0010?\u001a\u0015\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020(\u0018\u00010@¢\u0006\u0002\u0008BH\u0014ø\u0001\u0000¢\u0006\u0004\u0008C\u0010DJ*\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010E\u001a\u000209H\u0014ø\u0001\u0000¢\u0006\u0004\u0008C\u0010FR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\u0008!\u0010\"\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006I", d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "measureNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "approachMeasureScope", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "value", "layoutModifierNode", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw$ui_release", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM$ui_release", "(Landroidx/compose/ui/unit/Constraints;)V", "<set-?>", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrappedNonNull", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onAfterPlaceAt", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Companion", "LookaheadDelegateForLayoutModifierNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutModifierNodeCoordinator extends androidx.compose.ui.node.NodeCoordinator {

    public static final int $stable;
    public static final androidx.compose.ui.node.LayoutModifierNodeCoordinator.Companion Companion;
    private static final Paint modifierBoundsPaint;
    private ApproachMeasureScopeImpl approachMeasureScope;
    private androidx.compose.ui.node.LayoutModifierNode layoutModifierNode;
    private Constraints lookaheadConstraints;
    private androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = null;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.access$getModifierBoundsPaint$cp();
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class LookaheadDelegateForLayoutModifierNode extends androidx.compose.ui.node.LookaheadDelegate {

        final androidx.compose.ui.node.LayoutModifierNodeCoordinator this$0;
        public LookaheadDelegateForLayoutModifierNode(androidx.compose.ui.node.LayoutModifierNodeCoordinator this$0) {
            this.this$0 = this$0;
            super((NodeCoordinator)this$0);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int i = LayoutModifierNodeCoordinatorKt.access$calculateAlignmentAndPlaceChildAsNeeded((LookaheadCapablePlaceable)this, alignmentLine);
            final int i3 = 0;
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(i));
            return i;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int maxIntrinsicHeight(int width) {
            final int i = 0;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return this.this$0.getLayoutModifierNode().maxIntrinsicHeight((IntrinsicMeasureScope)this, (IntrinsicMeasurable)lookaheadDelegate, width);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int maxIntrinsicWidth(int height) {
            final int i = 0;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return this.this$0.getLayoutModifierNode().maxIntrinsicWidth((IntrinsicMeasureScope)this, (IntrinsicMeasurable)lookaheadDelegate, height);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public Placeable measure-BRTryo0(long constraints) {
            final androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this;
            androidx.compose.ui.node.LayoutModifierNodeCoordinator this$0 = this.this$0;
            final int i = 0;
            LookaheadDelegate.access$setMeasurementConstraints-BRTryo0((LookaheadDelegate)lookaheadDelegate, constraints);
            final int i2 = 0;
            this$0.setLookaheadConstraints-_Sx5XlM$ui_release(Constraints.box-impl(constraints));
            final int i3 = 0;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate2 = this$0.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            LookaheadDelegate.access$set_measureResult(lookaheadDelegate, this$0.getLayoutModifierNode().measure-3p2s80s((MeasureScope)this, (Measurable)lookaheadDelegate2, constraints));
            return (Placeable)lookaheadDelegate;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int minIntrinsicHeight(int width) {
            final int i = 0;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return this.this$0.getLayoutModifierNode().minIntrinsicHeight((IntrinsicMeasureScope)this, (IntrinsicMeasurable)lookaheadDelegate, width);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int minIntrinsicWidth(int height) {
            final int i = 0;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return this.this$0.getLayoutModifierNode().minIntrinsicWidth((IntrinsicMeasureScope)this, (IntrinsicMeasurable)lookaheadDelegate, height);
        }
    }
    static {
        LayoutModifierNodeCoordinator.Companion companion = new LayoutModifierNodeCoordinator.Companion(0);
        LayoutModifierNodeCoordinator.Companion = companion;
        Paint paint = AndroidPaint_androidKt.Paint();
        Paint paint2 = paint;
        final int i2 = 0;
        paint2.setColor-8_81llA(Color.Companion.getBlue-0d7_KjU());
        paint2.setStrokeWidth(1065353216);
        paint2.setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
        LayoutModifierNodeCoordinator.modifierBoundsPaint = paint;
    }

    public LayoutModifierNodeCoordinator(androidx.compose.ui.node.LayoutNode layoutNode, androidx.compose.ui.node.LayoutModifierNode measureNode) {
        Object node;
        int approachMeasureScopeImpl;
        int i;
        super(layoutNode);
        this.layoutModifierNode = measureNode;
        if (layoutNode.getLookaheadRoot$ui_release() != null) {
            LayoutModifierNodeCoordinator.LookaheadDelegateForLayoutModifierNode lookaheadDelegateForLayoutModifierNode = new LayoutModifierNodeCoordinator.LookaheadDelegateForLayoutModifierNode(this);
        }
        int i2 = approachMeasureScopeImpl;
        int i3 = 0;
        int i5 = 0;
        i = kindSet$ui_release &= $i$f$getApproachMeasureOLwlOKw != 0 ? 1 : 0;
        if (i != 0) {
            Intrinsics.checkNotNull(measureNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, (ApproachLayoutModifierNode)measureNode);
        } else {
        }
        this.approachMeasureScope = approachMeasureScopeImpl;
    }

    public static final ApproachMeasureScopeImpl access$getApproachMeasureScope$p(androidx.compose.ui.node.LayoutModifierNodeCoordinator $this) {
        return $this.approachMeasureScope;
    }

    public static final Paint access$getModifierBoundsPaint$cp() {
        return LayoutModifierNodeCoordinator.modifierBoundsPaint;
    }

    private final void onAfterPlaceAt() {
        int i4;
        ApproachLayoutModifierNode approachNode;
        int i;
        androidx.compose.ui.node.NodeCoordinator wrappedNonNull;
        int i2;
        int i3;
        boolean placementApproachInProgress;
        Object size-YbymL2g$ui_release2;
        int box-impl;
        long size-YbymL2g$ui_release;
        if (isShallowPlacing$ui_release()) {
        }
        onPlaced();
        ApproachMeasureScopeImpl approachMeasureScope = this.approachMeasureScope;
        final int i5 = 0;
        if (approachMeasureScope != null) {
            i4 = 0;
            i = 0;
            i2 = 0;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (!approachMeasureScope.getApproachNode().isPlacementApproachInProgress(getPlacementScope(), (LayoutCoordinates)lookaheadDelegate.getLookaheadLayoutCoordinates()) && !approachMeasureScope.getApproachMeasureRequired$ui_release()) {
                if (!approachMeasureScope.getApproachMeasureRequired$ui_release()) {
                    androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
                    box-impl = 0;
                    if (lookaheadDelegate2 != null) {
                        size-YbymL2g$ui_release2 = IntSize.box-impl(lookaheadDelegate2.getSize-YbymL2g$ui_release());
                    } else {
                        size-YbymL2g$ui_release2 = box-impl;
                    }
                    if (IntSize.equals-impl(getSize-YbymL2g(), obj8)) {
                        size-YbymL2g$ui_release2 = getWrappedNonNull().getLookaheadDelegate();
                        if (size-YbymL2g$ui_release2 != null) {
                            box-impl = IntSize.box-impl(size-YbymL2g$ui_release2.getSize-YbymL2g$ui_release());
                        }
                        i3 = IntSize.equals-impl(getWrappedNonNull().getSize-YbymL2g(), obj8) ? 1 : i5;
                    } else {
                    }
                } else {
                }
            } else {
            }
            getWrappedNonNull().setForcePlaceWithLookaheadOffset$ui_release(i3);
        }
        getMeasureResult$ui_release().placeChildren();
        getWrappedNonNull().setForcePlaceWithLookaheadOffset$ui_release(i5);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        int cachedAlignmentLine$ui_release;
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            cachedAlignmentLine$ui_release = lookaheadDelegate.getCachedAlignmentLine$ui_release(alignmentLine);
        } else {
            cachedAlignmentLine$ui_release = LayoutModifierNodeCoordinatorKt.access$calculateAlignmentAndPlaceChildAsNeeded((LookaheadCapablePlaceable)this, alignmentLine);
        }
        return cachedAlignmentLine$ui_release;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void ensureLookaheadDelegateCreated() {
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegateForLayoutModifierNode;
        if (getLookaheadDelegate() == null) {
            lookaheadDelegateForLayoutModifierNode = new LayoutModifierNodeCoordinator.LookaheadDelegateForLayoutModifierNode(this);
            setLookaheadDelegate((LookaheadDelegate)lookaheadDelegateForLayoutModifierNode);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final androidx.compose.ui.node.LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final Constraints getLookaheadConstraints-DWUhwKw$ui_release() {
        return this.lookaheadConstraints;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public androidx.compose.ui.node.LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final androidx.compose.ui.node.NodeCoordinator getWrappedNonNull() {
        final androidx.compose.ui.node.NodeCoordinator wrapped$ui_release = getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int maxIntrinsicHeight(int width) {
        Object approachMeasureScope;
        int i;
        int $this$maxIntrinsicHeight_u24lambda_u2416_u24lambda_u2415;
        int wrappedNonNull2;
        ApproachMeasureScopeImpl approachMeasureScopeImpl;
        androidx.compose.ui.node.NodeCoordinator wrappedNonNull;
        approachMeasureScope = this.approachMeasureScope;
        if (approachMeasureScope != null) {
            i = 0;
            wrappedNonNull2 = 0;
            $this$maxIntrinsicHeight_u24lambda_u2416_u24lambda_u2415 = approachMeasureScope.getApproachNode().maxApproachIntrinsicHeight((ApproachIntrinsicMeasureScope)approachMeasureScope, (IntrinsicMeasurable)getWrappedNonNull(), width);
        } else {
            i = 0;
            $this$maxIntrinsicHeight_u24lambda_u2416_u24lambda_u2415 = this.layoutModifierNode.maxIntrinsicHeight((IntrinsicMeasureScope)this, (IntrinsicMeasurable)getWrappedNonNull(), width);
        }
        return $this$maxIntrinsicHeight_u24lambda_u2416_u24lambda_u2415;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int maxIntrinsicWidth(int height) {
        Object approachMeasureScope;
        int i;
        int $this$maxIntrinsicWidth_u24lambda_u2410_u24lambda_u249;
        int wrappedNonNull;
        ApproachMeasureScopeImpl approachMeasureScopeImpl;
        androidx.compose.ui.node.NodeCoordinator wrappedNonNull2;
        approachMeasureScope = this.approachMeasureScope;
        if (approachMeasureScope != null) {
            i = 0;
            wrappedNonNull = 0;
            $this$maxIntrinsicWidth_u24lambda_u2410_u24lambda_u249 = approachMeasureScope.getApproachNode().maxApproachIntrinsicWidth((ApproachIntrinsicMeasureScope)approachMeasureScope, (IntrinsicMeasurable)getWrappedNonNull(), height);
        } else {
            i = 0;
            $this$maxIntrinsicWidth_u24lambda_u2410_u24lambda_u249 = this.layoutModifierNode.maxIntrinsicWidth((IntrinsicMeasureScope)this, (IntrinsicMeasurable)getWrappedNonNull(), height);
        }
        return $this$maxIntrinsicWidth_u24lambda_u2410_u24lambda_u249;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Placeable measure-BRTryo0(long constraints) {
        long unbox-impl;
        Object layoutModifierNode;
        int i2;
        ApproachLayoutModifierNode approachNode;
        int wrappedNonNull;
        int i3;
        boolean approachMeasureRequired$ui_release2;
        boolean measurementApproachInProgress-ozmzZPI;
        MeasureResult approachMeasure-3p2s80s;
        int i;
        MeasureResult measure-3p2s80s;
        boolean approachMeasureRequired$ui_release;
        int height;
        int box-impl;
        final Object obj = this;
        if (obj.getForceMeasureWithLookaheadConstraints$ui_release()) {
            Constraints lookaheadConstraints = obj.lookaheadConstraints;
            if (lookaheadConstraints == null) {
            } else {
                unbox-impl = lookaheadConstraints.unbox-impl();
                final int i5 = 0;
                NodeCoordinator.access$setMeasurementConstraints-BRTryo0((NodeCoordinator)obj, unbox-impl);
                int i6 = 0;
                layoutModifierNode = LayoutModifierNodeCoordinator.access$getApproachMeasureScope$p(obj);
                if (layoutModifierNode != null) {
                    i2 = 0;
                    approachNode = layoutModifierNode.getApproachNode();
                    wrappedNonNull = 0;
                    i = 0;
                    int i7 = 1;
                    if (!approachNode.isMeasurementApproachInProgress-ozmzZPI(layoutModifierNode.getLookaheadSize-YbymL2g())) {
                        if (!Constraints.equals-impl(unbox-impl, obj2)) {
                            i3 = i7;
                        } else {
                            i3 = i;
                        }
                    } else {
                    }
                    layoutModifierNode.setApproachMeasureRequired$ui_release(i3);
                    if (!layoutModifierNode.getApproachMeasureRequired$ui_release()) {
                        obj.getWrappedNonNull().setForceMeasureWithLookaheadConstraints$ui_release(i7);
                    }
                    approachMeasure-3p2s80s = approachNode.approachMeasure-3p2s80s((ApproachMeasureScope)layoutModifierNode, (Measurable)obj.getWrappedNonNull(), unbox-impl);
                    obj.getWrappedNonNull().setForceMeasureWithLookaheadConstraints$ui_release(i);
                    androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = obj.getLookaheadDelegate();
                    Intrinsics.checkNotNull(lookaheadDelegate);
                    androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate2 = obj.getLookaheadDelegate();
                    Intrinsics.checkNotNull(lookaheadDelegate2);
                    if (approachMeasure-3p2s80s.getWidth() == lookaheadDelegate.getWidth() && approachMeasure-3p2s80s.getHeight() == lookaheadDelegate2.getHeight()) {
                        lookaheadDelegate2 = obj.getLookaheadDelegate();
                        Intrinsics.checkNotNull(lookaheadDelegate2);
                        if (approachMeasure-3p2s80s.getHeight() == lookaheadDelegate2.getHeight()) {
                            i = i7;
                        } else {
                        }
                    } else {
                    }
                    if (!layoutModifierNode.getApproachMeasureRequired$ui_release()) {
                        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate3 = obj.getWrappedNonNull().getLookaheadDelegate();
                        if (lookaheadDelegate3 != null) {
                            box-impl = IntSize.box-impl(lookaheadDelegate3.getSize-YbymL2g$ui_release());
                        } else {
                            box-impl = 0;
                        }
                        if (IntSize.equals-impl(obj.getWrappedNonNull().getSize-YbymL2g(), height) && i == 0) {
                            if (i == 0) {
                                measure-3p2s80s = new LayoutModifierNodeCoordinator.measure.1.1.1.1(approachMeasure-3p2s80s, obj);
                            } else {
                                measure-3p2s80s = approachMeasure-3p2s80s;
                            }
                        } else {
                        }
                    } else {
                    }
                    if (measure-3p2s80s == null) {
                        i2 = 0;
                        measure-3p2s80s = obj.getLayoutModifierNode().measure-3p2s80s((MeasureScope)obj, (Measurable)obj.getWrappedNonNull(), unbox-impl);
                    }
                } else {
                }
                obj.setMeasureResult$ui_release(measure-3p2s80s);
                Object $i$a$PerformingMeasureK40F9xALayoutModifierNodeCoordinator$measure$1 = obj;
                obj.onMeasured();
                return (Placeable)obj;
            }
            int i4 = 0;
            IllegalArgumentException $i$a$RequireNotNullLayoutModifierNodeCoordinator$measure$constraints$1 = new IllegalArgumentException("Lookahead constraints cannot be null in approach pass.".toString());
            throw $i$a$RequireNotNullLayoutModifierNodeCoordinator$measure$constraints$1;
        }
        unbox-impl = constraints;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int minIntrinsicHeight(int width) {
        Object approachMeasureScope;
        int i;
        int $this$minIntrinsicHeight_u24lambda_u2413_u24lambda_u2412;
        int wrappedNonNull2;
        ApproachMeasureScopeImpl approachMeasureScopeImpl;
        androidx.compose.ui.node.NodeCoordinator wrappedNonNull;
        approachMeasureScope = this.approachMeasureScope;
        if (approachMeasureScope != null) {
            i = 0;
            wrappedNonNull2 = 0;
            $this$minIntrinsicHeight_u24lambda_u2413_u24lambda_u2412 = approachMeasureScope.getApproachNode().minApproachIntrinsicHeight((ApproachIntrinsicMeasureScope)approachMeasureScope, (IntrinsicMeasurable)getWrappedNonNull(), width);
        } else {
            i = 0;
            $this$minIntrinsicHeight_u24lambda_u2413_u24lambda_u2412 = this.layoutModifierNode.minIntrinsicHeight((IntrinsicMeasureScope)this, (IntrinsicMeasurable)getWrappedNonNull(), width);
        }
        return $this$minIntrinsicHeight_u24lambda_u2413_u24lambda_u2412;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int minIntrinsicWidth(int height) {
        Object approachMeasureScope;
        int i;
        int $this$minIntrinsicWidth_u24lambda_u247_u24lambda_u246;
        int wrappedNonNull2;
        ApproachMeasureScopeImpl approachMeasureScopeImpl;
        androidx.compose.ui.node.NodeCoordinator wrappedNonNull;
        approachMeasureScope = this.approachMeasureScope;
        if (approachMeasureScope != null) {
            i = 0;
            wrappedNonNull2 = 0;
            $this$minIntrinsicWidth_u24lambda_u247_u24lambda_u246 = approachMeasureScope.getApproachNode().minApproachIntrinsicWidth((ApproachIntrinsicMeasureScope)approachMeasureScope, (IntrinsicMeasurable)getWrappedNonNull(), height);
        } else {
            i = 0;
            $this$minIntrinsicWidth_u24lambda_u247_u24lambda_u246 = this.layoutModifierNode.minIntrinsicWidth((IntrinsicMeasureScope)this, (IntrinsicMeasurable)getWrappedNonNull(), height);
        }
        return $this$minIntrinsicWidth_u24lambda_u247_u24lambda_u246;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        boolean modifierBoundsPaint;
        getWrappedNonNull().draw(canvas, graphicsLayer);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, LayoutModifierNodeCoordinator.modifierBoundsPaint);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    protected void placeAt-f8xVGno(long position, float zIndex, GraphicsLayer layer) {
        super.placeAt-f8xVGno(position, zIndex, layer);
        onAfterPlaceAt();
    }

    protected void placeAt-f8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.placeAt-f8xVGno(position, zIndex, layerBlock);
        onAfterPlaceAt();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void setLayoutModifierNode$ui_release(androidx.compose.ui.node.LayoutModifierNode value) {
        boolean approachMeasureScope;
        int $i$f$getApproachMeasureOLwlOKw;
        int i2;
        int i;
        if (!Intrinsics.areEqual(value, this.layoutModifierNode)) {
            int i3 = 0;
            i2 = 0;
            i = kindSet$ui_release &= $i$f$getApproachMeasureOLwlOKw != 0 ? 1 : 0;
            if (i != 0) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                Object obj = value;
                approachMeasureScope = this.approachMeasureScope;
                if (approachMeasureScope != null) {
                    i2 = 0;
                    approachMeasureScope.setApproachNode((ApproachLayoutModifierNode)value);
                } else {
                    approachMeasureScope = new ApproachMeasureScopeImpl(this, (ApproachLayoutModifierNode)value);
                }
                this.approachMeasureScope = approachMeasureScope;
            } else {
                this.approachMeasureScope = 0;
            }
        }
        this.layoutModifierNode = value;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void setLookaheadConstraints-_Sx5XlM$ui_release(Constraints <set-?>) {
        this.lookaheadConstraints = <set-?>;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    protected void setLookaheadDelegate(androidx.compose.ui.node.LookaheadDelegate <set-?>) {
        this.lookaheadDelegate = <set-?>;
    }
}
