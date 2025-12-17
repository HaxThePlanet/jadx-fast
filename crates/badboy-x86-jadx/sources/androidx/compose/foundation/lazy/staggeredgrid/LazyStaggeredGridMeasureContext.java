package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ'\u0010F\u001a\u00020A*\u00020\u00082\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008I\u0010JJ\u0012\u0010@\u001a\u00020\u000e*\u00020\u00082\u0006\u0010G\u001a\u00020\u0006R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u001eR\u0019\u0010\u000b\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008 \u0010!R\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008#\u0010!R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010(R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u0011\u0010+\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001eR\u0011\u0010-\u001a\u00020.¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u001eR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0011\u00105\u001a\u000206¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010<R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u0016\u0010@\u001a\u00020\u000e*\u00020A8Æ\u0002¢\u0006\u0006\u001a\u0004\u0008B\u0010CR\u0016\u0010-\u001a\u00020\u0006*\u00020A8Æ\u0002¢\u0006\u0006\u001a\u0004\u0008D\u0010E\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006K", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "mainAxisAvailableSize", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "beforeContentPadding", "afterContentPadding", "reverseLayout", "mainAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZLandroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJIIZILkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "getBeforeContentPadding", "getConstraints-msEJaDk", "()J", "J", "getContentOffset-nOcc-ac", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "()Z", "getItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "laneCount", "getLaneCount", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getMainAxisAvailableSize", "getMainAxisSpacing", "getMeasureScope", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getMeasuredItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getPinnedItems", "()Ljava/util/List;", "getResolvedSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getReverseLayout", "getState", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "isFullSpan", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "isFullSpan-SZVOQXA", "(J)Z", "getLaneInfo-SZVOQXA", "(J)I", "getSpanRange", "itemIndex", "lane", "getSpanRange-lOCCd4c", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;II)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridMeasureContext {

    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final long constraints;
    private final long contentOffset;
    private final CoroutineScope coroutineScope;
    private final GraphicsContext graphicsContext;
    private final boolean isVertical;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider;
    private final int laneCount;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo laneInfo;
    private final int mainAxisAvailableSize;
    private final int mainAxisSpacing;
    private final LazyLayoutMeasureScope measureScope;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider measuredItemProvider;
    private final List<Integer> pinnedItems;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots resolvedSlots;
    private final boolean reverseLayout;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state;
    static {
        final int i = 8;
    }

    private LazyStaggeredGridMeasureContext(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, List<Integer> pinnedItems, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots resolvedSlots, long constraints, boolean isVertical, LazyLayoutMeasureScope measureScope, int mainAxisAvailableSize, long contentOffset, int beforeContentPadding, int afterContentPadding, boolean reverseLayout, int mainAxisSpacing, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        final Object obj = this;
        super();
        obj.state = state;
        obj.pinnedItems = pinnedItems;
        obj.itemProvider = itemProvider;
        obj.resolvedSlots = resolvedSlots;
        obj.constraints = constraints;
        obj.isVertical = measureScope;
        obj.measureScope = mainAxisAvailableSize;
        obj.mainAxisAvailableSize = contentOffset;
        obj.contentOffset = beforeContentPadding;
        obj.beforeContentPadding = reverseLayout;
        obj.afterContentPadding = mainAxisSpacing;
        obj.reverseLayout = coroutineScope;
        obj.mainAxisSpacing = graphicsContext;
        obj.coroutineScope = obj32;
        obj.graphicsContext = obj33;
        LazyStaggeredGridMeasureContext.measuredItemProvider.1 anon = new LazyStaggeredGridMeasureContext.measuredItemProvider.1(obj, obj.isVertical, obj.itemProvider, obj.measureScope, obj.resolvedSlots);
        obj.measuredItemProvider = (LazyStaggeredGridMeasureProvider)anon;
        obj.laneInfo = obj.state.getLaneInfo$foundation_release();
        obj.laneCount = sizes.length;
    }

    public LazyStaggeredGridMeasureContext(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState lazyStaggeredGridState, List list2, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider3, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots lazyStaggeredGridSlots4, long l5, boolean z6, LazyLayoutMeasureScope lazyLayoutMeasureScope7, int i8, long l9, int i10, int i11, boolean z12, int i13, CoroutineScope coroutineScope14, GraphicsContext graphicsContext15, DefaultConstructorMarker defaultConstructorMarker16) {
        super(lazyStaggeredGridState, list2, lazyStaggeredGridItemProvider3, lazyStaggeredGridSlots4, l5, z6, lazyLayoutMeasureScope7, i8, l9, i10, i11, z12, i13, coroutineScope14, graphicsContext15, defaultConstructorMarker16, obj17);
    }

    public final int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final long getConstraints-msEJaDk() {
        return this.constraints;
    }

    public final long getContentOffset-nOcc-ac() {
        return this.contentOffset;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider getItemProvider() {
        return this.itemProvider;
    }

    public final int getLaneCount() {
        return this.laneCount;
    }

    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo getLaneInfo() {
        return this.laneInfo;
    }

    public final int getLaneInfo-SZVOQXA(long $this$laneInfo) {
        int i;
        int value$iv$iv;
        int i2;
        int i3;
        final int i4 = 0;
        int i5 = $this$laneInfo;
        final Object obj = this;
        i2 = 0;
        int i8 = 0;
        int i9 = 0;
        final int i14 = 0;
        int i10 = 0;
        int i16 = 0;
        final int i17 = 32;
        if (value$iv$iv$iv$iv -= value$iv$iv$iv$iv2 != 1) {
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            i = -2;
        } else {
            int i6 = 0;
            i2 = 0;
            i = value$iv$iv;
        }
        return i;
    }

    public final int getMainAxisAvailableSize() {
        return this.mainAxisAvailableSize;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final LazyLayoutMeasureScope getMeasureScope() {
        return this.measureScope;
    }

    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider getMeasuredItemProvider() {
        return this.measuredItemProvider;
    }

    public final List<Integer> getPinnedItems() {
        return this.pinnedItems;
    }

    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots getResolvedSlots() {
        return this.resolvedSlots;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final long getSpanRange-lOCCd4c(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider $this$getSpanRange_u2dlOCCd4c, int itemIndex, int lane) {
        int laneCount;
        int i;
        boolean fullSpan = $this$getSpanRange_u2dlOCCd4c.getSpanProvider().isFullSpan(itemIndex);
        laneCount = fullSpan ? this.laneCount : 1;
        i = fullSpan ? 0 : lane;
        return SpanRange.constructor-impl(i, laneCount);
    }

    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState getState() {
        return this.state;
    }

    public final boolean isFullSpan(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider $this$isFullSpan, int itemIndex) {
        return $this$isFullSpan.getSpanProvider().isFullSpan(itemIndex);
    }

    public final boolean isFullSpan-SZVOQXA(long $this$isFullSpan) {
        int i;
        final int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        final int i9 = 0;
        int i5 = 0;
        int i11 = 0;
        if (value$iv$iv$iv -= value$iv$iv$iv2 != 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }
}
