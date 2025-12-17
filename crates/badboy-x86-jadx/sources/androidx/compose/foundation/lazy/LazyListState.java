package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u009b\u00012\u00020\u0001:\u0002\u009b\u0001B\u001b\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B%\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\"\u0010t\u001a\u00020u2\u0008\u0008\u0001\u0010v\u001a\u00020\u00032\u0008\u0008\u0002\u0010w\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010xJ'\u0010y\u001a\u00020u2\u0006\u0010z\u001a\u00020E2\u0006\u0010{\u001a\u00020\u00182\u0008\u0008\u0002\u0010|\u001a\u00020\u0018H\u0000¢\u0006\u0002\u0008}J\u0010\u0010~\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020\u000bH\u0016J\u0019\u0010\u0080\u0001\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020@H\u0002J\u0018\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u0082\u0001\u001a\u00020\u000bH\u0000¢\u0006\u0003\u0008\u0083\u0001J\u001b\u0010\u0084\u0001\u001a\u00020u2\u0008\u0008\u0001\u0010v\u001a\u00020\u00032\u0008\u0008\u0002\u0010w\u001a\u00020\u0003JI\u0010\u0085\u0001\u001a\u00020u2\u0008\u0010\u0086\u0001\u001a\u00030\u0087\u00012-\u0010\u0088\u0001\u001a(\u0008\u0001\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020u0\u008b\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u008c\u00010\u0089\u0001¢\u0006\u0003\u0008\u008d\u0001H\u0096@¢\u0006\u0003\u0010\u008e\u0001J#\u0010\u008f\u0001\u001a\u00020u2\u0008\u0008\u0001\u0010v\u001a\u00020\u00032\u0008\u0008\u0002\u0010w\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010xJ(\u0010\u0090\u0001\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u00032\u0007\u0010\u0091\u0001\u001a\u00020\u0018H\u0000¢\u0006\u0003\u0008\u0092\u0001J#\u0010\u0093\u0001\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0008\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002J\"\u0010\u0096\u0001\u001a\u00020\u00032\u0008\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\u0008\u009a\u0001R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001e\u0010\u001f\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR+\u0010 \u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008#\u0010\u001f\u001a\u0004\u0008!\u0010\u001b\"\u0004\u0008\"\u0010\u001dR\u0014\u0010$\u001a\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008(\u0010)R\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008*\u0010)R\u001e\u0010+\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001bR\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\u0008/\u00100R\u0014\u00101\u001a\u000202X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0014\u00105\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00085\u0010\u001bR\u001a\u00106\u001a\u0008\u0012\u0004\u0012\u00020807X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u0014\u0010;\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008<\u0010\u001bR\u0014\u0010=\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008>\u0010\u001bR\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\u0008A\u0010BR\u0014\u0010C\u001a\u0008\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u00020GX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\u0008H\u0010IR\u001b\u0010J\u001a\u00020K8@X\u0080\u0084\u0002¢\u0006\u000c\u001a\u0004\u0008N\u0010O*\u0004\u0008L\u0010MR\u001e\u0010P\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008Q\u0010)R\u0014\u0010R\u001a\u00020SX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010UR\u001c\u0010V\u001a\u00020GX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\u0008W\u0010IR\"\u0010X\u001a\u0004\u0018\u00010E2\u0008\u0010\u0017\u001a\u0004\u0018\u00010E@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008Y\u0010ZR\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010]\u001a\u00020^X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008_\u0010`R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008b\u0010\u001b\"\u0004\u0008c\u0010\u001dR\"\u0010e\u001a\u0004\u0018\u00010d2\u0008\u0010\u0017\u001a\u0004\u0018\u00010d@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008f\u0010gR\u0014\u0010h\u001a\u00020iX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008j\u0010kR\u0014\u0010l\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008m\u0010nR\u000e\u0010o\u001a\u00020pX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010q\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008r\u0010nR\u000e\u0010s\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u009c\u0001", d2 = {"Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/LazyListPrefetchStrategy;)V", "_scrollDeltaBetweenPasses", "Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animateScrollScope", "Landroidx/compose/foundation/lazy/LazyListAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "hasLookaheadPassOccurred", "getHasLookaheadPassOccurred$foundation_release", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/LazyListState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "postLookaheadLayoutInfo", "getPostLookaheadLayoutInfo$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "prefetchScope", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation_release", "()F", "scrollPosition", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "scrollableState", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "dispatchRawDelta", "delta", "notifyPrefetchOnScroll", "onScroll", "distance", "onScroll$foundation_release", "requestScrollToItem", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "forceRemeasure", "snapToItemIndexInternal$foundation_release", "updateScrollDeltaForPostLookahead", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyListState implements ScrollableState {

    public static final int $stable;
    public static final androidx.compose.foundation.lazy.LazyListState.Companion Companion;
    private static final Saver<androidx.compose.foundation.lazy.LazyListState, ?> Saver;
    private AnimationState<Float, AnimationVector1D> _scrollDeltaBetweenPasses;
    private final androidx.compose.foundation.lazy.LazyListAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private boolean hasLookaheadPassOccurred;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.LazyListMeasuredItem> itemAnimator;
    private final MutableState<androidx.compose.foundation.lazy.LazyListMeasureResult> layoutInfoState;
    private final MutableState<Unit> measurementScopeInvalidator;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private androidx.compose.foundation.lazy.LazyListMeasureResult postLookaheadLayoutInfo;
    private final androidx.compose.foundation.lazy.LazyListPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final androidx.compose.foundation.lazy.LazyListPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final androidx.compose.foundation.lazy.LazyListScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0008\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u00042\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0008\u000bR\u001b\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/lazy/LazyListState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/LazyListState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "saver", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "saver$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.foundation.lazy.LazyListState, ?> getSaver() {
            return LazyListState.access$getSaver$cp();
        }

        public final Saver<androidx.compose.foundation.lazy.LazyListState, ?> saver$foundation_release(androidx.compose.foundation.lazy.LazyListPrefetchStrategy prefetchStrategy) {
            LazyListState.Companion.saver.4 anon = new LazyListState.Companion.saver.4(prefetchStrategy);
            return ListSaverKt.listSaver((Function2)LazyListState.Companion.saver.3.INSTANCE, (Function1)anon);
        }
    }
    static {
        LazyListState.Companion companion = new LazyListState.Companion(0);
        LazyListState.Companion = companion;
        LazyListState.Saver = ListSaverKt.listSaver((Function2)LazyListState.Companion.Saver.1.INSTANCE, (Function1)LazyListState.Companion.Saver.2.INSTANCE);
    }

    public LazyListState() {
        super(0, 0, 0, 7, 0);
    }

    public LazyListState(int firstVisibleItemIndex, int firstVisibleItemScrollOffset) {
        super(firstVisibleItemIndex, firstVisibleItemScrollOffset, LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, 0));
    }

    public LazyListState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        int obj3;
        final int i4 = 0;
        obj2 = i3 & 1 != 0 ? i4 : obj2;
        obj3 = i3 &= 2 != 0 ? i4 : obj3;
        super(obj2, obj3);
    }

    public LazyListState(int firstVisibleItemIndex, int firstVisibleItemScrollOffset, androidx.compose.foundation.lazy.LazyListPrefetchStrategy prefetchStrategy) {
        super();
        this.prefetchStrategy = prefetchStrategy;
        LazyListScrollPosition lazyListScrollPosition = new LazyListScrollPosition(firstVisibleItemIndex, firstVisibleItemScrollOffset);
        this.scrollPosition = lazyListScrollPosition;
        LazyListAnimateScrollScope lazyListAnimateScrollScope = new LazyListAnimateScrollScope(this);
        this.animateScrollScope = lazyListAnimateScrollScope;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyListStateKt.access$getEmptyLazyListMeasureResult$p(), SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        LazyListState.scrollableState.1 anon = new LazyListState.scrollableState.1(this);
        this.scrollableState = ScrollableStateKt.ScrollableState((Function1)anon);
        int i = 1;
        this.prefetchingEnabled = i;
        LazyListState.remeasurementModifier.1 anon2 = new LazyListState.remeasurementModifier.1(this);
        this.remeasurementModifier = (RemeasurementModifier)anon2;
        AwaitFirstLayoutModifier awaitFirstLayoutModifier = new AwaitFirstLayoutModifier();
        this.awaitLayoutModifier = awaitFirstLayoutModifier;
        LazyLayoutItemAnimator lazyLayoutItemAnimator = new LazyLayoutItemAnimator();
        this.itemAnimator = lazyLayoutItemAnimator;
        LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
        LazyListState.prefetchState.1 anon4 = new LazyListState.prefetchState.1(this, firstVisibleItemIndex);
        LazyLayoutPrefetchState lazyLayoutPrefetchState = new LazyLayoutPrefetchState(this.prefetchStrategy.getPrefetchScheduler(), (Function1)anon4);
        this.prefetchState = lazyLayoutPrefetchState;
        LazyListState.prefetchScope.1 anon3 = new LazyListState.prefetchScope.1(this);
        this.prefetchScope = (LazyListPrefetchScope)anon3;
        LazyLayoutPinnedItemList lazyLayoutPinnedItemList = new LazyLayoutPinnedItemList();
        this.pinnedItems = lazyLayoutPinnedItemList;
        this.scrollPosition.getNearestRangeState();
        int i3 = 0;
        this.measurementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(i3, i, i3);
        Boolean valueOf = false;
        int i5 = 2;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i5, i3);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i5, i3);
        this.placementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(i3, i, i3);
        Float valueOf2 = 0f;
        this._scrollDeltaBetweenPasses = AnimationStateKt.AnimationState$default(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), valueOf2, valueOf2, 0, obj5, false, obj7, 0);
    }

    public LazyListState(int i, int i2, androidx.compose.foundation.lazy.LazyListPrefetchStrategy lazyListPrefetchStrategy3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        int obj3;
        androidx.compose.foundation.lazy.LazyListPrefetchStrategy obj4;
        int obj5;
        final int i3 = 0;
        obj2 = i4 & 1 != 0 ? i3 : obj2;
        obj3 = i4 & 2 != 0 ? i3 : obj3;
        if (i4 &= 4 != 0) {
            obj4 = LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(i3, 1, 0);
        }
        super(obj2, obj3, obj4);
    }

    public static final MutableState access$getLayoutInfoState$p(androidx.compose.foundation.lazy.LazyListState $this) {
        return $this.layoutInfoState;
    }

    public static final androidx.compose.foundation.lazy.LazyListPrefetchStrategy access$getPrefetchStrategy$p(androidx.compose.foundation.lazy.LazyListState $this) {
        return $this.prefetchStrategy;
    }

    public static final Saver access$getSaver$cp() {
        return LazyListState.Saver;
    }

    public static final AnimationState access$get_scrollDeltaBetweenPasses$p(androidx.compose.foundation.lazy.LazyListState $this) {
        return $this._scrollDeltaBetweenPasses;
    }

    public static final void access$setRemeasurement$p(androidx.compose.foundation.lazy.LazyListState $this, Remeasurement <set-?>) {
        $this.remeasurement = <set-?>;
    }

    public static Object animateScrollToItem$default(androidx.compose.foundation.lazy.LazyListState lazyListState, int i2, int i3, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return lazyListState.animateScrollToItem(i2, obj2, continuation4);
    }

    public static void applyMeasureResult$foundation_release$default(androidx.compose.foundation.lazy.LazyListState lazyListState, androidx.compose.foundation.lazy.LazyListMeasureResult lazyListMeasureResult2, boolean z3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        lazyListState.applyMeasureResult$foundation_release(lazyListMeasureResult2, z3, obj3);
    }

    private static Object getNearestRange$foundation_release$delegate(androidx.compose.foundation.lazy.LazyListState <this>) {
        return <this>.scrollPosition.getNearestRangeState();
    }

    private final void notifyPrefetchOnScroll(float delta, androidx.compose.foundation.lazy.LazyListLayoutInfo layoutInfo) {
        boolean prefetchingEnabled;
        int i;
        androidx.compose.foundation.lazy.LazyListPrefetchScope prefetchScope;
        if (this.prefetchingEnabled) {
            i = 0;
            this.prefetchStrategy.onScroll(this.prefetchScope, delta, layoutInfo);
        }
    }

    public static void requestScrollToItem$default(androidx.compose.foundation.lazy.LazyListState lazyListState, int i2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        lazyListState.requestScrollToItem(i2, obj2);
    }

    public static Object scrollToItem$default(androidx.compose.foundation.lazy.LazyListState lazyListState, int i2, int i3, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return lazyListState.scrollToItem(i2, obj2, continuation4);
    }

    private void setCanScrollBackward(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private void setCanScrollForward(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.canScrollForward$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void updateScrollDeltaForPostLookahead(float delta, Density density, CoroutineScope coroutineScope) {
        kotlin.jvm.functions.Function1 readObserver;
        kotlin.coroutines.jvm.internal.SuspendLambda anon;
        Object vectorConverter;
        Float valueOf;
        int i;
        int i5;
        long i8;
        int i6;
        CoroutineScope coroutineScope2;
        int i2;
        int i3;
        androidx.compose.foundation.lazy.LazyListState.updateScrollDeltaForPostLookahead.2.2 list;
        int i4;
        int i7;
        final Object obj2 = this;
        final float f = delta;
        int i10 = 0;
        if (Float.compare(f, $this$updateScrollDeltaForPostLookahead_u24lambda_u243) <= 0) {
        }
        Snapshot.Companion companion = Snapshot.Companion;
        int i11 = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        int i9 = 0;
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = i9;
        }
        final int i12 = 0;
        if (obj2._scrollDeltaBetweenPasses.isRunning()) {
            obj2._scrollDeltaBetweenPasses = AnimationStateKt.copy$default(obj2._scrollDeltaBetweenPasses, floatValue - f, 0, 0, obj15, false, obj17, 0);
            anon = new LazyListState.updateScrollDeltaForPostLookahead.2.1(obj2, i9);
            BuildersKt.launch$default(coroutineScope, 0, 0, (Function2)anon, 3, 0);
        } else {
            AnimationState animationState = new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(-f), 0, 0, obj15, 0, obj17, 0, 60, 0);
            obj2._scrollDeltaBetweenPasses = animationState;
            anon = new LazyListState.updateScrollDeltaForPostLookahead.2.2(obj2, i9);
            BuildersKt.launch$default(coroutineScope, 0, 0, (Function2)anon, 3, 0);
        }
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
    }

    public final Object animateScrollToItem(int index, int scrollOffset, Continuation<? super Unit> $completion) {
        Object obj8 = LazyAnimateScrollKt.animateScrollToItem((LazyLayoutAnimateScrollScope)this.animateScrollScope, index, scrollOffset, 100, getDensity$foundation_release(), $completion);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void applyMeasureResult$foundation_release(androidx.compose.foundation.lazy.LazyListMeasureResult result, boolean isLookingAhead, boolean visibleItemsStayedTheSame) {
        boolean hasLookaheadPassOccurred;
        boolean prefetchingEnabled;
        int i;
        float firstVisibleItemScrollOffset;
        androidx.compose.foundation.lazy.LazyListPrefetchScope coroutineScope;
        androidx.compose.foundation.lazy.LazyListMeasureResult list;
        if (!isLookingAhead && this.hasLookaheadPassOccurred) {
            if (this.hasLookaheadPassOccurred) {
                this.postLookaheadLayoutInfo = result;
            } else {
                hasLookaheadPassOccurred = 1;
                if (isLookingAhead) {
                    this.hasLookaheadPassOccurred = hasLookaheadPassOccurred;
                }
                setCanScrollBackward(result.getCanScrollBackward());
                setCanScrollForward(result.getCanScrollForward());
                this.scrollToBeConsumed = scrollToBeConsumed -= firstVisibleItemScrollOffset;
                this.layoutInfoState.setValue(result);
                if (visibleItemsStayedTheSame) {
                    this.scrollPosition.updateScrollOffset(result.getFirstVisibleItemScrollOffset());
                } else {
                    this.scrollPosition.updateFromMeasureResult(result);
                    if (this.prefetchingEnabled) {
                        firstVisibleItemScrollOffset = 0;
                        this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, (LazyListLayoutInfo)result);
                    }
                }
                if (isLookingAhead) {
                    updateScrollDeltaForPostLookahead(result.getScrollBackAmount(), result.getDensity(), result.getCoroutineScope());
                }
                this.numMeasurePasses = numMeasurePasses += hasLookaheadPassOccurred;
            }
        } else {
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.canScrollBackward$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.canScrollForward$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Density getDensity$foundation_release() {
        return (LazyListMeasureResult)this.layoutInfoState.getValue().getDensity();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getHasLookaheadPassOccurred$foundation_release() {
        return this.hasLookaheadPassOccurred;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final InteractionSource getInteractionSource() {
        return (InteractionSource)this.internalInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.LazyListMeasuredItem> getItemAnimator$foundation_release() {
        return this.itemAnimator;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final androidx.compose.foundation.lazy.LazyListLayoutInfo getLayoutInfo() {
        return (LazyListLayoutInfo)this.layoutInfoState.getValue();
    }

    public final MutableState<Unit> getMeasurementScopeInvalidator-zYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final IntRange getNearestRange$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (IntRange)(State)this.scrollPosition.getNearestRangeState().getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    public final MutableState<Unit> getPlacementScopeInvalidator-zYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final androidx.compose.foundation.lazy.LazyListMeasureResult getPostLookaheadLayoutInfo$foundation_release() {
        return this.postLookaheadLayoutInfo;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Remeasurement getRemeasurement$foundation_release() {
        return this.remeasurement;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float getScrollDeltaBetweenPasses$foundation_release() {
        return (Number)this._scrollDeltaBetweenPasses.getValue().floatValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float onScroll$foundation_release(float distance) {
        boolean canScrollBackward;
        int i;
        int value;
        int i2;
        float scrollToBeConsumed;
        int $this$fastRoundToInt$iv;
        androidx.compose.foundation.lazy.LazyListMeasureResult postLookaheadLayoutInfo;
        boolean scrolledWithoutRemeasure;
        Object layoutInfo;
        int i3 = 0;
        if (Float.compare(distance, i3) < 0) {
            if (getCanScrollForward() && Float.compare(distance, i3) > 0 && !getCanScrollBackward()) {
                if (Float.compare(distance, i3) > 0) {
                    if (!getCanScrollBackward()) {
                    }
                }
            }
            return i3;
        } else {
        }
        int i7 = 1056964608;
        i2 = 1;
        i = Float.compare(f, i7) <= 0 ? i2 : 0;
        if (i == 0) {
        } else {
            this.scrollToBeConsumed = scrollToBeConsumed3 += distance;
            value = this.layoutInfoState.getValue();
            scrollToBeConsumed = this.scrollToBeConsumed;
            int i8 = 0;
            $this$fastRoundToInt$iv = Math.round(this.scrollToBeConsumed);
            postLookaheadLayoutInfo = this.postLookaheadLayoutInfo;
            if (Float.compare(f2, i7) > 0 && (LazyListMeasureResult)value.tryToApplyScrollWithoutRemeasure($this$fastRoundToInt$iv, hasLookaheadPassOccurred ^= i2) && postLookaheadLayoutInfo != null) {
                value = this.layoutInfoState.getValue();
                scrollToBeConsumed = this.scrollToBeConsumed;
                i8 = 0;
                $this$fastRoundToInt$iv = Math.round(this.scrollToBeConsumed);
                postLookaheadLayoutInfo = this.postLookaheadLayoutInfo;
                if ((LazyListMeasureResult)value.tryToApplyScrollWithoutRemeasure($this$fastRoundToInt$iv, hasLookaheadPassOccurred ^= i2)) {
                    if (postLookaheadLayoutInfo != null) {
                        scrolledWithoutRemeasure = postLookaheadLayoutInfo.tryToApplyScrollWithoutRemeasure($this$fastRoundToInt$iv, i2);
                    }
                }
                if (scrolledWithoutRemeasure) {
                    applyMeasureResult$foundation_release(value, this.hasLookaheadPassOccurred, i2);
                    ObservableScopeInvalidator.invalidateScope-impl(this.placementScopeInvalidator);
                    notifyPrefetchOnScroll(scrollToBeConsumed - scrollToBeConsumed7, (LazyListLayoutInfo)value);
                } else {
                    Remeasurement remeasurement = this.remeasurement;
                    if (remeasurement != null) {
                        remeasurement.forceRemeasure();
                    }
                    notifyPrefetchOnScroll(scrollToBeConsumed - scrollToBeConsumed8, getLayoutInfo());
                }
            }
            if (Float.compare(f3, i7) <= 0) {
                return distance;
            }
            this.scrollToBeConsumed = i3;
            return distance - scrollToBeConsumed5;
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("entered drag with non-zero pending scroll: ").append(this.scrollToBeConsumed).toString().toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void requestScrollToItem(int index, int scrollOffset) {
        boolean scrollInProgress;
        CoroutineScope coroutineScope;
        int i3;
        int i4;
        androidx.compose.foundation.lazy.LazyListState.requestScrollToItem.1 list;
        int i2;
        int i;
        if (isScrollInProgress()) {
            i3 = 0;
            scrollInProgress = new LazyListState.requestScrollToItem.1(this, i3);
            BuildersKt.launch$default((LazyListMeasureResult)this.layoutInfoState.getValue().getCoroutineScope(), i3, 0, (Function2)scrollInProgress, 3, 0);
        }
        snapToItemIndexInternal$foundation_release(index, scrollOffset, false);
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation3) {
        boolean anon;
        int i2;
        int i;
        Object label;
        Object waitForFirstLayout;
        int i3;
        Object obj;
        Object obj7;
        Object obj8;
        Object obj9;
        anon = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof LazyListState.scroll.1 && label2 &= i != 0) {
            anon = continuation3;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj9 -= i;
            } else {
                anon = new LazyListState.scroll.1(this, continuation3);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                label = this;
                anon.L$0 = label;
                anon.L$1 = mutatePriority;
                anon.L$2 = function22;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj8 = mutatePriority;
                obj7 = obj;
                break;
            case 1:
                obj7 = anon.L$2;
                obj8 = anon.L$1;
                label = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                break;
            case 2:
                ResultKt.throwOnFailure(obj9);
                return Unit.INSTANCE;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        int i4 = 0;
        anon.L$0 = i4;
        anon.L$1 = i4;
        anon.L$2 = i4;
        anon.label = 2;
        if (label.scrollableState.scroll(obj8, obj7, anon) == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        }
    }

    public final Object scrollToItem(int index, int scrollOffset, Continuation<? super Unit> $completion) {
        LazyListState.scrollToItem.2 anon = new LazyListState.scrollToItem.2(this, index, scrollOffset, 0);
        Object obj9 = ScrollableState.scroll$default((ScrollableState)this, 0, (Function2)anon, $completion, 1, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setPrefetchingEnabled$foundation_release(boolean <set-?>) {
        this.prefetchingEnabled = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void snapToItemIndexInternal$foundation_release(int index, int scrollOffset, boolean forceRemeasure) {
        int i;
        int scrollOffset2;
        LazyLayoutItemAnimator itemAnimator;
        Object measurementScopeInvalidator;
        if (this.scrollPosition.getIndex() == index) {
            if (this.scrollPosition.getScrollOffset() != scrollOffset) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        if (i != 0) {
            this.itemAnimator.reset();
        }
        this.scrollPosition.requestPositionAndForgetLastKnownKey(index, scrollOffset);
        if (forceRemeasure) {
            measurementScopeInvalidator = this.remeasurement;
            if (measurementScopeInvalidator != null) {
                measurementScopeInvalidator.forceRemeasure();
            }
        } else {
            ObservableScopeInvalidator.invalidateScope-impl(this.measurementScopeInvalidator);
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation_release(androidx.compose.foundation.lazy.LazyListItemProvider itemProvider, int firstItemIndex) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }
}
