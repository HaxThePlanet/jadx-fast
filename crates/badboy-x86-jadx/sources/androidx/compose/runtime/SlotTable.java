package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0015\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010(\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u001cJ\u000e\u0010<\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0007J=\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u0001`/H\u0000¢\u0006\u0002\u0008AJ\u008f\u0001\u0010=\u001a\u00020>2\u0006\u00108\u001a\u00020B2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$2\u0006\u0010*\u001a\u00020\u001c2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u00082&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0000¢\u0006\u0004\u0008A\u0010CJ\u0006\u0010D\u001a\u00020>J\u0006\u0010E\u001a\u00020>J\u0006\u0010F\u001a\u00020!J\u000e\u0010G\u001a\u0008\u0012\u0004\u0012\u00020\u001c0HH\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010\u00032\u0006\u0010J\u001a\u00020%H\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u001cH\u0002J\u0016\u0010N\u001a\u00020!2\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010P\u001a\u0008\u0012\u0004\u0012\u00020\u001c0HH\u0002J\u001d\u0010Q\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010H2\u0006\u0010R\u001a\u00020\u001cH\u0000¢\u0006\u0002\u0008SJ\u000f\u0010T\u001a\u0008\u0012\u0004\u0012\u00020\u00030UH\u0096\u0002J\u000e\u0010V\u001a\u0008\u0012\u0004\u0012\u00020\u001c0HH\u0002J\u000e\u0010W\u001a\u0008\u0012\u0004\u0012\u00020\u001c0HH\u0002J\u0006\u0010X\u001a\u00020@J\u0006\u0010Y\u001a\u00020BJ\u000e\u0010Z\u001a\u00020!2\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010[\u001a\u0008\u0012\u0004\u0012\u00020\u001c0HH\u0002J7\u0010\\\u001a\u0002H]\"\u0004\u0008\u0000\u0010]2!\u0010^\u001a\u001d\u0012\u0013\u0012\u00110@¢\u0006\u000c\u0008`\u0012\u0008\u0008a\u0012\u0004\u0008\u0008(?\u0012\u0004\u0012\u0002H]0_H\u0086\u0008¢\u0006\u0002\u0010bJ\u0087\u0001\u0010c\u001a\u00020>2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$2\u0006\u0010*\u001a\u00020\u001c2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u00082&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0000¢\u0006\u0004\u0008d\u0010eJ\u001f\u0010f\u001a\u0004\u0018\u00010%2\u0006\u0010M\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020\u001cH\u0000¢\u0006\u0002\u0008hJ\u001d\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0H2\u0006\u0010M\u001a\u00020\u001cH\u0000¢\u0006\u0002\u0008jJ\u0010\u0010k\u001a\u0004\u0018\u00010.2\u0006\u0010M\u001a\u00020\u001cJ\u0006\u0010l\u001a\u00020mJ\u0012\u0010n\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\u001cH\u0002J\u0006\u0010o\u001a\u00020>J7\u0010p\u001a\u0002H]\"\u0004\u0008\u0000\u0010]2!\u0010^\u001a\u001d\u0012\u0013\u0012\u00110B¢\u0006\u000c\u0008`\u0012\u0008\u0008a\u0012\u0004\u0008\u0008(8\u0012\u0004\u0012\u0002H]0_H\u0086\u0008¢\u0006\u0002\u0010bJ \u0010q\u001a\u00020\u001c*\u00060rj\u0002`s2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010t\u001a\u00020\u001cH\u0002R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010\"R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$@BX\u0086\u000e¢\u0006\n\n\u0002\u0010)\u001a\u0004\u0008'\u0010(R\u001e\u0010*\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001fR:\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0018\u0001`/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R\u001a\u00104\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00085\u0010\u001f\"\u0004\u00086\u00107R\u001e\u00108\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010\"¨\u0006u", d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime_release", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime_release", "(Landroidx/collection/MutableIntObjectMap;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "getSourceInformationMap$runtime_release", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime_release", "(Ljava/util/HashMap;)V", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchor", "index", "anchorIndex", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "collectCalledByInformation", "collectSourceInformation", "containsMark", "dataIndexes", "", "find", "identityToFind", "findEffectiveRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "group", "groupContainsAnchor", "groupIndex", "groupSizes", "invalidateGroupsWithKey", "target", "invalidateGroupsWithKey$runtime_release", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", "read", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "slot", "slotIndex", "slot$runtime_release", "slotsOf", "slotsOf$runtime_release", "sourceInformationOf", "toDebugString", "", "tryAnchor", "verifyWellFormed", "write", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {

    public static final int $stable = 8;
    private ArrayList<androidx.compose.runtime.Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int[] groups;
    private int groupsSize;
    private int readers;
    private Object[] slots;
    private int slotsSize;
    private HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> sourceInformationMap;
    private int version;
    private boolean writer;
    static {
        final int i = 8;
    }

    public SlotTable() {
        super();
        int i = 0;
        this.groups = new int[i];
        this.slots = new Object[i];
        ArrayList arrayList = new ArrayList();
        this.anchors = arrayList;
    }

    private final List<Integer> dataIndexes() {
        return SlotTableKt.access$dataAnchors(this.groups, groupsSize *= 5);
    }

    private final int emitGroup(StringBuilder $this$emitGroup, int index, int level) {
        int slotsSize;
        boolean string;
        boolean string4;
        boolean string2;
        String string3;
        int current;
        int i5;
        Object sourceInformationOf;
        int i6;
        int i4;
        boolean str2;
        boolean str4;
        int startsWith$default;
        int dataIndex;
        int dataIndex2;
        int str;
        String str3;
        int i3;
        int i2;
        int i;
        slotsSize = 0;
        i5 = slotsSize;
        while (i5 < level) {
            i6 = i5;
            i4 = 0;
            $this$emitGroup.append(' ');
            i5++;
        }
        $this$emitGroup.append("Group(");
        $this$emitGroup.append(index);
        $this$emitGroup.append(")");
        sourceInformationOf = sourceInformationOf(index);
        int i9 = 1;
        sourceInformationOf = sourceInformationOf.getSourceInformation();
        if (sourceInformationOf != null && sourceInformationOf != null) {
            sourceInformationOf = sourceInformationOf.getSourceInformation();
            if (sourceInformationOf != null) {
                i4 = 0;
                dataIndex = 2;
                str = 0;
                if (!StringsKt.startsWith$default(sourceInformationOf, "C(", slotsSize, dataIndex, str)) {
                    if (StringsKt.startsWith$default(sourceInformationOf, "CC(", slotsSize, dataIndex, str)) {
                        i2 = 6;
                        i = 0;
                        int i17 = 0;
                        i3 = 0;
                        $this$emitGroup.append(" ");
                        String substring = sourceInformationOf.substring(indexOf$default += i9, StringsKt.indexOf$default((CharSequence)sourceInformationOf, ')', i17, i3, i2, i));
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        $this$emitGroup.append(substring);
                        $this$emitGroup.append("()");
                    }
                } else {
                }
            }
        }
        $this$emitGroup.append(" key=");
        $this$emitGroup.append(SlotTableKt.access$key(this.groups, index));
        int i8 = SlotTableKt.access$groupSize(this.groups, index);
        $this$emitGroup.append(", nodes=");
        $this$emitGroup.append(SlotTableKt.access$nodeCount(this.groups, index));
        $this$emitGroup.append(", size=");
        $this$emitGroup.append(i8);
        if (SlotTableKt.access$hasMark(this.groups, index)) {
            $this$emitGroup.append(", mark");
        }
        if (SlotTableKt.access$containsMark(this.groups, index)) {
            $this$emitGroup.append(", contains mark");
        }
        int emitGroup$dataIndex = SlotTable.emitGroup$dataIndex(this, index);
        int emitGroup$dataIndex2 = SlotTable.emitGroup$dataIndex(this, index + 1);
        if (emitGroup$dataIndex >= 0 && emitGroup$dataIndex <= emitGroup$dataIndex2) {
            if (emitGroup$dataIndex <= emitGroup$dataIndex2) {
                slotsSize = i9;
            }
        }
        int i10 = 10;
        if (slotsSize != 0 && emitGroup$dataIndex2 <= this.slotsSize) {
            if (emitGroup$dataIndex2 <= this.slotsSize) {
                if (SlotTableKt.access$hasObjectKey(this.groups, index)) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    $this$emitGroup.append(stringBuilder3.append(" objectKey=").append(SlotTableKt.access$summarize(String.valueOf(this.slots[SlotTableKt.access$objectKeyIndex(this.groups, index)]), i10)).toString());
                }
                if (SlotTableKt.access$isNode(this.groups, index)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    $this$emitGroup.append(stringBuilder2.append(" node=").append(SlotTableKt.access$summarize(String.valueOf(this.slots[SlotTableKt.access$nodeIndex(this.groups, index)]), i10)).toString());
                }
                if (SlotTableKt.access$hasAux(this.groups, index)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    $this$emitGroup.append(stringBuilder.append(" aux=").append(SlotTableKt.access$summarize(String.valueOf(this.slots[SlotTableKt.access$auxIndex(this.groups, index)]), i10)).toString());
                }
                string3 = SlotTableKt.access$slotAnchor(this.groups, index);
                if (string3 < emitGroup$dataIndex2) {
                    $this$emitGroup.append(", slots=[");
                    $this$emitGroup.append(string3);
                    $this$emitGroup.append(": ");
                    dataIndex2 = string3;
                    while (dataIndex2 < emitGroup$dataIndex2) {
                        if (dataIndex2 != string3) {
                        }
                        $this$emitGroup.append(SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndex2]), i10));
                        dataIndex2++;
                        $this$emitGroup.append(", ");
                    }
                    $this$emitGroup.append("]");
                }
            } else {
                StringBuilder slotStart = new StringBuilder();
                $this$emitGroup.append(slotStart.append(", *invalid data offsets ").append(emitGroup$dataIndex).append('-').append(emitGroup$dataIndex2).append('*').toString());
            }
        } else {
        }
        $this$emitGroup.append(i10);
        current = index + 1;
        while (current < index + i8) {
            current += dataIndex;
        }
        return i8;
    }

    private static final int emitGroup$dataIndex(androidx.compose.runtime.SlotTable this$0, int index) {
        int slotsSize;
        if (index >= this$0.groupsSize) {
            slotsSize = this$0.slotsSize;
        } else {
            slotsSize = SlotTableKt.access$dataAnchor(this$0.groups, index);
        }
        return slotsSize;
    }

    private final androidx.compose.runtime.RecomposeScopeImpl findEffectiveRecomposeScope(int group) {
        int current;
        int[] groups;
        boolean next;
        boolean z;
        int i;
        current = group;
        while (current > 0) {
            DataIterator dataIterator = new DataIterator(this, current);
            Iterator iterator = dataIterator.iterator();
            for (Object next : iterator) {
                (RecomposeScopeImpl)next.setForcedRecompose(true);
            }
            current = SlotTableKt.access$parentAnchor(this.groups, current);
            next = iterator.next();
            (RecomposeScopeImpl)next.setForcedRecompose(true);
        }
        return null;
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.access$groupSizes(this.groups, groupsSize *= 5);
    }

    private static final void invalidateGroupsWithKey$lambda$20$scanGroup(androidx.compose.runtime.SlotReader $reader, MutableIntSet set, List<androidx.compose.runtime.Anchor> anchors, Ref.BooleanRef allScopesFound, androidx.compose.runtime.SlotTable this$0, List<androidx.compose.runtime.RecomposeScopeImpl> scopes) {
        int anchor$default;
        boolean effectiveRecomposeScope;
        boolean groupEnd;
        int effectiveRecomposeScope2;
        int i;
        int location$runtime_release;
        int currentGroup;
        final int groupKey = $reader.getGroupKey();
        i = 0;
        if (set.contains(groupKey) && groupKey != -3) {
            i = 0;
            if (groupKey != -3) {
                anchors.add(SlotReader.anchor$default($reader, i, 1, 0));
            }
            if (allScopesFound.element) {
                effectiveRecomposeScope = this$0.findEffectiveRecomposeScope($reader.getCurrentGroup());
                if (effectiveRecomposeScope != null) {
                    scopes.add(effectiveRecomposeScope);
                    location$runtime_release = effectiveRecomposeScope.getAnchor();
                    if (location$runtime_release != null && location$runtime_release.getLocation$runtime_release() == $reader.getCurrentGroup()) {
                        if (location$runtime_release.getLocation$runtime_release() == $reader.getCurrentGroup()) {
                        } else {
                            effectiveRecomposeScope2 = i;
                        }
                    } else {
                    }
                    if (effectiveRecomposeScope2 != 0) {
                        effectiveRecomposeScope2 = this$0.findEffectiveRecomposeScope($reader.getParent());
                        if (effectiveRecomposeScope2 != null) {
                            location$runtime_release = 0;
                            scopes.add(effectiveRecomposeScope2);
                        } else {
                        }
                    }
                } else {
                    allScopesFound.element = i;
                    scopes.clear();
                }
            }
            $reader.skipGroup();
        }
        $reader.startGroup();
        while (!$reader.isGroupEnd()) {
            SlotTable.invalidateGroupsWithKey$lambda$20$scanGroup($reader, set, anchors, allScopesFound, this$0, scopes);
        }
        $reader.endGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.access$keys(this.groups, groupsSize *= 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.access$nodeCounts(this.groups, groupsSize *= 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.access$parentAnchors(this.groups, groupsSize *= 5);
    }

    private final androidx.compose.runtime.Anchor tryAnchor(int index) {
        androidx.compose.runtime.Anchor anchor;
        int groupsSize;
        int groupsSize2;
        String str;
        groupsSize2 = 0;
        if (writer ^= groupsSize == 0) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
        }
        if (index >= 0 && index < this.groupsSize) {
            if (index < this.groupsSize) {
            } else {
                groupsSize = value$iv;
            }
        } else {
        }
        if (groupsSize != 0) {
            anchor = SlotTableKt.access$find(this.anchors, index, this.groupsSize);
        } else {
            anchor = 0;
        }
        return anchor;
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef current, androidx.compose.runtime.SlotTable this$0, int parent, int parentEnd) {
        Object string9;
        boolean z;
        String string3;
        int nodeCount2;
        String string;
        int minSlotsNeeded;
        int string6;
        Object isNode;
        int i10;
        int i;
        int string8;
        int i2;
        int value$iv;
        int str;
        String string7;
        int i3;
        StringBuilder string4;
        int slotsSize;
        String string2;
        int i5;
        int i9;
        String append;
        int i11;
        int i6;
        int verifyWellFormed$validateGroup;
        String string5;
        int i4;
        StringBuilder append2;
        int i12;
        String stringBuilder;
        int i8;
        int parentIndex;
        int i7;
        int nodeCount;
        int end;
        string9 = current;
        final Object obj = this$0;
        final int i13 = parent;
        final int element = string9.element;
        string9.element = element + 1;
        string3 = SlotTableKt.access$parentAnchor(obj.groups, element);
        string6 = 1;
        i = string3 == i13 ? string6 : 0;
        int i20 = 0;
        if (i == 0) {
            int i23 = 0;
            StringBuilder stringBuilder4 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder4.append("Invalid parent index detected at ").append(element).append(", expected parent index to be ").append(i13).append(" found ").append(string3).toString());
        }
        i18 += element;
        i2 = string8 <= obj.groupsSize ? string6 : 0;
        int i21 = 0;
        if (i2 == 0) {
            int i26 = 0;
            StringBuilder stringBuilder5 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder5.append("A group extends past the end of the table at ").append(element).toString());
        }
        i3 = string8 <= parentEnd ? string6 : 0;
        int i24 = 0;
        if (i3 == 0) {
            int i28 = 0;
            StringBuilder stringBuilder6 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder6.append("A group extends past its parent group at ").append(element).toString());
        }
        int i22 = SlotTableKt.access$dataAnchor(obj.groups, element);
        if (element >= groupsSize2 -= string6) {
            slotsSize = obj.slotsSize;
        } else {
            slotsSize = SlotTableKt.access$dataAnchor(obj.groups, element + 1);
        }
        i5 = slotsSize <= slots.length ? string6 : 0;
        int i29 = 0;
        if (i5 == 0) {
            int i37 = 0;
            StringBuilder stringBuilder8 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder8.append("Slots for ").append(element).append(" extend past the end of the slot table").toString());
        }
        i9 = i22 <= slotsSize ? string6 : 0;
        int i30 = 0;
        if (i9 == 0) {
            int i36 = 0;
            StringBuilder stringBuilder7 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder7.append("Invalid data anchor at ").append(element).toString());
        }
        i11 = SlotTableKt.access$slotAnchor(obj.groups, element) <= slotsSize ? string6 : 0;
        int i33 = 0;
        if (i11 == 0) {
            append2 = 0;
            stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder.append("Slots start out of range at ").append(element).toString());
        }
        i16 += z5;
        i6 = slotsSize - i22 >= i17 ? string6 : 0;
        i4 = 0;
        if (i6 == 0) {
            append2 = 0;
            stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder.append("Not enough slots added for group ").append(element).toString());
        }
        boolean z3 = SlotTableKt.access$isNode(obj.groups, element);
        if (z3) {
            if (obj.slots[SlotTableKt.access$nodeIndex(obj.groups, element)] != null) {
                verifyWellFormed$validateGroup = 1;
            } else {
                verifyWellFormed$validateGroup = 0;
            }
        } else {
        }
        int i34 = 0;
        if (verifyWellFormed$validateGroup == 0) {
            append2 = 0;
            stringBuilder = new StringBuilder();
            parentIndex = string3;
            PreconditionsKt.throwIllegalStateException(stringBuilder.append("No node recorded for a node group at ").append(element).toString());
        } else {
            parentIndex = string3;
        }
        nodeCount2 = 0;
        while (string9.element < string8) {
            nodeCount2 += verifyWellFormed$validateGroup;
        }
        int i32 = SlotTableKt.access$nodeCount(obj.groups, element);
        int i35 = SlotTableKt.access$groupSize(obj.groups, element);
        i12 = i32 == nodeCount2 ? 1 : 0;
        i8 = 0;
        final int i39 = i17;
        minSlotsNeeded = ", received ";
        isNode = ", expected ";
        if (i12 == 0) {
            i7 = 0;
            end = string8;
            StringBuilder end2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(end2.append("Incorrect node count detected at ").append(element).append(isNode).append(i32).append(minSlotsNeeded).append(nodeCount2).toString());
        } else {
            end = string8;
        }
        element2 -= element;
        str = i35 == i19 ? 1 : 0;
        int i38 = 0;
        if (str == null) {
            i8 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            nodeCount = nodeCount2;
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Incorrect slot count detected at ").append(element).append(isNode).append(i35).append(minSlotsNeeded).append(i19).toString());
        } else {
            nodeCount = nodeCount2;
        }
        if (SlotTableKt.access$containsAnyMark(obj.groups, element)) {
            if (element > 0) {
                if (SlotTableKt.access$containsMark(obj.groups, i13)) {
                    minSlotsNeeded = 1;
                } else {
                    minSlotsNeeded = 0;
                }
            } else {
            }
            z = 0;
            if (minSlotsNeeded == 0) {
                int i15 = 0;
                StringBuilder stringBuilder3 = new StringBuilder();
                PreconditionsKt.throwIllegalStateException(stringBuilder3.append("Expected group ").append(i13).append(" to record it contains a mark because ").append(element).append(" does").toString());
            }
        }
        i10 = z3 ? 1 : nodeCount;
        return i10;
    }

    private static final void verifyWellFormed$verifySourceGroup(androidx.compose.runtime.SlotTable this$0, androidx.compose.runtime.GroupSourceInformation group) {
        int i3;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i;
        boolean ownsAnchor;
        int i2;
        String str;
        final ArrayList groups = group.getGroups();
        if (groups != null) {
            i3 = 0;
            index$iv = 0;
            while (index$iv < (List)groups.size()) {
                obj2 = obj;
                i = 0;
                if (obj2 instanceof Anchor) {
                } else {
                }
                if (obj2 instanceof GroupSourceInformation) {
                }
                index$iv++;
                SlotTable.verifyWellFormed$verifySourceGroup(this$0, (GroupSourceInformation)obj2);
                int i4 = 0;
                if (!(Anchor)obj2.getValid()) {
                }
                i2 = 0;
                if (!this$0.ownsAnchor((Anchor)obj2)) {
                }
                int i5 = 0;
                PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                int i6 = 0;
                PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
            }
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final androidx.compose.runtime.Anchor anchor(int index) {
        int i;
        int groupsSize;
        String str;
        Object obj;
        Object anchor;
        groupsSize = 0;
        if (writer ^= i == 0) {
            int i7 = 0;
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to create an anchor location instead");
        }
        if (index >= 0 && index < this.groupsSize) {
            if (index < this.groupsSize) {
            } else {
                i = value$iv;
            }
        } else {
        }
        int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            PreconditionsKt.throwIllegalArgumentException("Parameter index is out of range");
        }
        ArrayList $i$f$requirePrecondition = this.anchors;
        int i5 = 0;
        int i6 = SlotTableKt.access$search($i$f$requirePrecondition, index, this.groupsSize);
        if (i6 < 0) {
            int i8 = 0;
            anchor = new Anchor(index);
            $i$f$requirePrecondition.add(-i9, anchor);
        } else {
            anchor = obj;
        }
        return anchor;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final int anchorIndex(androidx.compose.runtime.Anchor anchor) {
        String str;
        int i2 = 0;
        if (writer ^= 1 == 0) {
            int i4 = 0;
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }
        int i3 = 0;
        if (!anchor.getValid()) {
            int i5 = 0;
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }
        return anchor.getLocation$runtime_release();
    }

    public final void close$runtime_release(androidx.compose.runtime.SlotReader reader, HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> sourceInformationMap) {
        androidx.compose.runtime.SlotTable table$runtime_release;
        int i2;
        int i;
        int iNSTANCE;
        String sourceInformationMap2;
        Map map;
        if (reader.getTable$runtime_release() == this && this.readers > 0) {
            i2 = this.readers > 0 ? 1 : 0;
        } else {
        }
        iNSTANCE = 0;
        if (i2 == 0) {
            int i4 = 0;
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }
        this.readers = value$iv--;
        if (sourceInformationMap != null) {
            i = 0;
            int i3 = 0;
            sourceInformationMap2 = this.sourceInformationMap;
            synchronized (this) {
                sourceInformationMap2.putAll((Map)sourceInformationMap);
                iNSTANCE = Unit.INSTANCE;
            }
        }
    }

    public final void close$runtime_release(androidx.compose.runtime.SlotWriter writer, int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<androidx.compose.runtime.Anchor> anchors, HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> sourceInformationMap, MutableIntObjectMap<MutableIntSet> calledByMap) {
        androidx.compose.runtime.SlotTable table$runtime_release;
        int i;
        String str;
        int i2 = 0;
        if (writer.getTable$runtime_release() == this && this.writer) {
            i = this.writer ? 1 : i2;
        } else {
        }
        int i4 = 0;
        if (i == 0) {
            int i5 = 0;
            PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
        }
        this.writer = i2;
        this.setTo$runtime_release(groups, groupsSize, slots, slotsSize, anchors, sourceInformationMap, calledByMap);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final void collectCalledByInformation() {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        this.calledByMap = mutableIntObjectMap;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final void collectSourceInformation() {
        HashMap hashMap = new HashMap();
        this.sourceInformationMap = hashMap;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final boolean containsMark() {
        int groupsSize;
        int i;
        if (this.groupsSize > 0 && SlotTableKt.access$containsMark(this.groups, 0)) {
            if (SlotTableKt.access$containsMark(this.groups, i)) {
                i = 1;
            }
        }
        return i;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object identityToFind) {
        SlotTableGroup slotTableGroup = new SlotTableGroup(this, 0, 0, 4, 0);
        return slotTableGroup.find(identityToFind);
    }

    public final ArrayList<androidx.compose.runtime.Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime_release() {
        return this.calledByMap;
    }

    public Iterable<CompositionGroup> getCompositionGroups() {
        return (Iterable)this;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final int[] getGroups() {
        return this.groups;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final int getGroupsSize() {
        return this.groupsSize;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final Object[] getSlots() {
        return this.slots;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> getSourceInformationMap$runtime_release() {
        return this.sourceInformationMap;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final int getVersion$runtime_release() {
        return this.version;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final boolean groupContainsAnchor(int groupIndex, androidx.compose.runtime.Anchor anchor) {
        int i;
        int i2;
        int ownsAnchor;
        int groupsSize;
        String str2;
        int location$runtime_release;
        String str;
        i = 1;
        groupsSize = 0;
        if (writer ^= i == 0) {
            int i6 = 0;
            ComposerKt.composeImmediateRuntimeError("Writer is active");
        }
        int value$iv = 0;
        if (groupIndex >= 0 && groupIndex < this.groupsSize) {
            i2 = groupIndex < this.groupsSize ? i : value$iv;
        } else {
        }
        location$runtime_release = 0;
        if (i2 == 0) {
            int i7 = 0;
            ComposerKt.composeImmediateRuntimeError("Invalid group index");
        }
        if (ownsAnchor(anchor)) {
            location$runtime_release = anchor.getLocation$runtime_release();
            if (groupIndex <= location$runtime_release && location$runtime_release < i4 += groupIndex) {
                ownsAnchor = location$runtime_release < i4 += groupIndex ? i : value$iv;
            } else {
            }
            if (ownsAnchor != 0) {
            } else {
                i = value$iv;
            }
        } else {
        }
        return i;
    }

    public final List<androidx.compose.runtime.RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int target) {
        Object calledByMap;
        int i4;
        int i3;
        Object obj3;
        MutableIntSet mutableIntSet;
        Object obj2;
        int index$iv;
        int i2;
        Object obj;
        int i;
        Object anchor;
        MutableIntSet set;
        i4 = target;
        ArrayList arrayList = new ArrayList();
        final ArrayList list = arrayList;
        ArrayList arrayList2 = new ArrayList();
        final ArrayList list2 = arrayList2;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        int i5 = 1;
        booleanRef.element = i5;
        mutableIntSet = new MutableIntSet(0, i5, 0);
        MutableIntSet set2 = mutableIntSet;
        i3 = 0;
        set2.add(i4);
        set2.add(-3);
        Object obj5 = this;
        calledByMap = obj5.calledByMap;
        calledByMap = calledByMap.get(i4);
        if (calledByMap != null && (MutableIntSet)calledByMap != null) {
            calledByMap = calledByMap.get(i4);
            if ((MutableIntSet)(MutableIntSet)calledByMap != null) {
                i3 = 0;
                mutableIntSet.addAll((IntSet)(MutableIntSet)(MutableIntSet)calledByMap);
            }
        }
        int i13 = 0;
        androidx.compose.runtime.SlotReader reader3 = reader;
        int i16 = 0;
        int i6 = 0;
        SlotTable.invalidateGroupsWithKey$lambda$20$scanGroup(reader3, mutableIntSet, (List)list, booleanRef, obj5, (List)list2);
        Unit iNSTANCE = Unit.INSTANCE;
        reader3.close();
        int i11 = 0;
        androidx.compose.runtime.SlotWriter writer3 = writer;
        int i14 = 0;
        int i15 = 0;
        androidx.compose.runtime.SlotWriter writer2 = writer3;
        int i17 = 0;
        writer2.startGroup();
        final ArrayList list3 = list;
        final int i18 = 0;
        index$iv = 0;
        while (index$iv < list3.size()) {
            i = 0;
            Object obj4 = obj8;
            if (obj4.toIndexFor(writer2) >= writer2.getCurrentGroup()) {
            }
            index$iv++;
            i4 = target;
            obj3 = anchor;
            mutableIntSet = set;
            writer2.seek(obj4);
            writer2.bashCurrentGroup();
        }
        Object this_$iv = obj3;
        MutableIntSet set3 = mutableIntSet;
        writer2.skipToGroupEnd();
        int endGroup = writer2.endGroup();
        int i7 = 0;
        writer3.close(true);
        i2 = booleanRef.element ? list2 : 0;
        return i2;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        int i;
        i = this.groupsSize == 0 ? 1 : 0;
        return i;
    }

    public Iterator<CompositionGroup> iterator() {
        GroupIterator groupIterator = new GroupIterator(this, 0, this.groupsSize);
        return (Iterator)groupIterator;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final androidx.compose.runtime.SlotReader openReader() {
        if (this.writer) {
        } else {
            this.readers = readers++;
            SlotReader slotReader = new SlotReader(this);
            return slotReader;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot read while a writer is pending".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final androidx.compose.runtime.SlotWriter openWriter() {
        int i;
        String str;
        final int i4 = 1;
        int i5 = 0;
        if (writer ^= i4 == 0) {
            int i8 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        i = this.readers <= 0 ? i4 : 0;
        int i6 = 0;
        if (i == 0) {
            int i7 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.writer = i4;
        this.version = version += i4;
        SlotWriter slotWriter = new SlotWriter(this);
        return slotWriter;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final boolean ownsAnchor(androidx.compose.runtime.Anchor anchor) {
        boolean it;
        int i2;
        int i;
        int i3;
        boolean equal;
        if (anchor.getValid()) {
            int i4 = SlotTableKt.access$search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize);
            i = 0;
            i3 = 1;
            if (i4 >= 0 && Intrinsics.areEqual(this.anchors.get(i4), anchor)) {
                it = Intrinsics.areEqual(this.anchors.get(i4), anchor) ? i3 : i2;
            } else {
            }
            if (it != 0) {
                i2 = i3;
            }
        }
        return i2;
    }

    public final <T> T read(Function1<? super androidx.compose.runtime.SlotReader, ? extends T> block) {
        final int i = 0;
        final androidx.compose.runtime.SlotReader reader = openReader();
        final int i2 = 0;
        reader.close();
        return block.invoke(reader);
    }

    public final void setAnchors$runtime_release(ArrayList<androidx.compose.runtime.Anchor> <set-?>) {
        this.anchors = <set-?>;
    }

    public final void setCalledByMap$runtime_release(MutableIntObjectMap<MutableIntSet> <set-?>) {
        this.calledByMap = <set-?>;
    }

    public final void setSourceInformationMap$runtime_release(HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> <set-?>) {
        this.sourceInformationMap = <set-?>;
    }

    public final void setTo$runtime_release(int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<androidx.compose.runtime.Anchor> anchors, HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> sourceInformationMap, MutableIntObjectMap<MutableIntSet> calledByMap) {
        this.groups = groups;
        this.groupsSize = groupsSize;
        this.slots = slots;
        this.slotsSize = slotsSize;
        this.anchors = anchors;
        this.sourceInformationMap = sourceInformationMap;
        this.calledByMap = calledByMap;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final void setVersion$runtime_release(int <set-?>) {
        this.version = <set-?>;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final Object slot$runtime_release(int group, int slotIndex) {
        int length;
        int groupsSize;
        int i;
        int i2 = SlotTableKt.access$slotAnchor(this.groups, group);
        if (group + 1 < this.groupsSize) {
            length = SlotTableKt.access$dataAnchor(this.groups, group + 1);
        } else {
            length = slots.length;
        }
        i = 0;
        if (slotIndex >= 0 && slotIndex < length - i2) {
            if (slotIndex < length - i2) {
                i = 1;
            }
        }
        if (i != 0) {
            return this.slots[i2 + slotIndex];
        }
        return Composer.Companion.getEmpty();
    }

    public final List<Object> slotsOf$runtime_release(int group) {
        int length;
        int groupsSize;
        if (group + 1 < this.groupsSize) {
            length = SlotTableKt.access$dataAnchor(this.groups, group + 1);
        } else {
            length = slots.length;
        }
        return ArraysKt.toList(this.slots).subList(SlotTableKt.access$dataAnchor(this.groups, group), length);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final androidx.compose.runtime.GroupSourceInformation sourceInformationOf(int group) {
        int i;
        int i2;
        androidx.compose.runtime.Anchor tryAnchor;
        Object obj;
        final HashMap sourceInformationMap = this.sourceInformationMap;
        i = 0;
        i2 = 0;
        tryAnchor = tryAnchor(group);
        if (sourceInformationMap != null && tryAnchor != null) {
            i2 = 0;
            tryAnchor = tryAnchor(group);
            if (tryAnchor != null) {
                int i3 = 0;
                i = obj;
            }
        }
        return i;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final String toDebugString() {
        String string;
        String str;
        int i;
        int groupsSize;
        int current;
        int emitGroup;
        if (this.writer) {
            string = super.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder sb = stringBuilder;
            i = 0;
            sb.append(super.toString());
            sb.append('\n');
            groupsSize = this.groupsSize;
            if (groupsSize > 0) {
                current = 0;
                while (current < groupsSize) {
                    current += emitGroup;
                }
            } else {
                sb.append("<EMPTY>");
            }
            Intrinsics.checkNotNullExpressionValue(stringBuilder.toString(), "StringBuilder().apply(builderAction).toString()");
        }
        return string;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final void verifyWellFormed() {
        int groupsSize3;
        int value$iv;
        int lastLocation;
        int i4;
        int i3;
        Object iterator;
        String element;
        int value;
        StringBuilder append;
        int index$iv;
        int groupsSize2;
        int ownsAnchor;
        StringBuilder append2;
        String str;
        int i5;
        int indexFor;
        int groupsSize;
        int i;
        int i2;
        String str2;
        Ref.IntRef intRef = new Ref.IntRef();
        int i6 = 0;
        i4 = 1;
        if (this.groupsSize > 0) {
        }
        value$iv = this.slotsSize;
        while (value$iv < slots.length) {
            if (this.slots[value$iv] == null) {
            } else {
            }
            element = i6;
            append = null;
            if (element == null) {
            }
            value$iv++;
            int i9 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Non null value in the slot gap at index ").append(value$iv).toString());
            element = i4;
        }
        int index = 0;
        lastLocation = -1;
        iterator = this.anchors;
        value = 0;
        index$iv = 0;
        while (index$iv < (List)iterator.size()) {
            i5 = 0;
            indexFor = (Anchor)iterator.get(index$iv).toIndexFor(this);
            if (indexFor >= 0 && indexFor <= this.groupsSize) {
            } else {
            }
            i = i6;
            int i13 = 0;
            if (i == 0) {
            }
            if (lastLocation < indexFor) {
            } else {
            }
            groupsSize = i6;
            i2 = 0;
            if (groupsSize == 0) {
            }
            lastLocation = indexFor;
            index$iv++;
            int i14 = 0;
            PreconditionsKt.throwIllegalArgumentException("Anchor is out of order");
            groupsSize = i4;
            int i15 = 0;
            PreconditionsKt.throwIllegalArgumentException("Invalid anchor, location out of bound");
            if (indexFor <= this.groupsSize) {
            } else {
            }
            i = i4;
        }
        HashMap sourceInformationMap = this.sourceInformationMap;
        if (sourceInformationMap != null) {
            i4 = 0;
            iterator = (Map)sourceInformationMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Object next = iterator.next();
                index$iv = (Map.Entry)next.getKey();
                int i10 = 0;
                if (!(Anchor)index$iv.getValid()) {
                }
                append2 = 0;
                if (ownsAnchor(index$iv) == 0) {
                }
                SlotTable.verifyWellFormed$verifySourceGroup(this, (GroupSourceInformation)next.getValue());
                int i11 = 0;
                PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                int i12 = 0;
                PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
            }
        }
    }

    public final <T> T write(Function1<? super androidx.compose.runtime.SlotWriter, ? extends T> block) {
        final int i = 0;
        final androidx.compose.runtime.SlotWriter writer = openWriter();
        final int i2 = 0;
        int i3 = 0;
        final Object invoke = block.invoke(writer);
        final Object obj = invoke;
        final int i4 = 0;
        writer.close(true);
        return invoke;
    }
}
