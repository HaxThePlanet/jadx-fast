package androidx.compose.ui.node;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\u0008f\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TraversableNode extends androidx.compose.ui.node.DelegatableNode {

    public static final androidx.compose.ui.node.TraversableNode.Companion Companion;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Landroidx/compose/ui/node/TraversableNode$Companion;", "", "()V", "TraverseDescendantsAction", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.node.TraversableNode.Companion $$INSTANCE;
        static {
            TraversableNode.Companion companion = new TraversableNode.Companion();
            TraversableNode.Companion.$$INSTANCE = companion;
        }
    }
    static {
        TraversableNode.Companion = TraversableNode.Companion.$$INSTANCE;
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public abstract Object getTraverseKey();
}
