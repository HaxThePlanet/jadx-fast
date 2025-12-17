package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u000c\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00062\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0006J\u001e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006J\u0016\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004R\u001a\u0010\u0008\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R-\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00138FX\u0086\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\nR\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00061", d2 = {"Landroidx/compose/runtime/Pending;", "", "keyInfos", "", "Landroidx/compose/runtime/KeyInfo;", "startIndex", "", "(Ljava/util/List;I)V", "groupIndex", "getGroupIndex", "()I", "setGroupIndex", "(I)V", "groupInfos", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/GroupInfo;", "getKeyInfos", "()Ljava/util/List;", "keyMap", "Landroidx/compose/runtime/MutableScatterMultiMap;", "getKeyMap-SAeQiB4", "()Landroidx/collection/MutableScatterMap;", "keyMap$delegate", "Lkotlin/Lazy;", "getStartIndex", "used", "", "getUsed", "usedKeys", "getNext", "key", "dataKey", "nodePositionOf", "keyInfo", "recordUsed", "", "registerInsert", "", "insertIndex", "registerMoveNode", "from", "to", "count", "registerMoveSlot", "slotPositionOf", "updateNodeCount", "group", "newCount", "updatedNodeCountOf", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Pending {

    private int groupIndex;
    private final MutableIntObjectMap<androidx.compose.runtime.GroupInfo> groupInfos;
    private final List<androidx.compose.runtime.KeyInfo> keyInfos;
    private final Lazy keyMap$delegate;
    private final int startIndex;
    private final List<androidx.compose.runtime.KeyInfo> usedKeys;
    public Pending(List<androidx.compose.runtime.KeyInfo> keyInfos, int startIndex) {
        int i;
        int index;
        String $i$a$RequirePreconditionPending$1;
        int runningNodeIndex;
        int i2;
        int nodes;
        androidx.compose.runtime.GroupInfo groupInfo;
        int nodes2;
        super();
        this.keyInfos = keyInfos;
        this.startIndex = startIndex;
        int i3 = 0;
        int i4 = 1;
        i = this.startIndex >= 0 ? i4 : i3;
        int i5 = 0;
        if (i == 0) {
            int i7 = 0;
            PreconditionsKt.throwIllegalArgumentException("Invalid start index");
        }
        ArrayList arrayList = new ArrayList();
        this.usedKeys = (List)arrayList;
        Object obj = this;
        int i6 = 0;
        runningNodeIndex = 0;
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(i3, i4, 0);
        index = 0;
        while (index < obj.keyInfos.size()) {
            i2 = obj.keyInfos.get(index);
            groupInfo = new GroupInfo(index, runningNodeIndex, i2.getNodes());
            mutableIntObjectMap.set((KeyInfo)i2.getLocation(), groupInfo);
            runningNodeIndex += nodes;
            index++;
        }
        this.groupInfos = mutableIntObjectMap;
        Pending.keyMap.2 anon = new Pending.keyMap.2(this);
        this.keyMap$delegate = LazyKt.lazy((Function0)anon);
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    public final List<androidx.compose.runtime.KeyInfo> getKeyInfos() {
        return this.keyInfos;
    }

    public final MutableScatterMap<K, Object> getKeyMap-SAeQiB4() {
        return (MutableScatterMultiMap)this.keyMap$delegate.getValue().unbox-impl();
    }

    public final androidx.compose.runtime.KeyInfo getNext(int key, Object dataKey) {
        Object joinedKey;
        Integer valueOf;
        if (dataKey != null) {
            joinedKey = new JoinedKey(Integer.valueOf(key), dataKey);
        } else {
            joinedKey = Integer.valueOf(key);
        }
        return (KeyInfo)MutableScatterMultiMap.pop-impl(getKeyMap-SAeQiB4(), joinedKey);
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final List<androidx.compose.runtime.KeyInfo> getUsed() {
        return this.usedKeys;
    }

    public final int nodePositionOf(androidx.compose.runtime.KeyInfo keyInfo) {
        int nodeIndex;
        Object obj = this.groupInfos.get(keyInfo.getLocation());
        if ((GroupInfo)obj != null) {
            nodeIndex = (GroupInfo)obj.getNodeIndex();
        } else {
            nodeIndex = -1;
        }
        return nodeIndex;
    }

    public final boolean recordUsed(androidx.compose.runtime.KeyInfo keyInfo) {
        return this.usedKeys.add(keyInfo);
    }

    public final void registerInsert(androidx.compose.runtime.KeyInfo keyInfo, int insertIndex) {
        GroupInfo groupInfo = new GroupInfo(-1, insertIndex, 0);
        this.groupInfos.set(keyInfo.getLocation(), groupInfo);
    }

    public final void registerMoveNode(int from, int to, int count) {
        Object obj;
        int i;
        int i6;
        int this_$iv$iv;
        int this_$iv$iv2;
        int nodeIndex;
        Object[] values;
        MutableIntObjectMap i$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        long[] j$iv$iv2;
        int i8;
        int i$iv$iv2;
        long slot$iv$iv2;
        int i2;
        long value$iv$iv$iv;
        int i4;
        int values2;
        MutableIntObjectMap this_$iv;
        int i10;
        int i7;
        int i9;
        long slot$iv$iv;
        int j$iv$iv;
        long l;
        int cmp;
        int i5;
        long l2;
        int i3;
        MutableIntObjectMap this_$iv$iv3;
        obj = this;
        i = from;
        final int i14 = to;
        i$iv$iv2 = 8;
        if (i > i14) {
            value$iv$iv$iv = obj.groupInfos;
            i4 = 0;
            i10 = 0;
            this_$iv$iv = this_$iv;
            nodeIndex = this_$iv$iv.metadata;
            length += -2;
            if (0 <= values) {
            } else {
                this_$iv$iv3 = this_$iv$iv;
            }
        } else {
            l2 = -9187201950435737472L;
            if (i14 > i) {
                this_$iv$iv = obj.groupInfos;
                $this$maskEmptyOrDeleted$iv$iv$iv = 0;
                j$iv$iv2 = i$iv$iv.metadata;
                length2 += -2;
                if (0 <= i8) {
                } else {
                    this_$iv = this_$iv$iv;
                    i10 = nodeIndex;
                }
            }
        }
    }

    public final void registerMoveSlot(int from, int to) {
        Object obj;
        int i7;
        MutableIntObjectMap groupInfos;
        int slotIndex;
        Object[] values;
        MutableIntObjectMap i$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        long[] j$iv$iv;
        int j$iv$iv3;
        int i3;
        int i$iv$iv2;
        int slot$iv$iv2;
        int value$iv$iv$iv;
        long value$iv$iv$iv2;
        int i;
        int values2;
        MutableIntObjectMap this_$iv;
        int i5;
        int i2;
        int i4;
        long slot$iv$iv;
        int j$iv$iv2;
        MutableIntObjectMap this_$iv2;
        int cmp;
        int i6;
        long l;
        int i8;
        int i9;
        obj = this;
        i7 = from;
        final int i12 = to;
        slot$iv$iv2 = 8;
        if (i7 > i12) {
            value$iv$iv$iv2 = obj.groupInfos;
            i = 0;
            i5 = 0;
            slotIndex = groupInfos.metadata;
            length += -2;
            if (0 <= values) {
            } else {
                this_$iv2 = value$iv$iv$iv2;
            }
        } else {
            l = -9187201950435737472L;
            if (i12 > i7) {
                groupInfos = obj.groupInfos;
                $this$maskEmptyOrDeleted$iv$iv$iv = 0;
                j$iv$iv = i$iv$iv.metadata;
                length2 += -2;
                if (0 <= i3) {
                } else {
                    this_$iv = groupInfos;
                    i5 = slotIndex;
                }
            }
        }
    }

    public final void setGroupIndex(int <set-?>) {
        this.groupIndex = <set-?>;
    }

    public final int slotPositionOf(androidx.compose.runtime.KeyInfo keyInfo) {
        int slotIndex;
        Object obj = this.groupInfos.get(keyInfo.getLocation());
        if ((GroupInfo)obj != null) {
            slotIndex = (GroupInfo)obj.getSlotIndex();
        } else {
            slotIndex = -1;
        }
        return slotIndex;
    }

    public final boolean updateNodeCount(int group, int newCount) {
        Object nodeIndex;
        int index;
        int index2;
        int i4;
        int cmp2;
        int nodeIndex2;
        int j$iv$iv;
        MutableIntObjectMap $i$f$isFull;
        int i;
        Object[] values;
        MutableIntObjectMap map2;
        int i7;
        long[] metadata;
        int i2;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i6;
        int cmp;
        int i5;
        MutableIntObjectMap map;
        long l;
        int i8;
        int i3;
        nodeIndex = this;
        index2 = newCount;
        Object obj = nodeIndex.groupInfos.get(group);
        if ((GroupInfo)obj != null) {
            nodeIndex2 = (GroupInfo)obj.getNodeIndex();
            int i17 = index2 - nodeCount;
            obj.setNodeCount(index2);
            if (i17 != 0) {
                $i$f$isFull = nodeIndex.groupInfos;
                i = 0;
                i7 = 0;
                metadata = map2.metadata;
                length += -2;
                if (0 <= i2) {
                } else {
                    index = nodeIndex2;
                    map = $i$f$isFull;
                    i5 = 1;
                }
            } else {
                index = nodeIndex2;
                i5 = 1;
            }
            return i5;
        }
        return 0;
    }

    public final int updatedNodeCountOf(androidx.compose.runtime.KeyInfo keyInfo) {
        int nodeCount;
        Object obj = this.groupInfos.get(keyInfo.getLocation());
        if ((GroupInfo)obj != null) {
            nodeCount = (GroupInfo)obj.getNodeCount();
        } else {
            nodeCount = keyInfo.getNodes();
        }
        return nodeCount;
    }
}
