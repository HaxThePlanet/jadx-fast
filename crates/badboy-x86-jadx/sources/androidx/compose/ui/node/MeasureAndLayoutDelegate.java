package androidx.compose.ui.node;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u001b\u0008\u0000\u0018\u00002\u00020\u0001:\u0001SB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020)2\u0008\u0008\u0002\u0010+\u001a\u00020\u0008J\"\u0010,\u001a\u00020\u00082\u0006\u0010-\u001a\u00020\u00032\u0008\u0010.\u001a\u0004\u0018\u00010\u001eH\u0002ø\u0001\u0000¢\u0006\u0002\u0008/J\"\u00100\u001a\u00020\u00082\u0006\u0010-\u001a\u00020\u00032\u0008\u0010.\u001a\u0004\u0018\u00010\u001eH\u0002ø\u0001\u0000¢\u0006\u0002\u00081J\u0008\u00102\u001a\u00020)H\u0002J\u0010\u00103\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0016\u00104\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0008J\u0018\u00106\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0008H\u0002J\u0018\u00107\u001a\u00020\u00082\u0010\u0008\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020)\u0018\u000109J \u00107\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\u0008:\u0010;J\u0006\u0010<\u001a\u00020)J\u000e\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0003J\u0018\u0010?\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0008H\u0002J\u001f\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\u00082\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u00020)09H\u0082\u0008J\u000e\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\u0016J$\u0010E\u001a\u00020\u00082\u0006\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u00105\u001a\u00020\u00082\u0008\u0008\u0002\u0010F\u001a\u00020\u0008H\u0002J\u0010\u0010G\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0018\u0010H\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0008H\u0002J\u0018\u0010I\u001a\u00020\u00082\u0006\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u0010J\u001a\u00020\u0008J\u0018\u0010K\u001a\u00020\u00082\u0006\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u0010J\u001a\u00020\u0008J\u000e\u0010L\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0003J\u0018\u0010M\u001a\u00020\u00082\u0006\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u0010J\u001a\u00020\u0008J\u0018\u0010N\u001a\u00020\u00082\u0006\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u0010J\u001a\u00020\u0008J\u0018\u0010O\u001a\u00020)2\u0006\u0010.\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\u0008P\u0010QJ\u0014\u0010R\u001a\u00020\u0008*\u00020\u00032\u0006\u00105\u001a\u00020\u0008H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000cR \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u0008*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u0018\u0010\"\u001a\u00020\u0008*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010!R\u0018\u0010$\u001a\u00020\u0008*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010!R\u0018\u0010&\u001a\u00020\u0008*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010!\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006T", d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "duringFullMeasureLayoutPass", "", "duringMeasureLayout", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hasPendingOnPositionedCallbacks", "getHasPendingOnPositionedCallbacks", "<set-?>", "", "measureIteration", "getMeasureIteration", "()J", "onLayoutCompletedListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "postponedMeasureRequests", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "canAffectParent", "getCanAffectParent", "(Landroidx/compose/ui/node/LayoutNode;)Z", "canAffectParentInLookahead", "getCanAffectParentInLookahead", "measureAffectsParent", "getMeasureAffectsParent", "measureAffectsParentLookahead", "getMeasureAffectsParentLookahead", "callOnLayoutCompletedListeners", "", "dispatchOnPositionedCallbacks", "forceDispatch", "doLookaheadRemeasure", "layoutNode", "constraints", "doLookaheadRemeasure-sdFAvZA", "doRemeasure", "doRemeasure-sdFAvZA", "drainPostponedMeasureRequests", "ensureSubtreeLookaheadReplaced", "forceMeasureTheSubtree", "affectsLookahead", "forceMeasureTheSubtreeInternal", "measureAndLayout", "onLayout", "Lkotlin/Function0;", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "measureOnly", "onNodeDetached", "node", "onlyRemeasureIfScheduled", "performMeasureAndLayout", "fullPass", "block", "registerOnLayoutCompletedListener", "listener", "remeasureAndRelayoutIfNeeded", "relayoutNeeded", "remeasureLookaheadRootsInSubtree", "remeasureOnly", "requestLookaheadRelayout", "forced", "requestLookaheadRemeasure", "requestOnPositionedCallback", "requestRelayout", "requestRemeasure", "updateRootConstraints", "updateRootConstraints-BRTryo0", "(J)V", "measurePending", "PostponedRequest", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MeasureAndLayoutDelegate {

    public static final int $stable = 8;
    private final androidx.compose.ui.node.LayoutTreeConsistencyChecker consistencyChecker = null;
    private boolean duringFullMeasureLayoutPass;
    private boolean duringMeasureLayout;
    private long measureIteration = 1;
    private final MutableVector<androidx.compose.ui.node.Owner.OnLayoutCompletedListener> onLayoutCompletedListeners;
    private final androidx.compose.ui.node.OnPositionedDispatcher onPositionedDispatcher;
    private final MutableVector<androidx.compose.ui.node.MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests;
    private final androidx.compose.ui.node.DepthSortedSetsForDifferentPasses relayoutNodes;
    private final androidx.compose.ui.node.LayoutNode root;
    private Constraints rootConstraints;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "isLookahead", "", "isForced", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "()Z", "getNode", "()Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PostponedRequest {

        public static final int $stable = 8;
        private final boolean isForced;
        private final boolean isLookahead;
        private final androidx.compose.ui.node.LayoutNode node;
        static {
            final int i = 8;
        }

        public PostponedRequest(androidx.compose.ui.node.LayoutNode node, boolean isLookahead, boolean isForced) {
            super();
            this.node = node;
            this.isLookahead = isLookahead;
            this.isForced = isForced;
        }

        public final androidx.compose.ui.node.LayoutNode getNode() {
            return this.node;
        }

        public final boolean isForced() {
            return this.isForced;
        }

        public final boolean isLookahead() {
            return this.isLookahead;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal3;
            int ordinal5;
            int ordinal2;
            int ordinal4;
            int[] iArr = new int[values.length];
            iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            MeasureAndLayoutDelegate.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    public MeasureAndLayoutDelegate(androidx.compose.ui.node.LayoutNode root) {
        super();
        this.root = root;
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = new DepthSortedSetsForDifferentPasses(Owner.Companion.getEnableExtraAssertions());
        this.relayoutNodes = depthSortedSetsForDifferentPasses;
        OnPositionedDispatcher onPositionedDispatcher = new OnPositionedDispatcher();
        this.onPositionedDispatcher = onPositionedDispatcher;
        int i = 0;
        int i7 = 0;
        final int i9 = 0;
        MutableVector mutableVector = new MutableVector(new Owner.OnLayoutCompletedListener[16], i9);
        this.onLayoutCompletedListeners = mutableVector;
        int i2 = 1;
        int i3 = 0;
        int i8 = 0;
        MutableVector mutableVector2 = new MutableVector(new MeasureAndLayoutDelegate.PostponedRequest[16], i9);
        this.postponedMeasureRequests = mutableVector2;
        if (Owner.Companion.getEnableExtraAssertions()) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = new LayoutTreeConsistencyChecker(this.root, this.relayoutNodes, this.postponedMeasureRequests.asMutableList());
        }
        int i4 = 0;
    }

    public static final androidx.compose.ui.node.LayoutNode access$getRoot$p(androidx.compose.ui.node.MeasureAndLayoutDelegate $this) {
        return $this.root;
    }

    private final void callOnLayoutCompletedListeners() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        MutableVector onLayoutCompletedListeners = this.onLayoutCompletedListeners;
        final int i2 = 0;
        final int size = onLayoutCompletedListeners.getSize();
        if (size > 0) {
            i$iv = 0;
            i = 0;
            (Owner.OnLayoutCompletedListener)onLayoutCompletedListeners.getContent()[i$iv].onLayoutComplete();
            while (i$iv++ >= size) {
                i = 0;
                (Owner.OnLayoutCompletedListener)content[i$iv].onLayoutComplete();
            }
        }
        this.onLayoutCompletedListeners.clear();
    }

    public static void dispatchOnPositionedCallbacks$default(androidx.compose.ui.node.MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(obj1);
    }

    private final boolean doLookaheadRemeasure-sdFAvZA(androidx.compose.ui.node.LayoutNode layoutNode, Constraints constraints) {
        boolean lookaheadRemeasure-_Sx5XlM$ui_release;
        androidx.compose.ui.node.LayoutNode.UsageByParent measuredByParentInLookahead$ui_release;
        androidx.compose.ui.node.LayoutNode.UsageByParent inLayoutBlock;
        int i;
        int i2;
        int i3;
        final int i5 = 0;
        if (layoutNode.getLookaheadRoot$ui_release() == null) {
            return i5;
        }
        int i4 = 1;
        final int i6 = 0;
        if (constraints != null) {
            lookaheadRemeasure-_Sx5XlM$ui_release = layoutNode.lookaheadRemeasure-_Sx5XlM$ui_release(constraints);
        } else {
            lookaheadRemeasure-_Sx5XlM$ui_release = LayoutNode.lookaheadRemeasure-_Sx5XlM$ui_release$default(layoutNode, i6, i4, i6);
        }
        final androidx.compose.ui.node.LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (lookaheadRemeasure-_Sx5XlM$ui_release && parent$ui_release != null) {
            if (parent$ui_release != null) {
                if (parent$ui_release.getLookaheadRoot$ui_release() == null) {
                    LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, 0);
                } else {
                    if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, 0);
                    } else {
                        if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                            LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, i5, i4, i6);
                        }
                    }
                }
            }
        }
        return lookaheadRemeasure-_Sx5XlM$ui_release;
    }

    private final boolean doRemeasure-sdFAvZA(androidx.compose.ui.node.LayoutNode layoutNode, Constraints constraints) {
        boolean remeasure-_Sx5XlM$ui_release$default;
        androidx.compose.ui.node.LayoutNode.UsageByParent measuredByParent$ui_release;
        androidx.compose.ui.node.LayoutNode.UsageByParent inLayoutBlock;
        int i2;
        int i;
        int i3;
        final int i4 = 1;
        final int i5 = 0;
        if (constraints != null) {
            remeasure-_Sx5XlM$ui_release$default = layoutNode.remeasure-_Sx5XlM$ui_release(constraints);
        } else {
            remeasure-_Sx5XlM$ui_release$default = LayoutNode.remeasure-_Sx5XlM$ui_release$default(layoutNode, i5, i4, i5);
        }
        final androidx.compose.ui.node.LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (remeasure-_Sx5XlM$ui_release$default && parent$ui_release != null) {
            if (parent$ui_release != null) {
                if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                    LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, false, 3, 0);
                } else {
                    if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                        LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, i4, i5);
                    }
                }
            }
        }
        return remeasure-_Sx5XlM$ui_release$default;
    }

    private final void drainPostponedMeasureRequests() {
        boolean this_$iv;
        int i3;
        int size;
        int i$iv;
        Object[] content;
        Object obj;
        int i5;
        boolean lookahead;
        androidx.compose.ui.node.LayoutNode node;
        boolean forced;
        int i;
        int i6;
        int i4;
        int i7;
        androidx.compose.ui.node.LayoutNode node2;
        boolean forced2;
        int i2;
        int i8;
        int i9;
        int i10;
        final Object obj2 = this;
        MutableVector postponedMeasureRequests2 = obj2.postponedMeasureRequests;
        i3 = 0;
        size = postponedMeasureRequests2.getSize();
        if (obj2.postponedMeasureRequests.isNotEmpty() && size > 0) {
            postponedMeasureRequests2 = obj2.postponedMeasureRequests;
            i3 = 0;
            size = postponedMeasureRequests2.getSize();
            if (size > 0) {
                i$iv = 0;
                obj = postponedMeasureRequests2.getContent()[i$iv];
                i5 = 0;
                do {
                    obj = content[i$iv];
                    i5 = 0;
                    if (i$iv++ < size) {
                    }
                    if (!obj.isLookahead()) {
                    } else {
                    }
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(obj.getNode(), obj.isForced(), false, false, 2, 0);
                    LayoutNode.requestRemeasure$ui_release$default(obj.getNode(), obj.isForced(), false, false, 2, 0);
                } while ((MeasureAndLayoutDelegate.PostponedRequest)obj.getNode().isAttached());
            }
            obj2.postponedMeasureRequests.clear();
        }
    }

    private final void ensureSubtreeLookaheadReplaced(androidx.compose.ui.node.LayoutNode layoutNode) {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        boolean deactivated;
        int i2;
        Boolean valueOf;
        final int i3 = 0;
        final MutableVector mutableVector = layoutNode.get_children$ui_release();
        final int i4 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            obj = mutableVector.getContent()[i$iv$iv];
            i = 0;
            i2 = 1;
            do {
                obj = content[i$iv$iv];
                i = 0;
                i2 = 1;
                if (i$iv$iv++ < size) {
                }
                if (!obj.isDeactivated() && this.relayoutNodes.contains(obj, i2)) {
                }
                if (this.relayoutNodes.contains(obj, i2)) {
                }
                ensureSubtreeLookaheadReplaced(obj);
                obj.lookaheadReplace$ui_release();
            } while (Intrinsics.areEqual((LayoutNode)obj.isPlacedInLookahead(), Boolean.valueOf(i2)));
        }
    }

    private final void forceMeasureTheSubtreeInternal(androidx.compose.ui.node.LayoutNode layoutNode, boolean affectsLookahead) {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i2;
        boolean measureAffectsParent;
        boolean outMostLookaheadRoot;
        int i;
        final int i3 = 0;
        final MutableVector mutableVector = layoutNode.get_children$ui_release();
        final int i4 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            obj = mutableVector.getContent()[i$iv$iv];
            i2 = 0;
            do {
                obj = content[i$iv$iv];
                i2 = 0;
                if (affectsLookahead && getMeasureAffectsParentLookahead((LayoutNode)(LayoutNode)obj) && LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(obj) && !affectsLookahead) {
                }
                if (i$iv$iv++ < size) {
                }
                if (getMeasureAffectsParentLookahead(obj)) {
                }
                if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(obj)) {
                }
                onlyRemeasureIfScheduled(obj, affectsLookahead);
                if (!measurePending(obj, affectsLookahead)) {
                }
                forceMeasureTheSubtreeInternal(obj, affectsLookahead);
                if (!affectsLookahead) {
                }
                i = 1;
                if (obj.getLookaheadMeasurePending$ui_release() && this.relayoutNodes.contains(obj, i)) {
                } else {
                }
                forceMeasureTheSubtree(obj, i);
                if (this.relayoutNodes.contains(obj, i)) {
                } else {
                }
                remeasureAndRelayoutIfNeeded(obj, i, false);
                if (!getMeasureAffectsParent(obj)) {
                } else {
                }
            } while (!affectsLookahead);
        }
        onlyRemeasureIfScheduled(layoutNode, affectsLookahead);
    }

    private final boolean getCanAffectParent(androidx.compose.ui.node.LayoutNode $this$canAffectParent) {
        boolean measurePending$ui_release;
        int i;
        if ($this$canAffectParent.getMeasurePending$ui_release() && getMeasureAffectsParent($this$canAffectParent)) {
            i = getMeasureAffectsParent($this$canAffectParent) ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean getCanAffectParentInLookahead(androidx.compose.ui.node.LayoutNode $this$canAffectParentInLookahead) {
        boolean lookaheadMeasurePending$ui_release;
        int i;
        if ($this$canAffectParentInLookahead.getLookaheadMeasurePending$ui_release() && getMeasureAffectsParentLookahead($this$canAffectParentInLookahead)) {
            i = getMeasureAffectsParentLookahead($this$canAffectParentInLookahead) ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean getMeasureAffectsParent(androidx.compose.ui.node.LayoutNode $this$measureAffectsParent) {
        int i;
        androidx.compose.ui.node.LayoutNode.UsageByParent measuredByParent$ui_release;
        if ($this$measureAffectsParent.getMeasuredByParent$ui_release() != LayoutNode.UsageByParent.InMeasureBlock) {
            if ($this$measureAffectsParent.getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final boolean getMeasureAffectsParentLookahead(androidx.compose.ui.node.LayoutNode $this$measureAffectsParentLookahead) {
        androidx.compose.ui.node.LayoutNode.UsageByParent measuredByParentInLookahead$ui_release;
        androidx.compose.ui.node.AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release;
        androidx.compose.ui.node.LayoutNode.UsageByParent inMeasureBlock;
        int i;
        i = 1;
        if ($this$measureAffectsParentLookahead.getMeasuredByParentInLookahead$ui_release() != LayoutNode.UsageByParent.InMeasureBlock) {
            lookaheadAlignmentLinesOwner$ui_release = $this$measureAffectsParentLookahead.getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
            inMeasureBlock = 0;
            lookaheadAlignmentLinesOwner$ui_release = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines();
            if (lookaheadAlignmentLinesOwner$ui_release != null && lookaheadAlignmentLinesOwner$ui_release != null && lookaheadAlignmentLinesOwner$ui_release.getRequired$ui_release() == i) {
                lookaheadAlignmentLinesOwner$ui_release = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines();
                if (lookaheadAlignmentLinesOwner$ui_release != null) {
                    measuredByParentInLookahead$ui_release = lookaheadAlignmentLinesOwner$ui_release.getRequired$ui_release() == i ? i : inMeasureBlock;
                } else {
                }
            } else {
            }
            if (measuredByParentInLookahead$ui_release != 0) {
            } else {
                i = inMeasureBlock;
            }
        } else {
        }
        return i;
    }

    public static boolean measureAndLayout$default(androidx.compose.ui.node.MeasureAndLayoutDelegate measureAndLayoutDelegate, Function0 function02, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return measureAndLayoutDelegate.measureAndLayout(obj1);
    }

    private final boolean measurePending(androidx.compose.ui.node.LayoutNode $this$measurePending, boolean affectsLookahead) {
        boolean lookaheadMeasurePending$ui_release;
        if (affectsLookahead) {
            lookaheadMeasurePending$ui_release = $this$measurePending.getLookaheadMeasurePending$ui_release();
        } else {
            lookaheadMeasurePending$ui_release = $this$measurePending.getMeasurePending$ui_release();
        }
        return lookaheadMeasurePending$ui_release;
    }

    private final void onlyRemeasureIfScheduled(androidx.compose.ui.node.LayoutNode node, boolean affectsLookahead) {
        boolean measurePending;
        if (measurePending(node, affectsLookahead) && this.relayoutNodes.contains(node, affectsLookahead)) {
            if (this.relayoutNodes.contains(node, affectsLookahead)) {
                remeasureAndRelayoutIfNeeded(node, affectsLookahead, false);
            }
        }
    }

    private final void performMeasureAndLayout(boolean fullPass, Function0<Unit> block) {
        Object value$iv;
        String str;
        String str2;
        final int i = 0;
        int i4 = 0;
        if (!this.root.isAttached()) {
            int i9 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        int i5 = 0;
        if (!this.root.isPlaced()) {
            int i7 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        int i6 = 1;
        int i8 = 0;
        if (value$iv3 ^= i6 == 0) {
            int i10 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        this.duringMeasureLayout = i6;
        this.duringFullMeasureLayoutPass = fullPass;
        int i3 = 0;
        block.invoke();
        this.duringMeasureLayout = i3;
        this.duringFullMeasureLayoutPass = i3;
        value$iv = this.consistencyChecker;
        if (this.rootConstraints != null && value$iv != null) {
            this.duringMeasureLayout = i6;
            this.duringFullMeasureLayoutPass = fullPass;
            i3 = 0;
            block.invoke();
            this.duringMeasureLayout = i3;
            this.duringFullMeasureLayoutPass = i3;
            value$iv = this.consistencyChecker;
            if (value$iv != null) {
                value$iv.assertConsistent();
            }
        }
    }

    private final boolean remeasureAndRelayoutIfNeeded(androidx.compose.ui.node.LayoutNode layoutNode, boolean affectsLookahead, boolean relayoutNeeded) {
        int sizeChanged;
        boolean canAffectParentInLookahead;
        int lookaheadMeasurePending$ui_release;
        int valueOf;
        Boolean measurePending$ui_release;
        androidx.compose.ui.node.LayoutNode parent$ui_release;
        sizeChanged = 0;
        lookaheadMeasurePending$ui_release = 0;
        if (layoutNode.isDeactivated()) {
            return lookaheadMeasurePending$ui_release;
        }
        valueOf = 1;
        if (!layoutNode.isPlaced() && !layoutNode.isPlacedByParent() && !getCanAffectParent(layoutNode) && !Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.valueOf(valueOf)) && !getCanAffectParentInLookahead(layoutNode)) {
            if (!layoutNode.isPlacedByParent()) {
                if (!getCanAffectParent(layoutNode)) {
                    if (!Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.valueOf(valueOf))) {
                        if (!getCanAffectParentInLookahead(layoutNode)) {
                            if (layoutNode.getAlignmentLinesRequired$ui_release()) {
                                if (layoutNode == this.root) {
                                    Intrinsics.checkNotNull(this.rootConstraints);
                                } else {
                                    canAffectParentInLookahead = 0;
                                }
                                if (affectsLookahead) {
                                    if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                                        sizeChanged = doLookaheadRemeasure-sdFAvZA(layoutNode, canAffectParentInLookahead);
                                    }
                                    if (relayoutNeeded) {
                                        if (sizeChanged == 0) {
                                            if (layoutNode.getLookaheadLayoutPending$ui_release() && Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.valueOf(valueOf))) {
                                                if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.valueOf(valueOf))) {
                                                    layoutNode.lookaheadReplace$ui_release();
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                    if (layoutNode.getMeasurePending$ui_release()) {
                                        sizeChanged = doRemeasure-sdFAvZA(layoutNode, canAffectParentInLookahead);
                                    }
                                    if (relayoutNeeded && layoutNode.getLayoutPending$ui_release()) {
                                        if (layoutNode.getLayoutPending$ui_release()) {
                                            if (layoutNode != this.root) {
                                                parent$ui_release = layoutNode.getParent$ui_release();
                                                if (parent$ui_release != null && parent$ui_release.isPlaced() == valueOf) {
                                                    measurePending$ui_release = parent$ui_release.isPlaced() == valueOf ? valueOf : lookaheadMeasurePending$ui_release;
                                                } else {
                                                }
                                                if (measurePending$ui_release != 0 && layoutNode.isPlacedByParent()) {
                                                    if (layoutNode.isPlacedByParent()) {
                                                    } else {
                                                        valueOf = lookaheadMeasurePending$ui_release;
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                            if (valueOf != 0) {
                                                if (layoutNode == this.root) {
                                                    layoutNode.place$ui_release(lookaheadMeasurePending$ui_release, lookaheadMeasurePending$ui_release);
                                                } else {
                                                    layoutNode.replace$ui_release();
                                                }
                                                this.onPositionedDispatcher.onNodePositioned(layoutNode);
                                                lookaheadMeasurePending$ui_release = this.consistencyChecker;
                                                if (lookaheadMeasurePending$ui_release != null) {
                                                    lookaheadMeasurePending$ui_release.assertConsistent();
                                                }
                                            }
                                        }
                                    }
                                }
                                drainPostponedMeasureRequests();
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
        return sizeChanged;
    }

    static boolean remeasureAndRelayoutIfNeeded$default(androidx.compose.ui.node.MeasureAndLayoutDelegate measureAndLayoutDelegate, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 1;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return measureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(layoutNode2, obj3, obj4);
    }

    private final void remeasureLookaheadRootsInSubtree(androidx.compose.ui.node.LayoutNode layoutNode) {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        boolean measureAffectsParent;
        final int i2 = 0;
        final MutableVector mutableVector = layoutNode.get_children$ui_release();
        final int i3 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            obj = mutableVector.getContent()[i$iv$iv];
            i = 0;
            do {
                obj = content[i$iv$iv];
                i = 0;
                if (i$iv$iv++ < size) {
                }
                if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(obj)) {
                } else {
                }
                remeasureLookaheadRootsInSubtree(obj);
                remeasureOnly(obj, true);
            } while (getMeasureAffectsParent((LayoutNode)obj));
        }
    }

    private final void remeasureOnly(androidx.compose.ui.node.LayoutNode layoutNode, boolean affectsLookahead) {
        Constraints rootConstraints;
        if (layoutNode.isDeactivated()) {
        }
        if (layoutNode == this.root) {
            Intrinsics.checkNotNull(this.rootConstraints);
        } else {
            rootConstraints = 0;
        }
        if (affectsLookahead) {
            doLookaheadRemeasure-sdFAvZA(layoutNode, rootConstraints);
        } else {
            doRemeasure-sdFAvZA(layoutNode, rootConstraints);
        }
    }

    public static boolean requestLookaheadRelayout$default(androidx.compose.ui.node.MeasureAndLayoutDelegate measureAndLayoutDelegate, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode2, obj2);
    }

    public static boolean requestLookaheadRemeasure$default(androidx.compose.ui.node.MeasureAndLayoutDelegate measureAndLayoutDelegate, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode2, obj2);
    }

    public static boolean requestRelayout$default(androidx.compose.ui.node.MeasureAndLayoutDelegate measureAndLayoutDelegate, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return measureAndLayoutDelegate.requestRelayout(layoutNode2, obj2);
    }

    public static boolean requestRemeasure$default(androidx.compose.ui.node.MeasureAndLayoutDelegate measureAndLayoutDelegate, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return measureAndLayoutDelegate.requestRemeasure(layoutNode2, obj2);
    }

    public final void dispatchOnPositionedCallbacks(boolean forceDispatch) {
        androidx.compose.ui.node.OnPositionedDispatcher onPositionedDispatcher;
        androidx.compose.ui.node.LayoutNode root;
        if (forceDispatch) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void forceMeasureTheSubtree(androidx.compose.ui.node.LayoutNode layoutNode, boolean affectsLookahead) {
        String str;
        if (this.relayoutNodes.isEmpty(affectsLookahead)) {
        }
        int i2 = 0;
        if (!this.duringMeasureLayout) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateException("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        int i3 = 0;
        if (measurePending ^= 1 == 0) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("node not yet measured");
        }
        forceMeasureTheSubtreeInternal(layoutNode, affectsLookahead);
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return this.relayoutNodes.isNotEmpty();
    }

    public final boolean getHasPendingOnPositionedCallbacks() {
        return this.onPositionedDispatcher.isNotEmpty();
    }

    public final long getMeasureIteration() {
        String str;
        final int i = 0;
        if (!this.duringMeasureLayout) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("measureIteration should be only used during the measure/layout pass");
        }
        return this.measureIteration;
    }

    public final boolean measureAndLayout(Function0<Unit> onLayout) {
        Object value$iv$iv;
        Object obj;
        int i;
        int i7;
        androidx.compose.ui.node.DepthSortedSet set;
        int notEmpty;
        String remeasureAndRelayoutIfNeeded$default;
        int i3;
        int i5;
        boolean z;
        androidx.compose.ui.node.DepthSortedSetsForDifferentPasses set2;
        int i2;
        int rootNodeResized;
        int i6;
        int i4;
        int i8;
        obj = this;
        final Object obj2 = this;
        final int i19 = 0;
        int i11 = 0;
        if (!obj2.root.isAttached()) {
            int i14 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        int i12 = 0;
        if (!obj2.root.isPlaced()) {
            int i15 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        final int i20 = 1;
        notEmpty = 0;
        if (value$iv$iv3 ^= i20 == 0) {
            int i17 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        obj2.duringMeasureLayout = i20;
        obj2.duringFullMeasureLayoutPass = true;
        int i10 = 0;
        z = 0;
        if (obj2.rootConstraints != null && obj.relayoutNodes.isNotEmpty()) {
            obj2.duringMeasureLayout = i20;
            obj2.duringFullMeasureLayoutPass = i18;
            i10 = 0;
            z = 0;
            if (obj.relayoutNodes.isNotEmpty()) {
                set2 = relayoutNodes2;
                i2 = notEmpty;
                rootNodeResized = i7;
                while (set2.isNotEmpty()) {
                    int i13 = 0;
                    i6 = this_$iv$iv;
                    if (i6 != 0) {
                    } else {
                    }
                    set = DepthSortedSetsForDifferentPasses.access$getSet$p(set2);
                    i7 = set.pop();
                    i4 = i7;
                    i8 = 0;
                    if (i7 == MeasureAndLayoutDelegate.access$getRoot$p(this) && MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded$default(obj, i7, i6, false, 4, 0) != null) {
                    }
                    obj = this;
                    if (MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded$default(obj, i7, i6, false, 4, 0) != null) {
                    }
                    rootNodeResized = 1;
                    set = DepthSortedSetsForDifferentPasses.access$getLookaheadSet$p(set2);
                }
                if (onLayout != null) {
                    onLayout.invoke();
                }
                i7 = rootNodeResized;
            }
            obj2.duringMeasureLayout = z;
            obj2.duringFullMeasureLayoutPass = z;
            value$iv$iv = obj2.consistencyChecker;
            if (value$iv$iv != null) {
                value$iv$iv.assertConsistent();
            }
        }
        callOnLayoutCompletedListeners();
        return i7;
    }

    public final void measureAndLayout-0kLqBqw(androidx.compose.ui.node.LayoutNode layoutNode, long constraints) {
        int consistencyChecker;
        boolean layoutPending$ui_release;
        String str;
        Constraints value$iv$iv;
        int i;
        String doLookaheadRemeasure-sdFAvZA;
        boolean lookaheadLayoutPending$ui_release;
        if (layoutNode.isDeactivated()) {
        }
        consistencyChecker = 1;
        int i3 = 0;
        if (equal ^= consistencyChecker == 0) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("measureAndLayout called on root");
        }
        Object obj = this;
        int i5 = 0;
        int i7 = 0;
        if (!obj.root.isAttached()) {
            int i11 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        int i8 = 0;
        if (!obj.root.isPlaced()) {
            int i9 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        i = 0;
        if (value$iv$iv3 ^= consistencyChecker == 0) {
            int i10 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        if (obj.rootConstraints != null) {
            obj.duringMeasureLayout = consistencyChecker;
            obj.duringFullMeasureLayoutPass = false;
            value$iv$iv = 0;
            i = 0;
            this.relayoutNodes.remove(layoutNode);
            if (!doLookaheadRemeasure-sdFAvZA(layoutNode, Constraints.box-impl(constraints))) {
                if (layoutNode.getLookaheadLayoutPending$ui_release() && Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.valueOf(consistencyChecker))) {
                    if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.valueOf(consistencyChecker))) {
                        layoutNode.lookaheadReplace$ui_release();
                    }
                }
            } else {
            }
            ensureSubtreeLookaheadReplaced(layoutNode);
            doRemeasure-sdFAvZA(layoutNode, Constraints.box-impl(constraints));
            if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                if (layoutNode.isPlaced()) {
                    layoutNode.replace$ui_release();
                    this.onPositionedDispatcher.onNodePositioned(layoutNode);
                }
            }
            drainPostponedMeasureRequests();
            obj.duringMeasureLayout = i;
            obj.duringFullMeasureLayoutPass = i;
            consistencyChecker = obj.consistencyChecker;
            if (consistencyChecker != null) {
                consistencyChecker.assertConsistent();
            }
        }
        callOnLayoutCompletedListeners();
    }

    public final void measureOnly() {
        boolean notEmpty;
        Object obj;
        int i;
        Object value$iv$iv;
        int root;
        String str;
        String lookaheadRoot$ui_release;
        obj = this;
        i = 0;
        int i4 = 0;
        if (this.relayoutNodes.isNotEmpty() && !obj.root.isAttached()) {
            obj = this;
            i = 0;
            i4 = 0;
            if (!obj.root.isAttached()) {
                int i7 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
            }
            int i5 = 0;
            if (!obj.root.isPlaced()) {
                int i6 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
            }
            root = 1;
            str = 0;
            if (value$iv$iv3 ^= root == 0) {
                int i8 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
            }
            obj.duringMeasureLayout = root;
            obj.duringFullMeasureLayoutPass = false;
            int i3 = 0;
            str = 0;
            if (obj.rootConstraints != null && !this.relayoutNodes.isEmpty(root)) {
                obj.duringMeasureLayout = root;
                obj.duringFullMeasureLayoutPass = notEmpty;
                i3 = 0;
                str = 0;
                if (!this.relayoutNodes.isEmpty(root)) {
                    if (this.root.getLookaheadRoot$ui_release() != null) {
                        remeasureOnly(this.root, root);
                    } else {
                        remeasureLookaheadRootsInSubtree(this.root);
                    }
                }
                remeasureOnly(this.root, str);
                obj.duringMeasureLayout = str;
                obj.duringFullMeasureLayoutPass = str;
                value$iv$iv = obj.consistencyChecker;
                if (value$iv$iv != null) {
                    value$iv$iv.assertConsistent();
                }
            }
        }
    }

    public final void onNodeDetached(androidx.compose.ui.node.LayoutNode node) {
        this.relayoutNodes.remove(node);
        this.onPositionedDispatcher.remove(node);
    }

    public final void registerOnLayoutCompletedListener(androidx.compose.ui.node.Owner.OnLayoutCompletedListener listener) {
        final int i = 0;
        this.onLayoutCompletedListeners.add(listener);
    }

    public final boolean requestLookaheadRelayout(androidx.compose.ui.node.LayoutNode layoutNode, boolean forced) {
        androidx.compose.ui.node.LayoutTreeConsistencyChecker consistencyChecker;
        boolean lookaheadMeasurePending$ui_release;
        int i2;
        boolean duringFullMeasureLayoutPass;
        boolean lookaheadMeasurePending$ui_release2;
        int layoutPending$ui_release;
        int i;
        Boolean valueOf;
        i2 = 0;
        switch (i3) {
            case 1:
                consistencyChecker = this.consistencyChecker;
                consistencyChecker.assertConsistent();
                break;
            case 2:
                consistencyChecker = this.consistencyChecker;
                consistencyChecker.assertConsistent();
                layoutNode.markLookaheadLayoutPending$ui_release();
                layoutNode.markLayoutPending$ui_release();
                consistencyChecker = layoutNode.getParent$ui_release();
                i = 1;
                lookaheadMeasurePending$ui_release2 = i;
                lookaheadMeasurePending$ui_release2 = i2;
                lookaheadMeasurePending$ui_release2 = i;
                lookaheadMeasurePending$ui_release2 = i2;
                this.relayoutNodes.add(layoutNode, i);
                layoutPending$ui_release = i;
                layoutPending$ui_release = i2;
                layoutPending$ui_release = i;
                layoutPending$ui_release = i2;
                this.relayoutNodes.add(layoutNode, i2);
                i2 = i;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i2;
    }

    public final boolean requestLookaheadRemeasure(androidx.compose.ui.node.LayoutNode layoutNode, boolean forced) {
        int i2;
        androidx.compose.ui.node.DepthSortedSetsForDifferentPasses canAffectParent;
        boolean canAffectParentInLookahead;
        androidx.compose.ui.node.LayoutNode lookaheadMeasurePending$ui_release2;
        androidx.compose.ui.node.LayoutNode measurePending$ui_release;
        androidx.compose.ui.node.LayoutTreeConsistencyChecker lookaheadMeasurePending$ui_release;
        int i;
        Object postponedRequest;
        String str;
        i = 1;
        final int i4 = 0;
        i2 = layoutNode.getLookaheadRoot$ui_release() != null ? i : i4;
        int i5 = 0;
        if (i2 == 0) {
            int i6 = 0;
            InlineClassHelperKt.throwIllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        switch (lookaheadMeasurePending$ui_release) {
            case 1:
                i = i4;
                break;
            case 2:
                postponedRequest = new MeasureAndLayoutDelegate.PostponedRequest(layoutNode, i, forced);
                this.postponedMeasureRequests.add(postponedRequest);
                lookaheadMeasurePending$ui_release = this.consistencyChecker;
                lookaheadMeasurePending$ui_release.assertConsistent();
                i = i4;
                break;
            case 3:
                i = i4;
                layoutNode.markLookaheadMeasurePending$ui_release();
                layoutNode.markMeasurePending$ui_release();
                i = i4;
                lookaheadMeasurePending$ui_release2 = layoutNode.getParent$ui_release();
                canAffectParentInLookahead = i;
                canAffectParentInLookahead = i4;
                this.relayoutNodes.add(layoutNode, i);
                measurePending$ui_release = layoutNode.getParent$ui_release();
                canAffectParent = i;
                canAffectParent = i4;
                this.relayoutNodes.add(layoutNode, i4);
                i = i4;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i;
    }

    public final void requestOnPositionedCallback(androidx.compose.ui.node.LayoutNode layoutNode) {
        this.onPositionedDispatcher.onNodePositioned(layoutNode);
    }

    public final boolean requestRelayout(androidx.compose.ui.node.LayoutNode layoutNode, boolean forced) {
        boolean measurePending$ui_release2;
        androidx.compose.ui.node.LayoutTreeConsistencyChecker consistencyChecker;
        int i;
        boolean placedByParent;
        boolean layoutPending$ui_release;
        int measurePending$ui_release;
        i = 0;
        switch (measurePending$ui_release2) {
            case 1:
                consistencyChecker = this.consistencyChecker;
                consistencyChecker.assertConsistent();
                break;
            case 2:
                consistencyChecker = this.consistencyChecker;
                consistencyChecker.assertConsistent();
                layoutNode.markLayoutPending$ui_release();
                consistencyChecker = layoutNode.getParent$ui_release();
                placedByParent = 1;
                measurePending$ui_release = placedByParent;
                measurePending$ui_release = i;
                measurePending$ui_release = placedByParent;
                measurePending$ui_release = i;
                this.relayoutNodes.add(layoutNode, i);
                i = placedByParent;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i;
    }

    public final boolean requestRemeasure(androidx.compose.ui.node.LayoutNode layoutNode, boolean forced) {
        int measurePending$ui_release2;
        androidx.compose.ui.node.LayoutNode measurePending$ui_release;
        int relayoutNodes;
        int i;
        int postponedRequest;
        i = 0;
        switch (measurePending$ui_release2) {
            case 1:
                break;
            case 2:
                postponedRequest = new MeasureAndLayoutDelegate.PostponedRequest(layoutNode, i, forced);
                this.postponedMeasureRequests.add(postponedRequest);
                measurePending$ui_release2 = this.consistencyChecker;
                measurePending$ui_release2.assertConsistent();
                break;
            case 3:
                layoutNode.markMeasurePending$ui_release();
                measurePending$ui_release = layoutNode.getParent$ui_release();
                postponedRequest = 1;
                relayoutNodes = postponedRequest;
                relayoutNodes = i;
                this.relayoutNodes.add(layoutNode, i);
                i = postponedRequest;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i;
    }

    public final void updateRootConstraints-BRTryo0(long constraints) {
        boolean relayoutNodes;
        androidx.compose.ui.node.LayoutNode lookaheadRoot$ui_release;
        int i;
        long unbox-impl;
        long root;
        Object lookaheadRoot$ui_release2;
        Constraints rootConstraints = this.rootConstraints;
        if (rootConstraints == null) {
            relayoutNodes = i;
        } else {
            relayoutNodes = Constraints.equals-impl0(rootConstraints.unbox-impl(), obj3);
        }
        unbox-impl = 1;
        int i3 = 0;
        if (!relayoutNodes && duringMeasureLayout ^= unbox-impl == 0) {
            unbox-impl = 1;
            i3 = 0;
            if (duringMeasureLayout ^= unbox-impl == 0) {
                int i4 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("updateRootConstraints called while measuring");
            }
            this.rootConstraints = Constraints.box-impl(constraints);
            if (this.root.getLookaheadRoot$ui_release() != null) {
                this.root.markLookaheadMeasurePending$ui_release();
            }
            this.root.markMeasurePending$ui_release();
            if (this.root.getLookaheadRoot$ui_release() != null) {
                i = unbox-impl;
            }
            this.relayoutNodes.add(this.root, i);
        }
    }
}
