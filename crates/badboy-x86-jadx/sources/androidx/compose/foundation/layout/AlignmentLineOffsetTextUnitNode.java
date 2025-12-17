package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J&\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cR\"\u0010\u0007\u001a\u00020\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\u0008\u0012\u0010\n\"\u0004\u0008\u0013\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetTextUnitNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/TextUnit;", "after", "(Landroidx/compose/ui/layout/AlignmentLine;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfter-XSAIIZE", "()J", "setAfter--R2X_6o", "(J)V", "J", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "setAlignmentLine", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getBefore-XSAIIZE", "setBefore--R2X_6o", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AlignmentLineOffsetTextUnitNode extends Modifier.Node implements LayoutModifierNode {

    private long after;
    private AlignmentLine alignmentLine;
    private long before;
    private AlignmentLineOffsetTextUnitNode(AlignmentLine alignmentLine, long before, long after) {
        super();
        this.alignmentLine = alignmentLine;
        this.before = before;
        this.after = obj4;
    }

    public AlignmentLineOffsetTextUnitNode(AlignmentLine alignmentLine, long l2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(alignmentLine, l2, l3, defaultConstructorMarker4, obj5);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getAfter-XSAIIZE() {
        return this.after;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getBefore-XSAIIZE() {
        return this.before;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        float unspecified-D9Ej5fM2;
        float unspecified-D9Ej5fM;
        long before;
        long after;
        if (!TextUnitKt.isUnspecified--R2X_6o(this.before)) {
            unspecified-D9Ej5fM2 = $this$measure_u2d3p2s80s.toDp-GaN1DYA(this.before);
        } else {
            unspecified-D9Ej5fM2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (!TextUnitKt.isUnspecified--R2X_6o(this.after)) {
            unspecified-D9Ej5fM = $this$measure_u2d3p2s80s.toDp-GaN1DYA(this.after);
        } else {
            unspecified-D9Ej5fM = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return AlignmentLineKt.access$alignmentLineOffsetMeasure-tjqqzMA($this$measure_u2d3p2s80s, this.alignmentLine, unspecified-D9Ej5fM2, unspecified-D9Ej5fM, measurable, constraints);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAfter--R2X_6o(long <set-?>) {
        this.after = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAlignmentLine(AlignmentLine <set-?>) {
        this.alignmentLine = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setBefore--R2X_6o(long <set-?>) {
        this.before = <set-?>;
    }
}
