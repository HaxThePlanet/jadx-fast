package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B*\u0012#\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0004¢\u0006\u0002\u0008\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u00020\u0008*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014R7\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0004¢\u0006\u0002\u0008\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"Landroidx/compose/ui/layout/LayoutModifierImpl;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "getMeasureBlock", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock", "toString", "", "measure", "measurable", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutModifierImpl extends Modifier.Node implements LayoutModifierNode {

    public static final int $stable = 8;
    private Function3<? super androidx.compose.ui.layout.MeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> measureBlock;
    static {
        final int i = 8;
    }

    public LayoutModifierImpl(Function3<? super androidx.compose.ui.layout.MeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> measureBlock) {
        super();
        this.measureBlock = measureBlock;
    }

    public final Function3<androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, Constraints, androidx.compose.ui.layout.MeasureResult> getMeasureBlock() {
        return this.measureBlock;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public androidx.compose.ui.layout.MeasureResult measure-3p2s80s(androidx.compose.ui.layout.MeasureScope $this$measure_u2d3p2s80s, androidx.compose.ui.layout.Measurable measurable, long constraints) {
        return (MeasureResult)this.measureBlock.invoke($this$measure_u2d3p2s80s, measurable, Constraints.box-impl(constraints));
    }

    public final void setMeasureBlock(Function3<? super androidx.compose.ui.layout.MeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> <set-?>) {
        this.measureBlock = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LayoutModifierImpl(measureBlock=").append(this.measureBlock).append(')').toString();
    }
}
