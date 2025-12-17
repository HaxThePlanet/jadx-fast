package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000cj\u0008\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0002\u0010\u000fJN\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u000201J \u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020(H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u001bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u001c\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000cj\u0008\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00066", d2 = {"Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "", "currentPosition", "Landroidx/compose/ui/geometry/Offset;", "previousHandlePosition", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "(JJLandroidx/compose/ui/layout/LayoutCoordinates;ZLandroidx/compose/foundation/text/selection/Selection;Ljava/util/Comparator;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCurrentPosition-F1C5BW0", "()J", "J", "currentSlot", "", "endSlot", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "()Z", "getPreviousHandlePosition-F1C5BW0", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "getSelectableIdOrderingComparator", "()Ljava/util/Comparator;", "selectableIdToInfoListIndex", "Landroidx/collection/MutableLongIntMap;", "startSlot", "appendInfo", "selectableId", "rawStartHandleOffset", "startXHandleDirection", "Landroidx/compose/foundation/text/selection/Direction;", "startYHandleDirection", "rawEndHandleOffset", "endXHandleDirection", "endYHandleDirection", "rawPreviousHandleOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "build", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "updateSlot", "slot", "xPositionDirection", "yPositionDirection", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionLayoutBuilder {

    public static final int $stable = 8;
    private final LayoutCoordinates containerCoordinates;
    private final long currentPosition;
    private int currentSlot;
    private int endSlot;
    private final List<androidx.compose.foundation.text.selection.SelectableInfo> infoList;
    private final boolean isStartHandle;
    private final long previousHandlePosition;
    private final androidx.compose.foundation.text.selection.Selection previousSelection;
    private final Comparator<Long> selectableIdOrderingComparator;
    private final MutableLongIntMap selectableIdToInfoListIndex;
    private int startSlot;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[Direction.BEFORE.ordinal()] = 1;
            iArr[Direction.ON.ordinal()] = 2;
            iArr[Direction.AFTER.ordinal()] = 3;
            SelectionLayoutBuilder.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    private SelectionLayoutBuilder(long currentPosition, long previousHandlePosition, LayoutCoordinates containerCoordinates, boolean isStartHandle, androidx.compose.foundation.text.selection.Selection previousSelection, Comparator<Long> selectableIdOrderingComparator) {
        super();
        this.currentPosition = currentPosition;
        this.previousHandlePosition = containerCoordinates;
        this.containerCoordinates = previousSelection;
        this.isStartHandle = selectableIdOrderingComparator;
        this.previousSelection = obj8;
        this.selectableIdOrderingComparator = obj9;
        this.selectableIdToInfoListIndex = LongIntMapKt.mutableLongIntMapOf();
        ArrayList arrayList = new ArrayList();
        this.infoList = (List)arrayList;
        int i = -1;
        this.startSlot = i;
        this.endSlot = i;
        this.currentSlot = i;
    }

    public SelectionLayoutBuilder(long l, long l2, LayoutCoordinates layoutCoordinates3, boolean z4, androidx.compose.foundation.text.selection.Selection selection5, Comparator comparator6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(l, l2, layoutCoordinates3, z4, selection5, comparator6, defaultConstructorMarker7, obj8);
    }

    private final int updateSlot(int slot, androidx.compose.foundation.text.selection.Direction xPositionDirection, androidx.compose.foundation.text.selection.Direction yPositionDirection) {
        int currentSlot;
        if (slot != -1) {
            return slot;
        }
        switch (i2) {
            case 1:
                currentSlot2--;
                break;
            case 2:
                currentSlot = this.currentSlot;
                break;
            case 3:
                currentSlot = slot;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return currentSlot;
    }

    public final androidx.compose.foundation.text.selection.SelectableInfo appendInfo(long selectableId, int rawStartHandleOffset, androidx.compose.foundation.text.selection.Direction startXHandleDirection, androidx.compose.foundation.text.selection.Direction startYHandleDirection, int rawEndHandleOffset, androidx.compose.foundation.text.selection.Direction endXHandleDirection, androidx.compose.foundation.text.selection.Direction endYHandleDirection, int rawPreviousHandleOffset, TextLayoutResult textLayoutResult) {
        this.currentSlot = currentSlot += 2;
        SelectableInfo selectableInfo = new SelectableInfo(selectableId, obj3, this.currentSlot, startXHandleDirection, endXHandleDirection, textLayoutResult, obj19);
        this.startSlot = updateSlot(this.startSlot, startYHandleDirection, rawEndHandleOffset);
        this.endSlot = updateSlot(this.endSlot, endYHandleDirection, rawPreviousHandleOffset);
        this.selectableIdToInfoListIndex.set(selectableId, rawStartHandleOffset);
        (Collection)this.infoList.add(selectableInfo);
        return selectableInfo;
    }

    public final androidx.compose.foundation.text.selection.SelectionLayout build() {
        int startSlot2;
        int endSlot;
        int startSlot;
        Object singleSelectionLayout;
        boolean isStartHandle;
        int infoList;
        int i;
        int previousSelection;
        Object isStartHandle2;
        androidx.compose.foundation.text.selection.Selection previousSelection2;
        currentSlot++;
        int i3 = -1;
        switch (size) {
            case 0:
                IllegalStateException illegalStateException = new IllegalStateException("SelectionLayout must not be empty.");
                throw illegalStateException;
            case 1:
                infoList = i2;
                infoList = startSlot2;
                i = i2;
                i = endSlot;
                singleSelectionLayout = new SingleSelectionLayout(this.isStartHandle, infoList, i, this.previousSelection, (SelectableInfo)CollectionsKt.single(this.infoList));
                break;
            default:
                i = i2;
                i = startSlot;
                previousSelection = i2;
                previousSelection = endSlot;
                singleSelectionLayout = new MultiSelectionLayout((LongIntMap)this.selectableIdToInfoListIndex, this.infoList, i, previousSelection, this.isStartHandle, this.previousSelection);
        }
        return singleSelectionLayout;
    }

    public final LayoutCoordinates getContainerCoordinates() {
        return this.containerCoordinates;
    }

    public final long getCurrentPosition-F1C5BW0() {
        return this.currentPosition;
    }

    public final long getPreviousHandlePosition-F1C5BW0() {
        return this.previousHandlePosition;
    }

    public final androidx.compose.foundation.text.selection.Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public final Comparator<Long> getSelectableIdOrderingComparator() {
        return this.selectableIdOrderingComparator;
    }

    public final boolean isStartHandle() {
        return this.isStartHandle;
    }
}
