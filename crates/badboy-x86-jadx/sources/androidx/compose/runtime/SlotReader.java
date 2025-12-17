package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0010\u0015\n\u0002\u0008\u0016\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010H\u001a\u00020C2\u0008\u0008\u0002\u0010I\u001a\u00020\nJ\u0006\u0010J\u001a\u00020KJ\u0006\u0010L\u001a\u00020KJ\u000e\u0010M\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\nJ\u0006\u0010N\u001a\u00020KJ\u0006\u0010O\u001a\u00020KJ\u000c\u0010P\u001a\u0008\u0012\u0004\u0012\u00020R0QJ\u0010\u0010S\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u0010\u0010T\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u0018\u0010T\u001a\u0004\u0018\u00010\u00012\u0006\u0010U\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010H\u001a\u00020CJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010V\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\nJ\u000e\u00100\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\nJ\u0008\u0010W\u001a\u0004\u0018\u00010\u0001J\u0010\u0010X\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u000e\u00101\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u00103\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010Y\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010Z\u001a\u00020K2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010[\u001a\u00020K2\u0006\u0010I\u001a\u00020\nJ\u0006\u0010\\\u001a\u00020\nJ\u0006\u0010]\u001a\u00020KJ\u0006\u0010^\u001a\u00020KJ\u0006\u0010_\u001a\u00020KJ\u0008\u0010`\u001a\u00020aH\u0016J\u0016\u0010b\u001a\u0004\u0018\u00010\u0001*\u00020'2\u0006\u0010I\u001a\u00020\nH\u0002J\u0016\u0010X\u001a\u0004\u0018\u00010\u0001*\u00020'2\u0006\u0010I\u001a\u00020\nH\u0002J\u0016\u0010c\u001a\u0004\u0018\u00010\u0001*\u00020'2\u0006\u0010I\u001a\u00020\nH\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\rR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0017R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0017R\u0011\u0010 \u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008!\u0010\rR\u0011\u0010\"\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008#\u0010\rR\u0011\u0010$\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008%\u0010\rR\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\tR\u0011\u0010+\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008,\u0010\tR\u0011\u0010-\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008.\u0010\tR\u0011\u0010/\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008/\u0010\tR\u0011\u00100\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u00080\u0010\tR\u0011\u00101\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u00082\u0010\rR\u001e\u00103\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010\rR\u0011\u00105\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u00086\u0010\rR\u0011\u00107\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u00088\u0010\rR\u0011\u00109\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008:\u0010\rR\u0011\u0010;\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008<\u0010\rR\u0018\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?R\u000e\u0010@\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010A\u001a\"\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D\u0018\u00010Bj\u0010\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D\u0018\u0001`EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010G¨\u0006d", d2 = {"Landroidx/compose/runtime/SlotReader;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "<set-?>", "", "closed", "getClosed", "()Z", "", "currentEnd", "getCurrentEnd", "()I", "currentGroup", "getCurrentGroup", "currentSlot", "currentSlotEnd", "currentSlotStack", "Landroidx/compose/runtime/IntStack;", "emptyCount", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupNode", "getGroupNode", "groupObjectKey", "getGroupObjectKey", "groupSize", "getGroupSize", "groupSlotCount", "getGroupSlotCount", "groupSlotIndex", "getGroupSlotIndex", "groups", "", "groupsSize", "hadNext", "getHadNext", "hasObjectKey", "getHasObjectKey", "inEmpty", "getInEmpty", "isGroupEnd", "isNode", "nodeCount", "getNodeCount", "parent", "getParent", "parentNodes", "getParentNodes", "remainingSlots", "getRemainingSlots", "size", "getSize", "slot", "getSlot", "slots", "", "[Ljava/lang/Object;", "slotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "anchor", "index", "beginEmpty", "", "close", "containsMark", "endEmpty", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "get", "groupGet", "group", "hasMark", "next", "node", "parentOf", "reposition", "restoreParent", "skipGroup", "skipToGroupEnd", "startGroup", "startNode", "toString", "", "aux", "objectKey", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SlotReader {

    public static final int $stable = 8;
    private boolean closed;
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private final androidx.compose.runtime.IntStack currentSlotStack;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private boolean hadNext;
    private int parent = -1;
    private final Object[] slots;
    private final int slotsSize;
    private HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> sourceInformationMap;
    private final androidx.compose.runtime.SlotTable table;
    static {
        final int i = 8;
    }

    public SlotReader(androidx.compose.runtime.SlotTable table) {
        super();
        this.table = table;
        this.groups = this.table.getGroups();
        this.groupsSize = this.table.getGroupsSize();
        this.slots = this.table.getSlots();
        this.slotsSize = this.table.getSlotsSize();
        this.currentEnd = this.groupsSize;
        int i = -1;
        IntStack intStack = new IntStack();
        this.currentSlotStack = intStack;
    }

    public static androidx.compose.runtime.Anchor anchor$default(androidx.compose.runtime.SlotReader slotReader, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = slotReader.currentGroup;
        }
        return slotReader.anchor(obj1);
    }

    private final Object aux(int[] $this$aux, int index) {
        Object empty;
        int i;
        if (SlotTableKt.access$hasAux($this$aux, index)) {
            empty = this.slots[SlotTableKt.access$auxIndex($this$aux, index)];
        } else {
            empty = Composer.Companion.getEmpty();
        }
        return empty;
    }

    private final Object node(int[] $this$node, int index) {
        Object empty;
        int i;
        if (SlotTableKt.access$isNode($this$node, index)) {
            empty = this.slots[SlotTableKt.access$nodeIndex($this$node, index)];
        } else {
            empty = Composer.Companion.getEmpty();
        }
        return empty;
    }

    private final Object objectKey(int[] $this$objectKey, int index) {
        Object obj;
        int i;
        if (SlotTableKt.access$hasObjectKey($this$objectKey, index)) {
            obj = this.slots[SlotTableKt.access$objectKeyIndex($this$objectKey, index)];
        } else {
            obj = 0;
        }
        return obj;
    }

    public final androidx.compose.runtime.Anchor anchor(int index) {
        int i;
        Object anchor;
        ArrayList anchors$runtime_release = this.table.getAnchors$runtime_release();
        final int i2 = 0;
        final int i3 = SlotTableKt.access$search(anchors$runtime_release, index, this.groupsSize);
        if (i3 < 0) {
            int i4 = 0;
            anchor = new Anchor(index);
            anchors$runtime_release.add(-i5, anchor);
        } else {
            anchor = i;
        }
        return anchor;
    }

    public final void beginEmpty() {
        this.emptyCount = emptyCount++;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime_release(this, this.sourceInformationMap);
    }

    public final boolean containsMark(int index) {
        return SlotTableKt.access$containsMark(this.groups, index);
    }

    public final void endEmpty() {
        int i;
        String str;
        i = this.emptyCount > 0 ? 1 : 0;
        final int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            PreconditionsKt.throwIllegalArgumentException("Unbalanced begin/end empty");
        }
        this.emptyCount = value$iv--;
    }

    public final void endGroup() {
        int i2;
        int emptyCount;
        int groupsSize;
        androidx.compose.runtime.IntStack currentSlotStack;
        int slotsSize;
        int i;
        String str;
        if (this.emptyCount == 0) {
            slotsSize = 1;
            i = 0;
            i2 = this.currentGroup == this.currentEnd ? slotsSize : i;
            int i3 = 0;
            if (i2 == 0) {
                int i5 = 0;
                ComposerKt.composeImmediateRuntimeError("endGroup() not called at the end of a group");
            }
            emptyCount = SlotTableKt.access$parentAnchor(this.groups, this.parent);
            this.parent = emptyCount;
            if (emptyCount < 0) {
                groupsSize = this.groupsSize;
            } else {
                i4 += emptyCount;
            }
            this.currentEnd = groupsSize;
            str = this.currentSlotStack.pop();
            if (str < 0) {
                this.currentSlot = i;
                this.currentSlotEnd = i;
            } else {
                this.currentSlot = str;
                if (emptyCount >= groupsSize2 -= slotsSize) {
                    slotsSize = this.slotsSize;
                } else {
                    slotsSize = SlotTableKt.access$dataAnchor(this.groups, emptyCount + 1);
                }
                this.currentSlotEnd = slotsSize;
            }
        }
    }

    public final List<androidx.compose.runtime.KeyInfo> extractKeys() {
        int i2;
        int i5;
        int currentGroup;
        androidx.compose.runtime.KeyInfo keyInfo;
        int i3;
        Object objectKey;
        int childIndex;
        int i;
        int i4;
        ArrayList arrayList = new ArrayList();
        if (this.emptyCount > 0) {
            return (List)arrayList;
        }
        childIndex = currentGroup;
        i4 = i2;
        while (childIndex < this.currentEnd) {
            if (SlotTableKt.access$isNode(this.groups, childIndex)) {
            } else {
            }
            i5 = SlotTableKt.access$nodeCount(this.groups, childIndex);
            keyInfo = new KeyInfo(SlotTableKt.access$key(this.groups, childIndex), objectKey(this.groups, childIndex), childIndex, i5, i4);
            arrayList.add(keyInfo);
            childIndex += currentGroup;
            i4 = i2;
            i5 = 1;
        }
        return arrayList;
    }

    public final Object get(int index) {
        Object empty;
        currentSlot += index;
        final int i2 = 0;
        if (i < this.currentSlotEnd) {
            empty = this.slots[i];
        } else {
            empty = Composer.Companion.getEmpty();
        }
        return empty;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final Object getGroupAux() {
        Object valueOf;
        int currentGroup;
        if (this.currentGroup < this.currentEnd) {
            valueOf = aux(this.groups, this.currentGroup);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int getGroupKey() {
        int i;
        int currentGroup;
        if (this.currentGroup < this.currentEnd) {
            i = SlotTableKt.access$key(this.groups, this.currentGroup);
        } else {
            i = 0;
        }
        return i;
    }

    public final Object getGroupNode() {
        Object node;
        int currentGroup;
        if (this.currentGroup < this.currentEnd) {
            node = node(this.groups, this.currentGroup);
        } else {
            node = 0;
        }
        return node;
    }

    public final Object getGroupObjectKey() {
        Object objectKey;
        int currentGroup;
        if (this.currentGroup < this.currentEnd) {
            objectKey = objectKey(this.groups, this.currentGroup);
        } else {
            objectKey = 0;
        }
        return objectKey;
    }

    public final int getGroupSize() {
        return SlotTableKt.access$groupSize(this.groups, this.currentGroup);
    }

    public final int getGroupSlotCount() {
        int slotsSize;
        final int currentGroup = this.currentGroup;
        final int i2 = currentGroup + 1;
        if (i2 < this.groupsSize) {
            slotsSize = SlotTableKt.access$dataAnchor(this.groups, i2);
        } else {
            slotsSize = this.slotsSize;
        }
        return slotsSize - i;
    }

    public final int getGroupSlotIndex() {
        return currentSlot -= i2;
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    public final boolean getHasObjectKey() {
        int currentGroup;
        int i;
        int currentGroup2;
        if (this.currentGroup < this.currentEnd && SlotTableKt.access$hasObjectKey(this.groups, this.currentGroup)) {
            i = SlotTableKt.access$hasObjectKey(this.groups, this.currentGroup) ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean getInEmpty() {
        int i;
        i = this.emptyCount > 0 ? 1 : 0;
        return i;
    }

    public final int getNodeCount() {
        return SlotTableKt.access$nodeCount(this.groups, this.currentGroup);
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int i;
        int parent;
        if (this.parent >= 0) {
            i = SlotTableKt.access$nodeCount(this.groups, this.parent);
        } else {
            i = 0;
        }
        return i;
    }

    public final int getRemainingSlots() {
        return currentSlotEnd -= currentSlot;
    }

    public final int getSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        return currentSlot -= i2;
    }

    public final androidx.compose.runtime.SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final Object groupAux(int index) {
        return aux(this.groups, index);
    }

    public final int groupEnd(int index) {
        return i += index;
    }

    public final Object groupGet(int index) {
        return groupGet(this.currentGroup, index);
    }

    public final Object groupGet(int group, int index) {
        int slotsSize;
        Object empty;
        final int i2 = group + 1;
        if (i2 < this.groupsSize) {
            slotsSize = SlotTableKt.access$dataAnchor(this.groups, i2);
        } else {
            slotsSize = this.slotsSize;
        }
        final int i3 = i + index;
        if (i3 < slotsSize) {
            empty = this.slots[i3];
        } else {
            empty = Composer.Companion.getEmpty();
        }
        return empty;
    }

    public final int groupKey(int index) {
        return SlotTableKt.access$key(this.groups, index);
    }

    public final int groupKey(androidx.compose.runtime.Anchor anchor) {
        int i;
        int anchorIndex;
        if (anchor.getValid()) {
            i = SlotTableKt.access$key(this.groups, this.table.anchorIndex(anchor));
        } else {
            i = 0;
        }
        return i;
    }

    public final Object groupObjectKey(int index) {
        return objectKey(this.groups, index);
    }

    public final int groupSize(int index) {
        return SlotTableKt.access$groupSize(this.groups, index);
    }

    public final boolean hasMark(int index) {
        return SlotTableKt.access$hasMark(this.groups, index);
    }

    public final boolean hasObjectKey(int index) {
        return SlotTableKt.access$hasObjectKey(this.groups, index);
    }

    public final boolean isGroupEnd() {
        int i;
        boolean currentGroup;
        int currentEnd;
        if (!getInEmpty()) {
            if (this.currentGroup == this.currentEnd) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean isNode() {
        return SlotTableKt.access$isNode(this.groups, this.currentGroup);
    }

    public final boolean isNode(int index) {
        return SlotTableKt.access$isNode(this.groups, index);
    }

    public final Object next() {
        int currentSlot;
        int currentSlotEnd;
        if (this.emptyCount <= 0 && this.currentSlot >= this.currentSlotEnd) {
            if (this.currentSlot >= this.currentSlotEnd) {
            }
            this.hadNext = true;
            int currentSlot2 = this.currentSlot;
            this.currentSlot = currentSlot2 + 1;
            return this.slots[currentSlot2];
        }
        this.hadNext = false;
        return Composer.Companion.getEmpty();
    }

    public final Object node(int index) {
        Object node;
        if (SlotTableKt.access$isNode(this.groups, index)) {
            node = node(this.groups, index);
        } else {
            node = 0;
        }
        return node;
    }

    public final int nodeCount(int index) {
        return SlotTableKt.access$nodeCount(this.groups, index);
    }

    public final int parent(int index) {
        return SlotTableKt.access$parentAnchor(this.groups, index);
    }

    public final int parentOf(int index) {
        int groupsSize;
        int i;
        String string;
        StringBuilder append;
        String str;
        if (index >= 0 && index < this.groupsSize) {
            i = index < this.groupsSize ? 1 : 0;
        } else {
        }
        final int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalArgumentException(stringBuilder.append("Invalid group index ").append(index).toString());
        }
        return SlotTableKt.access$parentAnchor(this.groups, index);
    }

    public final void reposition(int index) {
        int i;
        int i2;
        int groupsSize;
        String str;
        final int i3 = 0;
        i = this.emptyCount == 0 ? 1 : i3;
        int i4 = 0;
        if (i == 0) {
            int i6 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
        }
        this.currentGroup = index;
        if (index < this.groupsSize) {
            i2 = SlotTableKt.access$parentAnchor(this.groups, index);
        } else {
            i2 = -1;
        }
        this.parent = i2;
        if (i2 < 0) {
            this.currentEnd = this.groupsSize;
        } else {
            this.currentEnd = i5 += i2;
        }
        this.currentSlot = i3;
        this.currentSlotEnd = i3;
    }

    public final void restoreParent(int index) {
        int i;
        String string;
        StringBuilder append;
        String str;
        i2 += index;
        final int currentGroup = this.currentGroup;
        final int i4 = 0;
        if (currentGroup >= index && currentGroup <= i3) {
            i = currentGroup <= i3 ? 1 : i4;
        } else {
        }
        final int i5 = 0;
        if (i == 0) {
            int i6 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            ComposerKt.composeImmediateRuntimeError(stringBuilder.append("Index ").append(index).append(" is not a parent of ").append(currentGroup).toString());
        }
        this.parent = index;
        this.currentEnd = i3;
        this.currentSlot = i4;
        this.currentSlotEnd = i4;
    }

    public final int skipGroup() {
        int i;
        int[] groups;
        int i2;
        String str;
        i = this.emptyCount == 0 ? i2 : 0;
        int i4 = 0;
        if (i == 0) {
            int i6 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot skip while in an empty region");
        }
        if (SlotTableKt.access$isNode(this.groups, this.currentGroup)) {
        } else {
            i2 = SlotTableKt.access$nodeCount(this.groups, this.currentGroup);
        }
        this.currentGroup = currentGroup += i5;
        return i2;
    }

    public final void skipToGroupEnd() {
        int i;
        String str;
        final int i2 = 0;
        i = this.emptyCount == 0 ? 1 : i2;
        final int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot skip the enclosing group while in an empty region");
        }
        this.currentGroup = this.currentEnd;
        this.currentSlot = i2;
        this.currentSlotEnd = i2;
    }

    public final void startGroup() {
        int emptyCount;
        int currentGroup;
        androidx.compose.runtime.IntStack currentSlotStack;
        int i2;
        Object value$iv;
        int slotsSize;
        int currentSlot;
        int anchor;
        int currentSlotEnd;
        int i;
        if (this.emptyCount <= 0) {
            emptyCount = this.parent;
            currentGroup = this.currentGroup;
            int i4 = 1;
            i2 = SlotTableKt.access$parentAnchor(this.groups, currentGroup) == emptyCount ? i4 : 0;
            anchor = 0;
            if (i2 == 0) {
                int i5 = 0;
                PreconditionsKt.throwIllegalArgumentException("Invalid slot table detected");
            }
            value$iv = this.sourceInformationMap;
            value$iv = value$iv.get(anchor(emptyCount));
            if (value$iv != null && (GroupSourceInformation)value$iv != null) {
                value$iv = value$iv.get(anchor(emptyCount));
                if ((GroupSourceInformation)(GroupSourceInformation)value$iv != null) {
                    (GroupSourceInformation)(GroupSourceInformation)value$iv.reportGroup(this.table, currentGroup);
                }
            }
            currentSlotStack = this.currentSlotStack;
            currentSlot = this.currentSlot;
            if (currentSlot == 0 && this.currentSlotEnd == 0) {
                if (this.currentSlotEnd == 0) {
                    currentSlotStack.push(-1);
                } else {
                    currentSlotStack.push(currentSlot);
                }
            } else {
            }
            this.parent = currentGroup;
            this.currentEnd = i6 += currentGroup;
            this.currentGroup = currentGroup + 1;
            this.currentSlot = SlotTableKt.access$slotAnchor(this.groups, currentGroup);
            if (currentGroup >= groupsSize -= i4) {
                slotsSize = this.slotsSize;
            } else {
                slotsSize = SlotTableKt.access$dataAnchor(this.groups, currentGroup + 1);
            }
            this.currentSlotEnd = slotsSize;
        }
    }

    public final void startNode() {
        int emptyCount;
        int i;
        String str;
        i = 0;
        if (this.emptyCount <= 0 && !SlotTableKt.access$isNode(this.groups, this.currentGroup)) {
            i = 0;
            if (!SlotTableKt.access$isNode(this.groups, this.currentGroup)) {
                int i2 = 0;
                PreconditionsKt.throwIllegalArgumentException("Expected a node group");
            }
            startGroup();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SlotReader(current=").append(this.currentGroup).append(", key=").append(getGroupKey()).append(", parent=").append(this.parent).append(", end=").append(this.currentEnd).append(')').toString();
    }
}
