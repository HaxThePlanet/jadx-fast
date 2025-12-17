package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0015\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0008\u0016J\r\u0010\u0017\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008\u0018J-\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\u0008\u001eJ-\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\u0008 J-\u0010!\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\u0008\"JC\u0010#\u001a\u00020\u0005\"\u0008\u0008\u0000\u0010$*\u00020%2\u0006\u0010\u0015\u001a\u0002H$2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00050\u00032\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\u0008'\u0010(J#\u0010)\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\r2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\u0008*J\r\u0010+\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008,J\r\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008.R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Landroidx/compose/ui/node/OwnerSnapshotObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "observer", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "onCommitAffectingLayout", "Landroidx/compose/ui/node/LayoutNode;", "onCommitAffectingLayoutModifier", "onCommitAffectingLayoutModifierInLookahead", "onCommitAffectingLookahead", "onCommitAffectingLookaheadMeasure", "onCommitAffectingMeasure", "onCommitAffectingSemantics", "clear", "target", "clear$ui_release", "clearInvalidObservations", "clearInvalidObservations$ui_release", "observeLayoutModifierSnapshotReads", "node", "affectsLookahead", "", "block", "observeLayoutModifierSnapshotReads$ui_release", "observeLayoutSnapshotReads", "observeLayoutSnapshotReads$ui_release", "observeMeasureSnapshotReads", "observeMeasureSnapshotReads$ui_release", "observeReads", "T", "Landroidx/compose/ui/node/OwnerScope;", "onChanged", "observeReads$ui_release", "(Landroidx/compose/ui/node/OwnerScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "observeSemanticsReads", "observeSemanticsReads$ui_release", "startObserving", "startObserving$ui_release", "stopObserving", "stopObserving$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OwnerSnapshotObserver {

    public static final int $stable;
    private final SnapshotStateObserver observer;
    private final Function1<androidx.compose.ui.node.LayoutNode, Unit> onCommitAffectingLayout;
    private final Function1<androidx.compose.ui.node.LayoutNode, Unit> onCommitAffectingLayoutModifier;
    private final Function1<androidx.compose.ui.node.LayoutNode, Unit> onCommitAffectingLayoutModifierInLookahead;
    private final Function1<androidx.compose.ui.node.LayoutNode, Unit> onCommitAffectingLookahead;
    private final Function1<androidx.compose.ui.node.LayoutNode, Unit> onCommitAffectingLookaheadMeasure;
    private final Function1<androidx.compose.ui.node.LayoutNode, Unit> onCommitAffectingMeasure;
    private final Function1<androidx.compose.ui.node.LayoutNode, Unit> onCommitAffectingSemantics;
    static {
        OwnerSnapshotObserver.$stable = SnapshotStateObserver.$stable;
    }

    public OwnerSnapshotObserver(Function1<? super Function0<Unit>, Unit> onChangedExecutor) {
        super();
        SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(onChangedExecutor);
        this.observer = snapshotStateObserver;
        this.onCommitAffectingLookaheadMeasure = (Function1)OwnerSnapshotObserver.onCommitAffectingLookaheadMeasure.1.INSTANCE;
        this.onCommitAffectingMeasure = (Function1)OwnerSnapshotObserver.onCommitAffectingMeasure.1.INSTANCE;
        this.onCommitAffectingSemantics = (Function1)OwnerSnapshotObserver.onCommitAffectingSemantics.1.INSTANCE;
        this.onCommitAffectingLayout = (Function1)OwnerSnapshotObserver.onCommitAffectingLayout.1.INSTANCE;
        this.onCommitAffectingLayoutModifier = (Function1)OwnerSnapshotObserver.onCommitAffectingLayoutModifier.1.INSTANCE;
        this.onCommitAffectingLayoutModifierInLookahead = (Function1)OwnerSnapshotObserver.onCommitAffectingLayoutModifierInLookahead.1.INSTANCE;
        this.onCommitAffectingLookahead = (Function1)OwnerSnapshotObserver.onCommitAffectingLookahead.1.INSTANCE;
    }

    public static void observeLayoutModifierSnapshotReads$ui_release$default(androidx.compose.ui.node.OwnerSnapshotObserver ownerSnapshotObserver, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, Function0 function04, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 1;
        }
        ownerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release(layoutNode2, obj2, function04);
    }

    public static void observeLayoutSnapshotReads$ui_release$default(androidx.compose.ui.node.OwnerSnapshotObserver ownerSnapshotObserver, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, Function0 function04, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 1;
        }
        ownerSnapshotObserver.observeLayoutSnapshotReads$ui_release(layoutNode2, obj2, function04);
    }

    public static void observeMeasureSnapshotReads$ui_release$default(androidx.compose.ui.node.OwnerSnapshotObserver ownerSnapshotObserver, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, Function0 function04, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 1;
        }
        ownerSnapshotObserver.observeMeasureSnapshotReads$ui_release(layoutNode2, obj2, function04);
    }

    public final void clear$ui_release(Object target) {
        this.observer.clear(target);
    }

    public final void clearInvalidObservations$ui_release() {
        this.observer.clearIf((Function1)OwnerSnapshotObserver.clearInvalidObservations.1.INSTANCE);
    }

    public final void observeLayoutModifierSnapshotReads$ui_release(androidx.compose.ui.node.LayoutNode node, boolean affectsLookahead, Function0<Unit> block) {
        androidx.compose.ui.node.LayoutNode lookaheadRoot$ui_release;
        androidx.compose.ui.node.OwnerScope ownerScope;
        Function1 onCommitAffectingLayoutModifier;
        if (affectsLookahead && node.getLookaheadRoot$ui_release() != null) {
            if (node.getLookaheadRoot$ui_release() != null) {
                observeReads$ui_release((OwnerScope)node, this.onCommitAffectingLayoutModifierInLookahead, block);
            } else {
                observeReads$ui_release((OwnerScope)node, this.onCommitAffectingLayoutModifier, block);
            }
        } else {
        }
    }

    public final void observeLayoutSnapshotReads$ui_release(androidx.compose.ui.node.LayoutNode node, boolean affectsLookahead, Function0<Unit> block) {
        androidx.compose.ui.node.LayoutNode lookaheadRoot$ui_release;
        androidx.compose.ui.node.OwnerScope ownerScope;
        Function1 onCommitAffectingLayout;
        if (affectsLookahead && node.getLookaheadRoot$ui_release() != null) {
            if (node.getLookaheadRoot$ui_release() != null) {
                observeReads$ui_release((OwnerScope)node, this.onCommitAffectingLookahead, block);
            } else {
                observeReads$ui_release((OwnerScope)node, this.onCommitAffectingLayout, block);
            }
        } else {
        }
    }

    public final void observeMeasureSnapshotReads$ui_release(androidx.compose.ui.node.LayoutNode node, boolean affectsLookahead, Function0<Unit> block) {
        androidx.compose.ui.node.LayoutNode lookaheadRoot$ui_release;
        androidx.compose.ui.node.OwnerScope ownerScope;
        Function1 onCommitAffectingMeasure;
        if (affectsLookahead && node.getLookaheadRoot$ui_release() != null) {
            if (node.getLookaheadRoot$ui_release() != null) {
                observeReads$ui_release((OwnerScope)node, this.onCommitAffectingLookaheadMeasure, block);
            } else {
                observeReads$ui_release((OwnerScope)node, this.onCommitAffectingMeasure, block);
            }
        } else {
        }
    }

    public final <T extends androidx.compose.ui.node.OwnerScope> void observeReads$ui_release(T target, Function1<? super T, Unit> onChanged, Function0<Unit> block) {
        this.observer.observeReads(target, onChanged, block);
    }

    public final void observeSemanticsReads$ui_release(androidx.compose.ui.node.LayoutNode node, Function0<Unit> block) {
        observeReads$ui_release((OwnerScope)node, this.onCommitAffectingSemantics, block);
    }

    public final void startObserving$ui_release() {
        this.observer.start();
    }

    public final void stopObserving$ui_release() {
        this.observer.stop();
        this.observer.clear();
    }
}
