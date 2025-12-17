package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u00030\u0002Be\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012H\u0010\u0006\u001aD\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u000c\u0010\u001d\u001a\u00020\u001b*\u00020\u001eH\u0016RP\u0010\u0006\u001aD\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/compose/material3/internal/DraggableAnchorsElement;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/internal/DraggableAnchorsNode;", "state", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "anchors", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "Landroidx/compose/material3/internal/DraggableAnchors;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/gestures/Orientation;)V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DraggableAnchorsElement<T>  extends ModifierNodeElement<androidx.compose.material3.internal.DraggableAnchorsNode<T>> {

    private final Function2<IntSize, Constraints, Pair<androidx.compose.material3.internal.DraggableAnchors<T>, T>> anchors;
    private final Orientation orientation;
    private final androidx.compose.material3.internal.AnchoredDraggableState<T> state;
    public DraggableAnchorsElement(androidx.compose.material3.internal.AnchoredDraggableState<T> state, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends androidx.compose.material3.internal.DraggableAnchors<T>, ? extends T>> anchors, Orientation orientation) {
        super();
        this.state = state;
        this.anchors = anchors;
        this.orientation = orientation;
    }

    public static final Function2 access$getAnchors$p(androidx.compose.material3.internal.DraggableAnchorsElement $this) {
        return $this.anchors;
    }

    public static final Orientation access$getOrientation$p(androidx.compose.material3.internal.DraggableAnchorsElement $this) {
        return $this.orientation;
    }

    public static final androidx.compose.material3.internal.AnchoredDraggableState access$getState$p(androidx.compose.material3.internal.DraggableAnchorsElement $this) {
        return $this.state;
    }

    public androidx.compose.material3.internal.DraggableAnchorsNode<T> create() {
        DraggableAnchorsNode draggableAnchorsNode = new DraggableAnchorsNode(this.state, this.anchors, this.orientation);
        return draggableAnchorsNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof DraggableAnchorsElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.state, obj.state)) {
            return i2;
        }
        if (this.anchors != obj2.anchors) {
            return i2;
        }
        if (this.orientation != obj3.orientation) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return result += i6;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        androidx.compose.material3.internal.DraggableAnchorsElement.inspectableProperties$$inlined.debugInspectorInfo.1 debugInspectorInfoEnabled;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            debugInspectorInfoEnabled = new DraggableAnchorsElement.inspectableProperties$$inlined.debugInspectorInfo.1(this);
        } else {
            InspectableValueKt.getNoInspectorInfo();
        }
    }

    public void update(androidx.compose.material3.internal.DraggableAnchorsNode<T> node) {
        node.setState(this.state);
        node.setAnchors(this.anchors);
        node.setOrientation(this.orientation);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((DraggableAnchorsNode)node);
    }
}
