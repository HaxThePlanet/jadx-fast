package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "(Landroidx/compose/foundation/layout/Direction;F)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getFraction", "()F", "setFraction", "(F)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FillNode extends Modifier.Node implements LayoutModifierNode {

    private androidx.compose.foundation.layout.Direction direction;
    private float fraction;
    public FillNode(androidx.compose.foundation.layout.Direction direction, float fraction) {
        super();
        this.direction = direction;
        this.fraction = fraction;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.layout.Direction getDirection() {
        return this.direction;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getFraction() {
        return this.fraction;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int minWidth;
        int minHeight;
        boolean hasBoundedWidth-impl;
        int maxWidth-impl2;
        androidx.compose.foundation.layout.Direction minWidth-impl;
        int maxWidth-impl;
        boolean hasBoundedHeight-impl;
        int maxHeight-impl2;
        androidx.compose.foundation.layout.Direction minHeight-impl;
        int maxHeight-impl;
        int i = 0;
        int i2 = 0;
        if (Constraints.getHasBoundedWidth-impl(constraints) && this.direction != Direction.Vertical) {
            if (this.direction != Direction.Vertical) {
                int i4 = 0;
                minWidth = maxWidth-impl2;
            } else {
                minWidth = Constraints.getMinWidth-impl(constraints);
                maxWidth-impl2 = Constraints.getMaxWidth-impl(constraints);
            }
        } else {
        }
        int maxWidth = 0;
        int i5 = 0;
        if (Constraints.getHasBoundedHeight-impl(constraints) && this.direction != Direction.Horizontal) {
            if (this.direction != Direction.Horizontal) {
                int i7 = 0;
                minHeight = maxHeight-impl2;
            } else {
                minHeight = Constraints.getMinHeight-impl(constraints);
                maxHeight-impl2 = Constraints.getMaxHeight-impl(constraints);
            }
        } else {
        }
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(ConstraintsKt.Constraints(minWidth, maxWidth-impl2, minHeight, maxHeight-impl2));
        FillNode.measure.1 anon = new FillNode.measure.1(measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setDirection(androidx.compose.foundation.layout.Direction <set-?>) {
        this.direction = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFraction(float <set-?>) {
        this.fraction = <set-?>;
    }
}
