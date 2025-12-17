package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\u0008\u0002\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ&\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\"\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u000f\"\u0004\u0008\u0013\u0010\u0011\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/lazy/ParentSizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fraction", "", "widthState", "Landroidx/compose/runtime/State;", "", "heightState", "(FLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getFraction", "()F", "setFraction", "(F)V", "getHeightState", "()Landroidx/compose/runtime/State;", "setHeightState", "(Landroidx/compose/runtime/State;)V", "getWidthState", "setWidthState", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ParentSizeNode extends Modifier.Node implements LayoutModifierNode {

    private float fraction;
    private State<Integer> heightState;
    private State<Integer> widthState;
    public ParentSizeNode(float fraction, State<Integer> widthState, State<Integer> heightState) {
        super();
        this.fraction = fraction;
        this.widthState = widthState;
        this.heightState = heightState;
    }

    public ParentSizeNode(float f, State state2, State state3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        int obj4;
        final int i = 0;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(f, obj3, obj4);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getFraction() {
        return this.fraction;
    }

    public final State<Integer> getHeightState() {
        return this.heightState;
    }

    public final State<Integer> getWidthState() {
        return this.widthState;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int minWidth-impl;
        int maxHeight-impl;
        int i;
        int minHeight-impl;
        int $this$fastRoundToInt$iv;
        int i2;
        int $this$fastRoundToInt$iv2;
        int i3;
        int maxWidth-impl;
        State widthState = this.widthState;
        int i4 = Integer.MAX_VALUE;
        if (widthState != null) {
            i = 0;
            if ((Number)widthState.getValue().intValue() != i4) {
                i2 = 0;
                $this$fastRoundToInt$iv = Math.round(floatValue *= fraction);
            } else {
                $this$fastRoundToInt$iv = i4;
            }
        } else {
            $this$fastRoundToInt$iv = i4;
        }
        State heightState = this.heightState;
        if (heightState != null) {
            i = 0;
            if ((Number)heightState.getValue().intValue() != i4) {
                i3 = 0;
                $this$fastRoundToInt$iv2 = Math.round(floatValue2 *= fraction2);
            } else {
                $this$fastRoundToInt$iv2 = i4;
            }
        } else {
            $this$fastRoundToInt$iv2 = i4;
        }
        if ($this$fastRoundToInt$iv != i4) {
            minWidth-impl = $this$fastRoundToInt$iv;
        } else {
            minWidth-impl = Constraints.getMinWidth-impl(constraints);
        }
        if ($this$fastRoundToInt$iv2 != i4) {
            minHeight-impl = $this$fastRoundToInt$iv2;
        } else {
            minHeight-impl = Constraints.getMinHeight-impl(constraints);
        }
        if ($this$fastRoundToInt$iv != i4) {
            maxWidth-impl = $this$fastRoundToInt$iv;
        } else {
            maxWidth-impl = Constraints.getMaxWidth-impl(constraints);
        }
        if ($this$fastRoundToInt$iv2 != i4) {
            maxHeight-impl = $this$fastRoundToInt$iv2;
        } else {
            maxHeight-impl = Constraints.getMaxHeight-impl(constraints);
        }
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(ConstraintsKt.Constraints(minWidth-impl, maxWidth-impl, minHeight-impl, maxHeight-impl));
        ParentSizeNode.measure.1 anon = new ParentSizeNode.measure.1(measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFraction(float <set-?>) {
        this.fraction = <set-?>;
    }

    public final void setHeightState(State<Integer> <set-?>) {
        this.heightState = <set-?>;
    }

    public final void setWidthState(State<Integer> <set-?>) {
        this.widthState = <set-?>;
    }
}
