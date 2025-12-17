package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0008\u001a\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013J\u0008\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0017\u001a\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0006\u0010\u0018\u001a\u00020\u0013J\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u001dH\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u001e", d2 = {"Landroidx/compose/ui/input/pointer/NodeParent;", "", "()V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/Node;", "getChildren", "()Landroidx/compose/runtime/collection/MutableVector;", "buildCache", "", "changes", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clear", "dispatchCancel", "dispatchFinalEventPass", "dispatchMainEventPass", "removeDetachedPointerInputModifierNodes", "removeInvalidPointerIdsAndChanges", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NodeParent {

    public static final int $stable;
    private final MutableVector<androidx.compose.ui.input.pointer.Node> children;
    static {
        NodeParent.$stable = MutableVector.$stable;
    }

    public NodeParent() {
        super();
        final int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new Node[16], 0);
        this.children = mutableVector;
    }

    public boolean buildCache(LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> changes, LayoutCoordinates parentCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        int changed;
        int i$iv;
        Object[] content;
        Object obj;
        int i2;
        int i;
        changed = 0;
        final MutableVector children = this.children;
        final int i3 = 0;
        final int size = children.getSize();
        if (size > 0) {
            i$iv = 0;
            i2 = 0;
            do {
                i2 = 0;
                i = 1;
                changed = i;
                if (i$iv++ < size) {
                }
                if (changed != 0) {
                } else {
                }
                i = 0;
            } while (!(Node)children.getContent()[i$iv].buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds));
        }
        return changed;
    }

    public void cleanUpHits(androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent) {
        MutableVector this_$iv;
        int children;
        int i;
        Object[] content;
        children = 0;
        size--;
        while (-1 < i) {
            int i3 = 0;
            if ((Node)this.children.getContent()[i].getPointerIds().isEmpty()) {
            }
            i--;
            this.children.removeAt(i);
        }
    }

    public final void clear() {
        this.children.clear();
    }

    public void dispatchCancel() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        final MutableVector children = this.children;
        final int i2 = 0;
        final int size = children.getSize();
        if (size > 0) {
            i$iv = 0;
            i = 0;
            (Node)children.getContent()[i$iv].dispatchCancel();
            while (i$iv++ >= size) {
                i = 0;
                (Node)content[i$iv].dispatchCancel();
            }
        }
    }

    public boolean dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent) {
        int dispatched;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        int i2;
        dispatched = 0;
        final MutableVector children = this.children;
        final int i3 = 0;
        final int size = children.getSize();
        if (size > 0) {
            i$iv = 0;
            i = 0;
            do {
                i = 0;
                i2 = 1;
                dispatched = i2;
                if (i$iv++ < size) {
                }
                if (dispatched != 0) {
                } else {
                }
                i2 = 0;
            } while (!(Node)children.getContent()[i$iv].dispatchFinalEventPass(internalPointerEvent));
        }
        cleanUpHits(internalPointerEvent);
        return dispatched;
    }

    public boolean dispatchMainEventPass(LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> changes, LayoutCoordinates parentCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        int dispatched;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        int i2;
        dispatched = 0;
        final MutableVector children = this.children;
        final int i3 = 0;
        final int size = children.getSize();
        if (size > 0) {
            i$iv = 0;
            i = 0;
            do {
                i = 0;
                i2 = 1;
                dispatched = i2;
                if (i$iv++ < size) {
                }
                if (dispatched != 0) {
                } else {
                }
                i2 = 0;
            } while (!(Node)children.getContent()[i$iv].dispatchMainEventPass(changes, parentCoordinates, internalPointerEvent, isInBounds));
        }
        return dispatched;
    }

    public final MutableVector<androidx.compose.ui.input.pointer.Node> getChildren() {
        return this.children;
    }

    public final void removeDetachedPointerInputModifierNodes() {
        int index;
        Object this_$iv;
        MutableVector attached;
        Object[] content;
        index = 0;
        while (index < this.children.getSize()) {
            int i = 0;
            this_$iv = this.children.getContent()[index];
            if (!(Node)this_$iv.getModifierNode().isAttached()) {
            } else {
            }
            index++;
            this_$iv.removeDetachedPointerInputModifierNodes();
            this_$iv.dispatchCancel();
            this.children.removeAt(index);
        }
    }

    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<androidx.compose.ui.input.pointer.Node> hitNodes) {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        final MutableVector children = this.children;
        final int i2 = 0;
        final int size = children.getSize();
        if (size > 0) {
            i$iv = 0;
            i = 0;
            (Node)children.getContent()[i$iv].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
            while (i$iv++ >= size) {
                i = 0;
                (Node)content[i$iv].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
            }
        }
    }
}
