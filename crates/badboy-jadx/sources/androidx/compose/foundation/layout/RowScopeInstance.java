package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000c\u001a\u00020\rH\u0017J\u000c\u0010\u000e\u001a\u00020\u0004*\u00020\u0004H\u0017J\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/layout/RowScopeInstance;", "Landroidx/compose/foundation/layout/RowScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "weight", "", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RowScopeInstance implements androidx.compose.foundation.layout.RowScope {

    public static final int $stable;
    public static final androidx.compose.foundation.layout.RowScopeInstance INSTANCE;
    static {
        RowScopeInstance rowScopeInstance = new RowScopeInstance();
        RowScopeInstance.INSTANCE = rowScopeInstance;
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier align(Modifier $this$align, Alignment.Vertical alignment) {
        VerticalAlignElement verticalAlignElement = new VerticalAlignElement(alignment);
        return $this$align.then((Modifier)verticalAlignElement);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignBy(Modifier $this$alignBy, HorizontalAlignmentLine alignmentLine) {
        WithAlignmentLineElement withAlignmentLineElement = new WithAlignmentLineElement((AlignmentLine)alignmentLine);
        return $this$alignBy.then((Modifier)withAlignmentLineElement);
    }

    public Modifier alignBy(Modifier $this$alignBy, Function1<? super Measured, Integer> alignmentLineBlock) {
        WithAlignmentLineBlockElement withAlignmentLineBlockElement = new WithAlignmentLineBlockElement(alignmentLineBlock);
        return $this$alignBy.then((Modifier)withAlignmentLineBlockElement);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignByBaseline(Modifier $this$alignByBaseline) {
        return alignBy($this$alignByBaseline, AlignmentLineKt.getFirstBaseline());
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier weight(Modifier $this$weight, float weight, boolean fill) {
        int i;
        i = Double.compare(d, i4) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(RangesKt.coerceAtMost(weight, 2139095039), fill);
            return $this$weight.then((Modifier)layoutWeightElement);
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("invalid weight ").append(weight).append("; must be greater than zero").toString().toString());
        throw illegalArgumentException;
    }
}
