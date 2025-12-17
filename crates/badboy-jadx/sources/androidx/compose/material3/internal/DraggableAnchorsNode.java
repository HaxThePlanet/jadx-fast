package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u00020\u0003Be\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012H\u0010\u0006\u001aD\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0008\u0010!\u001a\u00020\"H\u0016J&\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\r\u001a\u00020\u000cH\u0016ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)R\\\u0010\u0006\u001aD\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR \u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 \u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006*", d2 = {"Landroidx/compose/material3/internal/DraggableAnchorsNode;", "T", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "state", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "anchors", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "Landroidx/compose/material3/internal/DraggableAnchors;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/gestures/Orientation;)V", "getAnchors", "()Lkotlin/jvm/functions/Function2;", "setAnchors", "(Lkotlin/jvm/functions/Function2;)V", "didLookahead", "", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "getState", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setState", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "onDetach", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DraggableAnchorsNode<T>  extends Modifier.Node implements LayoutModifierNode {

    private Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends androidx.compose.material3.internal.DraggableAnchors<T>, ? extends T>> anchors;
    private boolean didLookahead;
    private Orientation orientation;
    private androidx.compose.material3.internal.AnchoredDraggableState<T> state;
    public DraggableAnchorsNode(androidx.compose.material3.internal.AnchoredDraggableState<T> state, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends androidx.compose.material3.internal.DraggableAnchors<T>, ? extends T>> anchors, Orientation orientation) {
        super();
        this.state = state;
        this.anchors = anchors;
        this.orientation = orientation;
    }

    public final Function2<IntSize, Constraints, Pair<androidx.compose.material3.internal.DraggableAnchors<T>, T>> getAnchors() {
        return this.anchors;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final androidx.compose.material3.internal.AnchoredDraggableState<T> getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        long lookingAhead;
        boolean lookingAhead2;
        int i;
        int height;
        Object invoke;
        androidx.compose.material3.internal.AnchoredDraggableState state;
        Object first;
        Object second;
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(constraints);
        if ($this$measure_u2d3p2s80s.isLookingAhead()) {
            if (!this.didLookahead) {
                height = measure-BRTryo0.getHeight();
                invoke = this.anchors.invoke(IntSize.box-impl(IntSizeKt.IntSize(measure-BRTryo0.getWidth(), height)), Constraints.box-impl(constraints));
                this.state.updateAnchors((DraggableAnchors)(Pair)invoke.getFirst(), invoke.getSecond());
            }
        } else {
        }
        if (!$this$measure_u2d3p2s80s.isLookingAhead()) {
            if (this.didLookahead) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        this.didLookahead = i;
        DraggableAnchorsNode.measure.1 anon = new DraggableAnchorsNode.measure.1($this$measure_u2d3p2s80s, this, measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        this.didLookahead = false;
    }

    public final void setAnchors(Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends androidx.compose.material3.internal.DraggableAnchors<T>, ? extends T>> <set-?>) {
        this.anchors = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setOrientation(Orientation <set-?>) {
        this.orientation = <set-?>;
    }

    public final void setState(androidx.compose.material3.internal.AnchoredDraggableState<T> <set-?>) {
        this.state = <set-?>;
    }
}
