package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a1\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u000b\u001a\u00020\u0008*\u00020\u00012\u0006\u0010\u000c\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u001a4\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0008\u0008\u0000\u0010\u0013*\u00020\u0014*\u0002H\u00132\u0014\u0008\u0004\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00080\u0003H\u0082\u0008¢\u0006\u0002\u0010\u0016\u001a/\u0010\u0017\u001a\u00020\u0011\"\u0008\u0008\u0000\u0010\u0013*\u00020\u0014*\u0002H\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00190\u0003H\u0002¢\u0006\u0002\u0010\u001a\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"DragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "contains", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;J)Z", "dispatchEntered", "", "firstDescendantOrNull", "T", "Landroidx/compose/ui/node/TraversableNode;", "predicate", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/node/TraversableNode;", "traverseSelfAndDescendants", "block", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DragAndDropNodeKt {
    public static final androidx.compose.ui.draganddrop.DragAndDropModifierNode DragAndDropModifierNode() {
        DragAndDropNode dragAndDropNode = new DragAndDropNode((Function1)DragAndDropNodeKt.DragAndDropModifierNode.1.INSTANCE);
        return (DragAndDropModifierNode)dragAndDropNode;
    }

    public static final androidx.compose.ui.draganddrop.DragAndDropModifierNode DragAndDropModifierNode(Function1<? super androidx.compose.ui.draganddrop.DragAndDropEvent, Boolean> shouldStartDragAndDrop, androidx.compose.ui.draganddrop.DragAndDropTarget target) {
        DragAndDropNodeKt.DragAndDropModifierNode.2 anon = new DragAndDropNodeKt.DragAndDropModifierNode.2(shouldStartDragAndDrop, target);
        DragAndDropNode dragAndDropNode = new DragAndDropNode((Function1)anon);
        return (DragAndDropModifierNode)dragAndDropNode;
    }

    public static final boolean access$contains-Uv8p0NA(androidx.compose.ui.draganddrop.DragAndDropModifierNode $receiver, long position) {
        return DragAndDropNodeKt.contains-Uv8p0NA($receiver, position);
    }

    public static final void access$dispatchEntered(androidx.compose.ui.draganddrop.DragAndDropTarget $receiver, androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        DragAndDropNodeKt.dispatchEntered($receiver, event);
    }

    public static final void access$traverseSelfAndDescendants(TraversableNode $receiver, Function1 block) {
        DragAndDropNodeKt.traverseSelfAndDescendants($receiver, block);
    }

    private static final boolean contains-Uv8p0NA(androidx.compose.ui.draganddrop.DragAndDropModifierNode $this$contains_u2dUv8p0NA, long position) {
        int i2;
        float x-impl;
        int i;
        float y-impl;
        int cmp;
        i2 = 0;
        if (!$this$contains_u2dUv8p0NA.getNode().isAttached()) {
            return i2;
        }
        LayoutCoordinates coordinates = DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$contains_u2dUv8p0NA).getCoordinates();
        if (!coordinates.isAttached()) {
            return i2;
        }
        long size-YbymL2g = coordinates.getSize-YbymL2g();
        int i4 = 0;
        int i5 = 0;
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
        int i3 = 0;
        float $i$f$component1Impl = Offset.getX-impl(positionInRoot);
        int i7 = 0;
        float y-impl2 = Offset.getY-impl(positionInRoot);
        x-impl = Offset.getX-impl(position);
        final int i9 = 1;
        if (Float.compare($i$f$component1Impl, x-impl) <= 0 && Float.compare(x-impl, i6) <= 0) {
            i = Float.compare(x-impl, i6) <= 0 ? i9 : i2;
        } else {
        }
        if (i != 0) {
            y-impl = Offset.getY-impl(position);
            if (Float.compare(y-impl2, y-impl) <= 0 && Float.compare(y-impl, i8) <= 0) {
                i = Float.compare(y-impl, i8) <= 0 ? i9 : i2;
            } else {
            }
            if (i != 0) {
                i2 = i9;
            }
        }
        return i2;
    }

    private static final void dispatchEntered(androidx.compose.ui.draganddrop.DragAndDropTarget $this$dispatchEntered, androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        final Object obj = $this$dispatchEntered;
        final int i = 0;
        obj.onEntered(event);
        obj.onMoved(event);
    }

    private static final <T extends TraversableNode> T firstDescendantOrNull(T $this$firstDescendantOrNull, Function1<? super T, Boolean> predicate) {
        final int i = 0;
        if (!$this$firstDescendantOrNull.getNode().isAttached()) {
            return 0;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        DragAndDropNodeKt.firstDescendantOrNull.1 anon = new DragAndDropNodeKt.firstDescendantOrNull.1(predicate, objectRef);
        TraversableNodeKt.traverseDescendants($this$firstDescendantOrNull, (Function1)anon);
        return (TraversableNode)objectRef.element;
    }

    private static final <T extends TraversableNode> void traverseSelfAndDescendants(T $this$traverseSelfAndDescendants, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> block) {
        if (block.invoke($this$traverseSelfAndDescendants) != TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal) {
        }
        TraversableNodeKt.traverseDescendants($this$traverseSelfAndDescendants, block);
    }
}
