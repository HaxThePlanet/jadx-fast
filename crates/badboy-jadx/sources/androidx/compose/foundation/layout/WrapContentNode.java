package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0008¢\u0006\u0002\u0010\u000cJ&\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!R,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"Landroidx/compose/foundation/layout/WrapContentNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;)V", "getAlignmentCallback", "()Lkotlin/jvm/functions/Function2;", "setAlignmentCallback", "(Lkotlin/jvm/functions/Function2;)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getUnbounded", "()Z", "setUnbounded", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {

    private Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback;
    private androidx.compose.foundation.layout.Direction direction;
    private boolean unbounded;
    public WrapContentNode(androidx.compose.foundation.layout.Direction direction, boolean unbounded, Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback) {
        super();
        this.direction = direction;
        this.unbounded = unbounded;
        this.alignmentCallback = alignmentCallback;
    }

    public final Function2<IntSize, LayoutDirection, IntOffset> getAlignmentCallback() {
        return this.alignmentCallback;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.layout.Direction getDirection() {
        return this.direction;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getUnbounded() {
        return this.unbounded;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int minWidth-impl;
        androidx.compose.foundation.layout.Direction direction2;
        int maxWidth-impl;
        int minHeight-impl;
        boolean direction;
        int maxHeight-impl;
        final Object obj = this;
        if (obj.direction != Direction.Vertical) {
            minWidth-impl = minHeight-impl;
        } else {
            minWidth-impl = Constraints.getMinWidth-impl(constraints);
        }
        if (obj.direction != Direction.Horizontal) {
        } else {
            minHeight-impl = Constraints.getMinHeight-impl(constraints);
        }
        if (obj.direction != Direction.Vertical && obj.unbounded) {
            if (obj.unbounded) {
                maxWidth-impl = maxHeight-impl;
            } else {
                maxWidth-impl = Constraints.getMaxWidth-impl(constraints);
            }
        } else {
        }
        if (obj.direction != Direction.Horizontal && obj.unbounded) {
            if (obj.unbounded) {
            } else {
                maxHeight-impl = Constraints.getMaxHeight-impl(constraints);
            }
        } else {
        }
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(ConstraintsKt.Constraints(minWidth-impl, maxWidth-impl, minHeight-impl, maxHeight-impl));
        int coerceIn = RangesKt.coerceIn(measure-BRTryo0.getWidth(), Constraints.getMinWidth-impl(constraints), Constraints.getMaxWidth-impl(constraints));
        final int coerceIn2 = RangesKt.coerceIn(measure-BRTryo0.getHeight(), Constraints.getMinHeight-impl(constraints), Constraints.getMaxHeight-impl(constraints));
        WrapContentNode.measure.1 anon = new WrapContentNode.measure.1(obj, coerceIn, measure-BRTryo0, coerceIn2, $this$measure_u2d3p2s80s);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, coerceIn, coerceIn2, 0, (Function1)anon, 4, 0);
    }

    public final void setAlignmentCallback(Function2<? super IntSize, ? super LayoutDirection, IntOffset> <set-?>) {
        this.alignmentCallback = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setDirection(androidx.compose.foundation.layout.Direction <set-?>) {
        this.direction = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setUnbounded(boolean <set-?>) {
        this.unbounded = <set-?>;
    }
}
