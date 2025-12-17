package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {

    private androidx.compose.foundation.layout.PaddingValues paddingValues;
    public PaddingValuesModifier(androidx.compose.foundation.layout.PaddingValues paddingValues) {
        super();
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.layout.PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int i;
        int compareTo-0680j_4;
        float $this$dp$iv;
        int i2;
        float f;
        i2 = 0;
        i2 = 0;
        i2 = 0;
        i2 = 0;
        if (Dp.compareTo-0680j_4(this.paddingValues.calculateLeftPadding-u2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()), Dp.constructor-impl((float)i4)) >= 0 && Dp.compareTo-0680j_4(this.paddingValues.calculateTopPadding-D9Ej5fM(), Dp.constructor-impl((float)i6)) >= 0 && Dp.compareTo-0680j_4(this.paddingValues.calculateRightPadding-u2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()), Dp.constructor-impl((float)i7)) >= 0 && Dp.compareTo-0680j_4(this.paddingValues.calculateBottomPadding-D9Ej5fM(), Dp.constructor-impl((float)i8)) >= 0) {
            i2 = 0;
            if (Dp.compareTo-0680j_4(this.paddingValues.calculateTopPadding-D9Ej5fM(), Dp.constructor-impl((float)i6)) >= 0) {
                i2 = 0;
                if (Dp.compareTo-0680j_4(this.paddingValues.calculateRightPadding-u2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()), Dp.constructor-impl((float)i7)) >= 0) {
                    i2 = 0;
                    i = Dp.compareTo-0680j_4(this.paddingValues.calculateBottomPadding-D9Ej5fM(), Dp.constructor-impl((float)i8)) >= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        if (i == 0) {
        } else {
            roundToPx-0680j_4 += roundToPx-0680j_42;
            roundToPx-0680j_43 += roundToPx-0680j_44;
            int i10 = -i5;
            Placeable measure-BRTryo0 = measurable.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(constraints, obj15, -i3));
            PaddingValuesModifier.measure.2 anon = new PaddingValuesModifier.measure.2(measure-BRTryo0, $this$measure_u2d3p2s80s, this);
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, ConstraintsKt.constrainWidth-K40F9xA(constraints, obj15), ConstraintsKt.constrainHeight-K40F9xA(constraints, obj15), 0, (Function1)anon, 4, 0);
        }
        MeasureScope $this$measure_u2d3p2s80s2 = $this$measure_u2d3p2s80s;
        int obj12 = 0;
        obj12 = new IllegalArgumentException("Padding must be non-negative".toString());
        throw obj12;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setPaddingValues(androidx.compose.foundation.layout.PaddingValues <set-?>) {
        this.paddingValues = <set-?>;
    }
}
