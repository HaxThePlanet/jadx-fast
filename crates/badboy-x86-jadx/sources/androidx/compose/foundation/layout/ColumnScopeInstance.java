package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0017J\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000c\u001a\u00020\rH\u0017J\u001c\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/layout/ColumnScopeInstance;", "Landroidx/compose/foundation/layout/ColumnScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "weight", "", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColumnScopeInstance implements androidx.compose.foundation.layout.ColumnScope {

    public static final int $stable;
    public static final androidx.compose.foundation.layout.ColumnScopeInstance INSTANCE;
    static {
        ColumnScopeInstance columnScopeInstance = new ColumnScopeInstance();
        ColumnScopeInstance.INSTANCE = columnScopeInstance;
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier align(Modifier $this$align, Alignment.Horizontal alignment) {
        HorizontalAlignElement horizontalAlignElement = new HorizontalAlignElement(alignment);
        return $this$align.then((Modifier)horizontalAlignElement);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier alignBy(Modifier $this$alignBy, VerticalAlignmentLine alignmentLine) {
        WithAlignmentLineElement withAlignmentLineElement = new WithAlignmentLineElement((AlignmentLine)alignmentLine);
        return $this$alignBy.then((Modifier)withAlignmentLineElement);
    }

    public Modifier alignBy(Modifier $this$alignBy, Function1<? super Measured, Integer> alignmentLineBlock) {
        WithAlignmentLineBlockElement withAlignmentLineBlockElement = new WithAlignmentLineBlockElement(alignmentLineBlock);
        return $this$alignBy.then((Modifier)withAlignmentLineBlockElement);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
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
