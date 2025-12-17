package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008À\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0097\u0001J!\u0010\u0008\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\nH\u0097\u0001J\u0015\u0010\u0008\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0097\u0001J\r\u0010\u000f\u001a\u00020\u0005*\u00020\u0005H\u0097\u0001J\u0014\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0008\u0008\u0001\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015H\u0097\u0001¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/layout/FlowRowScopeInstance;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/foundation/layout/FlowRowScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "fillMaxRowHeight", "fraction", "", "weight", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowRowScopeInstance implements androidx.compose.foundation.layout.RowScope, androidx.compose.foundation.layout.FlowRowScope {

    public static final int $stable;
    public static final androidx.compose.foundation.layout.FlowRowScopeInstance INSTANCE;
    private final androidx.compose.foundation.layout.RowScopeInstance $$delegate_0;
    static {
        FlowRowScopeInstance flowRowScopeInstance = new FlowRowScopeInstance();
        FlowRowScopeInstance.INSTANCE = flowRowScopeInstance;
    }

    private FlowRowScopeInstance() {
        super();
        this.$$delegate_0 = RowScopeInstance.INSTANCE;
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier align(Modifier modifier, Alignment.Vertical alignment$Vertical2) {
        return this.$$delegate_0.align(modifier, vertical2);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignBy(Modifier modifier, HorizontalAlignmentLine horizontalAlignmentLine2) {
        return this.$$delegate_0.alignBy(modifier, horizontalAlignmentLine2);
    }

    public Modifier alignBy(Modifier modifier, Function1<? super Measured, Integer> function12) {
        return this.$$delegate_0.alignBy(modifier, function12);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignByBaseline(Modifier modifier) {
        return this.$$delegate_0.alignByBaseline(modifier);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier fillMaxRowHeight(Modifier $this$fillMaxRowHeight, float fraction) {
        int i;
        int i2;
        int i6 = 0;
        i = Double.compare(d, i5) >= 0 ? i2 : i6;
        final String str3 = "invalid fraction ";
        if (i == 0) {
        } else {
            if (Double.compare(d2, l) <= 0) {
            } else {
                i2 = i6;
            }
            if (i2 == 0) {
            } else {
                FillCrossAxisSizeElement fillCrossAxisSizeElement = new FillCrossAxisSizeElement(fraction);
                return $this$fillMaxRowHeight.then((Modifier)fillCrossAxisSizeElement);
            }
            int i4 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append(str3).append(fraction).append("; must not be greater than 1.0").toString().toString());
            throw illegalArgumentException2;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append(str3).append(fraction).append("; must be greater than or equal to zero").toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier weight(Modifier modifier, float f2, boolean z3) {
        return this.$$delegate_0.weight(modifier, f2, z3);
    }
}
