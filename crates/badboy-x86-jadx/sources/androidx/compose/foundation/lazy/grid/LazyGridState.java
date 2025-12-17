package androidx.compose.foundation.lazy.grid;

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
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u0091\u00012\u00020\u0001:\u0002\u0091\u0001B\u001b\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B%\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\"\u0010n\u001a\u00020o2\u0008\u0008\u0001\u0010p\u001a\u00020\u00032\u0008\u0008\u0002\u0010q\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010rJ\u001f\u0010s\u001a\u00020o2\u0006\u0010t\u001a\u00020?2\u0008\u0008\u0002\u0010u\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0008vJ\u0010\u0010w\u001a\u00020g2\u0006\u0010x\u001a\u00020gH\u0016J\u0018\u0010y\u001a\u00020o2\u0006\u0010x\u001a\u00020g2\u0006\u00109\u001a\u00020:H\u0002J\u0015\u0010z\u001a\u00020g2\u0006\u0010{\u001a\u00020gH\u0000¢\u0006\u0002\u0008|J\u001a\u0010}\u001a\u00020o2\u0008\u0008\u0001\u0010p\u001a\u00020\u00032\u0008\u0008\u0002\u0010q\u001a\u00020\u0003JG\u0010~\u001a\u00020o2\u0007\u0010\u007f\u001a\u00030\u0080\u00012-\u0010\u0081\u0001\u001a(\u0008\u0001\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020o0\u0084\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0085\u00010\u0082\u0001¢\u0006\u0003\u0008\u0086\u0001H\u0096@¢\u0006\u0003\u0010\u0087\u0001J#\u0010\u0088\u0001\u001a\u00020o2\u0008\u0008\u0001\u0010p\u001a\u00020\u00032\u0008\u0008\u0002\u0010q\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010rJ(\u0010\u0089\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00020\u00032\u0006\u0010q\u001a\u00020\u00032\u0007\u0010\u008a\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\u0008\u008b\u0001J\"\u0010\u008c\u0001\u001a\u00020\u00032\u0008\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\u0008\u0090\u0001R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u000cX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001f\u0010\u001b\u001a\u0004\u0008\u001d\u0010\u0017\"\u0004\u0008\u001e\u0010\u0019R\u0014\u0010 \u001a\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008&\u0010%R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\u0008)\u0010*R\u0014\u0010+\u001a\u00020,X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u0014\u0010/\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008/\u0010\u0017R\u001a\u00100\u001a\u0008\u0012\u0004\u0012\u00020201X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0014\u00105\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00086\u0010\u0017R\u0014\u00107\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00088\u0010\u0017R\u0011\u00109\u001a\u00020:8F¢\u0006\u0006\u001a\u0004\u0008;\u0010<R\u0014\u0010=\u001a\u0008\u0012\u0004\u0012\u00020?0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u00020AX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008B\u0010CR\u001b\u0010D\u001a\u00020E8@X\u0080\u0084\u0002¢\u0006\u000c\u001a\u0004\u0008H\u0010I*\u0004\u0008F\u0010GR\u001e\u0010J\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008K\u0010%R\u0014\u0010L\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008M\u0010%R\u0014\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010QR\u001c\u0010R\u001a\u00020AX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\u0008S\u0010CR\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020WX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008X\u0010YR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Z\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008[\u0010\u0017\"\u0004\u0008\\\u0010\u0019R\"\u0010^\u001a\u0004\u0018\u00010]2\u0008\u0010\u0013\u001a\u0004\u0018\u00010]@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008_\u0010`R\u0014\u0010a\u001a\u00020bX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008c\u0010dR\u000e\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010h\u001a\u00020g2\u0006\u0010\u0013\u001a\u00020g@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008i\u0010jR\u000e\u0010k\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010l\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008m\u0010%\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0092\u0001", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "numOfItemsToTeleport", "getNumOfItemsToTeleport", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "prefetchScope", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "slotsPerLine", "getSlotsPerLine$foundation_release", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "dispatchRawDelta", "delta", "notifyPrefetchOnScroll", "onScroll", "distance", "onScroll$foundation_release", "requestScrollToItem", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "forceRemeasure", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridState implements ScrollableState {

    public static final int $stable;
    public static final androidx.compose.foundation.lazy.grid.LazyGridState.Companion Companion;
    private static final Saver<androidx.compose.foundation.lazy.grid.LazyGridState, ?> Saver;
    private final androidx.compose.foundation.lazy.grid.LazyGridAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> itemAnimator;
    private final MutableState<androidx.compose.foundation.lazy.grid.LazyGridMeasureResult> layoutInfoState;
    private final MutableState<Unit> measurementScopeInvalidator;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private final androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final androidx.compose.foundation.lazy.grid.LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0008\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u00042\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0008\u000bR\u001b\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "saver", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "saver$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.foundation.lazy.grid.LazyGridState, ?> getSaver() {
            return LazyGridState.access$getSaver$cp();
        }

        public final Saver<androidx.compose.foundation.lazy.grid.LazyGridState, ?> saver$foundation_release(androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy prefetchStrategy) {
            LazyGridState.Companion.saver.4 anon = new LazyGridState.Companion.saver.4(prefetchStrategy);
            return ListSaverKt.listSaver((Function2)LazyGridState.Companion.saver.3.INSTANCE, (Function1)anon);
        }
    }
    static {
        LazyGridState.Companion companion = new LazyGridState.Companion(0);
        LazyGridState.Companion = companion;
        LazyGridState.Saver = ListSaverKt.listSaver((Function2)LazyGridState.Companion.Saver.1.INSTANCE, (Function1)LazyGridState.Companion.Saver.2.INSTANCE);
    }

    public LazyGridState() {
        super(0, 0, 0, 7, 0);
    }

    public LazyGridState(int firstVisibleItemIndex, int firstVisibleItemScrollOffset) {
        super(firstVisibleItemIndex, firstVisibleItemScrollOffset, LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, 0));
    }

    public LazyGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        int obj3;
        final int i4 = 0;
        obj2 = i3 & 1 != 0 ? i4 : obj2;
        obj3 = i3 &= 2 != 0 ? i4 : obj3;
        super(obj2, obj3);
    }

    public LazyGridState(int firstVisibleItemIndex, int firstVisibleItemScrollOffset, androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy prefetchStrategy) {
        super();
        this.prefetchStrategy = prefetchStrategy;
        LazyGridScrollPosition lazyGridScrollPosition = new LazyGridScrollPosition(firstVisibleItemIndex, firstVisibleItemScrollOffset);
        this.scrollPosition = lazyGridScrollPosition;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyGridStateKt.access$getEmptyLazyGridLayoutInfo$p(), SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        LazyGridState.scrollableState.1 anon = new LazyGridState.scrollableState.1(this);
        this.scrollableState = ScrollableStateKt.ScrollableState((Function1)anon);
        int i = 1;
        this.prefetchingEnabled = i;
        LazyGridState.remeasurementModifier.1 anon2 = new LazyGridState.remeasurementModifier.1(this);
        this.remeasurementModifier = (RemeasurementModifier)anon2;
        AwaitFirstLayoutModifier awaitFirstLayoutModifier = new AwaitFirstLayoutModifier();
        this.awaitLayoutModifier = awaitFirstLayoutModifier;
        LazyLayoutItemAnimator lazyLayoutItemAnimator = new LazyLayoutItemAnimator();
        this.itemAnimator = lazyLayoutItemAnimator;
        LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
        LazyGridState.prefetchState.1 anon4 = new LazyGridState.prefetchState.1(this, firstVisibleItemIndex);
        LazyLayoutPrefetchState lazyLayoutPrefetchState = new LazyLayoutPrefetchState(this.prefetchStrategy.getPrefetchScheduler(), (Function1)anon4);
        this.prefetchState = lazyLayoutPrefetchState;
        LazyGridState.prefetchScope.1 anon3 = new LazyGridState.prefetchScope.1(this);
        this.prefetchScope = (LazyGridPrefetchScope)anon3;
        LazyGridAnimateScrollScope lazyGridAnimateScrollScope = new LazyGridAnimateScrollScope(this);
        this.animateScrollScope = lazyGridAnimateScrollScope;
        LazyLayoutPinnedItemList lazyLayoutPinnedItemList = new LazyLayoutPinnedItemList();
        this.pinnedItems = lazyLayoutPinnedItemList;
        this.scrollPosition.getNearestRangeState();
        int i3 = 0;
        this.placementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(i3, i, i3);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(i3, i, i3);
        Boolean valueOf = false;
        int i4 = 2;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
    }

    public LazyGridState(int i, int i2, androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy lazyGridPrefetchStrategy3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        int obj3;
        androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy obj4;
        int obj5;
        final int i3 = 0;
        obj2 = i4 & 1 != 0 ? i3 : obj2;
        obj3 = i4 & 2 != 0 ? i3 : obj3;
        if (i4 &= 4 != 0) {
            obj4 = LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(i3, 1, 0);
        }
        super(obj2, obj3, obj4);
    }

    public static final MutableState access$getLayoutInfoState$p(androidx.compose.foundation.lazy.grid.LazyGridState $this) {
        return $this.layoutInfoState;
    }

    public static final androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy access$getPrefetchStrategy$p(androidx.compose.foundation.lazy.grid.LazyGridState $this) {
        return $this.prefetchStrategy;
    }

    public static final Saver access$getSaver$cp() {
        return LazyGridState.Saver;
    }

    public static final void access$setRemeasurement$p(androidx.compose.foundation.lazy.grid.LazyGridState $this, Remeasurement <set-?>) {
        $this.remeasurement = <set-?>;
    }

    public static Object animateScrollToItem$default(androidx.compose.foundation.lazy.grid.LazyGridState lazyGridState, int i2, int i3, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return lazyGridState.animateScrollToItem(i2, obj2, continuation4);
    }

    public static void applyMeasureResult$foundation_release$default(androidx.compose.foundation.lazy.grid.LazyGridState lazyGridState, androidx.compose.foundation.lazy.grid.LazyGridMeasureResult lazyGridMeasureResult2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        lazyGridState.applyMeasureResult$foundation_release(lazyGridMeasureResult2, obj2);
    }

    private static Object getNearestRange$foundation_release$delegate(androidx.compose.foundation.lazy.grid.LazyGridState <this>) {
        return <this>.scrollPosition.getNearestRangeState();
    }

    private final int getNumOfItemsToTeleport() {
        return slotsPerLine$foundation_release *= 100;
    }

    private final void notifyPrefetchOnScroll(float delta, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo layoutInfo) {
        boolean prefetchingEnabled;
        int i;
        androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope prefetchScope;
        if (this.prefetchingEnabled) {
            i = 0;
            this.prefetchStrategy.onScroll(this.prefetchScope, delta, layoutInfo);
        }
    }

    public static void requestScrollToItem$default(androidx.compose.foundation.lazy.grid.LazyGridState lazyGridState, int i2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        lazyGridState.requestScrollToItem(i2, obj2);
    }

    public static Object scrollToItem$default(androidx.compose.foundation.lazy.grid.LazyGridState lazyGridState, int i2, int i3, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return lazyGridState.scrollToItem(i2, obj2, continuation4);
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
        Object obj8 = LazyAnimateScrollKt.animateScrollToItem((LazyLayoutAnimateScrollScope)this.animateScrollScope, index, scrollOffset, getNumOfItemsToTeleport(), getDensity$foundation_release(), $completion);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final void applyMeasureResult$foundation_release(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult result, boolean visibleItemsStayedTheSame) {
        androidx.compose.foundation.lazy.grid.LazyGridScrollPosition prefetchingEnabled;
        int firstVisibleLineScrollOffset;
        androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope prefetchScope;
        Object obj;
        this.scrollToBeConsumed = scrollToBeConsumed -= firstVisibleLineScrollOffset;
        this.layoutInfoState.setValue(result);
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateScrollOffset(result.getFirstVisibleLineScrollOffset());
        } else {
            this.scrollPosition.updateFromMeasureResult(result);
            if (this.prefetchingEnabled) {
                firstVisibleLineScrollOffset = 0;
                this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, (LazyGridLayoutInfo)result);
            }
        }
        this.numMeasurePasses = numMeasurePasses++;
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
        return (LazyGridMeasureResult)this.layoutInfoState.getValue().getDensity();
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
        return (InteractionSource)this.internalInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> getItemAnimator$foundation_release() {
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
    public final androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo getLayoutInfo() {
        return (LazyGridLayoutInfo)this.layoutInfoState.getValue();
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
    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final int getSlotsPerLine$foundation_release() {
        return (LazyGridMeasureResult)this.layoutInfoState.getValue().getSlotsPerLine();
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
        int roundToInt;
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
            if (Float.compare(f2, i7) > 0) {
                value = this.layoutInfoState.getValue();
                scrollToBeConsumed = this.scrollToBeConsumed;
                if ((LazyGridMeasureResult)value.tryToApplyScrollWithoutRemeasure(MathKt.roundToInt(this.scrollToBeConsumed))) {
                    applyMeasureResult$foundation_release(value, i2);
                    ObservableScopeInvalidator.invalidateScope-impl(this.placementScopeInvalidator);
                    notifyPrefetchOnScroll(scrollToBeConsumed - scrollToBeConsumed7, (LazyGridLayoutInfo)value);
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
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i2;
        int i4;
        androidx.compose.foundation.lazy.grid.LazyGridState.requestScrollToItem.1 anon;
        int i;
        int i3;
        if (isScrollInProgress()) {
            i2 = 0;
            scrollInProgress = new LazyGridState.requestScrollToItem.1(this, i2);
            BuildersKt.launch$default((LazyGridMeasureResult)this.layoutInfoState.getValue().getCoroutineScope(), i2, 0, (Function2)scrollInProgress, 3, 0);
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
        if (continuation3 instanceof LazyGridState.scroll.1 && label2 &= i != 0) {
            anon = continuation3;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj9 -= i;
            } else {
                anon = new LazyGridState.scroll.1(this, continuation3);
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
        LazyGridState.scrollToItem.2 anon = new LazyGridState.scrollToItem.2(this, index, scrollOffset, 0);
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
    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation_release(androidx.compose.foundation.lazy.grid.LazyGridItemProvider itemProvider, int firstItemIndex) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }
}
