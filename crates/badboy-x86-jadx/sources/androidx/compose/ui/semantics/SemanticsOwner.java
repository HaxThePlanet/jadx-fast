package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\n¨\u0006\r", d2 = {"Landroidx/compose/ui/semantics/SemanticsOwner;", "", "rootNode", "Landroidx/compose/ui/node/LayoutNode;", "outerSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/EmptySemanticsModifier;)V", "rootSemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRootSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedRootSemanticsNode", "getUnmergedRootSemanticsNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsOwner {

    public static final int $stable = 8;
    private final androidx.compose.ui.semantics.EmptySemanticsModifier outerSemanticsNode;
    private final LayoutNode rootNode;
    static {
        final int i = 8;
    }

    public SemanticsOwner(LayoutNode rootNode, androidx.compose.ui.semantics.EmptySemanticsModifier outerSemanticsNode) {
        super();
        this.rootNode = rootNode;
        this.outerSemanticsNode = outerSemanticsNode;
    }

    public final androidx.compose.ui.semantics.SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    public final androidx.compose.ui.semantics.SemanticsNode getUnmergedRootSemanticsNode() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        SemanticsNode semanticsNode = new SemanticsNode((Modifier.Node)this.outerSemanticsNode, 0, this.rootNode, semanticsConfiguration);
        return semanticsNode;
    }
}
