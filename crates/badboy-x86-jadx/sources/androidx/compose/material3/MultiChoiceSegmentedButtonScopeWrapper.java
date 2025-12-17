package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0097\u0001J!\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000bH\u0097\u0001J\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0097\u0001J\r\u0010\u0010\u001a\u00020\u0006*\u00020\u0006H\u0097\u0001J!\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0008\u0008\u0001\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014H\u0097\u0001¨\u0006\u0015", d2 = {"Landroidx/compose/material3/MultiChoiceSegmentedButtonScopeWrapper;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/foundation/layout/RowScope;", "scope", "(Landroidx/compose/foundation/layout/RowScope;)V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "weight", "", "fill", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MultiChoiceSegmentedButtonScopeWrapper implements androidx.compose.material3.MultiChoiceSegmentedButtonRowScope, RowScope {

    private final RowScope $$delegate_0;
    public MultiChoiceSegmentedButtonScopeWrapper(RowScope scope) {
        super();
        this.$$delegate_0 = scope;
    }

    @Override // androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
    public Modifier align(Modifier modifier, Alignment.Vertical alignment$Vertical2) {
        return this.$$delegate_0.align(modifier, vertical2);
    }

    @Override // androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
    public Modifier alignBy(Modifier modifier, HorizontalAlignmentLine horizontalAlignmentLine2) {
        return this.$$delegate_0.alignBy(modifier, horizontalAlignmentLine2);
    }

    public Modifier alignBy(Modifier modifier, Function1<? super Measured, Integer> function12) {
        return this.$$delegate_0.alignBy(modifier, function12);
    }

    @Override // androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
    public Modifier alignByBaseline(Modifier modifier) {
        return this.$$delegate_0.alignByBaseline(modifier);
    }

    @Override // androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
    public Modifier weight(Modifier modifier, float f2, boolean z3) {
        return this.$$delegate_0.weight(modifier, f2, z3);
    }
}
