package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0007\u001a\u00020\u0005H\u0016J&\u0010\u0008\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "sharePointerInputWithSiblings", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StylusHandwritingNodeWithNegativePadding extends androidx.compose.foundation.text.handwriting.StylusHandwritingNode implements LayoutModifierNode {

    public static final int $stable;
    static {
    }

    public StylusHandwritingNodeWithNegativePadding(Function0<Boolean> onHandwritingSlopExceeded) {
        super(onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.foundation.text.handwriting.StylusHandwritingNode
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final MeasureScope measureScope = $this$measure_u2d3p2s80s;
        final int roundToPx-0680j_4 = measureScope.roundToPx-0680j_4(StylusHandwritingKt.getHandwritingBoundsVerticalOffset());
        final int roundToPx-0680j_42 = measureScope.roundToPx-0680j_4(StylusHandwritingKt.getHandwritingBoundsHorizontalOffset());
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(constraints, obj10, roundToPx-0680j_42 * 2));
        StylusHandwritingNodeWithNegativePadding.measure.1 anon = new StylusHandwritingNodeWithNegativePadding.measure.1(measure-BRTryo0, roundToPx-0680j_42, roundToPx-0680j_4);
        return MeasureScope.layout$default(measureScope, width -= i6, height - i4, 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.foundation.text.handwriting.StylusHandwritingNode
    public boolean sharePointerInputWithSiblings() {
        return 1;
    }
}
