package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMap;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\r0+2\u0006\u0010,\u001a\u00020\rH\u0016J\u001c\u0010-\u001a\u00020.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.00H\u0016J\u0010\u00101\u001a\u00020\u00082\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0000H\u0002J\u0012\u00106\u001a\u00020\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u0001H\u0016J\u0018\u00107\u001a\u00020\u00082\u0006\u00108\u001a\u00020\u00082\u0006\u00109\u001a\u00020\u000bH\u0002J\u0018\u0010:\u001a\u00020\u00082\u0006\u00108\u001a\u00020\u00082\u0006\u0010;\u001a\u00020\u000bH\u0002J\u0008\u0010<\u001a\u00020=H\u0016J2\u0010>\u001a\u00020.*\u0008\u0012\u0004\u0012\u00020\r0?2\u0006\u0010,\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00082\u0006\u0010B\u001a\u00020\u0008H\u0002R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0015R\u0014\u0010\t\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0015R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010\u0015R\u0016\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0014\u0010%\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u0019¨\u0006C", d2 = {"Landroidx/compose/foundation/text/selection/MultiSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectableIdToInfoListIndex", "Landroidx/collection/LongIntMap;", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "startSlot", "", "endSlot", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "(Landroidx/collection/LongIntMap;Ljava/util/List;IIZLandroidx/compose/foundation/text/selection/Selection;)V", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "currentInfo", "getCurrentInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "getEndSlot", "()I", "firstInfo", "getFirstInfo", "getInfoList", "()Ljava/util/List;", "()Z", "lastInfo", "getLastInfo", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "getSelectableIdToInfoListIndex", "()Landroidx/collection/LongIntMap;", "size", "getSize", "startInfo", "getStartInfo", "getStartSlot", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "getInfoListIndexBySelectableId", "id", "", "shouldAnyInfoRecomputeSelection", "other", "shouldRecomputeSelection", "slotToIndex", "slot", "isMinimumSlot", "startOrEndSlotToIndex", "isStartSlot", "toString", "", "createAndPutSubSelection", "Landroidx/collection/MutableLongObjectMap;", "info", "minOffset", "maxOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MultiSelectionLayout implements androidx.compose.foundation.text.selection.SelectionLayout {

    private final int endSlot;
    private final List<androidx.compose.foundation.text.selection.SelectableInfo> infoList;
    private final boolean isStartHandle;
    private final androidx.compose.foundation.text.selection.Selection previousSelection;
    private final LongIntMap selectableIdToInfoListIndex;
    private final int startSlot;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[CrossStatus.COLLAPSED.ordinal()] = 1;
            iArr[CrossStatus.NOT_CROSSED.ordinal()] = 2;
            iArr[CrossStatus.CROSSED.ordinal()] = 3;
            MultiSelectionLayout.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public MultiSelectionLayout(LongIntMap selectableIdToInfoListIndex, List<androidx.compose.foundation.text.selection.SelectableInfo> infoList, int startSlot, int endSlot, boolean isStartHandle, androidx.compose.foundation.text.selection.Selection previousSelection) {
        int i;
        super();
        this.selectableIdToInfoListIndex = selectableIdToInfoListIndex;
        this.infoList = infoList;
        this.startSlot = startSlot;
        this.endSlot = endSlot;
        this.isStartHandle = isStartHandle;
        this.previousSelection = previousSelection;
        if (this.infoList.size() > 1) {
        } else {
            i = 0;
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("MultiSelectionLayout requires an infoList size greater than 1, was ").append(this.infoList.size()).append('.').toString().toString());
        throw illegalStateException;
    }

    public static final void access$createAndPutSubSelection(androidx.compose.foundation.text.selection.MultiSelectionLayout $this, MutableLongObjectMap $receiver, androidx.compose.foundation.text.selection.Selection selection, androidx.compose.foundation.text.selection.SelectableInfo info, int minOffset, int maxOffset) {
        $this.createAndPutSubSelection($receiver, selection, info, minOffset, maxOffset);
    }

    private final void createAndPutSubSelection(MutableLongObjectMap<androidx.compose.foundation.text.selection.Selection> $this$createAndPutSubSelection, androidx.compose.foundation.text.selection.Selection selection, androidx.compose.foundation.text.selection.SelectableInfo info, int minOffset, int maxOffset) {
        androidx.compose.foundation.text.selection.Selection singleLayoutSelection;
        int i;
        if (selection.getHandlesCrossed()) {
            singleLayoutSelection = info.makeSingleLayoutSelection(maxOffset, minOffset);
        } else {
            singleLayoutSelection = info.makeSingleLayoutSelection(minOffset, maxOffset);
        }
        i = minOffset <= maxOffset ? 1 : 0;
        if (i == 0) {
        } else {
            $this$createAndPutSubSelection.put(info.getSelectableId(), obj2);
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("minOffset should be less than or equal to maxOffset: ").append(singleLayoutSelection).toString().toString());
        throw illegalStateException;
    }

    private final int getInfoListIndexBySelectableId(long id) {
        return this.selectableIdToInfoListIndex.get(id);
    }

    private final boolean shouldAnyInfoRecomputeSelection(androidx.compose.foundation.text.selection.MultiSelectionLayout other) {
        int i;
        Object obj;
        Object obj2;
        boolean recomputeSelection;
        final int i3 = 1;
        if (getSize() != other.getSize()) {
            return i3;
        }
        i = 0;
        while (i < this.infoList.size()) {
            i++;
        }
        return 0;
    }

    private final int slotToIndex(int slot, boolean isMinimumSlot) {
        return i2 /= 2;
    }

    private final int startOrEndSlotToIndex(int slot, boolean isStartSlot) {
        int i;
        i = 1;
        switch (i2) {
            case 1:
                break;
            case 2:
                i = isStartSlot;
                break;
            case 3:
                i = 0;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return slotToIndex(slot, i);
    }

    public LongObjectMap<androidx.compose.foundation.text.selection.Selection> createSubSelections(androidx.compose.foundation.text.selection.Selection selection) {
        LongObjectMap mutableLongObjectMapOf;
        boolean handlesCrossed;
        int i3;
        int offset;
        long selectableId;
        Object obj;
        androidx.compose.foundation.text.selection.SelectableInfo lastInfo;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start2;
        int i2;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start;
        int offset2;
        int i;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo anchorInfo;
        Object obj10;
        if (Long.compare(selectableId2, selectableId) == 0) {
            if (selection.getHandlesCrossed()) {
                if (selection.getStart().getOffset() < selection.getEnd().getOffset()) {
                    if (!selection.getHandlesCrossed() && selection.getStart().getOffset() <= selection.getEnd().getOffset()) {
                        i3 = selection.getStart().getOffset() <= selection.getEnd().getOffset() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (i3 == 0) {
            } else {
                mutableLongObjectMapOf = LongObjectMapKt.longObjectMapOf(selection.getStart().getSelectableId(), offset);
                obj = selection;
                return mutableLongObjectMapOf;
            }
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("unexpectedly miss-crossed selection: ").append(selection).toString().toString());
            throw illegalStateException;
        }
        selectableId = mutableLongObjectMapOf;
        i = 0;
        Object obj2 = selection;
        int i5 = 0;
        if (obj2.getHandlesCrossed()) {
            start2 = obj2.getEnd();
        } else {
            start2 = obj2.getStart();
        }
        offset = this;
        obj = selection;
        offset.createAndPutSubSelection(selectableId, obj, getFirstInfo(), start2.getOffset(), getFirstInfo().getTextLength());
        obj10 = new MultiSelectionLayout.createSubSelections.2.1(this, selectableId, obj);
        forEachMiddleInfo((Function1)obj10);
        obj10 = obj;
        int i6 = 0;
        if (obj10.getHandlesCrossed()) {
            start = obj10.getStart();
        } else {
            start = obj10.getEnd();
        }
        offset.createAndPutSubSelection(selectableId, obj, getLastInfo(), 0, start.getOffset());
    }

    public void forEachMiddleInfo(Function1<? super androidx.compose.foundation.text.selection.SelectableInfo, Unit> block) {
        int i;
        Object obj;
        int infoListIndexBySelectableId = getInfoListIndexBySelectableId(getFirstInfo().getSelectableId());
        int infoListIndexBySelectableId2 = getInfoListIndexBySelectableId(getLastInfo().getSelectableId());
        if (infoListIndexBySelectableId + 1 >= infoListIndexBySelectableId2) {
        }
        i = infoListIndexBySelectableId + 1;
        while (i < infoListIndexBySelectableId2) {
            block.invoke(this.infoList.get(i));
            i++;
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.CrossStatus getCrossStatus() {
        androidx.compose.foundation.text.selection.CrossStatus rawCrossStatus;
        int endSlot;
        if (getStartSlot() < getEndSlot()) {
            rawCrossStatus = CrossStatus.NOT_CROSSED;
        } else {
            if (getStartSlot() > getEndSlot()) {
                rawCrossStatus = CrossStatus.CROSSED;
            } else {
                rawCrossStatus = (SelectableInfo)this.infoList.get(startSlot3 /= 2).getRawCrossStatus();
            }
        }
        return rawCrossStatus;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getCurrentInfo() {
        androidx.compose.foundation.text.selection.SelectableInfo startInfo;
        if (isStartHandle()) {
            startInfo = getStartInfo();
        } else {
            startInfo = getEndInfo();
        }
        return startInfo;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getEndInfo() {
        return (SelectableInfo)this.infoList.get(startOrEndSlotToIndex(getEndSlot(), false));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getEndSlot() {
        return this.endSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getFirstInfo() {
        androidx.compose.foundation.text.selection.SelectableInfo startInfo;
        if (getCrossStatus() == CrossStatus.CROSSED) {
            startInfo = getEndInfo();
        } else {
            startInfo = getStartInfo();
        }
        return startInfo;
    }

    public final List<androidx.compose.foundation.text.selection.SelectableInfo> getInfoList() {
        return this.infoList;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getLastInfo() {
        androidx.compose.foundation.text.selection.SelectableInfo startInfo;
        if (getCrossStatus() == CrossStatus.CROSSED) {
            startInfo = getStartInfo();
        } else {
            startInfo = getEndInfo();
        }
        return startInfo;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.Selection getPreviousSelection() {
        return this.previousSelection;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final LongIntMap getSelectableIdToInfoListIndex() {
        return this.selectableIdToInfoListIndex;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return this.infoList.size();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getStartInfo() {
        return (SelectableInfo)this.infoList.get(startOrEndSlotToIndex(getStartSlot(), true));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getStartSlot() {
        return this.startSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean isStartHandle() {
        return this.isStartHandle;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean shouldRecomputeSelection(androidx.compose.foundation.text.selection.SelectionLayout other) {
        int i;
        androidx.compose.foundation.text.selection.Selection anyInfoRecomputeSelection;
        boolean startHandle;
        if (getPreviousSelection() != null && other != null && other instanceof MultiSelectionLayout && isStartHandle() == (MultiSelectionLayout)other.isStartHandle() && getStartSlot() == (MultiSelectionLayout)other.getStartSlot() && getEndSlot() == (MultiSelectionLayout)other.getEndSlot()) {
            if (other != null) {
                if (other instanceof MultiSelectionLayout) {
                    if (isStartHandle() == (MultiSelectionLayout)other.isStartHandle()) {
                        if (getStartSlot() == (MultiSelectionLayout)other.getStartSlot()) {
                            if (getEndSlot() == (MultiSelectionLayout)other.getEndSlot()) {
                                if (shouldAnyInfoRecomputeSelection((MultiSelectionLayout)other)) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public String toString() {
        int first;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        int i2;
        String string;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        float f3 = (float)i8;
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder sb = stringBuilder2;
        final int i9 = 0;
        sb.append("[\n\t");
        int i10 = 0;
        first = 1;
        List infoList = this.infoList;
        final int i11 = 0;
        index$iv = 0;
        while (index$iv < infoList.size()) {
            i2 = 0;
            if (first != 0) {
            } else {
            }
            sb.append(",\n\t");
            StringBuilder stringBuilder3 = new StringBuilder();
            sb.append(stringBuilder3.append(i + 1).append(" -> ").append((SelectableInfo)infoList.get(index$iv)).toString());
            index$iv++;
            first = 0;
        }
        sb.append("\n]");
        String string3 = stringBuilder2.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder.append("MultiSelectionLayout(isStartHandle=").append(isStartHandle()).append(", startPosition=").append(f /= f3).append(", endPosition=").append(f2 /= f3).append(", crossed=").append(getCrossStatus()).append(", infos=").append(string3).append(')').toString();
    }
}
