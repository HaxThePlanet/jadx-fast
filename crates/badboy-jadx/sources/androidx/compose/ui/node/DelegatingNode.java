package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0002H\r\"\u0008\u0008\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0004¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0002H\r\"\u0008\u0008\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0001¢\u0006\u0004\u0008\u0012\u0010\u0010J\"\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0016H\u0080\u0008¢\u0006\u0002\u0008\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008\u0019J\r\u0010\u001a\u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008\u001bJ\r\u0010\u001c\u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008\u001dJ\r\u0010\u001e\u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008\u001fJ\r\u0010 \u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008!J\u0015\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0001H\u0010¢\u0006\u0002\u0008$J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000eH\u0004J\u0015\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0008(J\u0017\u0010)\u001a\u00020\u00142\u0008\u0010*\u001a\u0004\u0018\u00010+H\u0010¢\u0006\u0002\u0008,J\u0018\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0001H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\tX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u000c¨\u00064", d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "delegate", "getDelegate$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "selfKindSet", "", "getSelfKindSet$ui_release$annotations", "getSelfKindSet$ui_release", "()I", "T", "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "delegateUnprotected", "delegateUnprotected$ui_release", "forEachImmediateDelegate", "", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui_release", "markAsAttached", "markAsAttached$ui_release", "markAsDetached", "markAsDetached$ui_release", "reset", "reset$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "undelegate", "instance", "undelegateUnprotected", "undelegateUnprotected$ui_release", "updateCoordinator", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DelegatingNode extends Modifier.Node {

    public static final int $stable = 8;
    private Modifier.Node delegate;
    private final int selfKindSet;
    static {
        final int i = 8;
    }

    public DelegatingNode() {
        super();
        this.selfKindSet = NodeKindKt.calculateNodeKindSetFrom((Modifier.Node)this);
    }

    public static void getSelfKindSet$ui_release$annotations() {
    }

    private final void updateNodeKindSet(int newKindSet, boolean recalculateOwner) {
        int agg;
        boolean attached;
        androidx.compose.ui.node.DelegatableNode it;
        int aggregateChildKindSet$ui_release;
        setKindSet$ui_release(newKindSet);
        if (getKindSet$ui_release() != newKindSet && DelegatableNodeKt.isDelegationRoot((DelegatableNode)this)) {
            if (DelegatableNodeKt.isDelegationRoot((DelegatableNode)this)) {
                setAggregateChildKindSet$ui_release(newKindSet);
            }
            if (isAttached()) {
                attached = getNode();
                it = this;
                while (it != null) {
                    it.setKindSet$ui_release(agg |= aggregateChildKindSet$ui_release);
                    if (it != attached) {
                    }
                    it = it.getParent$ui_release();
                }
                if (recalculateOwner && it == attached) {
                    if (it == attached) {
                        attached.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(attached));
                    }
                }
                aggregateChildKindSet$ui_release = it.getChild$ui_release();
                if (it != null && aggregateChildKindSet$ui_release != null) {
                    aggregateChildKindSet$ui_release = it.getChild$ui_release();
                    if (aggregateChildKindSet$ui_release != null) {
                        aggregateChildKindSet$ui_release = aggregateChildKindSet$ui_release.getAggregateChildKindSet$ui_release();
                    } else {
                        aggregateChildKindSet$ui_release = 0;
                    }
                } else {
                }
                agg |= aggregateChildKindSet$ui_release;
                while (it != null) {
                    it.setAggregateChildKindSet$ui_release(agg |= aggregateChildKindSet$ui_release);
                    it = it.getParent$ui_release();
                }
            }
        }
    }

    private final void validateDelegateKindSet(int delegateKindSet, Modifier.Node delegateNode) {
        int $i$f$getLayoutOLwlOKw;
        int i2;
        int $i$a$CheckPreconditionDelegatingNode$validateDelegateKindSet$1;
        int append;
        int str;
        int i;
        int i3 = 0;
        i2 = 2;
        append = 0;
        final int i6 = 0;
        $i$f$getLayoutOLwlOKw = $i$a$CheckPreconditionDelegatingNode$validateDelegateKindSet$1 & $i$f$getLayoutOLwlOKw2 != 0 ? i : i6;
        if ($i$f$getLayoutOLwlOKw != 0) {
            int i4 = 0;
            $i$a$CheckPreconditionDelegatingNode$validateDelegateKindSet$1 = 0;
            if (i2 & $i$f$getLayoutOLwlOKw != 0) {
            } else {
                i = i6;
            }
            i2 = 0;
            if (i != 0 && !this instanceof LayoutModifierNode) {
                i2 = 0;
                if (!this instanceof LayoutModifierNode) {
                    int i5 = 0;
                    StringBuilder stringBuilder = new StringBuilder();
                    InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: ").append(this).append("\nDelegate Node: ").append(delegateNode).toString());
                }
            }
        }
    }

    protected final <T extends androidx.compose.ui.node.DelegatableNode> T delegate(T delegatableNode) {
        int coordinator$ui_release;
        int node;
        int i4;
        int parent$ui_release;
        int i3;
        Modifier.Node equal;
        String $i$a$CheckPreconditionDelegatingNode$delegate$1;
        boolean $i$f$getLayoutOLwlOKw;
        int i5;
        int i2;
        int i6;
        int i;
        final Modifier.Node node2 = delegatableNode.getNode();
        coordinator$ui_release = 1;
        node = 0;
        i4 = node2 != delegatableNode ? coordinator$ui_release : node;
        parent$ui_release = 0;
        if (i4 != 0) {
            if (delegatableNode instanceof Modifier.Node) {
                i3 = delegatableNode;
            } else {
                i3 = parent$ui_release;
            }
            if (i3 != 0) {
                parent$ui_release = i3.getParent$ui_release();
            }
            if (node2 == getNode() && Intrinsics.areEqual(parent$ui_release, this)) {
                if (Intrinsics.areEqual(parent$ui_release, this)) {
                } else {
                    coordinator$ui_release = node;
                }
            } else {
            }
            if (coordinator$ui_release == 0) {
            } else {
                return delegatableNode;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot delegate to an already delegated node".toString());
            throw illegalStateException;
        }
        int i8 = 0;
        if (attached ^= coordinator$ui_release == 0) {
            int i12 = 0;
            InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
        }
        node2.setAsDelegateTo$ui_release(getNode());
        int nodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node2);
        node2.setKindSet$ui_release(nodeKindSetFromIncludingDelegates);
        validateDelegateKindSet(nodeKindSetFromIncludingDelegates, node2);
        node2.setChild$ui_release(this.delegate);
        this.delegate = node2;
        node2.setParent$ui_release((Modifier.Node)this);
        updateNodeKindSet(kindSet$ui_release2 |= nodeKindSetFromIncludingDelegates, node);
        if (isAttached()) {
            int i10 = 0;
            i5 = 2;
            i6 = 0;
            $i$f$getLayoutOLwlOKw = i2 & $i$f$getLayoutOLwlOKw2 != 0 ? coordinator$ui_release : node;
            if ($i$f$getLayoutOLwlOKw != 0) {
                int i11 = 0;
                i2 = 0;
                if (i5 & $i$f$getLayoutOLwlOKw != 0) {
                } else {
                    coordinator$ui_release = node;
                }
                if (coordinator$ui_release == 0) {
                    getNode().updateCoordinator$ui_release(parent$ui_release);
                    DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getNodes$ui_release().syncCoordinators();
                } else {
                    updateCoordinator$ui_release(getCoordinator$ui_release());
                }
            } else {
            }
            node2.markAsAttached$ui_release();
            node2.runAttachLifecycle$ui_release();
            NodeKindKt.autoInvalidateInsertedNode(node2);
        }
        return delegatableNode;
    }

    public final <T extends androidx.compose.ui.node.DelegatableNode> T delegateUnprotected$ui_release(T delegatableNode) {
        return delegate(delegatableNode);
    }

    public final void forEachImmediateDelegate$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node node;
        final int i = 0;
        node = getDelegate$ui_release();
        while (node != null) {
            block.invoke(node);
            node = node.getChild$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Modifier.Node getDelegate$ui_release() {
        return this.delegate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int getSelfKindSet$ui_release() {
        return this.selfKindSet;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void markAsAttached$ui_release() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        boolean attached;
        super.markAsAttached$ui_release();
        final int i2 = 0;
        node$iv = this.getDelegate$ui_release();
        while (node$iv != null) {
            node = node$iv;
            i = 0;
            node.updateCoordinator$ui_release(getCoordinator$ui_release());
            if (!node.isAttached()) {
            }
            node$iv = node$iv.getChild$ui_release();
            node.markAsAttached$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void markAsDetached$ui_release() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        final int i2 = 0;
        node$iv = this.getDelegate$ui_release();
        while (node$iv != null) {
            i = 0;
            node$iv.markAsDetached$ui_release();
            node$iv = node$iv.getChild$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void reset$ui_release() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        super.reset$ui_release();
        final int i2 = 0;
        node$iv = this.getDelegate$ui_release();
        while (node$iv != null) {
            i = 0;
            node$iv.reset$ui_release();
            node$iv = node$iv.getChild$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void runAttachLifecycle$ui_release() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        final int i2 = 0;
        node$iv = this.getDelegate$ui_release();
        while (node$iv != null) {
            i = 0;
            node$iv.runAttachLifecycle$ui_release();
            node$iv = node$iv.getChild$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void runDetachLifecycle$ui_release() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        super.runDetachLifecycle$ui_release();
        final int i2 = 0;
        node$iv = this.getDelegate$ui_release();
        while (node$iv != null) {
            i = 0;
            node$iv.runDetachLifecycle$ui_release();
            node$iv = node$iv.getChild$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void setAsDelegateTo$ui_release(Modifier.Node owner) {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        super.setAsDelegateTo$ui_release(owner);
        final int i2 = 0;
        node$iv = this.getDelegate$ui_release();
        while (node$iv != null) {
            i = 0;
            node$iv.setAsDelegateTo$ui_release(owner);
            node$iv = node$iv.getChild$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setDelegate$ui_release(Modifier.Node <set-?>) {
        this.delegate = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    protected final void undelegate(androidx.compose.ui.node.DelegatableNode instance) {
        int prev;
        Modifier.Node it;
        int found;
        int i2;
        int nodes$ui_release;
        Modifier.Node child$ui_release;
        int node;
        boolean value$iv;
        int i4;
        int i;
        int i3;
        int i5;
        prev = 0;
        it = this.delegate;
        found = 0;
        i2 = 0;
        nodes$ui_release = 0;
        while (it != null) {
            if (it == instance) {
                break;
            } else {
            }
            prev = it;
            it = it.getChild$ui_release();
            i2 = 0;
            nodes$ui_release = 0;
        }
        if (found == 0) {
        } else {
            int nodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates((Modifier.Node)this);
            node = 1;
            updateNodeKindSet(nodeKindSetFromIncludingDelegates, node);
            if (isAttached()) {
                int i6 = 0;
                i4 = 2;
                i3 = 0;
                value$iv = i & $i$f$getLayoutOLwlOKw != 0 ? node : nodes$ui_release;
                int i7 = 0;
                i = 0;
                if (value$iv != 0 && i4 & value$iv != 0) {
                    i7 = 0;
                    i = 0;
                    if (i4 & value$iv != 0) {
                        nodes$ui_release = node;
                    }
                    if (nodes$ui_release == 0) {
                        getNode().updateCoordinator$ui_release(i2);
                        DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getNodes$ui_release().syncCoordinators();
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Could not find delegate: ").append(instance).toString().toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void undelegateUnprotected$ui_release(androidx.compose.ui.node.DelegatableNode instance) {
        undelegate(instance);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void updateCoordinator$ui_release(androidx.compose.ui.node.NodeCoordinator coordinator) {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        super.updateCoordinator$ui_release(coordinator);
        final int i2 = 0;
        node$iv = this.getDelegate$ui_release();
        while (node$iv != null) {
            i = 0;
            node$iv.updateCoordinator$ui_release(coordinator);
            node$iv = node$iv.getChild$ui_release();
        }
    }
}
