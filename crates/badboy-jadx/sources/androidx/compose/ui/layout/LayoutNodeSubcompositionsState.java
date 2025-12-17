package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode.LayoutState;
import androidx.compose.ui.node.LayoutNode.UsageByParent;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0000\u0018\u00002\u00020\u0001:\u0003cdeB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010+\u001a\u00020,2\u001d\u0010-\u001a\u0019\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010.¢\u0006\u0002\u00082J!\u00103\u001a\u0002012\u0006\u00104\u001a\u0002012\u000e\u0008\u0004\u00105\u001a\u0008\u0012\u0004\u0012\u00020706H\u0082\u0008J\u0010\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0010H\u0002J\u0008\u0010:\u001a\u000207H\u0002J\u000e\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020\u0010J\u0008\u0010=\u001a\u000207H\u0002J\u0006\u0010>\u001a\u000207J\u0012\u0010?\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020\u0010H\u0002J\u0017\u0010@\u001a\u0002072\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020706H\u0082\u0008J\u0006\u0010A\u001a\u000207J\u0010\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020DH\u0002J\"\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u00102\u0008\u0008\u0002\u0010H\u001a\u00020\u0010H\u0002J\u0008\u0010I\u001a\u000207H\u0016J\u0008\u0010J\u001a\u000207H\u0016J\u0008\u0010K\u001a\u000207H\u0016J0\u0010L\u001a\u0008\u0012\u0004\u0012\u00020N0M2\u0008\u0010O\u001a\u0004\u0018\u00010\u00182\u0011\u0010P\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\u0008QH\u0002¢\u0006\u0002\u0010RJ(\u0010S\u001a\u00020\u001d2\u0008\u0010O\u001a\u0004\u0018\u00010\u00182\u0011\u0010P\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\u0008Q¢\u0006\u0002\u0010TJ\u0018\u0010U\u001a\u0002072\u0006\u0010V\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u0014H\u0002J2\u0010U\u001a\u0002072\u0006\u0010V\u001a\u00020\u00032\u0008\u0010O\u001a\u0004\u0018\u00010\u00182\u0011\u0010P\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\u0008QH\u0002¢\u0006\u0002\u0010XJ.\u0010U\u001a\u0008\u0012\u0004\u0012\u00020N0M2\u0008\u0010O\u001a\u0004\u0018\u00010\u00182\u0011\u0010P\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\u0008Q¢\u0006\u0002\u0010RJB\u0010Y\u001a\u00020Z2\u0008\u0010[\u001a\u0004\u0018\u00010Z2\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020\n2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\u0008QH\u0002¢\u0006\u0002\u0010`J\u0014\u0010a\u001a\u0004\u0018\u00010\u00032\u0008\u0010O\u001a\u0004\u0018\u00010\u0018H\u0002J\u000c\u0010b\u001a\u000207*\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u001e\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00030\u0013j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0003`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010%\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00030\u0013j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0003`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*¨\u0006f", d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "NoIntrinsicsMessage", "", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "currentIndex", "", "currentPostLookaheadIndex", "nodeToNodeState", "Ljava/util/HashMap;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "Lkotlin/collections/HashMap;", "postLookaheadComposedSlotIds", "Landroidx/compose/runtime/collection/MutableVector;", "", "postLookaheadMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$PostLookaheadMeasureScopeImpl;", "postLookaheadPrecomposeSlotHandleMap", "", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "precomposeMap", "precomposedCount", "reusableCount", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "slotIdToNode", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "createMeasureResult", "result", "placeChildrenBlock", "Lkotlin/Function0;", "", "createNodeAt", "index", "disposeCurrentNodes", "disposeOrReuseStartingFromIndex", "startIndex", "disposeUnusedSlotsInPostLookahead", "forceRecomposeChildren", "getSlotIdAtIndex", "ignoreRemeasureRequests", "makeSureStateIsConsistent", "markActiveNodesAsReused", "deactivate", "", "move", "from", "to", "count", "onDeactivate", "onRelease", "onReuse", "postLookaheadSubcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "precompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "subcompose", "node", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "subcomposeInto", "Landroidx/compose/runtime/ReusableComposition;", "existing", "container", "reuseContent", "parent", "composable", "(Landroidx/compose/runtime/ReusableComposition;Landroidx/compose/ui/node/LayoutNode;ZLandroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/ReusableComposition;", "takeNodeFromReusables", "resetLayoutState", "NodeState", "PostLookaheadMeasureScopeImpl", "Scope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {

    public static final int $stable = 8;
    private final String NoIntrinsicsMessage;
    private CompositionContext compositionContext;
    private int currentIndex;
    private int currentPostLookaheadIndex;
    private final HashMap<LayoutNode, androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState> nodeToNodeState;
    private final MutableVector<Object> postLookaheadComposedSlotIds;
    private final androidx.compose.ui.layout.LayoutNodeSubcompositionsState.PostLookaheadMeasureScopeImpl postLookaheadMeasureScope;
    private final Map<Object, androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle> postLookaheadPrecomposeSlotHandleMap;
    private final HashMap<Object, LayoutNode> precomposeMap;
    private int precomposedCount;
    private int reusableCount;
    private final androidx.compose.ui.layout.SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet;
    private final LayoutNode root;
    private final androidx.compose.ui.layout.LayoutNodeSubcompositionsState.Scope scope;
    private final HashMap<Object, LayoutNode> slotIdToNode;
    private androidx.compose.ui.layout.SubcomposeSlotReusePolicy slotReusePolicy;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0018\u0008\u0002\u0018\u00002\u00020\u0001B.\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0008\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tR$\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0008\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u000e\"\u0004\u0008\"\u0010\u0010R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010\u000e\"\u0004\u0008%\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010'\"\u0004\u0008(\u0010)¨\u0006*", d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/ReusableComposition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ReusableComposition;)V", "value", "", "active", "getActive", "()Z", "setActive", "(Z)V", "activeState", "Landroidx/compose/runtime/MutableState;", "getActiveState", "()Landroidx/compose/runtime/MutableState;", "setActiveState", "(Landroidx/compose/runtime/MutableState;)V", "getComposition", "()Landroidx/compose/runtime/ReusableComposition;", "setComposition", "(Landroidx/compose/runtime/ReusableComposition;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "forceRecompose", "getForceRecompose", "setForceRecompose", "forceReuse", "getForceReuse", "setForceReuse", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class NodeState {

        private MutableState<Boolean> activeState;
        private ReusableComposition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private boolean forceReuse;
        private Object slotId;
        public NodeState(Object slotId, Function2<? super Composer, ? super Integer, Unit> content, ReusableComposition composition) {
            super();
            this.slotId = slotId;
            this.content = content;
            this.composition = composition;
            final int i2 = 0;
            this.activeState = SnapshotStateKt.mutableStateOf$default(true, i2, 2, i2);
        }

        public NodeState(Object object, Function2 function22, ReusableComposition reusableComposition3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
            int obj3;
            obj3 = i4 &= 4 != 0 ? 0 : obj3;
            super(object, function22, obj3);
        }

        public final boolean getActive() {
            return (Boolean)this.activeState.getValue().booleanValue();
        }

        public final MutableState<Boolean> getActiveState() {
            return this.activeState;
        }

        public final ReusableComposition getComposition() {
            return this.composition;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final boolean getForceReuse() {
            return this.forceReuse;
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setActive(boolean value) {
            this.activeState.setValue(Boolean.valueOf(value));
        }

        public final void setActiveState(MutableState<Boolean> <set-?>) {
            this.activeState = <set-?>;
        }

        public final void setComposition(ReusableComposition <set-?>) {
            this.composition = <set-?>;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> <set-?>) {
            this.content = <set-?>;
        }

        public final void setForceRecompose(boolean <set-?>) {
            this.forceRecompose = <set-?>;
        }

        public final void setForceReuse(boolean <set-?>) {
            this.forceReuse = <set-?>;
        }

        public final void setSlotId(Object <set-?>) {
            this.slotId = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003Je\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0008\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u00172\u001b\u0008\u0002\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a¢\u0006\u0002\u0008\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\u0008\u001dH\u0096\u0001JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0008\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u00172\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\u0008\u001dH\u0096\u0001J0\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\"0!2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u001c0&¢\u0006\u0002\u0008'H\u0016¢\u0006\u0002\u0010(J\u0017\u0010)\u001a\u00020\u0014*\u00020*H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J\u0017\u0010)\u001a\u00020\u0014*\u00020-H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008.\u0010/J\u0017\u00100\u001a\u00020**\u00020-H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00081\u00102J\u001a\u00100\u001a\u00020**\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00083\u00104J\u001a\u00100\u001a\u00020**\u00020\u0014H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00083\u00105J\u0017\u00106\u001a\u000207*\u000208H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J\u0017\u0010;\u001a\u00020\u0005*\u00020*H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008<\u00104J\u0017\u0010;\u001a\u00020\u0005*\u00020-H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008=\u00102J\r\u0010>\u001a\u00020?*\u00020@H\u0097\u0001J\u0017\u0010A\u001a\u000208*\u000207H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008B\u0010:J\u0017\u0010C\u001a\u00020-*\u00020*H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ\u001a\u0010C\u001a\u00020-*\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008F\u0010EJ\u001a\u0010C\u001a\u00020-*\u00020\u0014H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008F\u0010GR\u0014\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0008\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000cR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006H", d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$PostLookaheadMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class PostLookaheadMeasureScopeImpl implements androidx.compose.ui.layout.SubcomposeMeasureScope, androidx.compose.ui.layout.MeasureScope {

        private final androidx.compose.ui.layout.LayoutNodeSubcompositionsState.Scope $$delegate_0;
        final androidx.compose.ui.layout.LayoutNodeSubcompositionsState this$0;
        public PostLookaheadMeasureScopeImpl(androidx.compose.ui.layout.LayoutNodeSubcompositionsState this$0) {
            this.this$0 = this$0;
            super();
            this.$$delegate_0 = LayoutNodeSubcompositionsState.access$getScope$p(this.this$0);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        public androidx.compose.ui.layout.MeasureResult layout(int i, int i2, Map<androidx.compose.ui.layout.AlignmentLine, Integer> map3, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> function14) {
            return this.$$delegate_0.layout(i, i2, map3, function14);
        }

        public androidx.compose.ui.layout.MeasureResult layout(int i, int i2, Map<androidx.compose.ui.layout.AlignmentLine, Integer> map3, Function1<? super androidx.compose.ui.layout.RulerScope, Unit> function14, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> function15) {
            return this.$$delegate_0.layout(i, i2, map3, function14, function15);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public int roundToPx--R2X_6o(long l) {
            return this.$$delegate_0.roundToPx--R2X_6o(l);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public int roundToPx-0680j_4(float f) {
            return this.$$delegate_0.roundToPx-0680j_4(f);
        }

        public List<androidx.compose.ui.layout.Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            List childMeasurables$ui_release;
            Object obj = LayoutNodeSubcompositionsState.access$getSlotIdToNode$p(this.this$0).get(slotId);
            if ((LayoutNode)obj != null) {
                childMeasurables$ui_release = (LayoutNode)obj.getChildMeasurables$ui_release();
            } else {
                childMeasurables$ui_release = 0;
            }
            if (childMeasurables$ui_release != null) {
                return childMeasurables$ui_release;
            }
            return LayoutNodeSubcompositionsState.access$postLookaheadSubcompose(this.this$0, slotId, content);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float toDp-GaN1DYA(long l) {
            return this.$$delegate_0.toDp-GaN1DYA(l);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float toDp-u2uoSUM(float f) {
            return this.$$delegate_0.toDp-u2uoSUM(f);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float toDp-u2uoSUM(int i) {
            return this.$$delegate_0.toDp-u2uoSUM(i);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public long toDpSize-k-rfVVM(long l) {
            return this.$$delegate_0.toDpSize-k-rfVVM(l);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float toPx--R2X_6o(long l) {
            return this.$$delegate_0.toPx--R2X_6o(l);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float toPx-0680j_4(float f) {
            return this.$$delegate_0.toPx-0680j_4(f);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public long toSize-XkaWNTQ(long l) {
            return this.$$delegate_0.toSize-XkaWNTQ(l);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public long toSp-0xMU5do(float f) {
            return this.$$delegate_0.toSp-0xMU5do(f);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public long toSp-kPz2Gy4(float f) {
            return this.$$delegate_0.toSp-kPz2Gy4(f);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public long toSp-kPz2Gy4(int i) {
            return this.$$delegate_0.toSp-kPz2Gy4(i);
        }
    }

    @Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J`\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u001b2\u0019\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e¢\u0006\u0002\u0008!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\u001e¢\u0006\u0002\u0008!H\u0016J0\u0010$\u001a\u0008\u0012\u0004\u0012\u00020&0%2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020 0*¢\u0006\u0002\u0008+H\u0016¢\u0006\u0002\u0010,R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u0006\"\u0004\u0008\u000b\u0010\u0008R\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006-", d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class Scope implements androidx.compose.ui.layout.SubcomposeMeasureScope {

        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection;
        final androidx.compose.ui.layout.LayoutNodeSubcompositionsState this$0;
        public Scope(androidx.compose.ui.layout.LayoutNodeSubcompositionsState this$0) {
            this.this$0 = this$0;
            super();
            this.layoutDirection = LayoutDirection.Rtl;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public float getFontScale() {
            return this.fontScale;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public boolean isLookingAhead() {
            int i;
            LayoutNode.LayoutState layoutState$ui_release;
            LayoutNode.LayoutState lookaheadLayingOut;
            if (LayoutNodeSubcompositionsState.access$getRoot$p(this.this$0).getLayoutState$ui_release() != LayoutNode.LayoutState.LookaheadLayingOut) {
                if (LayoutNodeSubcompositionsState.access$getRoot$p(this.this$0).getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public androidx.compose.ui.layout.MeasureResult layout(int width, int height, Map<androidx.compose.ui.layout.AlignmentLine, Integer> alignmentLines, Function1<? super androidx.compose.ui.layout.RulerScope, Unit> rulers, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> placementBlock) {
            int i;
            int i2;
            String $i$a$CheckPreconditionLookaheadDelegateKt$checkMeasuredSize$1$iv;
            StringBuilder append;
            String str;
            int i3 = 0;
            i = -16777216;
            if (width & i == 0 && i &= height == 0) {
                i2 = i &= height == 0 ? 1 : 0;
            } else {
            }
            int i7 = 0;
            if (i2 == 0) {
                int i8 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Size(").append(width).append(" x ").append(height).append(") is out of range. Each dimension must be between 0 and 16777215.").toString());
            }
            LayoutNodeSubcompositionsState.Scope.layout.1 $i$f$checkMeasuredSize = new LayoutNodeSubcompositionsState.Scope.layout.1(width, height, alignmentLines, rulers, this, this.this$0, placementBlock);
            return (MeasureResult)$i$f$checkMeasuredSize;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public void setDensity(float <set-?>) {
            this.density = <set-?>;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public void setFontScale(float <set-?>) {
            this.fontScale = <set-?>;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public void setLayoutDirection(LayoutDirection <set-?>) {
            this.layoutDirection = <set-?>;
        }

        public List<androidx.compose.ui.layout.Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            return this.this$0.subcompose(slotId, content);
        }
    }
    static {
        final int i = 8;
    }

    public LayoutNodeSubcompositionsState(LayoutNode root, androidx.compose.ui.layout.SubcomposeSlotReusePolicy slotReusePolicy) {
        super();
        this.root = root;
        this.slotReusePolicy = slotReusePolicy;
        HashMap hashMap = new HashMap();
        this.nodeToNodeState = hashMap;
        HashMap hashMap2 = new HashMap();
        this.slotIdToNode = hashMap2;
        LayoutNodeSubcompositionsState.Scope scope = new LayoutNodeSubcompositionsState.Scope(this);
        this.scope = scope;
        LayoutNodeSubcompositionsState.PostLookaheadMeasureScopeImpl postLookaheadMeasureScopeImpl = new LayoutNodeSubcompositionsState.PostLookaheadMeasureScopeImpl(this);
        this.postLookaheadMeasureScope = postLookaheadMeasureScopeImpl;
        HashMap hashMap3 = new HashMap();
        this.precomposeMap = hashMap3;
        int i2 = 0;
        SubcomposeSlotReusePolicy.SlotIdsSet slotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet(i2, 1, i2);
        this.reusableSlotIdsSet = slotIdsSet;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.postLookaheadPrecomposeSlotHandleMap = (Map)linkedHashMap;
        int i = 0;
        int i5 = 0;
        MutableVector mutableVector = new MutableVector(new Object[16], 0);
        this.postLookaheadComposedSlotIds = mutableVector;
        this.NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    }

    public static final void access$disposeUnusedSlotsInPostLookahead(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        $this.disposeUnusedSlotsInPostLookahead();
    }

    public static final int access$getCurrentIndex$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.currentIndex;
    }

    public static final int access$getCurrentPostLookaheadIndex$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.currentPostLookaheadIndex;
    }

    public static final MutableVector access$getPostLookaheadComposedSlotIds$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.postLookaheadComposedSlotIds;
    }

    public static final androidx.compose.ui.layout.LayoutNodeSubcompositionsState.PostLookaheadMeasureScopeImpl access$getPostLookaheadMeasureScope$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.postLookaheadMeasureScope;
    }

    public static final HashMap access$getPrecomposeMap$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.precomposeMap;
    }

    public static final int access$getPrecomposedCount$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.precomposedCount;
    }

    public static final int access$getReusableCount$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.reusableCount;
    }

    public static final LayoutNode access$getRoot$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.root;
    }

    public static final androidx.compose.ui.layout.LayoutNodeSubcompositionsState.Scope access$getScope$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.scope;
    }

    public static final HashMap access$getSlotIdToNode$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this) {
        return $this.slotIdToNode;
    }

    public static final void access$move(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this, int from, int to, int count) {
        $this.move(from, to, count);
    }

    public static final List access$postLookaheadSubcompose(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this, Object slotId, Function2 content) {
        return $this.postLookaheadSubcompose(slotId, content);
    }

    public static final void access$setCurrentIndex$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this, int <set-?>) {
        $this.currentIndex = <set-?>;
    }

    public static final void access$setCurrentPostLookaheadIndex$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this, int <set-?>) {
        $this.currentPostLookaheadIndex = <set-?>;
    }

    public static final void access$setPrecomposedCount$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this, int <set-?>) {
        $this.precomposedCount = <set-?>;
    }

    public static final void access$setReusableCount$p(androidx.compose.ui.layout.LayoutNodeSubcompositionsState $this, int <set-?>) {
        $this.reusableCount = <set-?>;
    }

    private final androidx.compose.ui.layout.MeasureResult createMeasureResult(androidx.compose.ui.layout.MeasureResult result, Function0<Unit> placeChildrenBlock) {
        final int i = 0;
        LayoutNodeSubcompositionsState.createMeasureResult.1 anon = new LayoutNodeSubcompositionsState.createMeasureResult.1(result, placeChildrenBlock);
        return (MeasureResult)anon;
    }

    private final LayoutNode createNodeAt(int index) {
        int i4 = 1;
        final int i6 = 0;
        LayoutNode layoutNode = new LayoutNode(i4, i6, 2, 0);
        int i3 = 0;
        final int i7 = 0;
        final LayoutNode root = obj.root;
        final int i8 = 0;
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, i4);
        int i5 = 0;
        this.root.insertAt$ui_release(index, layoutNode);
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, i6);
        return layoutNode;
    }

    private final void disposeCurrentNodes() {
        Object next;
        Object obj;
        int i;
        ReusableComposition composition;
        LayoutNode root = this.root;
        final int i2 = 0;
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, true);
        int i4 = 0;
        final int i6 = 0;
        final Iterator iterator = (Iterable)this.nodeToNodeState.values().iterator();
        while (iterator.hasNext()) {
            i = 0;
            composition = (LayoutNodeSubcompositionsState.NodeState)iterator.next().getComposition();
            if (composition != null) {
            }
            composition.dispose();
        }
        this.root.removeAll$ui_release();
        int i5 = 0;
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, i5);
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = i5;
        this.reusableCount = i5;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    private final void disposeUnusedSlotsInPostLookahead() {
        LayoutNodeSubcompositionsState.disposeUnusedSlotsInPostLookahead.1 anon = new LayoutNodeSubcompositionsState.disposeUnusedSlotsInPostLookahead.1(this);
        CollectionsKt.removeAll((Iterable)this.postLookaheadPrecomposeSlotHandleMap.entrySet(), (Function1)anon);
    }

    private final Object getSlotIdAtIndex(int index) {
        Object obj2 = this.nodeToNodeState.get((LayoutNode)this.root.getFoldedChildren$ui_release().get(index));
        Intrinsics.checkNotNull(obj2);
        return (LayoutNodeSubcompositionsState.NodeState)obj2.getSlotId();
    }

    private final void ignoreRemeasureRequests(Function0<Unit> block) {
        final int i = 0;
        final LayoutNode root = this.root;
        final int i2 = 0;
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, true);
        block.invoke();
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, false);
    }

    private final void markActiveNodesAsReused(boolean deactivate) {
        int slotIdToNode;
        int reusableCount;
        int i2;
        Snapshot currentThreadSnapshot;
        int i5;
        Function1 readObserver;
        Snapshot currentNonObservable;
        int i;
        int i4;
        Object obj;
        Object obj2;
        boolean mutableStateOf$default;
        int i3;
        slotIdToNode = 0;
        this.precomposedCount = slotIdToNode;
        this.precomposeMap.clear();
        int size = this.root.getFoldedChildren$ui_release().size();
        if (this.reusableCount != size) {
            this.reusableCount = size;
            reusableCount = Snapshot.Companion;
            i2 = 0;
            currentThreadSnapshot = reusableCount.getCurrentThreadSnapshot();
            i5 = 0;
            if (currentThreadSnapshot != null) {
                readObserver = currentThreadSnapshot.getReadObserver();
            } else {
                readObserver = i5;
            }
            i = 0;
            i4 = 0;
            while (i4 < size) {
                obj = this.root.getFoldedChildren$ui_release().get(i4);
                obj2 = this.nodeToNodeState.get((LayoutNode)obj);
                if (obj2 != null && (LayoutNodeSubcompositionsState.NodeState)obj2.getActive()) {
                }
                i4++;
                if (obj2.getActive()) {
                }
                resetLayoutState(obj);
                if (deactivate) {
                } else {
                }
                obj2.setActive(slotIdToNode);
                obj2.setSlotId(SubcomposeLayoutKt.access$getReusedSlotId$p());
                ReusableComposition composition = obj2.getComposition();
                if (composition != null) {
                }
                obj2.setActiveState(SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(slotIdToNode), i5, 2, i5));
                composition.deactivate();
            }
            Unit iNSTANCE = Unit.INSTANCE;
            reusableCount.restoreNonObservable(currentThreadSnapshot, reusableCount.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
            this.slotIdToNode.clear();
        }
        makeSureStateIsConsistent();
    }

    private final void move(int from, int to, int count) {
        final int i = 0;
        final LayoutNode root = obj.root;
        final int i2 = 0;
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, true);
        int i4 = 0;
        this.root.move$ui_release(from, to, count);
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, false);
    }

    static void move$default(androidx.compose.ui.layout.LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i2, int i3, int i4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 1;
        }
        layoutNodeSubcompositionsState.move(i2, i3, obj3);
    }

    private final List<androidx.compose.ui.layout.Measurable> postLookaheadSubcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        int i2;
        MutableVector postLookaheadComposedSlotIds;
        boolean layoutState$ui_release;
        int currentPostLookaheadIndex;
        List childDelegates$ui_release;
        Object postLookaheadPrecomposeSlotHandleMap;
        int i3;
        int i4;
        int i;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i5;
        childDelegates$ui_release = 1;
        i2 = this.postLookaheadComposedSlotIds.getSize() >= this.currentPostLookaheadIndex ? childDelegates$ui_release : 0;
        if (i2 == 0) {
        } else {
            if (this.postLookaheadComposedSlotIds.getSize() == this.currentPostLookaheadIndex) {
                this.postLookaheadComposedSlotIds.add(slotId);
            } else {
                this.postLookaheadComposedSlotIds.set(this.currentPostLookaheadIndex, slotId);
            }
            this.currentPostLookaheadIndex = currentPostLookaheadIndex2 += childDelegates$ui_release;
            if (!(Map)this.precomposeMap.containsKey(slotId)) {
                int i8 = 0;
                this.postLookaheadPrecomposeSlotHandleMap.put(slotId, precompose(slotId, content));
                if (this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                    this.root.requestLookaheadRelayout$ui_release(childDelegates$ui_release);
                } else {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(this.root, true, false, false, 6, 0);
                }
            }
            Object obj3 = this.precomposeMap.get(slotId);
            if ((LayoutNode)obj3 != null) {
                currentPostLookaheadIndex = 0;
                childDelegates$ui_release = (LayoutNode)obj3.getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
                i3 = 0;
                i4 = postLookaheadPrecomposeSlotHandleMap;
                i = 0;
                index$iv = 0;
                while (index$iv < i4.size()) {
                    i5 = 0;
                    (LayoutNodeLayoutDelegate.MeasurePassDelegate)i4.get(index$iv).markDetachedFromParentLookaheadPass$ui_release();
                    index$iv++;
                }
                if (childDelegates$ui_release == null) {
                    childDelegates$ui_release = CollectionsKt.emptyList();
                }
            } else {
            }
            return childDelegates$ui_release;
        }
        int i7 = 0;
        IllegalArgumentException $i$a$RequireLayoutNodeSubcompositionsState$postLookaheadSubcompose$1 = new IllegalArgumentException("Error: currentPostLookaheadIndex cannot be greater than the size of thepostLookaheadComposedSlotIds list.".toString());
        throw $i$a$RequireLayoutNodeSubcompositionsState$postLookaheadSubcompose$1;
    }

    private final void resetLayoutState(LayoutNode $this$resetLayoutState) {
        LayoutNode.UsageByParent notUsed2;
        LayoutNode.UsageByParent notUsed;
        $this$resetLayoutState.getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = $this$resetLayoutState.getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            notUsed2 = 0;
            lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        }
    }

    private final void subcompose(LayoutNode node, androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState nodeState) {
        Function1 readObserver;
        Object obj3;
        final androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState nodeState2 = nodeState;
        final Snapshot.Companion companion = Snapshot.Companion;
        int i3 = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        int i = 0;
        Object obj = this;
        final int i4 = 0;
        final LayoutNode root = obj.root;
        final int i5 = 0;
        LayoutNode.access$setIgnoreRemeasureRequests$p(root, true);
        final int i7 = 0;
        final Object obj2 = this;
        CompositionContext compositionContext = obj2.compositionContext;
        if (compositionContext == null) {
        } else {
            int i9 = i;
            LayoutNodeSubcompositionsState.subcompose.3.1.1 $i$a$WithoutReadObservationLayoutNodeSubcompositionsState$subcompose$32 = new LayoutNodeSubcompositionsState.subcompose.3.1.1(nodeState2, nodeState2.getContent());
            int i11 = i3;
            Object obj5 = obj;
            nodeState2.setComposition(obj2.subcomposeInto(nodeState2.getComposition(), node, nodeState2.getForceReuse(), compositionContext, (Function2)ComposableLambdaKt.composableLambdaInstance(-1750409193, true, $i$a$WithoutReadObservationLayoutNodeSubcompositionsState$subcompose$32)));
            int i2 = 0;
            nodeState2.setForceReuse(i2);
            LayoutNode.access$setIgnoreRemeasureRequests$p(root, i2);
            Unit iNSTANCE = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        }
        int i8 = i;
        int i10 = i3;
        Object obj4 = obj;
        IllegalStateException $i$a$WithoutReadObservationLayoutNodeSubcompositionsState$subcompose$3 = new IllegalStateException("parent composition reference not set".toString());
        throw $i$a$WithoutReadObservationLayoutNodeSubcompositionsState$subcompose$3;
    }

    private final void subcompose(LayoutNode node, Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        int hasInvalidations;
        boolean forceRecompose;
        int i;
        Object nodeState;
        Object slotId2;
        Function2 lambda-1$ui_release;
        int i4;
        int i2;
        int i3;
        HashMap nodeToNodeState = this.nodeToNodeState;
        int i5 = 0;
        final Object obj = (Map)nodeToNodeState.get(node);
        if (obj == null) {
            i = 0;
            nodeState = new LayoutNodeSubcompositionsState.NodeState(slotId, ComposableSingletons.SubcomposeLayoutKt.INSTANCE.getLambda-1$ui_release(), 0, 4, 0);
            nodeToNodeState.put(node, nodeState);
        } else {
            slotId2 = slotId;
            nodeState = obj;
        }
        final Object obj12 = nodeState;
        ReusableComposition composition = (LayoutNodeSubcompositionsState.NodeState)obj12.getComposition();
        if (composition != null) {
            hasInvalidations = composition.getHasInvalidations();
        } else {
            hasInvalidations = 1;
        }
        if (obj12.getContent() == content && hasInvalidations == 0) {
            if (hasInvalidations == 0) {
                if (obj12.getForceRecompose()) {
                    obj12.setContent(content);
                    subcompose(node, obj12);
                    obj12.setForceRecompose(false);
                }
            } else {
            }
        } else {
        }
    }

    private final ReusableComposition subcomposeInto(ReusableComposition existing, LayoutNode container, boolean reuseContent, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> composable) {
        ReusableComposition subcomposition;
        boolean disposed;
        if (existing != null) {
            if (existing.isDisposed()) {
                subcomposition = Wrapper_androidKt.createSubcomposition(container, parent);
            } else {
                subcomposition = existing;
            }
        } else {
        }
        final ReusableComposition reusableComposition = subcomposition;
        final int i = 0;
        if (!reuseContent) {
            reusableComposition.setContent(composable);
        } else {
            reusableComposition.setContentWithReuse(composable);
        }
        return subcomposition;
    }

    private final LayoutNode takeNodeFromReusables(Object slotId) {
        Object i;
        int index;
        int chosenIndex;
        boolean equal;
        Object i2;
        Object obj;
        Object obj2;
        Object valueOf;
        Object slotId2;
        i = 0;
        if (this.reusableCount == 0) {
            return i;
        }
        size -= precomposedCount;
        int i4 = i3 - reusableCount2;
        index = i3 + -1;
        chosenIndex = -1;
        while (index >= i4) {
            if (Intrinsics.areEqual(getSlotIdAtIndex(index), slotId)) {
                break;
            } else {
            }
            index--;
        }
        i2 = -1;
        if (chosenIndex == i2) {
            index = i3 + -1;
            while (index >= i4) {
                obj2 = this.nodeToNodeState.get((LayoutNode)this.root.getFoldedChildren$ui_release().get(index));
                Intrinsics.checkNotNull(obj2);
                index--;
            }
        }
        if (chosenIndex == i2) {
        } else {
            obj = 1;
            if (index != i4) {
                move(index, i4, obj);
            }
            this.reusableCount = reusableCount3 += i2;
            i2 = this.root.getFoldedChildren$ui_release().get(i4);
            obj2 = this.nodeToNodeState.get((LayoutNode)i2);
            Intrinsics.checkNotNull(obj2);
            (LayoutNodeSubcompositionsState.NodeState)obj2.setActiveState(SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(obj), i, 2, i));
            obj2.setForceReuse(obj);
            obj2.setForceRecompose(obj);
            i = i2;
        }
        return i;
    }

    public final androidx.compose.ui.layout.MeasurePolicy createMeasurePolicy(Function2<? super androidx.compose.ui.layout.SubcomposeMeasureScope, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> block) {
        LayoutNodeSubcompositionsState.createMeasurePolicy.1 anon = new LayoutNodeSubcompositionsState.createMeasurePolicy.1(this, block, this.NoIntrinsicsMessage);
        return (MeasurePolicy)anon;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void disposeOrReuseStartingFromIndex(int startIndex) {
        int iNSTANCE;
        int i3;
        int i11;
        int i;
        int lastReusableIndex2;
        int i10;
        Object active;
        int needApplyNotification;
        int i9;
        int i7;
        Object slotIdAtIndex;
        androidx.compose.ui.layout.SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet;
        Snapshot currentThreadSnapshot;
        int readObserver;
        Snapshot currentNonObservable;
        int i2;
        Object obj2;
        Object obj;
        Object slotId;
        int i4;
        int i12;
        int i6;
        int i8;
        int i5;
        int lastReusableIndex;
        final Object obj3 = this;
        obj3.reusableCount = 0;
        i15 -= i10;
        needApplyNotification = 0;
        if (startIndex <= i) {
            obj3.reusableSlotIdsSet.clear();
            if (startIndex <= i) {
            }
            obj3.slotReusePolicy.getSlotsToRetain(obj3.reusableSlotIdsSet);
            int i18 = 0;
            i7 = i;
            slotIdAtIndex = Snapshot.Companion;
            reusableSlotIdsSet = 0;
            currentThreadSnapshot = slotIdAtIndex.getCurrentThreadSnapshot();
            if (currentThreadSnapshot != null) {
                readObserver = currentThreadSnapshot.getReadObserver();
            } else {
                readObserver = 0;
            }
            i2 = 0;
            while (i7 >= i3) {
                obj2 = obj3.root.getFoldedChildren$ui_release().get(i7);
                obj = obj3.nodeToNodeState.get((LayoutNode)obj2);
                Intrinsics.checkNotNull(obj);
                slotId = (LayoutNodeSubcompositionsState.NodeState)obj.getSlotId();
                i4 = i10;
                if (obj3.reusableSlotIdsSet.contains(slotId)) {
                } else {
                }
                i12 = 0;
                iNSTANCE = active.root;
                i6 = 0;
                LayoutNode.access$setIgnoreRemeasureRequests$p(iNSTANCE, i4);
                i8 = i14;
                obj3.nodeToNodeState.remove(obj2);
                ReusableComposition composition = obj.getComposition();
                if (composition != null) {
                }
                i5 = i;
                obj3.root.removeAt$ui_release(i7, 1);
                LayoutNode.access$setIgnoreRemeasureRequests$p(iNSTANCE, false);
                obj3.slotIdToNode.remove(slotId);
                i7--;
                iNSTANCE = i11;
                i10 = lastReusableIndex2;
                i = i5;
                i3 = startIndex;
                composition.dispose();
                obj3.reusableCount = reusableCount++;
                if (obj.getActive()) {
                } else {
                }
                i11 = iNSTANCE;
                i5 = i;
                lastReusableIndex2 = i4;
                obj3.resetLayoutState(obj2);
                obj.setActive(iNSTANCE);
                i11 = iNSTANCE;
                i5 = i;
                needApplyNotification = active;
                lastReusableIndex2 = i4;
            }
            lastReusableIndex = i;
            iNSTANCE = Unit.INSTANCE;
            slotIdAtIndex.restoreNonObservable(currentThreadSnapshot, slotIdAtIndex.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        } else {
            lastReusableIndex = i;
        }
        if (needApplyNotification != 0) {
            Snapshot.Companion.sendApplyNotifications();
        }
        obj3.makeSureStateIsConsistent();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void forceRecomposeChildren() {
        int measurePending$ui_release;
        int root;
        Iterator iterator;
        Object next;
        int i2;
        Object value;
        int i;
        if (this.reusableCount != this.root.getFoldedChildren$ui_release().size()) {
            root = 0;
            iterator = (Map)this.nodeToNodeState.entrySet().iterator();
            for (Map.Entry next : iterator) {
                i2 = 0;
                (LayoutNodeSubcompositionsState.NodeState)next.getValue().setForceRecompose(true);
            }
            if (!this.root.getMeasurePending$ui_release()) {
                LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, false, 7, 0);
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.layout.SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void makeSureStateIsConsistent() {
        int i3;
        int i2;
        int i;
        int size = this.root.getFoldedChildren$ui_release().size();
        i = 1;
        int i9 = 0;
        i3 = this.nodeToNodeState.size() == size ? i : i9;
        if (i3 == 0) {
        } else {
            i2 = i4 -= precomposedCount3 >= 0 ? i : i9;
            if (i2 == 0) {
            } else {
                if (this.precomposeMap.size() == this.precomposedCount) {
                } else {
                    i = i9;
                }
                if (i == 0) {
                } else {
                }
                int i7 = 0;
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Incorrect state. Precomposed children ").append(this.precomposedCount).append(". Map size ").append(this.precomposeMap.size()).toString().toString());
                throw illegalArgumentException2;
            }
            int i6 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Incorrect state. Total children ").append(size).append(". Reusable children ").append(this.reusableCount).append(". Precomposed children ").append(this.precomposedCount).toString().toString());
            throw illegalArgumentException;
        }
        int i8 = 0;
        StringBuilder stringBuilder3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.append("Inconsistency between the count of nodes tracked by the state (").append(this.nodeToNodeState.size()).append(") and the children count on the SubcomposeLayout (").append(size).append("). Are you trying to use the state of the disposed SubcomposeLayout?").toString().toString());
        throw illegalArgumentException3;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        markActiveNodesAsReused(true);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        disposeCurrentNodes();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        markActiveNodesAsReused(false);
    }

    public final androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle precompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        boolean $this$getOrPut$iv;
        int i5;
        Object obj;
        int i2;
        LayoutNode takeNodeFromReusables;
        int i3;
        Object nodeIndex;
        LayoutNode layoutNode;
        int i4;
        int i;
        if (!this.root.isAttached()) {
            LayoutNodeSubcompositionsState.precompose.1 anon = new LayoutNodeSubcompositionsState.precompose.1();
            return (SubcomposeLayoutState.PrecomposedSlotHandle)anon;
        }
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(slotId)) {
            this.postLookaheadPrecomposeSlotHandleMap.remove(slotId);
            HashMap precomposeMap = this.precomposeMap;
            i5 = 0;
            obj = (Map)precomposeMap.get(slotId);
            if (obj == null) {
                i2 = 0;
                takeNodeFromReusables = takeNodeFromReusables(slotId);
                i3 = 1;
                if (takeNodeFromReusables != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(takeNodeFromReusables), this.root.getFoldedChildren$ui_release().size(), i3);
                    this.precomposedCount = precomposedCount += i3;
                    nodeIndex = takeNodeFromReusables;
                } else {
                    layoutNode = nodeIndex;
                    i4 = 0;
                    this.precomposedCount = precomposedCount2 += i3;
                }
                precomposeMap.put(slotId, nodeIndex);
            } else {
                nodeIndex = obj;
            }
            subcompose((LayoutNode)nodeIndex, slotId, content);
        }
        LayoutNodeSubcompositionsState.precompose.2 node = new LayoutNodeSubcompositionsState.precompose.2(this, slotId);
        return (SubcomposeLayoutState.PrecomposedSlotHandle)node;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setCompositionContext(CompositionContext <set-?>) {
        this.compositionContext = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setSlotReusePolicy(androidx.compose.ui.layout.SubcomposeSlotReusePolicy value) {
        androidx.compose.ui.layout.SubcomposeSlotReusePolicy slotReusePolicy;
        LayoutNode root;
        int i;
        int i4;
        int i3;
        int i2;
        int i5;
        if (this.slotReusePolicy != value) {
            this.slotReusePolicy = value;
            markActiveNodesAsReused(false);
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, false, 7, 0);
        }
    }

    public final List<androidx.compose.ui.layout.Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        LayoutNode.LayoutState lookaheadMeasuring;
        int i;
        int currentIndex3;
        LayoutNode.LayoutState layingOut;
        List childLookaheadMeasurables$ui_release;
        int currentIndex;
        String $i$a$CheckPreconditionLayoutNodeSubcompositionsState$subcompose$1;
        Object obj;
        int indexOf;
        Object currentIndex2;
        Object takeNodeFromReusables;
        int i2;
        int i3;
        String str;
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState$ui_release = this.root.getLayoutState$ui_release();
        currentIndex3 = 0;
        int i6 = 1;
        if (layoutState$ui_release != LayoutNode.LayoutState.Measuring && layoutState$ui_release != LayoutNode.LayoutState.LayingOut && layoutState$ui_release != LayoutNode.LayoutState.LookaheadMeasuring) {
            if (layoutState$ui_release != LayoutNode.LayoutState.LayingOut) {
                if (layoutState$ui_release != LayoutNode.LayoutState.LookaheadMeasuring) {
                    if (layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
                        i = i6;
                    } else {
                        i = currentIndex3;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        int i7 = 0;
        if (i == 0) {
            int i9 = 0;
            InlineClassHelperKt.throwIllegalStateException("subcompose can only be used inside the measure or layout blocks");
        }
        HashMap value$iv = this.slotIdToNode;
        int i8 = 0;
        Object obj2 = (Map)value$iv.get(slotId);
        if (obj2 == null) {
            indexOf = 0;
            currentIndex2 = this.precomposeMap.remove(slotId);
            if ((LayoutNode)currentIndex2 != null) {
                i2 = this.precomposedCount > 0 ? i6 : currentIndex3;
                i3 = 0;
                if (i2 == 0) {
                    InlineClassHelperKt.throwIllegalStateException("Check failed.");
                }
                this.precomposedCount = value$iv2--;
                takeNodeFromReusables = currentIndex2;
            } else {
                if (takeNodeFromReusables(slotId) == null) {
                    takeNodeFromReusables = createNodeAt(this.currentIndex);
                }
            }
            value$iv.put(slotId, takeNodeFromReusables);
        } else {
            takeNodeFromReusables = obj2;
        }
        Object $this$getOrPut$iv = takeNodeFromReusables;
        indexOf = this.root.getFoldedChildren$ui_release().indexOf((LayoutNode)$this$getOrPut$iv);
        if (CollectionsKt.getOrNull(this.root.getFoldedChildren$ui_release(), this.currentIndex) != $this$getOrPut$iv && indexOf >= this.currentIndex) {
            indexOf = this.root.getFoldedChildren$ui_release().indexOf($this$getOrPut$iv);
            if (indexOf >= this.currentIndex) {
                currentIndex3 = i6;
            }
            if (currentIndex3 == 0) {
            } else {
                if (this.currentIndex != indexOf) {
                    LayoutNodeSubcompositionsState.move$default(this, indexOf, this.currentIndex, 0, 4, 0);
                } else {
                    obj = this;
                }
                obj.currentIndex = currentIndex4 += i6;
                subcompose($this$getOrPut$iv, slotId, content);
                if (layoutState$ui_release != LayoutNode.LayoutState.Measuring) {
                    if (layoutState$ui_release == LayoutNode.LayoutState.LayingOut) {
                        childLookaheadMeasurables$ui_release = $this$getOrPut$iv.getChildMeasurables$ui_release();
                    } else {
                        childLookaheadMeasurables$ui_release = $this$getOrPut$iv.getChildLookaheadMeasurables$ui_release();
                    }
                } else {
                }
                return childLookaheadMeasurables$ui_release;
            }
            Object obj3 = this;
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Key \"").append(slotId).append("\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString().toString());
            throw illegalArgumentException;
        }
        obj = this;
    }
}
