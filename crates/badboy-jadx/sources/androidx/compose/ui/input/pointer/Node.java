package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0016\u001a\u00020\u00082\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0008H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0008\u0010\u001e\u001a\u00020\u001dH\u0002J\u0008\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00082\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0017\u0010!\u001a\u00020\u00082\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u001d0#H\u0082\u0008J.\u0010$\u001a\u00020\u00082\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0008H\u0016J\u001a\u0010%\u001a\u00020\u00082\u0008\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020\rH\u0002J\u0006\u0010(\u001a\u00020\u001dJ\u001e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\u00000-H\u0016J\u0008\u0010.\u001a\u00020/H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060", d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "removeInvalidPointerIdsAndChanges", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Node extends androidx.compose.ui.input.pointer.NodeParent {

    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private boolean hasExited = true;
    private boolean isIn = true;
    private final Modifier.Node modifierNode;
    private androidx.compose.ui.input.pointer.PointerEvent pointerEvent;
    private final PointerIdArray pointerIds;
    private final LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> relevantChanges;
    private boolean wasIn;
    static {
        final int i = 8;
    }

    public Node(Modifier.Node modifierNode) {
        super();
        this.modifierNode = modifierNode;
        PointerIdArray pointerIdArray = new PointerIdArray();
        this.pointerIds = pointerIdArray;
        LongSparseArray longSparseArray = new LongSparseArray(2);
        this.relevantChanges = longSparseArray;
        int i = 1;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = 0;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        final int i = 0;
        final int i3 = 0;
        if (this.relevantChanges.isEmpty()) {
            return i3;
        }
        if (!this.modifierNode.isAttached()) {
            return i3;
        }
        block.invoke();
        return 1;
    }

    private final boolean hasPositionChanged(androidx.compose.ui.input.pointer.PointerEvent oldEvent, androidx.compose.ui.input.pointer.PointerEvent newEvent) {
        int size;
        int i;
        int size2;
        Object obj2;
        Object obj;
        boolean equals-impl0;
        long position-F1C5BW0;
        int i2 = 1;
        if (oldEvent != null) {
            if (oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            } else {
                i = 0;
                while (i < newEvent.getChanges().size()) {
                    i++;
                }
            }
            return 0;
        }
        return i2;
    }

    public boolean buildCache(LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> changes, LayoutCoordinates parentCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        boolean activeHoverEvent-0FcD4WY;
        LayoutCoordinates layoutCoordinates;
        int i16;
        boolean childChanged3;
        int childChanged4;
        int childChanged2;
        PointerIdArray pointerIds;
        int j;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2;
        int copy-OHpmEuE$default;
        int i14;
        int keyAt;
        int i8;
        boolean positionChanged;
        int i4;
        boolean isIn;
        boolean hasExited;
        int $i$f$getPointerInputOLwlOKw;
        int enter-7fucELk;
        int contains;
        List list;
        int stack$iv;
        Modifier.Node node$iv;
        int index$iv$iv;
        int size;
        int count$iv;
        long layoutCoordinates2;
        int historical;
        Modifier.Node node$iv$iv;
        Modifier.Node node3;
        int i10;
        int this_$iv$iv;
        int i11;
        int i17;
        int i9;
        boolean childChanged;
        Modifier.Node node;
        Modifier.Node node2;
        int i15;
        int i12;
        int i7;
        long historicalChange;
        long localPositionOf-R5De75A2;
        int localPositionOf-R5De75A3;
        kotlin.jvm.internal.DefaultConstructorMarker constructor;
        int originalEventPosition-F1C5BW0$ui_release;
        long localPositionOf-R5De75A;
        long l;
        int i5;
        int i;
        ArrayList list2;
        int i2;
        int i3;
        int i13;
        int i6;
        final Object obj = this;
        activeHoverEvent-0FcD4WY = changes;
        layoutCoordinates = parentCoordinates;
        final androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent2 = internalPointerEvent;
        childChanged3 = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        if (!obj.modifierNode.isAttached()) {
            return 1;
        }
        int i21 = 0;
        $i$f$getPointerInputOLwlOKw = NodeKind.constructor-impl(16);
        contains = 0;
        stack$iv = 0;
        int i24 = 0;
        node$iv = $this$dispatchForKind_u2d6rFNWt0$iv;
        size = 0;
        while (node$iv != null) {
            if (node$iv instanceof PointerInputModifierNode) {
            } else {
            }
            layoutCoordinates2 = 0;
            if (kindSet$ui_release &= $i$f$getPointerInputOLwlOKw != 0) {
            } else {
            }
            count$iv = size;
            if (count$iv != 0 && node$iv instanceof DelegatingNode) {
            } else {
            }
            childChanged = childChanged3;
            node = $this$dispatchForKind_u2d6rFNWt0$iv;
            node$iv = DelegatableNodeKt.access$pop(stack$iv);
            childChanged3 = childChanged;
            $this$dispatchForKind_u2d6rFNWt0$iv = node;
            keyAt = 1;
            size = 0;
            if (node$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv = 0;
            historical = 0;
            node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
            while (node$iv$iv != null) {
                node3 = node$iv$iv;
                i10 = 0;
                i11 = 0;
                if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv = size;
                if (this_$iv$iv != 0) {
                } else {
                }
                childChanged = childChanged3;
                node = $this$dispatchForKind_u2d6rFNWt0$iv;
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node3;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                childChanged3 = childChanged;
                $this$dispatchForKind_u2d6rFNWt0$iv = node;
                keyAt = 1;
                if (count$iv++ == keyAt) {
                } else {
                }
                if (stack$iv == 0) {
                } else {
                }
                childChanged = childChanged3;
                node = $this$dispatchForKind_u2d6rFNWt0$iv;
                childChanged4 = stack$iv;
                stack$iv = childChanged4;
                childChanged3 = node$iv;
                if (childChanged3 != null && stack$iv != 0) {
                }
                if (stack$iv != 0) {
                } else {
                }
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node3;
                stack$iv.add(node3);
                if (stack$iv != 0) {
                }
                node$iv = $this$dispatchForKind_u2d6rFNWt0$iv;
                stack$iv.add(childChanged3);
                this_$iv$iv = 0;
                i9 = 0;
                childChanged = childChanged3;
                node = $this$dispatchForKind_u2d6rFNWt0$iv;
                childChanged4 = new MutableVector(new Modifier.Node[16], size);
                node$iv = node3;
                childChanged = childChanged3;
                node = $this$dispatchForKind_u2d6rFNWt0$iv;
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node3;
                this_$iv$iv = keyAt;
            }
            if (count$iv == 1) {
            } else {
            }
            childChanged3 = childChanged;
            $this$dispatchForKind_u2d6rFNWt0$iv = node;
            keyAt = 1;
            node3 = node$iv$iv;
            i10 = 0;
            i11 = 0;
            if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
            } else {
            }
            this_$iv$iv = size;
            if (this_$iv$iv != 0) {
            } else {
            }
            childChanged = childChanged3;
            node = $this$dispatchForKind_u2d6rFNWt0$iv;
            $this$dispatchForKind_u2d6rFNWt0$iv2 = node3;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            childChanged3 = childChanged;
            $this$dispatchForKind_u2d6rFNWt0$iv = node;
            keyAt = 1;
            if (count$iv++ == keyAt) {
            } else {
            }
            if (stack$iv == 0) {
            } else {
            }
            childChanged = childChanged3;
            node = $this$dispatchForKind_u2d6rFNWt0$iv;
            childChanged4 = stack$iv;
            stack$iv = childChanged4;
            childChanged3 = node$iv;
            if (childChanged3 != null && stack$iv != 0) {
            }
            if (stack$iv != 0) {
            } else {
            }
            $this$dispatchForKind_u2d6rFNWt0$iv2 = node3;
            stack$iv.add(node3);
            if (stack$iv != 0) {
            }
            node$iv = $this$dispatchForKind_u2d6rFNWt0$iv;
            stack$iv.add(childChanged3);
            this_$iv$iv = 0;
            i9 = 0;
            childChanged = childChanged3;
            node = $this$dispatchForKind_u2d6rFNWt0$iv;
            childChanged4 = new MutableVector(new Modifier.Node[16], size);
            node$iv = node3;
            childChanged = childChanged3;
            node = $this$dispatchForKind_u2d6rFNWt0$iv;
            $this$dispatchForKind_u2d6rFNWt0$iv2 = node3;
            this_$iv$iv = keyAt;
            count$iv = keyAt;
            count$iv = 0;
            obj.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode)node$iv);
            childChanged = childChanged3;
            node = $this$dispatchForKind_u2d6rFNWt0$iv;
        }
        node2 = $this$dispatchForKind_u2d6rFNWt0$iv;
        childChanged2 = 0;
        copy-OHpmEuE$default = activeHoverEvent-0FcD4WY.size();
        while (childChanged2 < copy-OHpmEuE$default) {
            keyAt = activeHoverEvent-0FcD4WY.keyAt(childChanged2);
            node2 = valueAt;
            if (obj.pointerIds.contains(keyAt)) {
            } else {
            }
            this_$iv$iv = childChanged2;
            i6 = copy-OHpmEuE$default;
            childChanged2 = this_$iv$iv + 1;
            copy-OHpmEuE$default = i6;
            size = 0;
            contains = (PointerInputChange)node2.getPreviousPosition-F1C5BW0();
            count$iv = node2.getPosition-F1C5BW0();
            if (Offset.isValid-impl(contains) && Offset.isValid-impl(count$iv)) {
            } else {
            }
            this_$iv$iv = childChanged2;
            i6 = copy-OHpmEuE$default;
            if (Offset.isValid-impl(count$iv)) {
            } else {
            }
            node$iv = new ArrayList(node2.getHistorical().size());
            historical = node2.getHistorical();
            node$iv$iv = 0;
            size = historical.size();
            this_$iv$iv = childChanged2;
            j = node3;
            while (j < size) {
                i9 = node3;
                i15 = 0;
                long position-F1C5BW0 = (HistoricalChange)i9.getPosition-F1C5BW0();
                if (Offset.isValid-impl(position-F1C5BW0)) {
                } else {
                }
                i7 = size;
                j = i12 + 1;
                size = i7;
                copy-OHpmEuE$default = i6;
                i7 = size;
                LayoutCoordinates coordinates4 = obj.coordinates;
                Intrinsics.checkNotNull(coordinates4);
                historicalChange = new HistoricalChange(i9.getUptimeMillis(), obj28, coordinates4.localPositionOf-R5De75A(layoutCoordinates, position-F1C5BW0), constructor, i9.getOriginalEventPosition-F1C5BW0$ui_release(), localPositionOf-R5De75A, 0);
                node$iv.add(historicalChange);
            }
            i6 = copy-OHpmEuE$default;
            LayoutCoordinates coordinates = obj.coordinates;
            Intrinsics.checkNotNull(coordinates);
            LayoutCoordinates coordinates2 = obj.coordinates;
            Intrinsics.checkNotNull(coordinates2);
            obj.relevantChanges.put(keyAt, $i$f$getPointerInputOLwlOKw);
            i9 = node3;
            i15 = 0;
            position-F1C5BW0 = (HistoricalChange)i9.getPosition-F1C5BW0();
            if (Offset.isValid-impl(position-F1C5BW0)) {
            } else {
            }
            i7 = size;
            j = i12 + 1;
            size = i7;
            copy-OHpmEuE$default = i6;
            i7 = size;
            coordinates4 = obj.coordinates;
            Intrinsics.checkNotNull(coordinates4);
            historicalChange = new HistoricalChange(i9.getUptimeMillis(), obj28, coordinates4.localPositionOf-R5De75A(layoutCoordinates, position-F1C5BW0), constructor, i9.getOriginalEventPosition-F1C5BW0$ui_release(), localPositionOf-R5De75A, 0);
            node$iv.add(historicalChange);
        }
        int i25 = childChanged2;
        if (obj.relevantChanges.isEmpty()) {
            obj.pointerIds.clear();
            obj.getChildren().clear();
            return 1;
        }
        int i26 = 1;
        size3--;
        while (-1 < i8) {
            if (!activeHoverEvent-0FcD4WY.containsKey(obj.pointerIds.get-_I2yYro(i8))) {
            }
            i8--;
            obj.pointerIds.removeAt(i8);
        }
        ArrayList arrayList = new ArrayList(obj.relevantChanges.size());
        i14 = 0;
        while (i14 < obj.relevantChanges.size()) {
            arrayList.add(obj.relevantChanges.valueAt(i14));
            i14++;
        }
        PointerEvent i20 = new PointerEvent((List)arrayList, internalPointerEvent2);
        list = positionChanged;
        int i23 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            historical = 0;
            node3 = 0;
            index$iv$iv++;
            activeHoverEvent-0FcD4WY = changes;
            layoutCoordinates = parentCoordinates;
        }
        layoutCoordinates2 = 0;
        long l2 = layoutCoordinates2;
        if ((PointerInputChange)l2 != 0) {
            if (!isInBounds) {
                obj.isIn = false;
                i17 = 1;
            } else {
                i16 = 0;
                if (!obj.isIn) {
                    if (!(PointerInputChange)l2.getPressed()) {
                        if (l2.getPreviousPressed()) {
                            LayoutCoordinates coordinates3 = obj.coordinates;
                            Intrinsics.checkNotNull(coordinates3);
                            i17 = 1;
                            obj.isIn = outOfBounds-O0kMr_c ^= 1;
                        } else {
                            i17 = 1;
                        }
                    } else {
                    }
                } else {
                    i17 = 1;
                }
            }
            if (obj.isIn != obj.wasIn) {
                if (!PointerEventType.equals-impl0(i20.getType-7fucELk(), PointerEventType.Companion.getMove-7fucELk()) && !PointerEventType.equals-impl0(i20.getType-7fucELk(), PointerEventType.Companion.getEnter-7fucELk())) {
                    if (!PointerEventType.equals-impl0(i20.getType-7fucELk(), PointerEventType.Companion.getEnter-7fucELk())) {
                        if (PointerEventType.equals-impl0(i20.getType-7fucELk(), PointerEventType.Companion.getExit-7fucELk())) {
                            if (obj.isIn) {
                                positionChanged = PointerEventType.Companion.getEnter-7fucELk();
                            } else {
                                positionChanged = PointerEventType.Companion.getExit-7fucELk();
                            }
                            i20.setType-EhbLWgg$ui_release(positionChanged);
                        } else {
                            if (PointerEventType.equals-impl0(i20.getType-7fucELk(), PointerEventType.Companion.getEnter-7fucELk()) && obj.wasIn && !obj.hasExited) {
                                if (obj.wasIn) {
                                    if (!obj.hasExited) {
                                        i20.setType-EhbLWgg$ui_release(PointerEventType.Companion.getMove-7fucELk());
                                    } else {
                                        if (PointerEventType.equals-impl0(i20.getType-7fucELk(), PointerEventType.Companion.getExit-7fucELk()) && obj.isIn && l2.getPressed()) {
                                            if (obj.isIn) {
                                                if (l2.getPressed()) {
                                                    i20.setType-EhbLWgg$ui_release(PointerEventType.Companion.getMove-7fucELk());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
            i16 = 0;
            i17 = 1;
        }
        if (!childChanged3 && PointerEventType.equals-impl0(i20.getType-7fucELk(), PointerEventType.Companion.getMove-7fucELk())) {
            if (PointerEventType.equals-impl0(i20.getType-7fucELk(), PointerEventType.Companion.getMove-7fucELk())) {
                if (obj.hasPositionChanged(obj.pointerEvent, i20)) {
                    i4 = i17;
                } else {
                    i4 = i16;
                }
            } else {
            }
        } else {
        }
        obj.pointerEvent = i20;
        return i4;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent) {
        androidx.compose.ui.input.pointer.PointerEvent pointerEvent;
        List changes;
        int index$iv;
        int i2;
        Object obj;
        Object obj2;
        int i5;
        int i4;
        int pointerIds;
        int i;
        int i3;
        androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent2;
        androidx.compose.ui.input.pointer.PointerEvent event;
        List list;
        final Object obj3 = this;
        super.cleanUpHits(internalPointerEvent);
        pointerEvent = obj3.pointerEvent;
        if (pointerEvent == null) {
        }
        obj3.wasIn = obj3.isIn;
        final int i6 = 0;
        index$iv = 0;
        while (index$iv < pointerEvent.getChanges().size()) {
            obj2 = obj;
            i5 = 0;
            pointerIds = 1;
            pressed ^= pointerIds;
            if (i4 != 0) {
            } else {
            }
            if (i4 != 0 && isIn2 ^= pointerIds != 0) {
            }
            if (i2 != 0) {
            } else {
            }
            event = pointerEvent;
            list = changes;
            index$iv++;
            pointerEvent = event;
            changes = list;
            event = pointerEvent;
            list = changes;
            obj3.pointerIds.remove-0FcD4WY(obj2.getId-J3iCeTQ());
            if (isIn2 ^= pointerIds != 0) {
            }
            i2 = pointerIds;
            if (activeHoverEvent-0FcD4WY ^= pointerIds == 0) {
            } else {
            }
        }
        List list2 = changes;
        obj3.isIn = false;
        obj3.hasExited = PointerEventType.equals-impl0(pointerEvent.getType-7fucELk(), PointerEventType.Companion.getExit-7fucELk());
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        Object this_$iv;
        int i6;
        int mutableVector;
        int i$iv;
        Object[] content;
        int stack$iv;
        Object obj;
        Modifier.Node node$iv;
        int this_$iv$iv2;
        int i;
        int i3;
        int i2;
        Modifier.Node node$iv$iv;
        Modifier.Node node;
        int i5;
        int this_$iv$iv;
        int i4;
        int i7;
        MutableVector children = getChildren();
        int i8 = 0;
        int size = children.getSize();
        if (size > 0) {
            i$iv = 0;
            this_$iv$iv2 = 0;
            (Node)children.getContent()[i$iv].dispatchCancel();
            while (i$iv += mutableVector >= size) {
                this_$iv$iv2 = 0;
                (Node)content[i$iv].dispatchCancel();
            }
        }
        int i9 = 0;
        int $i$f$getPointerInputOLwlOKw = NodeKind.constructor-impl(16);
        int i11 = 0;
        stack$iv = 0;
        int i12 = 0;
        node$iv = modifierNode;
        while (node$iv != null) {
            if (node$iv instanceof PointerInputModifierNode) {
            } else {
            }
            i = 0;
            i2 = 0;
            if (kindSet$ui_release &= $i$f$getPointerInputOLwlOKw != 0) {
            } else {
            }
            this_$iv$iv2 = i2;
            if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
            } else {
            }
            i6 = mutableVector;
            node$iv = DelegatableNodeKt.access$pop(stack$iv);
            mutableVector = i6;
            this_$iv = this;
            if (node$iv instanceof DelegatingNode) {
            } else {
            }
            this_$iv$iv2 = 0;
            i3 = 0;
            node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
            while (node$iv$iv != null) {
                node = node$iv$iv;
                i5 = 0;
                i4 = 0;
                if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv = i2;
                if (this_$iv$iv != 0) {
                }
                node$iv$iv = node$iv$iv.getChild$ui_release();
                mutableVector = 1;
                this_$iv = this;
                if (this_$iv$iv2++ == mutableVector) {
                } else {
                }
                if (stack$iv == 0) {
                } else {
                }
                mutableVector = stack$iv;
                stack$iv = mutableVector;
                this_$iv = node$iv;
                if (this_$iv != null && stack$iv != 0) {
                }
                if (stack$iv != 0) {
                }
                stack$iv.add(node);
                if (stack$iv != 0) {
                }
                node$iv = mutableVector;
                stack$iv.add(this_$iv);
                this_$iv$iv = 0;
                i7 = 0;
                mutableVector = new MutableVector(new Modifier.Node[16], i2);
                node$iv = node;
                this_$iv$iv = mutableVector;
            }
            i6 = 1;
            if (this_$iv$iv2 == i6) {
            } else {
            }
            mutableVector = i6;
            this_$iv = this;
            node = node$iv$iv;
            i5 = 0;
            i4 = 0;
            if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
            } else {
            }
            this_$iv$iv = i2;
            if (this_$iv$iv != 0) {
            }
            node$iv$iv = node$iv$iv.getChild$ui_release();
            mutableVector = 1;
            this_$iv = this;
            if (this_$iv$iv2++ == mutableVector) {
            } else {
            }
            if (stack$iv == 0) {
            } else {
            }
            mutableVector = stack$iv;
            stack$iv = mutableVector;
            this_$iv = node$iv;
            if (this_$iv != null && stack$iv != 0) {
            }
            if (stack$iv != 0) {
            }
            stack$iv.add(node);
            if (stack$iv != 0) {
            }
            node$iv = mutableVector;
            stack$iv.add(this_$iv);
            this_$iv$iv = 0;
            i7 = 0;
            mutableVector = new MutableVector(new Modifier.Node[16], i2);
            node$iv = node;
            this_$iv$iv = mutableVector;
            this_$iv$iv2 = mutableVector;
            i = 0;
            (PointerInputModifierNode)node$iv.onCancelPointerInput();
            i6 = mutableVector;
        }
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent) {
        Object this_$iv2;
        MutableVector this_$iv;
        int $i$f$dispatchIfNeeded2;
        Modifier.Node $i$f$dispatchIfNeeded;
        boolean attached;
        int size;
        androidx.compose.ui.input.pointer.PointerEvent pointerEvent;
        long size-YbymL2g;
        Modifier.Node i$iv;
        int $i$f$getPointerInputOLwlOKw;
        int i5;
        int stack$iv;
        Modifier.Node node$iv;
        int i;
        int this_$iv$iv;
        Modifier.Node final;
        int i7;
        Modifier.Node node$iv$iv;
        Modifier.Node node;
        int i3;
        int this_$iv$iv2;
        int i4;
        int i6;
        Object this_$iv3;
        int i2;
        final Object obj = this;
        this_$iv2 = this;
        $i$f$dispatchIfNeeded2 = 0;
        size = 0;
        if (this_$iv2.relevantChanges.isEmpty()) {
            node$iv = internalPointerEvent;
        } else {
            if (!this_$iv2.modifierNode.isAttached()) {
                node$iv = internalPointerEvent;
            } else {
                attached = 0;
                pointerEvent = obj.pointerEvent;
                Intrinsics.checkNotNull(pointerEvent);
                LayoutCoordinates coordinates = obj.coordinates;
                Intrinsics.checkNotNull(coordinates);
                int i8 = 0;
                $i$f$getPointerInputOLwlOKw = NodeKind.constructor-impl(16);
                i5 = 0;
                stack$iv = 0;
                int i10 = 0;
                node$iv = i$iv;
                while (node$iv != null) {
                    if (node$iv instanceof PointerInputModifierNode) {
                    } else {
                    }
                    final = 0;
                    if (kindSet$ui_release &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv = size;
                    if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv3 = this_$iv2;
                    i2 = $i$f$dispatchIfNeeded2;
                    node$iv = DelegatableNodeKt.access$pop(stack$iv);
                    this_$iv2 = this_$iv3;
                    $i$f$dispatchIfNeeded2 = i2;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    i7 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        node = node$iv$iv;
                        i3 = 0;
                        i4 = 0;
                        if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv2 = size;
                        if (this_$iv$iv2 != 0) {
                        } else {
                        }
                        this_$iv3 = this_$iv2;
                        i2 = $i$f$dispatchIfNeeded2;
                        $i$f$dispatchIfNeeded = node;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        this_$iv2 = this_$iv3;
                        $i$f$dispatchIfNeeded2 = i2;
                        i = 1;
                        if (this_$iv$iv++ == i) {
                        } else {
                        }
                        if (stack$iv == 0) {
                        } else {
                        }
                        this_$iv3 = this_$iv2;
                        i2 = $i$f$dispatchIfNeeded2;
                        this_$iv = stack$iv;
                        stack$iv = this_$iv;
                        this_$iv2 = node$iv;
                        if (this_$iv2 != null && stack$iv != null) {
                        }
                        if (stack$iv != null) {
                        } else {
                        }
                        $i$f$dispatchIfNeeded = node;
                        stack$iv.add(node);
                        if (stack$iv != null) {
                        }
                        node$iv = $i$f$dispatchIfNeeded2;
                        stack$iv.add(this_$iv2);
                        this_$iv$iv2 = 0;
                        i6 = 0;
                        this_$iv3 = this_$iv2;
                        i2 = $i$f$dispatchIfNeeded2;
                        this_$iv = new MutableVector(new Modifier.Node[16], size);
                        node$iv = node;
                        this_$iv3 = this_$iv2;
                        i2 = $i$f$dispatchIfNeeded2;
                        $i$f$dispatchIfNeeded = node;
                        this_$iv$iv2 = i;
                    }
                    if (this_$iv$iv == 1) {
                    } else {
                    }
                    this_$iv2 = this_$iv3;
                    $i$f$dispatchIfNeeded2 = i2;
                    node = node$iv$iv;
                    i3 = 0;
                    i4 = 0;
                    if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv2 = size;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    this_$iv3 = this_$iv2;
                    i2 = $i$f$dispatchIfNeeded2;
                    $i$f$dispatchIfNeeded = node;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    this_$iv2 = this_$iv3;
                    $i$f$dispatchIfNeeded2 = i2;
                    i = 1;
                    if (this_$iv$iv++ == i) {
                    } else {
                    }
                    if (stack$iv == 0) {
                    } else {
                    }
                    this_$iv3 = this_$iv2;
                    i2 = $i$f$dispatchIfNeeded2;
                    this_$iv = stack$iv;
                    stack$iv = this_$iv;
                    this_$iv2 = node$iv;
                    if (this_$iv2 != null && stack$iv != null) {
                    }
                    if (stack$iv != null) {
                    } else {
                    }
                    $i$f$dispatchIfNeeded = node;
                    stack$iv.add(node);
                    if (stack$iv != null) {
                    }
                    node$iv = $i$f$dispatchIfNeeded2;
                    stack$iv.add(this_$iv2);
                    this_$iv$iv2 = 0;
                    i6 = 0;
                    this_$iv3 = this_$iv2;
                    i2 = $i$f$dispatchIfNeeded2;
                    this_$iv = new MutableVector(new Modifier.Node[16], size);
                    node$iv = node;
                    this_$iv3 = this_$iv2;
                    i2 = $i$f$dispatchIfNeeded2;
                    $i$f$dispatchIfNeeded = node;
                    this_$iv$iv2 = i;
                    this_$iv$iv = i;
                    this_$iv$iv = 0;
                    (PointerInputModifierNode)node$iv.onPointerEvent-H0pRuoY(pointerEvent, PointerEventPass.Final, coordinates.getSize-YbymL2g());
                    this_$iv3 = this_$iv2;
                    i2 = $i$f$dispatchIfNeeded2;
                }
                this_$iv3 = this_$iv2;
                i2 = $i$f$dispatchIfNeeded2;
                if (obj.modifierNode.isAttached()) {
                    this_$iv2 = obj.getChildren();
                    $i$f$dispatchIfNeeded2 = 0;
                    size = this_$iv2.getSize();
                    if (size > 0) {
                        i$iv = 0;
                        stack$iv = 0;
                        (Node)this_$iv2.getContent()[i$iv].dispatchFinalEventPass(internalPointerEvent);
                        i4 = 1;
                        while (i$iv++ >= size) {
                            stack$iv = 0;
                            (Node)$i$f$getPointerInputOLwlOKw[i$iv].dispatchFinalEventPass(internalPointerEvent);
                            i4 = 1;
                        }
                    } else {
                        node$iv = internalPointerEvent;
                        i4 = 1;
                    }
                } else {
                    node$iv = internalPointerEvent;
                    i4 = 1;
                }
                size = i4;
            }
        }
        cleanUpHits(internalPointerEvent);
        obj.clearCache();
        return size;
    }

    public boolean dispatchMainEventPass(LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> changes, LayoutCoordinates parentCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Object obj;
        int i6;
        int capacity$iv$iv$iv;
        Object this_$iv;
        int this_$iv3;
        boolean attached;
        Modifier.Node modifierNode;
        int $this$dispatchForKind_u2d6rFNWt0$iv;
        int $this$dispatchForKind_u2d6rFNWt0$iv3;
        int $this$dispatchForKind_u2d6rFNWt0$iv2;
        int $i$f$dispatchIfNeeded2;
        Modifier.Node $i$f$dispatchIfNeeded;
        int next$iv;
        int attached2;
        boolean z;
        int i;
        androidx.compose.ui.input.pointer.PointerEvent pointerEvent;
        long size-YbymL2g;
        Modifier.Node modifierNode2;
        int $i$f$getPointerInputOLwlOKw;
        int count$iv2;
        int count$iv3;
        int count$iv;
        int stack$iv;
        Modifier.Node node$iv;
        int node$iv$iv2;
        Modifier.Node node;
        int i5;
        int i7;
        Modifier.Node node$iv$iv;
        Modifier.Node this_$iv$iv;
        int i4;
        Modifier.Node this_$iv$iv2;
        int i9;
        int i3;
        Object this_$iv2;
        int i8;
        int i2;
        obj = this;
        this_$iv = this;
        $i$f$dispatchIfNeeded2 = 0;
        i = 0;
        if (this_$iv.relevantChanges.isEmpty()) {
            node = internalPointerEvent;
            $this$dispatchForKind_u2d6rFNWt0$iv2 = i;
            z = isInBounds;
        } else {
            if (!this_$iv.modifierNode.isAttached()) {
                node = internalPointerEvent;
                $this$dispatchForKind_u2d6rFNWt0$iv2 = i;
                z = isInBounds;
            } else {
                attached2 = 0;
                pointerEvent = obj.pointerEvent;
                Intrinsics.checkNotNull(pointerEvent);
                LayoutCoordinates coordinates = obj.coordinates;
                Intrinsics.checkNotNull(coordinates);
                size-YbymL2g = coordinates.getSize-YbymL2g();
                int i13 = 0;
                $i$f$getPointerInputOLwlOKw = NodeKind.constructor-impl(16);
                count$iv = 0;
                stack$iv = 0;
                int i15 = 0;
                node$iv = modifierNode2;
                while (node$iv != null) {
                    if (node$iv instanceof PointerInputModifierNode) {
                    } else {
                    }
                    node = 0;
                    if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    count$iv3 = i;
                    if (count$iv3 != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv2 = this_$iv;
                    i8 = $i$f$dispatchIfNeeded2;
                    node$iv = DelegatableNodeKt.access$pop(stack$iv);
                    count$iv2 = i5;
                    this_$iv = this_$iv2;
                    $i$f$dispatchIfNeeded2 = i8;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv3 = 0;
                    i7 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        this_$iv$iv = node$iv$iv;
                        i4 = 0;
                        i9 = 0;
                        if (kindSet$ui_release4 &= $i$f$getPointerInputOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv2 = i;
                        if (this_$iv$iv2 != 0) {
                        } else {
                        }
                        this_$iv2 = this_$iv;
                        i8 = $i$f$dispatchIfNeeded2;
                        $i$f$dispatchIfNeeded = this_$iv$iv;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        this_$iv = this_$iv2;
                        $i$f$dispatchIfNeeded2 = i8;
                        node$iv$iv2 = 1;
                        if (count$iv3++ == node$iv$iv2) {
                        } else {
                        }
                        if (stack$iv == 0) {
                        } else {
                        }
                        this_$iv2 = this_$iv;
                        i8 = $i$f$dispatchIfNeeded2;
                        this_$iv3 = stack$iv;
                        stack$iv = this_$iv3;
                        this_$iv = node$iv;
                        if (this_$iv != null && stack$iv != 0) {
                        }
                        if (stack$iv != 0) {
                        } else {
                        }
                        $i$f$dispatchIfNeeded = this_$iv$iv;
                        stack$iv.add(this_$iv$iv);
                        if (stack$iv != 0) {
                        }
                        node$iv = $i$f$dispatchIfNeeded2;
                        stack$iv.add(this_$iv);
                        this_$iv$iv2 = 0;
                        i3 = 0;
                        this_$iv2 = this_$iv;
                        i8 = $i$f$dispatchIfNeeded2;
                        this_$iv3 = new MutableVector(new Modifier.Node[16], i);
                        node$iv = this_$iv$iv;
                        this_$iv2 = this_$iv;
                        i8 = $i$f$dispatchIfNeeded2;
                        $i$f$dispatchIfNeeded = this_$iv$iv;
                        this_$iv$iv2 = node$iv$iv2;
                    }
                    if (count$iv3 == 1) {
                    } else {
                    }
                    count$iv2 = i5;
                    this_$iv = this_$iv2;
                    $i$f$dispatchIfNeeded2 = i8;
                    this_$iv$iv = node$iv$iv;
                    i4 = 0;
                    i9 = 0;
                    if (kindSet$ui_release4 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv2 = i;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    this_$iv2 = this_$iv;
                    i8 = $i$f$dispatchIfNeeded2;
                    $i$f$dispatchIfNeeded = this_$iv$iv;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    this_$iv = this_$iv2;
                    $i$f$dispatchIfNeeded2 = i8;
                    node$iv$iv2 = 1;
                    if (count$iv3++ == node$iv$iv2) {
                    } else {
                    }
                    if (stack$iv == 0) {
                    } else {
                    }
                    this_$iv2 = this_$iv;
                    i8 = $i$f$dispatchIfNeeded2;
                    this_$iv3 = stack$iv;
                    stack$iv = this_$iv3;
                    this_$iv = node$iv;
                    if (this_$iv != null && stack$iv != 0) {
                    }
                    if (stack$iv != 0) {
                    } else {
                    }
                    $i$f$dispatchIfNeeded = this_$iv$iv;
                    stack$iv.add(this_$iv$iv);
                    if (stack$iv != 0) {
                    }
                    node$iv = $i$f$dispatchIfNeeded2;
                    stack$iv.add(this_$iv);
                    this_$iv$iv2 = 0;
                    i3 = 0;
                    this_$iv2 = this_$iv;
                    i8 = $i$f$dispatchIfNeeded2;
                    this_$iv3 = new MutableVector(new Modifier.Node[16], i);
                    node$iv = this_$iv$iv;
                    this_$iv2 = this_$iv;
                    i8 = $i$f$dispatchIfNeeded2;
                    $i$f$dispatchIfNeeded = this_$iv$iv;
                    this_$iv$iv2 = node$iv$iv2;
                    count$iv3 = node$iv$iv2;
                    node = 0;
                    i5 = count$iv2;
                    (PointerInputModifierNode)node$iv.onPointerEvent-H0pRuoY(pointerEvent, PointerEventPass.Initial, size-YbymL2g);
                    this_$iv2 = this_$iv;
                    i8 = $i$f$dispatchIfNeeded2;
                }
                this_$iv2 = this_$iv;
                i8 = $i$f$dispatchIfNeeded2;
                if (obj.modifierNode.isAttached()) {
                    attached = obj.getChildren();
                    $i$f$dispatchIfNeeded2 = 0;
                    modifierNode2 = attached.getSize();
                    if (modifierNode2 > 0) {
                        $i$f$getPointerInputOLwlOKw = 0;
                        stack$iv = 0;
                        node$iv$iv2 = obj.coordinates;
                        Intrinsics.checkNotNull(node$iv$iv2);
                        (Node)attached.getContent()[$i$f$getPointerInputOLwlOKw].dispatchMainEventPass(obj.relevantChanges, node$iv$iv2, internalPointerEvent, isInBounds);
                        i9 = 1;
                        while ($i$f$getPointerInputOLwlOKw++ >= modifierNode2) {
                            i = 0;
                            stack$iv = 0;
                            node$iv$iv2 = obj.coordinates;
                            Intrinsics.checkNotNull(node$iv$iv2);
                            (Node)count$iv2[$i$f$getPointerInputOLwlOKw].dispatchMainEventPass(obj.relevantChanges, node$iv$iv2, internalPointerEvent, isInBounds);
                            i9 = 1;
                        }
                    } else {
                        node = internalPointerEvent;
                        z = isInBounds;
                    }
                } else {
                    node = internalPointerEvent;
                    z = isInBounds;
                }
                if (obj.modifierNode.isAttached()) {
                    int i12 = 0;
                    $i$f$dispatchIfNeeded2 = NodeKind.constructor-impl(count$iv2);
                    modifierNode2 = 0;
                    $i$f$getPointerInputOLwlOKw = 0;
                    int i14 = 0;
                    count$iv2 = modifierNode;
                    while (count$iv2 != null) {
                        if (count$iv2 instanceof PointerInputModifierNode) {
                        } else {
                        }
                        stack$iv = 0;
                        if (kindSet$ui_release &= $i$f$dispatchIfNeeded2 != 0) {
                        } else {
                        }
                        count$iv = 0;
                        if (count$iv != 0 && count$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv2 = modifierNode;
                        i3 = $i$f$dispatchIfNeeded2;
                        i6 = 0;
                        $this$dispatchForKind_u2d6rFNWt0$iv = 1;
                        count$iv2 = DelegatableNodeKt.access$pop($i$f$getPointerInputOLwlOKw);
                        obj = this;
                        modifierNode = this_$iv$iv2;
                        $i$f$dispatchIfNeeded2 = i3;
                        if (count$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv = 0;
                        node$iv = null;
                        node$iv$iv2 = (DelegatingNode)count$iv2.getDelegate$ui_release();
                        while (node$iv$iv2 != 0) {
                            i5 = node$iv$iv2;
                            node$iv$iv = null;
                            i4 = 0;
                            if (kindSet$ui_release3 &= $i$f$dispatchIfNeeded2 != 0) {
                            } else {
                            }
                            this_$iv$iv = 0;
                            if (this_$iv$iv != 0) {
                            } else {
                            }
                            this_$iv$iv2 = modifierNode;
                            i3 = $i$f$dispatchIfNeeded2;
                            next$iv = i5;
                            capacity$iv$iv$iv = 0;
                            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                            obj = this;
                            modifierNode = this_$iv$iv2;
                            $i$f$dispatchIfNeeded2 = i3;
                            if (count$iv++ == 1) {
                            } else {
                            }
                            if ($i$f$getPointerInputOLwlOKw == 0) {
                            } else {
                            }
                            this_$iv$iv2 = modifierNode;
                            i3 = $i$f$dispatchIfNeeded2;
                            capacity$iv$iv$iv = 0;
                            $this$dispatchForKind_u2d6rFNWt0$iv3 = $i$f$getPointerInputOLwlOKw;
                            $i$f$getPointerInputOLwlOKw = $this$dispatchForKind_u2d6rFNWt0$iv3;
                            modifierNode = count$iv2;
                            if (modifierNode != null && $i$f$getPointerInputOLwlOKw != 0) {
                            }
                            if ($i$f$getPointerInputOLwlOKw != 0) {
                            } else {
                            }
                            next$iv = i5;
                            $i$f$getPointerInputOLwlOKw.add(i5);
                            if ($i$f$getPointerInputOLwlOKw != 0) {
                            }
                            count$iv2 = $i$f$dispatchIfNeeded2;
                            $i$f$getPointerInputOLwlOKw.add(modifierNode);
                            this_$iv$iv = i11;
                            int $i$f$mutableVectorOf = 16;
                            i4 = 0;
                            this_$iv$iv2 = modifierNode;
                            i3 = $i$f$dispatchIfNeeded2;
                            i2 = $i$f$mutableVectorOf;
                            $this$dispatchForKind_u2d6rFNWt0$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            count$iv2 = i5;
                            this_$iv$iv2 = modifierNode;
                            i3 = $i$f$dispatchIfNeeded2;
                            next$iv = i5;
                            capacity$iv$iv$iv = 0;
                            this_$iv$iv = 1;
                        }
                        i6 = 0;
                        if (count$iv == 1) {
                        } else {
                        }
                        obj = this;
                        modifierNode = this_$iv$iv2;
                        $i$f$dispatchIfNeeded2 = i3;
                        i5 = node$iv$iv2;
                        node$iv$iv = null;
                        i4 = 0;
                        if (kindSet$ui_release3 &= $i$f$dispatchIfNeeded2 != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv2 = modifierNode;
                        i3 = $i$f$dispatchIfNeeded2;
                        next$iv = i5;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                        obj = this;
                        modifierNode = this_$iv$iv2;
                        $i$f$dispatchIfNeeded2 = i3;
                        if (count$iv++ == 1) {
                        } else {
                        }
                        if ($i$f$getPointerInputOLwlOKw == 0) {
                        } else {
                        }
                        this_$iv$iv2 = modifierNode;
                        i3 = $i$f$dispatchIfNeeded2;
                        capacity$iv$iv$iv = 0;
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $i$f$getPointerInputOLwlOKw;
                        $i$f$getPointerInputOLwlOKw = $this$dispatchForKind_u2d6rFNWt0$iv3;
                        modifierNode = count$iv2;
                        if (modifierNode != null && $i$f$getPointerInputOLwlOKw != 0) {
                        }
                        if ($i$f$getPointerInputOLwlOKw != 0) {
                        } else {
                        }
                        next$iv = i5;
                        $i$f$getPointerInputOLwlOKw.add(i5);
                        if ($i$f$getPointerInputOLwlOKw != 0) {
                        }
                        count$iv2 = $i$f$dispatchIfNeeded2;
                        $i$f$getPointerInputOLwlOKw.add(modifierNode);
                        this_$iv$iv = i11;
                        $i$f$mutableVectorOf = 16;
                        i4 = 0;
                        this_$iv$iv2 = modifierNode;
                        i3 = $i$f$dispatchIfNeeded2;
                        i2 = $i$f$mutableVectorOf;
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        count$iv2 = i5;
                        this_$iv$iv2 = modifierNode;
                        i3 = $i$f$dispatchIfNeeded2;
                        next$iv = i5;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                        count$iv = 1;
                        stack$iv = 0;
                        (PointerInputModifierNode)count$iv2.onPointerEvent-H0pRuoY(pointerEvent, PointerEventPass.Main, size-YbymL2g);
                        this_$iv$iv2 = modifierNode;
                        i3 = $i$f$dispatchIfNeeded2;
                        i6 = 0;
                        $this$dispatchForKind_u2d6rFNWt0$iv = 1;
                    }
                    this_$iv$iv2 = modifierNode;
                    i3 = $i$f$dispatchIfNeeded2;
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = 1;
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = 1;
                }
            }
        }
        return $this$dispatchForKind_u2d6rFNWt0$iv2;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public final void markIsIn() {
        this.isIn = true;
    }

    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<androidx.compose.ui.input.pointer.Node> hitNodes) {
        boolean relevantChanges;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        if (this.pointerIds.contains(pointerIdValue) && !obj10.contains(this)) {
            if (!obj10.contains(this)) {
                this.pointerIds.remove(pointerIdValue);
                this.relevantChanges.remove(pointerIdValue);
            }
        }
        MutableVector children = getChildren();
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

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Node(pointerInputFilter=").append(this.modifierNode).append(", children=").append(getChildren()).append(", pointerIds=").append(this.pointerIds).append(')').toString();
    }
}
