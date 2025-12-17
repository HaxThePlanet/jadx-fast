package androidx.compose.ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u001e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020 2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "hitPointerIdsAndNodes", "Landroidx/collection/MutableLongObjectMap;", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/input/pointer/Node;", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNodes", "", "Landroidx/compose/ui/Modifier$Node;", "prunePointerIdsAndChangesNotInNodesList", "", "addHitPath-QJqDSyo", "(JLjava/util/List;Z)V", "clearPreviouslyHitModifierNodeCache", "dispatchChanges", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "processCancel", "removeDetachedPointerInputNodes", "removeInvalidPointerIdsAndChanges", "", "hitNodes", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HitPathTracker {

    public static final int $stable = 8;
    private final MutableLongObjectMap<MutableObjectList<androidx.compose.ui.input.pointer.Node>> hitPointerIdsAndNodes;
    private final androidx.compose.ui.input.pointer.NodeParent root;
    private final LayoutCoordinates rootCoordinates;
    static {
        final int i = 8;
    }

    public HitPathTracker(LayoutCoordinates rootCoordinates) {
        super();
        this.rootCoordinates = rootCoordinates;
        NodeParent nodeParent = new NodeParent();
        this.root = nodeParent;
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(10);
        this.hitPointerIdsAndNodes = mutableLongObjectMap;
    }

    public static void addHitPath-QJqDSyo$default(androidx.compose.ui.input.pointer.HitPathTracker hitPathTracker, long l2, List list3, boolean z4, int i5, Object object6) {
        int obj4;
        if (object6 &= 4 != 0) {
            obj4 = 0;
        }
        hitPathTracker.addHitPath-QJqDSyo(l2, list3, z4);
    }

    public static boolean dispatchChanges$default(androidx.compose.ui.input.pointer.HitPathTracker hitPathTracker, androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent2, obj2);
    }

    private final void removeInvalidPointerIdsAndChanges(long pointerId, MutableObjectList<androidx.compose.ui.input.pointer.Node> hitNodes) {
        this.root.removeInvalidPointerIdsAndChanges(pointerId, hitNodes);
    }

    public final void addHitPath-QJqDSyo(long pointerId, List<? extends Modifier.Node> pointerInputNodes, boolean prunePointerIdsAndChangesNotInNodesList) {
        long hitPointerIdsAndNodes2;
        MutableObjectList list;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        androidx.compose.ui.input.pointer.NodeParent parent;
        int merging;
        int i6;
        int size;
        int hitPointerIdsAndNodes;
        int j$iv$iv;
        int i3;
        int $i$f$isFull;
        Object metadata;
        int i7;
        Object i$iv$iv;
        int slot$iv$iv;
        int size2;
        int i$iv;
        Object[] content;
        int i;
        androidx.compose.ui.input.pointer.NodeParent parent2;
        int i2;
        int $i$f$forEach;
        long[] k$iv;
        long l;
        int i5;
        int i4;
        final Object obj = this;
        hitPointerIdsAndNodes2 = pointerId;
        parent = obj.root;
        obj.hitPointerIdsAndNodes.clear();
        merging = 1;
        i6 = 0;
        j$iv$iv = 1;
        while (i6 < prunePointerIdsAndChangesNotInNodesList.size()) {
            metadata = prunePointerIdsAndChangesNotInNodesList.get(i6);
            i7 = 0;
            if (merging != 0) {
            } else {
            }
            parent2 = parent;
            i2 = merging;
            Node parent3 = new Node((Modifier.Node)metadata);
            int i17 = 0;
            slot$iv$iv = parent3.getPointerIds();
            slot$iv$iv.add-0FcD4WY(hitPointerIdsAndNodes2);
            hitPointerIdsAndNodes = obj.hitPointerIdsAndNodes;
            i$iv$iv = pointerId;
            size2 = 0;
            if (hitPointerIdsAndNodes.get(i$iv$iv) == null) {
            }
            (MutableObjectList)i$iv.add(parent3);
            parent2.getChildren().add(parent3);
            parent = hitPointerIdsAndNodes2;
            i6++;
            hitPointerIdsAndNodes2 = pointerId;
            j$iv$iv = 1;
            int i18 = 0;
            content = 0;
            hitPointerIdsAndNodes2 = new MutableObjectList(0, j$iv$iv, i7);
            j$iv$iv = 0;
            hitPointerIdsAndNodes.set(i$iv$iv, slot$iv$iv);
            i$iv = hitPointerIdsAndNodes2;
            i$iv$iv = parent.getChildren();
            slot$iv$iv = 0;
            size2 = i$iv$iv.getSize();
            if (size2 > 0) {
            } else {
            }
            i = i7;
            hitPointerIdsAndNodes = i;
            if ((Node)hitPointerIdsAndNodes != 0) {
            } else {
            }
            parent2 = parent;
            i2 = merging;
            merging = 0;
            (Node)hitPointerIdsAndNodes.markIsIn();
            hitPointerIdsAndNodes.getPointerIds().add-0FcD4WY(hitPointerIdsAndNodes2);
            i$iv$iv = obj.hitPointerIdsAndNodes;
            slot$iv$iv = pointerId;
            i$iv = 0;
            if (i$iv$iv.get(slot$iv$iv) == null) {
            } else {
            }
            parent2 = parent;
            i2 = merging;
            (MutableObjectList)content.add(hitPointerIdsAndNodes);
            parent = i12;
            merging = i2;
            int i19 = 0;
            i = 0;
            parent2 = parent;
            i2 = merging;
            parent = new MutableObjectList(0, j$iv$iv, i7);
            j$iv$iv = 0;
            i$iv$iv.set(slot$iv$iv, size2);
            content = parent;
            i$iv = 0;
            i2 = 0;
            while (Intrinsics.areEqual((Node)i$iv$iv.getContent()[i$iv].getModifierNode(), metadata)) {
                i2 = 0;
            }
            if (i$iv++ >= size2) {
            } else {
            }
        }
        $i$f$isFull = prunePointerIdsAndChangesNotInNodesList;
        androidx.compose.ui.input.pointer.NodeParent nodeParent = parent;
        int i21 = merging;
        $this$maskEmptyOrDeleted$iv$iv$iv = 0;
        if (obj28 != null) {
            hitPointerIdsAndNodes2 = obj.hitPointerIdsAndNodes;
            hitPointerIdsAndNodes = 0;
            metadata = size.metadata;
            length += -2;
            if (0 <= i7) {
            } else {
                $i$f$forEach = parent;
                k$iv = merging;
            }
        }
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        this.root.clear();
    }

    public final boolean dispatchChanges(androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        int i;
        if (!this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds)) {
            return 0;
        }
        if (!this.root.dispatchFinalEventPass(internalPointerEvent)) {
            if (this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds)) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    public final androidx.compose.ui.input.pointer.NodeParent getRoot$ui_release() {
        return this.root;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        clearPreviouslyHitModifierNodeCache();
    }

    public final void removeDetachedPointerInputNodes() {
        this.root.removeDetachedPointerInputModifierNodes();
    }
}
