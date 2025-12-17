package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007J&\u0010\u0008\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u001c\u0010\u001a\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J&\u0010\u001c\u001a\u00020\t*\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u001c\u0010 \u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u001c\u0010!\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0016H\u0016ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\"À\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "isMeasurementApproachInProgress", "", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "isPlacementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "maxApproachIntrinsicHeight", "", "Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxApproachIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureScope;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minApproachIntrinsicHeight", "minApproachIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ApproachLayoutModifierNode extends LayoutModifierNode {
    @Override // androidx.compose.ui.node.LayoutModifierNode
    public abstract androidx.compose.ui.layout.MeasureResult approachMeasure-3p2s80s(androidx.compose.ui.layout.ApproachMeasureScope approachMeasureScope, androidx.compose.ui.layout.Measurable measurable2, long l3);

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public abstract boolean isMeasurementApproachInProgress-ozmzZPI(long l);

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public boolean isPlacementApproachInProgress(androidx.compose.ui.layout.Placeable.PlacementScope $this$isPlacementApproachInProgress, androidx.compose.ui.layout.LayoutCoordinates lookaheadCoordinates) {
        return 0;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxApproachIntrinsicHeight(androidx.compose.ui.layout.ApproachIntrinsicMeasureScope $this$maxApproachIntrinsicHeight, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int width) {
        ApproachLayoutModifierNode.maxApproachIntrinsicHeight.1 anon = new ApproachLayoutModifierNode.maxApproachIntrinsicHeight.1(this);
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release((NodeMeasuringIntrinsics.ApproachMeasureBlock)anon, $this$maxApproachIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxApproachIntrinsicWidth(androidx.compose.ui.layout.ApproachIntrinsicMeasureScope $this$maxApproachIntrinsicWidth, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int height) {
        ApproachLayoutModifierNode.maxApproachIntrinsicWidth.1 anon = new ApproachLayoutModifierNode.maxApproachIntrinsicWidth.1(this);
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release((NodeMeasuringIntrinsics.ApproachMeasureBlock)anon, $this$maxApproachIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public androidx.compose.ui.layout.MeasureResult measure-3p2s80s(androidx.compose.ui.layout.MeasureScope $this$measure_u2d3p2s80s, androidx.compose.ui.layout.Measurable measurable, long constraints) {
        final androidx.compose.ui.layout.Placeable measure-BRTryo0 = measurable.measure-BRTryo0(constraints);
        final int i = 0;
        ApproachLayoutModifierNode.measure.1.1 anon = new ApproachLayoutModifierNode.measure.1.1(measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minApproachIntrinsicHeight(androidx.compose.ui.layout.ApproachIntrinsicMeasureScope $this$minApproachIntrinsicHeight, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int width) {
        ApproachLayoutModifierNode.minApproachIntrinsicHeight.1 anon = new ApproachLayoutModifierNode.minApproachIntrinsicHeight.1(this);
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release((NodeMeasuringIntrinsics.ApproachMeasureBlock)anon, $this$minApproachIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minApproachIntrinsicWidth(androidx.compose.ui.layout.ApproachIntrinsicMeasureScope $this$minApproachIntrinsicWidth, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int height) {
        ApproachLayoutModifierNode.minApproachIntrinsicWidth.1 anon = new ApproachLayoutModifierNode.minApproachIntrinsicWidth.1(this);
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release((NodeMeasuringIntrinsics.ApproachMeasureBlock)anon, $this$minApproachIntrinsicWidth, measurable, height);
    }
}
