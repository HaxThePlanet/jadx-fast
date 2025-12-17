package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SlotReader;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.IntRef;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010\u0001J\u001e\u0010(\u001a\u00020$2\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010*2\u0006\u0010+\u001a\u00020,J(\u0010-\u001a\u00020$2\u0008\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u00020$J\u0016\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020,2\u0006\u0010%\u001a\u00020&J\"\u00108\u001a\u00020$2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020$0:2\u0006\u0010<\u001a\u00020;J\u0006\u0010=\u001a\u00020$J\u0006\u0010>\u001a\u00020$J\u0006\u0010?\u001a\u00020$J\u0016\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u0012J\u0006\u0010C\u001a\u00020$J\u0010\u0010D\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0008\u0010E\u001a\u00020$H\u0002J\u0006\u0010F\u001a\u00020$J\u001a\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020\u00052\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,J\u0016\u0010I\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020JJ\u001e\u0010I\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020J2\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020\u0012J\u0010\u0010O\u001a\u00020$2\u0008\u0010P\u001a\u0004\u0018\u00010\u0001J\u001e\u0010Q\u001a\u00020$2\u0006\u00102\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012J\u000e\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020\u0012J\u000e\u0010U\u001a\u00020$2\u0006\u0010T\u001a\u00020\u0012J\u0006\u0010V\u001a\u00020$J\u0008\u0010W\u001a\u00020$H\u0002J\u0008\u0010X\u001a\u00020$H\u0002J\u0008\u0010Y\u001a\u00020$H\u0002J\u0012\u0010Z\u001a\u00020$2\u0008\u0008\u0002\u0010[\u001a\u00020\u000cH\u0002J \u0010\\\u001a\u00020$2\u0006\u00104\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0008\u0010]\u001a\u00020$H\u0002J\u0012\u0010^\u001a\u00020$2\u0008\u0008\u0002\u0010_\u001a\u00020\u000cH\u0002J\u0018\u0010`\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010a\u001a\u00020$J\u0006\u0010b\u001a\u00020$J\u001e\u0010c\u001a\u00020$2\u0006\u0010<\u001a\u00020d2\u0006\u00100\u001a\u0002012\u0006\u0010e\u001a\u000203J\u000e\u0010f\u001a\u00020$2\u0006\u0010'\u001a\u00020gJ\u0006\u0010h\u001a\u00020$J\u0016\u0010i\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012J\u0006\u0010j\u001a\u00020$J\u0006\u0010k\u001a\u00020$J\u0014\u0010l\u001a\u00020$2\u000c\u0010m\u001a\u0008\u0012\u0004\u0012\u00020$0nJ\u0006\u0010o\u001a\u00020$J\u000e\u0010p\u001a\u00020$2\u0006\u0010R\u001a\u00020\u0012J \u0010q\u001a\u00020$2\u0008\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010r\u001a\u00020\u0012J\u0010\u0010s\u001a\u00020$2\u0008\u0010t\u001a\u0004\u0018\u00010\u0001J>\u0010u\u001a\u00020$\"\u0004\u0008\u0000\u0010v\"\u0004\u0008\u0001\u0010w2\u0006\u0010'\u001a\u0002Hw2\u001d\u0010x\u001a\u0019\u0012\u0004\u0012\u0002Hv\u0012\u0004\u0012\u0002Hw\u0012\u0004\u0012\u00020$0y¢\u0006\u0002\u0008z¢\u0006\u0002\u0010{J\u0018\u0010|\u001a\u00020$2\u0008\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010r\u001a\u00020\u0012J\u0010\u0010}\u001a\u00020$2\u0008\u0010P\u001a\u0004\u0018\u00010\u0001J\u001f\u0010~\u001a\u00020$2\u0006\u0010\u007f\u001a\u00020\u00052\u000c\u0010x\u001a\u0008\u0012\u0004\u0012\u00020$0nH\u0086\u0008J\u0018\u0010\u0080\u0001\u001a\u00020$2\u000c\u0010x\u001a\u0008\u0012\u0004\u0012\u00020$0nH\u0086\u0008R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u000eR\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001", d2 = {"Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "", "composer", "Landroidx/compose/runtime/ComposerImpl;", "changeList", "Landroidx/compose/runtime/changelist/ChangeList;", "(Landroidx/compose/runtime/ComposerImpl;Landroidx/compose/runtime/changelist/ChangeList;)V", "getChangeList", "()Landroidx/compose/runtime/changelist/ChangeList;", "setChangeList", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "implicitRootStart", "", "getImplicitRootStart", "()Z", "setImplicitRootStart", "(Z)V", "moveCount", "", "moveFrom", "moveTo", "pastParent", "getPastParent", "pendingDownNodes", "Landroidx/compose/runtime/Stack;", "pendingUps", "reader", "Landroidx/compose/runtime/SlotReader;", "getReader", "()Landroidx/compose/runtime/SlotReader;", "removeFrom", "startedGroup", "startedGroups", "Landroidx/compose/runtime/IntStack;", "writersReaderDelta", "appendValue", "", "anchor", "Landroidx/compose/runtime/Anchor;", "value", "copyNodesToNewAnchorLocation", "nodes", "", "effectiveNodeIndex", "Landroidx/compose/runtime/internal/IntRef;", "copySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "from", "Landroidx/compose/runtime/MovableContentStateReference;", "to", "deactivateCurrentGroup", "determineMovableContentNodeIndex", "effectiveNodeIndexOut", "endCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "endCurrentGroup", "endMovableContentPlacement", "endNodeMovement", "endNodeMovementAndDeleteNode", "nodeIndex", "group", "endRoot", "ensureGroupStarted", "ensureRootStarted", "finalizeComposition", "includeOperationsIn", "other", "insertSlots", "Landroidx/compose/runtime/SlotTable;", "fixups", "Landroidx/compose/runtime/changelist/FixupList;", "moveCurrentGroup", "offset", "moveDown", "node", "moveNode", "count", "moveReaderRelativeTo", "location", "moveReaderToAbsolute", "moveUp", "pushApplierOperationPreamble", "pushPendingUpsAndDowns", "pushSlotEditingOperationPreamble", "pushSlotTableOperationPreamble", "useParentSlot", "realizeMoveNode", "realizeNodeMovementOperations", "realizeOperationLocation", "forParent", "realizeRemoveNode", "recordSlotEditing", "releaseMovableContent", "releaseMovableGroupAtCurrent", "Landroidx/compose/runtime/ControlledComposition;", "reference", "remember", "Landroidx/compose/runtime/RememberObserver;", "removeCurrentGroup", "removeNode", "resetSlots", "resetTransientState", "sideEffect", "effect", "Lkotlin/Function0;", "skipToEndOfCurrentGroup", "trimValues", "updateAnchoredValue", "groupSlotIndex", "updateAuxData", "data", "updateNode", "T", "V", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "updateValue", "useNode", "withChangeList", "newChangeList", "withoutImplicitRootStart", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposerChangeListWriter {

    public static final int $stable = 0;
    public static final androidx.compose.runtime.changelist.ComposerChangeListWriter.Companion Companion = null;
    private static final int invalidGroupLocation = -2;
    private androidx.compose.runtime.changelist.ChangeList changeList;
    private final ComposerImpl composer;
    private boolean implicitRootStart = true;
    private int moveCount;
    private int moveFrom = -1;
    private int moveTo = -1;
    private Stack<Object> pendingDownNodes;
    private int pendingUps;
    private int removeFrom = -1;
    private boolean startedGroup;
    private final IntStack startedGroups;
    private int writersReaderDelta;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/runtime/changelist/ComposerChangeListWriter$Companion;", "", "()V", "invalidGroupLocation", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        ComposerChangeListWriter.Companion companion = new ComposerChangeListWriter.Companion(0);
        ComposerChangeListWriter.Companion = companion;
        ComposerChangeListWriter.$stable = 8;
    }

    public ComposerChangeListWriter(ComposerImpl composer, androidx.compose.runtime.changelist.ChangeList changeList) {
        super();
        this.composer = composer;
        this.changeList = changeList;
        IntStack intStack = new IntStack();
        this.startedGroups = intStack;
        int i = 1;
        Stack stack = new Stack();
        this.pendingDownNodes = stack;
        int i2 = -1;
    }

    private final void ensureGroupStarted(Anchor anchor) {
        final int i3 = 1;
        ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, i3, 0);
        this.changeList.pushEnsureGroupStarted(anchor);
        this.startedGroup = i3;
    }

    private final void ensureRootStarted() {
        boolean implicitRootStart;
        int i;
        int i2;
        if (!this.startedGroup && this.implicitRootStart) {
            if (this.implicitRootStart) {
                i2 = 1;
                ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, i2, 0);
                this.changeList.pushEnsureRootStarted();
                this.startedGroup = i2;
            }
        }
    }

    private final SlotReader getReader() {
        return this.composer.getReader$runtime_release();
    }

    public static void includeOperationsIn$default(androidx.compose.runtime.changelist.ComposerChangeListWriter composerChangeListWriter, androidx.compose.runtime.changelist.ChangeList changeList2, IntRef intRef3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        composerChangeListWriter.includeOperationsIn(changeList2, obj2);
    }

    private final void pushApplierOperationPreamble() {
        pushPendingUpsAndDowns();
    }

    private final void pushPendingUpsAndDowns() {
        int pendingUps;
        boolean pendingDownNodes;
        int pendingUps2;
        if (this.pendingUps > 0) {
            this.changeList.pushUps(this.pendingUps);
            this.pendingUps = 0;
        }
        if (this.pendingDownNodes.isNotEmpty()) {
            this.changeList.pushDowns(this.pendingDownNodes.toArray());
            this.pendingDownNodes.clear();
        }
    }

    private final void pushSlotEditingOperationPreamble() {
        ComposerChangeListWriter.realizeOperationLocation$default(this, false, 1, 0);
        recordSlotEditing();
    }

    private final void pushSlotTableOperationPreamble(boolean useParentSlot) {
        realizeOperationLocation(useParentSlot);
    }

    static void pushSlotTableOperationPreamble$default(androidx.compose.runtime.changelist.ComposerChangeListWriter composerChangeListWriter, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        composerChangeListWriter.pushSlotTableOperationPreamble(obj1);
    }

    private final void realizeMoveNode(int to, int from, int count) {
        pushApplierOperationPreamble();
        this.changeList.pushMoveNode(to, from, count);
    }

    private final void realizeNodeMovementOperations() {
        int removeFrom;
        int moveCount;
        int i;
        int moveCount3;
        int moveCount2;
        if (this.moveCount > 0) {
            i = -1;
            if (this.removeFrom >= 0) {
                realizeRemoveNode(this.removeFrom, this.moveCount);
                this.removeFrom = i;
            } else {
                realizeMoveNode(this.moveTo, this.moveFrom, this.moveCount);
                this.moveFrom = i;
                this.moveTo = i;
            }
            this.moveCount = 0;
        }
    }

    private final void realizeOperationLocation(boolean forParent) {
        int currentGroup;
        int changeList;
        String $i$a$RuntimeCheckComposerChangeListWriter$realizeOperationLocation$1;
        SlotReader reader = getReader();
        if (forParent) {
            currentGroup = reader.getParent();
        } else {
            currentGroup = reader.getCurrentGroup();
        }
        int i = currentGroup - writersReaderDelta;
        changeList = i >= 0 ? 1 : 0;
        final int i2 = 0;
        if (changeList == null) {
            int i3 = 0;
            ComposerKt.composeImmediateRuntimeError("Tried to seek backward");
        }
        if (i > 0) {
            this.changeList.pushAdvanceSlotsBy(i);
            this.writersReaderDelta = currentGroup;
        }
    }

    static void realizeOperationLocation$default(androidx.compose.runtime.changelist.ComposerChangeListWriter composerChangeListWriter, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        composerChangeListWriter.realizeOperationLocation(obj1);
    }

    private final void realizeRemoveNode(int removeFrom, int moveCount) {
        pushApplierOperationPreamble();
        this.changeList.pushRemoveNode(removeFrom, moveCount);
    }

    public final void appendValue(Anchor anchor, Object value) {
        this.changeList.pushAppendValue(anchor, value);
    }

    public final void copyNodesToNewAnchorLocation(List<? extends Object> nodes, IntRef effectiveNodeIndex) {
        this.changeList.pushCopyNodesToNewAnchorLocation(nodes, effectiveNodeIndex);
    }

    public final void copySlotTableToAnchorLocation(MovableContentState resolvedState, CompositionContext parentContext, MovableContentStateReference from, MovableContentStateReference to) {
        this.changeList.pushCopySlotTableToAnchorLocation(resolvedState, parentContext, from, to);
    }

    public final void deactivateCurrentGroup() {
        ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, 0);
        this.changeList.pushDeactivateCurrentGroup();
    }

    public final void determineMovableContentNodeIndex(IntRef effectiveNodeIndexOut, Anchor anchor) {
        pushPendingUpsAndDowns();
        this.changeList.pushDetermineMovableContentNodeIndex(effectiveNodeIndexOut, anchor);
    }

    public final void endCompositionScope(Function1<? super Composition, Unit> action, Composition composition) {
        this.changeList.pushEndCompositionScope(action, composition);
    }

    public final void endCurrentGroup() {
        int changeList;
        int i;
        String $i$a$RuntimeCheckComposerChangeListWriter$endCurrentGroup$1;
        int parent = getReader().getParent();
        int i2 = -1;
        final int i4 = 1;
        final int i5 = 0;
        i = this.startedGroups.peekOr(i2) <= parent ? i4 : i5;
        final int i6 = 0;
        if (i == 0) {
            int i7 = 0;
            ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup");
        }
        if (this.startedGroups.peekOr(i2) == parent) {
            ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, i5, i4, 0);
            this.startedGroups.pop();
            this.changeList.pushEndCurrentGroup();
        }
    }

    public final void endMovableContentPlacement() {
        this.changeList.pushEndMovableContentPlacement();
        this.writersReaderDelta = 0;
    }

    public final void endNodeMovement() {
        realizeNodeMovementOperations();
    }

    public final void endNodeMovementAndDeleteNode(int nodeIndex, int group) {
        int nodeCount;
        endNodeMovement();
        pushPendingUpsAndDowns();
        if (getReader().isNode(group)) {
            nodeCount = 1;
        } else {
            nodeCount = getReader().nodeCount(group);
        }
        if (nodeCount > 0) {
            removeNode(nodeIndex, nodeCount);
        }
    }

    public final void endRoot() {
        boolean startedGroup;
        androidx.compose.runtime.changelist.ChangeList changeList;
        int i;
        if (this.startedGroup) {
            startedGroup = 0;
            int i2 = 1;
            i = 0;
            ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, startedGroup, i2, i);
            ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, startedGroup, i2, i);
            this.changeList.pushEndCurrentGroup();
            this.startedGroup = startedGroup;
        }
    }

    public final void finalizeComposition() {
        String $i$a$RuntimeCheckComposerChangeListWriter$finalizeComposition$1;
        pushPendingUpsAndDowns();
        final int i = 0;
        if (!this.startedGroups.isEmpty()) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup()");
        }
    }

    public final androidx.compose.runtime.changelist.ChangeList getChangeList() {
        return this.changeList;
    }

    public final boolean getImplicitRootStart() {
        return this.implicitRootStart;
    }

    public final boolean getPastParent() {
        int i;
        i = parent -= writersReaderDelta < 0 ? 1 : 0;
        return i;
    }

    public final void includeOperationsIn(androidx.compose.runtime.changelist.ChangeList other, IntRef effectiveNodeIndex) {
        this.changeList.pushExecuteOperationsIn(other, effectiveNodeIndex);
    }

    public final void insertSlots(Anchor anchor, SlotTable from) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(anchor, from);
    }

    public final void insertSlots(Anchor anchor, SlotTable from, androidx.compose.runtime.changelist.FixupList fixups) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(anchor, from, fixups);
    }

    public final void moveCurrentGroup(int offset) {
        pushSlotEditingOperationPreamble();
        this.changeList.pushMoveCurrentGroup(offset);
    }

    public final void moveDown(Object node) {
        realizeNodeMovementOperations();
        this.pendingDownNodes.push(node);
    }

    public final void moveNode(int from, int to, int count) {
        int moveCount;
        int i;
        if (count > 0) {
            if (this.moveCount > 0 && this.moveFrom == from - moveCount3 && this.moveTo == to - moveCount4) {
                if (this.moveFrom == from - moveCount3) {
                    if (this.moveTo == to - moveCount4) {
                        this.moveCount = moveCount2 += count;
                    } else {
                        realizeNodeMovementOperations();
                        this.moveFrom = from;
                        this.moveTo = to;
                        this.moveCount = count;
                    }
                } else {
                }
            } else {
            }
        }
    }

    public final void moveReaderRelativeTo(int location) {
        this.writersReaderDelta = writersReaderDelta += i2;
    }

    public final void moveReaderToAbsolute(int location) {
        this.writersReaderDelta = location;
    }

    public final void moveUp() {
        Stack pendingDownNodes;
        realizeNodeMovementOperations();
        if (this.pendingDownNodes.isNotEmpty()) {
            this.pendingDownNodes.pop();
        } else {
            this.pendingUps = pendingUps++;
        }
    }

    public final void recordSlotEditing() {
        int reader;
        int parent;
        int peekOr;
        int startedGroups;
        reader = getReader();
        parent = reader.getParent();
        ensureRootStarted();
        if (getReader().getSize() > 0 && this.startedGroups.peekOr(-2) != parent && parent > 0) {
            reader = getReader();
            parent = reader.getParent();
            if (this.startedGroups.peekOr(-2) != parent) {
                ensureRootStarted();
                if (parent > 0) {
                    this.startedGroups.push(parent);
                    ensureGroupStarted(reader.anchor(parent));
                }
            }
        }
    }

    public final void releaseMovableContent() {
        pushPendingUpsAndDowns();
        if (this.startedGroup) {
            skipToEndOfCurrentGroup();
            endRoot();
        }
    }

    public final void releaseMovableGroupAtCurrent(ControlledComposition composition, CompositionContext parentContext, MovableContentStateReference reference) {
        this.changeList.pushReleaseMovableGroupAtCurrent(composition, parentContext, reference);
    }

    public final void remember(RememberObserver value) {
        this.changeList.pushRemember(value);
    }

    public final void removeCurrentGroup() {
        pushSlotEditingOperationPreamble();
        this.changeList.pushRemoveCurrentGroup();
        this.writersReaderDelta = writersReaderDelta += groupSize;
    }

    public final void removeNode(int nodeIndex, int count) {
        int value$iv;
        int i2;
        int i;
        String $i$a$RuntimeCheckComposerChangeListWriter$removeNode$1;
        StringBuilder append;
        String str;
        if (count > 0) {
            i2 = nodeIndex >= 0 ? 1 : 0;
            i = 0;
            if (i2 == 0) {
                int i3 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                ComposerKt.composeImmediateRuntimeError(stringBuilder.append("Invalid remove index ").append(nodeIndex).toString());
            }
            if (this.removeFrom == nodeIndex) {
                this.moveCount = moveCount += count;
            } else {
                realizeNodeMovementOperations();
                this.removeFrom = nodeIndex;
                this.moveCount = count;
            }
        }
    }

    public final void resetSlots() {
        this.changeList.pushResetSlots();
    }

    public final void resetTransientState() {
        final int i = 0;
        this.startedGroup = i;
        this.startedGroups.clear();
        this.writersReaderDelta = i;
    }

    public final void setChangeList(androidx.compose.runtime.changelist.ChangeList <set-?>) {
        this.changeList = <set-?>;
    }

    public final void setImplicitRootStart(boolean <set-?>) {
        this.implicitRootStart = <set-?>;
    }

    public final void sideEffect(Function0<Unit> effect) {
        this.changeList.pushSideEffect(effect);
    }

    public final void skipToEndOfCurrentGroup() {
        this.changeList.pushSkipToEndOfCurrentGroup();
    }

    public final void trimValues(int count) {
        androidx.compose.runtime.changelist.ChangeList changeList;
        if (count > 0) {
            pushSlotEditingOperationPreamble();
            this.changeList.pushTrimValues(count);
        }
    }

    public final void updateAnchoredValue(Object value, Anchor anchor, int groupSlotIndex) {
        this.changeList.pushUpdateAnchoredValue(value, anchor, groupSlotIndex);
    }

    public final void updateAuxData(Object data) {
        ComposerChangeListWriter.pushSlotTableOperationPreamble$default(this, false, 1, 0);
        this.changeList.pushUpdateAuxData(data);
    }

    public final <T, V> void updateNode(V value, Function2<? super T, ? super V, Unit> block) {
        pushApplierOperationPreamble();
        this.changeList.pushUpdateNode(value, block);
    }

    public final void updateValue(Object value, int groupSlotIndex) {
        pushSlotTableOperationPreamble(true);
        this.changeList.pushUpdateValue(value, groupSlotIndex);
    }

    public final void useNode(Object node) {
        pushApplierOperationPreamble();
        this.changeList.pushUseNode(node);
    }

    public final void withChangeList(androidx.compose.runtime.changelist.ChangeList newChangeList, Function0<Unit> block) {
        final int i = 0;
        setChangeList(newChangeList);
        block.invoke();
        setChangeList(getChangeList());
    }

    public final void withoutImplicitRootStart(Function0<Unit> block) {
        final int i = 0;
        setImplicitRootStart(false);
        block.invoke();
        setImplicitRootStart(getImplicitRootStart());
    }
}
