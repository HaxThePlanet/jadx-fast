package androidx.compose.material;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"Landroidx/compose/material/MinimumInteractiveModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MinimumInteractiveModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {

    public static final int $stable;
    static {
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        boolean booleanValue;
        int i;
        int width;
        androidx.compose.runtime.ProvidableCompositionLocal localMinimumInteractiveComponentEnforcement;
        int height;
        int roundToPx-0680j_4;
        if (isAttached() && (Boolean)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement()).booleanValue()) {
            i = (Boolean)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement()).booleanValue() ? 1 : 0;
        } else {
        }
        final int i5 = i;
        final long l = InteractiveComponentSizeKt.access$getMinimumInteractiveComponentSize$p();
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(constraints);
        if (i5 != 0) {
            width = Math.max(measure-BRTryo0.getWidth(), $this$measure_u2d3p2s80s.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(l)));
        } else {
            width = measure-BRTryo0.getWidth();
        }
        if (i5 != 0) {
            height = Math.max(measure-BRTryo0.getHeight(), $this$measure_u2d3p2s80s.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(l)));
        } else {
            height = measure-BRTryo0.getHeight();
        }
        MinimumInteractiveModifierNode.measure.1 anon = new MinimumInteractiveModifierNode.measure.1(width, measure-BRTryo0, height);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, height, 0, (Function1)anon, 4, 0);
    }
}
