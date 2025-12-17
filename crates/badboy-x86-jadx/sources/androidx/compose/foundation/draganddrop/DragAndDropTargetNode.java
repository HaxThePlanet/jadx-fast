package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0003\u0018\u00002\u00020\u0001B0\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u000e\u001a\u00020\u000fH\u0002J\u0008\u0010\u0010\u001a\u00020\u000fH\u0016J\u0008\u0010\u0011\u001a\u00020\u000fH\u0016J1\u0010\u0012\u001a\u00020\u000f2!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00032\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropTargetNode;", "Landroidx/compose/ui/node/DelegatingNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/draganddrop/DragAndDropTarget;)V", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "createAndAttachDragAndDropModifierNode", "", "onAttach", "onDetach", "update", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DragAndDropTargetNode extends DelegatingNode {

    private DragAndDropModifierNode dragAndDropNode;
    private Function1<? super DragAndDropEvent, Boolean> shouldStartDragAndDrop;
    private DragAndDropTarget target;
    public DragAndDropTargetNode(Function1<? super DragAndDropEvent, Boolean> shouldStartDragAndDrop, DragAndDropTarget target) {
        super();
        this.shouldStartDragAndDrop = shouldStartDragAndDrop;
        this.target = target;
    }

    public static final Function1 access$getShouldStartDragAndDrop$p(androidx.compose.foundation.draganddrop.DragAndDropTargetNode $this) {
        return $this.shouldStartDragAndDrop;
    }

    private final void createAndAttachDragAndDropModifierNode() {
        DragAndDropTargetNode.createAndAttachDragAndDropModifierNode.1 anon = new DragAndDropTargetNode.createAndAttachDragAndDropModifierNode.1(this);
        this.dragAndDropNode = (DragAndDropModifierNode)delegate((DelegatableNode)DragAndDropNodeKt.DragAndDropModifierNode((Function1)anon, this.target));
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onAttach() {
        createAndAttachDragAndDropModifierNode();
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onDetach() {
        final DragAndDropModifierNode dragAndDropNode = this.dragAndDropNode;
        Intrinsics.checkNotNull(dragAndDropNode);
        undelegate((DelegatableNode)dragAndDropNode);
    }

    public final void update(Function1<? super DragAndDropEvent, Boolean> shouldStartDragAndDrop, DragAndDropTarget target) {
        boolean dragAndDropNode;
        int i;
        DragAndDropModifierNode dragAndDropModifierNode;
        this.shouldStartDragAndDrop = shouldStartDragAndDrop;
        dragAndDropNode = this.dragAndDropNode;
        if (!Intrinsics.areEqual(target, this.target) && dragAndDropNode != null) {
            dragAndDropNode = this.dragAndDropNode;
            if (dragAndDropNode != null) {
                i = 0;
                undelegate((DelegatableNode)dragAndDropNode);
            }
            this.target = target;
            createAndAttachDragAndDropModifierNode();
        }
    }
}
