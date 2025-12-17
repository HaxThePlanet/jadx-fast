package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeImpl.Companion;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a(\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0008H\u0002\u001a(\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00082\u0006\u0010\u000c\u001a\u00020\u0001H\u0002\u001a(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0014", d2 = {"currentNodeIndex", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "positionToInsert", "anchor", "Landroidx/compose/runtime/Anchor;", "applier", "Landroidx/compose/runtime/Applier;", "", "positionToParentOf", "", "index", "releaseMovableGroupAtCurrent", "composition", "Landroidx/compose/runtime/ControlledComposition;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OperationKt {
    public static final int access$positionToInsert(SlotWriter slots, Anchor anchor, Applier applier) {
        return OperationKt.positionToInsert(slots, anchor, applier);
    }

    public static final void access$positionToParentOf(SlotWriter slots, Applier applier, int index) {
        OperationKt.positionToParentOf(slots, applier, index);
    }

    public static final void access$releaseMovableGroupAtCurrent(ControlledComposition composition, CompositionContext parentContext, MovableContentStateReference reference, SlotWriter slots) {
        OperationKt.releaseMovableGroupAtCurrent(composition, parentContext, reference, slots);
    }

    private static final int currentNodeIndex(SlotWriter slots) {
        int current2;
        int current;
        boolean node;
        int index;
        boolean groupSize;
        int nodeCount;
        final int currentGroup = slots.getCurrentGroup();
        current2 = slots.getParent();
        while (current2 >= 0) {
            if (!slots.isNode(current2)) {
            }
            current2 = slots.parent(current2);
        }
        index = 0;
        final int i = 1;
        current2 += i;
        while (current < currentGroup) {
            if (slots.indexInGroup(currentGroup, current)) {
            } else {
            }
            if (slots.isNode(current)) {
            } else {
            }
            nodeCount = slots.nodeCount(current);
            index += nodeCount;
            current += groupSize;
            nodeCount = i;
            if (slots.isNode(current)) {
            }
            current++;
            index = 0;
        }
        return index;
    }

    private static final int positionToInsert(SlotWriter slots, Anchor anchor, Applier<Object> applier) {
        int i;
        int nodeIndex;
        int i2;
        boolean skipGroup;
        final int anchorIndex = slots.anchorIndex(anchor);
        final int i3 = 0;
        i = slots.getCurrentGroup() < anchorIndex ? i2 : i3;
        ComposerKt.runtimeCheck(i);
        OperationKt.positionToParentOf(slots, applier, anchorIndex);
        nodeIndex = OperationKt.currentNodeIndex(slots);
        while (slots.getCurrentGroup() < anchorIndex) {
            if (slots.indexInCurrentGroup(anchorIndex)) {
            } else {
            }
            nodeIndex += skipGroup;
            if (slots.isNode()) {
            }
            slots.startGroup();
            applier.down(slots.node(slots.getCurrentGroup()));
            nodeIndex = 0;
        }
        if (slots.getCurrentGroup() == anchorIndex) {
        } else {
            i2 = i3;
        }
        ComposerKt.runtimeCheck(i2);
        return nodeIndex;
    }

    private static final void positionToParentOf(SlotWriter slots, Applier<Object> applier, int index) {
        boolean node;
        while (!slots.indexInParent(index)) {
            slots.skipToGroupEnd();
            if (slots.isNode(slots.getParent())) {
            }
            slots.endGroup();
            applier.up();
        }
    }

    private static final void releaseMovableGroupAtCurrent(ControlledComposition composition, CompositionContext parentContext, MovableContentStateReference reference, SlotWriter slots) {
        boolean it$iv;
        int i4;
        Object writer;
        int i6;
        int i5;
        ControlledComposition controlledComposition;
        ControlledComposition controlledComposition2;
        Object obj;
        Object obj3;
        int i;
        boolean i3;
        int i2;
        RecomposeScopeImpl.Companion companion;
        androidx.compose.runtime.changelist.OperationKt.releaseMovableGroupAtCurrent.movableContentRecomposeScopeOwner.1 anon;
        final MovableContentStateReference movableContentStateReference = reference;
        SlotTable slotTable = new SlotTable();
        final SlotTable slotTable2 = slotTable;
        if (slots.getCollectingSourceInformation()) {
            slotTable2.collectSourceInformation();
        }
        if (slots.getCollectingCalledInformation()) {
            slotTable2.collectCalledByInformation();
        }
        i4 = 0;
        writer = writer2;
        i6 = 0;
        i5 = 0;
        SlotWriter writer3 = writer;
        int i7 = 0;
        writer3.beginInsert();
        writer3.startGroup(126665345, movableContentStateReference.getContent$runtime_release());
        i = 1;
        SlotWriter.markGroup$default(writer3, 0, i, 0);
        writer3.update(movableContentStateReference.getParameter$runtime_release());
        java.util.List moveTo = slots.moveTo(movableContentStateReference.getAnchor$runtime_release(), i, writer3);
        writer3.skipGroup();
        writer3.endGroup();
        writer3.endInsert();
        java.util.List writer4 = moveTo;
        int i8 = 0;
        writer.close(true);
        MovableContentState movableContentState = new MovableContentState(slotTable2);
        if (RecomposeScopeImpl.Companion.hasAnchoredRecomposeScopes$runtime_release(slotTable2, moveTo)) {
            OperationKt.releaseMovableGroupAtCurrent.movableContentRecomposeScopeOwner.1 anon2 = new OperationKt.releaseMovableGroupAtCurrent.movableContentRecomposeScopeOwner.1(composition, movableContentStateReference);
            i6 = 0;
            i5 = writer5;
            i = 0;
            i3 = 0;
            int i12 = 0;
            RecomposeScopeImpl.Companion.adoptAnchoredScopes$runtime_release(i5, moveTo, (RecomposeScopeOwner)anon2);
            Unit writer7 = Unit.INSTANCE;
            i2 = 0;
            i5.close(true);
        } else {
            controlledComposition2 = composition;
        }
        parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
    }
}
