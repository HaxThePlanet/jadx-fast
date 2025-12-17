package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00080$2\u0006\u0010%\u001a\u00020\u0008H\u0016J\u001c\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020'0)H\u0016J\u0012\u0010*\u001a\u00020\u00032\u0008\u0010+\u001a\u0004\u0018\u00010\u0001H\u0016J\u0008\u0010,\u001a\u00020-H\u0016R\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0016R\u0014\u0010 \u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0016¨\u0006/", d2 = {"Landroidx/compose/foundation/text/selection/SingleSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "isStartHandle", "", "startSlot", "", "endSlot", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "info", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "(ZIILandroidx/compose/foundation/text/selection/Selection;Landroidx/compose/foundation/text/selection/SelectableInfo;)V", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "currentInfo", "getCurrentInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "getEndSlot", "()I", "firstInfo", "getFirstInfo", "()Z", "lastInfo", "getLastInfo", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "size", "getSize", "startInfo", "getStartInfo", "getStartSlot", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "shouldRecomputeSelection", "other", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SingleSelectionLayout implements androidx.compose.foundation.text.selection.SelectionLayout {

    public static final androidx.compose.foundation.text.selection.SingleSelectionLayout.Companion Companion = null;
    public static final long DEFAULT_SELECTABLE_ID = 1L;
    public static final int DEFAULT_SLOT = 1;
    private final int endSlot;
    private final androidx.compose.foundation.text.selection.SelectableInfo info;
    private final boolean isStartHandle;
    private final androidx.compose.foundation.text.selection.Selection previousSelection;
    private final int startSlot;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/text/selection/SingleSelectionLayout$Companion;", "", "()V", "DEFAULT_SELECTABLE_ID", "", "DEFAULT_SLOT", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        SingleSelectionLayout.Companion companion = new SingleSelectionLayout.Companion(0);
        SingleSelectionLayout.Companion = companion;
    }

    public SingleSelectionLayout(boolean isStartHandle, int startSlot, int endSlot, androidx.compose.foundation.text.selection.Selection previousSelection, androidx.compose.foundation.text.selection.SelectableInfo info) {
        super();
        this.isStartHandle = isStartHandle;
        this.startSlot = startSlot;
        this.endSlot = endSlot;
        this.previousSelection = previousSelection;
        this.info = info;
    }

    public LongObjectMap<androidx.compose.foundation.text.selection.Selection> createSubSelections(androidx.compose.foundation.text.selection.Selection selection) {
        androidx.compose.foundation.text.selection.Selection copy$default;
        int handlesCrossed;
        int offset;
        int i;
        int i3;
        int i2;
        androidx.compose.foundation.text.selection.Selection selection2 = selection;
        final int i5 = 0;
        if (!selection2.getHandlesCrossed()) {
            if (selection2.getStart().getOffset() <= selection2.getEnd().getOffset()) {
                if (selection2.getHandlesCrossed() && selection2.getStart().getOffset() <= selection2.getEnd().getOffset()) {
                    if (selection2.getStart().getOffset() <= selection2.getEnd().getOffset()) {
                        copy$default = Selection.copy$default(selection2, 0, 0, handlesCrossed2 ^ 1, 3, 0);
                    } else {
                        copy$default = selection2;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return LongObjectMapKt.longObjectMapOf(this.info.getSelectableId(), i);
    }

    public void forEachMiddleInfo(Function1<? super androidx.compose.foundation.text.selection.SelectableInfo, Unit> block) {
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
                rawCrossStatus = this.info.getRawCrossStatus();
            }
        }
        return rawCrossStatus;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getCurrentInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getEndInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getEndSlot() {
        return this.endSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getFirstInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getLastInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.Selection getPreviousSelection() {
        return this.previousSelection;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return 1;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public androidx.compose.foundation.text.selection.SelectableInfo getStartInfo() {
        return this.info;
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
        androidx.compose.foundation.text.selection.Selection recomputeSelection;
        int startHandle;
        if (getPreviousSelection() != null && other != null && other instanceof SingleSelectionLayout && getStartSlot() == (SingleSelectionLayout)other.getStartSlot() && getEndSlot() == (SingleSelectionLayout)other.getEndSlot() && isStartHandle() == (SingleSelectionLayout)other.isStartHandle()) {
            if (other != null) {
                if (other instanceof SingleSelectionLayout) {
                    if (getStartSlot() == (SingleSelectionLayout)other.getStartSlot()) {
                        if (getEndSlot() == (SingleSelectionLayout)other.getEndSlot()) {
                            if (isStartHandle() == (SingleSelectionLayout)other.isStartHandle()) {
                                if (this.info.shouldRecomputeSelection(obj4.info)) {
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
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SingleSelectionLayout(isStartHandle=").append(isStartHandle()).append(", crossed=").append(getCrossStatus()).append(", info=\n\t").append(this.info).append(')').toString();
    }
}
