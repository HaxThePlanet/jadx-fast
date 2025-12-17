package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
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
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.IntOffset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u000b\n\u0002\u0010\"\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000  \u00012\u00020\u0001:\u0002 \u0001B\u001b\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B!\u0008\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ \u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\u00032\u0008\u0008\u0002\u0010z\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010{J\u001f\u0010|\u001a\u00020x2\u0006\u0010}\u001a\u00020E2\u0008\u0008\u0002\u0010~\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0008\u007fJ\u0012\u0010\u0080\u0001\u001a\u00020x2\u0007\u0010\u0081\u0001\u001a\u00020@H\u0002J\u0019\u0010\u0082\u0001\u001a\u00020x2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0084\u0001H\u0002J\u0012\u0010\u0085\u0001\u001a\u00020r2\u0007\u0010\u0086\u0001\u001a\u00020rH\u0016J\u001a\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002J\u001d\u0010\u0089\u0001\u001a\u00020x2\u0007\u0010\u0086\u0001\u001a\u00020r2\t\u0008\u0002\u0010\u0081\u0001\u001a\u00020EH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020r2\u0007\u0010\u008b\u0001\u001a\u00020rH\u0002J\u001b\u0010\u008c\u0001\u001a\u00020x2\u0008\u0008\u0001\u0010y\u001a\u00020\u00032\u0008\u0008\u0002\u0010z\u001a\u00020\u0003JI\u0010\u008d\u0001\u001a\u00020x2\u0008\u0010\u008e\u0001\u001a\u00030\u008f\u00012-\u0010\u0090\u0001\u001a(\u0008\u0001\u0012\u0005\u0012\u00030\u0092\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020x0\u0093\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u00010\u0091\u0001¢\u0006\u0003\u0008\u0095\u0001H\u0096@¢\u0006\u0003\u0010\u0096\u0001J!\u0010\u0097\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020\u00032\u0008\u0008\u0002\u0010z\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010{J(\u0010\u0098\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020\u00032\u0006\u0010z\u001a\u00020\u00032\u0007\u0010\u0099\u0001\u001a\u00020\u0017H\u0000¢\u0006\u0003\u0008\u009a\u0001J\"\u0010\u009b\u0001\u001a\u00020\u00072\u0008\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\u0008\u009f\u0001R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR+\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\"\u0010\u001e\u001a\u0004\u0008 \u0010\u001a\"\u0004\u0008!\u0010\u001cR\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008'\u0010(R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008*\u0010(R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u0014\u0010/\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008/\u0010\u001aR\u001a\u00100\u001a\u0008\u0012\u0004\u0012\u00020201X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0014\u00105\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00086\u0010(R\u0014\u00107\u001a\u000208X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u0014\u0010;\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008<\u0010\u001aR\u0014\u0010=\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008>\u0010\u001aR\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\u0008A\u0010BR\u0014\u0010C\u001a\u0008\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008G\u0010(\"\u0004\u0008H\u0010IR\u001c\u0010J\u001a\u00020KX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\u0008L\u0010MR\u0014\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010QR\u001b\u0010R\u001a\u00020S8@X\u0080\u0084\u0002¢\u0006\u000c\u001a\u0004\u0008V\u0010W*\u0004\u0008T\u0010UR\u0014\u0010X\u001a\u00020YX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008Z\u0010[R\u001c\u0010\\\u001a\u00020KX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\u0008]\u0010MR\u000e\u0010^\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\u00020`X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008a\u0010bR\u001a\u0010c\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008d\u0010\u001a\"\u0004\u0008e\u0010\u001cR\"\u0010g\u001a\u0004\u0018\u00010f2\u0008\u0010\u0016\u001a\u0004\u0018\u00010f@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008h\u0010iR\u0014\u0010j\u001a\u00020kX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008l\u0010mR\u0014\u0010n\u001a\u00020oX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008p\u0010qR\u001e\u0010s\u001a\u00020r2\u0006\u0010\u0016\u001a\u00020r@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008t\u0010uR\u000e\u0010v\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006¡\u0001", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemOffset", "(II)V", "initialFirstVisibleItems", "", "initialFirstVisibleOffsets", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "([I[ILandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "currentItemPrefetchHandles", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "firstVisibleItemIndex", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "isScrollInProgress", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "laneCount", "getLaneCount$foundation_release", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measurePassCount", "getMeasurePassCount$foundation_release", "setMeasurePassCount$foundation_release", "(I)V", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "mutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getMutableInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "prefetchBaseIndex", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "getScrollPosition$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "clearLeftoverPrefetchHandles", "prefetchHandlesUsed", "", "dispatchRawDelta", "delta", "fillNearestIndices", "itemIndex", "notifyPrefetch", "onScroll", "distance", "requestScrollToItem", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemInternal", "forceRemeasure", "snapToItemInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridState implements ScrollableState {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.Companion Companion;
    private static final Saver<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, Object> Saver;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final Map<Integer, LazyLayoutPrefetchState.PrefetchHandle> currentItemPrefetchHandles;
    private final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> itemAnimator;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo laneInfo;
    private final MutableState<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult> layoutInfoState;
    private int measurePassCount;
    private final MutableState<Unit> measurementScopeInvalidator;
    private final MutableInteractionSource mutableInteractionSource;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private int prefetchBaseIndex;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, Object> getSaver() {
            return LazyStaggeredGridState.access$getSaver$cp();
        }
    }
    static {
        LazyStaggeredGridState.Companion companion = new LazyStaggeredGridState.Companion(0);
        LazyStaggeredGridState.Companion = companion;
        int i = 8;
        LazyStaggeredGridState.Saver = ListSaverKt.listSaver((Function2)LazyStaggeredGridState.Companion.Saver.1.INSTANCE, (Function1)LazyStaggeredGridState.Companion.Saver.2.INSTANCE);
    }

    public LazyStaggeredGridState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemOffset) {
        super(/* result */, /* result */, 0);
    }

    public LazyStaggeredGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        int obj3;
        final int i4 = 0;
        obj2 = i3 & 1 != 0 ? i4 : obj2;
        obj3 = i3 &= 2 != 0 ? i4 : obj3;
        super(obj2, obj3);
    }

    public LazyStaggeredGridState(int[] initialFirstVisibleItems, int[] initialFirstVisibleOffsets, PrefetchScheduler prefetchScheduler) {
        super();
        LazyStaggeredGridState.scrollPosition.1 anon2 = new LazyStaggeredGridState.scrollPosition.1(this);
        LazyStaggeredGridScrollPosition lazyStaggeredGridScrollPosition = new LazyStaggeredGridScrollPosition(initialFirstVisibleItems, initialFirstVisibleOffsets, (Function2)anon2);
        this.scrollPosition = lazyStaggeredGridScrollPosition;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyStaggeredGridMeasureResultKt.getEmptyLazyStaggeredGridLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo = new LazyStaggeredGridLaneInfo();
        this.laneInfo = lazyStaggeredGridLaneInfo;
        Boolean valueOf = false;
        int i3 = 0;
        int i4 = 2;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        LazyStaggeredGridAnimateScrollScope lazyStaggeredGridAnimateScrollScope = new LazyStaggeredGridAnimateScrollScope(this);
        this.animateScrollScope = lazyStaggeredGridAnimateScrollScope;
        LazyStaggeredGridState.remeasurementModifier.1 anon = new LazyStaggeredGridState.remeasurementModifier.1(this);
        this.remeasurementModifier = (RemeasurementModifier)anon;
        AwaitFirstLayoutModifier awaitFirstLayoutModifier = new AwaitFirstLayoutModifier();
        this.awaitLayoutModifier = awaitFirstLayoutModifier;
        LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
        int i2 = 1;
        this.prefetchingEnabled = i2;
        LazyLayoutPrefetchState lazyLayoutPrefetchState = new LazyLayoutPrefetchState(prefetchScheduler, i3, i4, i3);
        this.prefetchState = lazyLayoutPrefetchState;
        LazyStaggeredGridState.scrollableState.1 anon3 = new LazyStaggeredGridState.scrollableState.1(this);
        this.scrollableState = ScrollableStateKt.ScrollableState((Function1)anon3);
        this.prefetchBaseIndex = -1;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.currentItemPrefetchHandles = (Map)linkedHashMap;
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
        LazyLayoutPinnedItemList lazyLayoutPinnedItemList = new LazyLayoutPinnedItemList();
        this.pinnedItems = lazyLayoutPinnedItemList;
        LazyLayoutItemAnimator lazyLayoutItemAnimator = new LazyLayoutItemAnimator();
        this.itemAnimator = lazyLayoutItemAnimator;
        this.scrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(i3, i2, i3);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(i3, i2, i3);
    }

    public static final int[] access$fillNearestIndices(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState $this, int itemIndex, int laneCount) {
        return $this.fillNearestIndices(itemIndex, laneCount);
    }

    public static final Saver access$getSaver$cp() {
        return LazyStaggeredGridState.Saver;
    }

    public static final float access$onScroll(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState $this, float distance) {
        return $this.onScroll(distance);
    }

    public static final void access$setRemeasurement$p(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState $this, Remeasurement <set-?>) {
        $this.remeasurement = <set-?>;
    }

    public static Object animateScrollToItem$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState lazyStaggeredGridState, int i2, int i3, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return lazyStaggeredGridState.animateScrollToItem(i2, obj2, continuation4);
    }

    public static void applyMeasureResult$foundation_release$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState lazyStaggeredGridState, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        lazyStaggeredGridState.applyMeasureResult$foundation_release(lazyStaggeredGridMeasureResult2, obj2);
    }

    private final void cancelPrefetchIfVisibleItemsChanged(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo info) {
        int $this$forEach$iv;
        int i3;
        int iterator;
        int prefetchBaseIndex;
        int i2;
        int i;
        final java.util.List visibleItemsInfo = info.getVisibleItemsInfo();
        i3 = -1;
        prefetchBaseIndex = this.prefetchBaseIndex;
        i2 = 0;
        if (this.prefetchBaseIndex != i3 && !(Collection)visibleItemsInfo.isEmpty() && (LazyStaggeredGridItemInfo)CollectionsKt.first(visibleItemsInfo).getIndex() <= prefetchBaseIndex && prefetchBaseIndex <= (LazyStaggeredGridItemInfo)CollectionsKt.last(visibleItemsInfo).getIndex()) {
            if (!(Collection)visibleItemsInfo.isEmpty()) {
                prefetchBaseIndex = this.prefetchBaseIndex;
                i2 = 0;
                if ((LazyStaggeredGridItemInfo)CollectionsKt.first(visibleItemsInfo).getIndex() <= prefetchBaseIndex) {
                    if (prefetchBaseIndex <= (LazyStaggeredGridItemInfo)CollectionsKt.last(visibleItemsInfo).getIndex()) {
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    this.prefetchBaseIndex = i3;
                    i3 = 0;
                    iterator = (Iterable)this.currentItemPrefetchHandles.values().iterator();
                    for (Object prefetchBaseIndex : iterator) {
                        i = 0;
                        (LazyLayoutPrefetchState.PrefetchHandle)prefetchBaseIndex.cancel();
                    }
                    this.currentItemPrefetchHandles.clear();
                }
            }
        }
    }

    private final void clearLeftoverPrefetchHandles(Set<Integer> prefetchHandlesUsed) {
        Object next;
        boolean contains;
        Iterator iterator = this.currentItemPrefetchHandles.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!prefetchHandlesUsed.contains((Map.Entry)next.getKey())) {
            }
            (LazyLayoutPrefetchState.PrefetchHandle)next.getValue().cancel();
            iterator.remove();
        }
    }

    private final int[] fillNearestIndices(int itemIndex, int laneCount) {
        int currentItemIndex2;
        int currentItemIndex;
        int i3;
        int i4;
        int lane;
        int lane2;
        int i2;
        int i;
        int currentItemIndex3;
        final int[] iArr = new int[laneCount];
        if ((LazyStaggeredGridMeasureResult)this.layoutInfoState.getValue().getSpanProvider().isFullSpan(itemIndex)) {
            ArraysKt.fill$default(iArr, itemIndex, 0, 0, 6, 0);
            return iArr;
        }
        if (/* condition */) {
            final int i12 = i3;
            currentItemIndex3 = currentItemIndex2;
            lane2 = i4;
            currentItemIndex2 = -1;
            while (currentItemIndex2 < lane2) {
                iArr[lane2] = this.laneInfo.findPreviousItemIndex(currentItemIndex3, lane2);
                if (iArr[lane2] == currentItemIndex2) {
                    break;
                } else {
                }
                currentItemIndex3 = iArr[lane2];
                lane2--;
                currentItemIndex2 = -1;
            }
            iArr[i12] = itemIndex;
            currentItemIndex = itemIndex;
            lane = i12 + 1;
            while (lane < laneCount) {
                iArr[lane] = this.laneInfo.findNextItemIndex(currentItemIndex, lane);
                currentItemIndex = iArr[lane];
                lane++;
            }
            return iArr;
        } else {
            if (lane3 >= 0) {
                i3 = 1;
            }
            if (i3 == 0) {
            } else {
                i3 = Math.min(lane3, laneCount);
            }
        }
        int i8 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected positive lane number, got ").append(lane3).append(" instead.").toString().toString());
        throw illegalArgumentException;
    }

    private static Object getNearestRange$foundation_release$delegate(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState <this>) {
        return <this>.scrollPosition.getNearestRangeState();
    }

    private final void notifyPrefetch(float delta, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult info) {
        boolean prefetchingEnabled;
        Integer valueOf;
        Constraints.Companion companion;
        int schedulePrefetch-0kLqBqw;
        int index;
        LinkedHashSet linkedHashSet;
        int targetIndex;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots slots;
        int length;
        int lane;
        int i3;
        boolean fullSpan;
        int previousItemIndex;
        int currentItemPrefetchHandles2;
        int i2;
        int start;
        Map currentItemPrefetchHandles;
        int i4;
        long fixedHeight-OenEA2s;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots slots2;
        long l;
        int i;
        final Object obj = this;
        if (obj.prefetchingEnabled && !(Collection)info.getVisibleItemsInfo().isEmpty()) {
            if (!(Collection)info.getVisibleItemsInfo().isEmpty()) {
                prefetchingEnabled = Float.compare(delta, i5) < 0 ? schedulePrefetch-0kLqBqw : 0;
                if (prefetchingEnabled != 0) {
                    index = (LazyStaggeredGridMeasuredItem)CollectionsKt.last(info.getVisibleItemsInfo()).getIndex();
                } else {
                    index = (LazyStaggeredGridMeasuredItem)CollectionsKt.first(info.getVisibleItemsInfo()).getIndex();
                }
                if (index == obj.prefetchBaseIndex) {
                }
                obj.prefetchBaseIndex = index;
                linkedHashSet = new LinkedHashSet();
                targetIndex = index;
                length = sizes.length;
                lane = 0;
                while (lane < length) {
                    i3 = targetIndex;
                    if (prefetchingEnabled != 0) {
                    } else {
                    }
                    previousItemIndex = obj.laneInfo.findPreviousItemIndex(i3, lane);
                    targetIndex = previousItemIndex;
                    if (targetIndex >= 0 && targetIndex < info.getTotalItemsCount()) {
                    } else {
                    }
                    fullSpan = 0;
                    (Collection)linkedHashSet.add(Integer.valueOf(targetIndex));
                    if (obj.currentItemPrefetchHandles.containsKey(Integer.valueOf(targetIndex))) {
                    } else {
                    }
                    fullSpan = info.getSpanProvider().isFullSpan(targetIndex);
                    if (fullSpan) {
                    } else {
                    }
                    currentItemPrefetchHandles2 = lane;
                    if (fullSpan) {
                    } else {
                    }
                    i2 = schedulePrefetch-0kLqBqw;
                    if (i2 == schedulePrefetch-0kLqBqw) {
                    } else {
                    }
                    i7 -= schedulePrefetch-0kLqBqw;
                    start = fixedHeight-OenEA2s;
                    if (info.getOrientation() == Orientation.Vertical) {
                    } else {
                    }
                    fixedHeight-OenEA2s = Constraints.Companion.fixedHeight-OenEA2s(start);
                    slots2 = slots;
                    i = length;
                    obj.currentItemPrefetchHandles.put(Integer.valueOf(targetIndex), obj.prefetchState.schedulePrefetch-0kLqBqw(targetIndex, fixedHeight-OenEA2s));
                    lane++;
                    slots = slots2;
                    length = i;
                    schedulePrefetch-0kLqBqw = 1;
                    fixedHeight-OenEA2s = Constraints.Companion.fixedWidth-OenEA2s(start);
                    start = slots.getSizes()[currentItemPrefetchHandles2];
                    i2 = length;
                    currentItemPrefetchHandles2 = 0;
                    slots2 = slots;
                    i = length;
                    if (targetIndex < info.getTotalItemsCount()) {
                    } else {
                    }
                    fullSpan = schedulePrefetch-0kLqBqw;
                    previousItemIndex = obj.laneInfo.findNextItemIndex(i3, lane);
                }
                slots2 = slots;
                i = length;
                obj.clearLeftoverPrefetchHandles(linkedHashSet);
            }
        }
    }

    static void notifyPrefetch$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState lazyStaggeredGridState, float f2, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult3, int i4, Object object5) {
        Object obj2;
        if (i4 &= 2 != 0) {
            obj2 = lazyStaggeredGridState.layoutInfoState.getValue();
        }
        lazyStaggeredGridState.notifyPrefetch(f2, obj2);
    }

    private final float onScroll(float distance) {
        boolean canScrollBackward;
        int i;
        int value;
        int i3;
        float scrollToBeConsumed;
        int roundToInt;
        boolean tryToApplyScrollWithoutRemeasure;
        int i2;
        int i4 = 0;
        if (Float.compare(distance, i4) < 0) {
            if (getCanScrollForward() && Float.compare(distance, i4) > 0 && !getCanScrollBackward()) {
                if (Float.compare(distance, i4) > 0) {
                    if (!getCanScrollBackward()) {
                    }
                }
            }
            return i4;
        } else {
        }
        int i8 = 1056964608;
        i3 = 1;
        i = Float.compare(f, i8) <= 0 ? i3 : 0;
        if (i == 0) {
        } else {
            this.scrollToBeConsumed = scrollToBeConsumed3 += distance;
            if (Float.compare(f2, i8) > 0) {
                value = this.layoutInfoState.getValue();
                scrollToBeConsumed = this.scrollToBeConsumed;
                if ((LazyStaggeredGridMeasureResult)value.tryToApplyScrollWithoutRemeasure(MathKt.roundToInt(this.scrollToBeConsumed))) {
                    applyMeasureResult$foundation_release(value, i3);
                    ObservableScopeInvalidator.invalidateScope-impl(this.placementScopeInvalidator);
                    notifyPrefetch(scrollToBeConsumed - scrollToBeConsumed7, value);
                } else {
                    Remeasurement remeasurement = this.remeasurement;
                    if (remeasurement != null) {
                        remeasurement.forceRemeasure();
                    }
                    i2 = 0;
                    LazyStaggeredGridState.notifyPrefetch$default(this, scrollToBeConsumed - scrollToBeConsumed8, i2, 2, i2);
                }
            }
            if (Float.compare(f3, i8) <= 0) {
                return distance;
            }
            this.scrollToBeConsumed = i4;
            return distance - scrollToBeConsumed5;
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("entered drag with non-zero pending scroll: ").append(this.scrollToBeConsumed).toString().toString());
        throw illegalStateException;
    }

    public static void requestScrollToItem$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState lazyStaggeredGridState, int i2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        lazyStaggeredGridState.requestScrollToItem(i2, obj2);
    }

    public static Object scrollToItem$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState lazyStaggeredGridState, int i2, int i3, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return lazyStaggeredGridState.scrollToItem(i2, obj2, continuation4);
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

    public final Object animateScrollToItem(int index, int scrollOffset, Continuation<? super Unit> $completion) {
        Object value = this.layoutInfoState.getValue();
        Object obj9 = LazyAnimateScrollKt.animateScrollToItem((LazyLayoutAnimateScrollScope)this.animateScrollScope, index, scrollOffset, length * 100, value.getDensity(), $completion);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void applyMeasureResult$foundation_release(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult result, boolean visibleItemsStayedTheSame) {
        Object scrollPosition;
        int[] firstVisibleItemScrollOffsets;
        this.scrollToBeConsumed = scrollToBeConsumed -= firstVisibleItemScrollOffsets;
        this.layoutInfoState.setValue(result);
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateScrollOffset(result.getFirstVisibleItemScrollOffsets());
        } else {
            this.scrollPosition.updateFromMeasureResult(result);
            cancelPrefetchIfVisibleItemsChanged((LazyStaggeredGridLayoutInfo)result);
        }
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        this.measurePassCount = measurePassCount++;
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
    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final InteractionSource getInteractionSource() {
        return (InteractionSource)this.mutableInteractionSource;
    }

    public final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> getItemAnimator$foundation_release() {
        return this.itemAnimator;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getLaneCount$foundation_release() {
        return sizes.length;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo getLaneInfo$foundation_release() {
        return this.laneInfo;
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
    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return (LazyStaggeredGridLayoutInfo)this.layoutInfoState.getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getMeasurePassCount$foundation_release() {
        return this.measurePassCount;
    }

    public final MutableState<Unit> getMeasurementScopeInvalidator-zYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final MutableInteractionSource getMutableInteractionSource$foundation_release() {
        return this.mutableInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final IntRange getNearestRange$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (IntRange)(State)this.scrollPosition.getNearestRangeState().getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    public final MutableState<Unit> getPlacementScopeInvalidator-zYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
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
    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScrollPosition getScrollPosition$foundation_release() {
        return this.scrollPosition;
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
    public final void requestScrollToItem(int index, int scrollOffset) {
        boolean scrollInProgress;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i4;
        int i3;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.requestScrollToItem.1 anon;
        int i2;
        int i;
        if (isScrollInProgress()) {
            i4 = 0;
            scrollInProgress = new LazyStaggeredGridState.requestScrollToItem.1(this, i4);
            BuildersKt.launch$default((LazyStaggeredGridMeasureResult)this.layoutInfoState.getValue().getCoroutineScope(), i4, 0, (Function2)scrollInProgress, 3, 0);
        }
        snapToItemInternal$foundation_release(index, scrollOffset, false);
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation3) {
        boolean anon;
        int i2;
        int i3;
        Object label;
        Object waitForFirstLayout;
        int i;
        Object obj;
        Object obj7;
        Object obj8;
        Object obj9;
        anon = continuation3;
        i3 = Integer.MIN_VALUE;
        if (continuation3 instanceof LazyStaggeredGridState.scroll.1 && label2 &= i3 != 0) {
            anon = continuation3;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = obj9 -= i3;
            } else {
                anon = new LazyStaggeredGridState.scroll.1(this, continuation3);
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
        LazyStaggeredGridState.scrollToItem.2 anon = new LazyStaggeredGridState.scrollToItem.2(this, index, scrollOffset, 0);
        Object obj9 = ScrollableState.scroll$default((ScrollableState)this, 0, (Function2)anon, $completion, 1, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setMeasurePassCount$foundation_release(int <set-?>) {
        this.measurePassCount = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void setPrefetchingEnabled$foundation_release(boolean <set-?>) {
        this.prefetchingEnabled = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void snapToItemInternal$foundation_release(int index, int scrollOffset, boolean forceRemeasure) {
        int scrollOffset2;
        int i2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScrollPosition scrollPosition;
        Object measurementScopeInvalidator;
        int i;
        LazyLayoutItemAnimator itemAnimator;
        int x-impl;
        int i4;
        int length;
        int[] iArr;
        int i3;
        if (this.scrollPosition.getIndex() == index) {
            if (this.scrollPosition.getScrollOffset() != scrollOffset) {
                i2 = 1;
            } else {
                i2 = i;
            }
        } else {
        }
        if (i2 != 0) {
            this.itemAnimator.reset();
        }
        Object value = this.layoutInfoState.getValue();
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo visibleItem = LazyStaggeredGridMeasureResultKt.findVisibleItem((LazyStaggeredGridLayoutInfo)(LazyStaggeredGridMeasureResult)value, index);
        if (visibleItem != null && i2 != 0) {
            if (i2 != 0) {
                Orientation vertical = Orientation.Vertical;
                if (value.getOrientation() == vertical) {
                    x-impl = IntOffset.getY-impl(visibleItem.getOffset-nOcc-ac());
                } else {
                    x-impl = IntOffset.getX-impl(visibleItem.getOffset-nOcc-ac());
                }
                length = firstVisibleItemScrollOffsets.length;
                iArr = new int[length];
                while (i < length) {
                    iArr[i] = i5 += i4;
                    i++;
                }
                this.scrollPosition.updateScrollOffset(iArr);
            } else {
                this.scrollPosition.requestPositionAndForgetLastKnownKey(index, scrollOffset);
            }
        } else {
        }
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
    public final int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyLayoutItemProvider itemProvider, int[] firstItemIndex) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }
}
