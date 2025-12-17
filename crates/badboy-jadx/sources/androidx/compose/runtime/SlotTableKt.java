package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0015\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0010\u001c\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0016\u001a\u00020\u0017*\u0008\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001e\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001f\u001a\u00020 *\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010!\u001a\u00020 *\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\"\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u001c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00010$*\u00020\u001c2\u0008\u0008\u0002\u0010%\u001a\u00020\u0001H\u0002\u001a7\u0010&\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010'*\u0012\u0012\u0004\u0012\u0002H'0(j\u0008\u0012\u0004\u0012\u0002H'`)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020 0+H\u0082\u0008\u001a>\u0010,\u001a\u0004\u0018\u0001H'\"\u0004\u0008\u0000\u0010'*\u0012\u0012\u0004\u0012\u0002H'0(j\u0008\u0012\u0004\u0012\u0002H'`)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020 0+H\u0082\u0008¢\u0006\u0002\u0010-\u001a.\u0010.\u001a\u0004\u0018\u00010/*\u0012\u0012\u0004\u0012\u00020/0(j\u0008\u0012\u0004\u0012\u00020/`)2\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0002\u001a;\u00102\u001a\u00020/*\u0012\u0012\u0004\u0012\u00020/0(j\u0008\u0012\u0004\u0012\u00020/`)2\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u00020/04H\u0082\u0008\u001a\u0014\u00105\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u00106\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u001c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u00010$*\u00020\u001c2\u0008\u0008\u0002\u0010%\u001a\u00020\u0001H\u0002\u001a\u0014\u00108\u001a\u00020 *\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u00109\u001a\u00020 *\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010:\u001a\u00020 *\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001aD\u0010;\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a\u0014\u0010<\u001a\u00020 *\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u001c\u0010@\u001a\u0008\u0012\u0004\u0012\u00020\u00010$*\u00020\u001c2\u0008\u0008\u0002\u0010%\u001a\u00020\u0001H\u0002\u001a,\u0010A\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020/0(j\u0008\u0012\u0004\u0012\u00020/`)2\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0002\u001a\u0014\u0010B\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u001c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00010$*\u00020\u001c2\u0008\u0008\u0002\u0010%\u001a\u00020\u0001H\u0002\u001a\u0014\u0010D\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010E\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010?\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u001c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u00010$*\u00020\u001c2\u0008\u0008\u0002\u0010%\u001a\u00020\u0001H\u0002\u001a,\u0010G\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020/0(j\u0008\u0012\u0004\u0012\u00020/`)2\u0006\u0010H\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0002\u001a \u0010I\u001a\u0008\u0012\u0004\u0012\u00020\u00010$*\u00020\u001c2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00010KH\u0002\u001a\u0014\u0010L\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002\u001a\u0014\u0010M\u001a\u00020N*\u00020N2\u0006\u0010O\u001a\u00020\u0001H\u0002\u001a\u001c\u0010P\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020 H\u0002\u001a\u001c\u0010Q\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010R\u001a\u00020\u0001H\u0002\u001a\u001c\u0010S\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\u001c\u0010T\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u001c\u0010U\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020 H\u0002\u001a\u001c\u0010V\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u001c\u0010W\u001a\u00020\u0017*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006X", d2 = {"Aux_Mask", "", "Aux_Shift", "ContainsMark_Mask", "DataAnchor_Offset", "GroupInfo_Offset", "Group_Fields_Size", "Key_Offset", "LIVE_EDIT_INVALID_KEY", "Mark_Mask", "MinGroupGrowthSize", "MinSlotsGrowthSize", "NodeBit_Mask", "NodeCount_Mask", "ObjectKey_Mask", "ObjectKey_Shift", "ParentAnchor_Offset", "Size_Offset", "Slots_Shift", "parentAnchorPivot", "countOneBits", "value", "add", "", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "key", "addAux", "", "address", "auxIndex", "containsAnyMark", "", "containsMark", "dataAnchor", "dataAnchors", "", "len", "fastIndexOf", "T", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "predicate", "Lkotlin/Function1;", "fastLastOrNull", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "find", "Landroidx/compose/runtime/Anchor;", "index", "effectiveSize", "getOrAdd", "block", "Lkotlin/Function0;", "groupInfo", "groupSize", "groupSizes", "hasAux", "hasMark", "hasObjectKey", "initGroup", "isNode", "hasDataKey", "hasData", "parentAnchor", "keys", "locationOf", "nodeCount", "nodeCounts", "nodeIndex", "objectKeyIndex", "parentAnchors", "search", "location", "slice", "indices", "", "slotAnchor", "summarize", "", "size", "updateContainsMark", "updateDataAnchor", "anchor", "updateGroupKey", "updateGroupSize", "updateMark", "updateNodeCount", "updateParentAnchor", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SlotTableKt {

    private static final int Aux_Mask = 268435456;
    private static final int Aux_Shift = 28;
    private static final int ContainsMark_Mask = 67108864;
    private static final int DataAnchor_Offset = 4;
    private static final int GroupInfo_Offset = 1;
    private static final int Group_Fields_Size = 5;
    private static final int Key_Offset = 0;
    private static final int LIVE_EDIT_INVALID_KEY = -3;
    private static final int Mark_Mask = 134217728;
    private static final int MinGroupGrowthSize = 32;
    private static final int MinSlotsGrowthSize = 32;
    private static final int NodeBit_Mask = 1073741824;
    private static final int NodeCount_Mask = 67108863;
    private static final int ObjectKey_Mask = 536870912;
    private static final int ObjectKey_Shift = 29;
    private static final int ParentAnchor_Offset = 2;
    private static final int Size_Offset = 3;
    private static final int Slots_Shift = 28;
    private static final int parentAnchorPivot = -2;
    public static final void access$add(MutableIntObjectMap $receiver, int key, int value) {
        SlotTableKt.add($receiver, key, value);
    }

    public static final void access$addAux(int[] $receiver, int address) {
        SlotTableKt.addAux($receiver, address);
    }

    public static final int access$auxIndex(int[] $receiver, int address) {
        return SlotTableKt.auxIndex($receiver, address);
    }

    public static final boolean access$containsAnyMark(int[] $receiver, int address) {
        return SlotTableKt.containsAnyMark($receiver, address);
    }

    public static final boolean access$containsMark(int[] $receiver, int address) {
        return SlotTableKt.containsMark($receiver, address);
    }

    public static final int access$countOneBits(int value) {
        return SlotTableKt.countOneBits(value);
    }

    public static final int access$dataAnchor(int[] $receiver, int address) {
        return SlotTableKt.dataAnchor($receiver, address);
    }

    public static final List access$dataAnchors(int[] $receiver, int len) {
        return SlotTableKt.dataAnchors($receiver, len);
    }

    public static final androidx.compose.runtime.Anchor access$find(ArrayList $receiver, int index, int effectiveSize) {
        return SlotTableKt.find($receiver, index, effectiveSize);
    }

    public static final int access$groupInfo(int[] $receiver, int address) {
        return SlotTableKt.groupInfo($receiver, address);
    }

    public static final int access$groupSize(int[] $receiver, int address) {
        return SlotTableKt.groupSize($receiver, address);
    }

    public static final List access$groupSizes(int[] $receiver, int len) {
        return SlotTableKt.groupSizes($receiver, len);
    }

    public static final boolean access$hasAux(int[] $receiver, int address) {
        return SlotTableKt.hasAux($receiver, address);
    }

    public static final boolean access$hasMark(int[] $receiver, int address) {
        return SlotTableKt.hasMark($receiver, address);
    }

    public static final boolean access$hasObjectKey(int[] $receiver, int address) {
        return SlotTableKt.hasObjectKey($receiver, address);
    }

    public static final void access$initGroup(int[] $receiver, int address, int key, boolean isNode, boolean hasDataKey, boolean hasData, int parentAnchor, int dataAnchor) {
        SlotTableKt.initGroup($receiver, address, key, isNode, hasDataKey, hasData, parentAnchor, dataAnchor);
    }

    public static final boolean access$isNode(int[] $receiver, int address) {
        return SlotTableKt.isNode($receiver, address);
    }

    public static final int access$key(int[] $receiver, int address) {
        return SlotTableKt.key($receiver, address);
    }

    public static final List access$keys(int[] $receiver, int len) {
        return SlotTableKt.keys($receiver, len);
    }

    public static final int access$locationOf(ArrayList $receiver, int index, int effectiveSize) {
        return SlotTableKt.locationOf($receiver, index, effectiveSize);
    }

    public static final int access$nodeCount(int[] $receiver, int address) {
        return SlotTableKt.nodeCount($receiver, address);
    }

    public static final List access$nodeCounts(int[] $receiver, int len) {
        return SlotTableKt.nodeCounts($receiver, len);
    }

    public static final int access$nodeIndex(int[] $receiver, int address) {
        return SlotTableKt.nodeIndex($receiver, address);
    }

    public static final int access$objectKeyIndex(int[] $receiver, int address) {
        return SlotTableKt.objectKeyIndex($receiver, address);
    }

    public static final int access$parentAnchor(int[] $receiver, int address) {
        return SlotTableKt.parentAnchor($receiver, address);
    }

    public static final List access$parentAnchors(int[] $receiver, int len) {
        return SlotTableKt.parentAnchors($receiver, len);
    }

    public static final int access$search(ArrayList $receiver, int location, int effectiveSize) {
        return SlotTableKt.search($receiver, location, effectiveSize);
    }

    public static final int access$slotAnchor(int[] $receiver, int address) {
        return SlotTableKt.slotAnchor($receiver, address);
    }

    public static final String access$summarize(String $receiver, int size) {
        return SlotTableKt.summarize($receiver, size);
    }

    public static final void access$updateContainsMark(int[] $receiver, int address, boolean value) {
        SlotTableKt.updateContainsMark($receiver, address, value);
    }

    public static final void access$updateDataAnchor(int[] $receiver, int address, int anchor) {
        SlotTableKt.updateDataAnchor($receiver, address, anchor);
    }

    public static final void access$updateGroupKey(int[] $receiver, int address, int key) {
        SlotTableKt.updateGroupKey($receiver, address, key);
    }

    public static final void access$updateGroupSize(int[] $receiver, int address, int value) {
        SlotTableKt.updateGroupSize($receiver, address, value);
    }

    public static final void access$updateMark(int[] $receiver, int address, boolean value) {
        SlotTableKt.updateMark($receiver, address, value);
    }

    public static final void access$updateNodeCount(int[] $receiver, int address, int value) {
        SlotTableKt.updateNodeCount($receiver, address, value);
    }

    public static final void access$updateParentAnchor(int[] $receiver, int address, int value) {
        SlotTableKt.updateParentAnchor($receiver, address, value);
    }

    private static final void add(MutableIntObjectMap<MutableIntSet> $this$add, int key, int value) {
        Object mutableIntSet;
        MutableIntSet set;
        int i2;
        int i;
        if ((MutableIntSet)$this$add.get(key) == null) {
            mutableIntSet = new MutableIntSet(0, 1, 0);
            i2 = 0;
            $this$add.set(key, mutableIntSet);
        }
        mutableIntSet.add(value);
    }

    private static final void addAux(int[] $this$addAux, int address) {
        i++;
        $this$addAux[i2] = i3 |= i5;
    }

    private static final int auxIndex(int[] $this$auxIndex, int address) {
        int length;
        int countOneBits;
        final int i = address * 5;
        final int i2 = 0;
        if (i >= $this$auxIndex.length) {
            length = $this$auxIndex.length;
        } else {
            i4 += countOneBits;
        }
        return length;
    }

    private static final boolean containsAnyMark(int[] $this$containsAnyMark, int address) {
        int i;
        if (i4 &= i6 != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final boolean containsMark(int[] $this$containsMark, int address) {
        int i;
        if (i4 &= i6 != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final int countOneBits(int value) {
        int i;
        i = 2;
        final int i2 = 1;
        switch (value) {
            case 0:
                i = 0;
                break;
            case 1:
                i = i2;
                break;
            case 2:
                i = i2;
                break;
            case 3:
                break;
            case 4:
                i = i2;
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                i = 3;
        }
        return i;
    }

    private static final int dataAnchor(int[] $this$dataAnchor, int address) {
        return $this$dataAnchor[i += 4];
    }

    private static final List<Integer> dataAnchors(int[] $this$dataAnchors, int len) {
        return SlotTableKt.slice($this$dataAnchors, (Iterable)RangesKt.step((IntProgression)RangesKt.until(4, len), 5));
    }

    static List dataAnchors$default(int[] iArr, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = iArr.length;
        }
        return SlotTableKt.dataAnchors(iArr, obj1);
    }

    private static final <T> int fastIndexOf(ArrayList<T> $this$fastIndexOf, Function1<? super T, Boolean> predicate) {
        int index;
        Object obj;
        boolean booleanValue;
        final int i = 0;
        index = 0;
        while (index < $this$fastIndexOf.size()) {
            index++;
        }
        return -1;
    }

    private static final <T> T fastLastOrNull(ArrayList<T> $this$fastLastOrNull, Function1<? super T, Boolean> predicate) {
        int index;
        Object obj;
        boolean booleanValue;
        final int i = 0;
        size--;
        while (index >= 0) {
            obj = $this$fastLastOrNull.get(index);
            index--;
        }
        return 0;
    }

    private static final androidx.compose.runtime.Anchor find(ArrayList<androidx.compose.runtime.Anchor> $this$find, int index, int effectiveSize) {
        Object obj;
        final int search = SlotTableKt.search($this$find, index, effectiveSize);
        if (search >= 0) {
            obj = $this$find.get(search);
        } else {
            obj = 0;
        }
        return obj;
    }

    private static final androidx.compose.runtime.Anchor getOrAdd(ArrayList<androidx.compose.runtime.Anchor> $this$getOrAdd, int index, int effectiveSize, Function0<androidx.compose.runtime.Anchor> block) {
        Object invoke;
        int i;
        final int i2 = 0;
        final int i3 = SlotTableKt.access$search($this$getOrAdd, index, effectiveSize);
        if (i3 < 0) {
            $this$getOrAdd.add(-i4, (Anchor)block.invoke());
        } else {
            invoke = $this$getOrAdd.get(i3);
        }
        return invoke;
    }

    private static final int groupInfo(int[] $this$groupInfo, int address) {
        return $this$groupInfo[i++];
    }

    private static final int groupSize(int[] $this$groupSize, int address) {
        return $this$groupSize[i += 3];
    }

    private static final List<Integer> groupSizes(int[] $this$groupSizes, int len) {
        return SlotTableKt.slice($this$groupSizes, (Iterable)RangesKt.step((IntProgression)RangesKt.until(3, len), 5));
    }

    static List groupSizes$default(int[] iArr, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = iArr.length;
        }
        return SlotTableKt.groupSizes(iArr, obj1);
    }

    private static final boolean hasAux(int[] $this$hasAux, int address) {
        int i;
        if (i4 &= i6 != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final boolean hasMark(int[] $this$hasMark, int address) {
        int i;
        if (i4 &= i6 != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final boolean hasObjectKey(int[] $this$hasObjectKey, int address) {
        int i;
        if (i4 &= i6 != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final void initGroup(int[] $this$initGroup, int address, int key, boolean isNode, boolean hasDataKey, boolean hasData, int parentAnchor, int dataAnchor) {
        int i3;
        int i2;
        int i;
        int i4 = 0;
        i3 = isNode ? 1073741824 : i4;
        i2 = hasDataKey ? 536870912 : i4;
        i = hasData != null ? 268435456 : i4;
        final int i6 = address * 5;
        $this$initGroup[i6 + 0] = key;
        $this$initGroup[i6 + 1] = i11 |= i;
        $this$initGroup[i6 + 2] = parentAnchor;
        $this$initGroup[i6 + 3] = i4;
        $this$initGroup[i6 + 4] = dataAnchor;
    }

    private static final boolean isNode(int[] $this$isNode, int address) {
        int i;
        if (i4 &= i6 != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final int key(int[] $this$key, int address) {
        return $this$key[address * 5];
    }

    private static final List<Integer> keys(int[] $this$keys, int len) {
        return SlotTableKt.slice($this$keys, (Iterable)RangesKt.step((IntProgression)RangesKt.until(0, len), 5));
    }

    static List keys$default(int[] iArr, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = iArr.length;
        }
        return SlotTableKt.keys(iArr, obj1);
    }

    private static final int locationOf(ArrayList<androidx.compose.runtime.Anchor> $this$locationOf, int index, int effectiveSize) {
        int it;
        int i;
        it = SlotTableKt.search($this$locationOf, index, effectiveSize);
        final int i2 = 0;
        if (it >= 0) {
        } else {
            it = i;
        }
        return it;
    }

    private static final int nodeCount(int[] $this$nodeCount, int address) {
        return i3 &= i5;
    }

    private static final List<Integer> nodeCounts(int[] $this$nodeCounts, int len) {
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i2;
        ArrayList list;
        Integer valueOf;
        int i3;
        int i;
        List slice = SlotTableKt.slice($this$nodeCounts, (Iterable)RangesKt.step((IntProgression)RangesKt.until(1, len), 5));
        int i6 = 0;
        ArrayList arrayList = new ArrayList(slice.size());
        List list2 = slice;
        final int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list2.size()) {
            i2 = 0;
            i3 = 0;
            (Collection)arrayList.add(Integer.valueOf(intValue &= i));
            index$iv$iv++;
        }
        return (List)arrayList;
    }

    static List nodeCounts$default(int[] iArr, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = iArr.length;
        }
        return SlotTableKt.nodeCounts(iArr, obj1);
    }

    private static final int nodeIndex(int[] $this$nodeIndex, int address) {
        return $this$nodeIndex[i += 4];
    }

    private static final int objectKeyIndex(int[] $this$objectKeyIndex, int address) {
        final int i = address * 5;
        final int i2 = 0;
        return i4 += countOneBits;
    }

    private static final int parentAnchor(int[] $this$parentAnchor, int address) {
        return $this$parentAnchor[i += 2];
    }

    private static final List<Integer> parentAnchors(int[] $this$parentAnchors, int len) {
        return SlotTableKt.slice($this$parentAnchors, (Iterable)RangesKt.step((IntProgression)RangesKt.until(2, len), 5));
    }

    static List parentAnchors$default(int[] iArr, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = iArr.length;
        }
        return SlotTableKt.parentAnchors(iArr, obj1);
    }

    private static final int search(ArrayList<androidx.compose.runtime.Anchor> $this$search, int location, int effectiveSize) {
        int low;
        int high;
        int i2;
        int it;
        int compare;
        int i;
        low = 0;
        size--;
        while (low <= high) {
            i3 >>>= 1;
            it = (Anchor)$this$search.get(i2).getLocation$runtime_release();
            int i5 = 0;
            if (it < 0) {
            }
            compare = Intrinsics.compare(it, location);
            high = i2 + -1;
            low = i2 + 1;
            it = i;
        }
        return -mid;
    }

    private static final List<Integer> slice(int[] $this$slice, Iterable<Integer> indices) {
        int intValue;
        Integer valueOf;
        ArrayList arrayList = new ArrayList();
        final Iterator iterator = indices.iterator();
        for (Number next2 : iterator) {
            (List)arrayList.add(Integer.valueOf($this$slice[next2.intValue()]));
        }
        return arrayList;
    }

    private static final int slotAnchor(int[] $this$slotAnchor, int address) {
        final int i = address * 5;
        final int i2 = 0;
        return i4 += countOneBits;
    }

    private static final String summarize(String $this$summarize, int size) {
        final int i4 = 4;
        final int i5 = 0;
        int i3 = 0;
        final int i7 = 4;
        final int i8 = 0;
        final int i6 = 0;
        String replace$default5 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default($this$summarize, "androidx.", "a.", i3, i4, i5), "compose.", "c.", i6, i7, i8), "runtime.", "r.", i3, i4, i5), "internal.", "ι.", i6, i7, i8), "ui.", "u.", i3, i4, i5), "Modifier", "μ", i6, i7, i8), "material.", "m.", i3, i4, i5), "Function", "λ", i6, i7, i8), "OpaqueKey", "κ", i3, i4, i5), "MutableState", "σ", i6, i7, i8);
        int i = 0;
        String substring = replace$default5.substring(i3, Math.min(size, replace$default5.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private static final void updateContainsMark(int[] $this$updateContainsMark, int address, boolean value) {
        int i;
        int i2;
        i3++;
        if (value != null) {
            $this$updateContainsMark[i4] = i5 |= i2;
        } else {
            $this$updateContainsMark[i4] = i6 &= i2;
        }
    }

    private static final void updateDataAnchor(int[] $this$updateDataAnchor, int address, int anchor) {
        $this$updateDataAnchor[i += 4] = anchor;
    }

    private static final void updateGroupKey(int[] $this$updateGroupKey, int address, int key) {
        $this$updateGroupKey[i + 0] = key;
    }

    private static final void updateGroupSize(int[] $this$updateGroupSize, int address, int value) {
        int i;
        i = value >= 0 ? 1 : 0;
        ComposerKt.runtimeCheck(i);
        $this$updateGroupSize[i2 += 3] = value;
    }

    private static final void updateMark(int[] $this$updateMark, int address, boolean value) {
        int i;
        int i2;
        i3++;
        if (value != null) {
            $this$updateMark[i4] = i5 |= i2;
        } else {
            $this$updateMark[i4] = i6 &= i2;
        }
    }

    private static final void updateNodeCount(int[] $this$updateNodeCount, int address, int value) {
        int i2;
        int i;
        int i3 = 1;
        if (value >= 0 && value < 67108863) {
            i = value < 67108863 ? i3 : 0;
        } else {
        }
        ComposerKt.runtimeCheck(i);
        $this$updateNodeCount[i7 += i3] = i5 |= value;
    }

    private static final void updateParentAnchor(int[] $this$updateParentAnchor, int address, int value) {
        $this$updateParentAnchor[i += 2] = value;
    }
}
