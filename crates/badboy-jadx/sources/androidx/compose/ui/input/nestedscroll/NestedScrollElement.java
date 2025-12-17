package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\u0002H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000c\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0018", d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class NestedScrollElement extends ModifierNodeElement<androidx.compose.ui.input.nestedscroll.NestedScrollNode> {

    private final androidx.compose.ui.input.nestedscroll.NestedScrollConnection connection;
    private final androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher dispatcher;
    public NestedScrollElement(androidx.compose.ui.input.nestedscroll.NestedScrollConnection connection, androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher dispatcher) {
        super();
        this.connection = connection;
        this.dispatcher = dispatcher;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.input.nestedscroll.NestedScrollNode create() {
        NestedScrollNode nestedScrollNode = new NestedScrollNode(this.connection, this.dispatcher);
        return nestedScrollNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        final int i2 = 0;
        if (!other instanceof NestedScrollElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(obj.connection, this.connection)) {
            return i2;
        }
        if (!Intrinsics.areEqual(obj2.dispatcher, this.dispatcher)) {
            return i2;
        }
        return 1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.input.nestedscroll.NestedScrollConnection getConnection() {
        return this.connection;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher dispatcher = this.dispatcher;
        if (dispatcher != null) {
            i = dispatcher.hashCode();
        } else {
            i = 0;
        }
        return i3 += i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("nestedScroll");
        $this$inspectableProperties.getProperties().set("connection", this.connection);
        $this$inspectableProperties.getProperties().set("dispatcher", this.dispatcher);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((NestedScrollNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.input.nestedscroll.NestedScrollNode node) {
        node.updateNode$ui_release(this.connection, this.dispatcher);
    }
}
