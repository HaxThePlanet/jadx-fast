package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\u0008\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J&\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0014À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LayoutModifierNode extends androidx.compose.ui.node.DelegatableNode {
    @Override // androidx.compose.ui.node.DelegatableNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        LayoutModifierNode.maxIntrinsicHeight.1 anon = new LayoutModifierNode.maxIntrinsicHeight.1(this);
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release((NodeMeasuringIntrinsics.MeasureBlock)anon, $this$maxIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        LayoutModifierNode.maxIntrinsicWidth.1 anon = new LayoutModifierNode.maxIntrinsicWidth.1(this);
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release((NodeMeasuringIntrinsics.MeasureBlock)anon, $this$maxIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public abstract MeasureResult measure-3p2s80s(MeasureScope measureScope, Measurable measurable2, long l3);

    @Override // androidx.compose.ui.node.DelegatableNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        LayoutModifierNode.minIntrinsicHeight.1 anon = new LayoutModifierNode.minIntrinsicHeight.1(this);
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release((NodeMeasuringIntrinsics.MeasureBlock)anon, $this$minIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        LayoutModifierNode.minIntrinsicWidth.1 anon = new LayoutModifierNode.minIntrinsicWidth.1(this);
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release((NodeMeasuringIntrinsics.MeasureBlock)anon, $this$minIntrinsicWidth, measurable, height);
    }
}
