package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\u0005H\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher;", "", "()V", "cachedNodes", "", "Landroidx/compose/ui/node/LayoutNode;", "[Landroidx/compose/ui/node/LayoutNode;", "layoutNodes", "Landroidx/compose/runtime/collection/MutableVector;", "dispatch", "", "dispatchHierarchy", "layoutNode", "isNotEmpty", "", "onNodePositioned", "node", "onRootNodePositioned", "rootNode", "remove", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnPositionedDispatcher {

    public static final int $stable = 0;
    public static final androidx.compose.ui.node.OnPositionedDispatcher.Companion Companion = null;
    private static final int MinArraySize = 16;
    private androidx.compose.ui.node.LayoutNode[] cachedNodes;
    private final MutableVector<androidx.compose.ui.node.LayoutNode> layoutNodes;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion;", "", "()V", "MinArraySize", "", "DepthComparator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        OnPositionedDispatcher.Companion companion = new OnPositionedDispatcher.Companion(0);
        OnPositionedDispatcher.Companion = companion;
        OnPositionedDispatcher.$stable = 8;
    }

    public OnPositionedDispatcher() {
        super();
        final int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new LayoutNode[16], 0);
        this.layoutNodes = mutableVector;
    }

    private final void dispatchHierarchy(androidx.compose.ui.node.LayoutNode layoutNode) {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        layoutNode.dispatchOnPositionedCallbacks$ui_release();
        layoutNode.setNeedsOnPositionedDispatch$ui_release(false);
        final int i3 = 0;
        final MutableVector mutableVector = layoutNode.get_children$ui_release();
        final int i4 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            i = 0;
            dispatchHierarchy((LayoutNode)mutableVector.getContent()[i$iv$iv]);
            while (i$iv$iv++ >= size) {
                i = 0;
                dispatchHierarchy((LayoutNode)content[i$iv$iv]);
            }
        }
    }

    public final void dispatch() {
        androidx.compose.ui.node.LayoutNode[] cache;
        int length;
        int i2;
        int i;
        int this_$iv;
        int needsOnPositionedDispatch$ui_release;
        Object[] content;
        this.layoutNodes.sortWith((Comparator)OnPositionedDispatcher.Companion.DepthComparator.INSTANCE);
        int i3 = 0;
        int size = this.layoutNodes.getSize();
        final androidx.compose.ui.node.LayoutNode[] cachedNodes = this.cachedNodes;
        if (cachedNodes != null) {
            if (cachedNodes.length < size) {
                cache = new LayoutNode[Math.max(16, this.layoutNodes.getSize())];
            } else {
                cache = cachedNodes;
            }
        } else {
        }
        this.cachedNodes = 0;
        i2 = 0;
        while (i2 < size) {
            needsOnPositionedDispatch$ui_release = 0;
            cache[i2] = this.layoutNodes.getContent()[i2];
            i2++;
        }
        this.layoutNodes.clear();
        i = size + -1;
        while (-1 < i) {
            this_$iv = cache[i];
            Intrinsics.checkNotNull(this_$iv);
            if (this_$iv.getNeedsOnPositionedDispatch$ui_release()) {
            }
            i--;
            dispatchHierarchy(this_$iv);
        }
        this.cachedNodes = cache;
    }

    public final boolean isNotEmpty() {
        return this.layoutNodes.isNotEmpty();
    }

    public final void onNodePositioned(androidx.compose.ui.node.LayoutNode node) {
        final int i = 0;
        this.layoutNodes.add(node);
        node.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void onRootNodePositioned(androidx.compose.ui.node.LayoutNode rootNode) {
        this.layoutNodes.clear();
        final int i = 0;
        this.layoutNodes.add(rootNode);
        rootNode.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void remove(androidx.compose.ui.node.LayoutNode node) {
        this.layoutNodes.remove(node);
    }
}
