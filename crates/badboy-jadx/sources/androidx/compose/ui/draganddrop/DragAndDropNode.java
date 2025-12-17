package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0000\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B*\u0012#\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J;\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\u0002\u0008\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0008\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "onDragAndDropStart", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "(Lkotlin/jvm/functions/Function1;)V", "lastChildDragAndDropModifierNode", "thisDragAndDropTarget", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "acceptDragAndDropTransfer", "", "startEvent", "drag", "", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)V", "onChanged", "onDetach", "onDrop", "onEnded", "onEntered", "onExited", "onMoved", "onStarted", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, androidx.compose.ui.draganddrop.DragAndDropModifierNode {

    public static final int $stable = 8;
    public static final androidx.compose.ui.draganddrop.DragAndDropNode.Companion Companion;
    private androidx.compose.ui.draganddrop.DragAndDropModifierNode lastChildDragAndDropModifierNode;
    private final Function1<androidx.compose.ui.draganddrop.DragAndDropEvent, androidx.compose.ui.draganddrop.DragAndDropTarget> onDragAndDropStart;
    private androidx.compose.ui.draganddrop.DragAndDropTarget thisDragAndDropTarget;
    private final Object traverseKey;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion;", "", "()V", "DragAndDropTraversableKey", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        DragAndDropNode.Companion companion = new DragAndDropNode.Companion(0);
        DragAndDropNode.Companion = companion;
        int i = 8;
    }

    public DragAndDropNode(Function1<? super androidx.compose.ui.draganddrop.DragAndDropEvent, ? extends androidx.compose.ui.draganddrop.DragAndDropTarget> onDragAndDropStart) {
        super();
        this.onDragAndDropStart = onDragAndDropStart;
        this.traverseKey = DragAndDropNode.Companion.DragAndDropTraversableKey.INSTANCE;
    }

    public static final Function1 access$getOnDragAndDropStart$p(androidx.compose.ui.draganddrop.DragAndDropNode $this) {
        return $this.onDragAndDropStart;
    }

    public static final androidx.compose.ui.draganddrop.DragAndDropTarget access$getThisDragAndDropTarget$p(androidx.compose.ui.draganddrop.DragAndDropNode $this) {
        return $this.thisDragAndDropTarget;
    }

    public static final void access$setLastChildDragAndDropModifierNode$p(androidx.compose.ui.draganddrop.DragAndDropNode $this, androidx.compose.ui.draganddrop.DragAndDropModifierNode <set-?>) {
        $this.lastChildDragAndDropModifierNode = <set-?>;
    }

    public static final void access$setThisDragAndDropTarget$p(androidx.compose.ui.draganddrop.DragAndDropNode $this, androidx.compose.ui.draganddrop.DragAndDropTarget <set-?>) {
        $this.thisDragAndDropTarget = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean acceptDragAndDropTransfer(androidx.compose.ui.draganddrop.DragAndDropEvent startEvent) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        DragAndDropNode.acceptDragAndDropTransfer.1 anon = new DragAndDropNode.acceptDragAndDropTransfer.1(startEvent, this, booleanRef);
        DragAndDropNodeKt.access$traverseSelfAndDescendants((TraversableNode)this, (Function1)anon);
        return booleanRef.element;
    }

    public void drag-12SF9DM(androidx.compose.ui.draganddrop.DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        DelegatableNodeKt.requireOwner((DelegatableNode)this).getDragAndDropManager().drag-12SF9DM(transferData, decorationSize, drawDragDecoration);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onChanged(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        androidx.compose.ui.draganddrop.DragAndDropModifierNode lastChildDragAndDropModifierNode;
        final androidx.compose.ui.draganddrop.DragAndDropTarget thisDragAndDropTarget = this.thisDragAndDropTarget;
        if (thisDragAndDropTarget == null) {
            lastChildDragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
            if (lastChildDragAndDropModifierNode != null) {
                lastChildDragAndDropModifierNode.onChanged(event);
            }
        } else {
            thisDragAndDropTarget.onChanged(event);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        final int i = 0;
        this.thisDragAndDropTarget = i;
        this.lastChildDragAndDropModifierNode = i;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean onDrop(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        int onDrop;
        final androidx.compose.ui.draganddrop.DragAndDropModifierNode lastChildDragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (lastChildDragAndDropModifierNode == null) {
            androidx.compose.ui.draganddrop.DragAndDropTarget thisDragAndDropTarget = this.thisDragAndDropTarget;
            if (thisDragAndDropTarget != null) {
                onDrop = thisDragAndDropTarget.onDrop(event);
            } else {
                onDrop = 0;
            }
        } else {
            onDrop = lastChildDragAndDropModifierNode.onDrop(event);
        }
        return onDrop;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onEnded(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        DragAndDropNode.onEnded.1 anon = new DragAndDropNode.onEnded.1(event);
        DragAndDropNodeKt.access$traverseSelfAndDescendants((TraversableNode)this, (Function1)anon);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onEntered(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        androidx.compose.ui.draganddrop.DragAndDropModifierNode lastChildDragAndDropModifierNode;
        final androidx.compose.ui.draganddrop.DragAndDropTarget thisDragAndDropTarget = this.thisDragAndDropTarget;
        if (thisDragAndDropTarget == null) {
            lastChildDragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
            if (lastChildDragAndDropModifierNode != null) {
                lastChildDragAndDropModifierNode.onEntered(event);
            }
        } else {
            thisDragAndDropTarget.onEntered(event);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onExited(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        androidx.compose.ui.draganddrop.DragAndDropTarget thisDragAndDropTarget = this.thisDragAndDropTarget;
        if (thisDragAndDropTarget != null) {
            thisDragAndDropTarget.onExited(event);
        }
        androidx.compose.ui.draganddrop.DragAndDropModifierNode lastChildDragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (lastChildDragAndDropModifierNode != null) {
            lastChildDragAndDropModifierNode.onExited(event);
        }
        this.lastChildDragAndDropModifierNode = 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onMoved(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        int i;
        boolean thisDragAndDropTarget;
        boolean z;
        long l;
        androidx.compose.ui.draganddrop.DragAndDropModifierNode match$iv;
        Object element;
        final androidx.compose.ui.draganddrop.DragAndDropModifierNode lastChildDragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        i = 0;
        l = 1;
        if (lastChildDragAndDropModifierNode != null && DragAndDropNodeKt.access$contains-Uv8p0NA(lastChildDragAndDropModifierNode, DragAndDrop_androidKt.getPositionInRoot(event)) == l) {
            l = 1;
            if (DragAndDropNodeKt.access$contains-Uv8p0NA(lastChildDragAndDropModifierNode, DragAndDrop_androidKt.getPositionInRoot(event)) == l) {
                i = l;
            }
        }
        if (i != 0) {
            match$iv = lastChildDragAndDropModifierNode;
        } else {
            i = this;
            z = 0;
            if (!(TraversableNode)i.getNode().isAttached()) {
                match$iv = 0;
            } else {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                DragAndDropNode.onMoved$$inlined.firstDescendantOrNull.1 anon = new DragAndDropNode.onMoved$$inlined.firstDescendantOrNull.1(objectRef, this, event);
                TraversableNodeKt.traverseDescendants(i, (Function1)anon);
                match$iv = element;
            }
        }
        if (match$iv != null && lastChildDragAndDropModifierNode == null) {
            if (lastChildDragAndDropModifierNode == null) {
                DragAndDropNodeKt.access$dispatchEntered((DragAndDropTarget)match$iv, event);
                thisDragAndDropTarget = this.thisDragAndDropTarget;
                if (thisDragAndDropTarget != null) {
                    thisDragAndDropTarget.onExited(event);
                }
            } else {
                if (match$iv == null && lastChildDragAndDropModifierNode != null) {
                    if (lastChildDragAndDropModifierNode != null) {
                        thisDragAndDropTarget = this.thisDragAndDropTarget;
                        if (thisDragAndDropTarget != null) {
                            DragAndDropNodeKt.access$dispatchEntered(thisDragAndDropTarget, event);
                        }
                        lastChildDragAndDropModifierNode.onExited(event);
                    } else {
                        if (!Intrinsics.areEqual(match$iv, lastChildDragAndDropModifierNode)) {
                            if (match$iv != null) {
                                DragAndDropNodeKt.access$dispatchEntered((DragAndDropTarget)match$iv, event);
                            }
                            if (lastChildDragAndDropModifierNode != null) {
                                lastChildDragAndDropModifierNode.onExited(event);
                            }
                        } else {
                            if (match$iv != null) {
                                match$iv.onMoved(event);
                            } else {
                                thisDragAndDropTarget = this.thisDragAndDropTarget;
                                if (thisDragAndDropTarget != null) {
                                    thisDragAndDropTarget.onMoved(event);
                                }
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
        this.lastChildDragAndDropModifierNode = match$iv;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onStarted(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
        androidx.compose.ui.draganddrop.DragAndDropModifierNode lastChildDragAndDropModifierNode;
        final androidx.compose.ui.draganddrop.DragAndDropTarget thisDragAndDropTarget = this.thisDragAndDropTarget;
        if (thisDragAndDropTarget == null) {
            lastChildDragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
            if (lastChildDragAndDropModifierNode != null) {
                lastChildDragAndDropModifierNode.onStarted(event);
            }
        } else {
            thisDragAndDropTarget.onStarted(event);
        }
    }
}
