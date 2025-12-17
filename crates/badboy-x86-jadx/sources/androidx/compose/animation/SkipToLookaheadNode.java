package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0008J&\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!R7\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u0005\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\"\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R/\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0010\t\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0019\u0010\u000e\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/animation/SkipToLookaheadNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "setScaleToBounds", "(Landroidx/compose/animation/ScaleToBoundsImpl;)V", "scaleToBounds$delegate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {

    private final MutableState isEnabled$delegate;
    private Constraints lookaheadConstraints;
    private final MutableState scaleToBounds$delegate;
    public SkipToLookaheadNode(androidx.compose.animation.ScaleToBoundsImpl scaleToBounds, Function0<Boolean> isEnabled) {
        super();
        int i = 0;
        final int i2 = 2;
        this.scaleToBounds$delegate = SnapshotStateKt.mutableStateOf$default(scaleToBounds, i, i2, i);
        this.isEnabled$delegate = SnapshotStateKt.mutableStateOf$default(isEnabled, i, i2, i);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Constraints getLookaheadConstraints-DWUhwKw() {
        return this.lookaheadConstraints;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.animation.ScaleToBoundsImpl getScaleToBounds() {
        final int i = 0;
        final int i2 = 0;
        return (ScaleToBoundsImpl)(State)this.scaleToBounds$delegate.getValue();
    }

    public final Function0<Boolean> isEnabled() {
        final int i = 0;
        final int i2 = 0;
        return (Function0)(State)this.isEnabled$delegate.getValue();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        boolean lookingAhead;
        final Object obj = this;
        if ($this$measure_u2d3p2s80s.isLookingAhead()) {
            obj.lookaheadConstraints = Constraints.box-impl(constraints);
        }
        Constraints lookaheadConstraints = obj.lookaheadConstraints;
        Intrinsics.checkNotNull(lookaheadConstraints);
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(lookaheadConstraints.unbox-impl());
        long l = IntSizeKt.IntSize(measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight());
        final long constrain-4WqzIAM = ConstraintsKt.constrain-4WqzIAM(constraints, obj10);
        SkipToLookaheadNode.measure.1 anon = new SkipToLookaheadNode.measure.1(obj, measure-BRTryo0, l, obj4, constrain-4WqzIAM, obj6, $this$measure_u2d3p2s80s);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, IntSize.getWidth-impl(constrain-4WqzIAM), IntSize.getHeight-impl(constrain-4WqzIAM), 0, (Function1)anon, 4, 0);
    }

    public final void setEnabled(Function0<Boolean> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isEnabled$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setLookaheadConstraints-_Sx5XlM(Constraints <set-?>) {
        this.lookaheadConstraints = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setScaleToBounds(androidx.compose.animation.ScaleToBoundsImpl <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.scaleToBounds$delegate.setValue(<set-?>);
    }
}
